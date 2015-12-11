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

public class b
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

    public b()
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

    public com.target.mothership.services.b.a.b.b a(v v1)
    {
        return (com.target.mothership.services.b.a.b.b)(new ad()).a(v1.a(), this);
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

    public com.target.mothership.services.b.a.b.b b(ab ab)
    {
        com.target.mothership.services.b.a.b.b b1 = new com.target.mothership.services.b.a.b.b();
        b1.a(false);
        b1.a(ab);
        return b1;
    }

    public com.target.mothership.services.b.a.b.b b(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        com.target.mothership.services.b.a.b.b b1 = new com.target.mothership.services.b.a.b.b();
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
                    b1.a(a(xmlpullparser));
                } else
                if (stringreader.equals("gateway-message"))
                {
                    b1.b(b(xmlpullparser));
                } else
                {
                    r.b(xmlpullparser);
                }
            }
        } while (true);
        b1.a(true);
        return b1;
    }

}
