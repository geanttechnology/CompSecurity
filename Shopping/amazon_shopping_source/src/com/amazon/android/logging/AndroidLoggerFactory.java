// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.logging;

import com.amazon.logging.Logger;
import com.amazon.logging.LoggerFactory;
import com.amazon.mas.client.BuildType;

// Referenced classes of package com.amazon.android.logging:
//            AndroidLogger

public class AndroidLoggerFactory
    implements LoggerFactory
{

    public AndroidLoggerFactory()
    {
    }

    public static String logTag(Class class1)
    {
        return (new StringBuilder()).append("AmazonAppstore.").append(class1.getSimpleName()).toString();
    }

    public static String logTag(String s, Class class1)
    {
        return (new StringBuilder()).append("AmazonAppstore.").append(s).append("/").append(class1.getSimpleName()).toString();
    }

    public static void setBuildType(BuildType buildtype)
    {
        boolean flag;
        if (buildtype != BuildType.RELEASE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AndroidLogger.setIsDebugBuild(flag);
    }

    public Logger createLogger(Class class1)
    {
        return new AndroidLogger(logTag(class1));
    }

    public Logger createLogger(String s, Class class1)
    {
        return new AndroidLogger(logTag(s, class1));
    }
}
