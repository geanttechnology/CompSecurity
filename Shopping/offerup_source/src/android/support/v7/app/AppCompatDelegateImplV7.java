// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.ba;
import android.support.v4.view.aa;
import android.support.v4.view.ag;
import android.support.v4.view.bi;
import android.support.v4.view.bv;
import android.support.v4.view.cx;
import android.support.v4.widget.am;
import android.support.v7.internal.app.AppCompatViewInflater;
import android.support.v7.internal.app.ToolbarActionBar;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.internal.view.StandaloneActionMode;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.support.v7.internal.widget.DecorContentParent;
import android.support.v7.internal.widget.FitWindowsViewGroup;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplBase, ActionBar, AppCompatCallback

class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase
    implements ag, j
{

    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private AppCompatViewInflater mAppCompatViewInflater;
    private boolean mClosingActionMenu;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    cx mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private int mInvalidatePanelMenuFeatures;
    private boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable = new _cls1();
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState mPanels[];
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    private ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private TextView mTitleView;
    private ViewGroup mWindowDecor;

    AppCompatDelegateImplV7(Context context, Window window, AppCompatCallback appcompatcallback)
    {
        super(context, window, appcompatcallback);
        mFadeAnim = null;
    }

    private void applyFixedSizeWindow()
    {
        ContentFrameLayout contentframelayout = (ContentFrameLayout)mSubDecor.findViewById(0x1020002);
        contentframelayout.setDecorPadding(mWindowDecor.getPaddingLeft(), mWindowDecor.getPaddingTop(), mWindowDecor.getPaddingRight(), mWindowDecor.getPaddingBottom());
        TypedArray typedarray = mContext.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.Theme);
        typedarray.getValue(android.support.v7.appcompat.R.styleable.Theme_windowMinWidthMajor, contentframelayout.getMinWidthMajor());
        typedarray.getValue(android.support.v7.appcompat.R.styleable.Theme_windowMinWidthMinor, contentframelayout.getMinWidthMinor());
        if (typedarray.hasValue(android.support.v7.appcompat.R.styleable.Theme_windowFixedWidthMajor))
        {
            typedarray.getValue(android.support.v7.appcompat.R.styleable.Theme_windowFixedWidthMajor, contentframelayout.getFixedWidthMajor());
        }
        if (typedarray.hasValue(android.support.v7.appcompat.R.styleable.Theme_windowFixedWidthMinor))
        {
            typedarray.getValue(android.support.v7.appcompat.R.styleable.Theme_windowFixedWidthMinor, contentframelayout.getFixedWidthMinor());
        }
        if (typedarray.hasValue(android.support.v7.appcompat.R.styleable.Theme_windowFixedHeightMajor))
        {
            typedarray.getValue(android.support.v7.appcompat.R.styleable.Theme_windowFixedHeightMajor, contentframelayout.getFixedHeightMajor());
        }
        if (typedarray.hasValue(android.support.v7.appcompat.R.styleable.Theme_windowFixedHeightMinor))
        {
            typedarray.getValue(android.support.v7.appcompat.R.styleable.Theme_windowFixedHeightMinor, contentframelayout.getFixedHeightMinor());
        }
        typedarray.recycle();
        contentframelayout.requestLayout();
    }

    private void callOnPanelClosed(int k, PanelFeatureState panelfeaturestate, Menu menu)
    {
        PanelFeatureState panelfeaturestate2 = panelfeaturestate;
        Object obj = menu;
        if (menu == null)
        {
            PanelFeatureState panelfeaturestate1 = panelfeaturestate;
            if (panelfeaturestate == null)
            {
                panelfeaturestate1 = panelfeaturestate;
                if (k >= 0)
                {
                    panelfeaturestate1 = panelfeaturestate;
                    if (k < mPanels.length)
                    {
                        panelfeaturestate1 = mPanels[k];
                    }
                }
            }
            panelfeaturestate2 = panelfeaturestate1;
            obj = menu;
            if (panelfeaturestate1 != null)
            {
                obj = panelfeaturestate1.menu;
                panelfeaturestate2 = panelfeaturestate1;
            }
        }
        while (panelfeaturestate2 != null && !panelfeaturestate2.isOpen || isDestroyed()) 
        {
            return;
        }
        mOriginalWindowCallback.onPanelClosed(k, ((Menu) (obj)));
    }

    private void checkCloseActionMenu(i k)
    {
        if (mClosingActionMenu)
        {
            return;
        }
        mClosingActionMenu = true;
        mDecorContentParent.dismissPopups();
        android.view.Window.Callback callback = getWindowCallback();
        if (callback != null && !isDestroyed())
        {
            callback.onPanelClosed(108, k);
        }
        mClosingActionMenu = false;
    }

    private void closePanel(int k)
    {
        closePanel(getPanelState(k, true), true);
    }

    private void closePanel(PanelFeatureState panelfeaturestate, boolean flag)
    {
        if (flag && panelfeaturestate.featureId == 0 && mDecorContentParent != null && mDecorContentParent.isOverflowMenuShowing())
        {
            checkCloseActionMenu(panelfeaturestate.menu);
        } else
        {
            WindowManager windowmanager = (WindowManager)mContext.getSystemService("window");
            if (windowmanager != null && panelfeaturestate.isOpen && panelfeaturestate.decorView != null)
            {
                windowmanager.removeView(panelfeaturestate.decorView);
                if (flag)
                {
                    callOnPanelClosed(panelfeaturestate.featureId, panelfeaturestate, null);
                }
            }
            panelfeaturestate.isPrepared = false;
            panelfeaturestate.isHandled = false;
            panelfeaturestate.isOpen = false;
            panelfeaturestate.shownPanelView = null;
            panelfeaturestate.refreshDecorView = true;
            if (mPreparedPanel == panelfeaturestate)
            {
                mPreparedPanel = null;
                return;
            }
        }
    }

    private ViewGroup createSubDecor()
    {
        Object obj = mContext.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.Theme);
        if (!((TypedArray) (obj)).hasValue(android.support.v7.appcompat.R.styleable.Theme_windowActionBar))
        {
            ((TypedArray) (obj)).recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (((TypedArray) (obj)).getBoolean(android.support.v7.appcompat.R.styleable.Theme_windowNoTitle, false))
        {
            requestWindowFeature(1);
        } else
        if (((TypedArray) (obj)).getBoolean(android.support.v7.appcompat.R.styleable.Theme_windowActionBar, false))
        {
            requestWindowFeature(108);
        }
        if (((TypedArray) (obj)).getBoolean(android.support.v7.appcompat.R.styleable.Theme_windowActionBarOverlay, false))
        {
            requestWindowFeature(109);
        }
        if (((TypedArray) (obj)).getBoolean(android.support.v7.appcompat.R.styleable.Theme_windowActionModeOverlay, false))
        {
            requestWindowFeature(10);
        }
        mIsFloating = ((TypedArray) (obj)).getBoolean(android.support.v7.appcompat.R.styleable.Theme_android_windowIsFloating, false);
        ((TypedArray) (obj)).recycle();
        obj = LayoutInflater.from(mContext);
        ViewGroup viewgroup;
        ContentFrameLayout contentframelayout;
        if (!mWindowNoTitle)
        {
            if (mIsFloating)
            {
                obj = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.appcompat.R.layout.abc_dialog_title_material, null);
                mOverlayActionBar = false;
                mHasActionBar = false;
            } else
            if (mHasActionBar)
            {
                obj = new TypedValue();
                mContext.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, ((TypedValue) (obj)), true);
                if (((TypedValue) (obj)).resourceId != 0)
                {
                    obj = new ContextThemeWrapper(mContext, ((TypedValue) (obj)).resourceId);
                } else
                {
                    obj = mContext;
                }
                obj = (ViewGroup)LayoutInflater.from(((Context) (obj))).inflate(android.support.v7.appcompat.R.layout.abc_screen_toolbar, null);
                mDecorContentParent = (DecorContentParent)((ViewGroup) (obj)).findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
                mDecorContentParent.setWindowCallback(getWindowCallback());
                if (mOverlayActionBar)
                {
                    mDecorContentParent.initFeature(109);
                }
                if (mFeatureProgress)
                {
                    mDecorContentParent.initFeature(2);
                }
                if (mFeatureIndeterminateProgress)
                {
                    mDecorContentParent.initFeature(5);
                }
            } else
            {
                obj = null;
            }
        } else
        {
            if (mOverlayActionMode)
            {
                obj = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.appcompat.R.layout.abc_screen_simple_overlay_action_mode, null);
            } else
            {
                obj = (ViewGroup)((LayoutInflater) (obj)).inflate(android.support.v7.appcompat.R.layout.abc_screen_simple, null);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                bi.a(((View) (obj)), new _cls2());
            } else
            {
                ((FitWindowsViewGroup)obj).setOnFitSystemWindowsListener(new _cls3());
            }
        }
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ")).append(mHasActionBar).append(", windowActionBarOverlay: ").append(mOverlayActionBar).append(", android:windowIsFloating: ").append(mIsFloating).append(", windowActionModeOverlay: ").append(mOverlayActionMode).append(", windowNoTitle: ").append(mWindowNoTitle).append(" }").toString());
        }
        if (mDecorContentParent == null)
        {
            mTitleView = (TextView)((ViewGroup) (obj)).findViewById(android.support.v7.appcompat.R.id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows(((View) (obj)));
        viewgroup = (ViewGroup)mWindow.findViewById(0x1020002);
        contentframelayout = (ContentFrameLayout)((ViewGroup) (obj)).findViewById(android.support.v7.appcompat.R.id.action_bar_activity_content);
        View view;
        for (; viewgroup.getChildCount() > 0; contentframelayout.addView(view))
        {
            view = viewgroup.getChildAt(0);
            viewgroup.removeViewAt(0);
        }

        mWindow.setContentView(((View) (obj)));
        viewgroup.setId(-1);
        contentframelayout.setId(0x1020002);
        if (viewgroup instanceof FrameLayout)
        {
            ((FrameLayout)viewgroup).setForeground(null);
        }
        return ((ViewGroup) (obj));
    }

    private void doInvalidatePanelMenu(int k)
    {
        PanelFeatureState panelfeaturestate = getPanelState(k, true);
        if (panelfeaturestate.menu != null)
        {
            Bundle bundle = new Bundle();
            panelfeaturestate.menu.c(bundle);
            if (bundle.size() > 0)
            {
                panelfeaturestate.frozenActionViewState = bundle;
            }
            panelfeaturestate.menu.f();
            panelfeaturestate.menu.clear();
        }
        panelfeaturestate.refreshMenuContent = true;
        panelfeaturestate.refreshDecorView = true;
        if ((k == 108 || k == 0) && mDecorContentParent != null)
        {
            PanelFeatureState panelfeaturestate1 = getPanelState(0, false);
            if (panelfeaturestate1 != null)
            {
                panelfeaturestate1.isPrepared = false;
                preparePanel(panelfeaturestate1, null);
            }
        }
    }

    private void endOnGoingFadeAnimation()
    {
        if (mFadeAnim != null)
        {
            mFadeAnim.b();
        }
    }

    private void ensureSubDecor()
    {
        if (!mSubDecorInstalled)
        {
            mSubDecor = createSubDecor();
            Object obj = getTitle();
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                onTitleChanged(((CharSequence) (obj)));
            }
            applyFixedSizeWindow();
            onSubDecorInstalled(mSubDecor);
            mSubDecorInstalled = true;
            obj = getPanelState(0, false);
            if (!isDestroyed() && (obj == null || ((PanelFeatureState) (obj)).menu == null))
            {
                invalidatePanelMenu(108);
            }
        }
    }

    private PanelFeatureState findMenuPanel(Menu menu)
    {
        PanelFeatureState apanelfeaturestate[] = mPanels;
        int k;
        int l;
        if (apanelfeaturestate != null)
        {
            k = apanelfeaturestate.length;
        } else
        {
            k = 0;
        }
        for (l = 0; l < k; l++)
        {
            PanelFeatureState panelfeaturestate = apanelfeaturestate[l];
            if (panelfeaturestate != null && panelfeaturestate.menu == menu)
            {
                return panelfeaturestate;
            }
        }

        return null;
    }

    private PanelFeatureState getPanelState(int k, boolean flag)
    {
        PanelFeatureState apanelfeaturestate[];
label0:
        {
            PanelFeatureState apanelfeaturestate1[] = mPanels;
            if (apanelfeaturestate1 != null)
            {
                apanelfeaturestate = apanelfeaturestate1;
                if (apanelfeaturestate1.length > k)
                {
                    break label0;
                }
            }
            apanelfeaturestate = new PanelFeatureState[k + 1];
            if (apanelfeaturestate1 != null)
            {
                System.arraycopy(apanelfeaturestate1, 0, apanelfeaturestate, 0, apanelfeaturestate1.length);
            }
            mPanels = apanelfeaturestate;
        }
        PanelFeatureState panelfeaturestate = apanelfeaturestate[k];
        if (panelfeaturestate == null)
        {
            panelfeaturestate = new PanelFeatureState(k);
            apanelfeaturestate[k] = panelfeaturestate;
            return panelfeaturestate;
        } else
        {
            return panelfeaturestate;
        }
    }

    private boolean initializePanelContent(PanelFeatureState panelfeaturestate)
    {
        if (panelfeaturestate.createdPanelView != null)
        {
            panelfeaturestate.shownPanelView = panelfeaturestate.createdPanelView;
            return true;
        }
        if (panelfeaturestate.menu == null)
        {
            return false;
        }
        if (mPanelMenuPresenterCallback == null)
        {
            mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(null);
        }
        panelfeaturestate.shownPanelView = (View)panelfeaturestate.getListMenuView(mPanelMenuPresenterCallback);
        return panelfeaturestate.shownPanelView != null;
    }

    private boolean initializePanelDecor(PanelFeatureState panelfeaturestate)
    {
        panelfeaturestate.setStyle(getActionBarThemedContext());
        panelfeaturestate.decorView = new ListMenuDecorView(panelfeaturestate.listPresenterContext);
        panelfeaturestate.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState panelfeaturestate)
    {
        Context context = mContext;
        if (panelfeaturestate.featureId != 0 && panelfeaturestate.featureId != 108 || mDecorContentParent == null) goto _L2; else goto _L1
_L1:
        Object obj;
        TypedValue typedvalue = new TypedValue();
        android.content.res.Resources.Theme theme1 = context.getTheme();
        theme1.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, typedvalue, true);
        obj = null;
        android.content.res.Resources.Theme theme;
        if (typedvalue.resourceId != 0)
        {
            obj = context.getResources().newTheme();
            ((android.content.res.Resources.Theme) (obj)).setTo(theme1);
            ((android.content.res.Resources.Theme) (obj)).applyStyle(typedvalue.resourceId, true);
            ((android.content.res.Resources.Theme) (obj)).resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedvalue, true);
        } else
        {
            theme1.resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedvalue, true);
        }
        theme = ((android.content.res.Resources.Theme) (obj));
        if (typedvalue.resourceId != 0)
        {
            theme = ((android.content.res.Resources.Theme) (obj));
            if (obj == null)
            {
                theme = context.getResources().newTheme();
                theme.setTo(theme1);
            }
            theme.applyStyle(typedvalue.resourceId, true);
        }
        if (theme == null) goto _L2; else goto _L3
_L3:
        obj = new ContextThemeWrapper(context, 0);
        ((Context) (obj)).getTheme().setTo(theme);
_L5:
        obj = new i(((Context) (obj)));
        ((i) (obj)).a(this);
        panelfeaturestate.setMenu(((i) (obj)));
        return true;
_L2:
        obj = context;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void invalidatePanelMenu(int k)
    {
        mInvalidatePanelMenuFeatures = mInvalidatePanelMenuFeatures | 1 << k;
        if (!mInvalidatePanelMenuPosted && mWindowDecor != null)
        {
            bi.a(mWindowDecor, mInvalidatePanelMenuRunnable);
            mInvalidatePanelMenuPosted = true;
        }
    }

    private boolean onKeyDownPanel(int k, KeyEvent keyevent)
    {
        if (keyevent.getRepeatCount() == 0)
        {
            PanelFeatureState panelfeaturestate = getPanelState(k, true);
            if (!panelfeaturestate.isOpen)
            {
                return preparePanel(panelfeaturestate, keyevent);
            }
        }
        return false;
    }

    private boolean onKeyUpPanel(int k, KeyEvent keyevent)
    {
        PanelFeatureState panelfeaturestate;
        boolean flag1;
        flag1 = true;
        if (mActionMode != null)
        {
            return false;
        }
        panelfeaturestate = getPanelState(k, true);
        if (k != 0 || mDecorContentParent == null || !mDecorContentParent.canShowOverflowMenu() || bv.b(ViewConfiguration.get(mContext))) goto _L2; else goto _L1
_L1:
        if (mDecorContentParent.isOverflowMenuShowing()) goto _L4; else goto _L3
_L3:
        if (isDestroyed() || !preparePanel(panelfeaturestate, keyevent)) goto _L6; else goto _L5
_L5:
        boolean flag = mDecorContentParent.showOverflowMenu();
_L8:
        if (flag)
        {
            keyevent = (AudioManager)mContext.getSystemService("audio");
            if (keyevent != null)
            {
                keyevent.playSoundEffect(0);
            } else
            {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return flag;
_L4:
        flag = mDecorContentParent.hideOverflowMenu();
        continue; /* Loop/switch isn't completed */
_L2:
        if (panelfeaturestate.isOpen || panelfeaturestate.isHandled)
        {
            flag = panelfeaturestate.isOpen;
            closePanel(panelfeaturestate, true);
            continue; /* Loop/switch isn't completed */
        }
        if (panelfeaturestate.isPrepared)
        {
            if (panelfeaturestate.refreshMenuContent)
            {
                panelfeaturestate.isPrepared = false;
                flag = preparePanel(panelfeaturestate, keyevent);
            } else
            {
                flag = true;
            }
            if (flag)
            {
                openPanel(panelfeaturestate, keyevent);
                flag = flag1;
                continue; /* Loop/switch isn't completed */
            }
        }
_L6:
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void openPanel(PanelFeatureState panelfeaturestate, KeyEvent keyevent)
    {
        byte byte0 = -1;
        if (!panelfeaturestate.isOpen && !isDestroyed()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (panelfeaturestate.featureId != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = mContext;
        boolean flag;
        boolean flag1;
        if ((((Context) (obj)).getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((Context) (obj)).getApplicationInfo().targetSdkVersion >= 11)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && flag1) goto _L1; else goto _L3
_L3:
        WindowManager windowmanager;
        obj = getWindowCallback();
        if (obj != null && !((android.view.Window.Callback) (obj)).onMenuOpened(panelfeaturestate.featureId, panelfeaturestate.menu))
        {
            closePanel(panelfeaturestate, true);
            return;
        }
        windowmanager = (WindowManager)mContext.getSystemService("window");
        if (windowmanager == null || !preparePanel(panelfeaturestate, keyevent)) goto _L1; else goto _L4
_L4:
        if (panelfeaturestate.decorView != null && !panelfeaturestate.refreshDecorView) goto _L6; else goto _L5
_L5:
        if (panelfeaturestate.decorView != null) goto _L8; else goto _L7
_L7:
        if (!initializePanelDecor(panelfeaturestate) || panelfeaturestate.decorView == null) goto _L1; else goto _L9
_L9:
        if (!initializePanelContent(panelfeaturestate) || !panelfeaturestate.hasPanelItems()) goto _L1; else goto _L10
_L10:
        int k;
        keyevent = panelfeaturestate.shownPanelView.getLayoutParams();
        if (keyevent == null)
        {
            keyevent = new android.view.ViewGroup.LayoutParams(-2, -2);
        }
        k = panelfeaturestate.background;
        panelfeaturestate.decorView.setBackgroundResource(k);
        ViewParent viewparent = panelfeaturestate.shownPanelView.getParent();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            ((ViewGroup)viewparent).removeView(panelfeaturestate.shownPanelView);
        }
        panelfeaturestate.decorView.addView(panelfeaturestate.shownPanelView, keyevent);
        if (!panelfeaturestate.shownPanelView.hasFocus())
        {
            panelfeaturestate.shownPanelView.requestFocus();
        }
        k = -2;
_L14:
        panelfeaturestate.isHandled = false;
        keyevent = new android.view.WindowManager.LayoutParams(k, -2, panelfeaturestate.x, panelfeaturestate.y, 1002, 0x820000, -3);
        keyevent.gravity = panelfeaturestate.gravity;
        keyevent.windowAnimations = panelfeaturestate.windowAnimations;
        windowmanager.addView(panelfeaturestate.decorView, keyevent);
        panelfeaturestate.isOpen = true;
        return;
_L8:
        if (panelfeaturestate.refreshDecorView && panelfeaturestate.decorView.getChildCount() > 0)
        {
            panelfeaturestate.decorView.removeAllViews();
        }
          goto _L9
_L6:
        if (panelfeaturestate.createdPanelView == null) goto _L12; else goto _L11
_L11:
        keyevent = panelfeaturestate.createdPanelView.getLayoutParams();
        if (keyevent == null) goto _L12; else goto _L13
_L13:
        k = byte0;
        if (((android.view.ViewGroup.LayoutParams) (keyevent)).width == -1) goto _L14; else goto _L12
_L12:
        k = -2;
          goto _L14
    }

    private boolean performPanelShortcut(PanelFeatureState panelfeaturestate, int k, KeyEvent keyevent, int l)
    {
        boolean flag;
        boolean flag2;
        flag2 = false;
        flag = false;
        if (!keyevent.isSystem()) goto _L2; else goto _L1
_L1:
        flag2 = flag;
_L4:
        return flag2;
_L2:
        boolean flag1;
label0:
        {
            if (!panelfeaturestate.isPrepared)
            {
                flag1 = flag2;
                if (!preparePanel(panelfeaturestate, keyevent))
                {
                    break label0;
                }
            }
            flag1 = flag2;
            if (panelfeaturestate.menu != null)
            {
                flag1 = panelfeaturestate.menu.performShortcut(k, keyevent, l);
            }
        }
        flag2 = flag1;
        if (flag1)
        {
            flag2 = flag1;
            if ((l & 1) == 0)
            {
                flag2 = flag1;
                if (mDecorContentParent == null)
                {
                    closePanel(panelfeaturestate, true);
                    return flag1;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean preparePanel(PanelFeatureState panelfeaturestate, KeyEvent keyevent)
    {
        if (!isDestroyed()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        android.view.Window.Callback callback;
        int k;
        if (panelfeaturestate.isPrepared)
        {
            return true;
        }
        if (mPreparedPanel != null && mPreparedPanel != panelfeaturestate)
        {
            closePanel(mPreparedPanel, false);
        }
        callback = getWindowCallback();
        if (callback != null)
        {
            panelfeaturestate.createdPanelView = callback.onCreatePanelView(panelfeaturestate.featureId);
        }
        if (panelfeaturestate.featureId == 0 || panelfeaturestate.featureId == 108)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (k && mDecorContentParent != null)
        {
            mDecorContentParent.setMenuPrepared();
        }
        if (panelfeaturestate.createdPanelView != null || k && (peekSupportActionBar() instanceof ToolbarActionBar))
        {
            break MISSING_BLOCK_LABEL_412;
        }
        if (panelfeaturestate.menu != null && !panelfeaturestate.refreshMenuContent)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        if (panelfeaturestate.menu == null && (!initializePanelMenu(panelfeaturestate) || panelfeaturestate.menu == null))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k && mDecorContentParent != null)
        {
            if (mActionMenuPresenterCallback == null)
            {
                mActionMenuPresenterCallback = new ActionMenuPresenterCallback(null);
            }
            mDecorContentParent.setMenu(panelfeaturestate.menu, mActionMenuPresenterCallback);
        }
        panelfeaturestate.menu.f();
        if (callback.onCreatePanelMenu(panelfeaturestate.featureId, panelfeaturestate.menu))
        {
            break; /* Loop/switch isn't completed */
        }
        panelfeaturestate.setMenu(null);
        if (k && mDecorContentParent != null)
        {
            mDecorContentParent.setMenu(null, mActionMenuPresenterCallback);
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        panelfeaturestate.refreshMenuContent = false;
        panelfeaturestate.menu.f();
        if (panelfeaturestate.frozenActionViewState != null)
        {
            panelfeaturestate.menu.d(panelfeaturestate.frozenActionViewState);
            panelfeaturestate.frozenActionViewState = null;
        }
        if (!callback.onPreparePanel(0, panelfeaturestate.createdPanelView, panelfeaturestate.menu))
        {
            if (k && mDecorContentParent != null)
            {
                mDecorContentParent.setMenu(null, mActionMenuPresenterCallback);
            }
            panelfeaturestate.menu.g();
            return false;
        }
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
        panelfeaturestate.qwertyMode = flag;
        panelfeaturestate.menu.setQwertyMode(panelfeaturestate.qwertyMode);
        panelfeaturestate.menu.g();
        panelfeaturestate.isPrepared = true;
        panelfeaturestate.isHandled = false;
        mPreparedPanel = panelfeaturestate;
        return true;
    }

    private void reopenMenu(i k, boolean flag)
    {
        if (mDecorContentParent == null || !mDecorContentParent.canShowOverflowMenu() || bv.b(ViewConfiguration.get(mContext)) && !mDecorContentParent.isOverflowMenuShowPending())
        {
            break MISSING_BLOCK_LABEL_211;
        }
        k = getWindowCallback();
        if (mDecorContentParent.isOverflowMenuShowing() && flag) goto _L2; else goto _L1
_L1:
        if (k != null && !isDestroyed())
        {
            if (mInvalidatePanelMenuPosted && (mInvalidatePanelMenuFeatures & 1) != 0)
            {
                mWindowDecor.removeCallbacks(mInvalidatePanelMenuRunnable);
                mInvalidatePanelMenuRunnable.run();
            }
            PanelFeatureState panelfeaturestate = getPanelState(0, true);
            if (panelfeaturestate.menu != null && !panelfeaturestate.refreshMenuContent && k.onPreparePanel(0, panelfeaturestate.createdPanelView, panelfeaturestate.menu))
            {
                k.onMenuOpened(108, panelfeaturestate.menu);
                mDecorContentParent.showOverflowMenu();
            }
        }
_L4:
        return;
_L2:
        mDecorContentParent.hideOverflowMenu();
        if (isDestroyed()) goto _L4; else goto _L3
_L3:
        k.onPanelClosed(108, getPanelState(0, true).menu);
        return;
        k = getPanelState(0, true);
        k.refreshDecorView = true;
        closePanel(k, false);
        openPanel(k, null);
        return;
    }

    private int sanitizeWindowFeatureId(int k)
    {
        int l;
        if (k == 8)
        {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            l = 108;
        } else
        {
            l = k;
            if (k == 9)
            {
                Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
                return 109;
            }
        }
        return l;
    }

    private boolean shouldInheritContext(ViewParent viewparent)
    {
        if (viewparent == null)
        {
            return false;
        }
        do
        {
            if (viewparent == null)
            {
                return true;
            }
            if (viewparent != mWindowDecor && (viewparent instanceof View) && !bi.D((View)viewparent))
            {
                viewparent = viewparent.getParent();
            } else
            {
                return false;
            }
        } while (true);
    }

    private void throwFeatureRequestIfSubDecorInstalled()
    {
        if (mSubDecorInstalled)
        {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        } else
        {
            return;
        }
    }

    private int updateStatusGuard(int k)
    {
        int i1 = 1;
        boolean flag = true;
        boolean flag1 = false;
        int l;
        if (mActionModeView != null && (mActionModeView.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams))
        {
            Object obj = (android.view.ViewGroup.MarginLayoutParams)mActionModeView.getLayoutParams();
            if (mActionModeView.isShown())
            {
                if (mTempRect1 == null)
                {
                    mTempRect1 = new Rect();
                    mTempRect2 = new Rect();
                }
                Rect rect = mTempRect1;
                Rect rect1 = mTempRect2;
                rect.set(0, k, 0, 0);
                ViewUtils.computeFitSystemWindows(mSubDecor, rect, rect1);
                if (rect1.top == 0)
                {
                    l = k;
                } else
                {
                    l = 0;
                }
                if (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin != l)
                {
                    obj.topMargin = k;
                    if (mStatusGuard == null)
                    {
                        mStatusGuard = new View(mContext);
                        mStatusGuard.setBackgroundColor(mContext.getResources().getColor(android.support.v7.appcompat.R.color.abc_input_method_navigation_guard));
                        mSubDecor.addView(mStatusGuard, -1, new android.view.ViewGroup.LayoutParams(-1, k));
                        l = 1;
                    } else
                    {
                        android.view.ViewGroup.LayoutParams layoutparams = mStatusGuard.getLayoutParams();
                        if (layoutparams.height != k)
                        {
                            layoutparams.height = k;
                            mStatusGuard.setLayoutParams(layoutparams);
                        }
                        l = 1;
                    }
                } else
                {
                    l = 0;
                }
                if (mStatusGuard == null)
                {
                    flag = false;
                }
                i1 = k;
                if (!mOverlayActionMode)
                {
                    i1 = k;
                    if (flag)
                    {
                        i1 = 0;
                    }
                }
                k = i1;
                i1 = l;
                l = ((flag) ? 1 : 0);
            } else
            if (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin != 0)
            {
                obj.topMargin = 0;
                l = 0;
            } else
            {
                i1 = 0;
                l = 0;
            }
            if (i1 != 0)
            {
                mActionModeView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            }
        } else
        {
            l = 0;
        }
        if (mStatusGuard != null)
        {
            obj = mStatusGuard;
            if (l != 0)
            {
                l = ((flag1) ? 1 : 0);
            } else
            {
                l = 8;
            }
            ((View) (obj)).setVisibility(l);
        }
        return k;
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        ensureSubDecor();
        ((ViewGroup)mSubDecor.findViewById(0x1020002)).addView(view, layoutparams);
        mOriginalWindowCallback.onContentChanged();
    }

    View callActivityOnCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        if (mOriginalWindowCallback instanceof android.view.LayoutInflater.Factory)
        {
            view = ((android.view.LayoutInflater.Factory)mOriginalWindowCallback).onCreateView(s, context, attributeset);
            if (view != null)
            {
                return view;
            }
        }
        return null;
    }

    public View createView(View view, String s, Context context, AttributeSet attributeset)
    {
        boolean flag;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mAppCompatViewInflater == null)
        {
            mAppCompatViewInflater = new AppCompatViewInflater();
        }
        if (flag && mSubDecorInstalled && shouldInheritContext((ViewParent)view))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return mAppCompatViewInflater.createView(view, s, context, attributeset, flag1, flag, true);
    }

    boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        boolean flag = true;
        if (keyevent.getKeyCode() == 82 && mOriginalWindowCallback.dispatchKeyEvent(keyevent))
        {
            return true;
        }
        int k = keyevent.getKeyCode();
        if (keyevent.getAction() != 0)
        {
            flag = false;
        }
        if (flag)
        {
            return onKeyDown(k, keyevent);
        } else
        {
            return onKeyUp(k, keyevent);
        }
    }

    public void initWindowDecorActionBar()
    {
        ensureSubDecor();
        if (mHasActionBar && mActionBar == null)
        {
            if (mOriginalWindowCallback instanceof Activity)
            {
                mActionBar = new WindowDecorActionBar((Activity)mOriginalWindowCallback, mOverlayActionBar);
            } else
            if (mOriginalWindowCallback instanceof Dialog)
            {
                mActionBar = new WindowDecorActionBar((Dialog)mOriginalWindowCallback);
            }
            if (mActionBar != null)
            {
                mActionBar.setDefaultDisplayHomeAsUpEnabled(mEnableDefaultActionBarUp);
                return;
            }
        }
    }

    public void installViewFactory()
    {
        LayoutInflater layoutinflater = LayoutInflater.from(mContext);
        if (layoutinflater.getFactory() == null)
        {
            aa.a(layoutinflater, this);
            return;
        } else
        {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
            return;
        }
    }

    public void invalidateOptionsMenu()
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null && actionbar.invalidateOptionsMenu())
        {
            return;
        } else
        {
            invalidatePanelMenu(0);
            return;
        }
    }

    boolean onBackPressed()
    {
        if (mActionMode != null)
        {
            mActionMode.finish();
        } else
        {
            ActionBar actionbar = getSupportActionBar();
            if (actionbar == null || !actionbar.collapseActionView())
            {
                return false;
            }
        }
        return true;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (mHasActionBar && mSubDecorInstalled)
        {
            ActionBar actionbar = getSupportActionBar();
            if (actionbar != null)
            {
                actionbar.onConfigurationChanged(configuration);
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            mWindowDecor = (ViewGroup)mWindow.getDecorView();
            if ((mOriginalWindowCallback instanceof Activity) && ba.b((Activity)mOriginalWindowCallback) != null)
            {
                bundle = peekSupportActionBar();
                if (bundle != null)
                {
                    break label0;
                }
                mEnableDefaultActionBarUp = true;
            }
            return;
        }
        bundle.setDefaultDisplayHomeAsUpEnabled(true);
    }

    public final View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        View view1 = callActivityOnCreateView(view, s, context, attributeset);
        if (view1 != null)
        {
            return view1;
        } else
        {
            return createView(view, s, context, attributeset);
        }
    }

    boolean onKeyDown(int k, KeyEvent keyevent)
    {
        k;
        JVM INSTR tableswitch 82 82: default 20
    //                   82 37;
           goto _L1 _L2
_L1:
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            onKeyShortcut(k, keyevent);
        }
        return false;
_L2:
        onKeyDownPanel(0, keyevent);
        if (true) goto _L1; else goto _L3
_L3:
    }

    boolean onKeyShortcut(int k, KeyEvent keyevent)
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar == null || !actionbar.onKeyShortcut(k, keyevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (mPreparedPanel == null || !performPanelShortcut(mPreparedPanel, keyevent.getKeyCode(), keyevent, 1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (mPreparedPanel != null)
        {
            mPreparedPanel.isHandled = true;
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag;
        if (mPreparedPanel != null)
        {
            break; /* Loop/switch isn't completed */
        }
        PanelFeatureState panelfeaturestate = getPanelState(0, true);
        preparePanel(panelfeaturestate, keyevent);
        flag = performPanelShortcut(panelfeaturestate, keyevent.getKeyCode(), keyevent, 1);
        panelfeaturestate.isPrepared = false;
        if (flag) goto _L1; else goto _L4
_L4:
        return false;
    }

    boolean onKeyUp(int k, KeyEvent keyevent)
    {
        k;
        JVM INSTR lookupswitch 2: default 28
    //                   4: 39
    //                   82: 30;
           goto _L1 _L2 _L3
_L1:
        return false;
_L3:
        onKeyUpPanel(0, keyevent);
        return true;
_L2:
        keyevent = getPanelState(0, false);
        if (keyevent != null && ((PanelFeatureState) (keyevent)).isOpen)
        {
            closePanel(keyevent, true);
            return true;
        }
        if (onBackPressed())
        {
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean onMenuItemSelected(i k, MenuItem menuitem)
    {
        android.view.Window.Callback callback = getWindowCallback();
        if (callback != null && !isDestroyed())
        {
            k = findMenuPanel(k.n());
            if (k != null)
            {
                return callback.onMenuItemSelected(((PanelFeatureState) (k)).featureId, menuitem);
            }
        }
        return false;
    }

    public void onMenuModeChange(i k)
    {
        reopenMenu(k, true);
    }

    boolean onMenuOpened(int k, Menu menu)
    {
        if (k == 108)
        {
            menu = getSupportActionBar();
            if (menu != null)
            {
                menu.dispatchMenuVisibilityChanged(true);
            }
            return true;
        } else
        {
            return false;
        }
    }

    void onPanelClosed(int k, Menu menu)
    {
        if (k == 108)
        {
            menu = getSupportActionBar();
            if (menu != null)
            {
                menu.dispatchMenuVisibilityChanged(false);
            }
        } else
        if (k == 0)
        {
            menu = getPanelState(k, true);
            if (((PanelFeatureState) (menu)).isOpen)
            {
                closePanel(menu, false);
                return;
            }
        }
    }

    public void onPostCreate(Bundle bundle)
    {
        ensureSubDecor();
    }

    public void onPostResume()
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            actionbar.setShowHideAnimationEnabled(true);
        }
    }

    public void onStop()
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            actionbar.setShowHideAnimationEnabled(false);
        }
    }

    void onSubDecorInstalled(ViewGroup viewgroup)
    {
    }

    void onTitleChanged(CharSequence charsequence)
    {
        if (mDecorContentParent != null)
        {
            mDecorContentParent.setWindowTitle(charsequence);
        } else
        {
            if (peekSupportActionBar() != null)
            {
                peekSupportActionBar().setWindowTitle(charsequence);
                return;
            }
            if (mTitleView != null)
            {
                mTitleView.setText(charsequence);
                return;
            }
        }
    }

    public boolean requestWindowFeature(int k)
    {
        k = sanitizeWindowFeatureId(k);
        if (mWindowNoTitle && k == 108)
        {
            return false;
        }
        if (mHasActionBar && k == 1)
        {
            mHasActionBar = false;
        }
        switch (k)
        {
        default:
            return mWindow.requestFeature(k);

        case 108: // 'l'
            throwFeatureRequestIfSubDecorInstalled();
            mHasActionBar = true;
            return true;

        case 109: // 'm'
            throwFeatureRequestIfSubDecorInstalled();
            mOverlayActionBar = true;
            return true;

        case 10: // '\n'
            throwFeatureRequestIfSubDecorInstalled();
            mOverlayActionMode = true;
            return true;

        case 2: // '\002'
            throwFeatureRequestIfSubDecorInstalled();
            mFeatureProgress = true;
            return true;

        case 5: // '\005'
            throwFeatureRequestIfSubDecorInstalled();
            mFeatureIndeterminateProgress = true;
            return true;

        case 1: // '\001'
            throwFeatureRequestIfSubDecorInstalled();
            mWindowNoTitle = true;
            return true;
        }
    }

    public void setContentView(int k)
    {
        ensureSubDecor();
        ViewGroup viewgroup = (ViewGroup)mSubDecor.findViewById(0x1020002);
        viewgroup.removeAllViews();
        LayoutInflater.from(mContext).inflate(k, viewgroup);
        mOriginalWindowCallback.onContentChanged();
    }

    public void setContentView(View view)
    {
        ensureSubDecor();
        ViewGroup viewgroup = (ViewGroup)mSubDecor.findViewById(0x1020002);
        viewgroup.removeAllViews();
        viewgroup.addView(view);
        mOriginalWindowCallback.onContentChanged();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        ensureSubDecor();
        ViewGroup viewgroup = (ViewGroup)mSubDecor.findViewById(0x1020002);
        viewgroup.removeAllViews();
        viewgroup.addView(view, layoutparams);
        mOriginalWindowCallback.onContentChanged();
    }

    public void setSupportActionBar(Toolbar toolbar)
    {
        if (!(mOriginalWindowCallback instanceof Activity))
        {
            return;
        }
        if (getSupportActionBar() instanceof WindowDecorActionBar)
        {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        } else
        {
            mMenuInflater = null;
            toolbar = new ToolbarActionBar(toolbar, ((Activity)mContext).getTitle(), mAppCompatWindowCallback);
            mActionBar = toolbar;
            mWindow.setCallback(toolbar.getWrappedWindowCallback());
            toolbar.invalidateOptionsMenu();
            return;
        }
    }

    public ActionMode startSupportActionMode(android.support.v7.view.ActionMode.Callback callback)
    {
        if (callback == null)
        {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (mActionMode != null)
        {
            mActionMode.finish();
        }
        callback = new ActionModeCallbackWrapperV7(callback);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            mActionMode = actionbar.startActionMode(callback);
            if (mActionMode != null && mAppCompatCallback != null)
            {
                mAppCompatCallback.onSupportActionModeStarted(mActionMode);
            }
        }
        if (mActionMode == null)
        {
            mActionMode = startSupportActionModeFromWindow(callback);
        }
        return mActionMode;
    }

    ActionMode startSupportActionModeFromWindow(android.support.v7.view.ActionMode.Callback callback)
    {
        ActionModeCallbackWrapperV7 actionmodecallbackwrapperv7;
        endOnGoingFadeAnimation();
        if (mActionMode != null)
        {
            mActionMode.finish();
        }
        actionmodecallbackwrapperv7 = new ActionModeCallbackWrapperV7(callback);
        if (mAppCompatCallback == null || isDestroyed())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        Object obj = mAppCompatCallback.onWindowStartingSupportActionMode(actionmodecallbackwrapperv7);
_L1:
        if (obj != null)
        {
            mActionMode = ((ActionMode) (obj));
        } else
        {
            if (mActionModeView == null)
            {
                if (mIsFloating)
                {
                    Object obj2 = new TypedValue();
                    Object obj1 = mContext.getTheme();
                    ((android.content.res.Resources.Theme) (obj1)).resolveAttribute(android.support.v7.appcompat.R.attr.actionBarTheme, ((TypedValue) (obj2)), true);
                    int k;
                    if (((TypedValue) (obj2)).resourceId != 0)
                    {
                        android.content.res.Resources.Theme theme = mContext.getResources().newTheme();
                        theme.setTo(((android.content.res.Resources.Theme) (obj1)));
                        theme.applyStyle(((TypedValue) (obj2)).resourceId, true);
                        obj1 = new ContextThemeWrapper(mContext, 0);
                        ((Context) (obj1)).getTheme().setTo(theme);
                    } else
                    {
                        obj1 = mContext;
                    }
                    mActionModeView = new ActionBarContextView(((Context) (obj1)));
                    mActionModePopup = new PopupWindow(((Context) (obj1)), null, android.support.v7.appcompat.R.attr.actionModePopupWindowStyle);
                    am.a(mActionModePopup, 2);
                    mActionModePopup.setContentView(mActionModeView);
                    mActionModePopup.setWidth(-1);
                    ((Context) (obj1)).getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, ((TypedValue) (obj2)), true);
                    k = TypedValue.complexToDimensionPixelSize(((TypedValue) (obj2)).data, ((Context) (obj1)).getResources().getDisplayMetrics());
                    mActionModeView.setContentHeight(k);
                    mActionModePopup.setHeight(-2);
                    mShowActionModePopup = new _cls4();
                } else
                {
                    ViewStubCompat viewstubcompat = (ViewStubCompat)mSubDecor.findViewById(android.support.v7.appcompat.R.id.action_mode_bar_stub);
                    if (viewstubcompat != null)
                    {
                        viewstubcompat.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
                        mActionModeView = (ActionBarContextView)viewstubcompat.inflate();
                    }
                }
            }
            if (mActionModeView != null)
            {
                endOnGoingFadeAnimation();
                mActionModeView.killMode();
                obj1 = mActionModeView.getContext();
                obj2 = mActionModeView;
                boolean flag;
                if (mActionModePopup == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj1 = new StandaloneActionMode(((Context) (obj1)), ((ActionBarContextView) (obj2)), actionmodecallbackwrapperv7, flag);
                if (callback.onCreateActionMode(((ActionMode) (obj1)), ((ActionMode) (obj1)).getMenu()))
                {
                    ((ActionMode) (obj1)).invalidate();
                    mActionModeView.initForMode(((ActionMode) (obj1)));
                    mActionMode = ((ActionMode) (obj1));
                    bi.c(mActionModeView, 0.0F);
                    mFadeAnim = bi.q(mActionModeView).a(1.0F);
                    mFadeAnim.a(new _cls5());
                    if (mActionModePopup != null)
                    {
                        mWindow.getDecorView().post(mShowActionModePopup);
                    }
                } else
                {
                    mActionMode = null;
                }
            }
        }
        if (mActionMode != null && mAppCompatCallback != null)
        {
            mAppCompatCallback.onSupportActionModeStarted(mActionMode);
        }
        return mActionMode;
        obj;
        obj = null;
          goto _L1
    }



/*
    static int access$002(AppCompatDelegateImplV7 appcompatdelegateimplv7, int k)
    {
        appcompatdelegateimplv7.mInvalidatePanelMenuFeatures = k;
        return k;
    }

*/





/*
    static boolean access$202(AppCompatDelegateImplV7 appcompatdelegateimplv7, boolean flag)
    {
        appcompatdelegateimplv7.mInvalidatePanelMenuPosted = flag;
        return flag;
    }

*/






    private class _cls1
        implements Runnable
    {

        final AppCompatDelegateImplV7 this$0;

        public void run()
        {
            if ((mInvalidatePanelMenuFeatures & 1) != 0)
            {
                doInvalidatePanelMenu(0);
            }
            if ((mInvalidatePanelMenuFeatures & 0x1000) != 0)
            {
                doInvalidatePanelMenu(108);
            }
            mInvalidatePanelMenuPosted = false;
            mInvalidatePanelMenuFeatures = 0;
        }

        _cls1()
        {
            this$0 = AppCompatDelegateImplV7.this;
            super();
        }
    }


    private class PanelFeatureState
    {

        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        g listMenuPresenter;
        Context listPresenterContext;
        i menu;
        public boolean qwertyMode;
        boolean refreshDecorView;
        boolean refreshMenuContent;
        View shownPanelView;
        int windowAnimations;
        int x;
        int y;

        final z getListMenuView(y y1)
        {
            if (menu == null)
            {
                return null;
            }
            if (listMenuPresenter == null)
            {
                listMenuPresenter = new g(listPresenterContext, android.support.v7.appcompat.R.layout.abc_list_menu_item_layout);
                listMenuPresenter.a(y1);
                menu.a(listMenuPresenter);
            }
            return listMenuPresenter.a(decorView);
        }

        public final boolean hasPanelItems()
        {
            if (shownPanelView != null)
            {
                if (createdPanelView != null)
                {
                    return true;
                }
                if (listMenuPresenter.a().getCount() > 0)
                {
                    return true;
                }
            }
            return false;
        }

        final void setMenu(i k)
        {
            if (k != menu)
            {
                if (menu != null)
                {
                    menu.b(listMenuPresenter);
                }
                menu = k;
                if (k != null && listMenuPresenter != null)
                {
                    k.a(listMenuPresenter);
                    return;
                }
            }
        }

        final void setStyle(Context context)
        {
            TypedValue typedvalue = new TypedValue();
            android.content.res.Resources.Theme theme = context.getResources().newTheme();
            theme.setTo(context.getTheme());
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
            context = new ContextThemeWrapper(context, 0);
            context.getTheme().setTo(theme);
            listPresenterContext = context;
            context = context.obtainStyledAttributes(android.support.v7.appcompat.R.styleable.Theme);
            background = context.getResourceId(android.support.v7.appcompat.R.styleable.Theme_panelBackground, 0);
            windowAnimations = context.getResourceId(android.support.v7.appcompat.R.styleable.Theme_android_windowAnimationStyle, 0);
            context.recycle();
        }

        PanelFeatureState(int k)
        {
            featureId = k;
            refreshDecorView = false;
        }
    }


    private class _cls2
        implements android.support.v4.view.ba
    {

        final AppCompatDelegateImplV7 this$0;

        public dn onApplyWindowInsets(View view, dn dn1)
        {
            int k = dn1.b();
            int l = updateStatusGuard(k);
            dn dn2 = dn1;
            if (k != l)
            {
                dn2 = dn1.a(dn1.a(), l, dn1.c(), dn1.d());
            }
            return bi.a(view, dn2);
        }

        _cls2()
        {
            this$0 = AppCompatDelegateImplV7.this;
            super();
        }
    }


    private class _cls3
        implements android.support.v7.internal.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
    {

        final AppCompatDelegateImplV7 this$0;

        public void onFitSystemWindows(Rect rect)
        {
            rect.top = updateStatusGuard(rect.top);
        }

        _cls3()
        {
            this$0 = AppCompatDelegateImplV7.this;
            super();
        }
    }


    private class PanelMenuPresenterCallback
        implements y
    {

        final AppCompatDelegateImplV7 this$0;

        public final void onCloseMenu(i k, boolean flag)
        {
label0:
            {
                i l = k.n();
                AppCompatDelegateImplV7 appcompatdelegateimplv7;
                boolean flag1;
                if (l != k)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                appcompatdelegateimplv7 = AppCompatDelegateImplV7.this;
                if (flag1)
                {
                    k = l;
                }
                k = appcompatdelegateimplv7.findMenuPanel(k);
                if (k != null)
                {
                    if (!flag1)
                    {
                        break label0;
                    }
                    callOnPanelClosed(((PanelFeatureState) (k)).featureId, k, l);
                    closePanel(k, true);
                }
                return;
            }
            closePanel(k, flag);
        }

        public final boolean onOpenSubMenu(i k)
        {
            if (k == null && mHasActionBar)
            {
                android.view.Window.Callback callback = getWindowCallback();
                if (callback != null && !isDestroyed())
                {
                    callback.onMenuOpened(108, k);
                }
            }
            return true;
        }

        private PanelMenuPresenterCallback()
        {
            this$0 = AppCompatDelegateImplV7.this;
            super();
        }

        PanelMenuPresenterCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ListMenuDecorView extends FrameLayout
    {

        final AppCompatDelegateImplV7 this$0;

        private boolean isOutOfBounds(int k, int l)
        {
            return k < -5 || l < -5 || k > getWidth() + 5 || l > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyevent)
        {
            return AppCompatDelegateImplV7.this.dispatchKeyEvent(keyevent) || super.dispatchKeyEvent(keyevent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0 && isOutOfBounds((int)motionevent.getX(), (int)motionevent.getY()))
            {
                closePanel(0);
                return true;
            } else
            {
                return super.onInterceptTouchEvent(motionevent);
            }
        }

        public void setBackgroundResource(int k)
        {
            setBackgroundDrawable(TintManager.getDrawable(getContext(), k));
        }

        public ListMenuDecorView(Context context)
        {
            this$0 = AppCompatDelegateImplV7.this;
            super(context);
        }
    }


    private class ActionMenuPresenterCallback
        implements y
    {

        final AppCompatDelegateImplV7 this$0;

        public final void onCloseMenu(i k, boolean flag)
        {
            checkCloseActionMenu(k);
        }

        public final boolean onOpenSubMenu(i k)
        {
            android.view.Window.Callback callback = getWindowCallback();
            if (callback != null)
            {
                callback.onMenuOpened(108, k);
            }
            return true;
        }

        private ActionMenuPresenterCallback()
        {
            this$0 = AppCompatDelegateImplV7.this;
            super();
        }

        ActionMenuPresenterCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ActionModeCallbackWrapperV7
        implements android.support.v7.view.ActionMode.Callback
    {

        private android.support.v7.view.ActionMode.Callback mWrapped;
        final AppCompatDelegateImplV7 this$0;

        public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
        {
            return mWrapped.onActionItemClicked(actionmode, menuitem);
        }

        public boolean onCreateActionMode(ActionMode actionmode, Menu menu)
        {
            return mWrapped.onCreateActionMode(actionmode, menu);
        }

        public void onDestroyActionMode(ActionMode actionmode)
        {
            mWrapped.onDestroyActionMode(actionmode);
            if (mActionModePopup != null)
            {
                mWindow.getDecorView().removeCallbacks(mShowActionModePopup);
            }
            if (mActionModeView != null)
            {
                endOnGoingFadeAnimation();
                mFadeAnim = bi.q(mActionModeView).a(0.0F);
                class _cls1 extends dl
                {

                    final ActionModeCallbackWrapperV7 this$1;

                    public void onAnimationEnd(View view)
                    {
                        mActionModeView.setVisibility(8);
                        if (mActionModePopup == null) goto _L2; else goto _L1
_L1:
                        mActionModePopup.dismiss();
_L4:
                        mActionModeView.removeAllViews();
                        mFadeAnim.a(null);
                        mFadeAnim = null;
                        return;
_L2:
                        if (mActionModeView.getParent() instanceof View)
                        {
                            bi.u((View)mActionModeView.getParent());
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

                _cls1()
                {
                    this$1 = ActionModeCallbackWrapperV7.this;
                    super();
                }
                }

                mFadeAnim.a(new _cls1());
            }
            if (mAppCompatCallback != null)
            {
                mAppCompatCallback.onSupportActionModeFinished(mActionMode);
            }
            mActionMode = null;
        }

        public boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
        {
            return mWrapped.onPrepareActionMode(actionmode, menu);
        }

        public ActionModeCallbackWrapperV7(android.support.v7.view.ActionMode.Callback callback)
        {
            this$0 = AppCompatDelegateImplV7.this;
            super();
            mWrapped = callback;
        }
    }


    private class _cls4
        implements Runnable
    {

        final AppCompatDelegateImplV7 this$0;

        public void run()
        {
            mActionModePopup.showAtLocation(mActionModeView, 55, 0, 0);
            endOnGoingFadeAnimation();
            bi.c(mActionModeView, 0.0F);
            mFadeAnim = bi.q(mActionModeView).a(1.0F);
            class _cls1 extends dl
            {

                final _cls4 this$1;

                public void onAnimationEnd(View view)
                {
                    bi.c(mActionModeView, 1.0F);
                    mFadeAnim.a(null);
                    mFadeAnim = null;
                }

                public void onAnimationStart(View view)
                {
                    mActionModeView.setVisibility(0);
                }

                _cls1()
                {
                    this$1 = _cls4.this;
                    super();
                }
            }

            mFadeAnim.a(new _cls1());
        }

        _cls4()
        {
            this$0 = AppCompatDelegateImplV7.this;
            super();
        }
    }


    private class _cls5 extends dl
    {

        final AppCompatDelegateImplV7 this$0;

        public void onAnimationEnd(View view)
        {
            bi.c(mActionModeView, 1.0F);
            mFadeAnim.a(null);
            mFadeAnim = null;
        }

        public void onAnimationStart(View view)
        {
            mActionModeView.setVisibility(0);
            mActionModeView.sendAccessibilityEvent(32);
            if (mActionModeView.getParent() != null)
            {
                bi.u((View)mActionModeView.getParent());
            }
        }

        _cls5()
        {
            this$0 = AppCompatDelegateImplV7.this;
            super();
        }
    }

}
