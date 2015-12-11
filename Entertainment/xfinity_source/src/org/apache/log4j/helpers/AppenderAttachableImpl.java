// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;

public class AppenderAttachableImpl
    implements AppenderAttachable
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
        int j = 0;
        if (appenderList != null)
        {
            int k = appenderList.size();
            int i = 0;
            do
            {
                j = k;
                if (i >= k)
                {
                    break;
                }
                ((Appender)appenderList.elementAt(i)).doAppend(loggingevent);
                i++;
            } while (true);
        }
        return j;
    }

    public Enumeration getAllAppenders()
    {
        if (appenderList == null)
        {
            return null;
        } else
        {
            return appenderList.elements();
        }
    }

    public void removeAllAppenders()
    {
        if (appenderList != null)
        {
            int j = appenderList.size();
            for (int i = 0; i < j; i++)
            {
                ((Appender)appenderList.elementAt(i)).close();
            }

            appenderList.removeAllElements();
            appenderList = null;
        }
    }
}
