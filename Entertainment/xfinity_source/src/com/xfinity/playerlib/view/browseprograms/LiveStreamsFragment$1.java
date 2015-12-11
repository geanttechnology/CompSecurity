// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.xfinity.playerlib.model.consumable.hal.HalLiveFeaturedContentResource;
import com.xfinity.playerlib.view.PagerContainer;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

class Listener extends DefaultTaskExecutionListener
{

    final LiveStreamsFragment this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        LiveStreamsFragment.access$200(LiveStreamsFragment.this).setVisibility(8);
    }

    public void onPostExecute(HalLiveFeaturedContentResource hallivefeaturedcontentresource)
    {
        LiveStreamsFragment.access$002(LiveStreamsFragment.this, hallivefeaturedcontentresource.getLiveFeaturedContent());
        LiveStreamsFragment.access$100(LiveStreamsFragment.this);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((HalLiveFeaturedContentResource)obj);
    }

    tResource()
    {
        this$0 = LiveStreamsFragment.this;
        super();
    }
}
