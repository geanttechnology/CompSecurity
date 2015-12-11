// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.spi;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

// Referenced classes of package org.apache.log4j.spi:
//            OptionHandler

public interface ErrorHandler
    extends OptionHandler
{

    public abstract void error(String s);

    public abstract void error(String s, Exception exception, int i);

    public abstract void setBackupAppender(Appender appender);

    public abstract void setLogger(Logger logger);
}
