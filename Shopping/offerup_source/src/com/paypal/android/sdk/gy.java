// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class gy extends Enum
{

    public static final gy a;
    public static final gy b;
    public static final gy c;
    private static gy e;
    private static final gy f[];
    final String d;

    private gy(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static gy a(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   -503070503: 118
    //                   -503070502: 104
    //                   79201641: 146
    //                   79923350: 132;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_146;
_L6:
        switch (byte0)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Unexpected TLS version: ")).append(s).toString());

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;

        case 3: // '\003'
            return e;
        }
_L3:
        if (s.equals("TLSv1.2"))
        {
            byte0 = 0;
        }
          goto _L6
_L2:
        if (s.equals("TLSv1.1"))
        {
            byte0 = 1;
        }
          goto _L6
_L5:
        if (s.equals("TLSv1"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("SSLv3"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public static gy valueOf(String s)
    {
        return (gy)Enum.valueOf(com/paypal/android/sdk/gy, s);
    }

    public static gy[] values()
    {
        return (gy[])f.clone();
    }

    static 
    {
        a = new gy("TLS_1_2", 0, "TLSv1.2");
        b = new gy("TLS_1_1", 1, "TLSv1.1");
        c = new gy("TLS_1_0", 2, "TLSv1");
        e = new gy("SSL_3_0", 3, "SSLv3");
        f = (new gy[] {
            a, b, c, e
        });
    }
}
