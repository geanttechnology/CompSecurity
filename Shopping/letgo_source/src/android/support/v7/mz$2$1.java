// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package android.support.v7:
//            mz, mw

class a
    implements ValueCallback
{

    final a a;

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

    // Unreferenced inner class android/support/v7/mz$2

/* anonymous class */
    class mz._cls2
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

            
            {
                d = mz1;
                b = mw;
                c = webview;
                super();
                a = new mz._cls2._cls1(this);
            }
    }

}
