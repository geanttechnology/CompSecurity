// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;


// Referenced classes of package com.medialets.advertising:
//            JSBridge, AdView

final class p
    implements Runnable
{

    private JSBridge a;

    p(JSBridge jsbridge)
    {
        a = jsbridge;
        super();
    }

    public final void run()
    {
        if (JSBridge.c(a) != null)
        {
            JSBridge.c(a).dismissLoadingView();
            JSBridge.c(a).setClicked(false);
        }
    }
}
