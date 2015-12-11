// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gu;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class abd
{

    public final av a;
    public final gu b;
    public final List c;
    public final int d;
    public final List e;
    public final List f;
    public final int g;
    public final long h;
    public final String i;
    public final JSONObject j;
    public final boolean k;
    public final vu l;
    public final wg m;
    public final String n;
    public final vv o;
    public final vx p;
    public final long q;
    public final ay r;
    public final long s;
    public final long t;
    public final long u;
    public final String v;
    public final ut w;

    public abd(abe abe1, gu gu, vu vu, wg wg, String s1, vx vx, ut ut)
    {
        this(abe1.a.c, gu, abe1.b.d, abe1.e, abe1.b.f, abe1.b.j, abe1.b.l, abe1.b.k, abe1.a.i, abe1.b.h, vu, wg, s1, abe1.c, vx, abe1.b.i, abe1.d, abe1.b.g, abe1.f, abe1.g, abe1.b.o, abe1.h, ut);
    }

    public abd(av av, gu gu, List list, int i1, List list1, List list2, int j1, 
            long l1, String s1, boolean flag, vu vu, wg wg, String s2, 
            vv vv, vx vx, long l2, ay ay, long l3, 
            long l4, long l5, String s3, JSONObject jsonobject, ut ut)
    {
        a = av;
        b = gu;
        if (list != null)
        {
            av = Collections.unmodifiableList(list);
        } else
        {
            av = null;
        }
        c = av;
        d = i1;
        if (list1 != null)
        {
            av = Collections.unmodifiableList(list1);
        } else
        {
            av = null;
        }
        e = av;
        if (list2 != null)
        {
            av = Collections.unmodifiableList(list2);
        } else
        {
            av = null;
        }
        f = av;
        g = j1;
        h = l1;
        i = s1;
        k = flag;
        l = vu;
        m = wg;
        n = s2;
        o = vv;
        p = vx;
        q = l2;
        r = ay;
        s = l3;
        t = l4;
        u = l5;
        v = s3;
        j = jsonobject;
        w = ut;
    }
}
