// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.b.i;
import org.jivesoftware.smack.packet.e;

// Referenced classes of package org.jivesoftware.smack:
//            j, XMPPConnection

public class f
{

    private i a;
    private ArrayBlockingQueue b;
    private XMPPConnection c;
    private boolean d;

    protected f(XMPPConnection xmppconnection, i k)
    {
        this(xmppconnection, k, j.c());
    }

    protected f(XMPPConnection xmppconnection, i k, int l)
    {
        d = false;
        c = xmppconnection;
        a = k;
        b = new ArrayBlockingQueue(l);
    }

    public e a(long l)
    {
        e e1;
        try
        {
            e1 = (e)b.poll(l, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new RuntimeException(interruptedexception);
        }
        return e1;
    }

    public void a()
    {
        if (!d)
        {
            d = true;
            c.a(this);
        }
    }

    protected void a(e e1)
    {
        if (e1 != null && (a == null || a.a(e1)))
        {
            while (!b.offer(e1)) 
            {
                b.poll();
            }
        }
    }

    public e b()
    {
        return b(c.y());
    }

    public e b(long l)
    {
        e e1 = a(l);
        a();
        if (e1 == null)
        {
            throw new SmackException.NoResponseException();
        }
        org.jivesoftware.smack.packet.XMPPError xmpperror = e1.t();
        if (xmpperror != null)
        {
            throw new XMPPException.XMPPErrorException(xmpperror);
        } else
        {
            return e1;
        }
    }
}
