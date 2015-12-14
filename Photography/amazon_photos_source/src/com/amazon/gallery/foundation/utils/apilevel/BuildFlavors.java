// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.apilevel;


public final class BuildFlavors
{

    public static boolean isAosp()
    {
        return "aosp".contains("aosp");
    }

    public static boolean isDebug()
    {
        return "release".equals("debug");
    }

    public static boolean isDuke()
    {
        return "aosp".equals("duke");
    }

    public static boolean isFireOS4OrLater()
    {
        return isFos4() || isFos5();
    }

    public static boolean isFireOS4OrOlder()
    {
        return isFos4() || isGen5();
    }

    public static boolean isFos4()
    {
        return "aosp".equals("fos4");
    }

    public static boolean isFos5()
    {
        return "aosp".equals("fos5");
    }

    public static boolean isGen5()
    {
        return "aosp".equals("gen5");
    }
}
