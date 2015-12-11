// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import com.tremorvideo.sdk.android.a.b;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;
import com.tremorvideo.sdk.android.richmedia.ae;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            am, ag, aw, ab, 
//            ad, Playvideo, k, bo, 
//            s, n, by, p, 
//            bv, ba, bb

public class ax
{
    public static interface a
    {

        public abstract void a(aw.b b1, int i1, int j1, int k1);
    }

    public static interface b
    {

        public abstract void b(String s1);
    }

    public static interface c
    {

        public abstract void a(aw aw1);

        public abstract void b(aw aw1);
    }

    public static interface d
    {

        public abstract void d(int i1);
    }

    public static interface e
    {

        public abstract void f(String s1);
    }


    a.a a;
    Activity b;
    boolean c;
    bv d;
    boolean e;
    int f;
    int g;
    int h;
    String i;
    ArrayList j;
    ArrayList k;
    c l;
    private int m;

    public ax(Activity activity, a.a a1, bv bv)
    {
        m = -1;
        c = false;
        e = false;
        j = new ArrayList();
        k = new ArrayList();
        d = bv;
        b = activity;
        a = a1;
        activity = (GregorianCalendar)GregorianCalendar.getInstance();
        f = activity.get(1);
        g = activity.get(2);
        h = activity.get(5);
    }

    private void a(aw aw1, b b1, String s1)
    {
        aw1 = am.a(b, new am.a(b1) {

            final b a;
            final ax b;

            public void a(Dialog dialog)
            {
                dialog.dismiss();
            }

            public void a(Dialog dialog, String s2)
            {
                b.i = s2;
                ax.a(b, true);
                a.b(s2);
                dialog.dismiss();
            }

            
            {
                b = ax.this;
                a = b1;
                super();
            }
        }, i, "Please enter your email address", d, true, 33, 254, new String[] {
            "Submit", "Cancel"
        });
        aw1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ax a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        i();
        aw1.setCanceledOnTouchOutside(false);
        aw1.show();
    }

    private void a(aw aw1, e e1, String s1)
    {
        aw1 = am.a(b, new am.a(e1, s1) {

            final e a;
            final String b;
            final ax c;

            public void a(Dialog dialog)
            {
                dialog.dismiss();
            }

            public void a(Dialog dialog, String s2)
            {
                c.i = s2;
                a.f(s2);
                if (b != null)
                {
                    s2 = c.a.g().c(b);
                    if (s2 != null)
                    {
                        c.a(s2);
                        c.b(s2);
                    }
                }
                dialog.dismiss();
            }

            
            {
                c = ax.this;
                a = e1;
                b = s1;
                super();
            }
        }, i, "Please enter a zip code", d, true, 2, 5, null);
        aw1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ax a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        a(e1);
        aw1.setCanceledOnTouchOutside(false);
        i();
        aw1.show();
    }

    private void a(aw aw1, String s1)
    {
        if (aw1 == null)
        {
            aw1 = aw.b.F;
        } else
        {
            aw1 = aw1.a();
        }
        aw1 = ag.a(b, new android.app.DatePickerDialog.OnDateSetListener(aw1, s1) {

            final aw.b a;
            final String b;
            final ax c;

            public void onDateSet(DatePicker datepicker, int i1, int j1, int k1)
            {
                if (c.f != i1 || c.g != j1 || c.h != k1)
                {
                    c.f = i1;
                    c.g = j1;
                    c.h = k1;
                    for (datepicker = c.j.iterator(); datepicker.hasNext(); ((a)datepicker.next()).a(a, c.f, c.g, c.h)) { }
                    if (b != null)
                    {
                        datepicker = c.a.g().c(b);
                        if (datepicker != null)
                        {
                            c.a(datepicker);
                            c.b(datepicker);
                        }
                    }
                    ax.a(c, true);
                }
            }

            
            {
                c = ax.this;
                a = b1;
                b = s1;
                super();
            }
        }, f, g, h);
        aw1.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ax a;

            public void onCancel(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        aw1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ax a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        aw1.setCanceledOnTouchOutside(false);
        aw1.setTitle("Please select a date.");
        i();
        aw1.show();
    }

    static void a(ax ax1, String s1)
        throws ActivityNotFoundException
    {
        ax1.g(s1);
    }

    static void a(ax ax1, boolean flag)
    {
        ax1.a(flag);
    }

    private void a(boolean flag)
    {
        c = false;
        if (flag)
        {
            b(((aw) (null)));
        }
    }

    private void b(aw aw1, e e1, String s1)
    {
        aw1 = am.a(b, new am.a(s1) {

            final String a;
            final ax b;

            public void a(Dialog dialog)
            {
                dialog.dismiss();
            }

            public void a(Dialog dialog, String s2)
            {
                b.i = s2;
                for (Iterator iterator = b.k.iterator(); iterator.hasNext(); ((e)iterator.next()).f(s2)) { }
                if (a != null)
                {
                    s2 = b.a.g().c(a);
                    if (s2 != null)
                    {
                        b.a(s2);
                        b.b(s2);
                    }
                }
                dialog.dismiss();
            }

            
            {
                b = ax.this;
                a = s1;
                super();
            }
        }, i, "Please enter a zip code", d, false, 2, 5, null);
        aw1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ax a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        if (e1 != null)
        {
            a(e1);
        }
        aw1.setCanceledOnTouchOutside(false);
        i();
        aw1.show();
    }

    private void d(aw aw1)
        throws Exception
    {
        aw1 = aw1.f();
        if (aw1.get("subject") == null && aw1.get("message") == null)
        {
            throw new Exception("Error launching share, no data supplied");
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (aw1.get("subject") != null)
        {
            intent.putExtra("android.intent.extra.SUBJECT", (String)aw1.get("subject"));
        }
        if (aw1.get("message") != null)
        {
            intent.putExtra("android.intent.extra.TEXT", (String)aw1.get("message"));
        }
        intent.setType("text/plain");
        b.startActivityForResult(Intent.createChooser(intent, "Share"), 11);
    }

    private void e(aw aw1)
    {
        com.tremorvideo.a.b.a a1 = new com.tremorvideo.a.b.a() {

            final ax a;

            public void a()
            {
                ax.a(a, true);
            }

            public void a(Bundle bundle)
            {
                a.b.runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        ab ab1 = new ab(a.a.b, a.a.d, ab.a.a, new ab.b(this) {

                            final _cls3 a;

                            public void a(boolean flag)
                            {
                                ax.a(a.a.a, true);
                            }

            
            {
                a = _pcls3;
                super();
            }
                        });
                        ab1.setCanceledOnTouchOutside(false);
                        ab1.setTitle("Facebook");
                        ab1.a("Posted to Facebook successfully.");
                        ab1.a("Ok", "");
                        ab1.show();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            public void a(com.tremorvideo.a.a a2)
            {
                a.b.runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        ab ab1 = new ab(a.a.b, a.a.d, ab.a.a, new ab.b(this) {

                            final _cls2 a;

                            public void a(boolean flag)
                            {
                                ax.a(a.a.a, true);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        ab1.setCanceledOnTouchOutside(false);
                        ab1.setTitle("Facebook");
                        ab1.a("There was an error posting to your Facebook page.");
                        ab1.a("Ok", "");
                        ab1.show();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            public void a(com.tremorvideo.a.c c1)
            {
                a.b.runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        ab ab1 = new ab(a.a.b, a.a.d, ab.a.a, new ab.b(this) {

                            final _cls1 a;

                            public void a(boolean flag)
                            {
                                ax.a(a.a.a, true);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        ab1.setCanceledOnTouchOutside(false);
                        ab1.setTitle("Facebook");
                        ab1.a("There was an error posting to your Facebook page.");
                        ab1.a("Ok", "");
                        ab1.show();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = ax.this;
                super();
            }
        };
        i();
        aw1 = new ab(b, d, com.tremorvideo.sdk.android.videoad.ab.a.b, new ab.b(aw1, a1) {

            final aw a;
            final com.tremorvideo.a.b.a b;
            final ax c;

            public void a(boolean flag)
            {
                if (flag)
                {
                    ax.a(c, true);
                    return;
                } else
                {
                    ba.a(c.b, a, b);
                    return;
                }
            }

            
            {
                c = ax.this;
                a = aw1;
                b = a1;
                super();
            }
        });
        aw1.setCanceledOnTouchOutside(false);
        aw1.setTitle("Facebook");
        aw1.a("Would you like to share this on your Facebook page?");
        aw1.a("Yes", "No");
        aw1.show();
    }

    private void e(String s1)
        throws Exception
    {
        Object obj = null;
        String s2;
        Intent intent;
        Object obj1;
        Iterator iterator;
        if (s1.startsWith("http://www.youtube.com/watch?v="))
        {
            s2 = s1.replace("http://www.youtube.com/watch?v=", "");
        } else
        if (s1.startsWith("http://www.youtube.com/v/"))
        {
            s2 = s1.replace("http://www.youtube.com/v/", "");
        } else
        {
            s2 = null;
        }
        if (s2 != null) goto _L2; else goto _L1
_L1:
        s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
_L4:
        b.startActivityForResult(s1, 11);
        TremorAdapterCalls.onLeaveApp();
        e = true;
        return;
_L2:
        intent = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        iterator = b.getPackageManager().queryIntentActivities(intent, 0x10000).iterator();
        s1 = null;
        while (iterator.hasNext()) 
        {
            obj1 = (ResolveInfo)iterator.next();
            if (((ResolveInfo) (obj1)).activityInfo.packageName.toLowerCase().contains("browser"))
            {
                s1 = ((String) (obj));
                obj = obj1;
            } else
            if (((ResolveInfo) (obj1)).activityInfo.packageName.toLowerCase().contains("youtube"))
            {
                obj = s1;
                s1 = ((String) (obj1));
            } else
            {
                obj1 = s1;
                s1 = ((String) (obj));
                obj = obj1;
            }
            obj1 = obj;
            obj = s1;
            s1 = ((String) (obj1));
        }
        if (ad.q() >= 11)
        {
            if (obj != null)
            {
                intent.setClassName(((ResolveInfo) (obj)).activityInfo.packageName, ((ResolveInfo) (obj)).activityInfo.name);
                s1 = intent;
                continue; /* Loop/switch isn't completed */
            }
            if (s1 != null)
            {
                intent.setClassName(((ResolveInfo) (s1)).activityInfo.packageName, ((ResolveInfo) (s1)).activityInfo.name);
                s1 = intent;
                continue; /* Loop/switch isn't completed */
            }
        } else
        {
            if (s1 != null)
            {
                obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://www.youtube.com/watch?v=").append(s2).toString()));
                ((Intent) (obj)).setClassName(((ResolveInfo) (s1)).activityInfo.packageName, ((ResolveInfo) (s1)).activityInfo.name);
                s1 = ((String) (obj));
                continue; /* Loop/switch isn't completed */
            }
            if (obj != null)
            {
                intent.setClassName(((ResolveInfo) (obj)).activityInfo.packageName, ((ResolveInfo) (obj)).activityInfo.name);
            }
        }
        s1 = intent;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void f(aw aw1)
    {
        aw1 = ag.a(b, new android.app.DatePickerDialog.OnDateSetListener(aw1) {

            final aw a;
            final ax b;

            public void onDateSet(DatePicker datepicker, int i1, int j1, int k1)
            {
                b.f = i1;
                b.g = j1;
                b.h = k1;
                for (datepicker = b.j.iterator(); datepicker.hasNext(); ((a)datepicker.next()).a(a.a(), b.f, b.g, b.h)) { }
                ax.a(b, true);
            }

            
            {
                b = ax.this;
                a = aw1;
                super();
            }
        }, f, g, h);
        aw1.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ax a;

            public void onCancel(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        aw1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ax a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        aw1.setTitle("Please enter your birthday.");
        i();
        aw1.show();
    }

    private void f(String s1)
        throws Exception
    {
        s1 = new Intent("android.intent.action.DIAL", Uri.parse(s1));
        b.startActivityForResult(s1, 11);
        e = true;
        Thread.sleep(500L);
    }

    private void g()
        throws Exception
    {
        com.tremorvideo.sdk.android.a.b.a = a.g();
        com.tremorvideo.sdk.android.a.b.b = a;
        try
        {
            Intent intent = new Intent(b, com/tremorvideo/sdk/android/videoad/Playvideo);
            intent.putExtra("tremorVideoType", "buyitnow");
            b.startActivityForResult(intent, 3232);
            return;
        }
        catch (Exception exception)
        {
            com.tremorvideo.sdk.android.a.b.a = null;
            com.tremorvideo.sdk.android.a.b.b = null;
            throw exception;
        }
    }

    private void g(aw aw1)
        throws Exception
    {
        Intent intent = new Intent(b, com/tremorvideo/sdk/android/videoad/Playvideo);
        intent.putExtra("tremorVideoType", "webview");
        intent.putExtra("tremorVideoURL", aw1.j());
        intent.putExtra("curEventID", m);
        b.startActivityForResult(intent, 3232);
    }

    private void g(String s1)
        throws ActivityNotFoundException
    {
        e = true;
        s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        b.startActivityForResult(s1, 11);
        TremorAdapterCalls.onLeaveApp();
    }

    private void h()
        throws Exception
    {
        com.tremorvideo.sdk.android.b.b.a = a.g();
        com.tremorvideo.sdk.android.b.b.b = a;
        try
        {
            Intent intent = new Intent(b, com/tremorvideo/sdk/android/videoad/Playvideo);
            intent.putExtra("tremorVideoType", "movieboard");
            b.startActivityForResult(intent, 3232);
            return;
        }
        catch (Exception exception)
        {
            com.tremorvideo.sdk.android.a.b.a = null;
            com.tremorvideo.sdk.android.a.b.b = null;
            throw exception;
        }
    }

    private void h(aw aw1)
        throws Exception
    {
        k.a = a.g();
        com.tremorvideo.sdk.android.videoad.k.b = a;
        try
        {
            aw1 = new Intent(b, com/tremorvideo/sdk/android/videoad/Playvideo);
            aw1.putExtra("tremorVideoType", "coupon");
            aw1.putExtra("curEventID", m);
            b.startActivityForResult(aw1, 3232);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aw aw1)
        {
            k.a = null;
        }
        com.tremorvideo.sdk.android.videoad.k.b = null;
        throw aw1;
    }

    private void i()
    {
        c = true;
    }

    private void i(aw aw1)
        throws Exception
    {
        double d1;
        double d2;
        Object obj;
        String s2;
        int i1;
        int j1;
label0:
        {
            obj = aw1.f();
            ArrayList arraylist;
            try
            {
                bo.a(ad.v(), true);
            }
            // Misplaced declaration of an exception variable
            catch (aw aw1)
            {
                ad.d((new StringBuilder()).append("EventHandler: Unable to get location: ").append(aw1.toString()).toString());
            }
            i1 = Integer.parseInt((String)((Dictionary) (obj)).get("map-type"));
            d1 = 0.0D;
            d2 = 0.0D;
            j1 = -1;
            s2 = (String)((Dictionary) (obj)).get("zoom");
            if (s2 != null)
            {
                j1 = Integer.parseInt(s2);
            }
            if (i1 == 1)
            {
                obj = (String)((Dictionary) (obj)).get("query");
                d1 = 0.0D;
                aw1 = null;
                i1 = 1;
                break label0;
            }
        }
        if (i1 != 2) goto _L2; else goto _L1
_L1:
        double d3;
        d1 = bo.a;
        d3 = com.tremorvideo.sdk.android.videoad.bo.b;
        d2 = d1;
        if (d1 != 0.0D)
        {
            break MISSING_BLOCK_LABEL_1165;
        }
        d2 = d1;
        if (d3 != 0.0D)
        {
            break MISSING_BLOCK_LABEL_1165;
        }
        if (((Dictionary) (obj)).get("latitude") != null)
        {
            d1 = Double.parseDouble((String)((Dictionary) (obj)).get("latitude"));
        }
        d2 = d1;
        if (((Dictionary) (obj)).get("longitude") == null)
        {
            break MISSING_BLOCK_LABEL_1165;
        }
        d3 = Double.parseDouble((String)((Dictionary) (obj)).get("longitude"));
        d2 = d1;
        d1 = d3;
_L4:
        obj = (String)((Dictionary) (obj)).get("query");
        d3 = d2;
        aw1 = null;
        i1 = 1;
        d2 = d1;
        d1 = d3;
          goto _L3
_L2:
        if (i1 == 3)
        {
            if (((Dictionary) (obj)).get("latitude") != null)
            {
                d1 = Double.parseDouble((String)((Dictionary) (obj)).get("latitude"));
            }
            if (((Dictionary) (obj)).get("longitude") != null)
            {
                d2 = Double.parseDouble((String)((Dictionary) (obj)).get("longitude"));
            }
            aw1 = (String)((Dictionary) (obj)).get("pinpoint-name");
            i1 = 1;
            obj = null;
        } else
        if (i1 == 4 || i1 == 5)
        {
            d1 = bo.a;
            d2 = com.tremorvideo.sdk.android.videoad.bo.b;
            aw1 = (String)((Dictionary) (obj)).get("retailigence-endpoint");
            obj = (String)((Dictionary) (obj)).get("html-template-path");
            obj = ((s)a.g()).E();
            obj = new StringBuilder((new StringBuilder()).append("file://").append(((String) (obj))).append("/comps/retailigence_map/index.html").toString());
            ((StringBuilder) (obj)).append("?api=");
            ((StringBuilder) (obj)).append(URLEncoder.encode(aw1, "UTF-8"));
            ((StringBuilder) (obj)).append("&type=");
            ((StringBuilder) (obj)).append(i1);
            if (j1 >= 0)
            {
                ((StringBuilder) (obj)).append("&zoom=");
                ((StringBuilder) (obj)).append(j1);
            }
            if (d1 == 0.0D && d2 == 0.0D)
            {
                aw1 = a.g().r();
                if (aw1 != null)
                {
                    ((StringBuilder) (obj)).append("&zipcode=");
                    ((StringBuilder) (obj)).append(((s.b) (aw1)).d);
                }
            } else
            {
                ((StringBuilder) (obj)).append("&lat=");
                ((StringBuilder) (obj)).append(d1);
                ((StringBuilder) (obj)).append("&lng=");
                ((StringBuilder) (obj)).append(d2);
            }
            aw1 = ((StringBuilder) (obj)).toString();
            ad.d((new StringBuilder()).append("WebView URL=").append(aw1).toString());
            obj = new Intent(b, com/tremorvideo/sdk/android/videoad/Playvideo);
            ((Intent) (obj)).putExtra("tremorVideoType", "webview");
            ((Intent) (obj)).putExtra("tremorVideoURL", aw1);
            ((Intent) (obj)).putExtra("curEventID", m);
            b.startActivityForResult(((Intent) (obj)), 3232);
            aw1 = null;
            i1 = 0;
            obj = null;
        } else
        {
            i1 = 1;
            d1 = 0.0D;
            aw1 = null;
            obj = null;
        }
_L3:
        if (i1 != 0)
        {
            String s1;
            if (d1 == 0.0D && d2 == 0.0D)
            {
                s1 = "geo:0,0";
            } else
            {
                s1 = (new StringBuilder()).append("geo:").append(d1).append(",").append(d2).toString();
            }
            arraylist = new ArrayList();
            if (j1 >= 0)
            {
                if ("0".equalsIgnoreCase(s2))
                {
                    i1 = 16;
                } else
                if ("1".equalsIgnoreCase(s2))
                {
                    i1 = 12;
                } else
                if ("2".equalsIgnoreCase(s2))
                {
                    i1 = 6;
                } else
                if ("3".equalsIgnoreCase(s2))
                {
                    i1 = 4;
                } else
                {
                    i1 = j1;
                }
                arraylist.add((new StringBuilder()).append("z=").append(i1).toString());
            }
            if (obj != null && obj != "")
            {
                arraylist.add((new StringBuilder()).append("q=").append(URLEncoder.encode(((String) (obj)), "UTF-8")).toString());
            }
            if (aw1 != null && aw1.length() > 0)
            {
                obj = new StringBuilder("q=");
                ((StringBuilder) (obj)).append(d1);
                ((StringBuilder) (obj)).append(",");
                ((StringBuilder) (obj)).append(d2);
                ((StringBuilder) (obj)).append("(");
                ((StringBuilder) (obj)).append(URLEncoder.encode(aw1, "UTF-8"));
                ((StringBuilder) (obj)).append(")");
                arraylist.add(((StringBuilder) (obj)).toString());
            }
            i1 = 0;
            while (i1 < arraylist.size()) 
            {
                if (i1 == 0)
                {
                    aw1 = (new StringBuilder()).append(s1).append("?").toString();
                } else
                {
                    aw1 = (new StringBuilder()).append(s1).append("&").toString();
                }
                s1 = (new StringBuilder()).append(aw1).append((String)arraylist.get(i1)).toString();
                i1++;
            }
            e = true;
            aw1 = Uri.parse(s1);
            ad.a(com.tremorvideo.sdk.android.videoad.ad.d.b, (new StringBuilder()).append("Map URL: ").append(aw1.toString()).toString());
            aw1 = new Intent("android.intent.action.VIEW", aw1);
            b.startActivityForResult(aw1, 11);
            TremorAdapterCalls.onLeaveApp();
        }
        return;
        d1 = d3;
          goto _L4
    }

    private void j(aw aw1)
        throws Exception
    {
        i();
        by.a(b, aw1, new by.e() {

            final ax a;

            public void a(int i1, String s1)
            {
                ab ab1;
                if (i1 == -1)
                {
                    ax.a(a, true);
                    return;
                }
                ab1 = new ab(a.b, a.d, ab.a.a, new ab.b(this) {

                    final _cls10 a;

                    public void a(boolean flag)
                    {
                        ax.a(a.a, true);
                    }

            
            {
                a = _pcls10;
                super();
            }
                });
                if (i1 != 0) goto _L2; else goto _L1
_L1:
                ab1.setTitle("Error");
                if (s1.compareTo("") == 0)
                {
                    ab1.a("There was an error sending your Tweet.");
                }
_L4:
                if (s1.compareTo("") != 0)
                {
                    ab1.a(s1);
                }
                ab1.setCanceledOnTouchOutside(false);
                ab1.a("OK", "");
                ab1.show();
                return;
_L2:
                ab1.setTitle("Success");
                if (s1.compareTo("") == 0)
                {
                    ab1.a("Your tweet was sent successfully.");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ax.this;
                super();
            }
        });
    }

    private void k(aw aw1)
    {
        int i1;
        boolean flag;
        boolean flag1;
        try
        {
            AudioManager audiomanager = (AudioManager)a.h().getSystemService("audio");
            flag = audiomanager.shouldVibrate(1);
            flag1 = audiomanager.shouldVibrate(0);
        }
        // Misplaced declaration of an exception variable
        catch (aw aw1)
        {
            ad.a(aw1);
            return;
        }
        if (!flag || !flag1)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        i1 = Math.min(30, Integer.parseInt((String)aw1.f().get("duration")));
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        ((Vibrator)b.getSystemService("vibrator")).vibrate(i1 * 1000);
    }

    public void a()
    {
        j = new ArrayList();
        k = new ArrayList();
    }

    public void a(aw.b b1)
    {
        a(b1, null, null, null);
    }

    public void a(aw.b b1, b b2, String s1, String s2, String s3)
    {
        if (c)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        if (l != null)
        {
            l.a(null);
        }
        if (b1 != aw.b.I)
        {
            m = 0x7fffffff;
        }
        if (b1 != com.tremorvideo.sdk.android.videoad.aw.b.b)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        try
        {
            b1 = a.g().c(s1);
        }
        // Misplaced declaration of an exception variable
        catch (aw.b b1)
        {
            ad.d((new StringBuilder()).append("Exception doEventAction").append(b1).toString());
            b(((aw) (null)));
            return;
        }
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        a(((aw) (b1)));
        b(b1);
        b1 = new Intent(b, com/tremorvideo/sdk/android/videoad/Playvideo);
        b1.putExtra("tremorVideoType", "webview");
        b1.putExtra("tremorVideoURL", s3);
        b1.putExtra("curEventID", -1);
        b.startActivityForResult(b1, 3232);
        return;
        if (b1 == aw.b.aw)
        {
            a(((aw) (null)), b2, s2);
            return;
        }
        if (b1 != aw.b.ax && b1 != aw.b.ay && b1 != aw.b.az)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        b1 = a.g().c(s1);
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        a(((aw) (b1)));
        b(b1);
        return;
        throw new Exception();
    }

    public void a(aw.b b1, e e1, ArrayList arraylist, String s1)
    {
        aw aw1;
        aw aw2;
        aw aw3;
        aw3 = null;
        aw2 = null;
        if (c)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        aw1 = aw3;
        if (b1 != aw.b.I)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        aw1 = aw3;
        aw3 = a.g().a(b1);
        aw2 = aw3;
        if (aw3 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        aw1 = aw3;
        a(aw3);
        aw2 = aw3;
        aw1 = aw2;
        if (b1 == aw.b.J)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        String s2;
        aw3 = aw2;
        s2 = s1;
        aw1 = aw2;
        if (b1 != aw.b.K)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        aw1 = aw2;
        aw2 = a.g().a(b1);
        aw3 = aw2;
        s2 = s1;
        if (aw2 == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        aw1 = aw2;
        s2 = aw2.d();
        aw3 = aw2;
        aw1 = aw3;
        if (l == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        aw1 = aw3;
        l.a(aw3);
        aw1 = aw3;
        if (b1 == aw.b.I)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        aw1 = aw3;
        m = 0x7fffffff;
        aw1 = aw3;
        if (b1 == aw.b.F)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        aw1 = aw3;
        if (b1 != aw.b.K)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        aw1 = aw3;
        try
        {
            a(((aw) (null)), s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aw.b b1)
        {
            ad.d((new StringBuilder()).append("Exception doEventAction").append(b1).toString());
        }
        break MISSING_BLOCK_LABEL_284;
        aw1 = aw3;
        if (b1 == aw.b.G)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        aw1 = aw3;
        if (b1 != aw.b.J)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        aw1 = aw3;
        b(null, e1, s2);
        return;
        b(aw1);
        return;
        aw1 = aw3;
        if (b1 != aw.b.au)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        aw1 = aw3;
        a(((aw) (null)), e1, s2);
        return;
        aw1 = aw3;
        if (b1 != aw.b.at)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        aw1 = aw3;
        a((d)e1, arraylist, s2);
        return;
        aw1 = aw3;
        if (b1 == aw.b.I)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        aw1 = aw3;
        throw new Exception();
    }

    public void a(aw aw1)
    {
        a(aw1, -1);
    }

    public void a(aw aw1, int i1)
    {
        m = a.a(aw1, i1);
    }

    public void a(aw aw1, int i1, String s1)
    {
        boolean flag1 = false;
        if (aw1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        if (aw1.a() != aw.b.x)
        {
            break; /* Loop/switch isn't completed */
        }
        a(aw1, i1);
        k(aw1);
        flag = flag1;
_L4:
        if (flag)
        {
            b(aw1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (aw1.a() == aw.b.ar)
        {
            a(aw1, i1);
            flag = flag1;
        } else
        {
            flag = flag1;
            if (!c)
            {
label0:
                {
                    a(aw1, i1);
                    if (aw1.a() != aw.b.j)
                    {
                        break label0;
                    }
                    m = -1;
                    flag = flag1;
                }
            }
        }
          goto _L4
        if (l != null)
        {
            l.a(aw1);
        }
        if (aw1.a() != aw.b.p)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        j(aw1);
        Object obj;
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.r)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        d(aw1);
        flag = true;
          goto _L4
        if (aw1.a() != aw.b.q)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        i(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.u)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        e(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.B)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        h(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != com.tremorvideo.sdk.android.videoad.aw.b.b)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        g(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.h)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        g(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.g)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        g(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.e)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        g(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.d)
        {
            break MISSING_BLOCK_LABEL_414;
        }
        g(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.i)
        {
            break MISSING_BLOCK_LABEL_438;
        }
        e(aw1.j());
        flag = true;
          goto _L4
        if (aw1.a() != aw.b.c)
        {
            break MISSING_BLOCK_LABEL_462;
        }
        f(aw1.j());
        flag = true;
          goto _L4
        if (aw1.a() != aw.b.F)
        {
            break MISSING_BLOCK_LABEL_485;
        }
        a(aw1, ((String) (null)));
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.H)
        {
            break MISSING_BLOCK_LABEL_510;
        }
        b(aw1.j());
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.L)
        {
            break MISSING_BLOCK_LABEL_532;
        }
        f(aw1);
        flag = flag1;
          goto _L4
        if (aw1.a() != aw.b.S)
        {
            break MISSING_BLOCK_LABEL_552;
        }
        g();
        flag = true;
          goto _L4
        if (aw1.a() != aw.b.X)
        {
            break MISSING_BLOCK_LABEL_572;
        }
        h();
        flag = true;
          goto _L4
        if (aw1.a() != aw.b.as)
        {
            break MISSING_BLOCK_LABEL_821;
        }
        flag = flag1;
        if (s1 == null) goto _L4; else goto _L5
_L5:
        s1 = new JSONObject(s1);
        flag = flag1;
        if (!s1.has("component_type")) goto _L4; else goto _L6
_L6:
        if (s1.getInt("component_type") != 5)
        {
            break MISSING_BLOCK_LABEL_657;
        }
        s1 = s1.getJSONObject("params").getString("pinEndpoint");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_891;
        }
        try
        {
            if (s1.length() > 0)
            {
                g(s1);
            }
            break MISSING_BLOCK_LABEL_891;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            obj = s1.getCause();
            if (obj != null)
            {
                ad.d((new StringBuilder()).append("Unable to launch URL: ").append(aw1.j()).append(". ").append(s1.getMessage()).append(" ").append(((Throwable) (obj)).getMessage()).toString());
            } else
            {
                ad.d((new StringBuilder()).append("Unable to launch URL: ").append(aw1.j()).append(". ").append(s1.getMessage()).toString());
            }
            flag = true;
        }
          goto _L4
        com.tremorvideo.sdk.android.richmedia.a.b.a = a.g();
        com.tremorvideo.sdk.android.richmedia.a.b.b = a;
        obj = new Intent(b, com/tremorvideo/sdk/android/videoad/Playvideo);
        ((Intent) (obj)).putExtra("tremorVideoType", "genericwebview");
        ((Intent) (obj)).putExtra("curEventID", m);
        if (s1.has("zip_path") && s1.has("index_file"))
        {
            ((Intent) (obj)).putExtra("path", (new StringBuilder()).append(s1.getString("zip_path")).append(s1.getString("index_file")).toString());
        }
        if (s1.has("params"))
        {
            ((Intent) (obj)).putExtra("params", s1.getString("params"));
        }
        b.startActivityForResult(((Intent) (obj)), 3232);
        flag = flag1;
          goto _L4
        flag = flag1;
        if (aw1.a() == aw.b.ar) goto _L4; else goto _L7
_L7:
        g(aw1.j());
        flag = true;
          goto _L4
        flag = true;
          goto _L4
    }

    public void a(aw aw1, int i1, List list)
    {
        m = a.a(aw1, i1, list);
    }

    public void a(a a1)
    {
        j.add(a1);
    }

    public void a(c c1)
    {
        l = c1;
    }

    public void a(d d1, ArrayList arraylist, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b);
        builder.setTitle("Select Cable Provider");
        ListView listview = new ListView(b);
        listview.setItemsCanFocus(false);
        listview.setAdapter(new ArrayAdapter(b, 0x1090003, 0x1020014, arraylist));
        builder.setView(listview);
        arraylist = builder.create();
        arraylist.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ax a;

            public void onCancel(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        arraylist.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ax a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        i();
        arraylist.show();
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(d1, s1, arraylist) {

            final d a;
            final String b;
            final Dialog c;
            final ax d;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                ad.d((new StringBuilder()).append("Position setOnItemClickListener").append(i1).toString());
                a.d(i1);
                if (b != null)
                {
                    adapterview = d.a.g().c(b);
                    if (adapterview != null)
                    {
                        d.a(adapterview);
                        d.b(adapterview);
                    }
                }
                ax.a(d, true);
                c.dismiss();
            }

            
            {
                d = ax.this;
                a = d1;
                b = s1;
                c = dialog;
                super();
            }
        });
    }

    public void a(e e1)
    {
        k.add(e1);
    }

    public void a(String s1)
    {
        i = s1;
    }

    public void b(aw aw1)
    {
        if (m != -1)
        {
            if (l != null)
            {
                l.b(aw1);
            }
            if (m != 0x7fffffff)
            {
                a.a(m);
            }
            m = -1;
        }
    }

    public void b(String s1)
    {
        s1 = p.a(b, new p.a(s1) {

            final String a;
            final ax b;

            public void a(Dialog dialog)
            {
                if (a != null && a.length() > 0)
                {
                    String s2 = ae.c(a);
                    bb.a(a, s2).c();
                }
                dialog.dismiss();
            }

            public void b(Dialog dialog)
            {
                dialog.dismiss();
            }

            public void c(Dialog dialog)
            {
                ax.a(b, "http://www.youradchoices.com/learn.aspx");
                dialog.dismiss();
            }

            
            {
                b = ax.this;
                a = s1;
                super();
            }
        }, d);
        s1.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ax a;

            public void onCancel(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        s1.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ax a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ax.a(a, true);
            }

            
            {
                a = ax.this;
                super();
            }
        });
        i();
        android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
        layoutparams.copyFrom(s1.getWindow().getAttributes());
        layoutparams.width = -1;
        layoutparams.height = -1;
        s1.show();
        s1.getWindow().setAttributes(layoutparams);
    }

    public boolean b()
    {
        return e;
    }

    public int c()
    {
        return m;
    }

    public void c(aw aw1)
    {
        a(aw1, -1, ((String) (null)));
    }

    public void c(String s1)
        throws Exception
    {
        i();
        by.a(b, null, new by.e() {

            final ax a;

            public void a(int i1, String s2)
            {
                ab ab1;
                if (i1 == -1)
                {
                    ax.a(a, true);
                    return;
                }
                ab1 = new ab(a.b, a.d, ab.a.a, new ab.b(this) {

                    final _cls11 a;

                    public void a(boolean flag)
                    {
                        ax.a(a.a, true);
                    }

            
            {
                a = _pcls11;
                super();
            }
                });
                if (i1 != 0) goto _L2; else goto _L1
_L1:
                ab1.setTitle("Error");
                if (s2.compareTo("") == 0)
                {
                    ab1.a("There was an error sending your Tweet.");
                }
_L4:
                if (s2.compareTo("") != 0)
                {
                    ab1.a(s2);
                }
                ab1.setCanceledOnTouchOutside(false);
                ab1.a("OK", "");
                ab1.show();
                return;
_L2:
                ab1.setTitle("Success");
                if (s2.compareTo("") == 0)
                {
                    ab1.a("Your tweet was sent successfully.");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ax.this;
                super();
            }
        }, 1, s1);
    }

    public void d(String s1)
    {
        Intent intent = new Intent(b, com/tremorvideo/sdk/android/videoad/Playvideo);
        intent.putExtra("tremorVideoType", "webview");
        intent.putExtra("tremorVideoURL", s1);
        intent.putExtra("curEventID", m);
        b.startActivityForResult(intent, 3232);
    }

    public boolean d()
    {
        return c;
    }

    public void e()
    {
        e = false;
    }

    public boolean f()
    {
        return c;
    }
}
