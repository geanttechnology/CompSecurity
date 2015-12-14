// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            h, ImageViewer, f, q

class d
    implements h
{

    final ImageViewer a;
    private fferName b;
    private q c;
    private f d;

    public void a()
    {
        ImageViewer.a(a, (new StringBuilder()).append("get image buffer from ViewEngine, buffer name is ").append(b.toString()).append(" bDisplay: ").append(d.a).toString());
        if (d.a)
        {
            a.a(b, c);
        }
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
