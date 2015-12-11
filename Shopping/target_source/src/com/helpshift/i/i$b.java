// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.helpshift.HSQuestionFragment;
import com.helpshift.app.a;
import com.helpshift.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift.i:
//            i

private class <init> extends WebViewClient
{

    final i a;

    public void onPageFinished(WebView webview, String s)
    {
        i.e(a).d(false);
        i.f(a).a();
        i.f(a).b();
    }

    public void onReceivedError(WebView webview, int j, String s, String s1)
    {
        super.onReceivedError(webview, j, s, s1);
        if (s1.equals(i.g(a)) && j == -10)
        {
            com.helpshift.i.i.a(a, true);
            i.f(a).d();
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

    private on(i j)
    {
        a = j;
        super();
    }

    ewClient(i j, ewClient ewclient)
    {
        this(j);
    }
}
