// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, kd, ke, 
//            jz, kc, jy, kh

public static final class q extends ka
{

    public DY fU[];
    public DY fV;
    public String fW;

    public static q b(byte abyte0[])
        throws kd
    {
        return (q)ke.a(new <init>(), abyte0);
    }

    public void a(jz jz1)
        throws IOException
    {
        if (fU != null && fU.length > 0)
        {
            for (int i = 0; i < fU.length; i++)
            {
                <init> <init>1 = fU[i];
                if (<init>1 != null)
                {
                    jz1.a(1, <init>1);
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
        int i = super.c();
        int l = i;
        if (fU != null)
        {
            l = i;
            if (fU.length > 0)
            {
                int i1 = 0;
                do
                {
                    l = i;
                    if (i1 >= fU.length)
                    {
                        break;
                    }
                    k k1 = fU[i1];
                    l = i;
                    if (k1 != null)
                    {
                        l = i + jz.b(1, k1);
                    }
                    i1++;
                    i = l;
                } while (true);
            }
        }
        i = l;
        if (fV != null)
        {
            i = l + jz.b(2, fV);
        }
        l = i;
        if (!fW.equals(""))
        {
            l = i + jz.g(3, fW);
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
        if (!kc.equals(fU, ((fU) (obj)).fU)) goto _L4; else goto _L5
_L5:
        if (fV != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((fV) (obj)).fV != null) goto _L4; else goto _L8
_L8:
        if (fW != null) goto _L10; else goto _L9
_L9:
        flag = flag1;
        if (((fW) (obj)).fW != null) goto _L4; else goto _L11
_L11:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_147;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L12
_L12:
        return true;
_L7:
        if (!fV.equals(((equals) (obj)).fV))
        {
            return false;
        }
          goto _L8
_L10:
        if (!fW.equals(((fW) (obj)).fW))
        {
            return false;
        }
          goto _L11
        return aae.equals(((aae) (obj)).aae);
          goto _L8
    }

    public int hashCode()
    {
        boolean flag = false;
        int j1 = kc.hashCode(fU);
        int i;
        int l;
        int i1;
        if (fV == null)
        {
            i = 0;
        } else
        {
            i = fV.hashCode();
        }
        if (fW == null)
        {
            l = 0;
        } else
        {
            l = fW.hashCode();
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
        return (l + (i + (j1 + 527) * 31) * 31) * 31 + i1;
    }

    public aae k(jy jy1)
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
                aae aaae[];
                int l;
                if (fU == null)
                {
                    l = 0;
                } else
                {
                    l = fU.length;
                }
                aaae = new fU[i1 + l];
                i1 = l;
                if (l != 0)
                {
                    System.arraycopy(fU, 0, aaae, 0, l);
                    i1 = l;
                }
                for (; i1 < aaae.length - 1; i1++)
                {
                    aaae[i1] = new <init>();
                    jy1.a(aaae[i1]);
                    jy1.ky();
                }

                aaae[i1] = new <init>();
                jy1.a(aaae[i1]);
                fU = aaae;
                break;

            case 18: // '\022'
                if (fV == null)
                {
                    fV = new <init>();
                }
                jy1.a(fV);
                break;

            case 26: // '\032'
                fW = jy1.readString();
                break;
            }
        } while (true);
    }

    public eadString q()
    {
        fU = o();
        fV = null;
        fW = "";
        aae = null;
        DY = -1;
        return this;
    }

    public ()
    {
        q();
    }
}
