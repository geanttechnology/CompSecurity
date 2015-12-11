// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.config;


// Referenced classes of package com.poshmark.config:
//            Env, BuildTypeConfig, BuildType

public class EnvConfig
{

    public static final String API_SERVER_NAME = "https://api.poshmark.com";
    public static final String APSALAR_KEY = "PoshmarkProd";
    public static final String APSALAR_SECRET = "92GmnhY9";
    public static final String DATABASE_NAME = "poshmark_app_Database.db";
    public static final Env ENV;
    public static String GCM_PROJECT_ID = "917058316614";
    public static final String GOOGLE_ANALYTICS_ID;
    public static final String HASOFFERS_ADVERTISER_ID = "9056";
    public static final String HASOFFERS_CONVERSION_KEY = "026e1400a6bc5a185b79446a9d6620e8";
    public static final String HOCKEY_APPID = "01486de8725142766a044552d92ef77f";
    public static final String KOCHAVA_APP_ID = "koposhmarkandroid3476533b1c455ecb8";
    public static final String NEWRELIC_APP_ID = "AAa319871d49ffd4ff9af36e15b2c6c6ed2d34ad2c";
    public static final String PINTEREST_APP_ID = "4794312476046927699";
    public static final String TR_SERVER_NAME = "https://tr.poshmark.com";
    public static final String UPLOAD_SERVER_NAME = "https://up.poshmark.com";
    public static int USER_STATE_SUMMARY_INTERVAL = 0;
    public static final String WEB_SERVER_NAME = "https://www.poshmark.com";

    public EnvConfig()
    {
    }

    public static void setupDevIP(String s)
    {
    }

    static 
    {
        ENV = Env.PRODUCTION;
        USER_STATE_SUMMARY_INTERVAL = 0x36ee80;
        String s;
        if (BuildTypeConfig.BUILD_TYPE == BuildType.DEBUG)
        {
            s = "UA-24801737-7";
        } else
        {
            s = "UA-24801737-8";
        }
        GOOGLE_ANALYTICS_ID = s;
    }
}
