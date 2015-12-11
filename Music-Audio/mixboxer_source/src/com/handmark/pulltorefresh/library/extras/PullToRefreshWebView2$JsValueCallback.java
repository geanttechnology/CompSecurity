// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.extras;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.handmark.pulltorefresh.library.extras:
//            PullToRefreshWebView2

final class this._cls0
{

    final PullToRefreshWebView2 this$0;

    public final void isReadyForPullDownResponse(boolean flag)
    {
        PullToRefreshWebView2.access$100(PullToRefreshWebView2.this).set(flag);
    }

    public final void isReadyForPullUpResponse(boolean flag)
    {
        PullToRefreshWebView2.access$000(PullToRefreshWebView2.this).set(flag);
    }

    ()
    {
        this$0 = PullToRefreshWebView2.this;
        super();
    }
}
