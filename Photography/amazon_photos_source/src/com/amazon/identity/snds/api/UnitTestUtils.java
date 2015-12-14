// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;


public final class UnitTestUtils
{

    private static final boolean IS_RUNNING_IN_UNIT_TEST = generateIsRunningInUnitTest();

    private static boolean generateIsRunningInUnitTest()
    {
        try
        {
            Class.forName("android.test.mock.MockContext");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    public static boolean isRunningInUnitTest()
    {
        return IS_RUNNING_IN_UNIT_TEST;
    }

}
