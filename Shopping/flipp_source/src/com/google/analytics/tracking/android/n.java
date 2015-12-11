// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.util.Log;

// Referenced classes of package com.google.analytics.tracking.android:
//            ao, ap

final class n
    implements ao
{

    private ap a;

    n()
    {
        a = ap.b;
    }

    private static String e(String s)
    {
        return (new StringBuilder()).append(Thread.currentThread().toString()).append(": ").append(s).toString();
    }

    public final ap a()
    {
        return a;
    }

    public final void a(String s)
    {
        if (a.ordinal() <= ap.a.ordinal())
        {
            Log.v("GAV3", e(s));
        }
    }

    public final void b(String s)
    {
        if (a.ordinal() <= ap.b.ordinal())
        {
            Log.i("GAV3", e(s));
        }
    }

    public final void c(String s)
    {
        if (a.ordinal() <= ap.c.ordinal())
        {
            Log.w("GAV3", e(s));
        }
    }

    public final void d(String s)
    {
        if (a.ordinal() <= ap.d.ordinal())
        {
            Log.e("GAV3", e(s));
        }
    }
}
