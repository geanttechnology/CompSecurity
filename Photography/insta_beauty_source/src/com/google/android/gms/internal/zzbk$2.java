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

    final zzbk zzrD;
    ValueCallback zzrE;
    final zzbh zzrF;
    final WebView zzrG;

    public void run()
    {
        if (!zzrG.getSettings().getJavaScriptEnabled())
        {
            break MISSING_BLOCK_LABEL_26;
        }
        zzrG.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzrE);
        return;
        Throwable throwable;
        throwable;
        zzrE.onReceiveValue("");
        return;
    }

    _cls1.zzrH(zzbk zzbk, zzbh zzbh, WebView webview)
    {
        zzrD = zzbk;
        zzrF = zzbh;
        zzrG = webview;
        super();
        class _cls1
            implements ValueCallback
        {

            final zzbk._cls2 zzrH;

            public void onReceiveValue(Object obj)
            {
                zzx((String)obj);
            }

            public void zzx(String s)
            {
                zzrH.zzrD.zza(zzrH.zzrF, zzrH.zzrG, s);
            }

            _cls1()
            {
                zzrH = zzbk._cls2.this;
                super();
            }
        }

        zzrE = new _cls1();
    }
}
