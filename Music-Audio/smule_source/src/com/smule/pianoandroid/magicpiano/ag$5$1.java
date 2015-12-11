// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.Handler;
import com.smule.android.network.core.b;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        b.e().post(new Runnable() {

            final ag._cls5._cls1 a;

            public void run()
            {
                o.a(a.a.b, false, a.a.a);
            }

            
            {
                a = ag._cls5._cls1.this;
                super();
            }
        });
    }

    _cls1.a(_cls1.a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ag$5

/* anonymous class */
    class ag._cls5
        implements Runnable
    {

        final Runnable a;
        final ag b;

        public void run()
        {
            o.a(b, a, new ag._cls5._cls1(this));
        }

            
            {
                b = ag1;
                a = runnable;
                super();
            }
    }

}
