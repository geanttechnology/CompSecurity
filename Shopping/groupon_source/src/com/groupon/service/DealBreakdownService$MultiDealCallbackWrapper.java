// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.dealbreakdown.DealMultiItemBreakdownContainer;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service:
//            DealBreakdownService, DealBreakdownServiceMultiDealListener

private static class te
{

    public final ReturningFunction1 exceptionCallback;
    public final Function0 finallyCallback;
    public final Function1 successCallback;

    public _cls3.val.listener(final DealBreakdownServiceMultiDealListener listener)
    {
        successCallback = new Function1() {

            final DealBreakdownService.MultiDealCallbackWrapper this$0;
            final DealBreakdownServiceMultiDealListener val$listener;

            public void execute(DealMultiItemBreakdownContainer dealmultiitembreakdowncontainer)
                throws RuntimeException
            {
                listener.onSuccess(dealmultiitembreakdowncontainer);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((DealMultiItemBreakdownContainer)obj);
            }

            
            {
                this$0 = DealBreakdownService.MultiDealCallbackWrapper.this;
                listener = dealbreakdownservicemultideallistener;
                super();
            }
        };
        exceptionCallback = new ReturningFunction1() {

            final DealBreakdownService.MultiDealCallbackWrapper this$0;
            final DealBreakdownServiceMultiDealListener val$listener;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                return Boolean.valueOf(listener.onException(exception));
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = DealBreakdownService.MultiDealCallbackWrapper.this;
                listener = dealbreakdownservicemultideallistener;
                super();
            }
        };
        finallyCallback = new Function0() {

            final DealBreakdownService.MultiDealCallbackWrapper this$0;
            final DealBreakdownServiceMultiDealListener val$listener;

            public void execute()
                throws RuntimeException
            {
                listener.onComplete();
            }

            
            {
                this$0 = DealBreakdownService.MultiDealCallbackWrapper.this;
                listener = dealbreakdownservicemultideallistener;
                super();
            }
        };
    }
}
