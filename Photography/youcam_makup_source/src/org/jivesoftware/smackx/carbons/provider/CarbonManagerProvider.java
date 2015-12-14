// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.carbons.provider;

import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.provider.e;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.carbons.packet.CarbonExtension;
import org.jivesoftware.smackx.forward.a;
import org.xmlpull.v1.XmlPullParser;

public class CarbonManagerProvider
    implements e
{

    public CarbonManagerProvider()
    {
    }

    public f a(XmlPullParser xmlpullparser)
    {
        org.jivesoftware.smackx.carbons.packet.CarbonExtension.Direction direction = org.jivesoftware.smackx.carbons.packet.CarbonExtension.Direction.valueOf(xmlpullparser.getName());
        a a1 = null;
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i = xmlpullparser.next();
            if (i == 2 && xmlpullparser.getName().equals("forwarded"))
            {
                a1 = (a)PacketParserUtils.a("forwarded", "urn:xmpp:forward:0", xmlpullparser);
            } else
            if (i == 3 && direction == org.jivesoftware.smackx.carbons.packet.CarbonExtension.Direction.valueOf(xmlpullparser.getName()))
            {
                flag = true;
            }
        } while (true);
        if (a1 == null)
        {
            throw new Exception("sent/received must contain exactly one <forwarded> tag");
        } else
        {
            return new CarbonExtension(direction, a1);
        }
    }
}
