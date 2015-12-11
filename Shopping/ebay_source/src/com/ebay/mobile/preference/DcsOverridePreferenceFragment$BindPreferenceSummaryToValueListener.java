// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import com.ebay.nautilus.domain.dcs.DcsProperty;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment, DcsValuesFragment

private static abstract class dc
    implements android.preference.istener, dc
{

    protected final DeviceConfiguration dc;
    protected final Map valueMap = new HashMap();

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = obj.toString();
        if (preference instanceof ListPreference)
        {
            ListPreference listpreference = (ListPreference)preference;
            int i = listpreference.findIndexOfValue(((String) (obj)));
            if (i >= 0)
            {
                obj = listpreference.getEntries()[i];
            } else
            {
                obj = null;
            }
            preference.setSummary(((CharSequence) (obj)));
        } else
        {
            preference.setSummary(((CharSequence) (obj)));
        }
        return true;
    }

    public boolean onPreferenceLongClick(PreferenceActivity preferenceactivity, Preference preference)
    {
        Object obj = (DcsProperty)valueMap.get(preference.getKey());
        preference = preference.getTitle();
        obj = DcsValuesFragment.createExtras(((DcsProperty) (obj)));
        preferenceactivity.startPreferencePanel(com/ebay/mobile/preference/DcsValuesFragment.getName(), ((android.os.Bundle) (obj)), 0, preference, null, 0);
        return true;
    }

    protected (DeviceConfiguration deviceconfiguration)
    {
        dc = deviceconfiguration;
    }
}
