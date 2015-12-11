// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.d;

import com.target.mothership.services.ab;
import com.target.mothership.services.ad;
import com.target.mothership.services.ae;
import com.target.mothership.services.b.a.b.h;
import com.target.mothership.services.d;
import com.target.mothership.services.v;
import com.target.mothership.util.r;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class e
    implements ae
{

    private static final String CODE = "code";
    private static final String STATUS = "status";
    private static final String mNameSpace = null;

    public e()
    {
    }

    private String a(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, mNameSpace, "status");
        return xmlpullparser.getAttributeValue(mNameSpace, "code");
    }

    public h a(v v1)
    {
        return (h)(new ad()).a(v1.a(), this);
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

    public h b(ab ab)
    {
        h h1 = new h();
        h1.a(false);
        h1.a(ab);
        return h1;
    }

    public h b(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        h h1 = new h();
        xmlpullparser.setInput(stringreader);
        xmlpullparser.nextTag();
        do
        {
label0:
            {
                if (xmlpullparser.next() != 1)
                {
                    if (xmlpullparser.getEventType() != 2)
                    {
                        continue;
                    }
                    if (!xmlpullparser.getName().equals("status"))
                    {
                        break label0;
                    }
                    h1.a(a(xmlpullparser));
                }
                h1.a(true);
                return h1;
            }
            r.b(xmlpullparser);
        } while (true);
    }

}
