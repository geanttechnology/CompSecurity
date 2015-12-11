// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.content.DialogInterface;
import android.webkit.WebView;

// Referenced classes of package com.appnexus.opensdk:
//            m

final class a
    implements android.content.ogInterface.OnCancelListener
{

    final WebView a;
    final m b;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.stopLoading();
    }

    erface(m m1, WebView webview)
    {
        b = m1;
        a = webview;
        super();
    }
}
