// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.r;

// Referenced classes of package org.jivesoftware.smack.packet:
//            IQ, b

public class Bind extends IQ
{

    private String a;
    private String b;

    public Bind()
    {
        a = null;
        b = null;
        a(b.b);
    }

    public String a()
    {
        return b;
    }

    public void a(String s)
    {
        a = s;
    }

    public CharSequence b()
    {
        r r1 = new r();
        r1.a("bind");
        r1.d("urn:ietf:params:xml:ns:xmpp-bind");
        r1.b();
        r1.b("resource", a);
        r1.b("jid", b);
        r1.c("bind");
        return r1;
    }

    public void b(String s)
    {
        b = s;
    }
}
