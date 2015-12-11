// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
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
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment, SeriesEntityActivity, SeriesCombinedTaskExecutorFactory, SeriesResource

public class SeriesDetailFragment extends DetailFragment
{

    private TextView descriptionText;
    private ImageView detailArtView;
    private TextView errorText;
    private SeriesResource lastSeenResource;
    private ImageView premiumChannelLogo;
    private TaskFactory seriesCacheMap;
    private SeriesCombinedTaskExecutorFactory seriesCombinedTaskExecutorFactory;
    private MerlinId seriesId;
    private TextView seriesTitleText;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;
    private WatchableKey watchableKey;

    public SeriesDetailFragment()
    {
        seriesCacheMap = PlayerContainer.getInstance().getSeriesCacheMap();
        seriesCombinedTaskExecutorFactory = PlayerContainer.getInstance().getSeriesCombinedTaskExecutorFactory();
    }

    public static Bundle createBundle(MerlinId merlinid)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable(com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries.getBundleKey(), merlinid);
        return bundle;
    }

    public static Bundle createBundle(WatchableKey watchablekey)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_watchable_key", watchablekey);
        return bundle;
    }

    public void extractDataFromBundle(Bundle bundle)
    {
        seriesId = (MerlinId)bundle.getSerializable(com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries.getBundleKey());
        watchableKey = (WatchableKey)bundle.getSerializable("extra_watchable_key");
    }

    public int getDetailLayoutId()
    {
        return com.xfinity.playerlib.R.layout.series_detail;
    }

    public ViewGroup getVideoItemViewContainer()
    {
        return null;
    }

    public void loadScreenInfo()
    {
        Object obj;
        android.app.Activity activity;
        if (watchableKey != null)
        {
            obj = new NonCachingBaseTask() {

                final SeriesDetailFragment this$0;

                public HalTvSeriesConsumable execute()
                {
                    Object obj1 = downloadManager.findFileWithVideoId(watchableKey.getVideoId());
                    if (obj1 != null)
                    {
                        obj1 = downloadManager.getStoredEntity(((PlayerDownloadFile) (obj1)).getUuid());
                        if (obj1 != null)
                        {
                            return (HalTvSeriesConsumable)((Either) (obj1)).e2;
                        }
                    }
                    return (HalTvSeriesConsumable)seriesCacheMap.get(seriesId).execute();
                }

                public volatile Object execute()
                {
                    return execute();
                }

            
            {
                this$0 = SeriesDetailFragment.this;
                super();
            }
            };
        } else
        {
            obj = seriesCacheMap.get(seriesId);
        }
        activity = getActivity();
        if (activity instanceof SeriesEntityActivity)
        {
            taskExecutor = ((SeriesEntityActivity)activity).getTaskExecutor();
        } else
        {
            taskExecutor = seriesCombinedTaskExecutorFactory.create(((Task) (obj)));
        }
        taskExecutionListener = new DefaultTaskExecutionListener() {

            final SeriesDetailFragment this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                onLoadingFailed();
            }

            public void onPostExecute(SeriesResource seriesresource)
            {
                safeSetVisibility(errorText, 8);
                safeSetVisibility(detailArtView, 0);
                TvSeriesFacade tvseriesfacade = seriesresource.tvSeriesFacade;
                DibicResource dibicresource = seriesresource.dibicResource;
                programDetailArtImageLoader.loadDetailProgramArt(tvseriesfacade.getMerlinId(), detailArtView);
                if (!seriesresource.equals(lastSeenResource))
                {
                    if (dibicresource.getProgramByMerlinId(tvseriesfacade.getMerlinId()) != null)
                    {
                        setDisplayTitle(tvseriesfacade.getTitle(), seriesTitleText);
                        setDescription(tvseriesfacade.getDescription());
                        lastSeenResource = seriesresource;
                    } else
                    {
                        showFailureState(null);
                    }
                }
                seriesresource = tvseriesfacade.getReviews();
                presentReviews(seriesresource);
                onLoadingFinished();
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
                this$0 = SeriesDetailFragment.this;
                super();
            }
        };
        taskExecutor.execute(taskExecutionListener);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        detailArtView = (ImageView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.detail_image);
        premiumChannelLogo = (ImageView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.premium_channel_logo);
        descriptionText = (TextView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.description);
        seriesTitleText = (TextView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.series_title);
        errorText = (TextView)layoutinflater.findViewById(com.xfinity.playerlib.R.id.series_detail_error_text);
        setupReviews(layoutinflater);
        return layoutinflater;
    }

    public void onStop()
    {
        super.onStop();
        if (taskExecutor != null)
        {
            taskExecutor.cancelNotificationsFor(taskExecutionListener);
        }
    }

    public void setDescription(String s)
    {
        if (descriptionText != null)
        {
            descriptionText.setText(s);
        }
    }

    public void showFailureState(CimException cimexception)
    {
        onLoadingFinished();
        safeSetVisibility(bodyContainer, 8);
        safeSetVisibility(detailArtView, 4);
        safeSetVisibility(errorText, 0);
    }










/*
    static SeriesResource access$702(SeriesDetailFragment seriesdetailfragment, SeriesResource seriesresource)
    {
        seriesdetailfragment.lastSeenResource = seriesresource;
        return seriesresource;
    }

*/

}
