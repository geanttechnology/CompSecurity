// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.widget.CompoundButton;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
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
        if (MixerBoxSharedPreferences.getHighQuality(getActivity()) && flag)
        {
            return;
        }
        ((MainPage)getActivity()).changeQuality(flag);
        ((MainPage)getActivity()).changeQuality(flag);
        if (flag)
        {
            compoundbutton = new HashMap();
            compoundbutton.put("from", "setting");
            compoundbutton.put("hd", "1");
            FlurryAgent.logEvent("action:set_hd", compoundbutton);
            return;
        } else
        {
            compoundbutton = new HashMap();
            compoundbutton.put("from", "setting");
            compoundbutton.put("hd", "0");
            FlurryAgent.logEvent("action:set_hd", compoundbutton);
            return;
        }
    }

    es()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
