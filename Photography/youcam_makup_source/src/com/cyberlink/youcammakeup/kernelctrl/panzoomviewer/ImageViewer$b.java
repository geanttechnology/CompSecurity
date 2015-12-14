// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            h, ImageViewer, f, ImageLoader, 
//            i, q

class d
    implements h
{

    final ImageViewer a;
    private fferName b;
    private q c;
    private f d;

    public void a()
    {
label0:
        {
            ImageViewer.a(a, (new StringBuilder()).append("offscreen canvas is prepared, buffer name is ").append(b.toString()).append(" bDisplay: ").append(d.a).toString());
            if (d.a)
            {
                if (b != fferName.a)
                {
                    break label0;
                }
                i j = (i)a.l.b.get(fferName.c);
                if (j == null || !j.c)
                {
                    break label0;
                }
                ImageViewer.a(a, "curView is prepared, no need to render fastBg now. skip it!");
            }
            return;
        }
        a.a(b, c);
    }

    public void a(Exception exception)
    {
        ImageViewer.a(a, (new StringBuilder()).append("request image buffer failed, reason: ").append(exception.getMessage()).toString());
    }

    public fferName(ImageViewer imageviewer, fferName ffername, q q, f f1)
    {
        a = imageviewer;
        super();
        b = null;
        c = null;
        d = null;
        b = ffername;
        c = q;
        d = f1;
    }
}
