// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.product.i;
import com.target.mothership.services.aa;

public class k
    implements aa
{

    public static final String AVAILABLE = "AVAILABLE";
    public static final String IN_STOCK = "IN_STOCK";
    public static final String LIMITED_STOCK = "LIMITED_STOCK";
    public static final String NOT_AVAILABLE = "UNAVAILABLE";
    public static final String NOT_SOLD_IN_THIS_STORE = "NOT_SOLD_IN_STORE";
    public static final String OUT_OF_STOCK = "OUT_OF_STOCK";

    public k()
    {
    }

    public i a(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 6: default 64
    //                   -1302561882: 178
    //                   -865353743: 164
    //                   696655999: 136
    //                   1487498288: 150
    //                   1680948060: 108
    //                   2052692649: 122;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_178;
_L8:
        switch (byte0)
        {
        default:
            return i.UNKNOWN;

        case 0: // '\0'
        case 1: // '\001'
            return i.InStock;

        case 2: // '\002'
        case 3: // '\003'
            return i.OutOfStock;

        case 4: // '\004'
            return i.LimitedStock;

        case 5: // '\005'
            return i.NotSoldInThisStore;
        }
_L6:
        if (s.equals("IN_STOCK"))
        {
            byte0 = 0;
        }
          goto _L8
_L7:
        if (s.equals("AVAILABLE"))
        {
            byte0 = 1;
        }
          goto _L8
_L4:
        if (s.equals("OUT_OF_STOCK"))
        {
            byte0 = 2;
        }
          goto _L8
_L5:
        if (s.equals("UNAVAILABLE"))
        {
            byte0 = 3;
        }
          goto _L8
_L3:
        if (s.equals("LIMITED_STOCK"))
        {
            byte0 = 4;
        }
          goto _L8
        if (s.equals("NOT_SOLD_IN_STORE"))
        {
            byte0 = 5;
        }
          goto _L8
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
