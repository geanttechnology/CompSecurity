// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.data;

import java.util.HashMap;
import java.util.Map;

public class PhoneInfo
{

    private String channelid;
    private String deviceid;
    private String imei;
    private String model;
    private String system_version;
    private String type;
    private String uuid;
    private String version;

    public PhoneInfo()
    {
    }

    public String getImei()
    {
        return imei;
    }

    public Map getJsonMap()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("model", model);
        hashmap.put("type", type);
        hashmap.put("system_version", system_version);
        hashmap.put("sim", uuid);
        hashmap.put("imei", uuid);
        hashmap.put("version", version);
        hashmap.put("channelid", channelid);
        hashmap.put("deviceid", deviceid);
        return hashmap;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setChannelid(String s)
    {
        channelid = s;
    }

    public void setDeviceid(String s)
    {
        deviceid = s;
    }

    public void setImei(String s)
    {
        imei = s;
    }

    public void setModel(String s)
    {
        model = s;
    }

    public void setSystem_version(String s)
    {
        system_version = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUuid(String s)
    {
        uuid = s;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
