// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import aa;
import ac;
import ba;
import bf;
import m;
import z;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            p, o

abstract class c extends p
{

    private final String a;
    private final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence b;

    c(m m1, String s, boolean flag, boolean flag1, String s1, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence, ac ac)
    {
        super(m1, flag, flag1, s1, null, ac);
        a = s;
        b = sequence;
    }

    protected final bf a()
    {
        return (new o()).a();
    }

    protected final z a(m m1, boolean flag, boolean flag1, String s, String s1, ac ac, ba ba, 
            ba ba1, ba ba2, ba ba3, bf bf, aa aa)
    {
        return m1.a(a, flag, flag1, s, b, ba, ba1, ba2, ba3, bf, ac, aa);
    }
}
