// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.a;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import com.jirbo.adcolony.aa;
import com.jirbo.adcolony.ac;
import com.jirbo.adcolony.f;
import com.jirbo.adcolony.h;
import com.jirbo.adcolony.q;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.shazam.android.advert.a:
//            e

public final class a
    implements e
{

    private final com.shazam.android.j.a.a a;

    public a(com.shazam.android.j.a.a a1)
    {
        a = a1;
    }

    public final String a(String s)
    {
        if (q.c == null || q.c.b == null || q.c.b.j == null || q.c.b.j.n == null)
        {
            return "unknown";
        }
        if (q.h)
        {
            return "unknown";
        }
        com.jirbo.adcolony.al.c c = q.c.b.j.n.a(s);
        if (c != null)
        {
            if (!c.e)
            {
                return "off";
            }
            if (c.f && q.c.b.b(s, true))
            {
                return "active";
            } else
            {
                return "loading";
            }
        }
        if (!q.g)
        {
            return "unknown";
        } else
        {
            return "invalid";
        }
    }

    public final void a()
    {
        f.a();
    }

    public final void a(Activity activity)
    {
        String s;
        String as[];
        Handler handler;
        com.jirbo.adcolony.f._cls1 _lcls1;
        s = a.d();
        as = a.b();
        f.a = false;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new com.jirbo.adcolony.f.a(activity)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            (new com.jirbo.adcolony.f.a(activity)).execute(new Void[0]);
        }
        q.X.clear();
        handler = new Handler();
        _lcls1 = new com.jirbo.adcolony.f._cls1();
        if (q.p && !q.q) goto _L2; else goto _L1
_L1:
        if (q.h) goto _L4; else goto _L3
_L3:
        if (s != null) goto _L6; else goto _L5
_L5:
        q.a("Null App ID - disabling AdColony.");
_L4:
        return;
_L6:
        if (as == null)
        {
            q.a("Null Zone IDs array - disabling AdColony.");
            return;
        }
        if (as.length == 0)
        {
            q.a("No Zone IDs provided - disabling AdColony.");
            return;
        }
        q.b(activity);
        q.c.a("", s, as);
        q.f = true;
        q.p = true;
        handler.postDelayed(_lcls1, 0x1d4c0L);
_L2:
        if (q.B == null)
        {
            q.m = true;
        }
        q.V.clear();
        q.W.clear();
        q.Y = new HashMap();
        int i = 0;
        while (i < as.length) 
        {
            q.Y.put(as[i], Boolean.valueOf(false));
            i++;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public final void a(h h)
    {
        (new StringBuilder("addAdAvailabilityListener: ")).append(h);
        if (!q.W.contains(h))
        {
            q.W.add(h);
        }
    }

    public final void b(Activity activity)
    {
        f.a(activity);
    }

    public final void b(h h)
    {
        (new StringBuilder("removeAdAvailabilityListener: ")).append(h);
        q.W.remove(h);
    }
}
