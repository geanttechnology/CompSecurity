// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.mindpipe.android.logging.log4j;

import java.io.IOException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

// Referenced classes of package de.mindpipe.android.logging.log4j:
//            LogCatAppender

public class LogConfigurator
{

    private String fileName;
    private String filePattern;
    private boolean immediateFlush;
    private String logCatPattern;
    private int maxBackupSize;
    private long maxFileSize;
    private Level rootLevel;
    private boolean useFileAppender;
    private boolean useLogCatAppender;

    public LogConfigurator()
    {
        rootLevel = Level.DEBUG;
        filePattern = "%d - [%p::%c::%C] - %m%n";
        logCatPattern = "%m%n";
        fileName = "android-log4j.log";
        maxBackupSize = 5;
        maxFileSize = 0x80000L;
        immediateFlush = true;
        useLogCatAppender = true;
        useFileAppender = true;
    }

    private void configureFileAppender()
    {
        Logger logger = Logger.getRootLogger();
        Object obj = new PatternLayout(getFilePattern());
        try
        {
            obj = new RollingFileAppender(((org.apache.log4j.Layout) (obj)), getFileName());
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Exception configuring log system", ioexception);
        }
        ((RollingFileAppender) (obj)).setMaxBackupIndex(getMaxBackupSize());
        ((RollingFileAppender) (obj)).setMaximumFileSize(getMaxFileSize());
        ((RollingFileAppender) (obj)).setImmediateFlush(isImmediateFlush());
        logger.addAppender(((org.apache.log4j.Appender) (obj)));
    }

    private void configureLogCatAppender()
    {
        Logger.getRootLogger().addAppender(new LogCatAppender(new PatternLayout(getLogCatPattern())));
    }

    public void configure()
    {
        Logger logger = Logger.getRootLogger();
        if (isUseFileAppender())
        {
            configureFileAppender();
        }
        if (isUseLogCatAppender())
        {
            configureLogCatAppender();
        }
        logger.setLevel(getRootLevel());
    }

    public String getFileName()
    {
        return fileName;
    }

    public String getFilePattern()
    {
        return filePattern;
    }

    public String getLogCatPattern()
    {
        return logCatPattern;
    }

    public int getMaxBackupSize()
    {
        return maxBackupSize;
    }

    public long getMaxFileSize()
    {
        return maxFileSize;
    }

    public Level getRootLevel()
    {
        return rootLevel;
    }

    public boolean isImmediateFlush()
    {
        return immediateFlush;
    }

    public boolean isUseFileAppender()
    {
        return useFileAppender;
    }

    public boolean isUseLogCatAppender()
    {
        return useLogCatAppender;
    }

    public void setRootLevel(Level level)
    {
        rootLevel = level;
    }

    public void setUseFileAppender(boolean flag)
    {
        useFileAppender = flag;
    }
}
