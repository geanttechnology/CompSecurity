// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.mobileapptracker:
//            Parameters

final class bt
    implements Runnable
{

    final Parameters a;
    private final WeakReference b;

    public bt(Parameters parameters, Context context)
    {
        a = parameters;
        super();
        b = new WeakReference(context);
    }

    public final void run()
    {
        try
        {
            WebView webview = new WebView((Context)b.get());
            String s = webview.getSettings().getUserAgentString();
            webview.destroy();
            Parameters.a(a, s);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
