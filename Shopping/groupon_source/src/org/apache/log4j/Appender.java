// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j:
//            Layout

public interface Appender
{

    public abstract void close();

    public abstract void doAppend(LoggingEvent loggingevent);

    public abstract String getName();

    public abstract boolean requiresLayout();

    public abstract void setLayout(Layout layout);

    public abstract void setName(String s);
}
