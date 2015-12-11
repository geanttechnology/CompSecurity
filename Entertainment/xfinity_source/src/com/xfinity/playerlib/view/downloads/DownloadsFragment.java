// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.LoadingIndicator;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.downloads.DownloadFile;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.downloads.DownloadServiceListener;
import com.comcast.cim.downloads.SimpleDownloadServiceListener;
import com.comcast.cim.utils.UIPresentationUtil;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.tracking.PlayNowTab;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.ScrollStateTracker;
import com.xfinity.playerlib.view.browseprograms.SortPolicy;
import com.xfinity.playerlib.view.favorite.MultiDeleteActionFragment;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import com.xfinity.playerlib.view.programdetails.EpisodeDetailActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadedVideosBookmarkCache, DownloadsArrayAdapter, DownloadsItemListener

public class DownloadsFragment extends MultiDeleteActionFragment
    implements ScrollStateTracker
{
    public class NetworkReceiver extends BroadcastReceiver
    {

        final DownloadsFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (loadingViewDelegate.resourcesLoaded())
            {
                showOfflineWarningIfNecessary();
            }
        }

        public NetworkReceiver()
        {
            this$0 = DownloadsFragment.this;
            super();
        }
    }

    protected class SortButtonOnTouchListener
        implements android.view.View.OnTouchListener
    {

        private final com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sortType;
        final DownloadsFragment this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 0)
            {
                return true;
            }
            if (motionevent.getAction() != 1)
            {
                return false;
            } else
            {
                sortPolicy.setCurrentSortType(sortType);
                updateSortButtonStates(sortType);
                applySort();
                return true;
            }
        }

        public SortButtonOnTouchListener(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
        {
            this$0 = DownloadsFragment.this;
            super();
            sortType = sorttype;
        }
    }


    protected final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/downloads/DownloadsFragment);
    protected View alphabetSortButton;
    private AlternateInterfaceListener alternateInterfaceListener;
    private final CachingVideoBookmarkDAO bookmarkDAO = PlayerContainer.getInstance().getVideoBookmarkDAO();
    private TaskExecutionListener bookmarkListener;
    private TaskExecutor bookmarkProvider;
    protected ListView downloadList;
    private DownloadServiceListener downloadServiceListener;
    protected ArrayList downloadedFiles;
    protected DownloadsArrayAdapter downloadsAdapter;
    protected ImageView downloadsFTU;
    private final DownloadsItemListener downloadsItemListener = PlayerContainer.getInstance().getDownloadsItemListDelegate();
    protected final PlayerDownloadServiceManager downloadsManager = PlayerContainer.getInstance().getDownloadServiceManager();
    protected ViewGroup downloadsSubNavBar;
    protected View expiringSortButton;
    protected final CoverArtImageLoader imageLoader = PlayerContainer.getInstance().createCoverArtImageLoader();
    private final InternetConnection internetConnection = PlayerContainer.getInstance().getInternetConnection();
    private boolean isEditMode;
    private boolean isPhone;
    DefaultLoadingViewDelegate loadingViewDelegate;
    protected final NetworkLogoImageLoader logoImageLoader = PlayerContainer.getInstance().createNetworkLogoImageLoader();
    protected ViewGroup offlineWarningLayout;
    protected TextView offlineWarningText;
    protected Button pauseResumeButton;
    protected ProgressBar pauseResumeSpinner;
    protected View pauseResumeView;
    private final TaskExecutorFactory providerFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
    protected View recentSortButton;
    private int scrollState;
    private final SortPolicy sortPolicy = PlayerContainer.getInstance().getDownloadsSortPolicy();
    protected final PlayNowTrackingService trackingService = PlayerContainer.getInstance().getTrackingService();
    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();
    private Task videoEntitlementCache;

    public DownloadsFragment()
    {
        videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();
        isEditMode = false;
        downloadServiceListener = new SimpleDownloadServiceListener() {

            final DownloadsFragment this$0;

            public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
            {
                updatePauseButton();
            }

            public volatile void onFileDownloadFinished(DownloadFile downloadfile)
            {
                onFileDownloadFinished((PlayerDownloadFile)downloadfile);
            }

            public void onFileDownloadFinished(PlayerDownloadFile playerdownloadfile)
            {
                applySort();
            }

            public volatile void onFileDownloadStarted(DownloadFile downloadfile)
            {
                onFileDownloadStarted((PlayerDownloadFile)downloadfile);
            }

            public void onFileDownloadStarted(PlayerDownloadFile playerdownloadfile)
            {
                applySort();
            }

            public void onFileListUpdated()
            {
                fetchBookmarksAndUpdateList();
            }

            
            {
                this$0 = DownloadsFragment.this;
                super();
            }
        };
    }

    private void enableListSelection(boolean flag)
    {
        if (flag)
        {
            downloadList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final DownloadsFragment this$0;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    if (!isEditMode)
                    {
                        showItemAtPosition(i);
                        downloadList.setItemChecked(i, false);
                        return;
                    } else
                    {
                        showSelectedCountOnActionMenu();
                        return;
                    }
                }

            
            {
                this$0 = DownloadsFragment.this;
                super();
            }
            });
            return;
        } else
        {
            downloadList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final DownloadsFragment this$0;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    if (!isEditMode)
                    {
                        downloadList.setItemChecked(i, false);
                        return;
                    } else
                    {
                        showSelectedCountOnActionMenu();
                        return;
                    }
                }

            
            {
                this$0 = DownloadsFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void fetchBookmarksAndUpdateList()
    {
        final List files = getAdultFilteredList();
        HashMap hashmap;
        if (!((PlayerUserSettings)userManager.getUserSettings()).getShowDownloadsFTU())
        {
            downloadsFTU.setVisibility(8);
        } else
        if (files.size() > 0)
        {
            ((PlayerUserSettings)userManager.getUserSettings()).setShowDownloadsFTU(false);
            downloadsFTU.setVisibility(8);
        } else
        {
            downloadsFTU.setVisibility(0);
        }
        hashmap = new HashMap(files.size());
        PlayerDownloadFile playerdownloadfile;
        Watchable watchable;
        for (Iterator iterator = files.iterator(); iterator.hasNext(); hashmap.put(watchable.findVideoById(playerdownloadfile.getVideoId()), watchable))
        {
            playerdownloadfile = (PlayerDownloadFile)iterator.next();
            watchable = playerdownloadfile.getWatchable();
        }

        bookmarkProvider = providerFactory.create(videoEntitlementCache, new DownloadedVideosBookmarkCache(bookmarkDAO, hashmap));
        bookmarkListener = bookmarkProvider.execute(new DefaultTaskExecutionListener() {

            final DownloadsFragment this$0;
            final List val$files;

            public void onError(TaskExecutionException taskexecutionexception)
            {
            }

            public void onPostExecute(Tuple tuple)
            {
                downloadsAdapter.setNotifyOnChange(false);
                downloadsAdapter.clear();
                downloadsAdapter.setVideoBookmarks((Map)tuple.e2);
                downloadsAdapter.setVideoEntitlement((VideoEntitlement)tuple.e1);
                PlayerDownloadFile playerdownloadfile1;
                for (tuple = files.iterator(); tuple.hasNext(); downloadsAdapter.add(playerdownloadfile1))
                {
                    playerdownloadfile1 = (PlayerDownloadFile)tuple.next();
                }

                applySort();
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((Tuple)obj);
            }

            public void onPreAsynchronousExecute()
            {
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
            }

            
            {
                this$0 = DownloadsFragment.this;
                files = list;
                super();
            }
        });
    }

    private List getAdultFilteredList()
    {
        Object obj = downloadsManager.getFilesList();
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        if (!((PlayerUserSettings)userManager.getUserSettings()).getWantsAdultContent())
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                PlayerDownloadFile playerdownloadfile = (PlayerDownloadFile)((Iterator) (obj)).next();
                if (playerdownloadfile.isDownloadComplete())
                {
                    if (!playerdownloadfile.getWatchable().findVideoById(playerdownloadfile.getVideoId()).isAdult())
                    {
                        arraylist.add(playerdownloadfile);
                    }
                } else
                {
                    arraylist.add(playerdownloadfile);
                }
            } while (true);
        } else
        {
            arraylist.addAll(((java.util.Collection) (obj)));
        }
        return arraylist;
    }

    private void hideSortButtons()
    {
        if (isPhone)
        {
            downloadList.setVisibility(4);
        }
        downloadsSubNavBar.setVisibility(8);
        recentSortButton.setVisibility(8);
        alphabetSortButton.setVisibility(8);
        expiringSortButton.setVisibility(8);
    }

    private void selectItem(int i)
    {
        boolean flag = false;
        SparseBooleanArray sparsebooleanarray = downloadList.getCheckedItemPositions();
        ListView listview = downloadList;
        if (!sparsebooleanarray.get(i, false))
        {
            flag = true;
        }
        listview.setItemChecked(i, flag);
        showSelectedCountOnActionMenu();
    }

    private void showItemAtPosition(int i)
    {
        Object obj;
label0:
        {
            obj = (PlayerDownloadFile)downloadList.getItemAtPosition(i);
            if (obj != null && ((PlayerDownloadFile) (obj)).getExpirationStatus() != com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.AAW_EXPIRED)
            {
                if (!isPhone || ((PlayerDownloadFile) (obj)).getWatchable().getMerlinId().getNamespace() != com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode)
                {
                    break label0;
                }
                obj = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(((PlayerDownloadFile) (obj)).getWatchableKey())).shouldHideSeriesTitle(false).episodeId(((PlayerDownloadFile) (obj)).getWatchable().getMerlinId()).overrideNamespace(com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode).build();
                Intent intent = new Intent(getActivity(), com/xfinity/playerlib/view/programdetails/EpisodeDetailActivity);
                intent.putExtras(((DetailIntentHelper) (obj)).getBundle());
                startActivity(intent);
            }
            return;
        }
        startActivity((new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(((PlayerDownloadFile) (obj)).getWatchableKey())).build().getIntent(getActivity()));
    }

    private void showNoWifiWarningIfNecessary()
    {
        PlayNowUser playnowuser = (PlayNowUser)userManager.getUser();
        int i = downloadsManager.getFilesList().size();
        PlayerUserSettings playerusersettings = (PlayerUserSettings)userManager.getUserSettings();
        if (playnowuser != null && i > 0 && internetConnection.isConnectedNotOnWiFi() && !playerusersettings.getUseCellularWhenAvailable())
        {
            offlineWarningLayout.setBackgroundColor(getResources().getColor(com.xfinity.playerlib.R.color.semitransparent_blue));
            offlineWarningText.setText(getResources().getString(com.xfinity.playerlib.R.string.cellular_not_enabled_but_it_could_be));
            offlineWarningLayout.setVisibility(0);
            offlineWarningText.setVisibility(0);
            return;
        } else
        {
            offlineWarningLayout.setVisibility(8);
            offlineWarningText.setVisibility(8);
            return;
        }
    }

    private void showOfflineWarningIfNecessary()
    {
        Object obj = downloadsManager.getDownloadedFileList();
        if (((List) (obj)).size() == 0 || internetConnection.isConnected())
        {
            enableListSelection(true);
            offlineWarningLayout.setVisibility(8);
            offlineWarningText.setVisibility(8);
            showNoWifiWarningIfNecessary();
            return;
        }
        Date date = null;
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            PlayerDownloadFile playerdownloadfile = (PlayerDownloadFile)((Iterator) (obj)).next();
            if (date == null)
            {
                date = playerdownloadfile.getLicenseExpirationDate();
            } else
            if (date.after(playerdownloadfile.getLicenseExpirationDate()))
            {
                date = playerdownloadfile.getLicenseExpirationDate();
            }
        } while (true);
        if (date != null)
        {
            if (date.after(new Date()))
            {
                offlineWarningLayout.setBackgroundColor(getResources().getColor(com.xfinity.playerlib.R.color.semitransparent_blue));
                int i = UIPresentationUtil.getDaysLeft(date);
                if (i > 0)
                {
                    offlineWarningText.setText(getResources().getQuantityString(com.xfinity.playerlib.R.plurals.offline_warning_content_expiring, i, new Object[] {
                        Integer.valueOf(i)
                    }));
                } else
                {
                    int j = getHoursLeft(date);
                    if (j == 23)
                    {
                        offlineWarningText.setText(getResources().getString(com.xfinity.playerlib.R.string.offline_warning_content_expiring_today));
                    } else
                    {
                        offlineWarningText.setText(getResources().getString(com.xfinity.playerlib.R.string.offline_warning_content_expiring_in_hours, new Object[] {
                            Integer.valueOf(j + 1)
                        }));
                    }
                }
            } else
            {
                offlineWarningLayout.setBackgroundColor(getResources().getColor(com.xfinity.playerlib.R.color.semitransparent_black));
                offlineWarningText.setText(getResources().getString(com.xfinity.playerlib.R.string.offline_warning_content_expired));
                enableListSelection(false);
            }
            offlineWarningLayout.setVisibility(0);
            offlineWarningText.setVisibility(0);
            return;
        } else
        {
            showNoWifiWarningIfNecessary();
            return;
        }
    }

    private void showSortButtons()
    {
        if (isPhone)
        {
            downloadList.setVisibility(0);
        }
        downloadsSubNavBar.setVisibility(0);
        recentSortButton.setVisibility(0);
        alphabetSortButton.setVisibility(0);
        expiringSortButton.setVisibility(0);
    }

    protected void applySort()
    {
        loadingViewDelegate.onLoadingStarted();
        downloadsAdapter.sort(sortPolicy.getCurrentSortComparator());
        if (downloadsAdapter.getCount() == 0)
        {
            hideSortButtons();
        } else
        {
            showSortButtons();
        }
        updatePauseButton();
        showOfflineWarningIfNecessary();
        downloadsAdapter.notifyDataSetChanged();
        loadingViewDelegate.onLoadingFinished();
    }

    protected void deleteItems()
    {
        SparseBooleanArray sparsebooleanarray = downloadList.getCheckedItemPositions();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < downloadList.getCount(); i++)
        {
            if (sparsebooleanarray.get(i))
            {
                PlayerDownloadFile playerdownloadfile = (PlayerDownloadFile)downloadList.getItemAtPosition(i);
                downloadList.setItemChecked(i, false);
                arraylist.add(playerdownloadfile);
            }
        }

        try
        {
            downloadsManager.deleteFiles(arraylist);
            return;
        }
        catch (DownloadServiceException downloadserviceexception)
        {
            return;
        }
    }

    protected int getCheckedItemsCount()
    {
        int j = 0;
        SparseBooleanArray sparsebooleanarray = downloadList.getCheckedItemPositions();
        for (int i = 0; i < downloadList.getCount();)
        {
            int k = j;
            if (sparsebooleanarray.get(i))
            {
                k = j + 1;
            }
            i++;
            j = k;
        }

        return j;
    }

    public int getHoursLeft(Date date)
    {
        return (int)((date.getTime() - (new Date()).getTime()) / 0x36ee80L);
    }

    protected int getTotalItemsCount()
    {
        return downloadsAdapter.getCount();
    }

    protected int getViewLayoutId()
    {
        return com.xfinity.playerlib.R.layout.downloads;
    }

    protected boolean isEditEnabled()
    {
        return true;
    }

    public boolean isFlinging()
    {
        return scrollState == 2;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = super.onCreateView(layoutinflater, viewgroup, bundle);
        downloadsSubNavBar = (ViewGroup)bundle.findViewById(com.xfinity.playerlib.R.id.downloadsSubNavBar);
        offlineWarningLayout = (ViewGroup)bundle.findViewById(com.xfinity.playerlib.R.id.offline_warning_layout);
        offlineWarningText = (TextView)bundle.findViewById(com.xfinity.playerlib.R.id.offline_warning_text);
        downloadsFTU = (ImageView)bundle.findViewById(com.xfinity.playerlib.R.id.downloads_ftu);
        viewgroup = sortPolicy.getSortTypes();
        expiringSortButton = bundle.findViewById(com.xfinity.playerlib.R.id.expiringSort);
        alphabetSortButton = bundle.findViewById(com.xfinity.playerlib.R.id.alphabetSort);
        recentSortButton = bundle.findViewById(com.xfinity.playerlib.R.id.recentSort);
        downloadList = (ListView)bundle.findViewById(com.xfinity.playerlib.R.id.downloadList);
        downloadList.setChoiceMode(2);
        boolean flag;
        if (alphabetSortButton == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPhone = flag;
        if (isPhone)
        {
            View view = layoutinflater.inflate(com.xfinity.playerlib.R.layout.downloads_list_header, null, false);
            downloadList.addHeaderView(view, null, false);
            expiringSortButton = view.findViewById(com.xfinity.playerlib.R.id.expiringSort);
            alphabetSortButton = view.findViewById(com.xfinity.playerlib.R.id.alphabetSort);
            recentSortButton = view.findViewById(com.xfinity.playerlib.R.id.recentSort);
        }
        recentSortButton.setOnTouchListener(new SortButtonOnTouchListener((com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType)viewgroup.get(0)));
        alphabetSortButton.setOnTouchListener(new SortButtonOnTouchListener((com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType)viewgroup.get(1)));
        expiringSortButton.setOnTouchListener(new SortButtonOnTouchListener((com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType)viewgroup.get(2)));
        downloadedFiles = new ArrayList();
        viewgroup = FastDateFormat.getInstance(getResources().getString(com.xfinity.playerlib.R.string.month_day_year_format));
        downloadsAdapter = new DownloadsArrayAdapter(getActivity(), downloadedFiles, layoutinflater, imageLoader, downloadsItemListener, downloadsManager, logoImageLoader, internetConnection, this, viewgroup);
        downloadList.setAdapter(downloadsAdapter);
        downloadList.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

            final DownloadsFragment this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view1, int i, long l)
            {
                if (!isEditMode)
                {
                    startActionMode();
                    selectItem(i);
                } else
                {
                    selectItem(i);
                }
                return true;
            }

            
            {
                this$0 = DownloadsFragment.this;
                super();
            }
        });
        downloadList.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final DownloadsFragment this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                scrollState = i;
            }

            
            {
                this$0 = DownloadsFragment.this;
                super();
            }
        });
        enableListSelection(true);
        registerForContextMenu(downloadList);
        pauseResumeView = bundle.findViewById(com.xfinity.playerlib.R.id.pauseResumeLayout);
        pauseResumeButton = (Button)bundle.findViewById(com.xfinity.playerlib.R.id.pauseResumeButton);
        viewgroup = bundle.findViewById(com.xfinity.playerlib.R.id.pauseResumeLayoutPhone);
        layoutinflater = viewgroup;
        if (viewgroup == null)
        {
            layoutinflater = pauseResumeView;
        }
        layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

            final DownloadsFragment this$0;

            public void onClick(View view1)
            {
                if (pauseResumeButton.getVisibility() != 8) goto _L2; else goto _L1
_L1:
                return;
_L2:
                try
                {
                    view1 = downloadsManager.getDownloadEngineStatus().status();
                    if (view1.equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading))
                    {
                        downloadsManager.pauseDownloading();
                        tempDisablePauseButton();
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view1)
                {
                    LOG.error(view1.getMessage(), view1);
                    loadingViewDelegate.onLoadingFailed();
                    return;
                }
                if (!view1.equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)) goto _L1; else goto _L3
_L3:
                downloadsManager.resumeDownloading();
                tempDisablePauseButton();
                return;
            }

            
            {
                this$0 = DownloadsFragment.this;
                super();
            }
        });
        pauseResumeSpinner = (ProgressBar)bundle.findViewById(com.xfinity.playerlib.R.id.pauseResumeSpinner);
        trackingService.trackTabRendered(PlayNowTab.DOWNLOADS);
        loadingViewDelegate = new DefaultLoadingViewDelegate(getActivity(), (ViewGroup)bundle.findViewById(com.xfinity.playerlib.R.id.body_container), (LoadingIndicator)bundle.findViewById(com.xfinity.playerlib.R.id.loading_indicator), internetConnection, new com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate.ReadyListener() {

            final DownloadsFragment this$0;

            public void onReady()
            {
                setEditMode(false);
                updateSortButtonStates(sortPolicy.getCurrentSortType());
                if (downloadsManager.isFileListReady())
                {
                    fetchBookmarksAndUpdateList();
                }
            }

            
            {
                this$0 = DownloadsFragment.this;
                super();
            }
        });
        loadingViewDelegate.setNetworkReceiver(new NetworkReceiver());
        return bundle;
    }

    public void onPause()
    {
        super.onPause();
        downloadsManager.removeDownloadServiceListener(downloadsAdapter);
        downloadsManager.removeDownloadServiceListener(downloadServiceListener);
        if (bookmarkProvider != null)
        {
            bookmarkProvider.cancelNotificationsFor(bookmarkListener);
        }
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        downloadsManager.addDownloadServiceListener(downloadsAdapter);
        downloadsManager.addDownloadServiceListener(downloadServiceListener);
        loadingViewDelegate.startLoading();
    }

    public void onStartInternal()
    {
        super.onStartInternal();
        loadingViewDelegate.onStart();
    }

    public void onStop()
    {
        super.onStop();
        loadingViewDelegate.onStop();
    }

    protected void select(View view)
    {
        view.setSelected(true);
    }

    protected void setEditMode(boolean flag)
    {
        isEditMode = flag;
        downloadsAdapter.setEditMode(flag);
        if (!isEditMode)
        {
            uncheckAll();
        }
    }

    protected void tempDisablePauseButton()
    {
        pauseResumeButton.setVisibility(8);
        pauseResumeSpinner.setVisibility(0);
    }

    protected void uncheckAll()
    {
        SparseBooleanArray sparsebooleanarray = downloadList.getCheckedItemPositions();
        for (int i = 0; i < downloadList.getCount(); i++)
        {
            if (sparsebooleanarray.get(i))
            {
                downloadList.setItemChecked(i, false);
            }
        }

    }

    protected void unselect(View view)
    {
        view.setSelected(false);
    }

    protected void updatePauseButton()
    {
        Object obj;
        try
        {
            pauseResumeSpinner.setVisibility(8);
            obj = downloadsManager.getDownloadEngineStatus().status();
            if (obj == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Downloading)
            {
                pauseResumeView.setVisibility(0);
                pauseResumeButton.setVisibility(0);
                pauseResumeButton.setText(getResources().getString(com.xfinity.playerlib.R.string.pause_download_text));
                pauseResumeButton.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(com.xfinity.playerlib.R.drawable.btn_download_pause), null, null, null);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LOG.error(((DownloadServiceException) (obj)).getMessage(), ((Throwable) (obj)));
            pauseResumeView.setVisibility(8);
            return;
        }
        if (obj == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
        {
            pauseResumeView.setVisibility(0);
            pauseResumeButton.setVisibility(0);
            pauseResumeButton.setText(getResources().getString(com.xfinity.playerlib.R.string.resume_download_text));
            pauseResumeButton.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(com.xfinity.playerlib.R.drawable.btn_download_resume), null, null, null);
            return;
        }
        if (obj == com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle)
        {
            pauseResumeView.setVisibility(8);
            return;
        }
        pauseResumeView.setVisibility(8);
        return;
    }

    protected void updateSortButtonStates(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
    {
        static class _cls9
        {

            static final int $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[];

            static 
            {
                $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType = new int[com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.values().length];
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.RECENT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.ALPHA.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.EXPIRING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls9..SwitchMap.com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType[sorttype.ordinal()])
        {
        default:
            LOG.warn((new StringBuilder()).append("unexpected sort=").append(sorttype).toString());
            return;

        case 1: // '\001'
            select(recentSortButton);
            unselect(expiringSortButton);
            unselect(alphabetSortButton);
            return;

        case 2: // '\002'
            select(alphabetSortButton);
            unselect(expiringSortButton);
            unselect(recentSortButton);
            return;

        case 3: // '\003'
            select(expiringSortButton);
            break;
        }
        unselect(alphabetSortButton);
        unselect(recentSortButton);
    }











/*
    static int access$802(DownloadsFragment downloadsfragment, int i)
    {
        downloadsfragment.scrollState = i;
        return i;
    }

*/

}
