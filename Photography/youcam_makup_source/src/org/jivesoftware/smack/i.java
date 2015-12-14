// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.apache.harmony.javax.security.sasl.SaslException;
import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.sasl.SASLAnonymous;
import org.jivesoftware.smack.sasl.SASLDigestMD5Mechanism;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.SASLExternalMechanism;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.sasl.SASLPlainMechanism;

// Referenced classes of package org.jivesoftware.smack:
//            XMPPConnection

public class i
{

    private static Map a = new HashMap();
    private static List b = new ArrayList();
    private XMPPConnection c;
    private Collection d;
    private SASLMechanism e;
    private boolean f;
    private org.jivesoftware.smack.sasl.SASLMechanism.SASLFailure g;

    i(XMPPConnection xmppconnection)
    {
        d = new ArrayList();
        e = null;
        c = xmppconnection;
        e();
    }

    public static void a(String s, int j)
    {
        b.add(j, s);
    }

    public static void a(String s, Class class1)
    {
        a.put(s, class1);
    }

    public void a(String s)
    {
        e.a(s);
    }

    public void a(String s, String s1, String s2)
    {
        Object obj = null;
        Iterator iterator = b.iterator();
        do
        {
            s2 = ((String) (obj));
            if (!iterator.hasNext())
            {
                break;
            }
            s2 = (String)iterator.next();
        } while (!a.containsKey(s2) || !d.contains(s2));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        obj = (Class)a.get(s2);
        try
        {
            e = (SASLMechanism)((Class) (obj)).getConstructor(new Class[] {
                org/jivesoftware/smack/i
            }).newInstance(new Object[] {
                this
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SaslException("Exception when creating the SASLAuthentication instance", s);
        }
        this;
        JVM INSTR monitorenter ;
        obj = c.b();
        e.a(s, c.c(), ((String) (obj)), s1);
        try
        {
            wait(c.y());
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        this;
        JVM INSTR monitorexit ;
        if (g != null)
        {
            throw new SASLErrorException(s2, g);
        }
        break MISSING_BLOCK_LABEL_191;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (!f)
        {
            throw new SmackException.NoResponseException();
        } else
        {
            return;
        }
        throw new SaslException("SASL Authentication failed. No known authentication mechanisims.");
    }

    public void a(String s, CallbackHandler callbackhandler)
    {
        Class class1 = null;
        Iterator iterator = b.iterator();
        do
        {
            s = class1;
            if (!iterator.hasNext())
            {
                break;
            }
            s = (String)iterator.next();
        } while (!a.containsKey(s) || !d.contains(s));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        class1 = (Class)a.get(s);
        try
        {
            e = (SASLMechanism)class1.getConstructor(new Class[] {
                org/jivesoftware/smack/i
            }).newInstance(new Object[] {
                this
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SaslException("Exception when creating the SASLAuthentication instance", s);
        }
        this;
        JVM INSTR monitorenter ;
        e.a(c.c(), callbackhandler);
        try
        {
            wait(c.y());
        }
        // Misplaced declaration of an exception variable
        catch (CallbackHandler callbackhandler) { }
        this;
        JVM INSTR monitorexit ;
        if (g != null)
        {
            throw new SASLErrorException(s, g);
        }
        break MISSING_BLOCK_LABEL_175;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (!f)
        {
            throw new SmackException.NoResponseException();
        } else
        {
            return;
        }
        throw new SaslException("SASL Authentication failed. No known authentication mechanisims.");
    }

    public void a(Collection collection)
    {
        d = collection;
    }

    public void a(e e1)
    {
        c.b(e1);
    }

    public void a(org.jivesoftware.smack.sasl.SASLMechanism.SASLFailure saslfailure)
    {
        g = saslfailure;
        this;
        JVM INSTR monitorenter ;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        saslfailure;
        this;
        JVM INSTR monitorexit ;
        throw saslfailure;
    }

    public boolean a()
    {
        return d.contains("ANONYMOUS");
    }

    public boolean b()
    {
        return !d.isEmpty() && (d.size() != 1 || !a());
    }

    public void c()
    {
        e = new SASLAnonymous(this);
        this;
        JVM INSTR monitorenter ;
        e.a(null, null, null, "");
        Exception exception;
        try
        {
            wait(c.y());
        }
        catch (InterruptedException interruptedexception) { }
        this;
        JVM INSTR monitorexit ;
        if (g != null)
        {
            throw new SASLErrorException(e.toString(), g);
        }
        break MISSING_BLOCK_LABEL_70;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (!f)
        {
            throw new SmackException.NoResponseException();
        } else
        {
            return;
        }
    }

    public void d()
    {
        f = true;
        this;
        JVM INSTR monitorenter ;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void e()
    {
        f = false;
        g = null;
    }

    static 
    {
        a("EXTERNAL", org/jivesoftware/smack/sasl/SASLExternalMechanism);
        a("DIGEST-MD5", org/jivesoftware/smack/sasl/SASLDigestMD5Mechanism);
        a("PLAIN", org/jivesoftware/smack/sasl/SASLPlainMechanism);
        a("ANONYMOUS", org/jivesoftware/smack/sasl/SASLAnonymous);
        a("DIGEST-MD5", 0);
        a("PLAIN", 1);
        a("ANONYMOUS", 2);
    }
}
