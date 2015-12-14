// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.delay.a;

import java.util.Date;
import org.jivesoftware.smack.util.XmppDateTime;

// Referenced classes of package org.jivesoftware.smackx.delay.a:
//            b

public class a extends b
{

    b a;

    public a(b b1)
    {
        super(b1.e());
        a = b1;
    }

    public String a()
    {
        return "delay";
    }

    public void a(String s)
    {
        a.a(s);
    }

    public String b()
    {
        return "urn:xmpp:delay";
    }

    public void b(String s)
    {
        a.b(s);
    }

    public String c()
    {
        return a.c();
    }

    public String d()
    {
        return a.d();
    }

    public Date e()
    {
        return a.e();
    }

    public String f()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<").append(a()).append(" xmlns=\"").append(b()).append("\"");
        stringbuilder.append(" stamp=\"");
        stringbuilder.append(XmppDateTime.a(e()));
        stringbuilder.append("\"");
        if (c() != null && c().length() > 0)
        {
            stringbuilder.append(" from=\"").append(c()).append("\"");
        }
        stringbuilder.append(">");
        if (d() != null && d().length() > 0)
        {
            stringbuilder.append(d());
        }
        stringbuilder.append("</").append(a()).append(">");
        return stringbuilder.toString();
    }

    public CharSequence g()
    {
        return f();
    }
}
