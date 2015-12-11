// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.GrouponSafeAsyncTask;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.activity:
//            Carousel

private class geoPoint extends GrouponSafeAsyncTask
{

    private final GeoPoint geoPoint;
    final Carousel this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public String call()
        throws Exception
    {
        return ((DivisionUtil)Carousel.access$2200(Carousel.this).get()).getCityNameFromGeoPoint(geoPoint);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((String)obj);
    }

    protected void onSuccess(String s)
        throws Exception
    {
        Carousel.access$2300(Carousel.this, geoPoint, s);
    }

    public (GeoPoint geopoint)
    {
        this$0 = Carousel.this;
        super();
        geoPoint = geopoint;
    }
}
