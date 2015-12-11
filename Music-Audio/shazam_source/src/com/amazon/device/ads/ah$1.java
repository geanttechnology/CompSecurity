// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ah, cx

final class c
    implements Runnable
{

    final String a;
    final boolean b;
    final cx c;
    final ah d;

    public final void run()
    {
        ah.a(d, a, b, c);
    }

    (ah ah1, String s, boolean flag, cx cx)
    {
        d = ah1;
        a = s;
        b = flag;
        c = cx;
        super();
    }
}
