// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.android.accessibility.AlternateInterfaceUtil;
import com.comcast.cim.android.accessibility.SpeechActions;
import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import com.xfinity.playerlib.view.programdetails.EpisodeDetailActivity;
import com.xfinity.playerlib.view.programdetails.SeriesCombinedTaskExecutorFactory;
import com.xfinity.playerlib.view.programdetails.SeriesResource;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class SeriesSpeechRecognizer extends PlayerSpeechRecognizer
{

    private Long currentlyPlayingVideoId;
    private TaskFactory seriesCacheMap;
    private SeriesCombinedTaskExecutorFactory seriesCombinedTaskExecutorFactory;
    private MerlinId seriesId;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;

    public SeriesSpeechRecognizer()
    {
        seriesCacheMap = PlayerContainer.getInstance().getSeriesCacheMap();
        seriesCombinedTaskExecutorFactory = PlayerContainer.getInstance().getSeriesCombinedTaskExecutorFactory();
    }

    private boolean playOrLoadSeriesWatchable(SeriesWatchable serieswatchable, SpeechPresentationMode speechpresentationmode)
    {
        Object obj = serieswatchable.getVideos().iterator();
        if (((Iterator) (obj)).hasNext())
        {
            obj = (VideoFacade)((Iterator) (obj)).next();
            if (speechpresentationmode.equals(SpeechPresentationMode.PLAY))
            {
                playSeriesWatchable(serieswatchable, ((VideoFacade) (obj)));
            } else
            {
                showSeriesWatchableDetail(((VideoFacade) (obj)), serieswatchable);
            }
            return true;
        } else
        {
            return false;
        }
    }

    private boolean playOrShowIfValidListNumberForSeriesWatchable(List list, String as[], SpeechPresentationMode speechpresentationmode)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (as.length == 1)
        {
            int i = alternateInterfaceUtil.interpretIfNumber(as[0]);
            flag = flag1;
            if (i > -1)
            {
                if (i <= list.size())
                {
                    playOrLoadSeriesWatchable((SeriesWatchable)list.get(i - 1), speechpresentationmode);
                } else
                {
                    getTalkDelegate().speak(getString(com.xfinity.playerlib.R.string.list_number_invalid, new Object[] {
                        Integer.valueOf(i), Integer.valueOf(list.size())
                    }));
                }
                flag = true;
            }
        }
        return flag;
    }

    private void playSeriesWatchable(SeriesWatchable serieswatchable, VideoFacade videofacade)
    {
        serieswatchable = VideoPlayerActivity.createIntentForPlayer(videofacade, serieswatchable);
        serieswatchable.setFlags(0x4000000);
        startActivity(serieswatchable);
        closeWithAction(SpeechActions.PLAY);
    }

    private void showSeriesWatchableDetail(VideoFacade videofacade, SeriesWatchable serieswatchable)
    {
        com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder builder = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(new WatchableKey(serieswatchable, videofacade))).shouldHideSeriesTitle(false);
        if (currentlyPlayingVideoId.longValue() != -1L)
        {
            videofacade = currentlyPlayingVideoId;
        } else
        {
            videofacade = null;
        }
        videofacade = builder.currentlyPlayingVideo(videofacade).episodeId(serieswatchable.getMerlinId()).overrideNamespace(com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode).build();
        serieswatchable = new Intent(this, com/xfinity/playerlib/view/programdetails/EpisodeDetailActivity);
        serieswatchable.putExtras(videofacade.getBundle());
        startActivity(serieswatchable);
        closeWithAction(SpeechActions.OPEN);
    }

    public void attemptSearch(final String terms[], final SpeechPresentationMode presentationMode)
    {
        if (presentationMode.equals(SpeechPresentationMode.SEARCH))
        {
            attemptSearch(terms, presentationMode);
            return;
        } else
        {
            com.comcast.cim.cmasl.taskexecutor.task.Task task = seriesCacheMap.get(seriesId);
            taskExecutor = seriesCombinedTaskExecutorFactory.create(task);
            taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

                final SeriesSpeechRecognizer this$0;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(SeriesResource seriesresource)
                {
                    Object obj = seriesresource.tvSeriesFacade;
                    if (seriesresource.dibicResource.getProgramByMerlinId(((TvSeriesFacade) (obj)).getMerlinId()) == null)
                    {
                        PlayerSpeechRecognizer.this.onError(0);
                    } else
                    if (!playOrShowIfValidListNumberForSeriesWatchable(((TvSeriesFacade) (obj)).getAllEpisodeFacades(), terms, presentationMode))
                    {
                        seriesresource = StringUtils.join(terms, " ");
                        for (obj = ((TvSeriesFacade) (obj)).getAllEpisodeFacades().iterator(); ((Iterator) (obj)).hasNext();)
                        {
                            SeriesWatchable serieswatchable = (SeriesWatchable)((Iterator) (obj)).next();
                            if (serieswatchable.getDisplayTitle().toLowerCase().contains(seriesresource) && playOrLoadSeriesWatchable(serieswatchable, presentationMode))
                            {
                                return;
                            }
                        }

                        attemptSearch(terms, presentationMode);
                        return;
                    }
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((SeriesResource)obj);
                }

            
            {
                this$0 = SeriesSpeechRecognizer.this;
                terms = as;
                presentationMode = speechpresentationmode;
                super();
            }
            });
            return;
        }
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        return taskExecutionListener;
    }

    protected TaskExecutor getTaskExecutor()
    {
        return taskExecutor;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        seriesId = (MerlinId)getIntent().getSerializableExtra("INTENT_KEY_SERIES_ID");
        currentlyPlayingVideoId = Long.valueOf(getIntent().getLongExtra("INTENT_KEY_CURRENTLY_PLAYING_VIDEO_ID", -1L));
    }






}
