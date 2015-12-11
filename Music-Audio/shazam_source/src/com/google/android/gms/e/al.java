// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

final class al extends o
{

    private static final String b;
    private static final String c;

    public al()
    {
        super(b, new String[] {
            c
        });
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        return cj.a(cj.a((com.google.android.gms.d.h.a)map.get(c)).toLowerCase());
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.O.toString();
        c = f.p.toString();
    }
}
