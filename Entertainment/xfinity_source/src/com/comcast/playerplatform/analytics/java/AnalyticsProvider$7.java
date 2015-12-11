// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java;

import com.comcast.playerplatform.analytics.java.xua.SizeBoundedQueue;
import java.util.List;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.analytics.java:
//            AnalyticsProvider

class 
    implements com.comcast.playerplatform.analytics.java.util.ner
{

    final AnalyticsProvider this$0;

    public void onError(Throwable throwable)
    {
        AnalyticsProvider.access$300().debug("onError");
    }

    public void onItemsRead(List list)
    {
        AnalyticsProvider.access$300().debug("onItemsRead");
        AnalyticsProvider.access$300().debug((new StringBuilder()).append(list.size()).append(" items read from disk").toString());
        AnalyticsProvider.access$000(AnalyticsProvider.this).addAll(list);
    }
}
