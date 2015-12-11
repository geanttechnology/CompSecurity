// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.for;

import io.presage.try.a;
import io.presage.try.d;

// Referenced classes of package io.presage.for:
//            b

final class h
    implements Runnable
{

    final a a;
    final String b;
    final String c;
    final b d;

    h(b b1, a a1, String s, String s1)
    {
        d = b1;
        a = a1;
        b = s;
        c = s1;
        super();
    }

    public final void run()
    {
        ((d)a).a(b, c);
    }
}
