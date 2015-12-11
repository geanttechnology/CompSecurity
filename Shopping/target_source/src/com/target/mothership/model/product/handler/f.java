// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.product.i;
import com.target.mothership.services.aa;

public class f
    implements aa
{

    public static final String AVAILABLE = "Available";
    public static final String IN_STOCK = "In Stock";
    public static final String LIMITED_AVAILABILITY = "Limited Availability";
    public static final String LIMITED_STOCK = "Limited Stock";
    public static final String NOT_AVAILABLE = "Not Available";
    public static final String NOT_SOLD_IN_THIS_STORE = "Not sold in this store";
    public static final String OUT_OF_STOCK = "Out of Stock";

    public f()
    {
    }

    public i a(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 7: default 72
    //                   -1786356645: 120
    //                   -1636989744: 176
    //                   -1177569: 148
    //                   473924193: 190
    //                   730222331: 204
    //                   1270065833: 134
    //                   1316322684: 162;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_204;
_L9:
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
        case 5: // '\005'
            return i.LimitedStock;

        case 6: // '\006'
            return i.NotSoldInThisStore;
        }
_L2:
        if (s.equals("In Stock"))
        {
            byte0 = 0;
        }
          goto _L9
_L7:
        if (s.equals("Available"))
        {
            byte0 = 1;
        }
          goto _L9
_L4:
        if (s.equals("Out of Stock"))
        {
            byte0 = 2;
        }
          goto _L9
_L8:
        if (s.equals("Not Available"))
        {
            byte0 = 3;
        }
          goto _L9
_L3:
        if (s.equals("Limited Stock"))
        {
            byte0 = 4;
        }
          goto _L9
_L5:
        if (s.equals("Limited Availability"))
        {
            byte0 = 5;
        }
          goto _L9
        if (s.equals("Not sold in this store"))
        {
            byte0 = 6;
        }
          goto _L9
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
