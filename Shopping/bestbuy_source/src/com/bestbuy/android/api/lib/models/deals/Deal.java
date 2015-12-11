// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.deals;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import org.json.JSONObject;

public class Deal
{

    private BBYProduct actualProduct;
    private String altImage;
    private String altImage_hover;
    private String averageOverallRating;
    private String category;
    private String dealDetailLink;
    private String dealPrice;
    private String displaySku;
    private String dotcomReviewUrl;
    private String dotdStatus;
    private boolean freeShipping;
    private String getDealUrl;
    private boolean isLimitedQuantity;
    private boolean isOnlineOnly;
    private boolean isSavingsOverride;
    private boolean isSuppressed;
    private boolean isUnactivatedPrice;
    private String model;
    private String originalPrice;
    private String productDetails;
    private String productDetailsCopy;
    private String productTitle;
    private String savings;
    private String sku;
    private String subCategory;
    private String totalReviews;
    private String upc;

    public Deal()
    {
    }

    public static Deal loadDealData(JSONObject jsonobject)
    {
        Deal deal = new Deal();
        deal.sku = jsonobject.optString("sku", "");
        deal.displaySku = jsonobject.optString("display_sku", "");
        deal.productTitle = jsonobject.optString("product_title", "");
        deal.dealPrice = jsonobject.optString("deal_price", "");
        deal.originalPrice = jsonobject.optString("original_price", "");
        deal.savings = jsonobject.optString("savings", "");
        deal.productDetails = jsonobject.optString("product_details", "");
        deal.productDetailsCopy = jsonobject.optString("product_details_copy", "");
        deal.category = jsonobject.optString("category", "");
        deal.subCategory = jsonobject.optString("sub_category", "");
        deal.averageOverallRating = jsonobject.optString("average_overall_rating", "");
        deal.model = jsonobject.optString("model", "");
        deal.altImage = jsonobject.optString("alt_image", "");
        deal.altImage_hover = jsonobject.optString("alt_image_hover", "");
        deal.dotdStatus = jsonobject.optString("dotdStatus", "");
        deal.dealDetailLink = jsonobject.optString("deal_detail_link", "");
        deal.getDealUrl = jsonobject.optString("get_deal_url", "");
        deal.upc = jsonobject.optString("upc", "");
        deal.totalReviews = jsonobject.optString("total_reviews", "");
        deal.productDetailsCopy = jsonobject.optString("product_details_copy", "");
        deal.dotcomReviewUrl = jsonobject.optString("dotcom_review_url", "");
        deal.freeShipping = jsonobject.optBoolean("free_shipping", false);
        deal.isLimitedQuantity = jsonobject.optBoolean("is_limited_quantity", false);
        deal.isOnlineOnly = jsonobject.optBoolean("is_online_only", false);
        deal.isUnactivatedPrice = jsonobject.optBoolean("is_unactivated_price", false);
        deal.isSuppressed = jsonobject.optBoolean("is_suppressed", false);
        deal.isSavingsOverride = jsonobject.optBoolean("is_savings_override", false);
        return deal;
    }

    public BBYProduct getActualProduct()
    {
        return actualProduct;
    }

    public String getAltImage()
    {
        return altImage;
    }

    public String getAltImage_hover()
    {
        return altImage_hover;
    }

    public String getAverageOverallRating()
    {
        return averageOverallRating;
    }

    public String getCategory()
    {
        return category;
    }

    public String getDealDetailLink()
    {
        return dealDetailLink;
    }

    public String getDealPrice()
    {
        return dealPrice;
    }

    public String getDisplaySku()
    {
        return displaySku;
    }

    public String getDotcomReviewUrl()
    {
        return dotcomReviewUrl;
    }

    public String getDotdStatus()
    {
        return dotdStatus;
    }

    public String getGetDealUrl()
    {
        return getDealUrl;
    }

    public String getModel()
    {
        return model;
    }

    public String getOriginalPrice()
    {
        return originalPrice;
    }

    public String getProductDetails()
    {
        return productDetails;
    }

    public String getProductDetailsCopy()
    {
        return productDetailsCopy;
    }

    public String getProductTitle()
    {
        return productTitle;
    }

    public String getSavings()
    {
        return savings;
    }

    public String getSku()
    {
        return sku;
    }

    public String getSubCategory()
    {
        return subCategory;
    }

    public String getTotalReviews()
    {
        return totalReviews;
    }

    public String getUpc()
    {
        return upc;
    }

    public boolean isFreeShipping()
    {
        return freeShipping;
    }

    public boolean isLimitedQuantity()
    {
        return isLimitedQuantity;
    }

    public boolean isOnlineOnly()
    {
        return isOnlineOnly;
    }

    public boolean isSavingsOverride()
    {
        return isSavingsOverride;
    }

    public boolean isSuppressed()
    {
        return isSuppressed;
    }

    public boolean isUnactivatedPrice()
    {
        return isUnactivatedPrice;
    }

    public void setActualProduct(BBYProduct bbyproduct)
    {
        actualProduct = bbyproduct;
    }
}
