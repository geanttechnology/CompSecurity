// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegate, ActionBar, AppCompatCallback

abstract class AppCompatDelegateImplBase extends AppCompatDelegate
{

    ActionBar mActionBar;
    final AppCompatCallback mAppCompatCallback;
    final android.view.Window.Callback mAppCompatWindowCallback;
    final Context mContext;
    boolean mHasActionBar;
    private boolean mIsDestroyed;
    boolean mIsFloating;
    MenuInflater mMenuInflater;
    final android.view.Window.Callback mOriginalWindowCallback;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private CharSequence mTitle;
    final Window mWindow;
    boolean mWindowNoTitle;

    AppCompatDelegateImplBase(Context context, Window window, AppCompatCallback appcompatcallback)
    {
        mContext = context;
        mWindow = window;
        mAppCompatCallback = appcompatcallback;
        mOriginalWindowCallback = mWindow.getCallback();
        if (mOriginalWindowCallback instanceof AppCompatWindowCallbackBase)
        {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        } else
        {
            mAppCompatWindowCallback = wrapWindowCallback(mOriginalWindowCallback);
            mWindow.setCallback(mAppCompatWindowCallback);
            return;
        }
    }

    abstract boolean dispatchKeyEvent(KeyEvent keyevent);

    final Context getActionBarThemedContext()
    {
        Context context = null;
        Object obj = getSupportActionBar();
        if (obj != null)
        {
            context = ((ActionBar) (obj)).getThemedContext();
        }
        obj = context;
        if (context == null)
        {
            obj = mContext;
        }
        return ((Context) (obj));
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
    {
        return new ActionBarDrawableToggleImpl(null);
    }

    public MenuInflater getMenuInflater()
    {
        if (mMenuInflater == null)
        {
            initWindowDecorActionBar();
            Context context;
            if (mActionBar != null)
            {
                context = mActionBar.getThemedContext();
            } else
            {
                context = mContext;
            }
            mMenuInflater = new SupportMenuInflater(context);
        }
        return mMenuInflater;
    }

    public ActionBar getSupportActionBar()
    {
        initWindowDecorActionBar();
        return mActionBar;
    }

    final CharSequence getTitle()
    {
        if (mOriginalWindowCallback instanceof Activity)
        {
            return ((Activity)mOriginalWindowCallback).getTitle();
        } else
        {
            return mTitle;
        }
    }

    final android.view.Window.Callback getWindowCallback()
    {
        return mWindow.getCallback();
    }

    abstract void initWindowDecorActionBar();

    final boolean isDestroyed()
    {
        return mIsDestroyed;
    }

    public boolean isHandleNativeActionModesEnabled()
    {
        return false;
    }

    public final void onDestroy()
    {
        mIsDestroyed = true;
    }

    abstract boolean onKeyShortcut(int i, KeyEvent keyevent);

    abstract boolean onMenuOpened(int i, Menu menu);

    abstract void onPanelClosed(int i, Menu menu);

    abstract void onTitleChanged(CharSequence charsequence);

    final ActionBar peekSupportActionBar()
    {
        return mActionBar;
    }

    public final void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        onTitleChanged(charsequence);
    }

    abstract ActionMode startSupportActionModeFromWindow(android.support.v7.view.ActionMode.Callback callback);

    android.view.Window.Callback wrapWindowCallback(android.view.Window.Callback callback)
    {
        return new AppCompatWindowCallbackBase(callback);
    }

    private class AppCompatWindowCallbackBase extends WindowCallbackWrapper
    {

        final AppCompatDelegateImplBase this$0;

        public boolean dispatchKeyEvent(KeyEvent keyevent)
        {
            return AppCompatDelegateImplBase.this.dispatchKeyEvent(keyevent) || super.dispatchKeyEvent(keyevent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
        {
            return super.dispatchKeyShortcutEvent(keyevent) || onKeyShortcut(keyevent.getKeyCode(), keyevent);
        }

        public void onContentChanged()
        {
        }

        public boolean onCreatePanelMenu(int j, Menu menu)
        {
            if (j == 0 && !(menu instanceof i))
            {
                return false;
            } else
            {
                return super.onCreatePanelMenu(j, menu);
            }
        }

        public boolean onMenuOpened(int j, Menu menu)
        {
            return super.onMenuOpened(j, menu) || AppCompatDelegateImplBase.this.onMenuOpened(j, menu);
        }

        public void onPanelClosed(int j, Menu menu)
        {
            super.onPanelClosed(j, menu);
            AppCompatDelegateImplBase.this.onPanelClosed(j, menu);
        }

        public boolean onPreparePanel(int j, View view, Menu menu)
        {
            i k;
            boolean flag;
            if (menu instanceof i)
            {
                k = (i)menu;
            } else
            {
                k = null;
            }
            if (j == 0 && k == null)
            {
                flag = false;
            } else
            {
                if (k != null)
                {
                    k.c(true);
                }
                boolean flag1 = super.onPreparePanel(j, view, menu);
                flag = flag1;
                if (k != null)
                {
                    k.c(false);
                    return flag1;
                }
            }
            return flag;
        }

        AppCompatWindowCallbackBase(android.view.Window.Callback callback)
        {
            this$0 = AppCompatDelegateImplBase.this;
            super(callback);
        }
    }


    private class ActionBarDrawableToggleImpl
        implements ActionBarDrawerToggle.Delegate
    {

        final AppCompatDelegateImplBase this$0;

        public void setActionBarDescription(int i)
        {
            ActionBar actionbar = getSupportActionBar();
            if (actionbar != null)
            {
                actionbar.setHomeActionContentDescription(i);
            }
        }

        private ActionBarDrawableToggleImpl()
        {
            this$0 = AppCompatDelegateImplBase.this;
            super();
        }

        ActionBarDrawableToggleImpl(_cls1 _pcls1)
        {
            this();
        }
    }

}
