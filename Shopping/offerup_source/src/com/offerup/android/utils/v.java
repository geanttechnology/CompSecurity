// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Context;
import android.os.Bundle;
import com.b.a.a.g;
import com.facebook.appevents.AppEventsLogger;
import java.util.Arrays;
import java.util.List;

public final class v
{

    public static final List a = Arrays.asList(new String[] {
        "publish_actions"
    });
    public static final List b = Arrays.asList(new String[] {
        "public_profile", "user_friends", "email"
    });
    public static final List c = Arrays.asList(new String[] {
        "public_profile", "email"
    });
    public static final List d = Arrays.asList(new String[] {
        "email"
    });
    private static AppEventsLogger e;
    private static String f = "FacebookEventUtil";

    private static AppEventsLogger a(Context context)
    {
        com/offerup/android/utils/v;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = AppEventsLogger.newLogger(context);
        }
        context = e;
        com/offerup/android/utils/v;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static void a(Context context, String s, double d1, Bundle bundle)
    {
        try
        {
            a(context).logEvent(s, d1, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(f, context);
        }
    }

    public static void a(Context context, String s, Bundle bundle)
    {
        try
        {
            a(context).logEvent(s, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(f, context);
        }
    }

}
