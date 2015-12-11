// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.view.View;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameRewardsActivity, ar

class a
    implements android.view.ameRewardsActivity._cls7
{

    final GameRewardsActivity a;

    public void onClick(View view)
    {
        GameRewardsActivity.b(a);
        if (a.m == null && a.k >= 3)
        {
            view = new Runnable() {

                final GameRewardsActivity._cls7 a;

                public void run()
                {
                    ar.a(true);
                    a.a.finish();
                }

            
            {
                a = GameRewardsActivity._cls7.this;
                super();
            }
            };
            o.a(a, view, view, a.getResources().getString(0x7f0c0216), a.getResources().getString(0x7f0c0215));
            return;
        } else
        {
            a.finish();
            return;
        }
    }

    _cls1.a(GameRewardsActivity gamerewardsactivity)
    {
        a = gamerewardsactivity;
        super();
    }
}
