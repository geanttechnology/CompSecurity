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
    implements Observer
{

    final DebugConsoleActivity a;

    public void update(Observable observable, Object obj)
    {
        if (obj != null)
        {
            observable = (Runnable)obj;
            a.runOnUiThread(new Runnable(observable) {

                final Runnable a;
                final DebugConsoleActivity._cls1 b;

                public void run()
                {
                    (new Handler()).postDelayed(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            a.a.run();
                        }

            
            {
                a = _pcls1;
                super();
            }
                    }, 1000L);
                }

            
            {
                b = DebugConsoleActivity._cls1.this;
                a = runnable;
                super();
            }
            });
        }
        a.finish();
    }

    _cls1.a(DebugConsoleActivity debugconsoleactivity)
    {
        a = debugconsoleactivity;
        super();
    }
}
