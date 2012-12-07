package com.bazzar.domain.lookup;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

/**
 * Manages Reference Types and provides a central cache for accessing/retrieving
 * and translating Reference Types. This class should only be referenced by the
 * Lookup Types when defining constants As well as the Lookup Type Service. All
 * other consumers of Lookup Functionality should reference the Lookup Service
 * {@link com.ceconvergence.domain.lookup} For Lookup related
 * 
 * 
 * To reduce direct access, all methods are protected. Only package classes, or 
 * if necessary, a Subclass should be created to access this directly. 
 * 
 * @author amelnik
 */
public class LookupTypeManager {
    static final Map<Class<? extends LookupType>, Map<String, LookupType>> lookupTypeCache = new HashMap<Class<? extends LookupType>, Map<String, LookupType>>();

    /**
     * This class provides a Static Interface. It is not intended to be
     * instantiated.
     */
    protected LookupTypeManager() {
    }

    /**
     * Creates a Reference Type Object and stores it into the cache. Typically
     * called during Class Type Initialization to define Constants. 
     * This is protected. Utilize AbstractLookupType to create Constants.
     * 
     * @param code
     * @param description
     * @param lookupTypeClass
     */
    protected static <T extends LookupType> T createConstant(String code,
            String description, Class<T> lookupTypeClass) {
        try {
            T retVal = lookupTypeClass.newInstance();
            retVal.setCode(code);
            retVal.setDescription(description);

            addToCache(retVal);
            return retVal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds the passed in reference type to the cache. Types are cached by their
     * Id and Value Fields.
     * 
     * @param lookupType
     */
    protected static void addToCache(LookupType lookupType) {
        Map<String, LookupType> referenceMap = lookupTypeCache.get(lookupType
                .getClass());

        if (referenceMap == null) {
        	referenceMap = new HashMap<String, LookupType>();
            lookupTypeCache.put(lookupType.getClass(), referenceMap);
        }

        // If this is an existing item, update the Cache object
        if (mergeExistingItem(lookupType)) {
            return;
        }

        referenceMap.put("CODE_" + lookupType.getCode().toUpperCase(),
                lookupType);
        referenceMap.put("ID_" + lookupType.getId(), lookupType);
    }

    /**
     * Merge a new reference Type into an existing Cache item. Typically done
     * when a Constant Reference Type item is merged with its Database
     * equivalent.
     * 
     * @param lookupType
     * @param referenceMap
     */
    protected static boolean mergeExistingItem(LookupType lookupType) {

        LookupType cachedItem = getFromCacheByCode(lookupType.getCode(),
                lookupType.getClass());
        if (cachedItem == null) {
            return false;
        }

        BeanUtils.copyProperties(lookupType, cachedItem);

        return true;
    }

    /**
     * Retrieves the specified Reference type given its Value
     * 
     * @param <T>
     * @param value
     * @param lookupType
     * @return
     */
    @SuppressWarnings("unchecked")
    protected static <T extends LookupType> T getFromCacheByCode(String code,
            Class<T> lookupType) {
        Map<String, LookupType> referenceMap = lookupTypeCache.get(lookupType);

        if (referenceMap == null) {
            return null;
        }

        LookupType retVal = referenceMap.get("CODE_" + code.toUpperCase());
        return (T) retVal;
    }

    /**
     * Retrieves the specified Reference type given its Id as an long
     * 
     * @param <T>
     * @param id
     * @param lookupType
     * @return
     */
    protected static <T extends LookupType> T getFromCacheById(long id,
            Class<T> lookupType) {
        return getFromCacheById("" + id, lookupType);
    }

    /**
     * Retrieves the specified Reference type given its Id as a String
     * 
     * @param <T>
     * @param id
     * @param lookupType
     * @return
     */
    @SuppressWarnings("unchecked")
    protected static <T extends LookupType> T getFromCacheById(String id,
            Class<T> lookupType) {
        Map<String, LookupType> referenceMap = lookupTypeCache.get(lookupType);

        if (referenceMap == null) {
            return null;
        }

        LookupType retVal = referenceMap.get("ID_" + id);
        return (T) retVal;
    }
}
