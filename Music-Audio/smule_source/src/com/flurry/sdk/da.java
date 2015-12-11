// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Xml;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.flurry.sdk:
//            cy, hp, gd, db, 
//            dc, cz, fu, dd, 
//            de, df, dg, di, 
//            dm, dj, dk, dl

public class da
{

    private static final String a = null;
    private static a b;

    public static cy a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        a(a.a);
        StringReader stringreader = new StringReader(s);
        Object obj = stringreader;
        Object obj1 = Xml.newPullParser();
        obj = stringreader;
        ((XmlPullParser) (obj1)).setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        obj = stringreader;
        ((XmlPullParser) (obj1)).setInput(stringreader);
        obj = stringreader;
        ((XmlPullParser) (obj1)).nextTag();
        obj = stringreader;
        cy cy1 = a(((XmlPullParser) (obj1)), new cy.a(), ((List) (new ArrayList())));
        obj1 = cy1;
        if (cy1 == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj1 = cy1;
        obj = stringreader;
        if (!cy1.c())
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj1 = cy1;
        obj = stringreader;
        if (cy1.f() != null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj = stringreader;
        obj1 = (new cy.a()).a().b();
        hp.a(stringreader);
        s = ((String) (obj1));
_L3:
        return s;
        Exception exception;
        exception;
        obj1 = null;
_L7:
        obj = obj1;
        if (!a().equals(a.d)) goto _L2; else goto _L1
_L1:
        obj = obj1;
        gd.a(3, "VASTXmlParser", (new StringBuilder()).append("Error parsing VAST XML: ").append(s).toString(), exception);
        obj = obj1;
        s = (new cy.a()).a().b();
_L4:
        hp.a(((java.io.Closeable) (obj1)));
          goto _L3
_L2:
        obj = obj1;
        gd.a(3, "VASTXmlParser", "Not a VAST Ad");
        s = null;
          goto _L4
        s;
        obj = null;
_L6:
        hp.a(((java.io.Closeable) (obj)));
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        obj1 = stringreader;
          goto _L7
    }

    private static cy a(XmlPullParser xmlpullparser, cy.a a1, List list)
    {
        xmlpullparser.require(2, a, "VAST");
        a(a.b);
        int i = c(xmlpullparser);
        if (a(i))
        {
            a1.a(i);
            do
            {
                if (xmlpullparser.next() == 3)
                {
                    break;
                }
                if (xmlpullparser.getEventType() == 2)
                {
                    if (xmlpullparser.getName().equals("Ad"))
                    {
                        list.add(a(xmlpullparser, new dg.a()));
                    } else
                    {
                        b(xmlpullparser);
                    }
                }
            } while (true);
        } else
        {
            a(a.d);
            throw new IllegalArgumentException();
        }
        a1.a(list);
        a1.a(a(list));
        if (!a(list))
        {
            a(a.a);
        } else
        {
            a(a.c);
        }
        return a1.b();
    }

    private static a a()
    {
        return b;
    }

    private static dg a(XmlPullParser xmlpullparser, dg.a a1)
    {
        Object obj;
        byte byte0;
        xmlpullparser.require(2, a, "Ad");
        a1.a(xmlpullparser.getAttributeValue(a, "id"));
        try
        {
            String s = xmlpullparser.getAttributeValue(a, "sequence");
            if (!TextUtils.isEmpty(s))
            {
                a1.a(Integer.parseInt(s));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            gd.a(3, "VASTXmlParser", "Could not identify Ad Sequence");
        }
_L6:
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break MISSING_BLOCK_LABEL_274;
            }
        } while (xmlpullparser.getEventType() != 2);
        obj = xmlpullparser.getName();
        byte0 = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 2: default 116
    //                   -2101083431: 159
    //                   -1034806157: 173;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_173;
_L4:
        switch (byte0)
        {
        default:
            b(xmlpullparser);
            break;

        case 0: // '\0'
            a1.a(a(xmlpullparser, new di.a(), new dh.a(), ((List) (new ArrayList())), ((List) (new ArrayList()))));
            break;

        case 1: // '\001'
            a1.a(a(xmlpullparser, new di.a(), new dh.a(), ((List) (new ArrayList())), ((List) (new ArrayList())), ((List) (new ArrayList()))));
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (((String) (obj)).equals("InLine"))
        {
            byte0 = 0;
        }
          goto _L4
        if (((String) (obj)).equals("Wrapper"))
        {
            byte0 = 1;
        }
          goto _L4
        return a1.a();
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static di a(XmlPullParser xmlpullparser, di.a a1, dh.a a2, List list, List list1)
    {
        a1.a(db.b);
        xmlpullparser.require(2, a, "InLine");
_L9:
        String s;
        byte byte0;
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break MISSING_BLOCK_LABEL_323;
            }
        } while (xmlpullparser.getEventType() != 2);
        s = xmlpullparser.getName();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 108
    //                   -1692490108: 151
    //                   -1633884078: 167
    //                   67232232: 215
    //                   501930965: 183
    //                   2114088489: 199;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_215;
_L7:
        switch (byte0)
        {
        default:
            b(xmlpullparser);
            break;

        case 0: // '\0'
            a1.d(a(xmlpullparser, ((List) (new ArrayList()))));
            break;

        case 1: // '\001'
            a2.a(xmlpullparser.getAttributeValue(a, "version"));
            a2.b(a(xmlpullparser));
            a1.a(a2.a());
            break;

        case 2: // '\002'
            a1.a(a(xmlpullparser));
            break;

        case 3: // '\003'
            a(list, a(xmlpullparser));
            break;

        case 4: // '\004'
            a(list1, a(xmlpullparser));
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("Creatives"))
        {
            byte0 = 0;
        }
          goto _L7
_L3:
        if (s.equals("AdSystem"))
        {
            byte0 = 1;
        }
          goto _L7
_L5:
        if (s.equals("AdTitle"))
        {
            byte0 = 2;
        }
          goto _L7
_L6:
        if (s.equals("Impression"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s.equals("Error"))
        {
            byte0 = 4;
        }
          goto _L7
        a1.b(list);
        a1.c(list1);
        return a1.a();
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static di a(XmlPullParser xmlpullparser, di.a a1, dh.a a2, List list, List list1, List list2)
    {
        a1.a(db.c);
        xmlpullparser.require(2, a, "Wrapper");
_L9:
        String s;
        byte byte0;
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break MISSING_BLOCK_LABEL_324;
            }
        } while (xmlpullparser.getEventType() != 2);
        s = xmlpullparser.getName();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 108
    //                   -1692490108: 151
    //                   -1633884078: 167
    //                   -587420703: 183
    //                   67232232: 216
    //                   2114088489: 200;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_216;
_L7:
        switch (byte0)
        {
        default:
            b(xmlpullparser);
            break;

        case 0: // '\0'
            a1.d(a(xmlpullparser, ((List) (new ArrayList()))));
            break;

        case 1: // '\001'
            a2.a(xmlpullparser.getAttributeValue(a, "version"));
            a2.b(a(xmlpullparser));
            a1.a(a2.a());
            break;

        case 2: // '\002'
            a(list, a(xmlpullparser));
            break;

        case 3: // '\003'
            a(list1, a(xmlpullparser));
            break;

        case 4: // '\004'
            a(list2, a(xmlpullparser));
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("Creatives"))
        {
            byte0 = 0;
        }
          goto _L7
_L3:
        if (s.equals("AdSystem"))
        {
            byte0 = 1;
        }
          goto _L7
_L4:
        if (s.equals("VASTAdTagURI"))
        {
            byte0 = 2;
        }
          goto _L7
_L6:
        if (s.equals("Impression"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s.equals("Error"))
        {
            byte0 = 4;
        }
          goto _L7
        a1.a(list);
        a1.b(list1);
        a1.c(list2);
        return a1.a();
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static dj a(XmlPullParser xmlpullparser, dj.a a1)
    {
        xmlpullparser.require(2, a, "Creative");
        a1.a(xmlpullparser.getAttributeValue(a, "id"));
        String s = xmlpullparser.getAttributeValue(a, "sequence");
        if (s != null)
        {
            try
            {
                a1.a(Math.round(Float.parseFloat(s)));
            }
            catch (NumberFormatException numberformatexception)
            {
                gd.a(3, "VASTXmlParser", "Could not identify Creative sequence");
            }
        }
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("Linear"))
                {
                    a1.a(dc.b);
                    a1.a(a(xmlpullparser, new dk.a()));
                } else
                {
                    b(xmlpullparser);
                }
            }
        } while (true);
        return a1.a();
    }

    private static dk a(XmlPullParser xmlpullparser, dk.a a1)
    {
        xmlpullparser.require(2, a, "Linear");
        String s = xmlpullparser.getAttributeValue(a, "skipoffset");
        if (s != null)
        {
            a1.b(cz.a(s));
        }
_L8:
        String s1;
        byte byte0;
        if (xmlpullparser.next() == 3)
        {
            break; /* Loop/switch isn't completed */
        }
        if (xmlpullparser.getEventType() != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = xmlpullparser.getName();
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 116
    //                   -2049897434: 185
    //                   -1927368268: 155
    //                   -385055469: 200
    //                   611554000: 170;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_200;
_L6:
        switch (byte0)
        {
        default:
            b(xmlpullparser);
            break;

        case 0: // '\0'
            a1.a(cz.a(a(xmlpullparser)));
            break;

        case 1: // '\001'
            a1.a(b(xmlpullparser, new fu()));
            break;

        case 2: // '\002'
            a1.b(a(xmlpullparser, new fu()));
            break;

        case 3: // '\003'
            dl dl = cz.a(b(xmlpullparser, new ArrayList()));
            if (dl != null)
            {
                a1.a(dl);
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s1.equals("Duration"))
        {
            byte0 = 0;
        }
          goto _L6
_L5:
        if (s1.equals("TrackingEvents"))
        {
            byte0 = 1;
        }
          goto _L6
_L2:
        if (s1.equals("VideoClicks"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s1.equals("MediaFiles"))
        {
            byte0 = 3;
        }
          goto _L6
        if (true) goto _L8; else goto _L7
_L7:
        return a1.a();
    }

    private static dl a(XmlPullParser xmlpullparser, dl.a a1)
    {
        xmlpullparser.require(2, a, "MediaFile");
        a1.a(xmlpullparser.getAttributeValue(a, "id"));
        a1.d(xmlpullparser.getAttributeValue(a, "type"));
        a1.b(xmlpullparser.getAttributeValue(a, "apiFramework"));
        a1.a(dd.a(xmlpullparser.getAttributeValue(a, "delivery")));
        try
        {
            a1.b(Integer.parseInt(xmlpullparser.getAttributeValue(a, "height")));
        }
        catch (NumberFormatException numberformatexception)
        {
            gd.a(3, "VASTXmlParser", "Could not identify MediaFile height");
        }
        try
        {
            a1.c(Integer.parseInt(xmlpullparser.getAttributeValue(a, "width")));
        }
        catch (NumberFormatException numberformatexception1)
        {
            gd.a(3, "VASTXmlParser", "Could not identify MediaFile width");
        }
        try
        {
            a1.a(Integer.parseInt(xmlpullparser.getAttributeValue(a, "bitrate")));
        }
        catch (NumberFormatException numberformatexception2)
        {
            gd.a(3, "VASTXmlParser", "Could not identify MediaFile bitRate");
        }
        a1.b(Boolean.parseBoolean(xmlpullparser.getAttributeValue(a, "scalable")));
        a1.a(Boolean.parseBoolean(xmlpullparser.getAttributeValue(a, "maintainAspectRatio")));
        a1.c(a(xmlpullparser));
        return a1.a();
    }

    private static dm a(XmlPullParser xmlpullparser, dm.a a1)
    {
        xmlpullparser.require(2, a, "Tracking");
        a1.a(de.a(xmlpullparser.getAttributeValue(a, "event")));
        a1.a(a(xmlpullparser));
        return a1.a();
    }

    private static fu a(XmlPullParser xmlpullparser, fu fu1)
    {
        xmlpullparser.require(2, a, "VideoClicks");
_L4:
        if (xmlpullparser.next() == 3) goto _L2; else goto _L1
_L1:
        if (xmlpullparser.getEventType() != 2) goto _L4; else goto _L3
_L3:
        String s;
        byte byte0;
        s = xmlpullparser.getName();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 80
    //                   -617879491: 115
    //                   -135761801: 145
    //                   2107600959: 130;
           goto _L5 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_145;
_L9:
        switch (byte0)
        {
        default:
            b(xmlpullparser);
            break;

        case 0: // '\0'
            fu1.a(df.b, a(xmlpullparser));
            break;

        case 1: // '\001'
            fu1.a(df.c, a(xmlpullparser));
            break;

        case 2: // '\002'
            fu1.a(df.d, a(xmlpullparser));
            break;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s.equals("ClickThrough"))
        {
            byte0 = 0;
        }
          goto _L9
_L8:
        if (s.equals("ClickTracking"))
        {
            byte0 = 1;
        }
          goto _L9
        if (s.equals("CustomClick"))
        {
            byte0 = 2;
        }
          goto _L9
_L2:
        return fu1;
        if (true) goto _L4; else goto _L10
_L10:
    }

    private static String a(XmlPullParser xmlpullparser)
    {
        String s = null;
        if (xmlpullparser.next() == 4)
        {
            s = xmlpullparser.getText().trim();
            xmlpullparser.nextTag();
        }
        return s;
    }

    private static List a(XmlPullParser xmlpullparser, List list)
    {
        xmlpullparser.require(2, a, "Creatives");
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("Creative"))
                {
                    list.add(a(xmlpullparser, new dj.a()));
                } else
                {
                    b(xmlpullparser);
                }
            }
        } while (true);
        return list;
    }

    private static void a(a a1)
    {
        gd.a(3, "VASTXmlParser", (new StringBuilder()).append("Setting VAST parse state as: ").append(a1.name()).toString());
        b = a1;
    }

    private static void a(List list, String s)
    {
        while (list == null || TextUtils.isEmpty(s)) 
        {
            return;
        }
        list.add(s);
    }

    private static boolean a(int i)
    {
        return i >= 1 && i <= 3;
    }

    public static boolean a(List list)
    {
        if (list == null || list.isEmpty())
        {
            return false;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            di di1 = ((dg)list.next()).c();
            if (di1 == null || !db.b.equals(di1.a()))
            {
                return false;
            }
        }

        return true;
    }

    private static fu b(XmlPullParser xmlpullparser, fu fu1)
    {
        xmlpullparser.require(2, a, "TrackingEvents");
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("Tracking"))
                {
                    dm dm1 = a(xmlpullparser, new dm.a());
                    if (!TextUtils.isEmpty(dm1.b()))
                    {
                        fu1.a(dm1.a(), dm1.b());
                    }
                } else
                {
                    b(xmlpullparser);
                }
            }
        } while (true);
        return fu1;
    }

    private static List b(XmlPullParser xmlpullparser, List list)
    {
        xmlpullparser.require(2, a, "MediaFiles");
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("MediaFile"))
                {
                    list.add(a(xmlpullparser, new dl.a()));
                } else
                {
                    b(xmlpullparser);
                }
            }
        } while (true);
        return list;
    }

    private static void b(XmlPullParser xmlpullparser)
    {
        if (xmlpullparser.getEventType() != 2)
        {
            throw new IllegalStateException();
        }
        int i = 1;
        do
        {
            if (i == 0)
            {
                break;
            }
            switch (xmlpullparser.next())
            {
            case 2: // '\002'
                i++;
                break;

            case 3: // '\003'
                i--;
                break;
            }
        } while (true);
    }

    private static int c(XmlPullParser xmlpullparser)
    {
        int j = 0x80000000;
        xmlpullparser = xmlpullparser.getAttributeValue(a, "version");
        gd.a(3, "VASTXmlParser", (new StringBuilder()).append("Version").append(xmlpullparser).toString());
        int i = j;
        if (!TextUtils.isEmpty(xmlpullparser))
        {
            xmlpullparser = xmlpullparser.split("\\.");
            i = j;
            if (xmlpullparser.length > 0)
            {
                i = j;
                if (!TextUtils.isEmpty(xmlpullparser[0]))
                {
                    try
                    {
                        i = Integer.parseInt(xmlpullparser[0]);
                    }
                    catch (NumberFormatException numberformatexception)
                    {
                        gd.a(3, "VASTXmlParser", (new StringBuilder()).append("Could not detect VAST version ").append(xmlpullparser[0]).toString());
                        return 0x80000000;
                    }
                }
            }
        }
        return i;
    }

    static 
    {
        b = a.a;
    }

    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/flurry/sdk/da$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("PARSING_UNKNOWN", 0);
            b = new a("PARSING_STARTED", 1);
            c = new a("PARSING_COMPLETE", 2);
            d = new a("PARSING_ERROR", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

}
