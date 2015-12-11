// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, c

final class df extends o
{

    private static final String b;
    private static final String c;
    private static final String d;
    private final c e;

    public df(c c1)
    {
        super(b, new String[] {
            c
        });
        e = c1;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        Object obj = e.a(cj.a((com.google.android.gms.d.h.a)map.get(c)));
        if (obj == null)
        {
            map = (com.google.android.gms.d.h.a)map.get(d);
            if (map != null)
            {
                return map;
            } else
            {
                return com.google.android.gms.e.cj.f();
            }
        } else
        {
            return cj.a(obj);
        }
    }

    public final boolean a()
    {
        return false;
    }

    static 
    {
        b = e.i.toString();
        c = f.bH.toString();
        d = f.as.toString();
    }
}
