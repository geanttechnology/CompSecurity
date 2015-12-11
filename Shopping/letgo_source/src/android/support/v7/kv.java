// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.ad;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.x;

// Referenced classes of package android.support.v7:
//            kw, ww

public class kv extends BroadcastReceiver
{

    static Object a = new Object();
    static ww b;
    static Boolean c;

    public kv()
    {
    }

    public static boolean a(Context context)
    {
        x.a(context);
        if (c != null)
        {
            return c.booleanValue();
        } else
        {
            boolean flag = l.a(context, android/support/v7/kv, true);
            c = Boolean.valueOf(flag);
            return flag;
        }
    }

    protected Class a()
    {
        return android/support/v7/kw;
    }

    protected void a(String s)
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        g g1;
        Object obj;
        boolean flag;
        obj = r.a(context);
        g1 = ((r) (obj)).f();
        String s = intent.getStringExtra("referrer");
        intent = intent.getAction();
        g1.a("CampaignTrackingReceiver received", intent);
        if (!"com.android.vending.INSTALL_REFERRER".equals(intent) || TextUtils.isEmpty(s))
        {
            g1.e("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        flag = kw.a(context);
        if (!flag)
        {
            g1.e("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        a(s);
        if (((r) (obj)).e().a())
        {
            g1.f("Received unexpected installation campaign on package side");
            return;
        }
        intent = a();
        x.a(intent);
        obj = new Intent(context, intent);
        ((Intent) (obj)).putExtra("referrer", s);
        intent = ((Intent) (a));
        intent;
        JVM INSTR monitorenter ;
        context.startService(((Intent) (obj)));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        intent;
        JVM INSTR monitorexit ;
        return;
        context;
        intent;
        JVM INSTR monitorexit ;
        throw context;
        if (b == null)
        {
            b = new ww(context, 1, "Analytics campaign WakeLock");
            b.a(false);
        }
        b.a(1000L);
_L1:
        intent;
        JVM INSTR monitorexit ;
        return;
        context;
        g1.e("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
          goto _L1
    }

}
