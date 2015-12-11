// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements android.view.Listener
{

    final MainPage this$0;

    public void onClick(View view)
    {
        isReady = false;
        MainPage.isPageLoaded = false;
        rlPanelTop.setVisibility(8);
        rlPanelBottom.setVisibility(8);
        wv.loadUrl("http://static.mixerbox.com/yt_android.min.b.v7.html");
        tvSwitch.setVisibility(8);
        wv.setOnTouchListener(null);
    }

    ()
    {
        this$0 = MainPage.this;
        super();
    }
}
