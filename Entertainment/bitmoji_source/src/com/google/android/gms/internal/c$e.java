// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, kc, jz, 
//            jy, ke

public static final class j extends ka
{

    private static volatile DY ff[];
    public int key;
    public int value;

    public static j[] i()
    {
        if (ff == null)
        {
            synchronized (kc.aah)
            {
                if (ff == null)
                {
                    ff = new ff[0];
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
        if (!(obj instanceof DY)) goto _L4; else goto _L3
_L3:
        obj = (DY)obj;
        flag = flag1;
        if (key != ((key) (obj)).key) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (value != ((value) (obj)).value) goto _L4; else goto _L6
_L6:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (((aae) (obj)).aae == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((aae) (obj)).aae.isEmpty()) goto _L4; else goto _L7
_L7:
        return true;
        return aae.equals(((aae) (obj)).aae);
    }

    public aae f(jy jy1)
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

    public aae j()
    {
        key = 0;
        value = 0;
        aae = null;
        DY = -1;
        return this;
    }

    public ()
    {
        j();
    }
}
