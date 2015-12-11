// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.xip.ams.AMSResponseHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoAuthorization

public class VideoAuthorizationResponseHandler extends AMSResponseHandler
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler);
    private VideoAuthorization videoAuthorization;

    public VideoAuthorizationResponseHandler(ObjectMapper objectmapper)
    {
        super(objectmapper);
    }

    public VideoAuthorization getVideoAuthorization()
    {
        return videoAuthorization;
    }

    public void handleAMSResponseBody(JsonNode jsonnode)
        throws IOException
    {
        String s = jsonnode.path("deviceId").asText();
        Object obj = jsonnode.path("sessionToken");
        Object obj1;
        if (!((JsonNode) (obj)).isMissingNode())
        {
            obj = ((JsonNode) (obj)).asText();
        } else
        {
            obj = null;
        }
        obj1 = jsonnode.path("deviceAuthorizationToken");
        if (!((JsonNode) (obj1)).isMissingNode())
        {
            obj1 = ((JsonNode) (obj1)).asText();
        } else
        {
            obj1 = null;
        }
        videoAuthorization = new VideoAuthorization(((String) (obj1)), s, ((String) (obj)), jsonnode.path("drmToken").path("devicePlaybackToken").asText());
    }

}
