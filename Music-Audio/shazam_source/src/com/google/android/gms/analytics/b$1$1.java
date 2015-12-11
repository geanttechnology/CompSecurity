// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.ai;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.common.internal.f;

// Referenced classes of package com.google.android.gms.analytics:
//            b

final class a
    implements Runnable
{

    final al.g.b a;

    public final void run()
    {
label0:
        {
            if (a.a.stopSelfResult(a.a))
            {
                if (!f.a)
                {
                    break label0;
                }
                a.a.b("Device AnalyticsService processed last dispatch request");
            }
            return;
        }
        a.a.b("Local AnalyticsService processed last dispatch request");
    }

    al.g(al.g g1)
    {
        a = g1;
        super();
    }

    // Unreferenced inner class com/google/android/gms/analytics/b$1

/* anonymous class */
    final class b._cls1
        implements ai
    {

        final int a;
        final r b;
        final g c;
        final b d;

        public final void a()
        {
            com.google.android.gms.analytics.b.a(d).post(new b._cls1._cls1(this));
        }

            
            {
                d = b1;
                a = i;
                b = r;
                c = g1;
                super();
            }
    }

}
