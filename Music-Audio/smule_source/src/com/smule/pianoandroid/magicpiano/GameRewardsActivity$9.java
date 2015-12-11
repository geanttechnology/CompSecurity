// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameRewardsActivity

class a
    implements Observer
{

    final GameRewardsActivity a;

    public void update(Observable observable, Object obj)
    {
        a.runOnUiThread(new Runnable() {

            final GameRewardsActivity._cls9 a;

            public void run()
            {
                GameRewardsActivity.d(a.a);
            }

            
            {
                a = GameRewardsActivity._cls9.this;
                super();
            }
        });
    }

    _cls1.a(GameRewardsActivity gamerewardsactivity)
    {
        a = gamerewardsactivity;
        super();
    }
}
