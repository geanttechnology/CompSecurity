// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.channel.compatible;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

// Referenced classes of package com.tencent.mm.sdk.channel.compatible:
//            MMessageUtil

public class MMessage
{
    public static class Args
    {

        public String action;
        public Bundle bundle;
        public String content;
        public String targetPkg;

        public Args()
        {
        }
    }


    public MMessage()
    {
    }

    public static boolean send(Context context, Args args)
    {
        if (context == null || args == null)
        {
            Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        }
        if (Util.isNullOrNil(args.action))
        {
            Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        }
        String s = null;
        if (!Util.isNullOrNil(args.targetPkg))
        {
            s = (new StringBuilder()).append(args.targetPkg).append(".permission.MM_MESSAGE").toString();
        }
        Intent intent = new Intent(args.action);
        if (args.bundle != null)
        {
            intent.putExtras(args.bundle);
        }
        String s1 = context.getPackageName();
        intent.putExtra("_mmessage_sdkVersion", 0x22010003);
        intent.putExtra("_mmessage_appPackage", s1);
        intent.putExtra("_mmessage_content", args.content);
        intent.putExtra("_mmessage_checksum", MMessageUtil.genCheckSum(args.content, 0x22010003, s1));
        context.sendBroadcast(intent, s);
        Log.d("MicroMsg.SDK.MMessage", (new StringBuilder()).append("send mm message, intent=").append(intent).append(", perm=").append(s).toString());
        return true;
    }
}
