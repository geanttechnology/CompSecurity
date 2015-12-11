// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.groupon.foundations.activity.BasePreferenceActivity;
import com.groupon.util.GrouponDialogCustomViewListener;
import com.groupon.util.SecretSettingsActionBarUtil;
import com.groupon.util.Tracking;

// Referenced classes of package com.groupon.activity:
//            GrouponActivityDelegate, SecretSettingsActivityDelegate

public abstract class GrouponPreferenceActivity extends BasePreferenceActivity
    implements GrouponDialogCustomViewListener
{

    private SecretSettingsActivityDelegate _flddelegate;
    private Tracking tracking;

    public GrouponPreferenceActivity()
    {
    }

    private void initActionBar()
    {
        SecretSettingsActionBarUtil.initializeActionBar(getApplicationContext(), getActionBar(), false, true);
    }

    protected boolean hasCartIcon()
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        GrouponActivityDelegate.onPreCreate(this);
        super.onCreate(bundle);
        android.app.ActionBar actionbar = getActionBar();
        _flddelegate.onPostCreate(bundle, actionbar);
        if (actionbar != null)
        {
            initActionBar();
            _flddelegate.addStandaloneShoppingCartIcon(actionbar, hasCartIcon());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu) && _flddelegate.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        _flddelegate.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem) || _flddelegate.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            return true;
        }
    }

    protected void onPause()
    {
        super.onPause();
        _flddelegate.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu) && _flddelegate.onPrepareOptionsMenu(menu);
    }

    protected void onResume()
    {
        super.onResume();
        _flddelegate.onResume();
        tracking.trackPageView(getClass().getSimpleName());
        _flddelegate.onPostResume(getActionBar());
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        _flddelegate.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        _flddelegate.onStart();
    }

    protected void onStop()
    {
        super.onStop();
        _flddelegate.onStop();
    }
}
