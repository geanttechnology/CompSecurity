// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.picsart.studio.profile.ProfileActivity;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import java.io.File;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            GalleryItemShowActivity, r

public class WebViewActivity extends BaseActivity
{

    private WebView a;
    private AudioManager b;

    public WebViewActivity()
    {
    }

    static WebView a(WebViewActivity webviewactivity)
    {
        return webviewactivity.a;
    }

    static void a(WebViewActivity webviewactivity, long l)
    {
        Intent intent = new Intent(webviewactivity, com/socialin/android/picsart/profile/activity/GalleryItemShowActivity);
        intent.putExtra("item_id", l);
        c.a(intent, webviewactivity);
        webviewactivity.startActivity(intent);
    }

    static void b(WebViewActivity webviewactivity, long l)
    {
        Intent intent = new Intent(webviewactivity, com/picsart/studio/profile/ProfileActivity);
        intent.putExtra("profileUserId", l);
        c.a(intent, webviewactivity);
        webviewactivity.startActivity(intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03026a);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        }
        if (getIntent() != null && getIntent().hasExtra("url"))
        {
            bundle = getIntent().getStringExtra("url");
        } else
        {
            bundle = null;
        }
        b = (AudioManager)getSystemService("audio");
        a = (WebView)findViewById(0x7f100adc);
        a.getSettings().setJavaScriptEnabled(true);
        a.getSettings().setAllowFileAccess(true);
        a.getSettings().setDomStorageEnabled(true);
        a.getSettings().setAppCachePath(getApplication().getCacheDir().toString());
        a.setFocusable(true);
        a.requestFocus();
        a.setWebViewClient(new r(this, bundle));
        a.setWebChromeClient(new WebChromeClient() {

            private WebViewActivity a;

            public final void onProgressChanged(WebView webview, int i)
            {
                webview = (Activity)WebViewActivity.a(a).getContext();
                webview.setTitle(0x7f0802f5);
                webview.setProgress(i * 100);
                if (i == 100)
                {
                    webview.setTitle(0x7f0808af);
                }
            }

            
            {
                a = WebViewActivity.this;
                super();
            }
        });
        if (SocialinV3.getInstance().isRegistered())
        {
            CookieSyncManager cookiesyncmanager = CookieSyncManager.createInstance(a.getContext());
            CookieManager cookiemanager = CookieManager.getInstance();
            cookiemanager.setAcceptCookie(true);
            cookiemanager.removeAllCookie();
            cookiemanager.setCookie(bundle, (new StringBuilder("key=")).append(SocialinV3.getInstance().getUser().key).toString());
            cookiesyncmanager.sync();
        }
        a.loadUrl(bundle);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() != 0)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (i != 4) goto _L2; else goto _L1
_L1:
        if (a == null || !a.canGoBack()) goto _L4; else goto _L3
_L3:
        a.goBack();
_L6:
        return true;
_L4:
        finish();
        return true;
_L2:
        if (i != 24 && i != 25) goto _L6; else goto _L5
_L5:
        if (i == 24)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        b.setStreamVolume(3, i + b.getStreamVolume(3), 0);
        return true;
        return super.onKeyDown(i, keyevent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return true;
    }

    public void onPause()
    {
        super.onPause();
        if (a != null)
        {
            a.onPause();
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (a != null)
        {
            a.restoreState(bundle);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (a != null)
        {
            a.saveState(bundle);
        }
    }
}
