// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.view.View;
import com.smule.pianoandroid.data.model.AchievementDefinition;
import com.smule.pianoandroid.data.model.AchievementState;
import com.smule.pianoandroid.e.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameStatsActivity, l, ac, GameRewardsActivity

class a
    implements android.view.
{

    final l a;
    final GameStatsActivity b;

    public void onClick(View view)
    {
        com.smule.pianoandroid.e.a.a().a(a.a.uid);
        a.b.display();
        com.smule.pianoandroid.magicpiano.ac.a().a("NOTIFICATION_ACHIEVEMENTS", -1);
        com.smule.pianoandroid.e.a.a().a(a.a);
        view = new Intent(b, com/smule/pianoandroid/magicpiano/GameRewardsActivity);
        view.putExtra("ACHIEVEMENT_ID", a.a.uid);
        b.startActivityForResult(view, 215);
    }

    n(GameStatsActivity gamestatsactivity, l l1)
    {
        b = gamestatsactivity;
        a = l1;
        super();
    }
}
