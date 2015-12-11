// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import android.os.AsyncTask;
import android.webkit.URLUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.html:
//            MRAIDWebView, HTMLRenderer

private class <init> extends AsyncTask
{

    private Boolean fail;
    private String script;
    final MRAIDWebView this$0;
    private String url;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        Object obj;
        String s1;
        int i;
        script = as[1];
        obj = as[0];
        s1 = "";
        as = "";
        if (!URLUtil.isValidUrl(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_341;
        }
        url = ((String) (obj));
        i = 0;
_L6:
        String as1[];
        String as2[];
        Object obj1;
        obj1 = null;
        as1 = as;
        as2 = as;
        obj = (HttpURLConnection)(HttpURLConnection)(new URL(((String) (obj)))).openConnection();
        as1 = as;
        obj1 = obj;
        as2 = as;
        ((HttpURLConnection) (obj)).setInstanceFollowRedirects(false);
        as1 = as;
        obj1 = obj;
        as2 = as;
        ((HttpURLConnection) (obj)).connect();
        as1 = as;
        obj1 = obj;
        as2 = as;
        if (((HttpURLConnection) (obj)).getResponseCode() == 302) goto _L2; else goto _L1
_L1:
        as1 = as;
        obj1 = obj;
        as2 = as;
        Object obj2 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L4:
        as1 = as;
        obj1 = obj;
        as2 = as;
        String s2 = ((BufferedReader) (obj2)).readLine();
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        as1 = as;
        obj1 = obj;
        as2 = as;
        as = (new StringBuilder()).append(as).append(s2).append("\n").toString();
        if (true) goto _L4; else goto _L3
_L3:
        as1 = as;
        obj1 = obj;
        as2 = as;
        ((BufferedReader) (obj2)).close();
        as1 = as;
        obj1 = obj;
        as2 = as;
        fail = Boolean.valueOf(false);
        obj = s1;
_L7:
        int j;
        if (fail.booleanValue())
        {
            return ((String) (obj));
        } else
        {
            return as;
        }
_L2:
        as1 = as;
        obj1 = obj;
        as2 = as;
        obj2 = ((HttpURLConnection) (obj)).getHeaderField("Location");
        j = i + 1;
        as1 = as;
        obj1 = obj;
        as2 = as;
        ((HttpURLConnection) (obj)).disconnect();
        i = j;
        obj = obj2;
        if (j <= 3) goto _L6; else goto _L5
_L5:
        obj = s1;
          goto _L7
        as;
        obj = as.toString();
        as = as1;
          goto _L7
        as;
        String s = (new StringBuilder()).append("Failed to get content from creative url.").append(as.toString()).toString();
        obj = s;
        as = as2;
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
            obj = s;
            as = as2;
        }
          goto _L7
        obj = (new StringBuilder()).append("Invalid url:").append(((String) (obj))).toString();
          goto _L7
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (fail.booleanValue())
        {
            MRAIDWebView.access$000(MRAIDWebView.this).error(s);
            MRAIDWebView.access$900(MRAIDWebView.this).mraidLoadFail(100, s);
            return;
        } else
        {
            s = MRAIDWebView.access$1000(MRAIDWebView.this, s, "");
            loadDataWithBaseURL(url, s, "text/html", "utf8", null);
            return;
        }
    }

    private ()
    {
        this$0 = MRAIDWebView.this;
        super();
        fail = Boolean.valueOf(true);
        script = "";
        url = "";
    }

    url(url url1)
    {
        this();
    }
}
