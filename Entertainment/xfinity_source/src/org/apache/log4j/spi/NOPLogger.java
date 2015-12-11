// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.spi;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

// Referenced classes of package org.apache.log4j.spi:
//            NOPLoggerRepository, LoggingEvent

public final class NOPLogger extends Logger
{

    public NOPLogger(NOPLoggerRepository noploggerrepository, String s)
    {
        super(s);
        super.repository = noploggerrepository;
        super.level = Level.OFF;
        super.parent = this;
    }

    public void addAppender(Appender appender)
    {
    }

    public void callAppenders(LoggingEvent loggingevent)
    {
    }

    void closeNestedAppenders()
    {
    }

    public Enumeration getAllAppenders()
    {
        return (new Vector()).elements();
    }

    public Level getEffectiveLevel()
    {
        return Level.OFF;
    }

    public boolean isDebugEnabled()
    {
        return false;
    }

    public boolean isEnabledFor(Priority priority)
    {
        return false;
    }

    public boolean isInfoEnabled()
    {
        return false;
    }

    public boolean isTraceEnabled()
    {
        return false;
    }

    public void log(String s, Priority priority, Object obj, Throwable throwable)
    {
    }

    public void removeAllAppenders()
    {
    }

    public void setLevel(Level level)
    {
    }

    public void setResourceBundle(ResourceBundle resourcebundle)
    {
    }
}
