// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoCustomReport;
import java.util.Locale;
import yn;

public class FWebViewActivity extends FragmentActivity
{

    WebView a;

    public FWebViewActivity()
    {
    }

    private String a()
    {
        String s = getApplicationContext().getPackageName();
        String s1 = yn.a(((WifiManager)getSystemService("wifi")).getConnectionInfo().getMacAddress());
        String s2 = Locale.getDefault().getLanguage();
        String s3 = Locale.getDefault().getLanguage();
        String s4 = Locale.getDefault().getCountry();
        String s5 = Build.MODEL;
        String s6 = android.os.Build.VERSION.RELEASE;
        Object obj;
        try
        {
            obj = getPackageManager().getPackageInfo(getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
            obj = null;
        }
        if (obj != null)
        {
            obj = ((PackageInfo) (obj)).versionName;
        } else
        {
            obj = null;
        }
        return String.format("osver=%s&appid=%s&appver=%s&countrycode=%s&langcode=%s&prelang=%s&aduuid=%s&devicetype=%s", new Object[] {
            s6, s, obj, s4, s2, s3, s1, s5
        });
    }

    public void OnBtnBackClicked(View view)
    {
        finish();
        FlurryAgent.logEvent("BtnBackClicked");
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030040);
        a = (WebView)findViewById(0x7f0c012f);
        a.getSettings().setJavaScriptEnabled(true);
        a.getSettings().setSupportZoom(true);
        a.getSettings().setBuiltInZoomControls(true);
        a.setWebViewClient(new WebViewClient() {

            final FWebViewActivity a;

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                webview.loadUrl(s);
                return true;
            }

            
            {
                a = FWebViewActivity.this;
                super();
            }
        });
        bundle = String.format("%s?%s&fotouuid=%s&token=%s&xgtoken=%s", new Object[] {
            "http://ads.fotoable.com/home/FeedMsg/", a(), FotoCustomReport.getFOTOUUID(this), FotoCustomReport.googleToken, FotoCustomReport.xgToken
        });
        a.loadUrl(bundle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && a.canGoBack())
        {
            a.goBack();
            return true;
        }
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
        }
        return super.onKeyDown(i, keyevent);
    }

    protected void onPause()
    {
        super.onPause();
    }

    public void startActivityForResult(Intent intent, int i)
    {
        super.startActivityForResult(intent, i);
    }
}
