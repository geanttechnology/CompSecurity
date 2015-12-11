// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.network.managers.ap;
import com.smule.magicpiano.PianoCoreBridge;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements android.view.ner
{

    final MagicActivity a;

    public void onClick(View view)
    {
        PianoCoreBridge.sPerforming = false;
        (new Timer()).schedule(new TimerTask() {

            final MagicActivity._cls11 a;

            public void run()
            {
                if (MagicActivity.b(a.a) || ap.a().b())
                {
                    a.a.i();
                    return;
                } else
                {
                    a.a.setResult(1);
                    a.a.finish();
                    return;
                }
            }

            
            {
                a = MagicActivity._cls11.this;
                super();
            }
        }, 1000L);
    }

    _cls1.a(MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }
}
