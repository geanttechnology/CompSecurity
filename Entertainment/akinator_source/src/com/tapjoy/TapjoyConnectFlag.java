// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.util.Hashtable;

public class TapjoyConnectFlag
{

    public static final Hashtable CONNECT_FLAG_DEFAULTS = new Hashtable() {

            
            {
                put("TJC_OPTION_SERVICE_URL", "https://ws.tapjoyads.com/");
                put("TJC_OPTION_PLACEMENT_SERVICE_URL", "https://placements.tapjoy.com/");
            }
    };
    public static final String DEBUG_DEVICE_ID = "TJC_OPTION_DEBUG_DEVICE_ID";
    public static final String DISABLE_ADVERTISING_ID_CHECK = "TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK";
    public static final String DISABLE_PERSISTENT_IDS = "TJC_OPTION_DISABLE_PERSISTENT_IDS";
    public static final String ENABLE_LOGGING = "TJC_OPTION_ENABLE_LOGGING";
    public static final String FLAG_ARRAY[] = {
        "TJC_OPTION_USER_ID", "TJC_OPTION_ENABLE_LOGGING", "TJC_OPTION_SERVICE_URL", "TJC_OPTION_PLACEMENT_SERVICE_URL", "TJC_OPTION_STORE_NAME", "TJC_OPTION_DEBUG_DEVICE_ID"
    };
    public static final String PLACEMENT_URL = "TJC_OPTION_PLACEMENT_SERVICE_URL";
    public static final String SERVICE_URL = "TJC_OPTION_SERVICE_URL";
    public static final String STORE_ARRAY[] = {
        "gfan", "skt"
    };
    public static final String STORE_GFAN = "gfan";
    public static final String STORE_NAME = "TJC_OPTION_STORE_NAME";
    public static final String STORE_SKT = "skt";
    public static final String USER_ID = "TJC_OPTION_USER_ID";

    public TapjoyConnectFlag()
    {
    }

}
