// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.d;

import com.target.mothership.services.ab;
import com.target.mothership.services.ad;
import com.target.mothership.services.ae;
import com.target.mothership.services.b.a.b.j;
import com.target.mothership.services.d;
import com.target.mothership.services.v;
import com.target.mothership.util.o;
import com.target.mothership.util.r;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g
    implements ae
{

    private static final String CODE = "code";
    private static final String GATEWAY_MESSAGE = "gateway-message";
    private static final String GATEWAY_MESSAGE_TYPE = "type";
    private static final String KEY = "key";
    private static final String RESPONSE_APP_ACCESS_KEY = "response-app-access-key";
    private static final String STATUS = "status";
    private static final String mNameSpace = null;

    public g()
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
        if ("response-app-access-key".equalsIgnoreCase(xmlpullparser.getAttributeValue(mNameSpace, "type"))) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (xmlpullparser.next() == 3) goto _L1; else goto _L3
_L3:
        if (xmlpullparser.getEventType() != 2) goto _L2; else goto _L4
_L4:
        String s = xmlpullparser.getName();
        if (!o.g(s) || !s.equals("key"))
        {
            break MISSING_BLOCK_LABEL_112;
        }
        xmlpullparser.next();
        if (xmlpullparser.getEventType() != 4) goto _L2; else goto _L5
_L5:
        xmlpullparser = xmlpullparser.getText();
        if (o.g(xmlpullparser))
        {
            return xmlpullparser.trim();
        }
          goto _L1
        r.b(xmlpullparser);
          goto _L2
    }

    public j a(v v1)
    {
        return (j)(new ad()).a(v1.a(), this);
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

    public j b(ab ab)
    {
        j j1 = new j();
        j1.a(false);
        j1.a(ab);
        return j1;
    }

    public j b(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        j j1 = new j();
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
                    j1.a(a(xmlpullparser));
                } else
                if (stringreader.equals("gateway-message"))
                {
                    j1.b(b(xmlpullparser));
                } else
                {
                    r.b(xmlpullparser);
                }
            }
        } while (true);
        j1.a(true);
        return j1;
    }

}
