// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.network.managers.e;
import com.smule.pianoandroid.utils.q;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            DailyChallengeActivity

class a
    implements Observer
{

    final DailyChallengeActivity a;

    public void update(Observable observable, Object obj)
    {
        if ((com.smule.android.network.models.)obj == com.smule.android.network.models.UBMIT_SUCCESS)
        {
            q.d(e.a().f().ontest.d);
        }
    }

    (DailyChallengeActivity dailychallengeactivity)
    {
        a = dailychallengeactivity;
        super();
    }
}
