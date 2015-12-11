// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.h;
import com.google.api.a.d.l;
import com.google.api.a.d.m;
import com.google.api.a.d.p;
import com.google.api.a.d.r;
import com.google.api.a.d.s;
import com.google.api.a.d.t;
import com.google.api.a.d.w;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.g;
import com.google.api.a.g.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.api.a.a.a:
//            s, f, t, j, 
//            o

public class i
    implements l, r, w
{
    public static interface a
    {

        public abstract String a(p p1);

        public abstract void a(p p1, String s1);
    }

    public static final class b
    {

        final a a;
        public com.google.api.a.d.v b;
        public com.google.api.a.e.c c;
        public h d;
        g e;
        public l f;
        r g;
        Collection h;

        public final b a(j j1)
        {
            h.add(com.google.api.a.f.a.a.a.a.c.a(j1));
            return this;
        }

        public final i a()
        {
            return new i(this);
        }

        public b(a a1)
        {
            e = g.a;
            h = new ArrayList();
            a = (a)com.google.api.a.f.a.a.a.a.c.a(a1);
        }
    }


    static final Logger a = Logger.getLogger(com/google/api/a/a/a/i.getName());
    private final Lock b = new ReentrantLock();
    private final a c;
    private final g d;
    private String e;
    private Long f;
    private String g;
    private final com.google.api.a.d.v h;
    private final l i;
    private final com.google.api.a.e.c j;
    private final String k;
    private final Collection l;
    private final r m;

    protected i(b b1)
    {
        c = (a)com.google.api.a.f.a.a.a.a.c.a(b1.a);
        h = b1.b;
        j = b1.c;
        String s1;
        if (b1.d == null)
        {
            s1 = null;
        } else
        {
            s1 = b1.d.d();
        }
        k = s1;
        i = b1.f;
        m = b1.g;
        l = Collections.unmodifiableCollection(b1.h);
        d = (g)com.google.api.a.f.a.a.a.a.c.a(b1.e);
    }

    private i b(Long long1)
    {
        if (long1 == null)
        {
            long1 = null;
        } else
        {
            long1 = Long.valueOf(d.a() + long1.longValue() * 1000L);
        }
        return a(long1);
    }

    public final i a(com.google.api.a.a.a.s s1)
    {
        a(s1.accessToken);
        if (s1.refreshToken != null)
        {
            b(s1.refreshToken);
        }
        b(s1.expiresInSeconds);
        return this;
    }

    public final i a(Long long1)
    {
        b.lock();
        f = long1;
        b.unlock();
        return this;
        long1;
        b.unlock();
        throw long1;
    }

    public final i a(String s1)
    {
        b.lock();
        e = s1;
        b.unlock();
        return this;
        s1;
        b.unlock();
        throw s1;
    }

    public final String a()
    {
        b.lock();
        String s1 = e;
        b.unlock();
        return s1;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public final void a(p p1)
    {
        p1.a = this;
        p1.j = this;
    }

    public final boolean a(p p1, s s1, boolean flag)
    {
        boolean flag1;
        boolean flag2;
        flag2 = true;
        Object obj = s1.e.c.authenticate;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        obj = ((List) (obj)).iterator();
        String s2;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_179;
            }
            s2 = (String)((Iterator) (obj)).next();
        } while (!s2.startsWith("Bearer "));
        flag = f.a.matcher(s2).find();
        flag1 = true;
_L1:
        if (!flag1)
        {
            if (s1.c == 401)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        b.lock();
        flag = flag2;
        if (!v.a(e, c.a(p1)))
        {
            break MISSING_BLOCK_LABEL_141;
        }
        flag = e();
        if (flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        b.unlock();
        return flag;
        p1;
        try
        {
            b.unlock();
            throw p1;
        }
        // Misplaced declaration of an exception variable
        catch (p p1)
        {
            a.log(Level.SEVERE, "unable to refresh token", p1);
        }
        return false;
        flag1 = false;
        flag = false;
          goto _L1
    }

    public final i b(String s1)
    {
        b.lock();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        boolean flag;
        if (j != null && h != null && i != null && k != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.api.a.g.w.a(flag, "Please use the Builder and call setJsonFactory, setTransport, setClientAuthentication and setTokenServerUrl/setTokenServerEncodedUrl");
        g = s1;
        b.unlock();
        return this;
        s1;
        b.unlock();
        throw s1;
    }

    public final String b()
    {
        b.lock();
        String s1 = g;
        b.unlock();
        return s1;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public final void b(p p1)
    {
        b.lock();
        Object obj;
        obj = d();
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (((Long) (obj)).longValue() > 60L)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        e();
        obj = e;
        if (obj == null)
        {
            b.unlock();
            return;
        }
        c.a(p1, e);
        b.unlock();
        return;
        p1;
        b.unlock();
        throw p1;
    }

    public final Long c()
    {
        b.lock();
        Long long1 = f;
        b.unlock();
        return long1;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public final Long d()
    {
        b.lock();
        Long long1 = f;
        if (long1 == null)
        {
            b.unlock();
            return null;
        }
        long l1 = (f.longValue() - d.a()) / 1000L;
        b.unlock();
        return Long.valueOf(l1);
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public final boolean e()
    {
        boolean flag;
        flag = true;
        b.lock();
        if (g != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        Iterator iterator1;
        try
        {
            a(((com.google.api.a.a.a.s) (obj)));
            for (Iterator iterator = l.iterator(); iterator.hasNext(); ((j)iterator.next()).onTokenResponse(this, ((com.google.api.a.a.a.s) (obj)))) { }
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            b.unlock();
            throw obj;
        }
        if (400 > ((t) (obj)).b || ((t) (obj)).b >= 500)
        {
            flag = false;
        }
        if (((com.google.api.a.a.a.t) (obj)).a == null || !flag)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        a(((String) (null)));
        b(((Long) (null)));
        for (iterator1 = l.iterator(); iterator1.hasNext(); ((j)iterator1.next()).onTokenErrorResponse(this, ((com.google.api.a.a.a.t) (obj)).a)) { }
        break MISSING_BLOCK_LABEL_232;
_L2:
        obj = (new o(h, j, new h(k), g)).a(i).a(m).b();
        if (true) goto _L4; else goto _L3
_L3:
        b.unlock();
        return true;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        throw obj;
        b.unlock();
        return false;
    }

}
