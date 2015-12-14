// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.preference.Preference;
import com.amazon.gallery.foundation.metrics.customer.CustomerMetricsInfo;
import com.amazon.gallery.framework.kindle.util.ReportIssueUtility;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SettingsFragment

class fo
    implements android.preference.enceClickListener
{

    final SettingsFragment this$0;
    final CustomerMetricsInfo val$info;

    public boolean onPreferenceClick(Preference preference)
    {
        (new ReportIssueUtility()).sendEmail(getActivity(), val$info.getAppVersionName());
        return true;
    }

    fo()
    {
        this$0 = final_settingsfragment;
        val$info = CustomerMetricsInfo.this;
        super();
    }
}
