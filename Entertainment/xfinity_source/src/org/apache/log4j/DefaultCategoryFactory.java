// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import org.apache.log4j.spi.LoggerFactory;

// Referenced classes of package org.apache.log4j:
//            Logger

class DefaultCategoryFactory
    implements LoggerFactory
{

    DefaultCategoryFactory()
    {
    }

    public Logger makeNewLoggerInstance(String s)
    {
        return new Logger(s);
    }
}
