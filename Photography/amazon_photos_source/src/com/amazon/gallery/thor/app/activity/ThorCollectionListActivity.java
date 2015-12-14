// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.InvalidateDataEvent;
import com.amazon.gallery.foundation.utils.messaging.ItemChangeEvent;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.foundation.utils.messaging.WhisperplayConnectionEvent;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.actions.AlbumInfoAction;
import com.amazon.gallery.framework.gallery.actions.DeleteAction;
import com.amazon.gallery.framework.gallery.actions.DownloadAction;
import com.amazon.gallery.framework.gallery.actions.RenameAction;
import com.amazon.gallery.framework.gallery.actions.ShareAlbumAction;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.metrics.EngagementMetrics;
import com.amazon.gallery.framework.gallery.metrics.NavigationMetrics;
import com.amazon.gallery.framework.gallery.widget.TagListAdapter;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.action.ManualUploadAction;
import com.amazon.gallery.framework.kindle.activity.CollectionListActivity;
import com.amazon.gallery.framework.kindle.activity.GridActivityParams;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.kindle.util.SavedTagsFragment;
import com.amazon.gallery.framework.kindle.widget.BadgeableItemViewFactory;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.albums.AlbumsWelcomeLetterHelper;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.actions.FavoriteAction;
import com.amazon.gallery.thor.app.actions.ThorActionFactory;
import com.amazon.gallery.thor.app.ui.cab.TagContextBar;
import com.amazon.gallery.thor.camera.ThorLaunchCamera;
import com.amazon.gallery.thor.cds.CDSSyncHandler;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.di.AppKeys;
import com.amazon.gallery.thor.di.NativeActivityBeans;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import com.amazon.gallery.thor.whisperplay.ThorWhisperPlayPanelListener;
import com.amazon.gallery.whisperplay.WhisperPlayConnectionManager;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorSettingsActivity, ThorNativeGalleryActivity, ThorActionBar

public class ThorCollectionListActivity extends CollectionListActivity
    implements OnSortingChangedListener
{

    public static final String TAG = com/amazon/gallery/thor/app/activity/ThorCollectionListActivity.getName();
    private TagContextBar contextBar;
    private EngagementMetrics engagementProfiler;
    private NavigationPaneController navController;
    private PhotosNavigationPane navPane;
    private final Runnable notifyDateSetInvalidatedRunnable = new Runnable() ;
    private ThorActionBar thorActionBar;

    public ThorCollectionListActivity()
    {
        super(new GridActivityParams(0x7f0c0121, com/amazon/gallery/thor/app/activity/ThorSettingsActivity, new ThorLaunchCamera(), new NativeActivityBeans()));
    }

    private void checkShowAlbumsWelcomeLetter()
    {
        AlbumsWelcomeLetterHelper albumswelcomeletterhelper = new AlbumsWelcomeLetterHelper((Profiler)getApplicationBean(Keys.PROFILER));
        if (albumswelcomeletterhelper.shouldShowLetter(getApplicationContext()))
        {
            albumswelcomeletterhelper.showLetter(this);
        }
    }

    private void setupContextBarActions()
    {
        if (!FeatureManager.isFeatureEnabled(Features.CONTEXT_BAR))
        {
            return;
        } else
        {
            com.amazon.gallery.framework.gallery.actions.MediaItemAction mediaitemaction = ThorActionFactory.createThorAction(this, com/amazon/gallery/framework/gallery/actions/DownloadAction);
            com.amazon.gallery.framework.gallery.actions.MediaItemAction mediaitemaction1 = ThorActionFactory.createThorAction(this, com/amazon/gallery/framework/kindle/action/ManualUploadAction);
            com.amazon.gallery.framework.gallery.actions.MediaItemAction mediaitemaction2 = ThorActionFactory.createThorAction(this, com/amazon/gallery/framework/gallery/actions/DeleteAction);
            com.amazon.gallery.framework.gallery.actions.SelectionAction selectionaction = ThorActionFactory.createSelectionAction(this, com/amazon/gallery/framework/gallery/actions/RenameAction);
            com.amazon.gallery.framework.gallery.actions.SelectionAction selectionaction1 = ThorActionFactory.createSelectionAction(this, com/amazon/gallery/thor/app/actions/FavoriteAction);
            com.amazon.gallery.framework.gallery.actions.MediaItemAction mediaitemaction3 = ThorActionFactory.createThorAction(this, com/amazon/gallery/framework/gallery/actions/ShareAlbumAction);
            com.amazon.gallery.framework.gallery.actions.SelectionAction selectionaction2 = ThorActionFactory.createSelectionAction(this, com/amazon/gallery/framework/gallery/actions/AlbumInfoAction);
            contextBar.addAction(0x7f0c0246, mediaitemaction);
            contextBar.addAction(0x7f0c0247, mediaitemaction1);
            contextBar.addAction(0x7f0c0245, mediaitemaction2);
            contextBar.addAction(0x7f0c0248, selectionaction);
            contextBar.addAction(0x7f0c0243, selectionaction1);
            contextBar.addAction(0x7f0c0249, mediaitemaction3);
            contextBar.addAction(0x7f0c024a, selectionaction2);
            return;
        }
    }

    private void updateContextBarData(View view, int i)
    {
        if (contextBar == null)
        {
            return;
        }
        view = (Tag)listAdapter.getItem(i);
        if (!contextBar.isSelected(view))
        {
            contextBar.addSelectable(view);
        } else
        {
            contextBar.removeSelectable(view);
        }
        GlobalMessagingBus.post(new ItemChangeEvent(i));
    }

    protected SyncHandler createSyncHandler()
    {
        if (!((FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER)).hasCloudSync())
        {
            return null;
        } else
        {
            return new CDSSyncHandler(this, (SyncManager)getApplicationBean(Keys.SYNC_MANAGER), (AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER), (CloudDriveServiceClientManager)getApplicationBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER), photosDemoManager);
        }
    }

    protected int getActionMenuId()
    {
        return 0x7f100004;
    }

    protected Class getLauncherActivityClass()
    {
        return com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity;
    }

    protected void initGridItemViewFactory()
    {
        super.initGridItemViewFactory();
        badgeFactory.setSelectionChecker(contextBar);
    }

    public void onBackPressed()
    {
        if (contextBar != null && contextBar.isContextBarActive())
        {
            contextBar.hide();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onClick(View view, int i)
    {
label0:
        {
            if (contextBar != null)
            {
                if (contextBar.isContextBarActive())
                {
                    break label0;
                }
                super.onClick(view, i);
            }
            return;
        }
        updateContextBarData(view, i);
    }

    public void onCreate(Bundle bundle)
    {
        TimeTracker.log("CollectionActivity.onCreate start");
        super.onCreate(bundle);
        ((BeanAwareApplication)getApplication()).registerNewActivity(this);
        engagementProfiler = (EngagementMetrics)getApplicationBean(Keys.ENGAGEMENT_METRICS);
        setupContextBarActions();
        GlobalMessagingBus.register(this);
        TimeTracker.log("CollectionActivity.onCreate finish");
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (contextBar != null && contextBar.getTagType() != null)
        {
            tagDao.unregisterObserver(contextBar, contextBar.getTagType());
        }
        GlobalMessagingBus.unregister(this);
        if (thorActionBar != null)
        {
            thorActionBar.onDestroy();
        }
        navController.onDestroy();
        ((BeanAwareApplication)getApplication()).unregisterActivity(this);
    }

    public void onInvalidateRequest(InvalidateDataEvent invalidatedataevent)
    {
        runOnUiThread(notifyDateSetInvalidatedRunnable);
    }

    public void onItemChangedEvent(ItemChangeEvent itemchangeevent)
    {
        runOnUiThread(notifyDateSetInvalidatedRunnable);
    }

    protected void onLongClick(View view, int i)
    {
        super.onLongClick(view, i);
        if (contextBar != null && !contextBar.isContextBarActive())
        {
            GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.TAP));
            updateContextBarData(view, i);
        }
    }

    public void onPause()
    {
        if (navController != null)
        {
            navController.onPause();
        }
        if (contextBar != null)
        {
            contextBar.onPause();
        }
        if (FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY))
        {
            ((WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER)).onPause(this);
        }
        super.onPause();
    }

    public void onResume()
    {
        TimeTracker.log("CollectionActivity.onResume start");
        super.onResume();
        navController.onResume();
        if (contextBar != null)
        {
            contextBar.onResume();
        }
        if (photosDemoManager.isInDemoMode() || !(new MAPAccountManager(this)).isDeviceRegistered())
        {
            ((ThorGalleryApplication)getApplication()).onFirstSyncCompleted();
        }
        GlobalMessagingBus.post(new InvalidateDataEvent());
        if (FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY))
        {
            ((WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER)).initWithActivity(this, false);
        }
        if (tagType != TagType.LOCAL_FOLDER) goto _L2; else goto _L1
_L1:
        navPane.select(0x7f0c026d);
_L4:
        TimeTracker.log("CollectionActivity.onResume finish");
        return;
_L2:
        if (tagType == TagType.ALBUM)
        {
            navPane.select(0x7f0c026a);
            checkShowAlbumsWelcomeLetter();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (contextBar != null)
        {
            getSavedTagsFragment().setSelectedTags(contextBar.getSelectables());
        }
    }

    public void onSortingChanged(int i)
    {
        switch (i)
        {
        default:
            return;

        case 2131493517: 
            sortAlbums(com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.DATE_DESC);
            engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.TagTimeStampToggled, CustomerMetricsHelper.getExtraEventTag("AlbumDate"));
            return;

        case 2131493516: 
            sortAlbums(com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.NAME_ASC);
            engagementProfiler.trackEvent(com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.TagAlbumNameToggled, CustomerMetricsHelper.getExtraEventTag("AlbumName"));
            return;
        }
    }

    public void onWhisperplayConnectionEvent(WhisperplayConnectionEvent whisperplayconnectionevent)
    {
        setWhisperPlayModeEnabled(whisperplayconnectionevent.deviceConnected);
    }

    public void setActivityContentView()
    {
        TimeTracker.log("CollectionListActivity#setActivityContentView start");
        setContentView(0x7f0300ea);
        TimeTracker.log("CollectionListActivity#setActivityContentView finish");
    }

    protected void setTitle(String s)
    {
        super.setTitle(s);
        if (thorActionBar != null)
        {
            thorActionBar.setTitle(s);
        }
    }

    public void setWhisperPlayModeEnabled(boolean flag)
    {
        super.setWhisperPlayModeEnabled(flag);
        if (navPane != null && FeatureManager.isFeatureEnabled(Features.WHISPER_PLAY))
        {
            navPane.addSidePanelListener(new ThorWhisperPlayPanelListener((WhisperPlayConnectionManager)getApplicationBean(AppKeys.WHISPER_PLAY_CONNECTION_MANAGER)));
        }
    }

    protected void setupActionBar()
    {
        TimeTracker.log("CollectionListActivity#setupActionBar start");
        navPane = (PhotosNavigationPane)findViewById(0x7f0c014e);
        navController = new NavigationPaneController(this, navPane, tagDao, mediaItemDao, (Executor)getApplicationBean(Keys.UI_READY_EXECUTOR));
        if (FeatureManager.isFeatureEnabled(Features.HEADER_ACTION_BAR))
        {
            thorActionBar = new ThorActionBar(navPane, this, false, (Toolbar)findViewById(0x7f0c0086));
            int i;
            if (listAdapter.getCurrentSortType() == com.amazon.gallery.framework.gallery.widget.TagListAdapter.SortType.DATE_DESC)
            {
                i = 0x7f0c028d;
            } else
            {
                i = 0x7f0c028c;
            }
            thorActionBar.setup(getActionMenuId(), 0x7f100012, i, this);
            thorActionBar.updateHeaderOptions(null, null);
            navigationBar = thorActionBar;
        }
        if (FeatureManager.isFeatureEnabled(Features.CONTEXT_BAR))
        {
            navPane.addSidePanelListener(new NoOpSidePanelListener() {

                final ThorCollectionListActivity this$0;

                public void onNavigate(MenuItem menuitem)
                {
                    contextBar.hide();
                }

            
            {
                this$0 = ThorCollectionListActivity.this;
                super();
            }
            });
        }
        TimeTracker.log("CollectionListActivity#setupActionBar start");
    }

    protected void setupContextBar()
    {
        if (!FeatureManager.isFeatureEnabled(Features.CONTEXT_BAR))
        {
            return;
        }
        contextBar = new TagContextBar(this, 0x7f100003);
        List list = getSavedTagsFragment().getSelectedTags();
        if (list != null && list.size() > 0)
        {
            verifyContextSelectables(list);
            if (list.size() > 0)
            {
                contextBar.restoreState(list);
            }
        }
        GlobalMessagingBus.post(new InvalidateDataEvent());
    }

    protected void updateView(TagType tagtype)
    {
        super.updateView(tagtype);
        if (tagtype != TagType.LOCAL_FOLDER) goto _L2; else goto _L1
_L1:
        ((NavigationMetrics)getApplicationBean(Keys.NAVIGATION_METRICS)).onNavigateToTagType(com.amazon.gallery.framework.gallery.metrics.NavigationMetrics.MetricEvent.TimeInDevice);
_L4:
        if (contextBar != null)
        {
            if (contextBar.getTagType() != null)
            {
                tagDao.unregisterObserver(contextBar, contextBar.getTagType());
            }
            contextBar.updateTagType(tagtype);
            tagDao.registerObserver(contextBar, tagtype);
        }
        if (thorActionBar != null)
        {
            thorActionBar.updateMenuItemsForTagType(tagtype);
        }
        return;
_L2:
        if (tagtype == TagType.FOLDER)
        {
            ((NavigationMetrics)getApplicationBean(Keys.NAVIGATION_METRICS)).onNavigateToTagType(com.amazon.gallery.framework.gallery.metrics.NavigationMetrics.MetricEvent.TimeInCloudDrive);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void verifyContextSelectables(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            if (tagDao.getTagById(((Tag)list.next()).getObjectId()) == null)
            {
                list.remove();
            }
        } while (true);
    }



}
