// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tremorvideo.sdk.android.videoad.ad;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            j, a, g, b

public class com.tremorvideo.sdk.android.richmedia.a.c extends WebView
    implements j
{
    private class a extends WebChromeClient
    {

        final com.tremorvideo.sdk.android.richmedia.a.c a;

        public void onConsoleMessage(String s, int i, String s1)
        {
            Log.d("ClickoutWebView", (new StringBuilder()).append("MSG: ").append(s).append("; Line: ").append(i).append("; Source: ").append(s1).toString());
        }

        public boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            Log.d("ClickoutWebView", (new StringBuilder()).append("MSG: ").append(consolemessage.message()).append("; Line: ").append(consolemessage.lineNumber()).append("; Source: ").append(consolemessage.sourceId()).toString());
            return true;
        }

        private a()
        {
            a = com.tremorvideo.sdk.android.richmedia.a.c.this;
            super();
        }

    }

    private class b extends WebViewClient
    {

        final com.tremorvideo.sdk.android.richmedia.a.c a;

        public void onPageFinished(WebView webview, String s)
        {
            if (!com.tremorvideo.sdk.android.richmedia.a.c.b(a))
            {
                a.b();
                for (webview = com.tremorvideo.sdk.android.richmedia.a.c.a(a).iterator(); webview.hasNext(); ((g)webview.next()).cancel(true)) { }
                com.tremorvideo.sdk.android.richmedia.a.c.a(a).clear();
                a.a();
                a.c((new StringBuilder()).append("TMWI.fireEvent('init',").append(com.tremorvideo.sdk.android.richmedia.a.c.c(a)).append(");").toString());
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (Uri.parse(s).getScheme().equals("tmwi"))
            {
                com.tremorvideo.sdk.android.richmedia.a.c.a(a, URI.create(s));
                return true;
            } else
            {
                return false;
            }
        }

        private b()
        {
            a = com.tremorvideo.sdk.android.richmedia.a.c.this;
            super();
        }

    }

    public class c
        implements Runnable
    {

        Map a;
        com.tremorvideo.sdk.android.richmedia.a.c b;
        final com.tremorvideo.sdk.android.richmedia.a.c c;

        public void run()
        {
            g g1 = new g(b);
            com.tremorvideo.sdk.android.richmedia.a.c.a(c).add(g1);
            if (a.containsKey("data"))
            {
                g1.execute(new String[] {
                    (String)a.get("url"), (String)a.get("type"), (String)a.get("header"), (String)a.get("data")
                });
                return;
            } else
            {
                g1.execute(new String[] {
                    (String)a.get("url"), (String)a.get("type"), (String)a.get("header")
                });
                return;
            }
        }

        public c(Map map, com.tremorvideo.sdk.android.richmedia.a.c c2)
        {
            c = com.tremorvideo.sdk.android.richmedia.a.c.this;
            super();
            a = map;
            b = c2;
        }
    }


    private com.tremorvideo.sdk.android.richmedia.a.b a;
    private b b;
    private a c;
    private com.tremorvideo.sdk.android.richmedia.a.a d;
    private ArrayList e;
    private boolean f;
    private JSONObject g;

    public com.tremorvideo.sdk.android.richmedia.a.c(Context context, com.tremorvideo.sdk.android.richmedia.a.b b1)
    {
        super(context);
        a = b1;
        c();
    }

    static ArrayList a(com.tremorvideo.sdk.android.richmedia.a.c c1)
    {
        return c1.e;
    }

    static void a(com.tremorvideo.sdk.android.richmedia.a.c c1, URI uri)
    {
        c1.a(uri);
    }

    private void a(URI uri)
    {
        Object obj;
        obj = uri.getHost();
        Object obj1 = URLEncodedUtils.parse(uri, "UTF-8");
        uri = new HashMap();
        NameValuePair namevaluepair;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); uri.put(namevaluepair.getName(), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)((Iterator) (obj1)).next();
        }

        if (((String) (obj)).equals("url-request"))
        {
            ((Activity)getContext()).runOnUiThread(new c(uri, this));
            b("url-request");
            return;
        }
        if (!((String) (obj)).equals("fire-tracking")) goto _L2; else goto _L1
_L1:
        obj = (String)uri.get("event_tag");
        if (obj == null) goto _L4; else goto _L3
_L3:
        ArrayList arraylist = new ArrayList();
        uri = uri.entrySet().iterator();
        do
        {
            if (!uri.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)uri.next();
            if (!((String)entry.getKey()).equals("event_tag"))
            {
                arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
            }
        } while (true);
        try
        {
            d.a(((String) (obj)), arraylist);
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            ad.d((new StringBuilder()).append("firetrackingEvent Exception:").append(uri).toString());
        }
          goto _L5
_L4:
        b("fire-tracking");
        return;
_L5:
        if (true) goto _L4; else goto _L2
_L2:
        if (((String) (obj)).equals("trigger-close"))
        {
            d.e();
            b("trigger-close");
            return;
        }
        if (((String) (obj)).equals("trigger-error"))
        {
            ad.d((new StringBuilder()).append("EmbedPlayer Error - ").append((String)uri.get("error_code")).append(": ").append((String)uri.get("description")).toString());
            b("trigger-error");
            return;
        }
        if (((String) (obj)).equals("cancel-request"))
        {
            if (e != null)
            {
                for (uri = e.iterator(); uri.hasNext(); ((g) (obj)).a())
                {
                    obj = (g)uri.next();
                    ((g) (obj)).cancel(true);
                }

            }
            b("cancel-request");
            return;
        } else
        {
            b(((String) (obj)));
            return;
        }
    }

    static boolean b(com.tremorvideo.sdk.android.richmedia.a.c c1)
    {
        return c1.f;
    }

    static JSONObject c(com.tremorvideo.sdk.android.richmedia.a.c c1)
    {
        return c1.g;
    }

    private void c()
    {
        setScrollContainer(false);
        setBackgroundColor(0);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        WebSettings websettings = getSettings();
        websettings.setSupportZoom(false);
        websettings.setJavaScriptEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            websettings.setPluginState(android.webkit.WebSettings.PluginState.ON);
        }
        websettings.setAllowFileAccess(true);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            websettings.setAllowFileAccessFromFileURLs(true);
        }
        d = a.k();
        b = new b();
        setWebViewClient(b);
        c = new a();
        setWebChromeClient(c);
        f = false;
        e = new ArrayList();
    }

    protected void a()
    {
        c("TMWI.fireEvent('viewableChange','true');");
    }

    public void a(g g1)
    {
        if (e != null && e.contains(g1))
        {
            e.remove(g1);
        }
    }

    public void a(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        g = new JSONObject(s);
        return;
        s;
    }

    public void b()
    {
        setBackgroundColor(0);
        if (ad.q() > 10)
        {
            setLayerType(1, null);
        }
        f = true;
    }

    protected void b(String s)
    {
        c((new StringBuilder()).append("TMWI.nativeCallComplete('").append(s).append("');").toString());
    }

    protected void c(String s)
    {
        if (s != null)
        {
            super.loadUrl((new StringBuilder()).append("javascript:").append(s).toString());
        }
    }

    public void destroy()
    {
        for (Iterator iterator = e.iterator(); iterator.hasNext(); ((g)iterator.next()).cancel(true)) { }
        e.clear();
        e = null;
        clearCache(false);
        destroyDrawingCache();
    }
}
