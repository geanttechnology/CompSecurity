// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import com.amazon.identity.auth.device.api.MAPInit;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class UnitTestUtils
{

    private static final boolean IS_RUNNING_IN_UNIT_TEST = generateIsRunningInUnitTest();
    private static final String TAG = com/amazon/identity/auth/device/utils/UnitTestUtils.getName();

    private UnitTestUtils()
    {
    }

    private static boolean generateIsRunningInUnitTest()
    {
        try
        {
            Class.forName("android.test.mock.MockContext");
            Class.forName("com.amazon.identity.auth.unittest.IsRunningInUnitTest");
            MAPLog.e(TAG, "Is running in unit test!");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    public static boolean isRunningInUnitTest()
    {
        return IS_RUNNING_IN_UNIT_TEST && !MAPInit.isRunningInFunctionalTest();
    }

}
