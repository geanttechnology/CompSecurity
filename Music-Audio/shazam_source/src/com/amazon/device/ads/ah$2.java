// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ah, f, h, cx

final class d
    implements Runnable
{

    final String a;
    final String b;
    final boolean c;
    final cx d;
    final ah e;

    public final void run()
    {
        f f1 = ah.a(e);
        String s = a;
        String s1 = b;
        boolean flag = c;
        cx cx = d;
        f1.a.a(s, s1, flag, cx);
    }

    (ah ah1, String s, String s1, boolean flag, cx cx)
    {
        e = ah1;
        a = s;
        b = s1;
        c = flag;
        d = cx;
        super();
    }
}
