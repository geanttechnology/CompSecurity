// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import com.bestbuy.android.api.lib.models.home.availability.Availability;
import gu;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            Attributes, Brand, BrandClass, CustomerRatings, 
//            Department, Descriptions, ManufacturerId, Media, 
//            Meta, Names, ParentCategory, PriceBlock, 
//            Properties, SubClass

public class SKU
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xfcfc1c5becfa9464L;
    private boolean active;
    private Attributes attributes;
    private Availability availability;
    private Brand brand;
    private BrandClass brandClass;
    private String condition;
    private CustomerRatings customerRatings;
    private Department department;
    private Descriptions descriptions;
    private String itemId;
    private ManufacturerId manufacturerId;
    private Media media;
    private Meta meta;
    private Names names;
    private ParentCategory parentCategory;
    private PriceBlock priceBlock;
    private String productId;
    private String productType;
    private Properties properties;
    private String skuId;
    private List specialOffers;
    private SubClass subclass;
    private String url;

    public SKU()
    {
    }

    public Attributes getAttributes()
    {
        return attributes;
    }

    public Availability getAvailability()
    {
        return availability;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public BrandClass getBrandClass()
    {
        return brandClass;
    }

    public String getCondition()
    {
        return condition;
    }

    public CustomerRatings getCustomerRatings()
    {
        return customerRatings;
    }

    public Department getDepartment()
    {
        return department;
    }

    public Descriptions getDescriptions()
    {
        return descriptions;
    }

    public String getItemId()
    {
        return itemId;
    }

    public ManufacturerId getManufacturerId()
    {
        return manufacturerId;
    }

    public Media getMedia()
    {
        return media;
    }

    public Meta getMeta()
    {
        return meta;
    }

    public Names getNames()
    {
        return names;
    }

    public ParentCategory getParentCategory()
    {
        return parentCategory;
    }

    public PriceBlock getPriceBlock()
    {
        return priceBlock;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getProductType()
    {
        return productType;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public List getSpecialOffers()
    {
        return specialOffers;
    }

    public SubClass getSubclass()
    {
        return subclass;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean flag)
    {
        active = flag;
    }

    public void setAttributes(Attributes attributes1)
    {
        attributes = attributes1;
    }

    public void setAvailability(Availability availability1)
    {
        availability = availability1;
    }

    public void setBrand(Brand brand1)
    {
        brand = brand1;
    }

    public void setBrandClass(BrandClass brandclass)
    {
        brandClass = brandclass;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setCustomerRatings(CustomerRatings customerratings)
    {
        customerRatings = customerratings;
    }

    public void setDepartment(Department department1)
    {
        department = department1;
    }

    public void setDescriptions(Descriptions descriptions1)
    {
        descriptions = descriptions1;
    }

    public void setItemId(String s)
    {
        itemId = s;
    }

    public void setManufacturerId(ManufacturerId manufacturerid)
    {
        manufacturerId = manufacturerid;
    }

    public void setMedia(Media media1)
    {
        media = media1;
    }

    public void setMeta(Meta meta1)
    {
        meta = meta1;
    }

    public void setNames(Names names1)
    {
        names = names1;
    }

    public void setParentCategory(ParentCategory parentcategory)
    {
        parentCategory = parentcategory;
    }

    public void setPriceBlock(PriceBlock priceblock)
    {
        priceBlock = priceblock;
    }

    public void setProductId(String s)
    {
        productId = s;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setProperties(Properties properties1)
    {
        properties = properties1;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setSpecialOffers(List list)
    {
        specialOffers = list;
    }

    public void setSubclass(SubClass subclass1)
    {
        subclass = subclass1;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
