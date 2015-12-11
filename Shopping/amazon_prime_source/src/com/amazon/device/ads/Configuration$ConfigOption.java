// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Configuration

public static class allowEmpty
{

    public static final IDENTIFY_USER_INTERVAL AAX_HOSTNAME;
    public static final IDENTIFY_USER_INTERVAL AD_PREF_URL;
    public static final IDENTIFY_USER_INTERVAL AD_RESOURCE_PATH;
    public static final IDENTIFY_USER_INTERVAL IDENTIFY_USER_INTERVAL;
    public static final IDENTIFY_USER_INTERVAL MADS_HOSTNAME;
    public static final IDENTIFY_USER_INTERVAL SEND_GEO;
    public static final IDENTIFY_USER_INTERVAL SIS_DOMAIN;
    public static final IDENTIFY_USER_INTERVAL SIS_URL;
    public static final IDENTIFY_USER_INTERVAL TRUNCATE_LAT_LON;
    public static final IDENTIFY_USER_INTERVAL WHITELISTED_CUSTOMER;
    public static final IDENTIFY_USER_INTERVAL configOptions[];
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
        AD_RESOURCE_PATH = new <init>("config-adResourcePath", java/lang/String, "adResourcePath", "debug.adResourcePath");
        SIS_URL = new <init>("config-sisURL", java/lang/String, "sisURL", "debug.sisURL");
        AD_PREF_URL = new <init>("config-adPrefURL", java/lang/String, "adPrefURL", "debug.adPrefURL");
        MADS_HOSTNAME = new <init>("config-madsHostname", java/lang/String, "madsHostname", "debug.madsHostname", true);
        SIS_DOMAIN = new <init>("config-sisDomain", java/lang/String, "sisDomain", "debug.sisDomain");
        SEND_GEO = new <init>("config-sendGeo", java/lang/Boolean, "sendGeo", "debug.sendGeo");
        TRUNCATE_LAT_LON = new <init>("config-truncateLatLon", java/lang/Boolean, "truncateLatLon", "debug.truncateLatLon");
        WHITELISTED_CUSTOMER = new <init>("config-whitelistedCustomer", java/lang/Boolean, "whitelistedCustomer", "debug.whiteListedCustomer");
        IDENTIFY_USER_INTERVAL = new <init>("config-identifyUserInterval", java/lang/Long, "identifyUserInterval", "debug.identifyUserInterval");
        configOptions = (new configOptions[] {
            AAX_HOSTNAME, AD_RESOURCE_PATH, SIS_URL, AD_PREF_URL, MADS_HOSTNAME, SIS_DOMAIN, SEND_GEO, TRUNCATE_LAT_LON, WHITELISTED_CUSTOMER, IDENTIFY_USER_INTERVAL
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
