// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.DefaultSpeechListener;
import com.comcast.cim.android.accessibility.SpeechListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.image.ProgramDetailArtImageLoader;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment, SeriesEntityActivity, SeriesCombinedTaskExecutorFactory, SeriesResource

public class EpisodeDetailFragment extends DetailFragment
{
    private class EpisodeDetailFragmentSpeechListener extends DefaultSpeechListener
    {

        final EpisodeDetailFragment this$0;

        public boolean onSpeechResponsePlay(String as[])
        {
            as = getFirstPlayButton();
            if (as != null)
            {
                as.callOnClick();
            }
            return true;
        }

        private EpisodeDetailFragmentSpeechListener()
        {
            this$0 = EpisodeDetailFragment.this;
            super();
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/programdetails/EpisodeDetailFragment);
    private TextView airdate;
    private TextView availability;
    private TextView cast;
    private TaskExecutionListener combinedListener;
    private TaskExecutor combinedTaskExecutor;
    private TextView descriptionText;
    private ImageView detailArtView;
    private TextView infoEpisodeTitle;
    private TextView infoSeriesTitle;
    private LayoutInflater layoutInflator;
    private ImageView newIndicator;
    private TextView seasonEpisode;
    private TaskFactory seriesCacheMap;
    private SeriesCombinedTaskExecutorFactory seriesCombinedTaskExecutorFactory;
    private SpeechListener speechListener;
    private ViewGroup videoItemContainer;

    public EpisodeDetailFragment()
    {
        seriesCacheMap = PlayerContainer.getInstance().getSeriesCacheMap();
        seriesCombinedTaskExecutorFactory = PlayerContainer.getInstance().getSeriesCombinedTaskExecutorFactory();
        speechListener = new EpisodeDetailFragmentSpeechListener();
    }

    private String buildAirdateString(Date date)
    {
        FastDateFormat fastdateformat = FastDateFormat.getInstance(getResources().getString(com.xfinity.playerlib.R.string.month_day_year_format));
        return (new StringBuilder()).append(getResources().getString(com.xfinity.playerlib.R.string.airdate)).append(": ").append(fastdateformat.format(date)).toString();
    }

    private String buildEpisodeNumberString(Integer integer)
    {
        Object obj = null;
        String s = obj;
        if (integer != null)
        {
            s = obj;
            if (integer.intValue() != 0)
            {
                s = (new StringBuilder()).append("Ep").append(integer).toString();
            }
        }
        return s;
    }

    private String buildSeasonNumberString(Integer integer)
    {
        Object obj = null;
        String s = obj;
        if (integer != null)
        {
            s = obj;
            if (integer.intValue() != 0)
            {
                s = (new StringBuilder()).append("S").append(integer).toString();
            }
        }
        return s;
    }

    private void displayDetail(TvSeriesFacade tvseriesfacade, Map map, SeriesWatchable serieswatchable, VideoEntitlement videoentitlement)
    {
        detailArtView.setVisibility(0);
        SortedSet sortedset = getSortedVideos(videoentitlement, serieswatchable);
        addVideoItems(map, videoentitlement, serieswatchable, sortedset, videoItemContainer, layoutInflator, playPressedListener, instanceState.currentlyPlayingVideoId);
        present(tvseriesfacade, serieswatchable);
        if (!sortedset.isEmpty())
        {
            showDuration((VideoFacade)sortedset.first());
        }
        onLoadingFinished();
    }

    private void loadImageArtForSeries(MerlinId merlinid)
    {
        if (detailArtView != null)
        {
            programDetailArtImageLoader.loadDetailProgramArt(merlinid, detailArtView);
        }
    }

    public int getDetailLayoutId()
    {
        return com.xfinity.playerlib.R.layout.series_episode_detail;
    }

    public ViewGroup getVideoItemViewContainer()
    {
        return videoItemContainer;
    }

    public void loadScreenInfo()
    {
        Object obj;
        Activity activity;
        if (instanceState.useDownloadAsSource())
        {
            obj = new NonCachingBaseTask() {

                final EpisodeDetailFragment this$0;

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
                this$0 = EpisodeDetailFragment.this;
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
            combinedTaskExecutor = ((SeriesEntityActivity)activity).getTaskExecutor();
        } else
        {
            combinedTaskExecutor = seriesCombinedTaskExecutorFactory.create(((Task) (obj)));
        }
        combinedListener = combinedTaskExecutor.execute(new DefaultTaskExecutionListener() {

            final EpisodeDetailFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                onLoadingFailed();
            }

            public void onPostExecute(SeriesResource seriesresource)
            {
                Object obj1;
                VideoEntitlement videoentitlement;
                TvSeriesFacade tvseriesfacade;
                videoentitlement = seriesresource.entitlement;
                tvseriesfacade = seriesresource.tvSeriesFacade;
                obj1 = seriesresource.dibicResource;
                loadImageArtForSeries(tvseriesfacade.getMerlinId());
                if (((DibicResource) (obj1)).getProgramByMerlinId(tvseriesfacade.getMerlinId()) == null) goto _L2; else goto _L1
_L1:
                obj1 = null;
                if (!instanceState.useDownloadAsSource() || instanceState.episodeId != null || instanceState.hasValidVideoId()) goto _L4; else goto _L3
_L3:
                obj1 = tvseriesfacade.findWatchableByVideoId(instanceState.watchableKey.getVideoId());
_L17:
                Object obj2 = obj1;
                if (obj1 != null) goto _L6; else goto _L5
_L5:
                obj2 = obj1;
                if (tvseriesfacade.getAllEpisodeFacades().size() <= 0) goto _L6; else goto _L7
_L7:
                obj2 = tvseriesfacade.getAllEpisodeFacades();
                if (instanceState.companyId == null && !instanceState.wantsSubscriptionOnly) goto _L9; else goto _L8
_L8:
                Iterator iterator = ((List) (obj2)).iterator();
_L13:
                obj2 = obj1;
                if (!iterator.hasNext()) goto _L6; else goto _L10
_L10:
                obj2 = (SeriesWatchable)iterator.next();
                if (obj1 == null) goto _L12; else goto _L11
_L11:
                obj2 = obj1;
_L6:
                Iterator iterator1;
                VideoFacade videofacade;
                if (obj2 == null)
                {
                    showFailureState(new CimException((new StringBuilder()).append("No consumables available for ").append(tvseriesfacade.toString()).toString()));
                    return;
                } else
                {
                    displayDetail(seriesresource.tvSeriesFacade, seriesresource.bookmarkMap, ((SeriesWatchable) (obj2)), videoentitlement);
                    return;
                }
_L4:
                if (instanceState.useEpisodeId())
                {
                    obj1 = tvseriesfacade.findEpisodeById(instanceState.episodeId);
                } else
                if (instanceState.hasNonEpisodeID())
                {
                    obj1 = tvseriesfacade.findWatchableByVideoId(instanceState.nonEpisodeVideoId.longValue());
                } else
                if (instanceState.hasValidVideoId())
                {
                    obj1 = tvseriesfacade.findWatchableByVideoId(instanceState.videoId.longValue());
                }
                continue; /* Loop/switch isn't completed */
_L12:
                iterator1 = ((SeriesWatchable) (obj2)).getVideos().iterator();
_L15:
                if (iterator1.hasNext())
                {
                    videofacade = (VideoFacade)iterator1.next();
                    if (instanceState.companyId == null || videofacade.getNetworkInfo() == null || videofacade.getNetworkInfo().getCompanyId() != instanceState.companyId.longValue())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    obj1 = obj2;
                }
                  goto _L13
                if (!instanceState.wantsSubscriptionOnly || !videoentitlement.isEntitled(videofacade.getProviderCode())) goto _L15; else goto _L14
_L14:
                obj1 = obj2;
                  goto _L13
_L9:
                obj2 = (SeriesWatchable)((List) (obj2)).get(0);
                  goto _L6
_L2:
                showFailureState(new CimException("Series was not found"));
                return;
                if (true) goto _L17; else goto _L16
_L16:
            }

            public volatile void onPostExecute(Object obj1)
            {
                onPostExecute((SeriesResource)obj1);
            }

            
            {
                this$0 = EpisodeDetailFragment.this;
                super();
            }
        });
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        alternateInterfaceListener.addSpeechListener(speechListener);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutInflator = layoutinflater;
        videoItemContainer = (LinearLayout)viewgroup.findViewById(com.xfinity.playerlib.R.id.video_item_container);
        detailArtView = (ImageView)viewgroup.findViewById(com.xfinity.playerlib.R.id.detail_image);
        infoSeriesTitle = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.info_series_title);
        infoEpisodeTitle = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.info_episode_title);
        seasonEpisode = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.season_episode);
        airdate = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.airdate);
        cast = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.cast);
        descriptionText = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.description);
        newIndicator = (ImageView)viewgroup.findViewById(com.xfinity.playerlib.R.id.new_indicator);
        availability = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.availability);
        bodyContainer = viewgroup.findViewById(com.xfinity.playerlib.R.id.body_container);
        setupReviews(viewgroup);
        return viewgroup;
    }

    public void onDetach()
    {
        super.onDetach();
        alternateInterfaceListener.removeSpeechListener(speechListener);
    }

    public void onStop()
    {
        super.onStop();
        if (combinedTaskExecutor != null)
        {
            combinedTaskExecutor.cancelNotificationsFor(combinedListener);
        }
    }

    public void present(TvSeriesFacade tvseriesfacade, SeriesWatchable serieswatchable)
    {
        int i;
        int j;
        if (instanceState.shouldHideSeriesTitle)
        {
            infoSeriesTitle.setVisibility(8);
        } else
        {
            setDisplayTitle(serieswatchable.getSeriesTitle(), infoSeriesTitle);
        }
        bodyContainer.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_describe_scrollable_episode_section, new Object[] {
            serieswatchable.getSeriesTitle()
        }));
        infoEpisodeTitle.setText(serieswatchable.getDisplayTitle());
        infoEpisodeTitle.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_add_pause, new Object[] {
            serieswatchable.getDisplayTitle()
        }));
        descriptionText.setText(serieswatchable.getDescription());
        descriptionText.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_description, new Object[] {
            serieswatchable.getDescription()
        }));
        i = serieswatchable.getEpisodeNumber().intValue();
        j = serieswatchable.getSeasonNumber().intValue();
        if (i > -1 && j > -1)
        {
            updateCompoundTextView(seasonEpisode, new Object[] {
                buildSeasonNumberString(serieswatchable.getSeasonNumber()), buildEpisodeNumberString(serieswatchable.getEpisodeNumber())
            });
        } else
        {
            seasonEpisode.setVisibility(8);
        }
        if (serieswatchable.getOriginalAirdate() != null)
        {
            airdate.setText(buildAirdateString(serieswatchable.getOriginalAirdate()));
            airdate.setVisibility(0);
        } else
        {
            airdate.setVisibility(8);
        }
        setNew(serieswatchable.isNew());
        if (serieswatchable.getExpiresDate() != null)
        {
            String s = formatAvailability(serieswatchable.getExpiresDate());
            availability.setText(s);
            availability.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_add_pause, new Object[] {
                s
            }));
        } else
        {
            availability.setVisibility(8);
        }
        if (serieswatchable.getCast() != null && !serieswatchable.getCast().isEmpty())
        {
            cast.setText(serieswatchable.getCast());
            cast.setVisibility(0);
            cast.setContentDescription(getString(com.xfinity.playerlib.R.string.content_description_cast, new Object[] {
                serieswatchable.getCast()
            }));
        } else
        {
            cast.setVisibility(8);
        }
        presentReviews(tvseriesfacade.getReviews());
    }

    protected void setDisplayTitle(String s, TextView textview)
    {
        super.setDisplayTitle(s, textview);
        alternateInterfaceListener.getTalkDelegate().setTitle(getString(com.xfinity.playerlib.R.string.content_description_detail_title, new Object[] {
            "Episode", s
        }));
    }

    public void setNew(boolean flag)
    {
        if (flag)
        {
            newIndicator.setVisibility(0);
            return;
        } else
        {
            newIndicator.setVisibility(8);
            return;
        }
    }

    public void showFailureState(CimException cimexception)
    {
        LOG.debug("Failed to get episode detail", cimexception);
        descriptionText.setText(com.xfinity.playerlib.R.string.error_not_available_text);
        onLoadingFailed(com.xfinity.playerlib.R.string.error_not_available_text);
    }




}
