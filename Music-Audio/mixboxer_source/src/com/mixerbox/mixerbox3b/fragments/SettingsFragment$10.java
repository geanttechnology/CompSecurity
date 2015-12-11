// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.Dialog;
import android.view.View;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MyFbLoginButton;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment, SignUpFragment

class this._cls0
    implements android.view.
{

    final SettingsFragment this$0;

    public void onClick(View view)
    {
        if (!MixerBoxClient.isConnectingToInternet(getActivity()))
        {
            AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
            return;
        }
        if (((MainPage)getActivity()).rlVideoPlayer.getVisibility() == 0)
        {
            ((MainPage)getActivity()).shouldSendNoti = false;
            ((MainPage)getActivity()).closePlayer();
        }
        FlurryAgent.logEvent("action:setting_page_login");
        ((MainPage)getActivity()).fragmentSignUp.checkLoginType = 0;
        ((MainPage)getActivity()).fragmentSignUp.loginButton.performClick();
    }

    ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
