// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifest

public class SmoothStreamingManifestParser
    implements com.google.android.exoplayer.upstream.UriLoadable.Parser
{
    private static abstract class ElementParser
    {

        private final String baseUri;
        private final List normalizedAttributes = new LinkedList();
        private final ElementParser parent;
        private final String tag;

        private ElementParser newChildParser(ElementParser elementparser, String s, String s1)
        {
            if ("QualityLevel".equals(s))
            {
                return new TrackElementParser(elementparser, s1);
            }
            if ("Protection".equals(s))
            {
                return new ProtectionElementParser(elementparser, s1);
            }
            if ("StreamIndex".equals(s))
            {
                return new StreamElementParser(elementparser, s1);
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
        //                       1 295
        //                       2 68
        //                       3 234
        //                       4 195;
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
                            addChild(((ElementParser) (obj)).parse(xmlpullparser));
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
                throw new MissingFieldException(s);
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
                throw new MissingFieldException(s);
            }
        }

        protected final String parseRequiredString(XmlPullParser xmlpullparser, String s)
            throws MissingFieldException
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

        public ElementParser(ElementParser elementparser, String s, String s1)
        {
            parent = elementparser;
            baseUri = s;
            tag = s1;
        }
    }

    public static class MissingFieldException extends ParserException
    {

        public MissingFieldException(String s)
        {
            super((new StringBuilder()).append("Missing required field: ").append(s).toString());
        }
    }

    private static class ProtectionElementParser extends ElementParser
    {

        public static final String KEY_SYSTEM_ID = "SystemID";
        public static final String TAG = "Protection";
        public static final String TAG_PROTECTION_HEADER = "ProtectionHeader";
        private boolean inProtectionHeader;
        private byte initData[];
        private UUID uuid;

        public Object build()
        {
            return new SmoothStreamingManifest.ProtectionElement(uuid, PsshAtomUtil.buildPsshAtom(uuid, initData));
        }

        public boolean handleChildInline(String s)
        {
            return "ProtectionHeader".equals(s);
        }

        public void parseEndTag(XmlPullParser xmlpullparser)
        {
            if ("ProtectionHeader".equals(xmlpullparser.getName()))
            {
                inProtectionHeader = false;
            }
        }

        public void parseStartTag(XmlPullParser xmlpullparser)
        {
            if ("ProtectionHeader".equals(xmlpullparser.getName()))
            {
                inProtectionHeader = true;
                uuid = UUID.fromString(xmlpullparser.getAttributeValue(null, "SystemID"));
            }
        }

        public void parseText(XmlPullParser xmlpullparser)
        {
            if (inProtectionHeader)
            {
                initData = Base64.decode(xmlpullparser.getText(), 0);
            }
        }

        public ProtectionElementParser(ElementParser elementparser, String s)
        {
            super(elementparser, s, "Protection");
        }
    }

    private static class SmoothStreamMediaParser extends ElementParser
    {

        private static final String KEY_DURATION = "Duration";
        private static final String KEY_DVR_WINDOW_LENGTH = "DVRWindowLength";
        private static final String KEY_IS_LIVE = "IsLive";
        private static final String KEY_LOOKAHEAD_COUNT = "LookaheadCount";
        private static final String KEY_MAJOR_VERSION = "MajorVersion";
        private static final String KEY_MINOR_VERSION = "MinorVersion";
        private static final String KEY_TIME_SCALE = "TimeScale";
        public static final String TAG = "SmoothStreamingMedia";
        private long duration;
        private long dvrWindowLength;
        private boolean isLive;
        private int lookAheadCount;
        private int majorVersion;
        private int minorVersion;
        private SmoothStreamingManifest.ProtectionElement protectionElement;
        private List streamElements;
        private long timescale;

        public void addChild(Object obj)
        {
            if (obj instanceof SmoothStreamingManifest.StreamElement)
            {
                streamElements.add((SmoothStreamingManifest.StreamElement)obj);
            } else
            if (obj instanceof SmoothStreamingManifest.ProtectionElement)
            {
                boolean flag;
                if (protectionElement == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkState(flag);
                protectionElement = (SmoothStreamingManifest.ProtectionElement)obj;
                return;
            }
        }

        public Object build()
        {
            SmoothStreamingManifest.StreamElement astreamelement[] = new SmoothStreamingManifest.StreamElement[streamElements.size()];
            streamElements.toArray(astreamelement);
            return new SmoothStreamingManifest(majorVersion, minorVersion, timescale, duration, dvrWindowLength, lookAheadCount, isLive, protectionElement, astreamelement);
        }

        public void parseStartTag(XmlPullParser xmlpullparser)
            throws ParserException
        {
            majorVersion = parseRequiredInt(xmlpullparser, "MajorVersion");
            minorVersion = parseRequiredInt(xmlpullparser, "MinorVersion");
            timescale = parseLong(xmlpullparser, "TimeScale", 0x989680L);
            duration = parseRequiredLong(xmlpullparser, "Duration");
            dvrWindowLength = parseLong(xmlpullparser, "DVRWindowLength", 0L);
            lookAheadCount = parseInt(xmlpullparser, "LookaheadCount", -1);
            isLive = parseBoolean(xmlpullparser, "IsLive", false);
            putNormalizedAttribute("TimeScale", Long.valueOf(timescale));
        }

        public SmoothStreamMediaParser(ElementParser elementparser, String s)
        {
            super(elementparser, s, "SmoothStreamingMedia");
            lookAheadCount = -1;
            protectionElement = null;
            streamElements = new LinkedList();
        }
    }

    private static class StreamElementParser extends ElementParser
    {

        private static final String KEY_DISPLAY_HEIGHT = "DisplayHeight";
        private static final String KEY_DISPLAY_WIDTH = "DisplayWidth";
        private static final String KEY_FRAGMENT_DURATION = "d";
        private static final String KEY_FRAGMENT_REPEAT_COUNT = "r";
        private static final String KEY_FRAGMENT_START_TIME = "t";
        private static final String KEY_LANGUAGE = "Language";
        private static final String KEY_MAX_HEIGHT = "MaxHeight";
        private static final String KEY_MAX_WIDTH = "MaxWidth";
        private static final String KEY_NAME = "Name";
        private static final String KEY_QUALITY_LEVELS = "QualityLevels";
        private static final String KEY_SUB_TYPE = "Subtype";
        private static final String KEY_TIME_SCALE = "TimeScale";
        private static final String KEY_TYPE = "Type";
        private static final String KEY_TYPE_AUDIO = "audio";
        private static final String KEY_TYPE_TEXT = "text";
        private static final String KEY_TYPE_VIDEO = "video";
        private static final String KEY_URL = "Url";
        public static final String TAG = "StreamIndex";
        private static final String TAG_STREAM_FRAGMENT = "c";
        private final String baseUri;
        private int displayHeight;
        private int displayWidth;
        private String language;
        private long lastChunkDuration;
        private int maxHeight;
        private int maxWidth;
        private String name;
        private int qualityLevels;
        private ArrayList startTimes;
        private String subType;
        private long timescale;
        private final List tracks = new LinkedList();
        private int type;
        private String url;

        private void parseStreamElementStartTag(XmlPullParser xmlpullparser)
            throws ParserException
        {
            type = parseType(xmlpullparser);
            putNormalizedAttribute("Type", Integer.valueOf(type));
            if (type == 2)
            {
                subType = parseRequiredString(xmlpullparser, "Subtype");
            } else
            {
                subType = xmlpullparser.getAttributeValue(null, "Subtype");
            }
            name = xmlpullparser.getAttributeValue(null, "Name");
            qualityLevels = parseInt(xmlpullparser, "QualityLevels", -1);
            url = parseRequiredString(xmlpullparser, "Url");
            maxWidth = parseInt(xmlpullparser, "MaxWidth", -1);
            maxHeight = parseInt(xmlpullparser, "MaxHeight", -1);
            displayWidth = parseInt(xmlpullparser, "DisplayWidth", -1);
            displayHeight = parseInt(xmlpullparser, "DisplayHeight", -1);
            language = xmlpullparser.getAttributeValue(null, "Language");
            timescale = parseInt(xmlpullparser, "TimeScale", -1);
            if (timescale == -1L)
            {
                timescale = ((Long)getNormalizedAttribute("TimeScale")).longValue();
            }
            startTimes = new ArrayList();
        }

        private void parseStreamFragmentStartTag(XmlPullParser xmlpullparser)
            throws ParserException
        {
            int i = startTimes.size();
            long l1 = parseLong(xmlpullparser, "t", -1L);
            long l = l1;
            int k;
            if (l1 == -1L)
            {
                if (i == 0)
                {
                    l = 0L;
                } else
                if (lastChunkDuration != -1L)
                {
                    l = ((Long)startTimes.get(i - 1)).longValue() + lastChunkDuration;
                } else
                {
                    throw new ParserException("Unable to infer start time");
                }
            }
            k = i + 1;
            startTimes.add(Long.valueOf(l));
            lastChunkDuration = parseLong(xmlpullparser, "d", -1L);
            l1 = parseLong(xmlpullparser, "r", 1L);
            if (l1 > 1L && lastChunkDuration == -1L)
            {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            for (int j = 1; (long)j < l1; j++)
            {
                k++;
                startTimes.add(Long.valueOf(lastChunkDuration * (long)j + l));
            }

        }

        private int parseType(XmlPullParser xmlpullparser)
            throws ParserException
        {
            xmlpullparser = xmlpullparser.getAttributeValue(null, "Type");
            if (xmlpullparser != null)
            {
                if ("audio".equalsIgnoreCase(xmlpullparser))
                {
                    return 0;
                }
                if ("video".equalsIgnoreCase(xmlpullparser))
                {
                    return 1;
                }
                if ("text".equalsIgnoreCase(xmlpullparser))
                {
                    return 2;
                } else
                {
                    throw new ParserException((new StringBuilder()).append("Invalid key value[").append(xmlpullparser).append("]").toString());
                }
            } else
            {
                throw new MissingFieldException("Type");
            }
        }

        public void addChild(Object obj)
        {
            if (obj instanceof SmoothStreamingManifest.TrackElement)
            {
                tracks.add((SmoothStreamingManifest.TrackElement)obj);
            }
        }

        public Object build()
        {
            SmoothStreamingManifest.TrackElement atrackelement[] = new SmoothStreamingManifest.TrackElement[tracks.size()];
            tracks.toArray(atrackelement);
            return new SmoothStreamingManifest.StreamElement(baseUri, url, type, subType, timescale, name, qualityLevels, maxWidth, maxHeight, displayWidth, displayHeight, language, atrackelement, startTimes, lastChunkDuration);
        }

        public boolean handleChildInline(String s)
        {
            return "c".equals(s);
        }

        public void parseStartTag(XmlPullParser xmlpullparser)
            throws ParserException
        {
            if ("c".equals(xmlpullparser.getName()))
            {
                parseStreamFragmentStartTag(xmlpullparser);
                return;
            } else
            {
                parseStreamElementStartTag(xmlpullparser);
                return;
            }
        }

        public StreamElementParser(ElementParser elementparser, String s)
        {
            super(elementparser, s, "StreamIndex");
            baseUri = s;
        }
    }

    private static class TrackElementParser extends ElementParser
    {

        private static final String KEY_BITRATE = "Bitrate";
        private static final String KEY_CHANNELS = "Channels";
        private static final String KEY_CODEC_PRIVATE_DATA = "CodecPrivateData";
        private static final String KEY_FOUR_CC = "FourCC";
        private static final String KEY_INDEX = "Index";
        private static final String KEY_MAX_HEIGHT = "MaxHeight";
        private static final String KEY_MAX_WIDTH = "MaxWidth";
        private static final String KEY_SAMPLING_RATE = "SamplingRate";
        private static final String KEY_TYPE = "Type";
        public static final String TAG = "QualityLevel";
        private int bitrate;
        private int channels;
        private final List csd = new LinkedList();
        private int index;
        private int maxHeight;
        private int maxWidth;
        private String mimeType;
        private int samplingRate;

        private static String fourCCToMimeType(String s)
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

        private static byte[] hexStringToByteArray(String s)
        {
            byte abyte0[] = new byte[s.length() / 2];
            for (int i = 0; i < abyte0.length; i++)
            {
                int j = i * 2;
                abyte0[i] = (byte)((Character.digit(s.charAt(j), 16) << 4) + Character.digit(s.charAt(j + 1), 16));
            }

            return abyte0;
        }

        public Object build()
        {
            byte abyte0[][] = (byte[][])null;
            if (!csd.isEmpty())
            {
                abyte0 = new byte[csd.size()][];
                csd.toArray(abyte0);
            }
            return new SmoothStreamingManifest.TrackElement(index, bitrate, mimeType, abyte0, maxWidth, maxHeight, samplingRate, channels);
        }

        public void parseStartTag(XmlPullParser xmlpullparser)
            throws ParserException
        {
            int i = ((Integer)getNormalizedAttribute("Type")).intValue();
            index = parseInt(xmlpullparser, "Index", -1);
            bitrate = parseRequiredInt(xmlpullparser, "Bitrate");
            if (i == 1)
            {
                maxHeight = parseRequiredInt(xmlpullparser, "MaxHeight");
                maxWidth = parseRequiredInt(xmlpullparser, "MaxWidth");
                mimeType = fourCCToMimeType(parseRequiredString(xmlpullparser, "FourCC"));
            } else
            {
                maxHeight = -1;
                maxWidth = -1;
                obj = xmlpullparser.getAttributeValue(null, "FourCC");
                if (obj != null)
                {
                    obj = fourCCToMimeType(((String) (obj)));
                } else
                if (i == 0)
                {
                    obj = "audio/mp4a-latm";
                } else
                {
                    obj = null;
                }
                mimeType = ((String) (obj));
            }
            if (i == 0)
            {
                samplingRate = parseRequiredInt(xmlpullparser, "SamplingRate");
                channels = parseRequiredInt(xmlpullparser, "Channels");
            } else
            {
                samplingRate = -1;
                channels = -1;
            }
            xmlpullparser = xmlpullparser.getAttributeValue(null, "CodecPrivateData");
            if (xmlpullparser != null && xmlpullparser.length() > 0)
            {
                xmlpullparser = hexStringToByteArray(xmlpullparser);
                Object obj = CodecSpecificDataUtil.splitNalUnits(xmlpullparser);
                if (obj == null)
                {
                    csd.add(xmlpullparser);
                } else
                {
                    int j = 0;
                    while (j < obj.length) 
                    {
                        csd.add(obj[j]);
                        j++;
                    }
                }
            }
        }

        public TrackElementParser(ElementParser elementparser, String s)
        {
            super(elementparser, s, "QualityLevel");
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

    public SmoothStreamingManifest parse(String s, InputStream inputstream)
        throws IOException, ParserException
    {
        try
        {
            XmlPullParser xmlpullparser = xmlParserFactory.newPullParser();
            xmlpullparser.setInput(inputstream, null);
            s = (SmoothStreamingManifest)(new SmoothStreamMediaParser(null, s)).parse(xmlpullparser);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParserException(s);
        }
        return s;
    }

    public volatile Object parse(String s, InputStream inputstream)
        throws ParserException, IOException
    {
        return parse(s, inputstream);
    }
}
