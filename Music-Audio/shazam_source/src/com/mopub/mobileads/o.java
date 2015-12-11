// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.a.e;

// Referenced classes of package com.mopub.mobileads:
//            s

public final class o extends BroadcastReceiver
{

    private final m.a a;
    private final long b;
    private Context c;

    static void a(Context context, long l, String s1)
    {
        s1 = new Intent(s1);
        s1.putExtra("broadcastIdentifier", l);
        e.a(context.getApplicationContext()).a(s1);
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        long l;
        return;
_L2:
        if (b != (l = intent.getLongExtra("broadcastIdentifier", -1L))) goto _L1; else goto _L3
_L3:
        context = intent.getAction();
        if ("com.mopub.action.interstitial.fail".equals(context))
        {
            a.a(s.k);
            return;
        }
        if ("com.mopub.action.interstitial.show".equals(context))
        {
            a.b();
            return;
        }
        if (!"com.mopub.action.interstitial.dismiss".equals(context))
        {
            continue; /* Loop/switch isn't completed */
        }
        a.d();
        if (c == null) goto _L1; else goto _L4
_L4:
        e.a(c).a(this);
        c = null;
        return;
        if (!"com.mopub.action.interstitial.click".equals(context)) goto _L1; else goto _L5
_L5:
        a.c();
        return;
    }
}
