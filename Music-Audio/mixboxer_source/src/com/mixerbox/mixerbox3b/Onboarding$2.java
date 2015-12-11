// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.View;
import com.flurry.android.FlurryAgent;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            Onboarding

class this._cls0
    implements android.view.istener
{

    final Onboarding this$0;

    public void onClick(View view)
    {
        FlurryAgent.logEvent("action_onboarding_skip");
        goToMainPage();
    }

    ()
    {
        this$0 = Onboarding.this;
        super();
    }
}
