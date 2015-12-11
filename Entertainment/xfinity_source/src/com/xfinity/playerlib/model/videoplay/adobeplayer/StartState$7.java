// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.Context;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            StartState, VideoStateController

class nit> extends RetryingTaskExecutionListener
{

    final StartState this$0;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        stateController.getUiController().hideLaunchScreen();
        super.onError(taskexecutionexception);
    }

    public void onPostExecute(HalLiveStream hallivestream)
    {
        stateController.onLiveStreamFetched(hallivestream);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((HalLiveStream)obj);
    }

    ption(TaskExecutor taskexecutor, Context context, ErrorDialogFactory errordialogfactory, android.content.ce.OnCancelListener oncancellistener)
    {
        this$0 = StartState.this;
        super(taskexecutor, context, errordialogfactory, oncancellistener);
    }
}
