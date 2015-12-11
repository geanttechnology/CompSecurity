// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            x, cm, dz, cz

public class w
{

    private static final String a = com/amazon/device/ads/w.getSimpleName();
    private static final x b = new x(a);

    private w()
    {
    }

    static x a()
    {
        return b;
    }

    public static final void a(String s)
    {
        cz cz1 = b.a.c;
        if (s.length() == 0)
        {
            throw new IllegalArgumentException("Application Key must not be null or empty.");
        } else
        {
            cz1.a = dz.a(s);
            return;
        }
    }

}
