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
//            EpisodeDetailFragment

class this._cls0 extends NonCachingBaseTask
{

    final EpisodeDetailFragment this$0;

    public HalTvSeriesConsumable execute()
    {
        Object obj = downloadManager.findFileWithVideoId(instanceState.watchableKey.getVideoId());
        if (obj != null)
        {
            obj = downloadManager.getStoredEntity(((PlayerDownloadFile) (obj)).getUuid());
            if (obj != null)
            {
                return (HalTvSeriesConsumable)((Either) (obj)).e2;
            }
        }
        return (HalTvSeriesConsumable)EpisodeDetailFragment.access$100(EpisodeDetailFragment.this).get(instanceState.seriesId).execute();
    }

    public volatile Object execute()
    {
        return execute();
    }

    ()
    {
        this$0 = EpisodeDetailFragment.this;
        super();
    }
}
