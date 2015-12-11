// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.f:
//            k, j, h

class nit> extends k
{

    final boolean a;
    final String b;
    final j c;

    public void a(j j1)
    {
        j1 = new Observer(j1) {

            final j a;
            final j._cls1 b;

            public void update(Observable observable, Object obj)
            {
                if (b.a)
                {
                    h.a().b(b.b, this);
                }
                a.b(b.h);
            }

            
            {
                b = j._cls1.this;
                a = j1;
                super();
            }
        };
        h.a().a(b, j1);
    }

    _cls1.a(j j1, boolean flag, String s)
    {
        c = j1;
        a = flag;
        b = s;
        super();
    }
}
