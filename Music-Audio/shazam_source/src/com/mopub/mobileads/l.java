// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.b;
import com.mopub.common.c.a;
import com.mopub.common.m;
import com.mopub.mobileads.a.c;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            u, s, k

public final class l
{

    boolean a;
    k b;
    final Handler c = new Handler();
    final Runnable d = new Runnable() {

        final l a;

        public final void run()
        {
            com.mopub.common.c.a.b("Third-party network timed out.");
            a.a(s.i);
            a.a();
        }

            
            {
                a = l.this;
                super();
            }
    };
    private u e;
    private Context f;
    private Map g;
    private Map h;

    public l(u u1, String s1, Map map, long l1, b b1)
    {
        m.a(map);
        e = u1;
        f = u1.getContext();
        com.mopub.common.c.a.b((new StringBuilder("Attempting to invoke custom event: ")).append(s1).toString());
        try
        {
            b = com.mopub.mobileads.a.c.a(s1);
        }
        // Misplaced declaration of an exception variable
        catch (u u1)
        {
            com.mopub.common.c.a.b((new StringBuilder("Couldn't locate or instantiate custom event: ")).append(s1).append(".").toString());
            e.b(s.g);
            return;
        }
        h = new TreeMap(map);
        g = e.getLocalExtras();
        if (e.getLocation() != null)
        {
            g.put("location", e.getLocation());
        }
        g.put("broadcastIdentifier", Long.valueOf(l1));
        g.put("mopub-intent-ad-report", b1);
        g.put("com_mopub_ad_width", Integer.valueOf(e.getAdWidth()));
        g.put("com_mopub_ad_height", Integer.valueOf(e.getAdHeight()));
    }

    final void a()
    {
        f = null;
        b = null;
        g = null;
        h = null;
        a = true;
    }

    public final void a(s s1)
    {
        while (a || e == null) 
        {
            return;
        }
        s s2 = s1;
        if (s1 == null)
        {
            s2 = s.q;
        }
        c.removeCallbacks(d);
        e.b(s2);
    }

    final int b()
    {
        if (e == null || e.getAdTimeoutDelay() == null || e.getAdTimeoutDelay().intValue() < 0)
        {
            return 10000;
        } else
        {
            return e.getAdTimeoutDelay().intValue() * 1000;
        }
    }
}
