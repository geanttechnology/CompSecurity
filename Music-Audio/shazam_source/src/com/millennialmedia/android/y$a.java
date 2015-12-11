// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            y, au, al

static final class ity
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/millennialmedia/android/y$a$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("DEFAULT", 0);
            b = new a("STOP", 1);
            c = new a("PLAY", 2);
            d = new a("PAUSE", 3);
            e = new a("RESUME", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }

    static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        private static final b d[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/millennialmedia/android/y$a$b, s);
        }

        public static b[] values()
        {
            return (b[])d.clone();
        }

        static 
        {
            a = new b("DEFAULT", 0);
            b = new b("PREPARING", 1);
            c = new b("PREPARED", 2);
            d = (new b[] {
                a, b, c
            });
        }

        private b(String s, int i1)
        {
            super(s, i1);
        }
    }


    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    String g;
    String h;
    String i;
    String j;
    boolean k;
    boolean l;
    float m;
    boolean n;
    int o;
    a p;
    b q;

    public final String a()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("x", a);
            ((JSONObject) (obj)).put("expanded", n);
            ((JSONObject) (obj)).put("y", b);
            ((JSONObject) (obj)).put("bodyWidth", c);
            ((JSONObject) (obj)).put("bodyHeight", d);
            ((JSONObject) (obj)).put("width", e);
            ((JSONObject) (obj)).put("height", f);
            ((JSONObject) (obj)).put("currentPosition", o);
            ((JSONObject) (obj)).put("playerState", p.ordinal());
            ((JSONObject) (obj)).put("videoState", q.ordinal());
            ((JSONObject) (obj)).put("streamVideoURI", g);
            ((JSONObject) (obj)).put("cachedVideoURI", h);
            ((JSONObject) (obj)).put("cachedVideoID", i);
            ((JSONObject) (obj)).put("touchCallBack", j);
            ((JSONObject) (obj)).put("autoPlay", k);
            ((JSONObject) (obj)).put("showControls", l);
            ((JSONObject) (obj)).put("scaleFactor", m);
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            al.a("InlineVideoView", "Error converting InlineParams to json string", jsonexception);
            return null;
        }
        return ((String) (obj));
    }

    public final String toString()
    {
        return String.format(Locale.ENGLISH, "cached video id: %s, x: %d, y: %d, body width: %d, body height: %d, current position: %d, auto play: %b, player state: %d, video state: %d", new Object[] {
            i, Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(c), Integer.valueOf(d), Integer.valueOf(o), Boolean.valueOf(k), Integer.valueOf(p.ordinal()), Integer.valueOf(q.ordinal())
        });
    }

    public b(String s)
    {
        p = a.a;
        q = b.a;
        try
        {
            s = new JSONObject(s);
            a = au.a(s, "x");
            b = au.a(s, "y");
            c = au.a(s, "bodyWidth");
            d = au.a(s, "bodyHeight");
            e = au.a(s, "width");
            f = au.a(s, "height");
            n = au.c(s, "expanded");
            o = au.a(s, "currentPosition");
            int i1 = au.a(s, "playerState");
            p = a.values()[i1];
            i1 = au.a(s, "videoState");
            q = b.values()[i1];
            g = au.a(s, "streamVideoURI", "");
            h = au.a(s, "cachedVideoURI", "");
            i = au.a(s, "cachedVideoID", "");
            j = au.a(s, "touchCallBack", "");
            k = au.c(s, "autoPlay");
            l = au.c(s, "showControls");
            m = (float)au.b(s, "scaleFactor");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            al.a("InlineVideoView", "Error creating inline param object", s);
        }
    }

    (Map map, Context context)
    {
        p = a.a;
        q = b.a;
        if (map.get("x") != null)
        {
            a = (int)Float.parseFloat((String)map.get("x"));
        }
        if (map.get("y") != null)
        {
            b = (int)Float.parseFloat((String)map.get("y"));
        }
        if (map.get("width") != null)
        {
            e = (int)Float.parseFloat((String)map.get("width"));
        }
        if (map.get("height") != null)
        {
            f = (int)Float.parseFloat((String)map.get("height"));
        }
        g = (String)map.get("streamVideoURI");
        h = (String)map.get("cachedVideoURI");
        i = (String)map.get("cachedVideoID");
        if (map.get("autoPlay") != null)
        {
            k = Boolean.parseBoolean((String)map.get("autoPlay"));
        }
        if (map.get("showControls") != null)
        {
            l = Boolean.parseBoolean((String)map.get("showControls"));
        }
        if (map.get("bodyWidth") != null)
        {
            c = (int)Float.parseFloat((String)map.get("bodyWidth"));
        }
        if (map.get("bodyHeight") != null)
        {
            d = (int)Float.parseFloat((String)map.get("bodyHeight"));
        }
        j = (String)map.get("touchCallback");
        m = context.getResources().getDisplayMetrics().density;
    }
}
