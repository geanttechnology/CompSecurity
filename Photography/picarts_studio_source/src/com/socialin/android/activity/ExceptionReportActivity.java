// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.firegnom.rat.SimpleExceptionActivity;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.FileUtils;
import myobfuscated.f.m;

public class ExceptionReportActivity extends SimpleExceptionActivity
{

    String appName;
    String appType;
    String appUid;

    public ExceptionReportActivity()
    {
        appName = " - ";
        appUid = " - ";
        appType = " - ";
    }

    public String getMoreDetails()
    {
        if (m.a(this, "string", "app_name"))
        {
            appName = getString(m.e(this, "app_name"));
        }
        if (m.a(this, "string", "si_app_uid"))
        {
            appUid = getString(m.e(this, "si_app_uid"));
        }
        if (m.a(this, "string", "app_name_short") && " - ".equals(appUid))
        {
            appUid = getString(m.e(this, "app_name_short"));
        }
        if (m.a(this, "string", "app_type"))
        {
            appType = getString(m.e(this, "app_type"));
        }
        String s = AnalyticUtils.getInstance(getApplicationContext()).getLocalTrackerData();
        try
        {
            Class.forName("com.socialin.android.api.controller.Socialin");
        }
        catch (Exception exception) { }
        return (new StringBuilder("\n\tApp Name: ")).append(appName).append("\n\tApp UID: ").append(appUid).append("\n\tApp Type: ").append(appType).append("\n\tMaxMem: ").append(Runtime.getRuntime().maxMemory() / 0x100000L).append("\n\tHeap: ").append(Runtime.getRuntime().totalMemory() / 0x100000L).append("\n\tPhoneStorage: ").append(FileUtils.a(this)).append("\n\tSDcardAvailable: ").append(FileUtils.d()).append("\n\tSDcard: ").append(FileUtils.c()).append("\n\tProcInfo: ").append(PicsartContext.b).append("\n\tRecomendedPhotoSizeMegapixel: ").append(PicsartContext.a.getRecomendedImageSizeMegapixel()).append("\n\tUserId: ").append(SocialinV3.getInstance().getUser().id).append("\n\tDeviceId: ").append(getSharedPreferences("socialin", 0).getString("device_id", null)).append("\n\tTracker: ").append(s).toString();
    }

    public String getSecurityToken()
    {
        return "SocialInGames2011";
    }

    public String getUrl()
    {
        return "http://t27.socialin.com/services/exception.php";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }
}
