// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.s;
import java.util.ArrayList;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity, an

class a
    implements com.smule.android.network.managers.seCallback
{

    final GlobeActivity a;

    public void handleResponse(s s1)
    {
        if (a.isFinishing())
        {
            return;
        }
        if (s1 == null || !s1.a.a())
        {
            a.runOnUiThread(new Runnable(s1) {

                final s a;
                final GlobeActivity.TopPerformanceCallback b;

                public void run()
                {
                    b.a.a(false);
                    if (a != null)
                    {
                        com.smule.android.network.core.b.a(a.a);
                    }
                    GlobeActivity.v(b.a).a(2, b.a.getResources().getString(0x7f0c0045), true);
                    GlobeActivity.a(b.a, 4);
                }

            
            {
                b = GlobeActivity.TopPerformanceCallback.this;
                a = s1;
                super();
            }
            });
            return;
        }
        aa.c(GlobeActivity.a, (new StringBuilder()).append("Downloaded ").append(s1.mPerformances.size()).append(" performances.").toString());
        GlobeActivity.x(a).addAll(s1.mPerformances);
        if (!s1.mPerformances.isEmpty())
        {
            GlobeActivity.a(a, Integer.valueOf(GlobeActivity.y(a)));
            return;
        } else
        {
            a.runOnUiThread(new Runnable() {

                final GlobeActivity.TopPerformanceCallback a;

                public void run()
                {
                    a.a.a(false);
                    GlobeActivity.a(a.a, 4);
                }

            
            {
                a = GlobeActivity.TopPerformanceCallback.this;
                super();
            }
            });
            return;
        }
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((s)obj);
    }

    public _cls2.a(GlobeActivity globeactivity)
    {
        a = globeactivity;
        super();
    }
}
