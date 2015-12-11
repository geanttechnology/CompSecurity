// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
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
            jsonarray.add(new JsonPrimitive(Long.valueOf(al[i])));
        }

        return jsonarray;
    }

    private static long[] longArrayFromJsonArray(JsonArray jsonarray)
    {
        long al[] = new long[jsonarray.size()];
        jsonarray = jsonarray.iterator();
        for (int i = 0; jsonarray.hasNext(); i++)
        {
            al[i] = ((JsonElement)jsonarray.next()).getAsLong();
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
        jsonobject.add("memoryUsage", new JsonPrimitive(Long.valueOf(memoryUsage)));
        jsonobject.add("orientation", new JsonPrimitive(Integer.valueOf(orientation)));
        jsonobject.add("networkStatus", new JsonPrimitive(networkStatus));
        jsonobject.add("diskAvailable", getDiskAvailableAsJson());
        jsonobject.add("osVersion", new JsonPrimitive(OSVersion));
        jsonobject.add("deviceName", new JsonPrimitive(deviceName));
        jsonobject.add("osBuild", new JsonPrimitive(OSBuild));
        jsonobject.add("architecture", new JsonPrimitive(architecture));
        jsonobject.add("runTime", new JsonPrimitive(runTime));
        jsonobject.add("modelNumber", new JsonPrimitive(modelNumber));
        jsonobject.add("screenResolution", new JsonPrimitive(screenResolution));
        jsonobject.add("deviceUuid", new JsonPrimitive(deviceUuid));
        return jsonobject;
    }
}
