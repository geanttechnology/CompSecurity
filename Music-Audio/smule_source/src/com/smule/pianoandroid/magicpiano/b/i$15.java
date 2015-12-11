// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.network.managers.ak;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            i

final class _cls1.a extends k
{

    static k a(_cls1.a a1)
    {
        return a1.h;
    }

    public void a(j j)
    {
        ak.a().a(new Runnable(j) {

            final j a;
            final i._cls15 b;

            public void run()
            {
                if (ak.a().e().size() <= 0)
                {
                    ak.a().c();
                }
                a.b(i._cls15.a(b));
            }

            
            {
                b = i._cls15.this;
                a = j1;
                super();
            }
        });
    }

    _cls1.a()
    {
    }
}
