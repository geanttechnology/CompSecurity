// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag

class a
    implements Observer
{

    final ag a;

    public void update(Observable observable, Object obj)
    {
        a.runOnUiThread(new Runnable() {

            final ag._cls2 a;

            public void run()
            {
                if (!ag.l())
                {
                    ag.c(true);
                    return;
                } else
                {
                    ag.b(a.a);
                    return;
                }
            }

            
            {
                a = ag._cls2.this;
                super();
            }
        });
    }

    _cls1.a(ag ag1)
    {
        a = ag1;
        super();
    }
}
