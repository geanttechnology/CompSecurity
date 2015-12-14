// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.util.Xml;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.Utils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VASTParser
{
    public static class Ad
    {

        public AdSystem adSystem;
        public List creatives;
        public String error;
        public String id;
        public List impressions;

        Ad()
        {
            impressions = new ArrayList();
        }
    }

    public static class AdSystem
    {

        public String name;
        public String version;

        AdSystem(String s, String s1)
        {
            name = s;
            version = s1;
        }
    }

    public static class Background
    {

        public boolean hideButtons;
        public StaticResource staticResource;
        public WebResource webResource;

        Background(boolean flag)
        {
            hideButtons = flag;
        }
    }

    public static class Button
    {

        public ButtonClicks buttonClicks;
        public String name;
        public String offset;
        public int position;
        public StaticResource staticResource;

        public Button(String s, String s1, int i)
        {
            name = s;
            offset = s1;
            position = i;
        }
    }

    public static class ButtonClicks
    {

        public String clickThrough;
        public List clickTrackingUrls;

        public ButtonClicks(String s, List list)
        {
            clickThrough = s;
            clickTrackingUrls = list;
        }
    }

    public static class CompanionAd
    {

        public int assetHeight;
        public int assetWidth;
        public String companionClickThrough;
        public List companionClickTracking;
        public int height;
        public boolean hideButtons;
        public WebResource htmlResource;
        public String id;
        public WebResource iframeResource;
        public StaticResource staticResource;
        public Map trackingEvents;
        public int width;

        CompanionAd(String s, int i, int j, int k, int l, boolean flag)
        {
            id = s;
            width = i;
            height = j;
            assetWidth = k;
            assetHeight = l;
            hideButtons = flag;
            companionClickTracking = new ArrayList();
        }
    }

    public static class Creative
    {

        public List companionAds;
        public String id;
        public LinearAd linearAd;
        public Integer sequence;

        Creative(String s, Integer integer)
        {
            id = s;
            sequence = integer;
        }
    }

    public static class InLineAd extends Ad
    {

        public MMExtension mmExtension;

        public InLineAd()
        {
        }
    }

    public static class LinearAd
    {

        public List mediaFiles;
        public String skipOffset;
        public Map trackingEvents;
        public VideoClicks videoClicks;

        LinearAd(String s)
        {
            skipOffset = s;
        }
    }

    public static class MMExtension
    {

        public Background background;
        public List buttons;
        public Overlay overlay;

        MMExtension(Overlay overlay1, Background background1, List list)
        {
            overlay = overlay1;
            background = background1;
            buttons = list;
        }
    }

    public static class MediaFile
    {

        public int bitrate;
        public String contentType;
        public String delivery;
        public int height;
        public boolean maintainAspectRatio;
        public String url;
        public int width;

        MediaFile(String s, String s1, String s2, int i, int j, int k, boolean flag)
        {
            url = s;
            contentType = s1;
            delivery = s2;
            width = i;
            height = j;
            bitrate = k;
            maintainAspectRatio = flag;
        }
    }

    public static class Overlay
    {

        public boolean hideButtons;
        public String uri;

        Overlay(String s, boolean flag)
        {
            uri = s;
            hideButtons = flag;
        }
    }

    public static class ProgressEvent extends TrackingEvent
    {

        public String offset;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof ProgressEvent))
                {
                    return false;
                }
                if (!super.equals(obj))
                {
                    return false;
                }
                obj = (ProgressEvent)obj;
                if (!offset.equals(((ProgressEvent) (obj)).offset))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + offset.hashCode();
        }

        ProgressEvent(String s, String s1)
        {
            super(TrackableEvent.progress, s);
            offset = s1;
        }
    }

    public static class StaticResource
    {

        public String backgroundColor;
        public String creativeType;
        public String uri;

        StaticResource(String s, String s1, String s2)
        {
            backgroundColor = s1;
            creativeType = s;
            uri = s2;
        }
    }

    public static final class TrackableEvent extends Enum
    {

        private static final TrackableEvent $VALUES[];
        public static final TrackableEvent closeLinear;
        public static final TrackableEvent complete;
        public static final TrackableEvent creativeView;
        public static final TrackableEvent firstQuartile;
        public static final TrackableEvent midpoint;
        public static final TrackableEvent progress;
        public static final TrackableEvent skip;
        public static final TrackableEvent start;
        public static final TrackableEvent thirdQuartile;

        public static TrackableEvent valueOf(String s)
        {
            return (TrackableEvent)Enum.valueOf(com/millennialmedia/internal/video/VASTParser$TrackableEvent, s);
        }

        public static TrackableEvent[] values()
        {
            return (TrackableEvent[])$VALUES.clone();
        }

        static 
        {
            creativeView = new TrackableEvent("creativeView", 0);
            start = new TrackableEvent("start", 1);
            firstQuartile = new TrackableEvent("firstQuartile", 2);
            midpoint = new TrackableEvent("midpoint", 3);
            thirdQuartile = new TrackableEvent("thirdQuartile", 4);
            complete = new TrackableEvent("complete", 5);
            closeLinear = new TrackableEvent("closeLinear", 6);
            skip = new TrackableEvent("skip", 7);
            progress = new TrackableEvent("progress", 8);
            $VALUES = (new TrackableEvent[] {
                creativeView, start, firstQuartile, midpoint, thirdQuartile, complete, closeLinear, skip, progress
            });
        }

        private TrackableEvent(String s, int i)
        {
            super(s, i);
        }
    }

    public static class TrackingEvent
    {

        TrackableEvent event;
        public String url;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof TrackingEvent))
                {
                    return false;
                }
                obj = (TrackingEvent)obj;
                if (event != ((TrackingEvent) (obj)).event)
                {
                    return false;
                }
                if (!url.equals(((TrackingEvent) (obj)).url))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return url.hashCode() * 31 + event.hashCode();
        }

        TrackingEvent(TrackableEvent trackableevent, String s)
        {
            event = trackableevent;
            url = s;
        }
    }

    public static class VideoClicks
    {

        public String clickThrough;
        public List clickTrackingUrls;
        public List customClickUrls;

        VideoClicks(String s, List list, List list1)
        {
            clickThrough = s;
            clickTrackingUrls = list;
            customClickUrls = list1;
        }
    }

    public static class WebResource
    {

        public String uri;

        WebResource(String s)
        {
            uri = s;
        }
    }

    public static class WrapperAd extends Ad
    {

        public String adTagURI;

        public WrapperAd()
        {
        }
    }


    private static final String TAG = com/millennialmedia/internal/video/VASTParser.getSimpleName();

    public VASTParser()
    {
    }

    private static String nextText(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        String s = xmlpullparser.nextText();
        xmlpullparser = s;
        if (s != null)
        {
            xmlpullparser = s.trim();
        }
        return xmlpullparser;
    }

    public static Ad parse(String s)
        throws XmlPullParserException, IOException
    {
        if (s == null)
        {
            MMLog.w(TAG, "Ad content was null.");
        } else
        {
            XmlPullParser xmlpullparser = Xml.newPullParser();
            xmlpullparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            xmlpullparser.setInput(new StringReader(s));
            xmlpullparser.nextTag();
            if (xmlpullparser.getName().equals("VAST"))
            {
                s = xmlpullparser.getAttributeValue("", "version");
                if (!Utils.isEmpty(s))
                {
                    try
                    {
                        if (Integer.parseInt((new StringBuilder()).append("").append(s.trim().charAt(0)).toString()) > 1)
                        {
                            xmlpullparser.nextTag();
                            return readAd(xmlpullparser);
                        }
                        MMLog.e(TAG, (new StringBuilder()).append("Unsupported VAST version = ").append(s).toString());
                    }
                    catch (NumberFormatException numberformatexception)
                    {
                        MMLog.e(TAG, (new StringBuilder()).append("Invalid version format for VAST tag with version = ").append(s).toString(), numberformatexception);
                        return null;
                    }
                    return null;
                } else
                {
                    MMLog.e(TAG, "VAST version not provided.");
                    return null;
                }
            }
        }
        return null;
    }

    private static Ad readAd(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        Object obj1;
        String s;
        xmlpullparser.require(2, null, "Ad");
        obj1 = null;
        s = xmlpullparser.getAttributeValue(null, "id");
_L7:
        Object obj = obj1;
        if (xmlpullparser.next() == 3) goto _L2; else goto _L1
_L1:
        if (xmlpullparser.getEventType() != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!xmlpullparser.getName().equals("InLine")) goto _L4; else goto _L3
_L3:
        obj = readInLine(xmlpullparser);
_L2:
        if (obj != null)
        {
            obj.id = s;
        }
        return ((Ad) (obj));
_L4:
        if (!xmlpullparser.getName().equals("Wrapper"))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = readWrapper(xmlpullparser);
        if (true) goto _L2; else goto _L5
_L5:
        skip(xmlpullparser);
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static Background readBackground(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Background");
        Background background = new Background(toBoolean(xmlpullparser.getAttributeValue(null, "hideButtons"), false));
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("StaticResource"))
                {
                    background.staticResource = new StaticResource(xmlpullparser.getAttributeValue(null, "creativeType"), xmlpullparser.getAttributeValue(null, "backgroundColor"), nextText(xmlpullparser));
                } else
                if (xmlpullparser.getName().equals("WebResource"))
                {
                    background.webResource = new WebResource(nextText(xmlpullparser));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return background;
    }

    public static Button readButton(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Button");
        Object obj = xmlpullparser.getAttributeValue(null, "name");
        String s = xmlpullparser.getAttributeValue(null, "offset");
        String s1 = xmlpullparser.getAttributeValue(null, "position");
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (s1 != null)
        {
            i = ((flag) ? 1 : 0);
            if (s1.trim().length() > 0)
            {
                try
                {
                    i = Integer.parseInt(s1);
                }
                catch (NumberFormatException numberformatexception)
                {
                    MMLog.w(TAG, (new StringBuilder()).append("Invalid position: ").append(s1).append(" for Button.").toString());
                    i = ((flag) ? 1 : 0);
                }
            }
        }
        obj = new Button(((String) (obj)), s, i);
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("StaticResource"))
                {
                    obj.staticResource = new StaticResource(xmlpullparser.getAttributeValue(null, "creativeType"), xmlpullparser.getAttributeValue(null, "backgroundColor"), nextText(xmlpullparser));
                } else
                if (xmlpullparser.getName().equals("ButtonClicks"))
                {
                    obj.buttonClicks = readButtonClicks(xmlpullparser);
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return ((Button) (obj));
    }

    private static ButtonClicks readButtonClicks(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "ButtonClicks");
        ButtonClicks buttonclicks = new ButtonClicks(null, new ArrayList());
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("ButtonClickThrough"))
                {
                    buttonclicks.clickThrough = nextText(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("ButtonClickTracking"))
                {
                    buttonclicks.clickTrackingUrls.add(nextText(xmlpullparser));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return buttonclicks;
    }

    private static List readButtons(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Buttons");
        ArrayList arraylist = new ArrayList();
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("Button"))
                {
                    arraylist.add(readButton(xmlpullparser));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return arraylist;
    }

    private static CompanionAd readCompanionAd(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Companion");
        CompanionAd companionad = new CompanionAd(xmlpullparser.getAttributeValue(null, "id"), Integer.parseInt(xmlpullparser.getAttributeValue(null, "width")), Integer.parseInt(xmlpullparser.getAttributeValue(null, "height")), Integer.parseInt(xmlpullparser.getAttributeValue(null, "assetWidth")), Integer.parseInt(xmlpullparser.getAttributeValue(null, "assetHeight")), toBoolean(xmlpullparser.getAttributeValue(null, "hideButtons"), false));
_L4:
        Object obj = companionad;
        if (xmlpullparser.next() == 3) goto _L2; else goto _L1
_L1:
        if (xmlpullparser.getEventType() != 2) goto _L4; else goto _L3
_L3:
        if (!xmlpullparser.getName().equals("StaticResource")) goto _L6; else goto _L5
_L5:
        companionad.staticResource = new StaticResource(xmlpullparser.getAttributeValue(null, "creativeType"), xmlpullparser.getAttributeValue(null, "backgroundColor"), nextText(xmlpullparser));
          goto _L4
        obj;
        xmlpullparser = companionad;
_L7:
        MMLog.e(TAG, "Syntax error in Companion element; skipping.", ((Throwable) (obj)));
        obj = xmlpullparser;
_L2:
        return ((CompanionAd) (obj));
_L6:
label0:
        {
            if (!xmlpullparser.getName().equals("HTMLResource"))
            {
                break label0;
            }
            companionad.htmlResource = new WebResource(nextText(xmlpullparser));
        }
          goto _L4
label1:
        {
            if (!xmlpullparser.getName().equals("IFrameResource"))
            {
                break label1;
            }
            companionad.iframeResource = new WebResource(nextText(xmlpullparser));
        }
          goto _L4
label2:
        {
            if (!xmlpullparser.getName().equals("TrackingEvents"))
            {
                break label2;
            }
            companionad.trackingEvents = readTrackingEvents(xmlpullparser);
        }
          goto _L4
label3:
        {
            if (!xmlpullparser.getName().equals("CompanionClickTracking"))
            {
                break label3;
            }
            obj = nextText(xmlpullparser);
            if (!Utils.isEmpty(((String) (obj))))
            {
                companionad.companionClickTracking.add(obj);
            }
        }
          goto _L4
label4:
        {
            if (!xmlpullparser.getName().equals("CompanionClickThrough"))
            {
                break label4;
            }
            obj = nextText(xmlpullparser);
            if (!Utils.isEmpty(((String) (obj))))
            {
                companionad.companionClickThrough = ((String) (obj));
            }
        }
          goto _L4
        skip(xmlpullparser);
          goto _L4
        obj;
        xmlpullparser = null;
          goto _L7
    }

    private static List readCompanionAds(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "CompanionAds");
        ArrayList arraylist = new ArrayList();
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("Companion"))
                {
                    CompanionAd companionad = readCompanionAd(xmlpullparser);
                    if (companionad != null)
                    {
                        arraylist.add(companionad);
                    }
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return arraylist;
    }

    private static Creative readCreative(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Creative");
        String s = xmlpullparser.getAttributeValue(null, "AdID");
        String s1 = xmlpullparser.getAttributeValue(null, "sequence");
        Object obj1 = null;
        Object obj = obj1;
        if (s1 != null)
        {
            obj = obj1;
            if (s1.trim().length() > 0)
            {
                try
                {
                    obj = Integer.decode(s1);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    MMLog.w(TAG, (new StringBuilder()).append("Invalid sequence number: ").append(s1).append(" for Creative.").toString());
                    obj = obj1;
                }
            }
        }
        obj = new Creative(s, ((Integer) (obj)));
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
                    obj.linearAd = readLinear(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("CompanionAds"))
                {
                    obj.companionAds = readCompanionAds(xmlpullparser);
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return ((Creative) (obj));
    }

    private static List readCreatives(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Creatives");
        ArrayList arraylist = new ArrayList();
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
                    arraylist.add(readCreative(xmlpullparser));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return arraylist;
    }

    private static MMExtension readExtensions(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        MMExtension mmextension = null;
        xmlpullparser.require(2, null, "Extensions");
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("Extension"))
                {
                    if ("MMInteractiveVideo".equals(xmlpullparser.getAttributeValue(null, "type")))
                    {
                        mmextension = readMMExtension(xmlpullparser);
                    } else
                    {
                        skip(xmlpullparser);
                    }
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return mmextension;
    }

    private static InLineAd readInLine(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "InLine");
        InLineAd inlinead = new InLineAd();
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("Creatives"))
                {
                    inlinead.creatives = readCreatives(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("Impression"))
                {
                    String s = nextText(xmlpullparser);
                    if (!Utils.isEmpty(s))
                    {
                        inlinead.impressions.add(s);
                    }
                } else
                if (xmlpullparser.getName().equals("Extensions"))
                {
                    inlinead.mmExtension = readExtensions(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("Error"))
                {
                    String s1 = nextText(xmlpullparser);
                    if (!Utils.isEmpty(s1))
                    {
                        inlinead.error = s1;
                    }
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return inlinead;
    }

    private static LinearAd readLinear(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Linear");
        LinearAd linearad = new LinearAd(xmlpullparser.getAttributeValue(null, "skipoffset"));
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("MediaFiles"))
                {
                    linearad.mediaFiles = readMediaFiles(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("TrackingEvents"))
                {
                    linearad.trackingEvents = readTrackingEvents(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("VideoClicks"))
                {
                    linearad.videoClicks = readVideoClicks(xmlpullparser);
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return linearad;
    }

    private static MMExtension readMMExtension(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Extension");
        Overlay overlay = null;
        Background background = null;
        List list = null;
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("Overlay"))
                {
                    boolean flag = toBoolean(xmlpullparser.getAttributeValue(null, "hideButtons"), true);
                    overlay = new Overlay(nextText(xmlpullparser), flag);
                } else
                if (xmlpullparser.getName().equals("Background"))
                {
                    background = readBackground(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("Buttons"))
                {
                    list = readButtons(xmlpullparser);
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return new MMExtension(overlay, background, list);
    }

    private static List readMediaFiles(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "MediaFiles");
        ArrayList arraylist = new ArrayList();
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
                    try
                    {
                        String s = xmlpullparser.getAttributeValue(null, "type");
                        String s1 = xmlpullparser.getAttributeValue(null, "delivery");
                        int i = Integer.parseInt(xmlpullparser.getAttributeValue(null, "width"));
                        int j = Integer.parseInt(xmlpullparser.getAttributeValue(null, "height"));
                        int k = Integer.parseInt(xmlpullparser.getAttributeValue(null, "bitrate"));
                        boolean flag = Boolean.parseBoolean(xmlpullparser.getAttributeValue(null, "maintainAspectRatio"));
                        arraylist.add(new MediaFile(nextText(xmlpullparser), s, s1, i, j, k, flag));
                    }
                    catch (NumberFormatException numberformatexception)
                    {
                        MMLog.e(TAG, "Skipping malformed MediaFile element in VAST response.", numberformatexception);
                    }
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return arraylist;
    }

    private static Map readTrackingEvents(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        HashMap hashmap;
        xmlpullparser.require(2, null, "TrackingEvents");
        hashmap = new HashMap();
_L3:
        Object obj;
        Object obj1;
        String s;
        if (xmlpullparser.next() == 3)
        {
            break; /* Loop/switch isn't completed */
        }
        if (xmlpullparser.getEventType() != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!xmlpullparser.getName().equals("Tracking"))
        {
            break MISSING_BLOCK_LABEL_222;
        }
        s = xmlpullparser.getAttributeValue(null, "event");
        obj = xmlpullparser.getAttributeValue(null, "offset");
        obj1 = nextText(xmlpullparser);
        if (Utils.isEmpty(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        TrackableEvent trackableevent;
        trackableevent = TrackableEvent.valueOf(s.trim());
        if (!TrackableEvent.progress.equals(trackableevent))
        {
            break MISSING_BLOCK_LABEL_208;
        }
        obj = new ProgressEvent(((String) (obj1)), ((String) (obj)));
_L1:
        List list = (List)hashmap.get(trackableevent);
        obj1 = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        obj1 = new ArrayList();
        hashmap.put(trackableevent, obj1);
        ((List) (obj1)).add(obj);
        continue; /* Loop/switch isn't completed */
        try
        {
            obj = new TrackingEvent(trackableevent, ((String) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Unsupported VAST event type: ").append(s).toString());
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L1
        skip(xmlpullparser);
        if (true) goto _L3; else goto _L2
_L2:
        return hashmap;
    }

    private static VideoClicks readVideoClicks(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "VideoClicks");
        VideoClicks videoclicks = new VideoClicks(null, new ArrayList(), new ArrayList());
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("ClickThrough"))
                {
                    videoclicks.clickThrough = nextText(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("ClickTracking"))
                {
                    videoclicks.clickTrackingUrls.add(nextText(xmlpullparser));
                } else
                if (xmlpullparser.getName().equals("CustomClick"))
                {
                    videoclicks.customClickUrls.add(nextText(xmlpullparser));
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return videoclicks;
    }

    private static WrapperAd readWrapper(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        xmlpullparser.require(2, null, "Wrapper");
        WrapperAd wrapperad = new WrapperAd();
        do
        {
            if (xmlpullparser.next() == 3)
            {
                break;
            }
            if (xmlpullparser.getEventType() == 2)
            {
                if (xmlpullparser.getName().equals("VASTAdTagURI"))
                {
                    wrapperad.adTagURI = nextText(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("Creatives"))
                {
                    wrapperad.creatives = readCreatives(xmlpullparser);
                } else
                if (xmlpullparser.getName().equals("Impression"))
                {
                    String s = nextText(xmlpullparser);
                    if (!Utils.isEmpty(s))
                    {
                        wrapperad.impressions.add(s);
                    }
                } else
                if (xmlpullparser.getName().equals("Error"))
                {
                    String s1 = nextText(xmlpullparser);
                    if (!Utils.isEmpty(s1))
                    {
                        wrapperad.error = s1;
                    }
                } else
                {
                    skip(xmlpullparser);
                }
            }
        } while (true);
        return wrapperad;
    }

    private static void skip(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
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

    private static boolean toBoolean(String s, boolean flag)
    {
        if (s == null)
        {
            return flag;
        } else
        {
            return Boolean.parseBoolean(s);
        }
    }

}
