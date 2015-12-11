// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, jz, jy, 
//            kh, kc, ke

public static final class h extends ka
{

    public aae fc[];
    public aae fd[];
    public aae fe[];

    public void a(jz jz1)
        throws IOException
    {
        boolean flag = false;
        if (fc != null && fc.length > 0)
        {
            for (int i = 0; i < fc.length; i++)
            {
                h h1 = fc[i];
                if (h1 != null)
                {
                    jz1.a(1, h1);
                }
            }

        }
        if (fd != null && fd.length > 0)
        {
            for (int j = 0; j < fd.length; j++)
            {
                h h2 = fd[j];
                if (h2 != null)
                {
                    jz1.a(2, h2);
                }
            }

        }
        if (fe != null && fe.length > 0)
        {
            for (int k = ((flag) ? 1 : 0); k < fe.length; k++)
            {
                h h3 = fe[k];
                if (h3 != null)
                {
                    jz1.a(3, h3);
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
        int i = super.c();
        int j = i;
        if (fc != null)
        {
            j = i;
            if (fc.length > 0)
            {
                for (j = 0; j < fc.length;)
                {
                    e e1 = fc[j];
                    int i1 = i;
                    if (e1 != null)
                    {
                        i1 = i + jz.b(1, e1);
                    }
                    j++;
                    i = i1;
                }

                j = i;
            }
        }
        i = j;
        if (fd != null)
        {
            i = j;
            if (fd.length > 0)
            {
                i = j;
                for (int k = 0; k < fd.length;)
                {
                    e e2 = fd[k];
                    int j1 = i;
                    if (e2 != null)
                    {
                        j1 = i + jz.b(2, e2);
                    }
                    k++;
                    i = j1;
                }

            }
        }
        int k1 = i;
        if (fe != null)
        {
            k1 = i;
            if (fe.length > 0)
            {
                int l = ((flag) ? 1 : 0);
                do
                {
                    k1 = i;
                    if (l >= fe.length)
                    {
                        break;
                    }
                    e e3 = fe[l];
                    k1 = i;
                    if (e3 != null)
                    {
                        k1 = i + jz.b(3, e3);
                    }
                    l++;
                    i = k1;
                } while (true);
            }
        }
        DY = k1;
        return k1;
    }

    public DY e(jy jy1)
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
                int i1 = kh.c(jy1, 10);
                DY ady[];
                int j;
                if (fc == null)
                {
                    j = 0;
                } else
                {
                    j = fc.length;
                }
                ady = new fc[i1 + j];
                i1 = j;
                if (j != 0)
                {
                    System.arraycopy(fc, 0, ady, 0, j);
                    i1 = j;
                }
                for (; i1 < ady.length - 1; i1++)
                {
                    ady[i1] = new <init>();
                    jy1.a(ady[i1]);
                    jy1.ky();
                }

                ady[i1] = new <init>();
                jy1.a(ady[i1]);
                fc = ady;
                break;

            case 18: // '\022'
                int j1 = kh.c(jy1, 18);
                DY ady1[];
                int k;
                if (fd == null)
                {
                    k = 0;
                } else
                {
                    k = fd.length;
                }
                ady1 = new fd[j1 + k];
                j1 = k;
                if (k != 0)
                {
                    System.arraycopy(fd, 0, ady1, 0, k);
                    j1 = k;
                }
                for (; j1 < ady1.length - 1; j1++)
                {
                    ady1[j1] = new <init>();
                    jy1.a(ady1[j1]);
                    jy1.ky();
                }

                ady1[j1] = new <init>();
                jy1.a(ady1[j1]);
                fd = ady1;
                break;

            case 26: // '\032'
                int k1 = kh.c(jy1, 26);
                DY ady2[];
                int l;
                if (fe == null)
                {
                    l = 0;
                } else
                {
                    l = fe.length;
                }
                ady2 = new fe[k1 + l];
                k1 = l;
                if (l != 0)
                {
                    System.arraycopy(fe, 0, ady2, 0, l);
                    k1 = l;
                }
                for (; k1 < ady2.length - 1; k1++)
                {
                    ady2[k1] = new <init>();
                    jy1.a(ady2[k1]);
                    jy1.ky();
                }

                ady2[k1] = new <init>();
                jy1.a(ady2[k1]);
                fe = ady2;
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
        if (!(obj instanceof fe)) goto _L4; else goto _L3
_L3:
        obj = (fe)obj;
        flag = flag1;
        if (!kc.equals(fc, ((fc) (obj)).fc)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!kc.equals(fd, ((fd) (obj)).fd)) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (!kc.equals(fe, ((fe) (obj)).fe)) goto _L4; else goto _L7
_L7:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L8
_L8:
        return true;
        return aae.equals(((aae) (obj)).aae);
    }

    public aae h()
    {
        fc = r();
        fd = r();
        fe = f();
        aae = null;
        DY = -1;
        return this;
    }

    public int hashCode()
    {
        int j = kc.hashCode(fc);
        int k = kc.hashCode(fd);
        int l = kc.hashCode(fe);
        int i;
        if (aae == null || aae.isEmpty())
        {
            i = 0;
        } else
        {
            i = aae.hashCode();
        }
        return i + (((j + 527) * 31 + k) * 31 + l) * 31;
    }

    public ()
    {
        h();
    }
}
