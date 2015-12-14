// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.channel;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.channel:
//            MMessageUtil

public class MMessageAct
{

    public MMessageAct()
    {
    }

    public static boolean send(Context context, String s, String s1)
    {
        return send(context, s, (new StringBuilder()).append(s).append(".wxapi.WXEntryActivity").toString(), s1, null);
    }

    public static boolean send(Context context, String s, String s1, Bundle bundle)
    {
        return send(context, s, (new StringBuilder()).append(s).append(".wxapi.WXEntryActivity").toString(), s1, bundle);
    }

    public static boolean send(Context context, String s, String s1, String s2, Bundle bundle)
    {
        if (context == null || s == null || s.length() == 0 || s1 == null || s1.length() == 0)
        {
            Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid arguments");
            return false;
        }
        Intent intent = new Intent();
        intent.setClassName(s, s1);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        s = context.getPackageName();
        intent.putExtra("_mmessage_sdkVersion", 0x21030001);
        intent.putExtra("_mmessage_appPackage", s);
        intent.putExtra("_mmessage_content", s2);
        intent.putExtra("_mmessage_checksum", MMessageUtil.a(s2, s));
        intent.addFlags(0x10000000).addFlags(0x8000000);
        try
        {
            context.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("MicroMsg.SDK.MMessageAct", "send fail, target ActivityNotFound");
            return false;
        }
        Log.d("MicroMsg.SDK.MMessageAct", (new StringBuilder("send mm message, intent=")).append(intent).toString());
        return true;
    }

    public static boolean sendToWx(Context context, String s)
    {
        return send(context, "com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity", s, null);
    }

    public static boolean sendToWx(Context context, String s, Bundle bundle)
    {
        return send(context, "com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity", s, bundle);
    }
}
