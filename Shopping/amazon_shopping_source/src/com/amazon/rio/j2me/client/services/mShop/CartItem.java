// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Badge, MerchantInfo

public class CartItem
{

    private String asin;
    private Badge badge;
    private String binding;
    private String byLine;
    private Boolean deprecatedEligibleForPrimeShipping;
    private Boolean eligibleForSuperSaverShipping;
    private String imageUrl;
    private Boolean isMinimumThresholdRequired;
    private boolean isQuantityEditable;
    private boolean isSavedItem;
    private String itemId;
    private MerchantInfo merchantInfo;
    private List messages;
    private Integer msToExpiry;
    private String offerId;
    private String points;
    private String price;
    private int quantity;
    private String shippingCharge;
    private String shortDescription;
    private String title;

    public CartItem()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public boolean getIsSavedItem()
    {
        return isSavedItem;
    }

    public String getItemId()
    {
        return itemId;
    }

    public MerchantInfo getMerchantInfo()
    {
        return merchantInfo;
    }

    public Integer getMsToExpiry()
    {
        return msToExpiry;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public String getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public String getTitle()
    {
        return title;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setBadge(Badge badge1)
    {
        badge = badge1;
    }

    public void setBinding(String s)
    {
        binding = s;
    }

    public void setByLine(String s)
    {
        byLine = s;
    }

    public void setDeprecatedEligibleForPrimeShipping(Boolean boolean1)
    {
        deprecatedEligibleForPrimeShipping = boolean1;
    }

    public void setEligibleForSuperSaverShipping(Boolean boolean1)
    {
        eligibleForSuperSaverShipping = boolean1;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setIsMinimumThresholdRequired(Boolean boolean1)
    {
        isMinimumThresholdRequired = boolean1;
    }

    public void setIsQuantityEditable(boolean flag)
    {
        isQuantityEditable = flag;
    }

    public void setIsSavedItem(boolean flag)
    {
        isSavedItem = flag;
    }

    public void setItemId(String s)
    {
        itemId = s;
    }

    public void setMerchantInfo(MerchantInfo merchantinfo)
    {
        merchantInfo = merchantinfo;
    }

    public void setMessages(List list)
    {
        messages = list;
    }

    public void setMsToExpiry(Integer integer)
    {
        msToExpiry = integer;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setPoints(String s)
    {
        points = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setQuantity(int i)
    {
        quantity = i;
    }

    public void setShippingCharge(String s)
    {
        shippingCharge = s;
    }

    public void setShortDescription(String s)
    {
        shortDescription = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
