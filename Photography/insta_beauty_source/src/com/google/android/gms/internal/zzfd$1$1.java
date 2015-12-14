// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzfd

class zzrG extends WebViewClient
{

    final zzrG zzAx;
    final WebView zzrG;

    public void onPageFinished(WebView webview, String s)
    {
        zzb.zzay("Loading assets have finished");
        zzAx.Aw.zzAt.remove(zzrG);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        zzb.zzaC("Loading assets have failed.");
        zzAx.Aw.zzAt.remove(zzrG);
    }

    client.zzb(client.zzb zzb1, WebView webview)
    {
        zzAx = zzb1;
        zzrG = webview;
        super();
    }
}
