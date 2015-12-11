// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.gu;
import java.net.URI;
import java.net.URISyntaxException;

public class acj extends WebViewClient
{

    private final String a;
    private boolean b;
    private final gu c;
    private final zy d;

    public acj(zy zy1, gu gu1, String s)
    {
        a = b(s);
        b = false;
        c = gu1;
        d = zy1;
    }

    private String b(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        if (!s.endsWith("/")) goto _L1; else goto _L3
_L3:
        String s1 = s.substring(0, s.length() - 1);
        return s1;
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        acb.b(indexoutofboundsexception.getMessage());
        return s;
    }

    protected boolean a(String s)
    {
        s = b(s);
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s1;
        Object obj;
        Object obj1;
        try
        {
            obj = new URI(s);
            if (!"passback".equals(((URI) (obj)).getScheme()))
            {
                continue; /* Loop/switch isn't completed */
            }
            acb.a("Passback received");
            d.b();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            acb.b(s.getMessage());
            return false;
        }
        return true;
        if (TextUtils.isEmpty(a)) goto _L1; else goto _L3
_L3:
        obj1 = new URI(a);
        s = ((URI) (obj1)).getHost();
        s1 = ((URI) (obj)).getHost();
        obj1 = ((URI) (obj1)).getPath();
        obj = ((URI) (obj)).getPath();
        if (!adv.a(s, s1) || !adv.a(obj1, obj)) goto _L1; else goto _L4
_L4:
        acb.a("Passback received");
        d.b();
        return true;
    }

    public void onLoadResource(WebView webview, String s)
    {
        acb.a((new StringBuilder()).append("JavascriptAdWebViewClient::onLoadResource: ").append(s).toString());
        if (!a(s))
        {
            c.f().onLoadResource(c, s);
        }
    }

    public void onPageFinished(WebView webview, String s)
    {
        acb.a((new StringBuilder()).append("JavascriptAdWebViewClient::onPageFinished: ").append(s).toString());
        if (!b)
        {
            d.a();
            b = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        acb.a((new StringBuilder()).append("JavascriptAdWebViewClient::shouldOverrideUrlLoading: ").append(s).toString());
        if (a(s))
        {
            acb.a("shouldOverrideUrlLoading: received passback url");
            return true;
        } else
        {
            return c.f().shouldOverrideUrlLoading(c, s);
        }
    }
}
