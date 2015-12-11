// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.pianoandroid.f.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameRewardsActivity

class a
    implements android.view.meRewardsActivity._cls13
{

    final GameRewardsActivity a;

    public void onClick(View view)
    {
        if (a.m != null)
        {
            com.smule.pianoandroid.f.a.a(a).b(a, a.m, 4);
            return;
        } else
        {
            com.smule.pianoandroid.f.a.a(a).b(a, a.k, 4);
            return;
        }
    }

    (GameRewardsActivity gamerewardsactivity)
    {
        a = gamerewardsactivity;
        super();
    }
}
