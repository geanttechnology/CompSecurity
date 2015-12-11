// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.common.c;
import com.target.mothership.services.aa;
import com.target.mothership.util.o;

class l
    implements aa
{

    l()
    {
    }

    private c b(String s)
    {
        byte byte0;
        if (!o.g(s))
        {
            return c.Other;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 60
    //                   2281: 92
    //                   2282: 134
    //                   2436: 106
    //                   2746: 120;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_134;
_L6:
        switch (byte0)
        {
        default:
            return c.Other;

        case 0: // '\0'
            return c.Home;

        case 1: // '\001'
            return c.Mobile;

        case 2: // '\002'
            return c.Work;
        }
_L2:
        if (s.equals("H1"))
        {
            byte0 = 0;
        }
          goto _L6
_L4:
        if (s.equals("M1"))
        {
            byte0 = 1;
        }
          goto _L6
_L5:
        if (s.equals("W1"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("H2"))
        {
            byte0 = 3;
        }
          goto _L6
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
