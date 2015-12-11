// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text.ttml;

import android.util.Log;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.text.Subtitle;
import shared_presage.com.google.android.exoplayer.text.SubtitleParser;

// Referenced classes of package shared_presage.com.google.android.exoplayer.text.ttml:
//            a, TtmlSubtitle

public final class TtmlParser
    implements SubtitleParser
{

    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final int DEFAULT_FRAMERATE = 30;
    private static final int DEFAULT_SUBFRAMERATE = 1;
    private static final int DEFAULT_TICKRATE = 1;
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final String TAG = "TtmlParser";
    private final boolean strictParsing;
    private final XmlPullParserFactory xmlParserFactory;

    public TtmlParser()
    {
        this(false);
    }

    public TtmlParser(boolean flag)
    {
        strictParsing = flag;
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

    private static boolean isSupportedTag(String s)
    {
        return s.equals("tt") || s.equals("head") || s.equals("body") || s.equals("div") || s.equals("p") || s.equals("span") || s.equals("br") || s.equals("style") || s.equals("styling") || s.equals("layout") || s.equals("region") || s.equals("metadata") || s.equals("smpte:image") || s.equals("smpte:data") || s.equals("smpte:information");
    }

    private a parseNode(XmlPullParser xmlpullparser, a a1)
    {
        long l;
        long l5;
        long l6;
        long l7;
        int j = xmlpullparser.getAttributeCount();
        long l1 = -1L;
        l = -1L;
        l6 = 0L;
        int i = 0;
        while (i < j) 
        {
            String s = xmlpullparser.getAttributeName(i).replaceFirst("^.*:", "");
            String s1 = xmlpullparser.getAttributeValue(i);
            long l2;
            long l4;
            if (s.equals("begin"))
            {
                l4 = parseTimeExpression(s1, 30, 1, 1);
                l2 = l1;
            } else
            if (s.equals("end"))
            {
                l2 = parseTimeExpression(s1, 30, 1, 1);
                l4 = l;
            } else
            {
                l2 = l1;
                l4 = l;
                if (s.equals("dur"))
                {
                    l6 = parseTimeExpression(s1, 30, 1, 1);
                    l2 = l1;
                    l4 = l;
                }
            }
            i++;
            l1 = l2;
            l = l4;
        }
        l5 = l1;
        l7 = l;
        if (a1 != null)
        {
            l5 = l1;
            l7 = l;
            if (a1.d != -1L)
            {
                long l3 = l;
                if (l != -1L)
                {
                    l3 = l + a1.d;
                }
                l5 = l1;
                l7 = l3;
                if (l1 != -1L)
                {
                    l5 = l1 + a1.d;
                    l7 = l3;
                }
            }
        }
        l = l5;
        if (l5 != -1L) goto _L2; else goto _L1
_L1:
        if (l6 <= 0L) goto _L4; else goto _L3
_L3:
        l = l7 + l6;
_L2:
        return a.a(xmlpullparser.getName(), l7, l);
_L4:
        l = l5;
        if (a1 != null)
        {
            l = l5;
            if (a1.e != -1L)
            {
                l = a1.e;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static long parseTimeExpression(String s, int i, int j, int k)
    {
        Matcher matcher;
        double d4 = 0.0D;
        matcher = CLOCK_TIME.matcher(s);
        if (matcher.matches())
        {
            double d5 = Long.parseLong(matcher.group(1)) * 3600L;
            double d6 = Long.parseLong(matcher.group(2)) * 60L;
            double d7 = Long.parseLong(matcher.group(3));
            s = matcher.group(4);
            double d;
            double d2;
            if (s != null)
            {
                d = Double.parseDouble(s);
            } else
            {
                d = 0.0D;
            }
            s = matcher.group(5);
            if (s != null)
            {
                d2 = (double)Long.parseLong(s) / (double)i;
            } else
            {
                d2 = 0.0D;
            }
            s = matcher.group(6);
            if (s != null)
            {
                d4 = (double)Long.parseLong(s) / (double)j / (double)i;
            }
            return (long)((d2 + (d7 + (d5 + d6) + d) + d4) * 1000000D);
        }
        matcher = OFFSET_TIME.matcher(s);
        if (!matcher.matches()) goto _L2; else goto _L1
_L1:
        double d3;
        d3 = Double.parseDouble(matcher.group(1));
        s = matcher.group(2);
        if (!s.equals("h")) goto _L4; else goto _L3
_L3:
        double d1 = d3 * 3600D;
_L5:
        return (long)(d1 * 1000000D);
_L4:
        if (s.equals("m"))
        {
            d1 = d3 * 60D;
        } else
        {
            d1 = d3;
            if (!s.equals("s"))
            {
                if (s.equals("ms"))
                {
                    d1 = d3 / 1000D;
                } else
                if (s.equals("f"))
                {
                    d1 = d3 / (double)i;
                } else
                {
                    d1 = d3;
                    if (s.equals("t"))
                    {
                        d1 = d3 / (double)k;
                    }
                }
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
        throw new ParserException((new StringBuilder("Malformed time expression: ")).append(s).toString());
    }

    public final boolean canParse(String s)
    {
        return "application/ttml+xml".equals(s);
    }

    public final Subtitle parse(InputStream inputstream, String s, long l)
    {
        XmlPullParser xmlpullparser;
        Object obj;
        int i;
        int j;
        Object obj1;
        try
        {
            xmlpullparser = xmlParserFactory.newPullParser();
            xmlpullparser.setInput(inputstream, s);
            s = new LinkedList();
            j = xmlpullparser.getEventType();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new ParserException("Unable to parse source", inputstream);
        }
        i = 0;
        inputstream = null;
        if (j == 1)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        obj = (a)s.peekLast();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        obj1 = xmlpullparser.getName();
        if (j != 2) goto _L2; else goto _L1
_L1:
        if (isSupportedTag(((String) (obj1)))) goto _L4; else goto _L3
_L3:
        Log.i("TtmlParser", (new StringBuilder("Ignoring unsupported tag: ")).append(xmlpullparser.getName()).toString());
        i++;
_L6:
        xmlpullparser.next();
        j = xmlpullparser.getEventType();
        break MISSING_BLOCK_LABEL_40;
_L4:
        obj1 = parseNode(xmlpullparser, ((a) (obj)));
        s.addLast(obj1);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((a) (obj)).a(((a) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj;
        if (strictParsing)
        {
            throw obj;
        }
        Log.e("TtmlParser", "Suppressing parser error", ((Throwable) (obj)));
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (j != 4)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        ((a) (obj)).a(a.a(xmlpullparser.getText()));
        continue; /* Loop/switch isn't completed */
        if (j != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (xmlpullparser.getName().equals("tt"))
        {
            inputstream = new TtmlSubtitle((a)s.getLast(), l);
        }
        s.removeLast();
        continue; /* Loop/switch isn't completed */
        if (j == 2)
        {
            i++;
        } else
        if (j == 3)
        {
            i--;
        }
        if (true) goto _L6; else goto _L5
_L5:
        return inputstream;
    }

}
