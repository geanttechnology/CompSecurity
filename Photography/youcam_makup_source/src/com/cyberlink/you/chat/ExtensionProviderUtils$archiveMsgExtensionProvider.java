// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.provider.e;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.cyberlink.you.chat:
//            a

public class 
    implements e
{

    public f a(XmlPullParser xmlpullparser)
    {
        a a1 = new a("message", "urn:xmpp:forward:0");
        a1.a("id", xmlpullparser.getAttributeValue(null, "id"));
        a1.a("type", xmlpullparser.getAttributeValue(null, "type"));
        a1.a("from", xmlpullparser.getAttributeValue(null, "from"));
        a1.a("to", xmlpullparser.getAttributeValue(null, "to"));
        return a1;
    }

    public ()
    {
    }
}
