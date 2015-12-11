// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.ButterKnife;
import com.f2prateek.dart.Dart;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GrouponDialogCustomViewListener;
import com.groupon.util.GrouponRoboActionBarListActivity;

// Referenced classes of package com.groupon.activity:
//            GrouponActivityInterface, GrouponActivityDelegate

public abstract class GrouponListActivity extends GrouponRoboActionBarListActivity
    implements GrouponActivityInterface, GrouponDialogCustomViewListener
{

    private GrouponActivityDelegate _flddelegate;
    boolean hasLoggedWindowDrawnTime;
    private boolean isDeepLinked;
    private Logger logger;
    private long onCreateStartTime;
    Toolbar toolbar;

    public GrouponListActivity()
    {
        hasLoggedWindowDrawnTime = false;
    }

    protected Intent getDeepLinkUpIntent()
    {
        return NavUtils.getParentActivityIntent(this);
    }

    public View getDialogCustomView(String s)
    {
        return _flddelegate.getDialogCustomView(s);
    }

    protected Toolbar getToolbar()
    {
        return toolbar;
    }

    protected boolean hasCartIcon()
    {
        return false;
    }

    protected void initActionBar(Bundle bundle)
    {
        bundle = getSupportActionBar();
        bundle.setTitle(null);
        bundle.setDisplayShowTitleEnabled(true);
        bundle.setDisplayHomeAsUpEnabled(true);
        if (toolbar == null)
        {
            bundle.setElevation(getResources().getDimension(0x7f0b0189));
        }
    }

    public void onCreate(Bundle bundle)
    {
        onCreateStartTime = SystemClock.elapsedRealtime();
        GrouponActivityDelegate.onPreCreate(this);
        super.onCreate(bundle);
        Dart.inject(this);
        isDeepLinked = getIntent().getBooleanExtra("isDeepLinked", false);
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
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   16908332: 53
    //                   2131755035: 78;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_78;
_L4:
        return super.onOptionsItemSelected(menuitem) || _flddelegate.onOptionsItemSelected(menuitem);
_L2:
        if (isDeepLinked)
        {
            GrouponActivityDelegate grouponactivitydelegate = _flddelegate;
            if (GrouponActivityDelegate.startDeepLinkedUpButtonIntent(this, getDeepLinkUpIntent()))
            {
                return true;
            }
        }
          goto _L4
        _flddelegate.reportABugDialog(getFragmentManager());
          goto _L4
    }

    protected void onPause()
    {
        super.onPause();
        _flddelegate.onPause();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        _flddelegate.onPostCreate(bundle);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            initActionBar(bundle);
            _flddelegate.addStandaloneShoppingCartIcon(actionbar, hasCartIcon());
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu) && _flddelegate.onPrepareOptionsMenu(menu);
    }

    protected void onResume()
    {
        super.onResume();
        _flddelegate.onResume();
        _flddelegate.onPostResume(getSupportActionBar());
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

    public void onSupportContentChanged()
    {
        super.onSupportContentChanged();
        ButterKnife.bind(this);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && !hasLoggedWindowDrawnTime)
        {
            hasLoggedWindowDrawnTime = true;
            String s = getClass().getSimpleName();
            logger.logGeneralEvent("android_events", "window_drawn", s, (int)(SystemClock.elapsedRealtime() - onCreateStartTime), Logger.NULL_NST_FIELD);
        }
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
    }

    protected void setDisplayToolbarTitle(boolean flag)
    {
        getSupportActionBar().setDisplayShowTitleEnabled(flag);
    }

    protected void setToolbarTitle(String s)
    {
        getSupportActionBar().setTitle(s);
    }
}
