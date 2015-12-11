// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.DialogInterface;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            OnboardingLoginDialog

class this._cls0
    implements android.content.istener
{

    final OnboardingLoginDialog this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MixerBoxSharedPreferences.putOnboardingFinish(OnboardingLoginDialog.access$000(OnboardingLoginDialog.this), true);
        ((MainPage)OnboardingLoginDialog.access$000(OnboardingLoginDialog.this)).onboardingPlayMusic();
    }

    ()
    {
        this$0 = OnboardingLoginDialog.this;
        super();
    }
}
