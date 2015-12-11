// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.a.m;
import com.google.b.b.d;
import com.google.b.c.a;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.b:
//            v, d, a, w, 
//            f, t, k, h, 
//            x, e, y

public final class g
{

    public d a;
    public boolean b;
    public boolean c;
    public boolean d;
    private v e;
    private e f;
    private final Map g = new HashMap();
    private final List h = new ArrayList();
    private final List i = new ArrayList();
    private String j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;

    public g()
    {
        a = d.a;
        e = com.google.b.v.a;
        f = com.google.b.d.a;
        k = 2;
        l = 2;
        c = true;
    }

    public final f a()
    {
        Object obj;
        ArrayList arraylist;
        int i1;
        int j1;
        arraylist = new ArrayList();
        arraylist.addAll(h);
        Collections.reverse(arraylist);
        arraylist.addAll(i);
        obj = j;
        i1 = k;
        j1 = l;
        if (obj == null || "".equals(((String) (obj)).trim())) goto _L2; else goto _L1
_L1:
        obj = new com.google.b.a(((String) (obj)));
_L6:
        arraylist.add(com.google.b.w.a(com.google.b.c.a.a(java/util/Date), obj));
        arraylist.add(com.google.b.w.a(com.google.b.c.a.a(java/sql/Timestamp), obj));
        arraylist.add(com.google.b.w.a(com.google.b.c.a.a(java/sql/Date), obj));
_L4:
        return new f(a, f, g, b, m, o, c, d, n, e, arraylist);
_L2:
        if (i1 == 2 || j1 == 2) goto _L4; else goto _L3
_L3:
        obj = new com.google.b.a(i1, j1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final g a(y y)
    {
        h.add(y);
        return this;
    }

    public final g a(Type type, Object obj)
    {
        boolean flag;
        if ((obj instanceof t) || (obj instanceof k) || (obj instanceof h) || (obj instanceof x))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.b.b.a.a(flag);
        if (obj instanceof h)
        {
            g.put(type, (h)obj);
        }
        if ((obj instanceof t) || (obj instanceof k))
        {
            a a1 = com.google.b.c.a.a(type);
            h.add(w.b(a1, obj));
        }
        if (obj instanceof x)
        {
            h.add(com.google.b.b.a.m.a(com.google.b.c.a.a(type), (x)obj));
        }
        return this;
    }
}
