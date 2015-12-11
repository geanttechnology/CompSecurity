// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import com.groupon.service.marketrate.HotelsService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.groupon.getaways.search:
//            GeoService, DestinationsData

public class GeoServiceClient
    implements GeoService
{
    private class OnErrorCallback
        implements Function1
    {

        private final GeoService.Callback callback;
        final GeoServiceClient this$0;

        public void execute(Exception exception)
            throws RuntimeException
        {
            logger.log(exception);
            callback.onDestinationsData(new DestinationsData(null, exception));
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((Exception)obj);
        }

        private OnErrorCallback(GeoService.Callback callback1)
        {
            this$0 = GeoServiceClient.this;
            super();
            callback = callback1;
        }

    }

    private class OnSuccessCallback
        implements Function1
    {

        private final GeoService.Callback callback;
        final GeoServiceClient this$0;

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((List)obj);
        }

        public void execute(List list)
            throws RuntimeException
        {
            callback.onDestinationsData(new DestinationsData(list, null));
        }

        private OnSuccessCallback(GeoService.Callback callback1)
        {
            this$0 = GeoServiceClient.this;
            super();
            callback = callback1;
        }

    }


    private final HotelsService hotelsService;
    private final Logger logger;

    public GeoServiceClient(HotelsService hotelsservice, Logger logger1)
    {
        hotelsService = hotelsservice;
        logger = logger1;
    }

    public void destinations(CharSequence charsequence, GeoService.Callback callback)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new CharSequence[] {
            "prefix", charsequence
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "limit", "10"
        }));
        hotelsService.getDestinationSuggestions(arraylist, null, new OnSuccessCallback(callback), new OnErrorCallback(callback));
    }

}
