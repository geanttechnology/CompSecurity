// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.utils.container.Either;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEpisodeListFragment

class this._cls0 extends NonCachingBaseTask
{

    final SeriesEpisodeListFragment this$0;

    public HalTvSeriesConsumable execute()
    {
        Object obj = SeriesEpisodeListFragment.access$300(SeriesEpisodeListFragment.this).findFileWithVideoId(SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).watchableKey.getVideoId());
        if (obj != null)
        {
            obj = SeriesEpisodeListFragment.access$300(SeriesEpisodeListFragment.this).getStoredEntity(((PlayerDownloadFile) (obj)).getUuid());
            if (obj != null)
            {
                return (HalTvSeriesConsumable)((Either) (obj)).e2;
            }
        }
        return (HalTvSeriesConsumable)SeriesEpisodeListFragment.access$400(SeriesEpisodeListFragment.this).get(SeriesEpisodeListFragment.access$200(SeriesEpisodeListFragment.this).seriesId).execute();
    }

    public volatile Object execute()
    {
        return execute();
    }

    stanceState()
    {
        this$0 = SeriesEpisodeListFragment.this;
        super();
    }
}
