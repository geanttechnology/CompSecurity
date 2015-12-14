// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.ping;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.b.a;
import org.jivesoftware.smack.b.d;
import org.jivesoftware.smack.b.i;
import org.jivesoftware.smack.b.k;
import org.jivesoftware.smack.e;
import org.jivesoftware.smack.f;
import org.jivesoftware.smack.packet.b;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.jivesoftware.smackx.ping.packet.Pong;

// Referenced classes of package org.jivesoftware.smackx.ping:
//            a

public class PingManager extends e
{

    private static final Logger b = Logger.getLogger(org/jivesoftware/smackx/ping/PingManager.getName());
    private static final Map c = Collections.synchronizedMap(new WeakHashMap());
    private static final i d;
    private static final i e;
    private static int f = 1800;
    private final Set g = Collections.synchronizedSet(new HashSet());
    private int h;
    private ScheduledFuture i;
    private long j;
    private final Runnable k = new _cls5();

    private PingManager(XMPPConnection xmppconnection)
    {
        super(xmppconnection);
        h = f;
        j = -1L;
        ServiceDiscoveryManager.a(xmppconnection).b("urn:xmpp:ping");
        c.put(xmppconnection, this);
        xmppconnection.a(new _cls2(), d);
        xmppconnection.a(new _cls3(), e);
        xmppconnection.a(new _cls4());
        d();
    }

    static long a(PingManager pingmanager, long l)
    {
        pingmanager.j = l;
        return l;
    }

    static XMPPConnection a(PingManager pingmanager)
    {
        return pingmanager.a();
    }

    public static PingManager a(XMPPConnection xmppconnection)
    {
        org/jivesoftware/smackx/ping/PingManager;
        JVM INSTR monitorenter ;
        PingManager pingmanager1 = (PingManager)c.get(xmppconnection);
        PingManager pingmanager;
        pingmanager = pingmanager1;
        if (pingmanager1 != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        pingmanager = new PingManager(xmppconnection);
        org/jivesoftware/smackx/ping/PingManager;
        JVM INSTR monitorexit ;
        return pingmanager;
        xmppconnection;
        throw xmppconnection;
    }

    static void a(PingManager pingmanager, int l)
    {
        pingmanager.b(l);
    }

    private void b(int l)
    {
        this;
        JVM INSTR monitorenter ;
        e();
        if (h > 0)
        {
            int i1 = h - l;
            b.fine((new StringBuilder()).append("Scheduling ServerPingTask in ").append(i1).append(" seconds (pingInterval=").append(h).append(", delta=").append(l).append(")").toString());
            i = a(k, i1, TimeUnit.SECONDS);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void b(PingManager pingmanager)
    {
        pingmanager.d();
    }

    static Logger c()
    {
        return b;
    }

    static void c(PingManager pingmanager)
    {
        pingmanager.e();
    }

    static XMPPConnection d(PingManager pingmanager)
    {
        return pingmanager.a();
    }

    private void d()
    {
        b(0);
    }

    static int e(PingManager pingmanager)
    {
        return pingmanager.h;
    }

    private void e()
    {
        if (i != null)
        {
            i.cancel(true);
            i = null;
        }
    }

    static Set f(PingManager pingmanager)
    {
        return pingmanager.g;
    }

    public void a(int l)
    {
        h = l;
        d();
    }

    public void a(org.jivesoftware.smackx.ping.a a1)
    {
        g.add(a1);
    }

    public boolean a(String s)
    {
        return a(s, a().y());
    }

    public boolean a(String s, long l)
    {
        Ping ping = new Ping(s);
        try
        {
            a().a(ping).b();
        }
        catch (XMPPException xmppexception)
        {
            return s.equals(a().b());
        }
        return true;
    }

    public boolean a(boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = a(a().b());
        }
        catch (org.jivesoftware.smack.SmackException.NoResponseException noresponseexception)
        {
            flag1 = false;
        }
        if (!flag1 && flag)
        {
            for (Iterator iterator = g.iterator(); iterator.hasNext(); ((org.jivesoftware.smackx.ping.a)iterator.next()).a()) { }
        }
        return flag1;
    }

    public long b()
    {
        return j;
    }

    static 
    {
        d = new a(new i[] {
            new k(org/jivesoftware/smackx/ping/packet/Ping), new d(b.a)
        });
        e = new a(new i[] {
            new k(org/jivesoftware/smackx/ping/packet/Pong), new d(b.c)
        });
        XMPPConnection.a(new _cls1());
    }

    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}

}
