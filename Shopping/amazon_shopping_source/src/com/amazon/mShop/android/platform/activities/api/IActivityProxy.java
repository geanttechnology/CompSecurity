// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.activities.api;

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

public interface IActivityProxy
{

    public abstract boolean superDispatchKeyEvent(KeyEvent keyevent);

    public abstract boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent);

    public abstract boolean superDispatchTouchEvent(MotionEvent motionevent);

    public abstract View superFindViewById(int i);

    public abstract Context superGetApplicationContext();

    public abstract Object superGetSystemService(String s);

    public abstract Window superGetWindow();

    public abstract boolean superIsFinishing();

    public abstract void superOnActivityResult(int i, int j, Intent intent);

    public abstract void superOnBackPressed();

    public abstract void superOnConfigurationChanged(Configuration configuration);

    public abstract void superOnCreate(Bundle bundle);

    public abstract void superOnDestroy();

    public abstract void superOnNewIntent(Intent intent);

    public abstract void superOnPause();

    public abstract void superOnPostCreate(Bundle bundle);

    public abstract boolean superOnPrepareOptionsMenu(Menu menu);

    public abstract void superOnRestart();

    public abstract void superOnRestoreInstanceState(Bundle bundle);

    public abstract void superOnResume();

    public abstract void superOnSaveInstanceState(Bundle bundle);

    public abstract void superOnStart();

    public abstract void superOnStop();

    public abstract boolean superOnTouchEvent(MotionEvent motionevent);

    public abstract void superOnUserLeaveHint();

    public abstract Intent superRegisterReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter);

    public abstract void superSetContentView(int i);

    public abstract void superSetContentView(View view);

    public abstract void superSetContentView(View view, android.widget.LinearLayout.LayoutParams layoutparams);

    public abstract void superUnregisterReceiver(BroadcastReceiver broadcastreceiver);
}
