// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.autoupdatesdk.obf.ad;
import com.baidu.autoupdatesdk.obf.h;
import com.baidu.autoupdatesdk.obf.j;
import com.baidu.autoupdatesdk.obf.k;
import com.baidu.autoupdatesdk.obf.l;

// Referenced classes of package com.baidu.autoupdatesdk:
//            UICheckUpdateCallback, CPCheckUpdateCallback, AppUpdateInfo, CPUpdateDownloadCallback

public class BDAutoUpdateSDK
{

    public static final int RESULT_CODE_ERROR_UNKNOWN = 0x80000000;
    public static final int RESULT_CODE_NET_ERROR = -1;
    public static final int RESULT_CODE_OK = 0;
    public static final int RESULT_CODE_PARSE_ERROR = -2;

    public BDAutoUpdateSDK()
    {
    }

    public static void asUpdateAction(Context context, UICheckUpdateCallback uicheckupdatecallback)
    {
        (new h()).a(context, uicheckupdatecallback);
    }

    public static void cpUpdateCheck(Context context, CPCheckUpdateCallback cpcheckupdatecallback)
    {
        (new j()).a(context, cpcheckupdatecallback);
    }

    public static void cpUpdateDownload(Context context, AppUpdateInfo appupdateinfo, CPUpdateDownloadCallback cpupdatedownloadcallback)
    {
        (new j()).a(context, appupdateinfo, cpupdatedownloadcallback);
    }

    public static void cpUpdateInstall(Context context, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            ad.b(context, s);
        }
    }

    public static void silenceUpdateAction(Context context)
    {
        (new k()).a(context);
    }

    public static void uiUpdateAction(Context context, UICheckUpdateCallback uicheckupdatecallback)
    {
        (new l()).a(context, uicheckupdatecallback);
    }
}
