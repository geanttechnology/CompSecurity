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
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.immersion.hapticmediasdk.HapticContentSDK;
import com.immersion.hapticmediasdk.HapticContentSDKFactory;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            a, d, c, ADCImage, 
//            AdColonyAd, ADCVideo, AdColony, e, 
//            ag, l, AdColonyBrowser, m, 
//            ab, w, AdColonyV4VCAd, AdColonyNativeAdView, 
//            AdColonyIAPEngagement

class ae extends View
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
{

    static float ay[] = new float[80];
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
    boolean T;
    boolean U;
    Canvas V;
    String W;
    String Z;
    WebView a;
    float aA;
    float aB;
    float aC;
    float aD;
    float aE;
    float aF;
    Paint aG;
    RectF aH;
    b aI;
    Handler aJ;
    String aa;
    String ab;
    String ac;
    ab.b ad;
    Paint ae;
    Paint af;
    Paint ag;
    Paint ah;
    Rect ai;
    ADCImage aj;
    ADCImage ak;
    ADCImage al;
    ADCImage am;
    ADCImage an;
    ADCImage ao;
    ADCImage ap;
    ADCImage aq;
    ADCImage ar;
    ADCImage as;
    ADCImage at;
    ADCImage au[];
    ADCImage av[];
    m aw;
    String ax[];
    float az;
    WebView b;
    View c;
    ADCVideo d;
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

    ae(ADCVideo adcvideo)
    {
        super(adcvideo);
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
        W = a.l.a.b;
        ae = new Paint();
        af = new Paint(1);
        ag = new Paint(1);
        ah = new Paint(1);
        ai = new Rect();
        au = new ADCImage[4];
        av = new ADCImage[4];
        ax = new String[4];
        aG = new Paint(1);
        aH = new RectF();
    /* block-local class not found */
    class b {}

        aI = new b();
        aJ = new _cls2();
        d = adcvideo;
        M = a.l.a.s;
        if (a.K != null)
        {
            M = M | a.K.i.v.l.a;
            a.K.n = a.K.o;
        }
        x = adcvideo.getResources().getDisplayMetrics().density;
        Q = a.P;
        if (a.e != null)
        {
            a.U = a.e;
        }
        if (a.K != null && a.K.i.u.d)
        {
            float f1;
            float f2;
            boolean flag;
            if (!Q)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            N = flag;
        }
        if (N)
        {
            aj = new ADCImage(com.jirbo.adcolony.a.j("end_card_filepath"));
            n = aj.f;
            o = aj.g;
            if (n == 0)
            {
                n = 480;
            }
            if (o == 0)
            {
                o = 320;
            }
            au[0] = new ADCImage(com.jirbo.adcolony.a.j("info_image_normal"));
            au[1] = new ADCImage(com.jirbo.adcolony.a.j("download_image_normal"));
            au[2] = new ADCImage(com.jirbo.adcolony.a.j("replay_image_normal"));
            au[3] = new ADCImage(com.jirbo.adcolony.a.j("continue_image_normal"));
            av[0] = new ADCImage(com.jirbo.adcolony.a.j("info_image_down"), true);
            av[1] = new ADCImage(com.jirbo.adcolony.a.j("download_image_down"), true);
            av[2] = new ADCImage(com.jirbo.adcolony.a.j("replay_image_down"), true);
            av[3] = new ADCImage(com.jirbo.adcolony.a.j("continue_image_down"), true);
            ax[0] = "Info";
            ax[1] = "Download";
            ax[2] = "Replay";
            ax[3] = "Continue";
        } else
        if (Q)
        {
            ao = new ADCImage(com.jirbo.adcolony.a.j("reload_image_normal"));
            am = new ADCImage(com.jirbo.adcolony.a.j("close_image_normal"));
            an = new ADCImage(com.jirbo.adcolony.a.j("close_image_down"));
            ap = new ADCImage(com.jirbo.adcolony.a.j("reload_image_down"));
            as = new ADCImage(com.jirbo.adcolony.a.j("browser_icon"));
    /* block-local class not found */
    class a {}

            c = new a(adcvideo);
            b();
        }
        if (M)
        {
            ak = new ADCImage(com.jirbo.adcolony.a.j("skip_video_image_normal"));
            al = new ADCImage(com.jirbo.adcolony.a.j("skip_video_image_down"));
            p = com.jirbo.adcolony.a.h("skip_delay") * 1000;
        }
        aG.setStyle(android.graphics.Paint.Style.STROKE);
        f2 = 2.0F * adcvideo.getResources().getDisplayMetrics().density;
        f1 = f2;
        if (f2 > 6F)
        {
            f1 = 6F;
        }
        if (f1 >= 4F);
        aG.setStrokeWidth(2.0F * adcvideo.getResources().getDisplayMetrics().density);
        aG.setColor(0xffcccccc);
        S = false;
        L = false;
        T = false;
        if (a.K != null)
        {
            L = a.K.i.v.m.a;
            T = com.jirbo.adcolony.a.i("image_overlay_enabled");
        }
        if (L)
        {
            aq = new ADCImage(com.jirbo.adcolony.a.j("engagement_image_normal"));
            ar = new ADCImage(com.jirbo.adcolony.a.j("engagement_image_down"));
            ab = a.K.i.v.m.j;
            Z = a.K.i.v.m.l;
            aa = a.K.i.v.m.o;
            r = a.K.i.v.m.c;
            q = com.jirbo.adcolony.a.h("engagement_delay") * 1000;
            if (Z.equals(""))
            {
                Z = "Learn More";
            }
            if (!aa.equals(""))
            {
                G = true;
            }
            if (G)
            {
                b = new WebView(adcvideo);
                b.setBackgroundColor(0);
            }
            if (aq == null || ar == null)
            {
                L = false;
            }
        }
        if (T)
        {
            at = new ADCImage(com.jirbo.adcolony.a.j("image_overlay_filepath"));
            double d1;
            if (AdColony.isTablet())
            {
                d1 = ((double)r * ((double)x / 1.0D)) / (double)at.g;
            } else
            {
                d1 = ((double)r * ((double)x / 0.75D)) / (double)at.g;
            }
            at.a(d1);
        }
        if (ADCVideo.d)
        {
            e();
        }
        ae.setColor(-1);
        ag.setTextSize(24F);
        ag.setColor(0xff000000);
        af.setColor(0xffcccccc);
        af.setTextSize(20F);
        af.setTextAlign(android.graphics.Paint.Align.CENTER);
        ah.setTextSize(20F);
        ah.setColor(-1);
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
        catch (ADCVideo adcvideo)
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
            if (d.E != null)
            {
                k1 = ((flag) ? 1 : 0);
                if (M)
                {
                    k1 = ((flag) ? 1 : 0);
                    if (i1 >= d.E.getWidth() - ak.f)
                    {
                        k1 = ((flag) ? 1 : 0);
                        if (j1 <= ak.g)
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
        if (d.E != null)
        {
            if (s <= 0)
            {
                s = d.E.getDuration();
            }
            if (flag)
            {
                setLayoutParams(new android.widget.FrameLayout.LayoutParams(d.t, d.u, 17));
                d.E.setLayoutParams(new android.widget.FrameLayout.LayoutParams(d.x, d.y, 17));
                y = true;
            }
        }
        if (y)
        {
            y = false;
            double d1;
            if (z)
            {
                DisplayMetrics displaymetrics = AdColony.activity().getResources().getDisplayMetrics();
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
                if (!AdColony.isTablet() && f == 0.69999999999999996D)
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
                af.setTextSize(f1);
                ah.setTextSize(f1);
                ag.setTextSize(f2);
                if (L && aq != null && ar != null)
                {
                    aq.a(b((new StringBuilder()).append(Z).append(aq.f * 2).toString()), aq.g);
                    ar.a(b((new StringBuilder()).append(Z).append(ar.f * 2).toString()), ar.g);
                }
                if (d.t > d.u)
                {
                    i1 = d.u;
                } else
                {
                    i1 = d.t;
                }
                z = false;
            }
            if (Q)
            {
                if (flag && a != null)
                {
                    a.setLayoutParams(new android.widget.FrameLayout.LayoutParams(d.t, d.u - m, 17));
                }
                if ((double)d.y / 640D < 0.90000000000000002D)
                {
                    d1 = 0.90000000000000002D;
                } else
                {
                    d1 = (double)d.y / 640D;
                }
                e = d1;
                if (!AdColony.isTablet() && e == 0.90000000000000002D)
                {
                    e = 1.2D;
                }
            }
            if (N)
            {
                double d2 = n / o;
                if ((double)d.t / d2 > (double)d.u / 1.0D)
                {
                    d1 = (double)d.u / 1.0D;
                } else
                {
                    d1 = (double)d.t / d2;
                }
                d.x = (int)(d2 * d1);
                d.y = (int)(d1 * 1.0D);
                if (d.t > d.u)
                {
                    d1 = (double)d.y / 640D;
                } else
                {
                    d1 = (double)d.y / 960D;
                }
                e = d1;
                if ((double)d.t / (double)n > (double)d.u / (double)o)
                {
                    d1 = (double)d.u / (double)o;
                } else
                {
                    d1 = (double)d.t / (double)n;
                }
                aj.a(d1);
                aj.d(d.t, d.u);
            }
            if (L && aq != null && ar != null)
            {
                if (aq != null && ar != null && aq.b != null && ar.b != null)
                {
                    i1 = (int)((double)aq.b.getHeight() * f);
                    j1 = (int)((double)ar.b.getHeight() * f);
                    aq.b(aq.f, i1);
                    ar.b(ar.f, j1);
                } else
                {
                    L = false;
                }
            }
            if (M)
            {
                ak.a(f);
                al.a(f);
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
        (new Handler()).postDelayed(new _cls1(), 1500L);
        return;
_L2:
label0:
        {
            t = 0;
            com.jirbo.adcolony.a.a("info", (new StringBuilder()).append("{\"ad_slot\":").append(a.K.h.k.c).append("}").toString(), d.G);
            obj = com.jirbo.adcolony.a.j("info_url");
            l.b.a("INFO ").b(obj);
            if (!((String) (obj)).startsWith("market:") && !((String) (obj)).startsWith("amzn:"))
            {
                break label0;
            }
            d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj)))));
        }
          goto _L7
        AdColonyBrowser.url = ((String) (obj));
        d.startActivity(new Intent(d, com/jirbo/adcolony/AdColonyBrowser));
          goto _L7
_L3:
label1:
        {
            t = 0;
            com.jirbo.adcolony.a.a("download", (new StringBuilder()).append("{\"ad_slot\":").append(a.K.h.k.c).append("}").toString(), d.G);
            obj = com.jirbo.adcolony.a.j("download_url");
            l.b.a("DOWNLOAD ").b(obj);
            if (!((String) (obj)).startsWith("market:") && !((String) (obj)).startsWith("amzn:"))
            {
                break label1;
            }
            d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj)))));
        }
          goto _L7
        AdColonyBrowser.url = ((String) (obj));
        d.startActivity(new Intent(d, com/jirbo/adcolony/AdColonyBrowser));
          goto _L7
_L4:
        t = 0;
        h();
        invalidate();
          goto _L7
_L5:
        t = 0;
        d.E.a();
        f();
          goto _L7
        t = 0;
        g();
          goto _L7
    }

    void a(String s1)
    {
        while (N || a == null) 
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
        if (N)
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

    public boolean a(ADCImage adcimage, int i1, int j1)
    {
        while (adcimage == null || i1 >= adcimage.c() + adcimage.f + 8 || i1 <= adcimage.c() - 8 || j1 >= adcimage.d() + adcimage.g + 8 || j1 <= adcimage.d() - 8) 
        {
            return false;
        }
        return true;
    }

    int b(String s1)
    {
        ag.getTextWidths(s1, ay);
        float f1 = 0.0F;
        int j1 = s1.length();
        for (int i1 = 0; i1 < j1; i1++)
        {
            f1 += ay[i1];
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
            a.setWebChromeClient(new _cls3());
            d.O = new FrameLayout(d);
            if (com.jirbo.adcolony.a.i("hardware_acceleration_disabled"))
            {
                try
                {
                    d.O.getClass().getMethod("setLayerType", new Class[] {
                        Integer.TYPE, android/graphics/Paint
                    }).invoke(a, new Object[] {
                        Integer.valueOf(1), null
                    });
                }
                catch (Exception exception) { }
            }
            aw = new m(d, a, d);
            obj = new _cls4();
            a.setWebViewClient(((android.webkit.WebViewClient) (obj)));
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                if (a.U.startsWith("<"))
                {
                    a.loadData(a.U, "text/html; charset=UTF-8", null);
                } else
                {
                    a.loadUrl(a.U);
                }
            }
            obj = com.jirbo.adcolony.ab.a(a.V, "");
            l.a.b("Injecting mraid");
            a(((String) (obj)));
            if (a.m)
            {
                obj = "true";
            } else
            {
                obj = "false";
            }
            a((new StringBuilder()).append("var is_tablet=").append(((String) (obj))).append(";").toString());
            if (a.m)
            {
                obj = "tablet";
            } else
            {
                obj = "phone";
            }
            a((new StringBuilder()).append("adc_bridge.adc_version='").append(a.X).append("'").toString());
            a((new StringBuilder()).append("adc_bridge.os_version='").append(a.W).append("'").toString());
            a("adc_bridge.os_name='android'");
            a((new StringBuilder()).append("adc_bridge.device_type='").append(((String) (obj))).append("'").toString());
            a("adc_bridge.fireChangeEvent({state:'default'});");
            a("adc_bridge.fireReadyEvent()");
            if (android.os.Build.VERSION.SDK_INT < 19)
            {
                if (!a.U.startsWith("<"))
                {
                    break label0;
                }
                a.loadData(a.U, "text/html; charset=UTF-8", null);
            }
            return;
        }
        a.loadUrl(a.U);
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
        if (!N);
    }

    public void c()
    {
        d d1 = a.l;
        ADCVideo adcvideo = d;
        d1.a(ADCVideo.e, d.G);
        if (Q && D && a.S)
        {
            d.N.addView(c);
            (new Handler()).postDelayed(new _cls5(), a.T * 1000);
        }
        if (a.Q)
        {
            f();
        }
        com.jirbo.adcolony.a.a("card_shown", d.G);
        synchronized (aI)
        {
            ad = null;
            if (a.K.i.u.e)
            {
                ad = new ab.b(a.K.i.u.g);
            }
        }
        if (Q)
        {
            obj = new Handler();
            View view = new View(d);
            _cls6 _lcls6 = new _cls6(view);
            view.setBackgroundColor(0xff000000);
            d.N.addView(view);
            ((Handler) (obj)).postDelayed(_lcls6, 500L);
            d.O.setVisibility(0);
        }
        d.r = System.currentTimeMillis();
        e();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void c(boolean flag)
    {
        a.D = true;
        if (a.K.b() && !flag)
        {
            ADCVideo adcvideo = d;
            ADCVideo.a = d.E.getCurrentPosition();
            w.I = new w(d, (AdColonyV4VCAd)a.K);
            return;
        }
        for (int i1 = 0; i1 < a.ah.size(); i1++)
        {
            if (a.ah.get(i1) != null)
            {
                ((AdColonyNativeAdView)a.ah.get(i1)).a();
            }
        }

        d.finish();
        a.N.b(d.G);
        a.ab = true;
        AdColonyBrowser.A = true;
    }

    void d()
    {
        a.loadUrl(a.U);
        l.a.a("Loading - end card url = ").b(a.U);
    }

    void e()
    {
        (new Handler()).postDelayed(new _cls7(), 300L);
        if (d.J)
        {
            d.H.stop();
        }
        ADCVideo adcvideo = d;
        ADCVideo.d = true;
        if (d.E != null)
        {
            d.E.a();
        }
        w.I = null;
        invalidate();
        I = false;
        invalidate();
    }

    void f()
    {
        if (d == null || Q && (a == null || d.O == null || d.N == null))
        {
            return;
        }
        a.D = true;
        d.s = System.currentTimeMillis();
        ADCVideo adcvideo = d;
        adcvideo.q = adcvideo.q + (double)(d.s - d.r) / 1000D;
        a.ab = true;
        for (int i1 = 0; i1 < a.ah.size(); i1++)
        {
            if (a.ah.get(i1) != null)
            {
                ((AdColonyNativeAdView)a.ah.get(i1)).a();
            }
        }

        try
        {
            d.T.close();
        }
        catch (Exception exception) { }
        d.finish();
        ad = null;
        if (Q)
        {
            d.N.removeView(d.O);
            a.destroy();
            a = null;
        }
        a.N.a(d.G);
        AdColonyBrowser.A = true;
    }

    void g()
    {
        c(false);
    }

    void h()
    {
        com.jirbo.adcolony.a.a("replay", d.G);
        Object obj = d;
        ADCVideo.e = true;
        obj = d;
        ADCVideo.d = false;
        obj = d;
        ADCVideo.a = 0;
        S = false;
        obj = new View(d);
        ((View) (obj)).setBackgroundColor(0xff000000);
        d.N.addView(((View) (obj)), new android.widget.FrameLayout.LayoutParams(d.t, d.u, 17));
        (new Handler()).postDelayed(new _cls8(((View) (obj))), 900L);
        d.E.start();
        if (d.J)
        {
            try
            {
                d.H = HapticContentSDKFactory.GetNewSDKInstance(0, d);
                d.H.openHaptics(d.I);
            }
            catch (Exception exception)
            {
                d.J = false;
            }
            if (d.H == null)
            {
                d.J = false;
            }
            if (d.J)
            {
                d.H.play();
            }
        }
        a.l.a(d.G);
        d.E.requestFocus();
        d.E.setBackgroundColor(0);
        d.E.setVisibility(0);
        a(false);
    }

    void i()
    {
        getViewTreeObserver().addOnGlobalLayoutListener(new _cls9(this));
    }

    void j()
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
        V = canvas;
        boolean flag;
        if (!O && M)
        {
            ADCVideo adcvideo;
            if (d.E.getCurrentPosition() > p)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            O = flag;
        }
        if (!P && L)
        {
            if (d.E.getCurrentPosition() > q)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            P = flag;
        }
        adcvideo = d;
        if (!ADCVideo.d || !N)
        {
            break MISSING_BLOCK_LABEL_491;
        }
        canvas.drawARGB(d.z >> 24 & 0xff, 0, 0, 0);
        aj.a(canvas, (d.t - aj.f) / 2, (d.u - aj.g) / 2);
        i1 = (int)(186D * e);
        j2 = aj.c() + i1;
        i1 = (int)(470D * e);
        k2 = aj.d() + i1;
        l1 = 0;
        if (l1 >= au.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (t != l1 + 1 && (u != l1 + 1 || A || u == 0))
        {
            break; /* Loop/switch isn't completed */
        }
        av[l1].a(e);
        av[l1].a(canvas, j2, k2);
        i1 = (int)((double)j2 + (double)157F * e);
_L6:
        af.setColor(-1);
        af.clearShadowLayer();
        canvas.drawText(ax[l1], (float)au[l1].c() + (float)(au[l1].f / 2), au[l1].d() + au[l1].g, af);
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
        au[l1].a(e);
        au[l1].a(canvas, j2, k2);
        i1 = (int)((double)j2 + (double)157F * e);
        if (true) goto _L6; else goto _L5
_L5:
        ADCVideo adcvideo1 = d;
        if (ADCVideo.d && Q)
        {
            am.a(f);
            an.a(f);
            ao.a(f);
            ap.a(f);
            int j1;
            if (!a.m && i != 0)
            {
                j1 = i;
            } else
            {
                j1 = d.t - am.f;
            }
            i = j1;
            j = 0;
            k = 0;
            l = 0;
            if (!H)
            {
                am.a(canvas, i, j);
            } else
            {
                an.a(canvas, i, j);
            }
            if (!I)
            {
                ao.a(canvas, k, l);
            } else
            {
                ap.a(canvas, k, l);
            }
            i();
            return;
        }
        if (d.E != null)
        {
            a.l.a((double)d.E.getCurrentPosition() / (double)d.E.getDuration(), d.G);
            if (d.J)
            {
                d.H.update(d.E.getCurrentPosition());
            }
            int i2 = d.E.getCurrentPosition();
            int k1 = ((s - i2) + 999) / 1000;
            if (S && k1 == 1)
            {
                k1 = 0;
            }
            if (k1 == 0)
            {
                S = true;
            }
            if (i2 >= 500)
            {
                if (B)
                {
                    aA = (float)(360D / ((double)s / 1000D));
                    B = false;
                    Rect rect = new Rect();
                    af.getTextBounds("0123456789", 0, 9, rect);
                    aD = rect.height();
                }
                aB = getWidth();
                aC = getHeight();
                aE = aD;
                aF = (float)d.u - aD - (float)m;
                aH.set(aE - aD / 2.0F, aF - 2.0F * aD, aE + 2.0F * aD, aF + aD / 2.0F);
                aG.setShadowLayer((int)(4D * e), 0.0F, 0.0F, 0xff000000);
                double d1 = aA;
                az = (float)(((double)s / 1000D - (double)i2 / 1000D) * d1);
                canvas.drawArc(aH, 270F, az, false, aG);
                ADCVideo adcvideo2 = d;
                if (!ADCVideo.d)
                {
                    af.setColor(0xffcccccc);
                    af.setShadowLayer((int)(2D * e), 0.0F, 0.0F, 0xff000000);
                    af.setTextAlign(android.graphics.Paint.Align.CENTER);
                    af.setLinearText(true);
                    canvas.drawText((new StringBuilder()).append("").append(k1).toString(), aH.centerX(), (float)((double)aH.centerY() + (double)af.getFontMetrics().bottom * 1.3500000000000001D), af);
                }
                if (M)
                {
                    ADCVideo adcvideo3 = d;
                    if (!ADCVideo.d && O)
                    {
                        if (t == 10)
                        {
                            al.a(canvas, d.t - al.f, (int)(e * 4D));
                        } else
                        {
                            ak.a(canvas, d.t - ak.f, (int)(e * 4D));
                        }
                    }
                }
                if (L && P)
                {
                    if (!G && !T)
                    {
                        if (J)
                        {
                            ar.c((int)((float)(d.t - ar.f) - aD / 2.0F), d.u - ar.g - m - (int)(aD / 2.0F));
                            ar.a(canvas);
                        } else
                        {
                            aq.c((int)((float)(d.t - aq.f) - aD / 2.0F), d.u - aq.g - m - (int)(aD / 2.0F));
                            aq.a(canvas);
                        }
                        ag.setTextAlign(android.graphics.Paint.Align.CENTER);
                        canvas.drawText(Z, aq.e.centerX(), (float)((double)aq.e.centerY() + (double)ag.getFontMetrics().bottom * 1.3500000000000001D), ag);
                    } else
                    if (!G && T)
                    {
                        at.c((int)((float)(d.t - at.f) - aD / 2.0F), d.u - at.g - m - (int)(aD / 2.0F));
                        at.a(canvas);
                    }
                }
            }
            if (w.I != null)
            {
                w.I.onDraw(canvas);
            }
        }
        canvas = d;
        if (ADCVideo.i)
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
        m = d.u - j1;
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
        if (w.I != null)
        {
            w.I.onTouchEvent(motionevent);
            return true;
        }
        int i1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        if (i2 == 0)
        {
            ADCVideo adcvideo = d;
            if (ADCVideo.d && Q)
            {
                if (a(am, i1, k1))
                {
                    H = true;
                    invalidate();
                    return true;
                }
                if (a(ao, i1, k1))
                {
                    I = true;
                    invalidate();
                    return true;
                } else
                {
                    return false;
                }
            }
            adcvideo = d;
            i2 = k1;
            int j2 = i1;
            if (ADCVideo.d)
            {
                i2 = k1;
                j2 = i1;
                if (N)
                {
                    i1 = (int)((double)(motionevent.getX() - (float)aj.c()) / (e * 2D));
                    k1 = (int)((double)(motionevent.getY() - (float)aj.d()) / (e * 2D));
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
            if (M && O && d.E != null && a(ak, j2, i2))
            {
                t = 10;
                u = t;
                A = false;
                invalidate();
                return true;
            }
            if (L && P && (a(aq, j2, i2) || a(at, j2, i2)))
            {
                J = true;
                invalidate();
                return true;
            }
        } else
        {
            if (i2 == 1)
            {
                ADCVideo adcvideo1 = d;
                if (ADCVideo.d && Q)
                {
                    if (a(am, i1, k1) && H)
                    {
                        t = 4;
                        if (a != null)
                        {
                            a.clearCache(true);
                        }
                        aJ.sendMessageDelayed(aJ.obtainMessage(t), 250L);
                        return true;
                    }
                    if (a(ao, i1, k1) && I)
                    {
                        t = 3;
                        if (a != null)
                        {
                            a.clearCache(true);
                        }
                        aJ.sendMessageDelayed(aJ.obtainMessage(t), 250L);
                        return true;
                    }
                }
                adcvideo1 = d;
                i2 = k1;
                int k2 = i1;
                if (ADCVideo.d)
                {
                    i2 = k1;
                    k2 = i1;
                    if (N)
                    {
                        int j1 = (int)((double)(motionevent.getX() - (float)aj.c()) / (e * 2D));
                        int l1 = (int)((double)(motionevent.getY() - (float)aj.d()) / (e * 2D));
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
                                            aJ.sendMessageDelayed(aJ.obtainMessage(l2), 250L);
                                            k2 = j1;
                                            i2 = l1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (M && O && d.E != null && a(ak, k2, i2))
                {
                    t = 10;
                    A = true;
                    u = t;
                    aJ.sendMessageDelayed(aJ.obtainMessage(t), 250L);
                    return true;
                }
                if (L && P && (a(aq, k2, i2) || a(at, k2, i2)))
                {
                    J = false;
                    if (ab.startsWith("market:") || ab.startsWith("amzn:"))
                    {
                        d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(ab)));
                    } else
                    if (ab.startsWith("v4iap:"))
                    {
                        ac = d.G.m;
                        d.G.u = AdColonyIAPEngagement.OVERLAY;
                        L = false;
                        U = true;
                        T = false;
                        g();
                    } else
                    {
                        AdColonyBrowser.url = ab;
                        d.startActivity(new Intent(d, com/jirbo/adcolony/AdColonyBrowser));
                    }
                    com.jirbo.adcolony.a.a("in_video_engagement", (new StringBuilder()).append("{\"ad_slot\":").append(a.K.h.k.c).append("}").toString(), d.G);
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


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}

}
