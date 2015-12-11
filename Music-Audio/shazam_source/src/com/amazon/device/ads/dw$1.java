// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.view.ViewGroup;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            dw, cn

final class a
    implements Runnable
{

    final WebView a[];
    final dw b;

    public final void run()
    {
        WebView awebview[] = a;
        int j = awebview.length;
        int i = 0;
        while (i < j) 
        {
            WebView webview = awebview[i];
            if (webview != null)
            {
                if (webview.getParent() != null)
                {
                    ((ViewGroup)webview.getParent()).removeView(webview);
                }
                try
                {
                    webview.destroy();
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    dw.a(b).c("Caught an IllegalArgumentException while destroying a WebView: %s", new Object[] {
                        illegalargumentexception.getMessage()
                    });
                }
            }
            i++;
        }
    }

    ception(dw dw1, WebView awebview[])
    {
        b = dw1;
        a = awebview;
        super();
    }
}
