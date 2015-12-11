// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.getaways.search:
//            GeoServiceClient, DestinationsData

private class <init>
    implements Function1
{

    private final ata callback;
    final GeoServiceClient this$0;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
        throws RuntimeException
    {
        callback.ata(new DestinationsData(list, null));
    }

    private ( )
    {
        this$0 = GeoServiceClient.this;
        super();
        callback = ;
    }

    callback(callback callback1, callback callback2)
    {
        this(callback1);
    }
}
