// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.weibo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.ShareEditActivity;
import tb;
import yd;
import yz;
import zj;
import zl;
import zn;
import zr;

public class QQAuthroizeActivity extends FullscreenActivity
{

    private WebView a;
    private String b;
    private ProgressDialog c;
    private Resources d;
    private zj e;
    private zn f;
    private String g;
    private String h;
    private Button i;
    private int j;

    public QQAuthroizeActivity()
    {
        j = 0;
    }

    public static ProgressDialog a(QQAuthroizeActivity qqauthroizeactivity, ProgressDialog progressdialog)
    {
        qqauthroizeactivity.c = progressdialog;
        return progressdialog;
    }

    static String a(QQAuthroizeActivity qqauthroizeactivity)
    {
        return qqauthroizeactivity.b;
    }

    public static ProgressDialog b(QQAuthroizeActivity qqauthroizeactivity)
    {
        return qqauthroizeactivity.c;
    }

    public static Resources c(QQAuthroizeActivity qqauthroizeactivity)
    {
        return qqauthroizeactivity.d;
    }

    public static WebView d(QQAuthroizeActivity qqauthroizeactivity)
    {
        return qqauthroizeactivity.a;
    }

    public String a()
    {
        j = 0;
        zl.a = zr.a(((WifiManager)getSystemService("wifi")).getConnectionInfo().getIpAddress());
        e = new zj("801279637", "6d65c5d279ab5ab38e7a78b2a6b51ac6", "pipcamera://QQCallBackActivity");
        f = new zn();
        String s;
        try
        {
            e = f.a(e);
            s = e.e();
            s = (new StringBuilder()).append("http://open.t.qq.com/cgi-bin/authorize?oauth_token=").append(s).toString();
            b = s;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return null;
        }
        return s;
    }

    public void a(String s, String s1)
    {
        try
        {
            b(s, s1);
            if (e.g() == 2)
            {
                Toast.makeText(this, d.getString(0x7f0601ab), 1).show();
                finish();
            }
            yz.a(this, true, e.e(), e.f());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Toast.makeText(this, d.getString(0x7f0601ab), 1).show();
            s.printStackTrace();
            Crashlytics.logException(s);
            finish();
            return;
        }
        s = f.c(e);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        (new yd(this, s)).execute(new String[0]);
_L1:
        if (h.compareTo("share") == 0)
        {
            s = new Intent(this, com/pipcamera/activity/ShareEditActivity);
            s.putExtra("com.wantu.android.weibo", "qq");
            startActivity(s);
            finish();
            return;
        }
        break MISSING_BLOCK_LABEL_171;
        s;
        Crashlytics.logException(s);
          goto _L1
        finish();
        return;
    }

    public void b(String s, String s1)
    {
        e.e(s);
        e.c(s1);
        g = zl.a;
        e = f.b(e);
    }

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030079);
        d = getResources();
        h = getIntent().getStringExtra("com.wantu.android.source");
        i = (Button)findViewById(0x7f0c0080);
        i.setVisibility(4);
        ((TextView)findViewById(0x7f0c002d)).setText(d.getString(0x7f0601ac));
        a = (WebView)findViewById(0x7f0c0227);
        a.getSettings().setJavaScriptEnabled(true);
        a.getSettings().setBuiltInZoomControls(true);
        c = new ProgressDialog(this);
        c.requestWindowFeature(1);
        c.setMessage(d.getString(0x7f0601ad));
        c.show();
        (new tb(this)).execute(new String[0]);
    }
}
