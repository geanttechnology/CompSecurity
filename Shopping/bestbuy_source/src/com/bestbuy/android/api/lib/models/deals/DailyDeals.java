// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.deals;

import gs;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.deals:
//            Deal

public class DailyDeals
{

    private static final String TAG = com/bestbuy/android/api/lib/models/deals/DailyDeals.getSimpleName();
    private ArrayList dealArray;
    private Date dealDate;
    private ArrayList dealSkuArray;
    private String dealsDetailLink;
    private Date dotdEndTime;
    private String dotdStatus;
    private boolean isMultipleDeals;
    private int numberOfDeals;
    private Date urlDate;

    public DailyDeals()
    {
    }

    public static DailyDeals loadData(JSONObject jsonobject)
    {
        DailyDeals dailydeals;
        dailydeals = new DailyDeals();
        Object obj = jsonobject.optString("dotdEndTime");
        int i;
        int j;
        int k;
        try
        {
            dailydeals.dotdEndTime = (new SimpleDateFormat("yyyy,MM,dd,hh,mm,sss", Locale.getDefault())).parse(((String) (obj)));
        }
        catch (Exception exception)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse date, skipping: ").append(exception.getLocalizedMessage()).toString());
        }
        obj = jsonobject.optString("deal_date");
        try
        {
            dailydeals.dealDate = (new SimpleDateFormat("MMM d", Locale.getDefault())).parse(((String) (obj)));
        }
        catch (Exception exception1)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse date, skipping: ").append(exception1.getLocalizedMessage()).toString());
        }
        obj = jsonobject.optString("urlDate");
        try
        {
            dailydeals.urlDate = (new SimpleDateFormat("yyyyMMdd", Locale.getDefault())).parse(((String) (obj)));
        }
        catch (Exception exception2)
        {
            gs.d(TAG, (new StringBuilder()).append("Could not parse date, skipping: ").append(exception2.getLocalizedMessage()).toString());
        }
        dailydeals.isMultipleDeals = jsonobject.optBoolean("isMultipleDeals");
        dailydeals.numberOfDeals = jsonobject.optInt("number_of_deals");
        dailydeals.dotdStatus = jsonobject.optString("dotdStatus");
        jsonobject = jsonobject.getJSONArray("deals");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_452;
        }
        if (jsonobject.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_452;
        }
        dailydeals.dealSkuArray = new ArrayList(dailydeals.numberOfDeals + 1);
        dailydeals.dealArray = new ArrayList();
        i = 0;
_L1:
        j = jsonobject.length();
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_452;
        }
        obj = jsonobject.getJSONObject(i).optJSONObject("deal").optString("deal_detail_link");
        j = Integer.parseInt(((String) (obj)).substring(((String) (obj)).lastIndexOf("/") + 1, ((String) (obj)).length()));
        obj = Deal.loadDealData(jsonobject.getJSONObject(i).optJSONObject("deal"));
        dailydeals.dealArray.add(obj);
        k = j - 1;
        j = k;
        if (k > dailydeals.dealSkuArray.size())
        {
            j = i;
        }
        dailydeals.dealSkuArray.add(j, jsonobject.getJSONObject(i).optJSONObject("deal").optString("sku"));
_L2:
        i++;
          goto _L1
        Exception exception3;
        exception3;
        gs.d(TAG, (new StringBuilder()).append("Could not parse a single deal in DailyDeals, skipping: ").append(exception3.getLocalizedMessage()).toString());
          goto _L2
        jsonobject;
        gs.e(TAG, (new StringBuilder()).append("Could not parse Deals for DailyDeals: ").append(jsonobject.getLocalizedMessage()).toString());
        return dailydeals;
    }

    public ArrayList getDealArray()
    {
        return dealArray;
    }

    public Date getDealDate()
    {
        return dealDate;
    }

    public ArrayList getDealSkuArray()
    {
        return dealSkuArray;
    }

    public String getDealsDetailLink()
    {
        return dealsDetailLink;
    }

    public Date getDotdEndTime()
    {
        return dotdEndTime;
    }

    public String getDotdStatus()
    {
        return dotdStatus;
    }

    public int getNumberOfDeals()
    {
        return numberOfDeals;
    }

    public Date getUrlDate()
    {
        return urlDate;
    }

    public boolean isMultipleDeals()
    {
        return isMultipleDeals;
    }

    public void setDealArray(ArrayList arraylist)
    {
        dealArray = arraylist;
    }

    public void setDealsDetailLink(String s)
    {
        dealsDetailLink = s;
    }

}
