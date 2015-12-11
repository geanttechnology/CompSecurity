// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SiteSpeedDataManager

public static class portrait
{

    public final String carrier;
    public String deviceId;
    public final String mobileNetworkType;
    public final String networkType;
    public final boolean portrait;
    public final String preferredLanguage;
    public final int rolloutThreshold;
    public final String screenRes;

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("SiteSpeedMeta [carrier=").append(carrier).append(", networkType=").append(networkType).append(", mobileNetworkType=").append(mobileNetworkType).append(", preferredLanguage=").append(preferredLanguage).append(", deviceId=").append(deviceId).append(", rolloutThreshold=").append(rolloutThreshold).append(", screenRes=").append(screenRes).append("]").toString();
    }

    public (String s, String s1, String s2, String s3, int i, String s4, boolean flag)
    {
        carrier = s;
        networkType = s1;
        mobileNetworkType = s2;
        preferredLanguage = s3;
        rolloutThreshold = i;
        screenRes = s4;
        portrait = flag;
    }
}
