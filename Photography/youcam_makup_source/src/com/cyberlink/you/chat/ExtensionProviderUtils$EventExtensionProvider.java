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
        a a1 = new a("event", "urn:xmpp:custom:event");
        int i = xmlpullparser.getEventType();
        if (i != 3 && i == 2)
        {
            for (int j = 0; j < xmlpullparser.getAttributeCount(); j++)
            {
                a1.a(xmlpullparser.getAttributeName(j), xmlpullparser.getAttributeValue(j));
            }

        }
        return a1;
    }

    public ()
    {
    }
}
