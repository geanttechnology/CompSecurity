// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package android.support.v7:
//            mz, mw

class _cls1.a
    implements Runnable
{

    ValueCallback a;
    final mw b;
    final WebView c;
    final mz d;

    public void run()
    {
        if (!c.getSettings().getJavaScriptEnabled())
        {
            break MISSING_BLOCK_LABEL_26;
        }
        c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", a);
        return;
        Throwable throwable;
        throwable;
        a.onReceiveValue("");
        return;
    }

    _cls1.a(mz mz1, mw mw, WebView webview)
    {
        d = mz1;
        b = mw;
        c = webview;
        super();
        a = new ValueCallback() {

            final mz._cls2 a;

            public void a(String s)
            {
                a.d.a(a.b, a.c, s);
            }

            public void onReceiveValue(Object obj)
            {
                a((String)obj);
            }

            
            {
                a = mz._cls2.this;
                super();
            }
        };
    }
}
