// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ab

class a
    implements Observer
{

    final ab a;

    public void update(Observable observable, Object obj)
    {
        ab.a(a).runOnUiThread(new Runnable() {

            final ab._cls1 a;

            public void run()
            {
                a.a.f();
                a.a.b();
            }

            
            {
                a = ab._cls1.this;
                super();
            }
        });
    }

    _cls1.a(ab ab1)
    {
        a = ab1;
        super();
    }
}
