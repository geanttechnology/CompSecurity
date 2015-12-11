// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameRewardsActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        GameRewardsActivity.d(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GameRewardsActivity$9

/* anonymous class */
    class GameRewardsActivity._cls9
        implements Observer
    {

        final GameRewardsActivity a;

        public void update(Observable observable, Object obj)
        {
            a.runOnUiThread(new GameRewardsActivity._cls9._cls1(this));
        }

            
            {
                a = gamerewardsactivity;
                super();
            }
    }

}
