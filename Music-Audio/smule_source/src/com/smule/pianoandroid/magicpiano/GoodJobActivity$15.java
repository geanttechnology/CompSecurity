// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity, DailyChallengeActivity

class a
    implements android.view.r
{

    final GoodJobActivity a;

    public void onClick(View view)
    {
        view = new Intent(a, com/smule/pianoandroid/magicpiano/DailyChallengeActivity);
        a.startActivity(view);
        a.finish();
    }

    ity(GoodJobActivity goodjobactivity)
    {
        a = goodjobactivity;
        super();
    }
}
