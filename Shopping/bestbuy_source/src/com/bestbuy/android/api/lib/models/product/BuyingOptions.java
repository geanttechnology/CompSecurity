// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import gs;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BuyingOptions
    implements Serializable
{

    private static String TAG = com/bestbuy/android/api/lib/models/product/BuyingOptions.getSimpleName();
    private static final long serialVersionUID = 1L;
    private boolean availableForStorePickup;
    private boolean availableOnline;
    private String availableOnlineDispMsg;
    private String availableOnlineUrl;
    private String availableStoreDispMsg;
    private String availableStoreUrl;
    private ArrayList buyingOptionsInfo;
    private String condition;
    private double currentPrice;
    private boolean displayCertifiedLogo;
    private String displayCondition;
    private ArrayList financingOfferInfo;
    private String freeShippingCode;
    private int height;
    private String listingId;
    private String pricingType;
    private String productId;
    private String productType;
    private double regularPrice;
    private double savingsAmount;
    private String sellerId;
    private String sellerImage;
    private String sellerInfoUrl;
    private String sellerName;
    private String sellerskuid;
    private double shippingCost;
    private String shortname;
    private String sku;
    private ArrayList spclOfferInfo;
    private String target;
    private double totalPrice;
    private int width;

    public BuyingOptions()
    {
        sku = "";
        shortname = "";
        productType = "";
        sellerskuid = "";
        condition = "";
        displayCondition = "";
        productId = "";
        availableForStorePickup = false;
        availableStoreDispMsg = "";
        availableStoreUrl = "";
        availableOnline = false;
        height = 0;
        width = 0;
        target = "";
        availableOnlineDispMsg = "";
        availableOnlineUrl = "";
        currentPrice = 0.0D;
        listingId = "";
        pricingType = "";
        shippingCost = 0.0D;
        totalPrice = 0.0D;
        regularPrice = 0.0D;
        savingsAmount = 0.0D;
        sellerName = "";
        sellerInfoUrl = "";
        sellerImage = "";
        sellerId = "";
        freeShippingCode = "";
    }

    public static BuyingOptions loadBuyingOptionsData(JSONObject jsonobject)
    {
        BuyingOptions buyingoptions = new BuyingOptions();
        try
        {
            if (jsonobject.optJSONObject("sku") != null)
            {
                jsonobject = jsonobject.optJSONObject("sku");
                buyingoptions.productType = jsonobject.optString("productType");
                buyingoptions.sku = jsonobject.optString("skuId");
                if (jsonobject.optJSONObject("names") != null)
                {
                    buyingoptions.shortname = jsonobject.optJSONObject("names").optString("short");
                }
                if (jsonobject.optJSONArray("buyingOptions") != null)
                {
                    buyingoptions.buyingOptionsInfo = buyingoptions.loadBuyingOptionsArrayData(jsonobject.optJSONArray("buyingOptions"));
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            gs.d(TAG, (new StringBuilder()).append("Couldn't parse buyingOptionsTab data:").append(jsonobject.getLocalizedMessage()).toString());
            return buyingoptions;
        }
        return buyingoptions;
    }

    public String getAvailableOnlineDispMsg()
    {
        return availableOnlineDispMsg;
    }

    public String getAvailableOnlineUrl()
    {
        return availableOnlineUrl;
    }

    public String getAvailableStoreDispMsg()
    {
        return availableStoreDispMsg;
    }

    public String getAvailableStoreUrl()
    {
        return availableStoreUrl;
    }

    public ArrayList getBuyingOptionsInfo()
    {
        return buyingOptionsInfo;
    }

    public String getCondition()
    {
        return condition;
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public String getDisplayCondition()
    {
        return displayCondition;
    }

    public ArrayList getFinancingOfferInfo()
    {
        return financingOfferInfo;
    }

    public String getFreeShippingCode()
    {
        return freeShippingCode;
    }

    public int getHeight()
    {
        return height;
    }

    public String getListingId()
    {
        return listingId;
    }

    public String getPricingType()
    {
        return pricingType;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getProductType()
    {
        return productType;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }

    public double getSavingsAmount()
    {
        return savingsAmount;
    }

    public String getSellerId()
    {
        return sellerId;
    }

    public String getSellerImage()
    {
        return sellerImage;
    }

    public String getSellerInfoUrl()
    {
        return sellerInfoUrl;
    }

    public String getSellerName()
    {
        return sellerName;
    }

    public String getSellerskuid()
    {
        return sellerskuid;
    }

    public double getShippingCost()
    {
        return shippingCost;
    }

    public String getShortname()
    {
        return shortname;
    }

    public String getSku()
    {
        return sku;
    }

    public ArrayList getSpclOfferInfo()
    {
        return spclOfferInfo;
    }

    public String getTarget()
    {
        return target;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public int getWidth()
    {
        return width;
    }

    public boolean isAvailableForStorePickup()
    {
        return availableForStorePickup;
    }

    public boolean isAvailableOnline()
    {
        return availableOnline;
    }

    public boolean isDisplayCertifiedLogo()
    {
        return displayCertifiedLogo;
    }

    public ArrayList loadBuyingOptionsArrayData(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null && jsonarray.length() > 0)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject == null)
                {
                    continue;
                }
                BuyingOptions buyingoptions = new BuyingOptions();
                buyingoptions.sellerskuid = jsonobject.optString("skuId");
                buyingoptions.condition = jsonobject.optString("condition");
                buyingoptions.displayCondition = jsonobject.optString("displayCondition");
                buyingoptions.productId = jsonobject.optString("productId");
                buyingoptions.displayCertifiedLogo = jsonobject.optBoolean("displayCertifiedLogo");
                if (jsonobject.optJSONArray("specialOffers") != null)
                {
                    buyingoptions.spclOfferInfo = SpecialOffers.loadSpecialOffersData(jsonobject.optJSONArray("specialOffers"));
                }
                if (jsonobject.optJSONArray("financingOffers") != null)
                {
                    buyingoptions.financingOfferInfo = FinancingOffers.loadFinanceOffersData(jsonobject.optJSONArray("financingOffers"));
                }
                if (jsonobject.optJSONObject("sellerInfo") != null)
                {
                    buyingoptions.sellerName = jsonobject.optJSONObject("sellerInfo").optString("seller");
                    buyingoptions.sellerInfoUrl = jsonobject.optJSONObject("sellerInfo").optString("sellerUrl");
                    Object obj = jsonobject.optJSONObject("sellerInfo").optJSONArray("images");
                    buyingoptions.sellerId = jsonobject.optJSONObject("sellerInfo").optString("sellerId");
                    if (obj != null)
                    {
                        obj = ((JSONArray) (obj)).getJSONObject(0);
                        if (obj != null)
                        {
                            buyingoptions.sellerImage = ((JSONObject) (obj)).optString("url");
                        }
                    }
                }
                if (jsonobject.optJSONObject("availability") != null)
                {
                    JSONObject jsonobject1 = jsonobject.optJSONObject("availability");
                    if (jsonobject1.optJSONObject("pickup") != null)
                    {
                        JSONObject jsonobject3 = jsonobject1.optJSONObject("pickup");
                        buyingoptions.availableForStorePickup = jsonobject3.optBoolean("available");
                        buyingoptions.availableStoreDispMsg = jsonobject3.optString("displayMessage").replace("<b>Store Pickup:</b>", "").replace("<b>Store Pickup</b>:", "").trim();
                        if (jsonobject3.optJSONObject("checkStoresLink") != null)
                        {
                            buyingoptions.availableStoreUrl = jsonobject3.optJSONObject("checkStoresLink").optString("url");
                        }
                    }
                    if (jsonobject1.optJSONObject("ship") != null)
                    {
                        jsonobject1 = jsonobject1.optJSONObject("ship");
                        buyingoptions.availableOnline = jsonobject1.optBoolean("available", false);
                        buyingoptions.availableOnlineDispMsg = jsonobject1.optString("displayMessage").replace("<b>Shipping:</b>", "").replace("<b>Shipping</b>:", "").trim();
                        if (jsonobject1.optJSONObject("checkLink") != null)
                        {
                            jsonobject1 = jsonobject1.optJSONObject("checkLink");
                            buyingoptions.availableOnlineUrl = jsonobject1.optString("url");
                            buyingoptions.height = jsonobject1.optInt("height");
                            buyingoptions.width = jsonobject1.optInt("width");
                            buyingoptions.target = jsonobject1.optString("target");
                        }
                    }
                }
                if (jsonobject.optJSONObject("price") != null)
                {
                    JSONObject jsonobject2 = jsonobject.optJSONObject("price");
                    buyingoptions.currentPrice = jsonobject2.optDouble("currentPrice");
                    buyingoptions.pricingType = jsonobject2.optString("pricingType");
                    buyingoptions.shippingCost = jsonobject2.optDouble("shippingCost", 0.0D);
                    buyingoptions.totalPrice = jsonobject2.optDouble("totalPrice", 0.0D);
                    buyingoptions.savingsAmount = jsonobject2.optDouble("savingsAmount");
                    buyingoptions.regularPrice = jsonobject2.optDouble("regularPrice");
                    buyingoptions.listingId = jsonobject2.optString("listingId");
                }
                if (jsonobject.optJSONObject("properties") != null)
                {
                    buyingoptions.freeShippingCode = jsonobject.optJSONObject("properties").optString("freeShippingCode", "");
                }
                arraylist.add(buyingoptions);
            }

        }
        return arraylist;
    }

    public void setDisplayCertifiedLogo(boolean flag)
    {
        displayCertifiedLogo = flag;
    }



    private class SpecialOffers
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private String spclOfferName;
        private String spclOfferTarget;
        private String spclOfferUrl;

        public static ArrayList loadSpecialOffersData(JSONArray jsonarray)
        {
            ArrayList arraylist;
            int i;
            arraylist = new ArrayList();
            i = 0;
_L3:
            if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            if (jsonobject != null)
            {
                try
                {
                    SpecialOffers specialoffers = new SpecialOffers();
                    specialoffers.spclOfferName = jsonobject.optString("name");
                    specialoffers.spclOfferTarget = jsonobject.optString("target");
                    specialoffers.spclOfferUrl = jsonobject.optString("url");
                    arraylist.add(specialoffers);
                }
                catch (Exception exception)
                {
                    gs.d(BuyingOptions.TAG, (new StringBuilder()).append("Couldn't parse Special Offers data: ").append(exception.getLocalizedMessage()).toString());
                }
            }
            i++;
              goto _L3
_L2:
            return arraylist;
        }

        public String getSpclOfferName()
        {
            return spclOfferName;
        }

        public String getSpclOfferTarget()
        {
            return spclOfferTarget;
        }

        public String getSpclOfferUrl()
        {
            return spclOfferUrl;
        }

        public SpecialOffers()
        {
        }
    }


    private class FinancingOffers
        implements Serializable
    {

        public static final long serialVersionUID = 1L;
        private String financeOfferName;
        private String financeOfferUrl;

        public static ArrayList loadFinanceOffersData(JSONArray jsonarray)
        {
            ArrayList arraylist = new ArrayList();
            FinancingOffers financingoffers = new FinancingOffers();
            int i = 0;
            while (i < jsonarray.length()) 
            {
                try
                {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    financingoffers.financeOfferName = jsonobject.optString("name");
                    financingoffers.financeOfferUrl = jsonobject.optString("url");
                    arraylist.add(financingoffers);
                }
                catch (Exception exception)
                {
                    gs.d(BuyingOptions.TAG, (new StringBuilder()).append("Couldn't parse Finance Offers Data: ").append(exception.getLocalizedMessage()).toString());
                }
                i++;
            }
            return arraylist;
        }

        public String getFinanceOfferName()
        {
            return financeOfferName;
        }

        public String getFinanceOfferUrl()
        {
            return financeOfferUrl;
        }

        public FinancingOffers()
        {
        }
    }

}
