// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.delay.provider;

import java.text.ParseException;
import java.util.Date;
import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.provider.e;
import org.jivesoftware.smack.util.XmppDateTime;
import org.jivesoftware.smackx.delay.a.b;
import org.xmlpull.v1.XmlPullParser;

public class DelayInformationProvider
    implements e
{

    public DelayInformationProvider()
    {
    }

    public f a(XmlPullParser xmlpullparser)
    {
        Object obj1 = null;
        Object obj = xmlpullparser.getAttributeValue("", "stamp");
        try
        {
            obj = XmppDateTime.a(((String) (obj)));
        }
        catch (ParseException parseexception)
        {
            if (true)
            {
                parseexception = new Date(0L);
            } else
            {
                parseexception = null;
            }
        }
        obj = new b(((Date) (obj)));
        ((b) (obj)).a(xmlpullparser.getAttributeValue("", "from"));
        xmlpullparser = xmlpullparser.nextText();
        if ("".equals(xmlpullparser))
        {
            xmlpullparser = obj1;
        }
        ((b) (obj)).b(xmlpullparser);
        return ((f) (obj));
    }
}
