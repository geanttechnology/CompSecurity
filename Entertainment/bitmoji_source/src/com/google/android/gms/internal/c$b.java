// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, kc, jz, 
//            jy, kh, ke

public static final class e extends ka
{

    private static volatile aae eR[];
    public int eS[];
    public int eT;
    public boolean eU;
    public boolean eV;
    public int name;

    public static e[] d()
    {
        if (eR == null)
        {
            synchronized (kc.aah)
            {
                if (eR == null)
                {
                    eR = new eR[0];
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
            for (int i = 0; i < eS.length; i++)
            {
                jz1.f(3, eS[i]);
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
        int j = 0;
        int k = super.c();
        int i = k;
        if (eV)
        {
            i = k + jz.b(1, eV);
        }
        k = jz.g(2, eT) + i;
        if (eS != null && eS.length > 0)
        {
            for (i = 0; i < eS.length; i++)
            {
                j += jz.cC(eS[i]);
            }

            j = k + j + eS.length * 1;
        } else
        {
            j = k;
        }
        i = j;
        if (name != 0)
        {
            i = j + jz.g(4, name);
        }
        j = i;
        if (eU)
        {
            j = i + jz.b(6, eU);
        }
        DY = j;
        return j;
    }

    public DY c(jy jy1)
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
                eV = jy1.kC();
                break;

            case 16: // '\020'
                eT = jy1.kB();
                break;

            case 24: // '\030'
                int l = kh.c(jy1, 24);
                int ai[];
                int j;
                if (eS == null)
                {
                    j = 0;
                } else
                {
                    j = eS.length;
                }
                ai = new int[l + j];
                l = j;
                if (j != 0)
                {
                    System.arraycopy(eS, 0, ai, 0, j);
                    l = j;
                }
                for (; l < ai.length - 1; l++)
                {
                    ai[l] = jy1.kB();
                    jy1.ky();
                }

                ai[l] = jy1.kB();
                eS = ai;
                break;

            case 26: // '\032'
                int j1 = jy1.cw(jy1.kE());
                int k = jy1.getPosition();
                int i1;
                for (i1 = 0; jy1.kJ() > 0; i1++)
                {
                    jy1.kB();
                }

                jy1.cy(k);
                int ai1[];
                if (eS == null)
                {
                    k = 0;
                } else
                {
                    k = eS.length;
                }
                ai1 = new int[i1 + k];
                i1 = k;
                if (k != 0)
                {
                    System.arraycopy(eS, 0, ai1, 0, k);
                    i1 = k;
                }
                for (; i1 < ai1.length; i1++)
                {
                    ai1[i1] = jy1.kB();
                }

                eS = ai1;
                jy1.cx(j1);
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

    public C e()
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
        if (!(obj instanceof DY)) goto _L4; else goto _L3
_L3:
        obj = (DY)obj;
        flag = flag1;
        if (!kc.equals(eS, ((eS) (obj)).eS)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (eT != ((eT) (obj)).eT) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (name != ((name) (obj)).name) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (eU != ((eU) (obj)).eU) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (eV != ((eV) (obj)).eV) goto _L4; else goto _L9
_L9:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_135;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L10
_L10:
        return true;
        return aae.equals(((aae) (obj)).aae);
    }

    public int hashCode()
    {
        char c2 = '\u04CF';
        int j = kc.hashCode(eS);
        int k = eT;
        int l = name;
        char c1;
        int i;
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
            i = 0;
        } else
        {
            i = aae.hashCode();
        }
        return i + ((c1 + (((j + 527) * 31 + k) * 31 + l) * 31) * 31 + c2) * 31;
    }

    public ()
    {
        e();
    }
}
