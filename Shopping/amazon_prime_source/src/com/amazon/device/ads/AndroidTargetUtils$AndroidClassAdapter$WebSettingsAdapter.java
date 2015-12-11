// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.WebSettings;

// Referenced classes of package com.amazon.device.ads:
//            AndroidTargetUtils

public class webSettings
{

    final webSettings this$0;
    private final WebSettings webSettings;

    public void setMediaPlaybackRequiresUserGesture(boolean flag)
    {
        if (webSettings(this._cls0.this, 17))
        {
            kRequiresUserGesture(webSettings, flag);
        }
    }

    public (WebSettings websettings)
    {
        this$0 = this._cls0.this;
        super();
        webSettings = websettings;
    }
}
