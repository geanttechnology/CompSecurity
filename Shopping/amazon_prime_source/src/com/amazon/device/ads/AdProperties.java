// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, MobileAdsLogger

public class AdProperties
{
    public static final class AdType extends Enum
    {

        private static final AdType $VALUES[];
        public static final AdType IMAGE_BANNER;
        public static final AdType INTERSTITIAL;
        public static final AdType MODELESS_INTERSTITIAL;
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
            MODELESS_INTERSTITIAL = new AdType("MODELESS_INTERSTITIAL", 4, "Modeless Interstitial", "mi");
            $VALUES = (new AdType[] {
                IMAGE_BANNER, MRAID_1, MRAID_2, INTERSTITIAL, MODELESS_INTERSTITIAL
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


    public static final int CAN_EXPAND1 = 1003;
    public static final int CAN_EXPAND2 = 1004;
    public static final int CAN_PLAY_AUDIO1 = 1001;
    public static final int CAN_PLAY_AUDIO2 = 1002;
    public static final int CAN_PLAY_VIDEO = 1014;
    public static final int HTML = 1007;
    public static final int INTERSTITIAL = 1008;
    private static final String LOGTAG = com/amazon/device/ads/AdProperties.getSimpleName();
    public static final int MRAID1 = 1016;
    public static final int MRAID2 = 1017;
    public static final int REQUIRES_TRANSPARENCY = 1031;
    public static final int VIDEO_INTERSTITIAL = 1030;
    private AdType adType_;
    private boolean canExpand_;
    private boolean canPlayAudio_;
    private boolean canPlayVideo_;
    private final MobileAdsLogger logger;

    AdProperties(JSONArray jsonarray)
    {
        this(jsonarray, new MobileAdsLoggerFactory());
    }

    AdProperties(JSONArray jsonarray, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        canExpand_ = false;
        canPlayAudio_ = false;
        canPlayVideo_ = false;
        logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L13:
        if (i >= jsonarray.length()) goto _L2; else goto _L3
_L3:
        jsonarray.getInt(i);
        JVM INSTR tableswitch 1001 1017: default 221
    //                   1001 132
    //                   1002 132
    //                   1003 164
    //                   1004 164
    //                   1005 221
    //                   1006 221
    //                   1007 172
    //                   1008 182
    //                   1009 221
    //                   1010 221
    //                   1011 221
    //                   1012 221
    //                   1013 221
    //                   1014 192
    //                   1015 221
    //                   1016 200
    //                   1017 210;
           goto _L4 _L5 _L5 _L6 _L6 _L4 _L4 _L7 _L8 _L4 _L4 _L4 _L4 _L4 _L9 _L4 _L10 _L11
_L5:
        canPlayAudio_ = true;
          goto _L4
_L6:
        try
        {
            canExpand_ = true;
        }
        // Misplaced declaration of an exception variable
        catch (MobileAdsLoggerFactory mobileadsloggerfactory)
        {
            logger.w("Unable to parse creative type: %s", new Object[] {
                mobileadsloggerfactory.getMessage()
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
