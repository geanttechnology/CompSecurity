// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib;

import com.comcast.cim.cmasl.utils.logging.Log4JConfigurator;
import de.mindpipe.android.logging.log4j.LogCatAppender;
import de.mindpipe.android.logging.log4j.LogConfigurator;
import java.util.Enumeration;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class PlayNowLog4JConfigurator
    implements Log4JConfigurator
{

    public PlayNowLog4JConfigurator()
    {
    }

    public void configureLogging()
    {
        Object obj = new LogConfigurator();
        ((LogConfigurator) (obj)).setRootLevel(Level.DEBUG);
        ((LogConfigurator) (obj)).setUseFileAppender(false);
        ((LogConfigurator) (obj)).configure();
        obj = Logger.getRootLogger().getAllAppenders();
        do
        {
            if (!((Enumeration) (obj)).hasMoreElements())
            {
                break;
            }
            Object obj1 = ((Enumeration) (obj)).nextElement();
            if (obj1 instanceof LogCatAppender)
            {
                ((LogCatAppender)obj1).setTagLayout(new PatternLayout("PNA:%c{1}:%t"));
            }
        } while (true);
    }
}
