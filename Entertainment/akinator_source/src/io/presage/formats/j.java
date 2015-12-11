// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package io.presage.formats:
//            h, b

final class j
    implements Runnable
{

    final h a;

    j(h h1)
    {
        a = h1;
        super();
    }

    public final void run()
    {
        if (a.e() != null)
        {
            for (Iterator iterator = a.e().iterator(); iterator.hasNext();)
            {
                b b1 = (b)iterator.next();
                ViewGroup viewgroup = (ViewGroup)b1.b();
                WebView webview = (WebView)viewgroup.findViewWithTag("webview");
                webview.loadUrl("about:blank");
                webview.destroy();
                b1.c();
                viewgroup.removeAllViews();
                a.b = null;
            }

            a.b = null;
        }
    }
}
