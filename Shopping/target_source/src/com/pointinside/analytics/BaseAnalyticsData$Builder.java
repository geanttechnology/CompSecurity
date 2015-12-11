// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;

import android.location.Location;

// Referenced classes of package com.pointinside.analytics:
//            BaseAnalyticsData

protected static abstract class lng
{

    private Float accuracy;
    private String custData;
    private Long datetime;
    private Double lat;
    private Double lng;
    private String proximity;
    private Long userLocTime;

    public lng custData(String s)
    {
        custData = s;
        return getThis();
    }

    public getThis datetime(long l)
    {
        datetime = Long.valueOf(l);
        return getThis();
    }

    protected abstract getThis getThis();

    public getThis location(Location location1)
    {
        if (location1 != null)
        {
            lat = Double.valueOf(location1.getLatitude());
            lng = Double.valueOf(location1.getLongitude());
            userLocTime = Long.valueOf(location1.getTime());
            accuracy = Float.valueOf(location1.getAccuracy());
        }
        return getThis();
    }

    public getThis proximity(String s)
    {
        proximity = s;
        return getThis();
    }








    public _cls9()
    {
        datetime = null;
        userLocTime = null;
        custData = null;
        proximity = null;
        accuracy = null;
        lat = null;
        lng = null;
    }
}
