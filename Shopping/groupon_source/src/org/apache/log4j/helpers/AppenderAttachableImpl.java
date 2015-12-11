// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;

public class AppenderAttachableImpl
{

    protected Vector appenderList;

    public AppenderAttachableImpl()
    {
    }

    public void addAppender(Appender appender)
    {
        if (appender != null)
        {
            if (appenderList == null)
            {
                appenderList = new Vector(1);
            }
            if (!appenderList.contains(appender))
            {
                appenderList.addElement(appender);
                return;
            }
        }
    }

    public int appendLoopOnAppenders(LoggingEvent loggingevent)
    {
        int i = 0;
        if (appenderList == null) goto _L2; else goto _L1
_L1:
        int j;
        j = appenderList.size();
        i = 0;
_L6:
        if (i < j) goto _L4; else goto _L3
_L3:
        i = j;
_L2:
        return i;
_L4:
        ((Appender)appenderList.elementAt(i)).doAppend(loggingevent);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void removeAllAppenders()
    {
        if (appenderList == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = appenderList.size();
        i = 0;
_L6:
        if (i < j) goto _L4; else goto _L3
_L3:
        appenderList.removeAllElements();
        appenderList = null;
_L2:
        return;
_L4:
        ((Appender)appenderList.elementAt(i)).close();
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
