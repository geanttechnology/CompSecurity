// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.dealbreakdown.DealMultiItemBreakdownContainer;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            DealBreakdownService, DealBreakdownServiceMultiDealListener

class val.listener
    implements Function1
{

    final execute this$0;
    final DealBreakdownServiceMultiDealListener val$listener;

    public void execute(DealMultiItemBreakdownContainer dealmultiitembreakdowncontainer)
        throws RuntimeException
    {
        val$listener.onSuccess(dealmultiitembreakdowncontainer);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((DealMultiItemBreakdownContainer)obj);
    }

    I()
    {
        this$0 = final_i;
        val$listener = DealBreakdownServiceMultiDealListener.this;
        super();
    }
}
