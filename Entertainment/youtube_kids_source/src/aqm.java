// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class aqm extends DefaultHandler
{

    private final XmlPullParserFactory a;

    public aqm()
    {
        try
        {
            a = XmlPullParserFactory.newInstance();
            return;
        }
        catch (XmlPullParserException xmlpullparserexception)
        {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", xmlpullparserexception);
        }
    }

    private static int a(int i, int j)
    {
        int k;
        if (i == -1)
        {
            k = j;
        } else
        {
            k = i;
            if (j != -1)
            {
                boolean flag;
                if (i == j)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a.b(flag);
                return i;
            }
        }
        return k;
    }

    private static int a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (a.e(s))
            {
                return 1;
            }
            if (a.f(s))
            {
                return 0;
            }
            if (a.d(s).equals("text") || s.equals("application/ttml+xml"))
            {
                return 2;
            }
        }
        return -1;
    }

    private static int a(XmlPullParser xmlpullparser, String s, int i)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return i;
        } else
        {
            return Integer.parseInt(xmlpullparser);
        }
    }

    private static long a(XmlPullParser xmlpullparser, String s, long l)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return l;
        } else
        {
            return atp.c(xmlpullparser);
        }
    }

    private aqn a(XmlPullParser xmlpullparser, String s, Uri uri, long l)
    {
        Uri uri1;
        String s1;
        ArrayList arraylist;
        long l1;
        s1 = xmlpullparser.getAttributeValue(null, "id");
        l1 = a(xmlpullparser, "start", 0L);
        l = a(xmlpullparser, "duration", l);
        Object obj = null;
        arraylist = new ArrayList();
        uri1 = uri;
        uri = obj;
_L2:
        Uri uri2;
        xmlpullparser.next();
        if (!b(xmlpullparser, "BaseURL"))
        {
            break; /* Loop/switch isn't completed */
        }
        uri2 = b(xmlpullparser, uri1);
_L3:
        uri1 = uri2;
        if (a(xmlpullparser, "Period"))
        {
            return new aqn(s1, l1, l, arraylist);
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (b(xmlpullparser, "AdaptationSet"))
        {
            arraylist.add(a(xmlpullparser, s, uri1, l1, l, ((aqs) (uri))));
            uri2 = uri1;
        } else
        if (b(xmlpullparser, "SegmentBase"))
        {
            uri = a(xmlpullparser, uri1, ((aqx) (null)));
            uri2 = uri1;
        } else
        if (b(xmlpullparser, "SegmentList"))
        {
            uri = a(xmlpullparser, uri1, ((aqu) (null)), l);
            uri2 = uri1;
        } else
        {
            uri2 = uri1;
            if (b(xmlpullparser, "SegmentTemplate"))
            {
                uri = a(xmlpullparser, uri1, ((aqv) (null)), l);
                uri2 = uri1;
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private aqo a(XmlPullParser xmlpullparser, Uri uri)
    {
        return a(xmlpullparser, uri, "sourceURL", "range");
    }

    private aqo a(XmlPullParser xmlpullparser, Uri uri, String s, String s1)
    {
        s = xmlpullparser.getAttributeValue(null, s);
        long l = 0L;
        long l1 = -1L;
        xmlpullparser = xmlpullparser.getAttributeValue(null, s1);
        if (xmlpullparser != null)
        {
            xmlpullparser = xmlpullparser.split("-");
            l = Long.parseLong(xmlpullparser[0]);
            l1 = 1L + (Long.parseLong(xmlpullparser[1]) - l);
        }
        return new aqo(uri, s, l, l1);
    }

    private aqp a(XmlPullParser xmlpullparser, String s, Uri uri, long l, long l1, 
            String s1, String s2, aqs aqs)
    {
        String s3 = xmlpullparser.getAttributeValue(null, "id");
        int j = a(xmlpullparser, "bandwidth", -1);
        int k = a(xmlpullparser, "audioSamplingRate", -1);
        int i1 = a(xmlpullparser, "width", -1);
        int j1 = a(xmlpullparser, "height", -1);
        String s4 = a(xmlpullparser, "mimeType", s1);
        String s5 = a(xmlpullparser, "codecs", ((String) (null)));
        int i = -1;
        s1 = uri;
        uri = aqs;
        do
        {
            xmlpullparser.next();
            if (b(xmlpullparser, "BaseURL"))
            {
                s1 = b(xmlpullparser, s1);
            } else
            if (b(xmlpullparser, "AudioChannelConfiguration"))
            {
                i = Integer.parseInt(xmlpullparser.getAttributeValue(null, "value"));
            } else
            if (b(xmlpullparser, "SegmentBase"))
            {
                uri = a(xmlpullparser, ((Uri) (s1)), (aqx)uri);
            } else
            if (b(xmlpullparser, "SegmentList"))
            {
                uri = a(xmlpullparser, ((Uri) (s1)), (aqu)uri, l1);
            } else
            if (b(xmlpullparser, "SegmentTemplate"))
            {
                uri = a(xmlpullparser, ((Uri) (s1)), (aqv)uri, l1);
            }
        } while (!a(xmlpullparser, "Representation"));
        xmlpullparser = new app(s3, s4, i1, j1, i, k, j, s2, s5);
        if (uri instanceof aqx)
        {
            return new aqr(l, l1, s, -1L, xmlpullparser, (aqx)uri, -1L);
        }
        if (uri instanceof aqt)
        {
            return new aqq(l, l1, s, -1L, xmlpullparser, (aqt)uri);
        } else
        {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    private aqu a(XmlPullParser xmlpullparser, Uri uri, aqu aqu1, long l)
    {
        Object obj;
        List list;
        aqo aqo1;
        Object obj1;
        aqo aqo2;
        List list1;
        int i;
        long l1;
        long l2;
        long l3;
        if (aqu1 != null)
        {
            l1 = aqu1.b;
        } else
        {
            l1 = 1L;
        }
        l2 = b(xmlpullparser, "timescale", l1);
        if (aqu1 != null)
        {
            l1 = aqu1.c;
        } else
        {
            l1 = 0L;
        }
        l3 = b(xmlpullparser, "presentationTimeOffset", l1);
        if (aqu1 != null)
        {
            l1 = aqu1.e;
        } else
        {
            l1 = -1L;
        }
        l1 = b(xmlpullparser, "duration", l1);
        if (aqu1 != null)
        {
            i = aqu1.d;
        } else
        {
            i = 1;
        }
        i = a(xmlpullparser, "startNumber", i);
        aqo2 = null;
        list1 = null;
        obj1 = null;
_L3:
        xmlpullparser.next();
        if (!b(xmlpullparser, "Initialization")) goto _L2; else goto _L1
_L1:
        aqo1 = a(xmlpullparser, uri);
        list = list1;
        obj = obj1;
_L4:
        obj1 = obj;
        list1 = list;
        aqo2 = aqo1;
        if (a(xmlpullparser, "SegmentList"))
        {
            if (aqu1 != null)
            {
                if (aqo1 == null)
                {
                    aqo1 = aqu1.a;
                }
                if (list != null)
                {
                    xmlpullparser = list;
                } else
                {
                    xmlpullparser = aqu1.f;
                }
                if (obj == null)
                {
                    obj = aqu1.g;
                }
            } else
            {
                xmlpullparser = list;
            }
            return new aqu(aqo1, l2, l3, l, i, l1, xmlpullparser, ((List) (obj)));
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (b(xmlpullparser, "SegmentTimeline"))
        {
            list = c(xmlpullparser);
            obj = obj1;
            aqo1 = aqo2;
        } else
        {
            obj = obj1;
            list = list1;
            aqo1 = aqo2;
            if (b(xmlpullparser, "SegmentURL"))
            {
                obj = obj1;
                if (obj1 == null)
                {
                    obj = new ArrayList();
                }
                ((List) (obj)).add(a(xmlpullparser, uri, "media", "mediaRange"));
                list = list1;
                aqo1 = aqo2;
            }
        }
          goto _L4
    }

    private aqv a(XmlPullParser xmlpullparser, Uri uri, aqv aqv1, long l)
    {
        Object obj;
        aqo aqo1;
        aqo aqo2;
        Object obj1;
        aqy aqy1;
        aqy aqy2;
        int i;
        long l1;
        long l2;
        long l3;
        if (aqv1 != null)
        {
            l1 = aqv1.b;
        } else
        {
            l1 = 1L;
        }
        l2 = b(xmlpullparser, "timescale", l1);
        if (aqv1 != null)
        {
            l1 = aqv1.c;
        } else
        {
            l1 = 0L;
        }
        l3 = b(xmlpullparser, "presentationTimeOffset", l1);
        if (aqv1 != null)
        {
            l1 = aqv1.e;
        } else
        {
            l1 = -1L;
        }
        l1 = b(xmlpullparser, "duration", l1);
        if (aqv1 != null)
        {
            i = aqv1.d;
        } else
        {
            i = 1;
        }
        i = a(xmlpullparser, "startNumber", i);
        if (aqv1 != null)
        {
            obj = aqv1.h;
        } else
        {
            obj = null;
        }
        aqy1 = a(xmlpullparser, "media", ((aqy) (obj)));
        if (aqv1 != null)
        {
            obj = aqv1.g;
        } else
        {
            obj = null;
        }
        aqy2 = a(xmlpullparser, "initialization", ((aqy) (obj)));
        aqo2 = null;
        obj1 = null;
_L3:
        xmlpullparser.next();
        if (!b(xmlpullparser, "Initialization")) goto _L2; else goto _L1
_L1:
        aqo1 = a(xmlpullparser, uri);
        obj = obj1;
_L4:
        obj1 = obj;
        aqo2 = aqo1;
        if (a(xmlpullparser, "SegmentTemplate"))
        {
            if (aqv1 != null)
            {
                if (aqo1 == null)
                {
                    aqo1 = aqv1.a;
                }
                if (obj == null)
                {
                    obj = aqv1.f;
                }
                xmlpullparser = ((XmlPullParser) (obj));
            } else
            {
                xmlpullparser = ((XmlPullParser) (obj));
            }
            return new aqv(aqo1, l2, l3, l, i, l1, xmlpullparser, aqy2, aqy1, uri);
        }
        if (true) goto _L3; else goto _L2
_L2:
        obj = obj1;
        aqo1 = aqo2;
        if (b(xmlpullparser, "SegmentTimeline"))
        {
            obj = c(xmlpullparser);
            aqo1 = aqo2;
        }
          goto _L4
    }

    private aqx a(XmlPullParser xmlpullparser, Uri uri, aqx aqx1)
    {
        String s;
        long l;
        long l1;
        long l2;
        long l3;
        if (aqx1 != null)
        {
            l = aqx1.b;
        } else
        {
            l = 1L;
        }
        l2 = b(xmlpullparser, "timescale", l);
        if (aqx1 != null)
        {
            l = aqx1.c;
        } else
        {
            l = 0L;
        }
        l3 = b(xmlpullparser, "presentationTimeOffset", l);
        if (aqx1 != null)
        {
            l = aqx1.e;
        } else
        {
            l = 0L;
        }
        if (aqx1 != null)
        {
            l1 = aqx1.f;
        } else
        {
            l1 = -1L;
        }
        s = xmlpullparser.getAttributeValue(null, "indexRange");
        if (s != null)
        {
            String as[] = s.split("-");
            l = Long.parseLong(as[0]);
            l1 = (Long.parseLong(as[1]) - l) + 1L;
        }
        if (aqx1 != null)
        {
            aqx1 = aqx1.a;
        } else
        {
            aqx1 = null;
        }
        do
        {
            xmlpullparser.next();
            if (b(xmlpullparser, "Initialization"))
            {
                aqx1 = a(xmlpullparser, uri);
            }
        } while (!a(xmlpullparser, "SegmentBase"));
        return new aqx(aqx1, l2, l3, uri, l, l1);
    }

    private static aqy a(XmlPullParser xmlpullparser, String s, aqy aqy1)
    {
        String s1 = xmlpullparser.getAttributeValue(null, s);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        String as[];
        int ai[];
        String as1[];
        int k;
        as = new String[5];
        ai = new int[4];
        as1 = new String[4];
        as[0] = "";
        k = 0;
_L4:
        for (int i = 0; i < s1.length();)
        {
            int l = s1.indexOf("$", i);
            if (l == -1)
            {
                xmlpullparser = String.valueOf(as[k]);
                s = String.valueOf(s1.substring(i));
                if (s.length() != 0)
                {
                    xmlpullparser = xmlpullparser.concat(s);
                } else
                {
                    xmlpullparser = new String(xmlpullparser);
                }
                as[k] = xmlpullparser;
                i = s1.length();
            } else
            if (l != i)
            {
                xmlpullparser = String.valueOf(as[k]);
                s = String.valueOf(s1.substring(i, l));
                if (s.length() != 0)
                {
                    xmlpullparser = xmlpullparser.concat(s);
                } else
                {
                    xmlpullparser = new String(xmlpullparser);
                }
                as[k] = xmlpullparser;
                i = l;
            } else
            if (s1.startsWith("$$", i))
            {
                as[k] = String.valueOf(as[k]).concat("$");
                i += 2;
            } else
            {
                int i1 = s1.indexOf("$", i + 1);
                aqy1 = s1.substring(i + 1, i1);
                if (aqy1.equals("RepresentationID"))
                {
                    ai[k] = 1;
                } else
                {
                    int j = aqy1.indexOf("%0");
                    xmlpullparser = "%01d";
                    s = aqy1;
                    if (j != -1)
                    {
                        s = aqy1.substring(j);
                        xmlpullparser = s;
                        if (!s.endsWith("d"))
                        {
                            xmlpullparser = String.valueOf(s).concat("d");
                        }
                        s = aqy1.substring(0, j);
                    }
                    if (s.equals("Number"))
                    {
                        ai[k] = 2;
                    } else
                    if (s.equals("Bandwidth"))
                    {
                        ai[k] = 3;
                    } else
                    if (s.equals("Time"))
                    {
                        ai[k] = 4;
                    } else
                    {
                        xmlpullparser = String.valueOf(s1);
                        if (xmlpullparser.length() != 0)
                        {
                            xmlpullparser = "Invalid template: ".concat(xmlpullparser);
                        } else
                        {
                            xmlpullparser = new String("Invalid template: ");
                        }
                        throw new IllegalArgumentException(xmlpullparser);
                    }
                    as1[k] = xmlpullparser;
                }
                k++;
                as[k] = "";
                i = i1 + 1;
            }
        }

        aqy1 = new aqy(as, ai, as1, k);
_L2:
        return aqy1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String a(XmlPullParser xmlpullparser, String s, String s1)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return s1;
        } else
        {
            return xmlpullparser;
        }
    }

    public static boolean a(XmlPullParser xmlpullparser, String s)
    {
        return xmlpullparser.getEventType() == 3 && s.equals(xmlpullparser.getName());
    }

    private static long b(XmlPullParser xmlpullparser, String s, long l)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return l;
        } else
        {
            return Long.parseLong(xmlpullparser);
        }
    }

    private static Uri b(XmlPullParser xmlpullparser, Uri uri)
    {
        xmlpullparser.next();
        String s = xmlpullparser.getText();
        Uri uri1 = Uri.parse(s);
        xmlpullparser = uri1;
        if (!uri1.isAbsolute())
        {
            xmlpullparser = Uri.withAppendedPath(uri, s);
        }
        return xmlpullparser;
    }

    public static boolean b(XmlPullParser xmlpullparser, String s)
    {
        return xmlpullparser.getEventType() == 2 && s.equals(xmlpullparser.getName());
    }

    private List c(XmlPullParser xmlpullparser)
    {
        ArrayList arraylist = new ArrayList();
        long l = 0L;
        do
        {
            xmlpullparser.next();
            long l1 = l;
            if (b(xmlpullparser, "S"))
            {
                l = b(xmlpullparser, "t", l);
                long l2 = b(xmlpullparser, "d", -1L);
                int j = a(xmlpullparser, "r", 0);
                int i = 0;
                do
                {
                    l1 = l;
                    if (i >= j + 1)
                    {
                        break;
                    }
                    arraylist.add(new aqw(l, l2));
                    i++;
                    l += l2;
                } while (true);
            }
            l = l1;
        } while (!a(xmlpullparser, "SegmentTimeline"));
        return arraylist;
    }

    public aqj a(int i, int j, List list, List list1)
    {
        return new aqj(i, j, list, list1);
    }

    public aqj a(XmlPullParser xmlpullparser, String s, Uri uri, long l, long l1, 
            aqs aqs)
    {
        Uri uri1;
        String s2;
        String s3;
        ArrayList arraylist;
        int i;
        int j;
        s2 = xmlpullparser.getAttributeValue(null, "mimeType");
        s3 = xmlpullparser.getAttributeValue(null, "lang");
        j = a(s2);
        i = -1;
        Object obj = null;
        arraylist = new ArrayList();
        uri1 = uri;
        uri = obj;
_L2:
        xmlpullparser.next();
        if (!b(xmlpullparser, "BaseURL"))
        {
            break; /* Loop/switch isn't completed */
        }
        uri1 = b(xmlpullparser, uri1);
_L3:
        if (a(xmlpullparser, "AdaptationSet"))
        {
            return a(i, j, ((List) (arraylist)), ((List) (uri)));
        }
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            if (!b(xmlpullparser, "ContentProtection"))
            {
                break label0;
            }
            if (uri == null)
            {
                uri = new ArrayList();
            }
            uri.add(a(xmlpullparser));
        }
          goto _L3
label1:
        {
            if (!b(xmlpullparser, "ContentComponent"))
            {
                break MISSING_BLOCK_LABEL_246;
            }
            int k = Integer.parseInt(xmlpullparser.getAttributeValue(null, "id"));
            String s1 = xmlpullparser.getAttributeValue(null, "contentType");
            if (TextUtils.isEmpty(s1))
            {
                break label1;
            }
            if ("audio".equals(s1))
            {
                i = 1;
            } else
            if ("video".equals(s1))
            {
                i = 0;
            } else
            {
                if (!"text".equals(s1))
                {
                    break label1;
                }
                i = 2;
            }
        }
_L4:
        j = a(j, i);
        i = k;
          goto _L3
        i = -1;
          goto _L4
        if (b(xmlpullparser, "Representation"))
        {
            aqp aqp1 = a(xmlpullparser, s, uri1, l, l1, s2, s3, aqs);
            j = a(j, a(aqp1.b.b));
            arraylist.add(aqp1);
        } else
        if (b(xmlpullparser, "SegmentBase"))
        {
            aqs = a(xmlpullparser, uri1, (aqx)aqs);
        } else
        if (b(xmlpullparser, "SegmentList"))
        {
            aqs = a(xmlpullparser, uri1, (aqu)aqs, l1);
        } else
        if (b(xmlpullparser, "SegmentTemplate"))
        {
            aqs = a(xmlpullparser, uri1, (aqv)aqs, l1);
        } else
        {
            boolean flag;
            if (xmlpullparser.getEventType() == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                b(xmlpullparser);
            }
        }
          goto _L3
    }

    public aqk a(XmlPullParser xmlpullparser)
    {
        return new aqk(xmlpullparser.getAttributeValue(null, "schemeIdUri"), null, null);
    }

    public final aql a(InputStream inputstream, String s, String s1, Uri uri)
    {
        Object obj;
        XmlPullParser xmlpullparser;
        ArrayList arraylist;
        long l1;
        long l2;
        long l3;
        boolean flag;
        long l;
        long l4;
        try
        {
            xmlpullparser = a.newPullParser();
            xmlpullparser.setInput(inputstream, s);
            if (xmlpullparser.next() != 2 || !"MPD".equals(xmlpullparser.getName()))
            {
                throw new aop("inputStream does not contain a valid media presentation description");
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new aop(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new aop(inputstream);
        }
        s = null;
        inputstream = xmlpullparser.getAttributeValue(null, "availabilityStartTime");
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        l = -1L;
_L11:
        l3 = a(xmlpullparser, "mediaPresentationDuration", -1L);
        l4 = a(xmlpullparser, "minBufferTime", -1L);
        inputstream = xmlpullparser.getAttributeValue(null, "type");
        if (inputstream == null) goto _L4; else goto _L3
_L3:
        flag = inputstream.equals("dynamic");
_L14:
        if (!flag) goto _L6; else goto _L5
_L5:
        l1 = a(xmlpullparser, "minimumUpdatePeriod", -1L);
_L15:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_380;
        }
        l2 = a(xmlpullparser, "timeShiftBufferDepth", -1L);
_L16:
        inputstream = null;
        arraylist = new ArrayList();
_L10:
        xmlpullparser.next();
        if (!b(xmlpullparser, "BaseURL")) goto _L8; else goto _L7
_L7:
        uri = b(xmlpullparser, s);
        obj = inputstream;
_L12:
        s = uri;
        inputstream = ((InputStream) (obj));
        if (!a(xmlpullparser, "MPD")) goto _L10; else goto _L9
_L9:
        return new aql(l, l3, l4, flag, l1, l2, ((aqz) (obj)), arraylist);
_L2:
        l = atp.d(inputstream);
          goto _L11
_L8:
        if (!b(xmlpullparser, "UTCTiming"))
        {
            break MISSING_BLOCK_LABEL_323;
        }
        obj = new aqz(xmlpullparser.getAttributeValue(null, "schemeIdUri"), xmlpullparser.getAttributeValue(null, "value"));
        uri = s;
          goto _L12
        uri = s;
        obj = inputstream;
        if (!b(xmlpullparser, "Period")) goto _L12; else goto _L13
_L13:
        arraylist.add(a(xmlpullparser, s1, ((Uri) (s)), l3));
        uri = s;
        obj = inputstream;
          goto _L12
_L4:
        flag = false;
          goto _L14
_L6:
        l1 = -1L;
          goto _L15
        l2 = -1L;
          goto _L16
    }

    public void b(XmlPullParser xmlpullparser)
    {
    }
}
