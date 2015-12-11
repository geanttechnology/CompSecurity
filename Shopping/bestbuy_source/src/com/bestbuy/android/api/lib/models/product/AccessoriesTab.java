// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import gs;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class AccessoriesTab
    implements Serializable
{

    private static String TAG = com/bestbuy/android/api/lib/models/product/AccessoriesTab.getName();
    private static final long serialVersionUID = 1L;
    private double averageRatingScore;
    private double currentPrice;
    private ArrayList includedItems;
    private String pricingType;
    private String productImage;
    private String productThumbNailImg;
    private String productType;
    private double ratingTotalCount;
    private double regularPrice;
    private ArrayList requiredAccessories;
    private double savingsAmount;
    private String shortName;
    private String sku;
    private ArrayList suggestedAccessories;

    public AccessoriesTab()
    {
        sku = "";
        productType = "";
        currentPrice = 0.0D;
        pricingType = "";
        regularPrice = 0.0D;
        savingsAmount = 0.0D;
        averageRatingScore = 0.0D;
        ratingTotalCount = 0.0D;
        shortName = "";
        productImage = "";
        productThumbNailImg = "";
    }

    public static ArrayList getCompleteAccessoriesData(JSONArray jsonarray)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        i = 0;
_L3:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = jsonarray.optJSONObject(i);
        if (jsonobject != null)
        {
            try
            {
                AccessoriesTab accessoriestab = new AccessoriesTab();
                if (jsonobject.optJSONObject("names") != null)
                {
                    accessoriestab.shortName = jsonobject.optJSONObject("names").optString("short");
                }
                if (jsonobject.optJSONObject("price") != null)
                {
                    JSONObject jsonobject1 = jsonobject.optJSONObject("price");
                    accessoriestab.currentPrice = jsonobject1.optDouble("currentPrice");
                    accessoriestab.pricingType = jsonobject1.optString("pricingType");
                    accessoriestab.regularPrice = jsonobject1.optDouble("regularPrice");
                    accessoriestab.savingsAmount = jsonobject1.optDouble("savingsAmount");
                }
                if (jsonobject.optJSONObject("customerRatings") != null)
                {
                    JSONObject jsonobject2 = jsonobject.optJSONObject("customerRatings");
                    if (jsonobject2.optJSONObject("averageRating") != null)
                    {
                        accessoriestab.averageRatingScore = jsonobject2.optJSONObject("averageRating").optDouble("score");
                    }
                    accessoriestab.ratingTotalCount = jsonobject2.optDouble("totalCount");
                }
                if (jsonobject.optJSONObject("media") != null)
                {
                    jsonobject = jsonobject.optJSONObject("media");
                    if (jsonobject.optJSONObject("primaryImage") != null)
                    {
                        accessoriestab.productImage = jsonobject.optJSONObject("primaryImage").optString("url");
                    }
                    if (jsonobject.optJSONObject("listImage") != null)
                    {
                        accessoriestab.productThumbNailImg = jsonobject.optJSONObject("listImage").optString("url");
                    }
                }
                arraylist.add(accessoriestab);
            }
            catch (Exception exception)
            {
                gs.d(TAG, (new StringBuilder()).append("Couldn't parse Accessories data:").append(exception.getLocalizedMessage()).toString());
            }
        }
        i++;
          goto _L3
_L2:
        return arraylist;
    }

    public static AccessoriesTab loadAccessoriesData(JSONObject jsonobject)
    {
        AccessoriesTab accessoriestab = new AccessoriesTab();
        try
        {
            if (jsonobject.optJSONObject("sku") != null)
            {
                jsonobject = jsonobject.optJSONObject("sku");
                if (jsonobject.optString("productType") != null)
                {
                    accessoriestab.productType = jsonobject.optString("productType");
                }
                if (jsonobject.optJSONArray("includedItems") != null)
                {
                    accessoriestab.includedItems = loadIncludedItems(jsonobject.optJSONArray("includedItems"));
                }
                if (jsonobject.optJSONArray("requiredAccessories") != null)
                {
                    accessoriestab.requiredAccessories = getCompleteAccessoriesData(jsonobject.optJSONArray("requiredAccessories"));
                }
                if (jsonobject.optJSONArray("suggestedAccessories") != null)
                {
                    accessoriestab.suggestedAccessories = getCompleteAccessoriesData(jsonobject.optJSONArray("suggestedAccessories"));
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            gs.d(TAG, (new StringBuilder()).append("Couldn't parse accessoriesTab data:").append(jsonobject.getLocalizedMessage()).toString());
            return accessoriestab;
        }
        return accessoriestab;
    }

    public static ArrayList loadIncludedItems(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        String s;
        int i;
        s = "";
        i = 0;
_L3:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = jsonarray.optJSONObject(i);
        Object obj = s;
        if (jsonobject != null)
        {
            try
            {
                obj = jsonobject.optString("name");
            }
            catch (Exception exception)
            {
                gs.d(TAG, (new StringBuilder()).append("Couldn't parse includedItems data: ").append(exception.getLocalizedMessage()).toString());
                exception = s;
            }
        }
        arraylist.add(obj);
        i++;
        s = ((String) (obj));
        if (true) goto _L3; else goto _L2
_L2:
        return arraylist;
    }

    public double getAverageRatingScore()
    {
        return averageRatingScore;
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public ArrayList getIncludedItems()
    {
        return includedItems;
    }

    public String getPricingType()
    {
        return pricingType;
    }

    public String getProductImage()
    {
        return productImage;
    }

    public String getProductThumbNailImg()
    {
        return productThumbNailImg;
    }

    public String getProductType()
    {
        return productType;
    }

    public double getRatingTotalCount()
    {
        return ratingTotalCount;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }

    public ArrayList getRequiredAccessories()
    {
        return requiredAccessories;
    }

    public double getSavingsAmount()
    {
        return savingsAmount;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getSku()
    {
        return sku;
    }

    public ArrayList getSuggestedAccessories()
    {
        return suggestedAccessories;
    }

}
