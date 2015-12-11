// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;


// Referenced classes of package com.b.a:
//            b

final class h
    implements Runnable
{

    final String a;
    final b b;

    h(b b1, String s)
    {
        b = b1;
        a = s;
        super();
    }

    public final void run()
    {
        b.a(a);
    }
}
