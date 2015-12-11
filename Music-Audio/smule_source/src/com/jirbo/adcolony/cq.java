// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            h

class cq
{

    ArrayList A;
    ArrayList B;
    HashMap C;
    ArrayList a;
    ArrayList b;
    ArrayList c;
    ArrayList d;
    ArrayList e;
    ArrayList f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    ArrayList n;
    ArrayList o;
    ArrayList p;
    ArrayList q;
    ArrayList r;
    ArrayList s;
    ArrayList t;
    ArrayList u;
    ArrayList v;
    ArrayList w;
    ArrayList x;
    ArrayList y;
    ArrayList z;

    cq()
    {
        a = new ArrayList();
        b = new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
        h = new ArrayList();
        i = new ArrayList();
        j = new ArrayList();
        k = new ArrayList();
        l = new ArrayList();
        m = new ArrayList();
        n = new ArrayList();
        o = new ArrayList();
        p = new ArrayList();
        q = new ArrayList();
        r = new ArrayList();
        s = new ArrayList();
        t = new ArrayList();
        u = new ArrayList();
        v = new ArrayList();
        w = new ArrayList();
        x = new ArrayList();
        y = new ArrayList();
        z = new ArrayList();
        A = new ArrayList();
        B = new ArrayList();
        C = new HashMap();
    }

    boolean a(h h1)
    {
        if (h1 == null)
        {
            return false;
        } else
        {
            a = h1.c("replay");
            b = h1.c("card_shown");
            c = h1.c("html5_interaction");
            d = h1.c("cancel");
            e = h1.c("download");
            f = h1.c("skip");
            g = h1.c("info");
            h = h1.c("midpoint");
            i = h1.c("card_dissolved");
            j = h1.c("start");
            k = h1.c("third_quartile");
            l = h1.c("complete");
            m = h1.c("continue");
            n = h1.c("in_video_engagement");
            o = h1.c("reward_v4vc");
            p = h1.c("first_quartile");
            q = h1.c("v4iap");
            r = h1.c("video_expanded");
            s = h1.c("sound_mute");
            t = h1.c("sound_unmute");
            u = h1.c("video_paused");
            v = h1.c("video_resumed");
            w = h1.c("native_start");
            x = h1.c("native_first_quartile");
            y = h1.c("native_midpoint");
            z = h1.c("native_third_quartile");
            A = h1.c("native_complete");
            B = h1.c("native_overlay_click");
            C.put("replay", a);
            C.put("card_shown", b);
            C.put("html5_interaction", c);
            C.put("cancel", d);
            C.put("download", e);
            C.put("skip", f);
            C.put("info", g);
            C.put("midpoint", h);
            C.put("card_dissolved", i);
            C.put("start", j);
            C.put("third_quartile", k);
            C.put("complete", l);
            C.put("continue", m);
            C.put("in_video_engagement", n);
            C.put("reward_v4vc", o);
            C.put("first_quartile", p);
            C.put("v4iap", q);
            C.put("video_expanded", r);
            C.put("sound_mute", s);
            C.put("sound_unmute", t);
            C.put("video_paused", u);
            C.put("video_resumed", v);
            C.put("native_start", w);
            C.put("native_first_quartile", x);
            C.put("native_midpoint", y);
            C.put("native_third_quartile", z);
            C.put("native_complete", A);
            C.put("native_overlay_click", B);
            return true;
        }
    }
}
