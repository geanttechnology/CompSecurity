// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            JSONUtils

class AppInfo
{

    private String applicationLabel;
    private JSONObject packageInfoUrlJSON;
    private String packageName;
    private String versionCode;
    private String versionName;

    protected AppInfo()
    {
    }

    public AppInfo(Context context)
    {
        Object obj;
        packageName = context.getPackageName();
        obj = context.getPackageManager();
        applicationLabel = (String)((PackageManager) (obj)).getApplicationLabel(context.getApplicationInfo());
        context = null;
        obj = ((PackageManager) (obj)).getPackageInfo(packageName, 0);
        context = ((Context) (obj));
_L2:
        String s;
        if (context != null)
        {
            s = ((PackageInfo) (context)).versionName;
        } else
        {
            s = "";
        }
        versionName = s;
        if (context != null)
        {
            context = Integer.toString(((PackageInfo) (context)).versionCode);
        } else
        {
            context = "";
        }
        versionCode = context;
        packageInfoUrlJSON = new JSONObject();
        JSONUtils.put(packageInfoUrlJSON, "lbl", applicationLabel);
        JSONUtils.put(packageInfoUrlJSON, "pn", packageName);
        JSONUtils.put(packageInfoUrlJSON, "v", versionCode);
        JSONUtils.put(packageInfoUrlJSON, "vn", versionName);
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public JSONObject getPackageInfoJSON()
    {
        return packageInfoUrlJSON;
    }

    public String getPackageInfoJSONString()
    {
        if (packageInfoUrlJSON != null)
        {
            return packageInfoUrlJSON.toString();
        } else
        {
            return null;
        }
    }
}
