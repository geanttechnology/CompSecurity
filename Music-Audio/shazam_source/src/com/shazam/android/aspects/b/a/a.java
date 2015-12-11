// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.b.a;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ai;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.shazam.android.aspects.b.b;

public interface a
    extends b
{

    public abstract void onActionModeFinished(com.shazam.android.aspects.c.a.a a1, ActionMode actionmode);

    public abstract void onActionModeStarted(com.shazam.android.aspects.c.a.a a1, ActionMode actionmode);

    public abstract void onActivityReenter(com.shazam.android.aspects.c.a.a a1, int i, Intent intent);

    public abstract void onActivityResult(com.shazam.android.aspects.c.a.a a1, int i, int j, Intent intent);

    public abstract void onApplyThemeResource(com.shazam.android.aspects.c.a.a a1, android.content.res.Resources.Theme theme, int i, boolean flag);

    public abstract void onAttachFragment(com.shazam.android.aspects.c.a.a a1, Fragment fragment);

    public abstract void onAttachFragment(com.shazam.android.aspects.c.a.a a1, android.support.v4.app.Fragment fragment);

    public abstract void onAttachedToWindow(com.shazam.android.aspects.c.a.a a1);

    public abstract void onBackPressed(com.shazam.android.aspects.c.a.a a1);

    public abstract void onChildTitleChanged(com.shazam.android.aspects.c.a.a a1, Activity activity, CharSequence charsequence);

    public abstract void onConfigurationChanged(com.shazam.android.aspects.c.a.a a1, Configuration configuration);

    public abstract void onContentChanged(com.shazam.android.aspects.c.a.a a1);

    public abstract boolean onContextItemSelected(com.shazam.android.aspects.c.a.a a1, MenuItem menuitem);

    public abstract void onContextMenuClosed(com.shazam.android.aspects.c.a.a a1, Menu menu);

    public abstract void onCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle);

    public abstract void onCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle, PersistableBundle persistablebundle);

    public abstract void onCreateContextMenu(com.shazam.android.aspects.c.a.a a1, ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo);

    public abstract CharSequence onCreateDescription(com.shazam.android.aspects.c.a.a a1);

    public abstract Dialog onCreateDialog(com.shazam.android.aspects.c.a.a a1, int i);

    public abstract Dialog onCreateDialog(com.shazam.android.aspects.c.a.a a1, int i, Bundle bundle);

    public abstract void onCreateNavigateUpTaskStack(com.shazam.android.aspects.c.a.a a1, TaskStackBuilder taskstackbuilder);

    public abstract boolean onCreateOptionsMenu(com.shazam.android.aspects.c.a.a a1, Menu menu);

    public abstract boolean onCreatePanelMenu(com.shazam.android.aspects.c.a.a a1, int i, Menu menu);

    public abstract View onCreatePanelView(com.shazam.android.aspects.c.a.a a1, int i);

    public abstract void onCreateSupportNavigateUpTaskStack(com.shazam.android.aspects.c.a.a a1, ai ai);

    public abstract boolean onCreateThumbnail(com.shazam.android.aspects.c.a.a a1, Bitmap bitmap, Canvas canvas);

    public abstract View onCreateView(com.shazam.android.aspects.c.a.a a1, View view, String s, Context context, AttributeSet attributeset);

    public abstract View onCreateView(com.shazam.android.aspects.c.a.a a1, String s, Context context, AttributeSet attributeset);

    public abstract void onDestroy(com.shazam.android.aspects.c.a.a a1);

    public abstract void onDetachedFromWindow(com.shazam.android.aspects.c.a.a a1);

    public abstract void onEnterAnimationComplete(com.shazam.android.aspects.c.a.a a1);

    public abstract boolean onGenericMotionEvent(com.shazam.android.aspects.c.a.a a1, MotionEvent motionevent);

    public abstract boolean onKeyDown(com.shazam.android.aspects.c.a.a a1, int i, KeyEvent keyevent);

    public abstract boolean onKeyLongPress(com.shazam.android.aspects.c.a.a a1, int i, KeyEvent keyevent);

    public abstract boolean onKeyMultiple(com.shazam.android.aspects.c.a.a a1, int i, int j, KeyEvent keyevent);

    public abstract boolean onKeyShortcut(com.shazam.android.aspects.c.a.a a1, int i, KeyEvent keyevent);

    public abstract boolean onKeyUp(com.shazam.android.aspects.c.a.a a1, int i, KeyEvent keyevent);

    public abstract void onLowMemory(com.shazam.android.aspects.c.a.a a1);

    public abstract boolean onMenuOpened(com.shazam.android.aspects.c.a.a a1, int i, Menu menu);

    public abstract boolean onNavigateUp(com.shazam.android.aspects.c.a.a a1);

    public abstract boolean onNavigateUpFromChild(com.shazam.android.aspects.c.a.a a1, Activity activity);

    public abstract void onNewIntent(com.shazam.android.aspects.c.a.a a1, Intent intent);

    public abstract boolean onOptionsItemSelected(com.shazam.android.aspects.c.a.a a1, MenuItem menuitem);

    public abstract void onOptionsMenuClosed(com.shazam.android.aspects.c.a.a a1, Menu menu);

    public abstract void onPanelClosed(com.shazam.android.aspects.c.a.a a1, int i, Menu menu);

    public abstract void onPause(com.shazam.android.aspects.c.a.a a1);

    public abstract void onPostCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle);

    public abstract void onPostCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle, PersistableBundle persistablebundle);

    public abstract void onPostResume(com.shazam.android.aspects.c.a.a a1);

    public abstract void onPrepareDialog(com.shazam.android.aspects.c.a.a a1, int i, Dialog dialog);

    public abstract void onPrepareDialog(com.shazam.android.aspects.c.a.a a1, int i, Dialog dialog, Bundle bundle);

    public abstract void onPrepareNavigateUpTaskStack(com.shazam.android.aspects.c.a.a a1, TaskStackBuilder taskstackbuilder);

    public abstract boolean onPrepareOptionsMenu(com.shazam.android.aspects.c.a.a a1, Menu menu);

    public abstract boolean onPrepareOptionsPanel(com.shazam.android.aspects.c.a.a a1, View view, Menu menu);

    public abstract boolean onPreparePanel(com.shazam.android.aspects.c.a.a a1, int i, View view, Menu menu);

    public abstract void onPrepareSupportNavigateUpTaskStack(com.shazam.android.aspects.c.a.a a1, ai ai);

    public abstract void onProvideAssistData(com.shazam.android.aspects.c.a.a a1, Bundle bundle);

    public abstract void onRestart(com.shazam.android.aspects.c.a.a a1);

    public abstract void onRestoreInstanceState(com.shazam.android.aspects.c.a.a a1, Bundle bundle);

    public abstract void onRestoreInstanceState(com.shazam.android.aspects.c.a.a a1, Bundle bundle, PersistableBundle persistablebundle);

    public abstract void onResume(com.shazam.android.aspects.c.a.a a1);

    public abstract void onResumeFragments(com.shazam.android.aspects.c.a.a a1);

    public abstract Object onRetainCustomNonConfigurationInstance(com.shazam.android.aspects.c.a.a a1);

    public abstract void onSaveInstanceState(com.shazam.android.aspects.c.a.a a1, Bundle bundle);

    public abstract void onSaveInstanceState(com.shazam.android.aspects.c.a.a a1, Bundle bundle, PersistableBundle persistablebundle);

    public abstract boolean onSearchRequested(com.shazam.android.aspects.c.a.a a1);

    public abstract void onStart(com.shazam.android.aspects.c.a.a a1);

    public abstract void onStop(com.shazam.android.aspects.c.a.a a1);

    public abstract void onSupportActionModeFinished(com.shazam.android.aspects.c.a.a a1, android.support.v7.e.a a2);

    public abstract void onSupportActionModeStarted(com.shazam.android.aspects.c.a.a a1, android.support.v7.e.a a2);

    public abstract void onSupportContentChanged(com.shazam.android.aspects.c.a.a a1);

    public abstract boolean onSupportNavigateUp(com.shazam.android.aspects.c.a.a a1);

    public abstract void onTitleChanged(com.shazam.android.aspects.c.a.a a1, CharSequence charsequence, int i);

    public abstract boolean onTouchEvent(com.shazam.android.aspects.c.a.a a1, MotionEvent motionevent);

    public abstract boolean onTrackballEvent(com.shazam.android.aspects.c.a.a a1, MotionEvent motionevent);

    public abstract void onTrimMemory(com.shazam.android.aspects.c.a.a a1, int i);

    public abstract void onUserInteraction(com.shazam.android.aspects.c.a.a a1);

    public abstract void onUserLeaveHint(com.shazam.android.aspects.c.a.a a1);

    public abstract void onVisibleBehindCanceled(com.shazam.android.aspects.c.a.a a1);

    public abstract void onWindowAttributesChanged(com.shazam.android.aspects.c.a.a a1, android.view.WindowManager.LayoutParams layoutparams);

    public abstract void onWindowFocusChanged(com.shazam.android.aspects.c.a.a a1, boolean flag);

    public abstract ActionMode onWindowStartingActionMode(com.shazam.android.aspects.c.a.a a1, android.view.ActionMode.Callback callback);

    public abstract android.support.v7.e.a onWindowStartingSupportActionMode(com.shazam.android.aspects.c.a.a a1, android.support.v7.e.a a2);
}
