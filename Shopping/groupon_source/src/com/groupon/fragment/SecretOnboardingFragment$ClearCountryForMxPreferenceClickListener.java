// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.service.operations.ClearCountryForMxUsers;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.fragment:
//            SecretOnboardingFragment

private class <init>
    implements android.preference.r
{

    final SecretOnboardingFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        preference = new ClearCountryForMxUsers();
        RoboGuice.getInjector(getActivity()).injectMembers(preference);
        preference.run();
        return true;
    }

    private ()
    {
        this$0 = SecretOnboardingFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
