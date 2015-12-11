// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.device.ads:
//            Log

public class AdProperties
{
    public static final class AdType extends Enum
    {

        private static final AdType $VALUES[];
        public static final AdType IMAGE_BANNER;
        public static final AdType INTERSTITIAL;
        public static final AdType MRAID_1;
        public static final AdType MRAID_2;
        private final String adTypeMetricTag;
        private final String type;

        public static AdType valueOf(String s)
        {
            return (AdType)Enum.valueOf(com/amazon/device/ads/AdProperties$AdType, s);
        }

        public static AdType[] values()
        {
            return (AdType[])$VALUES.clone();
        }

        String getAdTypeMetricTag()
        {
            return adTypeMetricTag;
        }

        public String toString()
        {
            return type;
        }

        static 
        {
            IMAGE_BANNER = new AdType("IMAGE_BANNER", 0, "Image Banner");
            MRAID_1 = new AdType("MRAID_1", 1, "MRAID 1.0");
            MRAID_2 = new AdType("MRAID_2", 2, "MRAID 2.0");
            INTERSTITIAL = new AdType("INTERSTITIAL", 3, "Interstitial", "i");
            $VALUES = (new AdType[] {
                IMAGE_BANNER, MRAID_1, MRAID_2, INTERSTITIAL
            });
        }

        private AdType(String s, int i, String s1)
        {
            this(s, i, s1, null);
        }

        private AdType(String s, int i, String s1, String s2)
        {
            super(s, i);
            type = s1;
            adTypeMetricTag = s2;
        }
    }


    private static final String LOG_TAG = "AdProperties";
    private AdType adType_;
    private boolean canExpand_;
    private boolean canPlayAudio_;
    private boolean canPlayVideo_;

    protected AdProperties()
    {
        canExpand_ = false;
        canPlayAudio_ = false;
        canPlayVideo_ = false;
    }

    AdProperties(JSONArray jsonarray)
    {
        canExpand_ = false;
        canPlayAudio_ = false;
        canPlayVideo_ = false;
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L13:
        if (i >= jsonarray.length()) goto _L2; else goto _L3
_L3:
        jsonarray.getInt(i);
        JVM INSTR tableswitch 1001 1017: default 207
    //                   1001 120
    //                   1002 120
    //                   1003 150
    //                   1004 150
    //                   1005 207
    //                   1006 207
    //                   1007 158
    //                   1008 168
    //                   1009 207
    //                   1010 207
    //                   1011 207
    //                   1012 207
    //                   1013 207
    //                   1014 178
    //                   1015 207
    //                   1016 186
    //                   1017 196;
           goto _L4 _L5 _L5 _L6 _L6 _L4 _L4 _L7 _L8 _L4 _L4 _L4 _L4 _L4 _L9 _L4 _L10 _L11
_L5:
        JSONException jsonexception;
        canPlayAudio_ = true;
          goto _L4
_L6:
        try
        {
            canExpand_ = true;
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            Log.w("AdProperties", "Unable to parse creative type: %s", new Object[] {
                jsonexception.getMessage()
            });
        }
          goto _L4
_L7:
        adType_ = AdType.IMAGE_BANNER;
          goto _L4
_L8:
        adType_ = AdType.INTERSTITIAL;
          goto _L4
_L9:
        canPlayVideo_ = true;
          goto _L4
_L10:
        adType_ = AdType.MRAID_1;
          goto _L4
_L11:
        adType_ = AdType.MRAID_2;
          goto _L4
_L2:
        return;
_L4:
        i++;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public boolean canExpand()
    {
        return canExpand_;
    }

    public boolean canPlayAudio()
    {
        return canPlayAudio_;
    }

    public boolean canPlayVideo()
    {
        return canPlayVideo_;
    }

    public AdType getAdType()
    {
        return adType_;
    }

    void setAdType(AdType adtype)
    {
        adType_ = adtype;
    }

    void setCanExpand(boolean flag)
    {
        canExpand_ = flag;
    }

    void setCanPlayAudio(boolean flag)
    {
        canPlayAudio_ = flag;
    }

    void setCanPlayVideo(boolean flag)
    {
        canPlayVideo_ = flag;
    }
}
