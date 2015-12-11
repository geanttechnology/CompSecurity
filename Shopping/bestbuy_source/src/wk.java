// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class wk extends agu
{

    private static volatile wk m[];
    public int a;
    public String b;
    public wk c[];
    public wk d[];
    public wk e[];
    public String f;
    public String g;
    public long h;
    public boolean i;
    public wk j[];
    public int k[];
    public boolean l;

    public wk()
    {
        b();
    }

    public static wk[] a()
    {
        if (m == null)
        {
            synchronized (agy.a)
            {
                if (m == null)
                {
                    m = new wk[0];
                }
            }
        }
        return m;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public wk a(agr agr1)
    {
_L16:
        int i1 = agr1.a();
        i1;
        JVM INSTR lookupswitch 14: default 132
    //                   0: 142
    //                   8: 144
    //                   18: 212
    //                   26: 223
    //                   34: 354
    //                   42: 485
    //                   50: 616
    //                   58: 627
    //                   64: 638
    //                   72: 649
    //                   80: 660
    //                   82: 904
    //                   90: 1222
    //                   96: 1353;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        if (a(agr1, i1)) goto _L16; else goto _L2
_L2:
        return this;
_L3:
        i1 = agr1.f();
        switch (i1)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            a = i1;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        b = agr1.h();
        continue; /* Loop/switch isn't completed */
_L5:
        int k1 = ahd.a(agr1, 26);
        wk awk[];
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.length;
        }
        awk = new wk[k1 + i1];
        k1 = i1;
        if (i1 != 0)
        {
            System.arraycopy(c, 0, awk, 0, i1);
            k1 = i1;
        }
        for (; k1 < awk.length - 1; k1++)
        {
            awk[k1] = new wk();
            agr1.a(awk[k1]);
            agr1.a();
        }

        awk[k1] = new wk();
        agr1.a(awk[k1]);
        c = awk;
        continue; /* Loop/switch isn't completed */
_L6:
        int l1 = ahd.a(agr1, 34);
        wk awk1[];
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.length;
        }
        awk1 = new wk[l1 + i1];
        l1 = i1;
        if (i1 != 0)
        {
            System.arraycopy(d, 0, awk1, 0, i1);
            l1 = i1;
        }
        for (; l1 < awk1.length - 1; l1++)
        {
            awk1[l1] = new wk();
            agr1.a(awk1[l1]);
            agr1.a();
        }

        awk1[l1] = new wk();
        agr1.a(awk1[l1]);
        d = awk1;
        continue; /* Loop/switch isn't completed */
_L7:
        int i2 = ahd.a(agr1, 42);
        wk awk2[];
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.length;
        }
        awk2 = new wk[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
            System.arraycopy(e, 0, awk2, 0, i1);
            i2 = i1;
        }
        for (; i2 < awk2.length - 1; i2++)
        {
            awk2[i2] = new wk();
            agr1.a(awk2[i2]);
            agr1.a();
        }

        awk2[i2] = new wk();
        agr1.a(awk2[i2]);
        e = awk2;
        continue; /* Loop/switch isn't completed */
_L8:
        f = agr1.h();
        continue; /* Loop/switch isn't completed */
_L9:
        g = agr1.h();
        continue; /* Loop/switch isn't completed */
_L10:
        h = agr1.e();
        continue; /* Loop/switch isn't completed */
_L11:
        l = agr1.g();
        continue; /* Loop/switch isn't completed */
_L12:
        int ai[];
        int j2;
        int j3;
        j3 = ahd.a(agr1, 80);
        ai = new int[j3];
        j2 = 0;
        i1 = 0;
_L22:
        if (j2 >= j3) goto _L18; else goto _L17
_L17:
        int k3;
        if (j2 != 0)
        {
            agr1.a();
        }
        k3 = agr1.f();
        k3;
        JVM INSTR tableswitch 1 17: default 788
    //                   1 797
    //                   2 797
    //                   3 797
    //                   4 797
    //                   5 797
    //                   6 797
    //                   7 797
    //                   8 797
    //                   9 797
    //                   10 797
    //                   11 797
    //                   12 797
    //                   13 797
    //                   14 797
    //                   15 797
    //                   16 797
    //                   17 797;
           goto _L19 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20
_L19:
        j2++;
        continue; /* Loop/switch isn't completed */
_L20:
        int l2 = i1 + 1;
        ai[i1] = k3;
        i1 = l2;
        if (true) goto _L19; else goto _L18
_L18:
        if (i1 != 0)
        {
            if (k == null)
            {
                j2 = 0;
            } else
            {
                j2 = k.length;
            }
            if (j2 == 0 && i1 == ai.length)
            {
                k = ai;
            } else
            {
                int ai1[] = new int[j2 + i1];
                if (j2 != 0)
                {
                    System.arraycopy(k, 0, ai1, 0, j2);
                }
                System.arraycopy(ai, 0, ai1, j2, i1);
                k = ai1;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L22; else goto _L21
_L21:
_L13:
        int i3;
        i3 = agr1.d(agr1.k());
        i1 = agr1.q();
        j2 = 0;
_L28:
        if (agr1.o() > 0)
        {
            switch (agr1.f())
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            case 16: // '\020'
            case 17: // '\021'
                j2++;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (j2 == 0) goto _L24; else goto _L23
_L23:
        agr1.f(i1);
        if (k == null)
        {
            i1 = 0;
        } else
        {
            i1 = k.length;
        }
        ai = new int[j2 + i1];
        j2 = i1;
        if (i1 != 0)
        {
            System.arraycopy(k, 0, ai, 0, i1);
            j2 = i1;
        }
_L26:
        if (agr1.o() > 0)
        {
            i1 = agr1.f();
            switch (i1)
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            case 16: // '\020'
            case 17: // '\021'
                ai[j2] = i1;
                j2++;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        k = ai;
_L24:
        agr1.e(i3);
        continue; /* Loop/switch isn't completed */
        if (true) goto _L26; else goto _L25
_L25:
        if (true) goto _L28; else goto _L27
_L27:
_L14:
        int k2 = ahd.a(agr1, 90);
        wk awk3[];
        int j1;
        if (j == null)
        {
            j1 = 0;
        } else
        {
            j1 = j.length;
        }
        awk3 = new wk[k2 + j1];
        k2 = j1;
        if (j1 != 0)
        {
            System.arraycopy(j, 0, awk3, 0, j1);
            k2 = j1;
        }
        for (; k2 < awk3.length - 1; k2++)
        {
            awk3[k2] = new wk();
            agr1.a(awk3[k2]);
            agr1.a();
        }

        awk3[k2] = new wk();
        agr1.a(awk3[k2]);
        j = awk3;
        continue; /* Loop/switch isn't completed */
_L15:
        i = agr1.g();
        if (true) goto _L16; else goto _L29
_L29:
    }

    public void a(ags ags1)
    {
        boolean flag = false;
        ags1.a(1, a);
        if (!b.equals(""))
        {
            ags1.a(2, b);
        }
        if (c != null && c.length > 0)
        {
            for (int i1 = 0; i1 < c.length; i1++)
            {
                wk wk1 = c[i1];
                if (wk1 != null)
                {
                    ags1.a(3, wk1);
                }
            }

        }
        if (d != null && d.length > 0)
        {
            for (int j1 = 0; j1 < d.length; j1++)
            {
                wk wk2 = d[j1];
                if (wk2 != null)
                {
                    ags1.a(4, wk2);
                }
            }

        }
        if (e != null && e.length > 0)
        {
            for (int k1 = 0; k1 < e.length; k1++)
            {
                wk wk3 = e[k1];
                if (wk3 != null)
                {
                    ags1.a(5, wk3);
                }
            }

        }
        if (!f.equals(""))
        {
            ags1.a(6, f);
        }
        if (!g.equals(""))
        {
            ags1.a(7, g);
        }
        if (h != 0L)
        {
            ags1.a(8, h);
        }
        if (l)
        {
            ags1.a(9, l);
        }
        if (k != null && k.length > 0)
        {
            for (int l1 = 0; l1 < k.length; l1++)
            {
                ags1.a(10, k[l1]);
            }

        }
        if (j != null && j.length > 0)
        {
            for (int i2 = ((flag) ? 1 : 0); i2 < j.length; i2++)
            {
                wk wk4 = j[i2];
                if (wk4 != null)
                {
                    ags1.a(11, wk4);
                }
            }

        }
        if (i)
        {
            ags1.a(12, i);
        }
        super.a(ags1);
    }

    public aha b(agr agr1)
    {
        return a(agr1);
    }

    public wk b()
    {
        a = 1;
        b = "";
        c = a();
        d = a();
        e = a();
        f = "";
        g = "";
        h = 0L;
        i = false;
        j = a();
        k = ahd.a;
        l = false;
        o = null;
        p = -1;
        return this;
    }

    protected int c()
    {
        boolean flag = false;
        int j1 = super.c() + ags.c(1, a);
        int i1 = j1;
        if (!b.equals(""))
        {
            i1 = j1 + ags.b(2, b);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1;
            if (c.length > 0)
            {
                for (j1 = 0; j1 < c.length;)
                {
                    wk wk1 = c[j1];
                    int k1 = i1;
                    if (wk1 != null)
                    {
                        k1 = i1 + ags.c(3, wk1);
                    }
                    j1++;
                    i1 = k1;
                }

                j1 = i1;
            }
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1;
            if (d.length > 0)
            {
                i1 = j1;
                for (j1 = 0; j1 < d.length;)
                {
                    wk wk2 = d[j1];
                    int l1 = i1;
                    if (wk2 != null)
                    {
                        l1 = i1 + ags.c(4, wk2);
                    }
                    j1++;
                    i1 = l1;
                }

            }
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1;
            if (e.length > 0)
            {
                for (j1 = 0; j1 < e.length;)
                {
                    wk wk3 = e[j1];
                    int i2 = i1;
                    if (wk3 != null)
                    {
                        i2 = i1 + ags.c(5, wk3);
                    }
                    j1++;
                    i1 = i2;
                }

                j1 = i1;
            }
        }
        i1 = j1;
        if (!f.equals(""))
        {
            i1 = j1 + ags.b(6, f);
        }
        j1 = i1;
        if (!g.equals(""))
        {
            j1 = i1 + ags.b(7, g);
        }
        i1 = j1;
        if (h != 0L)
        {
            i1 = j1 + ags.b(8, h);
        }
        j1 = i1;
        if (l)
        {
            j1 = i1 + ags.b(9, l);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1;
            if (k.length > 0)
            {
                i1 = 0;
                int j2 = 0;
                for (; i1 < k.length; i1++)
                {
                    j2 += ags.c(k[i1]);
                }

                i1 = j1 + j2 + k.length * 1;
            }
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1;
            if (j.length > 0)
            {
                int k2 = ((flag) ? 1 : 0);
                do
                {
                    j1 = i1;
                    if (k2 >= j.length)
                    {
                        break;
                    }
                    wk wk4 = j[k2];
                    j1 = i1;
                    if (wk4 != null)
                    {
                        j1 = i1 + ags.c(11, wk4);
                    }
                    k2++;
                    i1 = j1;
                } while (true);
            }
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + ags.b(12, i);
        }
        return i1;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof wk)) goto _L4; else goto _L3
_L3:
        obj = (wk)obj;
        flag = flag1;
        if (a != ((wk) (obj)).a) goto _L4; else goto _L5
_L5:
        if (b != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((wk) (obj)).b != null) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (!agy.a(c, ((wk) (obj)).c)) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (!agy.a(d, ((wk) (obj)).d)) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (!agy.a(e, ((wk) (obj)).e)) goto _L4; else goto _L11
_L11:
        if (f != null) goto _L13; else goto _L12
_L12:
        flag = flag1;
        if (((wk) (obj)).f != null) goto _L4; else goto _L14
_L14:
        if (g != null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        flag = flag1;
        if (((wk) (obj)).g != null) goto _L4; else goto _L15
_L15:
        flag = flag1;
        if (h == ((wk) (obj)).h)
        {
            flag = flag1;
            if (i == ((wk) (obj)).i)
            {
                flag = flag1;
                if (agy.a(j, ((wk) (obj)).j))
                {
                    flag = flag1;
                    if (agy.a(k, ((wk) (obj)).k))
                    {
                        flag = flag1;
                        if (l == ((wk) (obj)).l)
                        {
                            return a(((agu) (obj)));
                        }
                    }
                }
            }
        }
          goto _L4
_L7:
        if (!b.equals(((wk) (obj)).b))
        {
            return false;
        }
          goto _L8
_L13:
        if (!f.equals(((wk) (obj)).f))
        {
            return false;
        }
          goto _L14
        if (!g.equals(((wk) (obj)).g))
        {
            return false;
        }
          goto _L15
    }

    public int hashCode()
    {
        char c2 = '\u04CF';
        int k1 = 0;
        int l1 = a;
        int i1;
        int j1;
        char c1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        i2 = agy.a(c);
        j2 = agy.a(d);
        k2 = agy.a(e);
        if (f == null)
        {
            j1 = 0;
        } else
        {
            j1 = f.hashCode();
        }
        if (g != null)
        {
            k1 = g.hashCode();
        }
        l2 = (int)(h ^ h >>> 32);
        if (i)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        i3 = agy.a(j);
        j3 = agy.a(k);
        if (!l)
        {
            c2 = '\u04D5';
        }
        return ((((c1 + (((j1 + ((((i1 + (l1 + 527) * 31) * 31 + i2) * 31 + j2) * 31 + k2) * 31) * 31 + k1) * 31 + l2) * 31) * 31 + i3) * 31 + j3) * 31 + c2) * 31 + d();
    }
}
