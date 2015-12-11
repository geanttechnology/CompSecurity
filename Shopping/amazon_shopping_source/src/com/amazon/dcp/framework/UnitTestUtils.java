// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.framework;


public final class UnitTestUtils
{

    private UnitTestUtils()
    {
    }

    public static boolean isRunningInUnitTest()
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
}
