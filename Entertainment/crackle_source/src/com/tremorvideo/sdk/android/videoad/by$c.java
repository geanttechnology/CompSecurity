// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            by

class d extends WebView
{

    public boolean a;
    public boolean b;

    (Activity activity)
    {
        super(activity);
        a = false;
        b = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
    }
}
