// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            MetricsCollector, AdProperties, AdSize

class AdData
{
    protected static final class AAXCreative extends Enum
    {

        private static final AAXCreative $VALUES[];
        public static final AAXCreative HTML;
        public static final AAXCreative INTERSTITIAL;
        public static final AAXCreative MRAID1;
        private final int id;

        static AAXCreative getCreative(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 1007: 
                return HTML;

            case 1016: 
                return MRAID1;

            case 1008: 
                return INTERSTITIAL;
            }
        }

        static AAXCreative getTopCreative(Set set)
        {
            AAXCreative aaxcreative = null;
            if (set.contains(MRAID1))
            {
                aaxcreative = MRAID1;
            } else
            if (set.contains(HTML))
            {
                return HTML;
            }
            return aaxcreative;
        }

        public static AAXCreative valueOf(String s)
        {
            return (AAXCreative)Enum.valueOf(com/amazon/device/ads/AdData$AAXCreative, s);
        }

        public static AAXCreative[] values()
        {
            return (AAXCreative[])$VALUES.clone();
        }

        public int getId()
        {
            return id;
        }

        static 
        {
            HTML = new AAXCreative("HTML", 0, 1007);
            MRAID1 = new AAXCreative("MRAID1", 1, 1016);
            INTERSTITIAL = new AAXCreative("INTERSTITIAL", 2, 1008);
            $VALUES = (new AAXCreative[] {
                HTML, MRAID1, INTERSTITIAL
            });
        }

        private AAXCreative(String s, int i, int j)
        {
            super(s, i);
            id = j;
        }
    }


    public static final int CAN_EXPAND1_CT = 1003;
    public static final int CAN_EXPAND2_CT = 1004;
    public static final int CAN_PLAY_AUDIO1_CT = 1001;
    public static final int CAN_PLAY_AUDIO2_CT = 1002;
    public static final int CAN_PLAY_VIDEO_CT = 1014;
    public static final int HTML_CT = 1007;
    public static final int INTERSTITIAL_CT = 1008;
    public static final int MRAID1_CT = 1016;
    public static final int MRAID2_CT = 1017;
    private String connectionType;
    private String creative;
    private Set creativeTypes;
    private long expirationTimeMs;
    private boolean fetched;
    private int height;
    private String impPixelUrl;
    private String instrPixelUrl;
    private boolean isRendering;
    private String maxSize;
    private MetricsCollector metricsCollector;
    private AdProperties properties;
    private final AdSize requestedAdSize;
    private int screenHeight;
    private int screenWidth;
    private int slotId;
    private int width;

    public AdData(AdSize adsize)
    {
        height = 0;
        width = 0;
        screenHeight = 0;
        screenWidth = 0;
        expirationTimeMs = -1L;
        requestedAdSize = adsize;
        metricsCollector = new MetricsCollector();
    }

    public String getConnectionType()
    {
        return connectionType;
    }

    protected String getCreative()
    {
        return creative;
    }

    protected Set getCreativeTypes()
    {
        return creativeTypes;
    }

    protected int getHeight()
    {
        return height;
    }

    protected String getImpressionPixelUrl()
    {
        return impPixelUrl;
    }

    protected String getInstrumentationPixelUrl()
    {
        return instrPixelUrl;
    }

    public boolean getIsFetched()
    {
        return fetched;
    }

    protected boolean getIsRendering()
    {
        return isRendering;
    }

    public String getMaxSize()
    {
        return maxSize;
    }

    public MetricsCollector getMetricsCollector()
    {
        return metricsCollector;
    }

    protected AdProperties getProperties()
    {
        return properties;
    }

    protected AdSize getRequestedAdSize()
    {
        return requestedAdSize;
    }

    protected int getScreenHeight()
    {
        return screenHeight;
    }

    protected int getScreenWidth()
    {
        return screenWidth;
    }

    public int getSlotId()
    {
        return slotId;
    }

    protected int getWidth()
    {
        return width;
    }

    public boolean isExpired()
    {
        while (expirationTimeMs < 0L || System.currentTimeMillis() <= expirationTimeMs) 
        {
            return false;
        }
        return true;
    }

    public void resetMetricsCollector()
    {
        metricsCollector = new MetricsCollector();
    }

    public void setConnectionType(String s)
    {
        connectionType = s;
    }

    protected void setCreative(String s)
    {
        creative = s;
    }

    protected void setCreativeTypes(Set set)
    {
        creativeTypes = set;
    }

    protected void setExpirationTimeMillis(long l)
    {
        expirationTimeMs = l;
    }

    public void setFetched(boolean flag)
    {
        fetched = flag;
    }

    protected void setHeight(int i)
    {
        height = i;
    }

    protected void setImpressionPixelUrl(String s)
    {
        impPixelUrl = s;
    }

    protected void setInstrumentationPixelUrl(String s)
    {
        instrPixelUrl = s;
    }

    protected void setIsRendering(boolean flag)
    {
        isRendering = flag;
    }

    public void setMaxSize(String s)
    {
        maxSize = s;
    }

    protected void setProperties(AdProperties adproperties)
    {
        properties = adproperties;
    }

    protected void setScreenHeight(int i)
    {
        screenHeight = i;
    }

    protected void setScreenWidth(int i)
    {
        screenWidth = i;
    }

    public void setSlotId(int i)
    {
        slotId = i;
    }

    protected void setWidth(int i)
    {
        width = i;
    }
}
