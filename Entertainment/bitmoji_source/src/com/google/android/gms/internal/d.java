// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, kc, jz, jy, 
//            kh, ke

public interface d
{
    public static final class a extends ka
    {

        private static volatile a fX[];
        public String fY;
        public a fZ[];
        public a ga[];
        public a gb[];
        public String gc;
        public String gd;
        public long ge;
        public boolean gf;
        public a gg[];
        public int gh[];
        public boolean gi;
        public int type;

        public static a[] r()
        {
            if (fX == null)
            {
                synchronized (kc.aah)
                {
                    if (fX == null)
                    {
                        fX = new a[0];
                    }
                }
            }
            return fX;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(jz jz1)
            throws IOException
        {
            boolean flag = false;
            jz1.f(1, type);
            if (!fY.equals(""))
            {
                jz1.b(2, fY);
            }
            if (fZ != null && fZ.length > 0)
            {
                for (int i = 0; i < fZ.length; i++)
                {
                    a a1 = fZ[i];
                    if (a1 != null)
                    {
                        jz1.a(3, a1);
                    }
                }

            }
            if (ga != null && ga.length > 0)
            {
                for (int j = 0; j < ga.length; j++)
                {
                    a a2 = ga[j];
                    if (a2 != null)
                    {
                        jz1.a(4, a2);
                    }
                }

            }
            if (gb != null && gb.length > 0)
            {
                for (int k = 0; k < gb.length; k++)
                {
                    a a3 = gb[k];
                    if (a3 != null)
                    {
                        jz1.a(5, a3);
                    }
                }

            }
            if (!gc.equals(""))
            {
                jz1.b(6, gc);
            }
            if (!gd.equals(""))
            {
                jz1.b(7, gd);
            }
            if (ge != 0L)
            {
                jz1.b(8, ge);
            }
            if (gi)
            {
                jz1.a(9, gi);
            }
            if (gh != null && gh.length > 0)
            {
                for (int i1 = 0; i1 < gh.length; i1++)
                {
                    jz1.f(10, gh[i1]);
                }

            }
            if (gg != null && gg.length > 0)
            {
                for (int j1 = ((flag) ? 1 : 0); j1 < gg.length; j1++)
                {
                    a a4 = gg[j1];
                    if (a4 != null)
                    {
                        jz1.a(11, a4);
                    }
                }

            }
            if (gf)
            {
                jz1.a(12, gf);
            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return l(jy1);
        }

        public int c()
        {
            boolean flag = false;
            int j = super.c() + jz.g(1, type);
            int i = j;
            if (!fY.equals(""))
            {
                i = j + jz.g(2, fY);
            }
            j = i;
            if (fZ != null)
            {
                j = i;
                if (fZ.length > 0)
                {
                    for (j = 0; j < fZ.length;)
                    {
                        a a1 = fZ[j];
                        int k = i;
                        if (a1 != null)
                        {
                            k = i + jz.b(3, a1);
                        }
                        j++;
                        i = k;
                    }

                    j = i;
                }
            }
            i = j;
            if (ga != null)
            {
                i = j;
                if (ga.length > 0)
                {
                    i = j;
                    for (j = 0; j < ga.length;)
                    {
                        a a2 = ga[j];
                        int i1 = i;
                        if (a2 != null)
                        {
                            i1 = i + jz.b(4, a2);
                        }
                        j++;
                        i = i1;
                    }

                }
            }
            j = i;
            if (gb != null)
            {
                j = i;
                if (gb.length > 0)
                {
                    for (j = 0; j < gb.length;)
                    {
                        a a3 = gb[j];
                        int j1 = i;
                        if (a3 != null)
                        {
                            j1 = i + jz.b(5, a3);
                        }
                        j++;
                        i = j1;
                    }

                    j = i;
                }
            }
            i = j;
            if (!gc.equals(""))
            {
                i = j + jz.g(6, gc);
            }
            j = i;
            if (!gd.equals(""))
            {
                j = i + jz.g(7, gd);
            }
            i = j;
            if (ge != 0L)
            {
                i = j + jz.d(8, ge);
            }
            j = i;
            if (gi)
            {
                j = i + jz.b(9, gi);
            }
            i = j;
            if (gh != null)
            {
                i = j;
                if (gh.length > 0)
                {
                    i = 0;
                    int k1 = 0;
                    for (; i < gh.length; i++)
                    {
                        k1 += jz.cC(gh[i]);
                    }

                    i = j + k1 + gh.length * 1;
                }
            }
            j = i;
            if (gg != null)
            {
                j = i;
                if (gg.length > 0)
                {
                    int l1 = ((flag) ? 1 : 0);
                    do
                    {
                        j = i;
                        if (l1 >= gg.length)
                        {
                            break;
                        }
                        a a4 = gg[l1];
                        j = i;
                        if (a4 != null)
                        {
                            j = i + jz.b(11, a4);
                        }
                        l1++;
                        i = j;
                    } while (true);
                }
            }
            i = j;
            if (gf)
            {
                i = j + jz.b(12, gf);
            }
            DY = i;
            return i;
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
            if (!(obj instanceof a)) goto _L4; else goto _L3
_L3:
            obj = (a)obj;
            flag = flag1;
            if (type != ((a) (obj)).type) goto _L4; else goto _L5
_L5:
            if (fY != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((a) (obj)).fY != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!kc.equals(fZ, ((a) (obj)).fZ)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (!kc.equals(ga, ((a) (obj)).ga)) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (!kc.equals(gb, ((a) (obj)).gb)) goto _L4; else goto _L11
_L11:
            if (gc != null) goto _L13; else goto _L12
_L12:
            flag = flag1;
            if (((a) (obj)).gc != null) goto _L4; else goto _L14
_L14:
            if (gd != null) goto _L16; else goto _L15
_L15:
            flag = flag1;
            if (((a) (obj)).gd != null) goto _L4; else goto _L17
_L17:
            flag = flag1;
            if (ge != ((a) (obj)).ge) goto _L4; else goto _L18
_L18:
            flag = flag1;
            if (gf != ((a) (obj)).gf) goto _L4; else goto _L19
_L19:
            flag = flag1;
            if (!kc.equals(gg, ((a) (obj)).gg)) goto _L4; else goto _L20
_L20:
            flag = flag1;
            if (!kc.equals(gh, ((a) (obj)).gh)) goto _L4; else goto _L21
_L21:
            flag = flag1;
            if (gi != ((a) (obj)).gi) goto _L4; else goto _L22
_L22:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_296;
            }
            if (((a) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((a) (obj)).aae.isEmpty()) goto _L4; else goto _L23
_L23:
            return true;
_L7:
            if (!fY.equals(((a) (obj)).fY))
            {
                return false;
            }
              goto _L8
_L13:
            if (!gc.equals(((a) (obj)).gc))
            {
                return false;
            }
              goto _L14
_L16:
            if (!gd.equals(((a) (obj)).gd))
            {
                return false;
            }
              goto _L17
            return aae.equals(((a) (obj)).aae);
              goto _L8
        }

        public int hashCode()
        {
            char c2 = '\u04CF';
            boolean flag = false;
            int j1 = type;
            int i;
            int j;
            int k;
            char c1;
            int i1;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            if (fY == null)
            {
                i = 0;
            } else
            {
                i = fY.hashCode();
            }
            k1 = kc.hashCode(fZ);
            l1 = kc.hashCode(ga);
            i2 = kc.hashCode(gb);
            if (gc == null)
            {
                j = 0;
            } else
            {
                j = gc.hashCode();
            }
            if (gd == null)
            {
                k = 0;
            } else
            {
                k = gd.hashCode();
            }
            j2 = (int)(ge ^ ge >>> 32);
            if (gf)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            k2 = kc.hashCode(gg);
            l2 = kc.hashCode(gh);
            if (!gi)
            {
                c2 = '\u04D5';
            }
            i1 = ((flag) ? 1 : 0);
            if (aae != null)
            {
                if (aae.isEmpty())
                {
                    i1 = ((flag) ? 1 : 0);
                } else
                {
                    i1 = aae.hashCode();
                }
            }
            return ((((c1 + ((k + (j + ((((i + (j1 + 527) * 31) * 31 + k1) * 31 + l1) * 31 + i2) * 31) * 31) * 31 + j2) * 31) * 31 + k2) * 31 + l2) * 31 + c2) * 31 + i1;
        }

        public a l(jy jy1)
            throws IOException
        {
_L16:
            int i = jy1.ky();
            i;
            JVM INSTR lookupswitch 14: default 132
        //                       0: 142
        //                       8: 144
        //                       18: 212
        //                       26: 223
        //                       34: 354
        //                       42: 485
        //                       50: 616
        //                       58: 627
        //                       64: 638
        //                       72: 649
        //                       80: 660
        //                       82: 904
        //                       90: 1222
        //                       96: 1353;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
            if (a(jy1, i)) goto _L16; else goto _L2
_L2:
            return this;
_L3:
            i = jy1.kB();
            switch (i)
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
                type = i;
                break;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            fY = jy1.readString();
            continue; /* Loop/switch isn't completed */
_L5:
            int k = kh.c(jy1, 26);
            a aa[];
            if (fZ == null)
            {
                i = 0;
            } else
            {
                i = fZ.length;
            }
            aa = new a[k + i];
            k = i;
            if (i != 0)
            {
                System.arraycopy(fZ, 0, aa, 0, i);
                k = i;
            }
            for (; k < aa.length - 1; k++)
            {
                aa[k] = new a();
                jy1.a(aa[k]);
                jy1.ky();
            }

            aa[k] = new a();
            jy1.a(aa[k]);
            fZ = aa;
            continue; /* Loop/switch isn't completed */
_L6:
            int i1 = kh.c(jy1, 34);
            a aa1[];
            if (ga == null)
            {
                i = 0;
            } else
            {
                i = ga.length;
            }
            aa1 = new a[i1 + i];
            i1 = i;
            if (i != 0)
            {
                System.arraycopy(ga, 0, aa1, 0, i);
                i1 = i;
            }
            for (; i1 < aa1.length - 1; i1++)
            {
                aa1[i1] = new a();
                jy1.a(aa1[i1]);
                jy1.ky();
            }

            aa1[i1] = new a();
            jy1.a(aa1[i1]);
            ga = aa1;
            continue; /* Loop/switch isn't completed */
_L7:
            int j1 = kh.c(jy1, 42);
            a aa2[];
            if (gb == null)
            {
                i = 0;
            } else
            {
                i = gb.length;
            }
            aa2 = new a[j1 + i];
            j1 = i;
            if (i != 0)
            {
                System.arraycopy(gb, 0, aa2, 0, i);
                j1 = i;
            }
            for (; j1 < aa2.length - 1; j1++)
            {
                aa2[j1] = new a();
                jy1.a(aa2[j1]);
                jy1.ky();
            }

            aa2[j1] = new a();
            jy1.a(aa2[j1]);
            gb = aa2;
            continue; /* Loop/switch isn't completed */
_L8:
            gc = jy1.readString();
            continue; /* Loop/switch isn't completed */
_L9:
            gd = jy1.readString();
            continue; /* Loop/switch isn't completed */
_L10:
            ge = jy1.kA();
            continue; /* Loop/switch isn't completed */
_L11:
            gi = jy1.kC();
            continue; /* Loop/switch isn't completed */
_L12:
            int ai[];
            int k1;
            int k2;
            k2 = kh.c(jy1, 80);
            ai = new int[k2];
            k1 = 0;
            i = 0;
_L22:
            if (k1 >= k2) goto _L18; else goto _L17
_L17:
            int l2;
            if (k1 != 0)
            {
                jy1.ky();
            }
            l2 = jy1.kB();
            l2;
            JVM INSTR tableswitch 1 17: default 788
        //                       1 797
        //                       2 797
        //                       3 797
        //                       4 797
        //                       5 797
        //                       6 797
        //                       7 797
        //                       8 797
        //                       9 797
        //                       10 797
        //                       11 797
        //                       12 797
        //                       13 797
        //                       14 797
        //                       15 797
        //                       16 797
        //                       17 797;
               goto _L19 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20
_L19:
            k1++;
            continue; /* Loop/switch isn't completed */
_L20:
            int i2 = i + 1;
            ai[i] = l2;
            i = i2;
            if (true) goto _L19; else goto _L18
_L18:
            if (i != 0)
            {
                if (gh == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = gh.length;
                }
                if (k1 == 0 && i == ai.length)
                {
                    gh = ai;
                } else
                {
                    int ai1[] = new int[k1 + i];
                    if (k1 != 0)
                    {
                        System.arraycopy(gh, 0, ai1, 0, k1);
                    }
                    System.arraycopy(ai, 0, ai1, k1, i);
                    gh = ai1;
                }
            }
            continue; /* Loop/switch isn't completed */
            if (true) goto _L22; else goto _L21
_L21:
_L13:
            int j2;
            j2 = jy1.cw(jy1.kE());
            i = jy1.getPosition();
            k1 = 0;
_L28:
            if (jy1.kJ() > 0)
            {
                switch (jy1.kB())
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
                    k1++;
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
            if (k1 == 0) goto _L24; else goto _L23
_L23:
            jy1.cy(i);
            if (gh == null)
            {
                i = 0;
            } else
            {
                i = gh.length;
            }
            ai = new int[k1 + i];
            k1 = i;
            if (i != 0)
            {
                System.arraycopy(gh, 0, ai, 0, i);
                k1 = i;
            }
_L26:
            if (jy1.kJ() > 0)
            {
                i = jy1.kB();
                switch (i)
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
                    ai[k1] = i;
                    k1++;
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
            gh = ai;
_L24:
            jy1.cx(j2);
            continue; /* Loop/switch isn't completed */
            if (true) goto _L26; else goto _L25
_L25:
            if (true) goto _L28; else goto _L27
_L27:
_L14:
            int l1 = kh.c(jy1, 90);
            a aa3[];
            int j;
            if (gg == null)
            {
                j = 0;
            } else
            {
                j = gg.length;
            }
            aa3 = new a[l1 + j];
            l1 = j;
            if (j != 0)
            {
                System.arraycopy(gg, 0, aa3, 0, j);
                l1 = j;
            }
            for (; l1 < aa3.length - 1; l1++)
            {
                aa3[l1] = new a();
                jy1.a(aa3[l1]);
                jy1.ky();
            }

            aa3[l1] = new a();
            jy1.a(aa3[l1]);
            gg = aa3;
            continue; /* Loop/switch isn't completed */
_L15:
            gf = jy1.kC();
            if (true) goto _L16; else goto _L29
_L29:
        }

        public a s()
        {
            type = 1;
            fY = "";
            fZ = r();
            ga = r();
            gb = r();
            gc = "";
            gd = "";
            ge = 0L;
            gf = false;
            gg = r();
            gh = kh.aaj;
            gi = false;
            aae = null;
            DY = -1;
            return this;
        }

        public a()
        {
            s();
        }
    }

}
