// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.internal.view.StandaloneActionMode;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.IcsProgressBar;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.actionbarsherlock.internal:
//            ResourcesCompat

public class ActionBarSherlockCompat extends ActionBarSherlock
    implements android.view.MenuItem.OnMenuItemClickListener, com.actionbarsherlock.internal.view.menu.MenuBuilder.Callback, com.actionbarsherlock.internal.view.menu.MenuPresenter.Callback, com.actionbarsherlock.view.Window.Callback
{

    protected static final int DEFAULT_FEATURES = 0;
    private static final String PANELS_TAG = "sherlock:Panels";
    private ActionBarImpl aActionBar;
    private ActionMode mActionMode;
    private ActionBarContextView mActionModeView;
    private IcsProgressBar mCircularProgressBar;
    private boolean mClosingActionMenu;
    private ViewGroup mContentParent;
    private ViewGroup mDecor;
    private int mFeatures;
    private IcsProgressBar mHorizontalProgressBar;
    private boolean mIsDestroyed;
    private boolean mIsTitleReady;
    private MenuBuilder mMenu;
    private Bundle mMenuFrozenActionViewState;
    private boolean mMenuIsPrepared;
    private boolean mMenuRefreshContent;
    protected HashMap mNativeItemMap;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private int mUiOptions;
    private ActionBarView wActionBar;

    public ActionBarSherlockCompat(Activity activity, int i)
    {
        super(activity, i);
        mReserveOverflowSet = false;
        mIsTitleReady = false;
        mIsDestroyed = false;
        mFeatures = 0;
        mUiOptions = 0;
    }

    public static String cleanActivityName(String s, String s1)
    {
        String s2;
        if (s1.charAt(0) == '.')
        {
            s2 = (new StringBuilder()).append(s).append(s1).toString();
        } else
        {
            s2 = s1;
            if (s1.indexOf('.', 1) == -1)
            {
                return (new StringBuilder()).append(s).append(".").append(s1).toString();
            }
        }
        return s2;
    }

    private ViewGroup generateLayout()
    {
        Object obj;
        obj = mActivity.getTheme().obtainStyledAttributes(com.actionbarsherlock.R.styleable.SherlockTheme);
        if (!((TypedArray) (obj)).hasValue(59))
        {
            throw new IllegalStateException("You must use Theme.Sherlock, Theme.Sherlock.Light, Theme.Sherlock.Light.DarkActionBar, or a derivative.");
        }
        if (((TypedArray) (obj)).getBoolean(58, false))
        {
            requestFeature(1);
            break MISSING_BLOCK_LABEL_49;
        } else
        {
            if (((TypedArray) (obj)).getBoolean(59, false))
            {
                requestFeature(8);
            }
            continue;
        }
        do
        {
            if (((TypedArray) (obj)).getBoolean(60, false))
            {
                requestFeature(9);
            }
            if (((TypedArray) (obj)).getBoolean(61, false))
            {
                requestFeature(10);
            }
            ((TypedArray) (obj)).recycle();
            int i;
            if (!hasFeature(1))
            {
                if (hasFeature(9))
                {
                    i = com.actionbarsherlock.R.layout.abs__screen_action_bar_overlay;
                } else
                {
                    i = com.actionbarsherlock.R.layout.abs__screen_action_bar;
                }
            } else
            if (hasFeature(10) && !hasFeature(1))
            {
                i = com.actionbarsherlock.R.layout.abs__screen_simple_overlay_action_mode;
            } else
            {
                i = com.actionbarsherlock.R.layout.abs__screen_simple;
            }
            (new StringBuilder()).append("[generateLayout] using screen XML ").append(mActivity.getResources().getString(i)).toString();
            obj = mActivity.getLayoutInflater().inflate(i, null);
            mDecor.addView(((View) (obj)), new android.view.ViewGroup.LayoutParams(-1, -1));
            obj = (ViewGroup)mDecor.findViewById(com.actionbarsherlock.R.id.abs__content);
            if (obj == null)
            {
                throw new RuntimeException("Couldn't find content container view");
            }
            mDecor.setId(-1);
            ((ViewGroup) (obj)).setId(0x1020002);
            if (hasFeature(5))
            {
                IcsProgressBar icsprogressbar = getCircularProgressBar(false);
                if (icsprogressbar != null)
                {
                    icsprogressbar.setIndeterminate(true);
                }
            }
            return ((ViewGroup) (obj));
        } while (true);
    }

    private IcsProgressBar getCircularProgressBar(boolean flag)
    {
        if (mCircularProgressBar != null)
        {
            return mCircularProgressBar;
        }
        if (mContentParent == null && flag)
        {
            installDecor();
        }
        mCircularProgressBar = (IcsProgressBar)mDecor.findViewById(com.actionbarsherlock.R.id.abs__progress_circular);
        if (mCircularProgressBar != null)
        {
            mCircularProgressBar.setVisibility(4);
        }
        return mCircularProgressBar;
    }

    private int getFeatures()
    {
        (new StringBuilder()).append("[getFeatures] returning ").append(mFeatures).toString();
        return mFeatures;
    }

    private IcsProgressBar getHorizontalProgressBar(boolean flag)
    {
        if (mHorizontalProgressBar != null)
        {
            return mHorizontalProgressBar;
        }
        if (mContentParent == null && flag)
        {
            installDecor();
        }
        mHorizontalProgressBar = (IcsProgressBar)mDecor.findViewById(com.actionbarsherlock.R.id.abs__progress_horizontal);
        if (mHorizontalProgressBar != null)
        {
            mHorizontalProgressBar.setVisibility(4);
        }
        return mHorizontalProgressBar;
    }

    private void hideProgressBars(IcsProgressBar icsprogressbar, IcsProgressBar icsprogressbar1)
    {
        int i = mFeatures;
        Animation animation = AnimationUtils.loadAnimation(mActivity, 0x10a0001);
        animation.setDuration(1000L);
        if ((i & 0x20) != 0 && icsprogressbar1.getVisibility() == 0)
        {
            icsprogressbar1.startAnimation(animation);
            icsprogressbar1.setVisibility(4);
        }
        if ((i & 4) != 0 && icsprogressbar.getVisibility() == 0)
        {
            icsprogressbar.startAnimation(animation);
            icsprogressbar.setVisibility(4);
        }
    }

    private void initActionBar()
    {
        if (mDecor == null)
        {
            installDecor();
        }
        if (aActionBar == null && hasFeature(8) && !hasFeature(1) && !mActivity.isChild())
        {
            aActionBar = new ActionBarImpl(mActivity, mFeatures);
            if (!mIsDelegate)
            {
                wActionBar.setWindowTitle(mActivity.getTitle());
                return;
            }
        }
    }

    private boolean initializePanelMenu()
    {
        Object obj = mActivity;
        if (wActionBar != null)
        {
            TypedValue typedvalue = new TypedValue();
            ((Context) (obj)).getTheme().resolveAttribute(com.actionbarsherlock.R.attr.actionBarWidgetTheme, typedvalue, true);
            int i = typedvalue.resourceId;
            if (i != 0)
            {
                obj = new ContextThemeWrapper(((Context) (obj)), i);
            }
        }
        mMenu = new MenuBuilder(((Context) (obj)));
        mMenu.setCallback(this);
        return true;
    }

    private void installDecor()
    {
        if (mDecor == null)
        {
            mDecor = (ViewGroup)mActivity.getWindow().getDecorView().findViewById(0x1020002);
        }
        if (mContentParent == null)
        {
            Object obj = null;
            if (mDecor.getChildCount() > 0)
            {
                ArrayList arraylist = new ArrayList(1);
                int k = mDecor.getChildCount();
                int i = 0;
                do
                {
                    obj = arraylist;
                    if (i >= k)
                    {
                        break;
                    }
                    obj = mDecor.getChildAt(0);
                    mDecor.removeView(((View) (obj)));
                    arraylist.add(obj);
                    i++;
                } while (true);
            }
            mContentParent = generateLayout();
            if (obj != null)
            {
                View view;
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); mContentParent.addView(view))
                {
                    view = (View)((Iterator) (obj)).next();
                }

            }
            wActionBar = (ActionBarView)mDecor.findViewById(com.actionbarsherlock.R.id.abs__action_bar);
            if (wActionBar != null)
            {
                wActionBar.setWindowCallback(this);
                if (wActionBar.getTitle() == null)
                {
                    wActionBar.setWindowTitle(mActivity.getTitle());
                }
                if (hasFeature(2))
                {
                    wActionBar.initProgress();
                }
                if (hasFeature(5))
                {
                    wActionBar.initIndeterminateProgress();
                }
                int j = loadUiOptionsFromManifest(mActivity);
                if (j != 0)
                {
                    mUiOptions = j;
                }
                ActionBarContainer actionbarcontainer;
                boolean flag;
                boolean flag1;
                if ((mUiOptions & 1) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    flag1 = ResourcesCompat.getResources_getBoolean(mActivity, com.actionbarsherlock.R.bool.abs__split_action_bar_is_narrow);
                } else
                {
                    flag1 = mActivity.getTheme().obtainStyledAttributes(com.actionbarsherlock.R.styleable.SherlockTheme).getBoolean(62, false);
                }
                actionbarcontainer = (ActionBarContainer)mDecor.findViewById(com.actionbarsherlock.R.id.abs__split_action_bar);
                if (actionbarcontainer != null)
                {
                    wActionBar.setSplitView(actionbarcontainer);
                    wActionBar.setSplitActionBar(flag1);
                    wActionBar.setSplitWhenNarrow(flag);
                    mActionModeView = (ActionBarContextView)mDecor.findViewById(com.actionbarsherlock.R.id.abs__action_context_bar);
                    mActionModeView.setSplitView(actionbarcontainer);
                    mActionModeView.setSplitActionBar(flag1);
                    mActionModeView.setSplitWhenNarrow(flag);
                }
                mDecor.post(new _cls1());
            }
        }
    }

    private boolean isReservingOverflow()
    {
        if (!mReserveOverflowSet)
        {
            mReserveOverflow = ActionMenuPresenter.reserveOverflow(mActivity);
            mReserveOverflowSet = true;
        }
        return mReserveOverflow;
    }

    private static int loadUiOptionsFromManifest(Activity activity)
    {
        String s1;
        String s2;
        XmlResourceParser xmlresourceparser;
        int l;
        s1 = activity.getClass().getName();
        (new StringBuilder()).append("Parsing AndroidManifest.xml for ").append(s1).toString();
        s2 = activity.getApplicationInfo().packageName;
        xmlresourceparser = activity.createPackageContext(s2, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
        l = xmlresourceparser.getEventType();
        int i = 0;
_L11:
        int j = i;
        if (l == 1) goto _L2; else goto _L1
_L1:
        int k = i;
        if (l != 2) goto _L4; else goto _L3
_L3:
        Object obj;
        boolean flag;
        boolean flag1;
        j = i;
        String s;
        String s3;
        boolean flag2;
        try
        {
            activity = xmlresourceparser.getName();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            i = j;
            continue; /* Loop/switch isn't completed */
        }
        j = i;
        if (!"application".equals(activity)) goto _L6; else goto _L5
_L5:
        j = i;
        k = xmlresourceparser.getAttributeCount() - 1;
_L12:
        if (k < 0) goto _L8; else goto _L7
_L7:
        j = i;
        (new StringBuilder()).append(xmlresourceparser.getAttributeName(k)).append(": ").append(xmlresourceparser.getAttributeValue(k)).toString();
        j = i;
        if (!"uiOptions".equals(xmlresourceparser.getAttributeName(k))) goto _L10; else goto _L9
_L9:
        j = i;
        i = xmlresourceparser.getAttributeIntValue(k, 0);
_L8:
        l = xmlresourceparser.nextToken();
          goto _L11
_L10:
        k--;
          goto _L12
_L6:
        k = i;
        j = i;
        if (!"activity".equals(activity)) goto _L4; else goto _L13
_L13:
        j = i;
        k = xmlresourceparser.getAttributeCount() - 1;
        flag = false;
        s = null;
        activity = null;
_L22:
        if (k < 0) goto _L15; else goto _L14
_L14:
        j = i;
        (new StringBuilder()).append(xmlresourceparser.getAttributeName(k)).append(": ").append(xmlresourceparser.getAttributeValue(k)).toString();
        j = i;
        s3 = xmlresourceparser.getAttributeName(k);
        j = i;
        if (!"uiOptions".equals(s3)) goto _L17; else goto _L16
_L16:
        j = i;
        obj = Integer.valueOf(xmlresourceparser.getAttributeIntValue(k, 0));
        flag1 = flag;
_L18:
        j = i;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_552;
        }
        j = i;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_552;
        }
        j = i;
        i = ((Integer) (obj)).intValue();
        j = i;
        break MISSING_BLOCK_LABEL_552;
_L17:
        flag1 = flag;
        obj = activity;
        j = i;
        if (!"name".equals(s3))
        {
            continue; /* Loop/switch isn't completed */
        }
        j = i;
        s = cleanActivityName(s2, xmlresourceparser.getAttributeValue(k));
        j = i;
        flag2 = s1.equals(s);
        if (!flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = true;
        obj = activity;
        if (true) goto _L18; else goto _L15
_L15:
        j = i;
        if (flag) goto _L2; else goto _L19
_L19:
        k = i;
_L4:
        i = k;
          goto _L8
        activity;
        i = 0;
_L21:
        activity.printStackTrace();
        j = i;
_L2:
        (new StringBuilder()).append("Returning ").append(Integer.toHexString(j)).toString();
        return j;
        activity;
        if (true) goto _L21; else goto _L20
_L20:
        k--;
        i = j;
        flag = flag1;
        activity = ((Activity) (obj));
          goto _L22
    }

    private void onIntChanged(int i, int j)
    {
        if (i == 2 || i == 5)
        {
            updateProgressBars(j);
        }
    }

    private boolean preparePanel()
    {
        boolean flag2;
        boolean flag3;
        flag3 = false;
        flag2 = false;
        if (!mMenuIsPrepared) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        if (mMenu != null && !mMenuRefreshContent)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        if (mMenu != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag2;
        if (!initializePanelMenu())
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag2;
        if (mMenu == null) goto _L4; else goto _L3
_L3:
        if (wActionBar != null)
        {
            wActionBar.setMenu(mMenu, this);
        }
        mMenu.stopDispatchingItemsChanged();
        if (callbackCreateOptionsMenu(mMenu))
        {
            break; /* Loop/switch isn't completed */
        }
        mMenu = null;
        flag = flag2;
        if (wActionBar != null)
        {
            wActionBar.setMenu(null, this);
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
        mMenuRefreshContent = false;
        mMenu.stopDispatchingItemsChanged();
        if (mMenuFrozenActionViewState != null)
        {
            mMenu.restoreActionViewStates(mMenuFrozenActionViewState);
            mMenuFrozenActionViewState = null;
        }
        if (!callbackPrepareOptionsMenu(mMenu))
        {
            if (wActionBar != null)
            {
                wActionBar.setMenu(null, this);
            }
            mMenu.startDispatchingItemsChanged();
            return false;
        }
        KeyCharacterMap keycharactermap = KeyCharacterMap.load(-1);
        MenuBuilder menubuilder = mMenu;
        boolean flag1 = flag3;
        if (keycharactermap.getKeyboardType() != 1)
        {
            flag1 = true;
        }
        menubuilder.setQwertyMode(flag1);
        mMenu.startDispatchingItemsChanged();
        mMenuIsPrepared = true;
        return true;
    }

    private void reopenMenu(boolean flag)
    {
label0:
        {
            if (wActionBar != null && wActionBar.isOverflowReserved())
            {
                if (wActionBar.isOverflowMenuShowing() && flag)
                {
                    break label0;
                }
                if (wActionBar.getVisibility() == 0 && callbackPrepareOptionsMenu(mMenu))
                {
                    wActionBar.showOverflowMenu();
                }
            }
            return;
        }
        wActionBar.hideOverflowMenu();
    }

    private void setFeatureInt(int i, int j)
    {
        updateInt(i, j, false);
    }

    private void showProgressBars(IcsProgressBar icsprogressbar, IcsProgressBar icsprogressbar1)
    {
        int i = mFeatures;
        if ((i & 0x20) != 0 && icsprogressbar1.getVisibility() == 4)
        {
            icsprogressbar1.setVisibility(0);
        }
        if ((i & 4) != 0 && icsprogressbar.getProgress() < 10000)
        {
            icsprogressbar.setVisibility(0);
        }
    }

    private void updateInt(int i, int j, boolean flag)
    {
        while (mContentParent == null || (1 << i & getFeatures()) == 0 && !flag) 
        {
            return;
        }
        onIntChanged(i, j);
    }

    private void updateProgressBars(int i)
    {
        IcsProgressBar icsprogressbar;
        IcsProgressBar icsprogressbar1;
        int j;
        icsprogressbar = getCircularProgressBar(true);
        icsprogressbar1 = getHorizontalProgressBar(true);
        j = mFeatures;
        if (i != -1) goto _L2; else goto _L1
_L1:
        if ((j & 4) != 0)
        {
            i = icsprogressbar1.getProgress();
            if (icsprogressbar1.isIndeterminate() || i < 10000)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            icsprogressbar1.setVisibility(i);
        }
        if ((j & 0x20) != 0)
        {
            icsprogressbar.setVisibility(0);
        }
_L4:
        return;
_L2:
        if (i != -2)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((j & 4) != 0)
        {
            icsprogressbar1.setVisibility(8);
        }
        if ((j & 0x20) != 0)
        {
            icsprogressbar.setVisibility(8);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i == -3)
        {
            icsprogressbar1.setIndeterminate(true);
            return;
        }
        if (i == -4)
        {
            icsprogressbar1.setIndeterminate(false);
            return;
        }
        if (i >= 0 && i <= 10000)
        {
            icsprogressbar1.setProgress(i + 0);
            if (i < 10000)
            {
                showProgressBars(icsprogressbar1, icsprogressbar);
                return;
            } else
            {
                hideProgressBars(icsprogressbar1, icsprogressbar);
                return;
            }
        }
        if (20000 <= i && i <= 30000)
        {
            icsprogressbar1.setSecondaryProgress(i - 20000);
            showProgressBars(icsprogressbar1, icsprogressbar);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        (new StringBuilder()).append("[addContentView] view: ").append(view).append(", params: ").append(layoutparams).toString();
        if (mContentParent == null)
        {
            installDecor();
        }
        mContentParent.addView(view, layoutparams);
        initActionBar();
    }

    void checkCloseActionMenu(Menu menu)
    {
        if (mClosingActionMenu)
        {
            return;
        } else
        {
            mClosingActionMenu = true;
            wActionBar.dismissPopupMenus();
            mClosingActionMenu = false;
            return;
        }
    }

    public boolean dispatchCloseOptionsMenu()
    {
        while (!isReservingOverflow() || wActionBar == null) 
        {
            return false;
        }
        return wActionBar.hideOverflowMenu();
    }

    public void dispatchConfigurationChanged(Configuration configuration)
    {
        (new StringBuilder()).append("[dispatchConfigurationChanged] newConfig: ").append(configuration).toString();
        if (aActionBar != null)
        {
            aActionBar.onConfigurationChanged(configuration);
        }
    }

    public boolean dispatchCreateOptionsMenu(android.view.Menu menu)
    {
        (new StringBuilder()).append("[dispatchCreateOptionsMenu] android.view.Menu: ").append(menu).toString();
        return true;
    }

    public void dispatchDestroy()
    {
        mIsDestroyed = true;
    }

    public void dispatchInvalidateOptionsMenu()
    {
        if (mMenu != null)
        {
            Bundle bundle = new Bundle();
            mMenu.saveActionViewStates(bundle);
            if (bundle.size() > 0)
            {
                mMenuFrozenActionViewState = bundle;
            }
            mMenu.stopDispatchingItemsChanged();
            mMenu.clear();
        }
        mMenuRefreshContent = true;
        if (wActionBar != null)
        {
            mMenuIsPrepared = false;
            preparePanel();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        int i;
        (new StringBuilder()).append("[dispatchKeyEvent] event: ").append(keyevent).toString();
        if (keyevent.getKeyCode() != 4)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        i = keyevent.getAction();
        if (mActionMode == null) goto _L2; else goto _L1
_L1:
        if (i == 1)
        {
            mActionMode.finish();
        }
_L4:
        return true;
_L2:
        if (wActionBar == null || !wActionBar.hasExpandedActionView())
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (i != 1) goto _L4; else goto _L3
_L3:
        wActionBar.collapseActionView();
        return true;
        return false;
    }

    public boolean dispatchMenuOpened(int i, android.view.Menu menu)
    {
        (new StringBuilder()).append("[dispatchMenuOpened] featureId: ").append(i).append(", menu: ").append(menu).toString();
        if (i == 8 || i == 0)
        {
            if (aActionBar != null)
            {
                aActionBar.dispatchMenuVisibilityChanged(true);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean dispatchOpenOptionsMenu()
    {
        if (!isReservingOverflow())
        {
            return false;
        } else
        {
            return wActionBar.showOverflowMenu();
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuitem)
    {
        throw new IllegalStateException("Native callback invoked. Create a test case and report!");
    }

    public void dispatchPanelClosed(int i, android.view.Menu menu)
    {
        (new StringBuilder()).append("[dispatchPanelClosed] featureId: ").append(i).append(", menu: ").append(menu).toString();
        if ((i == 8 || i == 0) && aActionBar != null)
        {
            aActionBar.dispatchMenuVisibilityChanged(false);
        }
    }

    public void dispatchPause()
    {
        if (wActionBar != null && wActionBar.isOverflowMenuShowing())
        {
            wActionBar.hideOverflowMenu();
        }
    }

    public void dispatchPostCreate(Bundle bundle)
    {
        if (mIsDelegate)
        {
            mIsTitleReady = true;
        }
        if (mDecor == null)
        {
            initActionBar();
        }
    }

    public void dispatchPostResume()
    {
        if (aActionBar != null)
        {
            aActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public boolean dispatchPrepareOptionsMenu(android.view.Menu menu)
    {
        (new StringBuilder()).append("[dispatchPrepareOptionsMenu] android.view.Menu: ").append(menu).toString();
        if (mActionMode == null)
        {
            mMenuIsPrepared = false;
            if (preparePanel() && !isReservingOverflow())
            {
                if (mNativeItemMap == null)
                {
                    mNativeItemMap = new HashMap();
                } else
                {
                    mNativeItemMap.clear();
                }
                if (mMenu != null)
                {
                    boolean flag = mMenu.bindNativeOverflow(menu, this, mNativeItemMap);
                    (new StringBuilder()).append("[dispatchPrepareOptionsMenu] returning ").append(flag).toString();
                    return flag;
                }
            }
        }
        return false;
    }

    public void dispatchRestoreInstanceState(Bundle bundle)
    {
        mMenuFrozenActionViewState = (Bundle)bundle.getParcelable("sherlock:Panels");
    }

    public void dispatchSaveInstanceState(Bundle bundle)
    {
        if (mMenu != null)
        {
            mMenuFrozenActionViewState = new Bundle();
            mMenu.saveActionViewStates(mMenuFrozenActionViewState);
        }
        bundle.putParcelable("sherlock:Panels", mMenuFrozenActionViewState);
    }

    public void dispatchStop()
    {
        if (aActionBar != null)
        {
            aActionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void dispatchTitleChanged(CharSequence charsequence, int i)
    {
        (new StringBuilder()).append("[dispatchTitleChanged] title: ").append(charsequence).append(", color: ").append(i).toString();
        if ((!mIsDelegate || mIsTitleReady) && wActionBar != null)
        {
            wActionBar.setWindowTitle(charsequence);
        }
    }

    public void ensureActionBar()
    {
        if (mDecor == null)
        {
            initActionBar();
        }
    }

    public ActionBar getActionBar()
    {
        initActionBar();
        return aActionBar;
    }

    protected Context getThemedContext()
    {
        return aActionBar.getThemedContext();
    }

    public boolean hasFeature(int i)
    {
        boolean flag = true;
        (new StringBuilder()).append("[hasFeature] featureId: ").append(i).toString();
        if ((mFeatures & 1 << i) == 0)
        {
            flag = false;
        }
        (new StringBuilder()).append("[hasFeature] returning ").append(flag).toString();
        return flag;
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        checkCloseActionMenu(menubuilder);
    }

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        (new StringBuilder()).append("[mNativeItemListener.onMenuItemClick] item: ").append(menuitem).toString();
        MenuItemImpl menuitemimpl = (MenuItemImpl)mNativeItemMap.get(menuitem);
        if (menuitemimpl != null)
        {
            menuitemimpl.invoke();
        } else
        {
            (new StringBuilder()).append("Options item \"").append(menuitem).append("\" not found in mapping").toString();
        }
        return true;
    }

    public boolean onMenuItemSelected(int i, com.actionbarsherlock.view.MenuItem menuitem)
    {
        return callbackOptionsItemSelected(menuitem);
    }

    public boolean onMenuItemSelected(MenuBuilder menubuilder, com.actionbarsherlock.view.MenuItem menuitem)
    {
        return callbackOptionsItemSelected(menuitem);
    }

    public void onMenuModeChange(MenuBuilder menubuilder)
    {
        reopenMenu(true);
    }

    public boolean onOpenSubMenu(MenuBuilder menubuilder)
    {
        return true;
    }

    public boolean requestFeature(int i)
    {
        (new StringBuilder()).append("[requestFeature] featureId: ").append(i).toString();
        if (mContentParent != null)
        {
            throw new AndroidRuntimeException("requestFeature() must be called before adding content");
        }
        switch (i)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 5: // '\005'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
            mFeatures = mFeatures | 1 << i;
            break;
        }
        return true;
    }

    public void setContentView(int i)
    {
        (new StringBuilder()).append("[setContentView] layoutResId: ").append(i).toString();
        android.view.Window.Callback callback;
        if (mContentParent == null)
        {
            installDecor();
        } else
        {
            mContentParent.removeAllViews();
        }
        mActivity.getLayoutInflater().inflate(i, mContentParent);
        callback = mActivity.getWindow().getCallback();
        if (callback != null)
        {
            callback.onContentChanged();
        }
        initActionBar();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        (new StringBuilder()).append("[setContentView] view: ").append(view).append(", params: ").append(layoutparams).toString();
        if (mContentParent == null)
        {
            installDecor();
        } else
        {
            mContentParent.removeAllViews();
        }
        mContentParent.addView(view, layoutparams);
        view = mActivity.getWindow().getCallback();
        if (view != null)
        {
            view.onContentChanged();
        }
        initActionBar();
    }

    public void setProgress(int i)
    {
        (new StringBuilder()).append("[setProgress] progress: ").append(i).toString();
        setFeatureInt(2, i + 0);
    }

    public void setProgressBarIndeterminate(boolean flag)
    {
        (new StringBuilder()).append("[setProgressBarIndeterminate] indeterminate: ").append(flag).toString();
        byte byte0;
        if (flag)
        {
            byte0 = -3;
        } else
        {
            byte0 = -4;
        }
        setFeatureInt(2, byte0);
    }

    public void setProgressBarIndeterminateVisibility(boolean flag)
    {
        (new StringBuilder()).append("[setProgressBarIndeterminateVisibility] visible: ").append(flag).toString();
        byte byte0;
        if (flag)
        {
            byte0 = -1;
        } else
        {
            byte0 = -2;
        }
        setFeatureInt(5, byte0);
    }

    public void setProgressBarVisibility(boolean flag)
    {
        (new StringBuilder()).append("[setProgressBarVisibility] visible: ").append(flag).toString();
        byte byte0;
        if (flag)
        {
            byte0 = -1;
        } else
        {
            byte0 = -2;
        }
        setFeatureInt(2, byte0);
    }

    public void setSecondaryProgress(int i)
    {
        (new StringBuilder()).append("[setSecondaryProgress] secondaryProgress: ").append(i).toString();
        setFeatureInt(2, i + 20000);
    }

    public void setTitle(CharSequence charsequence)
    {
        (new StringBuilder()).append("[setTitle] title: ").append(charsequence).toString();
        dispatchTitleChanged(charsequence, 0);
    }

    public void setUiOptions(int i)
    {
        (new StringBuilder()).append("[setUiOptions] uiOptions: ").append(i).toString();
        mUiOptions = i;
    }

    public void setUiOptions(int i, int j)
    {
        (new StringBuilder()).append("[setUiOptions] uiOptions: ").append(i).append(", mask: ").append(j).toString();
        mUiOptions = mUiOptions & ~j | i & j;
    }

    public ActionMode startActionMode(com.actionbarsherlock.view.ActionMode.Callback callback)
    {
        (new StringBuilder()).append("[startActionMode] callback: ").append(callback).toString();
        if (mActionMode != null)
        {
            mActionMode.finish();
        }
        ActionModeCallbackWrapper actionmodecallbackwrapper = new ActionModeCallbackWrapper(callback);
        initActionBar();
        Object obj;
        if (aActionBar != null)
        {
            obj = aActionBar.startActionMode(actionmodecallbackwrapper);
        } else
        {
            obj = null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        mActionMode = ((ActionMode) (obj));
_L4:
        if (mActionMode != null && (mActivity instanceof com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener))
        {
            ((com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener)mActivity).onActionModeStarted(mActionMode);
        }
        return mActionMode;
_L2:
        if (mActionModeView == null)
        {
            obj = (ViewStub)mDecor.findViewById(com.actionbarsherlock.R.id.abs__action_mode_bar_stub);
            if (obj != null)
            {
                mActionModeView = (ActionBarContextView)((ViewStub) (obj)).inflate();
            }
        }
        if (mActionModeView != null)
        {
            mActionModeView.killMode();
            obj = new StandaloneActionMode(mActivity, mActionModeView, actionmodecallbackwrapper, true);
            if (callback.onCreateActionMode(((ActionMode) (obj)), ((ActionMode) (obj)).getMenu()))
            {
                ((ActionMode) (obj)).invalidate();
                mActionModeView.initForMode(((ActionMode) (obj)));
                mActionModeView.setVisibility(0);
                mActionMode = ((ActionMode) (obj));
                mActionModeView.sendAccessibilityEvent(32);
            } else
            {
                mActionMode = null;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }








/*
    static ActionMode access$502(ActionBarSherlockCompat actionbarsherlockcompat, ActionMode actionmode)
    {
        actionbarsherlockcompat.mActionMode = actionmode;
        return actionmode;
    }

*/



}
