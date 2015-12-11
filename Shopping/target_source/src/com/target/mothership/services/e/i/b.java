// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.i;

import com.target.mothership.common.product.c;
import com.target.mothership.services.aa;

public class b
    implements aa
{

    public b()
    {
    }

    private c b(String s)
    {
        byte byte0;
        if (s == null)
        {
            return c.UNKNOWN;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR tableswitch 48 50: default 40
    //                   48 72
    //                   49 86
    //                   50 100;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_100;
_L5:
        switch (byte0)
        {
        default:
            return c.UNKNOWN;

        case 0: // '\0'
            return c.ONLINE_ONLY;

        case 1: // '\001'
            return c.STORE_ONLY;

        case 2: // '\002'
            return c.ONLINE_STORES;
        }
_L2:
        if (s.equals("0"))
        {
            byte0 = 0;
        }
          goto _L5
_L3:
        if (s.equals("1"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("2"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public c a(String s)
    {
        return b(s);
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
