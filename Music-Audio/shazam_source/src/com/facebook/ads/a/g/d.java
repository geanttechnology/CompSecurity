// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.a.a.a;
import com.facebook.ads.a.b.q;
import com.facebook.ads.a.b.r;
import com.facebook.ads.a.f.b;
import com.facebook.ads.a.f.c;
import com.facebook.ads.a.f.e;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.h;
import java.util.Collections;

// Referenced classes of package com.facebook.ads.a.g:
//            f, a

public class d
    implements f
{

    private static final String a = com/facebook/ads/a/g/d.getSimpleName();
    private f.a b;
    private com.facebook.ads.a.g.a c;
    private q d;
    private r e;
    private long f;
    private long g;
    private com.facebook.ads.a.f.b.a h;

    public d(InterstitialAdActivity interstitialadactivity, f.a a1)
    {
        b = a1;
        f = System.currentTimeMillis();
        c = new com.facebook.ads.a.g.a(interstitialadactivity, new a.a(interstitialadactivity) {

            final InterstitialAdActivity a;
            final d b;

            public final void a()
            {
                com.facebook.ads.a.g.d.b(b).a();
            }

            public final void a(int i)
            {
            }

            public final void a(String s)
            {
                s = Uri.parse(s);
                if ("fbad".equals(s.getScheme()) && "close".equals(s.getAuthority()))
                {
                    a.finish();
                } else
                {
                    com.facebook.ads.a.g.d.a(b).a("com.facebook.ads.interstitial.clicked");
                    s = com.facebook.ads.a.a.b.a(a, s);
                    if (s != null)
                    {
                        try
                        {
                            com.facebook.ads.a.g.d.a(b, s.a());
                            com.facebook.ads.a.g.d.a(b, System.currentTimeMillis());
                            s.b();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            Log.e(d.d(), "Error executing action", s);
                        }
                        return;
                    }
                }
            }

            
            {
                b = d.this;
                a = interstitialadactivity;
                super();
            }
        }, 1);
        c.setId(0x186a1);
        c.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        e = new r(interstitialadactivity, c, new com.facebook.ads.a.b.h() {

            final d a;

            public final void b()
            {
                com.facebook.ads.a.g.d.a(a).a("com.facebook.ads.interstitial.impression.logged");
            }

            
            {
                a = d.this;
                super();
            }
        });
        e.a(Collections.singletonMap("evt", "interstitial_displayed"));
        a1.a(c);
    }

    static long a(d d1, long l)
    {
        d1.g = l;
        return l;
    }

    static com.facebook.ads.a.f.b.a a(d d1, com.facebook.ads.a.f.b.a a1)
    {
        d1.h = a1;
        return a1;
    }

    static f.a a(d d1)
    {
        return d1.b;
    }

    static r b(d d1)
    {
        return d1.e;
    }

    static String d()
    {
        return a;
    }

    public final void a()
    {
        if (c != null)
        {
            c.onPause();
        }
    }

    public final void a(Intent intent, Bundle bundle)
    {
        if (bundle != null && bundle.containsKey("dataModel"))
        {
            intent = bundle.getBundle("dataModel");
            bundle = intent.getString("markup");
            String s = intent.getString("native_impression_report_url");
            String s2 = intent.getString("request_id");
            int i = intent.getInt("viewability_check_initial_delay");
            int k = intent.getInt("viewability_check_interval");
            d = new q(bundle, null, s, e.a, "", null, null, s2, i, k);
            if (d != null)
            {
                c.loadDataWithBaseURL(com.facebook.ads.a.f.h.a(), d.a, "text/html", "utf-8", null);
                c.a(d.f, d.g);
            }
        } else
        {
            bundle = com.facebook.ads.a.f.g.a(intent.getByteArrayExtra("markup"));
            String s1 = intent.getStringExtra("activation_command");
            String s3 = intent.getStringExtra("native_impression_report_url");
            String s4 = intent.getStringExtra("request_id");
            int j = intent.getIntExtra("viewability_check_initial_delay", 0);
            int l = intent.getIntExtra("viewability_check_interval", 1000);
            d = new q(bundle, s1, s3, e.a, "", null, null, s4, j, l);
            if (d != null)
            {
                e.b = d;
                c.loadDataWithBaseURL(com.facebook.ads.a.f.h.a(), d.a, "text/html", "utf-8", null);
                c.a(d.f, d.g);
                return;
            }
        }
    }

    public final void a(Bundle bundle)
    {
        if (d != null)
        {
            q q1 = d;
            Bundle bundle1 = new Bundle();
            bundle1.putString("markup", q1.a);
            bundle1.putString("native_impression_report_url", q1.c);
            bundle1.putString("request_id", q1.e);
            bundle1.putInt("viewability_check_initial_delay", q1.f);
            bundle1.putInt("viewability_check_interval", q1.g);
            bundle.putBundle("dataModel", bundle1);
        }
    }

    public final void b()
    {
        if (g > 0L && h != null && d != null)
        {
            com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(g, h, d.e));
        }
        if (c != null)
        {
            c.onResume();
        }
    }

    public final void c()
    {
        if (d != null)
        {
            com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(f, com.facebook.ads.a.f.b.a.c, d.e));
        }
        if (c != null)
        {
            com.facebook.ads.a.f.h.a(c);
            c.destroy();
            c = null;
        }
    }

}
