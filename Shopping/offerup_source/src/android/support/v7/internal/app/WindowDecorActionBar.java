// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.bi;
import android.support.v4.view.cx;
import android.support.v4.view.dk;
import android.support.v4.view.dm;
import android.support.v7.app.ActionBar;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class WindowDecorActionBar extends ActionBar
    implements android.support.v7.internal.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
{

    static final boolean $assertionsDisabled;
    private static final boolean ALLOW_SHOW_HIDE_ANIMATIONS;
    private static final Interpolator sHideInterpolator = new AccelerateInterpolator();
    private static final Interpolator sShowInterpolator = new DecelerateInterpolator();
    ActionModeImpl mActionMode;
    private Activity mActivity;
    private ActionBarContainer mContainerView;
    private boolean mContentAnimations;
    private View mContentView;
    private Context mContext;
    private ActionBarContextView mContextView;
    private int mCurWindowVisibility;
    private ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    private DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    android.support.v7.view.ActionMode.Callback mDeferredModeDestroyCallback;
    private Dialog mDialog;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    private boolean mHiddenByApp;
    private boolean mHiddenBySystem;
    final dk mHideListener;
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList mMenuVisibilityListeners;
    private boolean mNowShowing;
    private ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition;
    private boolean mShowHideAnimationEnabled;
    final dk mShowListener;
    private boolean mShowingForMode;
    private ScrollingTabContainerView mTabScrollView;
    private ArrayList mTabs;
    private Context mThemedContext;
    final dm mUpdateListener;

    public WindowDecorActionBar(Activity activity, boolean flag)
    {
        mTabs = new ArrayList();
        mSavedTabPosition = -1;
        mMenuVisibilityListeners = new ArrayList();
        mCurWindowVisibility = 0;
        mContentAnimations = true;
        mNowShowing = true;
        mHideListener = new _cls1();
        mShowListener = new _cls2();
        mUpdateListener = new _cls3();
        mActivity = activity;
        activity = activity.getWindow().getDecorView();
        init(activity);
        if (!flag)
        {
            mContentView = activity.findViewById(0x1020002);
        }
    }

    public WindowDecorActionBar(Dialog dialog)
    {
        mTabs = new ArrayList();
        mSavedTabPosition = -1;
        mMenuVisibilityListeners = new ArrayList();
        mCurWindowVisibility = 0;
        mContentAnimations = true;
        mNowShowing = true;
        mHideListener = new _cls1();
        mShowListener = new _cls2();
        mUpdateListener = new _cls3();
        mDialog = dialog;
        init(dialog.getWindow().getDecorView());
    }

    private static boolean checkShowingFlags(boolean flag, boolean flag1, boolean flag2)
    {
        while (flag2 || !flag && !flag1) 
        {
            return true;
        }
        return false;
    }

    private DecorToolbar getDecorToolbar(View view)
    {
        if (view instanceof DecorToolbar)
        {
            return (DecorToolbar)view;
        }
        if (view instanceof Toolbar)
        {
            return ((Toolbar)view).getWrapper();
        }
        if ((new StringBuilder("Can't make a decor toolbar out of ")).append(view).toString() != null)
        {
            view = view.getClass().getSimpleName();
        } else
        {
            view = "null";
        }
        throw new IllegalStateException(view);
    }

    private void hideForActionMode()
    {
        if (mShowingForMode)
        {
            mShowingForMode = false;
            if (mOverlayLayout != null)
            {
                mOverlayLayout.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
    }

    private void init(View view)
    {
        mOverlayLayout = (ActionBarOverlayLayout)view.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
        if (mOverlayLayout != null)
        {
            mOverlayLayout.setActionBarVisibilityCallback(this);
        }
        mDecorToolbar = getDecorToolbar(view.findViewById(android.support.v7.appcompat.R.id.action_bar));
        mContextView = (ActionBarContextView)view.findViewById(android.support.v7.appcompat.R.id.action_context_bar);
        mContainerView = (ActionBarContainer)view.findViewById(android.support.v7.appcompat.R.id.action_bar_container);
        if (mDecorToolbar == null || mContextView == null || mContainerView == null)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used with a compatible window decor layout").toString());
        }
        mContext = mDecorToolbar.getContext();
        int i;
        boolean flag;
        if ((mDecorToolbar.getDisplayOptions() & 4) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            mDisplayHomeAsUpSet = true;
        }
        view = ActionBarPolicy.get(mContext);
        if (view.enableHomeButtonByDefault() || i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setHomeButtonEnabled(flag);
        setHasEmbeddedTabs(view.hasEmbeddedTabs());
        view = mContext.obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.ActionBar, android.support.v7.appcompat.R.attr.actionBarStyle, 0);
        if (view.getBoolean(android.support.v7.appcompat.R.styleable.ActionBar_hideOnContentScroll, false))
        {
            setHideOnContentScrollEnabled(true);
        }
        i = view.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.ActionBar_elevation, 0);
        if (i != 0)
        {
            setElevation(i);
        }
        view.recycle();
    }

    private void setHasEmbeddedTabs(boolean flag)
    {
        boolean flag2 = true;
        mHasEmbeddedTabs = flag;
        Object obj;
        boolean flag1;
        if (!mHasEmbeddedTabs)
        {
            mDecorToolbar.setEmbeddedTabView(null);
            mContainerView.setTabContainer(mTabScrollView);
        } else
        {
            mContainerView.setTabContainer(null);
            mDecorToolbar.setEmbeddedTabView(mTabScrollView);
        }
        if (getNavigationMode() == 2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (mTabScrollView != null)
        {
            if (flag1)
            {
                mTabScrollView.setVisibility(0);
                if (mOverlayLayout != null)
                {
                    bi.u(mOverlayLayout);
                }
            } else
            {
                mTabScrollView.setVisibility(8);
            }
        }
        obj = mDecorToolbar;
        if (!mHasEmbeddedTabs && flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((DecorToolbar) (obj)).setCollapsible(flag);
        obj = mOverlayLayout;
        if (!mHasEmbeddedTabs && flag1)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        ((ActionBarOverlayLayout) (obj)).setHasNonEmbeddedTabs(flag);
    }

    private void showForActionMode()
    {
        if (!mShowingForMode)
        {
            mShowingForMode = true;
            if (mOverlayLayout != null)
            {
                mOverlayLayout.setShowingForActionMode(true);
            }
            updateVisibility(false);
        }
    }

    private void updateVisibility(boolean flag)
    {
        if (checkShowingFlags(mHiddenByApp, mHiddenBySystem, mShowingForMode))
        {
            if (!mNowShowing)
            {
                mNowShowing = true;
                doShow(flag);
            }
        } else
        if (mNowShowing)
        {
            mNowShowing = false;
            doHide(flag);
            return;
        }
    }

    public void animateToMode(boolean flag)
    {
        cx cx1;
        cx cx2;
        ViewPropertyAnimatorCompatSet viewpropertyanimatorcompatset;
        if (flag)
        {
            showForActionMode();
        } else
        {
            hideForActionMode();
        }
        if (flag)
        {
            cx1 = mDecorToolbar.setupAnimatorToVisibility(8, 100L);
            cx2 = mContextView.setupAnimatorToVisibility(0, 200L);
        } else
        {
            cx2 = mDecorToolbar.setupAnimatorToVisibility(0, 200L);
            cx1 = mContextView.setupAnimatorToVisibility(8, 100L);
        }
        viewpropertyanimatorcompatset = new ViewPropertyAnimatorCompatSet();
        viewpropertyanimatorcompatset.playSequentially(cx1, cx2);
        viewpropertyanimatorcompatset.start();
    }

    public boolean collapseActionView()
    {
        if (mDecorToolbar != null && mDecorToolbar.hasExpandedActionView())
        {
            mDecorToolbar.collapseActionView();
            return true;
        } else
        {
            return false;
        }
    }

    void completeDeferredDestroyActionMode()
    {
        if (mDeferredModeDestroyCallback != null)
        {
            mDeferredModeDestroyCallback.onDestroyActionMode(mDeferredDestroyActionMode);
            mDeferredDestroyActionMode = null;
            mDeferredModeDestroyCallback = null;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean flag)
    {
        if (flag != mLastMenuVisibility)
        {
            mLastMenuVisibility = flag;
            int j = mMenuVisibilityListeners.size();
            int i = 0;
            while (i < j) 
            {
                ((android.support.v7.app.ActionBar.OnMenuVisibilityListener)mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(flag);
                i++;
            }
        }
    }

    public void doHide(boolean flag)
    {
        if (mCurrentShowAnim != null)
        {
            mCurrentShowAnim.cancel();
        }
        if (mCurWindowVisibility == 0 && ALLOW_SHOW_HIDE_ANIMATIONS && (mShowHideAnimationEnabled || flag))
        {
            bi.c(mContainerView, 1.0F);
            mContainerView.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewpropertyanimatorcompatset = new ViewPropertyAnimatorCompatSet();
            float f1 = -mContainerView.getHeight();
            float f = f1;
            if (flag)
            {
                int ai[] = new int[2];
                int[] _tmp = ai;
                ai[0] = 0;
                ai[1] = 0;
                mContainerView.getLocationInWindow(ai);
                f = f1 - (float)ai[1];
            }
            cx cx1 = bi.q(mContainerView).c(f);
            cx1.a(mUpdateListener);
            viewpropertyanimatorcompatset.play(cx1);
            if (mContentAnimations && mContentView != null)
            {
                viewpropertyanimatorcompatset.play(bi.q(mContentView).c(f));
            }
            viewpropertyanimatorcompatset.setInterpolator(sHideInterpolator);
            viewpropertyanimatorcompatset.setDuration(250L);
            viewpropertyanimatorcompatset.setListener(mHideListener);
            mCurrentShowAnim = viewpropertyanimatorcompatset;
            viewpropertyanimatorcompatset.start();
            return;
        } else
        {
            mHideListener.onAnimationEnd(null);
            return;
        }
    }

    public void doShow(boolean flag)
    {
        if (mCurrentShowAnim != null)
        {
            mCurrentShowAnim.cancel();
        }
        mContainerView.setVisibility(0);
        if (mCurWindowVisibility == 0 && ALLOW_SHOW_HIDE_ANIMATIONS && (mShowHideAnimationEnabled || flag))
        {
            bi.b(mContainerView, 0.0F);
            float f1 = -mContainerView.getHeight();
            float f = f1;
            if (flag)
            {
                int ai[] = new int[2];
                int[] _tmp = ai;
                ai[0] = 0;
                ai[1] = 0;
                mContainerView.getLocationInWindow(ai);
                f = f1 - (float)ai[1];
            }
            bi.b(mContainerView, f);
            ViewPropertyAnimatorCompatSet viewpropertyanimatorcompatset = new ViewPropertyAnimatorCompatSet();
            cx cx1 = bi.q(mContainerView).c(0.0F);
            cx1.a(mUpdateListener);
            viewpropertyanimatorcompatset.play(cx1);
            if (mContentAnimations && mContentView != null)
            {
                bi.b(mContentView, f);
                viewpropertyanimatorcompatset.play(bi.q(mContentView).c(0.0F));
            }
            viewpropertyanimatorcompatset.setInterpolator(sShowInterpolator);
            viewpropertyanimatorcompatset.setDuration(250L);
            viewpropertyanimatorcompatset.setListener(mShowListener);
            mCurrentShowAnim = viewpropertyanimatorcompatset;
            viewpropertyanimatorcompatset.start();
        } else
        {
            bi.c(mContainerView, 1.0F);
            bi.b(mContainerView, 0.0F);
            if (mContentAnimations && mContentView != null)
            {
                bi.b(mContentView, 0.0F);
            }
            mShowListener.onAnimationEnd(null);
        }
        if (mOverlayLayout != null)
        {
            bi.u(mOverlayLayout);
        }
    }

    public void enableContentAnimations(boolean flag)
    {
        mContentAnimations = flag;
    }

    public int getDisplayOptions()
    {
        return mDecorToolbar.getDisplayOptions();
    }

    public int getNavigationMode()
    {
        return mDecorToolbar.getNavigationMode();
    }

    public Context getThemedContext()
    {
        if (mThemedContext == null)
        {
            TypedValue typedvalue = new TypedValue();
            mContext.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedvalue, true);
            int i = typedvalue.resourceId;
            if (i != 0)
            {
                mThemedContext = new ContextThemeWrapper(mContext, i);
            } else
            {
                mThemedContext = mContext;
            }
        }
        return mThemedContext;
    }

    public void hide()
    {
        if (!mHiddenByApp)
        {
            mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    public void hideForSystem()
    {
        if (!mHiddenBySystem)
        {
            mHiddenBySystem = true;
            updateVisibility(true);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        setHasEmbeddedTabs(ActionBarPolicy.get(mContext).hasEmbeddedTabs());
    }

    public void onContentScrollStarted()
    {
        if (mCurrentShowAnim != null)
        {
            mCurrentShowAnim.cancel();
            mCurrentShowAnim = null;
        }
    }

    public void onContentScrollStopped()
    {
    }

    public void onWindowVisibilityChanged(int i)
    {
        mCurWindowVisibility = i;
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean flag)
    {
        if (!mDisplayHomeAsUpSet)
        {
            setDisplayHomeAsUpEnabled(flag);
        }
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

    public void setDisplayOptions(int i, int j)
    {
        int k = mDecorToolbar.getDisplayOptions();
        if ((j & 4) != 0)
        {
            mDisplayHomeAsUpSet = true;
        }
        mDecorToolbar.setDisplayOptions(k & ~j | i & j);
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
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        setDisplayOptions(i, 1);
    }

    public void setElevation(float f)
    {
        bi.f(mContainerView, f);
    }

    public void setHideOnContentScrollEnabled(boolean flag)
    {
        if (flag && !mOverlayLayout.isInOverlayMode())
        {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        } else
        {
            mHideOnContentScroll = flag;
            mOverlayLayout.setHideOnContentScrollEnabled(flag);
            return;
        }
    }

    public void setHomeActionContentDescription(int i)
    {
        mDecorToolbar.setNavigationContentDescription(i);
    }

    public void setHomeAsUpIndicator(int i)
    {
        mDecorToolbar.setNavigationIcon(i);
    }

    public void setHomeButtonEnabled(boolean flag)
    {
        mDecorToolbar.setHomeButtonEnabled(flag);
    }

    public void setLogo(int i)
    {
        mDecorToolbar.setLogo(i);
    }

    public void setShowHideAnimationEnabled(boolean flag)
    {
        mShowHideAnimationEnabled = flag;
        if (!flag && mCurrentShowAnim != null)
        {
            mCurrentShowAnim.cancel();
        }
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
        if (mHiddenByApp)
        {
            mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    public void showForSystem()
    {
        if (mHiddenBySystem)
        {
            mHiddenBySystem = false;
            updateVisibility(true);
        }
    }

    public ActionMode startActionMode(android.support.v7.view.ActionMode.Callback callback)
    {
        if (mActionMode != null)
        {
            mActionMode.finish();
        }
        mOverlayLayout.setHideOnContentScrollEnabled(false);
        mContextView.killMode();
        callback = new ActionModeImpl(mContextView.getContext(), callback);
        if (callback.dispatchOnCreate())
        {
            callback.invalidate();
            mContextView.initForMode(callback);
            animateToMode(true);
            mContextView.sendAccessibilityEvent(32);
            mActionMode = callback;
            return callback;
        } else
        {
            return null;
        }
    }

    static 
    {
        boolean flag1 = true;
        boolean flag;
        if (!android/support/v7/internal/app/WindowDecorActionBar.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ALLOW_SHOW_HIDE_ANIMATIONS = flag;
    }






/*
    static ViewPropertyAnimatorCompatSet access$302(WindowDecorActionBar windowdecoractionbar, ViewPropertyAnimatorCompatSet viewpropertyanimatorcompatset)
    {
        windowdecoractionbar.mCurrentShowAnim = viewpropertyanimatorcompatset;
        return viewpropertyanimatorcompatset;
    }

*/







    private class _cls1 extends dl
    {

        final WindowDecorActionBar this$0;

        public void onAnimationEnd(View view)
        {
            if (mContentAnimations && mContentView != null)
            {
                bi.b(mContentView, 0.0F);
                bi.b(mContainerView, 0.0F);
            }
            mContainerView.setVisibility(8);
            mContainerView.setTransitioning(false);
            mCurrentShowAnim = null;
            completeDeferredDestroyActionMode();
            if (mOverlayLayout != null)
            {
                bi.u(mOverlayLayout);
            }
        }

        _cls1()
        {
            this$0 = WindowDecorActionBar.this;
            super();
        }
    }


    private class _cls2 extends dl
    {

        final WindowDecorActionBar this$0;

        public void onAnimationEnd(View view)
        {
            mCurrentShowAnim = null;
            mContainerView.requestLayout();
        }

        _cls2()
        {
            this$0 = WindowDecorActionBar.this;
            super();
        }
    }


    private class _cls3
        implements dm
    {

        final WindowDecorActionBar this$0;

        public void onAnimationUpdate(View view)
        {
            ((View)mContainerView.getParent()).invalidate();
        }

        _cls3()
        {
            this$0 = WindowDecorActionBar.this;
            super();
        }
    }


    private class ActionModeImpl extends ActionMode
        implements j
    {

        private final Context mActionModeContext;
        private android.support.v7.view.ActionMode.Callback mCallback;
        private WeakReference mCustomView;
        private final i mMenu;
        final WindowDecorActionBar this$0;

        public boolean dispatchOnCreate()
        {
            mMenu.f();
            boolean flag = mCallback.onCreateActionMode(this, mMenu);
            mMenu.g();
            return flag;
            Exception exception;
            exception;
            mMenu.g();
            throw exception;
        }

        public void finish()
        {
            if (mActionMode != this)
            {
                return;
            }
            if (!WindowDecorActionBar.checkShowingFlags(mHiddenByApp, mHiddenBySystem, false))
            {
                mDeferredDestroyActionMode = this;
                mDeferredModeDestroyCallback = mCallback;
            } else
            {
                mCallback.onDestroyActionMode(this);
            }
            mCallback = null;
            animateToMode(false);
            mContextView.closeMode();
            mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
            mOverlayLayout.setHideOnContentScrollEnabled(mHideOnContentScroll);
            mActionMode = null;
        }

        public View getCustomView()
        {
            if (mCustomView != null)
            {
                return (View)mCustomView.get();
            } else
            {
                return null;
            }
        }

        public Menu getMenu()
        {
            return mMenu;
        }

        public MenuInflater getMenuInflater()
        {
            return new SupportMenuInflater(mActionModeContext);
        }

        public CharSequence getSubtitle()
        {
            return mContextView.getSubtitle();
        }

        public CharSequence getTitle()
        {
            return mContextView.getTitle();
        }

        public void invalidate()
        {
            if (mActionMode != this)
            {
                return;
            }
            mMenu.f();
            mCallback.onPrepareActionMode(this, mMenu);
            mMenu.g();
            return;
            Exception exception;
            exception;
            mMenu.g();
            throw exception;
        }

        public boolean isTitleOptional()
        {
            return mContextView.isTitleOptional();
        }

        public boolean onMenuItemSelected(i k, MenuItem menuitem)
        {
            if (mCallback != null)
            {
                return mCallback.onActionItemClicked(this, menuitem);
            } else
            {
                return false;
            }
        }

        public void onMenuModeChange(i k)
        {
            if (mCallback == null)
            {
                return;
            } else
            {
                invalidate();
                mContextView.showOverflowMenu();
                return;
            }
        }

        public void setCustomView(View view)
        {
            mContextView.setCustomView(view);
            mCustomView = new WeakReference(view);
        }

        public void setSubtitle(int k)
        {
            setSubtitle(((CharSequence) (mContext.getResources().getString(k))));
        }

        public void setSubtitle(CharSequence charsequence)
        {
            mContextView.setSubtitle(charsequence);
        }

        public void setTitle(int k)
        {
            setTitle(((CharSequence) (mContext.getResources().getString(k))));
        }

        public void setTitle(CharSequence charsequence)
        {
            mContextView.setTitle(charsequence);
        }

        public void setTitleOptionalHint(boolean flag)
        {
            super.setTitleOptionalHint(flag);
            mContextView.setTitleOptional(flag);
        }

        public ActionModeImpl(Context context, android.support.v7.view.ActionMode.Callback callback)
        {
            this$0 = WindowDecorActionBar.this;
            super();
            mActionModeContext = context;
            mCallback = callback;
            mMenu = (new i(context)).a(1);
            mMenu.a(this);
        }
    }

}
