// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.xip.ams.AMSResponseHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoContinue, VideoSession

public class VideoContinueResponseHandler extends AMSResponseHandler
{

    private VideoContinue videoContinue;

    public VideoContinueResponseHandler(ObjectMapper objectmapper)
    {
        super(objectmapper);
    }

    public VideoSession getVideoContinue()
    {
        return videoContinue;
    }

    protected void handleAMSResponseBody(JsonNode jsonnode)
        throws IOException
    {
        videoContinue = new VideoContinue(detailedStatus.getStatusMessage(), String.valueOf(detailedStatus.getStatusCode()));
    }
}
