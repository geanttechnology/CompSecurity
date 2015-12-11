// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.d;

import com.target.mothership.services.ab;
import com.target.mothership.services.ad;
import com.target.mothership.services.ae;
import com.target.mothership.services.b.a.b.f;
import com.target.mothership.services.v;
import com.target.mothership.util.r;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class d
    implements ae
{

    public d()
    {
    }

    private com.target.mothership.services.b.a.b.d a(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        final com.target.mothership.services.b.a.b.d availableOffer = new com.target.mothership.services.b.a.b.d();
        availableOffer.b(r.a(xmlpullparser, "accessor"));
        availableOffer.a(r.a(xmlpullparser, "assigned"));
        availableOffer.d(r.a(xmlpullparser, "effective"));
        availableOffer.e(r.a(xmlpullparser, "expiration"));
        availableOffer.f(r.a(xmlpullparser, "ident"));
        com.target.mothership.util.r.a a1 = new com.target.mothership.util.r.a() {

            final d this$0;
            final com.target.mothership.services.b.a.b.d val$availableOffer;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                availableOffer.c(r.a(xmlpullparser1));
            }

            
            {
                this$0 = d.this;
                availableOffer = d2;
                super();
            }
        };
        r.b(xmlpullparser, new String[] {
            "details", "description", "text"
        }, a1);
        return availableOffer;
    }

    static List a(d d1, XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return d1.b(xmlpullparser);
    }

    static String b(d d1, XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return d1.c(xmlpullparser);
    }

    private List b(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        final ArrayList availableOffers = new ArrayList();
        r.a(xmlpullparser, "available-offer", new com.target.mothership.util.r.a() {

            final d this$0;
            final List val$availableOffers;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                xmlpullparser1 = d.c(d.this, xmlpullparser1);
                if (xmlpullparser1 != null)
                {
                    availableOffers.add(xmlpullparser1);
                }
            }

            
            {
                this$0 = d.this;
                availableOffers = list;
                super();
            }
        });
        return availableOffers;
    }

    static com.target.mothership.services.b.a.b.d c(d d1, XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return d1.a(xmlpullparser);
    }

    private String c(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return r.a(xmlpullparser, "code");
    }

    public f a(v v1)
    {
        return (f)(new ad()).a(v1.a(), this);
    }

    public com.target.mothership.services.d a(ab ab)
    {
        return b(ab);
    }

    public com.target.mothership.services.d a(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        return b(stringreader, xmlpullparser);
    }

    public volatile Object a(Object obj)
    {
        return a((v)obj);
    }

    public f b(ab ab)
    {
        f f1 = new f();
        f1.a(false);
        f1.a(ab);
        return f1;
    }

    public f b(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        final f response = new f();
        com.target.mothership.util.r.a a1 = new com.target.mothership.util.r.a() {

            final d this$0;
            final f val$response;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR lookupswitch 2: default 32
            //                           -892481550: 71
            //                           784442750: 57;
                   goto _L1 _L2 _L3
_L1:
                break; /* Loop/switch isn't completed */
_L2:
                break MISSING_BLOCK_LABEL_71;
_L4:
                switch (byte0)
                {
                default:
                    return;

                case 0: // '\0'
                    response.a(d.a(d.this, xmlpullparser1));
                    return;

                case 1: // '\001'
                    response.a(d.b(d.this, xmlpullparser1));
                    break;
                }
                break MISSING_BLOCK_LABEL_116;
_L3:
                if (s.equals("gateway-message"))
                {
                    byte0 = 0;
                }
                  goto _L4
                if (s.equals("status"))
                {
                    byte0 = 1;
                }
                  goto _L4
            }

            
            {
                this$0 = d.this;
                response = f1;
                super();
            }
        };
        r.a(xmlpullparser, stringreader, new String[] {
            "gateway-message", "status"
        }, a1);
        response.a(true);
        return response;
    }
}
