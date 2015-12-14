// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.app.Activity;
import android.content.Intent;
import android.preference.Preference;
import com.amazon.gallery.thor.app.activity.LegalInformationSettingsActivity;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SettingsFragment

class this._cls0
    implements android.preference.enceClickListener
{

    final SettingsFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        preference = new Intent(getActivity(), com/amazon/gallery/thor/app/activity/LegalInformationSettingsActivity);
        getActivity().startActivity(preference);
        return true;
    }

    ivity()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
