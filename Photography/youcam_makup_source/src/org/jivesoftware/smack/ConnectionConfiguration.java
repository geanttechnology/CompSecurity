// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.a.b;
import org.jivesoftware.smack.util.j;
import org.jivesoftware.smack.util.p;

// Referenced classes of package org.jivesoftware.smack:
//            j

public class ConnectionConfiguration
    implements Cloneable
{

    protected List a;
    protected ProxyInfo b;
    private String c;
    private String d;
    private String e;
    private String f;
    private SSLContext g;
    private boolean h;
    private CallbackHandler i;
    private boolean j;
    private boolean k;
    private SocketFactory l;
    private String m;
    private String n;
    private String o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private SecurityMode t;
    private HostnameVerifier u;

    public ConnectionConfiguration(String s1, int i1, String s2)
    {
        h = false;
        j = j.a;
        k = true;
        p = true;
        q = true;
        r = false;
        s = true;
        t = org.jivesoftware.smack.SecurityMode.b;
        a(s1, i1);
        a(s2, ProxyInfo.a());
    }

    private void a(String s1, int i1)
    {
        if (org.jivesoftware.smack.util.p.c(s1))
        {
            throw new IllegalArgumentException("host must not be the empty String");
        } else
        {
            a = new ArrayList(1);
            s1 = new b(s1, i1);
            a.add(s1);
            s = false;
            return;
        }
    }

    public String a()
    {
        return c;
    }

    void a(String s1)
    {
        c = s1;
    }

    void a(String s1, String s2, String s3)
    {
        m = s1;
        n = s2;
        o = s3;
    }

    protected void a(String s1, ProxyInfo proxyinfo)
    {
        if (org.jivesoftware.smack.util.p.c(s1))
        {
            throw new IllegalArgumentException("serviceName must not be the empty String");
        } else
        {
            c = s1;
            b = proxyinfo;
            d = System.getProperty("javax.net.ssl.keyStore");
            e = "jks";
            f = "pkcs11.config";
            l = proxyinfo.f();
            return;
        }
    }

    public void a(SSLContext sslcontext)
    {
        g = sslcontext;
    }

    public void a(SecurityMode securitymode)
    {
        t = securitymode;
    }

    public void a(boolean flag)
    {
        j = flag;
    }

    public SecurityMode b()
    {
        return t;
    }

    public void b(boolean flag)
    {
        k = flag;
    }

    public String c()
    {
        return d;
    }

    public void c(boolean flag)
    {
        p = flag;
    }

    public String d()
    {
        return e;
    }

    public String e()
    {
        return f;
    }

    public SSLContext f()
    {
        return g;
    }

    public HostnameVerifier g()
    {
        if (u != null)
        {
            return u;
        } else
        {
            return org.jivesoftware.smack.j.f();
        }
    }

    public boolean h()
    {
        return h;
    }

    public boolean i()
    {
        return j;
    }

    public boolean j()
    {
        return k;
    }

    public boolean k()
    {
        return r;
    }

    public CallbackHandler l()
    {
        return i;
    }

    public SocketFactory m()
    {
        return l;
    }

    public List n()
    {
        return Collections.unmodifiableList(a);
    }

    public String o()
    {
        return m;
    }

    public String p()
    {
        return n;
    }

    public String q()
    {
        return o;
    }

    public boolean r()
    {
        return p;
    }

    void s()
    {
        if (!s)
        {
            return;
        } else
        {
            a = org.jivesoftware.smack.util.j.a(c);
            return;
        }
    }

    private class SecurityMode extends Enum
    {

        public static final SecurityMode a;
        public static final SecurityMode b;
        public static final SecurityMode c;
        public static final SecurityMode d;
        private static final SecurityMode e[];

        public static SecurityMode valueOf(String s1)
        {
            return (SecurityMode)Enum.valueOf(org/jivesoftware/smack/ConnectionConfiguration$SecurityMode, s1);
        }

        public static SecurityMode[] values()
        {
            return (SecurityMode[])e.clone();
        }

        static 
        {
            a = new SecurityMode("required", 0);
            b = new SecurityMode("enabled", 1);
            c = new SecurityMode("disabled", 2);
            d = new SecurityMode("legacy", 3);
            e = (new SecurityMode[] {
                a, b, c, d
            });
        }

        private SecurityMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
