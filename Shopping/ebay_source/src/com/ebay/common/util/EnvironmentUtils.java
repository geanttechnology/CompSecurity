// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;


public class EnvironmentUtils
{

    public EnvironmentUtils()
    {
    }

    public static boolean isBlackberry()
    {
        return System.getProperty("os.name").equals("qnx");
    }

    public static boolean isNativeModuleSupportEnabled()
    {
        return !isBlackberry();
    }
}
