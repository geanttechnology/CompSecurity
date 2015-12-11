// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            AndroidTargetUtils, ThreadUtils

private static class _cls1.val.enable
{

    public static void enableWebViewDebugging(boolean flag)
    {
        ThreadUtils.executeOnMainThread(new Runnable(flag) {

            final boolean val$enable;

            public void run()
            {
                WebView.setWebContentsDebuggingEnabled(enable);
            }

            
            {
                enable = flag;
                super();
            }
        });
    }

    private _cls1.val.enable()
    {
    }
}
