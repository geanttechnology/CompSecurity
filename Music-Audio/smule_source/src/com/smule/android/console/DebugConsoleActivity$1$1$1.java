// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.os.Handler;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.console:
//            DebugConsoleActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.run();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/android/console/DebugConsoleActivity$1

/* anonymous class */
    class DebugConsoleActivity._cls1
        implements Observer
    {

        final DebugConsoleActivity a;

        public void update(Observable observable, Object obj)
        {
            if (obj != null)
            {
                observable = (Runnable)obj;
                a.runOnUiThread(new DebugConsoleActivity._cls1._cls1(this, observable));
            }
            a.finish();
        }

            
            {
                a = debugconsoleactivity;
                super();
            }
    }


    // Unreferenced inner class com/smule/android/console/DebugConsoleActivity$1$1

/* anonymous class */
    class DebugConsoleActivity._cls1._cls1
        implements Runnable
    {

        final Runnable a;
        final DebugConsoleActivity._cls1 b;

        public void run()
        {
            (new Handler()).postDelayed(new DebugConsoleActivity._cls1._cls1._cls1(this), 1000L);
        }

            
            {
                b = _pcls1;
                a = runnable;
                super();
            }
    }

}
