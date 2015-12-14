// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.fotoable.fotobeauty.ShareEditActivity;
import com.wantu.activity.weibo.SinaAuthroizeActivity;
import com.wantu.weibo.other.sina.WeiboException;

public class bjz extends WebViewClient
{

    final SinaAuthroizeActivity a;

    bjz(SinaAuthroizeActivity sinaauthroizeactivity)
    {
        a = sinaauthroizeactivity;
        super();
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (s.startsWith("http://api.t.sina.com.cn/oauth/authorize") && SinaAuthroizeActivity.a(a) != null)
        {
            SinaAuthroizeActivity.a(a).cancel();
            SinaAuthroizeActivity.a(a, null);
        }
        if (!s.startsWith("wantu://SinaCallBackActivity")) goto _L2; else goto _L1
_L1:
        webview = Uri.parse(s).getQueryParameter("oauth_verifier");
        s = brt.a();
        s.a("1970943938", "96b30ffeffd7c387e7744a2608dfb524");
        s.a(webview);
        webview = s.a(a, null);
        s = a.getSharedPreferences("com.wantu.android.WantuSetting", 0).edit();
        s.putInt("com.wantu.android.weibo.sina_status", 1);
        s.putString("com.wantu.android.weibo.sina_token", webview.a());
        s.putString("com.wantu.android.weibo.sina_secret", webview.c());
        s.commit();
        if (SinaAuthroizeActivity.c(a).compareTo("share") != 0) goto _L4; else goto _L3
_L3:
        webview = new Intent(a, com/fotoable/fotobeauty/ShareEditActivity);
        webview.putExtra("com.wantu.android.weibo", "sina");
        a.startActivity(webview);
_L6:
        if (SinaAuthroizeActivity.a(a) != null)
        {
            SinaAuthroizeActivity.a(a).cancel();
            SinaAuthroizeActivity.a(a, null);
        }
        a.finish();
_L2:
        return;
_L4:
        try
        {
            a.finish();
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            Toast.makeText(a, SinaAuthroizeActivity.b(a).getString(0x7f060259), 1).show();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (s.startsWith("wantu://SinaCallBackActivity"))
        {
            SinaAuthroizeActivity.a(a, new ProgressDialog(a));
            SinaAuthroizeActivity.a(a).requestWindowFeature(1);
            SinaAuthroizeActivity.a(a).setMessage(SinaAuthroizeActivity.b(a).getString(0x7f06025b));
            SinaAuthroizeActivity.a(a).show();
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Toast.makeText(a, SinaAuthroizeActivity.b(a).getString(0x7f060259), 1).show();
        a.finish();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return true;
    }
}
