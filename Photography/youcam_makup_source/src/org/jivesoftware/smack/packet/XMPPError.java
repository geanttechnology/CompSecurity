// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package org.jivesoftware.smack.packet:
//            j, i, f

public class XMPPError
{

    private final Type a;
    private final String b;
    private String c;
    private List d;

    public XMPPError(Type type, String s, String s1, List list)
    {
        d = null;
        a = type;
        b = s;
        c = s1;
        d = list;
    }

    public XMPPError(i k)
    {
        d = null;
        j j1 = j.a(k);
        b = i.a(k);
        if (j1 != null)
        {
            a = j1.a();
            return;
        } else
        {
            a = null;
            return;
        }
    }

    public String a()
    {
        return b;
    }

    public void a(f f1)
    {
        this;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = new ArrayList();
        }
        d.add(f1);
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        throw f1;
    }

    public Type b()
    {
        return a;
    }

    public CharSequence c()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<error");
        if (a != null)
        {
            stringbuilder.append(" type=\"");
            stringbuilder.append(a.name().toLowerCase(Locale.US));
            stringbuilder.append("\"");
        }
        stringbuilder.append(">");
        if (b != null)
        {
            stringbuilder.append("<").append(b);
            stringbuilder.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (c != null)
        {
            stringbuilder.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            stringbuilder.append(c);
            stringbuilder.append("</text>");
        }
        for (Iterator iterator = d().iterator(); iterator.hasNext(); stringbuilder.append(((f)iterator.next()).g())) { }
        stringbuilder.append("</error>");
        return stringbuilder.toString();
    }

    public List d()
    {
        this;
        JVM INSTR monitorenter ;
        if (d != null) goto _L2; else goto _L1
_L1:
        List list = Collections.emptyList();
_L4:
        this;
        JVM INSTR monitorexit ;
        return list;
_L2:
        list = Collections.unmodifiableList(d);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (b != null)
        {
            stringbuilder.append(b);
        }
        if (c != null)
        {
            stringbuilder.append(" ").append(c);
        }
        return stringbuilder.toString();
    }

    /* member class not found */
    class Type {}

}
