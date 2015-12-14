// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreHelper;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.metrics.NavigationMetrics;
import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.gallery.view.ViewNotificationManager;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.config.GalleryViewConfigWrapper;
import com.amazon.gallery.framework.kindle.metrics.UIClickMetrics;
import com.amazon.gallery.framework.kindle.ui.ActivityIndicatorCheckThread;
import com.amazon.gallery.framework.kindle.ui.NavigationBar;
import com.amazon.gallery.framework.kindle.ui.NetworkIndicator;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CommonActivity, GridActivityParams, AdLaunchHelper, LaunchSourceMetrics

public abstract class BasicListActivity extends CommonActivity
    implements AccountChangeListener
{

    private static final String TAG = com/amazon/gallery/framework/kindle/activity/BasicListActivity.getName();
    private ActivityIndicatorCheckThread activityIndicatorCheckThread;
    protected GridActivityParams activityParams;
    protected AuthenticationManager authenticationManager;
    protected UIClickMetrics clickMetrics;
    protected boolean ftueLaunched;
    private volatile boolean instantAnimation;
    protected ViewFactory itemViewFactory;
    protected AbsListView listView;
    protected MediaItemDao mediaItemDao;
    protected MediaStoreHelper mediaStoreHelper;
    protected NavigationBar navigationBar;
    protected NetworkConnectivity networkConnectivity;
    private Long openTime;
    protected int orientation;
    protected RestClient restClient;
    private View statusBar;
    private final VisibilityAnimator statusBarAnimator = new VisibilityAnimator() {

        final BasicListActivity this$0;

        protected long getDuration()
        {
            return !instantAnimation ? 375L : 0L;
        }

        protected ObjectAnimator getHideAnimator()
        {
            int j = statusBar.getHeight();
            int i = j;
            if (j == 0)
            {
                statusBar.measure(0, 0);
                i = statusBar.getMeasuredHeight();
            }
            View view = statusBar;
            float f;
            if (i != 0)
            {
                f = -i;
            } else
            {
                f = -100F;
            }
            return ObjectAnimator.ofFloat(view, "translationY", new float[] {
                f
            });
        }

        protected volatile ValueAnimator getHideAnimator()
        {
            return getHideAnimator();
        }

        protected ObjectAnimator getShowAnimator()
        {
            return ObjectAnimator.ofFloat(statusBar, "translationY", new float[] {
                0.0F
            });
        }

        protected volatile ValueAnimator getShowAnimator()
        {
            return getShowAnimator();
        }

        protected void onHidden()
        {
        }

            
            {
                this$0 = BasicListActivity.this;
                super();
            }
    };
    protected GridStatus statusTracker;
    protected TagDao tagDao;
    private String title;

    public BasicListActivity(GridActivityParams gridactivityparams)
    {
        super(gridactivityparams.beanFactory, gridactivityparams.launchCamera);
        ftueLaunched = false;
        instantAnimation = false;
        navigationBar = null;
        activityParams = gridactivityparams;
    }

    public static int calculateImageWidth(Context context, int i, int j, int k)
    {
        return Math.round((float)(context.getResources().getDisplayMetrics().widthPixels - j * 2 - (i - 1) * k) / (float)i);
    }

    private void initActivityIndicator(GridStatus gridstatus)
    {
        activityIndicatorCheckThread = new ActivityIndicatorCheckThread(this, null, gridstatus, (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY));
        activityIndicatorCheckThread.start();
        notificationManager.addListener(new NoOpViewStateListener() {

            final BasicListActivity this$0;

            public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
            {
                if (viewdescriptor.getMediaProperty() == CommonMediaProperty.CAMERA)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                activityIndicatorCheckThread.getNetworkIndicator().setIsLocalView(flag);
            }

            
            {
                this$0 = BasicListActivity.this;
                super();
            }
        });
    }

    private void initTouchHandling()
    {
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BasicListActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                onClick(view, i);
            }

            
            {
                this$0 = BasicListActivity.this;
                super();
            }
        });
        listView.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

            final BasicListActivity this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
            {
                onLongClick(view, i);
                return true;
            }

            
            {
                this$0 = BasicListActivity.this;
                super();
            }
        });
    }

    public Intent createLauncherActivityIntent()
    {
        Intent intent = new Intent(this, getLauncherActivityClass());
        intent.setAction("com.amazon.photos.INTERNAL");
        return intent;
    }

    protected String getAccessibilityDescription()
    {
        return title;
    }

    protected abstract Class getLauncherActivityClass();

    protected abstract BaseAdapter getListAdapter();

    protected abstract Enum getOpenEvent();

    public void initCameraPanelIfApplicable()
    {
        View view = findViewById(0x7f0c024e);
        if (view != null && isDeviceCameraEnabled())
        {
            view.setVisibility(0);
        }
    }

    protected abstract void initGridItemViewFactory();

    protected abstract void initListAdapter();

    protected abstract void initPipelineFactory();

    protected void launchCollectionViewActivity(MediaProperty mediaproperty)
    {
        Intent intent = createLauncherActivityIntent();
        intent.putExtra("mediaProperty", mediaproperty.toString());
        startPhotosIntent(intent);
    }

    public void launchCollectionViewActivity(Tag tag)
    {
        Intent intent = createLauncherActivityIntent();
        if (tag.getObjectId().equals(ObjectID.getCameraRollTagId()))
        {
            intent.putExtra("mediaProperty", CommonMediaProperty.LOCAL.toString());
        } else
        {
            if (tag.getType().equals(TagType.ALBUM))
            {
                intent.putExtra("mediaDynamicAlbum", true);
            }
            intent.putExtra("mediaTag", tag);
        }
        startPhotosIntent(intent);
    }

    protected void onClick(View view, int i)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setActivityContentView();
        clickMetrics = (UIClickMetrics)getApplicationBean(Keys.UI_METRICS_PROFILER);
        int i;
        if (getResources().getInteger(0x7f0d0044) == 0)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        orientation = i;
        statusBar = findViewById(activityParams.collection_list_status_bar);
        statusBarAnimator.setView(statusBar);
        instantAnimation = true;
        statusBarAnimator.hide();
        instantAnimation = false;
        bundle = getApplicationBeanFactory();
        mediaItemDao = (MediaItemDao)bundle.getBean(Keys.MEDIA_ITEM_DAO);
        tagDao = (TagDao)bundle.getBean(Keys.TAG_DAO);
        if (FeatureManager.isFeatureEnabled(Features.CONTEXT_BAR))
        {
            setupContextBar();
        }
        restClient = (RestClient)bundle.getBean(Keys.REST_CLIENT);
        mediaStoreHelper = (MediaStoreHelper)bundle.getBean(Keys.MEDIA_STORE_HELPER);
        networkConnectivity = (NetworkConnectivity)bundle.getBean(Keys.NETWORK_CONNECTIVITY);
        authenticationManager = (AuthenticationManager)bundle.getBean(Keys.AUTHENTICATING_MANAGER);
        GalleryViewConfigWrapper.addListeners(notificationManager, bundle);
        statusTracker = new GridStatus();
        listView = (AbsListView)findViewById(0x7f0c011e);
        initCameraPanelIfApplicable();
        initPipelineFactory();
        initGridItemViewFactory();
        if (itemViewFactory != null)
        {
            listView.setOnHierarchyChangeListener(new android.view.ViewGroup.OnHierarchyChangeListener() {

                final BasicListActivity this$0;

                public void onChildViewAdded(View view, View view1)
                {
                }

                public void onChildViewRemoved(View view, View view1)
                {
                    itemViewFactory.onViewDestroy(view1);
                }

            
            {
                this$0 = BasicListActivity.this;
                super();
            }
            });
        }
        initListAdapter();
        bundle = getListAdapter();
        listView.setAdapter(bundle);
        initTouchHandling();
        setupActionBar();
        setupFragmentController();
        initActivityIndicator(statusTracker);
        bundle = getIntent();
        if (AdLaunchHelper.isAdLaunch(bundle))
        {
            AdLaunchHelper.process(bundle);
            AdLaunchHelper.logLaunchMetric((LaunchSourceMetrics)getApplicationBean(Keys.LAUNCH_SOURCE_PROFILER), bundle);
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        statusTracker.reset();
        activityIndicatorCheckThread.onDestroy();
    }

    protected void onLongClick(View view, int i)
    {
    }

    public void onPause()
    {
        super.onPause();
        activityIndicatorCheckThread.onPause();
        if (notificationManager.hasViewStateListener(noContentOverlay))
        {
            notificationManager.removeListener(noContentOverlay);
        }
        if (openTime != null)
        {
            clickMetrics.trackTimer(getOpenEvent(), System.currentTimeMillis() - openTime.longValue());
        }
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        final int fScrollPos = bundle.getInt("scrollPos", -1);
        if (fScrollPos >= 0)
        {
            listView.post(new Runnable() {

                final BasicListActivity this$0;
                final int val$fScrollPos;

                public void run()
                {
                    listView.setSelection(fScrollPos);
                }

            
            {
                this$0 = BasicListActivity.this;
                fScrollPos = i;
                super();
            }
            });
        }
    }

    public void onResume()
    {
        super.onResume();
        if (ftueLaunched)
        {
            return;
        } else
        {
            activityIndicatorCheckThread.onResume();
            openTime = Long.valueOf(System.currentTimeMillis());
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("scrollPos", listView.getFirstVisiblePosition());
    }

    public abstract void setActivityContentView();

    protected void setTitle(String s)
    {
        title = s;
    }

    protected void setupActionBar()
    {
    }

    protected void setupContextBar()
    {
    }

    protected void setupFragmentController()
    {
    }

    protected void setupNoContentOverlay()
    {
        super.setupNoContentOverlay();
        notificationManager.addListener(noContentOverlay);
    }

    public void startPhotosIntent(Intent intent)
    {
        intent.putExtra("com.amazon.photos.FROM_CLA", true);
        ((NavigationMetrics)getApplicationBean(Keys.NAVIGATION_METRICS)).onNavigateToCollection();
        startActivity(intent);
        overridePendingTransition(0x7f040019, 0x7f04001a);
    }




}
