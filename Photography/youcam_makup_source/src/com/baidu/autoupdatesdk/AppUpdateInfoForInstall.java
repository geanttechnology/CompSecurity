// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.baidu.autoupdatesdk:
//            AppUpdateInfo

public class AppUpdateInfoForInstall
{

    private String a;
    private String b;
    private String c;
    private String d;

    private AppUpdateInfoForInstall()
    {
    }

    public static AppUpdateInfoForInstall build(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            s = new AppUpdateInfoForInstall();
            s.a = jsonobject.optString("appSName");
            s.b = jsonobject.optString("appVersionName");
            s.c = jsonobject.optString("appChangeLog");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = null;
        }
        return s;
    }

    public static String toJson(AppUpdateInfo appupdateinfo)
    {
        Object obj = null;
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("appSName", appupdateinfo.getAppSname());
            jsonobject.put("appVersionName", appupdateinfo.getAppVersionName());
            jsonobject.put("appChangeLog", appupdateinfo.getAppChangeLog());
        }
        // Misplaced declaration of an exception variable
        catch (AppUpdateInfo appupdateinfo)
        {
            appupdateinfo.printStackTrace();
            return null;
        }
        appupdateinfo = obj;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        appupdateinfo = jsonobject.toString();
        return appupdateinfo;
    }

    public String getAppChangeLog()
    {
        return c;
    }

    public String getAppSName()
    {
        return a;
    }

    public String getAppVersionName()
    {
        return b;
    }

    public String getInstallPath()
    {
        return d;
    }

    public void setInstallPath(String s)
    {
        d = s;
    }
}
