// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.c.aa;
import com.smule.android.f.h;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            DailyChallengeActivity, h

class a
    implements Observer
{

    final DailyChallengeActivity a;

    public void update(Observable observable, Object obj)
    {
        aa.a(DailyChallengeActivity.b(), "LoadContestTask called from DailyChallenges.init");
        (new com.smule.pianoandroid.magicpiano.h(a, null)).execute(new Void[] {
            null, null, null
        });
        h.a().b("DAILY_CHALLENGES_INIT", com.smule.pianoandroid.magicpiano.DailyChallengeActivity.h(a));
    }

    (DailyChallengeActivity dailychallengeactivity)
    {
        a = dailychallengeactivity;
        super();
    }
}
