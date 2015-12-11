// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class bpl extends bxi
{

    public String a;
    public int b;
    public String c;
    public String d;
    public boolean e;
    private final bxs j;
    private String k;
    private String l;
    private List m;

    bpl(bxm bxm, cpj cpj1, bxs bxs1)
    {
        super(bxm, cpj1.b, bxj.b);
        k = "";
        a = "";
        b = 0;
        c = "";
        d = "";
        l = "";
        e = false;
        m = new ArrayList();
        j = (bxs)b.a(bxs1);
        a(bqd.a);
    }

    public final bpl a(String s)
    {
        k = (String)b.a(s);
        return this;
    }

    protected final void a()
    {
        boolean flag;
        if (!TextUtils.isEmpty(a) || !TextUtils.isEmpty(k) || !TextUtils.isEmpty(l))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
    }

    public final String b()
    {
        return "next";
    }

    public final String c()
    {
        cne cne1 = i();
        cne1.a("videoId", k);
        cne1.a("playlistId", a);
        cne1.a("playlistIndex", a(b));
        cne1.a("params", c);
        cne1.a("adParams", d);
        cne1.a("continuation", l);
        cne1.a("isAdPlayback", e);
        return cne1.a();
    }

    public final eun d()
    {
        edd edd1 = new edd();
        edd1.c = a;
        if (b >= 0)
        {
            edd1.e = b;
        }
        edd1.d = c;
        edd1.j = d;
        edd1.b = k;
        edd1.f = l;
        edd1.a = h();
        edd1.g = e;
        edd1.h = j.a();
        edd1.i = new int[m.size()];
        for (int i = 0; i < m.size(); i++)
        {
            edd1.i[i] = ((Integer)m.get(i)).intValue();
        }

        return edd1;
    }
}
