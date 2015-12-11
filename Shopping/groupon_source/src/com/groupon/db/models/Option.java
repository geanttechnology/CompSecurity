// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            CommonOptions, BookableSegments, CustomField, Price, 
//            GiftWrappingCharge, Image, InventoryService, LegalDisclosure, 
//            PricingMetadata, Location, SchedulerOption, ShippingOption, 
//            StockCategory, Trait, UiTreatment, Deal

public class Option
    implements CommonOptions
{
    protected static class Detail
    {

        public String description;

        protected Detail()
        {
            description = "";
        }
    }

    protected static class SpecificAttributes
    {

        public TakeoutDelivery takeoutDelivery;

        protected SpecificAttributes()
        {
            takeoutDelivery = new TakeoutDelivery();
        }
    }

    protected static class TakeoutDelivery
    {

        public boolean delivery;
        public boolean takeout;

        protected TakeoutDelivery()
        {
            takeout = false;
            delivery = false;
        }
    }


    protected List _bookableSegments;
    protected List _details;
    protected SpecificAttributes _specificAttributes;
    public boolean bookable;
    protected ArrayList bookableSegmentsList;
    public boolean customFieldPresent;
    public Collection customFields;
    public String details;
    public Price discount;
    public int discountPercent;
    public Date endAt;
    public Date endRedemptionAt;
    public Date expiresAt;
    public String externalUrl;
    public GiftWrappingCharge giftWrappingCharge;
    public String highlightsHtml;
    public Collection images;
    public InventoryService inventoryService;
    public boolean isLimitedQuantity;
    public boolean isSoldOut;
    protected volatile ArrayList legalDisclosureList;
    protected Collection legalDisclosures;
    public int maxPartySize;
    public int maximumPurchaseQuantity;
    public int minPartySize;
    public int minimumPurchaseQuantity;
    public Deal parentDeal;
    public String paymentMethods;
    public String pitchHtml;
    public Price price;
    public PricingMetadata pricingMetadata;
    public Long primaryKey;
    protected Collection redemptionLocations;
    protected volatile ArrayList redemptionLocationsList;
    public Price regularPrice;
    public int remainingQuantity;
    public String remoteId;
    public SchedulerOption schedulerOptions;
    public Collection shippingOptions;
    public int soldQuantity;
    public String soldQuantityMessage;
    public boolean specificAttributeDelivery;
    public boolean specificAttributeTakeout;
    public Date startRedemptionAt;
    public String status;
    public Collection stockCategories;
    public boolean stockManagement;
    public int timezoneOffsetInSeconds;
    public String title;
    public Collection traits;
    protected volatile ArrayList uiTreatmentList;
    protected Collection uiTreatments;
    public String uuid;
    public Price value;

    public Option()
    {
        minimumPurchaseQuantity = 1;
        discountPercent = 0;
        pitchHtml = "";
        highlightsHtml = "";
        paymentMethods = "";
        details = "";
        isLimitedQuantity = false;
        bookable = false;
        externalUrl = "";
        uuid = "";
        endAt = null;
        expiresAt = null;
        startRedemptionAt = null;
        endRedemptionAt = null;
        timezoneOffsetInSeconds = 0;
        maximumPurchaseQuantity = 10;
        remainingQuantity = -1;
        soldQuantity = 0;
        soldQuantityMessage = "";
        isSoldOut = false;
        status = "";
        title = "";
        stockManagement = false;
        minPartySize = 0;
        maxPartySize = 0;
        _details = Collections.emptyList();
        _specificAttributes = new SpecificAttributes();
        _bookableSegments = Collections.emptyList();
        specificAttributeDelivery = false;
        specificAttributeTakeout = false;
        customFieldPresent = false;
        bookableSegmentsList = new ArrayList();
        redemptionLocations = Collections.emptyList();
        legalDisclosures = Collections.emptyList();
        images = Collections.emptyList();
        traits = Collections.emptyList();
        shippingOptions = Collections.emptyList();
        customFields = Collections.emptyList();
        stockCategories = Collections.emptyList();
        uiTreatments = Collections.emptyList();
    }

    public void afterJsonDeserializationPostProcessor()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator1 = _details.iterator(); iterator1.hasNext(); arraylist.add(((Detail)iterator1.next()).description)) { }
        details = Strings.join("<BR />", arraylist);
        boolean flag;
        if (customFields != null && !customFields.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        customFieldPresent = flag;
        if (_specificAttributes != null && _specificAttributes.takeoutDelivery != null)
        {
            specificAttributeDelivery = _specificAttributes.takeoutDelivery.delivery;
            specificAttributeTakeout = _specificAttributes.takeoutDelivery.takeout;
        }
        if (_bookableSegments == null)
        {
            _bookableSegments = Collections.emptyList();
        }
        BookableSegments bookablesegments;
        for (Iterator iterator = _bookableSegments.iterator(); iterator.hasNext(); bookableSegmentsList.add(bookablesegments))
        {
            bookablesegments = (BookableSegments)iterator.next();
        }

    }

    public Price getDiscount()
    {
        return discount;
    }

    public int getDiscountPercent()
    {
        return discountPercent;
    }

    public Date getEndAt()
    {
        return endAt;
    }

    public Date getEndRedemptionAt()
    {
        return endRedemptionAt;
    }

    public Date getExpiresAt()
    {
        return expiresAt;
    }

    public ArrayList getLegalDisclosures()
    {
        if (legalDisclosureList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (legalDisclosureList == null)
        {
            legalDisclosureList = new ArrayList(legalDisclosures);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return legalDisclosureList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getMinimumPurchaseQuantity()
    {
        return minimumPurchaseQuantity;
    }

    public Price getPrice()
    {
        return price;
    }

    public ArrayList getRedemptionLocations()
    {
        if (redemptionLocationsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (redemptionLocationsList == null)
        {
            redemptionLocationsList = new ArrayList(redemptionLocations);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return redemptionLocationsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getSoldQuantity()
    {
        return soldQuantity;
    }

    public String getSoldQuantityMessage()
    {
        return soldQuantityMessage;
    }

    public String getStatus()
    {
        return status;
    }

    public String getTitle()
    {
        return title;
    }

    public ArrayList getUiTreatments()
    {
        if (uiTreatmentList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (uiTreatmentList == null)
        {
            uiTreatmentList = new ArrayList(uiTreatments);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return uiTreatmentList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Price getValue()
    {
        return value;
    }

    public boolean isExpired()
    {
        Date date = getExpiresAt();
        return Strings.equalsIgnoreCase("closed", getStatus()) || date != null && date.before(new Date());
    }

    public boolean isSoldOut()
    {
        return isSoldOut;
    }

    public boolean isSoldOutOrExpired()
    {
        return isSoldOut() || isExpired();
    }

    public void setCustomFieldPresent(boolean flag)
    {
        customFieldPresent = flag;
    }

    public void setCustomFields(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((CustomField)collection.next()).parentOption = this;
        }

        customFields = ((Collection) (obj));
    }

    public void setDiscount(Price price1)
    {
        if (price1 != null)
        {
            price1.parentOption = this;
        }
        discount = price1;
    }

    public void setGiftWrappingCharge(GiftWrappingCharge giftwrappingcharge)
    {
        if (giftwrappingcharge != null)
        {
            giftwrappingcharge.parentOption = this;
        }
        giftWrappingCharge = giftwrappingcharge;
    }

    public void setImages(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            Image image = (Image)collection.next();
            image.afterJsonDeserializationPostProcessor();
            image.parentOption = this;
        }

        images = ((Collection) (obj));
    }

    public void setInventoryService(InventoryService inventoryservice)
    {
        if (inventoryservice != null)
        {
            inventoryservice.parentOption = this;
        }
        inventoryService = inventoryservice;
    }

    public void setLegalDisclosures(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((LegalDisclosure)collection.next()).parentOption = this;
        }

        legalDisclosures = ((Collection) (obj));
    }

    public void setPrice(Price price1)
    {
        if (price1 != null)
        {
            price1.parentOption = this;
        }
        price = price1;
    }

    public void setPricingMetadata(PricingMetadata pricingmetadata)
    {
        if (pricingmetadata != null)
        {
            pricingmetadata.parentOption = this;
        }
        pricingMetadata = pricingmetadata;
    }

    public void setRedemptionLocations(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Location)collection.next()).parentOption = this;
        }

        redemptionLocations = ((Collection) (obj));
    }

    public void setRegularPrice(Price price1)
    {
        if (price1 != null)
        {
            price1.parentOption = this;
        }
        regularPrice = price1;
    }

    public void setSchedulerOptions(SchedulerOption scheduleroption)
    {
        if (scheduleroption != null)
        {
            scheduleroption.parentOption = this;
        }
        schedulerOptions = scheduleroption;
    }

    public void setShippingOptions(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((ShippingOption)collection.next()).parentOption = this;
        }

        shippingOptions = ((Collection) (obj));
    }

    public void setStockCategories(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((StockCategory)collection.next()).parentOption = this;
        }

        stockCategories = ((Collection) (obj));
    }

    public void setTraits(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Trait)collection.next()).parentOption = this;
        }

        traits = ((Collection) (obj));
    }

    public void setUiTreatments(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((UiTreatment)collection.next()).parentOption = this;
        }

        uiTreatments = ((Collection) (obj));
    }

    public void setValue(Price price1)
    {
        if (price1 != null)
        {
            price1.parentOption = this;
        }
        value = price1;
    }
}
