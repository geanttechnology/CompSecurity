// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, aj

final class dd extends o
{
    public static interface a
    {

        public abstract Object a(String s);
    }


    private static final String b;
    private static final String c;
    private static final String d;
    private final a e;

    public dd(a a1)
    {
        super(b, new String[] {
            c
        });
        e = a1;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        String s = cj.a((com.google.android.gms.d.h.a)map.get(c));
        HashMap hashmap = new HashMap();
        map = (com.google.android.gms.d.h.a)map.get(d);
        if (map != null)
        {
            map = ((Map) (com.google.android.gms.e.cj.e(map)));
            if (!(map instanceof Map))
            {
                aj.a();
                return com.google.android.gms.e.cj.f();
            }
            java.util.Map.Entry entry;
            for (map = ((Map)map).entrySet().iterator(); map.hasNext(); hashmap.put(entry.getKey().toString(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        try
        {
            map = cj.a(e.a(s));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            (new StringBuilder("Custom macro/tag ")).append(s).append(" threw exception ").append(map.getMessage());
            aj.a();
            return com.google.android.gms.e.cj.f();
        }
        return map;
    }

    public final boolean a()
    {
        return false;
    }

    static 
    {
        b = e.r.toString();
        c = f.ba.toString();
        d = f.d.toString();
    }
}
