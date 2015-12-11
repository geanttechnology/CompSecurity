// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j.helpers:
//            PatternParser, FormattingInfo

private class this._cls0 extends this._cls0
{

    private final PatternParser this$0;

    String getFullyQualifiedName(LoggingEvent loggingevent)
    {
        return loggingevent.getLocationInformation().getClassName();
    }

    (FormattingInfo formattinginfo, int i)
    {
        super(formattinginfo, i);
        this$0 = PatternParser.this;
    }
}
