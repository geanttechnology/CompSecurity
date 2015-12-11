// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.events.activity.OnDestroyEvent;
import java.util.concurrent.BlockingQueue;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.util:
//            HttpExecutor

class val.context
{

    final HttpExecutor this$0;
    final Context val$context;

    public void onEvent(OnDestroyEvent ondestroyevent)
    {
        Ln.d("Clearing tasks and shutting down executor for destroyed context %s", new Object[] {
            val$context
        });
        getQueue().clear();
        shutdown();
    }

    stroyEvent()
    {
        this$0 = final_httpexecutor;
        val$context = Context.this;
        super();
    }
}
