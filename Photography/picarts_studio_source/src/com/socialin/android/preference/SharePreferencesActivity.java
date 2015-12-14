// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.CommonConstants;

// Referenced classes of package com.socialin.android.preference:
//            e

public final class SharePreferencesActivity extends BaseActivity
    implements CommonConstants
{

    public SharePreferencesActivity()
    {
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setHomeButtonEnabled(true);
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setTitle(getString(0x7f080324));
        }
        bundle = new e();
        getFragmentManager().beginTransaction().add(0x1020002, bundle).commit();
        AnalyticUtils.getInstance(this).trackLocalAction("sharedPref:onCreate");
    }

    public final boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return true;
    }
}
