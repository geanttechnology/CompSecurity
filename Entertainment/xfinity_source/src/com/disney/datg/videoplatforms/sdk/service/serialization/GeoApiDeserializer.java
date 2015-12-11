// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.serialization;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import java.util.concurrent.Future;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.serialization:
//            ApiDeserializer

public class GeoApiDeserializer extends ApiDeserializer
{

    public GeoApiDeserializer()
    {
        super(com/disney/datg/videoplatforms/sdk/models/api/GeoLocation);
    }

    public Future executeAsync(Request request, int i, HttpRequestHandler httprequesthandler)
        throws AndroidSDKException
    {
        return super.executeAsync(request, i, httprequesthandler);
    }
}
