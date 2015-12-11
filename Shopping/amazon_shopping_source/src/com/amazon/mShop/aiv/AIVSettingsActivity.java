// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.gno.GNODrawer;

// Referenced classes of package com.amazon.mShop.aiv:
//            AIVAvailabilityUtils, AmazonInstantVideoProxy

public class AIVSettingsActivity extends AmazonActivity
{

    public AIVSettingsActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (AIVAvailabilityUtils.isCompanionSettingsPageAvailable(this))
        {
            startActivity(AIVAvailabilityUtils.getSettingsIntent());
            finish();
            return;
        } else
        {
            pushView(com.amazon.mShop.android.lib.R.layout.aiv_settings);
            bundle = AmazonInstantVideoProxy.getInstance().createMainSettingsFragment();
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmenttransaction.add(com.amazon.mShop.android.lib.R.id.aiv_settings_container, bundle);
            fragmenttransaction.commit();
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        getGNODrawer().focusOn("mshop:aiv");
    }
}
