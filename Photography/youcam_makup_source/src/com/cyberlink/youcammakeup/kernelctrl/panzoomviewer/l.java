// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import com.cyberlink.youcammakeup.utility.bx;
import com.cyberlink.youcammakeup.utility.by;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            ImageLoader, k, q, h

class l
    implements bx
{

    ImageLoader.BufferName a;
    q b;
    h c;
    final ImageLoader d;

    public l(ImageLoader imageloader, ImageLoader.BufferName buffername, q q, h h)
    {
        d = imageloader;
        super();
        a = null;
        b = null;
        c = null;
        a = buffername;
        b = q;
        c = h;
    }

    public k a(by by)
    {
        synchronized (d.g)
        {
            ImageLoader.a(d, a, b, null);
        }
        by = new k(d);
        by.a = c;
        return by;
        exception;
        by;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object b(by by)
    {
        return a(by);
    }
}
