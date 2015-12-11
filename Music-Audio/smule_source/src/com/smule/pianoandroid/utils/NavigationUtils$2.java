// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.models.PerformanceV2;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o, p

final class _cls1.a
    implements NetworkResponseCallback
{

    final Activity a;
    final com.smule.pianoandroid.utils.p b;
    final PerformanceV2 c;

    public void handleResponse(o o1)
    {
        if (o1 != null && o1.a == p.a && o1.b == 0)
        {
            a.runOnUiThread(new Runnable() {

                final NavigationUtils._cls2 a;

                public void run()
                {
                    if (a.b != null)
                    {
                        PerformanceV2 performancev2 = a.c;
                        performancev2.totalLoves = performancev2.totalLoves + 1;
                        a.b.a(Boolean.valueOf(true), a.c);
                    }
                }

            
            {
                a = NavigationUtils._cls2.this;
                super();
            }
            });
        } else
        {
            o.c();
            com.smule.android.network.core.b.a(o1);
            if (b != null)
            {
                b.a(Boolean.valueOf(false), c);
                return;
            }
        }
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((o)obj);
    }
}
