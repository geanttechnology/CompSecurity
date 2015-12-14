// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.app.KeyguardManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.Window;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.messaging.ContentConfigurationEvent;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.gallery.view.ViewStateListener;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.kindle.fragment.SingleViewFragment;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.ui.NavigationBar;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.thor.app.activity.ThorSettingsActivity;
import com.amazon.gallery.thor.camera.CameraMediaLoaderTask;
import com.amazon.gallery.thor.camera.ThorLaunchCamera;
import com.amazon.gallery.thor.di.NativeActivityBeans;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            NativeGalleryActivity, GridActivityParams

public class SingleViewActivity extends NativeGalleryActivity
{

    public static final String TAG = com/amazon/gallery/framework/kindle/activity/SingleViewActivity.getName();
    private boolean isInLockscreen;

    public SingleViewActivity()
    {
        super(new GridActivityParams(-1, com/amazon/gallery/thor/app/activity/ThorSettingsActivity, new ThorLaunchCamera(), new NativeActivityBeans()));
    }

    private int getNavigationBarHeightPx(int i)
    {
        Resources resources = getResources();
        String s;
        if (i == 1)
        {
            s = "navigation_bar_height";
        } else
        {
            s = "navigation_bar_height_landscape";
        }
        i = resources.getIdentifier(s, "dimen", "android");
        if (i > 0)
        {
            return resources.getDimensionPixelSize(i);
        } else
        {
            return 0;
        }
    }

    public void adjustSnackbarForSoftKeyBar()
    {
        Resources resources = getResources();
        android.widget.RelativeLayout.LayoutParams layoutparams;
        int i;
        if (BuildFlavors.isAosp())
        {
            i = getNavigationBarHeightPx(resources.getConfiguration().orientation);
        } else
        {
            i = (int)TypedValue.applyDimension(1, getResources().getDimensionPixelSize(0x7f0a0050), resources.getDisplayMetrics());
        }
        layoutparams = (android.widget.RelativeLayout.LayoutParams)((CoordinatorLayout)findViewById(0x7f0c0122)).getLayoutParams();
        if (resources.getConfiguration().orientation == 1)
        {
            layoutparams.setMargins(0, 0, 0, i);
            return;
        } else
        {
            layoutparams.setMargins(0, 0, i, 0);
            return;
        }
    }

    protected SyncHandler createSyncHandler()
    {
        return null;
    }

    protected boolean isSyncAllowed()
    {
        return false;
    }

    protected void launchFragment()
    {
        if (getIntent().getData() != null && configurationHasCameraContentLoadingScreen() && (cameraMediaLoaderTask == null || cameraMediaLoaderTask.getStatus() == android.os.AsyncTask.Status.FINISHED))
        {
            setupNoContentOverlay();
            waitForUriToScan();
        }
        notificationManager.notifyViewStateChange(contentConfiguration.toViewDescriptor(), true);
    }

    public void onBackPressed()
    {
        SingleViewFragment singleviewfragment = (SingleViewFragment)getSupportFragmentManager().findFragmentById(0x7f0c01e2);
        if (singleviewfragment != null)
        {
            com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode screenmode = singleviewfragment.getScreenMode();
            Intent intent1 = new Intent();
            boolean flag = false;
            if (screenmode == com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN)
            {
                flag = true;
            }
            intent1.putExtra(com.amazon.gallery.framework.kindle.amazon.ScreenModeManager.ScreenMode.SUPER_FULL_SCREEN.toString(), flag);
            setResult(-1, intent1);
            singleviewfragment.onBackPressed();
        }
        if (IntentUtil.isLaunchedByCamera(getIntent()) && !BuildFlavors.isDuke())
        {
            Intent intent = IntentUtil.getCameraRollIntent();
            intent.setFlags(0x10008000);
            startActivity(intent);
            finish();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = (SingleViewFragment)getSupportFragmentManager().findFragmentById(0x7f0c01e2);
        if (configuration != null)
        {
            configuration.getNavigationBar().getViewStateListener().onRotation();
        }
    }

    public void onCreate(Bundle bundle)
    {
        isInLockscreen = ((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        super.onCreate(bundle);
        overridePendingTransition(0x7f040020, 0x7f040021);
    }

    public void onPause()
    {
        super.onPause();
        GlobalMessagingBus.unregister(this);
        overridePendingTransition(0x7f040020, 0x7f040021);
        if (isInLockscreen && !isFinishing())
        {
            finish();
        }
    }

    public void onResume()
    {
        super.onResume();
        GlobalMessagingBus.register(this);
    }

    public void onStop()
    {
        super.onStop();
        if (isInLockscreen)
        {
            getWindow().clearFlags(0x680080);
        }
    }

    public ContentConfigurationEvent produceContentConfiguration()
    {
        return new ContentConfigurationEvent(contentConfiguration);
    }

    public void setActivityContentView()
    {
        if (isInLockscreen)
        {
            getWindow().addFlags(0x680080);
        }
        setContentView(0x7f0300d7);
    }

    protected void setupNavPane()
    {
        super.setupNavPane();
        navPane.addSidePanelListener(new NoOpSidePanelListener() {

            final SingleViewActivity this$0;

            public void onNavigate(MenuItem menuitem)
            {
                super.onNavigate(menuitem);
                if (menuitem.getItemId() != 0x7f0c0270)
                {
                    finish();
                }
            }

            
            {
                this$0 = SingleViewActivity.this;
                super();
            }
        });
    }

}
