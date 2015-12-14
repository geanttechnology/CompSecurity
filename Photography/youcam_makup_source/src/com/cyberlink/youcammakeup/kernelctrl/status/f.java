// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.jniproxy.d;
import com.cyberlink.youcammakeup.kernelctrl.t;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            SessionState

class f
{

    final SessionState a;
    private final String b;
    private ImageBufferWrapper c;
    private SessionState.SwapState d;

    public f(SessionState sessionstate, String s, ImageBufferWrapper imagebufferwrapper)
    {
        a = sessionstate;
        super();
        b = s;
        c = imagebufferwrapper;
        c.l();
        d = SessionState.SwapState.b;
    }

    private void d()
    {
        if (c != null)
        {
            c.m();
            c = null;
        }
        if (d == SessionState.SwapState.b)
        {
            d = com.cyberlink.youcammakeup.kernelctrl.status.SessionState.SwapState.d;
        } else
        if (d == SessionState.SwapState.c)
        {
            d = SessionState.SwapState.a;
            return;
        }
    }

    private boolean e()
    {
        while (d == SessionState.SwapState.b || d == SessionState.SwapState.c) 
        {
            return true;
        }
        if (d == com.cyberlink.youcammakeup.kernelctrl.status.SessionState.SwapState.d)
        {
            return false;
        }
        c = t.a(b, Boolean.valueOf(true));
        if (c == null)
        {
            return false;
        } else
        {
            d = SessionState.SwapState.b;
            return true;
        }
    }

    public ImageBufferWrapper a()
    {
        if (e())
        {
            c.l();
            return c;
        } else
        {
            return null;
        }
    }

    public void a(e e1)
    {
        if (e())
        {
            e1.a(c);
            return;
        } else
        {
            e1.b(null);
            return;
        }
    }

    public boolean b()
    {
        if (d == SessionState.SwapState.a)
        {
            return true;
        }
        if (d == SessionState.SwapState.c)
        {
            d();
            return true;
        }
        if (d == com.cyberlink.youcammakeup.kernelctrl.status.SessionState.SwapState.d)
        {
            return false;
        }
        if (c == null)
        {
            return false;
        }
        d d1 = c.j();
        if (d1 == null)
        {
            return false;
        } else
        {
            d1.b(b);
            d = SessionState.SwapState.c;
            d();
            return true;
        }
    }

    public String c()
    {
        if (d == SessionState.SwapState.c || d == SessionState.SwapState.b)
        {
            d();
        }
        d = com.cyberlink.youcammakeup.kernelctrl.status.SessionState.SwapState.d;
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append("swapState: ").append(d).append(", dumpFilePath: ").append(b).toString();
    }
}
