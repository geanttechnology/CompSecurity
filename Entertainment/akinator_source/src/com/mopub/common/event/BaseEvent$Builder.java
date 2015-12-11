// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import com.mopub.common.Preconditions;

// Referenced classes of package com.mopub.common.event:
//            BaseEvent

public static abstract class mSamplingRate
{

    private String mAdCreativeId;
    private Double mAdHeightPx;
    private String mAdNetworkType;
    private String mAdType;
    private String mAdUnitId;
    private Double mAdWidthPx;
    private  mCategory;
    private Double mGeoAccuracy;
    private Double mGeoLat;
    private Double mGeoLon;
    private  mName;
    private Double mPerformanceDurationMs;
    private String mRequestId;
    private Integer mRequestRetries;
    private Integer mRequestStatusCode;
    private String mRequestUri;
    private double mSamplingRate;
    private tegory mScribeCategory;
    private ct mSdkProduct;

    public abstract BaseEvent build();

    public mSamplingRate withAdCreativeId(String s)
    {
        mAdCreativeId = s;
        return this;
    }

    public mAdCreativeId withAdHeightPx(Double double1)
    {
        mAdHeightPx = double1;
        return this;
    }

    public mAdHeightPx withAdNetworkType(String s)
    {
        mAdNetworkType = s;
        return this;
    }

    public mAdNetworkType withAdType(String s)
    {
        mAdType = s;
        return this;
    }

    public mAdType withAdUnitId(String s)
    {
        mAdUnitId = s;
        return this;
    }

    public mAdUnitId withAdWidthPx(Double double1)
    {
        mAdWidthPx = double1;
        return this;
    }

    public mAdWidthPx withGeoAccuracy(Double double1)
    {
        mGeoAccuracy = double1;
        return this;
    }

    public mGeoAccuracy withGeoLat(Double double1)
    {
        mGeoLat = double1;
        return this;
    }

    public mGeoLat withGeoLon(Double double1)
    {
        mGeoLon = double1;
        return this;
    }

    public mGeoLon withPerformanceDurationMs(Double double1)
    {
        mPerformanceDurationMs = double1;
        return this;
    }

    public mPerformanceDurationMs withRequestId(String s)
    {
        mRequestId = s;
        return this;
    }

    public mRequestId withRequestRetries(Integer integer)
    {
        mRequestRetries = integer;
        return this;
    }

    public mRequestRetries withRequestStatusCode(Integer integer)
    {
        mRequestStatusCode = integer;
        return this;
    }

    public mRequestStatusCode withRequestUri(String s)
    {
        mRequestUri = s;
        return this;
    }

    public ct withSdkProduct(ct ct)
    {
        mSdkProduct = ct;
        return this;
    }




















    public (tegory tegory, tegory tegory1,  , double d)
    {
        Preconditions.checkNotNull(tegory);
        Preconditions.checkNotNull(tegory1);
        Preconditions.checkNotNull();
        boolean flag;
        if (d >= 0.0D && d <= 1.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mScribeCategory = tegory;
        mName = tegory1;
        mCategory = ;
        mSamplingRate = d;
    }
}
