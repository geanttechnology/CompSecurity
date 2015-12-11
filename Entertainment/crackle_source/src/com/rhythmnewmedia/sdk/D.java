// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.FrameLayout;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            b

public final class D extends b
{

    int k;
    int l;

    public D(Activity activity, String s, String s1)
    {
        super(activity, s, s1);
    }

    public final void a(Intent intent)
    {
        d = d();
        int i = intent.getIntExtra("backgroundColor", -1);
        setBackgroundColor(i);
        c.setBackgroundColor(i);
        d.setBackgroundColor(i);
        c.addView(d);
        String s = intent.getStringExtra("url");
        d.loadUrl(s);
        k = intent.getIntExtra("channelNum", 0);
        l = intent.getIntExtra("contentNum", 0);
    }

    protected final boolean a()
    {
        return true;
    }
}
