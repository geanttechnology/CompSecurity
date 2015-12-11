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

class a extends TimerTask
{

    final MagicActivity a;

    public void run()
    {
        a.runOnUiThread(new Runnable() {

            final MagicActivity._cls7 a;

            public void run()
            {
                MagicActivity.f(a.a).setProgress(0);
                MagicActivity.f(a.a).setVisibility(0);
            }

            
            {
                a = MagicActivity._cls7.this;
                super();
            }
        });
        MagicActivity.r(a);
        MagicActivity.a(a, new TimerTask() {

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
        });
        (new Timer()).schedule(MagicActivity.v(a), 3300L);
    }

    _cls2.a(MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }
}
