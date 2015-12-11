// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.serialization;

import com.disney.datg.videoplatforms.sdk.service.Request;
import java.net.URI;
import java.util.HashMap;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.serialization:
//            CacheableApiDeserializer

class val.request extends HashMap
{

    final CacheableApiDeserializer this$0;
    final Request val$request;

    Y()
    {
        this$0 = final_cacheableapideserializer;
        val$request = Request.this;
        super();
        put("host", val$request.getServiceUri().toString());
    }
}
