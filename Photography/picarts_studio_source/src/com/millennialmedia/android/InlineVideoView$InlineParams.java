// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.millennialmedia.google.gson.b;
import java.util.Map;

class p
{

    int a;
    boolean b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    String i;
    String j;
    String k;
    String l;
    boolean m;
    boolean n;
    boolean o;
    float p;
    int q;
    boolean r;
    boolean s;
    boolean t;

    static p a(String s1)
    {
        return (p)(new b()).a(s1, com/millennialmedia/android/InlineVideoView$InlineParams);
    }

    public String toString()
    {
        return String.format("%s id, %d x, %d y, %d bWidth, %d bHeight, %d pos, %b autoPlay", new Object[] {
            k, Integer.valueOf(a), Integer.valueOf(c), Integer.valueOf(d), Integer.valueOf(e), Integer.valueOf(h), Boolean.valueOf(m)
        });
    }

    (Map map, Context context)
    {
        o = true;
        if (map.get("x") != null)
        {
            a = (int)Float.parseFloat((String)map.get("x"));
        }
        if (map.get("y") != null)
        {
            c = (int)Float.parseFloat((String)map.get("y"));
        }
        if (map.get("width") != null)
        {
            f = (int)Float.parseFloat((String)map.get("width"));
        }
        if (map.get("height") != null)
        {
            g = (int)Float.parseFloat((String)map.get("height"));
        }
        i = (String)map.get("streamVideoURI");
        j = (String)map.get("cachedVideoURI");
        k = (String)map.get("cachedVideoID");
        if (map.get("autoPlay") != null)
        {
            m = Boolean.parseBoolean((String)map.get("autoPlay"));
        }
        if (map.get("showControls") != null)
        {
            n = Boolean.parseBoolean((String)map.get("showControls"));
        }
        if (map.get("bodyWidth") != null)
        {
            d = (int)Float.parseFloat((String)map.get("bodyWidth"));
        }
        if (map.get("bodyHeight") != null)
        {
            e = (int)Float.parseFloat((String)map.get("bodyHeight"));
        }
        l = (String)map.get("touchCallback");
        p = context.getResources().getDisplayMetrics().density;
    }
}
