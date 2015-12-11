// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.log;


// Referenced classes of package uk.co.senab.photoview.log:
//            LoggerDefault, Logger

public final class LogManager
{

    private static Logger logger = new LoggerDefault();

    public LogManager()
    {
    }

    public static Logger getLogger()
    {
        return logger;
    }

    public static void setLogger(Logger logger1)
    {
        logger = logger1;
    }

}
