// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;
import com.google.common.collect.Sets;
import com.xfinity.playerlib.alt.speechrecognizers.SeriesSpeechRecognizer;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.view.BaseInstanceState;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailActivity, SeriesCombinedTaskExecutorFactory, EpisodeDetailActivity, SeriesEpisodeListFragment, 
//            DetailIntentHelper, DetailFragment, SeriesDetailFragment, SeriesDetailActivity, 
//            SeriesResource

public class SeriesEntityActivity extends DetailActivity
    implements DetailFragment.PlayPressedListener, SeriesEpisodeListFragment.SeriesEpisodeListContainer
{
    public static class InstanceState extends BaseInstanceState
    {

        protected static final String EXTRA_BUNDLE_PARAMS = com/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState.getCanonicalName();

        public static InstanceState fromBundle(Bundle bundle)
        {
            return (InstanceState)bundle.getSerializable(EXTRA_BUNDLE_PARAMS);
        }

        public Bundle addToBundle(Bundle bundle)
        {
            bundle.putSerializable(EXTRA_BUNDLE_PARAMS, this);
            return bundle;
        }


        public InstanceState()
        {
        }
    }

    private class ProxyTaskExecutionListener extends DefaultTaskExecutionListener
    {

        final SeriesEntityActivity this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
            SeriesEntityActivity.LOG.error("Proxy fetch listener received error", taskexecutionexception);
            showError();
        }

        public void onPostExecute(SeriesResource seriesresource)
        {
            SeriesEntityActivity.LOG.debug("Data fetched with {} pending listeners", Integer.valueOf(pendingListeners.size()));
            TaskExecutionListener taskexecutionlistener;
            for (Iterator iterator = pendingListeners.iterator(); iterator.hasNext(); SeriesEntityActivity.LOG.debug("Delegate listener {} notified", taskexecutionlistener))
            {
                taskexecutionlistener = (TaskExecutionListener)iterator.next();
                taskexecutionlistener.onPostExecute(seriesresource);
                iterator.remove();
            }

            hideLoading();
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((SeriesResource)obj);
        }

        public void onPreAsynchronousExecute()
        {
            showLoading();
        }

        private ProxyTaskExecutionListener()
        {
            this$0 = SeriesEntityActivity.this;
            super();
        }

    }

    private class ProxyTaskExecutor
        implements TaskExecutor
    {

        final SeriesEntityActivity this$0;

        public void cancelNotificationsFor(TaskExecutionListener taskexecutionlistener)
        {
            pendingListeners.remove(taskexecutionlistener);
        }

        public TaskExecutionListener execute(TaskExecutionListener taskexecutionlistener)
        {
            if (pendingListeners.isEmpty())
            {
                pendingListeners.add(taskexecutionlistener);
                SeriesEntityActivity.LOG.debug("Fetching data for delegate listener {}", taskexecutionlistener);
                triggerLoading();
                return taskexecutionlistener;
            } else
            {
                pendingListeners.add(taskexecutionlistener);
                SeriesEntityActivity.LOG.debug("Added {} to the list of pending listeners for in-progress fetch", taskexecutionlistener);
                return taskexecutionlistener;
            }
        }

        private ProxyTaskExecutor()
        {
            this$0 = SeriesEntityActivity.this;
            super();
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/programdetails/SeriesEntityActivity);
    private final AccessibilityUtil accessibilityUtil = CALContainer.getInstance().getAccessibilityUtil();
    private View bodyContainer;
    private final InternetConnection connection = CALContainer.getInstance().getInternetConnection();
    private final PlayerDownloadServiceManager downloadManager = PlayerContainer.getInstance().getDownloadServiceManager();
    private SeriesEpisodeListFragment episodeListFragment;
    private FragmentManager fm;
    private InstanceState instanceState;
    private boolean isDualPanel;
    private View loadingIndicator;
    private TextView loadingInfoText;
    private ProgressBar loadingProgressBar;
    private Button loadingRetryButton;
    private final BroadcastReceiver networkReceiver = new BroadcastReceiver() {

        final SeriesEntityActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            boolean flag = intent.getBooleanExtra("noConnectivity", false);
            SeriesEntityActivity.LOG.debug("Network change, isNetworkDown {}", Boolean.valueOf(flag));
            if (waitingForInternet && !flag)
            {
                SeriesEntityActivity.LOG.debug("Internet connect reestablished, triggering loading");
                waitingForInternet = false;
                triggerLoading();
            }
        }

            
            {
                this$0 = SeriesEntityActivity.this;
                super();
            }
    };
    private final Set pendingListeners = Sets.newHashSet();
    private final TaskExecutionListener proxyTaskExecutionListener = new ProxyTaskExecutionListener();
    private final TaskExecutor proxyTaskExecutor = new ProxyTaskExecutor();
    private boolean receiverRegistered;
    private final TaskFactory seriesCacheMap = PlayerContainer.getInstance().getSeriesCacheMap();
    private final SeriesCombinedTaskExecutorFactory seriesCombinedTaskExecutorFactory = PlayerContainer.getInstance().getSeriesCombinedTaskExecutorFactory();
    private TaskExecutor taskExecutor;
    private boolean waitingForInternet;

    public SeriesEntityActivity()
    {
        fm = getFragmentManager();
        instanceState = null;
        receiverRegistered = false;
        waitingForInternet = false;
    }

    private void initDataProvider()
    {
        Object obj;
        if (instanceState.useDownloadAsSource())
        {
            obj = new NonCachingBaseTask() {

                final SeriesEntityActivity this$0;

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
                this$0 = SeriesEntityActivity.this;
                super();
            }
            };
        } else
        {
            obj = seriesCacheMap.get(instanceState.seriesId);
        }
        taskExecutor = seriesCombinedTaskExecutorFactory.create(((Task) (obj)));
    }

    private void showError()
    {
        if (connection.isConnected())
        {
            loadingInfoText.setText(getResources().getString(com.xfinity.playerlib.R.string.loading_exception));
            loadingInfoText.setVisibility(0);
            loadingRetryButton.setVisibility(0);
            loadingProgressBar.setVisibility(4);
            return;
        } else
        {
            LOG.error("Connection error, enter waiting state");
            loadingInfoText.setText(getResources().getString(com.xfinity.playerlib.R.string.waiting_for_internet));
            loadingInfoText.setVisibility(0);
            waitingForInternet = true;
            return;
        }
    }

    private void triggerLoading()
    {
        loadingProgressBar.setVisibility(0);
        loadingInfoText.setVisibility(4);
        loadingRetryButton.setVisibility(8);
        taskExecutor.execute(proxyTaskExecutionListener);
    }

    protected Class getEpisodeDetailActivityClass()
    {
        return com/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;
    }

    protected InstanceState getInstanceState()
    {
        return instanceState;
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.series_entity;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;
    }

    TaskExecutor getTaskExecutor()
    {
        if (isDualPanel)
        {
            LOG.debug("Returning proxy resource provider for dual panel view");
            return proxyTaskExecutor;
        } else
        {
            return taskExecutor;
        }
    }

    public void hideLoading()
    {
        bodyContainer.setVisibility(0);
        loadingIndicator.setVisibility(8);
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag1 = true;
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        boolean flag2 = bundle.getBoolean("KEY_ANNOUNCE_EPISODES");
        instanceState = InstanceState.fromBundle(bundle);
        boolean flag;
        if (findViewById(com.xfinity.playerlib.R.id.fragment_container_2) != null && !accessibilityUtil.isAccessibilityEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isDualPanel = flag;
        initDataProvider();
        loadingIndicator = findViewById(com.xfinity.playerlib.R.id.loading_indicator);
        bodyContainer = findViewById(com.xfinity.playerlib.R.id.body_container);
        loadingInfoText = (TextView)findViewById(com.xfinity.playerlib.R.id.loading_info_text);
        loadingRetryButton = (Button)findViewById(com.xfinity.playerlib.R.id.loading_retry_button);
        if (loadingRetryButton != null)
        {
            loadingRetryButton.setOnClickListener(new android.view.View.OnClickListener() {

                final SeriesEntityActivity this$0;

                public void onClick(View view)
                {
                    triggerLoading();
                }

            
            {
                this$0 = SeriesEntityActivity.this;
                super();
            }
            });
        }
        loadingProgressBar = (ProgressBar)findViewById(com.xfinity.playerlib.R.id.loading_progressbar);
        bundle = fm.beginTransaction();
        episodeListFragment = (SeriesEpisodeListFragment)fm.findFragmentByTag("episodeList");
        if (episodeListFragment == null)
        {
            Object obj = new DetailIntentHelper.Builder(instanceState, com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries);
            if (!isDualPanel)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = ((DetailIntentHelper.Builder) (obj)).showSeriesArt(flag).companyId(instanceState.companyId);
            if (instanceState.companyId == null && instanceState.wantsSubscriptionOnly)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = ((DetailIntentHelper.Builder) (obj)).wantsSubscriptionOnly(flag).build();
            episodeListFragment = new SeriesEpisodeListFragment();
            ((DetailIntentHelper) (obj)).getBundle().putBoolean("KEY_ANNOUNCE_EPISODES", flag2);
            obj = ((DetailIntentHelper) (obj)).getBundle();
            ((Bundle) (obj)).putBoolean("KEY_ANNOUNCE_EPISODES", flag2);
            episodeListFragment.setArguments(((Bundle) (obj)));
            bundle.replace(com.xfinity.playerlib.R.id.fragment_container_1, episodeListFragment, "episodeList");
        }
        if (isDualPanel && (DetailFragment)fm.findFragmentByTag("detail") == null)
        {
            obj = (new DetailIntentHelper.Builder(instanceState, com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode)).shouldHideSeriesTitle(true).companyId(instanceState.companyId);
            if (instanceState.companyId == null && instanceState.wantsSubscriptionOnly)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            obj = ((DetailIntentHelper.Builder) (obj)).wantsSubscriptionOnly(flag).build().getFragment();
            bundle.replace(com.xfinity.playerlib.R.id.fragment_container_2, ((android.app.Fragment) (obj)), "detail");
        }
        bundle.commit();
    }

    public void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable)
    {
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            getTalkDelegate().speak(getString(com.xfinity.playerlib.R.string.speech_playing_x, new Object[] {
                watchable.getTitle()
            }));
        }
        videofacade = VideoPlayerActivity.createIntentForPlayer(videofacade, watchable);
        videofacade.setFlags(0x4000000);
        startActivity(videofacade);
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        checkTalkBackModeOnResume();
    }

    public void onSpeechSwipe()
    {
        getTalkDelegate().stopSpeaking();
        Bundle bundle = new Bundle();
        bundle.putSerializable("INTENT_KEY_SERIES_ID", instanceState.seriesId);
        long l;
        if (instanceState.currentlyPlayingVideoId == null)
        {
            l = -1L;
        } else
        {
            l = instanceState.currentlyPlayingVideoId.longValue();
        }
        bundle.putLong("INTENT_KEY_CURRENTLY_PLAYING_VIDEO_ID", l);
        getSpeechDelegate().getSpeechInput(getSpeechRecognizerClass(), bundle);
    }

    public void onStartInternal()
    {
        super.onStartInternal();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkReceiver, intentfilter);
        receiverRegistered = true;
    }

    protected void onStop()
    {
        super.onStop();
        if (receiverRegistered)
        {
            unregisterReceiver(networkReceiver);
            receiverRegistered = false;
        }
        if (taskExecutor != null)
        {
            taskExecutor.cancelNotificationsFor(proxyTaskExecutionListener);
        }
    }

    public boolean shouldShowSeriesListItemsChecked()
    {
        return isDualPanel;
    }

    public void showLoading()
    {
        bodyContainer.setVisibility(4);
        loadingIndicator.setVisibility(0);
    }

    public void showSeriesDetail()
    {
        Bundle bundle;
        if (instanceState.useDownloadAsSource())
        {
            bundle = SeriesDetailFragment.createBundle(instanceState.watchableKey);
        } else
        {
            bundle = SeriesDetailFragment.createBundle(instanceState.seriesId);
        }
        if (isDualPanel)
        {
            FragmentTransaction fragmenttransaction = fm.beginTransaction();
            SeriesDetailFragment seriesdetailfragment = new SeriesDetailFragment();
            seriesdetailfragment.setArguments(bundle);
            fragmenttransaction.replace(com.xfinity.playerlib.R.id.fragment_container_2, seriesdetailfragment, "detail");
            fragmenttransaction.commit();
            episodeListFragment.showSeriesAsSelected();
            return;
        } else
        {
            Intent intent = new Intent(this, com/xfinity/playerlib/view/programdetails/SeriesDetailActivity);
            intent.putExtras(bundle);
            startActivity(intent);
            return;
        }
    }

    public void showSeriesWatchableDetail(SeriesWatchable serieswatchable)
    {
        boolean flag2 = true;
        boolean flag = true;
        Object obj;
        if (instanceState.watchableKey != null)
        {
            obj = (new DetailIntentHelper.Builder(instanceState.watchableKey)).shouldHideSeriesTitle(isDualPanel).currentlyPlayingVideo(instanceState.currentlyPlayingVideoId).episodeId(serieswatchable.getMerlinId()).overrideNamespace(com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode).companyId(instanceState.companyId);
            FragmentTransaction fragmenttransaction;
            if (instanceState.companyId != null || !instanceState.wantsSubscriptionOnly)
            {
                flag = false;
            }
            obj = ((DetailIntentHelper.Builder) (obj)).wantsSubscriptionOnly(flag).build();
        } else
        {
            obj = (new DetailIntentHelper.Builder(serieswatchable)).currentlyPlayingVideo(instanceState.currentlyPlayingVideoId).shouldHideSeriesTitle(isDualPanel).overrideNamespace(com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode).companyId(instanceState.companyId);
            boolean flag1;
            if (instanceState.companyId == null && instanceState.wantsSubscriptionOnly)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            obj = ((DetailIntentHelper.Builder) (obj)).wantsSubscriptionOnly(flag1).build();
        }
        if (isDualPanel)
        {
            fragmenttransaction = fm.beginTransaction();
            fragmenttransaction.replace(com.xfinity.playerlib.R.id.fragment_container_2, ((DetailIntentHelper) (obj)).getFragment(), "detail");
            fragmenttransaction.commit();
            episodeListFragment.showEpisodeAsSelected(serieswatchable);
            return;
        } else
        {
            serieswatchable = new Intent(this, getEpisodeDetailActivityClass());
            serieswatchable.putExtras(((DetailIntentHelper) (obj)).getBundle());
            startActivity(serieswatchable);
            return;
        }
    }





/*
    static boolean access$302(SeriesEntityActivity seriesentityactivity, boolean flag)
    {
        seriesentityactivity.waitingForInternet = flag;
        return flag;
    }

*/






}
