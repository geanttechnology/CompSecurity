// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import android.util.Pair;
import com.google.android.exoplayer.ParserException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

private static abstract class tag
{

    private final String baseUri;
    private final List normalizedAttributes = new LinkedList();
    private final normalizedAttributes parent;
    private final String tag;

    private tag newChildParser(tag tag1, String s, String s1)
    {
        if ("QualityLevel".equals(s))
        {
            return new rser(tag1, s1);
        }
        if ("Protection".equals(s))
        {
            return new entParser(tag1, s1);
        }
        if ("StreamIndex".equals(s))
        {
            return new arser(tag1, s1);
        } else
        {
            return null;
        }
    }

    protected void addChild(Object obj)
    {
    }

    protected abstract Object build();

    protected final Object getNormalizedAttribute(String s)
    {
        for (int i = 0; i < normalizedAttributes.size(); i++)
        {
            Pair pair = (Pair)normalizedAttributes.get(i);
            if (((String)pair.first).equals(s))
            {
                return pair.second;
            }
        }

        if (parent == null)
        {
            return null;
        } else
        {
            return parent.getNormalizedAttribute(s);
        }
    }

    protected boolean handleChildInline(String s)
    {
        return false;
    }

    public final Object parse(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException, ParserException
    {
        boolean flag;
        int j;
        flag = false;
        j = 0;
_L7:
        xmlpullparser.getEventType();
        JVM INSTR tableswitch 1 4: default 44
    //                   1 295
    //                   2 68
    //                   3 234
    //                   4 195;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_295;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        int i;
        boolean flag1;
        i = j;
        flag1 = flag;
_L8:
        xmlpullparser.next();
        flag = flag1;
        j = i;
        if (true) goto _L7; else goto _L6
_L6:
        Object obj = xmlpullparser.getName();
        if (tag.equals(obj))
        {
            flag1 = true;
            parseStartTag(xmlpullparser);
            i = j;
        } else
        {
            flag1 = flag;
            i = j;
            if (flag)
            {
                if (j > 0)
                {
                    i = j + 1;
                    flag1 = flag;
                } else
                if (handleChildInline(((String) (obj))))
                {
                    parseStartTag(xmlpullparser);
                    flag1 = flag;
                    i = j;
                } else
                {
                    obj = newChildParser(this, ((String) (obj)), baseUri);
                    if (obj == null)
                    {
                        i = 1;
                        flag1 = flag;
                    } else
                    {
                        addChild(((addChild) (obj)).parse(xmlpullparser));
                        flag1 = flag;
                        i = j;
                    }
                }
            }
        }
          goto _L8
_L5:
        flag1 = flag;
        i = j;
        if (flag)
        {
            flag1 = flag;
            i = j;
            if (j == 0)
            {
                parseText(xmlpullparser);
                flag1 = flag;
                i = j;
            }
        }
          goto _L8
_L4:
        flag1 = flag;
        i = j;
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
        parseEndTag(xmlpullparser);
        flag1 = flag;
        i = j;
        if (handleChildInline(s)) goto _L8; else goto _L9
_L9:
        return build();
        return null;
    }

    protected final boolean parseBoolean(XmlPullParser xmlpullparser, String s, boolean flag)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            flag = Boolean.parseBoolean(xmlpullparser);
        }
        return flag;
    }

    protected void parseEndTag(XmlPullParser xmlpullparser)
        throws ParserException
    {
    }

    protected final int parseInt(XmlPullParser xmlpullparser, String s, int i)
        throws ParserException
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            try
            {
                i = Integer.parseInt(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
        }
        return i;
    }

    protected final long parseLong(XmlPullParser xmlpullparser, String s, long l)
        throws ParserException
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

    protected final int parseRequiredInt(XmlPullParser xmlpullparser, String s)
        throws ParserException
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
            throw new ception(s);
        }
    }

    protected final long parseRequiredLong(XmlPullParser xmlpullparser, String s)
        throws ParserException
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
            throw new ception(s);
        }
    }

    protected final String parseRequiredString(XmlPullParser xmlpullparser, String s)
        throws ception
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            return xmlpullparser;
        } else
        {
            throw new ception(s);
        }
    }

    protected void parseStartTag(XmlPullParser xmlpullparser)
        throws ParserException
    {
    }

    protected void parseText(XmlPullParser xmlpullparser)
        throws ParserException
    {
    }

    protected final void putNormalizedAttribute(String s, Object obj)
    {
        normalizedAttributes.add(Pair.create(s, obj));
    }

    public ception(ception ception, String s, String s1)
    {
        parent = ception;
        baseUri = s;
        tag = s1;
    }
}
