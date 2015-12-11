// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.pianoandroid.data.model.GameReward;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            k, GameRewardsActivity

class a
    implements android.view..OnClickListener
{

    final GameReward a;
    final k b;

    public void onClick(View view)
    {
        if (a != null && a.value != null && k.a(b).size() > 1)
        {
            b.a.i = a.value;
        } else
        {
            b.a.i = "";
        }
        GameRewardsActivity.b(b.a, b.a.i);
    }

    Reward(k k1, GameReward gamereward)
    {
        b = k1;
        a = gamereward;
        super();
    }
}
