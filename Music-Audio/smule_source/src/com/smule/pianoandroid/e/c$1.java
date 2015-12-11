// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.pianoandroid.a.w;

// Referenced classes of package com.smule.pianoandroid.e:
//            c

class a extends k
{

    final c a;

    static k a(a a1)
    {
        return a1.h;
    }

    public void a(j j1)
    {
        if (!c.f() && !c.g())
        {
            w.a(new Runnable(j1) {

                final j a;
                final c._cls1 b;

                public void run()
                {
                    c.a(b.a);
                    a.b(c._cls1.a(b));
                }

            
            {
                b = c._cls1.this;
                a = j1;
                super();
            }
            });
            return;
        } else
        {
            j1.b(h);
            return;
        }
    }

    _cls1.a(c c1)
    {
        a = c1;
        super();
    }
}
