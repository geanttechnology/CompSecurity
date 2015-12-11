// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import org.apache.log4j.spi.LoggerRepository;

// Referenced classes of package org.apache.log4j:
//            Category, LogManager, Level, Priority

public class Logger extends Category
{

    private static final String FQCN;
    static Class class$org$apache$log4j$Logger;

    protected Logger(String s)
    {
        super(s);
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

    public static Logger getRootLogger()
    {
        return LogManager.getRootLogger();
    }

    public boolean isTraceEnabled()
    {
        if (super.repository.isDisabled(5000))
        {
            return false;
        } else
        {
            return Level.TRACE.isGreaterOrEqual(getEffectiveLevel());
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$log4j$Logger == null)
        {
            class1 = _mthclass$("org.apache.log4j.Logger");
            class$org$apache$log4j$Logger = class1;
        } else
        {
            class1 = class$org$apache$log4j$Logger;
        }
        FQCN = class1.getName();
    }
}
