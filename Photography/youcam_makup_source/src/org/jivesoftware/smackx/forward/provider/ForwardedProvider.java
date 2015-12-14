// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.forward.provider;

import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.provider.e;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.delay.a.a;
import org.xmlpull.v1.XmlPullParser;

public class ForwardedProvider
    implements e
{

    public ForwardedProvider()
    {
    }

    public f a(XmlPullParser xmlpullparser)
    {
        Object obj1 = null;
        boolean flag = false;
        Object obj = null;
        while (!flag) 
        {
            int i = xmlpullparser.next();
            Object obj2;
            if (i == 2)
            {
                if (xmlpullparser.getName().equals("delay"))
                {
                    a a1 = (a)PacketParserUtils.a(xmlpullparser.getName(), xmlpullparser.getNamespace(), xmlpullparser);
                    obj = obj1;
                    obj1 = a1;
                } else
                if (xmlpullparser.getName().equals("message"))
                {
                    org.jivesoftware.smack.packet.Message message = PacketParserUtils.a(xmlpullparser);
                    obj1 = obj;
                    obj = message;
                } else
                {
                    throw new Exception((new StringBuilder()).append("Unsupported forwarded packet type: ").append(xmlpullparser.getName()).toString());
                }
            } else
            if (i == 3 && xmlpullparser.getName().equals("forwarded"))
            {
                flag = true;
                Object obj3 = obj;
                obj = obj1;
                obj1 = obj3;
            } else
            {
                Object obj4 = obj;
                obj = obj1;
                obj1 = obj4;
            }
            obj2 = obj1;
            obj1 = obj;
            obj = obj2;
        }
        if (obj1 == null)
        {
            throw new Exception("forwarded extension must contain a packet");
        } else
        {
            return new org.jivesoftware.smackx.forward.a(((a) (obj)), ((org.jivesoftware.smack.packet.e) (obj1)));
        }
    }
}
