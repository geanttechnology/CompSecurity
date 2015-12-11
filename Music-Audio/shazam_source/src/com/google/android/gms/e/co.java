// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, ab

final class co extends o
{

    private static final String b;
    private static final String c;
    private static final String d;
    private final Context e;

    public co(Context context)
    {
        super(b, new String[] {
            d
        });
        e = context;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        Object obj = (com.google.android.gms.d.h.a)map.get(d);
        if (obj == null)
        {
            return com.google.android.gms.e.cj.f();
        }
        obj = cj.a(((com.google.android.gms.d.h.a) (obj)));
        map = (com.google.android.gms.d.h.a)map.get(c);
        if (map != null)
        {
            map = cj.a(map);
        } else
        {
            map = null;
        }
        map = ab.a(e, ((String) (obj)), map);
        if (map != null)
        {
            return cj.a(map);
        } else
        {
            return com.google.android.gms.e.cj.f();
        }
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.E.toString();
        c = f.R.toString();
        d = f.U.toString();
    }
}
