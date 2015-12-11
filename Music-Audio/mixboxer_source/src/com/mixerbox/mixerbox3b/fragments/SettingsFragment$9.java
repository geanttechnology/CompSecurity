// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class this._cls0
    implements android.view.r
{

    final SettingsFragment this$0;

    public void onClick(View view)
    {
        if (!MixerBoxClient.isConnectingToInternet(getActivity()))
        {
            AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
            return;
        }
        FlurryAgent.logEvent("action:like_fanpage");
        try
        {
            view = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/264387593636216"));
            startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/MixerBox"));
        }
        startActivity(view);
    }

    ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
