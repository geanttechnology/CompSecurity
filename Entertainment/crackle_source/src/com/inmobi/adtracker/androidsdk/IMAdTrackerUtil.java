// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk;

import com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants;

public class IMAdTrackerUtil
{
    public static final class LOG_LEVEL extends Enum
    {

        public static final LOG_LEVEL DEBUG;
        private static final LOG_LEVEL ENUM$VALUES[];
        public static final LOG_LEVEL NONE;
        public static final LOG_LEVEL VERBOSE;
        private final int value;

        public static LOG_LEVEL valueOf(String s)
        {
            return (LOG_LEVEL)Enum.valueOf(com/inmobi/adtracker/androidsdk/IMAdTrackerUtil$LOG_LEVEL, s);
        }

        public static LOG_LEVEL[] values()
        {
            LOG_LEVEL alog_level[] = ENUM$VALUES;
            int i = alog_level.length;
            LOG_LEVEL alog_level1[] = new LOG_LEVEL[i];
            System.arraycopy(alog_level, 0, alog_level1, 0, i);
            return alog_level1;
        }

        public int getValue()
        {
            return value;
        }

        static 
        {
            NONE = new LOG_LEVEL("NONE", 0, 0);
            DEBUG = new LOG_LEVEL("DEBUG", 1, 1);
            VERBOSE = new LOG_LEVEL("VERBOSE", 2, 2);
            ENUM$VALUES = (new LOG_LEVEL[] {
                NONE, DEBUG, VERBOSE
            });
        }

        private LOG_LEVEL(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    public IMAdTrackerUtil()
    {
    }

    public static String getSDKVersion()
    {
        return IMAdTrackerAnalyticsConstants.IMAdTracker_VERSION;
    }

    public static void setLogLevel(LOG_LEVEL log_level)
    {
        IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG = log_level;
    }
}
