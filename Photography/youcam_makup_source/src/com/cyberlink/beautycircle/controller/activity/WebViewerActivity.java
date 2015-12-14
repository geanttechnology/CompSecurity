// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.BiDirectionSwipeRefreshLayout;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            y, w, x, DeepLinkActivity

public class WebViewerActivity extends BaseFbActivity
{

    public static final UUID e = UUID.randomUUID();
    public static final List p = Arrays.asList(y);
    public static final List q = Arrays.asList(z);
    public static Uri r = null;
    private static final String y[] = {
        "ybc", "ycpbc", "ymkbc", "ycnbc"
    };
    private static final String z[] = {
        "market", "ybc", "ycp", "ymk", "ycn", "ycpbc", "ymkbc", "ycnbc"
    };
    private y A;
    private String B;
    private ValueCallback C;
    private String D;
    private boolean E;
    private FrameLayout F;
    private View G;
    private ViewGroup H;
    private android.webkit.WebChromeClient.CustomViewCallback I;
    private Boolean J;
    private android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener K;
    protected WebView f;
    protected ProgressBar g;
    CookieManager o;
    protected String s;
    TopBarFragment t;
    public BiDirectionSwipeRefreshLayout u;
    public boolean v;
    protected WebChromeClient w;
    protected WebViewClient x;

    public WebViewerActivity()
    {
        f = null;
        g = null;
        o = CookieManager.getInstance();
        A = new y(this);
        B = null;
        C = null;
        D = null;
        E = false;
        G = null;
        H = null;
        J = Boolean.valueOf(false);
        v = false;
        K = new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final WebViewerActivity a;

            public void onRefresh()
            {
                if (a.f != null)
                {
                    a.f.reload();
                }
                if (a.u != null)
                {
                    a.u.setRefreshing(false);
                }
            }

            
            {
                a = WebViewerActivity.this;
                super();
            }
        };
        w = new w(this);
        x = new WebViewClient() {

            final WebViewerActivity a;

            public void onPageFinished(WebView webview, String s1)
            {
                a.g.setVisibility(8);
                a.f(s1);
                if (a.v && a.f != null)
                {
                    a.v = false;
                    a.f.clearHistory();
                }
            }

            public void onPageStarted(WebView webview, String s1, Bitmap bitmap)
            {
                a.s = s1;
                if ((WebViewerActivity.f(a).a == 1 || WebViewerActivity.f(a).a == 2) && a.t != null)
                {
                    a.t.a(s1);
                }
                WebViewerActivity.a(a, s1);
                if (a.g != null)
                {
                    a.g.setVisibility(0);
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s1)
            {
                DeepLinkActivity.f(s1);
                if (a.a(webview, s1))
                {
                    return true;
                }
                String s2;
                Uri uri;
                Uri uri1;
                String s3;
                String s4;
                String s5;
                String s6;
                try
                {
                    uri = Uri.parse(s1);
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    return true;
                }
                if (s1 != null && s1.startsWith("http://www.perfectcorp.com/ybc/twitter/callback"))
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        s1
                    });
                    webview = Uri.parse(s1).getQueryParameter("oauth_verifier");
                    s1 = new Intent();
                    s1.putExtra("OauthVerifier", webview);
                    a.setResult(-1, s1);
                    a.finish();
                    return true;
                }
                s3 = uri.getHost();
                s4 = uri.getScheme();
                s5 = a.getResources().getString(m.bc_scheme);
                s6 = a.getResources().getString(m.bc_appscheme);
                uri1 = uri;
                s2 = s1;
                if (s4 != null)
                {
                    uri1 = uri;
                    s2 = s1;
                    if (!s4.equals(s6))
                    {
                        uri1 = uri;
                        s2 = s1;
                        if (WebViewerActivity.p.contains(s4))
                        {
                            s2 = s1.replaceFirst(s4, s6);
                            try
                            {
                                uri1 = Uri.parse(s2);
                            }
                            // Misplaced declaration of an exception variable
                            catch (WebView webview)
                            {
                                return true;
                            }
                        }
                    }
                }
                if (s3 != null && s4 != null && (s4.equals(s5) || s4.equals(s6)))
                {
                    if (s3.equals(a.getResources().getString(m.bc_host_pick_photo)))
                    {
                        WebViewerActivity.a(a, Boolean.valueOf(true));
                        DialogUtils.a(a, null, 48138);
                        return true;
                    } else
                    {
                        com.cyberlink.beautycircle.c.a(a, uri1);
                        return true;
                    }
                }
                if (WebViewerActivity.q.contains(s4))
                {
                    return com.cyberlink.beautycircle.c.a(a, uri1);
                }
                if (s4.equals("mailto"))
                {
                    com.cyberlink.beautycircle.c.b(a, s2);
                    return true;
                } else
                {
                    return super.shouldOverrideUrlLoading(webview, s2);
                }
            }

            
            {
                a = WebViewerActivity.this;
                super();
            }
        };
    }

    static View a(WebViewerActivity webvieweractivity)
    {
        return webvieweractivity.G;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(WebViewerActivity webvieweractivity, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        webvieweractivity.I = customviewcallback;
        return customviewcallback;
    }

    static FrameLayout a(WebViewerActivity webvieweractivity, FrameLayout framelayout)
    {
        webvieweractivity.F = framelayout;
        return framelayout;
    }

    static Boolean a(WebViewerActivity webvieweractivity, Boolean boolean1)
    {
        webvieweractivity.J = boolean1;
        return boolean1;
    }

    static String a(WebViewerActivity webvieweractivity, String s1)
    {
        webvieweractivity.B = s1;
        return s1;
    }

    private void a(Uri uri)
    {
        k();
        uri = ImageUtils.a(Globals.n(), uri);
        if (uri == null || uri.getWidth() < 160 || uri.getHeight() < 160)
        {
            Globals.b("The bitmap is invalid");
            l();
            return;
        }
        uri = NetworkFile.a(uri, com.perfectcorp.utility.ImageUtils.CompressSetting.PostPhoto);
        if (uri == null)
        {
            Globals.b("Upload file is null");
            l();
            return;
        } else
        {
            NetworkFile.a(AccountManager.b(), com.cyberlink.beautycircle.model.network.NetworkFile.FileType.Photo, ((h) (uri)).e, ((h) (uri)).c, ((h) (uri)).f.toString(), ((h) (uri)).a).a(new com.perfectcorp.utility.m(uri) {

                final h a;
                final WebViewerActivity b;

                protected void a(int i)
                {
                    b.l();
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult uploadfileresult)
                {
                    if (android.os.Build.VERSION.SDK_INT >= 19)
                    {
                        b.f.evaluateJavascript((new StringBuilder()).append("document.getElementById('fileId').value = '").append(uploadfileresult.fileId).append("'").toString(), null);
                        b.f.evaluateJavascript((new StringBuilder()).append("document.getElementById('metadata').value = '").append(a.f.toString()).append("'").toString(), null);
                    } else
                    {
                        b.f.loadUrl((new StringBuilder()).append("javascript:document.getElementById('fileId').value = '").append(uploadfileresult.fileId).append("'").toString());
                        b.f.loadUrl((new StringBuilder()).append("javascript:document.getElementById('metadata').value = '").append(a.f.toString()).append("'").toString());
                    }
                    b.l();
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)obj);
                }

            
            {
                b = WebViewerActivity.this;
                a = h1;
                super();
            }
            });
            return;
        }
    }

    static boolean a(WebViewerActivity webvieweractivity, boolean flag)
    {
        webvieweractivity.E = flag;
        return flag;
    }

    static FrameLayout b(WebViewerActivity webvieweractivity)
    {
        return webvieweractivity.F;
    }

    static ViewGroup c(WebViewerActivity webvieweractivity)
    {
        return webvieweractivity.H;
    }

    static boolean d(WebViewerActivity webvieweractivity)
    {
        return webvieweractivity.E;
    }

    static android.webkit.WebChromeClient.CustomViewCallback e(WebViewerActivity webvieweractivity)
    {
        return webvieweractivity.I;
    }

    static y f(WebViewerActivity webvieweractivity)
    {
        return webvieweractivity.A;
    }

    private void o()
    {
        if ((A.a == 1 || A.a == 2) && t != null)
        {
            t.a(s);
        }
        G = findViewById(com.cyberlink.beautycircle.j.nonVideoLayout);
        H = (ViewGroup)findViewById(com.cyberlink.beautycircle.j.videoLayout);
        f = (WebView)findViewById(com.cyberlink.beautycircle.j.web_view);
        if (f != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 19 && Globals.n().p())
            {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            f.setWebChromeClient(w);
            f.setWebViewClient(x);
            if (A.e)
            {
                f.getSettings().setJavaScriptEnabled(true);
                f.addJavascriptInterface(new com.cyberlink.beautycircle.controller.activity.x(this), "_WebView");
            }
            if (A.d)
            {
                f.getSettings().setUseWideViewPort(true);
            }
            f.getSettings().setLoadWithOverviewMode(true);
            if (A.b)
            {
                f.getSettings().setBuiltInZoomControls(true);
                f.getSettings().setSupportZoom(true);
            }
            f.getSettings().setAppCacheEnabled(true);
            f.getSettings().setAllowFileAccess(true);
            f.getSettings().setAllowContentAccess(true);
            f.getSettings().setDomStorageEnabled(true);
            CookieSyncManager.createInstance(this);
            o.setAcceptCookie(true);
            o.acceptCookie();
            CookieSyncManager.getInstance().startSync();
            c(s);
        }
        B = s;
        g = (ProgressBar)findViewById(com.cyberlink.beautycircle.j.progress_bar);
        u = (BiDirectionSwipeRefreshLayout)findViewById(com.cyberlink.beautycircle.j.bc_pull_to_refresh_layout);
        if (u != null && A.c)
        {
            u.setColorSchemeResources(new int[] {
                g.bc_color_main_style, g.bc_color_main_style, g.bc_color_main_style, g.bc_color_main_style
            });
            u.setOnRefreshListener(K);
            u.setOnLoadNextListener(null);
        }
    }

    private void p()
    {
        if (f != null)
        {
            f.stopLoading();
            f.loadUrl("");
            f.reload();
            f = null;
        }
    }

    public void a(y y1)
    {
        A = y1;
    }

    protected boolean a(WebView webview, String s1)
    {
        return false;
    }

    public void b(boolean flag)
    {
        FragmentManager fragmentmanager;
label0:
        {
            fragmentmanager = getFragmentManager();
            if (fragmentmanager != null && t != null && f != null)
            {
                if (!flag)
                {
                    break label0;
                }
                fragmentmanager.beginTransaction().hide(t).commitAllowingStateLoss();
            }
            return;
        }
        fragmentmanager.beginTransaction().show(t).commitAllowingStateLoss();
    }

    public void c(String s1)
    {
        if (s1 != null && s1.length() > 0)
        {
            String s2 = s1;
            if (Uri.parse(s1).getScheme() == null)
            {
                s2 = (new StringBuilder()).append("http://").append(s1).toString();
            }
            if (f != null)
            {
                f.loadUrl(s2);
                DeepLinkActivity.f(s2);
            }
        }
    }

    public void c(boolean flag)
    {
        if (flag)
        {
            android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
            layoutparams.flags = layoutparams.flags | 0x400;
            layoutparams.flags = layoutparams.flags | 0x80;
            getWindow().setAttributes(layoutparams);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                getWindow().getDecorView().setSystemUiVisibility(1);
            }
            if (t != null)
            {
                getFragmentManager().beginTransaction().hide(t).commit();
            }
        } else
        {
            android.view.WindowManager.LayoutParams layoutparams1 = getWindow().getAttributes();
            layoutparams1.flags = layoutparams1.flags & 0xfffffbff;
            layoutparams1.flags = layoutparams1.flags & 0xffffff7f;
            getWindow().setAttributes(layoutparams1);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (t != null)
            {
                getFragmentManager().beginTransaction().show(t).commit();
                return;
            }
        }
    }

    protected boolean e()
    {
        if (E)
        {
            if (w != null)
            {
                w.onHideCustomView();
            }
        } else
        if (A.f && f != null && f.canGoBack())
        {
            f.goBack();
        } else
        {
            super.e();
        }
        return true;
    }

    protected boolean f(String s1)
    {
        return false;
    }

    protected void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        if (i != 48138) goto _L2; else goto _L1
_L1:
        if (intent != null && l == -1) goto _L4; else goto _L3
_L3:
        if (C != null)
        {
            C.onReceiveValue(null);
            C = null;
        }
_L6:
        return;
_L4:
        intent = intent.getData();
        com.perfectcorp.utility.e.b(new Object[] {
            "[PickFromGallery]", intent
        });
        String s1 = com.perfectcorp.utility.h.a(this, intent, true);
        r = Uri.parse((new StringBuilder()).append("file://").append(s1).toString());
        if (J.booleanValue())
        {
            a(intent);
            J = Boolean.valueOf(false);
            return;
        }
        if (C != null)
        {
            C.onReceiveValue(intent);
            C = null;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i != 48139)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (C != null)
        {
            C.onReceiveValue(null);
            C = null;
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
        MediaScannerConnection.scanFile(this, new String[] {
            D.toString()
        }, null, null);
        intent = Uri.fromFile(new File(D));
        com.perfectcorp.utility.e.b(new Object[] {
            "[PickFromCamera]", intent
        });
        if (J.booleanValue())
        {
            a(intent);
            J = Boolean.valueOf(false);
            return;
        }
        if (C != null)
        {
            C.onReceiveValue(intent);
            C = null;
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (i != 48158) goto _L6; else goto _L7
_L7:
        if (intent != null && l == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (C != null)
        {
            C.onReceiveValue(null);
            C = null;
            return;
        }
        if (true) goto _L6; else goto _L8
_L8:
        intent = intent.getData();
        com.perfectcorp.utility.e.b(new Object[] {
            "[ChooseFile]", intent
        });
        if (C != null)
        {
            C.onReceiveValue(intent);
            C = null;
            return;
        }
        if (true) goto _L6; else goto _L9
_L9:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_web_viewer);
        if (A.a == 0)
        {
            A.a = getIntent().getIntExtra("BrowserMode", 2);
        }
        t = b();
        if (t != null)
        {
            int i = getIntent().getIntExtra("TopBarStyle", 0);
            if (i != 0)
            {
                t.a(i);
            }
            b(m.bc_post_info_title);
            if (A.a == 1)
            {
                t.a();
                t.a(false);
            } else
            if (A.a == 2)
            {
                t.a(0xc8000000, x.a, x.m, 0);
                t.a(true);
            } else
            {
                t.a();
            }
        }
        s = getIntent().getStringExtra("RedirectUrl");
        o();
    }

    public void onDestroy()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        p();
        super.onDestroy();
    }

    protected void onPause()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        super.onPause();
        if (f != null)
        {
            f.onPause();
        }
        CookieSyncManager.getInstance().sync();
    }

    protected void onResume()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        super.onResume();
        if (f != null)
        {
            f.onResume();
        }
        CookieSyncManager.getInstance().stopSync();
    }

    public void onRightBtnClick(View view)
    {
        if (B != null)
        {
            com.cyberlink.beautycircle.c.a(this, B, null);
        }
    }

}
