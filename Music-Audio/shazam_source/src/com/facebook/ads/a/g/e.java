// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.facebook.ads.a.f.o;
import com.facebook.ads.a.f.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class e extends LinearLayout
{
    private static final class a extends u
    {

        public final void run()
        {
            e e1;
label0:
            {
                e1 = (e)super.a.get();
                if (e1 != null)
                {
                    if (e.a(e1).getCurrentPosition() <= 3000)
                    {
                        break label0;
                    }
                    (new o()).execute(new String[] {
                        e1.getVideoPlayReportURI()
                    });
                }
                return;
            }
            e.d(e1).postDelayed(this, 250L);
        }

        public a(e e1)
        {
            super(e1);
        }
    }

    private static final class b extends u
    {

        public final void run()
        {
            e e1 = (e)super.a.get();
            if (e1 != null)
            {
                int i = e.a(e1).getCurrentPosition();
                if (i > e.b(e1))
                {
                    e.a(e1, i);
                }
                e.c(e1).postDelayed(this, 250L);
            }
        }

        public b(e e1)
        {
            super(e1);
        }
    }


    VideoView a;
    private String b;
    private String c;
    private boolean d;
    private int e;
    private Handler f;
    private Handler g;

    public e(Context context)
    {
        super(context);
        context = new MediaController(getContext());
        a = new VideoView(getContext());
        context.setAnchorView(this);
        a.setMediaController(context);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        context.addRule(11, -1);
        context.addRule(9, -1);
        context.addRule(10, -1);
        context.addRule(12, -1);
        context.addRule(13);
        a.setLayoutParams(context);
        addView(a);
        g = new Handler();
        context = new b(this);
        g.postDelayed(context, 250L);
        f = new Handler();
        context = new a(this);
        f.postDelayed(context, 250L);
    }

    static int a(e e1, int i)
    {
        e1.e = i;
        return i;
    }

    static VideoView a(e e1)
    {
        return e1.a;
    }

    static int b(e e1)
    {
        return e1.e;
    }

    static Handler c(e e1)
    {
        return e1.g;
    }

    static Handler d(e e1)
    {
        return e1.f;
    }

    public final String getVideoPlayReportURI()
    {
        return b;
    }

    public final String getVideoTimeReportURI()
    {
        return c;
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
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

    public final void setVideoPlayReportURI(String s)
    {
        b = s;
    }

    public final void setVideoTimeReportURI(String s)
    {
        c = s;
    }

    public final void setVideoURI(Uri uri)
    {
        if (uri != null)
        {
            a.setVideoURI(uri);
        }
    }

    public final void setVideoURI(String s)
    {
        if (s != null)
        {
            setVideoURI(Uri.parse(s));
        }
    }
}
