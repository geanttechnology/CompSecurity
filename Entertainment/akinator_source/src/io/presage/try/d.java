// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.try;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import io.presage.formats.multiwebviews.g;
import io.presage.formats.multiwebviews.h;
import io.presage.utils.b;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.try:
//            a, e, f, g

public final class d extends WebView
    implements io.presage.try.a
{
    public static interface a
    {

        public abstract void a(d d1, String s);
    }

    public static interface b
    {

        public abstract void a(WebView webview, String s);
    }

    public static interface c
    {

        public abstract void b(d d1, String s);
    }


    private String a;
    private boolean b;
    private boolean c;
    private h d;
    private b e;
    private a f;
    private c g;
    private a.a h;
    private io.presage.formats.multiwebviews.h.b i;
    private io.presage.formats.multiwebviews.h.a j;
    private android.view.View.OnTouchListener k;

    public d(Context context, String s)
    {
        super(context);
        i = new e(this);
        j = new f(this);
        k = new io.presage.utils.b(new io.presage.try.g(this));
        a = s;
        b = false;
        c = false;
        getSettings().setJavaScriptEnabled(true);
        d = new h();
        setWebViewClient(d);
        setWebChromeClient(new g(s));
    }

    static c a(d d1)
    {
        return d1.g;
    }

    static b b(d d1)
    {
        return d1.e;
    }

    static a.a c(d d1)
    {
        return d1.h;
    }

    public final String a()
    {
        return a;
    }

    public final void a(a.a a1)
    {
        h = a1;
    }

    public final void a(a a1)
    {
        f = a1;
    }

    public final void a(b b1)
    {
        e = b1;
    }

    public final void a(c c1)
    {
        g = c1;
    }

    public final void a(String s)
    {
        super.loadUrl((new StringBuilder("javascript:")).append(s).toString());
    }

    public final void a(String s, Object obj)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("(function(n,p){p=p||{bubbles:false,cancelable:false,detail:undefined};var e;if(!window.CustomEvent){e=document.createEvent('CustomEvent');e.initCustomEvent(n,p.bubbles,p.cancelable,p.detail);}else{e=new CustomEvent(n,p);}window.dispatchEvent(e);})('").append(s).append("',{'detail':").append((new Gson()).toJson(obj)).append("})");
        a(stringbuilder.toString());
    }

    public final void b()
    {
        b = true;
    }

    public final void c()
    {
        c = true;
    }

    public final boolean d()
    {
        return b;
    }

    public final boolean e()
    {
        return c;
    }

    public final void loadUrl(String s)
    {
        super.loadUrl(s);
        if (f != null)
        {
            f.a(this, s);
        }
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        d.a(j);
        d.a(i);
        setOnTouchListener(k);
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        d.a(null);
        d.a(null);
        setOnTouchListener(null);
    }

    protected final void onMeasure(int l, int i1)
    {
        invalidate();
        super.onMeasure(l, i1);
    }
}
