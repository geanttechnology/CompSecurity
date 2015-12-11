// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.mediameasurement;

import com.adobe.adms.measurement.ADMS_Measurement;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

// Referenced classes of package com.adobe.adms.mediameasurement:
//            ADMS_MediaItem, ADMS_MediaState, ADMS_MediaMeasurementDelegate

public class ADMS_MediaMeasurement
{
    private static class ADMS_MediaMeasurementHolder
    {

        public static ADMS_MediaMeasurement baseInstance = new ADMS_MediaMeasurement();


        private ADMS_MediaMeasurementHolder()
        {
        }
    }


    public String channel;
    public int completeCloseOffsetThreshold;
    public Hashtable contextDataMapping;
    public ADMS_MediaMeasurementDelegate _flddelegate;
    protected Hashtable list;
    public boolean segmentByMilestones;
    public boolean segmentByOffsetMilestones;
    public String trackEvents;
    public String trackMilestones;
    public String trackOffsetMilestones;
    public int trackSeconds;
    public String trackVars;

    private ADMS_MediaMeasurement()
    {
        list = null;
        trackVars = "";
        trackEvents = "";
        channel = "";
        trackSeconds = 0;
        completeCloseOffsetThreshold = 1;
        trackMilestones = "";
        segmentByMilestones = false;
        trackOffsetMilestones = "";
        segmentByOffsetMilestones = false;
        contextDataMapping = null;
        _flddelegate = null;
    }


    private boolean isInteger(Object obj)
    {
        boolean flag = false;
        try
        {
            obj = (Integer)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (obj != null)
        {
            flag = true;
        }
        return flag;
    }

    private boolean isString(Object obj)
    {
        boolean flag = false;
        try
        {
            obj = (String)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (obj != null)
        {
            flag = true;
        }
        return flag;
    }

    public static ADMS_MediaMeasurement sharedInstance()
    {
        return ADMS_MediaMeasurementHolder.baseInstance;
    }

    private String toString(Object obj)
    {
        return (String)obj;
    }

    protected void buildContextData(Hashtable hashtable, Hashtable hashtable1, ADMS_MediaItem adms_mediaitem)
    {
        StringBuffer stringbuffer;
        StringBuffer stringbuffer1;
        StringBuffer stringbuffer2;
        stringbuffer = new StringBuffer(String.valueOf(hashtable1.get("linkTrackVars")));
        stringbuffer1 = new StringBuffer(String.valueOf(hashtable1.get("linkTrackEvents")));
        String s = "m_i";
        hashtable.put("a.contentType", "video");
        if (isSet(channel))
        {
            hashtable.put((new StringBuilder()).append("a.media.").append("channel").toString(), channel);
        }
        hashtable.put((new StringBuilder()).append("a.media.").append("name").toString(), adms_mediaitem.name);
        hashtable.put((new StringBuilder()).append("a.media.").append("playerName").toString(), adms_mediaitem.playerName);
        if (adms_mediaitem.length > 0.0D)
        {
            hashtable.put((new StringBuilder()).append("a.media.").append("length").toString(), (new StringBuilder()).append("").append((int)adms_mediaitem.length).toString());
        }
        hashtable.put((new StringBuilder()).append("a.media.").append("timePlayed").toString(), (new StringBuilder()).append("").append((int)Math.floor(adms_mediaitem.timePlayedSinceTrack)).toString());
        if (!adms_mediaitem.viewTracked)
        {
            hashtable.put((new StringBuilder()).append("a.media.").append("view").toString(), String.valueOf(true));
            s = "m_s";
            adms_mediaitem.viewTracked = true;
        }
        if (isSet(adms_mediaitem.segment))
        {
            hashtable.put((new StringBuilder()).append("a.media.").append("segmentNum").toString(), (new StringBuilder()).append("").append(adms_mediaitem.segmentNum).toString());
            hashtable.put((new StringBuilder()).append("a.media.").append("segment").toString(), adms_mediaitem.segment);
            if (adms_mediaitem.segmentLength > 0.0D)
            {
                hashtable.put((new StringBuilder()).append("a.media.").append("segmentLength").toString(), (new StringBuilder()).append("").append(adms_mediaitem.segmentLength).toString());
            }
            if (adms_mediaitem.segmentChanged && adms_mediaitem.timePlayedSinceTrack > 0.0D)
            {
                hashtable.put((new StringBuilder()).append("a.media.").append("segmentView").toString(), String.valueOf(true));
            }
        }
        if (!adms_mediaitem.completeTracked && adms_mediaitem.complete)
        {
            hashtable.put((new StringBuilder()).append("a.media.").append("complete").toString(), String.valueOf(true));
            adms_mediaitem.completeTracked = true;
        }
        if (adms_mediaitem.lastMilestone > 0)
        {
            hashtable.put((new StringBuilder()).append("a.media.").append("milestone").toString(), (new StringBuilder()).append("").append(adms_mediaitem.lastMilestone).toString());
        }
        if (adms_mediaitem.lastOffsetMilestone > 0)
        {
            hashtable.put((new StringBuilder()).append("a.media.").append("offsetMilestone").toString(), (new StringBuilder()).append("").append(adms_mediaitem.lastOffsetMilestone).toString());
        }
        hashtable1.put("pe", s);
        hashtable1.put("pev3", "video");
        stringbuffer2 = new StringBuffer();
        if (!isSet(contextDataMapping)) goto _L2; else goto _L1
_L1:
        Enumeration enumeration = contextDataMapping.keys();
_L8:
        Object obj1;
        String s4;
        if (!enumeration.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (String)enumeration.nextElement();
        Object obj;
        String as[];
        int i;
        if (((String) (obj1)).length() > "a.media.".length() && ((String) (obj1)).substring(0, "a.media.".length()).equals("a.media."))
        {
            adms_mediaitem = ((String) (obj1)).substring("a.media.".length());
        } else
        {
            adms_mediaitem = "";
        }
        obj = contextDataMapping.get(obj1);
        if (!isString(obj) || !hashtable.containsKey(obj1))
        {
            break MISSING_BLOCK_LABEL_1384;
        }
        as = ((String)obj).split(",");
        i = 0;
_L4:
        if (i >= as.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        s4 = as[i];
        if (!((String) (obj1)).equals("a.contentType"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (stringbuffer.length() > 0)
        {
            stringbuffer.append(",");
            stringbuffer.append(String.valueOf(s4));
        }
        hashtable1.put((String)s4, (String)(String)hashtable.get(obj1));
_L6:
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (adms_mediaitem.equals("")) goto _L6; else goto _L5
_L5:
        if (adms_mediaitem.equals("view") || adms_mediaitem.equals("segmentView") || adms_mediaitem.equals("complete") || adms_mediaitem.equals("timePlayed"))
        {
            if (adms_mediaitem.equals("timePlayed"))
            {
                if (isSet(hashtable.get(obj1)) && Integer.valueOf(String.valueOf(hashtable.get(obj1))).intValue() > 0)
                {
                    String s1;
                    if (stringbuffer2.length() > 0)
                    {
                        s1 = ",";
                    } else
                    {
                        s1 = "";
                    }
                    stringbuffer2.append(s1);
                    stringbuffer2.append(String.valueOf(s4));
                    stringbuffer2.append("=");
                    stringbuffer2.append(hashtable.get(obj1));
                    if (stringbuffer1.length() > 0)
                    {
                        stringbuffer1.append(",");
                        stringbuffer1.append(String.valueOf(s4));
                        stringbuffer1.append("=");
                        stringbuffer1.append(hashtable.get(obj1));
                    }
                }
            } else
            if (isSet(hashtable.get(obj1)))
            {
                String s2;
                if (stringbuffer2.length() > 0)
                {
                    s2 = ",";
                } else
                {
                    s2 = "";
                }
                stringbuffer2.append(s2);
                stringbuffer2.append(String.valueOf(s4));
                if (stringbuffer1.length() > 0)
                {
                    stringbuffer1.append(",");
                    stringbuffer1.append(String.valueOf(s4));
                }
            }
        } else
        if (adms_mediaitem.equals("segment") && hashtable.containsKey((new StringBuilder()).append(((String) (obj1))).append("Num").toString()) && isSet(hashtable.get((new StringBuilder()).append(((String) (obj1))).append("Num").toString())))
        {
            if (stringbuffer.length() > 0)
            {
                stringbuffer.append(",");
                stringbuffer.append(String.valueOf(s4));
            }
            hashtable1.put(String.valueOf(s4), (new StringBuilder()).append("").append(hashtable.get((new StringBuilder()).append(((String) (obj1))).append("Num").toString())).append(":").append(String.valueOf(hashtable.get(obj1))).toString());
        } else
        {
            if (stringbuffer.length() > 0)
            {
                stringbuffer.append(",");
                stringbuffer.append(String.valueOf(s4));
            }
            hashtable1.put(String.valueOf(s4), String.valueOf(hashtable.get(obj1)));
        }
          goto _L6
        if (adms_mediaitem.equals("milestones") || adms_mediaitem.equals("offsetMilestones"))
        {
            String s3 = ((String) (obj1)).substring(0, ((String) (obj1)).length() - 1);
            obj1 = (Hashtable)contextDataMapping.get((new StringBuilder()).append(s3).append("s").toString());
            if (hashtable.containsKey(s3) && isSet(hashtable.get(s3)) && ((Hashtable) (obj1)).containsKey(hashtable.get(s3)))
            {
                if (stringbuffer1.length() > 0)
                {
                    stringbuffer1.append(",");
                    stringbuffer1.append(((Hashtable) (obj1)).get(hashtable.get(s3)));
                }
                if (stringbuffer2.length() > 0)
                {
                    adms_mediaitem = ",";
                } else
                {
                    adms_mediaitem = "";
                }
                stringbuffer2.append(adms_mediaitem);
                stringbuffer2.append(((Hashtable) (obj1)).get(hashtable.get(s3)));
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
        hashtable1.put("events", stringbuffer2.toString());
_L10:
        hashtable1.put("linkTrackVars", stringbuffer.toString());
        hashtable1.put("linkTrackEvents", stringbuffer1.toString());
        return;
_L2:
        if (stringbuffer.length() == 0)
        {
            stringbuffer.append("None");
        }
        hashtable = hashtable.keys();
        while (hashtable.hasMoreElements()) 
        {
            stringbuffer.append(",contextdata.");
            stringbuffer.append((String)hashtable.nextElement());
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected String cleanName(String s)
    {
        return s.replace("\n", "").replace("\r", "").replace("--**--", "");
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public void close(String s)
    {
        playerEvent(s, 0, -1D, 0, null, -1D, null);
    }

    public void complete(String s, double d)
    {
        playerEvent(s, 5, d, 0, null, -1D, null);
    }

    protected boolean isBoolean(Object obj)
    {
        boolean flag = false;
        try
        {
            obj = (Boolean)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        if (obj != null)
        {
            flag = true;
        }
        return flag;
    }

    protected boolean isSet(double d)
    {
        return d != 0.0D;
    }

    protected boolean isSet(float f)
    {
        return (double)f != 0.0D;
    }

    protected boolean isSet(int i)
    {
        return i != 0;
    }

    protected boolean isSet(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (isString(obj))
        {
            return isSet(toString(obj));
        }
        if (isInteger(obj))
        {
            return isSet(toInteger(obj));
        }
        if (isBoolean(obj))
        {
            return isSet(toBoolean(obj));
        } else
        {
            return true;
        }
    }

    protected boolean isSet(String s)
    {
        while (s == null || s.length() == 0) 
        {
            return false;
        }
        return true;
    }

    protected boolean isSet(boolean flag)
    {
        return flag;
    }

    public void open(String s, double d, String s1)
    {
        open(s, d, s1, null);
    }

    public void open(String s, double d, String s1, String s2)
    {
        ADMS_MediaItem adms_mediaitem = new ADMS_MediaItem();
        double d1;
        String s3;
        if (!isSet(s1))
        {
            s1 = "Not_Specified";
        }
        s3 = cleanName(s1);
        s1 = s;
        if (isSet(s))
        {
            s1 = cleanName(s);
        }
        d1 = d;
        if (!isSet(d))
        {
            d1 = -1D;
        }
        if (isSet(s1) && isSet(s3))
        {
            if (!isSet(list))
            {
                list = new Hashtable();
            }
            if (list.containsKey(s1))
            {
                close(s1);
            }
            if (isSet(s2))
            {
                s = list.keys();
                do
                {
                    if (!s.hasMoreElements())
                    {
                        break;
                    }
                    String s4 = (String)s.nextElement();
                    if (list.containsKey(s4) && ((ADMS_MediaItem)(ADMS_MediaItem)list.get(s4)).playerID.equals(s2))
                    {
                        close(s4);
                    }
                } while (true);
            }
            adms_mediaitem.name = s1;
            adms_mediaitem.length = d1;
            adms_mediaitem.offset = 0.0D;
            adms_mediaitem.percent = 0.0D;
            adms_mediaitem.playerName = cleanName(s3);
            adms_mediaitem.playerID = s2;
            adms_mediaitem.timePlayed = 0.0D;
            adms_mediaitem.timePlayedSinceTrack = 0.0D;
            adms_mediaitem.timestamp = Math.floor((double)System.currentTimeMillis() / 1000D);
            adms_mediaitem.lastEventType = 0;
            adms_mediaitem.lastEventTimestamp = adms_mediaitem.timestamp;
            adms_mediaitem.lastEventOffset = 0.0D;
            adms_mediaitem.session = "";
            adms_mediaitem.lastTrackOffset = -1D;
            adms_mediaitem.trackCount = 0;
            adms_mediaitem.firstEventList = new Hashtable();
            adms_mediaitem.viewTracked = false;
            adms_mediaitem.segmentNum = 0;
            adms_mediaitem.segment = "";
            adms_mediaitem.segmentLength = 0.0D;
            adms_mediaitem.segmentGenerated = false;
            adms_mediaitem.segmentChanged = false;
            adms_mediaitem.lastMilestone = 0;
            adms_mediaitem.lastOffsetMilestone = 0;
            adms_mediaitem.m = this;
            list.put(s1, adms_mediaitem);
        }
    }

    public void play(String s, double d)
    {
        String s1 = s;
        if (isSet(s))
        {
            s1 = cleanName(s);
        }
        playerEvent(s1, 1, d, 0, null, -1D, null);
        if (isSet(s1) && isSet(list) && list.containsKey(s1))
        {
            ((ADMS_MediaItem)(ADMS_MediaItem)list.get(s1)).startMonitor();
        }
    }

    protected ADMS_MediaItem playerEvent(String s, int i, double d, int j, String s1, double d1, Object obj)
    {
        double d2;
        double d6;
        double d7;
        Object obj1;
        Object obj2;
        ADMS_MediaItem adms_mediaitem;
        Object obj3;
        String s2;
        ADMS_MediaState adms_mediastate;
        String s4;
        String s5;
        int k;
        int l;
        int l2;
        boolean flag;
        boolean flag1;
        d7 = Math.floor((double)System.currentTimeMillis() / 1000D);
        s2 = trackVars;
        String s3 = trackEvents;
        d6 = trackSeconds;
        s5 = trackMilestones;
        s4 = trackOffsetMilestones;
        flag = segmentByMilestones;
        flag1 = segmentByOffsetMilestones;
        k = 1;
        int i1 = 1;
        obj3 = s;
        if (isSet(s))
        {
            obj3 = cleanName(s);
        }
        if (isSet(((String) (obj3))) && isSet(list) && list.containsKey(obj3))
        {
            adms_mediaitem = (ADMS_MediaItem)(ADMS_MediaItem)list.get(obj3);
        } else
        {
            adms_mediaitem = null;
        }
        if (adms_mediaitem == null)
        {
            break MISSING_BLOCK_LABEL_2836;
        }
        d1 = d;
        if (d < 0.0D)
        {
            if (adms_mediaitem.lastEventType == 1 && adms_mediaitem.lastEventTimestamp > 0.0D)
            {
                d1 = (d7 - adms_mediaitem.lastEventTimestamp) + adms_mediaitem.lastEventOffset;
            } else
            {
                d1 = adms_mediaitem.lastEventOffset;
            }
        }
        d2 = d1;
        if (adms_mediaitem.length > 0.0D)
        {
            if (d1 < adms_mediaitem.length)
            {
                d2 = d1;
            } else
            {
                d2 = adms_mediaitem.length;
            }
        }
        d = d2;
        if (d2 < 0.0D)
        {
            d = 0.0D;
        }
        adms_mediaitem.offset = d;
        if (adms_mediaitem.length > 0.0D)
        {
            adms_mediaitem.percent = (adms_mediaitem.offset / adms_mediaitem.length) * 100D;
            int l1;
            if (adms_mediaitem.percent > 100D)
            {
                d1 = 100D;
            } else
            {
                d1 = adms_mediaitem.percent;
            }
            adms_mediaitem.percent = d1;
        }
        if (adms_mediaitem.lastEventOffset < 0.0D)
        {
            adms_mediaitem.lastEventOffset = d;
        }
        l2 = adms_mediaitem.trackCount;
        adms_mediastate = new ADMS_MediaState();
        adms_mediastate.name = ((String) (obj3));
        adms_mediastate.length = adms_mediaitem.length;
        adms_mediastate.openTime = new Date();
        adms_mediastate.openTime.setTime((long)adms_mediaitem.timestamp);
        adms_mediastate.offset = adms_mediaitem.offset;
        adms_mediastate.percent = adms_mediaitem.percent;
        adms_mediastate.playerName = adms_mediaitem.playerName;
        if (adms_mediaitem.lastTrackOffset >= 0.0D) goto _L2; else goto _L1
_L1:
        adms_mediastate.mediaEvent = "OPEN";
_L23:
        if (i <= 2 && (i == adms_mediaitem.lastEventType || i == 2 && adms_mediaitem.lastEventType != 1))
        {
            break MISSING_BLOCK_LABEL_2836;
        }
        s = s1;
        if (!isSet(s1))
        {
            j = adms_mediaitem.segmentNum;
            s = adms_mediaitem.segment;
        }
        obj = s3;
        obj1 = s2;
        l = j;
        obj2 = s;
        if (i <= 0) goto _L4; else goto _L3
_L3:
        if (i == 1)
        {
            adms_mediaitem.lastEventOffset = d;
        }
        if (i <= 3) goto _L6; else goto _L5
_L5:
        k = i1;
        obj = s3;
        obj1 = s2;
        if (i != 5) goto _L7; else goto _L6
_L6:
        k = i1;
        obj = s3;
        obj1 = s2;
        if (adms_mediaitem.lastTrackOffset < 0.0D) goto _L7; else goto _L8
_L8:
        l1 = 0;
        k = 0;
        i1 = 0;
        obj2 = "None";
        s2 = "None";
        obj = s2;
        obj1 = obj2;
        if (Math.abs(adms_mediaitem.lastTrackOffset - d) <= 0.0001D) goto _L7; else goto _L9
_L9:
        d2 = adms_mediaitem.lastTrackOffset;
        d1 = d2;
        if (d2 > d)
        {
            d2 = adms_mediaitem.lastEventOffset;
            d1 = d2;
            if (d2 > d)
            {
                d1 = d;
            }
        }
        if (isSet(s5))
        {
            s1 = s5.split(",");
        } else
        {
            s1 = null;
        }
        l = l1;
        if (adms_mediaitem.length <= 0.0D) goto _L11; else goto _L10
_L10:
        l = l1;
        if (!isSet(s1)) goto _L11; else goto _L12
_L12:
        l = l1;
        if (d < d1) goto _L11; else goto _L13
_L13:
        l = 0;
        k = i1;
        i1 = l;
_L17:
        l = k;
        if (i1 >= s1.length) goto _L11; else goto _L14
_L14:
        if (!isSet(s1[i1])) goto _L16; else goto _L15
_L15:
        l = Integer.parseInt((new StringBuilder()).append("").append(s1[i1]).toString());
_L18:
        d2 = l;
_L19:
        l1 = i1;
        l = k;
        if (isSet(d2))
        {
            l1 = i1;
            l = k;
            if ((d1 / adms_mediaitem.length) * 100D < d2)
            {
                l1 = i1;
                l = k;
                if (adms_mediaitem.percent >= d2)
                {
                    l = 1;
                    adms_mediastate.mediaEvent = "MILESTONE";
                    k = (int)d2;
                    adms_mediastate.milestone = k;
                    adms_mediaitem.lastMilestone = k;
                    l1 = s1.length;
                }
            }
        }
        i1 = l1 + 1;
        k = l;
          goto _L17
_L2:
        switch (i)
        {
        default:
            adms_mediastate.mediaEvent = "CLOSE";
            break;

        case 1: // '\001'
            adms_mediastate.mediaEvent = "PLAY";
            break;

        case 2: // '\002'
            adms_mediastate.mediaEvent = "STOP";
            break;

        case 3: // '\003'
            adms_mediastate.mediaEvent = "MONITOR";
            break;

        case 4: // '\004'
            adms_mediastate.mediaEvent = "TRACK";
            break;

        case 5: // '\005'
            adms_mediastate.mediaEvent = "COMPLETE";
            break;
        }
        continue; /* Loop/switch isn't completed */
_L16:
        l = 0;
          goto _L18
        obj;
        d2 = 0.0D;
          goto _L19
_L11:
        int j1;
        int i2;
        if (isSet(s4))
        {
            s1 = s4.split(",");
        } else
        {
            s1 = null;
        }
        k = l;
        obj = s2;
        obj1 = obj2;
        if (!isSet(s1)) goto _L7; else goto _L20
_L20:
        k = l;
        obj = s2;
        obj1 = obj2;
        if (d < d1) goto _L7; else goto _L21
_L21:
        j1 = 0;
_L26:
label0:
        {
            k = l;
            obj = s2;
            obj1 = obj2;
            if (j1 < s1.length)
            {
                break label0;
            }
        }
          goto _L7
        if (true) goto _L23; else goto _L22
_L22:
        if (!isSet(s1[j1])) goto _L25; else goto _L24
_L24:
        k = Integer.parseInt((new StringBuilder()).append("").append(s1[j1]).toString());
_L27:
        d2 = k;
_L28:
        i2 = j1;
        k = l;
        if (isSet(d2))
        {
            i2 = j1;
            k = l;
            if (d1 < d2)
            {
                i2 = j1;
                k = l;
                if (d >= d2)
                {
                    k = 1;
                    adms_mediastate.mediaEvent = "OFFSET_MILESTONE";
                    l = (int)d2;
                    adms_mediastate.offsetMilestone = l;
                    adms_mediaitem.lastOffsetMilestone = l;
                    i2 = s1.length;
                }
            }
        }
        j1 = i2 + 1;
        l = k;
          goto _L26
_L25:
        k = 0;
          goto _L27
        obj;
        d2 = 0.0D;
          goto _L28
_L7:
        int k1;
        if (!adms_mediaitem.segmentGenerated)
        {
            l = j;
            obj2 = s;
            if (isSet(s))
            {
                break MISSING_BLOCK_LABEL_1974;
            }
        }
        if (!flag || !isSet(s5) || adms_mediaitem.length <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_1569;
        }
        obj2 = (new StringBuilder()).append(s5).append(",100").toString().split(",");
        k1 = j;
        s1 = s;
        if (!isSet(obj2))
        {
            break MISSING_BLOCK_LABEL_1943;
        }
        d2 = 0.0D;
        k1 = 0;
        l = j;
        j = k1;
_L31:
        k1 = l;
        s1 = s;
        if (j >= obj2.length)
        {
            break MISSING_BLOCK_LABEL_1943;
        }
        if (!isSet(obj2[j])) goto _L30; else goto _L29
_L29:
        k1 = Integer.parseInt((new StringBuilder()).append("").append(obj2[j]).toString());
_L32:
        d1 = k1;
_L33:
        k1 = j;
        double d4 = d2;
        int j2 = l;
        s1 = s;
        if (isSet(d1))
        {
            k1 = j;
            if (adms_mediaitem.percent < d1)
            {
                l = j + 1;
                s = (new StringBuilder()).append("M:").append(String.format("%1.0f", new Object[] {
                    Double.valueOf(d2)
                })).append("-").append(String.format("%1.0f", new Object[] {
                    Double.valueOf(d1)
                })).toString();
                k1 = obj2.length;
            }
            s1 = s;
            j2 = l;
            d4 = d1;
        }
        j = k1 + 1;
        d2 = d4;
        l = j2;
        s = s1;
          goto _L31
_L30:
        k1 = 0;
          goto _L32
        s1;
        d1 = 0.0D;
          goto _L33
        k1 = j;
        s1 = s;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_1943;
        }
        k1 = j;
        s1 = s;
        if (!isSet(s4))
        {
            break MISSING_BLOCK_LABEL_1943;
        }
        double d3;
        double d5;
        int k2;
        if (adms_mediaitem.length > 0.0D)
        {
            obj2 = (new StringBuilder()).append(s4).append(",").append((long)Math.floor(adms_mediaitem.length)).toString().split(",");
        } else
        {
            obj2 = (new StringBuilder()).append(s4).append(",").append("E").toString().split(",");
        }
        k1 = j;
        s1 = s;
        if (!isSet(obj2))
        {
            break MISSING_BLOCK_LABEL_1943;
        }
        d3 = 0.0D;
        k1 = 0;
        l = j;
        j = k1;
        k1 = l;
        s1 = s;
        if (j >= obj2.length)
        {
            break MISSING_BLOCK_LABEL_1943;
        }
        if (!isSet(obj2[j])) goto _L35; else goto _L34
_L34:
        k1 = Integer.parseInt((new StringBuilder()).append("").append(obj2[j]).toString());
_L36:
        d1 = k1;
_L37:
label1:
        {
label2:
            {
                if (!isSet(d1))
                {
                    k1 = j;
                    d5 = d3;
                    k2 = l;
                    s1 = s;
                    if (!obj2[j].equals("E"))
                    {
                        break label1;
                    }
                }
                if (d >= d1)
                {
                    k1 = j;
                    if (!obj2[j].equals("E"))
                    {
                        break label2;
                    }
                }
                l = j + 1;
                s = (new StringBuilder()).append("O:").append(String.format("%1.0f", new Object[] {
                    Double.valueOf(d3)
                })).append("-").append(obj2[j]).toString();
                k1 = obj2.length;
            }
            s1 = s;
            k2 = l;
            d5 = d1;
        }
        j = k1 + 1;
        d3 = d5;
        l = k2;
        s = s1;
        break MISSING_BLOCK_LABEL_1676;
_L35:
        k1 = 0;
          goto _L36
        s1;
        d1 = 0.0D;
          goto _L37
        l = k1;
        obj2 = s1;
        if (isSet(s1))
        {
            adms_mediaitem.segmentGenerated = true;
            obj2 = s1;
            l = k1;
        }
label3:
        {
            if (!isSet(((String) (obj2))))
            {
                j = k;
                if (!isSet(adms_mediaitem.segment))
                {
                    break label3;
                }
            }
            j = k;
            if (!((String) (obj2)).equals(adms_mediaitem.segment))
            {
                adms_mediaitem.updateSegment = true;
                if (!isSet(adms_mediaitem.segment))
                {
                    adms_mediaitem.segmentNum = l;
                    adms_mediaitem.segment = ((String) (obj2));
                }
                j = k;
                if (adms_mediaitem.lastTrackOffset >= 0.0D)
                {
                    j = 1;
                }
            }
        }
        if (i >= 2 && adms_mediaitem.lastEventOffset < d)
        {
            adms_mediaitem.timePlayed = adms_mediaitem.timePlayed + (d - adms_mediaitem.lastEventOffset);
            adms_mediaitem.timePlayedSinceTrack = adms_mediaitem.timePlayedSinceTrack + (d - adms_mediaitem.lastEventOffset);
        }
        if (i <= 2 || i == 3 && adms_mediaitem.lastEventType == 0)
        {
            s1 = (new StringBuilder()).append(adms_mediaitem.session);
            if (i == 1 || i == 3)
            {
                s = "S";
            } else
            {
                s = "E";
            }
            adms_mediaitem.session = s1.append(s).append(Math.floor(d)).toString();
            if (i == 3)
            {
                k = 1;
            } else
            {
                k = i;
            }
            adms_mediaitem.lastEventType = k;
        }
        k = j;
        if (j == 0)
        {
            k = j;
            if (adms_mediaitem.lastTrackOffset >= 0.0D)
            {
                k = j;
                if (i <= 3)
                {
                    if (d6 > 0.0D)
                    {
                        d1 = d6;
                    } else
                    {
                        d1 = 0.0D;
                    }
                    k = j;
                    if (d1 > 0.0D)
                    {
                        k = j;
                        if (adms_mediaitem.timePlayedSinceTrack >= d1)
                        {
                            k = 1;
                            adms_mediastate.mediaEvent = "SECONDS";
                        }
                    }
                }
            }
        }
        adms_mediaitem.lastEventTimestamp = d7;
        adms_mediaitem.lastEventOffset = d;
_L4:
label4:
        {
            if (i != 0)
            {
                s = ((String) (obj));
                s1 = ((String) (obj1));
                j = i;
                if (i > 3)
                {
                    break label4;
                }
                s = ((String) (obj));
                s1 = ((String) (obj1));
                j = i;
                if (adms_mediaitem.percent < 100D)
                {
                    break label4;
                }
            }
            if (adms_mediaitem.lastEventType != 2)
            {
                adms_mediaitem.session = (new StringBuilder()).append(adms_mediaitem.session).append("E").append(Math.floor(d)).toString();
            }
            j = 0;
            s1 = "None";
            s = "None";
            adms_mediastate.mediaEvent = "CLOSE";
        }
label5:
        {
            if (j != 5)
            {
                if (j != 0)
                {
                    i = k;
                    if (adms_mediaitem.percent < 100D)
                    {
                        break label5;
                    }
                }
                i = k;
                if (adms_mediaitem.length <= 0.0D)
                {
                    break label5;
                }
                i = k;
                if (d < adms_mediaitem.length - (double)completeCloseOffsetThreshold)
                {
                    break label5;
                }
            }
            adms_mediastate.complete = true;
            adms_mediaitem.complete = true;
            i = 1;
        }
        obj1 = adms_mediastate.mediaEvent;
        if (((String) (obj1)).equals("MILESTONE"))
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("_").append(adms_mediastate.milestone).toString();
        } else
        {
            obj = obj1;
            if (((String) (obj1)).equals("OFFSET_MILESTONE"))
            {
                obj = (new StringBuilder()).append(((String) (obj1))).append("_").append(adms_mediastate.offsetMilestone).toString();
            }
        }
        if (!adms_mediaitem.firstEventList.containsKey(obj))
        {
            adms_mediastate.eventFirstTime = true;
            adms_mediaitem.firstEventList.put(obj, Integer.valueOf(1));
        } else
        {
            adms_mediastate.eventFirstTime = false;
        }
        adms_mediastate.timePlayed = adms_mediaitem.timePlayed;
        adms_mediastate.segmentNum = adms_mediaitem.segmentNum;
        adms_mediastate.segment = adms_mediaitem.segment;
        adms_mediastate.segmentLength = adms_mediaitem.segmentLength;
        if (_flddelegate != null && j != 4)
        {
            _flddelegate.ADMS_MediaMeasurementMonitor(ADMS_Measurement.sharedInstance(), adms_mediastate);
        }
        if (j == 0)
        {
            list.remove(obj3);
            adms_mediaitem.stopMonitor();
        }
        if (i != 0 && adms_mediaitem.trackCount == l2)
        {
            obj1 = new Hashtable();
            obj3 = new Hashtable();
            obj = s1;
            if (!isSet(s1))
            {
                obj = "";
            }
            s1 = s;
            if (!isSet(s))
            {
                s1 = "";
            }
            ((Hashtable) (obj1)).put("linkTrackVars", obj);
            ((Hashtable) (obj1)).put("linkTrackEvents", s1);
            buildContextData(((Hashtable) (obj3)), ((Hashtable) (obj1)), adms_mediaitem);
            ADMS_Measurement.sharedInstance().track(((Hashtable) (obj3)), ((Hashtable) (obj1)));
            if (adms_mediaitem.updateSegment)
            {
                adms_mediaitem.segmentNum = l;
                adms_mediaitem.segment = ((String) (obj2));
                adms_mediaitem.segmentChanged = true;
                adms_mediaitem.updateSegment = false;
            } else
            if (adms_mediaitem.timePlayedSinceTrack > 0.0D)
            {
                adms_mediaitem.segmentChanged = false;
            }
            adms_mediaitem.session = "";
            adms_mediaitem.lastMilestone = 0;
            adms_mediaitem.lastOffsetMilestone = 0;
            adms_mediaitem.timePlayedSinceTrack = adms_mediaitem.timePlayedSinceTrack - Math.floor(adms_mediaitem.timePlayedSinceTrack);
            adms_mediaitem.lastTrackOffset = d;
            adms_mediaitem.trackCount = adms_mediaitem.trackCount + 1;
        }
        return adms_mediaitem;
          goto _L26
    }

    public void stop(String s, double d)
    {
        playerEvent(s, 2, d, 0, null, -1D, null);
    }

    protected boolean toBoolean(Object obj)
    {
        return ((Boolean)obj).booleanValue();
    }

    protected int toInteger(Object obj)
    {
        return ((Integer)obj).intValue();
    }

    public void track(String s)
    {
        playerEvent(s, 4, -1D, 0, null, -1D, null);
    }
}
