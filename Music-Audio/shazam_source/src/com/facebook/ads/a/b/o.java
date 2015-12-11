// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.a.e;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.a.f.f;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.h;
import com.facebook.ads.b;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a.b:
//            d, q, e, i

public final class o extends d
{

    private final String a = UUID.randomUUID().toString();
    private Context b;
    private boolean c;
    private int d;
    private int e;
    private boolean f;
    private i g;
    private com.facebook.ads.a.b.e h;
    private boolean i;
    private q j;
    private WebView k;

    public o()
    {
        i = false;
    }

    static com.facebook.ads.a.b.e a(o o1)
    {
        return o1.h;
    }

    public final void a(Context context, com.facebook.ads.a.b.e e1, Map map)
    {
        b = context;
        h = e1;
        j = q.a((JSONObject)map.get("data"));
        if (!com.facebook.ads.a.f.f.a(context, j)) goto _L2; else goto _L1
_L1:
        context = b.b;
        e1.b(this);
_L4:
        return;
_L2:
        g = new i(context, a, this, h);
        context = g;
        e1 = new IntentFilter();
        e1.addAction((new StringBuilder("com.facebook.ads.interstitial.impression.logged:")).append(((i) (context)).a).toString());
        e1.addAction((new StringBuilder("com.facebook.ads.interstitial.displayed:")).append(((i) (context)).a).toString());
        e1.addAction((new StringBuilder("com.facebook.ads.interstitial.dismissed:")).append(((i) (context)).a).toString());
        e1.addAction((new StringBuilder("com.facebook.ads.interstitial.clicked:")).append(((i) (context)).a).toString());
        e1.addAction((new StringBuilder("com.facebook.ads.interstitial.error:")).append(((i) (context)).a).toString());
        android.support.v4.a.e.a(((i) (context)).b).a(context, e1);
        i = true;
        context = j.d;
        if (context.containsKey("is_tablet"))
        {
            c = Boolean.parseBoolean((String)context.get("is_tablet"));
        }
        if (context.containsKey("ad_height"))
        {
            d = Integer.parseInt((String)context.get("ad_height"));
        }
        if (context.containsKey("ad_width"))
        {
            e = Integer.parseInt((String)context.get("ad_width"));
        }
        if (context.containsKey("native_close"))
        {
            f = Boolean.valueOf((String)context.get("native_close")).booleanValue();
        }
        if (!context.containsKey("preloadMarkup") || !Boolean.parseBoolean((String)context.get("preloadMarkup")))
        {
            continue; /* Loop/switch isn't completed */
        }
        context = j;
        if (context == null) goto _L4; else goto _L3
_L3:
        k = new WebView(b.getApplicationContext());
        k.setWebChromeClient(new WebChromeClient() {

            final o a;

            public final void onProgressChanged(WebView webview, int l)
            {
                if (l == 100 && o.a(a) != null)
                {
                    o.a(a).a(a);
                }
            }

            
            {
                a = o.this;
                super();
            }
        });
        k.loadDataWithBaseURL(com.facebook.ads.a.f.h.a(), ((q) (context)).a, "text/html", "utf-8", null);
        return;
        if (h == null) goto _L4; else goto _L5
_L5:
        h.a(this);
        return;
    }

    public final void b()
    {
        if (g != null)
        {
            i l = g;
            try
            {
                android.support.v4.a.e.a(l.b).a(l);
            }
            catch (Exception exception) { }
        }
        if (k != null)
        {
            com.facebook.ads.a.f.h.a(k);
            k.destroy();
            k = null;
        }
    }

    public final boolean c()
    {
        if (!i)
        {
            if (h != null)
            {
                com.facebook.ads.a.b.e e1 = h;
                b b1 = b.e;
                e1.b(this);
            }
            return false;
        } else
        {
            Intent intent = new Intent(b, com/facebook/ads/InterstitialAdActivity);
            Object obj = j;
            intent.putExtra("markup", com.facebook.ads.a.f.g.a(((q) (obj)).a));
            intent.putExtra("activation_command", ((q) (obj)).b);
            intent.putExtra("native_impression_report_url", ((q) (obj)).c);
            intent.putExtra("request_id", ((q) (obj)).e);
            intent.putExtra("viewability_check_initial_delay", ((q) (obj)).f);
            intent.putExtra("viewability_check_interval", ((q) (obj)).g);
            obj = ((WindowManager)b.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((Display) (obj)).getMetrics(displaymetrics);
            intent.putExtra("displayRotation", ((Display) (obj)).getRotation());
            intent.putExtra("displayWidth", displaymetrics.widthPixels);
            intent.putExtra("displayHeight", displaymetrics.heightPixels);
            intent.putExtra("isTablet", c);
            intent.putExtra("adHeight", d);
            intent.putExtra("adWidth", e);
            intent.putExtra("adInterstitialUniqueId", a);
            intent.putExtra("useNativeCloseButton", f);
            intent.putExtra("viewType", com.facebook.ads.InterstitialAdActivity.a.a);
            intent.addFlags(0x10000000);
            b.startActivity(intent);
            return true;
        }
    }
}
