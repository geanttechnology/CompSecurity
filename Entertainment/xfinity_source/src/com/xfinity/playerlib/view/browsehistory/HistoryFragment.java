// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.downloads.DownloadServiceListener;
import com.comcast.cim.downloads.SimpleDownloadServiceListener;
import com.comcast.cim.utils.UIUtil;
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.dibic.NullDibicResource;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.NullVideoEntitlement;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.tracking.PlayNowTab;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.common.UpsellDialog;
import com.xfinity.playerlib.view.downloads.DownloadsItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            MultiDeleteBrowseFragment, HistoryAdapter, MultiDeleteBrowseAdapter

public class HistoryFragment extends MultiDeleteBrowseFragment
{
    public static interface HistoryListener
    {

        public abstract void showDetail(VideoBookmark videobookmark, Long long1);
    }

    public static interface LiveStreamPlayOrResumePressedListener
    {

        public abstract void onLiveStreamPlayOrResumePressed(String s);
    }

    private class ShortCircuitingDataFetcher extends NonCachingBaseTask
    {

        final HistoryFragment this$0;

        public Tuple4 execute()
        {
            List list = (List)bookmarkFetcher.execute();
            Object obj;
            Object obj1;
            if (list.size() > 0)
            {
                obj = (DibicResource)dibicCombinedCache.execute();
                obj1 = (VideoEntitlement)videoEntitlementCache.execute();
            } else
            {
                HistoryFragment.LOG.debug("No bookmarks, skipping dibic and entitlement fetches");
                obj = new NullDibicResource();
                obj1 = new NullVideoEntitlement();
            }
            return new Tuple4(list, obj, obj1, (HalLiveStreamResource)liveStreamResourceCache.execute());
        }

        public volatile Object execute()
        {
            return execute();
        }

        private ShortCircuitingDataFetcher()
        {
            this$0 = HistoryFragment.this;
            super();
        }

    }

    public static interface VideoPlayOrResumePressedListener
    {

        public abstract void onVideoPlayOrResumePressed(VideoBookmark videobookmark);
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browsehistory/HistoryFragment);
    private AndroidDevice androidDevice;
    private final CachingVideoBookmarkDAO bookmarkDAO = PlayerContainer.getInstance().getVideoBookmarkDAO();
    private final Task bookmarkFetcher = new NonCachingBaseTask() {

        final HistoryFragment this$0;

        public volatile Object execute()
        {
            return execute();
        }

        public List execute()
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = bookmarkDAO.getRecentBookmarks().iterator(); iterator.hasNext(); arraylist.add((Bookmark)iterator.next())) { }
            Iterator iterator1 = liveStreamBookmarkDAO.getRecentBookmarks().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                Bookmark bookmark = (Bookmark)iterator1.next();
                if (((PlayerUserSettings)userManager.getUserSettings()).getWantsAdultContent() || !((LiveStreamBookmark)bookmark).isAdultContent())
                {
                    arraylist.add(bookmark);
                }
            } while (true);
            Collections.sort(arraylist, new Comparator() {

                final _cls1 this$1;

                public int compare(Bookmark bookmark, Bookmark bookmark1)
                {
                    return bookmark1.getTimestamp().compareTo(bookmark.getTimestamp());
                }

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((Bookmark)obj, (Bookmark)obj1);
                }

            
            {
                this$1 = _cls1.this;
                super();
            }
            });
            return arraylist;
        }

            
            {
                this$0 = HistoryFragment.this;
                super();
            }
    };
    private final CoverArtImageLoader coverArtImageLoader = PlayerContainer.getInstance().createCoverArtImageLoader();
    private final TaskExecutor dataProvider;
    private final Task dibicCombinedCache = PlayerContainer.getInstance().getDibicCombinedCache();
    private DibicResource dibicResource;
    private DownloadServiceListener downloadServiceListener;
    private DownloadsItemListener downloadsItemListener;
    protected final PlayerDownloadServiceManager downloadsManager = PlayerContainer.getInstance().getDownloadServiceManager();
    private HistoryAdapter historyAdapter;
    private HistoryListener historyListener;
    private InternetConnection internetConnection;
    private final LiveStreamBookmarkDAO liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
    android.view.View.OnClickListener liveStreamPlayButtonOnClickListener;
    private HalLiveStreamResource liveStreamResource;
    private final Task liveStreamResourceCache = PlayerContainer.getInstance().getLiveStreamResourceCache();
    private PlayerDownloadServiceManager playerDownloadServiceManager;
    private int restoredFirstVisibleItemPosition;
    private final TaskExecutorFactory taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
    private PlayNowTrackingService trackingService;
    protected UIUtil uiUtil;
    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();
    VideoEntitlement videoEntitlement;
    private final Task videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();
    android.view.View.OnClickListener videoPlayButtonOnClickListener;

    public HistoryFragment()
    {
        trackingService = PlayerContainer.getInstance().getTrackingService();
        playerDownloadServiceManager = PlayerContainer.getInstance().getDownloadServiceManager();
        downloadsItemListener = PlayerContainer.getInstance().getDownloadsItemListDelegate();
        androidDevice = PlayerContainer.getInstance().getAndroidDevice();
        internetConnection = PlayerContainer.getInstance().getInternetConnection();
        uiUtil = PlayerContainer.getInstance().getUIUtil();
        dataProvider = taskExecutorFactory.create(new ShortCircuitingDataFetcher());
        downloadServiceListener = new SimpleDownloadServiceListener() {

            final HistoryFragment this$0;

            public void onFileListUpdated()
            {
                historyAdapter.notifyDataSetChanged();
            }

            
            {
                this$0 = HistoryFragment.this;
                super();
            }
        };
        videoPlayButtonOnClickListener = new android.view.View.OnClickListener() {

            final HistoryFragment this$0;

            public void onClick(View view)
            {
                Object obj = (VideoBookmark)view.getTag();
                final Object activity;
                if (((VideoBookmark) (obj)).isMovie())
                {
                    activity = dibicResource.getProgramByMerlinId(((VideoBookmark) (obj)).getMerlinId());
                } else
                {
                    activity = dibicResource.getProgramByMerlinId(((VideoBookmark) (obj)).getParentMerlinIdIfApplicable());
                }
                if (videoEntitlement.isEntitled(((DibicProgram) (activity))))
                {
                    activity = getActivity();
                    obj = downloadsManager.findFileWithVideoId(((VideoBookmark) (obj)).getVideoId());
                    if (obj != null)
                    {
                        view = ((PlayerDownloadFile) (obj)).getWatchable();
                        Iterator iterator = view.getVideos().iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            VideoFacade videofacade = (VideoFacade)iterator.next();
                            if (videofacade.getVideoId() != ((PlayerDownloadFile) (obj)).getVideoId())
                            {
                                continue;
                            }
                            ((com.xfinity.playerlib.view.programdetails.DetailFragment.PlayPressedListener)activity).onPlayOrResumePressed(videofacade, view);
                            break;
                        } while (true);
                        return;
                    } else
                    {
                        uiUtil.ensureConnectivityBeforeExecuting(view.getContext(), view. new Runnable() {

                            final _cls3 this$1;
                            final Activity val$activity;
                            final View val$view;

                            public void run()
                            {
                                ((VideoPlayOrResumePressedListener)activity).onVideoPlayOrResumePressed((VideoBookmark)view.getTag());
                            }

            
            {
                this$1 = final__pcls3;
                activity = activity1;
                view = View.this;
                super();
            }
                        });
                        return;
                    }
                } else
                {
                    showUpsellDialogForProgram(((DibicProgram) (activity)));
                    return;
                }
            }

            
            {
                this$0 = HistoryFragment.this;
                super();
            }
        };
        liveStreamPlayButtonOnClickListener = new android.view.View.OnClickListener() {

            final HistoryFragment this$0;

            public void onClick(View view)
            {
                view = (LiveStreamBookmark)view.getTag();
                onLiveStreamPlayRequested(view);
            }

            
            {
                this$0 = HistoryFragment.this;
                super();
            }
        };
    }

    private void onLiveStreamPlayRequested(final LiveStreamBookmark liveStreamBookmark)
    {
        final Object liveStreamPlayOrResumePressedListener = liveStreamResource.getLiveStream(liveStreamBookmark.getStreamId());
        if (liveStreamPlayOrResumePressedListener == null || ((HalLiveStream) (liveStreamPlayOrResumePressedListener)).getPlaybackLink() == null)
        {
            Object obj = new Bundle();
            ((Bundle) (obj)).putString("title", getString(com.xfinity.playerlib.R.string.unavailable));
            ((Bundle) (obj)).putString("description", (new StringBuilder()).append(getString(com.xfinity.playerlib.R.string.error_stream_not_available_text)).append(getString(com.xfinity.playerlib.R.string.remove_item_prompt, new Object[] {
                "history"
            })).toString());
            liveStreamPlayOrResumePressedListener = CALDialogFragment.newInstance("inputPromptDlg");
            ((CALDialogFragment) (liveStreamPlayOrResumePressedListener)).addArguments(((Bundle) (obj)));
            obj = new ArrayList();
            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getString(com.xfinity.playerlib.R.string.dlg_btn_yes), new android.content.DialogInterface.OnClickListener() {

                final HistoryFragment this$0;
                final LiveStreamBookmark val$liveStreamBookmark;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    liveStreamBookmarkDAO.removeHistoryItem(liveStreamBookmark);
                    historyAdapter.removeItems(Arrays.asList(new Bookmark[] {
                        liveStreamBookmark
                    }));
                }

            
            {
                this$0 = HistoryFragment.this;
                liveStreamBookmark = livestreambookmark;
                super();
            }
            }));
            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_no), new android.content.DialogInterface.OnClickListener() {

                final HistoryFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.cancel();
                }

            
            {
                this$0 = HistoryFragment.this;
                super();
            }
            }));
            ((CALDialogFragment) (liveStreamPlayOrResumePressedListener)).setButtonList(((List) (obj)));
            ((CALDialogFragment) (liveStreamPlayOrResumePressedListener)).show(getFragmentManager(), "caldialogfragment");
            return;
        }
        List list = ((HalLiveStream) (liveStreamPlayOrResumePressedListener)).getProviderCodes();
        if (videoEntitlement.isEntitledToList((String[])list.toArray(new String[list.size()])))
        {
            liveStreamPlayOrResumePressedListener = (LiveStreamPlayOrResumePressedListener)getActivity();
            uiUtil.ensureConnectivityBeforeExecuting(getActivity(), new Runnable() {

                final HistoryFragment this$0;
                final LiveStreamBookmark val$liveStreamBookmark;
                final LiveStreamPlayOrResumePressedListener val$liveStreamPlayOrResumePressedListener;

                public void run()
                {
                    liveStreamPlayOrResumePressedListener.onLiveStreamPlayOrResumePressed(liveStreamBookmark.getStreamId());
                }

            
            {
                this$0 = HistoryFragment.this;
                liveStreamPlayOrResumePressedListener = livestreamplayorresumepressedlistener;
                liveStreamBookmark = livestreambookmark;
                super();
            }
            });
            return;
        } else
        {
            liveStreamBookmark = getFragmentManager();
            UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAY_FROM_HISTORY, ((HalLiveStream) (liveStreamPlayOrResumePressedListener))).show(liveStreamBookmark, "upsell_dialog");
            return;
        }
    }

    private void showUpsellDialogForProgram(DibicProgram dibicprogram)
    {
        android.app.FragmentManager fragmentmanager = getFragmentManager();
        UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAY_FROM_HISTORY, dibicprogram).show(fragmentmanager, "upsell_dialog");
    }

    protected HistoryAdapter createAdapter(LayoutInflater layoutinflater)
    {
        int i;
        if (inBabyGuideMode)
        {
            i = com.xfinity.playerlib.R.layout.history_baby_guide_item;
        } else
        {
            i = com.xfinity.playerlib.R.layout.history_item;
        }
        historyAdapter = new HistoryAdapter(layoutinflater, coverArtImageLoader, videoPlayButtonOnClickListener, liveStreamPlayButtonOnClickListener, playerDownloadServiceManager, downloadsItemListener, i, currentlyPlayingVideoId, androidDevice.isTabletDevice(), this, internetConnection);
        playerDownloadServiceManager.addDownloadServiceListener(historyAdapter);
        playerDownloadServiceManager.addDownloadServiceListener(downloadServiceListener);
        return historyAdapter;
    }

    protected volatile MultiDeleteBrowseAdapter createAdapter(LayoutInflater layoutinflater)
    {
        return createAdapter(layoutinflater);
    }

    protected void deleteItem(Bookmark bookmark)
    {
        if (bookmark instanceof VideoBookmark)
        {
            bookmarkDAO.deleteBookmark((VideoBookmark)bookmark);
            return;
        } else
        {
            liveStreamBookmarkDAO.removeHistoryItem((LiveStreamBookmark)bookmark);
            return;
        }
    }

    protected volatile void deleteItem(Object obj)
    {
        deleteItem((Bookmark)obj);
    }

    protected List getData(Tuple4 tuple4)
    {
        return (List)tuple4.e1;
    }

    protected volatile List getData(Object obj)
    {
        return getData((Tuple4)obj);
    }

    protected TaskExecutor getDataTaskExecutor()
    {
        return dataProvider;
    }

    protected MultiDeleteBrowseFragment.ItemClickListener getItemClickListener()
    {
        return new MultiDeleteBrowseFragment.ItemClickListener() {

            final HistoryFragment this$0;

            public void onItemClicked(Bookmark bookmark)
            {
                if (bookmark instanceof VideoBookmark)
                {
                    historyListener.showDetail((VideoBookmark)bookmark, currentlyPlayingVideoId);
                    return;
                } else
                {
                    onLiveStreamPlayRequested((LiveStreamBookmark)bookmark);
                    return;
                }
            }

            public volatile void onItemClicked(Object obj)
            {
                onItemClicked((Bookmark)obj);
            }

            
            {
                this$0 = HistoryFragment.this;
                super();
            }
        };
    }

    protected CharSequence getListHeaderText()
    {
        return getResources().getString(com.xfinity.playerlib.R.string.history);
    }

    protected int getListViewId()
    {
        return com.xfinity.playerlib.R.id.history_bookmarks;
    }

    protected int getViewLayoutId()
    {
        if (inBabyGuideMode)
        {
            return com.xfinity.playerlib.R.layout.history_baby_guide;
        } else
        {
            return com.xfinity.playerlib.R.layout.history;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        historyListener = (HistoryListener)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        trackingService.trackTabRendered(PlayNowTab.HISTORY);
        if (bundle != null)
        {
            restoredFirstVisibleItemPosition = bundle.getInt("firstVisibleItemPosition", 0);
        }
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        playerDownloadServiceManager.removeDownloadServiceListener(historyAdapter);
        playerDownloadServiceManager.removeDownloadServiceListener(downloadServiceListener);
    }

    protected void onResourceFetched(Tuple4 tuple4)
    {
        ((HistoryAdapter)adapter).setDibicResource((DibicResource)tuple4.e2);
        ((HistoryAdapter)adapter).setVideoEntitlement((VideoEntitlement)tuple4.e3);
        ((HistoryAdapter)adapter).setLiveStreamResource((HalLiveStreamResource)tuple4.e4);
        videoEntitlement = (VideoEntitlement)tuple4.e3;
        dibicResource = (DibicResource)tuple4.e2;
        liveStreamResource = (HalLiveStreamResource)tuple4.e4;
        super.onResourceFetched(tuple4);
        getListView().setSelection(restoredFirstVisibleItemPosition);
    }

    protected volatile void onResourceFetched(Object obj)
    {
        onResourceFetched((Tuple4)obj);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        restoredFirstVisibleItemPosition = getListView().getFirstVisiblePosition();
        bundle.putInt("firstVisibleItemPosition", restoredFirstVisibleItemPosition);
    }

    public void onStop()
    {
        super.onStop();
        coverArtImageLoader.purgeJobs();
    }














}
