// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.app.Activity;

// Referenced classes of package com.helpshift:
//            l, o, t

final class j
{

    protected static boolean a;
    private static l b = null;
    private static int c;
    private static int d;
    private static boolean e;

    public static void a(Activity activity)
    {
        if (b == null)
        {
            b = new l(activity);
        }
        c++;
        if (!e)
        {
            if (a)
            {
                o.a("d");
            } else
            {
                o.a("o");
            }
            activity = t.a();
            if (activity != null)
            {
                activity.a();
            }
        }
        e = true;
    }

    public static void b(Activity activity)
    {
        d++;
        if (c == d)
        {
            e = false;
            o.a("q");
            b.e();
            activity = t.a();
            if (activity != null)
            {
                activity.b();
            }
        }
    }

}
