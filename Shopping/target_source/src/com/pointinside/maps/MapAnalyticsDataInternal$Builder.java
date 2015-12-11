// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            MapAnalyticsDataInternal

static final class  extends com.pointinside.analytics.
{

    private String imageType;
    private String referrer;
    private String storeId;
    private String venue;
    private String zone;

    public MapAnalyticsDataInternal build()
    {
        return new MapAnalyticsDataInternal(this, null);
    }

    public volatile com.pointinside.analytics. getThis()
    {
        return getThis();
    }

    public getThis getThis()
    {
        return this;
    }

    public getThis imageType(String s)
    {
        imageType = s;
        return this;
    }

    public imageType referrer(String s)
    {
        referrer = s;
        return this;
    }

    public referrer storeID(String s)
    {
        storeId = s;
        return this;
    }

    public storeId venueUUID(String s)
    {
        venue = s;
        return this;
    }

    public venue zoneUUID(String s)
    {
        zone = s;
        return this;
    }






    public ()
    {
    }
}
