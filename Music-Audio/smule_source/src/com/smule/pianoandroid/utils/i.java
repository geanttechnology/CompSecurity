// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import com.smule.android.network.models.ListingV2;

public class i
{

    public static String a = "desiredListing";
    public static String b = "desiredListingIsJoin";
    private static i c;
    private ListingV2 d;
    private boolean e;
    private boolean f;

    private i()
    {
        e = false;
        f = false;
    }

    public static i d()
    {
        com/smule/pianoandroid/utils/i;
        JVM INSTR monitorenter ;
        i j;
        if (c == null)
        {
            c = new i();
        }
        j = c;
        com/smule/pianoandroid/utils/i;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    public ListingV2 a()
    {
        return d;
    }

    public void a(ListingV2 listingv2, boolean flag)
    {
        d = listingv2;
        e = flag;
    }

    public void a(boolean flag)
    {
        f = flag;
    }

    public boolean b()
    {
        return d != null && d.b() && e;
    }

    public boolean c()
    {
        return f;
    }

}
