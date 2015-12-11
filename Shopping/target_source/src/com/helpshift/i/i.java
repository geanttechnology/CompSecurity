// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.f;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.helpshift.HSQuestionFragment;
import com.helpshift.app.a;
import com.helpshift.o;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends WebView
{
    private class a extends WebChromeClient
    {

        final i a;
        private Bitmap b;
        private View c;

        public Bitmap getDefaultVideoPoster()
        {
            if (b != null);
            return b;
        }

        public View getVideoLoadingProgressView()
        {
            if (c == null)
            {
                c = LayoutInflater.from(i.d(a)).inflate(com.helpshift.b.d.y, null);
            }
            return c;
        }

        public boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            return true;
        }

        public void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
        {
            callback.invoke(s, true, false);
        }

        public void onHideCustomView()
        {
            if (com.helpshift.i.i.a(a) == null)
            {
                return;
            } else
            {
                com.helpshift.i.i.a(a).setVisibility(8);
                i.b(a).removeView(com.helpshift.i.i.a(a));
                com.helpshift.i.i.a(a, null);
                i.b(a).setVisibility(8);
                i.c(a).onCustomViewHidden();
                a.setVisibility(0);
                return;
            }
        }

        public void onProgressChanged(WebView webview, int l)
        {
            ((com.helpshift.app.a)i.d(a)).getWindow().setFeatureInt(2, l * 100);
        }

        public void onReceivedTitle(WebView webview, String s)
        {
            ((com.helpshift.app.a)i.d(a)).setTitle(s);
        }

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            a.setVisibility(8);
            if (com.helpshift.i.i.a(a) != null)
            {
                customviewcallback.onCustomViewHidden();
                return;
            } else
            {
                i.b(a).addView(view);
                com.helpshift.i.i.a(a, view);
                com.helpshift.i.i.a(a, customviewcallback);
                i.b(a).setVisibility(0);
                return;
            }
        }

        private a()
        {
            a = i.this;
            super();
        }

    }

    private class b extends WebViewClient
    {

        final i a;

        public void onPageFinished(WebView webview, String s)
        {
            i.e(a).d(false);
            com.helpshift.i.i.f(a).a();
            com.helpshift.i.i.f(a).b();
        }

        public void onReceivedError(WebView webview, int l, String s, String s1)
        {
            super.onReceivedError(webview, l, s, s1);
            if (s1.equals(i.g(a)) && l == -10)
            {
                com.helpshift.i.i.a(a, true);
                com.helpshift.i.i.f(a).d();
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
        {
            Object obj;
            File file;
            file = i.e(a).getExternalCacheDir();
            try
            {
                obj = new URL(s);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d("HelpShiftDebug", "MalformedURLException", ((Throwable) (obj)));
                obj = null;
            }
            if (obj == null) goto _L2; else goto _L1
_L1:
            file = new File(file, s.replace("/", "_"));
            if (!file.exists()) goto _L4; else goto _L3
_L3:
            obj = new WebResourceResponse("", "", new FileInputStream(file));
            return ((WebResourceResponse) (obj));
            obj;
            Log.d("HelpShiftDebug", "FileNotFoundException", ((Throwable) (obj)));
_L2:
            return super.shouldInterceptRequest(webview, s);
_L4:
            if (com.helpshift.i.i.a(a, ((URL) (obj))))
            {
                com.helpshift.i.i.a(a, ((URL) (obj)), file);
            }
            if (true) goto _L2; else goto _L5
_L5:
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (!TextUtils.isEmpty(s))
            {
                webview = new Intent("android.intent.action.VIEW");
                Uri uri = Uri.parse(s.trim());
                webview.setData(uri);
                if (webview.resolveActivity(i.e(a).getPackageManager()) != null)
                {
                    try
                    {
                        JSONObject jsonobject = new JSONObject();
                        jsonobject.put("p", uri.getScheme());
                        jsonobject.put("u", s.trim());
                        o.a("fl", jsonobject);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        Log.d("HelpShiftDebug", "JSONException : ", s);
                    }
                    i.e(a).startActivity(webview);
                    return true;
                }
                com.helpshift.i.i.a(a, s);
            }
            return false;
        }

        private b()
        {
            a = i.this;
            super();
        }

    }


    private Context a;
    private a b;
    private View c;
    private FrameLayout d;
    private android.webkit.WebChromeClient.CustomViewCallback e;
    private FrameLayout f;
    private FrameLayout g;
    private HSQuestionFragment h;
    private com.helpshift.app.a i;
    private String j;
    private boolean k;

    public i(Context context, HSQuestionFragment hsquestionfragment)
    {
        super(context);
        a(context, hsquestionfragment);
    }

    static View a(i l)
    {
        return l.c;
    }

    static View a(i l, View view)
    {
        l.c = view;
        return view;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(i l, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        l.e = customviewcallback;
        return customviewcallback;
    }

    static String a(i l, String s)
    {
        l.j = s;
        return s;
    }

    private void a(Context context, HSQuestionFragment hsquestionfragment)
    {
        h = hsquestionfragment;
        a = context;
        i = (com.helpshift.app.a)a;
        g = (FrameLayout)LayoutInflater.from(i).inflate(com.helpshift.b.d.x, null);
        f = (FrameLayout)g.findViewById(com.helpshift.b.c.L);
        d = (FrameLayout)i.findViewById(com.helpshift.b.c.M);
        b = new a();
        setWebChromeClient(b);
        setWebViewClient(new b());
        context = getSettings();
        context.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        context.setLoadWithOverviewMode(true);
        context.setSavePassword(true);
        context.setSaveFormData(true);
        context.setJavaScriptEnabled(true);
        context.setDomStorageEnabled(true);
        context.setJavaScriptEnabled(true);
        context.setAllowFileAccess(true);
        context.setAppCacheEnabled(true);
        context.setDomStorageEnabled(true);
        context.setPluginState(android.webkit.WebSettings.PluginState.OFF);
        context.setAllowFileAccess(true);
        f.addView(this);
    }

    static void a(i l, URL url, File file)
    {
        l.a(url, file);
    }

    private void a(URL url, File file)
    {
        url = url.openStream();
        file = new FileOutputStream(file);
        byte abyte0[] = new byte[500];
_L1:
        int l = url.read(abyte0, 0, abyte0.length);
        if (l < 0)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        file.write(abyte0, 0, l);
          goto _L1
        Exception exception;
        exception;
        try
        {
            file.close();
            url.close();
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.d("HelpShiftDebug", "saveFile Exception :", url);
        }
        return;
        file.close();
        url.close();
        return;
    }

    static boolean a(i l, URL url)
    {
        return l.a(url);
    }

    static boolean a(i l, boolean flag)
    {
        l.k = flag;
        return flag;
    }

    private boolean a(URL url)
    {
        HashSet hashset = new HashSet(Arrays.asList(new String[] {
            "image/jpeg", "image/png", "image/gif", "image/x-png", "image/x-citrix-pjpeg", "image/x-citrix-gif", "image/pjpeg"
        }));
        boolean flag;
        try
        {
            flag = hashset.contains(HttpInstrumentation.openConnection(url.openConnection()).getContentType());
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Log.d("HelpShiftDebug", "openConnection() Exception :", url);
            return false;
        }
        return flag;
    }

    static FrameLayout b(i l)
    {
        return l.d;
    }

    static android.webkit.WebChromeClient.CustomViewCallback c(i l)
    {
        return l.e;
    }

    static Context d(i l)
    {
        return l.a;
    }

    static com.helpshift.app.a e(i l)
    {
        return l.i;
    }

    static HSQuestionFragment f(i l)
    {
        return l.h;
    }

    static String g(i l)
    {
        return l.j;
    }

    public boolean a()
    {
        return c != null;
    }

    public void b()
    {
        b.onHideCustomView();
    }

    public FrameLayout getLayout()
    {
        return g;
    }

    public boolean onKeyDown(int l, KeyEvent keyevent)
    {
        if (l == 4 && c == null && canGoBack())
        {
            if (k)
            {
                h.getActivity().finish();
            } else
            {
                goBack();
            }
            return true;
        } else
        {
            return super.onKeyDown(l, keyevent);
        }
    }
}
