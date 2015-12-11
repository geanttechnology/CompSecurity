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

    final Runnable a;
    final a b;

    public void run()
    {
        GoodJobActivity.b(b.b, true);
        if (!GoodJobActivity.g(b.b).a(b.b, 0x7f0a00b5))
        {
            a.run();
        }
    }

    a(a a1, Runnable runnable)
    {
        b = a1;
        a = runnable;
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
            GoodJobActivity._cls4._cls2 _lcls2 = new GoodJobActivity._cls4._cls2(this, new GoodJobActivity._cls4._cls1());
            if (GoodJobActivity.h(a))
            {
                o.a(a, _lcls2, _lcls2, a.getResources().getString(0x7f0c020e), a.getResources().getString(0x7f0c020d));
                return;
            } else
            {
                _lcls2.run();
                return;
            }
        }

            
            {
                a = goodjobactivity;
                super();
            }

        // Unreferenced inner class com/smule/pianoandroid/magicpiano/GoodJobActivity$4$1

/* anonymous class */
        class GoodJobActivity._cls4._cls1
            implements Runnable
        {

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
        }

    }

}
