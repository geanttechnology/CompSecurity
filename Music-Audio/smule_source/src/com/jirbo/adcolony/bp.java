// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, bz, 
//            cd, bc, bx, cx, 
//            bl, h

class bp
{

    boolean a;
    int b;
    int c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    double k;
    bz l;
    bz m;
    bz n;
    cd o;

    bp()
    {
    }

    boolean a()
    {
        if (a)
        {
            if (!ak.c.c.a(d))
            {
                return false;
            }
            if (!l.a())
            {
                return false;
            }
            if (!m.a())
            {
                return false;
            }
            if (!o.a())
            {
                return false;
            }
            if (!n.a())
            {
                return false;
            }
            if (ak.c.b.j.i.equals("online") && !cx.c())
            {
                ak.T = 9;
                return bl.c.b("Video not ready due to VIEW_FILTER_ONLINE");
            }
            if (ak.c.b.j.i.equals("wifi") && !cx.a())
            {
                ak.T = 9;
                return bl.c.b("Video not ready due to VIEW_FILTER_WIFI");
            }
            if (ak.c.b.j.i.equals("cell") && !cx.b())
            {
                ak.T = 9;
                return bl.c.b("Video not ready due to VIEW_FILTER_CELL");
            }
            if (ak.c.b.j.i.equals("offline") && cx.c())
            {
                ak.T = 9;
                return bl.c.b("Video not ready due to VIEW_FILTER_OFFLINE");
            }
        }
        return true;
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.g("enabled");
            if (!a)
            {
                return true;
            }
            b = h1.f("width");
            c = h1.f("height");
            d = h1.d("url");
            e = h1.d("last_modified");
            f = h1.d("video_frame_rate");
            g = h1.d("audio_channels");
            h = h1.d("audio_codec");
            i = h1.d("audio_sample_rate");
            j = h1.d("video_codec");
            k = h1.e("duration");
            l = new bz();
            if (l.a(h1.a("skip_video")))
            {
                m = new bz();
                if (m.a(h1.a("in_video_engagement")))
                {
                    o = new cd();
                    if (o.a(h1.a("haptic")))
                    {
                        n = new bz();
                        if (n.a(h1.a("in_video_engagement").a("image_overlay")))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    String b()
    {
        return ak.c.c.b(d);
    }

    void c()
    {
        ak.c.c.a(d, e);
        m.b();
        l.b();
        o.b();
        n.b();
    }
}
