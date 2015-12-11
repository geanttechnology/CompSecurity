// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.b;

class aa
    implements com.target.mothership.services.aa
{

    aa()
    {
    }

    private b b(String s)
    {
        byte byte0;
        if (s == null)
        {
            return b.None;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 48
    //                   -1930231127: 94
    //                   -1084691008: 108
    //                   925315128: 80;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_108;
_L5:
        switch (byte0)
        {
        default:
            return b.None;

        case 0: // '\0'
            return b.Email;

        case 1: // '\001'
            return b.Mobile;

        case 2: // '\002'
            return b.Standard;
        }
_L4:
        if (s.equals("Email Delivery"))
        {
            byte0 = 0;
        }
          goto _L5
_L2:
        if (s.equals("Mobile Text Delivery"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("Ship to Home"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public b a(String s)
    {
        return b(s);
    }

    public volatile Object a(Object obj)
    {
        return a((String)obj);
    }
}
