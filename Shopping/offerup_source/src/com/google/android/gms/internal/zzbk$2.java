// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.google.android.gms.internal:
//            zzbk, zzbh

class _cls1
    implements Runnable
{

    final zzbk zzsh;
    ValueCallback zzsi;
    final zzbh zzsj;
    final WebView zzsk;

    public void run()
    {
        if (!zzsk.getSettings().getJavaScriptEnabled())
        {
            break MISSING_BLOCK_LABEL_26;
        }
        zzsk.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzsi);
        return;
        Throwable throwable;
        throwable;
        zzsi.onReceiveValue("");
        return;
    }

    _cls1.zzsl(zzbk zzbk, zzbh zzbh, WebView webview)
    {
        zzsh = zzbk;
        zzsj = zzbh;
        zzsk = webview;
        super();
        class _cls1
            implements ValueCallback
        {

            final zzbk._cls2 zzsl;

            public void onReceiveValue(Object obj)
            {
                zzy((String)obj);
            }

            public void zzy(String s)
            {
                zzsl.zzsh.zza(zzsl.zzsj, zzsl.zzsk, s);
            }

            _cls1()
            {
                zzsl = zzbk._cls2.this;
                super();
            }
        }

        zzsi = new _cls1();
    }
}
