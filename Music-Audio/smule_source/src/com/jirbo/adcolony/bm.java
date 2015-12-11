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
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            ak, o, bl, s, 
//            bq, ay, z, al, 
//            AdColonyBrowser, ap

class bm
{

    WebView a;
    Activity b;
    o c;
    Handler d;
    Runnable e;
    s f;
    String g;

    public bm(o o1, WebView webview, Activity activity)
    {
        a = webview;
        b = activity;
        c = o1;
        d = new Handler();
        e = new Runnable() {

            final bm a;

            public void run()
            {
                ak.r = false;
            }

            
            {
                a = bm.this;
                super();
            }
        };
    }

    void a()
    {
        ak.r = true;
        d.postDelayed(e, 1000L);
        ak.a("html5_interaction", g, c.D);
        String s1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures/AdColony_Screenshots/").append("AdColony_Screenshot_").append(System.currentTimeMillis()).append(".jpg").toString();
        Object obj1 = a.getRootView();
        ((View) (obj1)).setDrawingCacheEnabled(true);
        Object obj = Bitmap.createBitmap(((View) (obj1)).getDrawingCache());
        ((View) (obj1)).setDrawingCacheEnabled(false);
        obj1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures").toString());
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/Pictures/AdColony_Screenshots").toString());
        try
        {
            ((File) (obj1)).mkdir();
            file.mkdir();
        }
        catch (Exception exception) { }
        obj1 = new File(s1);
        try
        {
            obj1 = new FileOutputStream(((File) (obj1)));
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, ((OutputStream) (obj1)));
            ((OutputStream) (obj1)).flush();
            ((OutputStream) (obj1)).close();
            obj = b;
            obj1 = new android.media.MediaScannerConnection.OnScanCompletedListener() {

                final bm a;

                public void onScanCompleted(String s2, Uri uri)
                {
                    Toast.makeText(a.b, "Screenshot saved to Gallery!", 0).show();
                }

            
            {
                a = bm.this;
                super();
            }
            };
            MediaScannerConnection.scanFile(((android.content.Context) (obj)), new String[] {
                s1
            }, null, ((android.media.MediaScannerConnection.OnScanCompletedListener) (obj1)));
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Toast.makeText(b, "Error saving screenshot.", 0).show();
            bl.a.a("ADC [info] FileNotFoundException in MRAIDCommandTakeScreenshot");
            return;
        }
        catch (IOException ioexception)
        {
            Toast.makeText(b, "Error saving screenshot.", 0).show();
        }
        bl.a.a("ADC [info] IOException in MRAIDCommandTakeScreenshot");
    }

    void a(String s1)
    {
        HashMap hashmap;
        s1 = s1.replace("mraid://", "");
        String as[];
        int l;
        if (s1.contains("?"))
        {
            as = s1.split("\\?");
            s1 = as[0];
        } else
        {
            as = null;
        }
        if (as != null)
        {
            as = as[1].split("&");
        } else
        {
            as = new String[0];
        }
        hashmap = new HashMap();
        l = as.length;
        for (int k = 0; k < l; k++)
        {
            String s2 = as[k];
            hashmap.put(s2.split("=")[0], s2.split("=")[1]);
        }

        f = ak.A;
        g = (new StringBuilder()).append("{\"ad_slot\":").append(f.c.k.d).append("}").toString();
        if (!s1.equals("send_adc_event")) goto _L2; else goto _L1
_L1:
        b((String)hashmap.get("type"));
_L4:
        f("adc_bridge.nativeCallComplete()");
        return;
_L2:
        if (s1.equals("close"))
        {
            b();
        } else
        if (s1.equals("open_store") && !ak.r)
        {
            c((String)hashmap.get("item"));
        } else
        if (s1.equals("open") && !ak.r)
        {
            d((String)hashmap.get("url"));
        } else
        if (s1.equals("expand"))
        {
            e((String)hashmap.get("url"));
        } else
        if (s1.equals("create_calendar_event") && !ak.r)
        {
            c(hashmap);
        } else
        if (s1.equals("mail") && !ak.r)
        {
            d(hashmap);
        } else
        if (s1.equals("sms") && !ak.r)
        {
            e(hashmap);
        } else
        if (s1.equals("tel") && !ak.r)
        {
            f(hashmap);
        } else
        if (s1.equals("custom_event"))
        {
            g(hashmap);
        } else
        if (s1.equals("launch_app") && !ak.r)
        {
            h(hashmap);
        } else
        if (s1.equals("check_app_presence"))
        {
            i(hashmap);
        } else
        if (s1.equals("auto_play"))
        {
            j(hashmap);
        } else
        if (s1.equals("save_screenshot"))
        {
            a();
        } else
        if (s1.equals("social_post") && !ak.r)
        {
            b(hashmap);
        } else
        if (s1.equals("make_in_app_purchase") && !ak.r)
        {
            a(hashmap);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void a(HashMap hashmap)
    {
        ak.r = true;
        d.postDelayed(e, 1000L);
        ak.a("html5_interaction", g, c.D);
        String s1 = g((String)hashmap.get("product"));
        Integer.parseInt(g((String)hashmap.get("quantity")));
        b.finish();
        c.D.h = s1;
        c.D.p = z.d;
        ak.D.a(c.D);
    }

    void b()
    {
        bl.a.b("ADC [info] MRAIDCommandClose called");
        b.finish();
        ak.D.a(c.D);
    }

    void b(String s1)
    {
        bl.a.a("ADC [info] MRAIDCommandSendADCEvent called with type: ").b(s1);
        ak.a(s1, c.D);
    }

    void b(HashMap hashmap)
    {
        ak.r = true;
        d.postDelayed(e, 1000L);
        String s1 = g((String)hashmap.get("text"));
        hashmap = g((String)hashmap.get("url"));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s1).append(" ").append(hashmap).toString());
        b.startActivity(Intent.createChooser(intent, "Share this post using..."));
    }

    void c(String s1)
    {
        bl.a.a("ADC [info] MRAIDCommandOpenStore called with item: ").b(s1);
        ak.r = true;
        d.postDelayed(e, 1000L);
        ak.a("html5_interaction", g, c.D);
        s1 = g(s1);
        try
        {
            s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
            b.startActivity(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Toast.makeText(b, "Unable to open store.", 0).show();
        }
    }

    void c(HashMap hashmap)
    {
        Object obj1;
        String s2;
        Object obj2;
        Object obj3;
        Object obj4;
        String s3;
        String s4;
        SimpleDateFormat simpledateformat;
        SimpleDateFormat simpledateformat1;
        String s5;
        bl.a.a("ADC [info] MRAIDCommandCreateCalendarEvent called with parameters: ").b(hashmap);
        ak.r = true;
        d.postDelayed(e, 1000L);
        ak.a("html5_interaction", g, c.D);
        simpledateformat1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ");
        obj4 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        s3 = g((String)(String)hashmap.get("description"));
        g((String)(String)hashmap.get("location"));
        obj3 = g((String)(String)hashmap.get("start"));
        s5 = g((String)(String)hashmap.get("end"));
        String s1 = g((String)(String)hashmap.get("summary"));
        s4 = g((String)(String)hashmap.get("recurrence"));
        s2 = "";
        obj1 = "";
        obj2 = new HashMap();
        s4 = s4.replace("\"", "").replace("{", "").replace("}", "");
        if (!s4.equals(""))
        {
            obj1 = s4.split(",");
            int l = obj1.length;
            for (int k = 0; k < l; k++)
            {
                s2 = obj1[k];
                ((HashMap) (obj2)).put(s2.substring(0, s2.indexOf(":")), s2.substring(s2.indexOf(":") + 1, s2.length()));
            }

            s2 = g((String)(String)((HashMap) (obj2)).get("expires"));
            obj1 = g((String)(String)((HashMap) (obj2)).get("frequency")).toUpperCase();
            bl.a.a("Calendar Recurrence - ").b(s4);
            bl.a.a("Calendar Recurrence - frequency = ").b(obj1);
            bl.a.a("Calendar Recurrence - expires =  ").b(s2);
        }
        obj2 = s1;
        if (s1.equals(""))
        {
            obj2 = g((String)(String)hashmap.get("description"));
        }
        hashmap = simpledateformat1.parse(((String) (obj3)));
        Object obj = simpledateformat1.parse(s5);
_L5:
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_900;
        }
        obj3 = ((DateFormat) (obj4)).parse(((String) (obj3)));
        hashmap = ((HashMap) (obj3));
        obj4 = ((DateFormat) (obj4)).parse(s5);
        obj = obj4;
        hashmap = ((HashMap) (obj3));
        obj3 = obj;
        break MISSING_BLOCK_LABEL_496;
        hashmap;
        hashmap = null;
_L1:
        obj = null;
        continue; /* Loop/switch isn't completed */
        obj3;
        obj3 = obj;
_L3:
        Object obj5;
        try
        {
            obj = simpledateformat1.parse(s2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        obj5 = obj;
        long l1;
        long l2;
        long l3;
        if (obj == null)
        {
            try
            {
                obj5 = simpledateformat.parse(s2);
            }
            catch (Exception exception)
            {
                obj5 = obj;
            }
        }
        if (hashmap == null)
        {
            Toast.makeText(b, "Unable to create Calendar Event.", 0).show();
            return;
        }
        l2 = hashmap.getTime();
        l3 = ((Date) (obj3)).getTime();
        l1 = 0L;
        if (obj5 != null)
        {
            l1 = (((Date) (obj5)).getTime() - hashmap.getTime()) / 1000L;
        }
        if (((String) (obj1)).equals("DAILY"))
        {
            l1 = l1 / 0x15180L + 1L;
        } else
        if (((String) (obj1)).equals("WEEKLY"))
        {
            l1 = l1 / 0x93a80L + 1L;
        } else
        if (((String) (obj1)).equals("MONTHLY"))
        {
            l1 = l1 / 0x2820a8L + 1L;
        } else
        if (((String) (obj1)).equals("YEARLY"))
        {
            l1 = l1 / 0x1e187e0L + 1L;
        } else
        {
            l1 = 0L;
        }
        if (!s4.equals(""))
        {
            hashmap = (new Intent("android.intent.action.EDIT")).setType("vnd.android.cursor.item/event").putExtra("title", ((String) (obj2))).putExtra("description", s3).putExtra("beginTime", l2).putExtra("endTime", l3).putExtra("rrule", (new StringBuilder()).append("FREQ=").append(((String) (obj1))).append(";").append("COUNT=").append(l1).toString());
            bl.a.a("Calendar Recurrence - count = ").b(l1);
        } else
        {
            hashmap = (new Intent("android.intent.action.EDIT")).setType("vnd.android.cursor.item/event").putExtra("title", ((String) (obj2))).putExtra("description", s3).putExtra("beginTime", l2).putExtra("endTime", l3);
        }
        try
        {
            b.startActivity(hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Toast.makeText(b, "Unable to create Calendar Event.", 0).show();
        }
        return;
        obj;
          goto _L1
        obj3 = obj;
        if (true) goto _L3; else goto _L2
_L2:
        if (true) goto _L5; else goto _L4
_L4:
    }

    void d(String s1)
    {
        bl.a.a("ADC [info] MRAIDCommandOpen called with url: ").b(s1);
        ak.r = true;
        d.postDelayed(e, 1000L);
        Object obj = g(s1);
        if (((String) (obj)).startsWith("adcvideo"))
        {
            s1 = ((String) (obj)).replace("adcvideo", "http");
            c.a(s1);
            return;
        }
        if (s1.contains("youtube"))
        {
            try
            {
                obj = ((String) (obj)).substring(((String) (obj)).indexOf('v') + 2);
                obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("vnd.youtube:").append(((String) (obj))).toString()));
                b.startActivity(((Intent) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = g(s1);
            }
            s1 = ((String) (obj));
            if (((String) (obj)).contains("safari"))
            {
                s1 = ((String) (obj)).replace("safari", "http");
            }
            s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
            b.startActivity(s1);
            return;
        }
        if (((String) (obj)).startsWith("browser"))
        {
            ak.a("html5_interaction", c.D);
            s1 = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj)).replace("browser", "http")));
            b.startActivity(s1);
            return;
        } else
        {
            ak.a("html5_interaction", g, c.D);
            AdColonyBrowser.a = ((String) (obj));
            s1 = new Intent(b, com/jirbo/adcolony/AdColonyBrowser);
            b.startActivity(s1);
            return;
        }
    }

    void d(HashMap hashmap)
    {
        bl.a.a("ADC [info] MRAIDCommandMail called with parameters: ").b(hashmap);
        ak.r = true;
        d.postDelayed(e, 1000L);
        String s1 = g((String)(String)hashmap.get("subject"));
        String s2 = g((String)(String)hashmap.get("body"));
        hashmap = g((String)(String)hashmap.get("to"));
        ak.a("html5_interaction", g, c.D);
        try
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.SUBJECT", s1).putExtra("android.intent.extra.TEXT", s2).putExtra("android.intent.extra.EMAIL", new String[] {
                hashmap
            });
            b.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            hashmap.printStackTrace();
        }
        Toast.makeText(b, "Unable to launch email client.", 0).show();
    }

    void e(String s1)
    {
        bl.a.a("ADC [info] MRAIDCommandExpand called with url: ").b(s1);
        f("adc_bridge.fireChangeEvent({state:'expanded'});");
    }

    void e(HashMap hashmap)
    {
        bl.a.a("ADC [info] MRAIDCommandSMS called with parameters: ").b(hashmap);
        ak.r = true;
        d.postDelayed(e, 1000L);
        String s1 = g((String)(String)hashmap.get("to"));
        hashmap = g((String)(String)hashmap.get("body"));
        ak.a("html5_interaction", g, c.D);
        try
        {
            hashmap = (new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("sms:").append(s1).toString()))).putExtra("sms_body", hashmap);
            b.startActivity(hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            hashmap.printStackTrace();
        }
        Toast.makeText(b, "Failed to create sms.", 0).show();
    }

    void f(String s1)
    {
        a.loadUrl((new StringBuilder()).append("javascript:").append(s1).toString());
    }

    void f(HashMap hashmap)
    {
        bl.a.a("ADC [info] MRAIDCommandTel called with parameters: ").b(hashmap);
        ak.r = true;
        d.postDelayed(e, 1000L);
        hashmap = g((String)(String)hashmap.get("number"));
        ak.a("html5_interaction", g, c.D);
        try
        {
            hashmap = (new Intent("android.intent.action.DIAL")).setData(Uri.parse((new StringBuilder()).append("tel:").append(hashmap).toString()));
            b.startActivity(hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Toast.makeText(b, "Failed to dial number.", 0).show();
        }
    }

    String g(String s1)
    {
        if (s1 == null)
        {
            return "";
        } else
        {
            return URLDecoder.decode(s1);
        }
    }

    void g(HashMap hashmap)
    {
        bl.a.a("ADC [info] MRAIDCommandSendCustomADCEvent called with parameters: ").b(hashmap);
        hashmap = g((String)hashmap.get("event_type"));
        ak.a("custom_event", (new StringBuilder()).append("{\"event_type\":\"").append(hashmap).append("\",\"ad_slot\":").append(f.c.k.d).append("}").toString(), c.D);
    }

    void h(HashMap hashmap)
    {
        bl.a.a("ADC [info] MRAIDCommandLaunchApp called with parameters: ").b(hashmap);
        ak.r = true;
        d.postDelayed(e, 1000L);
        hashmap = g((String)(String)hashmap.get("handle"));
        ak.a("html5_interaction", g, c.D);
        try
        {
            hashmap = b.getPackageManager().getLaunchIntentForPackage(hashmap);
            b.startActivity(hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Toast.makeText(b, "Failed to launch external application.", 0).show();
        }
    }

    void i(HashMap hashmap)
    {
        bl.a.a("ADC [info] MRAIDCommandCheckAppPresence called with parameters: ").b(hashmap);
        hashmap = g((String)(String)hashmap.get("handle"));
        boolean flag = ap.a(hashmap);
        f((new StringBuilder()).append("adc_bridge.fireAppPresenceEvent('").append(hashmap).append("',").append(flag).append(")").toString());
    }

    void j(HashMap hashmap)
    {
        bl.a.a("ADC [info] MRAIDCommandCheckAutoPlay called with parameters: ").b(hashmap);
    }
}
