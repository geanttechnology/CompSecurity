// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Build;

public final class dz
{

    public static String a = "Android";
    public static String b = "mobile";
    public static String c;
    public static String d;

    static 
    {
        c = android.os.Build.VERSION.RELEASE;
        d = Build.MODEL;
    }
}
