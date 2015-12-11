// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import com.groupon.fragment.SecretAbTestFragment;
import com.groupon.fragment.SecretApiUrlFragment;
import com.groupon.fragment.SecretGeneralFragment;
import com.groupon.fragment.SecretLoggingFragment;
import com.groupon.fragment.SecretOnboardingFragment;
import com.groupon.fragment.SecretProxyFragment;
import com.groupon.fragment.SecretSetOnceFlagsFragment;
import com.groupon.fragment.SecretWidgetsFragment;

// Referenced classes of package com.groupon.activity:
//            SecretAdminSettings

private class this._cls0 extends FragmentStatePagerAdapter
{

    final SecretAdminSettings this$0;

    public int getCount()
    {
        return 8;
    }

    public Fragment getItem(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return new SecretGeneralFragment();

        case 1: // '\001'
            return new SecretProxyFragment();

        case 2: // '\002'
            return new SecretAbTestFragment();

        case 3: // '\003'
            return new SecretLoggingFragment();

        case 4: // '\004'
            return new SecretOnboardingFragment();

        case 5: // '\005'
            return new SecretApiUrlFragment();

        case 6: // '\006'
            return new SecretWidgetsFragment();

        case 7: // '\007'
            return new SecretSetOnceFlagsFragment();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return "General";

        case 1: // '\001'
            return "Proxy";

        case 2: // '\002'
            return "A/B Tests";

        case 3: // '\003'
            return "Logging";

        case 4: // '\004'
            return "Onboarding";

        case 5: // '\005'
            return "API Url";

        case 6: // '\006'
            return "Widgets";

        case 7: // '\007'
            return "Set Once Flags";
        }
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = SecretAdminSettings.this;
        super(fragmentmanager);
    }
}
