// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.Preference;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretGeneralFragment

private class smuggledDeals
    implements android.preference.r
{

    private final EditTextPreference smuggledDeals;
    final SecretGeneralFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (Strings.isEmpty(obj))
        {
            smuggledDeals.setSummary("None");
            ((SharedPreferences)prefs.get()).edit().smuggledDeals("smuggledDeals").smuggledDeals();
        } else
        {
            smuggledDeals.setSummary(Strings.toString(obj));
            ((SharedPreferences)prefs.get()).edit().smuggledDeals("smuggledDeals", Strings.toString(obj)).smuggledDeals();
        }
        return true;
    }

    public (EditTextPreference edittextpreference)
    {
        this$0 = SecretGeneralFragment.this;
        super();
        smuggledDeals = edittextpreference;
    }
}
