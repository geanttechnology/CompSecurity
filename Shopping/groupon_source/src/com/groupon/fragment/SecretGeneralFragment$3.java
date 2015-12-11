// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.view.View;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretGeneralFragment

class this._cls0 extends EditTextPreference
{

    final SecretGeneralFragment this$0;

    protected void onBindView(View view)
    {
        if (findPreferenceInHierarchy("clearSmuggledDeals") != null)
        {
            setDependency("clearSmuggledDeals");
        }
        super.onBindView(view);
    }

    public void onDependencyChanged(Preference preference, boolean flag)
    {
        super.onDependencyChanged(preference, flag);
        preference = ((SharedPreferences)prefs.get()).getString("smuggledDeals", null);
        setText(preference);
        callChangeListener(preference);
    }

    (Context context)
    {
        this$0 = SecretGeneralFragment.this;
        super(context);
    }
}
