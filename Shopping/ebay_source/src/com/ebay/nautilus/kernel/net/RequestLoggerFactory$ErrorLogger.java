// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            IRequestLogger, RequestLoggerFactory, Response

private static final class loggers
    implements IRequestLogger
{

    private final ArrayList loggers;

    public void logHostError(int i)
    {
        for (Iterator iterator = loggers.iterator(); iterator.hasNext(); ((IRequestLogger)iterator.next()).logHostError(i)) { }
    }

    public void setCompleteResponse(Response response)
    {
        for (Iterator iterator = loggers.iterator(); iterator.hasNext(); ((IRequestLogger)iterator.next()).setCompleteResponse(response)) { }
    }

    public void setRequestTime(long l)
    {
        for (Iterator iterator = loggers.iterator(); iterator.hasNext(); ((IRequestLogger)iterator.next()).setRequestTime(l)) { }
    }

    public void setResponseTime(long l)
    {
        for (Iterator iterator = loggers.iterator(); iterator.hasNext(); ((IRequestLogger)iterator.next()).setResponseTime(l)) { }
    }

    public (ArrayList arraylist)
    {
        loggers = arraylist;
    }
}
