// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import gs;
import gv;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.product:
//            SellerInfo

public class PriceBlock
    implements Serializable
{

    private static final String TAG = com/bestbuy/android/api/lib/models/product/PriceBlock.getSimpleName();
    private static final long serialVersionUID = 1L;
    private boolean advertisedPriceRestriction;
    private String buttonStateId;
    private boolean clearance;
    private String collection;
    private ArrayList contractOptions;
    private String displayName;
    private double dollarSavings;
    private ArrayList formatOptions;
    private boolean freeShipping;
    private boolean icr_hidePrice;
    private boolean icr_noPrice;
    private boolean icr_strike;
    private Date ircEndDate;
    private Date ircStartDate;
    private boolean isBundle;
    private boolean isContractProduct;
    private boolean isInActiveSku;
    private boolean lowPriceGuarantee;
    private boolean map;
    private boolean marketPlace;
    private double minimumDisplayPrice;
    private boolean onSale;
    private boolean onlineOnly;
    private String orderable;
    private boolean outletCenter;
    private double percentSavings;
    private double planPrice;
    private Date priceUpdateDate;
    private double priceWithPlan_newTwoYearPlan;
    private double priceWithPlan_upgradeTwoYearPlan;
    private boolean purchasable;
    private boolean refurbished;
    private double regularPrice;
    private double restrictedSalePrice;
    private double salePrice;
    private SellerInfo sellerInfo;
    private String skuId;
    private boolean smartCapable;
    private String url;

    public PriceBlock()
    {
        isInActiveSku = false;
        isContractProduct = false;
    }

    public static PriceBlock loadCBAPIPriceData(JSONObject jsonobject)
    {
        PriceBlock priceblock = new PriceBlock();
        if (!jsonobject.has("error")) goto _L2; else goto _L1
_L1:
        priceblock.isInActiveSku = true;
_L8:
        return priceblock;
_L2:
        Object obj;
        String s;
        JSONObject jsonobject1;
        try
        {
            priceblock.skuId = jsonobject.optString("skuId", "");
            jsonobject1 = jsonobject.optJSONObject("price");
            obj = jsonobject.optJSONObject("buttonState");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            gs.d(TAG, (new StringBuilder()).append("Error Parsing Price Block: ").append(jsonobject.getLocalizedMessage()).toString());
            return priceblock;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        priceblock.purchasable = ((JSONObject) (obj)).optBoolean("purchasable", false);
        priceblock.displayName = ((JSONObject) (obj)).optString("displayName", "");
        priceblock.buttonStateId = ((JSONObject) (obj)).optString("buttonStateID", "");
        priceblock.url = jsonobject.optString("url", "");
        obj = jsonobject.optJSONObject("properties");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj = ((JSONObject) (obj)).optString("contractCondition");
        if (((String) (obj)).equals("2_YEARS_NEW") || ((String) (obj)).equals("2_YEARS_UPGRADE"))
        {
            priceblock.isContractProduct = true;
        }
        obj = jsonobject.optJSONObject("attributes");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        priceblock.lowPriceGuarantee = ((JSONObject) (obj)).optBoolean("lowPriceGuaranteedProduct", false);
        obj = jsonobject.optString("condition");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        if (((String) (obj)).equals("refurbished"))
        {
            priceblock.refurbished = true;
        }
        obj = jsonobject.optJSONObject("sellerInfo");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        priceblock.sellerInfo = SellerInfo.getSellerInfo(((JSONObject) (obj)));
        if (jsonobject1 == null) goto _L4; else goto _L3
_L3:
        s = jsonobject1.optString("originalPricingType", "");
        obj = s;
        if (s.isEmpty())
        {
            obj = jsonobject1.optString("pricingType", "");
        }
        priceblock.minimumDisplayPrice = jsonobject1.optDouble("minimumPriceDisplay");
        priceblock.salePrice = jsonobject1.optDouble("currentPrice");
        priceblock.regularPrice = jsonobject1.optDouble("regularPrice");
        priceblock.dollarSavings = jsonobject1.optDouble("savingsAmount");
        if (!((String) (obj)).equals("MAP")) goto _L6; else goto _L5
_L5:
        priceblock.map = true;
_L4:
        if (jsonobject.optJSONObject("productOptions") == null) goto _L8; else goto _L7
_L7:
        obj = jsonobject.optJSONObject("productOptions").optJSONArray("alternateProducts");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_334;
        }
        priceblock.formatOptions = Product.AlternateSKU.loadAlternateSKUData(((JSONArray) (obj)));
        jsonobject = jsonobject.optJSONObject("productOptions").optJSONArray("contractOptions");
        if (jsonobject == null) goto _L8; else goto _L9
_L9:
        priceblock.contractOptions = Product.AlternateSKU.loadAlternateSKUData(jsonobject);
        return priceblock;
_L6:
label0:
        {
            if (!((String) (obj)).equals("onSale"))
            {
                break label0;
            }
            priceblock.onSale = true;
        }
          goto _L4
label1:
        {
            if (!((String) (obj)).equals("ICR-noPrice"))
            {
                break label1;
            }
            priceblock.icr_noPrice = true;
        }
          goto _L4
label2:
        {
            if (!((String) (obj)).equals("ICR-strikeThrough"))
            {
                break label2;
            }
            priceblock.icr_strike = true;
        }
          goto _L4
label3:
        {
            if (!((String) (obj)).equals("ICR-hidePrice"))
            {
                break label3;
            }
            priceblock.icr_hidePrice = true;
        }
          goto _L4
label4:
        {
            if (!((String) (obj)).equals("clearance"))
            {
                break label4;
            }
            priceblock.clearance = true;
        }
          goto _L4
label5:
        {
            if (!((String) (obj)).equals("bundle"))
            {
                break label5;
            }
            priceblock.isBundle = true;
        }
          goto _L4
        priceblock.map = false;
        priceblock.onSale = false;
        priceblock.icr_noPrice = false;
        priceblock.icr_noPrice = false;
        priceblock.isBundle = false;
          goto _L4
    }

    public static PriceBlock loadData(JSONObject jsonobject)
    {
        boolean flag1 = true;
        PriceBlock priceblock = new PriceBlock();
        Object obj;
        boolean flag;
        try
        {
            priceblock.onSale = jsonobject.optBoolean("onSale");
            priceblock.marketPlace = jsonobject.optBoolean("marketplace");
            priceblock.collection = jsonobject.optString("collection");
            priceblock.salePrice = jsonobject.optDouble("salePrice");
            priceblock.planPrice = jsonobject.optDouble("planPrice");
            priceblock.restrictedSalePrice = jsonobject.optDouble("restrictedSalePrice");
            priceblock.regularPrice = jsonobject.optDouble("regularPrice");
            priceblock.percentSavings = jsonobject.optDouble("percentSavings");
            obj = jsonobject.optString("priceUpdateDate");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            gs.d(TAG, (new StringBuilder()).append("Error Parsing Price Block: ").append(jsonobject.getLocalizedMessage()).toString());
            return priceblock;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (((String) (obj)).compareTo("null") != 0 && ((String) (obj)).compareTo("") != 0)
        {
            priceblock.priceUpdateDate = gv.c.parse(((String) (obj)));
        }
        obj = jsonobject.optString("icrStartDate");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (((String) (obj)).compareTo("null") != 0 && ((String) (obj)).compareTo("") != 0)
        {
            priceblock.ircStartDate = gv.a.parse(((String) (obj)));
        }
        obj = jsonobject.optString("icrEndDate");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        if (((String) (obj)).compareTo("null") != 0 && ((String) (obj)).compareTo("") != 0)
        {
            priceblock.ircEndDate = gv.a.parse(((String) (obj)));
        }
        priceblock.dollarSavings = jsonobject.optDouble("dollarSavings");
        obj = jsonobject.optJSONArray("priceWithPlan");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        if (((JSONArray) (obj)).length() > 0)
        {
            obj = ((JSONArray) (obj)).getJSONObject(0);
            priceblock.priceWithPlan_upgradeTwoYearPlan = ((JSONObject) (obj)).optDouble("upgradeTwoYearPlan");
            priceblock.priceWithPlan_newTwoYearPlan = ((JSONObject) (obj)).optDouble("newTwoYearPlan");
        }
        priceblock.outletCenter = jsonobject.optBoolean("outletCenter");
        priceblock.advertisedPriceRestriction = jsonobject.optBoolean("advertisedPriceRestriction");
        priceblock.orderable = jsonobject.optString("orderable");
        priceblock.lowPriceGuarantee = jsonobject.optBoolean("lowPriceGuarantee");
        priceblock.freeShipping = jsonobject.optBoolean("freeShipping");
        obj = jsonobject.optString("priceRestriction");
        jsonobject = jsonobject.optString("icrType");
        if (((String) (obj)).compareTo("MAP") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        priceblock.map = flag;
        if (((String) (obj)).compareTo("ICR") == 0 && jsonobject.compareTo("ST") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        priceblock.icr_strike = flag;
        if (((String) (obj)).compareTo("ICR") == 0 && jsonobject.compareTo("NP") == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        priceblock.icr_noPrice = flag;
        return priceblock;
    }

    public static PriceBlock loadPandaAPIPriceData(JSONObject jsonobject)
    {
        PriceBlock priceblock = new PriceBlock();
        priceblock.skuId = jsonobject.optString("skuId", "");
        if (!jsonobject.has("error"))
        {
            break MISSING_BLOCK_LABEL_36;
        }
        priceblock.isInActiveSku = true;
        return priceblock;
        String s;
        String s1;
        try
        {
            s1 = jsonobject.optString("originalPricingType", "");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            gs.d(TAG, (new StringBuilder()).append("Error Parsing Price Block: ").append(jsonobject.getLocalizedMessage()).toString());
            return priceblock;
        }
        s = s1;
        if (s1.isEmpty())
        {
            s = jsonobject.optString("pricingType", "");
        }
        priceblock.minimumDisplayPrice = jsonobject.optDouble("minimumPriceDisplay");
        priceblock.salePrice = jsonobject.optDouble("currentPrice");
        priceblock.regularPrice = jsonobject.optDouble("regularPrice");
        priceblock.dollarSavings = jsonobject.optDouble("savingsAmount");
        if (!s.equals("MAP"))
        {
            break MISSING_BLOCK_LABEL_150;
        }
        priceblock.map = true;
        return priceblock;
        if (!s.equals("onSale"))
        {
            break MISSING_BLOCK_LABEL_166;
        }
        priceblock.onSale = true;
        return priceblock;
        if (!s.equals("ICR-noPrice"))
        {
            break MISSING_BLOCK_LABEL_182;
        }
        priceblock.icr_noPrice = true;
        return priceblock;
        if (!s.equals("ICR-strikeThrough"))
        {
            break MISSING_BLOCK_LABEL_198;
        }
        priceblock.icr_strike = true;
        return priceblock;
        if (!s.equals("ICR-hidePrice"))
        {
            break MISSING_BLOCK_LABEL_214;
        }
        priceblock.icr_hidePrice = true;
        return priceblock;
        if (!s.equals("clearance"))
        {
            break MISSING_BLOCK_LABEL_230;
        }
        priceblock.clearance = true;
        return priceblock;
        if (!s.equals("bundle"))
        {
            break MISSING_BLOCK_LABEL_246;
        }
        priceblock.isBundle = true;
        return priceblock;
        priceblock.map = false;
        priceblock.onSale = false;
        priceblock.icr_noPrice = false;
        priceblock.icr_noPrice = false;
        priceblock.isBundle = false;
        return priceblock;
    }

    public String getButtonStateId()
    {
        return buttonStateId;
    }

    public String getCollection()
    {
        return collection;
    }

    public ArrayList getContractOptions()
    {
        return contractOptions;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public double getDollarSavings()
    {
        return dollarSavings;
    }

    public ArrayList getFormatOptions()
    {
        return formatOptions;
    }

    public Date getIrcEndDate()
    {
        return ircEndDate;
    }

    public Date getIrcStartDate()
    {
        return ircStartDate;
    }

    public double getMinimumDisplayPrice()
    {
        return minimumDisplayPrice;
    }

    public String getOrderable()
    {
        return orderable;
    }

    public double getPercentSavings()
    {
        return percentSavings;
    }

    public double getPlanPrice()
    {
        return planPrice;
    }

    public Date getPriceUpdateDate()
    {
        return priceUpdateDate;
    }

    public double getPriceWithPlan_newTwoYearPlan()
    {
        return priceWithPlan_newTwoYearPlan;
    }

    public double getPriceWithPlan_upgradeTwoYearPlan()
    {
        return priceWithPlan_upgradeTwoYearPlan;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }

    public double getRestrictedSalePrice()
    {
        return restrictedSalePrice;
    }

    public double getSalePrice()
    {
        return salePrice;
    }

    public SellerInfo getSellerInfo()
    {
        return sellerInfo;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isAdvertisedPriceRestriction()
    {
        return advertisedPriceRestriction;
    }

    public boolean isBundle()
    {
        return isBundle;
    }

    public boolean isClearance()
    {
        return clearance;
    }

    public boolean isContractProduct()
    {
        return isContractProduct;
    }

    public boolean isFreeShipping()
    {
        return freeShipping;
    }

    public boolean isIcr_hidePrice()
    {
        return icr_hidePrice;
    }

    public boolean isIcr_noPrice()
    {
        return icr_noPrice;
    }

    public boolean isIcr_strike()
    {
        return icr_strike;
    }

    public boolean isInActiveSku()
    {
        return isInActiveSku;
    }

    public boolean isLowPriceGuarantee()
    {
        return lowPriceGuarantee;
    }

    public boolean isMap()
    {
        return map;
    }

    public boolean isMarketPlace()
    {
        return marketPlace;
    }

    public boolean isOnSale()
    {
        return onSale;
    }

    public boolean isOnlineOnly()
    {
        return onlineOnly;
    }

    public boolean isOutletCenter()
    {
        return outletCenter;
    }

    public boolean isPurchasable()
    {
        return purchasable;
    }

    public boolean isRefurbished()
    {
        return refurbished;
    }

    public boolean isSmartCapable()
    {
        return smartCapable;
    }

    public void setDollarSavings(double d)
    {
        dollarSavings = d;
    }

    public void setRegularPrice(double d)
    {
        regularPrice = d;
    }

    public void setSalePrice(double d)
    {
        salePrice = d;
    }

}
