// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.bi;
import android.support.v7.app.ActionBar;
import android.support.v7.internal.view.menu.g;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class ToolbarActionBar extends ActionBar
{

    private DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private g mListMenuPresenter;
    private boolean mMenuCallbackSet;
    private final android.support.v7.widget.Toolbar.OnMenuItemClickListener mMenuClicker = new _cls2();
    private final Runnable mMenuInvalidator = new _cls1();
    private ArrayList mMenuVisibilityListeners;
    private boolean mToolbarMenuPrepared;
    private android.view.Window.Callback mWindowCallback;

    public ToolbarActionBar(Toolbar toolbar, CharSequence charsequence, android.view.Window.Callback callback)
    {
        mMenuVisibilityListeners = new ArrayList();
        mDecorToolbar = new ToolbarWidgetWrapper(toolbar, false);
        mWindowCallback = new ToolbarCallbackWrapper(callback);
        mDecorToolbar.setWindowCallback(mWindowCallback);
        toolbar.setOnMenuItemClickListener(mMenuClicker);
        mDecorToolbar.setWindowTitle(charsequence);
    }

    private void ensureListMenuPresenter(Menu menu)
    {
        if (mListMenuPresenter == null && (menu instanceof i))
        {
            menu = (i)menu;
            Object obj = mDecorToolbar.getContext();
            TypedValue typedvalue = new TypedValue();
            android.content.res.Resources.Theme theme = ((Context) (obj)).getResources().newTheme();
            theme.setTo(((Context) (obj)).getTheme());
            theme.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarPopupTheme, typedvalue, true);
            if (typedvalue.resourceId != 0)
            {
                theme.applyStyle(typedvalue.resourceId, true);
            }
            theme.resolveAttribute(android.support.v7.appcompat.R.attr.panelMenuListTheme, typedvalue, true);
            if (typedvalue.resourceId != 0)
            {
                theme.applyStyle(typedvalue.resourceId, true);
            } else
            {
                theme.applyStyle(android.support.v7.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            obj = new ContextThemeWrapper(((Context) (obj)), 0);
            ((Context) (obj)).getTheme().setTo(theme);
            mListMenuPresenter = new g(((Context) (obj)), android.support.v7.appcompat.R.layout.abc_list_menu_item_layout);
            mListMenuPresenter.a(new PanelMenuPresenterCallback(null));
            menu.a(mListMenuPresenter);
        }
    }

    private View getListMenuView(Menu menu)
    {
        ensureListMenuPresenter(menu);
        while (menu == null || mListMenuPresenter == null || mListMenuPresenter.a().getCount() <= 0) 
        {
            return null;
        }
        return (View)mListMenuPresenter.a(mDecorToolbar.getViewGroup());
    }

    private Menu getMenu()
    {
        if (!mMenuCallbackSet)
        {
            mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(null), new MenuBuilderCallback(null));
            mMenuCallbackSet = true;
        }
        return mDecorToolbar.getMenu();
    }

    public boolean collapseActionView()
    {
        if (mDecorToolbar.hasExpandedActionView())
        {
            mDecorToolbar.collapseActionView();
            return true;
        } else
        {
            return false;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean flag)
    {
        if (flag != mLastMenuVisibility)
        {
            mLastMenuVisibility = flag;
            int k = mMenuVisibilityListeners.size();
            int j = 0;
            while (j < k) 
            {
                ((android.support.v7.app.ActionBar.OnMenuVisibilityListener)mMenuVisibilityListeners.get(j)).onMenuVisibilityChanged(flag);
                j++;
            }
        }
    }

    public int getDisplayOptions()
    {
        return mDecorToolbar.getDisplayOptions();
    }

    public Context getThemedContext()
    {
        return mDecorToolbar.getContext();
    }

    public android.view.Window.Callback getWrappedWindowCallback()
    {
        return mWindowCallback;
    }

    public void hide()
    {
        mDecorToolbar.setVisibility(8);
    }

    public boolean invalidateOptionsMenu()
    {
        mDecorToolbar.getViewGroup().removeCallbacks(mMenuInvalidator);
        bi.a(mDecorToolbar.getViewGroup(), mMenuInvalidator);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public boolean onKeyShortcut(int j, KeyEvent keyevent)
    {
        Menu menu = getMenu();
        if (menu != null)
        {
            int k;
            boolean flag;
            if (keyevent != null)
            {
                k = keyevent.getDeviceId();
            } else
            {
                k = -1;
            }
            if (KeyCharacterMap.load(k).getKeyboardType() != 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            menu.setQwertyMode(flag);
            menu.performShortcut(j, keyevent, 0);
        }
        return true;
    }

    void populateOptionsMenu()
    {
        i j;
        Menu menu = getMenu();
        if (menu instanceof i)
        {
            j = (i)menu;
        } else
        {
            j = null;
        }
        if (j != null)
        {
            j.f();
        }
        menu.clear();
        if (!mWindowCallback.onCreatePanelMenu(0, menu) || !mWindowCallback.onPreparePanel(0, null, menu))
        {
            menu.clear();
        }
        if (j != null)
        {
            j.g();
        }
        return;
        Exception exception;
        exception;
        if (j != null)
        {
            j.g();
        }
        throw exception;
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean flag)
    {
    }

    public void setDisplayHomeAsUpEnabled(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        setDisplayOptions(byte0, 4);
    }

    public void setDisplayOptions(int j, int k)
    {
        int l = mDecorToolbar.getDisplayOptions();
        mDecorToolbar.setDisplayOptions(l & ~k | j & k);
    }

    public void setDisplayShowHomeEnabled(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        setDisplayOptions(byte0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        setDisplayOptions(byte0, 8);
    }

    public void setDisplayUseLogoEnabled(boolean flag)
    {
        int j;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        setDisplayOptions(j, 1);
    }

    public void setElevation(float f)
    {
        bi.f(mDecorToolbar.getViewGroup(), f);
    }

    public void setHomeActionContentDescription(int j)
    {
        mDecorToolbar.setNavigationContentDescription(j);
    }

    public void setHomeAsUpIndicator(int j)
    {
        mDecorToolbar.setNavigationIcon(j);
    }

    public void setHomeButtonEnabled(boolean flag)
    {
    }

    public void setLogo(int j)
    {
        mDecorToolbar.setLogo(j);
    }

    public void setShowHideAnimationEnabled(boolean flag)
    {
    }

    public void setTitle(CharSequence charsequence)
    {
        mDecorToolbar.setTitle(charsequence);
    }

    public void setWindowTitle(CharSequence charsequence)
    {
        mDecorToolbar.setWindowTitle(charsequence);
    }

    public void show()
    {
        mDecorToolbar.setVisibility(0);
    }




/*
    static boolean access$202(ToolbarActionBar toolbaractionbar, boolean flag)
    {
        toolbaractionbar.mToolbarMenuPrepared = flag;
        return flag;
    }

*/



    private class _cls1
        implements Runnable
    {

        final ToolbarActionBar this$0;

        public void run()
        {
            populateOptionsMenu();
        }

        _cls1()
        {
            this$0 = ToolbarActionBar.this;
            super();
        }
    }


    private class _cls2
        implements android.support.v7.widget.Toolbar.OnMenuItemClickListener
    {

        final ToolbarActionBar this$0;

        public boolean onMenuItemClick(MenuItem menuitem)
        {
            return mWindowCallback.onMenuItemSelected(0, menuitem);
        }

        _cls2()
        {
            this$0 = ToolbarActionBar.this;
            super();
        }
    }


    private class ToolbarCallbackWrapper extends WindowCallbackWrapper
    {

        final ToolbarActionBar this$0;

        public View onCreatePanelView(int j)
        {
            j;
            JVM INSTR tableswitch 0 0: default 20
        //                       0 26;
               goto _L1 _L2
_L1:
            Menu menu;
            return super.onCreatePanelView(j);
_L2:
            if (onPreparePanel(j, null, menu = mDecorToolbar.getMenu()) && onMenuOpened(j, menu))
            {
                return getListMenuView(menu);
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public boolean onPreparePanel(int j, View view, Menu menu)
        {
            boolean flag = super.onPreparePanel(j, view, menu);
            if (flag && !mToolbarMenuPrepared)
            {
                mDecorToolbar.setMenuPrepared();
                mToolbarMenuPrepared = true;
            }
            return flag;
        }

        public ToolbarCallbackWrapper(android.view.Window.Callback callback)
        {
            this$0 = ToolbarActionBar.this;
            super(callback);
        }
    }


    private class PanelMenuPresenterCallback
        implements y
    {

        final ToolbarActionBar this$0;

        public final void onCloseMenu(i j, boolean flag)
        {
            if (mWindowCallback != null)
            {
                mWindowCallback.onPanelClosed(0, j);
            }
        }

        public final boolean onOpenSubMenu(i j)
        {
            if (j == null && mWindowCallback != null)
            {
                mWindowCallback.onMenuOpened(0, j);
            }
            return true;
        }

        private PanelMenuPresenterCallback()
        {
            this$0 = ToolbarActionBar.this;
            super();
        }

        PanelMenuPresenterCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ActionMenuPresenterCallback
        implements y
    {

        private boolean mClosingActionMenu;
        final ToolbarActionBar this$0;

        public final void onCloseMenu(i j, boolean flag)
        {
            if (mClosingActionMenu)
            {
                return;
            }
            mClosingActionMenu = true;
            mDecorToolbar.dismissPopupMenus();
            if (mWindowCallback != null)
            {
                mWindowCallback.onPanelClosed(108, j);
            }
            mClosingActionMenu = false;
        }

        public final boolean onOpenSubMenu(i j)
        {
            if (mWindowCallback != null)
            {
                mWindowCallback.onMenuOpened(108, j);
                return true;
            } else
            {
                return false;
            }
        }

        private ActionMenuPresenterCallback()
        {
            this$0 = ToolbarActionBar.this;
            super();
        }

        ActionMenuPresenterCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class MenuBuilderCallback
        implements j
    {

        final ToolbarActionBar this$0;

        public final boolean onMenuItemSelected(i k, MenuItem menuitem)
        {
            return false;
        }

        public final void onMenuModeChange(i k)
        {
            if (mWindowCallback != null)
            {
                if (mDecorToolbar.isOverflowMenuShowing())
                {
                    mWindowCallback.onPanelClosed(108, k);
                } else
                if (mWindowCallback.onPreparePanel(0, null, k))
                {
                    mWindowCallback.onMenuOpened(108, k);
                    return;
                }
            }
        }

        private MenuBuilderCallback()
        {
            this$0 = ToolbarActionBar.this;
            super();
        }

        MenuBuilderCallback(_cls1 _pcls1)
        {
            this();
        }
    }

}
