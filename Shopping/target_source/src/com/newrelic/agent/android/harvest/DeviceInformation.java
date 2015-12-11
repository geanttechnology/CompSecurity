// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DeviceInformation extends HarvestableArray
{

    private String agentName;
    private String agentVersion;
    private String architecture;
    private String countryCode;
    private String deviceId;
    private String manufacturer;
    private Map misc;
    private String model;
    private String osBuild;
    private String osName;
    private String osVersion;
    private String regionCode;
    private String runTime;
    private String size;

    public DeviceInformation()
    {
        misc = new HashMap();
    }

    public void addMisc(String s, String s1)
    {
        misc.put(s, s1);
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        notEmpty(osName);
        jsonarray.add(new JsonPrimitive(osName));
        notEmpty(osVersion);
        jsonarray.add(new JsonPrimitive(osVersion));
        notEmpty(manufacturer);
        notEmpty(model);
        jsonarray.add(new JsonPrimitive((new StringBuilder()).append(manufacturer).append(" ").append(model).toString()));
        notEmpty(agentName);
        jsonarray.add(new JsonPrimitive(agentName));
        notEmpty(agentVersion);
        jsonarray.add(new JsonPrimitive(agentVersion));
        notEmpty(deviceId);
        jsonarray.add(new JsonPrimitive(deviceId));
        jsonarray.add(new JsonPrimitive(optional(countryCode)));
        jsonarray.add(new JsonPrimitive(optional(regionCode)));
        jsonarray.add(new JsonPrimitive(manufacturer));
        if (misc == null || misc.isEmpty())
        {
            misc = Collections.emptyMap();
        }
        jsonarray.add((new Gson()).toJsonTree(misc, GSON_STRING_MAP_TYPE));
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
            obj = (DeviceInformation)obj;
            if (agentName == null ? ((DeviceInformation) (obj)).agentName != null : !agentName.equals(((DeviceInformation) (obj)).agentName))
            {
                return false;
            }
            if (agentVersion == null ? ((DeviceInformation) (obj)).agentVersion != null : !agentVersion.equals(((DeviceInformation) (obj)).agentVersion))
            {
                return false;
            }
            if (architecture == null ? ((DeviceInformation) (obj)).architecture != null : !architecture.equals(((DeviceInformation) (obj)).architecture))
            {
                return false;
            }
            if (deviceId == null ? ((DeviceInformation) (obj)).deviceId != null : !deviceId.equals(((DeviceInformation) (obj)).deviceId))
            {
                return false;
            }
            if (manufacturer == null ? ((DeviceInformation) (obj)).manufacturer != null : !manufacturer.equals(((DeviceInformation) (obj)).manufacturer))
            {
                return false;
            }
            if (model == null ? ((DeviceInformation) (obj)).model != null : !model.equals(((DeviceInformation) (obj)).model))
            {
                return false;
            }
            if (osBuild == null ? ((DeviceInformation) (obj)).osBuild != null : !osBuild.equals(((DeviceInformation) (obj)).osBuild))
            {
                return false;
            }
            if (osName == null ? ((DeviceInformation) (obj)).osName != null : !osName.equals(((DeviceInformation) (obj)).osName))
            {
                return false;
            }
            if (osVersion == null ? ((DeviceInformation) (obj)).osVersion != null : !osVersion.equals(((DeviceInformation) (obj)).osVersion))
            {
                return false;
            }
            if (runTime == null ? ((DeviceInformation) (obj)).runTime != null : !runTime.equals(((DeviceInformation) (obj)).runTime))
            {
                return false;
            }
            if (size == null ? ((DeviceInformation) (obj)).size != null : !size.equals(((DeviceInformation) (obj)).size))
            {
                return false;
            }
        }
        return true;
    }

    public String getAgentName()
    {
        return agentName;
    }

    public String getAgentVersion()
    {
        return agentVersion;
    }

    public String getArchitecture()
    {
        return architecture;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getModel()
    {
        return model;
    }

    public String getOsBuild()
    {
        return osBuild;
    }

    public String getOsName()
    {
        return osName;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public String getRegionCode()
    {
        return regionCode;
    }

    public String getRunTime()
    {
        return runTime;
    }

    public String getSize()
    {
        return size;
    }

    public int hashCode()
    {
        int k2 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (osName != null)
        {
            i = osName.hashCode();
        } else
        {
            i = 0;
        }
        if (osVersion != null)
        {
            j = osVersion.hashCode();
        } else
        {
            j = 0;
        }
        if (osBuild != null)
        {
            k = osBuild.hashCode();
        } else
        {
            k = 0;
        }
        if (model != null)
        {
            l = model.hashCode();
        } else
        {
            l = 0;
        }
        if (agentName != null)
        {
            i1 = agentName.hashCode();
        } else
        {
            i1 = 0;
        }
        if (agentVersion != null)
        {
            j1 = agentVersion.hashCode();
        } else
        {
            j1 = 0;
        }
        if (deviceId != null)
        {
            k1 = deviceId.hashCode();
        } else
        {
            k1 = 0;
        }
        if (manufacturer != null)
        {
            l1 = manufacturer.hashCode();
        } else
        {
            l1 = 0;
        }
        if (architecture != null)
        {
            i2 = architecture.hashCode();
        } else
        {
            i2 = 0;
        }
        if (runTime != null)
        {
            j2 = runTime.hashCode();
        } else
        {
            j2 = 0;
        }
        if (size != null)
        {
            k2 = size.hashCode();
        }
        return (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k2;
    }

    public void setAgentName(String s)
    {
        agentName = s;
    }

    public void setAgentVersion(String s)
    {
        agentVersion = s;
    }

    public void setArchitecture(String s)
    {
        architecture = s;
    }

    public void setCountryCode(String s)
    {
        countryCode = s;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setManufacturer(String s)
    {
        manufacturer = s;
    }

    public void setMisc(Map map)
    {
        misc = new HashMap(map);
    }

    public void setModel(String s)
    {
        model = s;
    }

    public void setOsBuild(String s)
    {
        osBuild = s;
    }

    public void setOsName(String s)
    {
        osName = s;
    }

    public void setOsVersion(String s)
    {
        osVersion = s;
    }

    public void setRegionCode(String s)
    {
        regionCode = s;
    }

    public void setRunTime(String s)
    {
        runTime = s;
    }

    public void setSize(String s)
    {
        size = s;
        addMisc("size", s);
    }

    public String toJsonString()
    {
        return (new StringBuilder()).append("DeviceInformation{manufacturer='").append(manufacturer).append('\'').append(", osName='").append(osName).append('\'').append(", osVersion='").append(osVersion).append('\'').append(", model='").append(model).append('\'').append(", agentName='").append(agentName).append('\'').append(", agentVersion='").append(agentVersion).append('\'').append(", deviceId='").append(deviceId).append('\'').append(", countryCode='").append(countryCode).append('\'').append(", regionCode='").append(regionCode).append('\'').append('}').toString();
    }
}
