// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.spi;


// Referenced classes of package org.apache.log4j.spi:
//            OptionHandler, LoggingEvent

public abstract class Filter
    implements OptionHandler
{

    public Filter next;

    public Filter()
    {
    }

    public void activateOptions()
    {
    }

    public abstract int decide(LoggingEvent loggingevent);

    public Filter getNext()
    {
        return next;
    }

    public void setNext(Filter filter)
    {
        next = filter;
    }
}
