// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.groupon.service.core.AbTestService;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretAbTestFragment

private class pref
    implements android.preference.r
{

    private final EditTextPreference pref;
    final SecretAbTestFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = (String)obj;
        String as[] = ((String) (obj)).split("=");
        if (Strings.notEmpty(as[0]) && as.length == 2 && !Strings.equals("experiment_id", as[0]))
        {
            ((AbTestService)SecretAbTestFragment.access$300(SecretAbTestFragment.this).get()).setOverride(as[0], as[1]);
            if (Strings.notEmpty(as[1]))
            {
                pref.setText(((String) (obj)));
                pref.setSummary(((CharSequence) (obj)));
            } else
            {
                pref.setText("experiment_id=variant");
                pref.setSummary("Click to add a experiment_id=variant pair");
            }
            SecretAbTestFragment.access$400(SecretAbTestFragment.this);
            return false;
        }
        if (Strings.notEmpty(as[0]) && as.length == 1 && Strings.equals(preference.getTitle(), as[0]))
        {
            ((AbTestService)SecretAbTestFragment.access$300(SecretAbTestFragment.this).get()).removeOverride(as[0]);
            getPreferenceScreen().removePreference(preference);
            SecretAbTestFragment.access$400(SecretAbTestFragment.this);
            return false;
        } else
        {
            Toast.makeText(getActivity(), "A/B Test Overrides must be specified as experiment_id=variant", 1).show();
            return false;
        }
    }

    public (EditTextPreference edittextpreference)
    {
        this$0 = SecretAbTestFragment.this;
        super();
        pref = edittextpreference;
    }
}
