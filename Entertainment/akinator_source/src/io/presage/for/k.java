// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.for;

import io.presage.try.h;

// Referenced classes of package io.presage.for:
//            b

final class k
    implements Runnable
{

    final String a;
    final b b;

    k(b b1, String s)
    {
        b = b1;
        a = s;
        super();
    }

    public final void run()
    {
        io.presage.for.b.a(b).b(a);
    }
}
