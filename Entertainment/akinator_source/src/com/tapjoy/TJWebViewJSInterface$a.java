// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.os.AsyncTask;
import android.webkit.WebView;

// Referenced classes of package com.tapjoy:
//            TJWebViewJSInterface, TapjoyLog

final class a extends AsyncTask
{

    WebView a;
    final TJWebViewJSInterface b;

    protected final volatile Object doInBackground(Object aobj[])
    {
        return ((String[])aobj)[0];
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (!((String) (obj)).startsWith("javascript:") || android.os.a < 19)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        obj = ((String) (obj)).replaceFirst("javascript:", "");
        a.evaluateJavascript(((String) (obj)), null);
        return;
        obj;
        TapjoyLog.e("TJWebViewJSInterface", (new StringBuilder("Exception in evaluateJavascript. Device not supported. ")).append(((Exception) (obj)).toString()).toString());
        return;
        try
        {
            a.loadUrl(((String) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            TapjoyLog.e("TJWebViewJSInterface", (new StringBuilder("Exception in loadUrl. Device not supported. ")).append(((Exception) (obj)).toString()).toString());
        }
        return;
    }

    public (TJWebViewJSInterface tjwebviewjsinterface, WebView webview)
    {
        b = tjwebviewjsinterface;
        super();
        a = webview;
    }
}
