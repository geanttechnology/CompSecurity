// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.os.Message;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            x, v, PanZoomViewer, q, 
//            t, w, ad

class ab extends x
{

    final PanZoomViewer b;

    private ab(PanZoomViewer panzoomviewer)
    {
        b = panzoomviewer;
        super(panzoomviewer);
    }

    ab(PanZoomViewer panzoomviewer, PanZoomViewer._cls1 _pcls1)
    {
        this(panzoomviewer);
    }

    public boolean handleMessage(Message message)
    {
        v v1;
        if (!(message.obj instanceof v))
        {
            return false;
        }
        v1 = (v)message.obj;
        message.what;
        JVM INSTR lookupswitch 4: default 68
    //                   0: 102
    //                   1: 130
    //                   11: 485
    //                   12: 558;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        m.e("RenderCacheHandlerCallback", (new StringBuilder()).append("cannot handle render command: ").append(message.what).toString());
        v1.b();
        return false;
_L2:
        b.c();
        b.J = 0;
        b.invalidate();
_L7:
        v1.b();
        return true;
_L3:
        if (PanZoomViewer.f(b) != PanZoomViewer.ViewerMode.g && PanZoomViewer.f(b) != PanZoomViewer.ViewerMode.h && PanZoomViewer.f(b) != PanZoomViewer.ViewerMode.a && v1.get(1) == ImageLoader.BufferName.c)
        {
            m.c("RenderCacheHandlerCallback#RENDER_DISPLAY", "ViewerMode");
            v1.b();
            return false;
        }
        w w1 = b.m.q.f;
        message = ((q)v1.get(2)).q.f;
        if (v1.get(1) == ImageLoader.BufferName.c && (w1 != null || message != null))
        {
            if (w1 == null && message != null || w1 != null && message == null)
            {
                m.c("RenderCacheHandlerCallback#RENDER_DISPLAY", "ROI #1");
                v1.b();
                return false;
            }
            if (w1.a() != message.a() || w1.b() != message.b() || w1.c() != message.c() || w1.d() != message.d())
            {
                m.c("RenderCacheHandlerCallback#RENDER_DISPLAY", "ROI #2");
                v1.b();
                return false;
            }
        }
        if (b.H == ImageLoader.BufferName.c && v1.get(1) == ImageLoader.BufferName.a)
        {
            w w2 = b.I.q.f;
            if (w2.a() == message.a() || w2.b() == message.b() || w2.c() == message.c() || w2.d() == message.d())
            {
                m.e("FUCK", "fastBg has same ROI!!!");
                return true;
            }
        }
        b.c();
        b.H = (ImageLoader.BufferName)v1.get(1);
        b.I = (q)v1.get(2);
        b.J = 1;
        b.invalidate();
        continue; /* Loop/switch isn't completed */
_L4:
        b.c();
        b.H = (ImageLoader.BufferName)v1.get(1);
        b.I = (q)v1.get(2);
        PanZoomViewer.b(b, (PanZoomViewer.ViewerMode)v1.get(11));
        b.J = 11;
        b.invalidate();
        continue; /* Loop/switch isn't completed */
_L5:
        b.c();
        PanZoomViewer.a(b, (ad)v1.get(12));
        b.J = 12;
        b.invalidate();
        if (true) goto _L7; else goto _L6
_L6:
    }
}
