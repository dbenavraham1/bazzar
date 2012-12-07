package com.bazzar.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personprefixlookup")
public class PerosnPrefixLookup  extends AbstractLookupType{

	private static final long serialVersionUID = 3212625355790851086L;
	
	public static final PerosnPrefixLookup MR = createConstant("MR", "MR", PerosnPrefixLookup.class);
	public static final PerosnPrefixLookup MRS = createConstant("MRS", "MRS", PerosnPrefixLookup.class);
	public static final PerosnPrefixLookup MISS = createConstant("MISS", "MISS", PerosnPrefixLookup.class);
	public static final PerosnPrefixLookup MS = createConstant("MS", "MS", PerosnPrefixLookup.class);
	
	
 	@Id
    @Column(name="Code")
    @Override
    public String getCode() {
        return super.getCode();
    }

    @Column(name="Description")
    @Override
    public String getDescription() {
        return super.getDescription();
    }

}
