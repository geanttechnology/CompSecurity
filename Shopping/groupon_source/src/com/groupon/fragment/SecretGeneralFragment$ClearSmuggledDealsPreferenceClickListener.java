// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.util.SmuggleDealManager;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretGeneralFragment

private class clearChannelSmuggledDeals
    implements android.preference.r
{

    private final Preference clearChannelSmuggledDeals;
    final SecretGeneralFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        ((SmuggleDealManager)SecretGeneralFragment.access$300(SecretGeneralFragment.this).get()).clearSmuggledDeals();
        clearChannelSmuggledDeals.notifyDependencyChange(false);
        return true;
    }

    public (Preference preference)
    {
        this$0 = SecretGeneralFragment.this;
        super();
        clearChannelSmuggledDeals = preference;
    }
}
