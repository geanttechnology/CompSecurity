// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import android.net.Uri;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

// Referenced classes of package bolts:
//            WebViewAppLinkResolver, Capture

class val.contentType
    implements Callable
{

    final WebViewAppLinkResolver this$0;
    final Capture val$content;
    final Capture val$contentType;
    final Uri val$url;

    public volatile Object call()
    {
        return call();
    }

    public Void call()
    {
        Object obj;
        Object obj1 = new URL(val$url.toString());
        obj = null;
        while (obj1 != null) 
        {
            obj1 = ((URL) (obj1)).openConnection();
            if (obj1 instanceof HttpURLConnection)
            {
                ((HttpURLConnection)obj1).setInstanceFollowRedirects(true);
            }
            ((URLConnection) (obj1)).setRequestProperty("Prefer-Html-Meta-Tags", "al");
            ((URLConnection) (obj1)).connect();
            if (obj1 instanceof HttpURLConnection)
            {
                Object obj2 = (HttpURLConnection)obj1;
                if (((HttpURLConnection) (obj2)).getResponseCode() >= 300 && ((HttpURLConnection) (obj2)).getResponseCode() < 400)
                {
                    obj = new URL(((HttpURLConnection) (obj2)).getHeaderField("Location"));
                    ((HttpURLConnection) (obj2)).disconnect();
                } else
                {
                    obj = null;
                }
                obj2 = obj;
                obj = obj1;
                obj1 = obj2;
            } else
            {
                obj = obj1;
                obj1 = null;
            }
        }
        val$content.set(WebViewAppLinkResolver.access$300(((URLConnection) (obj))));
        val$contentType.set(((URLConnection) (obj)).getContentType());
        if (obj instanceof HttpURLConnection)
        {
            ((HttpURLConnection)obj).disconnect();
        }
        return null;
        Exception exception;
        exception;
        if (obj instanceof HttpURLConnection)
        {
            ((HttpURLConnection)obj).disconnect();
        }
        throw exception;
    }

    ()
    {
        this$0 = final_webviewapplinkresolver;
        val$url = uri;
        val$content = capture;
        val$contentType = Capture.this;
        super();
    }
}
