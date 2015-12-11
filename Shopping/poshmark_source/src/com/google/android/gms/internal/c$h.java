// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, kb, jz, 
//            kc, jy, kh, ke

public static final class n extends ka
{

    public static final kb fI = kb.a(11, com/google/android/gms/internal/c$h, 810);
    private static final  fJ[] = new [0];
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
            for (int j = 0; j < fK.length; j++)
            {
                jz1.f(1, fK[j]);
            }

        }
        if (fL != null && fL.length > 0)
        {
            for (int k = 0; k < fL.length; k++)
            {
                jz1.f(2, fL[k]);
            }

        }
        if (fM != null && fM.length > 0)
        {
            for (int l = 0; l < fM.length; l++)
            {
                jz1.f(3, fM[l]);
            }

        }
        if (fN != 0)
        {
            jz1.f(4, fN);
        }
        if (fO != null && fO.length > 0)
        {
            for (int i1 = ((flag) ? 1 : 0); i1 < fO.length; i1++)
            {
                jz1.f(5, fO[i1]);
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
        int i1 = super.c();
        int k;
        int l;
        if (fK != null && fK.length > 0)
        {
            int j = 0;
            l = 0;
            for (; j < fK.length; j++)
            {
                l += jz.cC(fK[j]);
            }

            l = i1 + l + fK.length * 1;
        } else
        {
            l = i1;
        }
        k = l;
        if (fL != null)
        {
            k = l;
            if (fL.length > 0)
            {
                k = 0;
                i1 = 0;
                for (; k < fL.length; k++)
                {
                    i1 += jz.cC(fL[k]);
                }

                k = l + i1 + fL.length * 1;
            }
        }
        l = k;
        if (fM != null)
        {
            l = k;
            if (fM.length > 0)
            {
                l = 0;
                i1 = 0;
                for (; l < fM.length; l++)
                {
                    i1 += jz.cC(fM[l]);
                }

                l = k + i1 + fM.length * 1;
            }
        }
        k = l;
        if (fN != 0)
        {
            k = l + jz.g(4, fN);
        }
        l = k;
        if (fO != null)
        {
            l = k;
            if (fO.length > 0)
            {
                i1 = 0;
                for (l = ((flag) ? 1 : 0); l < fO.length; l++)
                {
                    i1 += jz.cC(fO[l]);
                }

                l = k + i1 + fO.length * 1;
            }
        }
        k = l;
        if (fP != 0)
        {
            k = l + jz.g(6, fP);
        }
        l = k;
        if (fQ != 0)
        {
            l = k + jz.g(7, fQ);
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
        if (!kc.equals(fK, ((fK) (obj)).fK)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!kc.equals(fL, ((fL) (obj)).fL)) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (!kc.equals(fM, ((fM) (obj)).fM)) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (fN != ((fN) (obj)).fN) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (!kc.equals(fO, ((fO) (obj)).fO)) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (fP != ((fP) (obj)).fP) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (fQ != ((fQ) (obj)).fQ) goto _L4; else goto _L11
_L11:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_170;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L12
_L12:
        return true;
        return aae.equals(((aae) (obj)).aae);
    }

    public int hashCode()
    {
        int k = kc.hashCode(fK);
        int l = kc.hashCode(fL);
        int i1 = kc.hashCode(fM);
        int j1 = fN;
        int k1 = kc.hashCode(fO);
        int l1 = fP;
        int i2 = fQ;
        int j;
        if (aae == null || aae.isEmpty())
        {
            j = 0;
        } else
        {
            j = aae.hashCode();
        }
        return j + (((((((k + 527) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31;
    }

    public aae i(jy jy1)
        throws IOException
    {
        do
        {
            int j = jy1.ky();
            switch (j)
            {
            default:
                if (a(jy1, j))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                int k2 = kh.c(jy1, 8);
                int ai[];
                int k;
                if (fK == null)
                {
                    k = 0;
                } else
                {
                    k = fK.length;
                }
                ai = new int[k2 + k];
                k2 = k;
                if (k != 0)
                {
                    System.arraycopy(fK, 0, ai, 0, k);
                    k2 = k;
                }
                for (; k2 < ai.length - 1; k2++)
                {
                    ai[k2] = jy1.kB();
                    jy1.ky();
                }

                ai[k2] = jy1.kB();
                fK = ai;
                break;

            case 10: // '\n'
                int k4 = jy1.cw(jy1.kE());
                int l = jy1.getPosition();
                int l2;
                for (l2 = 0; jy1.kJ() > 0; l2++)
                {
                    jy1.kB();
                }

                jy1.cy(l);
                int ai1[];
                if (fK == null)
                {
                    l = 0;
                } else
                {
                    l = fK.length;
                }
                ai1 = new int[l2 + l];
                l2 = l;
                if (l != 0)
                {
                    System.arraycopy(fK, 0, ai1, 0, l);
                    l2 = l;
                }
                for (; l2 < ai1.length; l2++)
                {
                    ai1[l2] = jy1.kB();
                }

                fK = ai1;
                jy1.cx(k4);
                break;

            case 16: // '\020'
                int i3 = kh.c(jy1, 16);
                int ai2[];
                int i1;
                if (fL == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = fL.length;
                }
                ai2 = new int[i3 + i1];
                i3 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(fL, 0, ai2, 0, i1);
                    i3 = i1;
                }
                for (; i3 < ai2.length - 1; i3++)
                {
                    ai2[i3] = jy1.kB();
                    jy1.ky();
                }

                ai2[i3] = jy1.kB();
                fL = ai2;
                break;

            case 18: // '\022'
                int l4 = jy1.cw(jy1.kE());
                int j1 = jy1.getPosition();
                int j3;
                for (j3 = 0; jy1.kJ() > 0; j3++)
                {
                    jy1.kB();
                }

                jy1.cy(j1);
                int ai3[];
                if (fL == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = fL.length;
                }
                ai3 = new int[j3 + j1];
                j3 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(fL, 0, ai3, 0, j1);
                    j3 = j1;
                }
                for (; j3 < ai3.length; j3++)
                {
                    ai3[j3] = jy1.kB();
                }

                fL = ai3;
                jy1.cx(l4);
                break;

            case 24: // '\030'
                int k3 = kh.c(jy1, 24);
                int ai4[];
                int k1;
                if (fM == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = fM.length;
                }
                ai4 = new int[k3 + k1];
                k3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(fM, 0, ai4, 0, k1);
                    k3 = k1;
                }
                for (; k3 < ai4.length - 1; k3++)
                {
                    ai4[k3] = jy1.kB();
                    jy1.ky();
                }

                ai4[k3] = jy1.kB();
                fM = ai4;
                break;

            case 26: // '\032'
                int i5 = jy1.cw(jy1.kE());
                int l1 = jy1.getPosition();
                int l3;
                for (l3 = 0; jy1.kJ() > 0; l3++)
                {
                    jy1.kB();
                }

                jy1.cy(l1);
                int ai5[];
                if (fM == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = fM.length;
                }
                ai5 = new int[l3 + l1];
                l3 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(fM, 0, ai5, 0, l1);
                    l3 = l1;
                }
                for (; l3 < ai5.length; l3++)
                {
                    ai5[l3] = jy1.kB();
                }

                fM = ai5;
                jy1.cx(i5);
                break;

            case 32: // ' '
                fN = jy1.kB();
                break;

            case 40: // '('
                int i4 = kh.c(jy1, 40);
                int ai6[];
                int i2;
                if (fO == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = fO.length;
                }
                ai6 = new int[i4 + i2];
                i4 = i2;
                if (i2 != 0)
                {
                    System.arraycopy(fO, 0, ai6, 0, i2);
                    i4 = i2;
                }
                for (; i4 < ai6.length - 1; i4++)
                {
                    ai6[i4] = jy1.kB();
                    jy1.ky();
                }

                ai6[i4] = jy1.kB();
                fO = ai6;
                break;

            case 42: // '*'
                int j5 = jy1.cw(jy1.kE());
                int j2 = jy1.getPosition();
                int j4;
                for (j4 = 0; jy1.kJ() > 0; j4++)
                {
                    jy1.kB();
                }

                jy1.cy(j2);
                int ai7[];
                if (fO == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = fO.length;
                }
                ai7 = new int[j4 + j2];
                j4 = j2;
                if (j2 != 0)
                {
                    System.arraycopy(fO, 0, ai7, 0, j2);
                    j4 = j2;
                }
                for (; j4 < ai7.length; j4++)
                {
                    ai7[j4] = jy1.kB();
                }

                fO = ai7;
                jy1.cx(j5);
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

    public B n()
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


    public ()
    {
        n();
    }
}
