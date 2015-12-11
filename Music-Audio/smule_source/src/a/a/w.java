// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;

// Referenced classes of package a.a:
//            ag, en, ap, aq, 
//            aa, ai, ds, ac, 
//            cq, cr, am, an

public final class w
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private int a;
    private boolean b;
    private boolean c;
    private boolean d;
    private Context e;
    private aa f;
    private ag g;

    public w(Context context, aa aa1)
    {
        a = 0;
        b = false;
        c = false;
        d = false;
        e = context;
        f = aa1;
        g = new ag(context, aa1);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public final void onActivityDestroyed(Activity activity)
    {
    }

    public final void onActivityPaused(Activity activity)
    {
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        if (c)
        {
            activity.unregisterReceiver(g);
            c = false;
        }
        return;
        activity;
        throw activity;
        activity;
        en.a(activity);
        return;
    }

    public final void onActivityResumed(Activity activity)
    {
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        if (!b) goto _L2; else goto _L1
_L1:
        en.b();
        b = false;
_L3:
        a = a + 1;
        IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentfilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        activity.registerReceiver(g, intentfilter);
        c = true;
        return;
_L2:
label0:
        {
            if (a != 0)
            {
                break MISSING_BLOCK_LABEL_178;
            }
            f.a(new ap(aq.a));
            ai.a();
            if (!d)
            {
                d = true;
                ac ac1 = (new ds(e)).a();
                if (ac1 != ac.c)
                {
                    if (ac1 != ac.d)
                    {
                        break label0;
                    }
                    f.a(new cq(cr.b));
                }
            }
        }
          goto _L3
        try
        {
            f.a(new cq(cr.a));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw activity;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            en.a(activity);
            return;
        }
          goto _L3
        f.a(new am(an.a, activity.getClass().getName()));
          goto _L3
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public final void onActivityStarted(Activity activity)
    {
    }

    public final void onActivityStopped(Activity activity)
    {
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        a = a - 1;
        if (activity.isChangingConfigurations())
        {
            en.b();
            b = true;
            return;
        }
        if (a == 0)
        {
            f.a(new ap(aq.b));
            ai.a(f);
            return;
        }
        try
        {
            f.a(new am(an.b, activity.getClass().getName()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw activity;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            en.a(activity);
        }
    }
}
