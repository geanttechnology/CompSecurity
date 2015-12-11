// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class k
{
    private class a
        implements Runnable
    {

        final k a;

        public void run()
        {
            synchronized (k.a(a))
            {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage("com.google.android.gms");
                intent.putStringArrayListExtra("PLACE_IDS", com.google.android.gms.location.places.internal.k.b(a));
                intent.putStringArrayListExtra("METHOD_NAMES", k.c(a));
                intent.putExtra("PACKAGE_NAME", k.d(a).getPackageName());
                intent.putExtra("CLIENT_VERSION", b.a);
                k.d(a).sendBroadcast(intent);
                k.a(a, null);
                com.google.android.gms.location.places.internal.k.b(a, null);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private a()
        {
            a = k.this;
            super();
        }

    }


    private static final String a = com/google/android/gms/location/places/internal/k.getSimpleName();
    private static final long b;
    private static k c;
    private final Context d;
    private final Handler e;
    private final Runnable f;
    private final Object g;
    private ArrayList h;
    private ArrayList i;

    private k(Context context)
    {
        this((Context)x.a(context), new Handler(Looper.getMainLooper()));
    }

    k(Context context, Handler handler)
    {
        f = new a();
        g = new Object();
        h = null;
        i = null;
        d = context;
        e = handler;
    }

    public static k a(Context context)
    {
        com/google/android/gms/location/places/internal/k;
        JVM INSTR monitorenter ;
        int j;
        x.a(context);
        j = android.os.Build.VERSION.SDK_INT;
        if (j >= 14) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/google/android/gms/location/places/internal/k;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (c == null)
        {
            c = new k(context.getApplicationContext());
        }
        context = c;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    static Object a(k k1)
    {
        return k1.g;
    }

    static ArrayList a(k k1, ArrayList arraylist)
    {
        k1.h = arraylist;
        return arraylist;
    }

    static ArrayList b(k k1)
    {
        return k1.h;
    }

    static ArrayList b(k k1, ArrayList arraylist)
    {
        k1.i = arraylist;
        return arraylist;
    }

    static ArrayList c(k k1)
    {
        return k1.i;
    }

    static Context d(k k1)
    {
        return k1.d;
    }

    static 
    {
        b = TimeUnit.SECONDS.toMillis(1L);
    }
}
