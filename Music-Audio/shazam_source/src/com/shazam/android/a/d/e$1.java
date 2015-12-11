// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.d;


// Referenced classes of package com.shazam.android.a.d:
//            e

final class a
    implements Runnable
{

    final int a;
    final e b;

    public final void run()
    {
        if (a >= 0 && a < b.j)
        {
            b.g(a);
            b.f(a);
        }
    }

    (e e1, int i)
    {
        b = e1;
        a = i;
        super();
    }
}
