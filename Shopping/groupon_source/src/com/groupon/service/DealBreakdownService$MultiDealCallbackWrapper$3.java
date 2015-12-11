// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.util.Function0;

// Referenced classes of package com.groupon.service:
//            DealBreakdownService, DealBreakdownServiceMultiDealListener

class val.listener
    implements Function0
{

    final  this$0;
    final DealBreakdownServiceMultiDealListener val$listener;

    public void execute()
        throws RuntimeException
    {
        val$listener.onComplete();
    }

    I()
    {
        this$0 = final_i;
        val$listener = DealBreakdownServiceMultiDealListener.this;
        super();
    }
}
