// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.content.DialogInterface;
import android.widget.RelativeLayout;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MyFbLoginButton;
import com.mixerbox.mixerbox3b.fragments.SignUpFragment;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            OnboardingLoginDialog

class this._cls0
    implements android.content.istener
{

    final OnboardingLoginDialog this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (((MainPage)OnboardingLoginDialog.access$000(OnboardingLoginDialog.this)).rlVideoPlayer.getVisibility() == 0)
        {
            ((MainPage)OnboardingLoginDialog.access$000(OnboardingLoginDialog.this)).shouldSendNoti = false;
            ((MainPage)OnboardingLoginDialog.access$000(OnboardingLoginDialog.this)).closePlayer();
        }
        ((MainPage)OnboardingLoginDialog.access$000(OnboardingLoginDialog.this)).fragmentSignUp.checkLoginType = 0;
        ((MainPage)OnboardingLoginDialog.access$000(OnboardingLoginDialog.this)).fragmentSignUp.loginButton.performClick();
    }

    ()
    {
        this$0 = OnboardingLoginDialog.this;
        super();
    }
}
