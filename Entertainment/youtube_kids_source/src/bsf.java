// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class bsf
{

    public final Set a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public bsf(dpz dpz1)
    {
        HashSet hashset = new HashSet();
        if (dpz1.a != null && dpz1.a.length > 0)
        {
            hashset.addAll(Arrays.asList(dpz1.a));
        }
        a = Collections.unmodifiableSet(hashset);
        if (dpz1.b == null || dpz1.b.a == null)
        {
            b = false;
            c = false;
            d = false;
            e = false;
            return;
        } else
        {
            b = dpz1.b.a.a;
            c = dpz1.b.a.b;
            d = dpz1.b.a.c;
            boolean flag = dpz1.b.a.d;
            flag = dpz1.b.a.e;
            e = dpz1.b.a.f;
            return;
        }
    }
}
