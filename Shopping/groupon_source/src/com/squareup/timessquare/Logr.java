// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import android.util.Log;

final class Logr
{

    public static void d(String s)
    {
        Log.d("TimesSquare", s);
    }

    public static transient void d(String s, Object aobj[])
    {
        d(String.format(s, aobj));
    }
}
