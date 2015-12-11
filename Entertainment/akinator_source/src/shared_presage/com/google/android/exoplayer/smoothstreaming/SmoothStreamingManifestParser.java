// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.smoothstreaming;

import android.util.Base64;
import android.util.Pair;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.extractor.mp4.PsshAtomUtil;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.CodecSpecificDataUtil;

// Referenced classes of package shared_presage.com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifest

public class SmoothStreamingManifestParser
    implements shared_presage.com.google.android.exoplayer.upstream.UriLoadable.Parser
{
    public static class MissingFieldException extends ParserException
    {

        public MissingFieldException(String s)
        {
            super((new StringBuilder("Missing required field: ")).append(s).toString());
        }
    }

    private static abstract class a
    {

        private final String a;
        private final String b;
        private final a c;
        private final List d = new LinkedList();

        protected static long a(XmlPullParser xmlpullparser, String s, long l)
        {
            xmlpullparser = xmlpullparser.getAttributeValue(null, s);
            if (xmlpullparser != null)
            {
                try
                {
                    l = Long.parseLong(xmlpullparser);
                }
                // Misplaced declaration of an exception variable
                catch (XmlPullParser xmlpullparser)
                {
                    throw new ParserException(xmlpullparser);
                }
            }
            return l;
        }

        protected static String a(XmlPullParser xmlpullparser, String s)
        {
            xmlpullparser = xmlpullparser.getAttributeValue(null, s);
            if (xmlpullparser != null)
            {
                return xmlpullparser;
            } else
            {
                throw new MissingFieldException(s);
            }
        }

        protected static int b(XmlPullParser xmlpullparser, String s)
        {
            xmlpullparser = xmlpullparser.getAttributeValue(null, s);
            if (xmlpullparser != null)
            {
                int i;
                try
                {
                    i = Integer.parseInt(xmlpullparser);
                }
                // Misplaced declaration of an exception variable
                catch (XmlPullParser xmlpullparser)
                {
                    throw new ParserException(xmlpullparser);
                }
                return i;
            } else
            {
                return -1;
            }
        }

        protected static int c(XmlPullParser xmlpullparser, String s)
        {
            xmlpullparser = xmlpullparser.getAttributeValue(null, s);
            if (xmlpullparser != null)
            {
                int i;
                try
                {
                    i = Integer.parseInt(xmlpullparser);
                }
                // Misplaced declaration of an exception variable
                catch (XmlPullParser xmlpullparser)
                {
                    throw new ParserException(xmlpullparser);
                }
                return i;
            } else
            {
                throw new MissingFieldException(s);
            }
        }

        protected static long d(XmlPullParser xmlpullparser, String s)
        {
            xmlpullparser = xmlpullparser.getAttributeValue(null, s);
            if (xmlpullparser != null)
            {
                long l;
                try
                {
                    l = Long.parseLong(xmlpullparser);
                }
                // Misplaced declaration of an exception variable
                catch (XmlPullParser xmlpullparser)
                {
                    throw new ParserException(xmlpullparser);
                }
                return l;
            } else
            {
                throw new MissingFieldException(s);
            }
        }

        protected abstract Object a();

        protected final Object a(String s)
        {
            a a1 = this;
            do
            {
                for (int i = 0; i < a1.d.size(); i++)
                {
                    Pair pair = (Pair)a1.d.get(i);
                    if (((String)pair.first).equals(s))
                    {
                        return pair.second;
                    }
                }

                if (a1.c == null)
                {
                    return null;
                }
                a1 = a1.c;
            } while (true);
        }

        public final Object a(XmlPullParser xmlpullparser)
        {
            boolean flag;
            int j;
            j = 0;
            flag = false;
_L7:
            xmlpullparser.getEventType();
            JVM INSTR tableswitch 1 4: default 44
        //                       1 371
        //                       2 70
        //                       3 307
        //                       4 265;
               goto _L1 _L2 _L3 _L4 _L5
_L2:
            break MISSING_BLOCK_LABEL_371;
_L3:
            break; /* Loop/switch isn't completed */
_L1:
            int i;
            boolean flag1;
            flag1 = flag;
            i = j;
_L8:
            xmlpullparser.next();
            j = i;
            flag = flag1;
            if (true) goto _L7; else goto _L6
_L6:
            Object obj = xmlpullparser.getName();
            if (b.equals(obj))
            {
                b(xmlpullparser);
                flag1 = true;
                i = j;
            } else
            {
                i = j;
                flag1 = flag;
                if (flag)
                {
                    if (j > 0)
                    {
                        i = j + 1;
                        flag1 = flag;
                    } else
                    if (b(((String) (obj))))
                    {
                        b(xmlpullparser);
                        i = j;
                        flag1 = flag;
                    } else
                    {
                        String s1 = a;
                        if ("QualityLevel".equals(obj))
                        {
                            obj = new e(this, s1);
                        } else
                        if ("Protection".equals(obj))
                        {
                            obj = new b(this, s1);
                        } else
                        if ("StreamIndex".equals(obj))
                        {
                            obj = new d(this, s1);
                        } else
                        {
                            obj = null;
                        }
                        if (obj == null)
                        {
                            i = 1;
                            flag1 = flag;
                        } else
                        {
                            a(((a) (obj)).a(xmlpullparser));
                            i = j;
                            flag1 = flag;
                        }
                    }
                }
            }
              goto _L8
_L5:
            i = j;
            flag1 = flag;
            if (flag)
            {
                i = j;
                flag1 = flag;
                if (j == 0)
                {
                    c(xmlpullparser);
                    i = j;
                    flag1 = flag;
                }
            }
              goto _L8
_L4:
            i = j;
            flag1 = flag;
            if (flag)
            {
label0:
                {
                    if (j <= 0)
                    {
                        break label0;
                    }
                    i = j - 1;
                    flag1 = flag;
                }
            }
              goto _L8
            String s;
            s = xmlpullparser.getName();
            d(xmlpullparser);
            i = j;
            flag1 = flag;
            if (b(s)) goto _L8; else goto _L9
_L9:
            return a();
            return null;
        }

        protected void a(Object obj)
        {
        }

        protected final void a(String s, Object obj)
        {
            d.add(Pair.create(s, obj));
        }

        protected void b(XmlPullParser xmlpullparser)
        {
        }

        protected boolean b(String s)
        {
            return false;
        }

        protected void c(XmlPullParser xmlpullparser)
        {
        }

        protected void d(XmlPullParser xmlpullparser)
        {
        }

        public a(a a1, String s, String s1)
        {
            c = a1;
            a = s;
            b = s1;
        }
    }

    private static final class b extends a
    {

        private boolean a;
        private UUID b;
        private byte c[];

        public final Object a()
        {
            return new SmoothStreamingManifest.ProtectionElement(b, PsshAtomUtil.buildPsshAtom(b, c));
        }

        public final void b(XmlPullParser xmlpullparser)
        {
            if ("ProtectionHeader".equals(xmlpullparser.getName()))
            {
                a = true;
                b = UUID.fromString(xmlpullparser.getAttributeValue(null, "SystemID"));
            }
        }

        public final boolean b(String s)
        {
            return "ProtectionHeader".equals(s);
        }

        public final void c(XmlPullParser xmlpullparser)
        {
            if (a)
            {
                c = Base64.decode(xmlpullparser.getText(), 0);
            }
        }

        public final void d(XmlPullParser xmlpullparser)
        {
            if ("ProtectionHeader".equals(xmlpullparser.getName()))
            {
                a = false;
            }
        }

        public b(a a1, String s)
        {
            super(a1, s, "Protection");
        }
    }

    private static final class c extends a
    {

        private int a;
        private int b;
        private long c;
        private long d;
        private long e;
        private int f;
        private boolean g;
        private SmoothStreamingManifest.ProtectionElement h;
        private List i;

        public final Object a()
        {
            SmoothStreamingManifest.StreamElement astreamelement[] = new SmoothStreamingManifest.StreamElement[i.size()];
            i.toArray(astreamelement);
            return new SmoothStreamingManifest(a, b, c, d, e, f, g, h, astreamelement);
        }

        public final void a(Object obj)
        {
            if (obj instanceof SmoothStreamingManifest.StreamElement)
            {
                i.add((SmoothStreamingManifest.StreamElement)obj);
            } else
            if (obj instanceof SmoothStreamingManifest.ProtectionElement)
            {
                boolean flag;
                if (h == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkState(flag);
                h = (SmoothStreamingManifest.ProtectionElement)obj;
                return;
            }
        }

        public final void b(XmlPullParser xmlpullparser)
        {
            a = c(xmlpullparser, "MajorVersion");
            b = c(xmlpullparser, "MinorVersion");
            c = a(xmlpullparser, "TimeScale", 0x989680L);
            d = d(xmlpullparser, "Duration");
            e = a(xmlpullparser, "DVRWindowLength", 0L);
            f = b(xmlpullparser, "LookaheadCount");
            xmlpullparser = xmlpullparser.getAttributeValue(null, "IsLive");
            boolean flag;
            if (xmlpullparser != null)
            {
                flag = Boolean.parseBoolean(xmlpullparser);
            } else
            {
                flag = false;
            }
            g = flag;
            a("TimeScale", Long.valueOf(c));
        }

        public c(String s)
        {
            super(null, s, "SmoothStreamingMedia");
            f = -1;
            h = null;
            i = new LinkedList();
        }
    }

    private static final class d extends a
    {

        private final String a;
        private final List b = new LinkedList();
        private int c;
        private String d;
        private long e;
        private String f;
        private int g;
        private String h;
        private int i;
        private int j;
        private int k;
        private int l;
        private String m;
        private ArrayList n;
        private long o;

        public final Object a()
        {
            SmoothStreamingManifest.TrackElement atrackelement[] = new SmoothStreamingManifest.TrackElement[b.size()];
            b.toArray(atrackelement);
            return new SmoothStreamingManifest.StreamElement(a, h, c, d, e, f, g, i, j, k, l, m, atrackelement, n, o);
        }

        public final void a(Object obj)
        {
            if (obj instanceof SmoothStreamingManifest.TrackElement)
            {
                b.add((SmoothStreamingManifest.TrackElement)obj);
            }
        }

        public final void b(XmlPullParser xmlpullparser)
        {
label0:
            {
                boolean flag = true;
                if ("c".equals(xmlpullparser.getName()))
                {
                    int i1 = n.size();
                    long l2 = a(xmlpullparser, "t", -1L);
                    long l1 = l2;
                    if (l2 == -1L)
                    {
                        if (i1 == 0)
                        {
                            l1 = 0L;
                        } else
                        if (o != -1L)
                        {
                            l1 = ((Long)n.get(i1 - 1)).longValue() + o;
                        } else
                        {
                            throw new ParserException("Unable to infer start time");
                        }
                    }
                    n.add(Long.valueOf(l1));
                    o = a(xmlpullparser, "d", -1L);
                    l2 = a(xmlpullparser, "r", 1L);
                    i1 = ((flag) ? 1 : 0);
                    if (l2 > 1L)
                    {
                        i1 = ((flag) ? 1 : 0);
                        if (o == -1L)
                        {
                            throw new ParserException("Repeated chunk with unspecified duration");
                        }
                    }
                    for (; (long)i1 < l2; i1++)
                    {
                        n.add(Long.valueOf(o * (long)i1 + l1));
                    }

                } else
                {
                    String s = xmlpullparser.getAttributeValue(null, "Type");
                    if (s == null)
                    {
                        break label0;
                    }
                    int j1;
                    if ("audio".equalsIgnoreCase(s))
                    {
                        j1 = 0;
                    } else
                    if ("video".equalsIgnoreCase(s))
                    {
                        j1 = 1;
                    } else
                    if ("text".equalsIgnoreCase(s))
                    {
                        j1 = 2;
                    } else
                    {
                        throw new ParserException((new StringBuilder("Invalid key value[")).append(s).append("]").toString());
                    }
                    c = j1;
                    a("Type", Integer.valueOf(c));
                    if (c == 2)
                    {
                        d = a(xmlpullparser, "Subtype");
                    } else
                    {
                        d = xmlpullparser.getAttributeValue(null, "Subtype");
                    }
                    f = xmlpullparser.getAttributeValue(null, "Name");
                    g = b(xmlpullparser, "QualityLevels");
                    h = a(xmlpullparser, "Url");
                    i = b(xmlpullparser, "MaxWidth");
                    j = b(xmlpullparser, "MaxHeight");
                    k = b(xmlpullparser, "DisplayWidth");
                    l = b(xmlpullparser, "DisplayHeight");
                    m = xmlpullparser.getAttributeValue(null, "Language");
                    e = b(xmlpullparser, "TimeScale");
                    if (e == -1L)
                    {
                        e = ((Long)a("TimeScale")).longValue();
                    }
                    n = new ArrayList();
                }
                return;
            }
            throw new MissingFieldException("Type");
        }

        public final boolean b(String s)
        {
            return "c".equals(s);
        }

        public d(a a1, String s)
        {
            super(a1, s, "StreamIndex");
            a = s;
        }
    }

    private static final class e extends a
    {

        private final List a = new LinkedList();
        private int b;
        private int c;
        private String d;
        private int e;
        private int f;
        private int g;
        private int h;

        private static String c(String s)
        {
            if (s.equalsIgnoreCase("H264") || s.equalsIgnoreCase("X264") || s.equalsIgnoreCase("AVC1") || s.equalsIgnoreCase("DAVC"))
            {
                return "video/avc";
            }
            if (s.equalsIgnoreCase("AAC") || s.equalsIgnoreCase("AACL") || s.equalsIgnoreCase("AACH") || s.equalsIgnoreCase("AACP"))
            {
                return "audio/mp4a-latm";
            }
            if (s.equalsIgnoreCase("TTML"))
            {
                return "application/ttml+xml";
            } else
            {
                return null;
            }
        }

        public final Object a()
        {
            byte abyte0[][] = null;
            if (!a.isEmpty())
            {
                abyte0 = new byte[a.size()][];
                a.toArray(abyte0);
            }
            return new SmoothStreamingManifest.TrackElement(b, c, d, abyte0, e, f, g, h);
        }

        public final void b(XmlPullParser xmlpullparser)
        {
            boolean flag = false;
            int i = ((Integer)a("Type")).intValue();
            b = b(xmlpullparser, "Index");
            c = c(xmlpullparser, "Bitrate");
            String s;
            if (i == 1)
            {
                f = c(xmlpullparser, "MaxHeight");
                e = c(xmlpullparser, "MaxWidth");
                s = c(a(xmlpullparser, "FourCC"));
            } else
            {
                f = -1;
                e = -1;
                s = xmlpullparser.getAttributeValue(null, "FourCC");
                if (s != null)
                {
                    s = c(s);
                } else
                if (i == 0)
                {
                    s = "audio/mp4a-latm";
                } else
                {
                    s = null;
                }
            }
            d = s;
            if (i == 0)
            {
                g = c(xmlpullparser, "SamplingRate");
                h = c(xmlpullparser, "Channels");
            } else
            {
                g = -1;
                h = -1;
            }
            s = xmlpullparser.getAttributeValue(null, "CodecPrivateData");
            if (s != null && s.length() > 0)
            {
                xmlpullparser = new byte[s.length() / 2];
                for (i = 0; i < xmlpullparser.length; i++)
                {
                    int j = i * 2;
                    int k = Character.digit(s.charAt(j), 16);
                    xmlpullparser[i] = (byte)(Character.digit(s.charAt(j + 1), 16) + (k << 4));
                }

                byte abyte0[][] = CodecSpecificDataUtil.splitNalUnits(xmlpullparser);
                i = ((flag) ? 1 : 0);
                if (abyte0 == null)
                {
                    a.add(xmlpullparser);
                } else
                {
                    while (i < abyte0.length) 
                    {
                        a.add(abyte0[i]);
                        i++;
                    }
                }
            }
        }

        public e(a a1, String s)
        {
            super(a1, s, "QualityLevel");
        }
    }


    private final XmlPullParserFactory xmlParserFactory;

    public SmoothStreamingManifestParser()
    {
        try
        {
            xmlParserFactory = XmlPullParserFactory.newInstance();
            return;
        }
        catch (XmlPullParserException xmlpullparserexception)
        {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", xmlpullparserexception);
        }
    }

    public volatile Object parse(String s, InputStream inputstream)
    {
        return parse(s, inputstream);
    }

    public SmoothStreamingManifest parse(String s, InputStream inputstream)
    {
        try
        {
            XmlPullParser xmlpullparser = xmlParserFactory.newPullParser();
            xmlpullparser.setInput(inputstream, null);
            s = (SmoothStreamingManifest)(new c(s)).a(xmlpullparser);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParserException(s);
        }
        return s;
    }
}
