// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

public class ApplicationInfo extends HarvestableObject
{

    private String applicationBuild;
    private String applicationName;
    private String applicationVersion;
    private String bundleId;
    private int processId;

    public ApplicationInfo()
    {
        applicationName = "";
        applicationVersion = "";
        applicationBuild = "";
        bundleId = "";
        processId = 0;
    }

    public ApplicationInfo(ApplicationInformation applicationinformation)
    {
        applicationName = "";
        applicationVersion = "";
        applicationBuild = "";
        bundleId = "";
        processId = 0;
        applicationName = applicationinformation.getAppName();
        applicationVersion = applicationinformation.getAppVersion();
        applicationBuild = applicationinformation.getAppBuild();
        bundleId = applicationinformation.getPackageId();
    }

    public static ApplicationInfo newFromJson(JsonObject jsonobject)
    {
        ApplicationInfo applicationinfo = new ApplicationInfo();
        applicationinfo.applicationName = jsonobject.get("appName").getAsString();
        applicationinfo.applicationVersion = jsonobject.get("appVersion").getAsString();
        applicationinfo.applicationBuild = jsonobject.get("appBuild").getAsString();
        applicationinfo.bundleId = jsonobject.get("bundleId").getAsString();
        applicationinfo.processId = jsonobject.get("processId").getAsInt();
        return applicationinfo;
    }

    public JsonObject asJsonObject()
    {
        JsonObject jsonobject = new JsonObject();
        jsonobject.add("appName", new JsonPrimitive(applicationName));
        jsonobject.add("appVersion", new JsonPrimitive(applicationVersion));
        jsonobject.add("appBuild", new JsonPrimitive(applicationBuild));
        jsonobject.add("bundleId", new JsonPrimitive(bundleId));
        jsonobject.add("processId", new JsonPrimitive(Integer.valueOf(processId)));
        return jsonobject;
    }
}
