// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import android.util.Log;
import bm;

public final class e extends bm
{

    private String a;

    public e(Class class1)
    {
        a = class1.getSimpleName();
    }

    public final void a(Object obj)
    {
        Log.v("NMSP_", (new StringBuilder("[")).append(a).append("] ").append(obj.toString()).toString());
    }

    public final void a(Object obj, Throwable throwable)
    {
        throwable.printStackTrace();
        Log.e("NMSP", (new StringBuilder("[")).append(a).append("] ").append(obj.toString()).toString(), throwable);
    }

    public final boolean a()
    {
        return Log.isLoggable("NMSP_", 2);
    }

    public final void b(Object obj)
    {
        Log.d("NMSP_", (new StringBuilder("[")).append(a).append("] ").append(obj.toString()).toString());
    }

    public final boolean b()
    {
        return Log.isLoggable("NMSP_", 3);
    }

    public final void c(Object obj)
    {
        Log.i("NMSP", (new StringBuilder("[")).append(a).append("] ").append(obj.toString()).toString());
    }

    public final boolean c()
    {
        return Log.isLoggable("NMSP", 4);
    }

    public final void d(Object obj)
    {
        Log.w("NMSP", (new StringBuilder("[")).append(a).append("] ").append(obj.toString()).toString());
    }

    public final boolean d()
    {
        return Log.isLoggable("NMSP", 5);
    }

    public final void e(Object obj)
    {
        Log.e("NMSP", (new StringBuilder("[")).append(a).append("] ").append(obj.toString()).toString());
    }

    public final boolean e()
    {
        return Log.isLoggable("NMSP", 6);
    }

    public final void f()
    {
    }

    public final void g()
    {
    }
}
