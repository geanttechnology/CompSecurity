// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.a.b;
import org.jivesoftware.smack.b.c;
import org.jivesoftware.smack.b.i;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.e;

// Referenced classes of package org.jivesoftware.smack:
//            j, i, n, m, 
//            k, d, f, ConnectionConfiguration, 
//            l, b, c, g, 
//            h

public abstract class XMPPConnection
{

    private static final Logger o = Logger.getLogger(org/jivesoftware/smack/XMPPConnection.getName());
    private static final AtomicInteger p = new AtomicInteger(0);
    private static final Set q = new CopyOnWriteArraySet();
    private IOException A;
    protected final Collection a = new CopyOnWriteArrayList();
    protected final Collection b = new ConcurrentLinkedQueue();
    protected final Map c = new ConcurrentHashMap();
    protected final Map d = new ConcurrentHashMap();
    protected final Map e = new ConcurrentHashMap();
    protected b f;
    protected Reader g;
    protected Writer h;
    protected org.jivesoftware.smack.i i;
    protected final int j;
    protected final ConnectionConfiguration k;
    protected XMPPInputOutputStream l;
    protected boolean m;
    protected boolean n;
    private long r;
    private String s;
    private FromMode t;
    private boolean u;
    private final ScheduledExecutorService v;
    private String w;
    private int x;
    private AtomicBoolean y;
    private boolean z;

    protected XMPPConnection(ConnectionConfiguration connectionconfiguration)
    {
        r = org.jivesoftware.smack.j.b();
        f = null;
        i = new org.jivesoftware.smack.i(this);
        j = p.getAndIncrement();
        t = org.jivesoftware.smack.FromMode.b;
        u = false;
        v = new ScheduledThreadPoolExecutor(1, new n(j));
        y = new AtomicBoolean(false);
        m = false;
        n = false;
        k = connectionconfiguration;
    }

    static Logger D()
    {
        return o;
    }

    public static void a(org.jivesoftware.smack.c c1)
    {
        q.add(c1);
    }

    private void d(e e1)
    {
        Iterator iterator = d.values().iterator();
_L2:
        m m1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        m1 = (m)iterator.next();
        m1.a(e1);
        if (true) goto _L2; else goto _L1
        e1;
        o.log(Level.WARNING, "Got not connected exception, aborting");
_L1:
    }

    private void e(e e1)
    {
        if (e1 != null)
        {
            for (Iterator iterator = e.values().iterator(); iterator.hasNext(); ((k)iterator.next()).a(e1)) { }
        }
    }

    protected static Collection t()
    {
        return Collections.unmodifiableCollection(q);
    }

    protected void A()
    {
        for (Iterator iterator = u().iterator(); iterator.hasNext(); ((d)iterator.next()).authenticated(this)) { }
    }

    void B()
    {
        for (Iterator iterator = u().iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            try
            {
                d1.connectionClosed();
            }
            catch (Exception exception)
            {
                o.log(Level.SEVERE, "Error in listener while closing connection", exception);
            }
        }

    }

    public int C()
    {
        return j;
    }

    protected String a(String s1)
    {
        AtomicBoolean atomicboolean = y;
        atomicboolean;
        JVM INSTR monitorenter ;
        boolean flag = y.get();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        try
        {
            y.wait(y());
        }
        catch (InterruptedException interruptedexception) { }
        if (!y.get())
        {
            throw new SmackException.ResourceBindingNotOfferedException();
        }
        break MISSING_BLOCK_LABEL_55;
        s1;
        atomicboolean;
        JVM INSTR monitorexit ;
        throw s1;
        atomicboolean;
        JVM INSTR monitorexit ;
        Bind bind = new Bind();
        bind.a(s1);
        s1 = ((Bind)a(((IQ) (bind))).b()).a();
        if (z && !a().k())
        {
            a(((IQ) (new Session()))).b();
        }
        return s1;
    }

    protected ScheduledFuture a(Runnable runnable, long l1, TimeUnit timeunit)
    {
        return v.schedule(runnable, l1, timeunit);
    }

    protected ConnectionConfiguration a()
    {
        return k;
    }

    public f a(i i1)
    {
        i1 = new f(this, i1);
        b.add(i1);
        return i1;
    }

    public f a(IQ iq)
    {
        f f1 = a(((i) (new c(iq, this))));
        b(iq);
        return f1;
    }

    protected void a(IOException ioexception)
    {
        A = ioexception;
    }

    protected void a(Exception exception)
    {
        o.log(Level.WARNING, "Connection closed with error", exception);
        for (Iterator iterator = u().iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            try
            {
                d1.connectionClosedOnError(exception);
            }
            catch (Exception exception1)
            {
                o.log(Level.SEVERE, "Error in listener while closing connection", exception1);
            }
        }

    }

    public abstract void a(String s1, String s2, String s3);

    public void a(d d1)
    {
        while (d1 == null || a.contains(d1)) 
        {
            return;
        }
        a.add(d1);
    }

    protected void a(f f1)
    {
        b.remove(f1);
    }

    public void a(g g1, i i1)
    {
        if (g1 == null)
        {
            throw new NullPointerException("Packet interceptor is null.");
        } else
        {
            e.put(g1, new k(g1, i1));
            return;
        }
    }

    public void a(h h1)
    {
        c.remove(h1);
    }

    public void a(h h1, i i1)
    {
        if (h1 == null)
        {
            throw new NullPointerException("Packet listener is null.");
        } else
        {
            i1 = new m(h1, i1);
            c.put(h1, i1);
            return;
        }
    }

    public void a(Presence presence)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = f();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b(presence);
        s();
        B();
        if (true) goto _L1; else goto _L3
_L3:
        presence;
        throw presence;
    }

    protected abstract void a(e e1);

    protected void a(boolean flag)
    {
        if (!n)
        {
            n = flag;
        }
    }

    public String b()
    {
        return k.a();
    }

    protected void b(String s1)
    {
        k.a(s1);
    }

    protected void b(String s1, String s2, String s3)
    {
        k.a(s1, s2, s3);
    }

    public void b(d d1)
    {
        a.remove(d1);
    }

    public void b(h h1, i i1)
    {
        if (h1 == null)
        {
            throw new NullPointerException("Packet listener is null.");
        } else
        {
            i1 = new m(h1, i1);
            d.put(h1, i1);
            return;
        }
    }

    public void b(e e1)
    {
        if (!f())
        {
            throw new SmackException.NotConnectedException();
        }
        if (e1 == null)
        {
            throw new NullPointerException("Packet is null.");
        }
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[FromMode.values().length];
                try
                {
                    a[org.jivesoftware.smack.FromMode.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[org.jivesoftware.smack.FromMode.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[FromMode.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[t.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 80
    //                   2 88;
           goto _L1 _L2 _L3
_L1:
        e(e1);
        a(e1);
        d(e1);
        return;
_L2:
        e1.m(null);
        continue; /* Loop/switch isn't completed */
_L3:
        e1.m(e());
        if (true) goto _L1; else goto _L4
_L4:
    }

    public String c()
    {
        return w;
    }

    protected void c(String s1)
    {
        s = s1;
    }

    protected void c(e e1)
    {
        if (e1 == null)
        {
            return;
        }
        for (Iterator iterator = v().iterator(); iterator.hasNext(); ((f)iterator.next()).a(e1)) { }
        v.submit(new l(this, e1));
    }

    public int d()
    {
        return x;
    }

    public abstract String e();

    public abstract boolean f();

    protected void finalize()
    {
        v.shutdownNow();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public abstract boolean g();

    public void h()
    {
        i.e();
        y.set(false);
        z = false;
        A = null;
        i();
    }

    protected abstract void i();

    protected void j()
    {
        synchronized (y)
        {
            y.set(true);
            y.notify();
        }
        return;
        exception;
        atomicboolean;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void k()
    {
        z = true;
    }

    protected void l()
    {
        if (A != null)
        {
            throw A;
        } else
        {
            throw new SmackException.NoResponseException();
        }
    }

    protected Reader m()
    {
        return g;
    }

    protected Writer n()
    {
        return h;
    }

    protected void o()
    {
        org.jivesoftware.smack.b.a(this).a(true);
    }

    protected void p()
    {
        k.s();
    }

    protected org.jivesoftware.smack.i q()
    {
        return i;
    }

    public void r()
    {
        a(new Presence(org.jivesoftware.smack.packet.Presence.Type.b));
    }

    protected abstract void s();

    protected Collection u()
    {
        return a;
    }

    protected Collection v()
    {
        return b;
    }

    protected void w()
    {
        Object obj2 = null;
        if (g == null || h == null)
        {
            throw new NullPointerException("Reader or writer isn't initialized.");
        }
        if (!k.i())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        if (f != null)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        Object obj;
        Object obj1;
        try
        {
            obj1 = System.getProperty("smack.debuggerClass");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj1 = null;
        }
        obj = obj2;
        if (obj1 != null)
        {
            try
            {
                obj = Class.forName(((String) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                o.warning((new StringBuilder()).append("Unabled to instantiate debugger class ").append(((String) (obj1))).toString());
                obj = obj2;
            }
        }
        obj1 = obj;
        if (obj == null)
        {
            try
            {
                obj1 = Class.forName("de.measite.smack.AndroidDebugger");
            }
            catch (Exception exception1)
            {
                try
                {
                    exception1 = Class.forName("org.jivesoftware.smack.a.a");
                }
                catch (Exception exception2)
                {
                    o.warning("Unabled to instantiate either Smack debugger class");
                    exception2 = ((Exception) (obj));
                }
            }
        }
        f = (b)((Class) (obj1)).getConstructor(new Class[] {
            org/jivesoftware/smack/XMPPConnection, java/io/Writer, java/io/Reader
        }).newInstance(new Object[] {
            this, h, g
        });
        g = f.getReader();
        h = f.getWriter();
        return;
        Exception exception;
        exception;
        throw new IllegalArgumentException("Can't initialize the configured debugger!", exception);
        g = f.newConnectionReader(g);
        h = f.newConnectionWriter(h);
        return;
    }

    protected void x()
    {
        u = true;
    }

    public long y()
    {
        return r;
    }

    protected void z()
    {
        for (Iterator iterator = u().iterator(); iterator.hasNext(); ((d)iterator.next()).connected(this)) { }
    }

    static 
    {
        org.jivesoftware.smack.j.a();
    }

    private class FromMode extends Enum
    {

        public static final FromMode a;
        public static final FromMode b;
        public static final FromMode c;
        private static final FromMode d[];

        public static FromMode valueOf(String s1)
        {
            return (FromMode)Enum.valueOf(org/jivesoftware/smack/XMPPConnection$FromMode, s1);
        }

        public static FromMode[] values()
        {
            return (FromMode[])d.clone();
        }

        static 
        {
            a = new FromMode("UNCHANGED", 0);
            b = new FromMode("OMITTED", 1);
            c = new FromMode("USER", 2);
            d = (new FromMode[] {
                a, b, c
            });
        }

        private FromMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
