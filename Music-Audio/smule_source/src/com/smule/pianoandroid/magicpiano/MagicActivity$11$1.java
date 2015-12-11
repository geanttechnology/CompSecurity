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

class a extends TimerTask
{

    final h a;

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

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/MagicActivity$11

/* anonymous class */
    class MagicActivity._cls11
        implements android.view.View.OnClickListener
    {

        final MagicActivity a;

        public void onClick(View view)
        {
            PianoCoreBridge.sPerforming = false;
            (new Timer()).schedule(new MagicActivity._cls11._cls1(this), 1000L);
        }

            
            {
                a = magicactivity;
                super();
            }
    }

}
