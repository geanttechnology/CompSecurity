// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.c.x;
import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f
{

    static final String a = com/smule/android/network/a/f.getName();
    protected static f b = null;

    private f()
    {
    }

    public static f a()
    {
        if (b == null)
        {
            b = new f();
        }
        return b;
    }

    private Map b(List list)
    {
        ArrayList arraylist = new ArrayList();
        HashMap hashmap;
        for (list = list.iterator(); list.hasNext(); arraylist.add(hashmap))
        {
            x x1 = (x)list.next();
            hashmap = new HashMap();
            double d = x1.a;
            new HashMap();
            hashmap.put("ts", Long.valueOf((long)d));
            hashmap.put("app", com.smule.android.network.core.b.b());
            hashmap.put("plyrId", Long.valueOf(UserManager.n().c()));
            hashmap.put("event", x1.b);
            if (x1.c != null)
            {
                hashmap.put("target", x1.c);
            }
            if (x1.d != null)
            {
                hashmap.put("context", x1.d);
            }
            if (x1.e != null)
            {
                hashmap.put("value", x1.e);
            }
            if (x1.f != null)
            {
                hashmap.put("k1", x1.f);
            }
            if (x1.g != null)
            {
                hashmap.put("k2", x1.g);
            }
            if (x1.h != null)
            {
                hashmap.put("k3", x1.h);
            }
            if (x1.i != null)
            {
                hashmap.put("k4", x1.i);
            }
            if (x1.j != null)
            {
                hashmap.put("k5", x1.j);
            }
            if (x1.k != null)
            {
                hashmap.put("k6", x1.k);
            }
            if (x1.l != null)
            {
                hashmap.put("k7", x1.l);
            }
        }

        list = new HashMap();
        list.put("app", com.smule.android.network.core.b.b());
        list.put("events", arraylist);
        return list;
    }

    public o a(List list)
    {
        list = b(list);
        list = new k(m.a, "/v2/analytics/el", l.b, n.c, list, false);
        return com.smule.android.network.core.b.a().a(list);
    }

}
