// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.os.Handler;
import android.webkit.WebSettings;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;

// Referenced classes of package com.medialets.advertising:
//            JSBridge, a, y, AdView, 
//            AdWebView, d

private final class b
    implements Runnable
{

    private String a;
    private int b;
    private JSBridge c;

    private void a()
    {
        if (b != 10) goto _L2; else goto _L1
_L1:
        com.medialets.advertising.a.c((new StringBuilder()).append("Maximum number (").append(10).append(") of redirects").append(" reached").toString());
_L4:
        return;
_L2:
        if (JSBridge.a(c, a))
        {
            JSBridge.a(c).post(new <init>(c, a, true));
            return;
        }
        if (!y.b())
        {
            JSBridge.a(c).post(c.mLoadingViewRunnable);
            return;
        }
        if (JSBridge.b(c)) goto _L4; else goto _L3
_L3:
        Object obj;
        d d1;
        HttpGet httpget;
        int i;
        try
        {
            d1 = d.a(JSBridge.c(c).getAdWebView().getSettings().getUserAgentString(), false);
            a = a.replace(" ", "%20");
            httpget = new HttpGet(a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Illegal URL will not load: ").append(((IllegalArgumentException) (obj)).toString()).toString());
            JSBridge.a(c).post(c.mLoadingViewRunnable);
            return;
        }
        if (JSBridge.b(c)) goto _L4; else goto _L5
_L5:
        com.medialets.advertising.a.d((new StringBuilder()).append("Processing URL: ").append(a).toString());
        obj = d1.execute(httpget, d1.a(JSBridge.d(c), a));
        i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        com.medialets.advertising.a.d((new StringBuilder()).append("URL request response code: ").append(i).toString());
        if (i != 200) goto _L7; else goto _L6
_L6:
        if (!a.startsWith("http")) goto _L9; else goto _L8
_L8:
        JSBridge.a(c).post(new <init>(c, a, JSBridge.a(c, a)));
_L10:
        d1.a();
        JSBridge.a(c).post(c.mLoadingViewRunnable);
        return;
_L9:
        JSBridge.a(c).post(new <init>(c, a));
          goto _L10
        obj;
        com.medialets.advertising.a.c((new StringBuilder()).append("Exception while opening URL: ").append(a).append(": ").append(((Exception) (obj)).toString()).toString());
        d1.a();
        JSBridge.a(c).post(c.mLoadingViewRunnable);
        return;
_L7:
        if (i < 300 || i >= 400)
        {
            break MISSING_BLOCK_LABEL_644;
        }
        String s = ((HttpResponse) (obj)).getHeaders("Location")[0].getValue();
        if (i != 301)
        {
            obj = s;
            if (i != 302)
            {
                break MISSING_BLOCK_LABEL_540;
            }
        }
        obj = URIUtils.resolve(httpget.getURI(), s).toString();
        com.medialets.advertising.a.d((new StringBuilder()).append("Loading redirect URL: ").append(((String) (obj))).toString());
        if (!((String) (obj)).startsWith("http"))
        {
            break MISSING_BLOCK_LABEL_618;
        }
        a = ((String) (obj));
        b = b + 1;
        a();
          goto _L10
        obj;
        d1.a();
        JSBridge.a(c).post(c.mLoadingViewRunnable);
        throw obj;
        JSBridge.a(c).post(new <init>(c, ((String) (obj))));
          goto _L10
        com.medialets.advertising.a.c("Response code unrecognised");
          goto _L10
    }

    public final void run()
    {
        a();
    }

    public (JSBridge jsbridge, String s)
    {
        c = jsbridge;
        super();
        a = s;
        b = 0;
    }
}
