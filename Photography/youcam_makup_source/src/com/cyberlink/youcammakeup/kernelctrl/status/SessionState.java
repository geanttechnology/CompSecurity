// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            d, a, f

public class SessionState
{

    private final a a;
    private final int b;
    private f c;

    public SessionState(d d1, int i, a a1, ImageBufferWrapper imagebufferwrapper)
    {
        if (a1 != null);
        if (imagebufferwrapper != null);
        b = i;
        a = a1;
        d1 = (new StringBuilder()).append(d1.b()).append("/").append(String.valueOf(a1.a)).toString();
        if (b >= 0)
        {
            d1 = (new StringBuilder()).append(d1).append("_").append(b).toString();
        } else
        {
            d1 = (new StringBuilder()).append(d1).append("_init").toString();
        }
        c = new f(this, d1, imagebufferwrapper);
    }

    public a a()
    {
        return a;
    }

    public void a(e e)
    {
        c.a(e);
    }

    public ImageBufferWrapper b()
    {
        return c.a();
    }

    public boolean c()
    {
        return true & c.b();
    }

    public String d()
    {
        return c.c();
    }

    public String toString()
    {
        return (new StringBuilder()).append("ID: ").append(a.a).append(", mCount: ").append(b).append(", sessionStateImpl: { ").append(c.toString()).append(" }").toString();
    }
}
