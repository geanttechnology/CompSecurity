// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.content.Context;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.auth.device.utils.TimeUtil;
import java.util.concurrent.TimeUnit;

public class ServerRegistrationSyncHelper
{

    private static final long DURATION_TO_CHECK_REGISTRATION;
    private final LocalAppDataAwareDataStorage mLocalAppDataAwareDataStorage;
    private final PlatformWrapper mPlatformWrapper;

    public ServerRegistrationSyncHelper(Context context, LocalAppDataAwareDataStorage localappdataawaredatastorage)
    {
        mPlatformWrapper = (PlatformWrapper)ServiceWrappingContext.create(context).getSystemService("sso_platform");
        mLocalAppDataAwareDataStorage = localappdataawaredatastorage;
    }

    public Long getRegistrationCheckTime(String s)
    {
        s = mLocalAppDataAwareDataStorage.getUserData(s, "3PLastRegistrationCheckTimeKey");
        if (s == null)
        {
            return null;
        } else
        {
            return StringConversionHelpers.toLong(s);
        }
    }

    public void recordRegistrationCheckTime(String s)
    {
        mLocalAppDataAwareDataStorage.setUserData(s, "3PLastRegistrationCheckTimeKey", Long.toString(System.currentTimeMillis()));
    }

    public boolean shouldDoRegistrationCheck(String s)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = mPlatformWrapper.isAmazonDevice();
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        s = getRegistrationCheckTime(s);
        if (s == null)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        long l;
        long l1;
        long l2;
        l = System.currentTimeMillis();
        l1 = s.longValue();
        l2 = DURATION_TO_CHECK_REGISTRATION;
        if (l - l1 >= l2)
        {
            flag = true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    static 
    {
        DURATION_TO_CHECK_REGISTRATION = TimeUtil.fromHoursTo(1L, TimeUnit.MILLISECONDS);
    }
}
