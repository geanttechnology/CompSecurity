// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.cmasl.xip.ams.AMSResponseHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationListResponseHandler extends AMSResponseHandler
{

    private List deviceList;

    public RegistrationListResponseHandler(ObjectMapper objectmapper)
    {
        super(objectmapper);
    }

    public List getDeviceList()
    {
        return deviceList;
    }

    public void handleAMSResponseBody(JsonNode jsonnode)
        throws IOException
    {
        jsonnode = jsonnode.get("devices");
        if (jsonnode != null)
        {
            deviceList = (List)jsonObjectMapper.readValue(jsonnode.traverse(), new TypeReference() {

                final RegistrationListResponseHandler this$0;

            
            {
                this$0 = RegistrationListResponseHandler.this;
                super();
            }
            });
            return;
        } else
        {
            deviceList = new ArrayList();
            return;
        }
    }
}
