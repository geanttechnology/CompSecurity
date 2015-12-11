// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

// Referenced classes of package cn.jpush.android.ui:
//            e

public final class d extends WebChromeClient
{

    private final ProgressBar a;
    private Handler b;

    public d(ProgressBar progressbar)
    {
        b = new e(this);
        a = progressbar;
    }

    static ProgressBar a(d d1)
    {
        return d1.a;
    }

    public final void onProgressChanged(WebView webview, int i)
    {
        super.onProgressChanged(webview, i);
        if (a != null)
        {
            if (a.getVisibility() != 0)
            {
                a.setVisibility(0);
            }
            a.setProgress(i);
            if (a.getProgress() == 100)
            {
                b.sendEmptyMessageDelayed(0, 500L);
            }
        }
    }
}
