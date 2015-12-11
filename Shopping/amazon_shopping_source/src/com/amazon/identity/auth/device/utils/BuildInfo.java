// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.lang.reflect.Field;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class BuildInfo
{

    private static final String TAG = com/amazon/identity/auth/device/utils/BuildInfo.getName();
    private static BuildInfo sBuildInfo;
    public final String mBrazilVersion;
    public final int mMajorVersion;
    public final int mMapSWVersion;
    public final int mMinorVersion;

    public BuildInfo(int i, int j, String s)
    {
        mMajorVersion = i;
        mMinorVersion = j;
        mBrazilVersion = s;
        mMapSWVersion = 0x989680 * mMajorVersion + mMinorVersion;
    }

    public static BuildInfo getBuildInfo()
    {
        com/amazon/identity/auth/device/utils/BuildInfo;
        JVM INSTR monitorenter ;
        if (sBuildInfo == null) goto _L2; else goto _L1
_L1:
        Object obj = sBuildInfo;
_L4:
        com/amazon/identity/auth/device/utils/BuildInfo;
        JVM INSTR monitorexit ;
        return ((BuildInfo) (obj));
_L2:
        obj = null;
        Object obj2;
        obj2 = Class.forName("com.amazon.identity.auth.device.utils.JarVersionInfo").getDeclaredField("JAR_BRAZIL_VERSION");
        ((Field) (obj2)).setAccessible(true);
        obj2 = (String)((Field) (obj2)).get(null);
        obj = obj2;
_L5:
        obj = new BuildInfo(13, 50001, ((String) (obj)));
        sBuildInfo = ((BuildInfo) (obj));
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        throw obj1;
        Object obj3;
        obj3;
        MAPLog.i(TAG, "No JarVersionInfo class. This is most likely because this was a local developer build");
          goto _L5
        obj1;
        MAPLog.e(TAG, "No field for getting jar version. This is a programatic error. If you are using proguard please make sure you are not stripping this class out by looking at the onboarding guide.");
        throw new RuntimeException(((Throwable) (obj1)));
        obj3;
        MAPLog.e(TAG, "Unexpected exception prevents getting jar version", ((Throwable) (obj3)));
          goto _L5
    }

    public String toString()
    {
        return (new StringBuilder()).append(mMapSWVersion).append(" / ").append(mBrazilVersion).toString();
    }

}
