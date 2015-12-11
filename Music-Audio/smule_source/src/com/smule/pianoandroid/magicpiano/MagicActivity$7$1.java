// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.ProgressBar;
import com.smule.magicpiano.PianoCoreBridge;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        MagicActivity.f(a.a).setProgress(0);
        MagicActivity.f(a.a).setVisibility(0);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/MagicActivity$7

/* anonymous class */
    class MagicActivity._cls7 extends TimerTask
    {

        final MagicActivity a;

        public void run()
        {
            a.runOnUiThread(new MagicActivity._cls7._cls1(this));
            MagicActivity.r(a);
            MagicActivity.a(a, new MagicActivity._cls7._cls2());
            (new Timer()).schedule(MagicActivity.v(a), 3300L);
        }

            
            {
                a = magicactivity;
                super();
            }

        // Unreferenced inner class com/smule/pianoandroid/magicpiano/MagicActivity$7$2

/* anonymous class */
        class MagicActivity._cls7._cls2 extends TimerTask
        {

            final MagicActivity._cls7 a;

            public void run()
            {
                PianoCoreBridge.setDifficulty(MagicActivity.s(a.a));
                MagicActivity.t(a.a);
                PianoCoreBridge.startPerformanceFromFile(MagicActivity.u(a.a), false);
                a.a.e();
            }

                    
                    {
                        a = MagicActivity._cls7.this;
                        super();
                    }
        }

    }

}
