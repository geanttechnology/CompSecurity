// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, SettingsFragment, BaseTimelineFragment

public class SettingsActivity extends BaseControllerActionBarActivity
{

    private String SETTINGS_TAG;
    private SettingsFragment mFrag;

    public SettingsActivity()
    {
        SETTINGS_TAG = "settings";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (mFrag == null)
        {
            mFrag = (SettingsFragment)getSupportFragmentManager().findFragmentByTag(SETTINGS_TAG);
        }
        if (mFrag != null)
        {
            mFrag.onActivityResult(i, j, intent);
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onBackPressed()
    {
        if (mFrag == null)
        {
            mFrag = (SettingsFragment)getSupportFragmentManager().findFragmentByTag(SETTINGS_TAG);
        }
        if (mFrag != null)
        {
            mFrag.onBackPressed();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e01c5, Boolean.valueOf(true));
        if (bundle == null)
        {
            bundle = new SettingsFragment();
            bundle.setArguments(BaseTimelineFragment.prepareArguments(getIntent()));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, SETTINGS_TAG).commit();
            mFrag = bundle;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            break;
        }
        if (mFrag == null)
        {
            mFrag = (SettingsFragment)getSupportFragmentManager().findFragmentByTag(SETTINGS_TAG);
        }
        if (mFrag != null)
        {
            mFrag.onBackPressed();
        }
        return true;
    }
}
