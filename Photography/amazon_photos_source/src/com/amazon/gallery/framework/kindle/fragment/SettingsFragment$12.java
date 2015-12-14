// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceGroup;
import com.amazon.gallery.thor.app.ui.ImageRewindSettingsHelper;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SettingsFragment

class val.helper extends BroadcastReceiver
{

    final SettingsFragment this$0;
    final ImageRewindSettingsHelper val$helper;
    final PreferenceGroup val$rewindCleanupButton;

    public void onReceive(Context context, Intent intent)
    {
        if (val$rewindCleanupButton != null)
        {
            val$helper.initializePreferenceView(val$rewindCleanupButton);
        }
    }

    ()
    {
        this$0 = final_settingsfragment;
        val$rewindCleanupButton = preferencegroup;
        val$helper = ImageRewindSettingsHelper.this;
        super();
    }
}
