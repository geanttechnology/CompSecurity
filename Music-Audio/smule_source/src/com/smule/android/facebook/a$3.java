// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.facebook;

import android.os.Handler;

// Referenced classes of package com.smule.android.facebook:
//            a, d, c

class b
    implements Runnable
{

    final d a;
    final Handler b;
    final a c;

    public void run()
    {
        c c1 = c.a(null, true);
        if (a != null)
        {
            b.post(new Runnable(c1) {

                final c a;
                final a._cls3 b;

                public void run()
                {
                    b.a.a(a);
                }

            
            {
                b = a._cls3.this;
                a = c1;
                super();
            }
            });
        }
    }

    _cls1.a(a a1, d d, Handler handler)
    {
        c = a1;
        a = d;
        b = handler;
        super();
    }
}
