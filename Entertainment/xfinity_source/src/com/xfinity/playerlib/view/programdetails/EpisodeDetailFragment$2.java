// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            EpisodeDetailFragment, SeriesResource

class stener extends DefaultTaskExecutionListener
{

    final EpisodeDetailFragment this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        onLoadingFailed();
    }

    public void onPostExecute(SeriesResource seriesresource)
    {
        Object obj;
        VideoEntitlement videoentitlement;
        TvSeriesFacade tvseriesfacade;
        videoentitlement = seriesresource.entitlement;
        tvseriesfacade = seriesresource.tvSeriesFacade;
        obj = seriesresource.dibicResource;
        EpisodeDetailFragment.access$200(EpisodeDetailFragment.this, tvseriesfacade.getMerlinId());
        if (((DibicResource) (obj)).getProgramByMerlinId(tvseriesfacade.getMerlinId()) == null) goto _L2; else goto _L1
_L1:
        obj = null;
        if (!instanceState.useDownloadAsSource() || instanceState.episodeId != null || instanceState.hasValidVideoId()) goto _L4; else goto _L3
_L3:
        obj = tvseriesfacade.findWatchableByVideoId(instanceState.watchableKey.getVideoId());
_L17:
        Object obj1 = obj;
        if (obj != null) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        if (tvseriesfacade.getAllEpisodeFacades().size() <= 0) goto _L6; else goto _L7
_L7:
        obj1 = tvseriesfacade.getAllEpisodeFacades();
        if (instanceState.companyId == null && !instanceState.wantsSubscriptionOnly) goto _L9; else goto _L8
_L8:
        Iterator iterator = ((List) (obj1)).iterator();
_L13:
        obj1 = obj;
        if (!iterator.hasNext()) goto _L6; else goto _L10
_L10:
        obj1 = (SeriesWatchable)iterator.next();
        if (obj == null) goto _L12; else goto _L11
_L11:
        obj1 = obj;
_L6:
        Iterator iterator1;
        VideoFacade videofacade;
        if (obj1 == null)
        {
            showFailureState(new CimException((new StringBuilder()).append("No consumables available for ").append(tvseriesfacade.toString()).toString()));
            return;
        } else
        {
            EpisodeDetailFragment.access$300(EpisodeDetailFragment.this, seriesresource.tvSeriesFacade, seriesresource.bookmarkMap, ((SeriesWatchable) (obj1)), videoentitlement);
            return;
        }
_L4:
        if (instanceState.useEpisodeId())
        {
            obj = tvseriesfacade.findEpisodeById(instanceState.episodeId);
        } else
        if (instanceState.hasNonEpisodeID())
        {
            obj = tvseriesfacade.findWatchableByVideoId(instanceState.nonEpisodeVideoId.longValue());
        } else
        if (instanceState.hasValidVideoId())
        {
            obj = tvseriesfacade.findWatchableByVideoId(instanceState.videoId.longValue());
        }
        continue; /* Loop/switch isn't completed */
_L12:
        iterator1 = ((SeriesWatchable) (obj1)).getVideos().iterator();
_L15:
        if (iterator1.hasNext())
        {
            videofacade = (VideoFacade)iterator1.next();
            if (instanceState.companyId == null || videofacade.getNetworkInfo() == null || videofacade.getNetworkInfo().getCompanyId() != instanceState.companyId.longValue())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = obj1;
        }
          goto _L13
        if (!instanceState.wantsSubscriptionOnly || !videoentitlement.isEntitled(videofacade.getProviderCode())) goto _L15; else goto _L14
_L14:
        obj = obj1;
          goto _L13
_L9:
        obj1 = (SeriesWatchable)((List) (obj1)).get(0);
          goto _L6
_L2:
        showFailureState(new CimException("Series was not found"));
        return;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((SeriesResource)obj);
    }

    on()
    {
        this$0 = EpisodeDetailFragment.this;
        super();
    }
}
