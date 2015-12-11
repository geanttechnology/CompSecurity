// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            v, ew, an, bq, 
//            ao, aq, x

public final class eb
{

    public final v a;
    public final ew b;
    public final List c;
    public final int d;
    public final List e;
    public final List f;
    public final int g;
    public final long h;
    public final String i;
    public final boolean j;
    public final an k;
    public final bq l;
    public final String m;
    public final ao n;
    public final aq o;
    public final long p;
    public final x q;
    public final long r;

    public eb(v v, ew ew, List list, int i1, List list1, List list2, int j1, 
            long l1, String s, boolean flag, an an, bq bq, String s1, 
            ao ao, aq aq, long l2, x x, long l3)
    {
        a = v;
        b = ew;
        if (list != null)
        {
            v = Collections.unmodifiableList(list);
        } else
        {
            v = null;
        }
        c = v;
        d = i1;
        if (list1 != null)
        {
            v = Collections.unmodifiableList(list1);
        } else
        {
            v = null;
        }
        e = v;
        if (list2 != null)
        {
            v = Collections.unmodifiableList(list2);
        } else
        {
            v = null;
        }
        f = v;
        g = j1;
        h = l1;
        i = s;
        j = flag;
        k = an;
        l = bq;
        m = s1;
        n = ao;
        o = aq;
        p = l2;
        q = x;
        r = l3;
    }
}
