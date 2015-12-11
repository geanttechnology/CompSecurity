// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

// Referenced classes of package com.google.analytics.tracking.android:
//            o

final class au
    implements o
{

    private static au a;
    private static Object b = new Object();
    private final Context c;

    private au(Context context)
    {
        c = context;
    }

    public static au a()
    {
        au au1;
        synchronized (b)
        {
            au1 = a;
        }
        return au1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void a(Context context)
    {
        synchronized (b)
        {
            if (a == null)
            {
                a = new au(context);
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final String a(String s)
    {
        if (s.equals("&sr"))
        {
            s = c.getResources().getDisplayMetrics();
            return (new StringBuilder()).append(((DisplayMetrics) (s)).widthPixels).append("x").append(((DisplayMetrics) (s)).heightPixels).toString();
        } else
        {
            return null;
        }
    }

}
