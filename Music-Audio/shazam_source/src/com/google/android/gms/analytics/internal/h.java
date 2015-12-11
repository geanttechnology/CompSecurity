// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ja;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            r, g, n, o

class h extends BroadcastReceiver
{

    static final String a = com/google/android/gms/analytics/internal/h.getName();
    final r b;
    boolean c;
    boolean d;

    h(r r1)
    {
        w.a(r1);
        b = r1;
    }

    final void a()
    {
        b.a();
        b.c();
    }

    public final void b()
    {
        if (!c)
        {
            return;
        }
        b.a().b("Unregistering connectivity change receiver");
        c = false;
        d = false;
        Context context = b.a;
        try
        {
            context.unregisterReceiver(this);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            b.a().e("Failed to unregister the network broadcast receiver", illegalargumentexception);
        }
    }

    final boolean c()
    {
        Object obj = (ConnectivityManager)b.a.getSystemService("connectivity");
        boolean flag;
        try
        {
            obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        }
        catch (SecurityException securityexception)
        {
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        flag = ((NetworkInfo) (obj)).isConnected();
        if (flag)
        {
            return true;
        }
        return false;
    }

    public void onReceive(Context context, Intent intent)
    {
        a();
        context = intent.getAction();
        b.a().a("NetworkBroadcastReceiver received action", context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(context))
        {
            boolean flag = c();
            if (d != flag)
            {
                d = flag;
                context = b.c();
                context.a("Network connectivity status changed", Boolean.valueOf(flag));
                ((o) (context)).i.b().a(new n._cls1(context, flag));
            }
        } else
        if ("com.google.analytics.RADIO_POWERED".equals(context))
        {
            if (!intent.hasExtra(a))
            {
                context = b.c();
                context.b("Radio powered up");
                context.b();
                return;
            }
        } else
        {
            b.a().d("NetworkBroadcastReceiver received unknown action", context);
            return;
        }
    }

}
