// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.view.View;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameRewardsActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        GameRewardsActivity.c(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GameRewardsActivity$8

/* anonymous class */
    class GameRewardsActivity._cls8
        implements android.view.View.OnClickListener
    {

        final GameRewardsActivity a;

        public void onClick(View view)
        {
            if (a.m != null)
            {
                view = a.getResources().getString(0x7f0c020a);
                String s = a.getResources().getString(0x7f0c0209);
                o.a(a, new GameRewardsActivity._cls8._cls1(this), null, view, s);
            } else
            if (a.k > 0)
            {
                GameRewardsActivity.a(a, a.i);
                return;
            }
        }

            
            {
                a = gamerewardsactivity;
                super();
            }
    }

}
