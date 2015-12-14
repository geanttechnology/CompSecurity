// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import android.content.Context;
import com.cyberlink.youcammakeup.Globals;
import com.flurry.android.FlurryAgent;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class a
{

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
        if (b())
        {
            return;
        } else
        {
            FlurryAgent.onStartSession(context, "4TJX3SR2FZ9KPBGGRNQR");
            return;
        }
    }

    public static void a(BaseEvent baseevent)
    {
        if (b())
        {
            return;
        }
        if (baseevent.b() == null)
        {
            FlurryAgent.logEvent(baseevent.a());
            return;
        } else
        {
            FlurryAgent.logEvent(baseevent.a(), baseevent.b());
            return;
        }
    }

    public static void b(Context context)
    {
        if (b())
        {
            return;
        } else
        {
            FlurryAgent.onEndSession(context);
            return;
        }
    }

    private static boolean b()
    {
        Globals.d();
        boolean flag = Globals.u();
        if (!flag);
        return flag;
    }
}
