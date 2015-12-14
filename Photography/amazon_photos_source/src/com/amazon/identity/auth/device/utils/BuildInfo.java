// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


public final class BuildInfo
{

    private static final String TAG = com/amazon/identity/auth/device/utils/BuildInfo.getName();
    private static BuildInfo sBuildInfo;
    public final String mBrazilVersion;
    public final int mMajorVersion = 13;
    public final int mMapSWVersion;
    public final int mMinorVersion = 50002;

    public BuildInfo(String s)
    {
        mBrazilVersion = s;
        mMapSWVersion = 0x989680 * mMajorVersion + mMinorVersion;
    }

    public static BuildInfo getBuildInfo()
    {
        com/amazon/identity/auth/device/utils/BuildInfo;
        JVM INSTR monitorenter ;
        if (sBuildInfo == null) goto _L2; else goto _L1
_L1:
        BuildInfo buildinfo = sBuildInfo;
_L4:
        com/amazon/identity/auth/device/utils/BuildInfo;
        JVM INSTR monitorexit ;
        return buildinfo;
_L2:
        buildinfo = new BuildInfo("MAPAndroidLib-1.0.1136.1");
        sBuildInfo = buildinfo;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static String getMAPSWVersion()
    {
        return String.valueOf(getBuildInfo().mMapSWVersion);
    }

    public String toString()
    {
        return (new StringBuilder()).append(mMapSWVersion).append(" / ").append(mBrazilVersion).toString();
    }

}
