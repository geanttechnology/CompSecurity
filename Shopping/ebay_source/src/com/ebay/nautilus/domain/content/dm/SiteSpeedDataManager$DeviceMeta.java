// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SiteSpeedDataManager

public static class memorySize
{

    public final String appVersion;
    public final String deviceModel;
    public final String memorySize;
    public final String osType;
    public final String osVersion;
    public final String trackingId;

    public String toString()
    {
        return (new StringBuilder()).append("DeviceMeta [trackingId=").append(trackingId).append(", deviceModel=").append(deviceModel).append(", osType=").append(osType).append(", osVersion=").append(osVersion).append(", appVersion=").append(appVersion).append(", memorySize=").append(memorySize).append("]").toString();
    }

    public I(String s, String s1, String s2, String s3, String s4, String s5)
    {
        trackingId = s;
        deviceModel = s1;
        osType = s2;
        osVersion = s3;
        appVersion = s4;
        memorySize = s5;
    }
}
