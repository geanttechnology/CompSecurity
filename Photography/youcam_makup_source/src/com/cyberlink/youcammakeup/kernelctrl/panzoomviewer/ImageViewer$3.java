// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            ImageViewer, f

class a
    implements e
{

    final long a;
    final ImageViewer b;

    public void a(ImageBufferWrapper imagebufferwrapper)
    {
        while (imagebufferwrapper == null || imagebufferwrapper.j() == null) 
        {
            return;
        }
        ViewEngine.a().a(a, imagebufferwrapper);
        imagebufferwrapper = new f();
        imagebufferwrapper.a = false;
        b.a(fferName.a, imagebufferwrapper);
        imagebufferwrapper = new f();
        imagebufferwrapper.a = true;
        b.a(fferName.c, imagebufferwrapper);
        imagebufferwrapper = new f();
        b.a(fferName.b, imagebufferwrapper);
    }

    public volatile void a(Object obj)
    {
        a((ImageBufferWrapper)obj);
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((Void)obj);
    }

    public void b(Void void1)
    {
    }

    public void c(Object obj)
    {
        b((Void)obj);
    }

    r(ImageViewer imageviewer, long l)
    {
        b = imageviewer;
        a = l;
        super();
    }
}
