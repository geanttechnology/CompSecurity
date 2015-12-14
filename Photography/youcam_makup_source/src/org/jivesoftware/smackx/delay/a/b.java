// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.delay.a;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.jivesoftware.smack.packet.f;

public class b
    implements f
{

    public static final DateFormat b;
    private Date a;
    private String c;
    private String d;

    public b(Date date)
    {
        a = date;
    }

    public String a()
    {
        return "x";
    }

    public void a(String s)
    {
        c = s;
    }

    public String b()
    {
        return "jabber:x:delay";
    }

    public void b(String s)
    {
        d = s;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public Date e()
    {
        return a;
    }

    public String f()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<").append(a()).append(" xmlns=\"").append(b()).append("\"");
        stringbuilder.append(" stamp=\"");
        synchronized (b)
        {
            stringbuilder.append(b.format(a));
        }
        stringbuilder.append("\"");
        if (c != null && c.length() > 0)
        {
            stringbuilder.append(" from=\"").append(c).append("\"");
        }
        stringbuilder.append(">");
        if (d != null && d.length() > 0)
        {
            stringbuilder.append(d);
        }
        stringbuilder.append("</").append(a()).append(">");
        return stringbuilder.toString();
        exception;
        dateformat;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public CharSequence g()
    {
        return f();
    }

    static 
    {
        b = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss");
        b.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
