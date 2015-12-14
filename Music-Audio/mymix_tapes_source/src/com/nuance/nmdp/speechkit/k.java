// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import bf;
import g;
import h;
import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            a, i

abstract class k extends a
{

    private final String a;

    k(m m1, String s, String s1, List list)
    {
        super(m1, s, list);
        a = s1;
    }

    protected final bf a()
    {
        return (new i()).a();
    }

    protected final g a(m m1, String s, List list, bf bf, h h)
    {
        return m1.a(list, a, bf, h);
    }
}
