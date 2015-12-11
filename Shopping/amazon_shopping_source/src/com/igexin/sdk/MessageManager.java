// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

// Referenced classes of package com.igexin.sdk:
//            SdkService

public class MessageManager
{

    private static MessageManager instance;

    public MessageManager()
    {
    }

    public static MessageManager getInstance()
    {
        if (instance == null)
        {
            instance = new MessageManager();
        }
        return instance;
    }

    public void initialize(Context context)
    {
        Object obj;
        obj = context.getApplicationContext().getPackageName();
        obj = context.getPackageManager().getApplicationInfo(((String) (obj)), 128);
        if (((ApplicationInfo) (obj)).metaData == null) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        s = ((ApplicationInfo) (obj)).metaData.getString("VPUSH_APPID");
        s1 = ((ApplicationInfo) (obj)).metaData.getString("VPUSH_APPSECRET");
        if (((ApplicationInfo) (obj)).metaData.get("VPUSH_APPKEY") == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        obj = ((ApplicationInfo) (obj)).metaData.get("VPUSH_APPKEY").toString();
_L3:
        if (s != null && s1 != null && obj != null)
        {
            try
            {
                context.getApplicationContext().startService(new Intent(context.getApplicationContext(), com/igexin/sdk/SdkService));
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                namenotfoundexception.printStackTrace();
            }
        }
_L2:
        context.getFilesDir();
        return;
        obj = null;
          goto _L3
    }

    public void startWeb(Context context, String s)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(0x10000000);
        intent.setData(Uri.parse(s));
        context.startActivity(intent);
    }
}
