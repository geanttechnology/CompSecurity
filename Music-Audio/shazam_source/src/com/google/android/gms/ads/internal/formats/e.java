// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.n;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ab;
import com.google.android.gms.d.bk;
import com.google.android.gms.d.id;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            g, a

public final class e extends com.google.android.gms.d.br.a
    implements g.a
{

    private final a a;
    private final String b;
    private final id c;
    private final id d;
    private final Object e = new Object();
    private g f;

    public e(String s, id id1, id id2, a a1)
    {
        b = s;
        c = id1;
        d = id2;
        a = a1;
    }

    public final String a(String s)
    {
        return (String)d.get(s);
    }

    public final List a()
    {
        boolean flag = false;
        String as[] = new String[c.size() + d.size()];
        int l = 0;
        int i = 0;
        int i1;
        int j1;
        do
        {
            i1 = ((flag) ? 1 : 0);
            j1 = i;
            if (l >= c.size())
            {
                break;
            }
            as[i] = (String)c.b(l);
            i++;
            l++;
        } while (true);
        while (i1 < d.size()) 
        {
            as[j1] = (String)d.b(i1);
            i1++;
            j1++;
        }
        return Arrays.asList(as);
    }

    public final void a(g g1)
    {
        synchronized (e)
        {
            f = g1;
        }
        return;
        g1;
        obj;
        JVM INSTR monitorexit ;
        throw g1;
    }

    public final bk b(String s)
    {
        return (bk)c.get(s);
    }

    public final void b()
    {
label0:
        {
            synchronized (e)
            {
                if (f != null)
                {
                    break label0;
                }
                com.google.android.gms.ads.internal.util.client.b.a("Attempt to perform recordImpression before ad initialized.");
            }
            return;
        }
        f.a();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void c(String s)
    {
label0:
        {
            synchronized (e)
            {
                if (f != null)
                {
                    break label0;
                }
                com.google.android.gms.ads.internal.util.client.b.a("Attempt to call performClick before ad initialized.");
            }
            return;
        }
        g g1;
        g1 = f;
        w.b("performClick must be called on the main UI thread.");
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("asset", s);
        jsonobject.put("template", g1.d.j());
        s = new JSONObject();
        s.put("ad", g1.b);
        s.put("click", jsonobject);
        boolean flag;
        if (g1.a.a(g1.d.k()) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.put("has_custom_click_handler", flag);
        g1.c.a("google.afma.nativeAds.handleClickGmsg", s);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        com.google.android.gms.ads.internal.util.client.b.a("Unable to create click JSON.", s);
          goto _L1
    }

    public final String j()
    {
        return "3";
    }

    public final String k()
    {
        return b;
    }
}
