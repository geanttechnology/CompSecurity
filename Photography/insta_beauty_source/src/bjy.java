// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.Toast;
import com.wantu.activity.weibo.SinaAuthroizeActivity;
import com.wantu.weibo.other.sina.WeiboException;

public class bjy extends AsyncTask
{

    final SinaAuthroizeActivity a;

    public bjy(SinaAuthroizeActivity sinaauthroizeactivity)
    {
        a = sinaauthroizeactivity;
        super();
    }

    protected transient String a(String as[])
    {
        try
        {
            as = brt.a();
            as.a("1970943938", "96b30ffeffd7c387e7744a2608dfb524");
            as = as.a(a, brt.b(), brt.c(), "wantu://SinaCallBackActivity");
            as = (new StringBuilder()).append(brt.c).append("?").append("oauth_token=").append(as.a()).append("&oauth_callback=").append("wantu://SinaCallBackActivity").toString();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            return null;
        }
        return as;
    }

    protected void a(String s)
    {
        if (s != null)
        {
            SinaAuthroizeActivity.d(a).setWebViewClient(new bjz(a));
            SinaAuthroizeActivity.d(a).loadUrl(s);
            return;
        }
        if (SinaAuthroizeActivity.a(a) != null)
        {
            SinaAuthroizeActivity.a(a).dismiss();
            SinaAuthroizeActivity.a(a, null);
        }
        Toast.makeText(a, SinaAuthroizeActivity.b(a).getString(0x7f060259), 1).show();
        a.finish();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled()
    {
        if (SinaAuthroizeActivity.a(a) != null)
        {
            SinaAuthroizeActivity.a(a).cancel();
            SinaAuthroizeActivity.a(a, null);
        }
        super.onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }
}
