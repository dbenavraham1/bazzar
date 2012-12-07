package com.bazzar.domain.lookup;

/**
 * General Interface for Lookup Types
 * @author amelnik
 *
 */
public interface LookupType {

    /**
     * Not all lookups are ID Based. The preferred approach is to utilize code
     * @return The Id of the lookup. 
     */
    long getId();
    
    /**
     * Sets the ID of the Lookup.
     * @param id
     */
    void setId(long id);
    
    /**
     * @return The Code field for the Lookup
     */
    String  getCode();
    
    /**
     * Sets the Code field for the lookup
     * @param value
     */
    void    setCode(String value);
        
    /**
     * @return The Description/Display Field for the Lookup
     */
    String getDescription();

    /**
     * Sets the Description/Display Field for the Lookup
     * @param description
     */
    void setDescription(String description);
}
