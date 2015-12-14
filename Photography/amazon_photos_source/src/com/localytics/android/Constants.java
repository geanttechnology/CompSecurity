// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            DatapointHelper

class Constants
{

    public static String ANALYTICS_URL = "analytics.localytics.com";
    static final String CLOSE_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "close"
    });
    static final int CURRENT_API_LEVEL = DatapointHelper.getApiLevel();
    static final String FLOW_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "flow"
    });
    public static boolean IS_LOGGABLE = false;
    static final String OPEN_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "open"
    });
    static final String OPT_IN_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "opt_in"
    });
    static final String OPT_OUT_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "opt_out"
    });
    public static String PROFILES_URL = "profile.localytics.com";
    public static long SESSION_EXPIRATION = 15000L;
    public static boolean USE_HTTPS = true;

    protected Constants()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

}
