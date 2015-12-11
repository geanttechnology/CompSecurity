// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.cmasl.utils.container.Either;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            MovieDetailFragment

class > extends NonCachingBaseTask
{

    final MovieDetailFragment this$0;

    public HalMovieConsumable execute()
    {
        Object obj = downloadManager.findFileWithVideoId(instanceState.watchableKey.getVideoId());
        if (obj != null)
        {
            obj = downloadManager.getStoredEntity(((PlayerDownloadFile) (obj)).getUuid());
            if (obj != null)
            {
                return (HalMovieConsumable)((Either) (obj)).e1;
            }
        }
        return (HalMovieConsumable)MovieDetailFragment.access$000(MovieDetailFragment.this).get(instanceState.merlinId).execute();
    }

    public volatile Object execute()
    {
        return execute();
    }

    er()
    {
        this$0 = MovieDetailFragment.this;
        super();
    }
}
