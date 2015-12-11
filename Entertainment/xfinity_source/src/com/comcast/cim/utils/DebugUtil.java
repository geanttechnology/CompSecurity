// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import java.util.Date;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugUtil
{

    private static final Logger CARP_LOG = LoggerFactory.getLogger("CARP");
    public static final FastDateFormat DATE_FORMATTER = FastDateFormat.getInstance("MM-dd-yyyy hh:mm:ss a z");
    public static final FastDateFormat DATE_FORMATTER_PRECISE = FastDateFormat.getInstance("MM-dd-yyyy hh:mm:ss.SSS a z");
    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/utils/DebugUtil);

    public DebugUtil()
    {
    }

    public static String millisToDateString(long l)
    {
        return millisToDateString(l, DATE_FORMATTER);
    }

    public static String millisToDateString(long l, FastDateFormat fastdateformat)
    {
        return fastdateformat.format(new Date(l));
    }

}
