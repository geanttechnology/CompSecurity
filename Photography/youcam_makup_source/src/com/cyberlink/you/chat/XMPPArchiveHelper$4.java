// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import org.jivesoftware.smack.packet.IQ;

// Referenced classes of package com.cyberlink.you.chat:
//            j

final class a extends IQ
{

    final String a;

    public String a()
    {
        return (new StringBuilder()).append("<query xmlns='urn:xmpp:mam:0'><cv>").append(a).append("</cv></query>").toString();
    }

    public CharSequence b()
    {
        return a();
    }

    (String s)
    {
        a = s;
        super();
    }
}
