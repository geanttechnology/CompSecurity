// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.mopub.common:
//            MoPubBrowser

final class a
    implements android.view.tener
{

    final MoPubBrowser a;

    public final void onClick(View view)
    {
        if (MoPubBrowser.a(a).canGoBack())
        {
            MoPubBrowser.a(a).goBack();
        }
    }

    r(MoPubBrowser mopubbrowser)
    {
        a = mopubbrowser;
        super();
    }
}
