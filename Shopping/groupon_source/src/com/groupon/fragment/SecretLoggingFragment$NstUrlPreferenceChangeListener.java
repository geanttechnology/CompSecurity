// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.ListPreference;
import android.preference.Preference;
import com.groupon.tracking.mobile.internal.LogClient;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretLoggingFragment

private class nstUrl
    implements android.preference.r
{

    private final ListPreference nstUrl;
    final SecretLoggingFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        ((LogClient)SecretLoggingFragment.access$500(SecretLoggingFragment.this).get()).setNstUrl(String.format(Strings.toString(obj), new Object[] {
            clientId
        }));
        nstUrl.setSummary(((LogClient)SecretLoggingFragment.access$500(SecretLoggingFragment.this).get()).getNstUrl());
        return true;
    }

    public (ListPreference listpreference)
    {
        this$0 = SecretLoggingFragment.this;
        super();
        nstUrl = listpreference;
    }
}
