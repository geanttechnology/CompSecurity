// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

class ng.Object
    implements ValueCallback
{

    final ng.String a;

    public void a(String s)
    {
        a.a.a(a.a, a.a, s);
    }

    public void onReceiveValue(Object obj)
    {
        a((String)obj);
    }

    <init>(<init> <init>1)
    {
        a = <init>1;
        super();
    }

    // Unreferenced inner class sy$2

/* anonymous class */
    class sy._cls2
        implements Runnable
    {

        ValueCallback a;
        final sv b;
        final WebView c;
        final sy d;

        public void run()
        {
            if (c.getSettings().getJavaScriptEnabled())
            {
                c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", a);
            }
        }

            
            {
                d = sy1;
                b = sv;
                c = webview;
                super();
                a = new sy._cls2._cls1(this);
            }
    }

}
