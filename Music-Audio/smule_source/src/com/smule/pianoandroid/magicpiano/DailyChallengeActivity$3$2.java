// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.Toast;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            DailyChallengeActivity, h

class a
    implements Runnable
{

    final tring a;

    public void run()
    {
        Toast.makeText(a.a, a.a.getString(0x7f0c027b), 1).show();
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/DailyChallengeActivity$3

/* anonymous class */
    class DailyChallengeActivity._cls3
        implements Observer
    {

        final DailyChallengeActivity a;

        public void update(Observable observable, Object obj)
        {
            observable = (com.smule.android.network.models.ContestData.SubmitState)obj;
            if (observable != com.smule.android.network.models.ContestData.SubmitState.SUBMIT_ERROR) goto _L2; else goto _L1
_L1:
            a.runOnUiThread(new DailyChallengeActivity._cls3._cls1());
_L4:
            (new h(a, null)).execute(new Void[] {
                null, null, null
            });
            return;
_L2:
            if (observable == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_EXPIRED)
            {
                a.runOnUiThread(new DailyChallengeActivity._cls3._cls2(this));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                a = dailychallengeactivity;
                super();
            }

        // Unreferenced inner class com/smule/pianoandroid/magicpiano/DailyChallengeActivity$3$1

/* anonymous class */
        class DailyChallengeActivity._cls3._cls1
            implements Runnable
        {

            final DailyChallengeActivity._cls3 a;

            public void run()
            {
                Toast.makeText(a.a, a.a.getString(0x7f0c027a), 1).show();
            }

                    
                    {
                        a = DailyChallengeActivity._cls3.this;
                        super();
                    }
        }

    }

}
