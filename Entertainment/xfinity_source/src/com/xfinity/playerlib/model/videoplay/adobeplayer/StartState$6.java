// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.Context;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.model.provider.RetryingTaskExecutionListener;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            StartState, VideoStateController

class nit> extends RetryingTaskExecutionListener
{

    final StartState this$0;
    final String val$streamId;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        stateController.getUiController().hideLaunchScreen();
        super.onError(taskexecutionexception);
    }

    public void onPostExecute(HalLiveStreamResource hallivestreamresource)
    {
        stateController.onLiveStreamFetched(hallivestreamresource.getLiveStream(val$streamId));
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((HalLiveStreamResource)obj);
    }

    e(Context context, ErrorDialogFactory errordialogfactory, android.content.ce.OnCancelListener oncancellistener, String s)
    {
        this$0 = final_startstate;
        val$streamId = s;
        super(TaskExecutor.this, context, errordialogfactory, oncancellistener);
    }
}
