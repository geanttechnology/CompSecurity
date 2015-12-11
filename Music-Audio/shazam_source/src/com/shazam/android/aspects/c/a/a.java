// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.c.a;

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
import android.support.v7.a.f;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.shazam.android.aspects.b.c;
import com.shazam.android.aspects.b.d;
import java.util.Collection;
import java.util.Iterator;

public class a extends f
{

    private com.shazam.android.aspects.d.a.a dispatcher;

    public a()
    {
        dispatcher = new com.shazam.android.aspects.d.a.a(com.shazam.android.aspects.b.a.a(this, com/shazam/android/aspects/b/a/a, com/shazam/android/aspects/c/a/a));
    }

    protected c getAspectProvider(Class class1)
    {
        return new d(class1, dispatcher.a);
    }

    public void onActionModeFinished(ActionMode actionmode)
    {
        super.onActionModeFinished(actionmode);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onActionModeFinished(this, actionmode)) { }
    }

    public void onActionModeStarted(ActionMode actionmode)
    {
        super.onActionModeStarted(actionmode);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onActionModeStarted(this, actionmode)) { }
    }

    public void onActivityReenter(int i, Intent intent)
    {
        super.onActivityReenter(i, intent);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onActivityReenter(this, i, intent)) { }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onActivityResult(this, i, j, intent)) { }
    }

    protected void onApplyThemeResource(android.content.res.Resources.Theme theme, int i, boolean flag)
    {
        super.onApplyThemeResource(theme, i, flag);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onApplyThemeResource(this, theme, i, flag)) { }
    }

    public void onAttachFragment(Fragment fragment)
    {
        super.onAttachFragment(fragment);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onAttachFragment(this, fragment)) { }
    }

    public void onAttachFragment(android.support.v4.app.Fragment fragment)
    {
        super.onAttachFragment(fragment);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onAttachFragment(this, fragment)) { }
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onAttachedToWindow(this)) { }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onBackPressed(this)) { }
    }

    protected void onChildTitleChanged(Activity activity, CharSequence charsequence)
    {
        super.onChildTitleChanged(activity, charsequence);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onChildTitleChanged(this, activity, charsequence)) { }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onConfigurationChanged(this, configuration)) { }
    }

    public void onContentChanged()
    {
        super.onContentChanged();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onContentChanged(this)) { }
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (super.onContextItemSelected(menuitem)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onContextItemSelected(this, menuitem)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onContextMenuClosed(Menu menu)
    {
        super.onContextMenuClosed(menu);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onContextMenuClosed(this, menu)) { }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreate(this, bundle)) { }
    }

    public void onCreate(Bundle bundle, PersistableBundle persistablebundle)
    {
        super.onCreate(bundle, persistablebundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreate(this, bundle, persistablebundle)) { }
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateContextMenu(this, contextmenu, view, contextmenuinfo)) { }
    }

    public CharSequence onCreateDescription()
    {
        CharSequence charsequence = super.onCreateDescription();
        if (charsequence != null)
        {
            return charsequence;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            CharSequence charsequence1 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateDescription(this);
            if (charsequence1 != null)
            {
                return charsequence1;
            }
        }

        return null;
    }

    public Dialog onCreateDialog(int i)
    {
        Dialog dialog = super.onCreateDialog(i);
        if (dialog != null)
        {
            return dialog;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            Dialog dialog1 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateDialog(this, i);
            if (dialog1 != null)
            {
                return dialog1;
            }
        }

        return null;
    }

    protected Dialog onCreateDialog(int i, Bundle bundle)
    {
        Dialog dialog = super.onCreateDialog(i, bundle);
        if (dialog != null)
        {
            return dialog;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            Dialog dialog1 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateDialog(this, i, bundle);
            if (dialog1 != null)
            {
                return dialog1;
            }
        }

        return null;
    }

    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskstackbuilder)
    {
        super.onCreateNavigateUpTaskStack(taskstackbuilder);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateNavigateUpTaskStack(this, taskstackbuilder)) { }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (super.onCreateOptionsMenu(menu)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateOptionsMenu(this, menu)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        if (super.onCreatePanelMenu(i, menu)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onCreatePanelMenu(this, i, menu)) goto _L6; else goto _L5
_L5:
        i = 1;
_L8:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public View onCreatePanelView(int i)
    {
        View view = super.onCreatePanelView(i);
        if (view != null)
        {
            return view;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            View view1 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreatePanelView(this, i);
            if (view1 != null)
            {
                return view1;
            }
        }

        return null;
    }

    public void onCreateSupportNavigateUpTaskStack(ai ai)
    {
        super.onCreateSupportNavigateUpTaskStack(ai);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateSupportNavigateUpTaskStack(this, ai)) { }
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas)
    {
        if (super.onCreateThumbnail(bitmap, canvas)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateThumbnail(this, bitmap, canvas)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        View view1 = super.onCreateView(view, s, context, attributeset);
        if (view1 != null)
        {
            return view1;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            View view2 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateView(this, view, s, context, attributeset);
            if (view2 != null)
            {
                return view2;
            }
        }

        return null;
    }

    public View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        View view = super.onCreateView(s, context, attributeset);
        if (view != null)
        {
            return view;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            View view1 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onCreateView(this, s, context, attributeset);
            if (view1 != null)
            {
                return view1;
            }
        }

        return null;
    }

    public void onDestroy()
    {
        super.onDestroy();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onDestroy(this)) { }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onDetachedFromWindow(this)) { }
    }

    public void onEnterAnimationComplete()
    {
        super.onEnterAnimationComplete();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onEnterAnimationComplete(this)) { }
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        if (super.onGenericMotionEvent(motionevent)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onGenericMotionEvent(this, motionevent)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (super.onKeyDown(i, keyevent)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onKeyDown(this, i, keyevent)) goto _L6; else goto _L5
_L5:
        i = 1;
_L8:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent)
    {
        if (super.onKeyLongPress(i, keyevent)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onKeyLongPress(this, i, keyevent)) goto _L6; else goto _L5
_L5:
        i = 1;
_L8:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent)
    {
        if (super.onKeyMultiple(i, j, keyevent)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onKeyMultiple(this, i, j, keyevent)) goto _L6; else goto _L5
_L5:
        i = 1;
_L8:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyevent)
    {
        if (super.onKeyShortcut(i, keyevent)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onKeyShortcut(this, i, keyevent)) goto _L6; else goto _L5
_L5:
        i = 1;
_L8:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (super.onKeyUp(i, keyevent)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onKeyUp(this, i, keyevent)) goto _L6; else goto _L5
_L5:
        i = 1;
_L8:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onLowMemory(this)) { }
    }

    public boolean onMenuOpened(int i, Menu menu)
    {
        if (super.onMenuOpened(i, menu)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onMenuOpened(this, i, menu)) goto _L6; else goto _L5
_L5:
        i = 1;
_L8:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onNavigateUp()
    {
        if (super.onNavigateUp()) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onNavigateUp(this)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onNavigateUpFromChild(Activity activity)
    {
        if (super.onNavigateUpFromChild(activity)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onNavigateUpFromChild(this, activity)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onNewIntent(this, intent)) { }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (super.onOptionsItemSelected(menuitem)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onOptionsItemSelected(this, menuitem)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onOptionsMenuClosed(Menu menu)
    {
        super.onOptionsMenuClosed(menu);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onOptionsMenuClosed(this, menu)) { }
    }

    public void onPanelClosed(int i, Menu menu)
    {
        super.onPanelClosed(i, menu);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPanelClosed(this, i, menu)) { }
    }

    public void onPause()
    {
        super.onPause();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPause(this)) { }
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPostCreate(this, bundle)) { }
    }

    public void onPostCreate(Bundle bundle, PersistableBundle persistablebundle)
    {
        super.onPostCreate(bundle, persistablebundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPostCreate(this, bundle, persistablebundle)) { }
    }

    protected void onPostResume()
    {
        super.onPostResume();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPostResume(this)) { }
    }

    protected void onPrepareDialog(int i, Dialog dialog)
    {
        super.onPrepareDialog(i, dialog);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPrepareDialog(this, i, dialog)) { }
    }

    protected void onPrepareDialog(int i, Dialog dialog, Bundle bundle)
    {
        super.onPrepareDialog(i, dialog, bundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPrepareDialog(this, i, dialog, bundle)) { }
    }

    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskstackbuilder)
    {
        super.onPrepareNavigateUpTaskStack(taskstackbuilder);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPrepareNavigateUpTaskStack(this, taskstackbuilder)) { }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (super.onPrepareOptionsMenu(menu)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onPrepareOptionsMenu(this, menu)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu)
    {
        if (super.onPrepareOptionsPanel(view, menu)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onPrepareOptionsPanel(this, view, menu)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        if (super.onPreparePanel(i, view, menu)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onPreparePanel(this, i, view, menu)) goto _L6; else goto _L5
_L5:
        i = 1;
_L8:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onPrepareSupportNavigateUpTaskStack(ai ai)
    {
        super.onPrepareSupportNavigateUpTaskStack(ai);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onPrepareSupportNavigateUpTaskStack(this, ai)) { }
    }

    public void onProvideAssistData(Bundle bundle)
    {
        super.onProvideAssistData(bundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onProvideAssistData(this, bundle)) { }
    }

    protected void onRestart()
    {
        super.onRestart();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onRestart(this)) { }
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onRestoreInstanceState(this, bundle)) { }
    }

    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistablebundle)
    {
        super.onRestoreInstanceState(bundle, persistablebundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onRestoreInstanceState(this, bundle, persistablebundle)) { }
    }

    public void onResume()
    {
        super.onResume();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onResume(this)) { }
    }

    protected void onResumeFragments()
    {
        super.onResumeFragments();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onResumeFragments(this)) { }
    }

    public Object onRetainCustomNonConfigurationInstance()
    {
        Object obj = super.onRetainCustomNonConfigurationInstance();
        if (obj != null)
        {
            return obj;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            Object obj1 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onRetainCustomNonConfigurationInstance(this);
            if (obj1 != null)
            {
                return obj1;
            }
        }

        return null;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onSaveInstanceState(this, bundle)) { }
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistablebundle)
    {
        super.onSaveInstanceState(bundle, persistablebundle);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onSaveInstanceState(this, bundle, persistablebundle)) { }
    }

    public boolean onSearchRequested()
    {
        if (super.onSearchRequested()) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onSearchRequested(this)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onStart()
    {
        super.onStart();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onStart(this)) { }
    }

    public void onStop()
    {
        super.onStop();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onStop(this)) { }
    }

    public void onSupportActionModeFinished(android.support.v7.e.a a1)
    {
        super.onSupportActionModeFinished(a1);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onSupportActionModeFinished(this, a1)) { }
    }

    public void onSupportActionModeStarted(android.support.v7.e.a a1)
    {
        super.onSupportActionModeStarted(a1);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onSupportActionModeStarted(this, a1)) { }
    }

    public void onSupportContentChanged()
    {
        super.onSupportContentChanged();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onSupportContentChanged(this)) { }
    }

    public boolean onSupportNavigateUp()
    {
        if (super.onSupportNavigateUp()) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onSupportNavigateUp(this)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    protected void onTitleChanged(CharSequence charsequence, int i)
    {
        super.onTitleChanged(charsequence, i);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onTitleChanged(this, charsequence, i)) { }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (super.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onTouchEvent(this, motionevent)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionevent)
    {
        if (super.onTrackballEvent(motionevent)) goto _L2; else goto _L1
_L1:
        Iterator iterator = dispatcher.a.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((com.shazam.android.aspects.b.a.a)iterator.next()).onTrackballEvent(this, motionevent)) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L8:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return true;
_L4:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        return false;
    }

    public void onTrimMemory(int i)
    {
        super.onTrimMemory(i);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onTrimMemory(this, i)) { }
    }

    public void onUserInteraction()
    {
        super.onUserInteraction();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onUserInteraction(this)) { }
    }

    protected void onUserLeaveHint()
    {
        super.onUserLeaveHint();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onUserLeaveHint(this)) { }
    }

    public void onVisibleBehindCanceled()
    {
        super.onVisibleBehindCanceled();
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onVisibleBehindCanceled(this)) { }
    }

    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutparams)
    {
        super.onWindowAttributesChanged(layoutparams);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onWindowAttributesChanged(this, layoutparams)) { }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext(); ((com.shazam.android.aspects.b.a.a)iterator.next()).onWindowFocusChanged(this, flag)) { }
    }

    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback)
    {
        ActionMode actionmode = super.onWindowStartingActionMode(callback);
        if (actionmode != null)
        {
            return actionmode;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            ActionMode actionmode1 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onWindowStartingActionMode(this, callback);
            if (actionmode1 != null)
            {
                return actionmode1;
            }
        }

        return null;
    }

    public android.support.v7.e.a onWindowStartingSupportActionMode(android.support.v7.e.a a1)
    {
        android.support.v7.e.a a2 = super.onWindowStartingSupportActionMode(a1);
        if (a2 != null)
        {
            return a2;
        }
        for (Iterator iterator = dispatcher.a.iterator(); iterator.hasNext();)
        {
            android.support.v7.e.a a3 = ((com.shazam.android.aspects.b.a.a)iterator.next()).onWindowStartingSupportActionMode(this, a1);
            if (a3 != null)
            {
                return a3;
            }
        }

        return null;
    }
}
