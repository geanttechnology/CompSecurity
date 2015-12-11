// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import com.amazon.mShop.android.platform.activities.api.IActivityProxy;

public class ActivityDelegateBase
{

    protected final Activity mActivityProxy;

    public ActivityDelegateBase(Activity activity)
    {
        mActivityProxy = activity;
    }

    public boolean dispatchKeyEvent_impl(KeyEvent keyevent)
    {
        return ((IActivityProxy)mActivityProxy).superDispatchKeyEvent(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent_impl(AccessibilityEvent accessibilityevent)
    {
        return ((IActivityProxy)mActivityProxy).superDispatchPopulateAccessibilityEvent(accessibilityevent);
    }

    public boolean dispatchTouchEvent_impl(MotionEvent motionevent)
    {
        return ((IActivityProxy)mActivityProxy).superDispatchTouchEvent(motionevent);
    }

    public View findViewById_impl(int i)
    {
        return ((IActivityProxy)mActivityProxy).superFindViewById(i);
    }

    public Context getApplicationContext_impl()
    {
        return ((IActivityProxy)mActivityProxy).superGetApplicationContext();
    }

    public Activity getProxy()
    {
        return mActivityProxy;
    }

    public Object getSystemService_impl(String s)
    {
        return ((IActivityProxy)mActivityProxy).superGetSystemService(s);
    }

    public Window getWindow_impl()
    {
        return ((IActivityProxy)mActivityProxy).superGetWindow();
    }

    public boolean isFinishing_impl()
    {
        return ((IActivityProxy)mActivityProxy).superIsFinishing();
    }

    protected void onActivityResult_impl(int i, int j, Intent intent)
    {
        ((IActivityProxy)mActivityProxy).superOnActivityResult(i, j, intent);
    }

    public void onBackPressed_impl()
    {
        ((IActivityProxy)mActivityProxy).superOnBackPressed();
    }

    public void onConfigurationChanged_impl(Configuration configuration)
    {
        ((IActivityProxy)mActivityProxy).superOnConfigurationChanged(configuration);
    }

    protected void onCreate_impl(Bundle bundle)
    {
        ((IActivityProxy)mActivityProxy).superOnCreate(bundle);
    }

    protected void onDestroy_impl()
    {
        ((IActivityProxy)mActivityProxy).superOnDestroy();
    }

    protected void onNewIntent_impl(Intent intent)
    {
        ((IActivityProxy)mActivityProxy).superOnNewIntent(intent);
    }

    protected void onPause_impl()
    {
        ((IActivityProxy)mActivityProxy).superOnPause();
    }

    protected void onPostCreate_impl(Bundle bundle)
    {
        ((IActivityProxy)mActivityProxy).superOnPostCreate(bundle);
    }

    public boolean onPrepareOptionsMenu_impl(Menu menu)
    {
        return ((IActivityProxy)mActivityProxy).superOnPrepareOptionsMenu(menu);
    }

    protected void onRestart_impl()
    {
        ((IActivityProxy)mActivityProxy).superOnRestart();
    }

    protected void onRestoreInstanceState_impl(Bundle bundle)
    {
        ((IActivityProxy)mActivityProxy).superOnRestoreInstanceState(bundle);
    }

    protected void onResume_impl()
    {
        ((IActivityProxy)mActivityProxy).superOnResume();
    }

    protected void onSaveInstanceState_impl(Bundle bundle)
    {
        ((IActivityProxy)mActivityProxy).superOnSaveInstanceState(bundle);
    }

    protected void onStart_impl()
    {
        ((IActivityProxy)mActivityProxy).superOnStart();
    }

    protected void onStop_impl()
    {
        ((IActivityProxy)mActivityProxy).superOnStop();
    }

    public boolean onTouchEvent_impl(MotionEvent motionevent)
    {
        return ((IActivityProxy)mActivityProxy).superOnTouchEvent(motionevent);
    }

    protected void onUserLeaveHint_impl()
    {
        ((IActivityProxy)mActivityProxy).superOnUserLeaveHint();
    }

    public Intent registerReceiver_impl(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        return ((IActivityProxy)mActivityProxy).superRegisterReceiver(broadcastreceiver, intentfilter);
    }

    public void setContentView_impl(int i)
    {
        ((IActivityProxy)mActivityProxy).superSetContentView(i);
    }

    public void setContentView_impl(View view)
    {
        ((IActivityProxy)mActivityProxy).superSetContentView(view);
    }

    public void setContentView_impl(View view, android.widget.LinearLayout.LayoutParams layoutparams)
    {
        ((IActivityProxy)mActivityProxy).superSetContentView(view, layoutparams);
    }

    public void unregisterReceiver_impl(BroadcastReceiver broadcastreceiver)
    {
        ((IActivityProxy)mActivityProxy).superUnregisterReceiver(broadcastreceiver);
    }
}
