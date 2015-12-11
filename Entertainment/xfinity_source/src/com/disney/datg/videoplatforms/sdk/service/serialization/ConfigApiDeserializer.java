// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.serialization;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import java.util.concurrent.Future;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.serialization:
//            CacheableApiDeserializer

public class ConfigApiDeserializer extends CacheableApiDeserializer
{

    protected static int CACHE_CAPACITY = 100;
    protected static String CACHE_CONTAINER = "Config";

    public ConfigApiDeserializer()
    {
        super(null, CACHE_CONTAINER, CACHE_CAPACITY, com/disney/datg/videoplatforms/sdk/models/api/Config);
    }

    public Future executeAsync(Request request, int i, HttpRequestHandler httprequesthandler)
        throws AndroidSDKException
    {
        return super.executeAsync(request, i, httprequesthandler);
    }

}
