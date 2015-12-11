// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.os.SystemClock;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            i

final class j
    implements Runnable
{

    final i a;

    j(i k)
    {
        a = k;
        super();
    }

    public final void run()
    {
        i.a(a, 0.01F * i.a(a));
        if (i.b(a) >= 1.0F / (float)i.c(a))
        {
            i.d(a);
            i.e(a);
        }
        a.scheduleSelf(i.f(a), SystemClock.uptimeMillis() + 16L);
        a.invalidateSelf();
    }
}
