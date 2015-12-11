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
import com.shazam.android.aspects.c.a.a;

// Referenced classes of package com.shazam.android.aspects.b.a:
//            a

public class b
    implements com.shazam.android.aspects.b.a.a
{

    public b()
    {
    }

    public Class classActingOn()
    {
        return com/shazam/android/aspects/c/a/a;
    }

    public void onActionModeFinished(a a1, ActionMode actionmode)
    {
    }

    public void onActionModeStarted(a a1, ActionMode actionmode)
    {
    }

    public void onActivityReenter(a a1, int i, Intent intent)
    {
    }

    public void onActivityResult(a a1, int i, int j, Intent intent)
    {
    }

    public void onApplyThemeResource(a a1, android.content.res.Resources.Theme theme, int i, boolean flag)
    {
    }

    public void onAttachFragment(a a1, Fragment fragment)
    {
    }

    public void onAttachFragment(a a1, android.support.v4.app.Fragment fragment)
    {
    }

    public void onAttachedToWindow(a a1)
    {
    }

    public void onBackPressed(a a1)
    {
    }

    public void onChildTitleChanged(a a1, Activity activity, CharSequence charsequence)
    {
    }

    public void onConfigurationChanged(a a1, Configuration configuration)
    {
    }

    public void onContentChanged(a a1)
    {
    }

    public boolean onContextItemSelected(a a1, MenuItem menuitem)
    {
        return false;
    }

    public void onContextMenuClosed(a a1, Menu menu)
    {
    }

    public void onCreate(a a1, Bundle bundle)
    {
    }

    public void onCreate(a a1, Bundle bundle, PersistableBundle persistablebundle)
    {
    }

    public void onCreateContextMenu(a a1, ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
    }

    public CharSequence onCreateDescription(a a1)
    {
        return null;
    }

    public Dialog onCreateDialog(a a1, int i)
    {
        return null;
    }

    public Dialog onCreateDialog(a a1, int i, Bundle bundle)
    {
        return null;
    }

    public void onCreateNavigateUpTaskStack(a a1, TaskStackBuilder taskstackbuilder)
    {
    }

    public boolean onCreateOptionsMenu(a a1, Menu menu)
    {
        return false;
    }

    public boolean onCreatePanelMenu(a a1, int i, Menu menu)
    {
        return false;
    }

    public View onCreatePanelView(a a1, int i)
    {
        return null;
    }

    public void onCreateSupportNavigateUpTaskStack(a a1, ai ai)
    {
    }

    public boolean onCreateThumbnail(a a1, Bitmap bitmap, Canvas canvas)
    {
        return false;
    }

    public View onCreateView(a a1, View view, String s, Context context, AttributeSet attributeset)
    {
        return null;
    }

    public View onCreateView(a a1, String s, Context context, AttributeSet attributeset)
    {
        return null;
    }

    public void onDestroy(a a1)
    {
    }

    public void onDetachedFromWindow(a a1)
    {
    }

    public void onEnterAnimationComplete(a a1)
    {
    }

    public boolean onGenericMotionEvent(a a1, MotionEvent motionevent)
    {
        return false;
    }

    public boolean onKeyDown(a a1, int i, KeyEvent keyevent)
    {
        return false;
    }

    public boolean onKeyLongPress(a a1, int i, KeyEvent keyevent)
    {
        return false;
    }

    public boolean onKeyMultiple(a a1, int i, int j, KeyEvent keyevent)
    {
        return false;
    }

    public boolean onKeyShortcut(a a1, int i, KeyEvent keyevent)
    {
        return false;
    }

    public boolean onKeyUp(a a1, int i, KeyEvent keyevent)
    {
        return false;
    }

    public void onLowMemory(a a1)
    {
    }

    public boolean onMenuOpened(a a1, int i, Menu menu)
    {
        return false;
    }

    public boolean onNavigateUp(a a1)
    {
        return false;
    }

    public boolean onNavigateUpFromChild(a a1, Activity activity)
    {
        return false;
    }

    public void onNewIntent(a a1, Intent intent)
    {
    }

    public boolean onOptionsItemSelected(a a1, MenuItem menuitem)
    {
        return false;
    }

    public void onOptionsMenuClosed(a a1, Menu menu)
    {
    }

    public void onPanelClosed(a a1, int i, Menu menu)
    {
    }

    public void onPause(a a1)
    {
    }

    public void onPostCreate(a a1, Bundle bundle)
    {
    }

    public void onPostCreate(a a1, Bundle bundle, PersistableBundle persistablebundle)
    {
    }

    public void onPostResume(a a1)
    {
    }

    public void onPrepareDialog(a a1, int i, Dialog dialog)
    {
    }

    public void onPrepareDialog(a a1, int i, Dialog dialog, Bundle bundle)
    {
    }

    public void onPrepareNavigateUpTaskStack(a a1, TaskStackBuilder taskstackbuilder)
    {
    }

    public boolean onPrepareOptionsMenu(a a1, Menu menu)
    {
        return false;
    }

    public boolean onPrepareOptionsPanel(a a1, View view, Menu menu)
    {
        return false;
    }

    public boolean onPreparePanel(a a1, int i, View view, Menu menu)
    {
        return false;
    }

    public void onPrepareSupportNavigateUpTaskStack(a a1, ai ai)
    {
    }

    public void onProvideAssistData(a a1, Bundle bundle)
    {
    }

    public void onRestart(a a1)
    {
    }

    public void onRestoreInstanceState(a a1, Bundle bundle)
    {
    }

    public void onRestoreInstanceState(a a1, Bundle bundle, PersistableBundle persistablebundle)
    {
    }

    public void onResume(a a1)
    {
    }

    public void onResumeFragments(a a1)
    {
    }

    public Object onRetainCustomNonConfigurationInstance(a a1)
    {
        return null;
    }

    public void onSaveInstanceState(a a1, Bundle bundle)
    {
    }

    public void onSaveInstanceState(a a1, Bundle bundle, PersistableBundle persistablebundle)
    {
    }

    public boolean onSearchRequested(a a1)
    {
        return false;
    }

    public void onStart(a a1)
    {
    }

    public void onStop(a a1)
    {
    }

    public void onSupportActionModeFinished(a a1, android.support.v7.e.a a2)
    {
    }

    public void onSupportActionModeStarted(a a1, android.support.v7.e.a a2)
    {
    }

    public void onSupportContentChanged(a a1)
    {
    }

    public boolean onSupportNavigateUp(a a1)
    {
        return false;
    }

    public void onTitleChanged(a a1, CharSequence charsequence, int i)
    {
    }

    public boolean onTouchEvent(a a1, MotionEvent motionevent)
    {
        return false;
    }

    public boolean onTrackballEvent(a a1, MotionEvent motionevent)
    {
        return false;
    }

    public void onTrimMemory(a a1, int i)
    {
    }

    public void onUserInteraction(a a1)
    {
    }

    public void onUserLeaveHint(a a1)
    {
    }

    public void onVisibleBehindCanceled(a a1)
    {
    }

    public void onWindowAttributesChanged(a a1, android.view.WindowManager.LayoutParams layoutparams)
    {
    }

    public void onWindowFocusChanged(a a1, boolean flag)
    {
    }

    public ActionMode onWindowStartingActionMode(a a1, android.view.ActionMode.Callback callback)
    {
        return null;
    }

    public android.support.v7.e.a onWindowStartingSupportActionMode(a a1, android.support.v7.e.a.a a2)
    {
        return null;
    }
}
