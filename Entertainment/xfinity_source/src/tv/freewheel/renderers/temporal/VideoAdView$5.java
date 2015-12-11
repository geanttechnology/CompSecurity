// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoAdView, VideoRenderer

class val.timeoutMs
    implements Runnable
{

    final VideoAdView this$0;
    final int val$timeoutMs;
    final String val$url;

    public void run()
    {
        Object obj;
        HttpURLConnection httpurlconnection;
        Object obj2;
        Object obj3;
        obj3 = null;
        VideoAdView.access$1202(VideoAdView.this, val$url);
        obj2 = null;
        obj = null;
        httpurlconnection = null;
        HttpURLConnection httpurlconnection1 = (HttpURLConnection)(new URL(val$url)).openConnection();
        httpurlconnection = httpurlconnection1;
        obj2 = httpurlconnection1;
        obj = httpurlconnection1;
        httpurlconnection1.setConnectTimeout(val$timeoutMs);
        httpurlconnection = httpurlconnection1;
        obj2 = httpurlconnection1;
        obj = httpurlconnection1;
        httpurlconnection1.setReadTimeout(val$timeoutMs);
        httpurlconnection = httpurlconnection1;
        obj2 = httpurlconnection1;
        obj = httpurlconnection1;
        httpurlconnection1.setInstanceFollowRedirects(false);
        httpurlconnection = httpurlconnection1;
        obj2 = httpurlconnection1;
        obj = httpurlconnection1;
        if (httpurlconnection1.getResponseCode() != 302)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        httpurlconnection = httpurlconnection1;
        obj2 = httpurlconnection1;
        obj = httpurlconnection1;
        VideoAdView.access$000(VideoAdView.this).debug("tryToGetRedirectedUrl asset url is a redirect url");
        httpurlconnection = httpurlconnection1;
        obj2 = httpurlconnection1;
        obj = httpurlconnection1;
        VideoAdView.access$1202(VideoAdView.this, httpurlconnection1.getHeaderField("Location"));
        httpurlconnection1.disconnect();
        obj = obj3;
_L1:
        if (VideoAdView.access$1200(VideoAdView.this) == null)
        {
            VideoAdView.access$1202(VideoAdView.this, val$url);
        }
        VideoAdView.access$400(VideoAdView.this).onRedirectUrlChecked(VideoAdView.access$1200(VideoAdView.this), ((Exception) (obj)));
        return;
        obj2;
        obj = httpurlconnection;
        VideoAdView.access$000(VideoAdView.this).warn((new StringBuilder()).append("tryToGetRedirectedUrl MalformedURLException for url:").append(val$url).toString());
        httpurlconnection.disconnect();
        obj = obj2;
          goto _L1
        Object obj1;
        obj1;
        obj = obj2;
        VideoAdView.access$000(VideoAdView.this).warn((new StringBuilder()).append("tryToGetRedirectedUrl IOException for url:").append(val$url).toString());
        ((HttpURLConnection) (obj2)).disconnect();
        obj = obj1;
          goto _L1
        obj1;
        ((HttpURLConnection) (obj)).disconnect();
        throw obj1;
    }

    ()
    {
        this$0 = final_videoadview;
        val$url = s;
        val$timeoutMs = I.this;
        super();
    }
}
