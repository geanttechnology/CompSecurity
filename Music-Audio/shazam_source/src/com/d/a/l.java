// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;


// Referenced classes of package com.d.a:
//            d, aj

final class l
    implements Runnable
{

    private String a;
    private aj b;

    l(aj aj1, String s)
    {
        b = aj1;
        a = s;
        super();
    }

    public final void run()
    {
        (new d(101)).a = a;
        if (aj.a(b) != null)
        {
            aj.a(b);
        }
    }
}
