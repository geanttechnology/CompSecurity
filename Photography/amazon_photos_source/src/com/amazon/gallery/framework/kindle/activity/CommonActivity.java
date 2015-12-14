// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.ToggleContentObserverEvent;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.TagAwareMediaStoreSyncProviderImpl;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.print.GalleryPrintContext;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.kindle.CameraUtils;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.LaunchCamera;
import com.amazon.gallery.framework.kindle.ParentalControl;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.kindle.ftue.ShowOverlayListener;
import com.amazon.gallery.framework.kindle.ui.NoContentOverlay;
import com.amazon.gallery.framework.kindle.util.KindleSearch;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.framework.network.throttle.NetworkThrottle;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.watchdog.AutoSaveManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.authentication.AccountStateManager;
import com.amazon.gallery.thor.app.service.WhisperUploadManager;
import com.amazon.gallery.thor.ftue.ThorNoContentOverlay;
import com.amazon.gallery.thor.packageupdate.PackageUpdateDialogManagerWrapper;
import com.bumptech.glide.Glide;
import com.google.common.collect.Sets;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            WhisperPlayActivity

public abstract class CommonActivity extends BeanAwareActivity
    implements WhisperPlayActivity
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent OrientationChanged;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/activity/CommonActivity$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            OrientationChanged = new MetricsEvent("OrientationChanged", 0);
            $VALUES = (new MetricsEvent[] {
                OrientationChanged
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String TAG = com/amazon/gallery/framework/kindle/activity/CommonActivity.getName();
    private AccountStateManager accountManager;
    private SharedPreferences accountSharedPref;
    protected ComponentProfiler albumsProfiler;
    protected ComponentProfiler commonProfiler;
    protected DialogManager dialogManager;
    protected boolean dismissActiveDialog;
    private volatile boolean isWhisperPlayModeEnabled;
    protected final LaunchCamera launchCamera;
    private SyncHandler mSyncHandler;
    private NetworkThrottle networkThrottle;
    protected NoContentOverlay noContentOverlay;
    protected ViewNotificationManager notificationManager;
    private ParentalControl parentalControl;
    protected PhotosDemoManager photosDemoManager;
    private boolean resumed;
    private boolean shouldToggleContentObserver;

    public CommonActivity(BeanFactory beanfactory, LaunchCamera launchcamera)
    {
        super(beanfactory);
        isWhisperPlayModeEnabled = false;
        dismissActiveDialog = true;
        resumed = false;
        notificationManager = new ViewNotificationManager();
        shouldToggleContentObserver = true;
        launchCamera = launchcamera;
    }

    public static String getStartedFtueFlag(Context context, BeanFactory beanfactory)
    {
        if (((AuthenticationManager)beanfactory.getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount())
        {
            return "started_ftue_flag";
        } else
        {
            return "unregistered_started_ftue_flag";
        }
    }

    private SyncHandler getSyncHandler()
    {
        DebugAssert.verifyOnTheMainThread();
        if (mSyncHandler == null)
        {
            mSyncHandler = createSyncHandler();
        }
        return mSyncHandler;
    }

    private void isAccountChanged()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        String s1;
        s = accountSharedPref.getString("accountID", null);
        s1 = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        if (s != null || s1 == null) goto _L2; else goto _L1
_L1:
        accountManager.registerAccount(this);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (s.equals(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
        accountManager.removeAccount(this);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static void logLaunchTime(Intent intent)
    {
        long l = intent.getLongExtra("launchTime", -1L);
        if (l == -1L)
        {
            return;
        } else
        {
            TimeTracker.log((new StringBuilder()).append("(SINCE INTENT CREATED TO START TRACKING LAUNCH: ").append(SystemClock.uptimeMillis() - l).append(")").toString());
            return;
        }
    }

    protected boolean autoSaveDialogsEnabled()
    {
        return true;
    }

    protected void createNoContentOverlay()
    {
        noContentOverlay = new ThorNoContentOverlay((Profiler)getBean(Keys.PROFILER), (SyncManager)getApplicationBean(Keys.SYNC_MANAGER), (MediaStoreSyncProvider)getApplicationBean(Keys.MEDIA_STORE_SYNC_PROVIDER), (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY), (AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER));
    }

    protected abstract SyncHandler createSyncHandler();

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        GLogger.d(TAG, "dispatchPopulateAccessibilityEvent: %s", new Object[] {
            accessibilityevent
        });
        if (accessibilityevent.getEventType() == 32)
        {
            accessibilityevent.setContentDescription(getAccessibilityDescription());
        }
        return super.dispatchPopulateAccessibilityEvent(accessibilityevent);
    }

    protected void fetchBeans()
    {
        ((ThorGalleryApplication)getApplication()).initCommonAppBeans();
        dialogManager = (DialogManager)getApplicationBean(Keys.DIALOG_MANAGER);
        parentalControl = (ParentalControl)getApplicationBean(Keys.PARENTAL_CONTROL);
        photosDemoManager = (PhotosDemoManager)getApplicationBean(Keys.DEMO_MANAGER);
        networkThrottle = (NetworkThrottle)getApplicationBean(Keys.NETWORK_THROTTLE);
    }

    protected abstract String getAccessibilityDescription();

    protected Set getFTUEActionWhiteList()
    {
        return Sets.newHashSet(new String[] {
            "com.amazon.photos.CMS", "android.intent.action.MAIN", "com.amazon.photos.LAUNCH_PHOTOS", "com.amazon.gallery.LAUNCH_VIDEOS", "com.amazon.photos.INTERNAL", "com.amazon.gallery.LAUNCH_NEW_PROMOTION_NOTIFICATION"
        });
    }

    protected Class getFtueActivity()
    {
        return null;
    }

    public boolean getLocalView()
    {
        return false;
    }

    public NoContentOverlay getNoContentOverlay()
    {
        return noContentOverlay;
    }

    protected Class getSettingsIntent()
    {
        return null;
    }

    protected ShowOverlayListener getShowOverlayListener()
    {
        return null;
    }

    public ViewNotificationManager getViewNotificationManager()
    {
        return notificationManager;
    }

    protected boolean isActivityResumed()
    {
        return resumed;
    }

    public boolean isDeviceCameraEnabled()
    {
        return CameraUtils.isCameraAvailable(this);
    }

    protected boolean isSyncAllowed()
    {
        return true;
    }

    public boolean isWhisperPlayModeEnabled()
    {
        return isWhisperPlayModeEnabled;
    }

    public void navigateToCamera(View view)
    {
        if (launchCamera != null)
        {
            launchCamera.launchCamera(this);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        commonProfiler.trackEvent(MetricsEvent.OrientationChanged);
    }

    public void onCreate(Bundle bundle)
    {
        fetchBeans();
        super.onCreate(bundle);
        createNoContentOverlay();
        if (bundle != null && bundle.containsKey("TIME"))
        {
            long l = bundle.getLong("TIME");
            if (SystemClock.uptimeMillis() - l < 5000L)
            {
                dismissActiveDialog = false;
            }
        }
        ((SubscriptionInfoCache)getApplicationBean(Keys.SUBSCRIPTION_INFO_CACHE)).onCreate();
        accountSharedPref = getSharedPreferences("accountpref", 0);
        accountManager = (AccountStateManager)getApplicationBean(Keys.ACCOUNT_STATE_MANAGER);
        setupMetricProfilers();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        GalleryPrintContext galleryprintcontext = (GalleryPrintContext)getBean(Keys.PRINT_CONTEXT);
        if (galleryprintcontext != null)
        {
            galleryprintcontext.destroyPrintContext();
        }
        notificationManager.clearListeners();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        if (shouldSetIntent(intent))
        {
            setIntent(intent);
        }
    }

    protected void onPause()
    {
        if (shouldToggleContentObserver)
        {
            GlobalMessagingBus.post(new ToggleContentObserverEvent(false));
        }
        resumed = false;
        super.onPause();
        noContentOverlay.detach();
        closeOptionsMenu();
        networkThrottle.stopThrottleThread();
        ((AutoSaveManager)getApplicationBean(Keys.AUTO_SAVE_MANAGER)).setContext(null);
        SyncHandler synchandler = getSyncHandler();
        if (synchandler != null)
        {
            synchandler.stopSyncObservation();
        }
        ((WhisperUploadManager)getApplicationBean(Keys.WHISPER_UPLOAD_MANAGER)).scheduleBackgroundSync();
    }

    protected void onResume()
    {
        if (!BuildFlavors.isAosp())
        {
            isAccountChanged();
        }
        logLaunchTime(getIntent());
        super.onResume();
        resumed = true;
        if (parentalblocked())
        {
            parentalControl.promptAndFinish(this);
        }
        if (dismissActiveDialog)
        {
            dialogManager.dismissActiveAndPendingDialogs();
        }
        onSyncMediaStore();
        dismissActiveDialog = true;
        if (((AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount())
        {
            networkThrottle.startThrottleThread();
        }
        if (autoSaveDialogsEnabled())
        {
            ((AutoSaveManager)getApplicationBean(Keys.AUTO_SAVE_MANAGER)).setContext(this);
        }
        (new PackageUpdateDialogManagerWrapper(getPackageName())).showUpdateDialogIfNeeded(this);
        setupNoContentOverlay();
        SyncHandler synchandler = getSyncHandler();
        if (synchandler != null)
        {
            synchandler.scheduleSync();
        }
        ((WhisperUploadManager)getApplicationBean(Keys.WHISPER_UPLOAD_MANAGER)).scheduleForegroundSync(false, TAG);
        if (shouldToggleContentObserver)
        {
            GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
        }
        recordOnResumeMetrics();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putLong("TIME", SystemClock.uptimeMillis());
        super.onSaveInstanceState(bundle);
    }

    public boolean onSearchRequested()
    {
        return KindleSearch.launchSearch(this);
    }

    protected void onStop()
    {
        super.onStop();
    }

    protected void onSyncMediaStore()
    {
        if (!isSyncAllowed())
        {
            GLogger.i(TAG, "Skipping mediaStore sync", new Object[0]);
            return;
        } else
        {
            (new AsyncTask() {

                final CommonActivity this$0;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    ((MediaStoreSyncProvider)getApplicationBean(Keys.MEDIA_STORE_SYNC_PROVIDER)).syncMediaStoreAsync();
                    return null;
                }

            
            {
                this$0 = CommonActivity.this;
                super();
            }
            }).executeOnExecutor(TagAwareMediaStoreSyncProviderImpl.SERIAL_EXECUTOR, new Void[0]);
            return;
        }
    }

    public void onTrimMemory(int i)
    {
        super.onTrimMemory(i);
        GLogger.i(TAG, "Trim Memory level %s", new Object[] {
            Integer.valueOf(i)
        });
        Glide.get(this).trimMemory(i);
    }

    protected boolean parentalblocked()
    {
        return parentalControl.isBlocked(this);
    }

    protected void recordOnResumeMetrics()
    {
    }

    public void setLocalView(boolean flag)
    {
    }

    public void setWhisperPlayModeEnabled(boolean flag)
    {
        isWhisperPlayModeEnabled = flag;
    }

    protected void setupMetricProfilers()
    {
        commonProfiler = new ComponentProfiler((Profiler)getApplicationBean(Keys.PROFILER), com/amazon/gallery/framework/kindle/activity/CommonActivity);
        albumsProfiler = new ComponentProfiler((Profiler)getApplicationBean(Keys.PROFILER), "AlbumsMetrics");
    }

    protected void setupNoContentOverlay()
    {
        if (!noContentOverlay.isAttached())
        {
            noContentOverlay.attach(this, new Handler(), getShowOverlayListener());
        }
    }

    public boolean shouldSetIntent(Intent intent)
    {
        return true;
    }

    protected boolean showFTUEIfNeeded()
    {
        SharedPreferences sharedpreferences;
        boolean flag1;
        sharedpreferences = getSharedPreferences("galleryKindleSharedPrefs", 0);
        flag1 = false;
        if (getIntent().getStringExtra("FORCE_FTUE") == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        flag = true;
        getIntent().removeExtra("FORCE_FTUE");
_L4:
        if (BuildFlavors.isAosp() && !((DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE)).isTablet())
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (getIntent().getBooleanExtra("intent_extra_came_from_sign_in", false))
        {
            flag = true;
            getIntent().removeExtra("intent_extra_came_from_sign_in");
            if (getIntent().getBooleanExtra("intent_extra_came_from_chooser", false))
            {
                flag = false;
            }
        } else
        if (sharedpreferences.getBoolean("FORCE_FTUE", false))
        {
            flag = true;
            sharedpreferences.edit().putBoolean("FORCE_FTUE", false).apply();
        } else
        {
            flag = flag1;
            if (getFTUEActionWhiteList().contains(getIntent().getAction()))
            {
                flag = flag1;
                if (!photosDemoManager.isInDemoMode())
                {
                    flag = flag1;
                    if (!getSharedPreferences("galleryKindleSharedPrefs", 0).getBoolean(getStartedFtueFlag(this, getApplicationBeanFactory()), false))
                    {
                        flag = true;
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (flag && getFtueActivity() != null)
        {
            startActivityForResult(new Intent(this, getFtueActivity()), 99);
            return true;
        } else
        {
            return false;
        }
    }

}
