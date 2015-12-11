// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.dibic.NullDibicResource;
import com.xfinity.playerlib.model.entitlement.NullVideoEntitlement;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.List;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryFragment

private class <init> extends NonCachingBaseTask
{

    final HistoryFragment this$0;

    public Tuple4 execute()
    {
        List list = (List)HistoryFragment.access$900(HistoryFragment.this).execute();
        Object obj;
        Object obj1;
        if (list.size() > 0)
        {
            obj = (DibicResource)HistoryFragment.access$1000(HistoryFragment.this).execute();
            obj1 = (VideoEntitlement)HistoryFragment.access$1100(HistoryFragment.this).execute();
        } else
        {
            HistoryFragment.access$1200().debug("No bookmarks, skipping dibic and entitlement fetches");
            obj = new NullDibicResource();
            obj1 = new NullVideoEntitlement();
        }
        return new Tuple4(list, obj, obj1, (HalLiveStreamResource)HistoryFragment.access$1300(HistoryFragment.this).execute());
    }

    public volatile Object execute()
    {
        return execute();
    }

    private Y()
    {
        this$0 = HistoryFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
