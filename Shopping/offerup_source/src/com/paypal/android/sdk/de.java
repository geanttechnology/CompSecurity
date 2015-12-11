// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class de extends Enum
{

    public static final de a;
    private static de b;
    private static de c;
    private static de d;
    private static de e;
    private static de f;
    private static de g;
    private static de h;
    private static de i;
    private static final de j[];

    private de(String s, int k)
    {
        super(s, k);
    }

    public static de a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        de de1 = a;
_L6:
        return de1;
_L2:
        de ade[];
        int k;
        int l;
        ade = values();
        l = ade.length;
        k = 0;
_L7:
        if (k >= l) goto _L4; else goto _L3
_L3:
        de de2;
        de2 = ade[k];
        if (de2 == a || de2 == i)
        {
            continue; /* Loop/switch isn't completed */
        }
        de1 = de2;
        if (s.equalsIgnoreCase(de2.toString())) goto _L6; else goto _L5
_L5:
        k++;
          goto _L7
_L4:
        return a;
    }

    public static de valueOf(String s)
    {
        return (de)Enum.valueOf(com/paypal/android/sdk/de, s);
    }

    public static de[] values()
    {
        return (de[])j.clone();
    }

    static 
    {
        b = new de("AMEX", 0);
        c = new de("DINERSCLUB", 1);
        d = new de("DISCOVER", 2);
        e = new de("JCB", 3);
        f = new de("MASTERCARD", 4);
        g = new de("VISA", 5);
        h = new de("MAESTRO", 6);
        a = new de("UNKNOWN", 7);
        i = new de("INSUFFICIENT_DIGITS", 8);
        j = (new de[] {
            b, c, d, e, f, g, h, a, i
        });
    }
}
