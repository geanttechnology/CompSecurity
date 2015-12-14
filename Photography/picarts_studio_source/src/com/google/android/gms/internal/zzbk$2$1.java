// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.google.android.gms.internal:
//            zzbk, zzbh

class zzsl
    implements ValueCallback
{

    final sk zzsl;

    public void onReceiveValue(Object obj)
    {
        zzy((String)obj);
    }

    public void zzy(String s)
    {
        zzsl.sh.zza(zzsl.sj, zzsl.sk, s);
    }

    <init>(<init> <init>1)
    {
        zzsl = <init>1;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/zzbk$2

/* anonymous class */
    class zzbk._cls2
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

            
            {
                zzsh = zzbk1;
                zzsj = zzbh;
                zzsk = webview;
                super();
                zzsi = new zzbk._cls2._cls1(this);
            }
    }

}
