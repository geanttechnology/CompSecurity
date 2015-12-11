// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class bxi
    implements bxq
{

    private boolean a;
    private int b;
    private final bxm c;
    private final cpl d;
    public Map f;
    public byte g[];
    public bxj h;
    public boolean i;

    public bxi(bxm bxm1, cpj cpj1)
    {
        this(bxm1, cpj1.b);
    }

    private bxi(bxm bxm1, cpl cpl1)
    {
        this(bxm1, cpl1, bxj.a);
    }

    public bxi(bxm bxm1, cpl cpl1, bxj bxj1)
    {
        a = false;
        h = bxj.a;
        b = 0;
        c = (bxm)b.a(bxm1);
        d = (cpl)b.a(cpl1);
        h = (bxj)b.a(bxj1);
    }

    public static int a(int l)
    {
        if (l >= 0)
        {
            return l;
        } else
        {
            return 0;
        }
    }

    public static transient void a(String as[])
    {
        int l = 0;
        int i1;
        int j1;
        for (i1 = 0; l < 2; i1 = j1)
        {
            j1 = i1;
            if (!TextUtils.isEmpty(as[l]))
            {
                j1 = i1 + 1;
            }
            l++;
        }

        boolean flag;
        if (i1 == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
    }

    public static String b(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return s1;
    }

    public abstract void a();

    public final void a(boolean flag)
    {
        i = flag;
    }

    public final void a(byte abyte0[])
    {
        b.a(abyte0);
        g = abyte0;
    }

    public String c()
    {
        return "NO_CACHE_KEY_VALUE";
    }

    public final boolean e()
    {
        return h != bxj.a;
    }

    public Map f()
    {
        if (f == null)
        {
            f = new HashMap();
        }
        return f;
    }

    public final void g()
    {
        a();
        if (g == null)
        {
            throw new IllegalArgumentException("Must set clickTrackingParams.");
        } else
        {
            return;
        }
    }

    public final dnl h()
    {
        Object obj = c;
        b.b();
        dnl dnl1 = new dnl();
        dnl1.b = new eap();
        for (obj = ((bxm) (obj)).a.iterator(); ((Iterator) (obj)).hasNext(); ((cnn)((Iterator) (obj)).next()).a(dnl1, this)) { }
        obj = new dgz();
        obj.a = g;
        dnl1.d = ((dgz) (obj));
        if (dnl1.a == null)
        {
            dnl1.a = new dhf();
        }
        return dnl1;
    }

    public final cne i()
    {
        cne cne1 = new cne();
        cne1.a("serviceName", b());
        byte abyte1[] = g;
        byte abyte0[] = abyte1;
        if (abyte1 == null)
        {
            abyte0 = bqd.a;
        }
        cne1.a("clickTrackingParams", abyte0);
        if (d.a())
        {
            cne1.a("managingAccount", d.c());
            cne1.a("onBehalfOf", d.d());
        }
        return cne1;
    }

    public final cpl j()
    {
        return d;
    }

    public final boolean k()
    {
        return i;
    }
}
