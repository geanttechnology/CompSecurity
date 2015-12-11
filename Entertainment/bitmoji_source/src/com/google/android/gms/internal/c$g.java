// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, kc, jz, 
//            jy, kh, ke

public static final class m extends ka
{

    private static volatile DY fx[];
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

    public static m[] l()
    {
        if (fx == null)
        {
            synchronized (kc.aah)
            {
                if (fx == null)
                {
                    fx = new fx[0];
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
            for (int i = 0; i < fy.length; i++)
            {
                jz1.f(1, fy[i]);
            }

        }
        if (fz != null && fz.length > 0)
        {
            for (int j = 0; j < fz.length; j++)
            {
                jz1.f(2, fz[j]);
            }

        }
        if (fA != null && fA.length > 0)
        {
            for (int k = 0; k < fA.length; k++)
            {
                jz1.f(3, fA[k]);
            }

        }
        if (fB != null && fB.length > 0)
        {
            for (int i1 = 0; i1 < fB.length; i1++)
            {
                jz1.f(4, fB[i1]);
            }

        }
        if (fC != null && fC.length > 0)
        {
            for (int j1 = 0; j1 < fC.length; j1++)
            {
                jz1.f(5, fC[j1]);
            }

        }
        if (fD != null && fD.length > 0)
        {
            for (int k1 = 0; k1 < fD.length; k1++)
            {
                jz1.f(6, fD[k1]);
            }

        }
        if (fE != null && fE.length > 0)
        {
            for (int l1 = 0; l1 < fE.length; l1++)
            {
                jz1.f(7, fE[l1]);
            }

        }
        if (fF != null && fF.length > 0)
        {
            for (int i2 = 0; i2 < fF.length; i2++)
            {
                jz1.f(8, fF[i2]);
            }

        }
        if (fG != null && fG.length > 0)
        {
            for (int j2 = 0; j2 < fG.length; j2++)
            {
                jz1.f(9, fG[j2]);
            }

        }
        if (fH != null && fH.length > 0)
        {
            for (int k2 = ((flag) ? 1 : 0); k2 < fH.length; k2++)
            {
                jz1.f(10, fH[k2]);
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
        int i1 = super.c();
        int j;
        int k;
        if (fy != null && fy.length > 0)
        {
            int i = 0;
            k = 0;
            for (; i < fy.length; i++)
            {
                k += jz.cC(fy[i]);
            }

            k = i1 + k + fy.length * 1;
        } else
        {
            k = i1;
        }
        j = k;
        if (fz != null)
        {
            j = k;
            if (fz.length > 0)
            {
                j = 0;
                i1 = 0;
                for (; j < fz.length; j++)
                {
                    i1 += jz.cC(fz[j]);
                }

                j = k + i1 + fz.length * 1;
            }
        }
        k = j;
        if (fA != null)
        {
            k = j;
            if (fA.length > 0)
            {
                k = 0;
                i1 = 0;
                for (; k < fA.length; k++)
                {
                    i1 += jz.cC(fA[k]);
                }

                k = j + i1 + fA.length * 1;
            }
        }
        j = k;
        if (fB != null)
        {
            j = k;
            if (fB.length > 0)
            {
                j = 0;
                i1 = 0;
                for (; j < fB.length; j++)
                {
                    i1 += jz.cC(fB[j]);
                }

                j = k + i1 + fB.length * 1;
            }
        }
        k = j;
        if (fC != null)
        {
            k = j;
            if (fC.length > 0)
            {
                k = 0;
                i1 = 0;
                for (; k < fC.length; k++)
                {
                    i1 += jz.cC(fC[k]);
                }

                k = j + i1 + fC.length * 1;
            }
        }
        j = k;
        if (fD != null)
        {
            j = k;
            if (fD.length > 0)
            {
                j = 0;
                i1 = 0;
                for (; j < fD.length; j++)
                {
                    i1 += jz.cC(fD[j]);
                }

                j = k + i1 + fD.length * 1;
            }
        }
        k = j;
        if (fE != null)
        {
            k = j;
            if (fE.length > 0)
            {
                k = 0;
                i1 = 0;
                for (; k < fE.length; k++)
                {
                    i1 += jz.cC(fE[k]);
                }

                k = j + i1 + fE.length * 1;
            }
        }
        j = k;
        if (fF != null)
        {
            j = k;
            if (fF.length > 0)
            {
                j = 0;
                i1 = 0;
                for (; j < fF.length; j++)
                {
                    i1 += jz.cC(fF[j]);
                }

                j = k + i1 + fF.length * 1;
            }
        }
        k = j;
        if (fG != null)
        {
            k = j;
            if (fG.length > 0)
            {
                k = 0;
                i1 = 0;
                for (; k < fG.length; k++)
                {
                    i1 += jz.cC(fG[k]);
                }

                k = j + i1 + fG.length * 1;
            }
        }
        j = k;
        if (fH != null)
        {
            j = k;
            if (fH.length > 0)
            {
                i1 = 0;
                for (j = ((flag) ? 1 : 0); j < fH.length; j++)
                {
                    i1 += jz.cC(fH[j]);
                }

                j = k + i1 + fH.length * 1;
            }
        }
        DY = j;
        return j;
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
        if (!kc.equals(fy, ((fy) (obj)).fy)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!kc.equals(fz, ((fz) (obj)).fz)) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (!kc.equals(fA, ((fA) (obj)).fA)) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (!kc.equals(fB, ((fB) (obj)).fB)) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (!kc.equals(fC, ((fC) (obj)).fC)) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (!kc.equals(fD, ((fD) (obj)).fD)) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (!kc.equals(fE, ((fE) (obj)).fE)) goto _L4; else goto _L11
_L11:
        flag = flag1;
        if (!kc.equals(fF, ((fF) (obj)).fF)) goto _L4; else goto _L12
_L12:
        flag = flag1;
        if (!kc.equals(fG, ((fG) (obj)).fG)) goto _L4; else goto _L13
_L13:
        flag = flag1;
        if (!kc.equals(fH, ((fH) (obj)).fH)) goto _L4; else goto _L14
_L14:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_227;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L15
_L15:
        return true;
        return aae.equals(((aae) (obj)).aae);
    }

    public aae h(jy jy1)
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

            case 8: // '\b'
                int k5 = kh.c(jy1, 8);
                int ai[];
                int j;
                if (fy == null)
                {
                    j = 0;
                } else
                {
                    j = fy.length;
                }
                ai = new int[k5 + j];
                k5 = j;
                if (j != 0)
                {
                    System.arraycopy(fy, 0, ai, 0, j);
                    k5 = j;
                }
                for (; k5 < ai.length - 1; k5++)
                {
                    ai[k5] = jy1.kB();
                    jy1.ky();
                }

                ai[k5] = jy1.kB();
                fy = ai;
                break;

            case 10: // '\n'
                int k10 = jy1.cw(jy1.kE());
                int k = jy1.getPosition();
                int l5;
                for (l5 = 0; jy1.kJ() > 0; l5++)
                {
                    jy1.kB();
                }

                jy1.cy(k);
                int ai1[];
                if (fy == null)
                {
                    k = 0;
                } else
                {
                    k = fy.length;
                }
                ai1 = new int[l5 + k];
                l5 = k;
                if (k != 0)
                {
                    System.arraycopy(fy, 0, ai1, 0, k);
                    l5 = k;
                }
                for (; l5 < ai1.length; l5++)
                {
                    ai1[l5] = jy1.kB();
                }

                fy = ai1;
                jy1.cx(k10);
                break;

            case 16: // '\020'
                int i6 = kh.c(jy1, 16);
                int ai2[];
                int i1;
                if (fz == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = fz.length;
                }
                ai2 = new int[i6 + i1];
                i6 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(fz, 0, ai2, 0, i1);
                    i6 = i1;
                }
                for (; i6 < ai2.length - 1; i6++)
                {
                    ai2[i6] = jy1.kB();
                    jy1.ky();
                }

                ai2[i6] = jy1.kB();
                fz = ai2;
                break;

            case 18: // '\022'
                int l10 = jy1.cw(jy1.kE());
                int j1 = jy1.getPosition();
                int j6;
                for (j6 = 0; jy1.kJ() > 0; j6++)
                {
                    jy1.kB();
                }

                jy1.cy(j1);
                int ai3[];
                if (fz == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = fz.length;
                }
                ai3 = new int[j6 + j1];
                j6 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(fz, 0, ai3, 0, j1);
                    j6 = j1;
                }
                for (; j6 < ai3.length; j6++)
                {
                    ai3[j6] = jy1.kB();
                }

                fz = ai3;
                jy1.cx(l10);
                break;

            case 24: // '\030'
                int k6 = kh.c(jy1, 24);
                int ai4[];
                int k1;
                if (fA == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = fA.length;
                }
                ai4 = new int[k6 + k1];
                k6 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(fA, 0, ai4, 0, k1);
                    k6 = k1;
                }
                for (; k6 < ai4.length - 1; k6++)
                {
                    ai4[k6] = jy1.kB();
                    jy1.ky();
                }

                ai4[k6] = jy1.kB();
                fA = ai4;
                break;

            case 26: // '\032'
                int i11 = jy1.cw(jy1.kE());
                int l1 = jy1.getPosition();
                int l6;
                for (l6 = 0; jy1.kJ() > 0; l6++)
                {
                    jy1.kB();
                }

                jy1.cy(l1);
                int ai5[];
                if (fA == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = fA.length;
                }
                ai5 = new int[l6 + l1];
                l6 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(fA, 0, ai5, 0, l1);
                    l6 = l1;
                }
                for (; l6 < ai5.length; l6++)
                {
                    ai5[l6] = jy1.kB();
                }

                fA = ai5;
                jy1.cx(i11);
                break;

            case 32: // ' '
                int i7 = kh.c(jy1, 32);
                int ai6[];
                int i2;
                if (fB == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = fB.length;
                }
                ai6 = new int[i7 + i2];
                i7 = i2;
                if (i2 != 0)
                {
                    System.arraycopy(fB, 0, ai6, 0, i2);
                    i7 = i2;
                }
                for (; i7 < ai6.length - 1; i7++)
                {
                    ai6[i7] = jy1.kB();
                    jy1.ky();
                }

                ai6[i7] = jy1.kB();
                fB = ai6;
                break;

            case 34: // '"'
                int j11 = jy1.cw(jy1.kE());
                int j2 = jy1.getPosition();
                int j7;
                for (j7 = 0; jy1.kJ() > 0; j7++)
                {
                    jy1.kB();
                }

                jy1.cy(j2);
                int ai7[];
                if (fB == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = fB.length;
                }
                ai7 = new int[j7 + j2];
                j7 = j2;
                if (j2 != 0)
                {
                    System.arraycopy(fB, 0, ai7, 0, j2);
                    j7 = j2;
                }
                for (; j7 < ai7.length; j7++)
                {
                    ai7[j7] = jy1.kB();
                }

                fB = ai7;
                jy1.cx(j11);
                break;

            case 40: // '('
                int k7 = kh.c(jy1, 40);
                int ai8[];
                int k2;
                if (fC == null)
                {
                    k2 = 0;
                } else
                {
                    k2 = fC.length;
                }
                ai8 = new int[k7 + k2];
                k7 = k2;
                if (k2 != 0)
                {
                    System.arraycopy(fC, 0, ai8, 0, k2);
                    k7 = k2;
                }
                for (; k7 < ai8.length - 1; k7++)
                {
                    ai8[k7] = jy1.kB();
                    jy1.ky();
                }

                ai8[k7] = jy1.kB();
                fC = ai8;
                break;

            case 42: // '*'
                int k11 = jy1.cw(jy1.kE());
                int l2 = jy1.getPosition();
                int l7;
                for (l7 = 0; jy1.kJ() > 0; l7++)
                {
                    jy1.kB();
                }

                jy1.cy(l2);
                int ai9[];
                if (fC == null)
                {
                    l2 = 0;
                } else
                {
                    l2 = fC.length;
                }
                ai9 = new int[l7 + l2];
                l7 = l2;
                if (l2 != 0)
                {
                    System.arraycopy(fC, 0, ai9, 0, l2);
                    l7 = l2;
                }
                for (; l7 < ai9.length; l7++)
                {
                    ai9[l7] = jy1.kB();
                }

                fC = ai9;
                jy1.cx(k11);
                break;

            case 48: // '0'
                int i8 = kh.c(jy1, 48);
                int ai10[];
                int i3;
                if (fD == null)
                {
                    i3 = 0;
                } else
                {
                    i3 = fD.length;
                }
                ai10 = new int[i8 + i3];
                i8 = i3;
                if (i3 != 0)
                {
                    System.arraycopy(fD, 0, ai10, 0, i3);
                    i8 = i3;
                }
                for (; i8 < ai10.length - 1; i8++)
                {
                    ai10[i8] = jy1.kB();
                    jy1.ky();
                }

                ai10[i8] = jy1.kB();
                fD = ai10;
                break;

            case 50: // '2'
                int l11 = jy1.cw(jy1.kE());
                int j3 = jy1.getPosition();
                int j8;
                for (j8 = 0; jy1.kJ() > 0; j8++)
                {
                    jy1.kB();
                }

                jy1.cy(j3);
                int ai11[];
                if (fD == null)
                {
                    j3 = 0;
                } else
                {
                    j3 = fD.length;
                }
                ai11 = new int[j8 + j3];
                j8 = j3;
                if (j3 != 0)
                {
                    System.arraycopy(fD, 0, ai11, 0, j3);
                    j8 = j3;
                }
                for (; j8 < ai11.length; j8++)
                {
                    ai11[j8] = jy1.kB();
                }

                fD = ai11;
                jy1.cx(l11);
                break;

            case 56: // '8'
                int k8 = kh.c(jy1, 56);
                int ai12[];
                int k3;
                if (fE == null)
                {
                    k3 = 0;
                } else
                {
                    k3 = fE.length;
                }
                ai12 = new int[k8 + k3];
                k8 = k3;
                if (k3 != 0)
                {
                    System.arraycopy(fE, 0, ai12, 0, k3);
                    k8 = k3;
                }
                for (; k8 < ai12.length - 1; k8++)
                {
                    ai12[k8] = jy1.kB();
                    jy1.ky();
                }

                ai12[k8] = jy1.kB();
                fE = ai12;
                break;

            case 58: // ':'
                int i12 = jy1.cw(jy1.kE());
                int l3 = jy1.getPosition();
                int l8;
                for (l8 = 0; jy1.kJ() > 0; l8++)
                {
                    jy1.kB();
                }

                jy1.cy(l3);
                int ai13[];
                if (fE == null)
                {
                    l3 = 0;
                } else
                {
                    l3 = fE.length;
                }
                ai13 = new int[l8 + l3];
                l8 = l3;
                if (l3 != 0)
                {
                    System.arraycopy(fE, 0, ai13, 0, l3);
                    l8 = l3;
                }
                for (; l8 < ai13.length; l8++)
                {
                    ai13[l8] = jy1.kB();
                }

                fE = ai13;
                jy1.cx(i12);
                break;

            case 64: // '@'
                int i9 = kh.c(jy1, 64);
                int ai14[];
                int i4;
                if (fF == null)
                {
                    i4 = 0;
                } else
                {
                    i4 = fF.length;
                }
                ai14 = new int[i9 + i4];
                i9 = i4;
                if (i4 != 0)
                {
                    System.arraycopy(fF, 0, ai14, 0, i4);
                    i9 = i4;
                }
                for (; i9 < ai14.length - 1; i9++)
                {
                    ai14[i9] = jy1.kB();
                    jy1.ky();
                }

                ai14[i9] = jy1.kB();
                fF = ai14;
                break;

            case 66: // 'B'
                int j12 = jy1.cw(jy1.kE());
                int j4 = jy1.getPosition();
                int j9;
                for (j9 = 0; jy1.kJ() > 0; j9++)
                {
                    jy1.kB();
                }

                jy1.cy(j4);
                int ai15[];
                if (fF == null)
                {
                    j4 = 0;
                } else
                {
                    j4 = fF.length;
                }
                ai15 = new int[j9 + j4];
                j9 = j4;
                if (j4 != 0)
                {
                    System.arraycopy(fF, 0, ai15, 0, j4);
                    j9 = j4;
                }
                for (; j9 < ai15.length; j9++)
                {
                    ai15[j9] = jy1.kB();
                }

                fF = ai15;
                jy1.cx(j12);
                break;

            case 72: // 'H'
                int k9 = kh.c(jy1, 72);
                int ai16[];
                int k4;
                if (fG == null)
                {
                    k4 = 0;
                } else
                {
                    k4 = fG.length;
                }
                ai16 = new int[k9 + k4];
                k9 = k4;
                if (k4 != 0)
                {
                    System.arraycopy(fG, 0, ai16, 0, k4);
                    k9 = k4;
                }
                for (; k9 < ai16.length - 1; k9++)
                {
                    ai16[k9] = jy1.kB();
                    jy1.ky();
                }

                ai16[k9] = jy1.kB();
                fG = ai16;
                break;

            case 74: // 'J'
                int k12 = jy1.cw(jy1.kE());
                int l4 = jy1.getPosition();
                int l9;
                for (l9 = 0; jy1.kJ() > 0; l9++)
                {
                    jy1.kB();
                }

                jy1.cy(l4);
                int ai17[];
                if (fG == null)
                {
                    l4 = 0;
                } else
                {
                    l4 = fG.length;
                }
                ai17 = new int[l9 + l4];
                l9 = l4;
                if (l4 != 0)
                {
                    System.arraycopy(fG, 0, ai17, 0, l4);
                    l9 = l4;
                }
                for (; l9 < ai17.length; l9++)
                {
                    ai17[l9] = jy1.kB();
                }

                fG = ai17;
                jy1.cx(k12);
                break;

            case 80: // 'P'
                int i10 = kh.c(jy1, 80);
                int ai18[];
                int i5;
                if (fH == null)
                {
                    i5 = 0;
                } else
                {
                    i5 = fH.length;
                }
                ai18 = new int[i10 + i5];
                i10 = i5;
                if (i5 != 0)
                {
                    System.arraycopy(fH, 0, ai18, 0, i5);
                    i10 = i5;
                }
                for (; i10 < ai18.length - 1; i10++)
                {
                    ai18[i10] = jy1.kB();
                    jy1.ky();
                }

                ai18[i10] = jy1.kB();
                fH = ai18;
                break;

            case 82: // 'R'
                int l12 = jy1.cw(jy1.kE());
                int j5 = jy1.getPosition();
                int j10;
                for (j10 = 0; jy1.kJ() > 0; j10++)
                {
                    jy1.kB();
                }

                jy1.cy(j5);
                int ai19[];
                if (fH == null)
                {
                    j5 = 0;
                } else
                {
                    j5 = fH.length;
                }
                ai19 = new int[j10 + j5];
                j10 = j5;
                if (j5 != 0)
                {
                    System.arraycopy(fH, 0, ai19, 0, j5);
                    j10 = j5;
                }
                for (; j10 < ai19.length; j10++)
                {
                    ai19[j10] = jy1.kB();
                }

                fH = ai19;
                jy1.cx(l12);
                break;
            }
        } while (true);
    }

    public int hashCode()
    {
        int j = kc.hashCode(fy);
        int k = kc.hashCode(fz);
        int i1 = kc.hashCode(fA);
        int j1 = kc.hashCode(fB);
        int k1 = kc.hashCode(fC);
        int l1 = kc.hashCode(fD);
        int i2 = kc.hashCode(fE);
        int j2 = kc.hashCode(fF);
        int k2 = kc.hashCode(fG);
        int l2 = kc.hashCode(fH);
        int i;
        if (aae == null || aae.isEmpty())
        {
            i = 0;
        } else
        {
            i = aae.hashCode();
        }
        return i + ((((((((((j + 527) * 31 + k) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31;
    }

    public aae m()
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

    public ()
    {
        m();
    }
}
