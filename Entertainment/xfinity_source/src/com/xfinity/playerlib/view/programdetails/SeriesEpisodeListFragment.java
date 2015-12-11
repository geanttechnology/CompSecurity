// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.SpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.CheckableRelativeLayout;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.LoadingIndicator;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.downloads.DownloadServiceListener;
import com.comcast.cim.downloads.SimpleDownloadServiceListener;
import com.comcast.cim.model.system.PlayerAndroidDevice;
import com.comcast.cim.utils.UIUtil;
import com.commonsware.MergeAdapter;
import com.xfinity.playerlib.alt.PlayerEpisodeListTalkListHelper;
import com.xfinity.playerlib.image.ProgramDetailArtImageLoader;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.AnimatedFragment;
import com.xfinity.playerlib.view.BaseInstanceState;
import com.xfinity.playerlib.view.common.PlayNowConsumableEpisodeArrayAdapter;
import com.xfinity.playerlib.view.favorite.BookmarkMenuItemDelegate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            FetchCanceledListener, ConsumableVideoListHelper, SeriesEntityActivity, SeriesCombinedTaskExecutorFactory, 
//            SeriesResource

public class SeriesEpisodeListFragment extends AuthenticatingFragment
    implements AnimatedFragment, FetchCanceledListener
{
    public static class InstanceState extends BaseInstanceState
    {

        protected static final String EXTRA_BUNDLE_PARAMS = com/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState.getCanonicalName();
        public boolean seriesDetailSelected;

        public static InstanceState fromBundle(Bundle bundle)
        {
            return (InstanceState)bundle.getSerializable(EXTRA_BUNDLE_PARAMS);
        }

        public Bundle addToBundle(Bundle bundle)
        {
            bundle.putSerializable(EXTRA_BUNDLE_PARAMS, this);
            return bundle;
        }

        public void resetWatchableInfo()
        {
            episodeId = null;
            nonEpisodeVideoId = null;
            seriesDetailSelected = false;
        }


        public InstanceState()
        {
            seriesDetailSelected = false;
        }
    }

    public static interface SeriesEpisodeListContainer
    {

        public abstract boolean shouldShowSeriesListItemsChecked();

        public abstract void showSeriesDetail();

        public abstract void showSeriesWatchableDetail(SeriesWatchable serieswatchable);
    }

    protected class SeriesEpisodeListSpeechListener extends DefaultSpeechListener
    {

        final SeriesEpisodeListFragment this$0;

        public boolean onSpeechResponseLess()
        {
            alternateInterfaceListener.getTalkDelegate().speak(playNowEpisodeListTalkHelper.getLessResults());
            return true;
        }

        public boolean onSpeechResponseMore()
        {
            alternateInterfaceListener.getTalkDelegate().speak(getPlayNowEpisodeListTalkHelper(getActivity()).getMoreResults());
            return true;
        }

        public boolean onSpeechResponseOpen(String as[])
        {
            announceListOnLoad = true;
            return true;
        }

        public boolean onSpeechResponsePlay(String as[])
        {
            announceListOnLoad = true;
            return true;
        }

        public boolean onSpeechResponseRepeat()
        {
            alternateInterfaceListener.getTalkDelegate().speak(getPlayNowEpisodeListTalkHelper(getActivity()).speakResults());
            return true;
        }

        protected SeriesEpisodeListSpeechListener()
        {
            this$0 = SeriesEpisodeListFragment.this;
            super();
        }
    }


    protected final AccessibilityUtil accessibilityUtil = PlayerContainer.getInstance().getAccessibilityUtil();
    private AlternateInterfaceListener alternateInterfaceListener;
    private boolean animationsEnabled;
    private boolean announceListOnLoad;
    protected ViewGroup bodyContainer;
    protected BookmarkMenuItemDelegate bookmarkMenuItemDelegate;
    private ListView consumableVideoList;
    private ConsumableVideoListHelper consumableVideoListHelper;
    private DibicResource dibicResource;
    private PlayerDownloadServiceManager downloadManager;
    private DownloadServiceListener downloadServiceListener;
    private Set episodeAdapters;
    private CheckBox favoriteIndicator;
    private FetchCanceledListener fetchCanceledListener;
    private InstanceState instanceState;
    private final InternetConnection internetConnection = CALContainer.getInstance().getInternetConnection();
    private boolean isFullScreen;
    private DefaultLoadingViewDelegate loadingViewDelegate;
    private MergeAdapter mergeAdapter;
    protected ViewGroup notAvailableContainer;
    private PlayerEpisodeListTalkListHelper playNowEpisodeListTalkHelper;
    protected PlayerAndroidDevice playerAndroidDevice;
    protected final ProgramDetailArtImageLoader programDetailImageLoader = PlayerContainer.getInstance().createProgramDetailArtImageLoader();
    private Parcelable restoredListState;
    private TaskFactory seriesCacheMap;
    private SeriesCombinedTaskExecutorFactory seriesCombinedTaskExecutorFactory;
    private SeriesEpisodeListContainer seriesEpisodeListContainer;
    private VideoFavorite seriesFavorite;
    private CheckableRelativeLayout seriesHeader;
    private ImageView seriesThumbnail;
    private TextView seriesTitle;
    protected ViewGroup seriesTitleContainer;
    private SpeechListener speechListener;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;
    private TvSeriesFacade tvSeriesFacade;
    private UIUtil uiUtil;

    public SeriesEpisodeListFragment()
    {
        uiUtil = PlayerContainer.getInstance().getUIUtil();
        consumableVideoListHelper = PlayerContainer.getInstance().getConsumableVideoListHelper();
        downloadManager = PlayerContainer.getInstance().getDownloadServiceManager();
        animationsEnabled = true;
        speechListener = new SeriesEpisodeListSpeechListener();
        playerAndroidDevice = PlayerContainer.getInstance().getAndroidDevice();
        downloadServiceListener = new SimpleDownloadServiceListener() {

            final SeriesEpisodeListFragment this$0;

            public void onFileListUpdated()
            {
                if (!loadingViewDelegate.firstTimeLoadStarted())
                {
                    loadScreenInfo();
                }
            }

            
            {
                this$0 = SeriesEpisodeListFragment.this;
                super();
            }
        };
        seriesCacheMap = PlayerContainer.getInstance().getSeriesCacheMap();
        seriesCombinedTaskExecutorFactory = PlayerContainer.getInstance().getSeriesCombinedTaskExecutorFactory();
        episodeAdapters = new HashSet();
        bookmarkMenuItemDelegate = new BookmarkMenuItemDelegate(PlayerContainer.getInstance().getBookmarkUtils());
        announceListOnLoad = false;
    }

    private void clearEpisodeAdaptersSelections()
    {
        Iterator iterator = episodeAdapters.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PlayNowConsumableEpisodeArrayAdapter playnowconsumableepisodearrayadapter = (PlayNowConsumableEpisodeArrayAdapter)iterator.next();
            if (seriesEpisodeListContainer.shouldShowSeriesListItemsChecked())
            {
                playnowconsumableepisodearrayadapter.setCheckedPos(-1);
            }
        } while (true);
    }

    private void displayDetail(Map map, Watchable watchable, TvSeriesFacade tvseriesfacade, ConsumableVideoListHelper.InfoClickListenerFactory infoclicklistenerfactory, VideoEntitlement videoentitlement)
    {
        map = consumableVideoListHelper.populateConsumableVideoList(getActivity(), consumableVideoList, tvseriesfacade, watchable, uiUtil, infoclicklistenerfactory, instanceState.currentlyPlayingVideoId, instanceState.companyId, instanceState.wantsSubscriptionOnly, videoentitlement, map, seriesEpisodeListContainer.shouldShowSeriesListItemsChecked());
        episodeAdapters = (Set)((Tuple) (map)).e1;
        mergeAdapter = (MergeAdapter)((Tuple) (map)).e2;
        if (instanceState.seriesDetailSelected || watchable == null)
        {
            showSeriesAsSelected();
        }
        loadingViewDelegate.onLoadingFinished();
        announceListItems();
    }

    private PlayerEpisodeListTalkListHelper getPlayNowEpisodeListTalkHelper(Context context)
    {
        if (playNowEpisodeListTalkHelper == null || announceListOnLoad)
        {
            playNowEpisodeListTalkHelper = new PlayerEpisodeListTalkListHelper(tvSeriesFacade, context);
        }
        return playNowEpisodeListTalkHelper;
    }

    private void loadScreenInfo()
    {
        Object obj;
        Activity activity;
        if (instanceState.useDownloadAsSource())
        {
            obj = new NonCachingBaseTask() {

                final SeriesEpisodeListFragment this$0;

                public HalTvSeriesConsumable execute()
                {
                    Object obj1 = downloadManager.findFileWithVideoId(instanceState.watchableKey.getVideoId());
                    if (obj1 != null)
                    {
                        obj1 = downloadManager.getStoredEntity(((PlayerDownloadFile) (obj1)).getUuid());
                        if (obj1 != null)
                        {
                            return (HalTvSeriesConsumable)((Either) (obj1)).e2;
                        }
                    }
                    return (HalTvSeriesConsumable)seriesCacheMap.get(instanceState.seriesId).execute();
                }

                public volatile Object execute()
                {
                    return execute();
                }

            
            {
                this$0 = SeriesEpisodeListFragment.this;
                super();
            }
            };
        } else
        {
            obj = seriesCacheMap.get(instanceState.seriesId);
        }
        activity = getActivity();
        if (activity instanceof SeriesEntityActivity)
        {
            taskExecutor = ((SeriesEntityActivity)activity).getTaskExecutor();
        } else
        {
            taskExecutor = seriesCombinedTaskExecutorFactory.create(((Task) (obj)));
        }
        taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

            final SeriesEpisodeListFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                loadingViewDelegate.onLoadingFailed();
            }

            public void onPostExecute(SeriesResource seriesresource)
            {
                VideoEntitlement videoentitlement;
                DibicProgram dibicprogram;
                notAvailableContainer.setVisibility(8);
                tvSeriesFacade = seriesresource.tvSeriesFacade;
                dibicResource = seriesresource.dibicResource;
                videoentitlement = seriesresource.entitlement;
                dibicprogram = dibicResource.getProgramByMerlinId(tvSeriesFacade.getMerlinId());
                if (dibicprogram != null) goto _L2; else goto _L1
_L1:
                showEntityUnavailableView();
_L9:
                return;
_L2:
                Object obj1;
                Object obj2;
                obj1 = null;
                obj2 = null;
                if (!instanceState.hasOnlySeriesInfo() || tvSeriesFacade.getAllEpisodeFacades().size() <= 0)
                {
                    break MISSING_BLOCK_LABEL_602;
                }
                obj1 = tvSeriesFacade.getAllEpisodeFacades();
                if (instanceState.companyId == null && !instanceState.wantsSubscriptionOnly) goto _L4; else goto _L3
_L3:
                Iterator iterator = ((List) (obj1)).iterator();
_L10:
                obj1 = obj2;
                if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
                obj1 = (SeriesWatchable)iterator.next();
                if (obj2 == null) goto _L8; else goto _L7
_L7:
                obj1 = obj2;
_L6:
                seriesFavorite = new VideoFavorite(tvSeriesFacade.getMerlinId(), tvSeriesFacade.getTitle(), dibicprogram.isAdult());
                Iterator iterator1;
                VideoFacade videofacade;
                if (instanceState.showSeriesArt.booleanValue() && (!playerAndroidDevice.isTabletDevice() || !alternateInterfaceListener.isAccessibilityEnabled()))
                {
                    seriesTitleContainer.setVisibility(8);
                    getActivity().setTitle(tvSeriesFacade.getTitle());
                    seriesTitle.setVisibility(8);
                    bookmarkMenuItemDelegate.setupFavorite(SeriesEpisodeListFragment.this, true, favoriteIndicator, seriesFavorite);
                } else
                {
                    seriesTitle.setText(tvSeriesFacade.getTitle());
                    seriesTitle.setVisibility(0);
                    bookmarkMenuItemDelegate.setupFavorite(SeriesEpisodeListFragment.this, false, favoriteIndicator, seriesFavorite);
                }
                alternateInterfaceListener.getTalkDelegate().setTitle(getString(com.xfinity.playerlib.R.string.content_description_detail_title, new Object[] {
                    "tv series", tvSeriesFacade.getTitle()
                }));
                seriesHeader.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls4 this$1;

                    public void onClick(View view)
                    {
                        instanceState.resetWatchableInfo();
                        instanceState.seriesDetailSelected = true;
                        clearEpisodeAdaptersSelections();
                        seriesEpisodeListContainer.showSeriesDetail();
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
                obj2 = new ConsumableVideoListHelper.InfoClickListenerFactory() {

                    final _cls4 this$1;

                    public com.xfinity.playerlib.view.common.PlayNowConsumableEpisodeArrayAdapter.OnInfoClickListener create(PlayNowConsumableEpisodeArrayAdapter playnowconsumableepisodearrayadapter)
                    {
                        return new com.xfinity.playerlib.view.common.PlayNowConsumableEpisodeArrayAdapter.OnInfoClickListener() {

                            final _cls2 this$2;

                            public void onClick(SeriesWatchable serieswatchable, int i)
                            {
                                instanceState.resetWatchableInfo();
                                instanceState.episodeId = serieswatchable.getMerlinId();
                                seriesEpisodeListContainer.showSeriesWatchableDetail(serieswatchable);
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        };
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                };
                displayDetail(seriesresource.bookmarkMap, ((Watchable) (obj1)), tvSeriesFacade, ((ConsumableVideoListHelper.InfoClickListenerFactory) (obj2)), videoentitlement);
                if (restoredListState != null)
                {
                    consumableVideoList.onRestoreInstanceState(restoredListState);
                    return;
                }
                  goto _L9
_L8:
                iterator1 = ((SeriesWatchable) (obj1)).getVideos().iterator();
_L12:
                if (iterator1.hasNext())
                {
                    videofacade = (VideoFacade)iterator1.next();
                    if (instanceState.companyId == null || videofacade.getNetworkInfo() == null || videofacade.getNetworkInfo().getCompanyId() != instanceState.companyId.longValue())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    obj2 = obj1;
                }
                  goto _L10
                if (!instanceState.wantsSubscriptionOnly || !videoentitlement.isEntitled(videofacade.getProviderCode())) goto _L12; else goto _L11
_L11:
                obj2 = obj1;
                  goto _L10
_L4:
                obj1 = (SeriesWatchable)((List) (obj1)).get(0);
                  goto _L6
                if (instanceState.watchableKey != null)
                {
                    obj1 = tvSeriesFacade.findWatchableByVideoId(instanceState.watchableKey.getVideoId());
                } else
                if (instanceState.useEpisodeId())
                {
                    obj1 = tvSeriesFacade.findEpisodeById(instanceState.episodeId);
                }
                  goto _L6
            }

            public volatile void onPostExecute(Object obj1)
            {
                onPostExecute((SeriesResource)obj1);
            }

            public void onPreAsynchronousExecute()
            {
                alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.string.loading);
            }

            
            {
                this$0 = SeriesEpisodeListFragment.this;
                super();
            }
        });
    }

    private void showEntityUnavailableView()
    {
        loadingViewDelegate.onLoadingFailed(com.xfinity.playerlib.R.string.error_series_not_available_text);
    }

    public boolean announceListItems()
    {
        if (announceListOnLoad && tvSeriesFacade != null)
        {
            alternateInterfaceListener.getTalkDelegate().cancelAllMessages();
            alternateInterfaceListener.getTalkDelegate().speak(getPlayNowEpisodeListTalkHelper(getActivity()).speakResults());
            announceListOnLoad = false;
            return true;
        } else
        {
            alternateInterfaceListener.getTalkDelegate().speakManagedMessage(com.xfinity.playerlib.R.id.ACCESSIBILITY_ANNOUNCE_LOADED);
            return false;
        }
    }

    public MergeAdapter getMergeAdapter()
    {
        return mergeAdapter;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        alternateInterfaceListener.addSpeechListener(speechListener);
        if (accessibilityUtil.isAccessibilityEnabled() && playerAndroidDevice.isTabletDevice())
        {
            getActivity().getActionBar().hide();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        seriesEpisodeListContainer = (SeriesEpisodeListContainer)activity;
        if (activity instanceof FetchCanceledListener)
        {
            fetchCanceledListener = (FetchCanceledListener)activity;
        } else
        {
            fetchCanceledListener = this;
        }
        alternateInterfaceListener = (AlternateInterfaceListener)activity;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        showEntityUnavailableView();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        bookmarkMenuItemDelegate.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = (ViewGroup)layoutinflater.inflate(com.xfinity.playerlib.R.layout.series_episode_list, viewgroup, false);
        seriesHeader = (CheckableRelativeLayout)viewgroup.findViewById(com.xfinity.playerlib.R.id.header);
        seriesTitle = (TextView)seriesHeader.findViewById(com.xfinity.playerlib.R.id.series_title);
        seriesThumbnail = (ImageView)seriesHeader.findViewById(com.xfinity.playerlib.R.id.series_thumbnail);
        favoriteIndicator = (CheckBox)seriesHeader.findViewById(com.xfinity.playerlib.R.id.favorite_indicator);
        consumableVideoList = (ListView)viewgroup.findViewById(com.xfinity.playerlib.R.id.episode_list);
        bodyContainer = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.body_container);
        notAvailableContainer = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.not_available_container);
        seriesTitleContainer = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.series_title_container);
        Bundle bundle1 = new Bundle();
        if (getArguments() != null)
        {
            bundle1.putAll(getArguments());
        }
        if (bundle != null)
        {
            bundle1.putAll(bundle);
        }
        announceListOnLoad = bundle1.getBoolean("KEY_ANNOUNCE_EPISODES");
        instanceState = InstanceState.fromBundle(bundle1);
        if (instanceState.showSeriesArt.booleanValue())
        {
            if (instanceState.useDownloadAsSource())
            {
                layoutinflater = instanceState.watchableKey.getParentMerlinId();
            } else
            {
                layoutinflater = instanceState.seriesId;
            }
            programDetailImageLoader.loadDetailProgramArt(layoutinflater, seriesThumbnail);
            seriesThumbnail.setVisibility(0);
            setHasOptionsMenu(true);
        } else
        {
            seriesThumbnail.setVisibility(8);
        }
        restoredListState = bundle1.getParcelable("listState");
        layoutinflater = (ViewGroup)viewgroup.findViewById(com.xfinity.playerlib.R.id.body_container);
        bundle = (LoadingIndicator)viewgroup.findViewById(com.xfinity.playerlib.R.id.loading_indicator);
        loadingViewDelegate = new DefaultLoadingViewDelegate(getActivity(), layoutinflater, bundle, internetConnection, new com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate.ReadyListener() {

            final SeriesEpisodeListFragment this$0;

            public void onReady()
            {
                loadScreenInfo();
            }

            
            {
                this$0 = SeriesEpisodeListFragment.this;
                super();
            }
        });
        alternateInterfaceListener.setupPassiveGestureDetector(viewgroup, com.xfinity.playerlib.R.id.touchy_parent);
        return viewgroup;
    }

    public void onDetach()
    {
        super.onDetach();
        alternateInterfaceListener.removeSpeechListener(speechListener);
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        activity = activity.obtainStyledAttributes(attributeset, com.xfinity.playerlib.R.styleable.com_xfinity_playerlib_view_programdetails_SeriesEpisodeListFragment);
        isFullScreen = activity.getBoolean(com.xfinity.playerlib.R.styleable.com_xfinity_playerlib_view_programdetails_SeriesEpisodeListFragment_isFullScreen, true);
        activity.recycle();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return bookmarkMenuItemDelegate.onOptionsItemSelected(menuitem, this, seriesFavorite);
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        announceListItems();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        instanceState.addToBundle(bundle);
        restoredListState = consumableVideoList.onSaveInstanceState();
        bundle.putParcelable("listState", restoredListState);
    }

    public void onStartInternal()
    {
        super.onStartInternal();
        loadingViewDelegate.onStart();
        downloadManager.addDownloadServiceListener(downloadServiceListener);
    }

    public void onStop()
    {
        super.onStop();
        loadingViewDelegate.onStop();
        downloadManager.removeDownloadServiceListener(downloadServiceListener);
        if (taskExecutor != null)
        {
            taskExecutor.cancelNotificationsFor(taskExecutionListener);
        }
    }

    public void setAnimationEnabled(Boolean boolean1)
    {
        animationsEnabled = boolean1.booleanValue();
    }

    public void showEpisodeAsSelected(SeriesWatchable serieswatchable)
    {
        if (seriesEpisodeListContainer.shouldShowSeriesListItemsChecked())
        {
            seriesHeader.setChecked(false);
            PlayNowConsumableEpisodeArrayAdapter playnowconsumableepisodearrayadapter;
            for (Iterator iterator = episodeAdapters.iterator(); iterator.hasNext(); playnowconsumableepisodearrayadapter.setCheckedPos(playnowconsumableepisodearrayadapter.getPosition(serieswatchable)))
            {
                playnowconsumableepisodearrayadapter = (PlayNowConsumableEpisodeArrayAdapter)iterator.next();
            }

        }
    }

    public void showSeriesAsSelected()
    {
        if (seriesEpisodeListContainer.shouldShowSeriesListItemsChecked())
        {
            clearEpisodeAdaptersSelections();
            seriesHeader.setChecked(true);
        }
    }















/*
    static boolean access$2002(SeriesEpisodeListFragment seriesepisodelistfragment, boolean flag)
    {
        seriesepisodelistfragment.announceListOnLoad = flag;
        return flag;
    }

*/






/*
    static TvSeriesFacade access$602(SeriesEpisodeListFragment seriesepisodelistfragment, TvSeriesFacade tvseriesfacade)
    {
        seriesepisodelistfragment.tvSeriesFacade = tvseriesfacade;
        return tvseriesfacade;
    }

*/



/*
    static DibicResource access$702(SeriesEpisodeListFragment seriesepisodelistfragment, DibicResource dibicresource)
    {
        seriesepisodelistfragment.dibicResource = dibicresource;
        return dibicresource;
    }

*/




/*
    static VideoFavorite access$902(SeriesEpisodeListFragment seriesepisodelistfragment, VideoFavorite videofavorite)
    {
        seriesepisodelistfragment.seriesFavorite = videofavorite;
        return videofavorite;
    }

*/
}
