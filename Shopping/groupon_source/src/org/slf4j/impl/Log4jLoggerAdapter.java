// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.spi.LocationAwareLogger;

public final class Log4jLoggerAdapter extends MarkerIgnoringBase
    implements LocationAwareLogger
{

    static final String FQCN;
    static Class class$org$slf4j$impl$Log4jLoggerAdapter;
    final Logger logger;

    Log4jLoggerAdapter(Logger logger1)
    {
        logger = logger1;
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public void error(String s)
    {
        logger.log(FQCN, Level.ERROR, s, null);
    }

    public String getName()
    {
        return logger.getName();
    }

    static 
    {
        Class class1;
        if (class$org$slf4j$impl$Log4jLoggerAdapter == null)
        {
            class1 = _mthclass$("org.slf4j.impl.Log4jLoggerAdapter");
            class$org$slf4j$impl$Log4jLoggerAdapter = class1;
        } else
        {
            class1 = class$org$slf4j$impl$Log4jLoggerAdapter;
        }
        FQCN = class1.getName();
    }
}
