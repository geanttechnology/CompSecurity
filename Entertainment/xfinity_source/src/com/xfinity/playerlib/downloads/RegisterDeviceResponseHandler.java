// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.cmasl.xip.ams.AMSResponseHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            DeviceRegistration

public class RegisterDeviceResponseHandler extends AMSResponseHandler
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/downloads/RegisterDeviceResponseHandler);
    private DeviceRegistration deviceRegistration;

    public RegisterDeviceResponseHandler(ObjectMapper objectmapper)
    {
        super(objectmapper);
    }

    public DeviceRegistration getDeviceRegistration()
    {
        return deviceRegistration;
    }

    protected void handleAMSResponseBody(JsonNode jsonnode)
        throws IOException
    {
        deviceRegistration = (DeviceRegistration)jsonObjectMapper.readValue(jsonnode.traverse(), com/xfinity/playerlib/downloads/DeviceRegistration);
    }

}
