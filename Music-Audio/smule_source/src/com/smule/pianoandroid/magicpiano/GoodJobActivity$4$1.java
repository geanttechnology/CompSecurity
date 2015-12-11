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

    final sh a;

    public void run()
    {
        a.a.setResult(1);
        a.a.finish();
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GoodJobActivity$4

/* anonymous class */
    class GoodJobActivity._cls4
        implements Runnable
    {

        final GoodJobActivity a;

        public void run()
        {
            Runnable runnable = new GoodJobActivity._cls4._cls2(new GoodJobActivity._cls4._cls1(this));
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

            
            {
                a = goodjobactivity;
                super();
            }

        // Unreferenced inner class com/smule/pianoandroid/magicpiano/GoodJobActivity$4$2

/* anonymous class */
        class GoodJobActivity._cls4._cls2
            implements Runnable
        {

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
        }

    }

}
