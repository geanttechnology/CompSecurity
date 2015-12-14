// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.facebook.ads.internal.util.o;
import java.util.HashMap;

public class g extends LinearLayout
{

    private VideoView a;
    private String b;
    private String c;
    private boolean d;
    private int e;
    private Handler f;
    private Handler g;

    public g(Context context)
    {
        super(context);
        c();
    }

    static int a(g g1, int i)
    {
        g1.e = i;
        return i;
    }

    static VideoView a(g g1)
    {
        return g1.a;
    }

    static int b(g g1)
    {
        return g1.e;
    }

    static Handler c(g g1)
    {
        return g1.g;
    }

    private void c()
    {
        Object obj = new MediaController(getContext());
        a = new VideoView(getContext());
        ((MediaController) (obj)).setAnchorView(this);
        a.setMediaController(((MediaController) (obj)));
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        addView(a);
        g = new Handler();
        obj = new b();
        g.postDelayed(((Runnable) (obj)), 250L);
        f = new Handler();
        obj = new a();
        f.postDelayed(((Runnable) (obj)), 250L);
    }

    static Handler d(g g1)
    {
        return g1.f;
    }

    private void d()
    {
        if (!d && getVideoTimeReportURI() != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("time", Integer.toString(e / 1000));
            hashmap.put("inline", "0");
            (new o(hashmap)).execute(new String[] {
                getVideoTimeReportURI()
            });
            d = true;
            e = 0;
        }
    }

    public void a()
    {
        a.start();
    }

    public void b()
    {
        if (a != null)
        {
            a.stopPlayback();
        }
    }

    public String getVideoPlayReportURI()
    {
        return b;
    }

    public String getVideoTimeReportURI()
    {
        return c;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        d();
    }

    public void setVideoPlayReportURI(String s)
    {
        b = s;
    }

    public void setVideoTimeReportURI(String s)
    {
        c = s;
    }

    public void setVideoURI(Uri uri)
    {
        if (uri != null)
        {
            a.setVideoURI(uri);
        }
    }

    public void setVideoURI(String s)
    {
        if (s != null)
        {
            setVideoURI(Uri.parse(s));
        }
    }

    private class b extends t
    {

        public void run()
        {
            g g1 = (g)a();
            if (g1 != null)
            {
                int i = g.a(g1).getCurrentPosition();
                if (i > g.b(g1))
                {
                    g.a(g1, i);
                }
                g.c(g1).postDelayed(this, 250L);
            }
        }

        public b()
        {
        }
    }


    private class a extends t
    {

        public void run()
        {
            g g1;
label0:
            {
                g1 = (g)a();
                if (g1 != null)
                {
                    if (g.a(g1).getCurrentPosition() <= 3000)
                    {
                        break label0;
                    }
                    (new o()).execute(new String[] {
                        g1.getVideoPlayReportURI()
                    });
                }
                return;
            }
            g.d(g1).postDelayed(this, 250L);
        }

        public a()
        {
        }
    }

}
