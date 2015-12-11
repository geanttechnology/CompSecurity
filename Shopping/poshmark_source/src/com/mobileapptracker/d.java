// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.mobileapptracker:
//            MATParameters

final class d
    implements Runnable
{

    final MATParameters a;
    private final WeakReference b;

    public d(MATParameters matparameters, Context context)
    {
        a = matparameters;
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
            MATParameters.a(a, s);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
        catch (VerifyError verifyerror)
        {
            return;
        }
    }
}
