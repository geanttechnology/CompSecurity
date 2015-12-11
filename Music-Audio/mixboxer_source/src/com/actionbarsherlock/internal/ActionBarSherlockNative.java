// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarWrapper;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.view.ActionMode;

public class ActionBarSherlockNative extends ActionBarSherlock
{

    private ActionBarWrapper mActionBar;
    private ActionModeWrapper mActionMode;
    private MenuWrapper mMenu;

    public ActionBarSherlockNative(Activity activity, int i)
    {
        super(activity, i);
    }

    private void initActionBar()
    {
        if (mActionBar != null || mActivity.getActionBar() == null)
        {
            return;
        } else
        {
            mActionBar = new ActionBarWrapper(mActivity);
            return;
        }
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        (new StringBuilder()).append("[addContentView] view: ").append(view).append(", params: ").append(layoutparams).toString();
        mActivity.getWindow().addContentView(view, layoutparams);
        initActionBar();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu)
    {
        (new StringBuilder()).append("[dispatchCreateOptionsMenu] menu: ").append(menu).toString();
        if (mMenu == null || menu != mMenu.unwrap())
        {
            mMenu = new MenuWrapper(menu);
        }
        boolean flag = callbackCreateOptionsMenu(mMenu);
        (new StringBuilder()).append("[dispatchCreateOptionsMenu] returning ").append(flag).toString();
        return flag;
    }

    public void dispatchInvalidateOptionsMenu()
    {
        mActivity.getWindow().invalidatePanelMenu(0);
        if (mMenu != null)
        {
            mMenu.invalidate();
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuitem)
    {
        (new StringBuilder()).append("[dispatchOptionsItemSelected] item: ").append(menuitem.getTitleCondensed()).toString();
        boolean flag;
        if (mMenu == null)
        {
            if (menuitem.getItemId() != 0x102002c)
            {
                throw new IllegalStateException((new StringBuilder()).append("Non-home action item clicked before onCreateOptionsMenu with ID ").append(menuitem.getItemId()).toString());
            }
            menuitem = new MenuItemWrapper(menuitem);
        } else
        {
            menuitem = mMenu.findItem(menuitem);
        }
        flag = callbackOptionsItemSelected(menuitem);
        (new StringBuilder()).append("[dispatchOptionsItemSelected] returning ").append(flag).toString();
        return flag;
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu)
    {
        (new StringBuilder()).append("[dispatchPrepareOptionsMenu] menu: ").append(menu).toString();
        boolean flag = callbackPrepareOptionsMenu(mMenu);
        (new StringBuilder()).append("[dispatchPrepareOptionsMenu] returning ").append(flag).toString();
        return flag;
    }

    public ActionBar getActionBar()
    {
        initActionBar();
        return mActionBar;
    }

    protected Context getThemedContext()
    {
        Activity activity = mActivity;
        TypedValue typedvalue = new TypedValue();
        mActivity.getTheme().resolveAttribute(0x1010397, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            return new ContextThemeWrapper(activity, typedvalue.resourceId);
        } else
        {
            return activity;
        }
    }

    public boolean hasFeature(int i)
    {
        (new StringBuilder()).append("[hasFeature] feature: ").append(i).toString();
        boolean flag = mActivity.getWindow().hasFeature(i);
        (new StringBuilder()).append("[hasFeature] returning ").append(flag).toString();
        return flag;
    }

    public boolean requestFeature(int i)
    {
        (new StringBuilder()).append("[requestFeature] featureId: ").append(i).toString();
        boolean flag = mActivity.getWindow().requestFeature(i);
        (new StringBuilder()).append("[requestFeature] returning ").append(flag).toString();
        return flag;
    }

    public void setContentView(int i)
    {
        (new StringBuilder()).append("[setContentView] layoutResId: ").append(i).toString();
        mActivity.getWindow().setContentView(i);
        initActionBar();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        (new StringBuilder()).append("[setContentView] view: ").append(view).append(", params: ").append(layoutparams).toString();
        mActivity.getWindow().setContentView(view, layoutparams);
        initActionBar();
    }

    public void setProgress(int i)
    {
        (new StringBuilder()).append("[setProgress] progress: ").append(i).toString();
        mActivity.setProgress(i);
    }

    public void setProgressBarIndeterminate(boolean flag)
    {
        (new StringBuilder()).append("[setProgressBarIndeterminate] indeterminate: ").append(flag).toString();
        mActivity.setProgressBarIndeterminate(flag);
    }

    public void setProgressBarIndeterminateVisibility(boolean flag)
    {
        (new StringBuilder()).append("[setProgressBarIndeterminateVisibility] visible: ").append(flag).toString();
        mActivity.setProgressBarIndeterminateVisibility(flag);
    }

    public void setProgressBarVisibility(boolean flag)
    {
        (new StringBuilder()).append("[setProgressBarVisibility] visible: ").append(flag).toString();
        mActivity.setProgressBarVisibility(flag);
    }

    public void setSecondaryProgress(int i)
    {
        (new StringBuilder()).append("[setSecondaryProgress] secondaryProgress: ").append(i).toString();
        mActivity.setSecondaryProgress(i);
    }

    public void setTitle(CharSequence charsequence)
    {
        (new StringBuilder()).append("[setTitle] title: ").append(charsequence).toString();
        mActivity.getWindow().setTitle(charsequence);
    }

    public void setUiOptions(int i)
    {
        (new StringBuilder()).append("[setUiOptions] uiOptions: ").append(i).toString();
        mActivity.getWindow().setUiOptions(i);
    }

    public void setUiOptions(int i, int j)
    {
        (new StringBuilder()).append("[setUiOptions] uiOptions: ").append(i).append(", mask: ").append(j).toString();
        mActivity.getWindow().setUiOptions(i, j);
    }

    public ActionMode startActionMode(com.actionbarsherlock.view.ActionMode.Callback callback)
    {
        (new StringBuilder()).append("[startActionMode] callback: ").append(callback).toString();
        if (mActionMode != null)
        {
            mActionMode.finish();
        }
        if (callback != null)
        {
            callback = new ActionModeCallbackWrapper(callback);
        } else
        {
            callback = null;
        }
        if (mActivity.startActionMode(callback) == null)
        {
            mActionMode = null;
        }
        if ((mActivity instanceof com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener) && mActionMode != null)
        {
            ((com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener)mActivity).onActionModeStarted(mActionMode);
        }
        return mActionMode;
    }



/*
    static ActionModeWrapper access$002(ActionBarSherlockNative actionbarsherlocknative, ActionModeWrapper actionmodewrapper)
    {
        actionbarsherlocknative.mActionMode = actionmodewrapper;
        return actionmodewrapper;
    }

*/



    private class ActionModeWrapper extends ActionMode
    {

        private final android.view.ActionMode mActionMode;
        private MenuWrapper mMenu;
        final ActionBarSherlockNative this$0;

        public void finish()
        {
            mActionMode.finish();
        }

        public View getCustomView()
        {
            return mActionMode.getCustomView();
        }

        public MenuWrapper getMenu()
        {
            if (mMenu == null)
            {
                mMenu = new MenuWrapper(mActionMode.getMenu());
            }
            return mMenu;
        }

        public volatile com.actionbarsherlock.view.Menu getMenu()
        {
            return getMenu();
        }

        public MenuInflater getMenuInflater()
        {
            return ActionBarSherlockNative.this.getMenuInflater();
        }

        public CharSequence getSubtitle()
        {
            return mActionMode.getSubtitle();
        }

        public Object getTag()
        {
            return mActionMode.getTag();
        }

        public CharSequence getTitle()
        {
            return mActionMode.getTitle();
        }

        public void invalidate()
        {
            mActionMode.invalidate();
            if (mMenu != null)
            {
                mMenu.invalidate();
            }
        }

        public void setCustomView(View view)
        {
            mActionMode.setCustomView(view);
        }

        public void setSubtitle(int i)
        {
            mActionMode.setSubtitle(i);
        }

        public void setSubtitle(CharSequence charsequence)
        {
            mActionMode.setSubtitle(charsequence);
        }

        public void setTag(Object obj)
        {
            mActionMode.setTag(obj);
        }

        public void setTitle(int i)
        {
            mActionMode.setTitle(i);
        }

        public void setTitle(CharSequence charsequence)
        {
            mActionMode.setTitle(charsequence);
        }

        ActionModeWrapper(android.view.ActionMode actionmode)
        {
            this$0 = ActionBarSherlockNative.this;
            super();
            mMenu = null;
            mActionMode = actionmode;
        }
    }


    private class ActionModeCallbackWrapper
        implements android.view.ActionMode.Callback
    {

        private final com.actionbarsherlock.view.ActionMode.Callback mCallback;
        final ActionBarSherlockNative this$0;

        public boolean onActionItemClicked(android.view.ActionMode actionmode, MenuItem menuitem)
        {
            return mCallback.onActionItemClicked(mActionMode, mActionMode.getMenu().findItem(menuitem));
        }

        public boolean onCreateActionMode(android.view.ActionMode actionmode, Menu menu)
        {
            mActionMode = new ActionModeWrapper(actionmode);
            return mCallback.onCreateActionMode(mActionMode, mActionMode.getMenu());
        }

        public void onDestroyActionMode(android.view.ActionMode actionmode)
        {
            mCallback.onDestroyActionMode(mActionMode);
            if (ActionBarSherlockNative.this.ActionBarSherlockNative$ActionModeWrapper instanceof com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener)
            {
                ((com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener)ActionBarSherlockNative.this.ActionBarSherlockNative$ActionModeWrapper).onActionModeFinished(mActionMode);
            }
        }

        public boolean onPrepareActionMode(android.view.ActionMode actionmode, Menu menu)
        {
            return mCallback.onPrepareActionMode(mActionMode, mActionMode.getMenu());
        }

        public ActionModeCallbackWrapper(com.actionbarsherlock.view.ActionMode.Callback callback)
        {
            this$0 = ActionBarSherlockNative.this;
            super();
            mCallback = callback;
        }
    }

}
