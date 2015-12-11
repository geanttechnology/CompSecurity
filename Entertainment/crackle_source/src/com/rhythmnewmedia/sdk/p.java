// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.rhythmnewmedia.sdk.display.AdView;
import com.rhythmnewmedia.sdk.video.RhythmVideoView;
import com.rhythmnewmedia.sdk.video.VideoEventAdapter;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            b, i, w, y

public final class p extends b
{

    AdView k;

    public p(Activity activity, String s, String s1)
    {
        super(activity, s, s1);
    }

    protected final i a(String s)
    {
        s = super.a(s);
        if (!j) goto _L2; else goto _L1
_L1:
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[d.a.values().length];
                try
                {
                    a[d.a.o.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[d.a.n.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[d.a.s.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[d.a.r.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[d.a.m.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[d.a.p.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[d.a.j.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[((i) (s)).a.ordinal()];
        JVM INSTR tableswitch 1 7: default 68
    //                   1 81
    //                   2 81
    //                   3 81
    //                   4 108
    //                   5 108
    //                   6 108
    //                   7 108;
           goto _L3 _L4 _L4 _L4 _L5 _L5 _L5 _L5
_L3:
        if (!((i) (s)).b)
        {
            c();
        }
_L2:
        return s;
_L4:
        RhythmVideoView rhythmvideoview = (RhythmVideoView)((i) (s)).e;
        if (rhythmvideoview != null)
        {
            rhythmvideoview.setVideoEventListener(new VideoEventAdapter() {

                final p a;

                public final void onCompletion(RhythmVideoView rhythmvideoview1, int j, int l, int i1)
                {
                    a.c();
                }

            
            {
                a = p.this;
                super();
            }
            });
        }
        continue; /* Loop/switch isn't completed */
_L5:
        c();
        if (true) goto _L3; else goto _L6
_L6:
    }

    public final void a(Intent intent)
    {
        Object aobj[] = w.a(intent.getStringExtra("ipckey"));
        if (aobj == null || aobj.length <= 0)
        {
            y.b("display landing page expected 1 parameter", new Object[0]);
            return;
        }
        k = (AdView)aobj[0];
        if (k.isCancelled())
        {
            c();
            return;
        } else
        {
            d = d();
            int j = intent.getIntExtra("backgroundColor", 0);
            setBackgroundColor(j);
            c.setBackgroundColor(j);
            d.setBackgroundColor(j);
            c.addView(d);
            intent = intent.getStringExtra("url");
            d.loadUrl(intent);
            return;
        }
    }

    protected final boolean a()
    {
        return true;
    }
}
