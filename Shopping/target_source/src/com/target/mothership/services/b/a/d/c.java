// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.d;

import com.target.mothership.services.ab;
import com.target.mothership.services.ad;
import com.target.mothership.services.ae;
import com.target.mothership.services.b.a.b.e;
import com.target.mothership.services.d;
import com.target.mothership.services.v;
import com.target.mothership.util.o;
import com.target.mothership.util.r;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c
    implements ae
{

    private static final String CONTENT_TYPE_HTML = "text/html";

    public c()
    {
    }

    static List a(c c1, XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return c1.a(xmlpullparser);
    }

    private List a(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        final ArrayList assignedOffers = new ArrayList();
        r.a(xmlpullparser, "assigned-offer", new com.target.mothership.util.r.a() {

            final c this$0;
            final List val$assignedOffers;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                xmlpullparser1 = c.c(c.this, xmlpullparser1);
                if (xmlpullparser1 != null)
                {
                    assignedOffers.add(xmlpullparser1);
                }
            }

            
            {
                this$0 = c.this;
                assignedOffers = list;
                super();
            }
        });
        return assignedOffers;
    }

    static String b(c c1, XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return c1.f(xmlpullparser);
    }

    private String b(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        final StringBuilder descriptionBuilder = new StringBuilder();
        com.target.mothership.util.r.a a1 = new com.target.mothership.util.r.a() {

            final c this$0;
            final StringBuilder val$descriptionBuilder;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                descriptionBuilder.append(r.a(xmlpullparser1));
            }

            
            {
                this$0 = c.this;
                descriptionBuilder = stringbuilder;
                super();
            }
        };
        r.b(xmlpullparser, new String[] {
            "description", "text"
        }, a1);
        return descriptionBuilder.toString();
    }

    static com.target.mothership.services.b.a.b.c c(c c1, XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return c1.d(xmlpullparser);
    }

    private String c(XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        final StringBuilder barcodeValueBuilder = new StringBuilder();
        com.target.mothership.util.r.a a1 = new com.target.mothership.util.r.a() {

            final c this$0;
            final StringBuilder val$barcodeValueBuilder;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                barcodeValueBuilder.append(r.a(xmlpullparser1));
            }

            
            {
                this$0 = c.this;
                barcodeValueBuilder = stringbuilder;
                super();
            }
        };
        r.b(xmlpullparser, new String[] {
            "code", "text"
        }, a1);
        return barcodeValueBuilder.toString();
    }

    private com.target.mothership.services.b.a.b.c d(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        final com.target.mothership.services.b.a.b.c offer = new com.target.mothership.services.b.a.b.c();
        offer.d(r.a(xmlpullparser, "effective"));
        offer.e(r.a(xmlpullparser, "expiration"));
        offer.f(r.a(xmlpullparser, "ident"));
        com.target.mothership.util.r.a a1 = new com.target.mothership.util.r.a() {

            final c this$0;
            final com.target.mothership.services.b.a.b.c val$offer;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR lookupswitch 4: default 48
            //                           -1221270899: 95
            //                           -341064690: 109
            //                           1557721666: 81
            //                           2061494827: 123;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                byte0;
                JVM INSTR tableswitch 0 3: default 80
            //                           0 137
            //                           1 153
            //                           2 169
            //                           3 194;
                   goto _L6 _L7 _L8 _L9 _L10
_L6:
                return;
_L4:
                if (s.equals("details"))
                {
                    byte0 = 0;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (s.equals("header"))
                {
                    byte0 = 1;
                }
                continue; /* Loop/switch isn't completed */
_L3:
                if (s.equals("resource"))
                {
                    byte0 = 2;
                }
                continue; /* Loop/switch isn't completed */
_L5:
                if (s.equals("redemption"))
                {
                    byte0 = 3;
                }
                continue; /* Loop/switch isn't completed */
_L7:
                offer.c(com.target.mothership.services.b.a.d.c.d(c.this, xmlpullparser1));
                return;
_L8:
                offer.c(com.target.mothership.services.b.a.d.c.d(c.this, xmlpullparser1));
                return;
_L9:
                xmlpullparser1 = com.target.mothership.services.b.a.d.c.e(c.this, xmlpullparser1);
                if (o.g(xmlpullparser1))
                {
                    offer.a(xmlpullparser1);
                    return;
                }
                  goto _L6
_L10:
                offer.b(c.f(c.this, xmlpullparser1));
                return;
                if (true) goto _L1; else goto _L11
_L11:
            }

            
            {
                this$0 = c.this;
                offer = c2;
                super();
            }
        };
        r.a(xmlpullparser, new String[] {
            "details", "header", "resource", "redemption"
        }, a1);
        return offer;
    }

    static String d(c c1, XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return c1.b(xmlpullparser);
    }

    static String e(c c1, XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return c1.e(xmlpullparser);
    }

    private String e(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        final StringBuilder uriBuilder = new StringBuilder();
        final StringBuilder contentTypeBuilder = new StringBuilder();
        com.target.mothership.util.r.a a1 = new com.target.mothership.util.r.a() {

            final c this$0;
            final StringBuilder val$contentTypeBuilder;
            final StringBuilder val$uriBuilder;

            public void a(XmlPullParser xmlpullparser1, String s)
                throws IOException, XmlPullParserException
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR lookupswitch 2: default 32
            //                           116076: 71
            //                           785670158: 57;
                   goto _L1 _L2 _L3
_L1:
                byte0;
                JVM INSTR tableswitch 0 1: default 56
            //                           0 85
            //                           1 109;
                   goto _L4 _L5 _L6
_L4:
                return;
_L3:
                if (s.equals("content-type"))
                {
                    byte0 = 0;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (s.equals("uri"))
                {
                    byte0 = 1;
                }
                continue; /* Loop/switch isn't completed */
_L5:
                if ("text/html".equalsIgnoreCase(xmlpullparser1 = r.a(xmlpullparser1)))
                {
                    contentTypeBuilder.append(xmlpullparser1);
                    return;
                }
                  goto _L4
_L6:
                uriBuilder.append(r.a(xmlpullparser1));
                return;
                if (true) goto _L1; else goto _L7
_L7:
            }

            
            {
                this$0 = c.this;
                contentTypeBuilder = stringbuilder;
                uriBuilder = stringbuilder1;
                super();
            }
        };
        r.a(xmlpullparser, new String[] {
            "uri", "content-type"
        }, a1);
        if (!o.g(contentTypeBuilder.toString()))
        {
            return null;
        } else
        {
            return uriBuilder.toString();
        }
    }

    static String f(c c1, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        return c1.c(xmlpullparser);
    }

    private String f(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        return r.a(xmlpullparser, "code");
    }

    public e a(v v1)
    {
        return (e)(new ad()).a(v1.a(), this);
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

    public e b(ab ab)
    {
        e e1 = new e();
        e1.a(false);
        e1.a(ab);
        return e1;
    }

    public e b(StringReader stringreader, XmlPullParser xmlpullparser)
        throws IOException, XmlPullParserException
    {
        final e response = new e();
        com.target.mothership.util.r.a a1 = new com.target.mothership.util.r.a() {

            final c this$0;
            final e val$response;

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
                    response.a(c.a(c.this, xmlpullparser1));
                    return;

                case 1: // '\001'
                    response.a(c.b(c.this, xmlpullparser1));
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
                this$0 = c.this;
                response = e1;
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
