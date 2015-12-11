// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, kd, ke, 
//            jz, kc, jy, kh

public static final class k extends ka
{

    public String fg[];
    public String fh[];
    public DY fi[];
    public DY fj[];
    public DY fk[];
    public DY fl[];
    public DY fm[];
    public DY fn[];
    public String fo;
    public String fp;
    public String fq;
    public String fr;
    public DY fs;
    public float ft;
    public boolean fu;
    public String fv[];
    public int fw;

    public static k a(byte abyte0[])
        throws kd
    {
        return (k)ke.a(new <init>(), abyte0);
    }

    public void a(jz jz1)
        throws IOException
    {
        boolean flag = false;
        if (fh != null && fh.length > 0)
        {
            for (int i = 0; i < fh.length; i++)
            {
                String s = fh[i];
                if (s != null)
                {
                    jz1.b(1, s);
                }
            }

        }
        if (fi != null && fi.length > 0)
        {
            for (int j = 0; j < fi.length; j++)
            {
                <init> <init>1 = fi[j];
                if (<init>1 != null)
                {
                    jz1.a(2, <init>1);
                }
            }

        }
        if (fj != null && fj.length > 0)
        {
            for (int l = 0; l < fj.length; l++)
            {
                <init> <init>2 = fj[l];
                if (<init>2 != null)
                {
                    jz1.a(3, <init>2);
                }
            }

        }
        if (fk != null && fk.length > 0)
        {
            for (int i1 = 0; i1 < fk.length; i1++)
            {
                <init> <init>3 = fk[i1];
                if (<init>3 != null)
                {
                    jz1.a(4, <init>3);
                }
            }

        }
        if (fl != null && fl.length > 0)
        {
            for (int j1 = 0; j1 < fl.length; j1++)
            {
                <init> <init>4 = fl[j1];
                if (<init>4 != null)
                {
                    jz1.a(5, <init>4);
                }
            }

        }
        if (fm != null && fm.length > 0)
        {
            for (int k1 = 0; k1 < fm.length; k1++)
            {
                <init> <init>5 = fm[k1];
                if (<init>5 != null)
                {
                    jz1.a(6, <init>5);
                }
            }

        }
        if (fn != null && fn.length > 0)
        {
            for (int l1 = 0; l1 < fn.length; l1++)
            {
                <init> <init>6 = fn[l1];
                if (<init>6 != null)
                {
                    jz1.a(7, <init>6);
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
            for (int i2 = 0; i2 < fv.length; i2++)
            {
                String s1 = fv[i2];
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
            for (int j2 = ((flag) ? 1 : 0); j2 < fg.length; j2++)
            {
                String s2 = fg[j2];
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
        int l4 = super.c();
        int j;
        int l;
        int l2;
        if (fh != null && fh.length > 0)
        {
            int i = 0;
            l = 0;
            int i1;
            int j3;
            for (i1 = 0; i < fh.length; i1 = j3)
            {
                String s = fh[i];
                int i4 = l;
                j3 = i1;
                if (s != null)
                {
                    j3 = i1 + 1;
                    i4 = l + jz.bQ(s);
                }
                i++;
                l = i4;
            }

            l = l4 + l + i1 * 1;
        } else
        {
            l = l4;
        }
        j = l;
        if (fi != null)
        {
            j = l;
            if (fi.length > 0)
            {
                j = l;
                for (l = 0; l < fi.length;)
                {
                    g g1 = fi[l];
                    int j1 = j;
                    if (g1 != null)
                    {
                        j1 = j + jz.b(2, g1);
                    }
                    l++;
                    j = j1;
                }

            }
        }
        l = j;
        if (fj != null)
        {
            l = j;
            if (fj.length > 0)
            {
                for (l = 0; l < fj.length;)
                {
                    g g2 = fj[l];
                    int k1 = j;
                    if (g2 != null)
                    {
                        k1 = j + jz.b(3, g2);
                    }
                    l++;
                    j = k1;
                }

                l = j;
            }
        }
        j = l;
        if (fk != null)
        {
            j = l;
            if (fk.length > 0)
            {
                j = l;
                for (l = 0; l < fk.length;)
                {
                    g g3 = fk[l];
                    int l1 = j;
                    if (g3 != null)
                    {
                        l1 = j + jz.b(4, g3);
                    }
                    l++;
                    j = l1;
                }

            }
        }
        l = j;
        if (fl != null)
        {
            l = j;
            if (fl.length > 0)
            {
                for (l = 0; l < fl.length;)
                {
                    g g4 = fl[l];
                    int i2 = j;
                    if (g4 != null)
                    {
                        i2 = j + jz.b(5, g4);
                    }
                    l++;
                    j = i2;
                }

                l = j;
            }
        }
        j = l;
        if (fm != null)
        {
            j = l;
            if (fm.length > 0)
            {
                j = l;
                for (l = 0; l < fm.length;)
                {
                    g g5 = fm[l];
                    int j2 = j;
                    if (g5 != null)
                    {
                        j2 = j + jz.b(6, g5);
                    }
                    l++;
                    j = j2;
                }

            }
        }
        l = j;
        if (fn != null)
        {
            l = j;
            if (fn.length > 0)
            {
                for (l = 0; l < fn.length;)
                {
                    g g6 = fn[l];
                    int k2 = j;
                    if (g6 != null)
                    {
                        k2 = j + jz.b(7, g6);
                    }
                    l++;
                    j = k2;
                }

                l = j;
            }
        }
        j = l;
        if (!fo.equals(""))
        {
            j = l + jz.g(9, fo);
        }
        l = j;
        if (!fp.equals(""))
        {
            l = j + jz.g(10, fp);
        }
        j = l;
        if (!fq.equals("0"))
        {
            j = l + jz.g(12, fq);
        }
        l = j;
        if (!fr.equals(""))
        {
            l = j + jz.g(13, fr);
        }
        l2 = l;
        if (fs != null)
        {
            l2 = l + jz.b(14, fs);
        }
        j = l2;
        if (Float.floatToIntBits(ft) != Float.floatToIntBits(0.0F))
        {
            j = l2 + jz.b(15, ft);
        }
        l = j;
        if (fv != null)
        {
            l = j;
            if (fv.length > 0)
            {
                l = 0;
                l2 = 0;
                int k3;
                int j4;
                for (k3 = 0; l < fv.length; k3 = j4)
                {
                    String s1 = fv[l];
                    l4 = l2;
                    j4 = k3;
                    if (s1 != null)
                    {
                        j4 = k3 + 1;
                        l4 = l2 + jz.bQ(s1);
                    }
                    l++;
                    l2 = l4;
                }

                l = j + l2 + k3 * 2;
            }
        }
        l2 = l;
        if (fw != 0)
        {
            l2 = l + jz.g(17, fw);
        }
        j = l2;
        if (fu)
        {
            j = l2 + jz.b(18, fu);
        }
        l = j;
        if (fg != null)
        {
            l = j;
            if (fg.length > 0)
            {
                int i3 = 0;
                int l3 = 0;
                for (l = ((flag) ? 1 : 0); l < fg.length;)
                {
                    String s2 = fg[l];
                    l4 = i3;
                    int k4 = l3;
                    if (s2 != null)
                    {
                        k4 = l3 + 1;
                        l4 = i3 + jz.bQ(s2);
                    }
                    l++;
                    i3 = l4;
                    l3 = k4;
                }

                l = j + i3 + l3 * 2;
            }
        }
        DY = l;
        return l;
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
        if (!(obj instanceof DY)) goto _L4; else goto _L3
_L3:
        obj = (DY)obj;
        flag = flag1;
        if (!kc.equals(fg, ((fg) (obj)).fg)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!kc.equals(fh, ((fh) (obj)).fh)) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (!kc.equals(fi, ((fi) (obj)).fi)) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (!kc.equals(fj, ((fj) (obj)).fj)) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (!kc.equals(fk, ((fk) (obj)).fk)) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (!kc.equals(fl, ((fl) (obj)).fl)) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (!kc.equals(fm, ((fm) (obj)).fm)) goto _L4; else goto _L11
_L11:
        flag = flag1;
        if (!kc.equals(fn, ((fn) (obj)).fn)) goto _L4; else goto _L12
_L12:
        if (fo != null) goto _L14; else goto _L13
_L13:
        flag = flag1;
        if (((fo) (obj)).fo != null) goto _L4; else goto _L15
_L15:
        if (fp != null) goto _L17; else goto _L16
_L16:
        flag = flag1;
        if (((fp) (obj)).fp != null) goto _L4; else goto _L18
_L18:
        if (fq != null) goto _L20; else goto _L19
_L19:
        flag = flag1;
        if (((fq) (obj)).fq != null) goto _L4; else goto _L21
_L21:
        if (fr != null) goto _L23; else goto _L22
_L22:
        flag = flag1;
        if (((fr) (obj)).fr != null) goto _L4; else goto _L24
_L24:
        if (fs != null) goto _L26; else goto _L25
_L25:
        flag = flag1;
        if (((fs) (obj)).fs != null) goto _L4; else goto _L27
_L27:
        flag = flag1;
        if (Float.floatToIntBits(ft) != Float.floatToIntBits(((ft) (obj)).ft)) goto _L4; else goto _L28
_L28:
        flag = flag1;
        if (fu != ((fu) (obj)).fu) goto _L4; else goto _L29
_L29:
        flag = flag1;
        if (!kc.equals(fv, ((fv) (obj)).fv)) goto _L4; else goto _L30
_L30:
        flag = flag1;
        if (fw != ((fw) (obj)).fw) goto _L4; else goto _L31
_L31:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_416;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L32
_L32:
        return true;
_L14:
        if (!fo.equals(((fo) (obj)).fo))
        {
            return false;
        }
          goto _L15
_L17:
        if (!fp.equals(((fp) (obj)).fp))
        {
            return false;
        }
          goto _L18
_L20:
        if (!fq.equals(((fq) (obj)).fq))
        {
            return false;
        }
          goto _L21
_L23:
        if (!fr.equals(((fr) (obj)).fr))
        {
            return false;
        }
          goto _L24
_L26:
        if (!fs.equals(((equals) (obj)).fs))
        {
            return false;
        }
          goto _L27
        return aae.equals(((aae) (obj)).aae);
          goto _L15
    }

    public aae g(jy jy1)
        throws IOException
    {
        do
        {
            int i = jy1.ky();
            switch (i)
            {
            default:
                if (a(jy1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int l2 = kh.c(jy1, 10);
                String as[];
                int j;
                if (fh == null)
                {
                    j = 0;
                } else
                {
                    j = fh.length;
                }
                as = new String[l2 + j];
                l2 = j;
                if (j != 0)
                {
                    System.arraycopy(fh, 0, as, 0, j);
                    l2 = j;
                }
                for (; l2 < as.length - 1; l2++)
                {
                    as[l2] = jy1.readString();
                    jy1.ky();
                }

                as[l2] = jy1.readString();
                fh = as;
                break;

            case 18: // '\022'
                int i3 = kh.c(jy1, 18);
                aae aaae[];
                int l;
                if (fi == null)
                {
                    l = 0;
                } else
                {
                    l = fi.length;
                }
                aaae = new fi[i3 + l];
                i3 = l;
                if (l != 0)
                {
                    System.arraycopy(fi, 0, aaae, 0, l);
                    i3 = l;
                }
                for (; i3 < aaae.length - 1; i3++)
                {
                    aaae[i3] = new <init>();
                    jy1.a(aaae[i3]);
                    jy1.ky();
                }

                aaae[i3] = new <init>();
                jy1.a(aaae[i3]);
                fi = aaae;
                break;

            case 26: // '\032'
                int j3 = kh.c(jy1, 26);
                aae aaae1[];
                int i1;
                if (fj == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = fj.length;
                }
                aaae1 = new fj[j3 + i1];
                j3 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(fj, 0, aaae1, 0, i1);
                    j3 = i1;
                }
                for (; j3 < aaae1.length - 1; j3++)
                {
                    aaae1[j3] = new <init>();
                    jy1.a(aaae1[j3]);
                    jy1.ky();
                }

                aaae1[j3] = new <init>();
                jy1.a(aaae1[j3]);
                fj = aaae1;
                break;

            case 34: // '"'
                int k3 = kh.c(jy1, 34);
                aae aaae2[];
                int j1;
                if (fk == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = fk.length;
                }
                aaae2 = new fk[k3 + j1];
                k3 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(fk, 0, aaae2, 0, j1);
                    k3 = j1;
                }
                for (; k3 < aaae2.length - 1; k3++)
                {
                    aaae2[k3] = new <init>();
                    jy1.a(aaae2[k3]);
                    jy1.ky();
                }

                aaae2[k3] = new <init>();
                jy1.a(aaae2[k3]);
                fk = aaae2;
                break;

            case 42: // '*'
                int l3 = kh.c(jy1, 42);
                aae aaae3[];
                int k1;
                if (fl == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = fl.length;
                }
                aaae3 = new fl[l3 + k1];
                l3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(fl, 0, aaae3, 0, k1);
                    l3 = k1;
                }
                for (; l3 < aaae3.length - 1; l3++)
                {
                    aaae3[l3] = new <init>();
                    jy1.a(aaae3[l3]);
                    jy1.ky();
                }

                aaae3[l3] = new <init>();
                jy1.a(aaae3[l3]);
                fl = aaae3;
                break;

            case 50: // '2'
                int i4 = kh.c(jy1, 50);
                aae aaae4[];
                int l1;
                if (fm == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = fm.length;
                }
                aaae4 = new fm[i4 + l1];
                i4 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(fm, 0, aaae4, 0, l1);
                    i4 = l1;
                }
                for (; i4 < aaae4.length - 1; i4++)
                {
                    aaae4[i4] = new <init>();
                    jy1.a(aaae4[i4]);
                    jy1.ky();
                }

                aaae4[i4] = new <init>();
                jy1.a(aaae4[i4]);
                fm = aaae4;
                break;

            case 58: // ':'
                int j4 = kh.c(jy1, 58);
                aae aaae5[];
                int i2;
                if (fn == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = fn.length;
                }
                aaae5 = new fn[j4 + i2];
                j4 = i2;
                if (i2 != 0)
                {
                    System.arraycopy(fn, 0, aaae5, 0, i2);
                    j4 = i2;
                }
                for (; j4 < aaae5.length - 1; j4++)
                {
                    aaae5[j4] = new <init>();
                    jy1.a(aaae5[j4]);
                    jy1.ky();
                }

                aaae5[j4] = new <init>();
                jy1.a(aaae5[j4]);
                fn = aaae5;
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
                    fs = new <init>();
                }
                jy1.a(fs);
                break;

            case 125: // '}'
                ft = jy1.readFloat();
                break;

            case 130: 
                int k4 = kh.c(jy1, 130);
                String as1[];
                int j2;
                if (fv == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = fv.length;
                }
                as1 = new String[k4 + j2];
                k4 = j2;
                if (j2 != 0)
                {
                    System.arraycopy(fv, 0, as1, 0, j2);
                    k4 = j2;
                }
                for (; k4 < as1.length - 1; k4++)
                {
                    as1[k4] = jy1.readString();
                    jy1.ky();
                }

                as1[k4] = jy1.readString();
                fv = as1;
                break;

            case 136: 
                fw = jy1.kB();
                break;

            case 144: 
                fu = jy1.kC();
                break;

            case 154: 
                int l4 = kh.c(jy1, 154);
                String as2[];
                int k2;
                if (fg == null)
                {
                    k2 = 0;
                } else
                {
                    k2 = fg.length;
                }
                as2 = new String[l4 + k2];
                l4 = k2;
                if (k2 != 0)
                {
                    System.arraycopy(fg, 0, as2, 0, k2);
                    l4 = k2;
                }
                for (; l4 < as2.length - 1; l4++)
                {
                    as2[l4] = jy1.readString();
                    jy1.ky();
                }

                as2[l4] = jy1.readString();
                fg = as2;
                break;
            }
        } while (true);
    }

    public int hashCode()
    {
        boolean flag = false;
        int l1 = kc.hashCode(fg);
        int i2 = kc.hashCode(fh);
        int j2 = kc.hashCode(fi);
        int k2 = kc.hashCode(fj);
        int l2 = kc.hashCode(fk);
        int i3 = kc.hashCode(fl);
        int j3 = kc.hashCode(fm);
        int k3 = kc.hashCode(fn);
        int i;
        int j;
        int l;
        int i1;
        int j1;
        char c1;
        int k1;
        int l3;
        int i4;
        int j4;
        if (fo == null)
        {
            i = 0;
        } else
        {
            i = fo.hashCode();
        }
        if (fp == null)
        {
            j = 0;
        } else
        {
            j = fp.hashCode();
        }
        if (fq == null)
        {
            l = 0;
        } else
        {
            l = fq.hashCode();
        }
        if (fr == null)
        {
            i1 = 0;
        } else
        {
            i1 = fr.hashCode();
        }
        if (fs == null)
        {
            j1 = 0;
        } else
        {
            j1 = fs.hashCode();
        }
        l3 = Float.floatToIntBits(ft);
        if (fu)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        i4 = kc.hashCode(fv);
        j4 = fw;
        k1 = ((flag) ? 1 : 0);
        if (aae != null)
        {
            if (aae.isEmpty())
            {
                k1 = ((flag) ? 1 : 0);
            } else
            {
                k1 = aae.hashCode();
            }
        }
        return (((c1 + ((j1 + (i1 + (l + (j + (i + ((((((((l1 + 527) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31) * 31) * 31) * 31) * 31) * 31 + l3) * 31) * 31 + i4) * 31 + j4) * 31 + k1;
    }

    public aae k()
    {
        fg = kh.aao;
        fh = kh.aao;
        fi = r();
        fj = i();
        fk = d();
        fl = d();
        fm = d();
        fn = l();
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

    public ()
    {
        k();
    }
}
