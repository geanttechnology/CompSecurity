// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.b;

import android.content.Context;
import com.flurry.android.FlurryAgent;
import com.perfectcorp.utility.e;

public class a
{

    private static String a;

    public static void a()
    {
        if (b())
        {
            return;
        } else
        {
            FlurryAgent.onPageView();
            return;
        }
    }

    public static void a(Context context)
    {
        while (b() || a == null) 
        {
            return;
        }
        FlurryAgent.onEndSession(context);
    }

    public static void a(Context context, String s)
    {
        if (!b())
        {
            a = s;
            if (a != null)
            {
                FlurryAgent.onStartSession(context, a);
                return;
            }
        }
    }

    private static boolean b()
    {
        e.b(new Object[] {
            "isDebuggable=", Boolean.valueOf(e.a)
        });
        return e.a;
    }
}
