// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

private class <init> extends NonCachingBaseTask
{

    final LiveStreamsFragment this$0;

    public Tuple3 execute()
    {
        java.util.List list = LiveStreamsFragment.access$2800(LiveStreamsFragment.this).getFavorites();
        return new Tuple3((VideoEntitlement)LiveStreamsFragment.access$2900(LiveStreamsFragment.this).execute(), (HalLiveStreamResource)LiveStreamsFragment.access$3000(LiveStreamsFragment.this).execute(), list);
    }

    public volatile Object execute()
    {
        return execute();
    }

    private ()
    {
        this$0 = LiveStreamsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
