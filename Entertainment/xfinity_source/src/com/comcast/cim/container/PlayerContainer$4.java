// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.comcast.cim.model.hal.HalLiveStreamFactory;
import com.xfinity.playerlib.model.HalLiveStreamMetaDataResource;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements TaskFactory
{

    final PlayerContainer this$0;

    public volatile Task get(Object obj)
    {
        return get((String)obj);
    }

    public Task get(String s)
    {
        return new HalLiveStreamMetaDataResource(getTveHypermediaServicesCache(), new HalLiveStreamFactory(), getHalHttpClient(), s);
    }

    ()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
