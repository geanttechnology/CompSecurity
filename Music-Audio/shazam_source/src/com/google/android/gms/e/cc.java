// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            be, cj

abstract class cc extends be
{

    public cc(String s)
    {
        super(s);
    }

    protected final boolean a(com.google.android.gms.d.h.a a1, com.google.android.gms.d.h.a a2, Map map)
    {
        a1 = cj.a(a1);
        a2 = cj.a(a2);
        if (a1 == cj.e() || a2 == cj.e())
        {
            return false;
        } else
        {
            return a(((String) (a1)), ((String) (a2)), map);
        }
    }

    protected abstract boolean a(String s, String s1, Map map);
}
