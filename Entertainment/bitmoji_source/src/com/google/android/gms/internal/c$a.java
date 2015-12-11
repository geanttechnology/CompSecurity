// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ka, c, jy, jz, 
//            ke

public static final class b extends ka
{

    public int eP;
    public int eQ;
    public int level;

    public b a(jy jy1)
        throws IOException
    {
_L6:
        int i = jy1.ky();
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   0: 57
    //                   8: 59
    //                   16: 103
    //                   24: 114;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (a(jy1, i)) goto _L6; else goto _L2
_L2:
        return this;
_L3:
        int j = jy1.kB();
        switch (j)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            level = j;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        eP = jy1.kB();
        continue; /* Loop/switch isn't completed */
_L5:
        eQ = jy1.kB();
        if (true) goto _L6; else goto _L7
_L7:
    }

    public void a(jz jz1)
        throws IOException
    {
        if (level != 1)
        {
            jz1.f(1, level);
        }
        if (eP != 0)
        {
            jz1.f(2, eP);
        }
        if (eQ != 0)
        {
            jz1.f(3, eQ);
        }
        super.a(jz1);
    }

    public  b()
    {
        level = 1;
        eP = 0;
        eQ = 0;
        aae = null;
        DY = -1;
        return this;
    }

    public ke b(jy jy1)
        throws IOException
    {
        return a(jy1);
    }

    public int c()
    {
        int j = super.c();
        int i = j;
        if (level != 1)
        {
            i = j + jz.g(1, level);
        }
        j = i;
        if (eP != 0)
        {
            j = i + jz.g(2, eP);
        }
        i = j;
        if (eQ != 0)
        {
            i = j + jz.g(3, eQ);
        }
        DY = i;
        return i;
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
        if (level != ((level) (obj)).level) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (eP != ((eP) (obj)).eP) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (eQ != ((eQ) (obj)).eQ) goto _L4; else goto _L7
_L7:
        if (aae != null && !aae.isEmpty())
        {
            break MISSING_BLOCK_LABEL_106;
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

    public int hashCode()
    {
        int j = level;
        int k = eP;
        int l = eQ;
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
        b();
    }
}
