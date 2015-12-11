// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

// Referenced classes of package com.jirbo.adcolony:
//            ad, aa, bl, cx, 
//            ak, be, db, m

class af extends View
{

    boolean a;
    final ad b;

    public af(ad ad1, Context context)
    {
        b = ad1;
        super(context);
        setBackgroundColor(0xff000000);
    }

    public void onDraw(Canvas canvas)
    {
        b.d = (ViewGroup)getParent().getParent();
        Rect rect = new Rect();
        if (b.T != null && !b.T.isPlaying() && b.j)
        {
            a = false;
        }
        if (getLocalVisibleRect(rect) && android.os.Build.VERSION.SDK_INT >= 14 && b.t)
        {
            if ((!b.j || b.j && (rect.top == 0 || rect.bottom - rect.top > b.getNativeAdHeight())) && rect.bottom - rect.top > b.getNativeAdHeight() / 2)
            {
                if (!a && !b.p && b.T != null && !b.T.isPlaying() && !b.u && !b.C.a(true))
                {
                    if (!b.o);
                }
                if (!b.o)
                {
                    bl.c.b("[ADC] Native Ad Starting");
                    b.b();
                    b.o = true;
                    b.C.e = "native";
                    b.C.f = "native";
                } else
                if (!b.q && b.T != null && cx.c() && !b.T.isPlaying() && !ak.k)
                {
                    bl.c.b("[ADC] Native Ad Resuming");
                    ak.c.d.b("video_resumed", b.C);
                    if (!b.m)
                    {
                        b.c(true);
                    }
                    b.setVolume(b.ar);
                    b.T.seekTo(b.C.k);
                    b.T.start();
                } else
                if (!b.p && !b.o && !ak.c.a(b.C.b, true, false))
                {
                    b.p = true;
                    setVisibility(0);
                    b.I.setVisibility(8);
                }
            }
            a = true;
        } else
        {
            a = false;
        }
        if (!b.p && !cx.c() && b.T != null && !b.T.isPlaying())
        {
            setVisibility(0);
            b.I.setVisibility(8);
            b.p = true;
        }
        if (!b.p && b.T != null && b.T.isPlaying())
        {
            setVisibility(4);
            b.I.setVisibility(0);
        } else
        if (b.p || b.q)
        {
            canvas.drawARGB(255, 0, 0, 0);
            b.I.setVisibility(8);
            b.F.a(canvas, (b.aj - b.F.f) / 2, (b.ak - b.F.g) / 2);
        }
        if (!b.u && !b.p)
        {
            invalidate();
        }
    }
}
