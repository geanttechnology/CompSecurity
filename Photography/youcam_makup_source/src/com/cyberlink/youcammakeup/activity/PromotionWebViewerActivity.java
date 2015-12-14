// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKPageViewADFromLauncherBannerEvent;
import com.cyberlink.youcammakeup.clflurry.YMKPromotionEvent;
import com.cyberlink.youcammakeup.kernelctrl.a.a.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ab;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ac;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ad;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ae;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.utility.a;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;
import com.cyberlink.youcammakeup.widgetpool.dialogs.x;
import com.perfectcorp.utility.u;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            WebViewerExActivity

public class PromotionWebViewerActivity extends WebViewerExActivity
{

    private String A;
    private final r B = new r() {

        final PromotionWebViewerActivity a;

        public void a()
        {
            View view = a.findViewById(0x7f0c01fd);
            if (view != null)
            {
                view.performClick();
            }
        }

            
            {
                a = PromotionWebViewerActivity.this;
                super();
            }
    };
    private Map z;

    public PromotionWebViewerActivity()
    {
        z = new HashMap();
        A = "";
    }

    static r a(PromotionWebViewerActivity promotionwebvieweractivity)
    {
        return promotionwebvieweractivity.B;
    }

    static Map b(PromotionWebViewerActivity promotionwebvieweractivity)
    {
        return promotionwebvieweractivity.z;
    }

    static WebView c(PromotionWebViewerActivity promotionwebvieweractivity)
    {
        return promotionwebvieweractivity.f;
    }

    static WebView d(PromotionWebViewerActivity promotionwebvieweractivity)
    {
        return promotionwebvieweractivity.f;
    }

    private void g(String s)
    {
        String s1 = (String)z.get(s);
        if (s1 != null)
        {
            s = new u(s1);
            s.a("HideTopBar", "true");
            f.loadUrl(s.c());
            return;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(s);
            A = s;
            NetworkManager networkmanager = Globals.d().w();
            networkmanager.a(new ad(networkmanager, arraylist, new ae(s) {

                final String a;
                final PromotionWebViewerActivity b;

                public void a(ab ab1)
                {
                    String s2 = ab1.a(a).c.toString();
                    if (s2.equals("http://none"))
                    {
                        b.runOnUiThread(new Runnable(this) {

                            final _cls2 a;

                            public void run()
                            {
                                Globals.d().i().a(com.cyberlink.youcammakeup.activity.PromotionWebViewerActivity.a(a.b));
                                Globals.d().i().a(a.b, x.a, a.b.getString(0x7f07051d).toString(), false);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        return;
                    } else
                    {
                        com.cyberlink.youcammakeup.activity.PromotionWebViewerActivity.b(b).put(a, s2);
                        b.runOnUiThread(new Runnable(this, ab1) {

                            final ab a;
                            final _cls2 b;

                            public void run()
                            {
                                String s = Uri.parse(a.a(b.a).c.toString()).buildUpon().appendQueryParameter("HideTopBar", "true").build().toString();
                                if (PromotionWebViewerActivity.c(b.b) != null)
                                {
                                    PromotionWebViewerActivity.d(b.b).loadUrl(s);
                                }
                            }

            
            {
                b = _pcls2;
                a = ab1;
                super();
            }
                        });
                        return;
                    }
                }

                public void a(bn bn1)
                {
                    Globals.d().i().a(b, x.a, bn1.toString(), false);
                }

                public volatile void a(Object obj)
                {
                    a((ab)obj);
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj)
                {
                    a((bn)obj);
                }

                public void c(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                b = PromotionWebViewerActivity.this;
                a = s;
                super();
            }
            }));
            return;
        }
    }

    private void h(String s)
    {
        com.cyberlink.youcammakeup.kernelctrl.a.a.b.a("PromotionWebViewerActivity", (new StringBuilder()).append("ActionURL: ").append(s).toString());
        g(com.cyberlink.youcammakeup.utility.a.d(s));
    }

    protected boolean a(WebView webview, String s)
    {
        if (com.cyberlink.youcammakeup.utility.a.b(s))
        {
            h(s);
            return true;
        } else
        {
            return super.a(webview, s);
        }
    }

    protected void o()
    {
        Intent intent = getIntent();
        String s = intent.getStringExtra("PromotionPageID");
        String s1 = intent.getStringExtra("SourceType");
        String s2 = intent.getStringExtra("SourceId");
        String s3 = intent.getStringExtra("SkuGuid");
        String s4 = intent.getStringExtra("SkuItemGuid");
        intent.putExtra("PromotionPageID", s);
        intent.putExtra("SourceType", s1);
        intent.putExtra("SourceId", s2);
        intent.putExtra("SkuGuid", s3);
        intent.putExtra("SkuItemGuid", s4);
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKPromotionEvent(com.cyberlink.youcammakeup.clflurry.YMKPromotionEvent.Operation.a.a(), s3, s, s1));
        if (s != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.a.a.b.a("PromotionWebViewerActivity", (new StringBuilder()).append("PageID: ").append(s).toString());
            g(s);
        } else
        {
            Uri uri = getIntent().getData();
            if (uri != null)
            {
                h(uri.toString());
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        o();
        super.onCreate(bundle);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        com.cyberlink.youcammakeup.kernelctrl.a.a.b.a("PromotionWebViewerActivity", "onNewIntent enter");
        o();
    }

    protected void onResume()
    {
        super.onResume();
        if (A != null && !A.isEmpty())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKPageViewADFromLauncherBannerEvent(com.cyberlink.youcammakeup.clflurry.YMKPageViewADFromLauncherBannerEvent.BannerType.b, A));
        }
        Globals.d().c(null);
    }
}
