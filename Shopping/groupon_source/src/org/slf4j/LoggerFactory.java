// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j;

import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

// Referenced classes of package org.slf4j:
//            ILoggerFactory, Logger

public final class LoggerFactory
{

    static ILoggerFactory loggerFactory;

    public static Logger getLogger(Class class1)
    {
        if (loggerFactory == null)
        {
            throw new IllegalStateException("Logging factory implementation cannot be null. See also http://www.slf4j.org/codes.html#null_LF");
        } else
        {
            return loggerFactory.getLogger(class1.getName());
        }
    }

    static 
    {
        try
        {
            loggerFactory = StaticLoggerBinder.SINGLETON.getLoggerFactory();
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            String s = noclassdeffounderror.getMessage();
            if (s != null && s.indexOf("org/slf4j/impl/StaticLoggerBinder") != -1)
            {
                Util.reportFailure("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                Util.reportFailure("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
            }
            throw noclassdeffounderror;
        }
        catch (Exception exception)
        {
            Util.reportFailure("Failed to instantiate logger [" + StaticLoggerBinder.SINGLETON.getLoggerFactoryClassStr() + "]", exception);
        }
    }
}
