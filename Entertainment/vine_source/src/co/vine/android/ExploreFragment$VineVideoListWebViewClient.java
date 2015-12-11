// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            ExploreFragment, ExploreChannelsActivity, ExploreVideoListActivity

class this._cls0 extends WebViewClient
{

    final ExploreFragment this$0;

    public void onPageFinished(WebView webview, String s)
    {
        ExploreFragment.access$100(ExploreFragment.this).setVisibility(8);
        webview.scrollTo(0, 0);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        SLog.dWithTag("ExploreFragment", (new StringBuilder()).append("WebViewClient errorCode=").append(i).toString());
        webview.setVisibility(8);
        if (ExploreFragment.access$000(ExploreFragment.this) != null)
        {
            ExploreFragment.access$000(ExploreFragment.this).setVisibility(8);
        }
        if (ExploreFragment.access$100(ExploreFragment.this) != null)
        {
            ExploreFragment.access$100(ExploreFragment.this).setVisibility(0);
        }
        if (ExploreFragment.access$200(ExploreFragment.this) != null)
        {
            ExploreFragment.access$300(ExploreFragment.this).setVisibility(0);
        }
        if (ExploreFragment.access$400(ExploreFragment.this) != null)
        {
            ExploreFragment.access$400(ExploreFragment.this).setVisibility(0);
        }
        if (i == -2)
        {
            webview = getString(0x7f0e00d2);
        } else
        {
            webview = getString(0x7f0e00d1);
        }
        ExploreFragment.access$400(ExploreFragment.this).setText(webview);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview = Uri.parse(s);
        if (webview.getScheme().equals("vine"))
        {
            s = new Intent();
            s.setData(webview);
            if ("channels".equals(webview.getHost()))
            {
                s.setClass(getActivity(), co/vine/android/ExploreChannelsActivity);
            } else
            {
                s.setClass(getActivity(), co/vine/android/ExploreVideoListActivity);
            }
            startActivity(s);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = ExploreFragment.this;
        super();
    }
}
