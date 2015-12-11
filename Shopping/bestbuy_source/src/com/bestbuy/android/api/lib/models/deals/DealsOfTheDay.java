// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.deals;

import gs;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class DealsOfTheDay
{

    private static final String TAG = com/bestbuy/android/api/lib/models/deals/DealsOfTheDay.getSimpleName();
    private String content;
    private ArrayList offersList;
    private String widgetTitle;
    private String widgetType;
    private ArrayList widgetsList;

    public DealsOfTheDay()
    {
    }

    public static DealsOfTheDay loadDealsData(JSONObject jsonobject)
    {
        DealsOfTheDay dealsoftheday = new DealsOfTheDay();
        if (jsonobject != null && jsonobject.optJSONArray("widgets") != null)
        {
            try
            {
                dealsoftheday.widgetsList = dealsoftheday.loadWidgetsList(jsonobject.optJSONArray("widgets"));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                gs.d(TAG, (new StringBuilder()).append("Couldn't parse deals data:").append(jsonobject.getLocalizedMessage()).toString());
                return dealsoftheday;
            }
        }
        return dealsoftheday;
    }

    public String getContent()
    {
        return content;
    }

    public ArrayList getOffersList()
    {
        return offersList;
    }

    public String getWidgetTitle()
    {
        return widgetTitle;
    }

    public String getWidgetType()
    {
        return widgetType;
    }

    public ArrayList getWidgetsList()
    {
        return widgetsList;
    }

    public ArrayList loadWidgetsList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null && jsonarray.length() > 0)
        {
            for (int i = 0; i <= jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject == null)
                {
                    continue;
                }
                DealsOfTheDay dealsoftheday = new DealsOfTheDay();
                dealsoftheday.content = jsonobject.optString("content");
                dealsoftheday.widgetType = jsonobject.optString("widgetType");
                dealsoftheday.widgetTitle = jsonobject.optString("widgetTitle");
                if (jsonobject.optJSONArray("offers") != null)
                {
                    dealsoftheday.offersList = DODOffers.loadDODoffersArrayData(jsonobject.optJSONArray("offers"));
                }
                arraylist.add(dealsoftheday);
            }

        }
        return arraylist;
    }


    private class DODOffers
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
                    DODOffers dodoffers = new DODOffers();
                    dodoffers.lid = jsonobject.optString("lid");
                    dodoffers.offerType = jsonobject.optString("offerType");
                    if (jsonobject.optString("offerTitle") != null)
                    {
                        dodoffers.offerTitle = jsonobject.optString("offerTitle");
                    }
                    if (jsonobject.optString("url") != null)
                    {
                        dodoffers.customOfferURL = jsonobject.optString("url");
                    }
                    if (jsonobject.optJSONObject("sku") != null)
                    {
                        JSONObject jsonobject1 = jsonobject.optJSONObject("sku");
                        dodoffers.skuId = jsonobject1.optString("skuId");
                        dodoffers.url = jsonobject1.optString("url");
                        dodoffers.productId = jsonobject1.optString("productId");
                        dodoffers.productType = jsonobject1.optString("productType");
                        dodoffers.productCondition = jsonobject1.optString("condition");
                        if (jsonobject1.optJSONObject("attributes") != null)
                        {
                            dodoffers.lowPriceGuaranteedProduct = jsonobject1.optJSONObject("attributes").optBoolean("lowPriceGuaranteedProduct");
                        }
                        if (jsonobject1.optJSONObject("manufacturerId") != null)
                        {
                            dodoffers.modelNumber = jsonobject1.optJSONObject("manufacturerId").optString("modelNumber");
                        }
                        if (jsonobject1.optJSONObject("media") != null)
                        {
                            if (jsonobject1.optJSONObject("media").optJSONObject("primaryImage") != null)
                            {
                                dodoffers.primaryImgURL = jsonobject1.optJSONObject("media").optJSONObject("primaryImage").optString("url");
                                dodoffers.primaryImgAltText = jsonobject1.optJSONObject("media").optJSONObject("primaryImage").optString("altText");
                            }
                            if (jsonobject1.optJSONObject("media").optJSONObject("listImage") != null)
                            {
                                dodoffers.ListImgURL = jsonobject1.optJSONObject("media").optJSONObject("listImage").optString("url");
                                dodoffers.ListImgAltText = jsonobject1.optJSONObject("media").optJSONObject("listImage").optString("altText");
                            }
                        }
                        if (jsonobject1.optJSONObject("meta") != null)
                        {
                            dodoffers.metaDescription = jsonobject1.optJSONObject("meta").optString("description");
                            dodoffers.metaKeywords = jsonobject1.optJSONObject("meta").optString("keywords");
                            dodoffers.metaTitle = jsonobject1.optJSONObject("meta").optString("title");
                        }
                        if (jsonobject1.optJSONObject("names") != null)
                        {
                            dodoffers.shortName = jsonobject1.optJSONObject("names").optString("short");
                        }
                        if (jsonobject1.optJSONObject("descriptions") != null)
                        {
                            dodoffers.shortDescription = jsonobject1.optJSONObject("descriptions").optString("short");
                        }
                        if (jsonobject1.optJSONObject("brand") != null)
                        {
                            dodoffers.brand = jsonobject1.optJSONObject("brand").optString("brand");
                        }
                        if (jsonobject1.optJSONObject("properties") != null)
                        {
                            dodoffers.freeShippingCode = jsonobject1.optJSONObject("properties").optString("freeShippingCode");
                        }
                        if (jsonobject1.optJSONObject("customerRatings") != null)
                        {
                            if (jsonobject1.optJSONObject("customerRatings").optJSONObject("averageRating") != null)
                            {
                                dodoffers.avgRatingScore = jsonobject1.optJSONObject("customerRatings").optJSONObject("averageRating").optDouble("score");
                                dodoffers.reviewTotalCount = jsonobject1.optJSONObject("customerRatings").optInt("totalCount");
                            } else
                            {
                                dodoffers.avgRatingScore = 0.0D;
                                dodoffers.reviewTotalCount = 0;
                            }
                        }
                    }
                    if (jsonobject.optJSONObject("offerImage") != null)
                    {
                        dodoffers.offerImgURL = jsonobject.optJSONObject("offerImage").optString("url");
                        dodoffers.offerImgAltText = jsonobject.optJSONObject("offerImage").optString("altText");
                    }
                    if (jsonobject.optJSONObject("price") != null)
                    {
                        dodoffers.currentPrice = jsonobject.optJSONObject("price").optString("currentPrice");
                        dodoffers.onSale = jsonobject.optJSONObject("price").optBoolean("onSale");
                        dodoffers.priceType = jsonobject.optJSONObject("price").optString("priceType");
                        dodoffers.regularPrice = jsonobject.optJSONObject("price").optString("regularPrice");
                        dodoffers.savingsAmount = jsonobject.optJSONObject("price").optString("savingsAmount");
                    }
                    arraylist.add(dodoffers);
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

        public DODOffers()
        {
        }
    }

}
