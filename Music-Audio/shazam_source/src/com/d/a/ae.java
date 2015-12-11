// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;


// Referenced classes of package com.d.a:
//            r, aj, x, ah

final class ae
    implements Runnable
{

    private String a;
    private r b;

    ae(r r1, String s)
    {
        b = r1;
        a = s;
        super();
    }

    public final void run()
    {
        if (a != null)
        {
            aj.a(b.d, b.b, a);
            b.c.a(new x((byte)8, b.d.f()));
            return;
        } else
        {
            String s = (new StringBuilder("Unable to launch in app market: ")).append(b.a).toString();
            String s1 = aj.a;
            aj.b(b.d, s);
            return;
        }
    }
}
