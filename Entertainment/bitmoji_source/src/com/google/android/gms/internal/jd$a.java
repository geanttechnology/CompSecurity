// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, jd, kd, ke, 
//            jz, jy

public static final class kw extends ka
{

    public long Yb;
    public Yc Yc;
    public Yc fV;

    public static kw l(byte abyte0[])
        throws kd
    {
        return (kw)ke.a(new <init>(), abyte0);
    }

    public void a(jz jz1)
        throws IOException
    {
        jz1.b(1, Yb);
        if (fV != null)
        {
            jz1.a(2, fV);
        }
        if (Yc != null)
        {
            jz1.a(3, Yc);
        }
        super.a(jz1);
    }

    public ke b(jy jy1)
        throws IOException
    {
        return n(jy1);
    }

    public int c()
    {
        int j = super.c() + jz.d(1, Yb);
        int i = j;
        if (fV != null)
        {
            i = j + jz.b(2, fV);
        }
        j = i;
        if (Yc != null)
        {
            j = i + jz.b(3, Yc);
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
        if (Yb != ((Yb) (obj)).Yb) goto _L4; else goto _L5
_L5:
        if (fV != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((fV) (obj)).fV != null) goto _L4; else goto _L8
_L8:
        if (Yc != null) goto _L10; else goto _L9
_L9:
        flag = flag1;
        if (((Yc) (obj)).Yc != null) goto _L4; else goto _L11
_L11:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_145;
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
        if (!fV.quals(((quals) (obj)).fV))
        {
            return false;
        }
          goto _L8
_L10:
        if (!Yc.quals(((quals) (obj)).Yc))
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
        int i1 = (int)(Yb ^ Yb >>> 32);
        int i;
        int j;
        int k;
        if (fV == null)
        {
            i = 0;
        } else
        {
            i = fV.ashCode();
        }
        if (Yc == null)
        {
            j = 0;
        } else
        {
            j = Yc.ashCode();
        }
        k = ((flag) ? 1 : 0);
        if (aae != null)
        {
            if (aae.isEmpty())
            {
                k = ((flag) ? 1 : 0);
            } else
            {
                k = aae.hashCode();
            }
        }
        return (j + (i + (i1 + 527) * 31) * 31) * 31 + k;
    }

    public aae kw()
    {
        Yb = 0L;
        fV = null;
        Yc = null;
        aae = null;
        DY = -1;
        return this;
    }

    public DY n(jy jy1)
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
                Yb = jy1.kA();
                break;

            case 18: // '\022'
                if (fV == null)
                {
                    fV = new init>();
                }
                jy1.a(fV);
                break;

            case 26: // '\032'
                if (Yc == null)
                {
                    Yc = new init>();
                }
                jy1.a(Yc);
                break;
            }
        } while (true);
    }

    public ()
    {
        kw();
    }
}
