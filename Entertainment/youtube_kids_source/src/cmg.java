// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public final class cmg extends cml
{

    private final bkn e;
    private final arp f;
    private final int g;
    private final float h;
    private final int i;
    private final boolean j;
    private boolean k;

    public cmg(bkn bkn1, arp arp1, int l, int i1, int j1, int k1, float f1, 
            int l1, int i2, int j2, boolean flag)
    {
        super(arp1, l, i1, j1, k1, f1, 144, i2);
        k = false;
        e = (bkn)b.a(bkn1);
        f = (arp)b.a(arp1);
        g = l;
        h = f1;
        i = j2;
        j = flag;
    }

    protected final long a(long l)
    {
        if (l == -1L)
        {
            l = e.h();
            if (l == -1L || !j)
            {
                return (long)g;
            } else
            {
                return l - (long)i;
            }
        } else
        {
            return (long)((float)l * h - (float)i);
        }
    }

    protected final app a(app aapp[], long l)
    {
        int i1;
        int j1;
        j1 = aapp.length;
        i1 = 0;
_L7:
        if (i1 >= aapp.length)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        if (aapp[i1].d > super.d) goto _L2; else goto _L1
_L1:
        j1 = aapp.length - 1;
_L8:
        if (j1 < 0) goto _L4; else goto _L3
_L3:
        if (aapp[j1].d < super.c) goto _L6; else goto _L5
_L2:
        i1++;
          goto _L7
_L6:
        j1--;
          goto _L8
_L5:
        int k1 = j1;
        if (i1 > j1)
        {
            k1 = i1;
        }
        l = a(l);
        app app1;
        int l1;
        for (j1 = i1; j1 <= k1; j1++)
        {
            app1 = aapp[j1];
            i1 = super.a;
            l1 = super.b;
            if (i1 == -1 || l1 == -1)
            {
                i1 = 1;
            } else
            if ((double)app1.c * 0.84999999999999998D <= (double)i1 || (double)app1.d * 0.84999999999999998D <= (double)l1)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0 && (long)app1.e <= l)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                return app1;
            }
        }

        return aapp[k1];
_L4:
        j1 = 0;
        if (true) goto _L5; else goto _L9
_L9:
        i1 = j1 - 1;
          goto _L1
    }

    public final void a(List list, long l, app aapp[], apt apt1)
    {
        int i1;
        if (super.c != super.d)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        apt1.c = a(aapp, f.a());
        if (k)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        apt1.b = i1;
        i1 = 1;
_L5:
        if (i1 >= list.size()) goto _L2; else goto _L1
_L1:
        if (((apv)list.get(i1)).a.d == apt1.c.d) goto _L4; else goto _L3
_L3:
        apt1.a = i1;
_L2:
        if (!k)
        {
            k = true;
        }
        return;
_L4:
        i1++;
          goto _L5
        super.a(list, l, aapp, apt1);
          goto _L2
    }
}
