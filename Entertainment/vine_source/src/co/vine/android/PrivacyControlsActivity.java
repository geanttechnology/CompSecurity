// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, PrivacyControlsFragment

public class PrivacyControlsActivity extends BaseControllerActionBarActivity
{

    private static final String PRIVACY_CONTROLS_TAG = "privacy_controls";

    public PrivacyControlsActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e0188, Boolean.valueOf(true));
        if (bundle == null)
        {
            bundle = new PrivacyControlsFragment();
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "privacy_controls").commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            break;
        }
        return true;
    }
}
