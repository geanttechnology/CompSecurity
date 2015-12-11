// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.EncodedWatchable;
import com.xfinity.playerlib.model.consumable.EpisodeFacade;
import com.xfinity.playerlib.model.consumable.MovieFacade;
import com.xfinity.playerlib.model.consumable.SeriesWatchableInfo;
import com.xfinity.playerlib.model.consumable.VideoComparator;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.WatchableCodec;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalEpisode;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeason;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, SetupMediaPlayerState, ErrorState, 
//            BackgroundState, VideoState, QuitState

public class StartState extends DefaultVideoState
{
    private abstract class EntityTaskExecutionListener extends RetryingTaskExecutionListener
    {

        private Long companyId;
        final StartState this$0;
        private WatchableKey watchableKey;

        protected abstract Watchable createWatchable(Object obj);

        public void onPostExecute(Tuple tuple)
        {
            Object obj1 = (VideoEntitlement)tuple.e1;
            tuple = ((Tuple) (tuple.e2));
            Object obj;
            Watchable watchable;
            try
            {
                watchable = createWatchable(tuple);
            }
            // Misplaced declaration of an exception variable
            catch (Tuple tuple)
            {
                StartState.LOG.error("Entity parsing error (possible data issue)", tuple);
                onError(new TaskExecutionException(tuple));
                return;
            }
            obj = null;
            if (watchableKey != null)
            {
                obj = watchable.findVideoById(watchableKey.getVideoId());
            } else
            if (watchable != null && !watchable.getVideos().isEmpty())
            {
                obj1 = new TreeSet(new VideoComparator(((VideoEntitlement) (obj1))));
                ((TreeSet) (obj1)).addAll(watchable.getVideos());
                tuple = ((Tuple) (obj));
                if (companyId != null)
                {
                    tuple = ((Tuple) (obj));
                    if (companyId.longValue() > 0L)
                    {
                        Iterator iterator = ((TreeSet) (obj1)).iterator();
                        do
                        {
                            tuple = ((Tuple) (obj));
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            tuple = (VideoFacade)iterator.next();
                        } while (tuple.getNetworkInfo() == null || tuple.getNetworkInfo().getCompanyId() != companyId.longValue());
                    }
                }
                obj = tuple;
                if (tuple == null)
                {
                    obj = (VideoFacade)((TreeSet) (obj1)).first();
                }
            } else
            {
                stateController.onVideoFetchFailed();
                return;
            }
            if (obj != null)
            {
                stateController.onVideoFetched(((VideoFacade) (obj)), watchable);
                return;
            } else
            {
                stateController.onVideoFetchFailed();
                return;
            }
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((Tuple)obj);
        }

        public EntityTaskExecutionListener(TaskExecutor taskexecutor)
        {
            this$0 = StartState.this;
            super(taskexecutor, stateController.getActivityContext(), stateController.getErrorDialogFactory(), cancelListener);
        }

        public EntityTaskExecutionListener(TaskExecutor taskexecutor, WatchableKey watchablekey)
        {
            this(taskexecutor);
            watchableKey = watchablekey;
        }

        public EntityTaskExecutionListener(TaskExecutor taskexecutor, Long long1)
        {
            this(taskexecutor);
            companyId = long1;
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/StartState);
    final android.content.DialogInterface.OnCancelListener cancelListener = new android.content.DialogInterface.OnCancelListener() {

        final StartState this$0;

        public void onCancel(DialogInterface dialoginterface)
        {
            transitionToState(new QuitState(stateController));
        }

            
            {
                this$0 = StartState.this;
                super();
            }
    };
    private TaskExecutionListener liveStreamMetaDataResourceTaskExecutionListener;
    private TaskExecutor liveStreamMetaDataResourceTaskExecutor;
    private TaskExecutionListener liveStreamResourceTaskExecutionListener;
    private TaskExecutor liveStreamResourceTaskExecutor;
    private TaskExecutionListener movieEntityTaskExecutionListener;
    private TaskExecutor movieEntityTaskExecutor;
    private TaskExecutionListener seriesEntityTaskExecutionListener;
    private TaskExecutor seriesEntityTaskExecutor;

    public StartState(VideoStateController videostatecontroller)
    {
        super(videostatecontroller);
    }

    private void fetchEpisode(MerlinId merlinid, MerlinId merlinid1, Long long1)
    {
        com.comcast.cim.cmasl.taskexecutor.task.Task task = stateController.getSeriesCacheMap().get(merlinid1);
        seriesEntityTaskExecutor = stateController.getTaskExecutorFactory().create(stateController.getVideoEntitlementCache(), task);
        seriesEntityTaskExecutionListener = new EntityTaskExecutionListener(merlinid, merlinid1) {

            final StartState this$0;
            final MerlinId val$merlinId;
            final MerlinId val$parentMerlinId;

            protected Watchable createWatchable(HalTvSeriesConsumable haltvseriesconsumable)
            {
                Object obj = null;
                if (merlinId.equals(parentMerlinId)) goto _L2; else goto _L1
_L1:
                EpisodeFacade episodefacade = new EpisodeFacade(haltvseriesconsumable, merlinId);
_L4:
                return episodefacade;
_L2:
                Iterator iterator1 = haltvseriesconsumable.getSeasons().iterator();
_L6:
                episodefacade = obj;
                if (!iterator1.hasNext()) goto _L4; else goto _L3
_L3:
                HalEpisode halepisode;
                Iterator iterator = ((HalTvSeason)iterator1.next()).getEpisodes().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    halepisode = (HalEpisode)iterator.next();
                } while (halepisode.getVideos().isEmpty());
                break; /* Loop/switch isn't completed */
                if (true) goto _L6; else goto _L5
_L5:
                return new EpisodeFacade(haltvseriesconsumable, halepisode.getMerlinEntityId());
            }

            protected volatile Watchable createWatchable(Object obj)
            {
                return createWatchable((HalTvSeriesConsumable)obj);
            }

            
            {
                this$0 = StartState.this;
                merlinId = merlinid;
                parentMerlinId = merlinid1;
                super(final_taskexecutor, final_long1);
            }
        };
        seriesEntityTaskExecutor.execute(seriesEntityTaskExecutionListener);
    }

    private void fetchEpisode(WatchableKey watchablekey)
    {
        Object obj = watchablekey.getParentMerlinId();
        obj = stateController.getSeriesCacheMap().get(obj);
        seriesEntityTaskExecutor = stateController.getTaskExecutorFactory().create(stateController.getVideoEntitlementCache(), ((com.comcast.cim.cmasl.taskexecutor.task.Task) (obj)));
        seriesEntityTaskExecutionListener = new EntityTaskExecutionListener(watchablekey, watchablekey) {

            final StartState this$0;
            final WatchableKey val$watchableKey;

            protected Watchable createWatchable(HalTvSeriesConsumable haltvseriesconsumable)
            {
                return stateController.getWatchableCodec().decode(new EncodedWatchable(watchableKey, haltvseriesconsumable));
            }

            protected volatile Watchable createWatchable(Object obj1)
            {
                return createWatchable((HalTvSeriesConsumable)obj1);
            }

            
            {
                this$0 = StartState.this;
                watchableKey = watchablekey1;
                super(final_taskexecutor, watchablekey);
            }
        };
        seriesEntityTaskExecutor.execute(seriesEntityTaskExecutionListener);
    }

    private void fetchLiveStreamById(String s)
    {
        stateController.getUiController().setLaunchScreenMessage(com.xfinity.playerlib.R.string.player_launch_fetch_live_stream_details);
        liveStreamResourceTaskExecutor = stateController.getTaskExecutorFactory().create(stateController.getLiveStreamResourceCache());
        liveStreamResourceTaskExecutionListener = new RetryingTaskExecutionListener(stateController.getActivityContext(), stateController.getErrorDialogFactory(), cancelListener, s) {

            final StartState this$0;
            final String val$streamId;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                stateController.getUiController().hideLaunchScreen();
                super.onError(taskexecutionexception);
            }

            public void onPostExecute(HalLiveStreamResource hallivestreamresource)
            {
                stateController.onLiveStreamFetched(hallivestreamresource.getLiveStream(streamId));
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((HalLiveStreamResource)obj);
            }

            
            {
                this$0 = StartState.this;
                streamId = s;
                super(final_taskexecutor, context, errordialogfactory, oncancellistener);
            }
        };
        liveStreamResourceTaskExecutor.execute(liveStreamResourceTaskExecutionListener);
    }

    private void fetchLiveStreamByName(String s)
    {
        stateController.getUiController().setLaunchScreenMessage(com.xfinity.playerlib.R.string.player_launch_fetch_live_stream_details);
        liveStreamMetaDataResourceTaskExecutor = stateController.getTaskExecutorFactory().create(stateController.getLiveStreamMetaDataResourceFactory().get(s));
        liveStreamMetaDataResourceTaskExecutionListener = new RetryingTaskExecutionListener(liveStreamMetaDataResourceTaskExecutor, stateController.getActivityContext(), stateController.getErrorDialogFactory(), cancelListener) {

            final StartState this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                stateController.getUiController().hideLaunchScreen();
                super.onError(taskexecutionexception);
            }

            public void onPostExecute(HalLiveStream hallivestream)
            {
                stateController.onLiveStreamFetched(hallivestream);
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((HalLiveStream)obj);
            }

            
            {
                this$0 = StartState.this;
                super(taskexecutor, context, errordialogfactory, oncancellistener);
            }
        };
        liveStreamMetaDataResourceTaskExecutor.execute(liveStreamMetaDataResourceTaskExecutionListener);
    }

    private void fetchMovie(MerlinId merlinid, Long long1)
    {
        merlinid = stateController.getMovieCacheMap().get(merlinid);
        movieEntityTaskExecutor = stateController.getTaskExecutorFactory().create(stateController.getVideoEntitlementCache(), merlinid);
        movieEntityTaskExecutionListener = new EntityTaskExecutionListener(movieEntityTaskExecutor, long1) {

            final StartState this$0;

            protected Watchable createWatchable(HalMovieConsumable halmovieconsumable)
            {
                return new MovieFacade(halmovieconsumable);
            }

            protected volatile Watchable createWatchable(Object obj)
            {
                return createWatchable((HalMovieConsumable)obj);
            }

            
            {
                this$0 = StartState.this;
                super(taskexecutor, long1);
            }
        };
        movieEntityTaskExecutor.execute(movieEntityTaskExecutionListener);
    }

    private void fetchMovie(WatchableKey watchablekey)
    {
        Object obj = watchablekey.getParentMerlinId();
        obj = stateController.getMovieCacheMap().get(obj);
        movieEntityTaskExecutor = stateController.getTaskExecutorFactory().create(stateController.getVideoEntitlementCache(), ((com.comcast.cim.cmasl.taskexecutor.task.Task) (obj)));
        movieEntityTaskExecutionListener = new EntityTaskExecutionListener(watchablekey, watchablekey) {

            final StartState this$0;
            final WatchableKey val$watchableKey;

            protected Watchable createWatchable(HalMovieConsumable halmovieconsumable)
            {
                return stateController.getWatchableCodec().decode(new EncodedWatchable(watchableKey, halmovieconsumable));
            }

            protected volatile Watchable createWatchable(Object obj1)
            {
                return createWatchable((HalMovieConsumable)obj1);
            }

            
            {
                this$0 = StartState.this;
                watchableKey = watchablekey1;
                super(final_taskexecutor, watchablekey);
            }
        };
        movieEntityTaskExecutor.execute(movieEntityTaskExecutionListener);
    }

    private void fetchVideo(Long long1, MerlinId merlinid, MerlinId merlinid1, Long long2)
    {
        stateController.getUiController().setLaunchScreenMessage(com.xfinity.playerlib.R.string.player_launch_fetch_details);
        PlayerDownloadFile playerdownloadfile;
        if (long1 == null)
        {
            playerdownloadfile = stateController.getPlayerDownloadServiceManager().findFileWithMerlinData(merlinid, merlinid1, long2);
        } else
        {
            playerdownloadfile = stateController.getPlayerDownloadServiceManager().findFileWithVideoId(long1.longValue());
        }
        if (playerdownloadfile != null)
        {
            if (playerdownloadfile.isDownloadComplete() && playerdownloadfile.getExpirationStatus() == com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.NOT_EXPIRED)
            {
                setupVideoAndWatchable(playerdownloadfile.getVideo(), playerdownloadfile.getWatchable(), playerdownloadfile);
                stateController.transitionToState(new SetupMediaPlayerState(stateController));
                return;
            } else
            {
                stateController.transitionToState(new ErrorState(stateController, stateController.getActivityContext().getResources().getString(com.xfinity.playerlib.R.string.video_startup_error)));
                return;
            }
        }
        if (long1 != null)
        {
            fetchWatchable(new WatchableKey(merlinid1, long1.longValue()));
            return;
        } else
        {
            fetchWatchable(merlinid, merlinid1, long2);
            return;
        }
    }

    private void fetchWatchable(MerlinId merlinid, MerlinId merlinid1, Long long1)
    {
        if (merlinid.getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
        {
            fetchMovie(merlinid, long1);
            return;
        } else
        {
            fetchEpisode(merlinid, merlinid1, long1);
            return;
        }
    }

    private void fetchWatchable(WatchableKey watchablekey)
    {
        if (watchablekey.getParentMerlinId().getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
        {
            fetchMovie(watchablekey);
            return;
        } else
        {
            fetchEpisode(watchablekey);
            return;
        }
    }

    private void onPostVideoSetup(VideoFacade videofacade, Watchable watchable)
    {
        stateController.checkShouldPauseDownloads();
        SeriesWatchableInfo serieswatchableinfo = watchable.getSeriesInfoIfApplicable();
        if (serieswatchableinfo != null && serieswatchableinfo.getSeasonNumber().intValue() > -1)
        {
            watchable = stateController.getActivityContext().getString(com.xfinity.playerlib.R.string.video_episode_title, new Object[] {
                serieswatchableinfo.getSeasonNumber(), serieswatchableinfo.getEpisodeNumber(), watchable.getDisplayTitle()
            });
        } else
        {
            watchable = watchable.getDisplayTitle();
        }
        stateController.getUiController().setVideoTitle(watchable);
        stateController.getUiController().setupRatingsBug(videofacade);
        stateController.getUiController().setInfoTabIcon();
        stateController.getUiController().configurePlaybackControls();
    }

    private void setupLiveStream(HalLiveStream hallivestream)
    {
        stateController.setLiveStream(hallivestream);
        stateController.checkShouldPauseDownloads();
        stateController.getUiController().setVideoTitle(hallivestream.getTitle());
        stateController.getUiController().setupRatingsBug(null);
        stateController.getUiController().setInfoTabIcon();
        stateController.getUiController().setNetworkInfo(hallivestream.getNetworkLogoUrl(), hallivestream.getTitle());
        stateController.getUiController().configurePlaybackControls();
    }

    private void setupVideoAndWatchable(VideoFacade videofacade, Watchable watchable, PlayerDownloadFile playerdownloadfile)
    {
        stateController.setVideoAndWatchable(videofacade, watchable);
        stateController.setDownloadedFile(playerdownloadfile);
        onPostVideoSetup(videofacade, watchable);
    }

    public String getStateName()
    {
        return "StartState";
    }

    public void onActivityPaused()
    {
        if (movieEntityTaskExecutor != null)
        {
            movieEntityTaskExecutor.cancelNotificationsFor(movieEntityTaskExecutionListener);
        }
        if (seriesEntityTaskExecutor != null)
        {
            seriesEntityTaskExecutor.cancelNotificationsFor(seriesEntityTaskExecutionListener);
        }
        if (liveStreamResourceTaskExecutor != null)
        {
            liveStreamResourceTaskExecutor.cancelNotificationsFor(liveStreamResourceTaskExecutionListener);
        }
        stateController.transitionToState(new BackgroundState(stateController, this));
    }

    public void onActivityResumed()
    {
        run();
    }

    public void onLiveStreamFetched(HalLiveStream hallivestream)
    {
        if (hallivestream == null)
        {
            transitionToState(new ErrorState(stateController, stateController.getActivityContext().getString(com.xfinity.playerlib.R.string.error_stream_not_available_text)));
            return;
        } else
        {
            setupLiveStream(hallivestream);
            stateController.transitionToState(new SetupMediaPlayerState(stateController));
            return;
        }
    }

    public void onVideoFetchFailed()
    {
        stateController.transitionToState(new ErrorState(stateController, stateController.getActivityContext().getResources().getString(com.xfinity.playerlib.R.string.error_video_not_available_text)));
    }

    public void onVideoFetched(VideoFacade videofacade, Watchable watchable)
    {
        setupVideoAndWatchable(videofacade, watchable, null);
        stateController.transitionToState(new SetupMediaPlayerState(stateController));
    }

    public void run()
    {
        stateController.getUiController().setLaunchScreenMessage(com.xfinity.playerlib.R.string.player_launch_starting);
        stateController.getUiController().showLaunchScreen();
        stateController.getUiController().hideMainControls();
        stateController.getUiController().hideActionBar();
        if (stateController.getVideoFacade() != null && stateController.getWatchable() != null)
        {
            PlayerDownloadFile playerdownloadfile = stateController.getPlayerDownloadServiceManager().findFileWithVideoId(stateController.getVideoFacade().getVideoId());
            stateController.setDownloadedFile(playerdownloadfile);
            onPostVideoSetup(stateController.getVideoFacade(), stateController.getWatchable());
            stateController.transitionToState(new SetupMediaPlayerState(stateController));
            return;
        }
        Object obj = null;
        Bundle bundle = stateController.getActivityContext().getIntent().getExtras();
        if (bundle.containsKey("liveStreamID"))
        {
            if (stateController.getLiveStream() != null)
            {
                obj = stateController.getLiveStream();
                stateController.getUiController().setVideoTitle(((HalLiveStream) (obj)).getTitle());
                stateController.getUiController().setNetworkInfo(((HalLiveStream) (obj)).getNetworkLogoUrl(), ((HalLiveStream) (obj)).getTitle());
                stateController.checkShouldPauseDownloads();
                stateController.transitionToState(new SetupMediaPlayerState(stateController));
                return;
            } else
            {
                fetchLiveStreamById(bundle.getString("liveStreamID"));
                return;
            }
        }
        if (bundle.containsKey("liveStreamName"))
        {
            fetchLiveStreamByName(bundle.getString("liveStreamName"));
            return;
        }
        if (bundle.containsKey("videoId"))
        {
            obj = Long.valueOf(bundle.getLong("videoId"));
        }
        MerlinId merlinid = (MerlinId)bundle.getSerializable("merlinId");
        MerlinId merlinid1 = (MerlinId)bundle.getSerializable("parentMerlinId");
        Long long1 = null;
        if (bundle.containsKey("companyId"))
        {
            long1 = Long.valueOf(bundle.getLong("companyId"));
        }
        fetchVideo(((Long) (obj)), merlinid, merlinid1, long1);
    }

    public void transitionToState(VideoState videostate)
    {
        if (videostate instanceof SetupMediaPlayerState)
        {
            stateController.setState(videostate);
            return;
        } else
        {
            super.transitionToState(videostate);
            return;
        }
    }


}
