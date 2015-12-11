// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.Toast;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            al, ab, as, aq, 
//            h, an, t, w

final class v
{
    private final class a
    {

        long a;
        long b;
        boolean c;
        final v d;

        final void a(android.content.SharedPreferences.Editor editor, String s1)
        {
            editor.putLong((new StringBuilder("handshake_lastvideo_")).append(s1).toString(), a);
            editor.putLong((new StringBuilder("handshake_videointerval_")).append(s1).toString(), b);
        }

        a()
        {
            d = v.this;
            super();
            a = 0L;
            b = 0L;
        }
    }

    static final class b
    {

        String a;
        String b;
        String c;
        int d;
        String e;

        public final String a()
        {
            Object obj;
            try
            {
                obj = new JSONObject();
                ((JSONObject) (obj)).put("appID", a);
                ((JSONObject) (obj)).put("appKey", b);
                ((JSONObject) (obj)).put("server", c);
                ((JSONObject) (obj)).put("port", d);
                e = ((JSONObject) (obj)).getString("sessionID");
                obj = ((JSONObject) (obj)).toString();
            }
            catch (JSONException jsonexception)
            {
                al.a("HandShake", "Error creating JSON from NuanceCredentials", jsonexception);
                return null;
            }
            return ((String) (obj));
        }

        public final String toString()
        {
            return (new StringBuilder("Credentials: appid=")).append(a).append(" server=").append(c).append(" port=").append(d).append(" appKey=").append(b).append("sessionID=").append(e).toString();
        }

        public b(String s1)
        {
            try
            {
                s1 = new JSONObject(s1);
                a = s1.getString("appID");
                b = s1.getString("appKey");
                c = s1.getString("server");
                d = s1.getInt("port");
                e = s1.getString("sessionID");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                al.a("HandShake", "Error parsing nuance string to json", s1);
            }
        }
    }

    private final class c
    {

        String a;
        int b;
        final v c;

        final boolean a(Context context)
        {
            Intent intent;
            if (a.contains("://"))
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(a));
            } else
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(a).append("://").toString()));
            }
            return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
        }

        c()
        {
            c = v.this;
            super();
        }

        c(String s1, int i1)
        {
            c = v.this;
            super();
            a = s1;
            b = i1;
        }
    }


    static String a = "28913";
    private static String l = "https://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static boolean m;
    private static v n;
    private static String y = "http://androidsdk.ads.mp.mydas.mobi/getAd?";
    boolean b;
    String c;
    long d;
    boolean e;
    String f;
    String g;
    long h;
    String i;
    b j;
    t k[];
    private WeakReference o;
    private WeakReference p;
    private final Handler q;
    private long r;
    private String s;
    private final LinkedHashMap t;
    private final ArrayList u;
    private String v;
    private long w;
    private long x;
    private final Runnable z;

    private v()
    {
        q = new Handler(Looper.getMainLooper());
        t = new LinkedHashMap();
        u = new ArrayList();
        w = 0x36ee80L;
        b = false;
        x = 0x5265c00L;
        d = 0xf731400L;
        z = new Runnable() {

            final v a;

            public final void run()
            {
                Context context1 = (Context)v.a(a).get();
                Context context = context1;
                if (context1 == null)
                {
                    context = (Context)v.b(a).get();
                }
                if (context != null)
                {
                    v.a(context);
                }
            }

            
            {
                a = v.this;
                super();
            }
        };
    }

    private v(Context context)
    {
        q = new Handler(Looper.getMainLooper());
        t = new LinkedHashMap();
        u = new ArrayList();
        w = 0x36ee80L;
        b = false;
        x = 0x5265c00L;
        d = 0xf731400L;
        z = new _cls2();
        o = new WeakReference(context);
        p = new WeakReference(context.getApplicationContext());
        if (m || !f(context) || System.currentTimeMillis() - r > x)
        {
            m = false;
            r = System.currentTimeMillis();
            a(false);
        }
    }

    static v a(Context context)
    {
        com/millennialmedia/android/v;
        JVM INSTR monitorenter ;
        if (a != null) goto _L2; else goto _L1
_L1:
        al.a("HandShake", "No apid set for the handshake.");
        context = null;
_L5:
        com/millennialmedia/android/v;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (n != null) goto _L4; else goto _L3
_L3:
        n = new v(context);
_L7:
        context = n;
          goto _L5
_L4:
        if (System.currentTimeMillis() - n.r <= n.x) goto _L7; else goto _L6
_L6:
        al.b();
        n = new v(context);
          goto _L7
        context;
        throw context;
    }

    static String a()
    {
        if (!TextUtils.isEmpty(y) && URLUtil.isHttpUrl(y.replace("getAd?", "")))
        {
            return y;
        } else
        {
            return "http://androidsdk.ads.mp.mydas.mobi/getAd?";
        }
    }

    static WeakReference a(v v1)
    {
        return v1.o;
    }

    static void a(v v1, Context context)
    {
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        context.putLong("handshake_deferredviewtimeout", v1.w);
        context.putBoolean("handshake_kill", v1.b);
        context.putString("handshake_baseUrl", y);
        context.putLong("handshake_callback", v1.x);
        context.putBoolean("handshake_hardwareAccelerationEnabled", v1.e);
        context.putString("handshake_startSessionURL", v1.f);
        if (v1.j != null)
        {
            context.putString("handshake_nuanceCredentials", v1.j.a());
        }
        context.putString("handshake_endSessionURL", v1.g);
        context.putLong("handshake_creativecaetimeout", v1.d);
        context.putString("handshake_mmjs", v1.i);
        String s1;
        for (Iterator iterator = v1.t.keySet().iterator(); iterator.hasNext(); ((a)v1.t.get(s1)).a(context, (String)s1))
        {
            s1 = (String)iterator.next();
        }

        v1;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder = new StringBuilder();
        int i1 = 0;
_L2:
        c c1;
        if (i1 >= v1.u.size())
        {
            break; /* Loop/switch isn't completed */
        }
        c1 = (c)v1.u.get(i1);
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        stringbuilder.append("\n");
        stringbuilder.append((new StringBuilder()).append(c1.a).append("\t").append(c1.b).toString());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        context.putString("handshake_schemes", stringbuilder.toString());
        v1;
        JVM INSTR monitorexit ;
        context.putString("handshake_novideostocacheurl", v1.s);
        context.putLong("handshake_lasthandshake", v1.r);
        context.commit();
        return;
        context;
        v1;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void a(v v1, JSONObject jsonobject)
    {
        Context context;
        context = (Context)v1.o.get();
        if (context == null)
        {
            context = (Context)v1.p.get();
        }
        if (context != null) goto _L2; else goto _L1
_L1:
        al.a("HandShake", "No context for handshake");
_L4:
        return;
_L2:
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj1;
        Object obj2;
        int i1;
        try
        {
            obj = jsonobject.optJSONArray("errors");
        }
        // Misplaced declaration of an exception variable
        catch (v v1)
        {
            al.a("HandShake", "Error deserializing handshake", v1);
            return;
        }
        if (obj == null) goto _L6; else goto _L5
_L5:
        i1 = 0;
_L41:
        if (i1 >= ((JSONArray) (obj)).length()) goto _L6; else goto _L7
_L7:
        obj2 = ((JSONArray) (obj)).optJSONObject(i1);
        if (obj2 == null) goto _L9; else goto _L8
_L8:
        obj1 = ((JSONObject) (obj2)).optString("message", null);
        obj2 = ((JSONObject) (obj2)).optString("type", null);
        if (obj1 == null || obj2 == null) goto _L9; else goto _L10
_L10:
        if (!((String) (obj2)).equalsIgnoreCase("log")) goto _L12; else goto _L11
_L11:
        al.a("HandShake", ((String) (obj1)));
          goto _L9
_L12:
        if (((String) (obj2)).equalsIgnoreCase("prompt"))
        {
            v1.q.post(v1. new Runnable(context, ((String) (obj1))) {

                final Context a;
                final String b;
                final v c;

                public final void run()
                {
                    try
                    {
                        Toast.makeText(a, (new StringBuilder("Error: ")).append(b).toString(), 1).show();
                        return;
                    }
                    catch (android.view.WindowManager.BadTokenException badtokenexception)
                    {
                        al.a("HandShake", "Error with toast token", badtokenexception);
                    }
                }

            
            {
                c = v.this;
                a = context;
                b = s1;
                super();
            }
            });
        }
          goto _L9
_L6:
        obj = jsonobject.optJSONObject("adtypes");
        if (obj == null) goto _L14; else goto _L13
_L13:
        Object aobj[] = ab.l();
        i1 = 0;
_L42:
        if (i1 >= 2) goto _L14; else goto _L15
_L15:
        Object obj3 = ((JSONObject) (obj)).optJSONObject(aobj[i1]);
        if (obj3 == null) goto _L17; else goto _L16
_L16:
        obj2 = v1. new a();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        obj2.b = ((JSONObject) (obj3)).optLong("videointerval") * 1000L;
        obj3 = aobj[i1];
        SharedPreferences sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        if (sharedpreferences == null)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        if (sharedpreferences.contains((new StringBuilder("handshake_lastvideo_")).append(((String) (obj3))).toString()))
        {
            obj2.a = sharedpreferences.getLong((new StringBuilder("handshake_lastvideo_")).append(((String) (obj3))).toString(), ((a) (obj2)).a);
        }
        v1.t.put(aobj[i1], obj2);
          goto _L17
_L14:
        v1;
        JVM INSTR monitorenter ;
        obj = jsonobject.optJSONArray("schemes");
        if (obj == null) goto _L19; else goto _L18
_L18:
        if (v1.u != null && v1.u.size() > 0)
        {
            v1.u.removeAll(v1.u);
        }
          goto _L20
_L43:
        if (i1 >= ((JSONArray) (obj)).length()) goto _L19; else goto _L21
_L21:
        aobj = ((JSONArray) (obj)).optJSONObject(i1);
        if (aobj == null) goto _L23; else goto _L22
_L22:
        obj2 = v1. new c();
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_463;
        }
        obj2.a = ((JSONObject) (aobj)).optString("scheme", null);
        obj2.b = ((JSONObject) (aobj)).optInt("schemeid");
        v1.u.add(obj2);
          goto _L23
_L19:
        v1;
        JVM INSTR monitorexit ;
        v1.h = jsonobject.optLong("adrefresh", 0L);
        v1.w = jsonobject.optLong("deferredviewtimeout", 3600L) * 1000L;
        v1.b = jsonobject.optBoolean("kill");
        obj = jsonobject.optString("baseURL");
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L25; else goto _L24
_L24:
        if (((String) (obj)).endsWith("/")) goto _L27; else goto _L26
_L26:
        y = (new StringBuilder()).append(((String) (obj))).append("/getAd?").toString();
_L25:
        v1.x = jsonobject.optLong("handshakecallback", 0x15180L) * 1000L;
        v1.d = jsonobject.optLong("creativeCacheTimeout", 0x3f480L) * 1000L;
        v1.e = jsonobject.optBoolean("hardwareAccelerationEnabled");
        v1.f = jsonobject.optString("startSessionURL");
        v1.g = jsonobject.optString("endSessionURL");
        v1.j = new b(jsonobject.optString("nuanceCredentials"));
        v1.i = jsonobject.optString("mmjs");
        v1.s = jsonobject.optString("noVideosToCacheURL");
        if (v1.k != null)
        {
            as.a(v1.k, context, v1.s);
        }
        if (TextUtils.isEmpty(v1.i)) goto _L29; else goto _L28
_L28:
        boolean flag;
        obj = v1.i;
        flag = aq.b(context);
        if (flag) goto _L31; else goto _L30
_L30:
        if (!"http://cdn.millennialmedia.com/mmjs/v1.7/mm.js".equals(obj)) goto _L31; else goto _L32
_L32:
        jsonobject = com.millennialmedia.android.h.a("LyohIG1tanMgLSAxLjcuMCAtIHYxLjcuMC0wLWcxYWJmNTQwIC0gMjAxNC0wNS0zMCAqLwp2YXIgTU1BcHBTdG9yZSxNTUJhbm5lcixNTUJyYW5kLE1NQnJpZGdlT2JqZWN0LE1NQ2FjaGVkVmlkZW8sTU1DYWxlbmRhcixNTUNvbW1hbmQsTU1EZXZpY2UsTU1JbmxpbmVWaWRlbyxNTUludGVyc3RpdGlhbCxNTUpTLE1NSlNVdGlscyxNTUxpc3RlbmVyTWFuYWdlcixNTU1lZGlhLE1NTm90aWZpY2F0aW9uLE1NUGFzc2Jvb2ssTU1TREtJbnRlcmZhY2UsTU1Tb2NpYWwsTU1TcGVlY2hraXQsTVJBSUQsX3JlZixfcmVmMSxfcmVmMTAsX3JlZjExLF9yZWYxMixfcmVmMixfcmVmMyxfcmVmNCxfcmVmNSxfcmVmNixfcmVmNyxfcmVmOCxfcmVmOSxfX2hhc1Byb3A9e30uaGFzT3duUHJvcGVydHksX19leHRlbmRzPWZ1bmN0aW9uKGNoaWxkLHBhcmVudCl7ZnVuY3Rpb24gY3Rvcigpe3RoaXMuY29uc3RydWN0b3I9Y2hpbGR9Zm9yKHZhciBrZXkgaW4gcGFyZW50KV9faGFzUHJvcC5jYWxsKHBhcmVudCxrZXkpJiYoY2hpbGRba2V5XT1wYXJlbnRba2V5XSk7cmV0dXJuIGN0b3IucHJvdG90eXBlPXBhcmVudC5wcm90b3R5cGUsY2hpbGQucHJvdG90eXBlPW5ldyBjdG9yLGNoaWxkLl9fc3VwZXJfXz1wYXJlbnQucHJvdG90eXBlLGNoaWxkfTtTdHJpbmcucHJvdG90eXBlLnRyaW09ZnVuY3Rpb24oKXtyZXR1cm4gdGhpcy5yZXBsYWNlKFJlZ0V4cCgiXlxccyt8XFxzKyQiLCJnIiksIiIpfSxTdHJpbmcucHJvdG90eXBlLnRpdGxlQ2FzZT1mdW5jdGlvbigpe3JldHVybiB0aGlzLnJlcGxhY2UoUmVnRXhwKCJcXHdcXFMqIiwiZyIpLGZ1bmN0aW9uKHN0cil7cmV0dXJuIHN0ci5jaGFyQXQoMCkudG9VcHBlckNhc2UoKS5jb25jYXQoc3RyLnN1YnN0cigxKS50b0xvd2VyQ2FzZSgpKX0pfSwidW5kZWZpbmVkIj09dHlwZW9mIE1NSlMmJihNTUpTVXRpbHM9ZnVuY3Rpb24oKXtmdW5jdGlvbiBNTUpTVXRpbHMoKXt9cmV0dXJuIE1NSlNVdGlscy5pb3NfdmVyc2lvbj1udWxsLE1NSlNVdGlscy5wbGF0Zm9ybT1udWxsLE1NSlNVdGlscy5zZGtfdmVyc2lvbj1udWxsLE1NSlNVdGlscy5wYXJhbXM9bnVsbCxNTUpTVXRpbHMuaXNCcmlkZ2VFbmFibGVkPWZ1bmN0aW9uKCl7cmV0dXJuInVua25vd24iIT09TU1EZXZpY2UucmVhZHlTdGF0ZT8hMDohMX0sTU1KU1V0aWxzLmlzUHJlNDY9ZnVuY3Rpb24oYSl7cmV0dXJuIHRoaXMuaXNCcmlkZ2VFbmFibGVkKCk9PT0hMD8hMTpudWxsPT1hPyEwOnRoaXMudW5kZXJWZXJzaW9uKGEsIjQuNi4wIil9LE1NSlNVdGlscy51bmRlclZlcnNpb249ZnVuY3Rpb24odmVyc2lvblN0cmluZyxtaW5WZXJzaW9uKXt2YXIgaSxyZXMscmVzdWx0LHYxLHYyO2lmKG51bGw9PXZlcnNpb25TdHJpbmcpcmV0dXJuITE7Zm9yKHYxPXZlcnNpb25TdHJpbmcuc3BsaXQoIi4iKSx2Mj1taW5WZXJzaW9uLnNwbGl0KCIuIiksaT0wLHJlc3VsdD0wO2k8TWF0aC5taW4odjEubGVuZ3RoLHYyLmxlbmd0aCk7KXtpZihyZXM9djFbaV0tdjJbaV0sMCE9PXJlcyl7cmVzdWx0PXJlczticmVha31pKyt9cmV0dXJuIDA+cmVzdWx0fSxNTUpTVXRpbHMuaXNWZXJzaW9uPWZ1bmN0aW9uKHZlcnNpb25TdHJpbmcpe3ZhciBpLHJlcyxyZXN1bHQsdjEsdjI7aWYobnVsbD09dmVyc2lvblN0cmluZylyZXR1cm4hMTtmb3IodjE9dmVyc2lvblN0cmluZy5zcGxpdCgiLiIpLHYyPXRoaXMuc2RrVmVyc2lvbigpLnNwbGl0KCIuIiksaT0wLHJlc3VsdD0wO2k8TWF0aC5taW4odjEubGVuZ3RoLHYyLmxlbmd0aCk7KXtpZihyZXM9djFbaV0tdjJbaV0sMCE9PXJlcyl7cmVzdWx0PXJlczticmVha31pKyt9cmV0dXJuIDA9PT1yZXN1bHR9LE1NSlNVdGlscy5pc0lPUz1mdW5jdGlvbigpe3JldHVybiJpb3MiPT09dGhpcy5nZXRQbGF0Zm9ybSgpfSxNTUpTVXRpbHMuaXNXaW5kb3dzPWZ1bmN0aW9uKCl7cmV0dXJuIndpbmRvd3MiPT09dGhpcy5nZXRQbGF0Zm9ybSgpfSxNTUpTVXRpbHMuaXNCbGFja0JlcnJ5PWZ1bmN0aW9uKCl7cmV0dXJuImJsYWNrYmVycnkiPT09dGhpcy5nZXRQbGF0Zm9ybSgpfSxNTUpTVXRpbHMuaXNBbmRyb2lkPWZ1bmN0aW9uKCl7cmV0dXJuImFuZHJvaWQiPT09dGhpcy5nZXRQbGF0Zm9ybSgpfSxNTUpTVXRpbHMuZ2V0UGxhdGZvcm09ZnVuY3Rpb24oKXtyZXR1cm4gbnVsbCE9dGhpcy5wbGF0Zm9ybT90aGlzLnBsYXRmb3JtOih0aGlzLnBsYXRmb3JtPW51bGwhPW5hdmlnYXRvci5wbGF0Zm9ybS5tYXRjaCgvKEFuZHJvaWQpLyk/ImFuZHJvaWQiOm51bGwhPW5hdmlnYXRvci5wbGF0Zm9ybS5tYXRjaCgvXihpUGFkfGlQb2R8aVBob25lKS8pPyJpb3MiOiJhbmRyb2lkIix0aGlzLnBsYXRmb3JtKX0sTU1KU1V0aWxzLnNka1ZlcnNpb249ZnVuY3Rpb24oKXt2YXIgbW1pc2RrLHBhcmFtcztyZXR1cm4gbnVsbCE9dGhpcy5zZGtfdmVyc2lvbj90aGlzLnNka192ZXJzaW9uOm51bGwhPU1NSlMuc2RrVmVyc2lvbj8odGhpcy5zZGtfdmVyaXNvbj1NTUpTLnNka1ZlcnNpb24sdGhpcy5zZGtfdmVyc2lvbik6KHBhcmFtcz10aGlzLmdldFBhcmFtcygpLG51bGwhPXBhcmFtcy5zZGt2ZXJzaW9uPyhtbWlzZGs9cGFyYW1zLnNka3ZlcnNpb24uc3BsaXQoIi0iKSx0aGlzLnNka192ZXJzaW9uPW1taXNka1swXSx0aGlzLnNka192ZXJzaW9uKTpudWxsKX0sTU1KU1V0aWxzLnNpbXVsYXRlUmVkaXJlY3Q9ZnVuY3Rpb24odXJsKXt2YXIgZXZlbnRGaXJlLGxpbmtUYWc7cmV0dXJuIGxpbmtUYWc9ZG9jdW1lbnQuY3JlYXRlRWxlbWVudCgiYSIpLGxpbmtUYWcuaWQ9Im1tX3NpbXVsYXRlTGluayIsbGlua1RhZy5zZXRBdHRyaWJ1dGUoImhyZWYiLHVybCksbGlua1RhZy5zZXRBdHRyaWJ1dGUoInN0eWxlIiwib3BhY2l0eTowIiksZG9jdW1lbnQuYm9keS5hcHBlbmRDaGlsZChsaW5rVGFnKSxldmVudEZpcmU9ZnVuY3Rpb24oZWwsZXR5cGUpe3ZhciBldk9iajtyZXR1cm4gZWwuZmlyZUV2ZW50P2VsLmZpcmVFdmVudCgib24iK2V0eXBlKTooZXZPYmo9ZG9jdW1lbnQuY3JlYXRlRXZlbnQoIkV2ZW50cyIpLGV2T2JqLmluaXRFdmVudChldHlwZSwhMCwhMSksZWwuZGlzcGF0Y2hFdmVudChldk9iaikpfSx3aW5kb3cuc2V0VGltZW91dChmdW5jdGlvbigpe3ZhciBlbGVtZW50O3JldHVybiBlbGVtZW50PWxpbmtUYWcsZXZlbnRGaXJlKGxpbmtUYWcsImNsaWNrIil9LDEpfSxNTUpTVXRpbHMubW9kRHVyYXRpb249ZnVuY3Rpb24oZHVyYXRpb24pe3JldHVybiB0aGlzLmlzQW5kcm9pZCgpJiYxMDA+ZHVyYXRpb24/MWUzKmR1cmF0aW9uOmR1cmF0aW9ufSxNTUpTVXRpbHMuZ2V0UGFyYW1zPWZ1bmN0aW9uKCl7dmFyIG4sbmFtZSxwYWlyLHBhcmFtcyxxcyx2YWx1ZSxfaSxfbGVuLF9yZWYsX3JlZjE7aWYobnVsbCE9dGhpcy5wYXJhbXMpcmV0dXJuIHRoaXMucGFyYW1zO2lmKHBhcmFtcz17fSxxcz13aW5kb3cubG9jYXRpb24uc2VhcmNoLnN1YnN0cmluZygxKSxxcy5sZW5ndGgpZm9yKF9yZWY9ZnVuY3Rpb24oKXt2YXIgX2osX2xlbixfcmVmLF9yZXN1bHRzO2ZvcihfcmVmPXFzLnNwbGl0KCImIiksX3Jlc3VsdHM9W10sX2o9MCxfbGVuPV9yZWYubGVuZ3RoO19sZW4+X2o7X2orKylwYWlyPV9yZWZbX2pdLF9yZXN1bHRzLnB1c2gocGFpci5zcGxpdCgiPSIpKTtyZXR1cm4gX3Jlc3VsdHN9KCksX2k9MCxfbGVuPV9yZWYubGVuZ3RoO19sZW4+X2k7X2krKylfcmVmMT1fcmVmW19pXSxuYW1lPV9yZWYxWzBdLHZhbHVlPV9yZWYxWzFdLG49bmFtZS5yZXBsYWNlKCJtbV8iLCIiKSxudWxsIT12YWx1ZSYmKHBhcmFtc1tuXT12YWx1ZSk7cmV0dXJuIHRoaXMucGFyYW1zPXBhcmFtcyx0aGlzLnBhcmFtc30sTU1KU1V0aWxzLmNvbnNvbGVMb2c9ZnVuY3Rpb24oX21zZyxfdXNlQWxlcnQpe3JldHVybiBudWxsPT1fdXNlQWxlcnQmJihfdXNlQWxlcnQ9ITEpLE1NSlMuZXZlbnRUcmFja2luZy5wdXNoKF9tc2cpLHRoaXMuaXNBbmRyb2lkKCk/bnVsbCE9d2luZG93LmNvbnNvbGUmJndpbmRvdy5jb25zb2xlLmxvZyhfbXNnKTp0aGlzLmlzV2luZG93cygpP3dpbmRvdy5leHRlcm5hbC5ub3RpZnkoX21zZyk6KG51bGwhPXdpbmRvdy5jb25zb2xlJiZ3aW5kb3cuY29uc29sZS5sb2coX21zZyksX3VzZUFsZXJ0JiZhbGVydChfbXNnKSksITF9LE1NSlNVdGlscy5pT1NWZXJzaW9uPWZ1bmN0aW9uKCl7dmFyIF92O3JldHVybiB0aGlzLmlvc192ZXJzaW9uP3RoaXMuaW9zX3ZlcnNpb246KF92PW5hdmlnYXRvci5hcHBWZXJzaW9uLnNwbGl0KCIgT1MgIilbMV0sX3Y9X3Yuc3BsaXQoIiAiKVswXS50cmltKCkuc3BsaXQoIl8iKSxfdi5zcGxpY2UoMSwwLCIuIiksdGhpcy5pb3NfdmVyc2lvbj1wYXJzZUZsb2F0KF92LmpvaW4oIiIpKSl9LE1NSlNVdGlscy5nZXRMb2NhdGlvbj1mdW5jdGlvbihmdW5jLGVycm9yKXtyZXR1cm4gbmF2aWdhdG9yLmdlb2xvY2F0aW9uP25hdmlnYXRvci5nZW9sb2NhdGlvbi5nZXRDdXJyZW50UG9zaXRpb24oZnVuYyxlcnJvcix7ZW5hYmxlSGlnaEFjY3VyYWN5OiEwfSk6ZXJyb3Ioe2NvZGU6OTl9KX0sTU1KU1V0aWxzLmxpc3RlbkZvckJyb3dzZXJSZWFkeT1mdW5jdGlvbihmdW5jKXtyZXR1cm4gdGhpcy5pc1dpbmRvd3MoKT9kb2N1bWVudC5hdHRhY2hFdmVudCgib25yZWFkeXN0YXRlY2hhbmdlIixmdW5jKTpkb2N1bWVudC5hZGRFdmVudExpc3RlbmVyKCJET01Db250ZW50TG9hZGVkIixmdW5jLCExKX0sTU1KU1V0aWxzLnBvc3RFdmVudD1mdW5jdGlvbihldmVudCl7dmFyIGV2T2JqO3JldHVybiBkb2N1bWVudC5jcmVhdGVFdmVudD8oZXZPYmo9ZG9jdW1lbnQuY3JlYXRlRXZlbnQoIkV2ZW50IiksZXZPYmouaW5pdEV2ZW50KGV2ZW50LCEwLCEwKSx3aW5kb3cuZG9jdW1lbnQuZGlzcGF0Y2hFdmVudChldk9iaikpOmRvY3VtZW50LmNyZWF0ZUV2ZW50T2JqZWN0fHx0aGlzLmlzV2luZG93cygpP2RvY3VtZW50LmJvZHkuZmlyZUV2ZW50KCJvbiIrZXZlbnQpOnZvaWQgMH0sTU1KU1V0aWxzLm9mZnNldD1mdW5jdGlvbihfZWwpe3ZhciBjb29yZHMscF9jb29yZHM7cmV0dXJuIGNvb3Jkcz1bX2VsLm9mZnNldExlZnQsX2VsLm9mZnNldFRvcF0sbnVsbCE9X2VsLm9mZnNldFBhcmVudCYmKHBfY29vcmRzPXRoaXMub2Zmc2V0KF9lbC5vZmZzZXRQYXJlbnQpLGNvb3Jkc1swXSs9cF9jb29yZHNbMF0sY29vcmRzWzFdKz1wX2Nvb3Jkc1sxXSksY29vcmRzfSxNTUpTVXRpbHN9KCksTU1KUz1mdW5jdGlvbigpe2Z1bmN0aW9uIE1NSlMoKXt9cmV0dXJuIE1NSlMuVkVSU0lPTj0iMS4zIixNTUpTLmNvbW1hbmRRdWV1ZT1bXSxNTUpTLmFuZHJvaWRJbnRlcmZhY2U9d2luZG93WyJpbnRlcmZhY2UiXSxNTUpTLnV0aWxzPU1NSlNVdGlscyxNTUpTLnNka1JlYWR5PSExLE1NSlMuZXhlY3V0aW5nQ29tbWFuZD0hMSxNTUpTLmV4ZWN1dGluZ0NvbW1hbmREZWxheT0wLE1NSlMucGFyYW1zPW51bGwsTU1KUy5wbGF0Zm9ybT1udWxsLE1NSlMuY2FsbGJhY2tzPXt9LE1NSlMubGlzdGVuZXJzPXt9LE1NSlMuc2RrVmVyc2lvbj1udWxsLE1NSlMub3BlbkNhbGxlZD0hMSxNTUpTLlRZUEVfU1RSSU5HPSJzdHJpbmciLE1NSlMuVFlQRV9PQkpFQ1Q9dHlwZW9mW10sTU1KUy5UWVBFX0ZVTkNUSU9OPSJmdW5jdGlvbiIsTU1KUy5UWVBFX05VTUJFUj0ibnVtYmVyIixNTUpTLlRZUEVfVU5ERUZJTkVEPSJ1bmRlZmluZWQiLE1NSlMuZXZlbnRUcmFja2luZz1bXSxNTUpTLnNldEV4ZWN1dGluZ0NvbW1hbmQ9ZnVuY3Rpb24oX2V4ZWN1dGluZyxfdGltZSl7cmV0dXJuIG51bGw9PV90aW1lJiYoX3RpbWU9MWU0KSx0aGlzLmxvZ0NhbGxzdGFjaygpLHRoaXMuZXhlY3V0aW5nQ29tbWFuZD1fZXhlY3V0aW5nfSxNTUpTLmxvZ0NhbGxzdGFjaz1mdW5jdGlvbigpe3ZhciBjYWxsc3RhY2ssY3VycmVudEZ1bmN0aW9uLGZuLGZuYW1lO2ZvcihjYWxsc3RhY2s9W10sY3VycmVudEZ1bmN0aW9uPWFyZ3VtZW50cy5jYWxsZWUuY2FsbGVyO2N1cnJlbnRGdW5jdGlvbjspZm49Y3VycmVudEZ1bmN0aW9uLnRvU3RyaW5nKCksZm5hbWU9Zm4uc3Vic3RyaW5nKGZuLmluZGV4T2YoImZ1bmN0aW9uIikrOCxmbi5pbmRleE9mKCIiKSl8fCJhbm9ueW1vdXMiLGNhbGxzdGFjay5wdXNoKGZuYW1lKSxjdXJyZW50RnVuY3Rpb249Y3VycmVudEZ1bmN0aW9uLmNhbGxlcjtyZXR1cm4gTU1KUy51dGlscy5jb25zb2xlTG9nKGNhbGxzdGFjayl9LE1NSlMuZGVidWc9ZnVuY3Rpb24oKXt2YXIgdG9Mb2c7cmV0dXJuIHRvTG9nPXRoaXMuZXZlbnRUcmFja2luZy5qb2luKCJcbiIpLGNvbnNvbGUubG9nKHRvTG9nKSwhMH0sTU1KUy5zZXRTREtWZXJzaW9uPWZ1bmN0aW9uKHZlcnNpb24pe3JldHVybiB0aGlzLnNka1ZlcnNpb249dmVyc2lvbn0sTU1KUy5tbXNka09wZW5GdW5jdGlvbj1udWxsLE1NSlMuc2hvdWxkT3Blbldhc0NhbGxlZD0hMSxNTUpTLnNldHVwT3ZlcmxheT1mdW5jdGlvbih1cmwscGFyYW1zKXtyZXR1cm4gbnVsbD09cGFyYW1zJiYocGFyYW1zPXt9KSx0aGlzLm9wZW4odXJsLHBhcmFtcywhMSl9LE1NSlMub3Blbj1mdW5jdGlvbih1cmwscGFyYW1zLGF1dG9FeHBhbmQpe3JldHVybiBudWxsPT1wYXJhbXMmJihwYXJhbXM9e30pLG51bGw9PWF1dG9FeHBhbmQmJihhdXRvRXhwYW5kPSEwKSxtcmFpZC5zZXRFeHBhbmRQcm9wZXJ0aWVzKHBhcmFtcyksbXJhaWQuZXhwYW5kKHVybCl9LE1NSlMuY2xvc2U9ZnVuY3Rpb24oZHVyYXRpb24pe3ZhciBtb2REdXJhdGlvbjtyZXR1cm4gbnVsbD09ZHVyYXRpb24mJihkdXJhdGlvbj0wKSxtb2REdXJhdGlvbj1mdW5jdGlvbihkdXJhdGlvbil7cmV0dXJuIDEwMD5kdXJhdGlvbj8xZTMqZHVyYXRpb246ZHVyYXRpb259LHNldFRpbWVvdXQoZnVuY3Rpb24oKXtyZXR1cm4gTU1KUy5pbnRlcnN0aXRpYWwuY2xvc2UoKX0sbW9kRHVyYXRpb24oZHVyYXRpb24pKX0sTU1KUy5vcGVuRXh0ZXJuYWw9ZnVuY3Rpb24odXJsKXtyZXR1cm4gdGhpcy51dGlscy5pc0JyaWRnZUVuYWJsZWQoKT9NTURldmljZS5vcGVuVXJsKHVybCk6d2luZG93LmxvY2F0aW9uPXRoaXMudXRpbHMuaXNJT1MoKT8ibW1icm93c2VyOjovLyIrdXJsOiJtbWJyb3dzZXI6Ly8iK3VybH0sTU1KUy5yZW1vdmVFdmVudExpc3RlbmVyPWZ1bmN0aW9uKGV2ZW50KXtyZXR1cm4gZGVsZXRlIHRoaXMubGlzdGVuZXJzW2V2ZW50XX0sTU1KUy5hZGRFdmVudExpc3RlbmVyPWZ1bmN0aW9uKGV2ZW50LGxpc3RlbmVyKXtyZXR1cm4gdGhpcy5saXN0ZW5lcnNbZXZlbnRdPWxpc3RlbmVyfSxNTUpTLmVucXVldWVDb21tYW5kPWZ1bmN0aW9uKGNvbW1hbmQpe3JldHVybiB0aGlzLmNvbW1hbmRRdWV1ZS5wdXNoKGNvbW1hbmQpLHRoaXMudXRpbHMuY29uc29sZUxvZygiY29tbWFuZFF1ZXVlICIrTU1KUy5jb21tYW5kUXVldWUpfSxNTUpTLmNhbGxiYWNrPWZ1bmN0aW9uKHJlc3BvbnNlKXt2YXIga2xhc3Msa2xhc3NGdW5jdGlvbixtZXRob2QscmVzcG9uc2VfZGF0YSxyZXN1bHQ7cmV0dXJuIHJlc3VsdD1yZXNwb25zZS5yZXN1bHQsbWV0aG9kPXJlc3BvbnNlLmNhbGwscmVzcG9uc2VfZGF0YT1yZXNwb25zZS5yZXNwb25zZSxrbGFzcz1yZXNwb25zZVsiY2xhc3MiXSxrbGFzc0Z1bmN0aW9uPXdpbmRvd1trbGFzc10sdHlwZW9mIGtsYXNzRnVuY3Rpb249PT10aGlzLlRZUEVfRlVOQ1RJT04/a2xhc3NGdW5jdGlvbihtZXRob2QscmVzcG9uc2VfZGF0YSxyZXN1bHQpOnZvaWQgMH0sTU1KU30oKSxNTVNES0ludGVyZmFjZT1mdW5jdGlvbigpe2Z1bmN0aW9uIE1NU0RLSW50ZXJmYWNlKCl7dGhpcy5zdGF0ZT0ibG9hZGluZyIsdGhpcy5pc1JlYWR5PSExLHRoaXMuYWRQcm9wZXJ0aWVzPXZvaWQgMCx0aGlzLnZpZXdhYmxlPSExLHRoaXMucGxhY2VtZW50VHlwZT0idW5rbm93biIsdGhpcy5hZFNpemU9e30sdGhpcy5kZWZhdWx0UG9zaXRpb249dm9pZCAwLHRoaXMudXRpbHM9TU1KUy51dGlscyx0aGlzLnNwZWVjaFJlc3VsdHM9bnVsbCx0aGlzLnNwZWVjaFN0YXR1cz0idW5rbm93biIsdGhpcy5zcGVlY2hBdWRpb0xldmVsPTAsdGhpcy5zcGVlY2hCYWNrZ3JvdW5kQXVkaW9MZXZlbD0wLHRoaXMuYXVkaW9Qb3NpdGlvbj0wLHRoaXMubWljcm9waG9uZVN0YXRlPSJyZWFkeSIsdGhpcy5taWNyb3Bob25lQXVkaW9MZXZlbD0wfXJldHVybiBNTVNES0ludGVyZmFjZS5wcm90b3R5cGUuc2V0QWRTaXplPWZ1bmN0aW9uKF9wcm9wZXJ0aWVzKXtyZXR1cm4gdGhpcy51dGlscy5jb25zb2xlTG9nKCJtbS5jb2ZmZWUgTU1TREtJbnRlcmZhY2Ugc2V0QWRTaXplIF9wcm9wZXJ0aWVzPSIrSlNPTi5zdHJpbmdpZnkoX3Byb3BlcnRpZXMpKSx0aGlzLnV0aWxzLmNvbnNvbGVMb2coIm1tLmNvZmZlZSBNTVNES0ludGVyZmFjZSBzZXRBZFNpemUgZ2V0U3RhdGU9Iit0aGlzLnN0YXRlKSx0aGlzLmFkU2l6ZT90aGlzLmFkU2l6ZS5oZWlnaHQhPT1fcHJvcGVydGllcy5oZWlnaHR8fHRoaXMuYWRTaXplLndpZHRoIT09X3Byb3BlcnRpZXMud2lkdGg/KHRoaXMuYWRTaXplPV9wcm9wZXJ0aWVzLE1NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygic2l6ZUNoYW5nZSIsX3Byb3BlcnRpZXMud2lkdGgsX3Byb3BlcnRpZXMuaGVpZ2h0KSk6dm9pZCAwOnRoaXMuYWRTaXplPV9wcm9wZXJ0aWVzfSxNTVNES0ludGVyZmFjZS5wcm90b3R5cGUuc2V0QWRQcm9wZXJ0aWVzPWZ1bmN0aW9uKF9hZFByb3BlcnRpZXMpe3JldHVybiB0aGlzLnV0aWxzLmNvbnNvbGVMb2coInNldEFkUHJvcGVydGllczogIitKU09OLnN0cmluZ2lmeShfYWRQcm9wZXJ0aWVzKSksdGhpcy5hZFByb3BlcnRpZXM9X2FkUHJvcGVydGllcyxudWxsIT10aGlzLmFkUHJvcGVydGllcyYmKG51bGwhPXRoaXMuYWRQcm9wZXJ0aWVzLmFkJiYodGhpcy5hZFNpemU9dGhpcy5hZFByb3BlcnRpZXMuYWQsdGhpcy5kZWZhdWx0UG9zaXRpb249SlNPTi5wYXJzZShKU09OLnN0cmluZ2lmeSh0aGlzLmFkUHJvcGVydGllcy5hZCkpKSxudWxsIT10aGlzLmFkUHJvcGVydGllcy5kZXZpY2UmJk1NSlMuZGV2aWNlLnNldEluZm8odGhpcy5hZFByb3BlcnRpZXMuZGV2aWNlKSxudWxsIT10aGlzLmFkUHJvcGVydGllcy5zdXBwb3J0cyk/dGhpcy5zdXBwb3J0UHJvcGVydGllcz10aGlzLmFkUHJvcGVydGllcy5zdXBwb3J0czp2b2lkIDB9LE1NU0RLSW50ZXJmYWNlLnByb3RvdHlwZS5zZXRQbGFjZW1lbnRUeXBlPWZ1bmN0aW9uKHBsYWNlbWVudFR5cGUpe3RoaXMucGxhY2VtZW50VHlwZT1wbGFjZW1lbnRUeXBlfSxNTVNES0ludGVyZmFjZS5wcm90b3R5cGUuc2V0U3RhdGU9ZnVuY3Rpb24oX3N0YXRlKXtyZXR1cm4gdGhpcy5zdGF0ZSE9PV9zdGF0ZT8odGhpcy51dGlscy5jb25zb2xlTG9nKCdNUkFJRCBzdGF0ZSBjaGFuZ2UgZnJvbSAiJyt0aGlzLnN0YXRlKyciIHRvICInK19zdGF0ZSsnIicpLHRoaXMuc3RhdGU9X3N0YXRlLE1NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygic3RhdGVDaGFuZ2UiLF9zdGF0ZSkpOnZvaWQgMH0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLnNldFZpZXdhYmxlPWZ1bmN0aW9uKF92aXNpYmxlKXtyZXR1cm4gdGhpcy52aWV3YWJsZSE9PV92aXNpYmxlPyh0aGlzLnV0aWxzLmNvbnNvbGVMb2coIk1SQUlEIHZpZXdhYmxlIGNoYW5nZTogdmlzaWJsZSA9ICIrX3Zpc2libGUpLHRoaXMudmlld2FibGU9X3Zpc2libGUsTU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJ2aWV3YWJsZUNoYW5nZSIsX3Zpc2libGUpKTp2b2lkIDB9LE1NU0RLSW50ZXJmYWNlLnByb3RvdHlwZS5yZWFkeT1mdW5jdGlvbigpe3JldHVybiJsb2FkaW5nIiE9PXRoaXMuc3RhdGUmJnRoaXMuaXNSZWFkeT09PSExPyh0aGlzLnV0aWxzLmNvbnNvbGVMb2coIk1SQUlEIHJlYWR5LiIpLHRoaXMudXRpbHMucG9zdEV2ZW50KCJzZGtyZWFkeSIpLHRoaXMuaXNSZWFkeT0hMCxNTUpTLmxpc3RlbmVyTWFuYWdlci5maXJlRXZlbnRDYWxsYmFja3MoInJlYWR5IikpOnZvaWQgMH0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLmVycm9yPWZ1bmN0aW9uKG1lc3NhZ2UsYWN0aW9uKXtyZXR1cm4gTU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJlcnJvciIsbWVzc2FnZSxhY3Rpb24pfSxNTVNES0ludGVyZmFjZS5wcm90b3R5cGUudm9pY2VTdGF0ZUNoYW5nZT1mdW5jdGlvbihfc3RhdHVzKXtyZXR1cm4gdGhpcy5zcGVlY2hTdGF0dXM9X3N0YXR1cyxNTUpTLmxpc3RlbmVyTWFuYWdlci5maXJlRXZlbnRDYWxsYmFja3MoInZvaWNlU3RhdGVDaGFuZ2UiLF9zdGF0dXMpfSxNTVNES0ludGVyZmFjZS5wcm90b3R5cGUuYXVkaW9MZXZlbENoYW5nZT1mdW5jdGlvbihfYXVkaW9MZXZlbCl7cmV0dXJuIHRoaXMuc3BlZWNoQXVkaW9MZXZlbD1fYXVkaW9MZXZlbCxNTUpTLmxpc3RlbmVyTWFuYWdlci5maXJlRXZlbnRDYWxsYmFja3MoImF1ZGlvTGV2ZWxDaGFuZ2UiLF9hdWRpb0xldmVsKX0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLnJlY29nbml0aW9uUmVzdWx0PWZ1bmN0aW9uKF9yZXN1bHRzKXtyZXR1cm4gdGhpcy5zcGVlY2hSZXN1bHRzPV9yZXN1bHRzLE1NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygicmVjb2duaXRpb25SZXN1bHQiLF9yZXN1bHRzKX0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLnZvaWNlRXJyb3I9ZnVuY3Rpb24oX2Vycm9yKXtyZXR1cm4gTU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJ2b2ljZUVycm9yIixfZXJyb3IpfSxNTVNES0ludGVyZmFjZS5wcm90b3R5cGUuYmFja2dyb3VuZEF1ZGlvTGV2ZWw9ZnVuY3Rpb24oX2JhY2tncm91bmRBdWRpb0xldmVsKXtyZXR1cm4gdGhpcy5zcGVlY2hCYWNrZ3JvdW5kQXVkaW9MZXZlbD1fYmFja2dyb3VuZEF1ZGlvTGV2ZWwsTU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJiYWNrZ3JvdW5kQXVkaW9MZXZlbCIsX2JhY2tncm91bmRBdWRpb0xldmVsKX0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLmF1ZGlvQ2FjaGVkPWZ1bmN0aW9uKCl7cmV0dXJuIE1NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygiYXVkaW9DYWNoZWQiKX0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLmF1ZGlvU3RhcnRlZD1mdW5jdGlvbigpe3JldHVybiBNTUpTLmxpc3RlbmVyTWFuYWdlci5maXJlRXZlbnRDYWxsYmFja3MoImF1ZGlvU3RhcnRlZCIpfSxNTVNES0ludGVyZmFjZS5wcm90b3R5cGUuYXVkaW9Qb3NpdGlvbkNoYW5nZT1mdW5jdGlvbihfcG9zaXRpb24pe3JldHVybiB0aGlzLmF1ZGlvUG9zaXRpb249X3Bvc2l0aW9uLE1NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygiYXVkaW9Qb3NpdGlvbkNoYW5nZSIsX3Bvc2l0aW9uKX0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLmF1ZGlvQ29tcGxldGVkPWZ1bmN0aW9uKCl7cmV0dXJuIE1NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygiYXVkaW9Db21wbGV0ZWQiKX0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLmN1c3RvbVZvaWNlV29yZHNBZGRlZD1mdW5jdGlvbigpe3JldHVybiBNTUpTLmxpc3RlbmVyTWFuYWdlci5maXJlRXZlbnRDYWxsYmFja3MoImN1c3RvbVZvaWNlV29yZHNBZGRlZCIpfSxNTVNES0ludGVyZmFjZS5wcm90b3R5cGUuY3VzdG9tVm9pY2VXb3Jkc0RlbGV0ZWQ9ZnVuY3Rpb24oKXtyZXR1cm4gTU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJjdXN0b21Wb2ljZVdvcmRzRGVsZXRlZCIpfSxNTVNES0ludGVyZmFjZS5wcm90b3R5cGUubWljcm9waG9uZVN0YXRlQ2hhbmdlPWZ1bmN0aW9uKF9tcFN0YXRlKXtyZXR1cm4gdGhpcy5taWNyb3Bob25lU3RhdGU9X21wU3RhdGUsTU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJtaWNyb3Bob25lU3RhdGVDaGFuZ2UiLF9tcFN0YXRlKX0sTU1TREtJbnRlcmZhY2UucHJvdG90eXBlLm1pY3JvcGhvbmVBdWRpb0xldmVsQ2hhbmdlPWZ1bmN0aW9uKF9tcGF1ZGlvTGV2ZWwpe3JldHVybiB0aGlzLm1pY3JvcGhvbmVBdWRpb0xldmVsPV9tcGF1ZGlvTGV2ZWwsTU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJtaWNyb3Bob25lQXVkaW9MZXZlbENoYW5nZSIsX21wYXVkaW9MZXZlbCl9LE1NU0RLSW50ZXJmYWNlfSgpLE1NTGlzdGVuZXJNYW5hZ2VyPWZ1bmN0aW9uKCl7ZnVuY3Rpb24gTU1MaXN0ZW5lck1hbmFnZXIoKXt0aGlzLmxpc3RlbmVycz17fSx0aGlzLnV0aWxzPU1NSlMudXRpbHN9cmV0dXJuIE1NTGlzdGVuZXJNYW5hZ2VyLnByb3RvdHlwZS5yZW1vdmVFdmVudExpc3RlbmVyPWZ1bmN0aW9uKGV2ZW50LGxpc3RlbmVyKXt2YXIgaW5kZXg7cmV0dXJuIG51bGwhPXRoaXMubGlzdGVuZXJzW2V2ZW50XT9udWxsIT1saXN0ZW5lcj8oaW5kZXg9dGhpcy5saXN0ZW5lcnNbZXZlbnRdLmluZGV4T2YobGlzdGVuZXIpLDA+aW5kZXg/KHRoaXMudXRpbHMuY29uc29sZUxvZygiTGlzdG5lciBub3QgZm91bmQhIiksITEpOih0aGlzLnV0aWxzLmNvbnNvbGVMb2coIiciK2V2ZW50KyInIGZvdW5kIGxpc3RlbmVyOiAiK2xpc3RlbmVyKSx0aGlzLmxpc3RlbmVyc1tldmVudF0uc3BsaWNlKGluZGV4LDEpLHRoaXMudXRpbHMuY29uc29sZUxvZygiJyIrZXZlbnQrIicgbGlzdGVuZXJzOiAiK3RoaXMubGlzdGVuZXJzW2V2ZW50XSkpKTpkZWxldGUgdGhpcy5saXN0ZW5lcnNbZXZlbnRdOnZvaWQgMH0sTU1MaXN0ZW5lck1hbmFnZXIucHJvdG90eXBlLmFkZEV2ZW50TGlzdGVuZXI9ZnVuY3Rpb24oZXZlbnQsbGlzdGVuZXIpe3JldHVybiBudWxsPT10aGlzLmxpc3RlbmVyc1tldmVudF0mJih0aGlzLmxpc3RlbmVyc1tldmVudF09W10pLHRoaXMudXRpbHMuY29uc29sZUxvZygiJyIrZXZlbnQrIicgYWRkZWQgbGlzdGVuZXI6ICIrbGlzdGVuZXIpLHRoaXMubGlzdGVuZXJzW2V2ZW50XS5wdXNoKGxpc3RlbmVyKSx0aGlzLnV0aWxzLmNvbnNvbGVMb2coIiciK2V2ZW50KyInIGxpc3RlbmVyczogIit0aGlzLmxpc3RlbmVyc1tldmVudF0pfSxNTUxpc3RlbmVyTWFuYWdlci5wcm90b3R5cGUuZmlyZUV2ZW50Q2FsbGJhY2tzPWZ1bmN0aW9uKGV2ZW50TmFtZSxwYXJhbWV0ZXIsYWN0aW9uKXt2YXIgY2FsbGJhY2ssX2ksX2xlbixfcmVmO2lmKHRoaXMudXRpbHMuY29uc29sZUxvZygiZXZlbnQgY2FsbGJhY2s6ICIrZXZlbnROYW1lKSxudWxsIT10aGlzLmxpc3RlbmVyc1tldmVudE5hbWVdKWZvcihfcmVmPXRoaXMubGlzdGVuZXJzW2V2ZW50TmFtZV0sX2k9MCxfbGVuPV9yZWYubGVuZ3RoO19sZW4+X2k7X2krKyljYWxsYmFjaz1fcmVmW19pXSxudWxsIT1wYXJhbWV0ZXI/bnVsbCE9YWN0aW9uP2NhbGxiYWNrKHBhcmFtZXRlcixhY3Rpb24pOmNhbGxiYWNrKHBhcmFtZXRlcik6Y2FsbGJhY2soKX0sTU1MaXN0ZW5lck1hbmFnZXJ9KCksTU1Db21tYW5kPWZ1bmN0aW9uKCl7ZnVuY3Rpb24gTU1Db21tYW5kKGNvbW1hbmQscGFyYW1zKXt2YXIgZnVuYyxmdW5jdGlvbk5hbWUsbmFtZSxxdWVyeV9hcmdzLHRpbWVzdGFtcCx1cmw7aWYodGhpcy51dGlscz1NTUpTLnV0aWxzLHRoaXMucGxhdGZvcm09dGhpcy51dGlscy5nZXRQbGF0Zm9ybSgpLHRoaXMuY29tbWFuZD1jb21tYW5kLHVybD0ibW1zZGs6Ly8iK2NvbW1hbmQrIi8iLG51bGwhPXBhcmFtcyl7cXVlcnlfYXJncz1bXSx0aW1lc3RhbXA9KG5ldyBEYXRlKS5nZXRUaW1lKCksZnVuYz1wYXJhbXMuY2FsbGJhY2ssZnVuY3Rpb25OYW1lPXRoaXMuY29tbWFuZC5yZXBsYWNlKCIuIiwiXyIpKyJfIit0aW1lc3RhbXAsTU1KUy51dGlscy5jb25zb2xlTG9nKCJjb21tYW5kOiAiK2NvbW1hbmQrIkNhbGxiYWNrIGZ1bmN0aW9uOiAiK2Z1bmMpLE1NSlMudXRpbHMuY29uc29sZUxvZygiY29tbWFuZDogIitjb21tYW5kKyIgcGFyYW1zICIrSlNPTi5zdHJpbmdpZnkocGFyYW1zKSksTU1KUy51dGlscy5jb25zb2xlTG9nKCJDYWxsYmFjayBmdW5jdGlvbjogIit0eXBlb2YgZnVuYyksdHlwZW9mIGZ1bmM9PT1NTUpTLlRZUEVfU1RSSU5HP3dpbmRvdy5NTUpTLmNhbGxiYWNrc1tmdW5jdGlvbk5hbWVdPWZ1bmN0aW9uKHJlc3BvbnNlKXt2YXIgYUZ1bmMsY29udGV4dCxpLG5hbWVzcGFjZXM7Zm9yKE1NSlMudXRpbHMuY29uc29sZUxvZygiZXhlY3V0aW5nIHN0cmluZyBmdW5jdGlvbiBjYWxsYmFjazogIitmdW5jdGlvbk5hbWUpLG51bGwhPXJlc3BvbnNlJiYocmVzcG9uc2UuZGF0YT1yZXNwb25zZS5yZXNwb25zZSksbmFtZXNwYWNlcz1mdW5jLnNwbGl0KCIuIiksYUZ1bmM9bmFtZXNwYWNlcy5wb3AoKSxpPTAsY29udGV4dD13aW5kb3c7aTxuYW1lc3BhY2VzLmxlbmd0aDspTU1KUy51dGlscy5jb25zb2xlTG9nKCJuYW1lc3BhY2U6ICIrbmFtZXNwYWNlc1tpXSksY29udGV4dD1jb250ZXh0W25hbWVzcGFjZXNbaV1dLGkrKztyZXR1cm4gTU1KUy51dGlscy5jb25zb2xlTG9nKCJhRnVuYzogIithRnVuYyksTU1KUy51dGlscy5jb25zb2xlTG9nKCJjb250ZXh0OiAiK2NvbnRleHQpLGNvbnRleHRbYUZ1bmNdKHJlc3BvbnNlKSxNTUpTLnNldEV4ZWN1dGluZ0NvbW1hbmQoITEpfTp0eXBlb2YgZnVuYz09PU1NSlMuVFlQRV9GVU5DVElPTj93aW5kb3cuTU1KUy5jYWxsYmFja3NbZnVuY3Rpb25OYW1lXT1mdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIG51bGwhPXJlc3BvbnNlJiYocmVzcG9uc2UuZGF0YT1yZXNwb25zZS5yZXNwb25zZSxyZXNwb25zZS5yZXN1bHQ9cGFyc2VJbnQocmVzcG9uc2UucmVzdWx0KSksZnVuYyhyZXNwb25zZSksTU1KUy5zZXRFeGVjdXRpbmdDb21tYW5kKCExKX06dHlwZW9mIGZ1bmM9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYod2luZG93Lk1NSlMuY2FsbGJhY2tzW2Z1bmN0aW9uTmFtZV09ZnVuY3Rpb24oKXtyZXR1cm4gTU1KUy51dGlscy5jb25zb2xlTG9nKCJleGVjdXRpbmcgdW5kZWZpbmVkIGNhbGxiYWNrOiAiK2Z1bmN0aW9uTmFtZSksTU1KUy51dGlscy5jb25zb2xlTG9nKCJubyBjYWxsYmFjayB3YXMgc3BlY2lmaWVkIiksTU1KUy5zZXRFeGVjdXRpbmdDb21tYW5kKCExKX0pLHBhcmFtcy5jYWxsYmFjaz0iTU1KUy5jYWxsYmFja3MuIitmdW5jdGlvbk5hbWUsdGhpcy5jYWxsYmFjaz1wYXJhbXMuY2FsbGJhY2s7Zm9yKG5hbWUgaW4gcGFyYW1zKXR5cGVvZiBuYW1lPT09TU1KUy5UWVBFX1NUUklORyYmdm9pZCAwIT09cGFyYW1zW25hbWVdJiZudWxsIT09cGFyYW1zW25hbWVdJiZxdWVyeV9hcmdzLnB1c2goZW5jb2RlVVJJQ29tcG9uZW50KG5hbWUpKyI9IitlbmNvZGVVUklDb21wb25lbnQocGFyYW1zW25hbWVdKSk7cXVlcnlfYXJncy5sZW5ndGg+MCYmKHVybCs9Ij8iK3F1ZXJ5X2FyZ3Muam9pbigiJiIpKX1NTUpTLnV0aWxzLmNvbnNvbGVMb2codXJsKSx0aGlzLnVybD11cmx9cmV0dXJuIE1NQ29tbWFuZC51cmw9bnVsbCxNTUNvbW1hbmQucGxhdGZvcm09bnVsbCxNTUNvbW1hbmQuY29tbWFuZD1udWxsLE1NQ29tbWFuZC5jYWxsYmFjaz1udWxsLE1NQ29tbWFuZC5wcm90b3R5cGUucGVyZm9ybT1mdW5jdGlvbigpe3ZhciBpZnJhbWU7cmV0dXJuIHRoaXMudXRpbHMuY29uc29sZUxvZygicGVyZm9ybSBwbGF0Zm9ybTogICIrdGhpcy5wbGF0Zm9ybSksdGhpcy51dGlscy5jb25zb2xlTG9nKCJjdXJyZW50IHdpbmRvdy5sb2NhdGlvbjogICIrd2luZG93LmxvY2F0aW9uKSxNTUpTLmV4ZWN1dGluZ0NvbW1hbmQ9ITAsdGhpcy51dGlscy5jb25zb2xlTG9nKCJ3aW5kb3cubG9jYXRpb246ICAiK3RoaXMudXJsKSx0aGlzLnV0aWxzLmNvbnNvbGVMb2coIlNldHRpbmcgZXhlY3V0aW5nQ29tbWFuZCA9IHRydWU6ICAiKSxpZnJhbWU9ZG9jdW1lbnQuY3JlYXRlRWxlbWVudCgiSUZSQU1FIiksaWZyYW1lLnNldEF0dHJpYnV0ZSgic3JjIix0aGlzLnVybCksZG9jdW1lbnQuZG9jdW1lbnRFbGVtZW50LmFwcGVuZENoaWxkKGlmcmFtZSksaWZyYW1lLnBhcmVudE5vZGUucmVtb3ZlQ2hpbGQoaWZyYW1lKSxpZnJhbWU9bnVsbH0sTU1Db21tYW5kfSgpLE1NQnJpZGdlT2JqZWN0PWZ1bmN0aW9uKCl7ZnVuY3Rpb24gTU1CcmlkZ2VPYmplY3QoKXt2YXIgbTt0aGlzLnV0aWxzPU1NSlMudXRpbHMsbT10aGlzLmNvbnN0cnVjdG9yLnRvU3RyaW5nKCkubWF0Y2goL15ccypmdW5jdGlvblxzKyhbXlxzXChdKykvKSxtJiYodGhpcy5jbGFzc05hbWU9bVsxXSl9cmV0dXJuIE1NQnJpZGdlT2JqZWN0LmNsYXNzTmFtZT1udWxsLE1NQnJpZGdlT2JqZWN0LnByb3RvdHlwZS5lbnF1ZXVlPWZ1bmN0aW9uKG1ldGhvZCxwYXJhbXMpe3JldHVybiBNTUpTLmVucXVldWVDb21tYW5kKG5ldyBNTUNvbW1hbmQodGhpcy5jbGFzc05hbWUrIi4iK21ldGhvZCxwYXJhbXMpKSwhMH0sTU1CcmlkZ2VPYmplY3R9KCksTU1EZXZpY2U9ZnVuY3Rpb24oX3N1cGVyKXtmdW5jdGlvbiBNTURldmljZSgpe3JldHVybiBfcmVmPU1NRGV2aWNlLl9fc3VwZXJfXy5jb25zdHJ1Y3Rvci5hcHBseSh0aGlzLGFyZ3VtZW50cyl9cmV0dXJuIF9fZXh0ZW5kcyhNTURldmljZSxfc3VwZXIpLE1NRGV2aWNlLmxvYWRTdGF0ZT0ic3RhbmRieSIsTU1EZXZpY2UubG9hZFRpbWVvdXQ9MCxNTURldmljZS5jb25uZWN0aW9uPW51bGwsTU1EZXZpY2UucHJvdG90eXBlLnNldE5ldHdvcmtDb25uZWN0aW9uPWZ1bmN0aW9uKG5ldHdvcmspe3JldHVybiB0aGlzLmNvbm5lY3Rpb249bmV0d29ya30sTU1EZXZpY2UucHJvdG90eXBlLnNldEluZm89ZnVuY3Rpb24oaW5mbyl7dmFyIGV2dCxrZXksdmFsdWU7Zm9yKGtleSBpbiBpbmZvKXZhbHVlPWluZm9ba2V5XSx0aGlzW2tleV09dmFsdWU7cmV0dXJuIE1NRGV2aWNlLmxvYWRTdGF0ZT0ibG9hZGVkIix0aGlzLnV0aWxzLmlzV2luZG93cygpfHwoZXZ0PSJkZXZpY2VMb2FkZWQiLHRoaXMudXRpbHMucG9zdEV2ZW50KGV2dCksZXZ0PSJkZXZpY2Vsb2FkZWQiLHRoaXMudXRpbHMucG9zdEV2ZW50KGV2dCkpLCEwfSxNTURldmljZS5wcm90b3R5cGUuZ2V0SW5mbz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIE1NRGV2aWNlLmxvYWRTdGF0ZT0ibG9hZGluZyIsdGhpcy5lbnF1ZXVlKCJnZXRJbmZvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1EZXZpY2UucHJvdG90eXBlLnNldE1NRElEPWZ1bmN0aW9uKG1tZGlkLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJzZXRNTURJRCIse21tZGlkOm1tZGlkLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NRGV2aWNlLnByb3RvdHlwZS5nZXRBdmFpbGFibGVTY2hlbWVzPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJnZXRBdmFpbGFibGVTY2hlbWVzIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1EZXZpY2UucHJvdG90eXBlLmlzU2NoZW1lQXZhaWxhYmxlPWZ1bmN0aW9uKHNjaGVtZSxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiaXNTY2hlbWVBdmFpbGFibGUiLHtzY2hlbWU6c2NoZW1lLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NRGV2aWNlLnByb3RvdHlwZS5nZXRBdmFpbGFibGVTY2hlbWVzPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJnZXRBdmFpbGFibGVTY2hlbWVzIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1EZXZpY2UucHJvdG90eXBlLmdldE9yaWVudGF0aW9uPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJnZXRPcmllbnRhdGlvbiIse2NhbGxiYWNrOmNhbGxiYWNrfSl9LE1NRGV2aWNlLnByb3RvdHlwZS5nZXRMb2NhdGlvbj1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZ2V0TG9jYXRpb24iLHtjYWxsYmFjazpjYWxsYmFja30pfSxNTURldmljZS5wcm90b3R5cGUuc2hvd01hcD1mdW5jdGlvbihsb2NhdGlvbixjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgic2hvd01hcCIse2xvY2F0aW9uOmxvY2F0aW9uLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NRGV2aWNlLnByb3RvdHlwZS5jYWxsPWZ1bmN0aW9uKG51bWJlcixkaWFsLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJjYWxsIix7bnVtYmVyOm51bWJlcixjYWxsYmFjazpjYWxsYmFjayxkaWFsOmRpYWx9KX0sTU1EZXZpY2UucHJvdG90eXBlLm9wZW5Vcmw9ZnVuY3Rpb24odXJsLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJvcGVuVXJsIix7dXJsOnVybCxjYWxsYmFjazpjYWxsYmFja30pfSxNTURldmljZS5wcm90b3R5cGUub3BlbkFwcFN0b3JlPWZ1bmN0aW9uKGFwcElkLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJvcGVuQXBwU3RvcmUiLHthcHBJZDphcHBJZCxjYWxsYmFjazpjYWxsYmFja30pfSxNTURldmljZS5wcm90b3R5cGUuY29tcG9zZVNNUz1mdW5jdGlvbihudW1iZXIsbWVzc2FnZSxjYWxsYmFjayl7cmV0dXJuIHRoaXMuY29tcG9zZVNtcyhudW1iZXIsbWVzc2FnZSxjYWxsYmFjayl9LE1NRGV2aWNlLnByb3RvdHlwZS5jb21wb3NlU21zPWZ1bmN0aW9uKG51bWJlcixtZXNzYWdlLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy51dGlscy5pc0lPUygpP3RoaXMuZW5xdWV1ZSgiY29tcG9zZVNtcyIse251bWJlcjpudW1iZXIsbWVzc2FnZTptZXNzYWdlLGNhbGxiYWNrOmNhbGxiYWNrfSk6dGhpcy5lbnF1ZXVlKCJjb21wb3NlU21zIix7bnVtYmVyOm51bWJlcixtZXNzYWdlOm1lc3NhZ2UsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1EZXZpY2UucHJvdG90eXBlLmNvbXBvc2VFbWFpbD1mdW5jdGlvbihyZWNpcGllbnQsc3ViamVjdCxtZXNzYWdlLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy51dGlscy5pc0lPUygpP3RoaXMub3BlblVybCgibWFpbHRvOj90bz0iK2VuY29kZVVSSUNvbXBvbmVudChyZWNpcGllbnQpKyImc3ViamVjdD0iK2VuY29kZVVSSUNvbXBvbmVudChzdWJqZWN0KSsiJmJvZHk9IitlbmNvZGVVUklDb21wb25lbnQobWVzc2FnZSksY2FsbGJhY2spOnRoaXMuZW5xdWV1ZSgiY29tcG9zZUVtYWlsIix7cmVjaXBpZW50OnJlY2lwaWVudCxzdWJqZWN0OnN1YmplY3QsbWVzc2FnZTptZXNzYWdlLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NRGV2aWNlLnByb3RvdHlwZS5nZXRDb21wYXNzSGVhZGluZz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZ2V0Q29tcGFzc0hlYWRpbmciLHtjYWxsYmFjazpjYWxsYmFja30pfSxNTURldmljZS5wcm90b3R5cGUuZ2V0QmFyb21ldGVyPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJnZXRCYXJvbWV0ZXIiLHtjYWxsYmFjazpjYWxsYmFja30pfSxNTURldmljZS5wcm90b3R5cGUuZW5hYmxlSGFyZHdhcmVBY2NlbGVyYXRpb249ZnVuY3Rpb24oZW5hYmxlZCxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZW5hYmxlSGFyZHdhcmVBY2NlbGVyYXRpb24iLHtlbmFibGVkOmVuYWJsZWQsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1EZXZpY2V9KE1NQnJpZGdlT2JqZWN0KSxNTU1lZGlhPWZ1bmN0aW9uKF9zdXBlcil7ZnVuY3Rpb24gTU1NZWRpYSgpe3JldHVybiBfcmVmMT1NTU1lZGlhLl9fc3VwZXJfXy5jb25zdHJ1Y3Rvci5hcHBseSh0aGlzLGFyZ3VtZW50cyl9cmV0dXJuIF9fZXh0ZW5kcyhNTU1lZGlhLF9zdXBlciksTU1NZWRpYS5wcm90b3R5cGUub3BlbkZyb250Q2FtZXJhPWZ1bmN0aW9uKGNvbnN0cmFpbldpZHRoLGNvbnN0cmFpbkhlaWdodCxjb250ZW50TW9kZSxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZ2V0UGljdHVyZSIse3NvdXJjZVR5cGU6IkNhbWVyYSIsY29uc3RyYWluV2lkdGg6Y29uc3RyYWluV2lkdGgsY29uc3RyYWluSGVpZ2h0OmNvbnN0cmFpbkhlaWdodCxjb250ZW50TW9kZTpjb250ZW50TW9kZSxmcm9udDohMCxjYWxsYmFjazpjYWxsYmFja30pfSxNTU1lZGlhLnByb3RvdHlwZS5vcGVuUmVhckNhbWVyYT1mdW5jdGlvbihjb25zdHJhaW5XaWR0aCxjb25zdHJhaW5IZWlnaHQsY29udGVudE1vZGUsY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImdldFBpY3R1cmUiLHtzb3VyY2VUeXBlOiJDYW1lcmEiLGNvbnN0cmFpbldpZHRoOmNvbnN0cmFpbldpZHRoLGNvbnN0cmFpbkhlaWdodDpjb25zdHJhaW5IZWlnaHQsY29udGVudE1vZGU6Y29udGVudE1vZGUsZnJvbnQ6ITEsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1NZWRpYS5wcm90b3R5cGUuZ2V0UGljdHVyZT1mdW5jdGlvbihzb3VyY2VUeXBlLGNvbnN0cmFpbldpZHRoLGNvbnN0cmFpbkhlaWdodCxjb250ZW50TW9kZSxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZ2V0UGljdHVyZSIse3NvdXJjZVR5cGU6c291cmNlVHlwZSxjb25zdHJhaW5XaWR0aDpjb25zdHJhaW5XaWR0aCxjb25zdHJhaW5IZWlnaHQ6Y29uc3RyYWluSGVpZ2h0LGNvbnRlbnRNb2RlOmNvbnRlbnRNb2RlLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NTWVkaWEucHJvdG90eXBlLndyaXRlVG9QaG90b0xpYnJhcnk9ZnVuY3Rpb24ocGF0aCx0aXRsZSxkZXNjcmlwdGlvbixjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgid3JpdGVUb1Bob3RvTGlicmFyeSIse3BhdGg6cGF0aCx0aXRsZTp0aXRsZSxkZXNjcmlwdGlvbjpkZXNjcmlwdGlvbixjYWxsYmFjazpjYWxsYmFja30pfSxNTU1lZGlhLnByb3RvdHlwZS5pc1NvdXJjZVR5cGVBdmFpbGFibGU9ZnVuY3Rpb24oc291cmNlVHlwZSxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiaXNTb3VyY2VUeXBlQXZhaWxhYmxlIix7c291cmNlVHlwZTpzb3VyY2VUeXBlLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NTWVkaWEucHJvdG90eXBlLmF2YWlsYWJsZVNvdXJjZVR5cGVzPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJhdmFpbGFibGVTb3VyY2VUeXBlcyIse2NhbGxiYWNrOmNhbGxiYWNrfSl9LE1NTWVkaWEucHJvdG90eXBlLnBsYXlWaWRlbz1mdW5jdGlvbihwYXRoLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJwbGF5VmlkZW8iLHtwYXRoOnBhdGgsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1NZWRpYS5wcm90b3R5cGUuZ2V0RGV2aWNlVm9sdW1lPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJnZXREZXZpY2VWb2x1bWUiLHtjYWxsYmFjazpjYWxsYmFja30pfSxNTU1lZGlhfShNTUJyaWRnZU9iamVjdCksTU1DYWxlbmRhcj1mdW5jdGlvbihfc3VwZXIpe2Z1bmN0aW9uIE1NQ2FsZW5kYXIoKXtyZXR1cm4gX3JlZjI9TU1DYWxlbmRhci5fX3N1cGVyX18uY29uc3RydWN0b3IuYXBwbHkodGhpcyxhcmd1bWVudHMpfXJldHVybiBfX2V4dGVuZHMoTU1DYWxlbmRhcixfc3VwZXIpLE1NQ2FsZW5kYXIucHJvdG90eXBlLmFkZEV2ZW50PWZ1bmN0aW9uKHBhcmFtZXRlcnMsY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImFkZEV2ZW50Iix7cGFyYW1ldGVyczpKU09OLnN0cmluZ2lmeShwYXJhbWV0ZXJzKSxjYWxsYmFjazpjYWxsYmFja30pfSxNTUNhbGVuZGFyfShNTUJyaWRnZU9iamVjdCksTU1CYW5uZXI9ZnVuY3Rpb24oX3N1cGVyKXtmdW5jdGlvbiBNTUJhbm5lcigpe3JldHVybiBfcmVmMz1NTUJhbm5lci5fX3N1cGVyX18uY29uc3RydWN0b3IuYXBwbHkodGhpcyxhcmd1bWVudHMpfXJldHVybiBfX2V4dGVuZHMoTU1CYW5uZXIsX3N1cGVyKSxNTUJhbm5lci5wcm90b3R5cGUucmVzaXplPWZ1bmN0aW9uKHBhcmFtZXRlcnMsY2FsbGJhY2spe3JldHVybiBwYXJhbWV0ZXJzLmNhbGxiYWNrPWNhbGxiYWNrLHRoaXMuZW5xdWV1ZSgicmVzaXplIixwYXJhbWV0ZXJzKX0sTU1CYW5uZXJ9KE1NQnJpZGdlT2JqZWN0KSxNTU5vdGlmaWNhdGlvbj1mdW5jdGlvbihfc3VwZXIpe2Z1bmN0aW9uIE1NTm90aWZpY2F0aW9uKCl7cmV0dXJuIF9yZWY0PU1NTm90aWZpY2F0aW9uLl9fc3VwZXJfXy5jb25zdHJ1Y3Rvci5hcHBseSh0aGlzLGFyZ3VtZW50cyl9cmV0dXJuIF9fZXh0ZW5kcyhNTU5vdGlmaWNhdGlvbixfc3VwZXIpLE1NTm90aWZpY2F0aW9uLnByb3RvdHlwZS5hbGVydD1mdW5jdGlvbih0aXRsZSxtZXNzYWdlLGNhbmNlbEJ1dHRvbixidXR0b25zLGNhbGxiYWNrKXt2YXIgcGFyYW1zO3JldHVybiBwYXJhbXM9e3RpdGxlOnRpdGxlLG1lc3NhZ2U6bWVzc2FnZSxjYW5jZWxCdXR0b246Y2FuY2VsQnV0dG9uLGNhbGxiYWNrOmNhbGxiYWNrfSxudWxsIT1idXR0b25zJiYiIiE9PWJ1dHRvbnMmJm51bGwhPT1idXR0b25zJiYocGFyYW1zLmJ1dHRvbnM9YnV0dG9ucyksdGhpcy5lbnF1ZXVlKCJhbGVydCIscGFyYW1zKX0sTU1Ob3RpZmljYXRpb24ucHJvdG90eXBlLnZpYnJhdGU9ZnVuY3Rpb24oZHVyYXRpb24sY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoInZpYnJhdGUiLHtkdXJhdGlvbjpkdXJhdGlvbixjYWxsYmFjazpjYWxsYmFja30pfSxNTU5vdGlmaWNhdGlvbn0oTU1CcmlkZ2VPYmplY3QpLE1NSW5saW5lVmlkZW89ZnVuY3Rpb24oX3N1cGVyKXtmdW5jdGlvbiBNTUlubGluZVZpZGVvKCl7cmV0dXJuIF9yZWY1PU1NSW5saW5lVmlkZW8uX19zdXBlcl9fLmNvbnN0cnVjdG9yLmFwcGx5KHRoaXMsYXJndW1lbnRzKX1yZXR1cm4gX19leHRlbmRzKE1NSW5saW5lVmlkZW8sX3N1cGVyKSxNTUlubGluZVZpZGVvLnByb3RvdHlwZS51cGRhdGVWaWRlb1NlZWtUaW1lPWZ1bmN0aW9uKGN1cnJlbnRTZWVrVGltZSl7cmV0dXJuIG51bGwhPXRoaXMudGltaW5nQ2FsbGJhY2s/dGhpcy50aW1pbmdDYWxsYmFjayhjdXJyZW50U2Vla1RpbWUpOnZvaWQgMH0sTU1JbmxpbmVWaWRlby5wcm90b3R5cGUuc2V0VGltaW5nQ2FsbGJhY2s9ZnVuY3Rpb24oX3RpbWluZ0NhbGxiYWNrKXtyZXR1cm4gdGhpcy50aW1pbmdDYWxsYmFjaz1fdGltaW5nQ2FsbGJhY2t9LE1NSW5saW5lVmlkZW8ucHJvdG90eXBlLnBsYXlWaWRlbz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgicGxheVZpZGVvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1JbmxpbmVWaWRlby5wcm90b3R5cGUuc3RvcFZpZGVvPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJzdG9wVmlkZW8iLHtjYWxsYmFjazpjYWxsYmFja30pfSxNTUlubGluZVZpZGVvLnByb3RvdHlwZS5wYXVzZVZpZGVvPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJwYXVz");
        aobj = com.millennialmedia.android.h.a("ZVZpZGVvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1JbmxpbmVWaWRlby5wcm90b3R5cGUucmVzdW1lVmlkZW89ZnVuY3Rpb24oY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoInJlc3VtZVZpZGVvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1JbmxpbmVWaWRlby5wcm90b3R5cGUucmVtb3ZlVmlkZW89ZnVuY3Rpb24oY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoInJlbW92ZVZpZGVvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1JbmxpbmVWaWRlby5wcm90b3R5cGUuc2V0U3RyZWFtVmlkZW9Tb3VyY2U9ZnVuY3Rpb24oc3RyZWFtVmlkZW9VUkksY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoInNldFN0cmVhbVZpZGVvU291cmNlIix7c3RyZWFtVmlkZW9VUkk6c3RyZWFtVmlkZW9VUkksY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1JbmxpbmVWaWRlby5wcm90b3R5cGUuYWRqdXN0VmlkZW89ZnVuY3Rpb24oY2FsbGJhY2spe3JldHVybiB0aGlzLmFkanVzdFZpZGVvV2l0aElkKCJpbmxpbmVWaWRlbyIsY2FsbGJhY2spfSxNTUlubGluZVZpZGVvLnByb3RvdHlwZS5hZGp1c3RWaWRlb1dpdGhJZD1mdW5jdGlvbihkaXZJZCxjYWxsYmFjayl7dmFyIGZyYW1lLHZpZGVvRWw7cmV0dXJuIHZpZGVvRWw9ZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoZGl2SWQpLG51bGwhPXZpZGVvRWw/KGZyYW1lPXRoaXMuY2FsY3VsYXRlRGl2UG9zaXRpb24oZGl2SWQpLGZyYW1lLmNhbGxiYWNrPWNhbGxiYWNrLHRoaXMuZW5xdWV1ZSgiYWRqdXN0VmlkZW8iLGZyYW1lKSk6Y2FsbGJhY2soe3Jlc3VsdDowLHJlc3BvbnNlOiJEaXYgSWQgbm90IGZvdW5kIiwiY2xhc3MiOiJNTUlubGluZVZpZGVvIixjYWxsOiJpbnNlcnRWaWRlbyJ9KX0sTU1JbmxpbmVWaWRlby5wcm90b3R5cGUuaW5zZXJ0VmlkZW9XaXRoSWQ9ZnVuY3Rpb24oZGl2SWQsdGltaW5nQ2FsbGJhY2ssY2FsbGJhY2spe3ZhciBhdXRvUGxheSxib2R5SGVpZ2h0LGJvZHlXaWR0aCxjYWNoZWRWaWRlb0lELGNhY2hlZFZpZGVvVVJJLGZyYW1lLGhlaWdodCxzaG93Q29udHJvbHMsc3RyZWFtVmlkZW9VUkksdG91Y2hDYWxsYmFjayx2aWRlb0VsLHdpZHRoLHgseTtyZXR1cm4gdmlkZW9FbD1kb2N1bWVudC5nZXRFbGVtZW50QnlJZChkaXZJZCksbnVsbCE9dmlkZW9FbD8oZnJhbWU9dGhpcy5jYWxjdWxhdGVEaXZQb3NpdGlvbihkaXZJZCksbnVsbCE9dGltaW5nQ2FsbGJhY2smJnRoaXMuc2V0VGltaW5nQ2FsbGJhY2sodGltaW5nQ2FsbGJhY2spLHg9ZnJhbWUueCx5PWZyYW1lLnksd2lkdGg9ZnJhbWUud2lkdGgsaGVpZ2h0PWZyYW1lLmhlaWdodCxib2R5V2lkdGg9ZG9jdW1lbnQuYm9keS5jbGllbnRXaWR0aCxib2R5SGVpZ2h0PWRvY3VtZW50LmJvZHkuY2xpZW50SGVpZ2h0LGNhY2hlZFZpZGVvVVJJPXZpZGVvRWwuZ2V0QXR0cmlidXRlKCJjYWNoZWRWaWRlb1VSSSIpLGNhY2hlZFZpZGVvSUQ9dmlkZW9FbC5nZXRBdHRyaWJ1dGUoImNhY2hlZFZpZGVvSUQiKSx0b3VjaENhbGxiYWNrPXZpZGVvRWwuZ2V0QXR0cmlidXRlKCJvblRvdWNoIiksc3RyZWFtVmlkZW9VUkk9dmlkZW9FbC5nZXRBdHRyaWJ1dGUoInN0cmVhbVZpZGVvVVJJIiksYXV0b1BsYXk9dmlkZW9FbC5nZXRBdHRyaWJ1dGUoImF1dG9QbGF5Iiksc2hvd0NvbnRyb2xzPXZpZGVvRWwuZ2V0QXR0cmlidXRlKCJzaG93Q29udHJvbHMiKSxjYWNoZWRWaWRlb1VSSXx8c3RyZWFtVmlkZW9VUkk/dGhpcy5lbnF1ZXVlKCJpbnNlcnRWaWRlbyIse3g6eCx5Onksd2lkdGg6d2lkdGgsaGVpZ2h0OmhlaWdodCxib2R5V2lkdGg6Ym9keVdpZHRoLGJvZHlIZWlnaHQ6Ym9keUhlaWdodCxjYWNoZWRWaWRlb1VSSTpjYWNoZWRWaWRlb1VSSSxzdHJlYW1WaWRlb1VSSTpzdHJlYW1WaWRlb1VSSSx0b3VjaENhbGxiYWNrOnRvdWNoQ2FsbGJhY2ssY2FjaGVkVmlkZW9JRDpjYWNoZWRWaWRlb0lELGF1dG9QbGF5OmF1dG9QbGF5LHNob3dDb250cm9sczpzaG93Q29udHJvbHMsY2FsbGJhY2s6Y2FsbGJhY2t9KTpjYWxsYmFjayh7cmVzdWx0OjAscmVzcG9uc2U6ImNhY2hlZFZpZGVvVVJJIG9yIHN0cmVhbVZpZGVvVVJJIG5vdCBmb3VuZCIsImNsYXNzIjoiTU1JbmxpbmVWaWRlbyIsY2FsbDoiaW5zZXJ0VmlkZW8ifSkpOmNhbGxiYWNrKHtyZXN1bHQ6MCxyZXNwb25zZToiRGl2IElkIG5vdCBmb3VuZCIsImNsYXNzIjoiTU1JbmxpbmVWaWRlbyIsY2FsbDoiaW5zZXJ0VmlkZW8ifSl9LE1NSW5saW5lVmlkZW8ucHJvdG90eXBlLmluc2VydFZpZGVvPWZ1bmN0aW9uKHRpbWluZ0NhbGxiYWNrLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5pbnNlcnRWaWRlb1dpdGhJZCgiaW5saW5lVmlkZW8iLHRpbWluZ0NhbGxiYWNrLGNhbGxiYWNrKX0sTU1JbmxpbmVWaWRlby5wcm90b3R5cGUuY2FsY3VsYXRlRGl2UG9zaXRpb249ZnVuY3Rpb24oZGl2SWQpe3ZhciBkaXZFbCxoZWlnaHQscG9zaXRpb24sd2lkdGgseCx5O3JldHVybiBkaXZFbD1kb2N1bWVudC5nZXRFbGVtZW50QnlJZChkaXZJZCkscG9zaXRpb249dGhpcy51dGlscy5vZmZzZXQoZGl2RWwpLHg9cG9zaXRpb25bMF0seT1wb3NpdGlvblsxXSx3aWR0aD1kaXZFbC5vZmZzZXRXaWR0aCxoZWlnaHQ9ZGl2RWwub2Zmc2V0SGVpZ2h0LHt4OngseTp5LHdpZHRoOndpZHRoLGhlaWdodDpoZWlnaHR9fSxNTUlubGluZVZpZGVvfShNTUJyaWRnZU9iamVjdCksTU1DYWNoZWRWaWRlbz1mdW5jdGlvbihfc3VwZXIpe2Z1bmN0aW9uIE1NQ2FjaGVkVmlkZW8oKXtyZXR1cm4gX3JlZjY9TU1DYWNoZWRWaWRlby5fX3N1cGVyX18uY29uc3RydWN0b3IuYXBwbHkodGhpcyxhcmd1bWVudHMpfXJldHVybiBfX2V4dGVuZHMoTU1DYWNoZWRWaWRlbyxfc3VwZXIpLE1NQ2FjaGVkVmlkZW8udGltaW5nQ2FsbGJhY2s9bnVsbCxNTUNhY2hlZFZpZGVvLmVycm9yQ2FsbGJhY2s9bnVsbCxNTUNhY2hlZFZpZGVvLnByb3RvdHlwZS51cGRhdGVWaWRlb1NlZWtUaW1lPWZ1bmN0aW9uKGN1cnJlbnRTZWVrVGltZSl7cmV0dXJuIG51bGwhPXRoaXMudGltaW5nQ2FsbGJhY2s/dGhpcy50aW1pbmdDYWxsYmFjayhjdXJyZW50U2Vla1RpbWUpOnZvaWQgMH0sTU1DYWNoZWRWaWRlby5wcm90b3R5cGUuc2V0VGltaW5nQ2FsbGJhY2s9ZnVuY3Rpb24odGltaW5nQ2FsbGJhY2spe3JldHVybiB0aGlzLnRpbWluZ0NhbGxiYWNrPXRpbWluZ0NhbGxiYWNrfSxNTUNhY2hlZFZpZGVvLnByb3RvdHlwZS5zZXRFcnJvcj1mdW5jdGlvbihlcnJvcil7cmV0dXJuIG51bGwhPXRoaXMuZXJyb3JDYWxsYmFjaz90aGlzLmVycm9yQ2FsbGJhY2soZXJyb3IpOnZvaWQgMH0sTU1DYWNoZWRWaWRlby5wcm90b3R5cGUuc2V0RXJyb3JDYWxsYmFjaz1mdW5jdGlvbihlcnJvckNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lcnJvckNhbGxiYWNrPWVycm9yQ2FsbGJhY2t9LE1NQ2FjaGVkVmlkZW8ucHJvdG90eXBlLnJlc3RhcnRWaWRlbz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgicmVzdGFydFZpZGVvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1DYWNoZWRWaWRlby5wcm90b3R5cGUuZW5kVmlkZW89ZnVuY3Rpb24oY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImVuZFZpZGVvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1DYWNoZWRWaWRlby5wcm90b3R5cGUucGF1c2VWaWRlbz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgicGF1c2VWaWRlbyIse2NhbGxiYWNrOmNhbGxiYWNrfSl9LE1NQ2FjaGVkVmlkZW8ucHJvdG90eXBlLnBsYXlWaWRlbz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgicGxheVZpZGVvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1DYWNoZWRWaWRlby5wcm90b3R5cGUuYXZhaWxhYmxlQ2FjaGVkVmlkZW9zPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJhdmFpbGFibGVDYWNoZWRWaWRlb3MiLHtjYWxsYmFjazpjYWxsYmFja30pfSxNTUNhY2hlZFZpZGVvLnByb3RvdHlwZS5wbGF5Q2FjaGVkVmlkZW89ZnVuY3Rpb24odmlkZW9JZCxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgicGxheUNhY2hlZFZpZGVvIix7dmlkZW9JZDp2aWRlb0lkLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NQ2FjaGVkVmlkZW8ucHJvdG90eXBlLmNhY2hlVmlkZW89ZnVuY3Rpb24odXJsLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJjYWNoZVZpZGVvIix7dXJsOnVybCxjYWxsYmFjazpjYWxsYmFja30pfSxNTUNhY2hlZFZpZGVvLnByb3RvdHlwZS52aWRlb0lkRXhpc3RzPWZ1bmN0aW9uKHZpZGVvSWQsY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoInZpZGVvSWRFeGlzdHMiLHt2aWRlb0lkOnZpZGVvSWQsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1DYWNoZWRWaWRlb30oTU1CcmlkZ2VPYmplY3QpLE1NSW50ZXJzdGl0aWFsPWZ1bmN0aW9uKF9zdXBlcil7ZnVuY3Rpb24gTU1JbnRlcnN0aXRpYWwoKXtyZXR1cm4gX3JlZjc9TU1JbnRlcnN0aXRpYWwuX19zdXBlcl9fLmNvbnN0cnVjdG9yLmFwcGx5KHRoaXMsYXJndW1lbnRzKX1yZXR1cm4gX19leHRlbmRzKE1NSW50ZXJzdGl0aWFsLF9zdXBlciksTU1JbnRlcnN0aXRpYWwuYW5pbWF0aW9uVHlwZXM9e2lvczpbImN1cmwiLCJmbGlwIiwiZGlzc29sdmUiLCJzbGlkZXVwIiwibm9uZSJdLGFuZHJvaWQ6WyJzbGlkZXVwIiwic2xpZGVkb3duIiwiZXhwbG9kZSIsIm5vbmUiXSx3aW5kb3dzOlsic2xpZGV1cCIsInNsaWRlZG93biIsImV4cGxvZGUiLCJub25lIl19LE1NSW50ZXJzdGl0aWFsLnByb3RvdHlwZS5jbG9zZT1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiY2xvc2UiLHtjYWxsYmFjazpjYWxsYmFja30pfSxNTUludGVyc3RpdGlhbC5wcm90b3R5cGUub3Blbj1mdW5jdGlvbih1cmwsY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoIm9wZW4iLHt1cmw6dXJsLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NSW50ZXJzdGl0aWFsLnByb3RvdHlwZS51c2VDdXN0b21DbG9zZT1mdW5jdGlvbih1c2VDdXN0b21DbG9zZSxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgidXNlQ3VzdG9tQ2xvc2UiLHt1c2VDdXN0b21DbG9zZTp1c2VDdXN0b21DbG9zZSxjYWxsYmFjazpjYWxsYmFja30pfSxNTUludGVyc3RpdGlhbC5wcm90b3R5cGUuc2V0T3JpZW50YXRpb249ZnVuY3Rpb24ocHJvcGVydGllcyxjYWxsYmFjayl7cmV0dXJuIHByb3BlcnRpZXMuY2FsbGJhY2s9Y2FsbGJhY2ssdGhpcy5lbnF1ZXVlKCJzZXRPcmllbnRhdGlvbiIscHJvcGVydGllcyl9LE1NSW50ZXJzdGl0aWFsLnByb3RvdHlwZS5leHBhbmRUb0V4dGVybmFsQnJvd3Nlcj1mdW5jdGlvbih1cmwsY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImV4cGFuZFRvRXh0ZXJuYWxCcm93c2VyIix7dXJsOnVybCxjYWxsYmFjazpjYWxsYmFja30pfSxNTUludGVyc3RpdGlhbC5wcm90b3R5cGUuZXhwYW5kV2l0aFByb3BlcnRpZXM9ZnVuY3Rpb24odXJsLHByb3BlcnRpZXMsY2FsbGJhY2spe3ZhciBrZXkscGFyYW1zLHRyYW5zaXRpb25UeXBlLHZhbHVlO2lmKHBhcmFtcz17Y2FsbGJhY2s6Y2FsbGJhY2t9LG51bGwhPXVybCYmKHBhcmFtcy51cmw9dXJsKSxNTUpTLnV0aWxzLmNvbnNvbGVMb2coImV4cGFuZFdpdGhQcm9wZXJ0aWVzIHByb3BlcnRpZXMgIitKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKSksbnVsbCE9cHJvcGVydGllcylmb3Ioa2V5IGluIHByb3BlcnRpZXMpX19oYXNQcm9wLmNhbGwocHJvcGVydGllcyxrZXkpJiYodmFsdWU9cHJvcGVydGllc1trZXldLCJ0cmFuc2l0aW9uIj09PWtleT8odHJhbnNpdGlvblR5cGU9dmFsdWUscGFyYW1zW2tleV09dHJhbnNpdGlvblR5cGUpOnBhcmFtc1trZXldPXZhbHVlKTtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJleHBhbmRXaXRoUHJvcGVydGllcyIscGFyYW1zKX0sTU1JbnRlcnN0aXRpYWx9KE1NQnJpZGdlT2JqZWN0KSxNTUJyYW5kPWZ1bmN0aW9uKF9zdXBlcil7ZnVuY3Rpb24gTU1CcmFuZCgpe3JldHVybiBfcmVmOD1NTUJyYW5kLl9fc3VwZXJfXy5jb25zdHJ1Y3Rvci5hcHBseSh0aGlzLGFyZ3VtZW50cyl9cmV0dXJuIF9fZXh0ZW5kcyhNTUJyYW5kLF9zdXBlciksTU1CcmFuZC5wcm90b3R5cGUuZ2V0SW5mbz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZ2V0SW5mbyIse2NhbGxiYWNrOmNhbGxiYWNrfSl9LE1NQnJhbmR9KE1NQnJpZGdlT2JqZWN0KSxNTUFwcFN0b3JlPWZ1bmN0aW9uKF9zdXBlcil7ZnVuY3Rpb24gTU1BcHBTdG9yZSgpe3JldHVybiBfcmVmOT1NTUFwcFN0b3JlLl9fc3VwZXJfXy5jb25zdHJ1Y3Rvci5hcHBseSh0aGlzLGFyZ3VtZW50cyl9cmV0dXJuIF9fZXh0ZW5kcyhNTUFwcFN0b3JlLF9zdXBlciksTU1BcHBTdG9yZS5wcm90b3R5cGUubG9hZEFwcD1mdW5jdGlvbihhcHBJZCxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgibG9hZEFwcCIse2FwcElkOmFwcElkLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NQXBwU3RvcmV9KE1NQnJpZGdlT2JqZWN0KSxNTVBhc3Nib29rPWZ1bmN0aW9uKF9zdXBlcil7ZnVuY3Rpb24gTU1QYXNzYm9vaygpe3JldHVybiBfcmVmMTA9TU1QYXNzYm9vay5fX3N1cGVyX18uY29uc3RydWN0b3IuYXBwbHkodGhpcyxhcmd1bWVudHMpfXJldHVybiBfX2V4dGVuZHMoTU1QYXNzYm9vayxfc3VwZXIpLE1NUGFzc2Jvb2sucHJvdG90eXBlLmlzUGFzc2Jvb2tBdmFpbGFibGU9ZnVuY3Rpb24oY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImlzUGFzc2Jvb2tBdmFpbGFibGUiLHtjYWxsYmFjazpjYWxsYmFja30pfSxNTVBhc3Nib29rLnByb3RvdHlwZS5hZGRQYXNzRnJvbVVSTD1mdW5jdGlvbih1cmwsY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImFkZFBhc3NGcm9tVVJMIix7dXJsOnVybCxjYWxsYmFjazpjYWxsYmFja30pfSxNTVBhc3Nib29rLnByb3RvdHlwZS5pc1Bhc3NJbnN0YWxsZWQ9ZnVuY3Rpb24odXJsLGlkZW50aWZpZXIsc2VyaWFsLGNhbGxiYWNrKXtyZXR1cm4gbnVsbCE9dXJsP3RoaXMuZW5xdWV1ZSgiaXNQYXNzSW5zdGFsbGVkIix7dXJsOnVybCxjYWxsYmFjazpjYWxsYmFja30pOnRoaXMuZW5xdWV1ZSgiaXNQYXNzSW5zdGFsbGVkIix7aWRlbnRpZmllcjppZGVudGlmaWVyLHNlcmlhbDpzZXJpYWwsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1QYXNzYm9vay5wcm90b3R5cGUuaXNQYXNzVVJMSW5zdGFsbGVkPWZ1bmN0aW9uKHVybCxjYWxsYmFjayl7cmV0dXJuIHRoaXMuaXNQYXNzSW5zdGFsbGVkKHVybCxudWxsLG51bGwsY2FsbGJhY2spfSxNTVBhc3Nib29rLnByb3RvdHlwZS5pc1Bhc3NJZGVudGlmaWVySW5zdGFsbGVkPWZ1bmN0aW9uKGlkZW50aWZpZXIsc2VyaWFsLGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5pc1Bhc3NJbnN0YWxsZWQobnVsbCxpZGVudGlmaWVyLHNlcmlhbCxjYWxsYmFjayl9LE1NUGFzc2Jvb2t9KE1NQnJpZGdlT2JqZWN0KSxNTVNvY2lhbD1mdW5jdGlvbihfc3VwZXIpe2Z1bmN0aW9uIE1NU29jaWFsKCl7cmV0dXJuIF9yZWYxMT1NTVNvY2lhbC5fX3N1cGVyX18uY29uc3RydWN0b3IuYXBwbHkodGhpcyxhcmd1bWVudHMpfXJldHVybiBfX2V4dGVuZHMoTU1Tb2NpYWwsX3N1cGVyKSxNTVNvY2lhbC5wcm90b3R5cGUudHdlZXQ9ZnVuY3Rpb24obWVzc2FnZSxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgidHdlZXQiLHttZXNzYWdlOm1lc3NhZ2UsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1Tb2NpYWwucHJvdG90eXBlLnR3ZWV0V2l0aENvbnRlbnQ9ZnVuY3Rpb24obWVzc2FnZSx1cmxzLGltYWdlcyxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgidHdlZXQiLHttZXNzYWdlOm1lc3NhZ2UsdXJsczp1cmxzLmpvaW4oIiwiKSxpbWFnZXM6aW1hZ2VzLmpvaW4oIiwiKSxjYWxsYmFjazpjYWxsYmFja30pfSxNTVNvY2lhbC5wcm90b3R5cGUuZmFjZWJvb2tQb3N0PWZ1bmN0aW9uKG1lc3NhZ2UsY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImZhY2Vib29rUG9zdCIse21lc3NhZ2U6bWVzc2FnZSxjYWxsYmFjazpjYWxsYmFja30pfSxNTVNvY2lhbC5wcm90b3R5cGUuZmFjZWJvb2tQb3N0V2l0aENvbnRlbnQ9ZnVuY3Rpb24obWVzc2FnZSx1cmxzLGltYWdlcyxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZmFjZWJvb2tQb3N0Iix7bWVzc2FnZTptZXNzYWdlLHVybHM6dXJscy5qb2luKCIsIiksaW1hZ2VzOmltYWdlcy5qb2luKCIsIiksY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1Tb2NpYWwucHJvdG90eXBlLmF1dGhlbnRpY2F0ZWRTZXJ2aWNlcz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiYXV0aGVudGljYXRlZFNlcnZpY2VzIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1Tb2NpYWx9KE1NQnJpZGdlT2JqZWN0KSxNTVNwZWVjaGtpdD1mdW5jdGlvbihfc3VwZXIpe2Z1bmN0aW9uIE1NU3BlZWNoa2l0KCl7cmV0dXJuIF9yZWYxMj1NTVNwZWVjaGtpdC5fX3N1cGVyX18uY29uc3RydWN0b3IuYXBwbHkodGhpcyxhcmd1bWVudHMpfXJldHVybiBfX2V4dGVuZHMoTU1TcGVlY2hraXQsX3N1cGVyKSxNTVNwZWVjaGtpdC5wcm90b3R5cGUuc3RhcnRSZWNvcmRpbmc9ZnVuY3Rpb24obGFuZ3VhZ2UscmVjb2duaXplcixlbmRPZlNwZWVjaCxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgic3RhcnRSZWNvcmRpbmciLHtsYW5ndWFnZTpsYW5ndWFnZSxyZWNvZ25pemVyOnJlY29nbml6ZXIsZW5kT2ZTcGVlY2g6ZW5kT2ZTcGVlY2gsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1TcGVlY2hraXQucHJvdG90eXBlLmVuZFJlY29yZGluZz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZW5kUmVjb3JkaW5nIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1TcGVlY2hraXQucHJvdG90eXBlLnNhbXBsZUJhY2tncm91bmRBdWRpb0xldmVsPWZ1bmN0aW9uKGNhbGxiYWNrKXtyZXR1cm4gdGhpcy5lbnF1ZXVlKCJzYW1wbGVCYWNrZ3JvdW5kQXVkaW9MZXZlbCIse2NhbGxiYWNrOmNhbGxiYWNrfSl9LE1NU3BlZWNoa2l0LnByb3RvdHlwZS50ZXh0VG9TcGVlY2g9ZnVuY3Rpb24obGFuZ3VhZ2UsdGV4dCxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgidGV4dFRvU3BlZWNoIix7bGFuZ3VhZ2U6bGFuZ3VhZ2UsdGV4dDp0ZXh0LGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NU3BlZWNoa2l0LnByb3RvdHlwZS5yZWxlYXNlVm9pY2U9ZnVuY3Rpb24oY2FsbGJhY2spe3JldHVybiBNTUpTLnNkay5zcGVlY2hSZXN1bHRzPVtdLE1NSlMuc2RrLnNwZWVjaEF1ZGlvTGV2ZWw9MCxNTUpTLnNkay5zcGVlY2hCYWNrZ3JvdW5kQXVkaW9MZXZlbD0wLE1NSlMuc2RrLnNwZWVjaFN0YXR1cz0iUmVsZWFzZWQiLHRoaXMuZW5xdWV1ZSgicmVsZWFzZVZvaWNlIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KQp9LE1NU3BlZWNoa2l0LnByb3RvdHlwZS5jYWNoZUF1ZGlvPWZ1bmN0aW9uKHVybCxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiY2FjaGVBdWRpbyIse3VybDp1cmwsY2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1TcGVlY2hraXQucHJvdG90eXBlLnBsYXlBdWRpbz1mdW5jdGlvbih1cmwscHJvcGVydGllcyxjYWxsYmFjayl7cmV0dXJuIHByb3BlcnRpZXMudXJsPXVybCxwcm9wZXJ0aWVzLmNhbGxiYWNrPWNhbGxiYWNrLHRoaXMuZW5xdWV1ZSgicGxheUF1ZGlvIixwcm9wZXJ0aWVzKX0sTU1TcGVlY2hraXQucHJvdG90eXBlLnN0b3BBdWRpbz1mdW5jdGlvbihjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgic3RvcEF1ZGlvIix7Y2FsbGJhY2s6Y2FsbGJhY2t9KX0sTU1TcGVlY2hraXQucHJvdG90eXBlLmFkZEN1c3RvbVZvaWNlV29yZHM9ZnVuY3Rpb24od29yZHMsY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImFkZEN1c3RvbVZvaWNlV29yZHMiLHt3b3Jkczp3b3JkcyxjYWxsYmFjazpjYWxsYmFja30pfSxNTVNwZWVjaGtpdC5wcm90b3R5cGUuZGVsZXRlQ3VzdG9tVm9pY2VXb3Jkcz1mdW5jdGlvbih3b3JkcyxjYWxsYmFjayl7cmV0dXJuIHRoaXMuZW5xdWV1ZSgiZGVsZXRlQ3VzdG9tVm9pY2VXb3JkcyIse3dvcmRzOndvcmRzLGNhbGxiYWNrOmNhbGxiYWNrfSl9LE1NU3BlZWNoa2l0LnByb3RvdHlwZS5nZXRTZXNzaW9uSWQ9ZnVuY3Rpb24oY2FsbGJhY2spe3JldHVybiB0aGlzLmVucXVldWUoImdldFNlc3Npb25JZCIse2NhbGxiYWNrOmNhbGxiYWNrfSl9LE1NU3BlZWNoa2l0LnByb3RvdHlwZS5nZXRSZWNvZ25pdGlvblJlc3VsdHM9ZnVuY3Rpb24oKXtyZXR1cm4gTU1KUy5zZGsuc3BlZWNoUmVzdWx0c30sTU1TcGVlY2hraXQucHJvdG90eXBlLmdldEJhY2tncm91bmROb2lzZUxldmVsPWZ1bmN0aW9uKCl7cmV0dXJuIE1NSlMuc2RrLnNwZWVjaEJhY2tncm91bmRBdWRpb0xldmVsfSxNTVNwZWVjaGtpdC5wcm90b3R5cGUuZ2V0QXVkaW9MZXZlbD1mdW5jdGlvbigpe3JldHVybiBNTUpTLnNkay5zcGVlY2hBdWRpb0xldmVsfSxNTVNwZWVjaGtpdC5wcm90b3R5cGUuZ2V0Vm9pY2VTdGF0ZT1mdW5jdGlvbigpe3JldHVybiBNTUpTLnNkay5zcGVlY2hTdGF0dXN9LE1NU3BlZWNoa2l0LnByb3RvdHlwZS5nZXRBdWRpb1Bvc2l0aW9uPWZ1bmN0aW9uKCl7cmV0dXJuIE1NSlMuc2RrLmF1ZGlvUG9zaXRpb259LE1NU3BlZWNoa2l0fShNTUJyaWRnZU9iamVjdCksTVJBSUQ9ZnVuY3Rpb24oX3N1cGVyKXtmdW5jdGlvbiBNUkFJRCgpe3RoaXMuc2RrPU1NSlMuc2RrLHRoaXMudXRpbHM9TU1KUy51dGlscyx0aGlzLnByb3BlcnRpZXM9e3dpZHRoOm51bGwsaGVpZ2h0Om51bGwsdXNlQ3VzdG9tQ2xvc2U6ITEsaXNNb2RhbDohMH0sdGhpcy5vcmllbnRhdGlvblByb3BlcnRpZXM9e2FsbG93T3JpZW50YXRpb25DaGFuZ2U6ITAsZm9yY2VPcmllbnRhdGlvbjoibm9uZSJ9LHRoaXMucmVzaXplUHJvcGVydGllcz17d2lkdGg6bnVsbCxoZWlnaHQ6bnVsbCxjdXN0b21DbG9zZVBvc2l0aW9uOiJ0b3AtcmlnaHQiLG9mZnNldFg6MCxvZmZzZXRZOjAsYWxsb3dPZmZzY3JlZW46ITB9LHRoaXMuYXVkaW9Qcm9wZXJ0aWVzPXtsb29wOiExLGNvbnRyb2xzOiExfX1yZXR1cm4gX19leHRlbmRzKE1SQUlELF9zdXBlciksTVJBSUQucHJvdG90eXBlLmdldEFkU2l6ZT1mdW5jdGlvbigpe3JldHVybiBudWxsIT10aGlzLnNkay5hZFNpemUmJih0aGlzLnV0aWxzLmNvbnNvbGVMb2coIk1SQUlEIGdldEFkU2l6ZSAiK0pTT04uc3RyaW5naWZ5KHRoaXMuc2RrLmFkU2l6ZSkpLHRoaXMuc2RrLmFkU2l6ZS5oZWlnaHQ+MCYmdGhpcy5zZGsuYWRTaXplLndpZHRoPjApP3RoaXMuc2RrLmFkU2l6ZTpudWxsfSxNUkFJRC5wcm90b3R5cGUuY2FsbGJhY2tNYW5hZ2VyPWZ1bmN0aW9uKHJlc3BvbnNlKXt2YXIga2xhc3MsbWV0aG9kLHJlc3BvbnNlX2RhdGEscmVzdWx0O3JldHVybiByZXN1bHQ9cmVzcG9uc2UucmVzdWx0LG1ldGhvZD1yZXNwb25zZS5jYWxsLHJlc3BvbnNlX2RhdGE9cmVzcG9uc2UucmVzcG9uc2Usa2xhc3M9cmVzcG9uc2VbImNsYXNzIl0sdGhpc30sTVJBSUQucHJvdG90eXBlLmdldFZlcnNpb249ZnVuY3Rpb24oKXtyZXR1cm4iMi4wIn0sTVJBSUQucHJvdG90eXBlLmNsb3NlPWZ1bmN0aW9uKCl7cmV0dXJuIE1NSlMuaW50ZXJzdGl0aWFsLmNsb3NlKGZ1bmN0aW9uKHJlc3BvbnNlKXtyZXR1cm4gcmVzcG9uc2UucmVzdWx0PDE/TU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJlcnJvciIsIkNsb3NlIGZhaWxlZCIsImNsb3NlIik6dm9pZCAwfSl9LE1SQUlELnByb3RvdHlwZS5leHBhbmQ9ZnVuY3Rpb24oX3VybCl7dmFyIGssbWF4U2l6ZSxwcm9wcyx2LF9yZWYxMzt0aGlzLnV0aWxzLmNvbnNvbGVMb2coIm1yYWlkLmV4cGFuZCBjYWxsZWQgd2l0aCBwcm9wZXJ0aWVzOiAiK0pTT04uc3RyaW5naWZ5KHRoaXMuZ2V0RXhwYW5kUHJvcGVydGllcygpKSksdGhpcy51dGlscy5jb25zb2xlTG9nKCJtcmFpZC5leHBhbmQgdXJsOiAiK191cmwpLHByb3BzPXRoaXMuZ2V0RXhwYW5kUHJvcGVydGllcygpLG1heFNpemU9dGhpcy5nZXRNYXhTaXplKCksbnVsbCE9cHJvcHMmJm51bGwhPW1heFNpemUmJnByb3BzLmhlaWdodD09PW1heFNpemUuaGVpZ2h0JiZwcm9wcy53aWR0aD09PW1heFNpemUud2lkdGgmJihwcm9wcy5oZWlnaHQ9dm9pZCAwLHByb3BzLndpZHRoPXZvaWQgMCksX3JlZjEzPXRoaXMub3JpZW50YXRpb25Qcm9wZXJ0aWVzO2ZvcihrIGluIF9yZWYxMyl2PV9yZWYxM1trXSxwcm9wc1trXT12O3JldHVybiBNTUpTLmludGVyc3RpdGlhbC5leHBhbmRXaXRoUHJvcGVydGllcyhfdXJsLHByb3BzLGZ1bmN0aW9uKHJlc3BvbnNlKXtyZXR1cm4gcmVzcG9uc2UucmVzdWx0PDE/TU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJlcnJvciIsIkV4cGFuZCBmYWlsZWQiLCJleHBhbmQiKTp2b2lkIDB9KX0sTVJBSUQucHJvdG90eXBlLm9wZW49ZnVuY3Rpb24oX3VybCl7cmV0dXJuIE1NSlMuaW50ZXJzdGl0aWFsLm9wZW4oX3VybCxmdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIHJlc3BvbnNlLnJlc3VsdDwxP01NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygiZXJyb3IiLCJPcGVuIGZhaWxlZCB0byBvcGVuIGV4dGVybmFsIHVybCIsIm9wZW4iKTp2b2lkIDB9KX0sTVJBSUQucHJvdG90eXBlLmdldEV4cGFuZFByb3BlcnRpZXM9ZnVuY3Rpb24oKXt2YXIgbWF4U2l6ZTtyZXR1cm4gbWF4U2l6ZT10aGlzLmdldE1heFNpemUoKSxudWxsIT1tYXhTaXplPygobnVsbD09PXRoaXMucHJvcGVydGllcy5oZWlnaHR8fHZvaWQgMD09PXRoaXMucHJvcGVydGllcy5oZWlnaHQpJiYodGhpcy5wcm9wZXJ0aWVzLmhlaWdodD1tYXhTaXplLmhlaWdodCksKG51bGw9PT10aGlzLnByb3BlcnRpZXMud2lkdGh8fHZvaWQgMD09PXRoaXMucHJvcGVydGllcy53aWR0aCkmJih0aGlzLnByb3BlcnRpZXMud2lkdGg9bWF4U2l6ZS53aWR0aCksdGhpcy5wcm9wZXJ0aWVzKTpNTUpTLmxpc3RlbmVyTWFuYWdlci5maXJlRXZlbnRDYWxsYmFja3MoImVycm9yIiwiZ2V0RXhwYW5kUHJvcGVydGllcyBmYWlsZWQiLCJnZXRFeHBhbmRQcm9wZXJ0aWVzIil9LE1SQUlELnByb3RvdHlwZS5zZXRFeHBhbmRQcm9wZXJ0aWVzPWZ1bmN0aW9uKF9wcm9wZXJ0aWVzKXtyZXR1cm4gdGhpcy51dGlscy5jb25zb2xlTG9nKCJzZXRFeHBhbmRQcm9wZXJ0aWVzOiAiK0pTT04uc3RyaW5naWZ5KHRoaXMucHJvcGVydGllcykpLHRoaXMucHJvcGVydGllcz1fcHJvcGVydGllc30sTVJBSUQucHJvdG90eXBlLmdldFBsYWNlbWVudFR5cGU9ZnVuY3Rpb24oKXtyZXR1cm4gdGhpcy5zZGsucGxhY2VtZW50VHlwZX0sTVJBSUQucHJvdG90eXBlLmdldFN0YXRlPWZ1bmN0aW9uKCl7cmV0dXJuIHRoaXMuc2RrLnN0YXRlfSxNUkFJRC5wcm90b3R5cGUudXNlQ3VzdG9tQ2xvc2U9ZnVuY3Rpb24oX2N1c3RvbUNsb3NlKXtyZXR1cm4gdGhpcy5wcm9wZXJ0aWVzLnVzZUN1c3RvbUNsb3NlPV9jdXN0b21DbG9zZSx0aGlzLnV0aWxzLmNvbnNvbGVMb2coIlVzZSBDdXN0b20gQ2xvc2Ugd2FzIGNhbGxlZDogIitfY3VzdG9tQ2xvc2UpLE1NSlMuaW50ZXJzdGl0aWFsLnVzZUN1c3RvbUNsb3NlKF9jdXN0b21DbG9zZSxmdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIHJlc3BvbnNlLnJlc3VsdDwxP01NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygiZXJyb3IiLCJVc2UgY3VzdG9tIGNsb3NlIGZhaWxlZCB0byBzZXQiLCJ1c2VDdXN0b21DbG9zZSIpOnZvaWQgMH0pfSxNUkFJRC5wcm90b3R5cGUuaXNWaWV3YWJsZT1mdW5jdGlvbigpe3JldHVybiB0aGlzLnNkay52aWV3YWJsZX0sTVJBSUQucHJvdG90eXBlLnJlbW92ZUV2ZW50TGlzdGVuZXI9ZnVuY3Rpb24oZXZlbnQsbGlzdGVuZXIpe3JldHVybiBNTUpTLmxpc3RlbmVyTWFuYWdlci5yZW1vdmVFdmVudExpc3RlbmVyKGV2ZW50LGxpc3RlbmVyKX0sTVJBSUQucHJvdG90eXBlLmFkZEV2ZW50TGlzdGVuZXI9ZnVuY3Rpb24oZXZlbnQsbGlzdGVuZXIpe3JldHVybiBNTUpTLmxpc3RlbmVyTWFuYWdlci5hZGRFdmVudExpc3RlbmVyKGV2ZW50LGxpc3RlbmVyKX0sTVJBSUQucHJvdG90eXBlLmZpcmVFdmVudENhbGxiYWNrcz1mdW5jdGlvbihldmVudE5hbWUscGFyYW1ldGVyLGFjdGlvbil7cmV0dXJuIE1NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcyhldmVudE5hbWUscGFyYW1ldGVyLGFjdGlvbil9LE1SQUlELnByb3RvdHlwZS5yZXNpemU9ZnVuY3Rpb24oKXt2YXIgY2FsbGVkcmVzaXplUHJvcGVydGllcyxtYXhTaXplO3JldHVybiBtYXhTaXplPXRoaXMuZ2V0TWF4U2l6ZSgpLGNhbGxlZHJlc2l6ZVByb3BlcnRpZXM9dGhpcy5nZXRSZXNpemVQcm9wZXJ0aWVzKCksY2FsbGVkcmVzaXplUHJvcGVydGllcy5hbGxvd09mZnNjcmVlbj09PSExJiYoY2FsbGVkcmVzaXplUHJvcGVydGllcy53aWR0aD5tYXhTaXplLndpZHRofHxjYWxsZWRyZXNpemVQcm9wZXJ0aWVzLmhlaWdodD5tYXhTaXplLmhlaWdodCk/dm9pZCB0aGlzLmZpcmVFdmVudENhbGxiYWNrcygiZXJyb3IiLCJSZXNpemUgaXMgdW5zdXBwb3J0ZWQgaW4gdGhpcyBhcHBsaWNhdGlvbi4iLCJyZXNpemUiKTooTU1KUy5iYW5uZXIucmVzaXplKGNhbGxlZHJlc2l6ZVByb3BlcnRpZXMsZnVuY3Rpb24ocmVzcG9uc2Upe3JldHVybiByZXNwb25zZS5yZXN1bHQ8MT9tcmFpZC5maXJlRXZlbnRDYWxsYmFja3MoImVycm9yIiwiUmVzaXplIGlzIHVuc3VwcG9ydGVkIGluIHRoaXMgYXBwbGljYXRpb24uIiwicmVzaXplIik6dm9pZCAwfSksbnVsbCl9LE1SQUlELnByb3RvdHlwZS5nZXRSZXNpemVQcm9wZXJ0aWVzPWZ1bmN0aW9uKCl7dmFyIGFkU2l6ZTtyZXR1cm4gYWRTaXplPXRoaXMuZ2V0QWRTaXplKCksbnVsbCE9YWRTaXplPyhNTUpTLnV0aWxzLmNvbnNvbGVMb2coIkFkIFNpemUgd2FzIGZvdW5kIiksbnVsbD09PXRoaXMucmVzaXplUHJvcGVydGllcy5oZWlnaHQmJih0aGlzLnJlc2l6ZVByb3BlcnRpZXMuaGVpZ2h0PWFkU2l6ZS5oZWlnaHQpLG51bGw9PT10aGlzLnJlc2l6ZVByb3BlcnRpZXMud2lkdGgmJih0aGlzLnJlc2l6ZVByb3BlcnRpZXMud2lkdGg9YWRTaXplLndpZHRoKSx0aGlzLnJlc2l6ZVByb3BlcnRpZXMpOihNTUpTLnV0aWxzLmNvbnNvbGVMb2coImdldFJlc2l6ZVByb3BlcnRpZXMgZmFpbGVkIiksTU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJlcnJvciIsIlJlc2l6ZSBpcyB1bnN1cHBvcnRlZCBpbiB0aGlzIGFwcGxpY2F0aW9uLiIsInJlc2l6ZSIpKX0sTVJBSUQucHJvdG90eXBlLnNldFJlc2l6ZVByb3BlcnRpZXM9ZnVuY3Rpb24oX3Byb3BlcnRpZXMpe3JldHVybiB0aGlzLnJlc2l6ZVByb3BlcnRpZXM9X3Byb3BlcnRpZXN9LE1SQUlELnByb3RvdHlwZS5nZXRDdXJyZW50UG9zaXRpb249ZnVuY3Rpb24oKXtyZXR1cm4gdGhpcy5zZGsuYWRTaXplfSxNUkFJRC5wcm90b3R5cGUuZ2V0TWF4U2l6ZT1mdW5jdGlvbigpe3JldHVybiBudWxsIT10aGlzLnNkay5hZFByb3BlcnRpZXMubWF4U2l6ZT97aGVpZ2h0OnRoaXMuc2RrLmFkUHJvcGVydGllcy5tYXhTaXplLmhlaWdodCx3aWR0aDp0aGlzLnNkay5hZFByb3BlcnRpZXMubWF4U2l6ZS53aWR0aH06KE1NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygiZXJyb3IiLCJnZXRSZXNpemVQcm9wZXJ0aWVzIGZhaWxlZCIsImdldFJlc2l6ZVByb3BlcnRpZXMiKSxudWxsKX0sTVJBSUQucHJvdG90eXBlLmdldERlZmF1bHRQb3NpdGlvbj1mdW5jdGlvbigpe3JldHVybiB0aGlzLnNkay5kZWZhdWx0UG9zaXRpb259LE1SQUlELnByb3RvdHlwZS5nZXRTY3JlZW5TaXplPWZ1bmN0aW9uKCl7cmV0dXJuIE1NSlMudXRpbHMuY29uc29sZUxvZygiZ2V0U2NyZWVuU2l6ZTogIit0aGlzLnNkay5hZFByb3BlcnRpZXMuc2NyZWVuKSxudWxsIT10aGlzLnNkay5hZFByb3BlcnRpZXMuc2NyZWVuP3RoaXMuc2RrLmFkUHJvcGVydGllcy5zY3JlZW46KHRoaXMuZmlyZUV2ZW50Q2FsbGJhY2tzKCJlcnJvciIsIlNjcmVlbiBzaXplIGlzIHVuYXZhaWxhYmxlIiwiZ2V0U2NyZWVuU2l6ZSIpLG51bGwpfSxNUkFJRC5wcm90b3R5cGUuc3VwcG9ydHM9ZnVuY3Rpb24oZmVhdHVyZSl7cmV0dXJuIG51bGwhPWZlYXR1cmU/dGhpcy5zZGsuc3VwcG9ydFByb3BlcnRpZXNbZmVhdHVyZV06dGhpcy5zZGsuc3VwcG9ydFByb3BlcnRpZXN9LE1SQUlELnByb3RvdHlwZS5zdG9yZVBpY3R1cmU9ZnVuY3Rpb24oVVJJKXtyZXR1cm4gTU1KUy5tZWRpYS53cml0ZVRvUGhvdG9MaWJyYXJ5KFVSSSwiIiwiIixmdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIHJlc3BvbnNlLnJlc3VsdDwxP01NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygiZXJyb3IiLCJFcnJvciBzdG9yaW5nIHBpY3R1cmUiLCJzdG9yZVBpY3R1cmUiKTp2b2lkIDB9KX0sTVJBSUQucHJvdG90eXBlLmNyZWF0ZUNhbGVuZGFyRXZlbnQ9ZnVuY3Rpb24ocGFyYW1ldGVycyl7cmV0dXJuIE1NSlMuY2FsZW5kYXIuYWRkRXZlbnQocGFyYW1ldGVycyxmdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIHJlc3BvbnNlLnJlc3VsdDwxP01NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygiZXJyb3IiLCJFcnJvciBhZGRpbmcgY2FsZW5kYXIgZXZlbnQiLCJjcmVhdGVDYWxlbmRhckV2ZW50Iik6dm9pZCAwfSl9LE1SQUlELnByb3RvdHlwZS5wbGF5VmlkZW89ZnVuY3Rpb24oVVJJKXtyZXR1cm4gTU1KUy5tZWRpYS5wbGF5VmlkZW8oVVJJLGZ1bmN0aW9uKHJlc3BvbnNlKXtyZXR1cm4gcmVzcG9uc2UucmVzdWx0PDE/TU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJlcnJvciIsIkVycm9yIHBsYXlpbmcgdmlkZW8iLCJwbGF5VmlkZW8iKTp2b2lkIDB9KX0sTVJBSUQucHJvdG90eXBlLmdldE9yaWVudGF0aW9uUHJvcGVydGllcz1mdW5jdGlvbigpe3JldHVybiB0aGlzLm9yaWVudGF0aW9uUHJvcGVydGllc30sTVJBSUQucHJvdG90eXBlLnNldE9yaWVudGF0aW9uUHJvcGVydGllcz1mdW5jdGlvbihwcm9wZXJ0aWVzKXtyZXR1cm4gdGhpcy5vcmllbnRhdGlvblByb3BlcnRpZXM9cHJvcGVydGllcywiZXhwYW5kZWQiPT09dGhpcy5nZXRTdGF0ZSgpJiYiaW5saW5lIj09PXRoaXMuZ2V0UGxhY2VtZW50VHlwZSgpfHwiaW50ZXJzdGl0aWFsIj09PXRoaXMuZ2V0UGxhY2VtZW50VHlwZSgpP01NSlMuaW50ZXJzdGl0aWFsLnNldE9yaWVudGF0aW9uKHRoaXMub3JpZW50YXRpb25Qcm9wZXJ0aWVzLCJtcmFpZC5jYWxsYmFja01hbmFnZXIiKTp2b2lkIDB9LE1SQUlELnByb3RvdHlwZS5zdGFydFJlY29yZGluZz1mdW5jdGlvbihsYW5ndWFnZUNvZGUpe3JldHVybiBNTUpTLnNwZWVjaGtpdC5zdGFydFJlY29yZGluZyhsYW5ndWFnZUNvZGUsImRpY3RhdGlvbiIsInNob3J0IixmdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIHJlc3BvbnNlLnJlc3VsdDwxP01NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygidm9pY2VFcnJvciIsIlN0YXJ0IHJlY29yZGluZyBmYWlsZWQiLCJzdGFydFJlY29yZGluZyIpOnZvaWQgMH0pfSxNUkFJRC5wcm90b3R5cGUuZW5kUmVjb3JkaW5nPWZ1bmN0aW9uKCl7cmV0dXJuIE1NSlMuc3BlZWNoa2l0LmVuZFJlY29yZGluZyhmdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIHJlc3BvbnNlLnJlc3VsdDwxP01NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygidm9pY2VFcnJvciIsIkVuZCByZWNvcmRpbmcgZmFpbGVkIiwiZW5kUmVjb3JkaW5nIik6dm9pZCAwfSl9LE1SQUlELnByb3RvdHlwZS50ZXh0VG9TcGVlY2g9ZnVuY3Rpb24odGV4dCxsYW5ndWFnZUNvZGUpe3JldHVybiBNTUpTLnNwZWVjaGtpdC50ZXh0VG9TcGVlY2gobGFuZ3VhZ2VDb2RlLHRleHQsZnVuY3Rpb24ocmVzcG9uc2Upe3JldHVybiByZXNwb25zZS5yZXN1bHQ8MT9NTUpTLmxpc3RlbmVyTWFuYWdlci5maXJlRXZlbnRDYWxsYmFja3MoInZvaWNlRXJyb3IiLCJUZXh0IHRvIFNwZWVjaCBmYWlsZWQiLCJ0ZXh0VG9TcGVlY2giKTp2b2lkIDB9KX0sTVJBSUQucHJvdG90eXBlLnBsYXlBdWRpbz1mdW5jdGlvbih1cmwsb3B0aW9ucyl7cmV0dXJuIG51bGwhPW9wdGlvbnMmJihvcHRpb25zLmxvb3A9dGhpcy5hdWRpb1Byb3BlcnRpZXMubG9vcCxvcHRpb25zLmNvbnRyb2xzPXRoaXMuYXVkaW9Qcm9wZXJ0aWVzLmNvbnRyb2xzKSxNTUpTLnNwZWVjaGtpdC5wbGF5QXVkaW8odXJsLHRoaXMuYXVkaW9Qcm9wZXJ0aWVzLGZ1bmN0aW9uKHJlc3BvbnNlKXtyZXR1cm4gcmVzcG9uc2UucmVzdWx0PDE/TU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJ2b2ljZUVycm9yIiwiUGxheWluZyBhdWRpbyBmYWlsZWQiLCJwbGF5QXVkaW8iKTp2b2lkIDB9KX0sTVJBSUQucHJvdG90eXBlLnN0b3BBdWRpbz1mdW5jdGlvbigpe3JldHVybiBNTUpTLnNwZWVjaGtpdC5zdG9wQXVkaW8oZnVuY3Rpb24ocmVzcG9uc2Upe3JldHVybiByZXNwb25zZS5yZXN1bHQ8MT9NTUpTLmxpc3RlbmVyTWFuYWdlci5maXJlRXZlbnRDYWxsYmFja3MoInZvaWNlRXJyb3IiLCJTdG9wIHBsYXlpbmcgYXVkaW8gZmFpbGVkIiwic3RvcEF1ZGlvIik6dm9pZCAwfSl9LE1SQUlELnByb3RvdHlwZS5jYWNoZUF1ZGlvPWZ1bmN0aW9uKHVybCl7cmV0dXJuIE1NSlMuc3BlZWNoa2l0LmNhY2hlQXVkaW8odXJsLGZ1bmN0aW9uKHJlc3BvbnNlKXtyZXR1cm4gcmVzcG9uc2UucmVzdWx0PDE/TU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJ2b2ljZUVycm9yIiwiQXVkaW8gY2FjaGluZyBmYWlsZWQiLCJjYWNoZUF1ZGlvIik6dm9pZCAwfSl9LE1SQUlELnByb3RvdHlwZS5zYW1wbGVCYWNrZ3JvdW5kQXVkaW9MZXZlbD1mdW5jdGlvbigpe3JldHVybiBNTUpTLnNwZWVjaGtpdC5zYW1wbGVCYWNrZ3JvdW5kQXVkaW9MZXZlbChmdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIHJlc3BvbnNlLnJlc3VsdDwxP01NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygidm9pY2VFcnJvciIsIlNhbXBsaW5nIG9mIGJhY2tncm91bmQgYXVkaW8gZmFpbGVkIiwic2FtcGxlQmFja2dyb3VuZEF1ZGlvTGV2ZWwiKTp2b2lkIDB9KX0sTVJBSUQucHJvdG90eXBlLnJlbGVhc2VWb2ljZT1mdW5jdGlvbigpe3JldHVybiBNTUpTLnNwZWVjaGtpdC5yZWxlYXNlVm9pY2UoZnVuY3Rpb24oKXt9KX0sTVJBSUQucHJvdG90eXBlLmFkZEN1c3RvbVZvaWNlV29yZHM9ZnVuY3Rpb24od29yZHMpe3JldHVybiBNTUpTLnNwZWVjaGtpdC5hZGRDdXN0b21Wb2ljZVdvcmRzKHdvcmRzLGZ1bmN0aW9uKHJlc3BvbnNlKXtyZXR1cm4gcmVzcG9uc2UucmVzdWx0PDE/TU1KUy5saXN0ZW5lck1hbmFnZXIuZmlyZUV2ZW50Q2FsbGJhY2tzKCJ2b2ljZUVycm9yIiwiQWRkaW5nIGN1c3RvbSB3b3JkcyBmYWlsZWQiLCJhZGRDdXN0b21Wb2ljZVdvcmRzIik6dm9pZCAwfSl9LE1SQUlELnByb3RvdHlwZS5kZWxldGVDdXN0b21Wb2ljZVdvcmRzPWZ1bmN0aW9uKHdvcmRzKXtyZXR1cm4gTU1KUy5zcGVlY2hraXQuZGVsZXRlQ3VzdG9tVm9pY2VXb3Jkcyh3b3JkcyxmdW5jdGlvbihyZXNwb25zZSl7cmV0dXJuIHJlc3BvbnNlLnJlc3VsdDwxP01NSlMubGlzdGVuZXJNYW5hZ2VyLmZpcmVFdmVudENhbGxiYWNrcygidm9pY2VFcnJvciIsIkRlbGV0aW5nIGN1c3RvbSB3b3JkcyBmYWlsZWQiLCJkZWxldGVDdXN0b21Wb2ljZVdvcmRzIik6dm9pZCAwfSl9LE1SQUlELnByb3RvdHlwZS5nZXRSZWNvZ25pdGlvblJlc3VsdHM9ZnVuY3Rpb24oKXtyZXR1cm4gTU1KUy5zcGVlY2hraXQuZ2V0UmVjb2duaXRpb25SZXN1bHRzKCl9LE1SQUlELnByb3RvdHlwZS5nZXRBdWRpb0xldmVsPWZ1bmN0aW9uKCl7cmV0dXJuIE1NSlMuc3BlZWNoa2l0LmdldEF1ZGlvTGV2ZWwoKX0sTVJBSUQucHJvdG90eXBlLmdldFZvaWNlU3RhdGU9ZnVuY3Rpb24oKXtyZXR1cm4gTU1KUy5zcGVlY2hraXQuZ2V0Vm9pY2VTdGF0ZSgpfSxNUkFJRC5wcm90b3R5cGUuZ2V0QXVkaW9Qb3NpdGlvbj1mdW5jdGlvbigpe3JldHVybiBNTUpTLnNwZWVjaGtpdC5nZXRBdWRpb1Bvc2l0aW9uKCl9LE1SQUlEfShNTUJyaWRnZU9iamVjdCksZnVuY3Rpb24oKXtyZXR1cm4gdHlwZW9mIE1NSlMuc2RrPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NSlMuc2RrPW5ldyBNTVNES0ludGVyZmFjZSksdHlwZW9mIE1NSlMuZGV2aWNlPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NSlMuZGV2aWNlPW5ldyBNTURldmljZSksdHlwZW9mIE1NSlMubWVkaWE9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1KUy5tZWRpYT1uZXcgTU1NZWRpYSksdHlwZW9mIE1NSlMubm90aWZpY2F0aW9uPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NSlMubm90aWZpY2F0aW9uPW5ldyBNTU5vdGlmaWNhdGlvbiksdHlwZW9mIE1NSlMuaW50ZXJzdGl0aWFsPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NSlMuaW50ZXJzdGl0aWFsPW5ldyBNTUludGVyc3RpdGlhbCksdHlwZW9mIE1NSlMuY2FjaGVkVmlkZW89PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1KUy5jYWNoZWRWaWRlbz1uZXcgTU1DYWNoZWRWaWRlbyksdHlwZW9mIE1NSlMuYnJhbmQ9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1KUy5icmFuZD1uZXcgTU1CcmFuZCksdHlwZW9mIE1NSlMuaW5saW5lVmlkZW89PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1KUy5pbmxpbmVWaWRlbz1uZXcgTU1JbmxpbmVWaWRlbyksdHlwZW9mIE1NSlMuc29jaWFsPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NSlMuc29jaWFsPW5ldyBNTVNvY2lhbCksdHlwZW9mIE1NSlMucGFzc2Jvb2s9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1KUy5wYXNzYm9vaz1uZXcgTU1QYXNzYm9vayksdHlwZW9mIE1NSlMuY2FsZW5kYXI9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1KUy5jYWxlbmRhcj1uZXcgTU1DYWxlbmRhciksdHlwZW9mIE1NSlMuYmFubmVyPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NSlMuYmFubmVyPW5ldyBNTUJhbm5lciksdHlwZW9mIE1NSlMuYXBwc3RvcmU9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1KUy5hcHBzdG9yZT1uZXcgTU1BcHBTdG9yZSksTU1KUy5hcHBTdG9yZT1NTUpTLmFwcHN0b3JlLHR5cGVvZiBNTUpTLmxpc3RlbmVyTWFuYWdlcj09PU1NSlMuVFlQRV9VTkRFRklORUQmJihNTUpTLmxpc3RlbmVyTWFuYWdlcj1uZXcgTU1MaXN0ZW5lck1hbmFnZXIpLHR5cGVvZiBNTUpTLnNwZWVjaGtpdD09PU1NSlMuVFlQRV9VTkRFRklORUQmJihNTUpTLnNwZWVjaGtpdD1uZXcgTU1TcGVlY2hraXQpLHR5cGVvZiB3aW5kb3cuTU1TREs9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYod2luZG93Lk1NU0RLPU1NSlMpLHR5cGVvZiBNTVNESy5zZGs9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1TREsuc2RrPU1NSlMuc2RrKSx0eXBlb2YgTU1TREsuZGV2aWNlPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NU0RLLmRldmljZT1NTUpTLmRldmljZSksdHlwZW9mIE1NU0RLLm1lZGlhPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NU0RLLm1lZGlhPU1NSlMubWVkaWEpLHR5cGVvZiBNTVNESy5ub3RpZmljYXRpb249PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1TREsubm90aWZpY2F0aW9uPU1NSlMubm90aWZpY2F0aW9uKSx0eXBlb2YgTU1TREsuaW50ZXJzdGl0aWFsPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NU0RLLmludGVyc3RpdGlhbD1NTUpTLmludGVyc3RpdGlhbCksdHlwZW9mIE1NSlMuY2FjaGVkVmlkZW89PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYoTU1TREsuY2FjaGVkVmlkZW89TU1KUy5jYWNoZWRWaWRlbyksdHlwZW9mIE1NU0RLLmJyYW5kPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NU0RLLmJyYW5kPU1NSlMuYnJhbmQpLHR5cGVvZiBNTVNESy5pbmxpbmVWaWRlbz09PU1NSlMuVFlQRV9VTkRFRklORUQmJihNTVNESy5pbmxpbmVWaWRlbz1NTUpTLmlubGluZVZpZGVvKSx0eXBlb2YgTU1TREsuc29jaWFsPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NU0RLLnNvY2lhbD1NTUpTLnNvY2lhbCksdHlwZW9mIE1NU0RLLnBhc3Nib29rPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NU0RLLnBhc3Nib29rPU1NSlMucGFzc2Jvb2spLHR5cGVvZiBNTVNESy5jYWxlbmRhcj09PU1NSlMuVFlQRV9VTkRFRklORUQmJihNTVNESy5jYWxlbmRhcj1NTUpTLmNhbGVuZGFyKSx0eXBlb2YgTU1TREsuYmFubmVyPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NU0RLLmJhbm5lcj1NTUpTLmJhbm5lciksdHlwZW9mIE1NU0RLLmFwcHN0b3JlPT09TU1KUy5UWVBFX1VOREVGSU5FRCYmKE1NU0RLLmFwcHN0b3JlPU1NSlMuYXBwc3RvcmUpLE1NU0RLLmFwcFN0b3JlPU1NSlMuYXBwc3RvcmUsdHlwZW9mIE1NU0RLLnNwZWVjaGtpdD09PU1NSlMuVFlQRV9VTkRFRklORUQmJihNTVNESy5zcGVlY2hraXQ9TU1KUy5zcGVlY2hraXQpLHR5cGVvZiB3aW5kb3cubXJhaWQ9PT1NTUpTLlRZUEVfVU5ERUZJTkVEJiYod2luZG93Lm1yYWlkPW5ldyBNUkFJRCksdHlwZW9mIHdpbmRvdy5NTT09PU1NSlMuVFlQRV9VTkRFRklORUQ/d2luZG93Lk1NPU1NSlM6dm9pZCAwfSgpLE1NSlMudXRpbHMubGlzdGVuRm9yQnJvd3NlclJlYWR5KGZ1bmN0aW9uKCl7dmFyIHRpbWVyO3JldHVybiB0aW1lcj1zZXRJbnRlcnZhbChmdW5jdGlvbigpe3ZhciBjb21tYW5kLGU7aWYoImxvYWRpbmciIT09TU1KUy5zZGsuc3RhdGUmJk1NSlMuZXhlY3V0aW5nQ29tbWFuZD09PSExJiZNTUpTLmNvbW1hbmRRdWV1ZS5sZW5ndGg+MCYmMD09PU1NSlMuZXhlY3V0aW5nQ29tbWFuZERlbGF5KXtjb21tYW5kPU1NSlMuY29tbWFuZFF1ZXVlLnNoaWZ0KCksTU1KUy51dGlscy5jb25zb2xlTG9nKCJydW5uaW5nIGNvbW1hbmQ6ICIrY29tbWFuZC51cmwpO3RyeXtyZXR1cm4gY29tbWFuZC5wZXJmb3JtKCl9Y2F0Y2goX2Vycm9yKXtyZXR1cm4gZT1fZXJyb3IsTU1KUy51dGlscy5jb25zb2xlTG9nKCJGYWlsZWQgdG8gcnVuIGNvbW1hbmQ6ICIrZS5tZXNzYWdlYWxlcnQpfX19LDEpfSgpKSk7");
        if (jsonobject == null || aobj == null) goto _L34; else goto _L33
_L33:
        byte abyte0[];
        abyte0 = new byte[jsonobject.length + aobj.length];
        System.arraycopy(jsonobject, 0, abyte0, 0, jsonobject.length);
        System.arraycopy(((Object) (aobj)), 0, abyte0, jsonobject.length, aobj.length);
        if (!aq.a(context, new ByteArrayInputStream(abyte0)) || !aq.a(context, ((String) (obj)))) goto _L34; else goto _L35
_L35:
        i1 = 1;
_L44:
        if (i1 == 0) goto _L37; else goto _L36
_L36:
        al.c();
        i1 = 1;
_L40:
        if (i1 != 0) goto _L29; else goto _L38
_L38:
        jsonobject = (Context)v1.p.get();
        v1 = v1.i;
        if (TextUtils.isEmpty(v1)) goto _L4; else goto _L39
_L39:
        au.c.a(new aq._cls1(v1, jsonobject));
        return;
        jsonobject;
        v1;
        JVM INSTR monitorexit ;
        throw jsonobject;
_L27:
        y = (new StringBuilder()).append(((String) (obj))).append("getAd?").toString();
          goto _L25
_L37:
        al.a("MRaid", "Unable to save bundled version of mm.js");
_L31:
        jsonobject = "";
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_931;
        }
        jsonobject = context.getSharedPreferences("MillennialMediaSettings", 0).getString("KEY_MMJS_URL", "");
        (new StringBuilder("Previous mm.js url is <")).append(jsonobject).append(">");
        al.b();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1044;
        }
        if (!((String) (obj)).equals(jsonobject))
        {
            break MISSING_BLOCK_LABEL_1044;
        }
        i1 = 1;
          goto _L40
_L29:
        (new StringBuilder("Not downloading MMJS - (")).append(v1.i).append(")");
        al.d();
        return;
_L9:
        i1++;
          goto _L41
_L17:
        i1++;
          goto _L42
_L20:
        i1 = 0;
          goto _L43
_L23:
        i1++;
          goto _L43
_L34:
        i1 = 0;
          goto _L44
        i1 = 0;
          goto _L40
    }

    static String b()
    {
        return l;
    }

    static WeakReference b(v v1)
    {
        return v1.p;
    }

    static Runnable c(v v1)
    {
        return v1.z;
    }

    static long d(v v1)
    {
        return v1.x;
    }

    static boolean d(Context context)
    {
        if (context == null)
        {
            return false;
        } else
        {
            return context.getSharedPreferences("MillennialMediaSettings", 0).getBoolean("firstlaunchHandshake", true);
        }
    }

    static Handler e(v v1)
    {
        return v1.q;
    }

    static String e(String s1)
    {
        l = s1;
        return s1;
    }

    static void e(Context context)
    {
        if (context != null)
        {
            context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            context.putBoolean("firstlaunchHandshake", false);
            context.commit();
        }
    }

    static JSONObject f(String s1)
    {
        return h(s1);
    }

    private boolean f(Context context)
    {
        SharedPreferences sharedpreferences;
        boolean flag;
        boolean flag2;
        flag = false;
        flag2 = false;
        sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        if (sharedpreferences != null) goto _L2; else goto _L1
_L1:
        return flag2;
_L2:
        int i1;
        boolean flag1;
        String as1[];
        int j1;
        if (sharedpreferences.contains("handshake_deferredviewtimeout"))
        {
            w = sharedpreferences.getLong("handshake_deferredviewtimeout", w);
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (sharedpreferences.contains("handshake_baseUrl"))
        {
            y = sharedpreferences.getString("handshake_baseUrl", y);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_callback"))
        {
            x = sharedpreferences.getLong("handshake_callback", x);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_hardwareAccelerationEnabled"))
        {
            e = sharedpreferences.getBoolean("handshake_hardwareAccelerationEnabled", false);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_startSessionURL"))
        {
            f = sharedpreferences.getString("handshake_startSessionURL", "");
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_endSessionURL"))
        {
            g = sharedpreferences.getString("handshake_endSessionURL", "");
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_nuanceCredentials"))
        {
            j = new b(sharedpreferences.getString("handshake_nuanceCredentials", ""));
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_mmdid"))
        {
            a(context, sharedpreferences.getString("handshake_mmdid", c), false);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_creativecachetimeout"))
        {
            d = sharedpreferences.getLong("handshake_creativecachetimeout", d);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_mmjs"))
        {
            i = sharedpreferences.getString("handshake_mmjs", i);
            flag1 = true;
        }
        as1 = ab.l();
        j1 = 0;
        while (j1 < 2) 
        {
            Object obj = new a();
            String s2 = as1[j1];
            String s1;
            String as2[];
            if (sharedpreferences.contains((new StringBuilder("handshake_lastvideo_")).append(s2).toString()))
            {
                obj.a = sharedpreferences.getLong((new StringBuilder("handshake_lastvideo_")).append(s2).toString(), ((a) (obj)).a);
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (sharedpreferences.contains((new StringBuilder("handshake_videointerval_")).append(s2).toString()))
            {
                obj.b = sharedpreferences.getLong((new StringBuilder("handshake_videointerval_")).append(s2).toString(), ((a) (obj)).b);
                i1 = 1;
            }
            if (i1 != 0)
            {
                t.put(as1[j1], obj);
                flag1 = true;
            }
            j1++;
        }
        this;
        JVM INSTR monitorenter ;
        if (!sharedpreferences.contains("handshake_schemes")) goto _L4; else goto _L3
_L3:
        s1 = sharedpreferences.getString("handshake_schemes", "");
        if (s1.length() <= 0) goto _L4; else goto _L5
_L5:
        s1 = s1.split("\n");
        j1 = s1.length;
        i1 = ((flag) ? 1 : 0);
_L10:
        if (i1 >= j1) goto _L7; else goto _L6
_L6:
        as2 = s1[i1].split("\t");
        if (as2.length >= 2)
        {
            as2 = new c(as2[0], Integer.parseInt(as2[1]));
            u.add(as2);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        this;
        JVM INSTR monitorexit ;
        if (sharedpreferences.contains("handshake_lasthandshake"))
        {
            r = sharedpreferences.getLong("handshake_lasthandshake", r);
            flag1 = true;
        }
        flag2 = flag1;
        if (!flag1) goto _L1; else goto _L8
_L8:
        al.b();
        if (System.currentTimeMillis() - r < x)
        {
            q.postDelayed(z, x - (System.currentTimeMillis() - r));
        }
        s = sharedpreferences.getString("handshake_novideostocacheurl", "");
        flag2 = flag1;
        if (k == null) goto _L1; else goto _L9
_L9:
        as.a(k, context, s);
        return flag1;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
          goto _L10
_L7:
        flag1 = true;
          goto _L4
    }

    private static boolean g(String s1)
    {
        com/millennialmedia/android/v;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s1);
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        com/millennialmedia/android/v;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        String s2 = s1;
        if (s1.startsWith("http://"))
        {
            s2 = s1.replaceFirst("http://", "https://");
        }
        l = (new StringBuilder()).append(s2).append("?apid=").toString();
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    private static JSONObject h(String s1)
    {
        String.format("JSON String: %s", new Object[] {
            s1
        });
        al.b();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        s1 = new JSONObject(s1);
        s1.toString();
        al.a();
        if (!s1.has("mmishake"))
        {
            break MISSING_BLOCK_LABEL_69;
        }
        s1 = s1.getJSONObject("mmishake");
        return s1;
        s1;
        al.a("HandShake", "Error parsing json", s1);
        return null;
    }

    final void a(Context context, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a a1 = (a)t.get(s1);
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        a1.a = System.currentTimeMillis();
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        a1.a(context, s1);
        context.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    final void a(Context context, String s1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (s1.length() != 0 && !s1.equals("NULL"))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        c = null;
_L1:
        an.a(c);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        context.putString("handshake_mmdid", c);
        context.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        c = s1;
          goto _L1
        context;
        throw context;
    }

    final void a(boolean flag)
    {
        Object obj = (Context)o.get();
        if (obj != null)
        {
            obj = ((Context) (obj)).getSharedPreferences("MillennialMediaSettings", 0).getString("handShakeUrl", null);
            if (obj != null)
            {
                g(((String) (obj)));
            }
        }
        au.c.a(new Runnable(flag) {

            final boolean a;
            final v b;

            public final void run()
            {
                Context context;
                context = (Context)v.a(b).get();
                if (context == null)
                {
                    context = (Context)v.b(b).get();
                }
                if (context != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                Object obj1;
                StringBuilder stringbuilder;
                boolean flag1;
                stringbuilder = new StringBuilder();
                obj1 = new TreeMap();
                ((Map) (obj1)).put("ua", (new StringBuilder("Android:")).append(Build.MODEL).toString());
                flag1 = v.d(context);
                boolean flag2;
                if (!flag1)
                {
                    break MISSING_BLOCK_LABEL_107;
                }
                flag2 = flag1;
                ((Map) (obj1)).put("firstlaunch", "1");
                flag2 = flag1;
                if (!a)
                {
                    break MISSING_BLOCK_LABEL_133;
                }
                flag2 = flag1;
                ((Map) (obj1)).put("init", "1");
                flag2 = flag1;
                an.a(context, ((Map) (obj1)));
                flag2 = flag1;
                obj1 = ((Map) (obj1)).entrySet().iterator();
_L4:
                flag2 = flag1;
                if (!((Iterator) (obj1)).hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                flag2 = flag1;
                Object obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
                flag2 = flag1;
                stringbuilder.append(String.format("&%s=%s", new Object[] {
                    ((java.util.Map.Entry) (obj2)).getKey(), URLEncoder.encode((String)((java.util.Map.Entry) (obj2)).getValue(), "UTF-8")
                }));
                if (true) goto _L4; else goto _L3
                obj1;
_L17:
                flag2 = flag1;
                al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj1)));
                return;
                obj1;
_L15:
                if (flag2)
                {
                    v.e(context);
                }
                throw obj1;
_L3:
                flag2 = flag1;
                obj2 = (new StringBuilder()).append(v.b()).append(v.a).append(stringbuilder.toString()).toString();
                flag2 = flag1;
                String.format("Performing handshake: %s", new Object[] {
                    obj2
                });
                flag2 = flag1;
                al.a();
                obj1 = null;
                flag2 = flag1;
                obj2 = (new w((byte)0)).a(((String) (obj2)));
                obj1 = obj2;
_L11:
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_371;
                }
                flag2 = flag1;
                int i1 = ((HttpResponse) (obj1)).getStatusLine().getStatusCode();
                obj2 = obj1;
                if (i1 == 200)
                {
                    break MISSING_BLOCK_LABEL_465;
                }
                flag2 = flag1;
                v.e(v.b().replaceFirst("https://", "http://"));
                flag2 = flag1;
                obj2 = (new StringBuilder()).append(v.b()).append(v.a).append(stringbuilder.toString()).toString();
                flag2 = flag1;
                String.format("Performing handshake (HTTP Fallback): %s", new Object[] {
                    obj2
                });
                flag2 = flag1;
                al.a();
                flag2 = flag1;
                obj2 = (new w()).a(((String) (obj2)));
_L12:
                if (obj2 == null) goto _L6; else goto _L5
_L5:
                flag2 = flag1;
                i1 = ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
                if (i1 == 200) goto _L7; else goto _L6
_L6:
                flag2 = flag1;
                obj1 = (new StringBuilder("http://ads.mp.mydas.mobi/appConfigServlet?apid=")).append(v.a).append(stringbuilder.toString()).toString();
                flag2 = flag1;
                al.a();
                flag2 = flag1;
                obj1 = (new w()).a(((String) (obj1)));
_L13:
                if (obj1 == null) goto _L9; else goto _L8
_L8:
                flag2 = flag1;
                if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() != 200) goto _L9; else goto _L10
_L10:
                flag2 = flag1;
                v.a(b, v.f(com.millennialmedia.android.w.a(((HttpResponse) (obj1)).getEntity().getContent())));
                flag2 = flag1;
                v.a(b, context);
                flag2 = flag1;
                v.e(b).postDelayed(v.c(b), v.d(b));
                flag2 = flag1;
                al.a();
_L14:
                if (flag1)
                {
                    v.e(context);
                    return;
                }
                  goto _L1
                obj2;
                flag2 = flag1;
                al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj2)));
                  goto _L11
                obj1;
_L16:
                flag2 = flag1;
                al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj1)));
                return;
                obj2;
                flag2 = flag1;
                al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj2)));
                obj2 = obj1;
                  goto _L12
                obj1;
                flag2 = flag1;
                al.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj1)));
_L7:
                obj1 = obj2;
                  goto _L13
_L9:
                flag1 = false;
                  goto _L14
                obj1;
                flag2 = false;
                  goto _L15
                obj1;
                flag1 = false;
                  goto _L16
                obj1;
                flag1 = false;
                  goto _L17
            }

            
            {
                b = v.this;
                a = flag;
                super();
            }
        });
    }

    final boolean a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (a)t.get(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        long l1;
        long l2;
        long l3;
        l1 = System.currentTimeMillis();
        (new StringBuilder("canRequestVideo() Current Time:")).append(l1).append(" Last Video: ").append(((a) (s1)).a / 1000L).append("  Diff: ").append((l1 - ((a) (s1)).a) / 1000L).append("  Video interval: ").append(((a) (s1)).b / 1000L);
        al.b();
        l1 = System.currentTimeMillis();
        l2 = ((a) (s1)).a;
        l3 = ((a) (s1)).b;
        boolean flag;
        if (l1 - l2 > l3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    final boolean a(String s1, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (a)t.get(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        long l2;
        long l3;
        l2 = System.currentTimeMillis();
        l3 = ((a) (s1)).d.w;
        boolean flag;
        if (l2 - l1 < l3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    final String b(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        Iterator iterator;
        if (v != null || u.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        stringbuilder = new StringBuilder();
        iterator = u.iterator();
_L1:
        c c1;
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_121;
                }
                c1 = (c)iterator.next();
            } while (!c1.a(context));
            if (stringbuilder.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_105;
            }
            stringbuilder.append((new StringBuilder(",")).append(c1.b).toString());
        } while (true);
        context;
        throw context;
        stringbuilder.append(Integer.toString(c1.b));
          goto _L1
        if (stringbuilder.length() > 0)
        {
            v = stringbuilder.toString();
        }
        context = v;
        this;
        JVM INSTR monitorexit ;
        return context;
    }

    final boolean b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (a)t.get(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        boolean flag = ((a) (s1)).c;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    final JSONArray c(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        JSONArray jsonarray;
        Iterator iterator;
        jsonarray = new JSONArray();
        if (u.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        iterator = u.iterator();
_L1:
        c c1;
        boolean flag;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_128;
            }
            c1 = (c)iterator.next();
            flag = c1.a(context);
        } while (!flag);
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("scheme", c1.a);
        jsonobject.put("schemeid", c1.b);
        jsonarray.put(jsonobject);
          goto _L1
        JSONException jsonexception;
        jsonexception;
        al.a("HandShake", "Json error getting scheme", jsonexception);
          goto _L1
        context;
        throw context;
        this;
        JVM INSTR monitorexit ;
        return jsonarray;
    }

    final void c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (a)t.get(s1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        s1.c = true;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    final void d(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (a)t.get(s1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        s1.c = false;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

}
