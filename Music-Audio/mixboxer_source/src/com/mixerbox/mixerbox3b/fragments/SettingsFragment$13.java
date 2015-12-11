// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.Dialog;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

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
        } else
        {
            FlurryAgent.logEvent("action:invite_friends");
            ((MainPage)getActivity()).sendRequestDialog();
            return;
        }
    }

    ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
