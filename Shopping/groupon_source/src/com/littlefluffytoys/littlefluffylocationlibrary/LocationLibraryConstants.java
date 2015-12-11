// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;


public class LocationLibraryConstants
{

    protected static boolean SUPPORTS_FROYO;
    protected static boolean SUPPORTS_GINGERBREAD;
    protected static boolean SUPPORTS_JELLYBEAN_4_2;

    static 
    {
        boolean flag1 = true;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SUPPORTS_FROYO = flag;
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SUPPORTS_GINGERBREAD = flag;
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        SUPPORTS_JELLYBEAN_4_2 = flag;
    }
}
