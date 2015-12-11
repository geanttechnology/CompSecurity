// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.channel.compatible.MMessageUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class MMessageActV2
{
    public static class Args
    {

        public Bundle bundle;
        public String content;
        public int flags;
        public String targetClassName;
        public String targetPkgName;

        public Args()
        {
            flags = -1;
        }
    }


    public MMessageActV2()
    {
    }

    public static boolean send(Context context, Args args)
    {
        if (context == null || args == null)
        {
            Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        }
        if (Util.isNullOrNil(args.targetPkgName))
        {
            Log.e("MicroMsg.SDK.MMessageAct", (new StringBuilder()).append("send fail, invalid targetPkgName, targetPkgName = ").append(args.targetPkgName).toString());
            return false;
        }
        if (Util.isNullOrNil(args.targetClassName))
        {
            args.targetClassName = (new StringBuilder()).append(args.targetPkgName).append(".wxapi.WXEntryActivity").toString();
        }
        Log.d("MicroMsg.SDK.MMessageAct", (new StringBuilder()).append("send, targetPkgName = ").append(args.targetPkgName).append(", targetClassName = ").append(args.targetClassName).toString());
        Intent intent = new Intent();
        intent.setClassName(args.targetPkgName, args.targetClassName);
        if (args.bundle != null)
        {
            intent.putExtras(args.bundle);
        }
        String s = context.getPackageName();
        intent.putExtra("_mmessage_sdkVersion", 0x22010003);
        intent.putExtra("_mmessage_appPackage", s);
        intent.putExtra("_mmessage_content", args.content);
        intent.putExtra("_mmessage_checksum", MMessageUtil.genCheckSum(args.content, 0x22010003, s));
        if (args.flags == -1)
        {
            intent.addFlags(0x10000000).addFlags(0x8000000);
        } else
        {
            intent.setFlags(args.flags);
        }
        try
        {
            context.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", new Object[] {
                context.getMessage()
            });
            return false;
        }
        Log.d("MicroMsg.SDK.MMessageAct", (new StringBuilder()).append("send mm message, intent=").append(intent).toString());
        return true;
    }
}
