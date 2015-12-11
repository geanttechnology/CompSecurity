// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.util.Log;

public final class y
{

    public y()
    {
    }

    public static transient String a(String s, Object aobj[])
    {
        if (aobj == null || aobj.length == 0)
        {
            return s;
        }
        try
        {
            aobj = String.format(s, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            ((Throwable) (aobj)).printStackTrace();
            return s;
        }
        return ((String) (aobj));
    }

    public static transient void a(Throwable throwable, String s, Object aobj[])
    {
        Log.e("RhythmSDK", a(s, aobj), throwable);
    }

    public static transient void b(String s, Object aobj[])
    {
        Log.e("RhythmSDK", a(s, aobj));
    }

    public static transient void b(Throwable throwable, String s, Object aobj[])
    {
        Log.w("RhythmSDK", a(s, aobj), throwable);
    }

    public static transient void c(String s, Object aobj[])
    {
        Log.w("RhythmSDK", a(s, aobj));
    }

    public static transient void d(String s, Object aobj[])
    {
        Log.i("RhythmSDK", a(s, aobj));
    }
}
