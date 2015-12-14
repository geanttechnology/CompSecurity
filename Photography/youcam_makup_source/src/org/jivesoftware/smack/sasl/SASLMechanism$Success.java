// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.sasl;

import org.jivesoftware.smack.packet.e;

public class a extends e
{

    private final String a;

    public String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<success xmlns=\"urn:ietf:params:xml:ns:xmpp-sasl\">");
        if (a != null && a.trim().length() > 0)
        {
            stringbuilder.append(a);
        }
        stringbuilder.append("</success>");
        return stringbuilder.toString();
    }

    public CharSequence g()
    {
        return a();
    }

    public (String s)
    {
        a = s;
    }
}
