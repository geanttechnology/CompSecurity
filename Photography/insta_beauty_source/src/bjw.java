// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.Toast;
import com.wantu.activity.weibo.QQAuthroizeActivity;

public class bjw extends AsyncTask
{

    final QQAuthroizeActivity a;

    public bjw(QQAuthroizeActivity qqauthroizeactivity)
    {
        a = qqauthroizeactivity;
        super();
    }

    protected transient String a(String as[])
    {
        return a.a();
    }

    protected void a(String s)
    {
        if (s != null)
        {
            QQAuthroizeActivity.d(a).setWebViewClient(new bjx(a));
            QQAuthroizeActivity.d(a).loadUrl(s);
            return;
        }
        if (QQAuthroizeActivity.b(a) != null)
        {
            QQAuthroizeActivity.b(a).dismiss();
            QQAuthroizeActivity.a(a, null);
        }
        Toast.makeText(a, QQAuthroizeActivity.c(a).getString(0x7f0601ce), 1).show();
        a.finish();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled()
    {
        if (QQAuthroizeActivity.b(a) != null)
        {
            QQAuthroizeActivity.b(a).cancel();
            QQAuthroizeActivity.a(a, null);
        }
        super.onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }
}
