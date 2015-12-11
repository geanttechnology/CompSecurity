// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby.pricewatch;

import gs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PriceWatch
{

    private static final String TAG = com/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch.getSimpleName();
    private double curPrice;
    private boolean enablePriceReaches;
    private boolean isPriceDropSel;
    private boolean isPriceReachSel;
    private double orgPrice;
    private String prodImgURL;
    private String prodName;
    private String prodURL;
    private double setPrice;
    private String sku;

    public PriceWatch()
    {
    }

    public static PriceWatch loadData(JSONObject jsonobject)
    {
        PriceWatch pricewatch;
        pricewatch = new PriceWatch();
        pricewatch.sku = jsonobject.optString("item_id");
        Object obj;
        JSONArray jsonarray;
        int i;
        obj = jsonobject.getJSONObject("product_info");
        pricewatch.prodName = ((JSONObject) (obj)).optString("product_name");
        pricewatch.prodImgURL = ((JSONObject) (obj)).optString("image_link");
        pricewatch.prodURL = ((JSONObject) (obj)).optString("pdp_link");
        pricewatch.setPrice = ((JSONObject) (obj)).optDouble("watch_for_price");
        pricewatch.orgPrice = ((JSONObject) (obj)).optDouble("reg_price");
        if (!jsonobject.has("priceWithPlan"))
        {
            break MISSING_BLOCK_LABEL_197;
        }
        jsonarray = ((JSONObject) (obj)).optJSONArray("priceWithPlan");
        i = jsonarray.length();
        if (i <= 1) goto _L2; else goto _L1
_L1:
        pricewatch.curPrice = jsonarray.getJSONObject(0).optDouble("newTwoYearPlan");
_L3:
        try
        {
            pricewatch.enablePriceReaches = false;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw jsonobject;
        }
_L4:
        pricewatch.isPriceDropSel = jsonobject.optBoolean("watch_for_drop");
        pricewatch.isPriceReachSel = jsonobject.optBoolean("watch_for_price");
        return pricewatch;
        obj;
        gs.e(TAG, (new StringBuilder()).append("Could not parse current price for price watch JSON object: ").append(((JSONException) (obj)).getLocalizedMessage()).toString());
          goto _L3
_L2:
        pricewatch.curPrice = ((JSONObject) (obj)).optDouble("current_price");
        pricewatch.enablePriceReaches = true;
          goto _L4
        pricewatch.curPrice = ((JSONObject) (obj)).optDouble("current_price");
        pricewatch.enablePriceReaches = true;
          goto _L4
    }

    public double getCurPrice()
    {
        return curPrice;
    }

    public double getOrgPrice()
    {
        return orgPrice;
    }

    public String getProdImgURL()
    {
        return prodImgURL;
    }

    public String getProdName()
    {
        return prodName;
    }

    public String getProdURL()
    {
        return prodURL;
    }

    public double getSetPrice()
    {
        return setPrice;
    }

    public String getSku()
    {
        return sku;
    }

    public boolean isEnablePriceReaches()
    {
        return enablePriceReaches;
    }

    public boolean isPriceDropSel()
    {
        return isPriceDropSel;
    }

    public boolean isPriceReachSel()
    {
        return isPriceReachSel;
    }

}
