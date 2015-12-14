// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.r;

// Referenced classes of package org.jivesoftware.smack.packet:
//            e

public class CLResumed extends e
{

    private String a;
    private String b;
    private String d;
    private String e;
    private long f;

    public CLResumed()
    {
        b = "urn:xmpp:custom:resume";
        j(b);
    }

    public String a()
    {
        return a;
    }

    public void a(long l)
    {
        f = l;
    }

    public void a(String s)
    {
        d = s;
    }

    public void b(String s)
    {
        e = s;
    }

    public String c()
    {
        return d;
    }

    public String d()
    {
        return e;
    }

    public long e()
    {
        return f;
    }

    public String e_()
    {
        return b;
    }

    public r f()
    {
        r r1 = new r();
        r1.a("clresumed");
        r1.d(e_());
        r1.e(a());
        r1.d("status", c());
        r1.d("sessionid", d());
        r1.d("expiration", String.valueOf(e()));
        r1.a();
        return r1;
    }

    public CharSequence g()
    {
        return f();
    }

    public String toString()
    {
        return f().toString();
    }
}
