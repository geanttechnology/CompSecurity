// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.ttml;

import android.util.Log;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package com.google.android.exoplayer.text.ttml:
//            TtmlNode, TtmlSubtitle

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

    private TtmlNode parseNode(XmlPullParser xmlpullparser, TtmlNode ttmlnode)
        throws ParserException
    {
        long l;
        long l5;
        long l6;
        long l7;
        l6 = 0L;
        l = -1L;
        long l1 = -1L;
        int j = xmlpullparser.getAttributeCount();
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
        if (ttmlnode != null)
        {
            l5 = l1;
            l7 = l;
            if (ttmlnode.startTimeUs != -1L)
            {
                long l3 = l;
                if (l != -1L)
                {
                    l3 = l + ttmlnode.startTimeUs;
                }
                l5 = l1;
                l7 = l3;
                if (l1 != -1L)
                {
                    l5 = l1 + ttmlnode.startTimeUs;
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
        return TtmlNode.buildNode(xmlpullparser.getName(), l7, l);
_L4:
        l = l5;
        if (ttmlnode != null)
        {
            l = l5;
            if (ttmlnode.endTimeUs != -1L)
            {
                l = ttmlnode.endTimeUs;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static long parseTimeExpression(String s, int i, int j, int k)
        throws ParserException
    {
        Matcher matcher;
        matcher = CLOCK_TIME.matcher(s);
        if (matcher.matches())
        {
            double d5 = Long.parseLong(matcher.group(1)) * 3600L;
            double d6 = Long.parseLong(matcher.group(2)) * 60L;
            double d7 = Long.parseLong(matcher.group(3));
            s = matcher.group(4);
            double d;
            double d2;
            double d4;
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
            } else
            {
                d4 = 0.0D;
            }
            return (long)(1000000D * (d5 + d6 + d7 + d + d2 + d4));
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
        return (long)(1000000D * d1);
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
        throw new ParserException((new StringBuilder()).append("Malformed time expression: ").append(s).toString());
    }

    public boolean canParse(String s)
    {
        return "application/ttml+xml".equals(s);
    }

    public Subtitle parse(InputStream inputstream, String s, long l)
        throws IOException
    {
        XmlPullParser xmlpullparser;
        LinkedList linkedlist;
        TtmlNode ttmlnode;
        int i;
        int j;
        int k;
        TtmlNode ttmlnode1;
        try
        {
            xmlpullparser = xmlParserFactory.newPullParser();
            xmlpullparser.setInput(inputstream, s);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new ParserException("Unable to parse source", inputstream);
        }
        inputstream = null;
        linkedlist = new LinkedList();
        j = 0;
        k = xmlpullparser.getEventType();
_L11:
        if (k == 1) goto _L2; else goto _L1
_L1:
        ttmlnode = (TtmlNode)linkedlist.peekLast();
        if (j != 0) goto _L4; else goto _L3
_L3:
        s = xmlpullparser.getName();
        if (k != 2) goto _L6; else goto _L5
_L5:
        if (isSupportedTag(s)) goto _L8; else goto _L7
_L7:
        Log.i("TtmlParser", (new StringBuilder()).append("Ignoring unsupported tag: ").append(xmlpullparser.getName()).toString());
        i = j + 1;
        s = inputstream;
_L9:
        xmlpullparser.next();
        k = xmlpullparser.getEventType();
        inputstream = s;
        j = i;
        continue; /* Loop/switch isn't completed */
_L8:
        ttmlnode1 = parseNode(xmlpullparser, ttmlnode);
        linkedlist.addLast(ttmlnode1);
        s = inputstream;
        i = j;
        if (ttmlnode == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ttmlnode.addChild(ttmlnode1);
        s = inputstream;
        i = j;
        continue; /* Loop/switch isn't completed */
        s;
        if (strictParsing)
        {
            throw s;
        }
        Log.e("TtmlParser", "Suppressing parser error", s);
        i = j + 1;
        s = inputstream;
        continue; /* Loop/switch isn't completed */
_L6:
        if (k != 4)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        ttmlnode.addChild(TtmlNode.buildTextNode(xmlpullparser.getText()));
        s = inputstream;
        i = j;
        continue; /* Loop/switch isn't completed */
        s = inputstream;
        i = j;
        if (k != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (xmlpullparser.getName().equals("tt"))
        {
            inputstream = new TtmlSubtitle((TtmlNode)linkedlist.getLast(), l);
        }
        linkedlist.removeLast();
        s = inputstream;
        i = j;
        continue; /* Loop/switch isn't completed */
_L4:
        if (k == 2)
        {
            i = j + 1;
            s = inputstream;
        } else
        {
            s = inputstream;
            i = j;
            if (k == 3)
            {
                i = j - 1;
                s = inputstream;
            }
        }
        if (true) goto _L9; else goto _L2
_L2:
        return inputstream;
        if (true) goto _L11; else goto _L10
_L10:
    }

}
