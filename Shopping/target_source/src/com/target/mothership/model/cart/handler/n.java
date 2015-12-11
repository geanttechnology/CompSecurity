// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.f;
import com.target.mothership.services.aa;

class n
    implements aa
{

    n()
    {
    }

    private f b(String s)
    {
        byte byte0;
        if (s == null)
        {
            return f.NONE_SELECTED;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 7: default 80
    //                   -1084691008: 142
    //                   -985151626: 128
    //                   -464619222: 170
    //                   -343811943: 184
    //                   -256988515: 156
    //                   712188859: 198
    //                   1068426203: 212;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_212;
_L9:
        switch (byte0)
        {
        default:
            return f.NONE_SELECTED;

        case 0: // '\0'
        case 1: // '\001'
            return f.ShipToHome;

        case 2: // '\002'
            return f.StorePickup;

        case 3: // '\003'
            return f.ShipToStore;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            return f.Special;
        }
_L3:
        if (s.equals("ShipToHome"))
        {
            byte0 = 0;
        }
          goto _L9
_L2:
        if (s.equals("Ship to Home"))
        {
            byte0 = 1;
        }
          goto _L9
_L6:
        if (s.equals("StorePickup"))
        {
            byte0 = 2;
        }
          goto _L9
_L4:
        if (s.equals("ShipToStore"))
        {
            byte0 = 3;
        }
          goto _L9
_L5:
        if (s.equals("Special"))
        {
            byte0 = 4;
        }
          goto _L9
_L7:
        if (s.equals("Special Delivery"))
        {
            byte0 = 5;
        }
          goto _L9
        if (s.equals(" Special Delivery"))
        {
            byte0 = 6;
        }
          goto _L9
    }

    public f a(String s)
    {
        return b(s);
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
