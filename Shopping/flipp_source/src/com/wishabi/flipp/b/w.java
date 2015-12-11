// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;


// Referenced classes of package com.wishabi.flipp.b:
//            x, u

final class w
    implements Runnable
{

    final x a;
    final u b;

    w(u u, x x1)
    {
        b = u;
        a = x1;
        super();
    }

    public final void run()
    {
        a.a();
    }
}
