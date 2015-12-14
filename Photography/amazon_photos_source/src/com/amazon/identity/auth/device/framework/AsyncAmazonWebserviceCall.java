// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazon.identity.auth.device.utils.HandlerHelpers;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.kcpsdk.auth.AmazonWebserviceCall;
import com.amazon.identity.kcpsdk.auth.IAmazonWebServiceCallback;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCall;
import com.amazon.identity.kcpsdk.auth.RequestSigner;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            Tracer

public class AsyncAmazonWebserviceCall
    implements IAmazonWebserviceCall
{

    private final Context mContext;
    private Handler mHandler;
    private final AmazonWebserviceCall mInner;
    private final Tracer mTracer;

    public AsyncAmazonWebserviceCall(Context context, WebRequest webrequest, final IAmazonWebServiceCallback callback, RequestSigner requestsigner, Tracer tracer)
    {
        mContext = context;
        mTracer = tracer;
        context = Looper.getMainLooper();
        if (context != null)
        {
            mHandler = new Handler(context);
        } else
        {
            mHandler = new Handler();
        }
        tracer = mContext;
        context = mContext;
        if (callback == null)
        {
            context = null;
        } else
        {
            context = new IAmazonWebServiceCallback() {

                final AsyncAmazonWebserviceCall this$0;
                final IAmazonWebServiceCallback val$callback;

                public void onBodyChunkReceived(final byte arg0[], int i)
                {
                    HandlerHelpers.postAndWait(mHandler, i. new Runnable() {

                        final _cls1 this$1;
                        final byte val$arg0[];
                        final int val$arg1;

                        public void run()
                        {
                            callback.onBodyChunkReceived(arg0, arg1);
                        }

            
            {
                this$1 = final__pcls1;
                arg0 = abyte0;
                arg1 = I.this;
                super();
            }
                    });
                }

                public void onHeadersReceived(WebResponseHeaders webresponseheaders)
                {
                    HandlerHelpers.postAndWait(mHandler, webresponseheaders. new Runnable() {

                        final _cls1 this$1;
                        final WebResponseHeaders val$arg0;

                        public void run()
                        {
                            callback.onHeadersReceived(arg0);
                        }

            
            {
                this$1 = final__pcls1;
                arg0 = WebResponseHeaders.this;
                super();
            }
                    });
                }

                public void onNetworkError()
                {
                    HandlerHelpers.postAndWait(mHandler, new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            callback.onNetworkError();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

                public void onRequestComplete()
                {
                    HandlerHelpers.postAndWait(mHandler, new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            callback.onRequestComplete();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$0 = AsyncAmazonWebserviceCall.this;
                callback = iamazonwebservicecallback;
                super();
            }
            };
        }
        mInner = new AmazonWebserviceCall(tracer, webrequest, context, requestsigner, mTracer);
    }

    public void call()
    {
        ThreadUtils.submitToBackgroundThread(new Runnable() {

            final AsyncAmazonWebserviceCall this$0;

            public void run()
            {
                mInner.call();
            }

            
            {
                this$0 = AsyncAmazonWebserviceCall.this;
                super();
            }
        });
    }


}
