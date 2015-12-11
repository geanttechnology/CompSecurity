// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android;

import android.content.Context;

// Referenced classes of package com.shazam.android:
//            d, ShazamApplication

public final class e
    implements d
{

    private static ShazamApplication a;

    public e()
    {
    }

    private static void c()
    {
        if (a == null)
        {
            throw new RuntimeException("ShazamApplication Reference is NOT set");
        } else
        {
            return;
        }
    }

    public final ShazamApplication a()
    {
        c();
        return a;
    }

    public final void a(ShazamApplication shazamapplication)
    {
        this;
        JVM INSTR monitorenter ;
        a = shazamapplication;
        this;
        JVM INSTR monitorexit ;
        return;
        shazamapplication;
        throw shazamapplication;
    }

    public final Context b()
    {
        this;
        JVM INSTR monitorenter ;
        Context context;
        c();
        context = a.getApplicationContext();
        this;
        JVM INSTR monitorexit ;
        return context;
        Exception exception;
        exception;
        throw exception;
    }
}
