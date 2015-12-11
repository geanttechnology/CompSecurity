// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.network.managers.RecommendationManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.x;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.a.z;
import com.smule.pianoandroid.magicpiano.b.n;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.magicpiano.suggestions.c;
import com.smule.pianoandroid.utils.q;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameRewardsActivity, an, ao

class a
    implements Runnable
{

    final GameRewardsActivity a;

    public void run()
    {
        aa.c(com.smule.pianoandroid.magicpiano.GameRewardsActivity.c(), (new StringBuilder()).append("Claiming reward song: ").append(a.i).toString());
        com.smule.pianoandroid.magicpiano.c.a.a().a(a.i);
        com.smule.pianoandroid.magicpiano.c.a.a().b(false);
        com.smule.pianoandroid.magicpiano.c.a.a().a = true;
        q.j(a.i);
        Object obj = ak.a().a(a.i);
        obj = String.format(a.getResources().getString(0x7f0c005a), new Object[] {
            ((SongV2) (obj)).title
        });
        a.f = new an(a, ((String) (obj)));
        a.f.setCancelable(false);
        a.f.a(new ao() {

            final GameRewardsActivity._cls5 a;

            public void c_()
            {
                com.smule.pianoandroid.magicpiano.c.a.a().a = false;
            }

            
            {
                a = GameRewardsActivity._cls5.this;
                super();
            }
        });
        a.f.show();
        (new n(a.i, a)).execute(new Void[0]);
        RecommendationManager.a().a(a.i, new ._cls2());
        a.e.dismiss();
        a.e = null;
    }

    _cls1.a(GameRewardsActivity gamerewardsactivity)
    {
        a = gamerewardsactivity;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GameRewardsActivity$13$2

/* anonymous class */
    class GameRewardsActivity._cls13._cls2
        implements com.smule.android.network.managers.RecommendationManager.RecommedationSelectCallback
    {

        final GameRewardsActivity._cls5 a;

        public void handleResponse(x x1)
        {
            p.a(z.a().b().edit().putBoolean("ONBOARDING_REPORTED", x1.a()));
            c.a().a(true);
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((x)obj);
        }

            
            {
                a = GameRewardsActivity._cls5.this;
                super();
            }
    }

}
