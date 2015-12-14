// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.cyberlink.beautycircle.controller.activity.WebViewerActivity;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKPageViewADFromLauncherBannerEvent;
import com.cyberlink.youcammakeup.clflurry.YMKPromotionEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.v;
import com.cyberlink.youcammakeup.clflurry.y;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.perfectcorp.utility.g;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

public class WebViewerExActivity extends WebViewerActivity
{

    public static final UUID y = UUID.randomUUID();
    private String A;
    private String B;
    private String C;
    private String D;
    private boolean E;
    private String F;
    private y G;
    private String z;

    public WebViewerExActivity()
    {
        E = false;
        G = null;
    }

    private void g(String s)
    {
        if (G != null && z != null)
        {
            G.e();
            b.a(G.a(A, B, z, C, D));
        }
        try
        {
            s = Uri.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        A = s.getQueryParameter("SourceType");
        B = s.getQueryParameter("SourceId");
        if (G == null)
        {
            G = new y("YMK_PageView_PromotionPage");
        }
        if (z != null)
        {
            G.d();
        }
    }

    private void o()
    {
    }

    protected boolean a(WebView webview, String s)
    {
        String s1;
        Uri uri;
        try
        {
            uri = Uri.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return true;
        }
        s1 = uri.getScheme();
        webview = uri.getHost();
        if (s1 != null && s1.equals(getResources().getString(0x7f070744)) && !com.perfectcorp.utility.g.a(Globals.d().getApplicationContext(), "com.cyberlink.youperfect"))
        {
            com.perfectcorp.utility.g.a(this, Globals.d().getPackageName(), "ymk", "WebViewEx");
            return true;
        }
        if (webview != null && webview.equals(getResources().getString(0x7f0707b9)))
        {
            b.a(new v(A, B, C, D, z, "back"));
            b.a(new YMKPromotionEvent(com.cyberlink.youcammakeup.clflurry.YMKPromotionEvent.Operation.b.a(), C, z, null));
            e();
            return true;
        }
        if (s1 != null && (s1.equals(getResources().getString(0x7f070744)) || s1.equals(getResources().getString(0x7f070742)) || s1.equals(getResources().getString(0x7f070743))))
        {
            g(s);
            if (webview != null && webview.equals(getResources().getString(0x7f0707be)))
            {
                webview = "selectphoto";
            } else
            if (webview != null && webview.equals(getResources().getString(0x7f0707c2)))
            {
                webview = "takephoto";
            } else
            {
                webview = uri.getQueryParameter("Button");
            }
            b.a(new v(A, B, C, D, z, webview));
            b.a(new YMKPromotionEvent(webview, C, z, A));
            webview = new Intent("android.intent.action.VIEW", uri);
            if (s1.equals(getResources().getString(0x7f070743)))
            {
                webview.setPackage(getPackageName());
            }
            startActivity(webview);
            return true;
        }
        boolean flag;
        try
        {
            flag = uri.getBooleanQueryParameter("HideTopBar", false);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return false;
        }
        if (flag)
        {
            E = true;
            b(E);
            return false;
        } else
        {
            E = false;
            b(E);
            return false;
        }
    }

    protected boolean e()
    {
        if (f.canGoBack())
        {
            f.goBack();
        } else
        if (Globals.d(this))
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
            finish();
        } else
        {
            super.e();
            finish();
        }
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj = getIntent();
        if (obj != null)
        {
            z = getIntent().getStringExtra("PromotionPageID");
            A = getIntent().getStringExtra("SourceType");
            B = getIntent().getStringExtra("SourceId");
            C = ((Intent) (obj)).getStringExtra("SkuGuid");
            D = ((Intent) (obj)).getStringExtra("SkuItemGuid");
            E = ((Intent) (obj)).getBooleanExtra("HideTopBar", false);
            F = ((Intent) (obj)).getStringExtra("Title");
        }
        StatusManager.j().a("webViewerExActivity");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.n, this);
        obj = new com.cyberlink.beautycircle.controller.activity.y(this);
        if (F != null)
        {
            obj.a = 1;
        } else
        {
            obj.a = 2;
        }
        a(((com.cyberlink.beautycircle.controller.activity.y) (obj)));
        super.onCreate(bundle);
        b(E);
        if (F != null)
        {
            b().c(F);
            return;
        } else
        {
            b().a(0x80000000, x.a, 0, 0);
            return;
        }
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.n, null);
        o();
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            e();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        v = true;
        super.onNewIntent(intent);
    }

    protected void onPause()
    {
        super.onPause();
        if (G != null && z != null)
        {
            G.e();
            b.a(G.a(A, B, z, C, D));
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (G == null)
        {
            G = new y("YMK_PageView_PromotionPage");
        }
        if (z != null)
        {
            G.d();
        }
        String s = getIntent().getStringExtra("BannerID");
        if (s != null && !s.isEmpty())
        {
            b.a(new YMKPageViewADFromLauncherBannerEvent(com.cyberlink.youcammakeup.clflurry.YMKPageViewADFromLauncherBannerEvent.BannerType.a, s));
        }
        Globals.d().c(null);
    }

}
