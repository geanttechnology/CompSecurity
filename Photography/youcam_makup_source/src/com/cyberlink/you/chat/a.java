// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringEscapeUtils;
import org.jivesoftware.smack.packet.f;

public class a
    implements f
{

    private String a;
    private String b;
    private String c;
    private Map d;

    public a(String s, String s1)
    {
        c = null;
        a = s;
        b = s1;
    }

    public String a()
    {
        return a;
    }

    public String a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Map map = d;
        if (map != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = (String)d.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = new HashMap();
        }
        d.put(s, StringEscapeUtils.escapeXml(s1));
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public String b()
    {
        return b;
    }

    public void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        c = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("<").append(a).append(" xmlns=\"").append(b).append("\"");
        String s;
        String s1;
        for (Iterator iterator = e(); iterator.hasNext(); stringbuffer.append(" ").append(s).append("=\"").append(s1).append("\""))
        {
            s = (String)iterator.next();
            s1 = a(s);
        }

        stringbuffer.append(">");
        if (c != null && !c.isEmpty())
        {
            stringbuffer.append(c);
        }
        stringbuffer.append("</").append(a).append(">");
        return stringbuffer.toString();
    }

    public Iterator e()
    {
        this;
        JVM INSTR monitorenter ;
        if (d != null) goto _L2; else goto _L1
_L1:
        Iterator iterator = Collections.emptyList().iterator();
_L4:
        this;
        JVM INSTR monitorexit ;
        return iterator;
_L2:
        iterator = Collections.unmodifiableMap(new HashMap(d)).keySet().iterator();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public Map f()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = d;
        if (map != null) goto _L2; else goto _L1
_L1:
        map = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return map;
_L2:
        map = d;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public CharSequence g()
    {
        return d();
    }
}
