// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.SystemClock;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.ads:
//            c, e, h, d, 
//            f, a, InMobiAdRequestStatus

final class g
    implements d.a
{
    public static interface a
    {

        public abstract void a(InMobiAdRequestStatus inmobiadrequeststatus);

        public abstract void a(com.inmobi.ads.a a1);
    }


    private static final String a = com/inmobi/ads/g.getSimpleName();
    private h b;
    private a c;
    private c d;
    private boolean e;
    private long f;

    public g(h h1, a a1)
    {
        e = false;
        f = 0L;
        b = h1;
        c = a1;
        d = com.inmobi.ads.c.a();
    }

    private void a(long l, String s)
    {
        e = true;
        c.a(d.b(l, s));
    }

    private void a(h h1)
    {
        e e1 = new e(h1.a(), h1.c(), h1.g());
        e1.d(h1.d());
        e1.a(h1.e());
        e1.a(h1.h());
        e1.b(h1.i());
        e1.a(h1.f().c());
        e1.b(h1.j());
        e1.b(h1.i());
        e1.c(h1.k());
        e1.b(h1.b() * 1000);
        e1.c(h1.b() * 1000);
        f = SystemClock.elapsedRealtime();
        (new d(e1, this)).a();
    }

    private List c(f f1)
    {
        ArrayList arraylist = new ArrayList();
        String s;
        JSONArray jsonarray;
        JSONObject jsonobject = new JSONObject(f1.c());
        s = jsonobject.getString("requestId").trim();
        jsonarray = jsonobject.getJSONArray("ads");
        Object obj = arraylist;
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        int j = Math.min(f1.b().d(), jsonarray.length());
        int i = 0;
_L3:
        obj = arraylist;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(new com.inmobi.ads.a(f1, jsonarray.getJSONObject(i).toString(), (new StringBuilder()).append(s).append("_").append(i).toString()));
        i++;
        if (true) goto _L3; else goto _L2
        f1;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while parsing ad response.", f1);
        obj = new HashMap();
        ((Map) (obj)).put("type", b.h());
        ((Map) (obj)).put("errorCode", "ParsingError");
        ((Map) (obj)).put("reason", f1.getLocalizedMessage());
        com.inmobi.commons.core.c.a.a().a("ads", "ServerError", ((Map) (obj)));
        obj = null;
_L2:
        return ((List) (obj));
    }

    public void a()
    {
        e = false;
        d.a(b.h(), b.f().e());
        int i = d.a(b.c(), b.k());
        if (i == 0)
        {
            a(b);
            return;
        }
        if (i <= b.f().d())
        {
            a(b.c(), b.k());
            a(b);
            return;
        } else
        {
            a(b.c(), b.k());
            return;
        }
    }

    public void a(f f1)
    {
        long l = SystemClock.elapsedRealtime();
        List list = c(f1);
        if (list == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Could not parse ad response:").append(f1.c()).toString());
            if (!e)
            {
                c.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            }
        } else
        if (list.size() == 0)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Ad response received but no ad available:").append(f1.c()).toString());
            f1 = new HashMap();
            f1.put("type", b.h());
            f1.put("loadLatency", Long.valueOf(l - f));
            com.inmobi.commons.core.c.a.a().a("ads", "ServerNoFill", f1);
            if (!e)
            {
                c.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NO_FILL));
                return;
            }
        } else
        {
            f1 = new HashMap();
            f1.put("type", b.h());
            f1.put("count", Integer.valueOf(list.size()));
            f1.put("loadLatency", Long.valueOf(l - f));
            com.inmobi.commons.core.c.a.a().a("ads", "ServerFill", f1);
            if (!e)
            {
                c.a((com.inmobi.ads.a)list.get(0));
                list.remove(0);
            }
            d.a(list, b.f().b(), b.h());
            return;
        }
    }

    public void b(f f1)
    {
        if (!e)
        {
            long l = SystemClock.elapsedRealtime();
            HashMap hashmap = new HashMap();
            hashmap.put("type", b.h());
            hashmap.put("errorCode", String.valueOf(f1.d().a().getValue()));
            hashmap.put("reason", f1.d().b());
            hashmap.put("loadLatency", Long.valueOf(l - f));
            com.inmobi.commons.core.c.a.a().a("ads", "ServerError", hashmap);
            c.a(f1.a());
        }
    }

}
