// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class AmazonCloudDriveLog
{

    private static Logger LOG = getLogger();

    private static Logger getLogger()
    {
        for (Enumeration enumeration = LogManager.getLogManager().getLoggerNames(); enumeration.hasMoreElements();)
        {
            if (((String)enumeration.nextElement()).equals("AmazonCloudDrive"))
            {
                return Logger.getLogger("AmazonCloudDrive");
            }
        }

        Logger logger = Logger.getLogger("AmazonCloudDrive");
        logger.setLevel(Level.SEVERE);
        return logger;
    }

    static void w(String s, Throwable throwable)
    {
        LOG.log(Level.WARNING, s, throwable);
    }

}
