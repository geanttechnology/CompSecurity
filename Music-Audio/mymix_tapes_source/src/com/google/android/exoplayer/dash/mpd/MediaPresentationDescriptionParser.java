// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.UriUtil;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            AdaptationSet, ContentProtection, MediaPresentationDescription, Period, 
//            RangedUri, Representation, UtcTimingElement, UrlTemplate, 
//            SegmentBase

public class MediaPresentationDescriptionParser extends DefaultHandler
    implements com.google.android.exoplayer.upstream.UriLoadable.Parser
{
    protected static final class ContentProtectionsBuilder
        implements Comparator
    {

        private ArrayList adaptationSetProtections;
        private ArrayList currentRepresentationProtections;
        private ArrayList representationProtections;
        private boolean representationProtectionsSet;

        private void maybeAddContentProtection(List list, ContentProtection contentprotection)
        {
            if (!list.contains(contentprotection))
            {
                int i = 0;
                while (i < list.size()) 
                {
                    boolean flag;
                    if (!((ContentProtection)list.get(i)).schemeUriId.equals(contentprotection.schemeUriId))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    Assertions.checkState(flag);
                    i++;
                }
                list.add(contentprotection);
            }
        }

        public void addAdaptationSetProtection(ContentProtection contentprotection)
        {
            if (adaptationSetProtections == null)
            {
                adaptationSetProtections = new ArrayList();
            }
            maybeAddContentProtection(adaptationSetProtections, contentprotection);
        }

        public void addRepresentationProtection(ContentProtection contentprotection)
        {
            if (currentRepresentationProtections == null)
            {
                currentRepresentationProtections = new ArrayList();
            }
            maybeAddContentProtection(currentRepresentationProtections, contentprotection);
        }

        public ArrayList build()
        {
            if (adaptationSetProtections == null)
            {
                return representationProtections;
            }
            if (representationProtections == null)
            {
                return adaptationSetProtections;
            }
            for (int i = 0; i < representationProtections.size(); i++)
            {
                maybeAddContentProtection(adaptationSetProtections, (ContentProtection)representationProtections.get(i));
            }

            return adaptationSetProtections;
        }

        public int compare(ContentProtection contentprotection, ContentProtection contentprotection1)
        {
            return contentprotection.schemeUriId.compareTo(contentprotection1.schemeUriId);
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((ContentProtection)obj, (ContentProtection)obj1);
        }

        public void endRepresentation()
        {
            boolean flag = true;
            if (!representationProtectionsSet)
            {
                if (currentRepresentationProtections != null)
                {
                    Collections.sort(currentRepresentationProtections, this);
                }
                representationProtections = currentRepresentationProtections;
                representationProtectionsSet = true;
            } else
            if (currentRepresentationProtections == null)
            {
                if (representationProtections != null)
                {
                    flag = false;
                }
                Assertions.checkState(flag);
            } else
            {
                Collections.sort(currentRepresentationProtections, this);
                Assertions.checkState(currentRepresentationProtections.equals(representationProtections));
            }
            currentRepresentationProtections = null;
        }

        protected ContentProtectionsBuilder()
        {
        }
    }


    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private final String contentId;
    private final XmlPullParserFactory xmlParserFactory;

    public MediaPresentationDescriptionParser()
    {
        this(null);
    }

    public MediaPresentationDescriptionParser(String s)
    {
        contentId = s;
        try
        {
            xmlParserFactory = XmlPullParserFactory.newInstance();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", s);
        }
    }

    private static int checkAdaptationSetTypeConsistency(int i, int j)
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
                Assertions.checkState(flag);
                return i;
            }
        }
        return k;
    }

    private static String checkLanguageConsistency(String s, String s1)
    {
        String s2;
        if (s == null)
        {
            s2 = s1;
        } else
        {
            s2 = s;
            if (s1 != null)
            {
                Assertions.checkState(s.equals(s1));
                return s;
            }
        }
        return s2;
    }

    protected static boolean isEndTag(XmlPullParser xmlpullparser, String s)
        throws XmlPullParserException
    {
        return xmlpullparser.getEventType() == 3 && s.equals(xmlpullparser.getName());
    }

    protected static boolean isStartTag(XmlPullParser xmlpullparser)
        throws XmlPullParserException
    {
        return xmlpullparser.getEventType() == 2;
    }

    protected static boolean isStartTag(XmlPullParser xmlpullparser, String s)
        throws XmlPullParserException
    {
        return xmlpullparser.getEventType() == 2 && s.equals(xmlpullparser.getName());
    }

    protected static String parseBaseUrl(XmlPullParser xmlpullparser, String s)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.next();
        return UriUtil.resolve(s, xmlpullparser.getText());
    }

    protected static long parseDateTime(XmlPullParser xmlpullparser, String s, long l)
        throws ParseException
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return l;
        } else
        {
            return Util.parseXsDateTime(xmlpullparser);
        }
    }

    protected static long parseDuration(XmlPullParser xmlpullparser, String s, long l)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser == null)
        {
            return l;
        } else
        {
            return Util.parseXsDuration(xmlpullparser);
        }
    }

    protected static int parseInt(XmlPullParser xmlpullparser, String s)
    {
        return parseInt(xmlpullparser, s, -1);
    }

    protected static int parseInt(XmlPullParser xmlpullparser, String s, int i)
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

    protected static long parseLong(XmlPullParser xmlpullparser, String s)
    {
        return parseLong(xmlpullparser, s, -1L);
    }

    protected static long parseLong(XmlPullParser xmlpullparser, String s, long l)
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

    protected static String parseString(XmlPullParser xmlpullparser, String s, String s1)
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

    protected AdaptationSet buildAdaptationSet(int i, int j, List list, List list1)
    {
        return new AdaptationSet(i, j, list, list1);
    }

    protected ContentProtection buildContentProtection(String s, UUID uuid, byte abyte0[])
    {
        return new ContentProtection(s, uuid, abyte0);
    }

    protected Format buildFormat(String s, String s1, int i, int j, float f, int k, int l, 
            int i1, String s2, String s3)
    {
        return new Format(s, s1, i, j, f, k, l, i1, s2, s3);
    }

    protected MediaPresentationDescription buildMediaPresentationDescription(long l, long l1, long l2, boolean flag, 
            long l3, long l4, UtcTimingElement utctimingelement, String s, List list)
    {
        return new MediaPresentationDescription(l, l1, l2, flag, l3, l4, utctimingelement, s, list);
    }

    protected Period buildPeriod(String s, long l, long l1, List list)
    {
        return new Period(s, l, l1, list);
    }

    protected RangedUri buildRangedUri(String s, String s1, long l, long l1)
    {
        return new RangedUri(s, s1, l, l1);
    }

    protected Representation buildRepresentation(long l, long l1, String s, int i, Format format, 
            SegmentBase segmentbase)
    {
        return Representation.newInstance(l, l1, s, i, format, segmentbase);
    }

    protected SegmentBase.SegmentList buildSegmentList(RangedUri rangeduri, long l, long l1, long l2, 
            int i, long l3, List list, List list1)
    {
        return new SegmentBase.SegmentList(rangeduri, l, l1, l2, i, l3, list, list1);
    }

    protected SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangeduri, long l, long l1, long l2, 
            int i, long l3, List list, UrlTemplate urltemplate, UrlTemplate urltemplate1, String s)
    {
        return new SegmentBase.SegmentTemplate(rangeduri, l, l1, l2, i, l3, list, urltemplate, urltemplate1, s);
    }

    protected SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long l, long l1)
    {
        return new SegmentBase.SegmentTimelineElement(l, l1);
    }

    protected SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangeduri, long l, long l1, String s, long l2, long l3)
    {
        return new SegmentBase.SingleSegmentBase(rangeduri, l, l1, s, l2, l3);
    }

    protected UtcTimingElement buildUtcTimingElement(String s, String s1)
    {
        return new UtcTimingElement(s, s1);
    }

    public MediaPresentationDescription parse(String s, InputStream inputstream)
        throws IOException, ParserException
    {
        XmlPullParser xmlpullparser;
        try
        {
            xmlpullparser = xmlParserFactory.newPullParser();
            xmlpullparser.setInput(inputstream, null);
            if (xmlpullparser.next() != 2 || !"MPD".equals(xmlpullparser.getName()))
            {
                throw new ParserException("inputStream does not contain a valid media presentation description");
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParserException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParserException(s);
        }
        s = parseMediaPresentationDescription(xmlpullparser, s);
        return s;
    }

    public volatile Object parse(String s, InputStream inputstream)
        throws ParserException, IOException
    {
        return parse(s, inputstream);
    }

    protected AdaptationSet parseAdaptationSet(XmlPullParser xmlpullparser, String s, long l, long l1, SegmentBase segmentbase)
        throws XmlPullParserException, IOException
    {
        String s1;
        Object obj;
        String s3;
        ContentProtectionsBuilder contentprotectionsbuilder;
        ArrayList arraylist;
        int k;
        int i1;
        i1 = parseInt(xmlpullparser, "id", -1);
        s3 = xmlpullparser.getAttributeValue(null, "mimeType");
        s1 = xmlpullparser.getAttributeValue(null, "lang");
        k = parseAdaptationSetType(xmlpullparser.getAttributeValue(null, "contentType"));
        int i = k;
        if (k == -1)
        {
            i = parseAdaptationSetTypeFromMimeType(xmlpullparser.getAttributeValue(null, "mimeType"));
        }
        contentprotectionsbuilder = new ContentProtectionsBuilder();
        arraylist = new ArrayList();
        obj = segmentbase;
        segmentbase = s;
        k = i;
_L2:
        String s2;
        Object obj1;
        int j;
        xmlpullparser.next();
        if (!isStartTag(xmlpullparser, "BaseURL"))
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = parseBaseUrl(xmlpullparser, segmentbase);
        s = ((String) (obj));
        j = k;
        s2 = s1;
_L3:
        s1 = s2;
        k = j;
        segmentbase = ((SegmentBase) (obj1));
        obj = s;
        if (isEndTag(xmlpullparser, "AdaptationSet"))
        {
            return buildAdaptationSet(i1, j, arraylist, contentprotectionsbuilder.build());
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (isStartTag(xmlpullparser, "ContentProtection"))
        {
            contentprotectionsbuilder.addAdaptationSetProtection(parseContentProtection(xmlpullparser));
            s2 = s1;
            j = k;
            obj1 = segmentbase;
            s = ((String) (obj));
        } else
        if (isStartTag(xmlpullparser, "ContentComponent"))
        {
            s2 = checkLanguageConsistency(s1, xmlpullparser.getAttributeValue(null, "lang"));
            j = checkAdaptationSetTypeConsistency(k, parseAdaptationSetType(xmlpullparser.getAttributeValue(null, "contentType")));
            obj1 = segmentbase;
            s = ((String) (obj));
        } else
        if (isStartTag(xmlpullparser, "Representation"))
        {
            s = parseRepresentation(xmlpullparser, segmentbase, l, l1, s3, s1, ((SegmentBase) (obj)), contentprotectionsbuilder);
            contentprotectionsbuilder.endRepresentation();
            j = checkAdaptationSetTypeConsistency(k, parseAdaptationSetTypeFromMimeType(((Representation) (s)).format.mimeType));
            arraylist.add(s);
            s2 = s1;
            obj1 = segmentbase;
            s = ((String) (obj));
        } else
        if (isStartTag(xmlpullparser, "SegmentBase"))
        {
            s = parseSegmentBase(xmlpullparser, segmentbase, (SegmentBase.SingleSegmentBase)obj);
            s2 = s1;
            j = k;
            obj1 = segmentbase;
        } else
        if (isStartTag(xmlpullparser, "SegmentList"))
        {
            s = parseSegmentList(xmlpullparser, segmentbase, (SegmentBase.SegmentList)obj, l1);
            s2 = s1;
            j = k;
            obj1 = segmentbase;
        } else
        if (isStartTag(xmlpullparser, "SegmentTemplate"))
        {
            s = parseSegmentTemplate(xmlpullparser, segmentbase, (SegmentBase.SegmentTemplate)obj, l1);
            s2 = s1;
            j = k;
            obj1 = segmentbase;
        } else
        {
            s2 = s1;
            j = k;
            obj1 = segmentbase;
            s = ((String) (obj));
            if (isStartTag(xmlpullparser))
            {
                parseAdaptationSetChild(xmlpullparser);
                s2 = s1;
                j = k;
                obj1 = segmentbase;
                s = ((String) (obj));
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    protected void parseAdaptationSetChild(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
    }

    protected int parseAdaptationSetType(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if ("audio".equals(s))
            {
                return 1;
            }
            if ("video".equals(s))
            {
                return 0;
            }
            if ("text".equals(s))
            {
                return 2;
            }
        }
        return -1;
    }

    protected int parseAdaptationSetTypeFromMimeType(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (MimeTypes.isAudio(s))
            {
                return 1;
            }
            if (MimeTypes.isVideo(s))
            {
                return 0;
            }
            if (MimeTypes.isText(s) || MimeTypes.isTtml(s))
            {
                return 2;
            }
        }
        return -1;
    }

    protected ContentProtection parseContentProtection(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        String s = xmlpullparser.getAttributeValue(null, "schemeIdUri");
        UUID uuid = null;
        byte abyte1[] = null;
        byte abyte0[];
        UUID uuid1;
        do
        {
            xmlpullparser.next();
            abyte0 = abyte1;
            uuid1 = uuid;
            if (isStartTag(xmlpullparser, "cenc:pssh"))
            {
                abyte0 = abyte1;
                uuid1 = uuid;
                if (xmlpullparser.next() == 4)
                {
                    abyte0 = Base64.decode(xmlpullparser.getText(), 0);
                    uuid = PsshAtomUtil.parseUuid(abyte0);
                    uuid1 = uuid;
                    if (uuid == null)
                    {
                        throw new ParserException("Invalid pssh atom in cenc:pssh element");
                    }
                }
            }
            abyte1 = abyte0;
            uuid = uuid1;
        } while (!isEndTag(xmlpullparser, "ContentProtection"));
        return buildContentProtection(s, uuid1, abyte0);
    }

    protected RangedUri parseInitialization(XmlPullParser xmlpullparser, String s)
    {
        return parseRangedUrl(xmlpullparser, s, "sourceURL", "range");
    }

    protected MediaPresentationDescription parseMediaPresentationDescription(XmlPullParser xmlpullparser, String s)
        throws XmlPullParserException, IOException, ParseException
    {
        String s1;
        UtcTimingElement utctimingelement;
        UtcTimingElement utctimingelement1;
        String s2;
        String s3;
        ArrayList arraylist;
        long l3;
        long l2 = parseDateTime(xmlpullparser, "availabilityStartTime", -1L);
        l3 = parseDuration(xmlpullparser, "mediaPresentationDuration", -1L);
        long l4 = parseDuration(xmlpullparser, "minBufferTime", -1L);
        s1 = xmlpullparser.getAttributeValue(null, "type");
        long l;
        long l1;
        boolean flag;
        if (s1 != null)
        {
            flag = s1.equals("dynamic");
        } else
        {
            flag = false;
        }
        if (flag)
        {
            l = parseDuration(xmlpullparser, "minimumUpdatePeriod", -1L);
        } else
        {
            l = -1L;
        }
        if (flag)
        {
            l1 = parseDuration(xmlpullparser, "timeShiftBufferDepth", -1L);
        } else
        {
            l1 = -1L;
        }
        utctimingelement = null;
        s1 = null;
        arraylist = new ArrayList();
_L6:
        xmlpullparser.next();
        if (!isStartTag(xmlpullparser, "BaseURL"))
        {
            break; /* Loop/switch isn't completed */
        }
        s3 = parseBaseUrl(xmlpullparser, s);
        s2 = s1;
        utctimingelement1 = utctimingelement;
_L4:
        utctimingelement = utctimingelement1;
        s1 = s2;
        s = s3;
        if (isEndTag(xmlpullparser, "MPD"))
        {
            return buildMediaPresentationDescription(l2, l3, l4, flag, l, l1, utctimingelement1, s2, arraylist);
        }
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_108;
_L1:
        if (isStartTag(xmlpullparser, "UTCTiming"))
        {
            utctimingelement1 = parseUtcTiming(xmlpullparser);
            s2 = s1;
            s3 = s;
        } else
        if (isStartTag(xmlpullparser, "Period"))
        {
            arraylist.add(parsePeriod(xmlpullparser, s, l3));
            utctimingelement1 = utctimingelement;
            s2 = s1;
            s3 = s;
        } else
        {
            utctimingelement1 = utctimingelement;
            s2 = s1;
            s3 = s;
            if (isStartTag(xmlpullparser, "Location"))
            {
                s2 = xmlpullparser.nextText();
                utctimingelement1 = utctimingelement;
                s3 = s;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected Period parsePeriod(XmlPullParser xmlpullparser, String s, long l)
        throws XmlPullParserException, IOException
    {
        String s1;
        String s3;
        ArrayList arraylist;
        long l1;
        s3 = xmlpullparser.getAttributeValue(null, "id");
        l1 = parseDuration(xmlpullparser, "start", 0L);
        l = parseDuration(xmlpullparser, "duration", l);
        Object obj = null;
        arraylist = new ArrayList();
        s1 = s;
        s = obj;
_L2:
        String s2;
        xmlpullparser.next();
        if (!isStartTag(xmlpullparser, "BaseURL"))
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = parseBaseUrl(xmlpullparser, s1);
_L3:
        s1 = s2;
        if (isEndTag(xmlpullparser, "Period"))
        {
            return buildPeriod(s3, l1, l, arraylist);
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (isStartTag(xmlpullparser, "AdaptationSet"))
        {
            arraylist.add(parseAdaptationSet(xmlpullparser, s1, l1, l, s));
            s2 = s1;
        } else
        if (isStartTag(xmlpullparser, "SegmentBase"))
        {
            s = parseSegmentBase(xmlpullparser, s1, null);
            s2 = s1;
        } else
        if (isStartTag(xmlpullparser, "SegmentList"))
        {
            s = parseSegmentList(xmlpullparser, s1, null, l);
            s2 = s1;
        } else
        {
            s2 = s1;
            if (isStartTag(xmlpullparser, "SegmentTemplate"))
            {
                s = parseSegmentTemplate(xmlpullparser, s1, null, l);
                s2 = s1;
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    protected RangedUri parseRangedUrl(XmlPullParser xmlpullparser, String s, String s1, String s2)
    {
        s1 = xmlpullparser.getAttributeValue(null, s1);
        long l = 0L;
        long l2 = -1L;
        xmlpullparser = xmlpullparser.getAttributeValue(null, s2);
        long l1 = l2;
        if (xmlpullparser != null)
        {
            xmlpullparser = xmlpullparser.split("-");
            long l3 = Long.parseLong(xmlpullparser[0]);
            l = l3;
            l1 = l2;
            if (xmlpullparser.length == 2)
            {
                l1 = (Long.parseLong(xmlpullparser[1]) - l3) + 1L;
                l = l3;
            }
        }
        return buildRangedUri(s, s1, l, l1);
    }

    protected Representation parseRepresentation(XmlPullParser xmlpullparser, String s, long l, long l1, String s1, 
            String s2, SegmentBase segmentbase, ContentProtectionsBuilder contentprotectionsbuilder)
        throws XmlPullParserException, IOException
    {
        Object obj;
        int i;
        int j;
        String s3 = xmlpullparser.getAttributeValue(null, "id");
        int k = parseInt(xmlpullparser, "bandwidth");
        int i1 = parseInt(xmlpullparser, "audioSamplingRate");
        int j1 = parseInt(xmlpullparser, "width");
        int k1 = parseInt(xmlpullparser, "height");
        float f1 = -1F;
        obj = xmlpullparser.getAttributeValue(null, "frameRate");
        float f = f1;
        if (obj != null)
        {
            obj = FRAME_RATE_PATTERN.matcher(((CharSequence) (obj)));
            f = f1;
            if (((Matcher) (obj)).matches())
            {
                i = Integer.parseInt(((Matcher) (obj)).group(1));
                obj = ((Matcher) (obj)).group(2);
                String s4;
                String s5;
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    f = (float)i / (float)Integer.parseInt(((String) (obj)));
                } else
                {
                    f = i;
                }
            }
        }
        s4 = parseString(xmlpullparser, "mimeType", s1);
        s5 = parseString(xmlpullparser, "codecs", null);
        i = -1;
        obj = segmentbase;
        segmentbase = s;
_L3:
        xmlpullparser.next();
        if (!isStartTag(xmlpullparser, "BaseURL")) goto _L2; else goto _L1
_L1:
        s1 = parseBaseUrl(xmlpullparser, segmentbase);
        s = ((String) (obj));
        j = i;
_L4:
        i = j;
        segmentbase = s1;
        obj = s;
        if (isEndTag(xmlpullparser, "Representation"))
        {
            xmlpullparser = buildFormat(s3, s4, j1, k1, f, j, i1, k, s2, s5);
            s2 = contentId;
            if (s == null)
            {
                s = new SegmentBase.SingleSegmentBase(s1);
            }
            return buildRepresentation(l, l1, s2, -1, xmlpullparser, s);
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (isStartTag(xmlpullparser, "AudioChannelConfiguration"))
        {
            j = Integer.parseInt(xmlpullparser.getAttributeValue(null, "value"));
            s1 = segmentbase;
            s = ((String) (obj));
        } else
        if (isStartTag(xmlpullparser, "SegmentBase"))
        {
            s = parseSegmentBase(xmlpullparser, segmentbase, (SegmentBase.SingleSegmentBase)obj);
            j = i;
            s1 = segmentbase;
        } else
        if (isStartTag(xmlpullparser, "SegmentList"))
        {
            s = parseSegmentList(xmlpullparser, segmentbase, (SegmentBase.SegmentList)obj, l1);
            j = i;
            s1 = segmentbase;
        } else
        if (isStartTag(xmlpullparser, "SegmentTemplate"))
        {
            s = parseSegmentTemplate(xmlpullparser, segmentbase, (SegmentBase.SegmentTemplate)obj, l1);
            j = i;
            s1 = segmentbase;
        } else
        {
            j = i;
            s1 = segmentbase;
            s = ((String) (obj));
            if (isStartTag(xmlpullparser, "ContentProtection"))
            {
                contentprotectionsbuilder.addRepresentationProtection(parseContentProtection(xmlpullparser));
                j = i;
                s1 = segmentbase;
                s = ((String) (obj));
            }
        }
          goto _L4
    }

    protected SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlpullparser, String s, SegmentBase.SingleSegmentBase singlesegmentbase)
        throws XmlPullParserException, IOException
    {
        Object obj;
        long l;
        long l1;
        long l2;
        long l3;
        if (singlesegmentbase != null)
        {
            l = singlesegmentbase.timescale;
        } else
        {
            l = 1L;
        }
        l2 = parseLong(xmlpullparser, "timescale", l);
        if (singlesegmentbase != null)
        {
            l = singlesegmentbase.presentationTimeOffset;
        } else
        {
            l = 0L;
        }
        l3 = parseLong(xmlpullparser, "presentationTimeOffset", l);
        if (singlesegmentbase != null)
        {
            l = singlesegmentbase.indexStart;
        } else
        {
            l = 0L;
        }
        if (singlesegmentbase != null)
        {
            l1 = singlesegmentbase.indexLength;
        } else
        {
            l1 = -1L;
        }
        obj = xmlpullparser.getAttributeValue(null, "indexRange");
        if (obj != null)
        {
            String as[] = ((String) (obj)).split("-");
            l = Long.parseLong(as[0]);
            l1 = (Long.parseLong(as[1]) - l) + 1L;
        }
        if (singlesegmentbase != null)
        {
            singlesegmentbase = singlesegmentbase.initialization;
        } else
        {
            singlesegmentbase = null;
        }
        do
        {
            xmlpullparser.next();
            as = singlesegmentbase;
            if (isStartTag(xmlpullparser, "Initialization"))
            {
                as = parseInitialization(xmlpullparser, s);
            }
            singlesegmentbase = as;
        } while (!isEndTag(xmlpullparser, "SegmentBase"));
        return buildSingleSegmentBase(as, l2, l3, s, l, l1);
    }

    protected SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlpullparser, String s, SegmentBase.SegmentList segmentlist, long l)
        throws XmlPullParserException, IOException
    {
        List list;
        RangedUri rangeduri;
        Object obj;
        Object obj1;
        List list1;
        RangedUri rangeduri1;
        int i;
        long l1;
        long l2;
        long l3;
        if (segmentlist != null)
        {
            l1 = segmentlist.timescale;
        } else
        {
            l1 = 1L;
        }
        l2 = parseLong(xmlpullparser, "timescale", l1);
        if (segmentlist != null)
        {
            l1 = segmentlist.presentationTimeOffset;
        } else
        {
            l1 = 0L;
        }
        l3 = parseLong(xmlpullparser, "presentationTimeOffset", l1);
        if (segmentlist != null)
        {
            l1 = segmentlist.duration;
        } else
        {
            l1 = -1L;
        }
        l1 = parseLong(xmlpullparser, "duration", l1);
        if (segmentlist != null)
        {
            i = segmentlist.startNumber;
        } else
        {
            i = 1;
        }
        i = parseInt(xmlpullparser, "startNumber", i);
        rangeduri1 = null;
        list1 = null;
        obj1 = null;
_L3:
        xmlpullparser.next();
        if (!isStartTag(xmlpullparser, "Initialization")) goto _L2; else goto _L1
_L1:
        rangeduri = parseInitialization(xmlpullparser, s);
        obj = obj1;
        list = list1;
_L4:
        rangeduri1 = rangeduri;
        list1 = list;
        obj1 = obj;
        if (isEndTag(xmlpullparser, "SegmentList"))
        {
            xmlpullparser = rangeduri;
            s = list;
            obj1 = obj;
            if (segmentlist != null)
            {
                if (rangeduri == null)
                {
                    rangeduri = segmentlist.initialization;
                }
                if (list == null)
                {
                    list = segmentlist.segmentTimeline;
                }
                if (obj != null)
                {
                    obj1 = obj;
                    s = list;
                    xmlpullparser = rangeduri;
                } else
                {
                    obj1 = segmentlist.mediaSegments;
                    xmlpullparser = rangeduri;
                    s = list;
                }
            }
            return buildSegmentList(xmlpullparser, l2, l3, l, i, l1, s, ((List) (obj1)));
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (isStartTag(xmlpullparser, "SegmentTimeline"))
        {
            list = parseSegmentTimeline(xmlpullparser);
            rangeduri = rangeduri1;
            obj = obj1;
        } else
        {
            rangeduri = rangeduri1;
            list = list1;
            obj = obj1;
            if (isStartTag(xmlpullparser, "SegmentURL"))
            {
                obj = obj1;
                if (obj1 == null)
                {
                    obj = new ArrayList();
                }
                ((List) (obj)).add(parseSegmentUrl(xmlpullparser, s));
                rangeduri = rangeduri1;
                list = list1;
            }
        }
          goto _L4
    }

    protected SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlpullparser, String s, SegmentBase.SegmentTemplate segmenttemplate, long l)
        throws XmlPullParserException, IOException
    {
        Object obj;
        List list;
        List list1;
        RangedUri rangeduri;
        UrlTemplate urltemplate;
        UrlTemplate urltemplate1;
        int i;
        long l1;
        long l2;
        long l3;
        if (segmenttemplate != null)
        {
            l1 = segmenttemplate.timescale;
        } else
        {
            l1 = 1L;
        }
        l2 = parseLong(xmlpullparser, "timescale", l1);
        if (segmenttemplate != null)
        {
            l1 = segmenttemplate.presentationTimeOffset;
        } else
        {
            l1 = 0L;
        }
        l3 = parseLong(xmlpullparser, "presentationTimeOffset", l1);
        if (segmenttemplate != null)
        {
            l1 = segmenttemplate.duration;
        } else
        {
            l1 = -1L;
        }
        l1 = parseLong(xmlpullparser, "duration", l1);
        if (segmenttemplate != null)
        {
            i = segmenttemplate.startNumber;
        } else
        {
            i = 1;
        }
        i = parseInt(xmlpullparser, "startNumber", i);
        if (segmenttemplate != null)
        {
            obj = segmenttemplate.mediaTemplate;
        } else
        {
            obj = null;
        }
        urltemplate = parseUrlTemplate(xmlpullparser, "media", ((UrlTemplate) (obj)));
        if (segmenttemplate != null)
        {
            obj = segmenttemplate.initializationTemplate;
        } else
        {
            obj = null;
        }
        urltemplate1 = parseUrlTemplate(xmlpullparser, "initialization", ((UrlTemplate) (obj)));
        rangeduri = null;
        list1 = null;
_L3:
        xmlpullparser.next();
        if (!isStartTag(xmlpullparser, "Initialization")) goto _L2; else goto _L1
_L1:
        obj = parseInitialization(xmlpullparser, s);
        list = list1;
_L4:
        rangeduri = ((RangedUri) (obj));
        list1 = list;
        if (isEndTag(xmlpullparser, "SegmentTemplate"))
        {
            xmlpullparser = ((XmlPullParser) (obj));
            list1 = list;
            if (segmenttemplate != null)
            {
                if (obj == null)
                {
                    obj = segmenttemplate.initialization;
                }
                if (list != null)
                {
                    list1 = list;
                    xmlpullparser = ((XmlPullParser) (obj));
                } else
                {
                    list1 = segmenttemplate.segmentTimeline;
                    xmlpullparser = ((XmlPullParser) (obj));
                }
            }
            return buildSegmentTemplate(xmlpullparser, l2, l3, l, i, l1, list1, urltemplate1, urltemplate, s);
        }
        if (true) goto _L3; else goto _L2
_L2:
        obj = rangeduri;
        list = list1;
        if (isStartTag(xmlpullparser, "SegmentTimeline"))
        {
            list = parseSegmentTimeline(xmlpullparser);
            obj = rangeduri;
        }
          goto _L4
    }

    protected List parseSegmentTimeline(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        ArrayList arraylist = new ArrayList();
        long l = 0L;
        do
        {
            xmlpullparser.next();
            long l1 = l;
            if (isStartTag(xmlpullparser, "S"))
            {
                l = parseLong(xmlpullparser, "t", l);
                long l2 = parseLong(xmlpullparser, "d");
                int j = parseInt(xmlpullparser, "r", 0);
                int i = 0;
                do
                {
                    l1 = l;
                    if (i >= j + 1)
                    {
                        break;
                    }
                    arraylist.add(buildSegmentTimelineElement(l, l2));
                    l += l2;
                    i++;
                } while (true);
            }
            l = l1;
        } while (!isEndTag(xmlpullparser, "SegmentTimeline"));
        return arraylist;
    }

    protected RangedUri parseSegmentUrl(XmlPullParser xmlpullparser, String s)
    {
        return parseRangedUrl(xmlpullparser, s, "media", "mediaRange");
    }

    protected UrlTemplate parseUrlTemplate(XmlPullParser xmlpullparser, String s, UrlTemplate urltemplate)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            urltemplate = UrlTemplate.compile(xmlpullparser);
        }
        return urltemplate;
    }

    protected UtcTimingElement parseUtcTiming(XmlPullParser xmlpullparser)
    {
        return buildUtcTimingElement(xmlpullparser.getAttributeValue(null, "schemeIdUri"), xmlpullparser.getAttributeValue(null, "value"));
    }

}
