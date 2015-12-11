// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.immersion.hapticmediasdk.a;
import com.immersion.hapticmediasdk.c;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            ak, be, bd, m, 
//            aw, s, bo, bp, 
//            bz, o, ca, q, 
//            av, bf, bq, ay, 
//            bl, AdColonyBrowser, bm, ap, 
//            ar, de, ag, ad, 
//            al, z

class au extends View
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
{

    static float ax[] = new float[80];
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    boolean P;
    boolean Q;
    boolean R;
    boolean S;
    Canvas T;
    String U;
    String V;
    String W;
    WebView a;
    float aA;
    float aB;
    float aC;
    float aD;
    float aE;
    Paint aF;
    RectF aG;
    aw aH;
    Handler aI;
    String aa;
    String ab;
    ar ac;
    Paint ad;
    Paint ae;
    Paint af;
    Paint ag;
    Rect ah;
    m ai;
    m aj;
    m ak;
    m al;
    m am;
    m an;
    m ao;
    m ap;
    m aq;
    m ar;
    m as;
    m at[];
    m au[];
    bm av;
    String aw[];
    float ay;
    float az;
    WebView b;
    View c;
    o d;
    double e;
    double f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u;
    long v;
    long w;
    float x;
    boolean y;
    boolean z;

    au(o o1)
    {
        super(o1);
        e = 1.0D;
        f = 1.0D;
        g = 99;
        h = 0;
        y = true;
        z = true;
        A = true;
        B = true;
        C = true;
        D = true;
        U = com.jirbo.adcolony.ak.c.a.b;
        ad = new Paint();
        ae = new Paint(1);
        af = new Paint(1);
        ag = new Paint(1);
        ah = new Rect();
        at = new m[4];
        au = new m[4];
        aw = new String[4];
        aF = new Paint(1);
        aG = new RectF();
        aH = new aw(this);
        aI = new Handler() {

            final au a;

            public void handleMessage(Message message)
            {
                while (a.d.isFinishing() || a.d.B == null) 
                {
                    return;
                }
                a.a(message.what);
            }

            
            {
                a = au.this;
                super();
            }
        };
        d = o1;
        L = com.jirbo.adcolony.ak.c.a.s;
        if (ak.A != null)
        {
            L = L | ak.A.d.u.l.a;
            ak.A.i = ak.A.j;
        }
        x = o1.getResources().getDisplayMetrics().density;
        P = ak.F;
        if (com.jirbo.adcolony.ak.a != null)
        {
            ak.K = com.jirbo.adcolony.ak.a;
        }
        if (ak.A != null && ak.A.d.t.d)
        {
            float f1;
            float f2;
            boolean flag;
            if (!P)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            M = flag;
        }
        if (M)
        {
            ai = new m(com.jirbo.adcolony.ak.g("end_card_filepath"));
            n = ai.f;
            o = ai.g;
            if (n == 0)
            {
                n = 480;
            }
            if (o == 0)
            {
                o = 320;
            }
            at[0] = new m(com.jirbo.adcolony.ak.g("info_image_normal"));
            at[1] = new m(com.jirbo.adcolony.ak.g("download_image_normal"));
            at[2] = new m(com.jirbo.adcolony.ak.g("replay_image_normal"));
            at[3] = new m(com.jirbo.adcolony.ak.g("continue_image_normal"));
            au[0] = new m(com.jirbo.adcolony.ak.g("info_image_down"), true);
            au[1] = new m(com.jirbo.adcolony.ak.g("download_image_down"), true);
            au[2] = new m(com.jirbo.adcolony.ak.g("replay_image_down"), true);
            au[3] = new m(com.jirbo.adcolony.ak.g("continue_image_down"), true);
            aw[0] = "Info";
            aw[1] = "Download";
            aw[2] = "Replay";
            aw[3] = "Continue";
        } else
        if (P)
        {
            an = new m(com.jirbo.adcolony.ak.g("reload_image_normal"));
            al = new m(com.jirbo.adcolony.ak.g("close_image_normal"));
            am = new m(com.jirbo.adcolony.ak.g("close_image_down"));
            ao = new m(com.jirbo.adcolony.ak.g("reload_image_down"));
            ar = new m(com.jirbo.adcolony.ak.g("browser_icon"));
            c = new av(this, o1);
            b();
        }
        if (L)
        {
            aj = new m(com.jirbo.adcolony.ak.g("skip_video_image_normal"));
            ak = new m(com.jirbo.adcolony.ak.g("skip_video_image_down"));
            p = com.jirbo.adcolony.ak.e("skip_delay") * 1000;
        }
        aF.setStyle(android.graphics.Paint.Style.STROKE);
        f2 = 2.0F * o1.getResources().getDisplayMetrics().density;
        f1 = f2;
        if (f2 > 6F)
        {
            f1 = 6F;
        }
        if (f1 >= 4F);
        aF.setStrokeWidth(2.0F * o1.getResources().getDisplayMetrics().density);
        aF.setColor(0xffcccccc);
        Q = false;
        K = false;
        R = false;
        if (ak.A != null)
        {
            K = ak.A.d.u.m.a;
            R = com.jirbo.adcolony.ak.f("image_overlay_enabled");
        }
        if (K)
        {
            ap = new m(com.jirbo.adcolony.ak.g("engagement_image_normal"));
            aq = new m(com.jirbo.adcolony.ak.g("engagement_image_down"));
            aa = ak.A.d.u.m.j;
            V = ak.A.d.u.m.l;
            W = ak.A.d.u.m.o;
            r = ak.A.d.u.m.c;
            q = com.jirbo.adcolony.ak.e("engagement_delay") * 1000;
            if (V.equals(""))
            {
                V = "Learn More";
            }
            if (!W.equals(""))
            {
                G = true;
            }
            if (G)
            {
                b = new WebView(o1);
                b.setBackgroundColor(0);
            }
            if (ap == null || aq == null)
            {
                K = false;
            }
        }
        if (R)
        {
            as = new m(com.jirbo.adcolony.ak.g("image_overlay_filepath"));
            double d1;
            if (com.jirbo.adcolony.q.b())
            {
                d1 = ((double)r * ((double)x / 1.0D)) / (double)as.g;
            } else
            {
                d1 = ((double)r * ((double)x / 0.75D)) / (double)as.g;
            }
            as.a(d1);
        }
        if (o.d)
        {
            d();
        }
        ad.setColor(-1);
        af.setTextSize(24F);
        af.setColor(0xff000000);
        ae.setColor(0xffcccccc);
        ae.setTextSize(20F);
        ae.setTextAlign(android.graphics.Paint.Align.CENTER);
        ag.setTextSize(20F);
        ag.setColor(-1);
        try
        {
            getClass().getMethod("setLayerType", new Class[] {
                Integer.TYPE, android/graphics/Paint
            }).invoke(this, new Object[] {
                Integer.valueOf(1), null
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            return;
        }
    }

    int a(int i1, int j1)
    {
        boolean flag = false;
        int k1;
        if (i1 >= g && i1 < g + 62)
        {
            k1 = 1;
        } else
        {
            if (i1 >= g + 78 && i1 < g + 78 + 62)
            {
                return 2;
            }
            if (i1 >= g + 78 + 78 && i1 < g + 78 + 78 + 62)
            {
                return 3;
            }
            if (i1 >= g + 78 + 78 + 78 && i1 < g + 78 + 78 + 78 + 62)
            {
                return 4;
            }
            k1 = ((flag) ? 1 : 0);
            if (d.B != null)
            {
                k1 = ((flag) ? 1 : 0);
                if (L)
                {
                    k1 = ((flag) ? 1 : 0);
                    if (i1 >= d.B.getWidth() - aj.f)
                    {
                        k1 = ((flag) ? 1 : 0);
                        if (j1 <= aj.g)
                        {
                            return 10;
                        }
                    }
                }
            }
        }
        return k1;
    }

    public void a()
    {
        boolean flag = d.b();
        y = y | flag;
        if (d.B != null)
        {
            if (s <= 0)
            {
                s = d.B.getDuration();
            }
            if (flag)
            {
                setLayoutParams(new android.widget.FrameLayout.LayoutParams(d.s, d.t, 17));
                d.B.setLayoutParams(new android.widget.FrameLayout.LayoutParams(d.u, d.v, 17));
                y = true;
            }
        }
        if (y)
        {
            y = false;
            double d1;
            if (z)
            {
                DisplayMetrics displaymetrics = com.jirbo.adcolony.q.d().getResources().getDisplayMetrics();
                float f1 = (float)displaymetrics.widthPixels / displaymetrics.xdpi;
                float f2 = (float)displaymetrics.heightPixels / displaymetrics.ydpi;
                d1 = Math.sqrt(f1 * f1 + f2 * f2);
                int i1 = displaymetrics.widthPixels;
                int j1 = displaymetrics.widthPixels;
                int k1 = displaymetrics.heightPixels;
                d1 = Math.sqrt(displaymetrics.heightPixels * k1 + i1 * j1) / d1;
                if (d1 / 280D < 0.69999999999999996D)
                {
                    d1 = 0.69999999999999996D;
                } else
                {
                    d1 /= 280D;
                }
                f = d1;
                if (!com.jirbo.adcolony.q.b() && f == 0.69999999999999996D)
                {
                    f = 1.0D;
                }
                if (f * 20D < 18D)
                {
                    f1 = 18F;
                } else
                {
                    f1 = (float)(f * 20D);
                }
                if (f * 20D < 18D)
                {
                    f2 = 18F;
                } else
                {
                    f2 = (float)(f * 20D);
                }
                ae.setTextSize(f1);
                ag.setTextSize(f1);
                af.setTextSize(f2);
                if (K && ap != null && aq != null)
                {
                    ap.a(b((new StringBuilder()).append(V).append(ap.f * 2).toString()), ap.g);
                    aq.a(b((new StringBuilder()).append(V).append(aq.f * 2).toString()), aq.g);
                }
                if (d.s > d.t)
                {
                    i1 = d.t;
                } else
                {
                    i1 = d.s;
                }
                z = false;
            }
            if (P)
            {
                if (flag && a != null)
                {
                    a.setLayoutParams(new android.widget.FrameLayout.LayoutParams(d.s, d.t - m, 17));
                }
                if ((double)d.v / 640D < 0.90000000000000002D)
                {
                    d1 = 0.90000000000000002D;
                } else
                {
                    d1 = (double)d.v / 640D;
                }
                e = d1;
                if (!com.jirbo.adcolony.q.b() && e == 0.90000000000000002D)
                {
                    e = 1.2D;
                }
            }
            if (M)
            {
                double d2 = n / o;
                if ((double)d.s / d2 > (double)d.t / 1.0D)
                {
                    d1 = (double)d.t / 1.0D;
                } else
                {
                    d1 = (double)d.s / d2;
                }
                d.u = (int)(d2 * d1);
                d.v = (int)(d1 * 1.0D);
                if (d.s > d.t)
                {
                    d1 = (double)d.v / 640D;
                } else
                {
                    d1 = (double)d.v / 960D;
                }
                e = d1;
                if ((double)d.s / (double)n > (double)d.t / (double)o)
                {
                    d1 = (double)d.t / (double)o;
                } else
                {
                    d1 = (double)d.s / (double)n;
                }
                ai.a(d1);
                ai.d(d.s, d.t);
            }
            if (K && ap != null && aq != null)
            {
                if (ap != null && aq != null && ap.b != null && aq.b != null)
                {
                    i1 = (int)((double)ap.b.getHeight() * f);
                    j1 = (int)((double)aq.b.getHeight() * f);
                    ap.b(ap.f, i1);
                    aq.b(aq.f, j1);
                } else
                {
                    K = false;
                }
            }
            if (L)
            {
                aj.a(f);
                ak.a(f);
            }
        }
    }

    void a(int i1)
    {
        Object obj;
        if (!C && i1 != 10)
        {
            break MISSING_BLOCK_LABEL_456;
        }
        try
        {
            C = false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            C = true;
            return;
        }
        i1;
        JVM INSTR tableswitch 1 10: default 453
    //                   1 100
    //                   2 255
    //                   3 403
    //                   4 419
    //                   5 72
    //                   6 72
    //                   7 72
    //                   8 72
    //                   9 72
    //                   10 441;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1 _L1 _L1 _L1 _L6
_L6:
        break MISSING_BLOCK_LABEL_441;
_L1:
        t = 0;
_L7:
        (new Handler()).postDelayed(new Runnable() {

            final au a;

            public void run()
            {
                a.C = true;
            }

            
            {
                a = au.this;
                super();
            }
        }, 1500L);
        return;
_L2:
label0:
        {
            t = 0;
            com.jirbo.adcolony.ak.a("info", (new StringBuilder()).append("{\"ad_slot\":").append(ak.A.c.k.c).append("}").toString(), d.D);
            obj = com.jirbo.adcolony.ak.g("info_url");
            bl.b.a("INFO ").b(obj);
            if (!((String) (obj)).startsWith("market:") && !((String) (obj)).startsWith("amzn:"))
            {
                break label0;
            }
            d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj)))));
        }
          goto _L7
        com.jirbo.adcolony.AdColonyBrowser.a = ((String) (obj));
        d.startActivity(new Intent(d, com/jirbo/adcolony/AdColonyBrowser));
          goto _L7
_L3:
label1:
        {
            t = 0;
            com.jirbo.adcolony.ak.a("download", (new StringBuilder()).append("{\"ad_slot\":").append(ak.A.c.k.c).append("}").toString(), d.D);
            obj = com.jirbo.adcolony.ak.g("download_url");
            bl.b.a("DOWNLOAD ").b(obj);
            if (!((String) (obj)).startsWith("market:") && !((String) (obj)).startsWith("amzn:"))
            {
                break label1;
            }
            d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj)))));
        }
          goto _L7
        com.jirbo.adcolony.AdColonyBrowser.a = ((String) (obj));
        d.startActivity(new Intent(d, com/jirbo/adcolony/AdColonyBrowser));
          goto _L7
_L4:
        t = 0;
        g();
        invalidate();
          goto _L7
_L5:
        t = 0;
        d.B.a();
        e();
          goto _L7
        t = 0;
        f();
          goto _L7
    }

    void a(String s1)
    {
        while (M || a == null) 
        {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a.evaluateJavascript(s1, null);
            return;
        } else
        {
            a.loadUrl((new StringBuilder()).append("javascript:").append(s1).toString());
            return;
        }
    }

    void a(boolean flag)
    {
        if (M)
        {
            return;
        }
        if (flag)
        {
            a("adc_bridge.fireChangeEvent({viewable:true});");
            return;
        } else
        {
            a("adc_bridge.fireChangeEvent({viewable:false});");
            return;
        }
    }

    public boolean a(m m1, int i1, int j1)
    {
        while (m1 == null || i1 >= m1.b() + m1.f + 8 || i1 <= m1.b() - 8 || j1 >= m1.c() + m1.g + 8 || j1 <= m1.c() - 8) 
        {
            return false;
        }
        return true;
    }

    int b(String s1)
    {
        af.getTextWidths(s1, ax);
        float f1 = 0.0F;
        int j1 = s1.length();
        for (int i1 = 0; i1 < j1; i1++)
        {
            f1 += ax[i1];
        }

        return (int)f1;
    }

    void b()
    {
label0:
        {
            a = new WebView(d);
            a.setFocusable(true);
            a.setHorizontalScrollBarEnabled(false);
            a.setVerticalScrollBarEnabled(false);
            Object obj = a.getSettings();
            ((WebSettings) (obj)).setJavaScriptEnabled(true);
            ((WebSettings) (obj)).setPluginState(android.webkit.WebSettings.PluginState.ON_DEMAND);
            ((WebSettings) (obj)).setBuiltInZoomControls(true);
            ((WebSettings) (obj)).setGeolocationEnabled(true);
            a.setWebChromeClient(new WebChromeClient() {

                final au a;

                public boolean onConsoleMessage(ConsoleMessage consolemessage)
                {
                    String s2 = consolemessage.sourceId();
                    if (s2 != null) goto _L2; else goto _L1
_L1:
                    String s1 = "Internal";
_L4:
                    bl.b.a(consolemessage.message()).a(" [").a(s1).a(" line ").a(consolemessage.lineNumber()).b("]");
                    return true;
_L2:
                    int i1 = s2.lastIndexOf('/');
                    s1 = s2;
                    if (i1 != -1)
                    {
                        s1 = s2.substring(i1 + 1);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                public void onGeolocationPermissionsShowPrompt(String s1, android.webkit.GeolocationPermissions.Callback callback)
                {
                    callback.invoke(s1, true, false);
                }

            
            {
                a = au.this;
                super();
            }
            });
            d.L = new FrameLayout(d);
            if (com.jirbo.adcolony.ak.f("hardware_acceleration_disabled"))
            {
                try
                {
                    d.L.getClass().getMethod("setLayerType", new Class[] {
                        Integer.TYPE, android/graphics/Paint
                    }).invoke(a, new Object[] {
                        Integer.valueOf(1), null
                    });
                }
                catch (Exception exception) { }
            }
            av = new bm(d, a, d);
            obj = new WebViewClient() {

                String a;
                final au b;

                public void onLoadResource(WebView webview, String s1)
                {
                    com.jirbo.adcolony.bl.a.a("DEC onLoad: ").b(s1);
                    if (s1.equals(a))
                    {
                        com.jirbo.adcolony.bl.a.b("DEC disabling mouse events");
                        b.a("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
                    }
                }

                public void onPageFinished(WebView webview, String s1)
                {
                    if (s1.equals(a) || ak.K.startsWith("<"))
                    {
                        b.D = false;
                        b.d.k = true;
                        b.w = System.currentTimeMillis();
                        b.d.o = (double)(b.w - b.v) / 1000D;
                    }
                    b.d.K.removeView(b.c);
                }

                public void onPageStarted(WebView webview, String s1, Bitmap bitmap)
                {
                    if (s1.equals(a))
                    {
                        b.d.j = true;
                        b.v = System.currentTimeMillis();
                    }
                }

                public boolean shouldOverrideUrlLoading(WebView webview, String s1)
                {
                    com.jirbo.adcolony.bl.a.a("DEC request: ").b(s1);
                    if (s1.contains("mraid:"))
                    {
                        b.av.a(s1);
                    } else
                    {
                        if (s1.contains("youtube"))
                        {
                            webview = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("vnd.youtube:").append(s1).toString()));
                            webview.putExtra("VIDEO_ID", s1);
                            b.d.startActivity(webview);
                            return true;
                        }
                        if (!s1.contains("mraid.js"))
                        {
                            return false;
                        }
                    }
                    return true;
                }

            
            {
                b = au.this;
                super();
                a = ak.K;
            }
            };
            a.setWebViewClient(((WebViewClient) (obj)));
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                if (ak.K.startsWith("<"))
                {
                    a.loadData(ak.K, "text/html; charset=UTF-8", null);
                } else
                {
                    a.loadUrl(ak.K);
                }
            }
            obj = com.jirbo.adcolony.ap.a(ak.L, "");
            com.jirbo.adcolony.bl.a.b("Injecting mraid");
            a(((String) (obj)));
            if (ak.d)
            {
                obj = "true";
            } else
            {
                obj = "false";
            }
            a((new StringBuilder()).append("var is_tablet=").append(((String) (obj))).append(";").toString());
            if (ak.d)
            {
                obj = "tablet";
            } else
            {
                obj = "phone";
            }
            a((new StringBuilder()).append("adc_bridge.adc_version='").append(ak.N).append("'").toString());
            a((new StringBuilder()).append("adc_bridge.os_version='").append(ak.M).append("'").toString());
            a("adc_bridge.os_name='android'");
            a((new StringBuilder()).append("adc_bridge.device_type='").append(((String) (obj))).append("'").toString());
            a("adc_bridge.fireChangeEvent({state:'default'});");
            a("adc_bridge.fireReadyEvent()");
            if (android.os.Build.VERSION.SDK_INT < 19)
            {
                if (!ak.K.startsWith("<"))
                {
                    break label0;
                }
                a.loadData(ak.K, "text/html; charset=UTF-8", null);
            }
            return;
        }
        a.loadUrl(ak.K);
    }

    void b(int i1)
    {
        h = i1;
        if (i1 < 0)
        {
            h = 0;
        }
    }

    void b(boolean flag)
    {
        if (!M);
    }

    public void c()
    {
        be be1 = com.jirbo.adcolony.ak.c;
        o o1 = d;
        be1.a(o.e, d.D);
        if (P && D && ak.I)
        {
            d.K.addView(c);
            (new Handler()).postDelayed(new Runnable() {

                final au a;

                public void run()
                {
                    if (a.D && a.d != null && a.P && a.a != null)
                    {
                        a.d.l = true;
                        a.e();
                    }
                }

            
            {
                a = au.this;
                super();
            }
            }, ak.J * 1000);
        }
        if (ak.G)
        {
            e();
        }
        com.jirbo.adcolony.ak.a("card_shown", d.D);
        synchronized (aH)
        {
            ac = null;
            if (ak.A.d.t.e)
            {
                ac = new ar(ak.A.d.t.g);
            }
        }
        if (P)
        {
            obj = new Handler();
            View view = new View(d);
            Runnable runnable = new Runnable(view) {

                final View a;
                final au b;

                public void run()
                {
                    b.d.K.removeView(a);
                    b.a(true);
                    b.d.q = System.currentTimeMillis();
                }

            
            {
                b = au.this;
                a = view;
                super();
            }
            };
            view.setBackgroundColor(0xff000000);
            d.K.addView(view);
            ((Handler) (obj)).postDelayed(runnable, 500L);
            d.L.setVisibility(0);
        }
        d.q = System.currentTimeMillis();
        d();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void c(boolean flag)
    {
        ak.u = true;
        if (ak.A.h() && !flag)
        {
            o o1 = d;
            com.jirbo.adcolony.o.a = d.B.getCurrentPosition();
            de.b = new de(d, (ag)ak.A);
            return;
        }
        for (int i1 = 0; i1 < ak.X.size(); i1++)
        {
            if (ak.X.get(i1) != null)
            {
                ((ad)ak.X.get(i1)).a();
            }
        }

        d.finish();
        ak.D.b(d.D);
        ak.R = true;
        AdColonyBrowser.B = true;
    }

    void d()
    {
        (new Handler()).postDelayed(new Runnable() {

            final au a;

            public void run()
            {
                if (a.d.B != null)
                {
                    a.d.B.setVisibility(8);
                }
            }

            
            {
                a = au.this;
                super();
            }
        }, 300L);
        if (d.G)
        {
            d.E.h();
        }
        o o1 = d;
        o.d = true;
        if (d.B != null)
        {
            d.B.a();
        }
        de.b = null;
        invalidate();
        I = false;
        invalidate();
    }

    void e()
    {
        if (d == null || P && (a == null || d.L == null || d.K == null))
        {
            return;
        }
        ak.u = true;
        d.r = System.currentTimeMillis();
        o o1 = d;
        o1.p = o1.p + (double)(d.r - d.q) / 1000D;
        ak.R = true;
        for (int i1 = 0; i1 < ak.X.size(); i1++)
        {
            if (ak.X.get(i1) != null)
            {
                ((ad)ak.X.get(i1)).a();
            }
        }

        try
        {
            d.Q.close();
        }
        catch (Exception exception) { }
        d.finish();
        ac = null;
        if (P)
        {
            d.K.removeView(d.L);
            a.destroy();
            a = null;
        }
        ak.D.a(d.D);
        AdColonyBrowser.B = true;
    }

    void f()
    {
        c(false);
    }

    void g()
    {
        com.jirbo.adcolony.ak.a("replay", d.D);
        Object obj = d;
        o.e = true;
        obj = d;
        o.d = false;
        obj = d;
        com.jirbo.adcolony.o.a = 0;
        Q = false;
        obj = new View(d);
        ((View) (obj)).setBackgroundColor(0xff000000);
        d.K.addView(((View) (obj)), new android.widget.FrameLayout.LayoutParams(d.s, d.t, 17));
        (new Handler()).postDelayed(new Runnable(((View) (obj))) {

            final View a;
            final au b;

            public void run()
            {
                if (b.P)
                {
                    b.d.L.setVisibility(4);
                }
                b.d.K.removeView(a);
            }

            
            {
                b = au.this;
                a = view;
                super();
            }
        }, 900L);
        d.B.start();
        if (d.G)
        {
            try
            {
                d.E = com.immersion.hapticmediasdk.c.a(0, d);
                d.E.a(d.F);
            }
            catch (Exception exception)
            {
                d.G = false;
            }
            if (d.E == null)
            {
                d.G = false;
            }
            if (d.G)
            {
                d.E.d();
            }
        }
        com.jirbo.adcolony.ak.c.a(d.D);
        d.B.requestFocus();
        d.B.setBackgroundColor(0);
        d.B.setVisibility(0);
        a(false);
    }

    void h()
    {
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(this) {

            final View a;
            final au b;

            public void onGlobalLayout()
            {
                Rect rect = new Rect();
                a.getWindowVisibleDisplayFrame(rect);
                if (b.a != null)
                {
                    b.b(a.getRootView().getHeight() - (rect.bottom - rect.top) - (b.d.t - b.a.getHeight()) / 2);
                }
                b.i();
            }

            
            {
                b = au.this;
                a = view;
                super();
            }
        });
    }

    void i()
    {
        if (h >= 70 && !E)
        {
            E = true;
            b(true);
        } else
        if (E && h == 0)
        {
            E = false;
            b(false);
            return;
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        c();
    }

    public void onDraw(Canvas canvas)
    {
        if (!F) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        int l1;
        int j2;
        int k2;
        a();
        T = canvas;
        boolean flag;
        if (!N && L)
        {
            o o1;
            if (d.B.getCurrentPosition() > p)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            N = flag;
        }
        if (!O && K)
        {
            if (d.B.getCurrentPosition() > q)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            O = flag;
        }
        o1 = d;
        if (!o.d || !M)
        {
            break MISSING_BLOCK_LABEL_491;
        }
        canvas.drawARGB(d.w >> 24 & 0xff, 0, 0, 0);
        ai.a(canvas, (d.s - ai.f) / 2, (d.t - ai.g) / 2);
        i1 = (int)(186D * e);
        j2 = ai.b() + i1;
        i1 = (int)(470D * e);
        k2 = ai.c() + i1;
        l1 = 0;
        if (l1 >= at.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (t != l1 + 1 && (u != l1 + 1 || A || u == 0))
        {
            break; /* Loop/switch isn't completed */
        }
        au[l1].a(e);
        au[l1].a(canvas, j2, k2);
        i1 = (int)((double)j2 + (double)157F * e);
_L6:
        ae.setColor(-1);
        ae.clearShadowLayer();
        canvas.drawText(aw[l1], (float)at[l1].b() + (float)(at[l1].f / 2), at[l1].c() + at[l1].g, ae);
        l1++;
        j2 = i1;
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_228;
_L3:
        if (!A)
        {
            i1 = j2;
            if (l1 + 1 == u)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        at[l1].a(e);
        at[l1].a(canvas, j2, k2);
        i1 = (int)((double)j2 + (double)157F * e);
        if (true) goto _L6; else goto _L5
_L5:
        o o2 = d;
        if (o.d && P)
        {
            al.a(f);
            am.a(f);
            an.a(f);
            ao.a(f);
            int j1;
            if (!ak.d && i != 0)
            {
                j1 = i;
            } else
            {
                j1 = d.s - al.f;
            }
            i = j1;
            j = 0;
            k = 0;
            l = 0;
            if (!H)
            {
                al.a(canvas, i, j);
            } else
            {
                am.a(canvas, i, j);
            }
            if (!I)
            {
                an.a(canvas, k, l);
            } else
            {
                ao.a(canvas, k, l);
            }
            h();
            return;
        }
        if (d.B != null)
        {
            com.jirbo.adcolony.ak.c.a((double)d.B.getCurrentPosition() / (double)d.B.getDuration(), d.D);
            if (d.G)
            {
                d.E.a(d.B.getCurrentPosition());
            }
            int i2 = d.B.getCurrentPosition();
            int k1 = ((s - i2) + 999) / 1000;
            if (Q && k1 == 1)
            {
                k1 = 0;
            }
            if (k1 == 0)
            {
                Q = true;
            }
            if (i2 >= 500)
            {
                if (B)
                {
                    az = (float)(360D / ((double)s / 1000D));
                    B = false;
                    Rect rect = new Rect();
                    ae.getTextBounds("0123456789", 0, 9, rect);
                    aC = rect.height();
                }
                aA = getWidth();
                aB = getHeight();
                aD = aC;
                aE = (float)d.t - aC - (float)m;
                aG.set(aD - aC / 2.0F, aE - 2.0F * aC, aD + 2.0F * aC, aE + aC / 2.0F);
                aF.setShadowLayer((int)(4D * e), 0.0F, 0.0F, 0xff000000);
                double d1 = az;
                ay = (float)(((double)s / 1000D - (double)i2 / 1000D) * d1);
                canvas.drawArc(aG, 270F, ay, false, aF);
                o o3 = d;
                if (!o.d)
                {
                    ae.setColor(0xffcccccc);
                    ae.setShadowLayer((int)(2D * e), 0.0F, 0.0F, 0xff000000);
                    ae.setTextAlign(android.graphics.Paint.Align.CENTER);
                    ae.setLinearText(true);
                    canvas.drawText((new StringBuilder()).append("").append(k1).toString(), aG.centerX(), (float)((double)aG.centerY() + (double)ae.getFontMetrics().bottom * 1.3500000000000001D), ae);
                }
                if (L)
                {
                    o o4 = d;
                    if (!o.d && N)
                    {
                        if (t == 10)
                        {
                            ak.a(canvas, d.s - ak.f, (int)(e * 4D));
                        } else
                        {
                            aj.a(canvas, d.s - aj.f, (int)(e * 4D));
                        }
                    }
                }
                if (K && O)
                {
                    if (!G && !R)
                    {
                        if (J)
                        {
                            aq.c((int)((float)(d.s - aq.f) - aC / 2.0F), d.t - aq.g - m - (int)(aC / 2.0F));
                            aq.a(canvas);
                        } else
                        {
                            ap.c((int)((float)(d.s - ap.f) - aC / 2.0F), d.t - ap.g - m - (int)(aC / 2.0F));
                            ap.a(canvas);
                        }
                        af.setTextAlign(android.graphics.Paint.Align.CENTER);
                        canvas.drawText(V, ap.e.centerX(), (float)((double)ap.e.centerY() + (double)af.getFontMetrics().bottom * 1.3500000000000001D), af);
                    } else
                    if (!G && R)
                    {
                        as.c((int)((float)(d.s - as.f) - aC / 2.0F), d.t - as.g - m - (int)(aC / 2.0F));
                        as.a(canvas);
                    }
                }
            }
            if (de.b != null)
            {
                de.b.onDraw(canvas);
            }
        }
        canvas = d;
        if (o.h)
        {
            invalidate();
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        c(true);
        return true;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        m = d.t - j1;
        if (Build.MODEL.equals("Kindle Fire"))
        {
            m = 20;
        }
        if (Build.MODEL.equals("SCH-I800"))
        {
            m = 25;
        }
        if (Build.MODEL.equals("SHW-M380K") || Build.MODEL.equals("SHW-M380S") || Build.MODEL.equals("SHW-M380W"))
        {
            m = 40;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i2 = motionevent.getAction();
        if (de.b != null)
        {
            de.b.onTouchEvent(motionevent);
            return true;
        }
        int i1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        if (i2 == 0)
        {
            o o1 = d;
            if (o.d && P)
            {
                if (a(al, i1, k1))
                {
                    H = true;
                    invalidate();
                    return true;
                }
                if (a(an, i1, k1))
                {
                    I = true;
                    invalidate();
                    return true;
                } else
                {
                    return false;
                }
            }
            o1 = d;
            i2 = k1;
            int j2 = i1;
            if (o.d)
            {
                i2 = k1;
                j2 = i1;
                if (M)
                {
                    i1 = (int)((double)(motionevent.getX() - (float)ai.b()) / (e * 2D));
                    k1 = (int)((double)(motionevent.getY() - (float)ai.c()) / (e * 2D));
                    i2 = k1;
                    j2 = i1;
                    if (t == 0)
                    {
                        i2 = k1;
                        j2 = i1;
                        if (k1 >= 235)
                        {
                            i2 = k1;
                            j2 = i1;
                            if (k1 < 305)
                            {
                                i2 = a(i1, k1);
                                t = i2;
                                u = i2;
                                A = false;
                                invalidate();
                                j2 = i1;
                                i2 = k1;
                            }
                        }
                    }
                }
            }
            if (L && N && d.B != null && a(aj, j2, i2))
            {
                t = 10;
                u = t;
                A = false;
                invalidate();
                return true;
            }
            if (K && O && (a(ap, j2, i2) || a(as, j2, i2)))
            {
                J = true;
                invalidate();
                return true;
            }
        } else
        {
            if (i2 == 1)
            {
                o o2 = d;
                if (o.d && P)
                {
                    if (a(al, i1, k1) && H)
                    {
                        t = 4;
                        if (a != null)
                        {
                            a.clearCache(true);
                        }
                        aI.sendMessageDelayed(aI.obtainMessage(t), 250L);
                        return true;
                    }
                    if (a(an, i1, k1) && I)
                    {
                        t = 3;
                        if (a != null)
                        {
                            a.clearCache(true);
                        }
                        aI.sendMessageDelayed(aI.obtainMessage(t), 250L);
                        return true;
                    }
                }
                o2 = d;
                i2 = k1;
                int k2 = i1;
                if (o.d)
                {
                    i2 = k1;
                    k2 = i1;
                    if (M)
                    {
                        int j1 = (int)((double)(motionevent.getX() - (float)ai.b()) / (e * 2D));
                        int l1 = (int)((double)(motionevent.getY() - (float)ai.c()) / (e * 2D));
                        i2 = l1;
                        k2 = j1;
                        if (!A)
                        {
                            i2 = l1;
                            k2 = j1;
                            if (l1 >= 235)
                            {
                                i2 = l1;
                                k2 = j1;
                                if (l1 < 305)
                                {
                                    int l2 = a(j1, l1);
                                    i2 = l1;
                                    k2 = j1;
                                    if (l2 > 0)
                                    {
                                        i2 = l1;
                                        k2 = j1;
                                        if (l2 == u)
                                        {
                                            aI.sendMessageDelayed(aI.obtainMessage(l2), 250L);
                                            k2 = j1;
                                            i2 = l1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (L && N && d.B != null && a(aj, k2, i2))
                {
                    t = 10;
                    A = true;
                    u = t;
                    aI.sendMessageDelayed(aI.obtainMessage(t), 250L);
                    return true;
                }
                if (K && O && (a(ap, k2, i2) || a(as, k2, i2)))
                {
                    J = false;
                    if (aa.startsWith("market:") || aa.startsWith("amzn:"))
                    {
                        d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aa)));
                    } else
                    if (aa.startsWith("v4iap:"))
                    {
                        ab = d.D.h;
                        d.D.p = com.jirbo.adcolony.z.c;
                        K = false;
                        S = true;
                        R = false;
                        f();
                    } else
                    {
                        com.jirbo.adcolony.AdColonyBrowser.a = aa;
                        d.startActivity(new Intent(d, com/jirbo/adcolony/AdColonyBrowser));
                    }
                    com.jirbo.adcolony.ak.a("in_video_engagement", (new StringBuilder()).append("{\"ad_slot\":").append(ak.A.c.k.c).append("}").toString(), d.D);
                    return true;
                } else
                {
                    H = false;
                    I = false;
                    J = false;
                    A = true;
                    t = 0;
                    invalidate();
                    return true;
                }
            }
            if (i2 == 3)
            {
                H = false;
                I = false;
                J = false;
                A = true;
                t = 0;
                invalidate();
                return true;
            }
        }
        return true;
    }

}
