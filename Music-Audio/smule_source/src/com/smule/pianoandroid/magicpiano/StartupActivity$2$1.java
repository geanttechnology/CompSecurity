// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            StartupActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
label0:
        {
            if (!StartupActivity.b(a.a))
            {
                if (!StartupActivity.c(a.a))
                {
                    break label0;
                }
                StartupActivity.d(a.a);
            }
            return;
        }
        StartupActivity.a(a.a, true);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/StartupActivity$2

/* anonymous class */
    class StartupActivity._cls2 extends TimerTask
    {

        final StartupActivity a;

        public void run()
        {
            a.runOnUiThread(new StartupActivity._cls2._cls1(this));
        }

            
            {
                a = startupactivity;
                super();
            }
    }

}
