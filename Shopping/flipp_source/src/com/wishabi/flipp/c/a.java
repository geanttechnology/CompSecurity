// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.c;

import android.os.Trace;

public final class a
{

    public static void a()
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            Trace.endSection();
        }
    }

    public static void a(String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            Trace.beginSection(s);
        }
    }
}
