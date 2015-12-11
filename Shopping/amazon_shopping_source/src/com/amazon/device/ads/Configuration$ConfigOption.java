// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Configuration

public static class allowEmpty
{

    public static final SEND_GEO AAX_HOSTNAME;
    public static final SEND_GEO AD_PREF_URL;
    public static final SEND_GEO MADS_HOSTNAME;
    public static final SEND_GEO SEND_GEO;
    public static final SEND_GEO SIS_DOMAIN;
    public static final SEND_GEO SIS_URL;
    public static final SEND_GEO configOptions[];
    private final boolean allowEmpty;
    private final Class dataType;
    private final String debugProperty;
    private final String responseKey;
    private final String settingsName;

    boolean getAllowEmpty()
    {
        return allowEmpty;
    }

    Class getDataType()
    {
        return dataType;
    }

    String getDebugProperty()
    {
        return debugProperty;
    }

    String getResponseKey()
    {
        return responseKey;
    }

    String getSettingsName()
    {
        return settingsName;
    }

    static 
    {
        AAX_HOSTNAME = new <init>("config-aaxHostname", java/lang/String, "aaxHostname", "debug.aaxHostname");
        SIS_URL = new <init>("config-sisURL", java/lang/String, "sisURL", "debug.sisURL");
        AD_PREF_URL = new <init>("config-adPrefURL", java/lang/String, "adPrefURL", "debug.adPrefURL");
        MADS_HOSTNAME = new <init>("config-madsHostname", java/lang/String, "madsHostname", "debug.madsHostname", true);
        SIS_DOMAIN = new <init>("config-sisDomain", java/lang/String, "sisDomain", "debug.sisDomain");
        SEND_GEO = new <init>("config-sendGeo", java/lang/Boolean, "sendGeo", "debug.sendGeo");
        configOptions = (new configOptions[] {
            AAX_HOSTNAME, SIS_URL, AD_PREF_URL, MADS_HOSTNAME, SIS_DOMAIN, SEND_GEO
        });
    }

    protected (String s, Class class1, String s1, String s2)
    {
        this(s, class1, s1, s2, false);
    }

    protected <init>(String s, Class class1, String s1, String s2, boolean flag)
    {
        settingsName = s;
        responseKey = s1;
        dataType = class1;
        debugProperty = s2;
        allowEmpty = flag;
    }
}
