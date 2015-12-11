// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.Dialog;
import android.widget.CompoundButton;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class this._cls0
    implements android.widget.eckedChangeListener
{

    final SettingsFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            if (shouldOpenConfirmDialog)
            {
                AlertDialogFactory.AskPostAlertDialog(getActivity()).show();
                return;
            } else
            {
                shouldOpenConfirmDialog = true;
                return;
            }
        } else
        {
            shouldOpenConfirmDialog = true;
            compoundbutton = new HashMap();
            compoundbutton.put("on", "0");
            FlurryAgent.logEvent("action:set_publish_activity", compoundbutton);
            MixerBoxSharedPreferences.putPostFB(getActivity(), false);
            MixerBoxSharedPreferences.putPlaySongCount(getActivity(), 1);
            return;
        }
    }

    es()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
