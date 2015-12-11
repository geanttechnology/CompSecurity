// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java;

import com.comcast.playerplatform.analytics.java.util.JsonFileIo;
import com.comcast.playerplatform.analytics.java.xua.SizeBoundedQueue;
import com.comcast.playerplatform.analytics.java.xua.XuaMessage;
import java.util.ArrayList;

// Referenced classes of package com.comcast.playerplatform.analytics.java:
//            AnalyticsProvider

class val.xuaMessage
    implements Runnable
{

    final AnalyticsProvider this$0;
    final XuaMessage val$xuaMessage;

    public void run()
    {
        AnalyticsProvider.access$100(AnalyticsProvider.this).append(new ArrayList(AnalyticsProvider.access$000(AnalyticsProvider.this)));
        AnalyticsProvider.access$000(AnalyticsProvider.this).clear();
        AnalyticsProvider.access$000(AnalyticsProvider.this).offer(val$xuaMessage);
        AnalyticsProvider.access$100(AnalyticsProvider.this).save();
    }

    ()
    {
        this$0 = final_analyticsprovider;
        val$xuaMessage = XuaMessage.this;
        super();
    }
}
