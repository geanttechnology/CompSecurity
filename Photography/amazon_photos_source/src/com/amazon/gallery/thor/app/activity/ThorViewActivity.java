// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.ui.layout.LayoutType;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.gallery.messaging.VideoViewerErrorEvent;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.kindle.fragment.FragmentController;
import com.amazon.gallery.framework.kindle.fragment.MediaLoaderTask;
import com.amazon.gallery.framework.kindle.ftue.AbstractNoContentOverlay;
import com.amazon.gallery.framework.kindle.ftue.LoadingContentViewFragment;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.fragment.ThorFragmentController;
import com.amazon.gallery.thor.camera.ThorLaunchCamera;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.di.GalleryActivityBeans;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            MediaContentConfigurationHolder

public class ThorViewActivity extends CommonActivity
    implements MediaContentConfigurationHolder
{

    public static final String TAG = com/amazon/gallery/thor/app/activity/ThorViewActivity.getName();
    protected MediaContentConfiguration contentConfiguration;
    protected FragmentController fragmentController;

    public ThorViewActivity()
    {
        super(new GalleryActivityBeans(), new ThorLaunchCamera());
    }

    private boolean isMediaStoreSyncRequired()
    {
        return "com.amazon.gallery.provider.internal".equals(getIntent().getData().getAuthority()) && !parentalblocked();
    }

    private void launchFragment()
    {
        contentConfiguration = IntentUtil.createMediaContentConfigBuilderFromIntent(this, getIntent()).withViewDescriptor(new ViewDescriptor()).withSortType(MediaItemSortType.DATE_TAKEN_DESC).build();
        if (contentConfiguration == null)
        {
            GLogger.errorStackTrace(TAG, "Error creating MediaContentConfiguration from intent: %s", new Object[] {
                getIntent()
            });
            finish();
            return;
        } else
        {
            contentConfiguration.toViewDescriptor().setCollectionSize(1);
            fragmentController.onNavigateTo(LayoutType.SINGLE, contentConfiguration, 0);
            return;
        }
    }

    protected void createNoContentOverlay()
    {
        noContentOverlay = new AbstractNoContentOverlay((Profiler)getBean(Keys.PROFILER), (SyncManager)getApplicationBean(Keys.SYNC_MANAGER), (MediaStoreSyncProvider)getApplicationBean(Keys.MEDIA_STORE_SYNC_PROVIDER), (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY), (AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER)) {

            final ThorViewActivity this$0;

            public int getNoContentViewId()
            {
                return 0x7f0c0185;
            }

            protected void setNoContentFragment()
            {
                fragment = new LoadingContentViewFragment();
            }

            
            {
                this$0 = ThorViewActivity.this;
                super(profiler, syncmanager, mediastoresyncprovider, networkconnectivity, authenticationmanager);
            }
        };
    }

    protected SyncHandler createSyncHandler()
    {
        return null;
    }

    protected String getAccessibilityDescription()
    {
        String s = null;
        if (((FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER)).hasSingleLayout())
        {
            s = "Preview";
        }
        return s;
    }

    public MediaContentConfiguration getMediaContentConfiguration()
    {
        return contentConfiguration;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300d8);
        bundle = (FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER);
        fragmentController = new ThorFragmentController(this, getSupportFragmentManager(), bundle);
        setRequestedOrientation(bundle.getScreenOrientation());
        GlobalMessagingBus.register(this);
    }

    public void onDestroy()
    {
        super.onDestroy();
        GlobalMessagingBus.unregister(this);
    }

    public void onResume()
    {
        GLogger.i(TAG, "onResume", new Object[0]);
        super.onResume();
        if (isMediaStoreSyncRequired())
        {
            (new MediaLoaderTask(this, new Runnable() {

                final ThorViewActivity this$0;

                public void run()
                {
                    launchFragment();
                }

            
            {
                this$0 = ThorViewActivity.this;
                super();
            }
            })).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            launchFragment();
            return;
        }
    }

    protected void onSyncMediaStore()
    {
    }

    public void onVideoViewError(VideoViewerErrorEvent videoviewererrorevent)
    {
        finish();
    }


}
