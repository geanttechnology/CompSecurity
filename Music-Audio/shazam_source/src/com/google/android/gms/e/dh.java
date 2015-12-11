// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            ch, cj, c

final class dh extends ch
{

    private static final String b;
    private static final String c;
    private static final String d;
    private final c e;

    public dh(c c1)
    {
        super(b, new String[] {
            c
        });
        e = c1;
    }

    public final void b(Map map)
    {
        Object obj = (com.google.android.gms.d.h.a)map.get(c);
        if (obj != null && obj != cj.a())
        {
            if ((obj = com.google.android.gms.e.cj.e(((com.google.android.gms.d.h.a) (obj)))) instanceof List)
            {
                obj = ((List)obj).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    Object obj1 = ((Iterator) (obj)).next();
                    if (obj1 instanceof Map)
                    {
                        obj1 = (Map)obj1;
                        e.a(((Map) (obj1)));
                    }
                }
            }
        }
        map = (com.google.android.gms.d.h.a)map.get(d);
        if (map != null && map != cj.a())
        {
            if ((map = cj.a(map)) != com.google.android.gms.e.cj.e())
            {
                c c1 = e;
                c1.a(com.google.android.gms.e.c.a(map, null));
                c1.c.a(map);
                return;
            }
        }
    }

    static 
    {
        b = e.N.toString();
        c = f.dv.toString();
        d = f.M.toString();
    }
}
