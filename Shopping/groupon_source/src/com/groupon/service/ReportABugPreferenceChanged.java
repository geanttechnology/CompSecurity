// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.SharedPreferences;
import java.io.Serializable;

// Referenced classes of package com.groupon.service:
//            ConfigurationChangedProvider

public class ReportABugPreferenceChanged
    implements ConfigurationChangedProvider
{

    private SharedPreferences prefs;

    public ReportABugPreferenceChanged()
    {
    }

    public Serializable getConfigurationState()
    {
        return Boolean.toString(prefs.getBoolean("pref_key_report_a_bug", false));
    }
}
