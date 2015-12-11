// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.i;

import com.target.mothership.common.product.m;
import com.target.mothership.services.aa;

public class g
    implements aa
{

    public g()
    {
    }

    private m b(String s)
    {
        byte byte0;
        if (s == null)
        {
            return m.Unavailable;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 56
    //                   -1802902336: 92
    //                   -1614627478: 106
    //                   175259132: 120
    //                   1487498288: 134;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_134;
_L6:
        switch (byte0)
        {
        default:
            return m.Unavailable;

        case 0: // '\0'
            return m.PickUpInStore;

        case 1: // '\001'
            return m.ShipToStore;

        case 2: // '\002'
            return m.Ineligible;

        case 3: // '\003'
            return m.Unavailable;
        }
_L2:
        if (s.equals("PICKUPINSTORE"))
        {
            byte0 = 0;
        }
          goto _L6
_L3:
        if (s.equals("SHIPTOSTORE"))
        {
            byte0 = 1;
        }
          goto _L6
_L4:
        if (s.equals("INELIGIBLE"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("UNAVAILABLE"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public m a(String s)
    {
        return b(s);
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
