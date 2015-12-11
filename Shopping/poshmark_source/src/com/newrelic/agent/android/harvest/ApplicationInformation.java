// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

public class ApplicationInformation extends HarvestableArray
{

    private String appBuild;
    private String appName;
    private String appVersion;
    private String packageId;
    private int versionCode;

    public ApplicationInformation()
    {
        versionCode = -1;
    }

    public ApplicationInformation(String s, String s1, String s2, String s3)
    {
        this();
        appName = s;
        appVersion = s1;
        packageId = s2;
        appBuild = s3;
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        notEmpty(appName);
        jsonarray.add(new JsonPrimitive(appName));
        notEmpty(appVersion);
        jsonarray.add(new JsonPrimitive(appVersion));
        notEmpty(packageId);
        jsonarray.add(new JsonPrimitive(packageId));
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
            obj = (ApplicationInformation)obj;
            if (appName == null ? ((ApplicationInformation) (obj)).appName != null : !appName.equals(((ApplicationInformation) (obj)).appName))
            {
                return false;
            }
            if (appVersion == null ? ((ApplicationInformation) (obj)).appVersion != null : !appVersion.equals(((ApplicationInformation) (obj)).appVersion))
            {
                return false;
            }
            if (appBuild == null ? ((ApplicationInformation) (obj)).appBuild != null : !appBuild.equals(((ApplicationInformation) (obj)).appBuild))
            {
                return false;
            }
            if (packageId == null ? ((ApplicationInformation) (obj)).packageId != null : !packageId.equals(((ApplicationInformation) (obj)).packageId))
            {
                return false;
            }
            if (versionCode != ((ApplicationInformation) (obj)).versionCode)
            {
                return false;
            }
        }
        return true;
    }

    public String getAppBuild()
    {
        return appBuild;
    }

    public String getAppName()
    {
        return appName;
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public String getPackageId()
    {
        return packageId;
    }

    public int getVersionCode()
    {
        return versionCode;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (appName != null)
        {
            i = appName.hashCode();
        } else
        {
            i = 0;
        }
        if (appVersion != null)
        {
            j = appVersion.hashCode();
        } else
        {
            j = 0;
        }
        if (appBuild != null)
        {
            k = appBuild.hashCode();
        } else
        {
            k = 0;
        }
        if (packageId != null)
        {
            l = packageId.hashCode();
        }
        return ((i * 31 + j) * 31 + k) * 31 + l;
    }

    public boolean isAppUpgrade(ApplicationInformation applicationinformation)
    {
        if (applicationinformation.versionCode == -1)
        {
            return versionCode >= 0 && applicationinformation.appVersion != null;
        }
        return versionCode > applicationinformation.versionCode;
    }

    public void setAppBuild(String s)
    {
        appBuild = s;
    }

    public void setAppName(String s)
    {
        appName = s;
    }

    public void setAppVersion(String s)
    {
        appVersion = s;
    }

    public void setPackageId(String s)
    {
        packageId = s;
    }

    public void setVersionCode(int i)
    {
        versionCode = i;
    }
}
