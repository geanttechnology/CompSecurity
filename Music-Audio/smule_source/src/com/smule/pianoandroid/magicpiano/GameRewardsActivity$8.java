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
    implements android.view.ameRewardsActivity._cls8
{

    final GameRewardsActivity a;

    public void onClick(View view)
    {
        if (a.m != null)
        {
            view = a.getResources().getString(0x7f0c020a);
            String s = a.getResources().getString(0x7f0c0209);
            o.a(a, new Runnable() {

                final GameRewardsActivity._cls8 a;

                public void run()
                {
                    GameRewardsActivity.c(a.a);
                }

            
            {
                a = GameRewardsActivity._cls8.this;
                super();
            }
            }, null, view, s);
        } else
        if (a.k > 0)
        {
            GameRewardsActivity.a(a, a.i);
            return;
        }
    }

    _cls1.a(GameRewardsActivity gamerewardsactivity)
    {
        a = gamerewardsactivity;
        super();
    }
}
