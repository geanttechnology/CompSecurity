// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import org.json.JSONObject;

public class Points
{

    private boolean isElite;
    private boolean isElitePlus;
    private String memberTier;
    private String pendingPoints;
    private String pointsBalance;
    private String pointsLastUpdDate;
    private String statusDisplay;
    private String targetSpend;
    private String yeartoDateDollarSpend;

    public Points()
    {
        isElitePlus = false;
        isElite = false;
    }

    public static Points loadData(JSONObject jsonobject)
    {
        Points points = new Points();
        points.pendingPoints = jsonobject.optString("pendingPoints");
        points.pointsBalance = jsonobject.optString("pointsBalance");
        points.pointsLastUpdDate = jsonobject.optString("pointsLastUpdDate");
        points.targetSpend = jsonobject.optString("targetSpend");
        points.yeartoDateDollarSpend = jsonobject.optString("yeartoDateDollarSpend");
        points.memberTier = jsonobject.optString("memberTier");
        points.setElite();
        points.setElitePlus();
        points.setStatusDisplay();
        return points;
    }

    public String getMemberTier()
    {
        return memberTier;
    }

    public String getPendingPoints()
    {
        return pendingPoints;
    }

    public String getPointsBalance()
    {
        return pointsBalance;
    }

    public String getPointsLastUpdDate()
    {
        return pointsLastUpdDate;
    }

    public String getStatusDisplay()
    {
        return statusDisplay;
    }

    public String getTargetSpend()
    {
        return targetSpend;
    }

    public String getYeartoDateDollarSpend()
    {
        return yeartoDateDollarSpend;
    }

    public boolean isElite()
    {
        return isElite;
    }

    public boolean isElitePlus()
    {
        return isElitePlus;
    }

    public void setElite()
    {
        if (memberTier != null && memberTier.equals("10067"))
        {
            isElite = true;
            return;
        } else
        {
            isElite = false;
            return;
        }
    }

    public void setElitePlus()
    {
        if (memberTier != null && memberTier.equals("10150"))
        {
            isElitePlus = true;
            return;
        } else
        {
            isElitePlus = false;
            return;
        }
    }

    public void setStatusDisplay()
    {
        if (isElitePlus)
        {
            statusDisplay = "eliteplus";
        }
        if (isElite)
        {
            statusDisplay = "elite";
            return;
        } else
        {
            statusDisplay = "mybestbuy";
            return;
        }
    }
}
