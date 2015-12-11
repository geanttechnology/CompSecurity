// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            v, q, aj, e, 
//            ak, g, x, AdColonyBrowser, 
//            s, k

final class a extends WebViewClient
{

    String a;
    final v b;

    public final void onLoadResource(WebView webview, String s1)
    {
        aj.a.a("DEC onLoad: ").b(s1);
        if (s1.equals(a))
        {
            aj.a.b("DEC disabling mouse events");
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
        aj.a.a("DEC request: ").b(s1);
        if (!s1.contains("mraid:")) goto _L2; else goto _L1
_L1:
        ak ak1;
        Object obj;
        ak1 = b.av;
        webview = s1.replace("mraid://", "");
        int j;
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
        obj = new HashMap();
        j = s1.length;
        for (int i = 0; i < j; i++)
        {
            String s2 = s1[i];
            ((HashMap) (obj)).put(s2.split("=")[0], s2.split("=")[1]);
        }

        ak1.f = q.A;
        ak1.g = (new StringBuilder("{\"ad_slot\":")).append(ak1.f.c.k.d).append("}").toString();
        if (!webview.equals("send_adc_event")) goto _L4; else goto _L3
_L3:
        webview = (String)((HashMap) (obj)).get("type");
        aj.a.a("ADC [info] MRAIDCommandSendADCEvent called with type: ").b(webview);
        q.a(webview, ak1.c.D);
_L5:
        ak1.a("adc_bridge.nativeCallComplete()");
        return true;
_L4:
        if (webview.equals("close"))
        {
            aj.a.b("ADC [info] MRAIDCommandClose called");
            ak1.b.finish();
            q.D.a(ak1.c.D);
        } else
        if (webview.equals("open_store") && !q.r)
        {
            webview = (String)((HashMap) (obj)).get("item");
            aj.a.a("ADC [info] MRAIDCommandOpenStore called with item: ").b(webview);
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            q.a("html5_interaction", ak1.g, ak1.c.D);
            webview = ak.b(webview);
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
            webview = (String)((HashMap) (obj)).get("url");
            aj.a.a("ADC [info] MRAIDCommandOpen called with url: ").b(webview);
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            s1 = ak.b(webview);
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
                ((e) (webview)).J.setLayoutParams(new android.widget.eLayout.LayoutParams(((e) (webview)).s, ((e) (webview)).t, 17));
                ((e) (webview)).M.addView(((e) (webview)).J);
                ((e) (webview)).M.addView(((e) (webview)).P);
                webview.setContentView(((e) (webview)).M);
                ((e) (webview)).J.setOnCompletionListener(new <init>(webview));
                ((e) (webview)).J.setOnPreparedListener(new <init>(webview));
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
                    s1 = ak.b(webview);
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
                q.a("html5_interaction", ak1.c.D);
                webview = new Intent("android.intent.action.VIEW", Uri.parse(s1.replace("browser", "http")));
                ak1.b.startActivity(webview);
            } else
            {
                q.a("html5_interaction", ak1.g, ak1.c.D);
                AdColonyBrowser.a = s1;
                webview = new Intent(ak1.b, com/jirbo/adcolony/AdColonyBrowser);
                ak1.b.startActivity(webview);
            }
        } else
        if (webview.equals("expand"))
        {
            webview = (String)((HashMap) (obj)).get("url");
            aj.a.a("ADC [info] MRAIDCommandExpand called with url: ").b(webview);
            ak1.a("adc_bridge.fireChangeEvent({state:'expanded'});");
        } else
        if (webview.equals("create_calendar_event") && !q.r)
        {
            ak1.a(((HashMap) (obj)));
        } else
        if (webview.equals("mail") && !q.r)
        {
            aj.a.a("ADC [info] MRAIDCommandMail called with parameters: ").b(obj);
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            webview = ak.b((String)(String)((HashMap) (obj)).get("subject"));
            s1 = ak.b((String)(String)((HashMap) (obj)).get("body"));
            obj = ak.b((String)(String)((HashMap) (obj)).get("to"));
            q.a("html5_interaction", ak1.g, ak1.c.D);
            try
            {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("plain/text");
                intent.putExtra("android.intent.extra.SUBJECT", webview).putExtra("android.intent.extra.TEXT", s1).putExtra("android.intent.extra.EMAIL", new String[] {
                    obj
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
            aj.a.a("ADC [info] MRAIDCommandSMS called with parameters: ").b(obj);
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            webview = ak.b((String)(String)((HashMap) (obj)).get("to"));
            s1 = ak.b((String)(String)((HashMap) (obj)).get("body"));
            q.a("html5_interaction", ak1.g, ak1.c.D);
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
            aj.a.a("ADC [info] MRAIDCommandTel called with parameters: ").b(obj);
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            webview = ak.b((String)(String)((HashMap) (obj)).get("number"));
            q.a("html5_interaction", ak1.g, ak1.c.D);
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
            aj.a.a("ADC [info] MRAIDCommandSendCustomADCEvent called with parameters: ").b(obj);
            webview = ak.b((String)((HashMap) (obj)).get("event_type"));
            q.a("custom_event", (new StringBuilder("{\"event_type\":\"")).append(webview).append("\",\"ad_slot\":").append(ak1.f.c.k.d).append("}").toString(), ak1.c.D);
        } else
        if (webview.equals("launch_app") && !q.r)
        {
            aj.a.a("ADC [info] MRAIDCommandLaunchApp called with parameters: ").b(obj);
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            webview = ak.b((String)(String)((HashMap) (obj)).get("handle"));
            q.a("html5_interaction", ak1.g, ak1.c.D);
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
            aj.a.a("ADC [info] MRAIDCommandCheckAppPresence called with parameters: ").b(obj);
            webview = ak.b((String)(String)((HashMap) (obj)).get("handle"));
            boolean flag = s.a(webview);
            ak1.a((new StringBuilder("adc_bridge.fireAppPresenceEvent('")).append(webview).append("',").append(flag).append(")").toString());
        } else
        if (webview.equals("auto_play"))
        {
            aj.a.a("ADC [info] MRAIDCommandCheckAutoPlay called with parameters: ").b(obj);
        } else
        if (webview.equals("save_screenshot"))
        {
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            q.a("html5_interaction", ak1.g, ak1.c.D);
            webview = (new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures/AdColony_Screenshots/AdColony_Screenshot_").append(System.currentTimeMillis()).append(".jpg").toString();
            obj = ak1.a.getRootView();
            ((View) (obj)).setDrawingCacheEnabled(true);
            s1 = Bitmap.createBitmap(((View) (obj)).getDrawingCache());
            ((View) (obj)).setDrawingCacheEnabled(false);
            obj = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures").toString());
            File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures/AdColony_Screenshots").toString());
            try
            {
                ((File) (obj)).mkdir();
                file.mkdir();
            }
            catch (Exception exception) { }
            obj = new File(webview);
            try
            {
                obj = new FileOutputStream(((File) (obj)));
                s1.compress(android.graphics.ap.CompressFormat.JPEG, 90, ((OutputStream) (obj)));
                ((OutputStream) (obj)).flush();
                ((OutputStream) (obj)).close();
                s1 = ak1.b;
                obj = new (ak1);
                MediaScannerConnection.scanFile(s1, new String[] {
                    webview
                }, null, ((android.media.aScannerConnection.OnScanCompletedListener) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Toast.makeText(ak1.b, "Error saving screenshot.", 0).show();
                aj.a.a("ADC [info] FileNotFoundException in MRAIDCommandTakeScreenshot");
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Toast.makeText(ak1.b, "Error saving screenshot.", 0).show();
                aj.a.a("ADC [info] IOException in MRAIDCommandTakeScreenshot");
            }
        } else
        if (webview.equals("social_post") && !q.r)
        {
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            webview = ak.b((String)((HashMap) (obj)).get("text"));
            s1 = ak.b((String)((HashMap) (obj)).get("url"));
            obj = new Intent("android.intent.action.SEND");
            ((Intent) (obj)).setType("text/plain");
            ((Intent) (obj)).putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(webview).append(" ").append(s1).toString());
            ak1.b.startActivity(Intent.createChooser(((Intent) (obj)), "Share this post using..."));
        } else
        if (webview.equals("make_in_app_purchase") && !q.r)
        {
            q.r = true;
            ak1.d.postDelayed(ak1.e, 1000L);
            q.a("html5_interaction", ak1.g, ak1.c.D);
            webview = ak.b((String)((HashMap) (obj)).get("product"));
            Integer.parseInt(ak.b((String)((HashMap) (obj)).get("quantity")));
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

    eption(v v1)
    {
        b = v1;
        super();
        a = q.K;
    }
}
