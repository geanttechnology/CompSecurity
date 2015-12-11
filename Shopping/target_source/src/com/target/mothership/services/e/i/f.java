// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.i;

import com.target.mothership.common.product.i;
import com.target.mothership.services.aa;

public class f
    implements aa
{

    public f()
    {
    }

    private i b(String s)
    {
        byte byte0;
        if (s == null)
        {
            return i.UNKNOWN;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 11: default 112
    //                   -2077427086: 232
    //                   -2044524117: 246
    //                   -865353743: 204
    //                   -158496089: 260
    //                   -56964446: 305
    //                   140722205: 290
    //                   696655999: 218
    //                   1487498288: 275
    //                   1581729819: 320
    //                   1680948060: 190
    //                   2052692649: 176;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        break; /* Loop/switch isn't completed */
_L10:
        break MISSING_BLOCK_LABEL_320;
_L13:
        switch (byte0)
        {
        default:
            return i.UNKNOWN;

        case 0: // '\0'
        case 1: // '\001'
            return i.InStock;

        case 2: // '\002'
            return i.LimitedStock;

        case 3: // '\003'
            return i.OutOfStock;

        case 4: // '\004'
            return i.PreOrder;

        case 5: // '\005'
            return i.PreOrderNonSellable;

        case 6: // '\006'
            return i.OnBackorder;

        case 7: // '\007'
            return i.UnAvailable;

        case 8: // '\b'
            return i.NotAvailable;

        case 9: // '\t'
            return i.CurrentlyNotOnSale;

        case 10: // '\n'
            return i.NotSoldInThisStore;
        }
_L12:
        if (s.equals("AVAILABLE"))
        {
            byte0 = 0;
        }
          goto _L13
_L11:
        if (s.equals("IN_STOCK"))
        {
            byte0 = 1;
        }
          goto _L13
_L4:
        if (s.equals("LIMITED_STOCK"))
        {
            byte0 = 2;
        }
          goto _L13
_L8:
        if (s.equals("OUT_OF_STOCK"))
        {
            byte0 = 3;
        }
          goto _L13
_L2:
        if (s.equals("PRE_ORDER"))
        {
            byte0 = 4;
        }
          goto _L13
_L3:
        if (s.equals("PRE_ORDER_NON_SELLABLE"))
        {
            byte0 = 5;
        }
          goto _L13
_L5:
        if (s.equals("BACKORDER"))
        {
            byte0 = 6;
        }
          goto _L13
_L9:
        if (s.equals("UNAVAILABLE"))
        {
            byte0 = 7;
        }
          goto _L13
_L7:
        if (s.equals("NOT_AVAILABLE"))
        {
            byte0 = 8;
        }
          goto _L13
_L6:
        if (s.equals("NOT_CURRENTLY_FOR_SALE"))
        {
            byte0 = 9;
        }
          goto _L13
        if (s.equals("NOT_SOLD_IN_THIS_STORE"))
        {
            byte0 = 10;
        }
          goto _L13
    }

    public i a(String s)
    {
        return b(s);
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
