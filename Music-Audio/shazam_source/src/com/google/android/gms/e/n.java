// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, bs, cj

final class n extends o
{

    private static final String b;
    private final bs c;

    public n(bs bs1)
    {
        super(b, new String[0]);
        c = bs1;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        map = c.a();
        if (map == null)
        {
            return cj.f();
        } else
        {
            return cj.a(map);
        }
    }

    public final boolean a()
    {
        return false;
    }

    static 
    {
        b = e.q.toString();
    }
}
