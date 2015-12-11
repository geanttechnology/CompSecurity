// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzfq

class zzsk extends WebViewClient
{

    final zzsk zzCv;
    final WebView zzsk;

    public void onPageFinished(WebView webview, String s)
    {
        zzb.zzaF("Loading assets have finished");
        zzCv.Cu.zzCr.remove(zzsk);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        zzb.zzaH("Loading assets have failed.");
        zzCv.Cu.zzCr.remove(zzsk);
    }

    client.zzb(client.zzb zzb1, WebView webview)
    {
        zzCv = zzb1;
        zzsk = webview;
        super();
    }
}
