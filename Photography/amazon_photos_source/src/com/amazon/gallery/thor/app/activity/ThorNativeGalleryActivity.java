// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.WhisperplayConnectionEvent;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.messaging.ContentConfigurationEvent;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.GridActivityParams;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.activity.SingleViewActivity;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.kindle.fragment.FragmentController;
import com.amazon.gallery.framework.kindle.fragment.OnBackPressedHandler;
import com.amazon.gallery.framework.kindle.fragment.ViewFragment;
import com.amazon.gallery.framework.kindle.notifications.NewPromotionNotificationHandler;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import com.amazon.gallery.thor.app.fragment.ThorFragmentController;
import com.amazon.gallery.thor.camera.CameraMediaLoaderTask;
import com.amazon.gallery.thor.camera.ThorLaunchCamera;
import com.amazon.gallery.thor.cds.CDSSyncHandler;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.di.NativeActivityBeans;
import com.amazon.gallery.thor.ftue.ThorFTUEActivity;
import com.amazon.gallery.whisperplay.WhisperPlayConnectionManager;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorSettingsActivity, SignInActivity, ManageStorageActivity

public class ThorNativeGalleryActivity extends NativeGalleryActivity
{

    private static final long PROMOTION_DISPLAY_TIMEOUT;
    private static final String TAG = com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity.getName();

    public ThorNativeGalleryActivity()
    {
        super(new GridActivityParams(-1, com/amazon/gallery/thor/app/activity/ThorSettingsActivity, new ThorLaunchCamera(), new NativeActivityBeans()));
    }

    private void checkSignedIn()
    {
        if (BuildFlavors.isAosp() && !(new AospPreferences(this)).signedIn())
        {
            Intent intent = new Intent(this, com/amazon/gallery/thor/app/activity/SignInActivity);
            if (getFragmentController() != null && getFragmentController().getInChooserMode())
            {
                intent.putExtra("intent_extra_came_from_chooser", true);
            }
            startActivity(intent);
            finish();
        }
    }

    protected MediaContentConfiguration createMediaContentConfiguration()
    {
        if (getIntent().hasExtra("useSavedContentConfiguration"))
        {
            MediaContentConfiguration mediacontentconfiguration = ((WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER)).getContentConfiguration();
            if (mediacontentconfiguration != null)
            {
                return mediacontentconfiguration;
            }
        }
        return super.createMediaContentConfiguration();
    }

    protected SyncHandler createSyncHandler()
    {
        if (!featureChecker.hasCloudSync())
        {
            return null;
        } else
        {
            return new CDSSyncHandler(this, (SyncManager)getApplicationBean(Keys.SYNC_MANAGER), (AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER), (CloudDriveServiceClientManager)getApplicationBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER), photosDemoManager);
        }
    }

    protected Class getFtueActivity()
    {
        if (featureChecker.hasFTUE())
        {
            return com/amazon/gallery/thor/ftue/ThorFTUEActivity;
        } else
        {
            return null;
        }
    }

    protected Class getLauncherActivityClass()
    {
        return com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity;
    }

    protected boolean isForceGridMode()
    {
        if (!FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY))
        {
            return false;
        } else
        {
            return ((WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER)).isWhisperPlayModeEnabled();
        }
    }

    public void onBackPressed()
    {
        android.support.v4.app.Fragment fragment = fragmentController.getFragment();
        Intent intent1 = getIntent();
        if ((fragment instanceof OnBackPressedHandler) && ((OnBackPressedHandler)fragment).onBackPressed())
        {
            if (!(fragment instanceof ViewFragment))
            {
                notificationManager.notifyViewStateChange(contentConfiguration.toViewDescriptor(), true);
            }
            return;
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 0 && (intent1.getBooleanExtra("fromAddToAlbumAction", false) || intent1.getBooleanExtra("cameFromViewAlbumAction", false)))
        {
            Intent intent = new Intent(this, getLauncherActivityClass());
            intent.setAction("com.amazon.photos.INTERNAL");
            startActivity(intent);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        checkSignedIn();
        int i = featureChecker.getScreenOrientation();
        if (getRequestedOrientation() != i)
        {
            setRequestedOrientation(i);
        }
    }

    public void onPause()
    {
        super.onPause();
        if (featureChecker.hasWhisperplay())
        {
            ((WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER)).onPause(this);
        }
        if (navPaneController != null && featureChecker.hasLeftPanel())
        {
            navPaneController.onPause();
        }
        GlobalMessagingBus.unregister(this);
    }

    public void onResume()
    {
        Intent intent;
        TimeTracker.log("Activity.onResume start");
        GlobalMessagingBus.register(this);
        super.onResume();
        intent = getIntent();
        if (!CameraMediaLoaderTask.hasCameraLoaderExtras(intent) || configurationHasCameraContentLoadingScreen()) goto _L2; else goto _L1
_L1:
        intent.removeExtra("media_loader_task_object_id");
        intent.removeExtra("media_loader_task_media_task");
_L4:
        (new AsyncTask() {

            final ThorNativeGalleryActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                if (hasWhisperplay.isInDemoMode() || !(new MAPAccountManager(ThorNativeGalleryActivity.this)).isDeviceRegistered())
                {
                    ((ThorGalleryApplication)getApplication()).onFirstSyncCompleted();
                }
                if (WHISPER_PLAY_CONNECTION_MANAGER.hasWhisperplay())
                {
                    ((WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER)).initWithActivity(ThorNativeGalleryActivity.this, false);
                }
                return null;
            }

            
            {
                this$0 = ThorNativeGalleryActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        TimeTracker.log("Activity.onResume finish");
        return;
_L2:
        if (fragmentController != null && fragmentController.getFragment() == null)
        {
            launchFragment();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onWhisperplayConnectionEvent(WhisperplayConnectionEvent whisperplayconnectionevent)
    {
        setWhisperPlayModeEnabled(whisperplayconnectionevent.deviceConnected);
    }

    public ContentConfigurationEvent produceContentConfiguration()
    {
        return new ContentConfigurationEvent(contentConfiguration);
    }

    protected void recordOnResumeMetrics()
    {
        if (getIntent().getBooleanExtra("mediaDynamicAlbum", false))
        {
            albumsProfiler.trackEvent(com.amazon.gallery.thor.albums.AlbumsMetricsHelper.MetricsEvent.PhotoAlbumViewAll);
        }
    }

    public void setActivityContentView()
    {
        setContentView(0x7f0300ec);
    }

    public void setWhisperPlayModeEnabled(boolean flag)
    {
        super.setWhisperPlayModeEnabled(flag);
    }

    protected void setupFragmentController()
    {
        fragmentController = new ThorFragmentController(this, getSupportFragmentManager(), featureChecker);
    }

    public boolean shouldSetIntent(Intent intent)
    {
        if (intent.hasExtra(SingleViewActivity.TAG))
        {
            return false;
        } else
        {
            return super.shouldSetIntent(intent);
        }
    }

    protected void showPromotionIfNeeded()
    {
        (new AsyncTask() {

            final ThorNativeGalleryActivity this$0;

            protected transient com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache.Promotion doInBackground(Void avoid[])
            {
                avoid = (SubscriptionInfoCache)getApplicationBean(Keys.SUBSCRIPTION_INFO_CACHE);
                Object obj = (FreeTime)getApplicationBean(AppKeys.THOR_FREE_TIME);
                if (avoid.getPromotionCheckOccurredInThisSession() || !getFTUEActionWhiteList().contains(getIntent().getAction()) || 
// JavaClassFileOutputException: get_constant: invalid tag

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache.Promotion promotion)
            {
                if (promotion != null)
                {
                    GalleryWebViewHelper.startPromotion(ThorNativeGalleryActivity.this, com/amazon/gallery/thor/app/activity/ManageStorageActivity, promotion);
                    overridePendingTransition(0x7f040024, 0x7f040024);
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache.Promotion)obj);
            }

            
            {
                this$0 = ThorNativeGalleryActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static 
    {
        PROMOTION_DISPLAY_TIMEOUT = TimeUnit.SECONDS.toMillis(10L);
    }





}
