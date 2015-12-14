// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse, MMWebView, MMLayout, 
//            InlineVideoView, MMSDK

class BridgeMMInlineVideo extends MMJSObject
{

    BridgeMMInlineVideo()
    {
    }

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if ("adjustVideo".equals(s))
        {
            mmjsresponse = adjustVideo(map);
        } else
        {
            if ("insertVideo".equals(s))
            {
                return insertVideo(map);
            }
            if ("pauseVideo".equals(s))
            {
                return pauseVideo(map);
            }
            if ("playVideo".equals(s))
            {
                return playVideo(map);
            }
            if ("removeVideo".equals(s))
            {
                return removeVideo(map);
            }
            if ("resumeVideo".equals(s))
            {
                return resumeVideo(map);
            }
            if ("setStreamVideoSource".equals(s))
            {
                return setStreamVideoSource(map);
            }
            if ("stopVideo".equals(s))
            {
                return stopVideo(map);
            }
        }
        return mmjsresponse;
    }

    public MMJSResponse adjustVideo(Map map)
    {
        return a(new Callable(map) {

            private Map a;
            private BridgeMMInlineVideo b;

            public MMJSResponse call()
            {
                MMWebView mmwebview = (MMWebView)b.c.get();
                if (mmwebview != null && mmwebview != null)
                {
                    MMSDK.a(new MMLayout._cls3(mmwebview.g(), new InlineVideoView.InlineParams(a, mmwebview.getContext())));
                }
                return MMJSResponse.b();
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                b = BridgeMMInlineVideo.this;
                a = map;
                super();
            }
        });
    }

    public MMJSResponse insertVideo(Map map)
    {
        return a(new Callable(map) {

            private Map a;
            private BridgeMMInlineVideo b;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)b.c.get();
                if (obj != null)
                {
                    MMLayout mmlayout = ((MMWebView) (obj)).g();
                    mmlayout.a(new InlineVideoView.InlineParams(a, ((MMWebView) (obj)).getContext()));
                    obj = new StringBuilder("usingStreaming=");
                    boolean flag;
                    if (mmlayout.i != null && mmlayout.i.isPlayingStreaming())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    return MMJSResponse.a(((StringBuilder) (obj)).append(flag).toString());
                } else
                {
                    return MMJSResponse.b();
                }
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                b = BridgeMMInlineVideo.this;
                a = map;
                super();
            }
        });
    }

    public MMJSResponse pauseVideo(Map map)
    {
        return a(new Callable() {

            private BridgeMMInlineVideo a;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)a.c.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).g();
                    if (obj != null)
                    {
                        ((MMLayout) (obj)).h();
                        return MMJSResponse.a();
                    }
                }
                return MMJSResponse.b();
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                a = BridgeMMInlineVideo.this;
                super();
            }
        });
    }

    public MMJSResponse playVideo(Map map)
    {
        return a(new Callable() {

            private BridgeMMInlineVideo a;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)a.c.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).g();
                    if (obj != null)
                    {
                        if (((MMLayout) (obj)).i != null)
                        {
                            ((MMLayout) (obj)).i.playVideo();
                        }
                        return MMJSResponse.a();
                    }
                }
                return MMJSResponse.b();
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                a = BridgeMMInlineVideo.this;
                super();
            }
        });
    }

    public MMJSResponse removeVideo(Map map)
    {
        return a(new Callable() {

            private BridgeMMInlineVideo a;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)a.c.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).g();
                    if (obj != null)
                    {
                        ((MMLayout) (obj)).g();
                        return MMJSResponse.a();
                    }
                }
                return MMJSResponse.b();
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                a = BridgeMMInlineVideo.this;
                super();
            }
        });
    }

    public MMJSResponse resumeVideo(Map map)
    {
        return a(new Callable() {

            private BridgeMMInlineVideo a;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)a.c.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).g();
                    if (obj != null)
                    {
                        ((MMLayout) (obj)).i();
                        return MMJSResponse.a();
                    }
                }
                return MMJSResponse.b();
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                a = BridgeMMInlineVideo.this;
                super();
            }
        });
    }

    public MMJSResponse setStreamVideoSource(Map map)
    {
        return a(new Callable(map) {

            private Map a;
            private BridgeMMInlineVideo b;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)b.c.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).g();
                    String s = (String)a.get("streamVideoURI");
                    if (obj != null && s != null)
                    {
                        if (((MMLayout) (obj)).i != null)
                        {
                            ((MMLayout) (obj)).i.setVideoSource(s);
                        }
                        return MMJSResponse.a();
                    }
                }
                return MMJSResponse.b();
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                b = BridgeMMInlineVideo.this;
                a = map;
                super();
            }
        });
    }

    public MMJSResponse stopVideo(Map map)
    {
        return a(new Callable() {

            private BridgeMMInlineVideo a;

            public MMJSResponse call()
            {
                Object obj = (MMWebView)a.c.get();
                if (obj != null)
                {
                    obj = ((MMWebView) (obj)).g();
                    if (obj != null)
                    {
                        if (((MMLayout) (obj)).i != null)
                        {
                            ((MMLayout) (obj)).i.stopVideo();
                        }
                        return MMJSResponse.a();
                    }
                }
                return MMJSResponse.b();
            }

            public volatile Object call()
            {
                return call();
            }

            
            {
                a = BridgeMMInlineVideo.this;
                super();
            }
        });
    }
}
