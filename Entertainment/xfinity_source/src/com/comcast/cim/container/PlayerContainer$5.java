// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.model.hal.HalMovieFactory;
import com.xfinity.playerlib.model.HalMovieConsumableCache;
import com.xfinity.playerlib.model.MerlinId;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements TaskFactory
{

    final PlayerContainer this$0;

    public Task get(MerlinId merlinid)
    {
        return new HalMovieConsumableCache(new HalMovieFactory(), getHalHttpClient(), getDefaultRevalidationPolicy(), getConsumablesHypermediaServicesCache(), getAndroidDevice(), merlinid);
    }

    public volatile Task get(Object obj)
    {
        return get((MerlinId)obj);
    }

    ()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
