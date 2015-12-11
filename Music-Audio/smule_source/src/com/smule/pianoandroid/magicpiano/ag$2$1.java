// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag

class a
    implements Runnable
{

    final a a;

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

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ag$2

/* anonymous class */
    class ag._cls2
        implements Observer
    {

        final ag a;

        public void update(Observable observable, Object obj)
        {
            a.runOnUiThread(new ag._cls2._cls1(this));
        }

            
            {
                a = ag1;
                super();
            }
    }

}
