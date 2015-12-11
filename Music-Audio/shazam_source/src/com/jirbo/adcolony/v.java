// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
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
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.immersion.hapticmediasdk.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            q, ac, ab, c, 
//            g, e, af, ak, 
//            s, aj, ad, at, 
//            o, n, AdColonyBrowser, x, 
//            k

final class v extends View
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
{
    final class a extends View
    {

        Rect a;
        final v b;

        public final void onDraw(Canvas canvas)
        {
            canvas.drawARGB(255, 0, 0, 0);
            getDrawingRect(a);
            b.ar.a(canvas, (a.width() - b.ar.f) / 2, (a.height() - b.ar.g) / 2);
            invalidate();
        }

        public a(Activity activity)
        {
            b = v.this;
            super(activity);
            a = new Rect();
        }
    }

    final class b extends Handler
    {

        final v a;

        private void a()
        {
            sendMessageDelayed(obtainMessage(), 500L);
        }

        public final void handleMessage(Message message)
        {
            a();
            while (a.d.isFinishing() || a.d.B == null) 
            {
                return;
            }
            this;
            JVM INSTR monitorenter ;
            if (a.ac != null && a.ac.a() && !a.d.B.isPlaying())
            {
                a.ac = null;
                a.t = 0;
                if (a.d.B != null)
                {
                    a.d.B.a();
                }
                a.d.m = true;
                a.c();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            message;
            this;
            JVM INSTR monitorexit ;
            throw message;
        }

        b()
        {
            a = v.this;
            super();
            a();
        }
    }


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
    b aH;
    Handler aI;
    String aa;
    String ab;
    s.b ac;
    Paint ad;
    Paint ae;
    Paint af;
    Paint ag;
    Rect ah;
    c ai;
    c aj;
    c ak;
    c al;
    c am;
    c an;
    c ao;
    c ap;
    c aq;
    c ar;
    c as;
    c at[];
    c au[];
    ak av;
    String aw[];
    float ay;
    float az;
    WebView b;
    View c;
    e d;
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

    v(e e1)
    {
        super(e1);
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
        U = q.c.a.b;
        ad = new Paint();
        ae = new Paint(1);
        af = new Paint(1);
        ag = new Paint(1);
        ah = new Rect();
        at = new c[4];
        au = new c[4];
        aw = new String[4];
        aF = new Paint(1);
        aG = new RectF();
        aH = new b();
        aI = new Handler() {

            final v a;

            public final void handleMessage(Message message)
            {
_L2:
                return;
                if (a.d.isFinishing() || a.d.B == null) goto _L2; else goto _L1
_L1:
                v v1;
                int i1;
                v1 = a;
                i1 = message.what;
                if (!v1.C && i1 != 10) goto _L2; else goto _L3
_L3:
                try
                {
                    v1.C = false;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    v1.C = true;
                    return;
                }
                i1;
                JVM INSTR tableswitch 1 10: default 727
            //                           1 147
            //                           2 283
            //                           3 419
            //                           4 693
            //                           5 112
            //                           6 112
            //                           7 112
            //                           8 112
            //                           9 112
            //                           10 715;
                   goto _L4 _L5 _L6 _L7 _L8 _L4 _L4 _L4 _L4 _L4 _L9
_L9:
                break MISSING_BLOCK_LABEL_715;
_L4:
                v1.t = 0;
_L10:
                (new Handler()).postDelayed(v1. new Runnable() {

                    final v a;

                    public final void run()
                    {
                        a.C = true;
                    }

            
            {
                a = v.this;
                super();
            }
                }, 1500L);
                return;
_L5:
label0:
                {
                    v1.t = 0;
                    com.jirbo.adcolony.q.a("info", (new StringBuilder("{\"ad_slot\":")).append(q.A.c.k.c).append("}").toString(), v1.d.D);
                    message = com.jirbo.adcolony.q.g("info_url");
                    aj.b.a("INFO ").b(message);
                    if (!message.startsWith("market:") && !message.startsWith("amzn:"))
                    {
                        break label0;
                    }
                    v1.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(message)));
                }
                  goto _L10
                com.jirbo.adcolony.AdColonyBrowser.a = message;
                v1.d.startActivity(new Intent(v1.d, com/jirbo/adcolony/AdColonyBrowser));
                  goto _L10
_L6:
label1:
                {
                    v1.t = 0;
                    com.jirbo.adcolony.q.a("download", (new StringBuilder("{\"ad_slot\":")).append(q.A.c.k.c).append("}").toString(), v1.d.D);
                    message = com.jirbo.adcolony.q.g("download_url");
                    aj.b.a("DOWNLOAD ").b(message);
                    if (!message.startsWith("market:") && !message.startsWith("amzn:"))
                    {
                        break label1;
                    }
                    v1.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(message)));
                }
                  goto _L10
                com.jirbo.adcolony.AdColonyBrowser.a = message;
                v1.d.startActivity(new Intent(v1.d, com/jirbo/adcolony/AdColonyBrowser));
                  goto _L10
_L7:
                boolean flag1;
                v1.t = 0;
                com.jirbo.adcolony.q.a("replay", v1.d.D);
                e.e = true;
                e.d = false;
                com.jirbo.adcolony.e.a = 0;
                v1.Q = false;
                message = new View(v1.d);
                message.setBackgroundColor(0xff000000);
                v1.d.K.addView(message, new android.widget.FrameLayout.LayoutParams(v1.d.s, v1.d.t, 17));
                (new Handler()).postDelayed(v1. new Runnable(message) {

                    final View a;
                    final v b;

                    public final void run()
                    {
                        if (b.P)
                        {
                            b.d.L.setVisibility(4);
                        }
                        b.d.K.removeView(a);
                    }

            
            {
                b = v.this;
                a = view;
                super();
            }
                }, 900L);
                v1.d.B.start();
                flag1 = v1.d.G;
                if (!flag1) goto _L12; else goto _L11
_L11:
                v1.d.E = com.immersion.hapticmediasdk.b.a(v1.d);
                v1.d.E.a(v1.d.F);
_L13:
                if (v1.d.E == null)
                {
                    v1.d.G = false;
                }
                if (v1.d.G)
                {
                    v1.d.E.c();
                }
_L12:
                q.c.a(v1.d.D);
                v1.d.B.requestFocus();
                v1.d.B.setBackgroundColor(0);
                v1.d.B.setVisibility(0);
                v1.a(false);
                v1.invalidate();
                  goto _L10
                message;
                v1.d.G = false;
                  goto _L13
_L8:
                v1.t = 0;
                v1.d.B.a();
                v1.c();
                  goto _L10
                v1.t = 0;
                v1.d();
                  goto _L10
            }

            
            {
                a = v.this;
                super();
            }
        };
        d = e1;
        L = q.c.a.s;
        if (q.A != null)
        {
            L = L | q.A.d.u.l.a;
            q.A.i = q.A.j;
        }
        x = e1.getResources().getDisplayMetrics().density;
        P = q.F;
        if (com.jirbo.adcolony.q.a != null)
        {
            q.K = com.jirbo.adcolony.q.a;
        }
        if (q.A != null && q.A.d.t.d)
        {
            float f1;
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
            ai = new c(com.jirbo.adcolony.q.g("end_card_filepath"));
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
            at[0] = new c(com.jirbo.adcolony.q.g("info_image_normal"));
            at[1] = new c(com.jirbo.adcolony.q.g("download_image_normal"));
            at[2] = new c(com.jirbo.adcolony.q.g("replay_image_normal"));
            at[3] = new c(com.jirbo.adcolony.q.g("continue_image_normal"));
            au[0] = new c(com.jirbo.adcolony.q.g("info_image_down"), '\0');
            au[1] = new c(com.jirbo.adcolony.q.g("download_image_down"), '\0');
            au[2] = new c(com.jirbo.adcolony.q.g("replay_image_down"), '\0');
            au[3] = new c(com.jirbo.adcolony.q.g("continue_image_down"), '\0');
            aw[0] = "Info";
            aw[1] = "Download";
            aw[2] = "Replay";
            aw[3] = "Continue";
        } else
        if (P)
        {
            an = new c(com.jirbo.adcolony.q.g("reload_image_normal"));
            al = new c(com.jirbo.adcolony.q.g("close_image_normal"));
            am = new c(com.jirbo.adcolony.q.g("close_image_down"));
            ao = new c(com.jirbo.adcolony.q.g("reload_image_down"));
            ar = new c(com.jirbo.adcolony.q.g("browser_icon"));
            c = new a(e1);
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

                final v a;

                public final boolean onConsoleMessage(ConsoleMessage consolemessage)
                {
                    String s2 = consolemessage.sourceId();
                    if (s2 != null) goto _L2; else goto _L1
_L1:
                    String s1 = "Internal";
_L4:
                    aj.b.a(consolemessage.message()).a(" [").a(s1).a(" line ").a(consolemessage.lineNumber()).b("]");
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

                public final void onGeolocationPermissionsShowPrompt(String s1, android.webkit.GeolocationPermissions.Callback callback)
                {
                    callback.invoke(s1, true, false);
                }

            
            {
                a = v.this;
                super();
            }
            });
            d.L = new FrameLayout(d);
            if (com.jirbo.adcolony.q.f("hardware_acceleration_disabled"))
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
            av = new ak(d, a, d);
            obj = new WebViewClient() {

                String a;
                final v b;

                public final void onLoadResource(WebView webview, String s1)
                {
                    com.jirbo.adcolony.aj.a.a("DEC onLoad: ").b(s1);
                    if (s1.equals(a))
                    {
                        com.jirbo.adcolony.aj.a.b("DEC disabling mouse events");
                        b.a("if (typeof(CN) != 'undefined' && CN.div) {\n  if (typeof(cn_dispatch_on_touch_begin) != 'undefined') CN.div.removeEventListener('mousedown',  cn_dispatch_on_touch_begin, true);\n  if (typeof(cn_dispatch_on_touch_end) != 'undefined')   CN.div.removeEventListener('mouseup',  cn_dispatch_on_touch_end, true);\n  if (typeof(cn_dispatch_on_touch_move) != 'undefined')  CN.div.removeEventListener('mousemove',  cn_dispatch_on_touch_move, true);\n}\n");
                    }
                }

                public final void onPageFinished(WebView webview, String s1)
                {
                    if (s1.equals(a) || q.K.startsWith("<"))
                    {
                        b.D = false;
                        b.d.k = true;
                        b.w = System.currentTimeMillis();
                        b.d.o = (double)(b.w - b.v) / 1000D;
                    }
                    b.d.K.removeView(b.c);
                }

                public final void onPageStarted(WebView webview, String s1, Bitmap bitmap)
                {
                    if (s1.equals(a))
                    {
                        b.d.j = true;
                        b.v = System.currentTimeMillis();
                    }
                }

                public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
                {
                    com.jirbo.adcolony.aj.a.a("DEC request: ").b(s1);
                    if (!s1.contains("mraid:")) goto _L2; else goto _L1
_L1:
                    ak ak1;
                    Object obj1;
                    ak1 = b.av;
                    webview = s1.replace("mraid://", "");
                    int j1;
                    if (webview.contains("?"))
                    {
                        s1 = webview.split("\\?");
                        webview = s1[0];
                    } else
                    {
                        s1 = null;
                    }
                    if (s1 != null)
                    {
                        s1 = s1[1].split("&");
                    } else
                    {
                        s1 = new String[0];
                    }
                    obj1 = new HashMap();
                    j1 = s1.length;
                    for (int i1 = 0; i1 < j1; i1++)
                    {
                        String s2 = s1[i1];
                        ((HashMap) (obj1)).put(s2.split("=")[0], s2.split("=")[1]);
                    }

                    ak1.f = q.A;
                    ak1.g = (new StringBuilder("{\"ad_slot\":")).append(ak1.f.c.k.d).append("}").toString();
                    if (!webview.equals("send_adc_event")) goto _L4; else goto _L3
_L3:
                    webview = (String)((HashMap) (obj1)).get("type");
                    com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandSendADCEvent called with type: ").b(webview);
                    com.jirbo.adcolony.q.a(webview, ak1.c.D);
_L5:
                    ak1.a("adc_bridge.nativeCallComplete()");
                    return true;
_L4:
                    if (webview.equals("close"))
                    {
                        com.jirbo.adcolony.aj.a.b("ADC [info] MRAIDCommandClose called");
                        ak1.b.finish();
                        q.D.a(ak1.c.D);
                    } else
                    if (webview.equals("open_store") && !q.r)
                    {
                        webview = (String)((HashMap) (obj1)).get("item");
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandOpenStore called with item: ").b(webview);
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        com.jirbo.adcolony.q.a("html5_interaction", ak1.g, ak1.c.D);
                        webview = com.jirbo.adcolony.ak.b(webview);
                        try
                        {
                            webview = new Intent("android.intent.action.VIEW", Uri.parse(webview));
                            ak1.b.startActivity(webview);
                        }
                        // Misplaced declaration of an exception variable
                        catch (WebView webview)
                        {
                            Toast.makeText(ak1.b, "Unable to open store.", 0).show();
                        }
                    } else
                    if (webview.equals("open") && !q.r)
                    {
                        webview = (String)((HashMap) (obj1)).get("url");
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandOpen called with url: ").b(webview);
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        s1 = com.jirbo.adcolony.ak.b(webview);
                        if (s1.startsWith("adcvideo"))
                        {
                            s1 = s1.replace("adcvideo", "http");
                            webview = ak1.c;
                            webview.x = s1;
                            e.f = true;
                            webview.J = new VideoView(webview);
                            s1 = Uri.parse(s1);
                            ((e) (webview)).J.setVideoURI(s1);
                            (new MediaController(webview)).setMediaPlayer(((e) (webview)).J);
                            ((e) (webview)).J.setLayoutParams(new android.widget.FrameLayout.LayoutParams(((e) (webview)).s, ((e) (webview)).t, 17));
                            ((e) (webview)).M.addView(((e) (webview)).J);
                            ((e) (webview)).M.addView(((e) (webview)).P);
                            webview.setContentView(((e) (webview)).M);
                            ((e) (webview)).J.setOnCompletionListener(new e._cls2(webview));
                            ((e) (webview)).J.setOnPreparedListener(new e._cls3(webview));
                            ((e) (webview)).J.start();
                        } else
                        if (webview.contains("youtube"))
                        {
                            try
                            {
                                s1 = s1.substring(s1.indexOf('v') + 2);
                                s1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("vnd.youtube:")).append(s1).toString()));
                                ak1.b.startActivity(s1);
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s1)
                            {
                                s1 = com.jirbo.adcolony.ak.b(webview);
                                webview = s1;
                                if (s1.contains("safari"))
                                {
                                    webview = s1.replace("safari", "http");
                                }
                                webview = new Intent("android.intent.action.VIEW", Uri.parse(webview));
                                ak1.b.startActivity(webview);
                            }
                        } else
                        if (s1.startsWith("browser"))
                        {
                            com.jirbo.adcolony.q.a("html5_interaction", ak1.c.D);
                            webview = new Intent("android.intent.action.VIEW", Uri.parse(s1.replace("browser", "http")));
                            ak1.b.startActivity(webview);
                        } else
                        {
                            com.jirbo.adcolony.q.a("html5_interaction", ak1.g, ak1.c.D);
                            com.jirbo.adcolony.AdColonyBrowser.a = s1;
                            webview = new Intent(ak1.b, com/jirbo/adcolony/AdColonyBrowser);
                            ak1.b.startActivity(webview);
                        }
                    } else
                    if (webview.equals("expand"))
                    {
                        webview = (String)((HashMap) (obj1)).get("url");
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandExpand called with url: ").b(webview);
                        ak1.a("adc_bridge.fireChangeEvent({state:'expanded'});");
                    } else
                    if (webview.equals("create_calendar_event") && !q.r)
                    {
                        ak1.a(((HashMap) (obj1)));
                    } else
                    if (webview.equals("mail") && !q.r)
                    {
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandMail called with parameters: ").b(obj1);
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        webview = com.jirbo.adcolony.ak.b((String)(String)((HashMap) (obj1)).get("subject"));
                        s1 = com.jirbo.adcolony.ak.b((String)(String)((HashMap) (obj1)).get("body"));
                        obj1 = com.jirbo.adcolony.ak.b((String)(String)((HashMap) (obj1)).get("to"));
                        com.jirbo.adcolony.q.a("html5_interaction", ak1.g, ak1.c.D);
                        try
                        {
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("plain/text");
                            intent.putExtra("android.intent.extra.SUBJECT", webview).putExtra("android.intent.extra.TEXT", s1).putExtra("android.intent.extra.EMAIL", new String[] {
                                obj1
                            });
                            ak1.b.startActivity(intent);
                        }
                        // Misplaced declaration of an exception variable
                        catch (WebView webview)
                        {
                            webview.printStackTrace();
                            Toast.makeText(ak1.b, "Unable to launch email client.", 0).show();
                        }
                    } else
                    if (webview.equals("sms") && !q.r)
                    {
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandSMS called with parameters: ").b(obj1);
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        webview = com.jirbo.adcolony.ak.b((String)(String)((HashMap) (obj1)).get("to"));
                        s1 = com.jirbo.adcolony.ak.b((String)(String)((HashMap) (obj1)).get("body"));
                        com.jirbo.adcolony.q.a("html5_interaction", ak1.g, ak1.c.D);
                        try
                        {
                            webview = (new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("sms:")).append(webview).toString()))).putExtra("sms_body", s1);
                            ak1.b.startActivity(webview);
                        }
                        // Misplaced declaration of an exception variable
                        catch (WebView webview)
                        {
                            webview.printStackTrace();
                            Toast.makeText(ak1.b, "Failed to create sms.", 0).show();
                        }
                    } else
                    if (webview.equals("tel") && !q.r)
                    {
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandTel called with parameters: ").b(obj1);
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        webview = com.jirbo.adcolony.ak.b((String)(String)((HashMap) (obj1)).get("number"));
                        com.jirbo.adcolony.q.a("html5_interaction", ak1.g, ak1.c.D);
                        try
                        {
                            webview = (new Intent("android.intent.action.DIAL")).setData(Uri.parse((new StringBuilder("tel:")).append(webview).toString()));
                            ak1.b.startActivity(webview);
                        }
                        // Misplaced declaration of an exception variable
                        catch (WebView webview)
                        {
                            Toast.makeText(ak1.b, "Failed to dial number.", 0).show();
                        }
                    } else
                    if (webview.equals("custom_event"))
                    {
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandSendCustomADCEvent called with parameters: ").b(obj1);
                        webview = com.jirbo.adcolony.ak.b((String)((HashMap) (obj1)).get("event_type"));
                        com.jirbo.adcolony.q.a("custom_event", (new StringBuilder("{\"event_type\":\"")).append(webview).append("\",\"ad_slot\":").append(ak1.f.c.k.d).append("}").toString(), ak1.c.D);
                    } else
                    if (webview.equals("launch_app") && !q.r)
                    {
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandLaunchApp called with parameters: ").b(obj1);
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        webview = com.jirbo.adcolony.ak.b((String)(String)((HashMap) (obj1)).get("handle"));
                        com.jirbo.adcolony.q.a("html5_interaction", ak1.g, ak1.c.D);
                        try
                        {
                            webview = ak1.b.getPackageManager().getLaunchIntentForPackage(webview);
                            ak1.b.startActivity(webview);
                        }
                        // Misplaced declaration of an exception variable
                        catch (WebView webview)
                        {
                            Toast.makeText(ak1.b, "Failed to launch external application.", 0).show();
                        }
                    } else
                    if (webview.equals("check_app_presence"))
                    {
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandCheckAppPresence called with parameters: ").b(obj1);
                        webview = com.jirbo.adcolony.ak.b((String)(String)((HashMap) (obj1)).get("handle"));
                        boolean flag1 = com.jirbo.adcolony.s.a(webview);
                        ak1.a((new StringBuilder("adc_bridge.fireAppPresenceEvent('")).append(webview).append("',").append(flag1).append(")").toString());
                    } else
                    if (webview.equals("auto_play"))
                    {
                        com.jirbo.adcolony.aj.a.a("ADC [info] MRAIDCommandCheckAutoPlay called with parameters: ").b(obj1);
                    } else
                    if (webview.equals("save_screenshot"))
                    {
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        com.jirbo.adcolony.q.a("html5_interaction", ak1.g, ak1.c.D);
                        webview = (new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures/AdColony_Screenshots/AdColony_Screenshot_").append(System.currentTimeMillis()).append(".jpg").toString();
                        obj1 = ak1.a.getRootView();
                        ((View) (obj1)).setDrawingCacheEnabled(true);
                        s1 = Bitmap.createBitmap(((View) (obj1)).getDrawingCache());
                        ((View) (obj1)).setDrawingCacheEnabled(false);
                        obj1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures").toString());
                        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures/AdColony_Screenshots").toString());
                        try
                        {
                            ((File) (obj1)).mkdir();
                            file.mkdir();
                        }
                        catch (Exception exception1) { }
                        obj1 = new File(webview);
                        try
                        {
                            obj1 = new FileOutputStream(((File) (obj1)));
                            s1.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, ((OutputStream) (obj1)));
                            ((OutputStream) (obj1)).flush();
                            ((OutputStream) (obj1)).close();
                            s1 = ak1.b;
                            obj1 = new ak._cls2(ak1);
                            MediaScannerConnection.scanFile(s1, new String[] {
                                webview
                            }, null, ((android.media.MediaScannerConnection.OnScanCompletedListener) (obj1)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (WebView webview)
                        {
                            Toast.makeText(ak1.b, "Error saving screenshot.", 0).show();
                            com.jirbo.adcolony.aj.a.a("ADC [info] FileNotFoundException in MRAIDCommandTakeScreenshot");
                        }
                        // Misplaced declaration of an exception variable
                        catch (WebView webview)
                        {
                            Toast.makeText(ak1.b, "Error saving screenshot.", 0).show();
                            com.jirbo.adcolony.aj.a.a("ADC [info] IOException in MRAIDCommandTakeScreenshot");
                        }
                    } else
                    if (webview.equals("social_post") && !q.r)
                    {
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        webview = com.jirbo.adcolony.ak.b((String)((HashMap) (obj1)).get("text"));
                        s1 = com.jirbo.adcolony.ak.b((String)((HashMap) (obj1)).get("url"));
                        obj1 = new Intent("android.intent.action.SEND");
                        ((Intent) (obj1)).setType("text/plain");
                        ((Intent) (obj1)).putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(webview).append(" ").append(s1).toString());
                        ak1.b.startActivity(Intent.createChooser(((Intent) (obj1)), "Share this post using..."));
                    } else
                    if (webview.equals("make_in_app_purchase") && !q.r)
                    {
                        q.r = true;
                        ak1.d.postDelayed(ak1.e, 1000L);
                        com.jirbo.adcolony.q.a("html5_interaction", ak1.g, ak1.c.D);
                        webview = com.jirbo.adcolony.ak.b((String)((HashMap) (obj1)).get("product"));
                        Integer.parseInt(com.jirbo.adcolony.ak.b((String)((HashMap) (obj1)).get("quantity")));
                        ak1.b.finish();
                        ak1.c.D.h = webview;
                        ak1.c.D.p = k.d;
                        q.D.a(ak1.c.D);
                    }
                    if (true) goto _L5; else goto _L2
_L2:
                    if (s1.contains("youtube"))
                    {
                        webview = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("vnd.youtube:")).append(s1).toString()));
                        webview.putExtra("VIDEO_ID", s1);
                        b.d.startActivity(webview);
                        return true;
                    }
                    return s1.contains("mraid.js");
                }

            
            {
                b = v.this;
                super();
                a = q.K;
            }
            };
            a.setWebViewClient(((WebViewClient) (obj)));
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                if (q.K.startsWith("<"))
                {
                    a.loadData(q.K, "text/html; charset=UTF-8", null);
                } else
                {
                    a.loadUrl(q.K);
                }
            }
            obj = com.jirbo.adcolony.s.a(q.L, "");
            com.jirbo.adcolony.aj.a.b("Injecting mraid");
            a(((String) (obj)));
            if (q.d)
            {
                obj = "true";
            } else
            {
                obj = "false";
            }
            a((new StringBuilder("var is_tablet=")).append(((String) (obj))).append(";").toString());
            if (q.d)
            {
                obj = "tablet";
            } else
            {
                obj = "phone";
            }
            a((new StringBuilder("adc_bridge.adc_version='")).append(q.N).append("'").toString());
            a((new StringBuilder("adc_bridge.os_version='")).append(q.M).append("'").toString());
            a("adc_bridge.os_name='android'");
            a((new StringBuilder("adc_bridge.device_type='")).append(((String) (obj))).append("'").toString());
            a("adc_bridge.fireChangeEvent({state:'default'});");
            a("adc_bridge.fireReadyEvent()");
            if (android.os.Build.VERSION.SDK_INT < 19)
            {
                if (q.K.startsWith("<"))
                {
                    a.loadData(q.K, "text/html; charset=UTF-8", null);
                } else
                {
                    a.loadUrl(q.K);
                }
            }
        }
        if (L)
        {
            aj = new c(com.jirbo.adcolony.q.g("skip_video_image_normal"));
            ak = new c(com.jirbo.adcolony.q.g("skip_video_image_down"));
            p = com.jirbo.adcolony.q.e("skip_delay") * 1000;
        }
        aF.setStyle(android.graphics.Paint.Style.STROKE);
        f1 = e1.getResources().getDisplayMetrics().density;
        aF.setStrokeWidth(2.0F * e1.getResources().getDisplayMetrics().density);
        aF.setColor(0xffcccccc);
        Q = false;
        K = false;
        R = false;
        if (q.A != null)
        {
            K = q.A.d.u.m.a;
            R = com.jirbo.adcolony.q.f("image_overlay_enabled");
        }
        if (K)
        {
            ap = new c(com.jirbo.adcolony.q.g("engagement_image_normal"));
            aq = new c(com.jirbo.adcolony.q.g("engagement_image_down"));
            aa = q.A.d.u.m.j;
            V = q.A.d.u.m.l;
            W = q.A.d.u.m.o;
            r = q.A.d.u.m.c;
            q = com.jirbo.adcolony.q.e("engagement_delay") * 1000;
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
                b = new WebView(e1);
                b.setBackgroundColor(0);
            }
            if (ap == null || aq == null)
            {
                K = false;
            }
        }
        if (R)
        {
            as = new c(com.jirbo.adcolony.q.g("image_overlay_filepath"));
            double d1;
            if (com.jirbo.adcolony.af.b())
            {
                d1 = ((double)r * ((double)x / 1.0D)) / (double)as.g;
            } else
            {
                d1 = ((double)r * ((double)x / 0.75D)) / (double)as.g;
            }
            as.a(d1, false);
        }
        if (e.d)
        {
            e();
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
        catch (e e1)
        {
            return;
        }
    }

    private int a(int i1, int j1)
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

    private static boolean a(c c1, int i1, int j1)
    {
        while (c1 == null || i1 >= c1.e.left + c1.f + 8 || i1 <= c1.e.left - 8 || j1 >= c1.e.top + c1.g + 8 || j1 <= c1.e.top - 8) 
        {
            return false;
        }
        return true;
    }

    private int b(String s1)
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

    private void e()
    {
        (new Handler()).postDelayed(new Runnable() {

            final v a;

            public final void run()
            {
                if (a.d.B != null)
                {
                    a.d.B.setVisibility(8);
                }
            }

            
            {
                a = v.this;
                super();
            }
        }, 300L);
        if (d.G)
        {
            d.E.f();
        }
        e.d = true;
        if (d.B != null)
        {
            d.B.a();
        }
        at.b = null;
        invalidate();
        I = false;
        invalidate();
    }

    public final void a()
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
                Object obj = com.jirbo.adcolony.q.b().getResources().getDisplayMetrics();
                float f1 = (float)((DisplayMetrics) (obj)).widthPixels / ((DisplayMetrics) (obj)).xdpi;
                float f2 = (float)((DisplayMetrics) (obj)).heightPixels / ((DisplayMetrics) (obj)).ydpi;
                d1 = Math.sqrt(f1 * f1 + f2 * f2);
                int i1 = ((DisplayMetrics) (obj)).widthPixels;
                int j1 = ((DisplayMetrics) (obj)).widthPixels;
                int k1 = ((DisplayMetrics) (obj)).heightPixels;
                d1 = Math.sqrt(((DisplayMetrics) (obj)).heightPixels * k1 + i1 * j1) / d1;
                if (d1 / 280D < 0.69999999999999996D)
                {
                    d1 = 0.69999999999999996D;
                } else
                {
                    d1 /= 280D;
                }
                f = d1;
                if (!com.jirbo.adcolony.af.b() && f == 0.69999999999999996D)
                {
                    f = 1.0D;
                }
                if (20D * f < 18D)
                {
                    f1 = 18F;
                } else
                {
                    f1 = (float)(20D * f);
                }
                if (20D * f < 18D)
                {
                    f2 = 18F;
                } else
                {
                    f2 = (float)(20D * f);
                }
                ae.setTextSize(f1);
                ag.setTextSize(f1);
                af.setTextSize(f2);
                if (K && ap != null && aq != null)
                {
                    ap.a(b((new StringBuilder()).append(V).append(ap.f * 2).toString()));
                    aq.a(b((new StringBuilder()).append(V).append(aq.f * 2).toString()));
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
                if (!com.jirbo.adcolony.af.b() && e == 0.90000000000000002D)
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
                ai.a(d1, false);
                obj = ai;
                i1 = d.s;
                j1 = d.t;
                ((c) (obj)).b((i1 - ((c) (obj)).f) / 2, (j1 - ((c) (obj)).g) / 2);
            }
            if (K && ap != null && aq != null)
            {
                if (ap != null && aq != null && ap.b != null && aq.b != null)
                {
                    i1 = (int)((double)ap.b.getHeight() * f);
                    j1 = (int)((double)aq.b.getHeight() * f);
                    ap.a(ap.f, i1);
                    aq.a(aq.f, j1);
                } else
                {
                    K = false;
                }
            }
            if (L)
            {
                aj.a(f, false);
                ak.a(f, false);
            }
        }
    }

    final void a(String s1)
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
            a.loadUrl((new StringBuilder("javascript:")).append(s1).toString());
            return;
        }
    }

    final void a(boolean flag)
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

    public final void b()
    {
        q.c.a(e.e, d.D);
        if (P && D && q.I)
        {
            d.K.addView(c);
            (new Handler()).postDelayed(new Runnable() {

                final v a;

                public final void run()
                {
                    if (a.D && a.d != null && a.P && a.a != null)
                    {
                        a.d.l = true;
                        a.c();
                    }
                }

            
            {
                a = v.this;
                super();
            }
            }, q.J * 1000);
        }
        if (q.G)
        {
            c();
        }
        com.jirbo.adcolony.q.a("card_shown", d.D);
        synchronized (aH)
        {
            ac = null;
            if (q.A.d.t.e)
            {
                ac = new s.b(q.A.d.t.g);
            }
        }
        if (P)
        {
            obj = new Handler();
            View view = new View(d);
            Runnable runnable = new Runnable(view) {

                final View a;
                final v b;

                public final void run()
                {
                    b.d.K.removeView(a);
                    b.a(true);
                    b.d.q = System.currentTimeMillis();
                }

            
            {
                b = v.this;
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
        e();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void b(boolean flag)
    {
        q.u = true;
        if (q.A.d() && !flag)
        {
            com.jirbo.adcolony.e.a = d.B.getCurrentPosition();
            at.b = new at(d, (o)q.A);
            return;
        }
        for (int i1 = 0; i1 < q.X.size(); i1++)
        {
            if (q.X.get(i1) != null)
            {
                ((n)q.X.get(i1)).a();
            }
        }

        d.finish();
        q.D.b(d.D);
        q.R = true;
        AdColonyBrowser.B = true;
    }

    final void c()
    {
        if (d == null || P && (a == null || d.L == null || d.K == null))
        {
            return;
        }
        q.u = true;
        d.r = System.currentTimeMillis();
        e e1 = d;
        e1.p = e1.p + (double)(d.r - d.q) / 1000D;
        q.R = true;
        for (int i1 = 0; i1 < q.X.size(); i1++)
        {
            if (q.X.get(i1) != null)
            {
                ((n)q.X.get(i1)).a();
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
        q.D.a(d.D);
        AdColonyBrowser.B = true;
    }

    final void d()
    {
        b(false);
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        b();
    }

    public final void onDraw(Canvas canvas)
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
        if (!e.d || !M)
        {
            break MISSING_BLOCK_LABEL_497;
        }
        canvas.drawARGB(d.w >> 24 & 0xff, 0, 0, 0);
        ai.a(canvas, (d.s - ai.f) / 2, (d.t - ai.g) / 2);
        i1 = (int)(186D * e);
        j2 = ai.e.left + i1;
        i1 = (int)(470D * e);
        k2 = ai.e.top + i1;
        l1 = 0;
_L6:
        if (l1 >= at.length) goto _L1; else goto _L3
_L3:
        if (t != l1 + 1 && (u != l1 + 1 || A || u == 0)) goto _L5; else goto _L4
_L4:
        au[l1].a(e, false);
        au[l1].a(canvas, j2, k2);
        i1 = (int)((double)j2 + 157D * e);
_L9:
        ae.setColor(-1);
        ae.clearShadowLayer();
        canvas.drawText(aw[l1], (float)at[l1].e.left + (float)(at[l1].f / 2), at[l1].e.top + at[l1].g, ae);
        l1++;
        j2 = i1;
          goto _L6
_L5:
        if (A) goto _L8; else goto _L7
_L7:
        i1 = j2;
        if (l1 + 1 == u) goto _L9; else goto _L8
_L8:
        at[l1].a(e, false);
        at[l1].a(canvas, j2, k2);
        i1 = (int)((double)j2 + 157D * e);
          goto _L9
        if (e.d && P)
        {
            al.a(f, false);
            am.a(f, false);
            an.a(f, false);
            ao.a(f, false);
            int j1;
            if (!q.d && i != 0)
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
            getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(this) {

                final View a;
                final v b;

                public final void onGlobalLayout()
                {
                    Object obj = new Rect();
                    a.getWindowVisibleDisplayFrame(((Rect) (obj)));
                    if (b.a != null)
                    {
                        v v1 = b;
                        int l2 = a.getRootView().getHeight() - (((Rect) (obj)).bottom - ((Rect) (obj)).top) - (b.d.t - b.a.getHeight()) / 2;
                        v1.h = l2;
                        if (l2 < 0)
                        {
                            v1.h = 0;
                        }
                    }
                    obj = b;
                    if (((v) (obj)).h >= 70 && !((v) (obj)).E)
                    {
                        obj.E = true;
                    } else
                    if (((v) (obj)).E && ((v) (obj)).h == 0)
                    {
                        obj.E = false;
                        return;
                    }
                }

            
            {
                b = v.this;
                a = view;
                super();
            }
            });
            return;
        }
        if (d.B == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        q.c.a((double)d.B.getCurrentPosition() / (double)d.B.getDuration(), d.D);
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
            if (!e.d)
            {
                ae.setColor(0xffcccccc);
                ae.setShadowLayer((int)(2D * e), 0.0F, 0.0F, 0xff000000);
                ae.setTextAlign(android.graphics.Paint.Align.CENTER);
                ae.setLinearText(true);
                canvas.drawText(String.valueOf(k1), aG.centerX(), (float)((double)aG.centerY() + (double)ae.getFontMetrics().bottom * 1.3500000000000001D), ae);
            }
            if (L && !e.d && N)
            {
                if (t == 10)
                {
                    ak.a(canvas, d.s - ak.f, (int)(e * 4D));
                } else
                {
                    aj.a(canvas, d.s - aj.f, (int)(e * 4D));
                }
            }
            if (K && O)
            {
                if (!G && !R)
                {
                    if (J)
                    {
                        aq.b((int)((float)(d.s - aq.f) - aC / 2.0F), d.t - aq.g - m - (int)(aC / 2.0F));
                        aq.a(canvas);
                    } else
                    {
                        ap.b((int)((float)(d.s - ap.f) - aC / 2.0F), d.t - ap.g - m - (int)(aC / 2.0F));
                        ap.a(canvas);
                    }
                    af.setTextAlign(android.graphics.Paint.Align.CENTER);
                    canvas.drawText(V, ap.e.centerX(), (float)((double)ap.e.centerY() + (double)af.getFontMetrics().bottom * 1.3500000000000001D), af);
                } else
                if (!G && R)
                {
                    as.b((int)((float)(d.s - as.f) - aC / 2.0F), d.t - as.g - m - (int)(aC / 2.0F));
                    as.a(canvas);
                }
            }
        }
        if (at.b != null)
        {
            at.b.onDraw(canvas);
        }
        if (!e.h) goto _L1; else goto _L10
_L10:
        invalidate();
        return;
    }

    public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        b(true);
        return true;
    }

    protected final void onSizeChanged(int i1, int j1, int k1, int l1)
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

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        int i2 = motionevent.getAction();
        if (at.b != null)
        {
            at.b.onTouchEvent(motionevent);
            return true;
        }
        int i1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        if (i2 == 0)
        {
            if (e.d && P)
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
            i2 = k1;
            int j2 = i1;
            if (e.d)
            {
                i2 = k1;
                j2 = i1;
                if (M)
                {
                    i1 = (int)((double)(motionevent.getX() - (float)ai.e.left) / (e * 2D));
                    k1 = (int)((double)(motionevent.getY() - (float)ai.e.top) / (e * 2D));
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
                if (e.d && P)
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
                i2 = k1;
                int k2 = i1;
                if (e.d)
                {
                    i2 = k1;
                    k2 = i1;
                    if (M)
                    {
                        int j1 = (int)((double)(motionevent.getX() - (float)ai.e.left) / (e * 2D));
                        int l1 = (int)((double)(motionevent.getY() - (float)ai.e.top) / (e * 2D));
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
                        d.D.p = k.c;
                        K = false;
                        S = true;
                        R = false;
                        d();
                    } else
                    {
                        com.jirbo.adcolony.AdColonyBrowser.a = aa;
                        d.startActivity(new Intent(d, com/jirbo/adcolony/AdColonyBrowser));
                    }
                    com.jirbo.adcolony.q.a("in_video_engagement", (new StringBuilder("{\"ad_slot\":")).append(q.A.c.k.c).append("}").toString(), d.D);
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
