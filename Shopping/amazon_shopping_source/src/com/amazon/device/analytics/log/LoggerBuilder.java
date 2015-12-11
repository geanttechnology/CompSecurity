// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.log;


// Referenced classes of package com.amazon.device.analytics.log:
//            Logger

public class LoggerBuilder
{

    private final Class cls;
    private Logging.LogLevel level;
    private final String tag;

    public LoggerBuilder(String s, Class class1)
    {
        tag = s;
        cls = class1;
    }

    public Logger build()
    {
        return new Logger(this);
    }

    public Logging.LogLevel getGlobalLogLevel()
    {
        return level;
    }

    public Class getLogClass()
    {
        return cls;
    }

    public String getTag()
    {
        return tag;
    }

    public LoggerBuilder setGlobalLogLevel(Logging.LogLevel loglevel)
    {
        level = loglevel;
        return this;
    }
}
