// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            ApplicationInformation, DeviceInformation

public class ConnectInformation extends HarvestableArray
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private ApplicationInformation applicationInformation;
    private DeviceInformation deviceInformation;

    public ConnectInformation(ApplicationInformation applicationinformation, DeviceInformation deviceinformation)
    {
        if (applicationinformation == null)
        {
            log.error("null applicationInformation passed into ConnectInformation constructor");
        }
        if (deviceinformation == null)
        {
            log.error("null deviceInformation passed into ConnectInformation constructor");
        }
        applicationInformation = applicationinformation;
        deviceInformation = deviceinformation;
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        notNull(applicationInformation);
        jsonarray.add(applicationInformation.asJsonArray());
        notNull(deviceInformation);
        jsonarray.add(deviceInformation.asJsonArray());
        return jsonarray;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ConnectInformation)obj;
            if (applicationInformation == null ? ((ConnectInformation) (obj)).applicationInformation != null : !applicationInformation.equals(((ConnectInformation) (obj)).applicationInformation))
            {
                return false;
            }
            if (deviceInformation == null ? ((ConnectInformation) (obj)).deviceInformation != null : !deviceInformation.equals(((ConnectInformation) (obj)).deviceInformation))
            {
                return false;
            }
        }
        return true;
    }

    public ApplicationInformation getApplicationInformation()
    {
        return applicationInformation;
    }

    public DeviceInformation getDeviceInformation()
    {
        return deviceInformation;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (applicationInformation != null)
        {
            i = applicationInformation.hashCode();
        } else
        {
            i = 0;
        }
        if (deviceInformation != null)
        {
            j = deviceInformation.hashCode();
        }
        return i * 31 + j;
    }

    public void setApplicationInformation(ApplicationInformation applicationinformation)
    {
        applicationInformation = applicationinformation;
    }

    public void setDeviceInformation(DeviceInformation deviceinformation)
    {
        deviceInformation = deviceinformation;
    }

}
