// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.d;

import com.target.mothership.services.ab;
import com.target.mothership.services.ad;
import com.target.mothership.services.ae;
import com.target.mothership.services.d;
import com.target.mothership.services.v;
import com.target.mothership.util.o;
import com.target.mothership.util.r;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
    implements ae
{

    private static final String ASSIGNMENT = "assignment";
    private static final String CODE = "code";
    private static final String GATEWAY_MESSAGE = "gateway-message";
    private static final String GATEWAY_MESSAGE_TYPE = "type";
    private static final String RESPONSE_APP_OFFER_ASSIGNMENT = "response-app-offer-assignment";
    private static final String STATE = "state";
    private static final String STATUS = "status";
    private static final String mNameSpace = null;

    public a()
    {
    }

    private String a(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, mNameSpace, "status");
        return xmlpullparser.getAttributeValue(mNameSpace, "code");
    }

    private String b(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, mNameSpace, "gateway-message");
        if ("response-app-offer-assignment".equalsIgnoreCase(xmlpullparser.getAttributeValue(mNameSpace, "type")))
        {
            while (xmlpullparser.next() != 3) 
            {
                if (xmlpullparser.getEventType() == 2)
                {
                    String s = xmlpullparser.getName();
                    if (o.g(s) && s.equals("assignment"))
                    {
                        return xmlpullparser.getAttributeValue(mNameSpace, "state");
                    }
                    r.b(xmlpullparser);
                }
            }
        }
        return null;
    }

    public com.target.mothership.services.b.a.b.a a(v v1)
    {
        return (com.target.mothership.services.b.a.b.a)(new ad()).a(v1.a(), this);
    }

    public d a(ab ab)
    {
        return b(ab);
    }

    public d a(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        return b(stringreader, xmlpullparser);
    }

    public volatile Object a(Object obj)
    {
        return a((v)obj);
    }

    public com.target.mothership.services.b.a.b.a b(ab ab)
    {
        com.target.mothership.services.b.a.b.a a1 = new com.target.mothership.services.b.a.b.a();
        a1.a(false);
        a1.a(ab);
        return a1;
    }

    public com.target.mothership.services.b.a.b.a b(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        com.target.mothership.services.b.a.b.a a1 = new com.target.mothership.services.b.a.b.a();
        xmlpullparser.setInput(stringreader);
        xmlpullparser.nextTag();
        do
        {
            if (xmlpullparser.next() == 1)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                stringreader = xmlpullparser.getName();
                if (stringreader.equals("status"))
                {
                    a1.a(a(xmlpullparser));
                } else
                if (stringreader.equals("gateway-message"))
                {
                    a1.b(b(xmlpullparser));
                } else
                {
                    r.b(xmlpullparser);
                }
            }
        } while (true);
        a1.a(true);
        return a1;
    }

}
