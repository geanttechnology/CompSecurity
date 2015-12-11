// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.Toast;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            aj, q, e, g

final class ak
{

    WebView a;
    Activity b;
    e c;
    Handler d;
    Runnable e;
    g f;
    String g;

    public ak(e e1, WebView webview, Activity activity)
    {
        a = webview;
        b = activity;
        c = e1;
        d = new Handler();
        e = new Runnable() {

            final ak a;

            public final void run()
            {
                q.r = false;
            }

            
            {
                a = ak.this;
                super();
            }
        };
    }

    static String b(String s)
    {
        if (s == null)
        {
            return "";
        } else
        {
            return URLDecoder.decode(s);
        }
    }

    final void a(String s)
    {
        a.loadUrl((new StringBuilder("javascript:")).append(s).toString());
    }

    final void a(HashMap hashmap)
    {
        Object obj1;
        String s1;
        String s2;
        Object obj2;
        String s3;
        String s4;
        SimpleDateFormat simpledateformat;
        SimpleDateFormat simpledateformat1;
        String s5;
        String s6;
        aj.a.a("ADC [info] MRAIDCommandCreateCalendarEvent called with parameters: ").b(hashmap);
        q.r = true;
        d.postDelayed(e, 1000L);
        q.a("html5_interaction", g, c.D);
        simpledateformat1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ");
        obj2 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        s3 = b((String)(String)hashmap.get("description"));
        b((String)(String)hashmap.get("location"));
        s6 = b((String)(String)hashmap.get("start"));
        s5 = b((String)(String)hashmap.get("end"));
        String s = b((String)(String)hashmap.get("summary"));
        s2 = b((String)(String)hashmap.get("recurrence"));
        s1 = "";
        obj1 = "";
        HashMap hashmap1 = new HashMap();
        s4 = s2.replace("\"", "").replace("{", "").replace("}", "");
        if (!s4.equals(""))
        {
            obj1 = s4.split(",");
            int j = obj1.length;
            for (int i = 0; i < j; i++)
            {
                s1 = obj1[i];
                hashmap1.put(s1.substring(0, s1.indexOf(":")), s1.substring(s1.indexOf(":") + 1, s1.length()));
            }

            s1 = b((String)(String)hashmap1.get("expires"));
            obj1 = b((String)(String)hashmap1.get("frequency")).toUpperCase();
            aj.a.a("Calendar Recurrence - ").b(s4);
            aj.a.a("Calendar Recurrence - frequency = ").b(obj1);
            aj.a.a("Calendar Recurrence - expires =  ").b(s1);
        }
        s2 = s;
        if (s.equals(""))
        {
            s2 = b((String)(String)hashmap.get("description"));
        }
        hashmap = simpledateformat1.parse(s6);
        Date date = simpledateformat1.parse(s5);
_L1:
        Object obj;
        obj = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        obj = ((DateFormat) (obj2)).parse(s6);
        hashmap = ((HashMap) (obj));
        obj2 = ((DateFormat) (obj2)).parse(s5);
        date = ((Date) (obj2));
        break MISSING_BLOCK_LABEL_461;
        hashmap;
        hashmap = null;
_L2:
        date = null;
          goto _L1
        obj;
        obj = hashmap;
        Object obj3;
        try
        {
            hashmap = simpledateformat1.parse(s1);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            hashmap = null;
        }
        obj3 = hashmap;
        long l;
        long l1;
        long l2;
        if (hashmap == null)
        {
            try
            {
                obj3 = simpledateformat.parse(s1);
            }
            catch (Exception exception1)
            {
                obj3 = hashmap;
            }
        }
        if (obj == null)
        {
            Toast.makeText(b, "Unable to create Calendar Event.", 0).show();
            return;
        }
        l1 = ((Date) (obj)).getTime();
        l2 = date.getTime();
        l = 0L;
        if (obj3 != null)
        {
            l = (((Date) (obj3)).getTime() - ((Date) (obj)).getTime()) / 1000L;
        }
        Exception exception;
        if (((String) (obj1)).equals("DAILY"))
        {
            l = l / 0x15180L + 1L;
        } else
        if (((String) (obj1)).equals("WEEKLY"))
        {
            l = l / 0x93a80L + 1L;
        } else
        if (((String) (obj1)).equals("MONTHLY"))
        {
            l = l / 0x2820a8L + 1L;
        } else
        if (((String) (obj1)).equals("YEARLY"))
        {
            l = l / 0x1e187e0L + 1L;
        } else
        {
            l = 0L;
        }
        if (!s4.equals(""))
        {
            hashmap = (new Intent("android.intent.action.EDIT")).setType("vnd.android.cursor.item/event").putExtra("title", s2).putExtra("description", s3).putExtra("beginTime", l1).putExtra("endTime", l2).putExtra("rrule", (new StringBuilder("FREQ=")).append(((String) (obj1))).append(";COUNT=").append(l).toString());
            aj.a.a("Calendar Recurrence - count = ").b(l);
        } else
        {
            hashmap = (new Intent("android.intent.action.EDIT")).setType("vnd.android.cursor.item/event").putExtra("title", s2).putExtra("description", s3).putExtra("beginTime", l1).putExtra("endTime", l2);
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
        exception;
          goto _L2
    }

    // Unreferenced inner class com/jirbo/adcolony/ak$2

/* anonymous class */
    final class _cls2
        implements android.media.MediaScannerConnection.OnScanCompletedListener
    {

        final ak a;

        public final void onScanCompleted(String s, Uri uri)
        {
            Toast.makeText(a.b, "Screenshot saved to Gallery!", 0).show();
        }

            
            {
                a = ak.this;
                super();
            }
    }

}
