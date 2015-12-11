// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.HandlerHelpers;
import com.amazon.identity.kcpsdk.auth.IAmazonWebServiceCallback;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AsyncAmazonWebserviceCall

class val.callback
    implements IAmazonWebServiceCallback
{

    final AsyncAmazonWebserviceCall this$0;
    final IAmazonWebServiceCallback val$callback;

    public void onBodyChunkReceived(final byte arg0[], final int arg1)
    {
        HandlerHelpers.postAndWait(AsyncAmazonWebserviceCall.access$000(AsyncAmazonWebserviceCall.this), new Runnable() {

            final AsyncAmazonWebserviceCall._cls1 this$1;
            final byte val$arg0[];
            final int val$arg1;

            public void run()
            {
                callback.onBodyChunkReceived(arg0, arg1);
            }

            
            {
                this$1 = AsyncAmazonWebserviceCall._cls1.this;
                arg0 = abyte0;
                arg1 = i;
                super();
            }
        });
    }

    public void onHeadersReceived(final WebResponseHeaders arg0)
    {
        HandlerHelpers.postAndWait(AsyncAmazonWebserviceCall.access$000(AsyncAmazonWebserviceCall.this), new Runnable() {

            final AsyncAmazonWebserviceCall._cls1 this$1;
            final WebResponseHeaders val$arg0;

            public void run()
            {
                callback.onHeadersReceived(arg0);
            }

            
            {
                this$1 = AsyncAmazonWebserviceCall._cls1.this;
                arg0 = webresponseheaders;
                super();
            }
        });
    }

    public void onNetworkError()
    {
        HandlerHelpers.postAndWait(AsyncAmazonWebserviceCall.access$000(AsyncAmazonWebserviceCall.this), new Runnable() {

            final AsyncAmazonWebserviceCall._cls1 this$1;

            public void run()
            {
                callback.onNetworkError();
            }

            
            {
                this$1 = AsyncAmazonWebserviceCall._cls1.this;
                super();
            }
        });
    }

    public void onRequestComplete()
    {
        HandlerHelpers.postAndWait(AsyncAmazonWebserviceCall.access$000(AsyncAmazonWebserviceCall.this), new Runnable() {

            final AsyncAmazonWebserviceCall._cls1 this$1;

            public void run()
            {
                callback.onRequestComplete();
            }

            
            {
                this$1 = AsyncAmazonWebserviceCall._cls1.this;
                super();
            }
        });
    }

    _cls4.this._cls1()
    {
        this$0 = final_asyncamazonwebservicecall;
        val$callback = IAmazonWebServiceCallback.this;
        super();
    }
}
