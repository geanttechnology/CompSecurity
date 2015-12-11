// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.d;

import com.target.mothership.services.ab;
import com.target.mothership.services.ad;
import com.target.mothership.services.ae;
import com.target.mothership.services.b.a.b.i;
import com.target.mothership.services.d;
import com.target.mothership.services.v;
import com.target.mothership.util.r;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f
    implements ae
{

    private static final String CODE = "code";
    private static final String STATUS = "status";
    private static final String mNameSpace = null;

    public f()
    {
    }

    private String a(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, mNameSpace, "status");
        return xmlpullparser.getAttributeValue(mNameSpace, "code");
    }

    public i a(v v1)
    {
        return (i)(new ad()).a(v1.a(), this);
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

    public i b(ab ab)
    {
        i j = new i();
        j.a(false);
        j.a(ab);
        return j;
    }

    public i b(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        i j = new i();
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
                    j.a(a(xmlpullparser));
                }
                j.a(true);
                return j;
            }
            r.b(xmlpullparser);
        } while (true);
    }

}
