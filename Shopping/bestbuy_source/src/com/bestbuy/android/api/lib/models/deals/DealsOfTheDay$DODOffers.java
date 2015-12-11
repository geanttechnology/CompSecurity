// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.deals;

import com.bestbuy.android.api.lib.models.product.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class t
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String ListImgAltText;
    private String ListImgURL;
    private double avgRatingScore;
    private BBYProduct bbyProduct;
    private String brand;
    private String currentPrice;
    private String customOfferURL;
    private String freeShippingCode;
    private String lid;
    private boolean lowPriceGuaranteedProduct;
    private String metaDescription;
    private String metaKeywords;
    private String metaTitle;
    private String modelNumber;
    private String offerImgAltText;
    private String offerImgURL;
    private String offerTitle;
    private String offerType;
    private boolean onSale;
    private String priceType;
    private String primaryImgAltText;
    private String primaryImgURL;
    private PriceBlock prodPriceBlock;
    private String productCondition;
    private String productId;
    private String productType;
    private String regularPrice;
    private int reviewTotalCount;
    private String savingsAmount;
    private String shortDescription;
    private String shortName;
    private boolean skuActive;
    private String skuId;
    private String url;

    public static ArrayList loadDODoffersArrayData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null && jsonarray.length() > 0)
        {
            int i = 0;
            while (i <= jsonarray.length()) 
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject == null)
                {
                    continue;
                }
                t t = new <init>();
                t.lid = jsonobject.optString("lid");
                t.offerType = jsonobject.optString("offerType");
                if (jsonobject.optString("offerTitle") != null)
                {
                    t.offerTitle = jsonobject.optString("offerTitle");
                }
                if (jsonobject.optString("url") != null)
                {
                    t.customOfferURL = jsonobject.optString("url");
                }
                if (jsonobject.optJSONObject("sku") != null)
                {
                    JSONObject jsonobject1 = jsonobject.optJSONObject("sku");
                    t.skuId = jsonobject1.optString("skuId");
                    t.url = jsonobject1.optString("url");
                    t.productId = jsonobject1.optString("productId");
                    t.productType = jsonobject1.optString("productType");
                    t.productCondition = jsonobject1.optString("condition");
                    if (jsonobject1.optJSONObject("attributes") != null)
                    {
                        t.lowPriceGuaranteedProduct = jsonobject1.optJSONObject("attributes").optBoolean("lowPriceGuaranteedProduct");
                    }
                    if (jsonobject1.optJSONObject("manufacturerId") != null)
                    {
                        t.modelNumber = jsonobject1.optJSONObject("manufacturerId").optString("modelNumber");
                    }
                    if (jsonobject1.optJSONObject("media") != null)
                    {
                        if (jsonobject1.optJSONObject("media").optJSONObject("primaryImage") != null)
                        {
                            t.primaryImgURL = jsonobject1.optJSONObject("media").optJSONObject("primaryImage").optString("url");
                            t.primaryImgAltText = jsonobject1.optJSONObject("media").optJSONObject("primaryImage").optString("altText");
                        }
                        if (jsonobject1.optJSONObject("media").optJSONObject("listImage") != null)
                        {
                            t.ListImgURL = jsonobject1.optJSONObject("media").optJSONObject("listImage").optString("url");
                            t.ListImgAltText = jsonobject1.optJSONObject("media").optJSONObject("listImage").optString("altText");
                        }
                    }
                    if (jsonobject1.optJSONObject("meta") != null)
                    {
                        t.metaDescription = jsonobject1.optJSONObject("meta").optString("description");
                        t.metaKeywords = jsonobject1.optJSONObject("meta").optString("keywords");
                        t.metaTitle = jsonobject1.optJSONObject("meta").optString("title");
                    }
                    if (jsonobject1.optJSONObject("names") != null)
                    {
                        t.shortName = jsonobject1.optJSONObject("names").optString("short");
                    }
                    if (jsonobject1.optJSONObject("descriptions") != null)
                    {
                        t.shortDescription = jsonobject1.optJSONObject("descriptions").optString("short");
                    }
                    if (jsonobject1.optJSONObject("brand") != null)
                    {
                        t.brand = jsonobject1.optJSONObject("brand").optString("brand");
                    }
                    if (jsonobject1.optJSONObject("properties") != null)
                    {
                        t.freeShippingCode = jsonobject1.optJSONObject("properties").optString("freeShippingCode");
                    }
                    if (jsonobject1.optJSONObject("customerRatings") != null)
                    {
                        if (jsonobject1.optJSONObject("customerRatings").optJSONObject("averageRating") != null)
                        {
                            t.avgRatingScore = jsonobject1.optJSONObject("customerRatings").optJSONObject("averageRating").optDouble("score");
                            t.reviewTotalCount = jsonobject1.optJSONObject("customerRatings").optInt("totalCount");
                        } else
                        {
                            t.avgRatingScore = 0.0D;
                            t.reviewTotalCount = 0;
                        }
                    }
                }
                if (jsonobject.optJSONObject("offerImage") != null)
                {
                    t.offerImgURL = jsonobject.optJSONObject("offerImage").optString("url");
                    t.offerImgAltText = jsonobject.optJSONObject("offerImage").optString("altText");
                }
                if (jsonobject.optJSONObject("price") != null)
                {
                    t.currentPrice = jsonobject.optJSONObject("price").optString("currentPrice");
                    t.onSale = jsonobject.optJSONObject("price").optBoolean("onSale");
                    t.priceType = jsonobject.optJSONObject("price").optString("priceType");
                    t.regularPrice = jsonobject.optJSONObject("price").optString("regularPrice");
                    t.savingsAmount = jsonobject.optJSONObject("price").optString("savingsAmount");
                }
                arraylist.add(t);
                i++;
            }
        }
        return arraylist;
    }

    public double getAvgRatingScore()
    {
        return avgRatingScore;
    }

    public BBYProduct getBbyProduct()
    {
        return bbyProduct;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getCurrentPrice()
    {
        return currentPrice;
    }

    public String getCustomOfferURL()
    {
        return customOfferURL;
    }

    public String getFreeShippingCode()
    {
        return freeShippingCode;
    }

    public String getLid()
    {
        return lid;
    }

    public String getListImgAltText()
    {
        return ListImgAltText;
    }

    public String getListImgURL()
    {
        return ListImgURL;
    }

    public String getMetaDescription()
    {
        return metaDescription;
    }

    public String getMetaKeywords()
    {
        return metaKeywords;
    }

    public String getMetaTitle()
    {
        return metaTitle;
    }

    public String getModelNumber()
    {
        return modelNumber;
    }

    public String getOfferImgAltText()
    {
        return offerImgAltText;
    }

    public String getOfferImgURL()
    {
        return offerImgURL;
    }

    public String getOfferTitle()
    {
        return offerTitle;
    }

    public String getOfferType()
    {
        return offerType;
    }

    public String getPriceType()
    {
        return priceType;
    }

    public String getPrimaryImgAltText()
    {
        return primaryImgAltText;
    }

    public String getPrimaryImgURL()
    {
        return primaryImgURL;
    }

    public PriceBlock getProdPriceBlock()
    {
        return prodPriceBlock;
    }

    public String getProductCondition()
    {
        return productCondition;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getRegularPrice()
    {
        return regularPrice;
    }

    public int getReviewTotalCount()
    {
        return reviewTotalCount;
    }

    public String getSavingsAmount()
    {
        return savingsAmount;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isLowPriceGuaranteedProduct()
    {
        return lowPriceGuaranteedProduct;
    }

    public boolean isOnSale()
    {
        return onSale;
    }

    public boolean isSkuActive()
    {
        return skuActive;
    }

    public void setBbyProduct(BBYProduct bbyproduct)
    {
        bbyProduct = bbyproduct;
    }

    public void setProdPriceBlock(PriceBlock priceblock)
    {
        prodPriceBlock = priceblock;
    }

    public t()
    {
    }
}
