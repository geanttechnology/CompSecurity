// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.entitlement;

import com.comcast.cim.cmasl.xip.XipResponseHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

// Referenced classes of package com.xfinity.playerlib.model.entitlement:
//            EntitlementParser, VideoEntitlement

public class EntitlementResponseHandler extends XipResponseHandler
{

    private ObjectMapper jsonObjectMapper;
    private EntitlementParser parser;
    private VideoEntitlement videoEntitlement;

    public EntitlementResponseHandler(ObjectMapper objectmapper)
    {
        parser = new EntitlementParser();
        jsonObjectMapper = objectmapper;
    }

    public VideoEntitlement getVideoEntitlement()
    {
        return videoEntitlement;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        videoEntitlement = parser.parse(jsonObjectMapper, inputstream);
    }
}
