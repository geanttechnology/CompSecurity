// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            be, cj, ci

abstract class ay extends be
{

    public ay(String s)
    {
        super(s);
    }

    protected final boolean a(com.google.android.gms.d.h.a a1, com.google.android.gms.d.h.a a2, Map map)
    {
        a1 = cj.b(a1);
        a2 = cj.b(a2);
        if (a1 == cj.d() || a2 == cj.d())
        {
            return false;
        } else
        {
            return a(((ci) (a1)), ((ci) (a2)));
        }
    }

    protected abstract boolean a(ci ci, ci ci1);
}
