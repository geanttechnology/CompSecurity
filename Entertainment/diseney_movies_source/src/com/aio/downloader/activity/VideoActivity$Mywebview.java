// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.aio.downloader.utils.ProgressWheel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.aio.downloader.activity:
//            VideoActivity

public class this._cls0 extends WebViewClient
{

    final VideoActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        VideoActivity.access$3(VideoActivity.this).setVisibility(8);
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        VideoActivity.access$3(VideoActivity.this).setVisibility(0);
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        VideoActivity.access$5(VideoActivity.this).loadData("", "text/html", "UTF-8");
        VideoActivity.access$6(VideoActivity.this).setVisibility(0);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        if (!s.contains("//m.youtube.com")) goto _L2; else goto _L1
_L1:
        Matcher matcher;
        Log.v("lklk", (new StringBuilder("load:")).append(s).toString());
        matcher = Pattern.compile("/watch\\?.*v=([^&]+)").matcher(s);
        if (!matcher.find()) goto _L4; else goto _L3
_L3:
        Log.v("cvcv", (new StringBuilder("GOOD:")).append(s).append("     id:").append(matcher.group(1)).toString());
        Message message1 = new Message();
        message1.what = 1;
        hander.sendMessage(message1);
        VideoActivity.access$7(VideoActivity.this, (new StringBuilder("http://www.youtube.com/get_video_info?&video_id=")).append(matcher.group(1)).append("&asv=3&el=detailpage&hl=en_US").toString());
        Log.i("getUrl", VideoActivity.access$8(VideoActivity.this));
_L2:
        return super.shouldInterceptRequest(webview, s);
_L4:
        if (!s.contains("/feed") && !s.contains("/_get_ads") && !s.contains("/guide_ajax"))
        {
            Log.v("cvcv", (new StringBuilder("BAD:")).append(s).toString());
            Message message = new Message();
            message.what = 2;
            hander.sendMessage(message);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public _cls9()
    {
        this$0 = VideoActivity.this;
        super();
    }
}
