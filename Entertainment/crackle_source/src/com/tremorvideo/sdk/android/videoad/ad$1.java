// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad

static final class 
    implements Runnable
{

    public void run()
    {
        ad.n = (new WebView(ad.a)).getSettings().getUserAgentString();
    }

    ()
    {
    }
}
