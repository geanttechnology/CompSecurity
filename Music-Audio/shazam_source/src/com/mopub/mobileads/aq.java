// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.mopub.common.d.m;
import com.mopub.common.d.n;

// Referenced classes of package com.mopub.mobileads:
//            j, ad

final class aq extends j
{
    static interface a
    {

        public abstract void a();
    }

    final class b
        implements android.view.View.OnTouchListener
    {

        final aq a;
        private boolean b;

        public final boolean onTouch(View view, MotionEvent motionevent)
        {
            motionevent.getAction();
            JVM INSTR tableswitch 0 1: default 28
        //                       0 30
        //                       1 37;
               goto _L1 _L2 _L3
_L1:
            return false;
_L2:
            b = true;
            return false;
_L3:
            if (b)
            {
                b = false;
                if (a.a != null)
                {
                    a.a.a();
                    return false;
                }
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        b()
        {
            a = aq.this;
            super();
        }
    }


    a a;

    private aq(Context context)
    {
        super(context);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
        getSettings().setJavaScriptEnabled(true);
        if (n.a().a(n.n))
        {
            a(true);
        }
        setBackgroundColor(0);
        setOnTouchListener(new b());
        setId((int)m.a());
    }

    static aq a(Context context, ad ad1)
    {
        com.mopub.common.m.a(context);
        com.mopub.common.m.a(ad1);
        context = new aq(context);
        com.mopub.common.m.a(context);
        if (ad1.b == ad.b.c)
        {
            context.a((new StringBuilder("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"")).append(ad1.d).append("\" height=\"").append(ad1.e).append("\" src=\"").append(ad1.a).append("\"></iframe>").toString());
        } else
        {
            if (ad1.b == ad.b.b)
            {
                context.a(ad1.a);
                return context;
            }
            if (ad1.b == ad.b.a)
            {
                if (ad1.c == ad.a.b)
                {
                    context.a((new StringBuilder("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"")).append(ad1.a).append("\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>").toString());
                    return context;
                }
                if (ad1.c == ad.a.c)
                {
                    context.a((new StringBuilder("<script src=\"")).append(ad1.a).append("\"></script>").toString());
                    return context;
                }
            }
        }
        return context;
    }

    private void a(String s)
    {
        loadDataWithBaseURL("http://ads.mopub.com/", s, "text/html", "utf-8", null);
    }
}
