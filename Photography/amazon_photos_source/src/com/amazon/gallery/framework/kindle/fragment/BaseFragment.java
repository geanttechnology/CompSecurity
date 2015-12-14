// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanKey;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.kindle.ui.ActivityIndicatorCheckThread;
import com.amazon.gallery.framework.kindle.ui.NavigationBar;
import com.amazon.gallery.framework.kindle.ui.NetworkIndicator;
import com.amazon.gallery.framework.kindle.ui.ScreenUtil;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.albums.AddToAlbumChooserActionBar;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.activity.ChooserActionBar;
import com.amazon.gallery.thor.app.activity.FreetimeActionBar;
import com.amazon.gallery.thor.app.activity.ThorActionBar;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            OnBackPressedHandler, FragmentController, StateFragment

public abstract class BaseFragment extends Fragment
    implements android.view.View.OnSystemUiVisibilityChangeListener, OnBackPressedHandler
{

    protected ActivityIndicatorCheckThread mActivityIndicatorCheckThread;
    protected FeatureChecker mFeatureChecker;
    protected GridStatus mGridStatus;
    protected ThorActionBar mNavigationBar;
    private ViewNotificationManager mNotificationManager;
    protected ScreenModeManager mScreenModeManager;
    protected ViewFactory mViewFactory;
    private final ViewStateListener mViewStateListener = new NoOpViewStateListener() {

        final BaseFragment this$0;

        public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
        {
            if (viewdescriptor.getMediaProperty() == CommonMediaProperty.CAMERA)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mActivityIndicatorCheckThread.getNetworkIndicator().setIsLocalView(flag);
            getActivity().getWindow().getDecorView().sendAccessibilityEvent(32);
        }

            
            {
                this$0 = BaseFragment.this;
                super();
            }
    };

    public BaseFragment()
    {
        setArguments(new Bundle());
    }

    protected void createActionBar(ViewGroup viewgroup)
    {
        boolean flag1 = true;
        viewgroup = (Toolbar)viewgroup.findViewById(0x7f0c0086);
        if (mFeatureChecker.hasFreetimeActionBar())
        {
            mNavigationBar = new FreetimeActionBar((BeanAwareActivity)getActivity(), isInNavBarDecorMode(), viewgroup);
            setUpActionBar(mNavigationBar, getActionBarMenuId(), -1, getSortingChangedListener());
        } else
        if (getActivity() instanceof NativeGalleryActivity)
        {
            Object obj = (NativeGalleryActivity)getActivity();
            PhotosNavigationPane photosnavigationpane = ((NativeGalleryActivity) (obj)).getNavPane();
            if (mFeatureChecker.hasLeftPanel() && photosnavigationpane != null)
            {
                photosnavigationpane.addSidePanelListener(new NoOpSidePanelListener() {

                    final BaseFragment this$0;

                    public void onNavigate(MenuItem menuitem)
                    {
                        BaseFragment.this.onNavigate(menuitem);
                    }

            
            {
                this$0 = BaseFragment.this;
                super();
            }
                });
            }
            obj = ((NativeGalleryActivity) (obj)).getFragmentController();
            boolean flag;
            if (obj != null && ((FragmentController) (obj)).getInAddToAlbumChooserMode())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (obj == null || !((FragmentController) (obj)).getInChooserMode())
            {
                flag1 = false;
            }
            if (obj != null && (flag1 || flag))
            {
                if (flag)
                {
                    mNavigationBar = new AddToAlbumChooserActionBar((BeanAwareActivity)getActivity(), viewgroup);
                    mNavigationBar.setTitle(getString(0x7f0e01db));
                } else
                {
                    mNavigationBar = new ChooserActionBar((BeanAwareActivity)getActivity(), viewgroup);
                }
            } else
            {
                mNavigationBar = new ThorActionBar(photosnavigationpane, (BeanAwareActivity)getActivity(), isInNavBarDecorMode(), viewgroup);
            }
            setUpActionBar(mNavigationBar, getActionBarMenuId(), 0x7f100014, getSortingChangedListener());
            return;
        }
    }

    protected void enterFullScreen()
    {
        enterFullScreen(false);
    }

    protected void enterFullScreen(boolean flag)
    {
        if ((mNavigationBar == null || mScreenModeManager.isFullScreen()) && !flag)
        {
            return;
        } else
        {
            mScreenModeManager.setScreenMode(getFullScreenMode(), getActivity());
            updateIndicatorMargins();
            return;
        }
    }

    protected void exitFullScreen()
    {
        exitFullScreen(false);
    }

    protected void exitFullScreen(boolean flag)
    {
        if ((mNavigationBar == null || !mScreenModeManager.isFullScreen()) && !flag)
        {
            return;
        } else
        {
            mScreenModeManager.setScreenMode(getStableScreenMode(), getActivity());
            updateIndicatorMargins();
            return;
        }
    }

    protected int getActionBarMenuId()
    {
        if (mFeatureChecker.hasFreetimeActionBar())
        {
            return !mFeatureChecker.alwaysTransparentHAB() ? 0x7f100015 : 0x7f10000b;
        }
        return !getActivity().getIntent().hasExtra("navigationFromFolders") ? 0x7f10000e : -1;
    }

    public Object getApplicationBean(BeanKey beankey)
    {
        return ((BeanAwareActivity)getActivity()).getApplicationBean(beankey);
    }

    protected com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getDefaultScreenMode()
    {
        return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE;
    }

    protected com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getFullScreenMode()
    {
        return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN;
    }

    protected int getMarginsForIndicators()
    {
        if (mScreenModeManager.isFullScreen())
        {
            return 0;
        } else
        {
            return ScreenUtil.getNavigationBarHeightForPadding(getActivity());
        }
    }

    public NavigationBar getNavigationBar()
    {
        return mNavigationBar;
    }

    public com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getScreenMode()
    {
        return mScreenModeManager.getScreenMode();
    }

    protected abstract OnSortingChangedListener getSortingChangedListener();

    protected com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode getStableScreenMode()
    {
        return com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE;
    }

    protected void initActivityIndicator(GridStatus gridstatus, ViewGroup viewgroup)
    {
        mActivityIndicatorCheckThread = new ActivityIndicatorCheckThread(getActivity(), viewgroup, gridstatus, (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY));
        mActivityIndicatorCheckThread.start();
        mNotificationManager.addListener(mViewStateListener);
        updateIndicatorMargins();
    }

    protected boolean isInFullScreen()
    {
        return mScreenModeManager.isFullScreen();
    }

    protected abstract boolean isInNavBarDecorMode();

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (FeatureManager.isFeatureEnabled(Features.HEADER_ACTION_BAR))
        {
            createActionBar((ViewGroup)getView());
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (StateFragment.stateFragmentExists(getActivity()))
        {
            onRestoreState(bundle);
        }
        mNotificationManager = ((CommonActivity)getActivity()).getViewNotificationManager();
        mFeatureChecker = (FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER);
        mGridStatus = new GridStatus();
        mScreenModeManager = (ScreenModeManager)getApplicationBean(Keys.SCREEN_MODE_MANAGER);
        onPostCreate(bundle);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mNavigationBar != null)
        {
            mNavigationBar.onDestroy();
        }
        mActivityIndicatorCheckThread.onDestroy();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (mViewFactory != null)
        {
            mViewFactory.reset();
        }
        CommonActivity commonactivity = (CommonActivity)getActivity();
        if (commonactivity.getViewNotificationManager().hasViewStateListener(mViewStateListener))
        {
            commonactivity.getViewNotificationManager().removeListener(mViewStateListener);
        }
    }

    protected void onNavigate(MenuItem menuitem)
    {
    }

    public void onPause()
    {
        super.onPause();
        mActivityIndicatorCheckThread.onPause();
        getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
    }

    protected void onPostCreate(Bundle bundle)
    {
    }

    protected abstract void onRestoreState(Bundle bundle);

    public void onResume()
    {
        super.onResume();
        mActivityIndicatorCheckThread.onResume();
        resetScreenMode();
    }

    public void onSystemUiVisibilityChange(int i)
    {
        if (!BuildFlavors.isGen5() && mScreenModeManager.isFullScreen() && (i & 6) == 0)
        {
            exitFullScreen();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(this);
        initActivityIndicator(mGridStatus, (ViewGroup)view);
    }

    protected void resetScreenMode()
    {
        mScreenModeManager.setNotificationManager(mNotificationManager);
        com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode = mScreenModeManager.getScreenMode();
        if (screenmode == null || mScreenModeManager.shouldResetMode())
        {
            screenmode = getDefaultScreenMode();
        }
        mScreenModeManager.setScreenMode(screenmode, getActivity(), false);
        if (mNavigationBar == null)
        {
            return;
        }
        static class _cls3
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode = new int[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.FULL_SCREEN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.GRID_GEN5.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$amazon$ScreenModeManager$ScreenMode[com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.NORMAL_STABLE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode[screenmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            mNavigationBar.forceHide();
            return;

        case 3: // '\003'
        case 4: // '\004'
            mNavigationBar.forceShow();
            break;
        }
    }

    protected void setUpActionBar(ThorActionBar thoractionbar, int i, int j, OnSortingChangedListener onsortingchangedlistener)
    {
        thoractionbar.setup(i, j, 0x7f0c0290, onsortingchangedlistener);
        thoractionbar.setNotificationManager(mNotificationManager);
    }

    protected void updateIndicatorMargins()
    {
        if (!isInNavBarDecorMode())
        {
            return;
        } else
        {
            mActivityIndicatorCheckThread.updateMargins(getMarginsForIndicators());
            return;
        }
    }

    protected void updateNavigationBar(ViewDescriptor viewdescriptor)
    {
        if (mNavigationBar != null)
        {
            mNavigationBar.viewStateChanged(viewdescriptor);
            mNavigationBar.updateHeaderOptions(viewdescriptor, null);
        }
    }
}
