// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.apilevel;


public class Api
{

    public static boolean isAtLeastAPI(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public static boolean isAtLeastJellyBean()
    {
        return isAtLeastAPI(16);
    }

    public static boolean isAtLeastJellyBeanMR1()
    {
        return isAtLeastAPI(17);
    }

    public static boolean isAtLeastJellyBeanMR2()
    {
        return isAtLeastAPI(18);
    }

    public static boolean isAtLeastKitkat()
    {
        return isAtLeastAPI(19);
    }

    public static boolean isAtLeastLollipop()
    {
        return isAtLeastAPI(21);
    }

    public static boolean isAtLeastMarshmallow()
    {
        return isAtLeastAPI(23);
    }
}
