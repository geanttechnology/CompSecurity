// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.product.o;
import com.target.mothership.services.aa;

public class c
    implements aa
{

    public static final String ANY = "none";
    public static final String PICK_UP = "hold";
    public static final String SHIP_TO_STORE = "shiptostore";

    public c()
    {
    }

    public o a(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   3208383: 72
    //                   3387192: 100
    //                   527378826: 86;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_100;
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
_L2:
        if (s.equals("hold"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s.equals("shiptostore"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("none"))
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
