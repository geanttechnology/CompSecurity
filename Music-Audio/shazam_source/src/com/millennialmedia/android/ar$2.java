// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import com.nuance.nmdp.speechkit.Recognizer;

// Referenced classes of package com.millennialmedia.android:
//            ar, al

final class a
    implements Runnable
{

    final ar a;

    public final void run()
    {
        if (ar.a(a) != null)
        {
            double d = Math.min(9.9900000000000002D, Math.max(Math.floor((double)ar.a(a).getAudioLevel() - 40D) / 4.0040040040040044D, 0.0D));
            al.b();
            a a1 = ar.b(a);
            double d1 = a1.b;
            double d2 = a1.a;
            a1.a = d;
            a1.c = a1.c + 1;
            a1.b = (d1 * (double)(a1.c - 1) + d) / (double)a1.c;
            boolean flag;
            if (!a1.d && a1.a != d2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && ar.c(a) != null)
            {
                ar.c(a).a(d);
            }
            if (ar.d(a) == c || ar.b(a).d)
            {
                ar.f(a).postDelayed(ar.e(a), 50L);
            }
        }
    }

    zer(ar ar1)
    {
        a = ar1;
        super();
    }
}
