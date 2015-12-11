// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.dibic.NullDibicResource;
import com.xfinity.playerlib.model.entitlement.NullVideoEntitlement;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            HistorySpeechRecognizer

private class <init> extends NonCachingBaseTask
{

    final HistorySpeechRecognizer this$0;

    public Tuple4 execute()
    {
        List list = (List)bookmarkTask.execute();
        Object obj;
        Object obj1;
        if (list.size() > 0)
        {
            obj = (DibicResource)HistorySpeechRecognizer.access$700(HistorySpeechRecognizer.this).execute();
            obj1 = (VideoEntitlement)HistorySpeechRecognizer.access$800(HistorySpeechRecognizer.this).execute();
        } else
        {
            obj = new NullDibicResource();
            obj1 = new NullVideoEntitlement();
        }
        return new Tuple4(list, obj, obj1, (HalLiveStreamResource)HistorySpeechRecognizer.access$900(HistorySpeechRecognizer.this).execute());
    }

    public volatile Object execute()
    {
        return execute();
    }

    private ()
    {
        this$0 = HistorySpeechRecognizer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
