// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMInlineVideo, MMWebView, MMSDK, MMJSResponse

class a
    implements Callable
{

    private Map a;
    private BridgeMMInlineVideo b;

    public MMJSResponse call()
    {
        MMWebView mmwebview = (MMWebView)b.c.get();
        if (mmwebview != null && mmwebview != null)
        {
            MMSDK.a(new b(mmwebview.g(), new Params(a, mmwebview.getContext())));
        }
        return MMJSResponse.b();
    }

    public volatile Object call()
    {
        return call();
    }

    Params(BridgeMMInlineVideo bridgemminlinevideo, Map map)
    {
        b = bridgemminlinevideo;
        a = map;
        super();
    }
}
