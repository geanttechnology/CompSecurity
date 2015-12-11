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

final class c
    implements ai
{

    final int a;
    final r b;
    final g c;
    final b d;

    public final void a()
    {
        com.google.android.gms.analytics.b.a(d).post(new Runnable() {

            final b._cls1 a;

            public final void run()
            {
label0:
                {
                    if (a.d.stopSelfResult(a.a))
                    {
                        if (!f.a)
                        {
                            break label0;
                        }
                        a.c.b("Device AnalyticsService processed last dispatch request");
                    }
                    return;
                }
                a.c.b("Local AnalyticsService processed last dispatch request");
            }

            
            {
                a = b._cls1.this;
                super();
            }
        });
    }

    rnal.g(b b1, int i, r r, g g)
    {
        d = b1;
        a = i;
        b = r;
        c = g;
        super();
    }
}
