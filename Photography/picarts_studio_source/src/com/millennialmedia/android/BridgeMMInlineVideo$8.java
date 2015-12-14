// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMInlineVideo, MMWebView, MMLayout, InlineVideoView, 
//            MMJSResponse

class a
    implements Callable
{

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

    (BridgeMMInlineVideo bridgemminlinevideo, Map map)
    {
        b = bridgemminlinevideo;
        a = map;
        super();
    }
}
