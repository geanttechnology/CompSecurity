// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.Session;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class this._cls0
    implements android.view.r
{

    final SettingsFragment this$0;

    public void onClick(View view)
    {
        if (((MainPage)getActivity()).rlVideoPlayer.getVisibility() == 0)
        {
            ((MainPage)getActivity()).shouldSendNoti = false;
            ((MainPage)getActivity()).closePlayer();
        }
        FlurryAgent.logEvent("action:logout");
        MixerBoxSharedPreferences.clearSharedPreferences(getActivity());
        view = Session.getActiveSession();
        if (!view.isClosed())
        {
            view.closeAndClearTokenInformation();
        }
        MixerBoxClient.reset();
        MixerBoxUtils.toastMsg(getActivity(), getResources().getString(0x7f080074), 1);
        updateSysinfo();
    }

    es()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
