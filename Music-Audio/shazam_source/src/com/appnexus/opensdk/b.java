// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.appnexus.opensdk.b.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.appnexus.opensdk:
//            al, ah, av

public final class b
    implements al
{

    String a;
    String b;
    String c;
    String d;
    Bitmap e;
    Bitmap f;
    String g;
    String h;
    String i;
    String j;
    al.a k;
    HashMap l;
    boolean m;
    ArrayList n;
    ArrayList o;
    Runnable p;
    View q;
    List r;
    ah s;
    av t;
    ArrayList u;
    boolean v;

    b()
    {
        m = false;
        p = new Runnable() {

            final b a;

            public final void run()
            {
                a.m = true;
                a.q = null;
                a.r = null;
                if (a.t != null)
                {
                    av av1 = a.t;
                    if (av1.d != null)
                    {
                        av1.d.shutdownNow();
                    }
                    av1.a.removeCallbacks(av1.c);
                    av1.a = null;
                    av1.b = null;
                    a.t = null;
                }
                a.u = null;
                a.s = null;
                if (a.f != null)
                {
                    a.f.recycle();
                    a.f = null;
                }
                if (a.e != null)
                {
                    a.e.recycle();
                    a.e = null;
                }
            }

            
            {
                a = b.this;
                super();
            }
        };
        v = false;
    }

    static b a(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return null;
_L2:
        if ((obj = com.appnexus.opensdk.b.i.a(com.appnexus.opensdk.b.i.a(jsonobject, "impression_trackers"))) == null) goto _L1; else goto _L3
_L3:
        b b1;
        b1 = new b();
        b1.n = ((ArrayList) (obj));
        b1.a = com.appnexus.opensdk.b.i.c(jsonobject, "title");
        b1.b = com.appnexus.opensdk.b.i.c(jsonobject, "description");
        obj = com.appnexus.opensdk.b.i.a(jsonobject, "main_media");
        if (obj == null) goto _L5; else goto _L4
_L4:
        int i1;
        int j1;
        j1 = ((JSONArray) (obj)).length();
        i1 = 0;
_L11:
        if (i1 >= j1) goto _L5; else goto _L6
_L6:
        JSONObject jsonobject2 = com.appnexus.opensdk.b.i.a(((JSONArray) (obj)), i1);
        if (jsonobject2 == null) goto _L8; else goto _L7
_L7:
        String s1 = com.appnexus.opensdk.b.i.c(jsonobject2, "label");
        if (s1 == null || !s1.equals("default")) goto _L8; else goto _L9
_L9:
        b1.c = com.appnexus.opensdk.b.i.c(jsonobject2, "url");
_L5:
        b1.d = com.appnexus.opensdk.b.i.c(jsonobject, "icon_img_url");
        b1.j = com.appnexus.opensdk.b.i.c(jsonobject, "context");
        b1.i = com.appnexus.opensdk.b.i.c(jsonobject, "cta");
        b1.g = com.appnexus.opensdk.b.i.c(jsonobject, "click_url");
        b1.h = com.appnexus.opensdk.b.i.c(jsonobject, "click_fallback_url");
        JSONObject jsonobject1 = com.appnexus.opensdk.b.i.b(jsonobject, "rating");
        b1.k = new al.a(com.appnexus.opensdk.b.i.e(jsonobject1, "value"), com.appnexus.opensdk.b.i.e(jsonobject1, "scale"));
        b1.o = com.appnexus.opensdk.b.i.a(com.appnexus.opensdk.b.i.a(jsonobject, "click_trackers"));
        b1.l = com.appnexus.opensdk.b.i.a(com.appnexus.opensdk.b.i.b(jsonobject, "custom"));
        (new Handler(Looper.getMainLooper())).postDelayed(b1.p, 0x36ee80L);
        return b1;
_L8:
        i1++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final String a()
    {
        return c;
    }

    public final void a(Bitmap bitmap)
    {
        e = bitmap;
    }

    public final String b()
    {
        return d;
    }

    public final void b(Bitmap bitmap)
    {
        f = bitmap;
    }

    public final void c()
    {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.removeCallbacks(p);
        handler.post(p);
    }
}
