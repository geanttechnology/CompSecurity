// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.for;

import io.presage.try.a;
import io.presage.try.d;

// Referenced classes of package io.presage.for:
//            b

final class c
    implements Runnable
{

    final a a;
    final b b;

    c(b b1, a a1)
    {
        b = b1;
        a = a1;
        super();
    }

    public final void run()
    {
        ((d)a).reload();
    }
}
