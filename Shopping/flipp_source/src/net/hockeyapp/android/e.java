// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import java.lang.ref.WeakReference;

// Referenced classes of package net.hockeyapp.android:
//            b, g

final class e extends Thread
{

    final WeakReference a;
    final g b;
    final boolean c;

    e(WeakReference weakreference, g g, boolean flag)
    {
        a = weakreference;
        b = g;
        c = flag;
        super();
    }

    public final void run()
    {
        net.hockeyapp.android.b.a(a, b);
        net.hockeyapp.android.b.a(b, c);
    }
}
