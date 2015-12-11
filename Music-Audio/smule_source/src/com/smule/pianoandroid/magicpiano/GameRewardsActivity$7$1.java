// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.view.View;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ar, GameRewardsActivity

class a
    implements Runnable
{

    final sh a;

    public void run()
    {
        ar.a(true);
        a.a.finish();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GameRewardsActivity$7

/* anonymous class */
    class GameRewardsActivity._cls7
        implements android.view.View.OnClickListener
    {

        final GameRewardsActivity a;

        public void onClick(View view)
        {
            GameRewardsActivity.b(a);
            if (a.m == null && a.k >= 3)
            {
                view = new GameRewardsActivity._cls7._cls1(this);
                o.a(a, view, view, a.getResources().getString(0x7f0c0216), a.getResources().getString(0x7f0c0215));
                return;
            } else
            {
                a.finish();
                return;
            }
        }

            
            {
                a = gamerewardsactivity;
                super();
            }
    }

}
