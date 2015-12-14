// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import aa;
import ac;
import ba;
import bf;
import java.util.List;
import m;
import z;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            p, h

abstract class y extends p
{

    private final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary a;
    private List b;

    y(m m1, String s, String s1, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, ac ac)
    {
        super(m1, false, false, s, s1, ac);
        a = dictionary;
        b = null;
    }

    protected final bf a()
    {
        return new h();
    }

    protected final z a(m m1, boolean flag, boolean flag1, String s, String s1, ac ac, ba ba, 
            ba ba1, ba ba2, ba ba3, bf bf, aa aa)
    {
        return m1.a(s, s1, a, bf, ac, aa);
    }
}
