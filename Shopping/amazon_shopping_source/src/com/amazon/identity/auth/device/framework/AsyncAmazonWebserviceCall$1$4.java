// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.HandlerHelpers;
import com.amazon.identity.kcpsdk.auth.IAmazonWebServiceCallback;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AsyncAmazonWebserviceCall

class this._cls1
    implements Runnable
{

    final ete this$1;

    public void run()
    {
        callback.onRequestComplete();
    }

    l.callback()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1

/* anonymous class */
    class AsyncAmazonWebserviceCall._cls1
        implements IAmazonWebServiceCallback
    {

        final AsyncAmazonWebserviceCall this$0;
        final IAmazonWebServiceCallback val$callback;

        public void onBodyChunkReceived(final byte arg0[], final int arg1)
        {
            HandlerHelpers.postAndWait(AsyncAmazonWebserviceCall.access$000(AsyncAmazonWebserviceCall.this), new AsyncAmazonWebserviceCall._cls1._cls1());
        }

        public void onHeadersReceived(final WebResponseHeaders arg0)
        {
            HandlerHelpers.postAndWait(AsyncAmazonWebserviceCall.access$000(AsyncAmazonWebserviceCall.this), new AsyncAmazonWebserviceCall._cls1._cls2());
        }

        public void onNetworkError()
        {
            HandlerHelpers.postAndWait(AsyncAmazonWebserviceCall.access$000(AsyncAmazonWebserviceCall.this), new AsyncAmazonWebserviceCall._cls1._cls3());
        }

        public void onRequestComplete()
        {
            HandlerHelpers.postAndWait(AsyncAmazonWebserviceCall.access$000(AsyncAmazonWebserviceCall.this), new AsyncAmazonWebserviceCall._cls1._cls4());
        }

            
            {
                this$0 = final_asyncamazonwebservicecall;
                callback = IAmazonWebServiceCallback.this;
                super();
            }

        // Unreferenced inner class com/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$1

/* anonymous class */
        class AsyncAmazonWebserviceCall._cls1._cls1
            implements Runnable
        {

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
        }


        // Unreferenced inner class com/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$2

/* anonymous class */
        class AsyncAmazonWebserviceCall._cls1._cls2
            implements Runnable
        {

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
        }


        // Unreferenced inner class com/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$3

/* anonymous class */
        class AsyncAmazonWebserviceCall._cls1._cls3
            implements Runnable
        {

            final AsyncAmazonWebserviceCall._cls1 this$1;

            public void run()
            {
                callback.onNetworkError();
            }

                    
                    {
                        this$1 = AsyncAmazonWebserviceCall._cls1.this;
                        super();
                    }
        }

    }

}
