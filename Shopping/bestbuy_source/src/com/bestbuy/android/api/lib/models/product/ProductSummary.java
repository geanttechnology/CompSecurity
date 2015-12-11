// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.product:
//            Availability

public class ProductSummary
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String artistName;
    private String brandLabel;
    private String brandName;
    private String chatType;
    private String condition;
    private String description;
    private String displayName;
    private boolean energyStarCompatible;
    private String fileSize;
    private String format;
    private String freeShippingCode;
    private boolean hasTrailers;
    private String id;
    private boolean isActive;
    private boolean isContractProduct;
    private String itemId;
    private String keywords;
    private String label;
    private String longDescription;
    private boolean lowPriceGuaranteedProduct;
    private boolean marketplaceProduct;
    private String mediaType;
    private String metaTitle;
    private boolean newProduct;
    private boolean parentalAdvisory;
    private double percent0To1;
    private int percent0To100;
    private String platform;
    private Availability productAvailability;
    private String productId;
    private Product.ProductImages productImages;
    private String productType;
    private String publisher;
    private int rangeMax;
    private String rating;
    private String ratingDescriptors;
    private double recommPercent0To1;
    private int recommPercent0To100;
    private double score;
    private String shortDes;
    private String shortName;
    private String skuId;
    private boolean smartCapable;
    private String streetDate;
    private String synopsis;
    private String title;
    private int totalRecommendCount;
    private String vendor;
    private boolean wallMountable;

    public ProductSummary()
    {
    }

    public static ProductSummary parseProductSummaryData(String s)
    {
        s = (new JSONArray(s)).getJSONObject(0);
        ProductSummary productsummary = new ProductSummary();
        productsummary.productId = s.optString("productId", "");
        productsummary.productType = s.optString("productType", "");
        productsummary.skuId = s.optString("sku");
        productsummary.isActive = s.optBoolean("active", false);
        if (productsummary.condition != null && !productsummary.condition.isEmpty())
        {
            productsummary.condition = (new StringBuilder()).append(productsummary.condition.substring(0, 1).toUpperCase()).append(productsummary.condition.substring(1).toLowerCase()).toString();
        }
        if (s.optJSONObject("attributes") != null)
        {
            productsummary.energyStarCompatible = s.optJSONObject("attributes").optBoolean("energyStarCompatible", false);
            productsummary.lowPriceGuaranteedProduct = s.optJSONObject("attributes").optBoolean("lowPriceGuaranteedProduct", false);
            productsummary.smartCapable = s.optJSONObject("attributes").optBoolean("smartCapable", false);
            productsummary.wallMountable = s.optJSONObject("attributes").optBoolean("wallMountable", false);
            productsummary.newProduct = s.optJSONObject("attributes").optBoolean("newProduct", false);
            productsummary.marketplaceProduct = s.optJSONObject("attributes").optBoolean("marketplaceProduct", false);
            productsummary.parentalAdvisory = s.optJSONObject("attributes").optBoolean("parentalAdvisory", false);
        }
        if (s.optJSONObject("meta") != null)
        {
            productsummary.description = s.optJSONObject("meta").optString("description", "");
            productsummary.title = s.optJSONObject("meta").optString("title", "");
            productsummary.keywords = s.optJSONObject("meta").optString("keywords", "");
        }
        if (s.optJSONObject("descriptions") != null)
        {
            productsummary.shortDes = s.optJSONObject("descriptions").optString("short");
            productsummary.longDescription = s.optJSONObject("descriptions").optString("long");
            productsummary.synopsis = s.optJSONObject("descriptions").optString("synopsis");
        }
        if (s.optJSONObject("brand") != null)
        {
            productsummary.brandLabel = s.optJSONObject("brand").optString("label", "");
            productsummary.brandName = s.optJSONObject("brand").optString("brand", "");
            productsummary.vendor = s.optJSONObject("brand").optString("vendor", "");
            productsummary.publisher = s.optJSONObject("brand").optString("publisher", "");
            productsummary.label = s.optJSONObject("brand").optString("label", "");
        }
        if (s.optJSONObject("properties") != null)
        {
            productsummary.fileSize = s.optJSONObject("properties").optString("fileSize", "");
            productsummary.chatType = s.optJSONObject("properties").optString("chatType", "");
            productsummary.format = s.optJSONObject("properties").optString("format", "");
            productsummary.freeShippingCode = s.optJSONObject("properties").optString("freeShippingCode", "");
            Object obj = s.optJSONObject("properties").optString("contractCondition", "");
            if (((String) (obj)).equals("2_YEARS_NEW") || ((String) (obj)).equals("2_YEARS_UPGRADE"))
            {
                productsummary.isContractProduct = true;
            }
            obj = s.optJSONObject("properties").optJSONArray("primaryArtist");
            productsummary.mediaType = s.optJSONObject("properties").optString("mediaType", "");
            if (obj != null)
            {
                productsummary.artistName = ((JSONArray) (obj)).optJSONObject(0).optString("displayName", "");
            }
        }
        return productsummary;
    }

    public String getArtistName()
    {
        return artistName;
    }

    public String getBrandLabel()
    {
        return brandLabel;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public String getChatType()
    {
        return chatType;
    }

    public String getCondition()
    {
        return condition;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getFileSize()
    {
        return fileSize;
    }

    public String getFormat()
    {
        return format;
    }

    public String getFreeShippingCode()
    {
        return freeShippingCode;
    }

    public String getId()
    {
        return id;
    }

    public String getItemId()
    {
        return itemId;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public String getLabel()
    {
        return label;
    }

    public String getLongDescription()
    {
        return longDescription;
    }

    public String getMediaType()
    {
        return mediaType;
    }

    public String getMetaTitle()
    {
        return metaTitle;
    }

    public double getPercent0To1()
    {
        return percent0To1;
    }

    public int getPercent0To100()
    {
        return percent0To100;
    }

    public String getPlatform()
    {
        return platform;
    }

    public Availability getProductAvailability()
    {
        return productAvailability;
    }

    public String getProductId()
    {
        return productId;
    }

    public Product.ProductImages getProductImages()
    {
        return productImages;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public int getRangeMax()
    {
        return rangeMax;
    }

    public String getRating()
    {
        return rating;
    }

    public String getRatingDescriptors()
    {
        return ratingDescriptors;
    }

    public double getRecommPercent0To1()
    {
        return recommPercent0To1;
    }

    public int getRecommPercent0To100()
    {
        return recommPercent0To100;
    }

    public double getScore()
    {
        return score;
    }

    public String getShortDes()
    {
        return shortDes;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public String getStreetDate()
    {
        return streetDate;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public String getTitle()
    {
        return title;
    }

    public int getTotalRecommendCount()
    {
        return totalRecommendCount;
    }

    public String getVendor()
    {
        return vendor;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public boolean isContractProduct()
    {
        return isContractProduct;
    }

    public boolean isEnergyStarCompatible()
    {
        return energyStarCompatible;
    }

    public boolean isHasTrailers()
    {
        return hasTrailers;
    }

    public boolean isLowPriceGuaranteedProduct()
    {
        return lowPriceGuaranteedProduct;
    }

    public boolean isMarketplaceProduct()
    {
        return marketplaceProduct;
    }

    public boolean isNewProduct()
    {
        return newProduct;
    }

    public boolean isParentalAdvisory()
    {
        return parentalAdvisory;
    }

    public boolean isSmartCapable()
    {
        return smartCapable;
    }

    public boolean isWallMountable()
    {
        return wallMountable;
    }
}
