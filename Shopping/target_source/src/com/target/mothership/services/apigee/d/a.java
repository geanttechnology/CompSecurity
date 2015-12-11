// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.d;

import com.target.mothership.common.product.i;
import com.target.mothership.services.aa;

public class a
    implements aa
{

    public a()
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
        JVM INSTR tableswitch 48 54: default 56
    //                   48 104
    //                   49 118
    //                   50 132
    //                   51 146
    //                   52 160
    //                   53 174
    //                   54 188;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_188;
_L9:
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
            return i.OnBackorder;

        case 4: // '\004'
        case 5: // '\005'
            return i.PreOrder;

        case 6: // '\006'
            return i.OutOfStock;
        }
_L2:
        if (s.equals("0"))
        {
            byte0 = 0;
        }
          goto _L9
_L3:
        if (s.equals("1"))
        {
            byte0 = 1;
        }
          goto _L9
_L4:
        if (s.equals("2"))
        {
            byte0 = 2;
        }
          goto _L9
_L5:
        if (s.equals("3"))
        {
            byte0 = 3;
        }
          goto _L9
_L6:
        if (s.equals("4"))
        {
            byte0 = 4;
        }
          goto _L9
_L7:
        if (s.equals("5"))
        {
            byte0 = 5;
        }
          goto _L9
        if (s.equals("6"))
        {
            byte0 = 6;
        }
          goto _L9
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
