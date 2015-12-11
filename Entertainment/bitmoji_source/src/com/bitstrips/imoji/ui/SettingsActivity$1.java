// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.SharedPreferences;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.util.PreferenceUtils;

// Referenced classes of package com.bitstrips.imoji.ui:
//            SettingsActivity

class this._cls0
    implements android.content.nSharedPreferenceChangeListener
{

    final SettingsActivity this$0;

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
label0:
        {
            if (getString(0x7f060083).equals(s))
            {
                if (!sharedpreferences.getBoolean(s, true))
                {
                    break label0;
                }
                if (preferenceUtils.getString(0x7f06002a, null) != null)
                {
                    floaterServiceManager.startFloaterService();
                }
            }
            return;
        }
        floaterServiceManager.stopFloaterService();
        analytics.sendEvent(Category.FLOATER, Action.DISABLE, null);
    }

    vice()
    {
        this$0 = SettingsActivity.this;
        super();
    }
}
