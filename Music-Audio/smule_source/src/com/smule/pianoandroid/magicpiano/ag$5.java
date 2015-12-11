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

    final Runnable a;
    final ag b;

    public void run()
    {
        o.a(b, a, new Runnable() {

            final ag._cls5 a;

            public void run()
            {
                com.smule.android.network.core.b.e().post(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        o.a(a.a.b, false, a.a.a);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = ag._cls5.this;
                super();
            }
        });
    }

    _cls1.a(ag ag1, Runnable runnable)
    {
        b = ag1;
        a = runnable;
        super();
    }
}
