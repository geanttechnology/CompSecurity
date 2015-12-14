// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package org.jivesoftware.smack:
//            XMPPConnection

public abstract class e
{

    final WeakReference a;

    public e(XMPPConnection xmppconnection)
    {
        a = new WeakReference(xmppconnection);
    }

    protected ScheduledFuture a(Runnable runnable, long l, TimeUnit timeunit)
    {
        return a().a(runnable, l, timeunit);
    }

    protected final XMPPConnection a()
    {
        return (XMPPConnection)a.get();
    }
}
