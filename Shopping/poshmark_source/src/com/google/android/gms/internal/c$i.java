// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, kc, jz, 
//            jy, ke

public static final class p extends ka
{

    private static volatile DY fR[];
    public DY fS;
    public DY fT;
    public String name;

    public static p[] o()
    {
        if (fR == null)
        {
            synchronized (kc.aah)
            {
                if (fR == null)
                {
                    fR = new fR[0];
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
        if (!(obj instanceof DY)) goto _L4; else goto _L3
_L3:
        obj = (DY)obj;
        if (name != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (((name) (obj)).name != null) goto _L4; else goto _L7
_L7:
        if (fS != null) goto _L9; else goto _L8
_L8:
        flag = flag1;
        if (((fS) (obj)).fS != null) goto _L4; else goto _L10
_L10:
        if (fT != null) goto _L12; else goto _L11
_L11:
        flag = flag1;
        if (((fT) (obj)).fT != null) goto _L4; else goto _L13
_L13:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_163;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L14
_L14:
        return true;
_L6:
        if (!name.equals(((name) (obj)).name))
        {
            return false;
        }
          goto _L7
_L9:
        if (!fS.equals(((equals) (obj)).fS))
        {
            return false;
        }
          goto _L10
_L12:
        if (!fT.equals(((equals) (obj)).fT))
        {
            return false;
        }
          goto _L13
        return aae.equals(((aae) (obj)).aae);
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

    public aae j(jy jy1)
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
                    fS = new <init>();
                }
                jy1.a(fS);
                break;

            case 26: // '\032'
                if (fT == null)
                {
                    fT = new <init>();
                }
                jy1.a(fT);
                break;
            }
        } while (true);
    }

    public fT p()
    {
        name = "";
        fS = null;
        fT = null;
        aae = null;
        DY = -1;
        return this;
    }

    public ()
    {
        p();
    }
}
