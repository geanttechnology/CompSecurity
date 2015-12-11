// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

class this._cls0
    implements com.comcast.cim.cmasl.android.util.view.widget.gate.ReadyListener
{

    final LiveStreamsFragment this$0;

    public void onReady()
    {
        getTaskExecutor().execute(getTaskExecutionListener());
        if (!LiveStreamsFragment.access$400(LiveStreamsFragment.this))
        {
            LiveStreamsFragment.access$600(LiveStreamsFragment.this).execute(LiveStreamsFragment.access$500(LiveStreamsFragment.this));
        }
    }

    wDelegate.ReadyListener()
    {
        this$0 = LiveStreamsFragment.this;
        super();
    }
}
