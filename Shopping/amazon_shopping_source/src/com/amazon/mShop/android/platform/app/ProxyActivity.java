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
import com.amazon.mShop.android.platform.dex.SecondDexEntry;

// Referenced classes of package com.amazon.mShop.android.platform.app:
//            ActivityDelegateBase

public class ProxyActivity extends Activity
    implements IActivityProxy
{

    private ActivityDelegateBase mActivityDelegate;

    public ProxyActivity()
    {
    }

    protected ActivityDelegateBase createActityImpl()
    {
        return (ActivityDelegateBase)SecondDexEntry.getInstance().createActivityDelegate(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return getActivityDelegate().dispatchKeyEvent_impl(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return getActivityDelegate().dispatchPopulateAccessibilityEvent_impl(accessibilityevent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return getActivityDelegate().dispatchTouchEvent_impl(motionevent);
    }

    public ActivityDelegateBase getActivityDelegate()
    {
        this;
        JVM INSTR monitorenter ;
        ActivityDelegateBase activitydelegatebase;
        if (mActivityDelegate == null)
        {
            mActivityDelegate = createActityImpl();
        }
        activitydelegatebase = mActivityDelegate;
        this;
        JVM INSTR monitorexit ;
        return activitydelegatebase;
        Exception exception;
        exception;
        throw exception;
    }

    public Context getApplicationContext()
    {
        return getActivityDelegate().getApplicationContext_impl();
    }

    public ClassLoader getClassLoader()
    {
        return SecondDexEntry.getInstance().getClassLoader();
    }

    public Object getSystemService(String s)
    {
        return getActivityDelegate().getSystemService_impl(s);
    }

    public boolean isFinishing()
    {
        return getActivityDelegate().isFinishing_impl();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        getActivityDelegate().onActivityResult_impl(i, j, intent);
    }

    public void onBackPressed()
    {
        getActivityDelegate().onBackPressed_impl();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        getActivityDelegate().onConfigurationChanged_impl(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        getActivityDelegate().onCreate_impl(bundle);
    }

    protected void onDestroy()
    {
        getActivityDelegate().onDestroy_impl();
    }

    protected void onNewIntent(Intent intent)
    {
        getActivityDelegate().onNewIntent_impl(intent);
    }

    protected void onPause()
    {
        getActivityDelegate().onPause_impl();
    }

    protected void onPostCreate(Bundle bundle)
    {
        getActivityDelegate().onPostCreate_impl(bundle);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return getActivityDelegate().onPrepareOptionsMenu_impl(menu);
    }

    protected void onRestart()
    {
        getActivityDelegate().onRestart_impl();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        getActivityDelegate().onRestoreInstanceState_impl(bundle);
    }

    protected void onResume()
    {
        getActivityDelegate().onResume_impl();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        getActivityDelegate().onSaveInstanceState_impl(bundle);
    }

    protected void onStart()
    {
        getActivityDelegate().onStart_impl();
    }

    protected void onStop()
    {
        getActivityDelegate().onStop_impl();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return getActivityDelegate().onTouchEvent_impl(motionevent);
    }

    protected void onUserLeaveHint()
    {
        getActivityDelegate().onUserLeaveHint_impl();
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        return getActivityDelegate().registerReceiver_impl(broadcastreceiver, intentfilter);
    }

    public void setContentView(int i)
    {
        getActivityDelegate().setContentView_impl(i);
    }

    public void setContentView(View view)
    {
        getActivityDelegate().setContentView_impl(view);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyEvent(keyevent);
    }

    public boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return super.dispatchPopulateAccessibilityEvent(accessibilityevent);
    }

    public boolean superDispatchTouchEvent(MotionEvent motionevent)
    {
        return super.dispatchTouchEvent(motionevent);
    }

    public View superFindViewById(int i)
    {
        return super.findViewById(i);
    }

    public Context superGetApplicationContext()
    {
        return super.getApplicationContext();
    }

    public Object superGetSystemService(String s)
    {
        return super.getSystemService(s);
    }

    public Window superGetWindow()
    {
        return super.getWindow();
    }

    public boolean superIsFinishing()
    {
        return super.isFinishing();
    }

    public void superOnActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    public void superOnBackPressed()
    {
        super.onBackPressed();
    }

    public void superOnConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void superOnCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public void superOnDestroy()
    {
        super.onDestroy();
    }

    public void superOnNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
    }

    public void superOnPause()
    {
        super.onPause();
    }

    public void superOnPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
    }

    public boolean superOnPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
    }

    public void superOnRestart()
    {
        super.onRestart();
    }

    public void superOnRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    public void superOnResume()
    {
        super.onResume();
    }

    public void superOnSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void superOnStart()
    {
        super.onStart();
    }

    public void superOnStop()
    {
        super.onStop();
    }

    public boolean superOnTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

    public void superOnUserLeaveHint()
    {
        super.onUserLeaveHint();
    }

    public Intent superRegisterReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        return super.registerReceiver(broadcastreceiver, intentfilter);
    }

    public void superSetContentView(int i)
    {
        super.setContentView(i);
    }

    public void superSetContentView(View view)
    {
        super.setContentView(view);
    }

    public void superSetContentView(View view, android.widget.LinearLayout.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
    }

    public void superUnregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        super.unregisterReceiver(broadcastreceiver);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        getActivityDelegate().unregisterReceiver_impl(broadcastreceiver);
    }
}
