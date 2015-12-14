// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import java.util.List;

// Referenced classes of package com.cyberlink.you:
//            g, a

final class h
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private h()
    {
    }

    h(g._cls1 _pcls1)
    {
        this();
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
        Log.d("Globals", (new StringBuilder()).append("onActivityCreated: ").append(activity.getClass().getCanonicalName()).toString());
    }

    public void onActivityDestroyed(Activity activity)
    {
        Log.d("Globals", (new StringBuilder()).append("onActivityDestroyed: ").append(activity.getClass().getCanonicalName()).toString());
    }

    public void onActivityPaused(Activity activity)
    {
        Log.d("Globals", (new StringBuilder()).append("onActivityPaused: ").append(activity.getClass().getCanonicalName()).toString());
    }

    public void onActivityResumed(Activity activity)
    {
        Log.d("Globals", (new StringBuilder()).append("onActivityResumed: ").append(activity.getClass().getCanonicalName()).toString());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        Log.d("Globals", (new StringBuilder()).append("onActivitySaveInstanceState: ").append(activity.getClass().getCanonicalName()).toString());
    }

    public void onActivityStarted(Activity activity)
    {
        Log.d("Globals", (new StringBuilder()).append("onActivityStarted: ").append(activity.getClass().getCanonicalName()).append(", ").append(g.Q().size() + 1).append(" activities.").toString());
        if (!g.Q().contains(activity.getClass().getCanonicalName()))
        {
            g.Q().add(activity.getClass().getCanonicalName());
        }
        if (g.R() != null)
        {
            g.R().cancel();
        }
        if (g.Q().size() == 1)
        {
            a.a().a("Globals");
        }
    }

    public void onActivityStopped(Activity activity)
    {
        Log.d("Globals", (new StringBuilder()).append("onActivityStopped: ").append(activity.getClass().getCanonicalName()).toString());
        g.Q().remove(activity.getClass().getCanonicalName());
        if (g.t())
        {
            Log.i("Globals", "No running activities left, app has likely entered the background.");
            g.a((new CountDownTimer(0x2bf20L, 20000L) {

                final h a;

                public void onFinish()
                {
                    Log.w("Globals", "XMPP disconnected");
                    com.cyberlink.you.a.a().b("Globals");
                }

                public void onTick(long l)
                {
                    l /= 1000L;
                    Log.w("Globals", (new StringBuilder()).append("XMPP will disconnect in ").append(l).append(" seconds").toString());
                }

            
            {
                a = h.this;
                super(l, l1);
            }
            }).start());
            return;
        } else
        {
            Log.i("Globals", (new StringBuilder()).append(g.Q().size()).append(" activities remaining").toString());
            return;
        }
    }
}
