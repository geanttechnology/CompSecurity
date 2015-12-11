// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;

public final class apo extends apv
{

    private final apw i;
    private final boolean j;
    private final long k;
    private boolean l;
    private aon m;
    private Map n;

    private apo(art art, arx arx, app app, int i1, long l1, long l2, int j1, apw apw1, Map map, boolean flag, long l3)
    {
        super(art, arx, app, i1, l1, l2, j1);
        i = apw1;
        j = flag;
        k = l3;
        n = null;
    }

    public apo(art art, arx arx, app app, int i1, long l1, long l2, int j1, apw apw1, boolean flag, long l3)
    {
        this(art, arx, app, i1, l1, l2, j1, apw1, null, false, 0L);
    }

    public final boolean a(long l1, boolean flag)
    {
        long l2 = k;
        flag = i.a(l2 + l1, flag);
        if (flag)
        {
            c();
        }
        return flag;
    }

    public final boolean a(aoq aoq1)
    {
        boolean flag1 = true;
        asn asn = super.e;
        boolean flag;
        if (asn != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        if ((i.a(asn, aoq1) & 4) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            aoq1.e = aoq1.e - k;
        }
        return flag;
    }

    public final void g()
    {
        i.a(0L, false);
        c();
    }

    public final boolean h()
    {
        boolean flag1 = true;
        if (!l)
        {
            if (j)
            {
                Object obj = super.e;
                boolean flag;
                if (obj != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a.b(flag);
                if ((i.a(((asn) (obj)), null) & 0x20) != 0)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                l = flag;
            } else
            {
                l = true;
            }
            if (l)
            {
                m = i.c();
                obj = i.d();
                if (obj != null)
                {
                    n = ((Map) (obj));
                }
            }
        }
        return l;
    }

    public final boolean i()
    {
        asn asn = super.e;
        return (i.a(asn, null) & 0x20) != 0;
    }

    public final aon j()
    {
        return m;
    }

    public final Map k()
    {
        return n;
    }
}
