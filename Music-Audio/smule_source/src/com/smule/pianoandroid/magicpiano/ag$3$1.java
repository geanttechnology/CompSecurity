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

    final String a;
    final a b;

    public void run()
    {
        b.b.c(a);
    }

    ( , String s)
    {
        b = ;
        a = s;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ag$3

/* anonymous class */
    class ag._cls3
        implements Observer
    {

        final ag a;

        public void update(Observable observable, Object obj)
        {
            observable = (String)obj;
            a.runOnUiThread(new ag._cls3._cls1(this, observable));
        }

            
            {
                a = ag1;
                super();
            }
    }

}
