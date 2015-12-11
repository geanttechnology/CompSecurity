// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, kc, jz, 
//            jy, ke

public static final class g extends ka
{

    private static volatile aae eW[];
    public String eX;
    public long eY;
    public long eZ;
    public boolean fa;
    public long fb;

    public static g[] f()
    {
        if (eW == null)
        {
            synchronized (kc.aah)
            {
                if (eW == null)
                {
                    eW = new eW[0];
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
        int j = super.c();
        int i = j;
        if (!eX.equals(""))
        {
            i = j + jz.g(1, eX);
        }
        j = i;
        if (eY != 0L)
        {
            j = i + jz.d(2, eY);
        }
        i = j;
        if (eZ != 0x7fffffffL)
        {
            i = j + jz.d(3, eZ);
        }
        j = i;
        if (fa)
        {
            j = i + jz.b(4, fa);
        }
        i = j;
        if (fb != 0L)
        {
            i = j + jz.d(5, fb);
        }
        DY = i;
        return i;
    }

    public DY d(jy jy1)
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
        if (!(obj instanceof A)) goto _L4; else goto _L3
_L3:
        obj = (A)obj;
        if (eX != null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        flag = flag1;
        if (((eX) (obj)).eX != null) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (eY != ((eY) (obj)).eY) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (eZ != ((eZ) (obj)).eZ) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (fa != ((fa) (obj)).fa) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (fb != ((fb) (obj)).fb) goto _L4; else goto _L9
_L9:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_154;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L10
_L10:
        return true;
        if (!eX.equals(((eX) (obj)).eX))
        {
            return false;
        }
          goto _L5
        return aae.equals(((aae) (obj)).aae);
    }

    public aae g()
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
        int i;
        char c1;
        int j;
        int k;
        int l;
        int i1;
        if (eX == null)
        {
            i = 0;
        } else
        {
            i = eX.hashCode();
        }
        k = (int)(eY ^ eY >>> 32);
        l = (int)(eZ ^ eZ >>> 32);
        if (fa)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        i1 = (int)(fb ^ fb >>> 32);
        j = ((flag) ? 1 : 0);
        if (aae != null)
        {
            if (aae.isEmpty())
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = aae.hashCode();
            }
        }
        return ((c1 + (((i + 527) * 31 + k) * 31 + l) * 31) * 31 + i1) * 31 + j;
    }

    public ()
    {
        g();
    }
}
