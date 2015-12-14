// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.preference.Preference;
import com.amazon.gallery.thor.app.ui.ImageRewindSettingsHelper;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SettingsFragment

class val.helper
    implements android.preference.nceClickListener
{

    final SettingsFragment this$0;
    final ImageRewindSettingsHelper val$helper;

    public boolean onPreferenceClick(Preference preference)
    {
        val$helper.onClick();
        return true;
    }

    ()
    {
        this$0 = final_settingsfragment;
        val$helper = ImageRewindSettingsHelper.this;
        super();
    }
}
