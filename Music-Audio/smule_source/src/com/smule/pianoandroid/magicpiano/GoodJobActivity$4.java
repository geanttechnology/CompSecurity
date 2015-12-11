// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import com.smule.pianoandroid.ads.j;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity

class a
    implements Runnable
{

    final GoodJobActivity a;

    public void run()
    {
        Runnable runnable = new Runnable(new Runnable() {

            final GoodJobActivity._cls4 a;

            public void run()
            {
                a.a.setResult(1);
                a.a.finish();
            }

            
            {
                a = GoodJobActivity._cls4.this;
                super();
            }
        }) {

            final Runnable a;
            final GoodJobActivity._cls4 b;

            public void run()
            {
                GoodJobActivity.b(b.a, true);
                if (!GoodJobActivity.g(b.a).a(b.a, 0x7f0a00b5))
                {
                    a.run();
                }
            }

            
            {
                b = GoodJobActivity._cls4.this;
                a = runnable;
                super();
            }
        };
        if (GoodJobActivity.h(a))
        {
            o.a(a, runnable, runnable, a.getResources().getString(0x7f0c020e), a.getResources().getString(0x7f0c020d));
            return;
        } else
        {
            runnable.run();
            return;
        }
    }

    _cls2.a(GoodJobActivity goodjobactivity)
    {
        a = goodjobactivity;
        super();
    }
}
