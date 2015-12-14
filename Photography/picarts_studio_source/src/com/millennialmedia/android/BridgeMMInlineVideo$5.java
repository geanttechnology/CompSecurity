// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMInlineVideo, MMWebView, MMLayout, InlineVideoView, 
//            MMJSResponse

class a
    implements Callable
{

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

    (BridgeMMInlineVideo bridgemminlinevideo)
    {
        a = bridgemminlinevideo;
        super();
    }
}
