// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse, MMWebView, MMLayout

class BridgeMMInlineVideo extends MMJSObject
{

    BridgeMMInlineVideo()
    {
    }

    public MMJSResponse adjustVideo(final HashMap parameters)
    {
        return runOnUiThreadFuture(new Callable() {

            final BridgeMMInlineVideo this$0;
            final HashMap val$parameters;

            public MMJSResponse call()
            {
                MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
                if (mmwebview != null && mmwebview != null && mmwebview.getMMLayout().adjustVideo(new InlineVideoView.InlineParams(parameters, mmwebview.getContext())))
                {
                    return MMJSResponse.responseWithSuccess();
                } else
                {
                    return MMJSResponse.responseWithError();
                }
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = BridgeMMInlineVideo.this;
                parameters = hashmap;
                super();
            }
        });
    }

    public MMJSResponse insertVideo(final HashMap parameters)
    {
        return runOnUiThreadFuture(new Callable() {

            final BridgeMMInlineVideo this$0;
            final HashMap val$parameters;

            public MMJSResponse call()
            {
                MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
                if (mmwebview != null)
                {
                    MMLayout mmlayout = mmwebview.getMMLayout();
                    mmlayout.initInlineVideo(new InlineVideoView.InlineParams(parameters, mmwebview.getContext()));
                    return MMJSResponse.responseWithSuccess((new StringBuilder()).append("usingStreaming=").append(mmlayout.isVideoPlayingStreaming()).toString());
                } else
                {
                    return MMJSResponse.responseWithError();
                }
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = BridgeMMInlineVideo.this;
                parameters = hashmap;
                super();
            }
        });
    }

    public MMJSResponse pauseVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new Callable() {

            final BridgeMMInlineVideo this$0;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)mmWebViewRef.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).getMMLayout();
                    if (obj != null)
                    {
                        ((MMLayout) (obj)).pauseVideo();
                        return MMJSResponse.responseWithSuccess();
                    }
                }
                return MMJSResponse.responseWithError();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = BridgeMMInlineVideo.this;
                super();
            }
        });
    }

    public MMJSResponse playVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new Callable() {

            final BridgeMMInlineVideo this$0;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)mmWebViewRef.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).getMMLayout();
                    if (obj != null)
                    {
                        ((MMLayout) (obj)).playVideo();
                        return MMJSResponse.responseWithSuccess();
                    }
                }
                return MMJSResponse.responseWithError();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = BridgeMMInlineVideo.this;
                super();
            }
        });
    }

    public MMJSResponse removeVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new Callable() {

            final BridgeMMInlineVideo this$0;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)mmWebViewRef.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).getMMLayout();
                    if (obj != null)
                    {
                        ((MMLayout) (obj)).removeVideo();
                        return MMJSResponse.responseWithSuccess();
                    }
                }
                return MMJSResponse.responseWithError();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = BridgeMMInlineVideo.this;
                super();
            }
        });
    }

    public MMJSResponse resumeVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new Callable() {

            final BridgeMMInlineVideo this$0;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)mmWebViewRef.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).getMMLayout();
                    if (obj != null)
                    {
                        ((MMLayout) (obj)).resumeVideo();
                        return MMJSResponse.responseWithSuccess();
                    }
                }
                return MMJSResponse.responseWithError();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = BridgeMMInlineVideo.this;
                super();
            }
        });
    }

    public MMJSResponse setStreamVideoSource(final HashMap parameters)
    {
        return runOnUiThreadFuture(new Callable() {

            final BridgeMMInlineVideo this$0;
            final HashMap val$parameters;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)mmWebViewRef.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).getMMLayout();
                    String s = (String)parameters.get("streamVideoURI");
                    if (obj != null && s != null)
                    {
                        ((MMLayout) (obj)).setVideoSource(s);
                        return MMJSResponse.responseWithSuccess();
                    }
                }
                return MMJSResponse.responseWithError();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = BridgeMMInlineVideo.this;
                parameters = hashmap;
                super();
            }
        });
    }

    public MMJSResponse stopVideo(HashMap hashmap)
    {
        return runOnUiThreadFuture(new Callable() {

            final BridgeMMInlineVideo this$0;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)mmWebViewRef.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).getMMLayout();
                    if (obj != null)
                    {
                        ((MMLayout) (obj)).stopVideo();
                        return MMJSResponse.responseWithSuccess();
                    }
                }
                return MMJSResponse.responseWithError();
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = BridgeMMInlineVideo.this;
                super();
            }
        });
    }
}
