// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;


// Referenced classes of package com.pointinside.analytics:
//            GeneralAnalyticsData

public static final class storeId extends storeId
{

    private String genericType;
    private String storeId;
    private String venue;

    public GeneralAnalyticsData build()
    {
        return new GeneralAnalyticsData(this, null);
    }

    public storeId genericType(String s)
    {
        genericType = s;
        return this;
    }

    protected volatile genericType getThis()
    {
        return getThis();
    }

    protected getThis getThis()
    {
        return this;
    }

    public getThis storeId(String s)
    {
        storeId = s;
        return this;
    }

    public storeId venue(String s)
    {
        venue = s;
        return this;
    }




    public ()
    {
        genericType = null;
        venue = null;
        storeId = null;
    }
}
