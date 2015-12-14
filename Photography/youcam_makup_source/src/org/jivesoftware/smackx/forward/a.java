// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.forward;

import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.packet.f;

public class a
    implements f
{

    private org.jivesoftware.smackx.delay.a.a a;
    private e b;

    public a(org.jivesoftware.smackx.delay.a.a a1, e e1)
    {
        a = a1;
        b = e1;
    }

    public String a()
    {
        return "forwarded";
    }

    public String b()
    {
        return "urn:xmpp:forward:0";
    }

    public String c()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<").append(a()).append(" xmlns=\"").append(b()).append("\">");
        if (a != null)
        {
            stringbuilder.append(a.f());
        }
        stringbuilder.append(b.g());
        stringbuilder.append("</").append(a()).append(">");
        return stringbuilder.toString();
    }

    public e d()
    {
        return b;
    }

    public org.jivesoftware.smackx.delay.a.a e()
    {
        return a;
    }

    public CharSequence g()
    {
        return c();
    }
}
