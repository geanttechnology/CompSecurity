// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzfo, zzid

public class zzfq
    implements zzfo
{

    private final Context mContext;
    final Set zzCr = Collections.synchronizedSet(new HashSet());

    public zzfq(Context context)
    {
        mContext = context;
    }

    public void zza(String s, String s1, String s2)
    {
        zzb.zzaF("Fetching assets for the given html");
        zzid.zzIE.post(new _cls1(s1, s2));
    }

    public WebView zzfh()
    {
        WebView webview = new WebView(mContext);
        webview.getSettings().setJavaScriptEnabled(true);
        return webview;
    }

    /* member class not found */
    class _cls1 {}

}
