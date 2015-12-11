// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

// Referenced classes of package com.jirbo.adcolony:
//            au, ak, bl, o, 
//            bm

class a extends WebViewClient
{

    String a;
    final au b;

    public void onLoadResource(WebView webview, String s)
    {
        bl.a.a("DEC onLoad: ").b(s);
        if (s.equals(a))
        {
            bl.a.b("DEC disabling mouse events");
            b.a("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
        }
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (s.equals(a) || ak.K.startsWith("<"))
        {
            b.D = false;
            b.d.k = true;
            b.w = System.currentTimeMillis();
            b.d.o = (double)(b.w - b.v) / 1000D;
        }
        b.d.K.removeView(b.c);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (s.equals(a))
        {
            b.d.j = true;
            b.v = System.currentTimeMillis();
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        bl.a.a("DEC request: ").b(s);
        if (s.contains("mraid:"))
        {
            b.av.a(s);
        } else
        {
            if (s.contains("youtube"))
            {
                webview = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("vnd.youtube:").append(s).toString()));
                webview.putExtra("VIDEO_ID", s);
                b.d.startActivity(webview);
                return true;
            }
            if (!s.contains("mraid.js"))
            {
                return false;
            }
        }
        return true;
    }

    ut(au au1)
    {
        b = au1;
        super();
        a = ak.K;
    }
}
