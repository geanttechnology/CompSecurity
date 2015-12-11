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

final class aa extends o
{

    private static final String b;
    private static final String c;
    private final Context d;

    public aa(Context context)
    {
        super(b, new String[0]);
        d = context;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        if ((com.google.android.gms.d.h.a)map.get(c) != null)
        {
            map = cj.a((com.google.android.gms.d.h.a)map.get(c));
        } else
        {
            map = null;
        }
        map = ab.a(d, map);
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
        b = e.J.toString();
        c = f.R.toString();
    }
}
