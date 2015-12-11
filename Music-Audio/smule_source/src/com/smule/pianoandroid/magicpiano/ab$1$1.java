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
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.f();
        a.a.b();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ab$1

/* anonymous class */
    class ab._cls1
        implements Observer
    {

        final ab a;

        public void update(Observable observable, Object obj)
        {
            ab.a(a).runOnUiThread(new ab._cls1._cls1(this));
        }

            
            {
                a = ab1;
                super();
            }
    }

}
