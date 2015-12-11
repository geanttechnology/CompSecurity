// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.product.o;
import com.target.mothership.services.aa;

public class j
    implements aa
{

    public static final String ANY = "NONE";
    public static final String PICK_UP = "HOLD";
    public static final String SHIP_TO_STORE = "SHIPSTORE";

    public j()
    {
    }

    public o a(String s)
    {
        byte byte0;
        if (s == null)
        {
            return o.UNKNOWN;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 48
    //                   -328715259: 94
    //                   2223295: 80
    //                   2402104: 108;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_108;
_L5:
        switch (byte0)
        {
        default:
            return o.UNKNOWN;

        case 0: // '\0'
            return o.PICKUP_IN_STORE;

        case 1: // '\001'
            return o.SHIP_TO_STORE;

        case 2: // '\002'
            return o.ANY;
        }
_L3:
        if (s.equals("HOLD"))
        {
            byte0 = 0;
        }
          goto _L5
_L2:
        if (s.equals("SHIPSTORE"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("NONE"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
