// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.getaways.search:
//            GeoServiceClient, DestinationsData

private class <init>
    implements Function1
{

    private final execute callback;
    final GeoServiceClient this$0;

    public void execute(Exception exception)
        throws RuntimeException
    {
        GeoServiceClient.access$200(GeoServiceClient.this).log(exception);
        callback.sData(new DestinationsData(null, exception));
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
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
