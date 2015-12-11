// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Iterator;

public class DeviceInfo extends HarvestableObject
{

    private String OSBuild;
    private String OSVersion;
    private String architecture;
    private String deviceName;
    private String deviceUuid;
    private long diskAvailable[];
    private long memoryUsage;
    private String modelNumber;
    private String networkStatus;
    private int orientation;
    private String runTime;
    private String screenResolution;

    public DeviceInfo()
    {
    }

    public DeviceInfo(DeviceInformation deviceinformation, EnvironmentInformation environmentinformation)
    {
        memoryUsage = environmentinformation.getMemoryUsage();
        orientation = environmentinformation.getOrientation();
        networkStatus = environmentinformation.getNetworkStatus();
        diskAvailable = environmentinformation.getDiskAvailable();
        OSVersion = deviceinformation.getOsVersion();
        deviceName = deviceinformation.getManufacturer();
        OSBuild = deviceinformation.getOsBuild();
        architecture = deviceinformation.getArchitecture();
        modelNumber = deviceinformation.getModel();
        screenResolution = deviceinformation.getSize();
        deviceUuid = deviceinformation.getDeviceId();
        runTime = deviceinformation.getRunTime();
    }

    private JsonArray getDiskAvailableAsJson()
    {
        JsonArray jsonarray = new JsonArray();
        long al[] = diskAvailable;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            jsonarray.add(SafeJsonPrimitive.factory(Long.valueOf(al[i])));
        }

        return jsonarray;
    }

    private static long[] longArrayFromJsonArray(JsonArray jsonarray)
    {
        long al[] = new long[jsonarray.size()];
        int i = 0;
        for (jsonarray = jsonarray.iterator(); jsonarray.hasNext();)
        {
            al[i] = ((JsonElement)jsonarray.next()).getAsLong();
            i++;
        }

        return al;
    }

    public static DeviceInfo newFromJson(JsonObject jsonobject)
    {
        DeviceInfo deviceinfo = new DeviceInfo();
        deviceinfo.memoryUsage = jsonobject.get("memoryUsage").getAsLong();
        deviceinfo.orientation = jsonobject.get("orientation").getAsInt();
        deviceinfo.networkStatus = jsonobject.get("networkStatus").getAsString();
        deviceinfo.diskAvailable = longArrayFromJsonArray(jsonobject.get("diskAvailable").getAsJsonArray());
        deviceinfo.OSVersion = jsonobject.get("osVersion").getAsString();
        deviceinfo.deviceName = jsonobject.get("deviceName").getAsString();
        deviceinfo.OSBuild = jsonobject.get("osBuild").getAsString();
        deviceinfo.architecture = jsonobject.get("architecture").getAsString();
        deviceinfo.runTime = jsonobject.get("runTime").getAsString();
        deviceinfo.modelNumber = jsonobject.get("modelNumber").getAsString();
        deviceinfo.screenResolution = jsonobject.get("screenResolution").getAsString();
        deviceinfo.deviceUuid = jsonobject.get("deviceUuid").getAsString();
        return deviceinfo;
    }

    public JsonObject asJsonObject()
    {
        JsonObject jsonobject = new JsonObject();
        jsonobject.add("memoryUsage", SafeJsonPrimitive.factory(Long.valueOf(memoryUsage)));
        jsonobject.add("orientation", SafeJsonPrimitive.factory(Integer.valueOf(orientation)));
        jsonobject.add("networkStatus", SafeJsonPrimitive.factory(networkStatus));
        jsonobject.add("diskAvailable", getDiskAvailableAsJson());
        jsonobject.add("osVersion", SafeJsonPrimitive.factory(OSVersion));
        jsonobject.add("deviceName", SafeJsonPrimitive.factory(deviceName));
        jsonobject.add("osBuild", SafeJsonPrimitive.factory(OSBuild));
        jsonobject.add("architecture", SafeJsonPrimitive.factory(architecture));
        jsonobject.add("runTime", SafeJsonPrimitive.factory(runTime));
        jsonobject.add("modelNumber", SafeJsonPrimitive.factory(modelNumber));
        jsonobject.add("screenResolution", SafeJsonPrimitive.factory(screenResolution));
        jsonobject.add("deviceUuid", SafeJsonPrimitive.factory(deviceUuid));
        return jsonobject;
    }
}
