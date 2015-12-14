// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            SessionState

public class ImageStateChangedEvent
{

    private final long a;
    private final SessionState b;
    private final SessionState c;
    private final ActionDirection d;

    public ImageStateChangedEvent(long l, SessionState sessionstate, SessionState sessionstate1, ActionDirection actiondirection)
    {
        a = l;
        b = sessionstate;
        c = sessionstate1;
        d = actiondirection;
    }

    public long a()
    {
        return a;
    }

    public SessionState b()
    {
        return b;
    }

    public SessionState c()
    {
        return c;
    }

    public ActionDirection d()
    {
        return d;
    }
}
