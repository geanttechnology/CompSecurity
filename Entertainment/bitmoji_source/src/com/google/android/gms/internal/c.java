// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, jy, jz, ke, 
//            kc, kh, kd, kb

public interface com.google.android.gms.internal.c
{
    public static final class a extends ka
    {

        public int eP;
        public int eQ;
        public int level;

        public a a(jy jy1)
            throws IOException
        {
_L6:
            int k = jy1.ky();
            k;
            JVM INSTR lookupswitch 4: default 48
        //                       0: 57
        //                       8: 59
        //                       16: 103
        //                       24: 114;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            if (a(jy1, k)) goto _L6; else goto _L2
_L2:
            return this;
_L3:
            int l = jy1.kB();
            switch (l)
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                level = l;
                break;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            eP = jy1.kB();
            continue; /* Loop/switch isn't completed */
_L5:
            eQ = jy1.kB();
            if (true) goto _L6; else goto _L7
_L7:
        }

        public void a(jz jz1)
            throws IOException
        {
            if (level != 1)
            {
                jz1.f(1, level);
            }
            if (eP != 0)
            {
                jz1.f(2, eP);
            }
            if (eQ != 0)
            {
                jz1.f(3, eQ);
            }
            super.a(jz1);
        }

        public a b()
        {
            level = 1;
            eP = 0;
            eQ = 0;
            aae = null;
            DY = -1;
            return this;
        }

        public ke b(jy jy1)
            throws IOException
        {
            return a(jy1);
        }

        public int c()
        {
            int l = super.c();
            int k = l;
            if (level != 1)
            {
                k = l + jz.g(1, level);
            }
            l = k;
            if (eP != 0)
            {
                l = k + jz.g(2, eP);
            }
            k = l;
            if (eQ != 0)
            {
                k = l + jz.g(3, eQ);
            }
            DY = k;
            return k;
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
            if (level != ((a) (obj)).level) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (eP != ((a) (obj)).eP) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (eQ != ((a) (obj)).eQ) goto _L4; else goto _L7
_L7:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_106;
            }
            if (((a) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((a) (obj)).aae.isEmpty()) goto _L4; else goto _L8
_L8:
            return true;
            return aae.equals(((a) (obj)).aae);
        }

        public int hashCode()
        {
            int l = level;
            int i1 = eP;
            int j1 = eQ;
            int k;
            if (aae == null || aae.isEmpty())
            {
                k = 0;
            } else
            {
                k = aae.hashCode();
            }
            return k + (((l + 527) * 31 + i1) * 31 + j1) * 31;
        }

        public a()
        {
            b();
        }
    }

    public static final class b extends ka
    {

        private static volatile b eR[];
        public int eS[];
        public int eT;
        public boolean eU;
        public boolean eV;
        public int name;

        public static b[] d()
        {
            if (eR == null)
            {
                synchronized (kc.aah)
                {
                    if (eR == null)
                    {
                        eR = new b[0];
                    }
                }
            }
            return eR;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(jz jz1)
            throws IOException
        {
            if (eV)
            {
                jz1.a(1, eV);
            }
            jz1.f(2, eT);
            if (eS != null && eS.length > 0)
            {
                for (int k = 0; k < eS.length; k++)
                {
                    jz1.f(3, eS[k]);
                }

            }
            if (name != 0)
            {
                jz1.f(4, name);
            }
            if (eU)
            {
                jz1.a(6, eU);
            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return c(jy1);
        }

        public int c()
        {
            int l = 0;
            int i1 = super.c();
            int k = i1;
            if (eV)
            {
                k = i1 + jz.b(1, eV);
            }
            i1 = jz.g(2, eT) + k;
            if (eS != null && eS.length > 0)
            {
                for (k = 0; k < eS.length; k++)
                {
                    l += jz.cC(eS[k]);
                }

                l = i1 + l + eS.length * 1;
            } else
            {
                l = i1;
            }
            k = l;
            if (name != 0)
            {
                k = l + jz.g(4, name);
            }
            l = k;
            if (eU)
            {
                l = k + jz.b(6, eU);
            }
            DY = l;
            return l;
        }

        public b c(jy jy1)
            throws IOException
        {
            do
            {
                int k = jy1.ky();
                switch (k)
                {
                default:
                    if (a(jy1, k))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 8: // '\b'
                    eV = jy1.kC();
                    break;

                case 16: // '\020'
                    eT = jy1.kB();
                    break;

                case 24: // '\030'
                    int j1 = kh.c(jy1, 24);
                    int ai[];
                    int l;
                    if (eS == null)
                    {
                        l = 0;
                    } else
                    {
                        l = eS.length;
                    }
                    ai = new int[j1 + l];
                    j1 = l;
                    if (l != 0)
                    {
                        System.arraycopy(eS, 0, ai, 0, l);
                        j1 = l;
                    }
                    for (; j1 < ai.length - 1; j1++)
                    {
                        ai[j1] = jy1.kB();
                        jy1.ky();
                    }

                    ai[j1] = jy1.kB();
                    eS = ai;
                    break;

                case 26: // '\032'
                    int l1 = jy1.cw(jy1.kE());
                    int i1 = jy1.getPosition();
                    int k1;
                    for (k1 = 0; jy1.kJ() > 0; k1++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(i1);
                    int ai1[];
                    if (eS == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = eS.length;
                    }
                    ai1 = new int[k1 + i1];
                    k1 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(eS, 0, ai1, 0, i1);
                        k1 = i1;
                    }
                    for (; k1 < ai1.length; k1++)
                    {
                        ai1[k1] = jy1.kB();
                    }

                    eS = ai1;
                    jy1.cx(l1);
                    break;

                case 32: // ' '
                    name = jy1.kB();
                    break;

                case 48: // '0'
                    eU = jy1.kC();
                    break;
                }
            } while (true);
        }

        public b e()
        {
            eS = kh.aaj;
            eT = 0;
            name = 0;
            eU = false;
            eV = false;
            aae = null;
            DY = -1;
            return this;
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
            if (!(obj instanceof b)) goto _L4; else goto _L3
_L3:
            obj = (b)obj;
            flag = flag1;
            if (!kc.equals(eS, ((b) (obj)).eS)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (eT != ((b) (obj)).eT) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (name != ((b) (obj)).name) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (eU != ((b) (obj)).eU) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (eV != ((b) (obj)).eV) goto _L4; else goto _L9
_L9:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_135;
            }
            if (((b) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((b) (obj)).aae.isEmpty()) goto _L4; else goto _L10
_L10:
            return true;
            return aae.equals(((b) (obj)).aae);
        }

        public int hashCode()
        {
            char c2 = '\u04CF';
            int l = kc.hashCode(eS);
            int i1 = eT;
            int j1 = name;
            char c1;
            int k;
            if (eU)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            if (!eV)
            {
                c2 = '\u04D5';
            }
            if (aae == null || aae.isEmpty())
            {
                k = 0;
            } else
            {
                k = aae.hashCode();
            }
            return k + ((c1 + (((l + 527) * 31 + i1) * 31 + j1) * 31) * 31 + c2) * 31;
        }

        public b()
        {
            e();
        }
    }

    public static final class c extends ka
    {

        private static volatile c eW[];
        public String eX;
        public long eY;
        public long eZ;
        public boolean fa;
        public long fb;

        public static c[] f()
        {
            if (eW == null)
            {
                synchronized (kc.aah)
                {
                    if (eW == null)
                    {
                        eW = new c[0];
                    }
                }
            }
            return eW;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(jz jz1)
            throws IOException
        {
            if (!eX.equals(""))
            {
                jz1.b(1, eX);
            }
            if (eY != 0L)
            {
                jz1.b(2, eY);
            }
            if (eZ != 0x7fffffffL)
            {
                jz1.b(3, eZ);
            }
            if (fa)
            {
                jz1.a(4, fa);
            }
            if (fb != 0L)
            {
                jz1.b(5, fb);
            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return d(jy1);
        }

        public int c()
        {
            int l = super.c();
            int k = l;
            if (!eX.equals(""))
            {
                k = l + jz.g(1, eX);
            }
            l = k;
            if (eY != 0L)
            {
                l = k + jz.d(2, eY);
            }
            k = l;
            if (eZ != 0x7fffffffL)
            {
                k = l + jz.d(3, eZ);
            }
            l = k;
            if (fa)
            {
                l = k + jz.b(4, fa);
            }
            k = l;
            if (fb != 0L)
            {
                k = l + jz.d(5, fb);
            }
            DY = k;
            return k;
        }

        public c d(jy jy1)
            throws IOException
        {
            do
            {
                int k = jy1.ky();
                switch (k)
                {
                default:
                    if (a(jy1, k))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 10: // '\n'
                    eX = jy1.readString();
                    break;

                case 16: // '\020'
                    eY = jy1.kA();
                    break;

                case 24: // '\030'
                    eZ = jy1.kA();
                    break;

                case 32: // ' '
                    fa = jy1.kC();
                    break;

                case 40: // '('
                    fb = jy1.kA();
                    break;
                }
            } while (true);
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
            if (!(obj instanceof c)) goto _L4; else goto _L3
_L3:
            obj = (c)obj;
            if (eX != null)
            {
                break MISSING_BLOCK_LABEL_138;
            }
            flag = flag1;
            if (((c) (obj)).eX != null) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (eY != ((c) (obj)).eY) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (eZ != ((c) (obj)).eZ) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (fa != ((c) (obj)).fa) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (fb != ((c) (obj)).fb) goto _L4; else goto _L9
_L9:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_154;
            }
            if (((c) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((c) (obj)).aae.isEmpty()) goto _L4; else goto _L10
_L10:
            return true;
            if (!eX.equals(((c) (obj)).eX))
            {
                return false;
            }
              goto _L5
            return aae.equals(((c) (obj)).aae);
        }

        public c g()
        {
            eX = "";
            eY = 0L;
            eZ = 0x7fffffffL;
            fa = false;
            fb = 0L;
            aae = null;
            DY = -1;
            return this;
        }

        public int hashCode()
        {
            boolean flag = false;
            int k;
            char c1;
            int l;
            int i1;
            int j1;
            int k1;
            if (eX == null)
            {
                k = 0;
            } else
            {
                k = eX.hashCode();
            }
            i1 = (int)(eY ^ eY >>> 32);
            j1 = (int)(eZ ^ eZ >>> 32);
            if (fa)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            k1 = (int)(fb ^ fb >>> 32);
            l = ((flag) ? 1 : 0);
            if (aae != null)
            {
                if (aae.isEmpty())
                {
                    l = ((flag) ? 1 : 0);
                } else
                {
                    l = aae.hashCode();
                }
            }
            return ((c1 + (((k + 527) * 31 + i1) * 31 + j1) * 31) * 31 + k1) * 31 + l;
        }

        public c()
        {
            g();
        }
    }

    public static final class d extends ka
    {

        public d.a fc[];
        public d.a fd[];
        public c fe[];

        public void a(jz jz1)
            throws IOException
        {
            boolean flag = false;
            if (fc != null && fc.length > 0)
            {
                for (int k = 0; k < fc.length; k++)
                {
                    d.a a1 = fc[k];
                    if (a1 != null)
                    {
                        jz1.a(1, a1);
                    }
                }

            }
            if (fd != null && fd.length > 0)
            {
                for (int l = 0; l < fd.length; l++)
                {
                    d.a a2 = fd[l];
                    if (a2 != null)
                    {
                        jz1.a(2, a2);
                    }
                }

            }
            if (fe != null && fe.length > 0)
            {
                for (int i1 = ((flag) ? 1 : 0); i1 < fe.length; i1++)
                {
                    c c1 = fe[i1];
                    if (c1 != null)
                    {
                        jz1.a(3, c1);
                    }
                }

            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return e(jy1);
        }

        public int c()
        {
            boolean flag = false;
            int k = super.c();
            int l = k;
            if (fc != null)
            {
                l = k;
                if (fc.length > 0)
                {
                    for (l = 0; l < fc.length;)
                    {
                        d.a a1 = fc[l];
                        int k1 = k;
                        if (a1 != null)
                        {
                            k1 = k + jz.b(1, a1);
                        }
                        l++;
                        k = k1;
                    }

                    l = k;
                }
            }
            k = l;
            if (fd != null)
            {
                k = l;
                if (fd.length > 0)
                {
                    k = l;
                    for (int i1 = 0; i1 < fd.length;)
                    {
                        d.a a2 = fd[i1];
                        int l1 = k;
                        if (a2 != null)
                        {
                            l1 = k + jz.b(2, a2);
                        }
                        i1++;
                        k = l1;
                    }

                }
            }
            int i2 = k;
            if (fe != null)
            {
                i2 = k;
                if (fe.length > 0)
                {
                    int j1 = ((flag) ? 1 : 0);
                    do
                    {
                        i2 = k;
                        if (j1 >= fe.length)
                        {
                            break;
                        }
                        c c1 = fe[j1];
                        i2 = k;
                        if (c1 != null)
                        {
                            i2 = k + jz.b(3, c1);
                        }
                        j1++;
                        k = i2;
                    } while (true);
                }
            }
            DY = i2;
            return i2;
        }

        public d e(jy jy1)
            throws IOException
        {
            do
            {
                int k = jy1.ky();
                switch (k)
                {
                default:
                    if (a(jy1, k))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 10: // '\n'
                    int k1 = kh.c(jy1, 10);
                    d.a aa[];
                    int l;
                    if (fc == null)
                    {
                        l = 0;
                    } else
                    {
                        l = fc.length;
                    }
                    aa = new d.a[k1 + l];
                    k1 = l;
                    if (l != 0)
                    {
                        System.arraycopy(fc, 0, aa, 0, l);
                        k1 = l;
                    }
                    for (; k1 < aa.length - 1; k1++)
                    {
                        aa[k1] = new d.a();
                        jy1.a(aa[k1]);
                        jy1.ky();
                    }

                    aa[k1] = new d.a();
                    jy1.a(aa[k1]);
                    fc = aa;
                    break;

                case 18: // '\022'
                    int l1 = kh.c(jy1, 18);
                    d.a aa1[];
                    int i1;
                    if (fd == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = fd.length;
                    }
                    aa1 = new d.a[l1 + i1];
                    l1 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(fd, 0, aa1, 0, i1);
                        l1 = i1;
                    }
                    for (; l1 < aa1.length - 1; l1++)
                    {
                        aa1[l1] = new d.a();
                        jy1.a(aa1[l1]);
                        jy1.ky();
                    }

                    aa1[l1] = new d.a();
                    jy1.a(aa1[l1]);
                    fd = aa1;
                    break;

                case 26: // '\032'
                    int i2 = kh.c(jy1, 26);
                    c ac[];
                    int j1;
                    if (fe == null)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = fe.length;
                    }
                    ac = new c[i2 + j1];
                    i2 = j1;
                    if (j1 != 0)
                    {
                        System.arraycopy(fe, 0, ac, 0, j1);
                        i2 = j1;
                    }
                    for (; i2 < ac.length - 1; i2++)
                    {
                        ac[i2] = new c();
                        jy1.a(ac[i2]);
                        jy1.ky();
                    }

                    ac[i2] = new c();
                    jy1.a(ac[i2]);
                    fe = ac;
                    break;
                }
            } while (true);
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
            if (!(obj instanceof d)) goto _L4; else goto _L3
_L3:
            obj = (d)obj;
            flag = flag1;
            if (!kc.equals(fc, ((d) (obj)).fc)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (!kc.equals(fd, ((d) (obj)).fd)) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (!kc.equals(fe, ((d) (obj)).fe)) goto _L4; else goto _L7
_L7:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_115;
            }
            if (((d) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((d) (obj)).aae.isEmpty()) goto _L4; else goto _L8
_L8:
            return true;
            return aae.equals(((d) (obj)).aae);
        }

        public d h()
        {
            fc = com.google.android.gms.internal.d.a.r();
            fd = com.google.android.gms.internal.d.a.r();
            fe = c.f();
            aae = null;
            DY = -1;
            return this;
        }

        public int hashCode()
        {
            int l = kc.hashCode(fc);
            int i1 = kc.hashCode(fd);
            int j1 = kc.hashCode(fe);
            int k;
            if (aae == null || aae.isEmpty())
            {
                k = 0;
            } else
            {
                k = aae.hashCode();
            }
            return k + (((l + 527) * 31 + i1) * 31 + j1) * 31;
        }

        public d()
        {
            h();
        }
    }

    public static final class e extends ka
    {

        private static volatile e ff[];
        public int key;
        public int value;

        public static e[] i()
        {
            if (ff == null)
            {
                synchronized (kc.aah)
                {
                    if (ff == null)
                    {
                        ff = new e[0];
                    }
                }
            }
            return ff;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(jz jz1)
            throws IOException
        {
            jz1.f(1, key);
            jz1.f(2, value);
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return f(jy1);
        }

        public int c()
        {
            int k = super.c() + jz.g(1, key) + jz.g(2, value);
            DY = k;
            return k;
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
            if (!(obj instanceof e)) goto _L4; else goto _L3
_L3:
            obj = (e)obj;
            flag = flag1;
            if (key != ((e) (obj)).key) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (value != ((e) (obj)).value) goto _L4; else goto _L6
_L6:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_93;
            }
            if (((e) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((e) (obj)).aae.isEmpty()) goto _L4; else goto _L7
_L7:
            return true;
            return aae.equals(((e) (obj)).aae);
        }

        public e f(jy jy1)
            throws IOException
        {
            do
            {
                int k = jy1.ky();
                switch (k)
                {
                default:
                    if (a(jy1, k))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 8: // '\b'
                    key = jy1.kB();
                    break;

                case 16: // '\020'
                    value = jy1.kB();
                    break;
                }
            } while (true);
        }

        public int hashCode()
        {
            int l = key;
            int i1 = value;
            int k;
            if (aae == null || aae.isEmpty())
            {
                k = 0;
            } else
            {
                k = aae.hashCode();
            }
            return k + ((l + 527) * 31 + i1) * 31;
        }

        public e j()
        {
            key = 0;
            value = 0;
            aae = null;
            DY = -1;
            return this;
        }

        public e()
        {
            j();
        }
    }

    public static final class f extends ka
    {

        public String fg[];
        public String fh[];
        public d.a fi[];
        public e fj[];
        public b fk[];
        public b fl[];
        public b fm[];
        public g fn[];
        public String fo;
        public String fp;
        public String fq;
        public String fr;
        public a fs;
        public float ft;
        public boolean fu;
        public String fv[];
        public int fw;

        public static f a(byte abyte0[])
            throws kd
        {
            return (f)ke.a(new f(), abyte0);
        }

        public void a(jz jz1)
            throws IOException
        {
            boolean flag = false;
            if (fh != null && fh.length > 0)
            {
                for (int l = 0; l < fh.length; l++)
                {
                    String s = fh[l];
                    if (s != null)
                    {
                        jz1.b(1, s);
                    }
                }

            }
            if (fi != null && fi.length > 0)
            {
                for (int i1 = 0; i1 < fi.length; i1++)
                {
                    d.a a1 = fi[i1];
                    if (a1 != null)
                    {
                        jz1.a(2, a1);
                    }
                }

            }
            if (fj != null && fj.length > 0)
            {
                for (int j1 = 0; j1 < fj.length; j1++)
                {
                    e e1 = fj[j1];
                    if (e1 != null)
                    {
                        jz1.a(3, e1);
                    }
                }

            }
            if (fk != null && fk.length > 0)
            {
                for (int k1 = 0; k1 < fk.length; k1++)
                {
                    b b1 = fk[k1];
                    if (b1 != null)
                    {
                        jz1.a(4, b1);
                    }
                }

            }
            if (fl != null && fl.length > 0)
            {
                for (int l1 = 0; l1 < fl.length; l1++)
                {
                    b b2 = fl[l1];
                    if (b2 != null)
                    {
                        jz1.a(5, b2);
                    }
                }

            }
            if (fm != null && fm.length > 0)
            {
                for (int i2 = 0; i2 < fm.length; i2++)
                {
                    b b3 = fm[i2];
                    if (b3 != null)
                    {
                        jz1.a(6, b3);
                    }
                }

            }
            if (fn != null && fn.length > 0)
            {
                for (int j2 = 0; j2 < fn.length; j2++)
                {
                    g g1 = fn[j2];
                    if (g1 != null)
                    {
                        jz1.a(7, g1);
                    }
                }

            }
            if (!fo.equals(""))
            {
                jz1.b(9, fo);
            }
            if (!fp.equals(""))
            {
                jz1.b(10, fp);
            }
            if (!fq.equals("0"))
            {
                jz1.b(12, fq);
            }
            if (!fr.equals(""))
            {
                jz1.b(13, fr);
            }
            if (fs != null)
            {
                jz1.a(14, fs);
            }
            if (Float.floatToIntBits(ft) != Float.floatToIntBits(0.0F))
            {
                jz1.a(15, ft);
            }
            if (fv != null && fv.length > 0)
            {
                for (int k2 = 0; k2 < fv.length; k2++)
                {
                    String s1 = fv[k2];
                    if (s1 != null)
                    {
                        jz1.b(16, s1);
                    }
                }

            }
            if (fw != 0)
            {
                jz1.f(17, fw);
            }
            if (fu)
            {
                jz1.a(18, fu);
            }
            if (fg != null && fg.length > 0)
            {
                for (int l2 = ((flag) ? 1 : 0); l2 < fg.length; l2++)
                {
                    String s2 = fg[l2];
                    if (s2 != null)
                    {
                        jz1.b(19, s2);
                    }
                }

            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return g(jy1);
        }

        public int c()
        {
            boolean flag = false;
            int j5 = super.c();
            int i1;
            int j1;
            int j3;
            if (fh != null && fh.length > 0)
            {
                int l = 0;
                j1 = 0;
                int k1;
                int l3;
                for (k1 = 0; l < fh.length; k1 = l3)
                {
                    String s = fh[l];
                    int k4 = j1;
                    l3 = k1;
                    if (s != null)
                    {
                        l3 = k1 + 1;
                        k4 = j1 + jz.bQ(s);
                    }
                    l++;
                    j1 = k4;
                }

                j1 = j5 + j1 + k1 * 1;
            } else
            {
                j1 = j5;
            }
            i1 = j1;
            if (fi != null)
            {
                i1 = j1;
                if (fi.length > 0)
                {
                    i1 = j1;
                    for (j1 = 0; j1 < fi.length;)
                    {
                        d.a a1 = fi[j1];
                        int l1 = i1;
                        if (a1 != null)
                        {
                            l1 = i1 + jz.b(2, a1);
                        }
                        j1++;
                        i1 = l1;
                    }

                }
            }
            j1 = i1;
            if (fj != null)
            {
                j1 = i1;
                if (fj.length > 0)
                {
                    for (j1 = 0; j1 < fj.length;)
                    {
                        e e1 = fj[j1];
                        int i2 = i1;
                        if (e1 != null)
                        {
                            i2 = i1 + jz.b(3, e1);
                        }
                        j1++;
                        i1 = i2;
                    }

                    j1 = i1;
                }
            }
            i1 = j1;
            if (fk != null)
            {
                i1 = j1;
                if (fk.length > 0)
                {
                    i1 = j1;
                    for (j1 = 0; j1 < fk.length;)
                    {
                        b b1 = fk[j1];
                        int j2 = i1;
                        if (b1 != null)
                        {
                            j2 = i1 + jz.b(4, b1);
                        }
                        j1++;
                        i1 = j2;
                    }

                }
            }
            j1 = i1;
            if (fl != null)
            {
                j1 = i1;
                if (fl.length > 0)
                {
                    for (j1 = 0; j1 < fl.length;)
                    {
                        b b2 = fl[j1];
                        int k2 = i1;
                        if (b2 != null)
                        {
                            k2 = i1 + jz.b(5, b2);
                        }
                        j1++;
                        i1 = k2;
                    }

                    j1 = i1;
                }
            }
            i1 = j1;
            if (fm != null)
            {
                i1 = j1;
                if (fm.length > 0)
                {
                    i1 = j1;
                    for (j1 = 0; j1 < fm.length;)
                    {
                        b b3 = fm[j1];
                        int l2 = i1;
                        if (b3 != null)
                        {
                            l2 = i1 + jz.b(6, b3);
                        }
                        j1++;
                        i1 = l2;
                    }

                }
            }
            j1 = i1;
            if (fn != null)
            {
                j1 = i1;
                if (fn.length > 0)
                {
                    for (j1 = 0; j1 < fn.length;)
                    {
                        g g1 = fn[j1];
                        int i3 = i1;
                        if (g1 != null)
                        {
                            i3 = i1 + jz.b(7, g1);
                        }
                        j1++;
                        i1 = i3;
                    }

                    j1 = i1;
                }
            }
            i1 = j1;
            if (!fo.equals(""))
            {
                i1 = j1 + jz.g(9, fo);
            }
            j1 = i1;
            if (!fp.equals(""))
            {
                j1 = i1 + jz.g(10, fp);
            }
            i1 = j1;
            if (!fq.equals("0"))
            {
                i1 = j1 + jz.g(12, fq);
            }
            j1 = i1;
            if (!fr.equals(""))
            {
                j1 = i1 + jz.g(13, fr);
            }
            j3 = j1;
            if (fs != null)
            {
                j3 = j1 + jz.b(14, fs);
            }
            i1 = j3;
            if (Float.floatToIntBits(ft) != Float.floatToIntBits(0.0F))
            {
                i1 = j3 + jz.b(15, ft);
            }
            j1 = i1;
            if (fv != null)
            {
                j1 = i1;
                if (fv.length > 0)
                {
                    j1 = 0;
                    j3 = 0;
                    int i4;
                    int l4;
                    for (i4 = 0; j1 < fv.length; i4 = l4)
                    {
                        String s1 = fv[j1];
                        j5 = j3;
                        l4 = i4;
                        if (s1 != null)
                        {
                            l4 = i4 + 1;
                            j5 = j3 + jz.bQ(s1);
                        }
                        j1++;
                        j3 = j5;
                    }

                    j1 = i1 + j3 + i4 * 2;
                }
            }
            j3 = j1;
            if (fw != 0)
            {
                j3 = j1 + jz.g(17, fw);
            }
            i1 = j3;
            if (fu)
            {
                i1 = j3 + jz.b(18, fu);
            }
            j1 = i1;
            if (fg != null)
            {
                j1 = i1;
                if (fg.length > 0)
                {
                    int k3 = 0;
                    int j4 = 0;
                    for (j1 = ((flag) ? 1 : 0); j1 < fg.length;)
                    {
                        String s2 = fg[j1];
                        j5 = k3;
                        int i5 = j4;
                        if (s2 != null)
                        {
                            i5 = j4 + 1;
                            j5 = k3 + jz.bQ(s2);
                        }
                        j1++;
                        k3 = j5;
                        j4 = i5;
                    }

                    j1 = i1 + k3 + j4 * 2;
                }
            }
            DY = j1;
            return j1;
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
            if (!(obj instanceof f)) goto _L4; else goto _L3
_L3:
            obj = (f)obj;
            flag = flag1;
            if (!kc.equals(fg, ((f) (obj)).fg)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (!kc.equals(fh, ((f) (obj)).fh)) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (!kc.equals(fi, ((f) (obj)).fi)) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (!kc.equals(fj, ((f) (obj)).fj)) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!kc.equals(fk, ((f) (obj)).fk)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (!kc.equals(fl, ((f) (obj)).fl)) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (!kc.equals(fm, ((f) (obj)).fm)) goto _L4; else goto _L11
_L11:
            flag = flag1;
            if (!kc.equals(fn, ((f) (obj)).fn)) goto _L4; else goto _L12
_L12:
            if (fo != null) goto _L14; else goto _L13
_L13:
            flag = flag1;
            if (((f) (obj)).fo != null) goto _L4; else goto _L15
_L15:
            if (fp != null) goto _L17; else goto _L16
_L16:
            flag = flag1;
            if (((f) (obj)).fp != null) goto _L4; else goto _L18
_L18:
            if (fq != null) goto _L20; else goto _L19
_L19:
            flag = flag1;
            if (((f) (obj)).fq != null) goto _L4; else goto _L21
_L21:
            if (fr != null) goto _L23; else goto _L22
_L22:
            flag = flag1;
            if (((f) (obj)).fr != null) goto _L4; else goto _L24
_L24:
            if (fs != null) goto _L26; else goto _L25
_L25:
            flag = flag1;
            if (((f) (obj)).fs != null) goto _L4; else goto _L27
_L27:
            flag = flag1;
            if (Float.floatToIntBits(ft) != Float.floatToIntBits(((f) (obj)).ft)) goto _L4; else goto _L28
_L28:
            flag = flag1;
            if (fu != ((f) (obj)).fu) goto _L4; else goto _L29
_L29:
            flag = flag1;
            if (!kc.equals(fv, ((f) (obj)).fv)) goto _L4; else goto _L30
_L30:
            flag = flag1;
            if (fw != ((f) (obj)).fw) goto _L4; else goto _L31
_L31:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_416;
            }
            if (((f) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((f) (obj)).aae.isEmpty()) goto _L4; else goto _L32
_L32:
            return true;
_L14:
            if (!fo.equals(((f) (obj)).fo))
            {
                return false;
            }
              goto _L15
_L17:
            if (!fp.equals(((f) (obj)).fp))
            {
                return false;
            }
              goto _L18
_L20:
            if (!fq.equals(((f) (obj)).fq))
            {
                return false;
            }
              goto _L21
_L23:
            if (!fr.equals(((f) (obj)).fr))
            {
                return false;
            }
              goto _L24
_L26:
            if (!fs.equals(((f) (obj)).fs))
            {
                return false;
            }
              goto _L27
            return aae.equals(((f) (obj)).aae);
              goto _L15
        }

        public f g(jy jy1)
            throws IOException
        {
            do
            {
                int l = jy1.ky();
                switch (l)
                {
                default:
                    if (a(jy1, l))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 10: // '\n'
                    int j3 = kh.c(jy1, 10);
                    String as[];
                    int i1;
                    if (fh == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = fh.length;
                    }
                    as = new String[j3 + i1];
                    j3 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(fh, 0, as, 0, i1);
                        j3 = i1;
                    }
                    for (; j3 < as.length - 1; j3++)
                    {
                        as[j3] = jy1.readString();
                        jy1.ky();
                    }

                    as[j3] = jy1.readString();
                    fh = as;
                    break;

                case 18: // '\022'
                    int k3 = kh.c(jy1, 18);
                    d.a aa[];
                    int j1;
                    if (fi == null)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = fi.length;
                    }
                    aa = new d.a[k3 + j1];
                    k3 = j1;
                    if (j1 != 0)
                    {
                        System.arraycopy(fi, 0, aa, 0, j1);
                        k3 = j1;
                    }
                    for (; k3 < aa.length - 1; k3++)
                    {
                        aa[k3] = new d.a();
                        jy1.a(aa[k3]);
                        jy1.ky();
                    }

                    aa[k3] = new d.a();
                    jy1.a(aa[k3]);
                    fi = aa;
                    break;

                case 26: // '\032'
                    int l3 = kh.c(jy1, 26);
                    e ae[];
                    int k1;
                    if (fj == null)
                    {
                        k1 = 0;
                    } else
                    {
                        k1 = fj.length;
                    }
                    ae = new e[l3 + k1];
                    l3 = k1;
                    if (k1 != 0)
                    {
                        System.arraycopy(fj, 0, ae, 0, k1);
                        l3 = k1;
                    }
                    for (; l3 < ae.length - 1; l3++)
                    {
                        ae[l3] = new e();
                        jy1.a(ae[l3]);
                        jy1.ky();
                    }

                    ae[l3] = new e();
                    jy1.a(ae[l3]);
                    fj = ae;
                    break;

                case 34: // '"'
                    int i4 = kh.c(jy1, 34);
                    b ab[];
                    int l1;
                    if (fk == null)
                    {
                        l1 = 0;
                    } else
                    {
                        l1 = fk.length;
                    }
                    ab = new b[i4 + l1];
                    i4 = l1;
                    if (l1 != 0)
                    {
                        System.arraycopy(fk, 0, ab, 0, l1);
                        i4 = l1;
                    }
                    for (; i4 < ab.length - 1; i4++)
                    {
                        ab[i4] = new b();
                        jy1.a(ab[i4]);
                        jy1.ky();
                    }

                    ab[i4] = new b();
                    jy1.a(ab[i4]);
                    fk = ab;
                    break;

                case 42: // '*'
                    int j4 = kh.c(jy1, 42);
                    b ab1[];
                    int i2;
                    if (fl == null)
                    {
                        i2 = 0;
                    } else
                    {
                        i2 = fl.length;
                    }
                    ab1 = new b[j4 + i2];
                    j4 = i2;
                    if (i2 != 0)
                    {
                        System.arraycopy(fl, 0, ab1, 0, i2);
                        j4 = i2;
                    }
                    for (; j4 < ab1.length - 1; j4++)
                    {
                        ab1[j4] = new b();
                        jy1.a(ab1[j4]);
                        jy1.ky();
                    }

                    ab1[j4] = new b();
                    jy1.a(ab1[j4]);
                    fl = ab1;
                    break;

                case 50: // '2'
                    int k4 = kh.c(jy1, 50);
                    b ab2[];
                    int j2;
                    if (fm == null)
                    {
                        j2 = 0;
                    } else
                    {
                        j2 = fm.length;
                    }
                    ab2 = new b[k4 + j2];
                    k4 = j2;
                    if (j2 != 0)
                    {
                        System.arraycopy(fm, 0, ab2, 0, j2);
                        k4 = j2;
                    }
                    for (; k4 < ab2.length - 1; k4++)
                    {
                        ab2[k4] = new b();
                        jy1.a(ab2[k4]);
                        jy1.ky();
                    }

                    ab2[k4] = new b();
                    jy1.a(ab2[k4]);
                    fm = ab2;
                    break;

                case 58: // ':'
                    int l4 = kh.c(jy1, 58);
                    g ag[];
                    int k2;
                    if (fn == null)
                    {
                        k2 = 0;
                    } else
                    {
                        k2 = fn.length;
                    }
                    ag = new g[l4 + k2];
                    l4 = k2;
                    if (k2 != 0)
                    {
                        System.arraycopy(fn, 0, ag, 0, k2);
                        l4 = k2;
                    }
                    for (; l4 < ag.length - 1; l4++)
                    {
                        ag[l4] = new g();
                        jy1.a(ag[l4]);
                        jy1.ky();
                    }

                    ag[l4] = new g();
                    jy1.a(ag[l4]);
                    fn = ag;
                    break;

                case 74: // 'J'
                    fo = jy1.readString();
                    break;

                case 82: // 'R'
                    fp = jy1.readString();
                    break;

                case 98: // 'b'
                    fq = jy1.readString();
                    break;

                case 106: // 'j'
                    fr = jy1.readString();
                    break;

                case 114: // 'r'
                    if (fs == null)
                    {
                        fs = new a();
                    }
                    jy1.a(fs);
                    break;

                case 125: // '}'
                    ft = jy1.readFloat();
                    break;

                case 130: 
                    int i5 = kh.c(jy1, 130);
                    String as1[];
                    int l2;
                    if (fv == null)
                    {
                        l2 = 0;
                    } else
                    {
                        l2 = fv.length;
                    }
                    as1 = new String[i5 + l2];
                    i5 = l2;
                    if (l2 != 0)
                    {
                        System.arraycopy(fv, 0, as1, 0, l2);
                        i5 = l2;
                    }
                    for (; i5 < as1.length - 1; i5++)
                    {
                        as1[i5] = jy1.readString();
                        jy1.ky();
                    }

                    as1[i5] = jy1.readString();
                    fv = as1;
                    break;

                case 136: 
                    fw = jy1.kB();
                    break;

                case 144: 
                    fu = jy1.kC();
                    break;

                case 154: 
                    int j5 = kh.c(jy1, 154);
                    String as2[];
                    int i3;
                    if (fg == null)
                    {
                        i3 = 0;
                    } else
                    {
                        i3 = fg.length;
                    }
                    as2 = new String[j5 + i3];
                    j5 = i3;
                    if (i3 != 0)
                    {
                        System.arraycopy(fg, 0, as2, 0, i3);
                        j5 = i3;
                    }
                    for (; j5 < as2.length - 1; j5++)
                    {
                        as2[j5] = jy1.readString();
                        jy1.ky();
                    }

                    as2[j5] = jy1.readString();
                    fg = as2;
                    break;
                }
            } while (true);
        }

        public int hashCode()
        {
            boolean flag = false;
            int j2 = kc.hashCode(fg);
            int k2 = kc.hashCode(fh);
            int l2 = kc.hashCode(fi);
            int i3 = kc.hashCode(fj);
            int j3 = kc.hashCode(fk);
            int k3 = kc.hashCode(fl);
            int l3 = kc.hashCode(fm);
            int i4 = kc.hashCode(fn);
            int l;
            int i1;
            int j1;
            int k1;
            int l1;
            char c1;
            int i2;
            int j4;
            int k4;
            int l4;
            if (fo == null)
            {
                l = 0;
            } else
            {
                l = fo.hashCode();
            }
            if (fp == null)
            {
                i1 = 0;
            } else
            {
                i1 = fp.hashCode();
            }
            if (fq == null)
            {
                j1 = 0;
            } else
            {
                j1 = fq.hashCode();
            }
            if (fr == null)
            {
                k1 = 0;
            } else
            {
                k1 = fr.hashCode();
            }
            if (fs == null)
            {
                l1 = 0;
            } else
            {
                l1 = fs.hashCode();
            }
            j4 = Float.floatToIntBits(ft);
            if (fu)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            k4 = kc.hashCode(fv);
            l4 = fw;
            i2 = ((flag) ? 1 : 0);
            if (aae != null)
            {
                if (aae.isEmpty())
                {
                    i2 = ((flag) ? 1 : 0);
                } else
                {
                    i2 = aae.hashCode();
                }
            }
            return (((c1 + ((l1 + (k1 + (j1 + (i1 + (l + ((((((((j2 + 527) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31) * 31) * 31) * 31) * 31) * 31 + j4) * 31) * 31 + k4) * 31 + l4) * 31 + i2;
        }

        public f k()
        {
            fg = kh.aao;
            fh = kh.aao;
            fi = com.google.android.gms.internal.d.a.r();
            fj = e.i();
            fk = b.d();
            fl = b.d();
            fm = b.d();
            fn = g.l();
            fo = "";
            fp = "";
            fq = "0";
            fr = "";
            fs = null;
            ft = 0.0F;
            fu = false;
            fv = kh.aao;
            fw = 0;
            aae = null;
            DY = -1;
            return this;
        }

        public f()
        {
            k();
        }
    }

    public static final class g extends ka
    {

        private static volatile g fx[];
        public int fA[];
        public int fB[];
        public int fC[];
        public int fD[];
        public int fE[];
        public int fF[];
        public int fG[];
        public int fH[];
        public int fy[];
        public int fz[];

        public static g[] l()
        {
            if (fx == null)
            {
                synchronized (kc.aah)
                {
                    if (fx == null)
                    {
                        fx = new g[0];
                    }
                }
            }
            return fx;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(jz jz1)
            throws IOException
        {
            boolean flag = false;
            if (fy != null && fy.length > 0)
            {
                for (int k = 0; k < fy.length; k++)
                {
                    jz1.f(1, fy[k]);
                }

            }
            if (fz != null && fz.length > 0)
            {
                for (int i1 = 0; i1 < fz.length; i1++)
                {
                    jz1.f(2, fz[i1]);
                }

            }
            if (fA != null && fA.length > 0)
            {
                for (int j1 = 0; j1 < fA.length; j1++)
                {
                    jz1.f(3, fA[j1]);
                }

            }
            if (fB != null && fB.length > 0)
            {
                for (int k1 = 0; k1 < fB.length; k1++)
                {
                    jz1.f(4, fB[k1]);
                }

            }
            if (fC != null && fC.length > 0)
            {
                for (int l1 = 0; l1 < fC.length; l1++)
                {
                    jz1.f(5, fC[l1]);
                }

            }
            if (fD != null && fD.length > 0)
            {
                for (int i2 = 0; i2 < fD.length; i2++)
                {
                    jz1.f(6, fD[i2]);
                }

            }
            if (fE != null && fE.length > 0)
            {
                for (int j2 = 0; j2 < fE.length; j2++)
                {
                    jz1.f(7, fE[j2]);
                }

            }
            if (fF != null && fF.length > 0)
            {
                for (int k2 = 0; k2 < fF.length; k2++)
                {
                    jz1.f(8, fF[k2]);
                }

            }
            if (fG != null && fG.length > 0)
            {
                for (int l2 = 0; l2 < fG.length; l2++)
                {
                    jz1.f(9, fG[l2]);
                }

            }
            if (fH != null && fH.length > 0)
            {
                for (int i3 = ((flag) ? 1 : 0); i3 < fH.length; i3++)
                {
                    jz1.f(10, fH[i3]);
                }

            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return h(jy1);
        }

        public int c()
        {
            boolean flag = false;
            int k1 = super.c();
            int i1;
            int j1;
            if (fy != null && fy.length > 0)
            {
                int k = 0;
                j1 = 0;
                for (; k < fy.length; k++)
                {
                    j1 += jz.cC(fy[k]);
                }

                j1 = k1 + j1 + fy.length * 1;
            } else
            {
                j1 = k1;
            }
            i1 = j1;
            if (fz != null)
            {
                i1 = j1;
                if (fz.length > 0)
                {
                    i1 = 0;
                    k1 = 0;
                    for (; i1 < fz.length; i1++)
                    {
                        k1 += jz.cC(fz[i1]);
                    }

                    i1 = j1 + k1 + fz.length * 1;
                }
            }
            j1 = i1;
            if (fA != null)
            {
                j1 = i1;
                if (fA.length > 0)
                {
                    j1 = 0;
                    k1 = 0;
                    for (; j1 < fA.length; j1++)
                    {
                        k1 += jz.cC(fA[j1]);
                    }

                    j1 = i1 + k1 + fA.length * 1;
                }
            }
            i1 = j1;
            if (fB != null)
            {
                i1 = j1;
                if (fB.length > 0)
                {
                    i1 = 0;
                    k1 = 0;
                    for (; i1 < fB.length; i1++)
                    {
                        k1 += jz.cC(fB[i1]);
                    }

                    i1 = j1 + k1 + fB.length * 1;
                }
            }
            j1 = i1;
            if (fC != null)
            {
                j1 = i1;
                if (fC.length > 0)
                {
                    j1 = 0;
                    k1 = 0;
                    for (; j1 < fC.length; j1++)
                    {
                        k1 += jz.cC(fC[j1]);
                    }

                    j1 = i1 + k1 + fC.length * 1;
                }
            }
            i1 = j1;
            if (fD != null)
            {
                i1 = j1;
                if (fD.length > 0)
                {
                    i1 = 0;
                    k1 = 0;
                    for (; i1 < fD.length; i1++)
                    {
                        k1 += jz.cC(fD[i1]);
                    }

                    i1 = j1 + k1 + fD.length * 1;
                }
            }
            j1 = i1;
            if (fE != null)
            {
                j1 = i1;
                if (fE.length > 0)
                {
                    j1 = 0;
                    k1 = 0;
                    for (; j1 < fE.length; j1++)
                    {
                        k1 += jz.cC(fE[j1]);
                    }

                    j1 = i1 + k1 + fE.length * 1;
                }
            }
            i1 = j1;
            if (fF != null)
            {
                i1 = j1;
                if (fF.length > 0)
                {
                    i1 = 0;
                    k1 = 0;
                    for (; i1 < fF.length; i1++)
                    {
                        k1 += jz.cC(fF[i1]);
                    }

                    i1 = j1 + k1 + fF.length * 1;
                }
            }
            j1 = i1;
            if (fG != null)
            {
                j1 = i1;
                if (fG.length > 0)
                {
                    j1 = 0;
                    k1 = 0;
                    for (; j1 < fG.length; j1++)
                    {
                        k1 += jz.cC(fG[j1]);
                    }

                    j1 = i1 + k1 + fG.length * 1;
                }
            }
            i1 = j1;
            if (fH != null)
            {
                i1 = j1;
                if (fH.length > 0)
                {
                    k1 = 0;
                    for (i1 = ((flag) ? 1 : 0); i1 < fH.length; i1++)
                    {
                        k1 += jz.cC(fH[i1]);
                    }

                    i1 = j1 + k1 + fH.length * 1;
                }
            }
            DY = i1;
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
            if (!(obj instanceof g)) goto _L4; else goto _L3
_L3:
            obj = (g)obj;
            flag = flag1;
            if (!kc.equals(fy, ((g) (obj)).fy)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (!kc.equals(fz, ((g) (obj)).fz)) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (!kc.equals(fA, ((g) (obj)).fA)) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (!kc.equals(fB, ((g) (obj)).fB)) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!kc.equals(fC, ((g) (obj)).fC)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (!kc.equals(fD, ((g) (obj)).fD)) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (!kc.equals(fE, ((g) (obj)).fE)) goto _L4; else goto _L11
_L11:
            flag = flag1;
            if (!kc.equals(fF, ((g) (obj)).fF)) goto _L4; else goto _L12
_L12:
            flag = flag1;
            if (!kc.equals(fG, ((g) (obj)).fG)) goto _L4; else goto _L13
_L13:
            flag = flag1;
            if (!kc.equals(fH, ((g) (obj)).fH)) goto _L4; else goto _L14
_L14:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_227;
            }
            if (((g) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((g) (obj)).aae.isEmpty()) goto _L4; else goto _L15
_L15:
            return true;
            return aae.equals(((g) (obj)).aae);
        }

        public g h(jy jy1)
            throws IOException
        {
            do
            {
                int k = jy1.ky();
                switch (k)
                {
                default:
                    if (a(jy1, k))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 8: // '\b'
                    int i6 = kh.c(jy1, 8);
                    int ai[];
                    int i1;
                    if (fy == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = fy.length;
                    }
                    ai = new int[i6 + i1];
                    i6 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(fy, 0, ai, 0, i1);
                        i6 = i1;
                    }
                    for (; i6 < ai.length - 1; i6++)
                    {
                        ai[i6] = jy1.kB();
                        jy1.ky();
                    }

                    ai[i6] = jy1.kB();
                    fy = ai;
                    break;

                case 10: // '\n'
                    int i11 = jy1.cw(jy1.kE());
                    int j1 = jy1.getPosition();
                    int j6;
                    for (j6 = 0; jy1.kJ() > 0; j6++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(j1);
                    int ai1[];
                    if (fy == null)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = fy.length;
                    }
                    ai1 = new int[j6 + j1];
                    j6 = j1;
                    if (j1 != 0)
                    {
                        System.arraycopy(fy, 0, ai1, 0, j1);
                        j6 = j1;
                    }
                    for (; j6 < ai1.length; j6++)
                    {
                        ai1[j6] = jy1.kB();
                    }

                    fy = ai1;
                    jy1.cx(i11);
                    break;

                case 16: // '\020'
                    int k6 = kh.c(jy1, 16);
                    int ai2[];
                    int k1;
                    if (fz == null)
                    {
                        k1 = 0;
                    } else
                    {
                        k1 = fz.length;
                    }
                    ai2 = new int[k6 + k1];
                    k6 = k1;
                    if (k1 != 0)
                    {
                        System.arraycopy(fz, 0, ai2, 0, k1);
                        k6 = k1;
                    }
                    for (; k6 < ai2.length - 1; k6++)
                    {
                        ai2[k6] = jy1.kB();
                        jy1.ky();
                    }

                    ai2[k6] = jy1.kB();
                    fz = ai2;
                    break;

                case 18: // '\022'
                    int j11 = jy1.cw(jy1.kE());
                    int l1 = jy1.getPosition();
                    int l6;
                    for (l6 = 0; jy1.kJ() > 0; l6++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(l1);
                    int ai3[];
                    if (fz == null)
                    {
                        l1 = 0;
                    } else
                    {
                        l1 = fz.length;
                    }
                    ai3 = new int[l6 + l1];
                    l6 = l1;
                    if (l1 != 0)
                    {
                        System.arraycopy(fz, 0, ai3, 0, l1);
                        l6 = l1;
                    }
                    for (; l6 < ai3.length; l6++)
                    {
                        ai3[l6] = jy1.kB();
                    }

                    fz = ai3;
                    jy1.cx(j11);
                    break;

                case 24: // '\030'
                    int i7 = kh.c(jy1, 24);
                    int ai4[];
                    int i2;
                    if (fA == null)
                    {
                        i2 = 0;
                    } else
                    {
                        i2 = fA.length;
                    }
                    ai4 = new int[i7 + i2];
                    i7 = i2;
                    if (i2 != 0)
                    {
                        System.arraycopy(fA, 0, ai4, 0, i2);
                        i7 = i2;
                    }
                    for (; i7 < ai4.length - 1; i7++)
                    {
                        ai4[i7] = jy1.kB();
                        jy1.ky();
                    }

                    ai4[i7] = jy1.kB();
                    fA = ai4;
                    break;

                case 26: // '\032'
                    int k11 = jy1.cw(jy1.kE());
                    int j2 = jy1.getPosition();
                    int j7;
                    for (j7 = 0; jy1.kJ() > 0; j7++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(j2);
                    int ai5[];
                    if (fA == null)
                    {
                        j2 = 0;
                    } else
                    {
                        j2 = fA.length;
                    }
                    ai5 = new int[j7 + j2];
                    j7 = j2;
                    if (j2 != 0)
                    {
                        System.arraycopy(fA, 0, ai5, 0, j2);
                        j7 = j2;
                    }
                    for (; j7 < ai5.length; j7++)
                    {
                        ai5[j7] = jy1.kB();
                    }

                    fA = ai5;
                    jy1.cx(k11);
                    break;

                case 32: // ' '
                    int k7 = kh.c(jy1, 32);
                    int ai6[];
                    int k2;
                    if (fB == null)
                    {
                        k2 = 0;
                    } else
                    {
                        k2 = fB.length;
                    }
                    ai6 = new int[k7 + k2];
                    k7 = k2;
                    if (k2 != 0)
                    {
                        System.arraycopy(fB, 0, ai6, 0, k2);
                        k7 = k2;
                    }
                    for (; k7 < ai6.length - 1; k7++)
                    {
                        ai6[k7] = jy1.kB();
                        jy1.ky();
                    }

                    ai6[k7] = jy1.kB();
                    fB = ai6;
                    break;

                case 34: // '"'
                    int l11 = jy1.cw(jy1.kE());
                    int l2 = jy1.getPosition();
                    int l7;
                    for (l7 = 0; jy1.kJ() > 0; l7++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(l2);
                    int ai7[];
                    if (fB == null)
                    {
                        l2 = 0;
                    } else
                    {
                        l2 = fB.length;
                    }
                    ai7 = new int[l7 + l2];
                    l7 = l2;
                    if (l2 != 0)
                    {
                        System.arraycopy(fB, 0, ai7, 0, l2);
                        l7 = l2;
                    }
                    for (; l7 < ai7.length; l7++)
                    {
                        ai7[l7] = jy1.kB();
                    }

                    fB = ai7;
                    jy1.cx(l11);
                    break;

                case 40: // '('
                    int i8 = kh.c(jy1, 40);
                    int ai8[];
                    int i3;
                    if (fC == null)
                    {
                        i3 = 0;
                    } else
                    {
                        i3 = fC.length;
                    }
                    ai8 = new int[i8 + i3];
                    i8 = i3;
                    if (i3 != 0)
                    {
                        System.arraycopy(fC, 0, ai8, 0, i3);
                        i8 = i3;
                    }
                    for (; i8 < ai8.length - 1; i8++)
                    {
                        ai8[i8] = jy1.kB();
                        jy1.ky();
                    }

                    ai8[i8] = jy1.kB();
                    fC = ai8;
                    break;

                case 42: // '*'
                    int i12 = jy1.cw(jy1.kE());
                    int j3 = jy1.getPosition();
                    int j8;
                    for (j8 = 0; jy1.kJ() > 0; j8++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(j3);
                    int ai9[];
                    if (fC == null)
                    {
                        j3 = 0;
                    } else
                    {
                        j3 = fC.length;
                    }
                    ai9 = new int[j8 + j3];
                    j8 = j3;
                    if (j3 != 0)
                    {
                        System.arraycopy(fC, 0, ai9, 0, j3);
                        j8 = j3;
                    }
                    for (; j8 < ai9.length; j8++)
                    {
                        ai9[j8] = jy1.kB();
                    }

                    fC = ai9;
                    jy1.cx(i12);
                    break;

                case 48: // '0'
                    int k8 = kh.c(jy1, 48);
                    int ai10[];
                    int k3;
                    if (fD == null)
                    {
                        k3 = 0;
                    } else
                    {
                        k3 = fD.length;
                    }
                    ai10 = new int[k8 + k3];
                    k8 = k3;
                    if (k3 != 0)
                    {
                        System.arraycopy(fD, 0, ai10, 0, k3);
                        k8 = k3;
                    }
                    for (; k8 < ai10.length - 1; k8++)
                    {
                        ai10[k8] = jy1.kB();
                        jy1.ky();
                    }

                    ai10[k8] = jy1.kB();
                    fD = ai10;
                    break;

                case 50: // '2'
                    int j12 = jy1.cw(jy1.kE());
                    int l3 = jy1.getPosition();
                    int l8;
                    for (l8 = 0; jy1.kJ() > 0; l8++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(l3);
                    int ai11[];
                    if (fD == null)
                    {
                        l3 = 0;
                    } else
                    {
                        l3 = fD.length;
                    }
                    ai11 = new int[l8 + l3];
                    l8 = l3;
                    if (l3 != 0)
                    {
                        System.arraycopy(fD, 0, ai11, 0, l3);
                        l8 = l3;
                    }
                    for (; l8 < ai11.length; l8++)
                    {
                        ai11[l8] = jy1.kB();
                    }

                    fD = ai11;
                    jy1.cx(j12);
                    break;

                case 56: // '8'
                    int i9 = kh.c(jy1, 56);
                    int ai12[];
                    int i4;
                    if (fE == null)
                    {
                        i4 = 0;
                    } else
                    {
                        i4 = fE.length;
                    }
                    ai12 = new int[i9 + i4];
                    i9 = i4;
                    if (i4 != 0)
                    {
                        System.arraycopy(fE, 0, ai12, 0, i4);
                        i9 = i4;
                    }
                    for (; i9 < ai12.length - 1; i9++)
                    {
                        ai12[i9] = jy1.kB();
                        jy1.ky();
                    }

                    ai12[i9] = jy1.kB();
                    fE = ai12;
                    break;

                case 58: // ':'
                    int k12 = jy1.cw(jy1.kE());
                    int j4 = jy1.getPosition();
                    int j9;
                    for (j9 = 0; jy1.kJ() > 0; j9++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(j4);
                    int ai13[];
                    if (fE == null)
                    {
                        j4 = 0;
                    } else
                    {
                        j4 = fE.length;
                    }
                    ai13 = new int[j9 + j4];
                    j9 = j4;
                    if (j4 != 0)
                    {
                        System.arraycopy(fE, 0, ai13, 0, j4);
                        j9 = j4;
                    }
                    for (; j9 < ai13.length; j9++)
                    {
                        ai13[j9] = jy1.kB();
                    }

                    fE = ai13;
                    jy1.cx(k12);
                    break;

                case 64: // '@'
                    int k9 = kh.c(jy1, 64);
                    int ai14[];
                    int k4;
                    if (fF == null)
                    {
                        k4 = 0;
                    } else
                    {
                        k4 = fF.length;
                    }
                    ai14 = new int[k9 + k4];
                    k9 = k4;
                    if (k4 != 0)
                    {
                        System.arraycopy(fF, 0, ai14, 0, k4);
                        k9 = k4;
                    }
                    for (; k9 < ai14.length - 1; k9++)
                    {
                        ai14[k9] = jy1.kB();
                        jy1.ky();
                    }

                    ai14[k9] = jy1.kB();
                    fF = ai14;
                    break;

                case 66: // 'B'
                    int l12 = jy1.cw(jy1.kE());
                    int l4 = jy1.getPosition();
                    int l9;
                    for (l9 = 0; jy1.kJ() > 0; l9++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(l4);
                    int ai15[];
                    if (fF == null)
                    {
                        l4 = 0;
                    } else
                    {
                        l4 = fF.length;
                    }
                    ai15 = new int[l9 + l4];
                    l9 = l4;
                    if (l4 != 0)
                    {
                        System.arraycopy(fF, 0, ai15, 0, l4);
                        l9 = l4;
                    }
                    for (; l9 < ai15.length; l9++)
                    {
                        ai15[l9] = jy1.kB();
                    }

                    fF = ai15;
                    jy1.cx(l12);
                    break;

                case 72: // 'H'
                    int i10 = kh.c(jy1, 72);
                    int ai16[];
                    int i5;
                    if (fG == null)
                    {
                        i5 = 0;
                    } else
                    {
                        i5 = fG.length;
                    }
                    ai16 = new int[i10 + i5];
                    i10 = i5;
                    if (i5 != 0)
                    {
                        System.arraycopy(fG, 0, ai16, 0, i5);
                        i10 = i5;
                    }
                    for (; i10 < ai16.length - 1; i10++)
                    {
                        ai16[i10] = jy1.kB();
                        jy1.ky();
                    }

                    ai16[i10] = jy1.kB();
                    fG = ai16;
                    break;

                case 74: // 'J'
                    int i13 = jy1.cw(jy1.kE());
                    int j5 = jy1.getPosition();
                    int j10;
                    for (j10 = 0; jy1.kJ() > 0; j10++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(j5);
                    int ai17[];
                    if (fG == null)
                    {
                        j5 = 0;
                    } else
                    {
                        j5 = fG.length;
                    }
                    ai17 = new int[j10 + j5];
                    j10 = j5;
                    if (j5 != 0)
                    {
                        System.arraycopy(fG, 0, ai17, 0, j5);
                        j10 = j5;
                    }
                    for (; j10 < ai17.length; j10++)
                    {
                        ai17[j10] = jy1.kB();
                    }

                    fG = ai17;
                    jy1.cx(i13);
                    break;

                case 80: // 'P'
                    int k10 = kh.c(jy1, 80);
                    int ai18[];
                    int k5;
                    if (fH == null)
                    {
                        k5 = 0;
                    } else
                    {
                        k5 = fH.length;
                    }
                    ai18 = new int[k10 + k5];
                    k10 = k5;
                    if (k5 != 0)
                    {
                        System.arraycopy(fH, 0, ai18, 0, k5);
                        k10 = k5;
                    }
                    for (; k10 < ai18.length - 1; k10++)
                    {
                        ai18[k10] = jy1.kB();
                        jy1.ky();
                    }

                    ai18[k10] = jy1.kB();
                    fH = ai18;
                    break;

                case 82: // 'R'
                    int j13 = jy1.cw(jy1.kE());
                    int l5 = jy1.getPosition();
                    int l10;
                    for (l10 = 0; jy1.kJ() > 0; l10++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(l5);
                    int ai19[];
                    if (fH == null)
                    {
                        l5 = 0;
                    } else
                    {
                        l5 = fH.length;
                    }
                    ai19 = new int[l10 + l5];
                    l10 = l5;
                    if (l5 != 0)
                    {
                        System.arraycopy(fH, 0, ai19, 0, l5);
                        l10 = l5;
                    }
                    for (; l10 < ai19.length; l10++)
                    {
                        ai19[l10] = jy1.kB();
                    }

                    fH = ai19;
                    jy1.cx(j13);
                    break;
                }
            } while (true);
        }

        public int hashCode()
        {
            int i1 = kc.hashCode(fy);
            int j1 = kc.hashCode(fz);
            int k1 = kc.hashCode(fA);
            int l1 = kc.hashCode(fB);
            int i2 = kc.hashCode(fC);
            int j2 = kc.hashCode(fD);
            int k2 = kc.hashCode(fE);
            int l2 = kc.hashCode(fF);
            int i3 = kc.hashCode(fG);
            int j3 = kc.hashCode(fH);
            int k;
            if (aae == null || aae.isEmpty())
            {
                k = 0;
            } else
            {
                k = aae.hashCode();
            }
            return k + ((((((((((i1 + 527) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31;
        }

        public g m()
        {
            fy = kh.aaj;
            fz = kh.aaj;
            fA = kh.aaj;
            fB = kh.aaj;
            fC = kh.aaj;
            fD = kh.aaj;
            fE = kh.aaj;
            fF = kh.aaj;
            fG = kh.aaj;
            fH = kh.aaj;
            aae = null;
            DY = -1;
            return this;
        }

        public g()
        {
            m();
        }
    }

    public static final class h extends ka
    {

        public static final kb fI = kb.a(11, com/google/android/gms/internal/c$h, 810);
        private static final h fJ[] = new h[0];
        public int fK[];
        public int fL[];
        public int fM[];
        public int fN;
        public int fO[];
        public int fP;
        public int fQ;

        public void a(jz jz1)
            throws IOException
        {
            boolean flag = false;
            if (fK != null && fK.length > 0)
            {
                for (int k = 0; k < fK.length; k++)
                {
                    jz1.f(1, fK[k]);
                }

            }
            if (fL != null && fL.length > 0)
            {
                for (int l = 0; l < fL.length; l++)
                {
                    jz1.f(2, fL[l]);
                }

            }
            if (fM != null && fM.length > 0)
            {
                for (int i1 = 0; i1 < fM.length; i1++)
                {
                    jz1.f(3, fM[i1]);
                }

            }
            if (fN != 0)
            {
                jz1.f(4, fN);
            }
            if (fO != null && fO.length > 0)
            {
                for (int j1 = ((flag) ? 1 : 0); j1 < fO.length; j1++)
                {
                    jz1.f(5, fO[j1]);
                }

            }
            if (fP != 0)
            {
                jz1.f(6, fP);
            }
            if (fQ != 0)
            {
                jz1.f(7, fQ);
            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return i(jy1);
        }

        public int c()
        {
            boolean flag = false;
            int j1 = super.c();
            int l;
            int i1;
            if (fK != null && fK.length > 0)
            {
                int k = 0;
                i1 = 0;
                for (; k < fK.length; k++)
                {
                    i1 += jz.cC(fK[k]);
                }

                i1 = j1 + i1 + fK.length * 1;
            } else
            {
                i1 = j1;
            }
            l = i1;
            if (fL != null)
            {
                l = i1;
                if (fL.length > 0)
                {
                    l = 0;
                    j1 = 0;
                    for (; l < fL.length; l++)
                    {
                        j1 += jz.cC(fL[l]);
                    }

                    l = i1 + j1 + fL.length * 1;
                }
            }
            i1 = l;
            if (fM != null)
            {
                i1 = l;
                if (fM.length > 0)
                {
                    i1 = 0;
                    j1 = 0;
                    for (; i1 < fM.length; i1++)
                    {
                        j1 += jz.cC(fM[i1]);
                    }

                    i1 = l + j1 + fM.length * 1;
                }
            }
            l = i1;
            if (fN != 0)
            {
                l = i1 + jz.g(4, fN);
            }
            i1 = l;
            if (fO != null)
            {
                i1 = l;
                if (fO.length > 0)
                {
                    j1 = 0;
                    for (i1 = ((flag) ? 1 : 0); i1 < fO.length; i1++)
                    {
                        j1 += jz.cC(fO[i1]);
                    }

                    i1 = l + j1 + fO.length * 1;
                }
            }
            l = i1;
            if (fP != 0)
            {
                l = i1 + jz.g(6, fP);
            }
            i1 = l;
            if (fQ != 0)
            {
                i1 = l + jz.g(7, fQ);
            }
            DY = i1;
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
            if (!(obj instanceof h)) goto _L4; else goto _L3
_L3:
            obj = (h)obj;
            flag = flag1;
            if (!kc.equals(fK, ((h) (obj)).fK)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (!kc.equals(fL, ((h) (obj)).fL)) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (!kc.equals(fM, ((h) (obj)).fM)) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (fN != ((h) (obj)).fN) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!kc.equals(fO, ((h) (obj)).fO)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (fP != ((h) (obj)).fP) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (fQ != ((h) (obj)).fQ) goto _L4; else goto _L11
_L11:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_170;
            }
            if (((h) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((h) (obj)).aae.isEmpty()) goto _L4; else goto _L12
_L12:
            return true;
            return aae.equals(((h) (obj)).aae);
        }

        public int hashCode()
        {
            int l = kc.hashCode(fK);
            int i1 = kc.hashCode(fL);
            int j1 = kc.hashCode(fM);
            int k1 = fN;
            int l1 = kc.hashCode(fO);
            int i2 = fP;
            int j2 = fQ;
            int k;
            if (aae == null || aae.isEmpty())
            {
                k = 0;
            } else
            {
                k = aae.hashCode();
            }
            return k + (((((((l + 527) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31;
        }

        public h i(jy jy1)
            throws IOException
        {
            do
            {
                int k = jy1.ky();
                switch (k)
                {
                default:
                    if (a(jy1, k))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 8: // '\b'
                    int l2 = kh.c(jy1, 8);
                    int ai[];
                    int l;
                    if (fK == null)
                    {
                        l = 0;
                    } else
                    {
                        l = fK.length;
                    }
                    ai = new int[l2 + l];
                    l2 = l;
                    if (l != 0)
                    {
                        System.arraycopy(fK, 0, ai, 0, l);
                        l2 = l;
                    }
                    for (; l2 < ai.length - 1; l2++)
                    {
                        ai[l2] = jy1.kB();
                        jy1.ky();
                    }

                    ai[l2] = jy1.kB();
                    fK = ai;
                    break;

                case 10: // '\n'
                    int l4 = jy1.cw(jy1.kE());
                    int i1 = jy1.getPosition();
                    int i3;
                    for (i3 = 0; jy1.kJ() > 0; i3++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(i1);
                    int ai1[];
                    if (fK == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = fK.length;
                    }
                    ai1 = new int[i3 + i1];
                    i3 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(fK, 0, ai1, 0, i1);
                        i3 = i1;
                    }
                    for (; i3 < ai1.length; i3++)
                    {
                        ai1[i3] = jy1.kB();
                    }

                    fK = ai1;
                    jy1.cx(l4);
                    break;

                case 16: // '\020'
                    int j3 = kh.c(jy1, 16);
                    int ai2[];
                    int j1;
                    if (fL == null)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = fL.length;
                    }
                    ai2 = new int[j3 + j1];
                    j3 = j1;
                    if (j1 != 0)
                    {
                        System.arraycopy(fL, 0, ai2, 0, j1);
                        j3 = j1;
                    }
                    for (; j3 < ai2.length - 1; j3++)
                    {
                        ai2[j3] = jy1.kB();
                        jy1.ky();
                    }

                    ai2[j3] = jy1.kB();
                    fL = ai2;
                    break;

                case 18: // '\022'
                    int i5 = jy1.cw(jy1.kE());
                    int k1 = jy1.getPosition();
                    int k3;
                    for (k3 = 0; jy1.kJ() > 0; k3++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(k1);
                    int ai3[];
                    if (fL == null)
                    {
                        k1 = 0;
                    } else
                    {
                        k1 = fL.length;
                    }
                    ai3 = new int[k3 + k1];
                    k3 = k1;
                    if (k1 != 0)
                    {
                        System.arraycopy(fL, 0, ai3, 0, k1);
                        k3 = k1;
                    }
                    for (; k3 < ai3.length; k3++)
                    {
                        ai3[k3] = jy1.kB();
                    }

                    fL = ai3;
                    jy1.cx(i5);
                    break;

                case 24: // '\030'
                    int l3 = kh.c(jy1, 24);
                    int ai4[];
                    int l1;
                    if (fM == null)
                    {
                        l1 = 0;
                    } else
                    {
                        l1 = fM.length;
                    }
                    ai4 = new int[l3 + l1];
                    l3 = l1;
                    if (l1 != 0)
                    {
                        System.arraycopy(fM, 0, ai4, 0, l1);
                        l3 = l1;
                    }
                    for (; l3 < ai4.length - 1; l3++)
                    {
                        ai4[l3] = jy1.kB();
                        jy1.ky();
                    }

                    ai4[l3] = jy1.kB();
                    fM = ai4;
                    break;

                case 26: // '\032'
                    int j5 = jy1.cw(jy1.kE());
                    int i2 = jy1.getPosition();
                    int i4;
                    for (i4 = 0; jy1.kJ() > 0; i4++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(i2);
                    int ai5[];
                    if (fM == null)
                    {
                        i2 = 0;
                    } else
                    {
                        i2 = fM.length;
                    }
                    ai5 = new int[i4 + i2];
                    i4 = i2;
                    if (i2 != 0)
                    {
                        System.arraycopy(fM, 0, ai5, 0, i2);
                        i4 = i2;
                    }
                    for (; i4 < ai5.length; i4++)
                    {
                        ai5[i4] = jy1.kB();
                    }

                    fM = ai5;
                    jy1.cx(j5);
                    break;

                case 32: // ' '
                    fN = jy1.kB();
                    break;

                case 40: // '('
                    int j4 = kh.c(jy1, 40);
                    int ai6[];
                    int j2;
                    if (fO == null)
                    {
                        j2 = 0;
                    } else
                    {
                        j2 = fO.length;
                    }
                    ai6 = new int[j4 + j2];
                    j4 = j2;
                    if (j2 != 0)
                    {
                        System.arraycopy(fO, 0, ai6, 0, j2);
                        j4 = j2;
                    }
                    for (; j4 < ai6.length - 1; j4++)
                    {
                        ai6[j4] = jy1.kB();
                        jy1.ky();
                    }

                    ai6[j4] = jy1.kB();
                    fO = ai6;
                    break;

                case 42: // '*'
                    int k5 = jy1.cw(jy1.kE());
                    int k2 = jy1.getPosition();
                    int k4;
                    for (k4 = 0; jy1.kJ() > 0; k4++)
                    {
                        jy1.kB();
                    }

                    jy1.cy(k2);
                    int ai7[];
                    if (fO == null)
                    {
                        k2 = 0;
                    } else
                    {
                        k2 = fO.length;
                    }
                    ai7 = new int[k4 + k2];
                    k4 = k2;
                    if (k2 != 0)
                    {
                        System.arraycopy(fO, 0, ai7, 0, k2);
                        k4 = k2;
                    }
                    for (; k4 < ai7.length; k4++)
                    {
                        ai7[k4] = jy1.kB();
                    }

                    fO = ai7;
                    jy1.cx(k5);
                    break;

                case 48: // '0'
                    fP = jy1.kB();
                    break;

                case 56: // '8'
                    fQ = jy1.kB();
                    break;
                }
            } while (true);
        }

        public h n()
        {
            fK = kh.aaj;
            fL = kh.aaj;
            fM = kh.aaj;
            fN = 0;
            fO = kh.aaj;
            fP = 0;
            fQ = 0;
            aae = null;
            DY = -1;
            return this;
        }


        public h()
        {
            n();
        }
    }

    public static final class i extends ka
    {

        private static volatile i fR[];
        public d.a fS;
        public d fT;
        public String name;

        public static i[] o()
        {
            if (fR == null)
            {
                synchronized (kc.aah)
                {
                    if (fR == null)
                    {
                        fR = new i[0];
                    }
                }
            }
            return fR;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(jz jz1)
            throws IOException
        {
            if (!name.equals(""))
            {
                jz1.b(1, name);
            }
            if (fS != null)
            {
                jz1.a(2, fS);
            }
            if (fT != null)
            {
                jz1.a(3, fT);
            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return j(jy1);
        }

        public int c()
        {
            int l = super.c();
            int k = l;
            if (!name.equals(""))
            {
                k = l + jz.g(1, name);
            }
            l = k;
            if (fS != null)
            {
                l = k + jz.b(2, fS);
            }
            k = l;
            if (fT != null)
            {
                k = l + jz.b(3, fT);
            }
            DY = k;
            return k;
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
            if (!(obj instanceof i)) goto _L4; else goto _L3
_L3:
            obj = (i)obj;
            if (name != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((i) (obj)).name != null) goto _L4; else goto _L7
_L7:
            if (fS != null) goto _L9; else goto _L8
_L8:
            flag = flag1;
            if (((i) (obj)).fS != null) goto _L4; else goto _L10
_L10:
            if (fT != null) goto _L12; else goto _L11
_L11:
            flag = flag1;
            if (((i) (obj)).fT != null) goto _L4; else goto _L13
_L13:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_163;
            }
            if (((i) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((i) (obj)).aae.isEmpty()) goto _L4; else goto _L14
_L14:
            return true;
_L6:
            if (!name.equals(((i) (obj)).name))
            {
                return false;
            }
              goto _L7
_L9:
            if (!fS.equals(((i) (obj)).fS))
            {
                return false;
            }
              goto _L10
_L12:
            if (!fT.equals(((i) (obj)).fT))
            {
                return false;
            }
              goto _L13
            return aae.equals(((i) (obj)).aae);
              goto _L7
        }

        public int hashCode()
        {
            boolean flag = false;
            int k;
            int l;
            int i1;
            int j1;
            if (name == null)
            {
                k = 0;
            } else
            {
                k = name.hashCode();
            }
            if (fS == null)
            {
                l = 0;
            } else
            {
                l = fS.hashCode();
            }
            if (fT == null)
            {
                i1 = 0;
            } else
            {
                i1 = fT.hashCode();
            }
            j1 = ((flag) ? 1 : 0);
            if (aae != null)
            {
                if (aae.isEmpty())
                {
                    j1 = ((flag) ? 1 : 0);
                } else
                {
                    j1 = aae.hashCode();
                }
            }
            return (i1 + (l + (k + 527) * 31) * 31) * 31 + j1;
        }

        public i j(jy jy1)
            throws IOException
        {
            do
            {
                int k = jy1.ky();
                switch (k)
                {
                default:
                    if (a(jy1, k))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 10: // '\n'
                    name = jy1.readString();
                    break;

                case 18: // '\022'
                    if (fS == null)
                    {
                        fS = new d.a();
                    }
                    jy1.a(fS);
                    break;

                case 26: // '\032'
                    if (fT == null)
                    {
                        fT = new d();
                    }
                    jy1.a(fT);
                    break;
                }
            } while (true);
        }

        public i p()
        {
            name = "";
            fS = null;
            fT = null;
            aae = null;
            DY = -1;
            return this;
        }

        public i()
        {
            p();
        }
    }

    public static final class j extends ka
    {

        public i fU[];
        public f fV;
        public String fW;

        public static j b(byte abyte0[])
            throws kd
        {
            return (j)ke.a(new j(), abyte0);
        }

        public void a(jz jz1)
            throws IOException
        {
            if (fU != null && fU.length > 0)
            {
                for (int i1 = 0; i1 < fU.length; i1++)
                {
                    i l = fU[i1];
                    if (l != null)
                    {
                        jz1.a(1, l);
                    }
                }

            }
            if (fV != null)
            {
                jz1.a(2, fV);
            }
            if (!fW.equals(""))
            {
                jz1.b(3, fW);
            }
            super.a(jz1);
        }

        public ke b(jy jy1)
            throws IOException
        {
            return k(jy1);
        }

        public int c()
        {
            int i1 = super.c();
            int j1 = i1;
            if (fU != null)
            {
                j1 = i1;
                if (fU.length > 0)
                {
                    int k1 = 0;
                    do
                    {
                        j1 = i1;
                        if (k1 >= fU.length)
                        {
                            break;
                        }
                        i l = fU[k1];
                        j1 = i1;
                        if (l != null)
                        {
                            j1 = i1 + jz.b(1, l);
                        }
                        k1++;
                        i1 = j1;
                    } while (true);
                }
            }
            i1 = j1;
            if (fV != null)
            {
                i1 = j1 + jz.b(2, fV);
            }
            j1 = i1;
            if (!fW.equals(""))
            {
                j1 = i1 + jz.g(3, fW);
            }
            DY = j1;
            return j1;
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
            if (!(obj instanceof j)) goto _L4; else goto _L3
_L3:
            obj = (j)obj;
            flag = flag1;
            if (!kc.equals(fU, ((j) (obj)).fU)) goto _L4; else goto _L5
_L5:
            if (fV != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((j) (obj)).fV != null) goto _L4; else goto _L8
_L8:
            if (fW != null) goto _L10; else goto _L9
_L9:
            flag = flag1;
            if (((j) (obj)).fW != null) goto _L4; else goto _L11
_L11:
            if (aae != null && !aae.isEmpty())
            {
                break MISSING_BLOCK_LABEL_147;
            }
            if (((j) (obj)).aae == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((j) (obj)).aae.isEmpty()) goto _L4; else goto _L12
_L12:
            return true;
_L7:
            if (!fV.equals(((j) (obj)).fV))
            {
                return false;
            }
              goto _L8
_L10:
            if (!fW.equals(((j) (obj)).fW))
            {
                return false;
            }
              goto _L11
            return aae.equals(((j) (obj)).aae);
              goto _L8
        }

        public int hashCode()
        {
            boolean flag = false;
            int k1 = kc.hashCode(fU);
            int l;
            int i1;
            int j1;
            if (fV == null)
            {
                l = 0;
            } else
            {
                l = fV.hashCode();
            }
            if (fW == null)
            {
                i1 = 0;
            } else
            {
                i1 = fW.hashCode();
            }
            j1 = ((flag) ? 1 : 0);
            if (aae != null)
            {
                if (aae.isEmpty())
                {
                    j1 = ((flag) ? 1 : 0);
                } else
                {
                    j1 = aae.hashCode();
                }
            }
            return (i1 + (l + (k1 + 527) * 31) * 31) * 31 + j1;
        }

        public j k(jy jy1)
            throws IOException
        {
            do
            {
                int l = jy1.ky();
                switch (l)
                {
                default:
                    if (a(jy1, l))
                    {
                        continue;
                    }
                    // fall through

                case 0: // '\0'
                    return this;

                case 10: // '\n'
                    int j1 = kh.c(jy1, 10);
                    i ai[];
                    int i1;
                    if (fU == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = fU.length;
                    }
                    ai = new i[j1 + i1];
                    j1 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(fU, 0, ai, 0, i1);
                        j1 = i1;
                    }
                    for (; j1 < ai.length - 1; j1++)
                    {
                        ai[j1] = new i();
                        jy1.a(ai[j1]);
                        jy1.ky();
                    }

                    ai[j1] = new i();
                    jy1.a(ai[j1]);
                    fU = ai;
                    break;

                case 18: // '\022'
                    if (fV == null)
                    {
                        fV = new f();
                    }
                    jy1.a(fV);
                    break;

                case 26: // '\032'
                    fW = jy1.readString();
                    break;
                }
            } while (true);
        }

        public j q()
        {
            fU = i.o();
            fV = null;
            fW = "";
            aae = null;
            DY = -1;
            return this;
        }

        public j()
        {
            q();
        }
    }

}
