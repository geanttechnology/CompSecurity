// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.channel:
//            MMessageUtil

public class MMessage
{

    public MMessage()
    {
    }

    public static void send(Context context, String s, String s1)
    {
        send(context, s, "com.tencent.mm.sdk.channel.Intent.ACTION_MESSAGE", s1);
    }

    public static void send(Context context, String s, String s1, String s2)
    {
        send(context, s, s1, s2, null);
    }

    public static boolean send(Context context, String s, String s1, String s2, Bundle bundle)
    {
        s = (new StringBuilder()).append(s).append(".permission.MM_MESSAGE").toString();
        s1 = new Intent(s1);
        if (bundle != null)
        {
            s1.putExtras(bundle);
        }
        bundle = context.getPackageName();
        s1.putExtra("_mmessage_sdkVersion", 0x21030001);
        s1.putExtra("_mmessage_appPackage", bundle);
        s1.putExtra("_mmessage_content", s2);
        s1.putExtra("_mmessage_checksum", MMessageUtil.a(s2, bundle));
        context.sendBroadcast(s1, s);
        Log.d("MicroMsg.SDK.MMessage", (new StringBuilder("send mm message, intent=")).append(s1).append(", perm=").append(s).toString());
        return true;
    }
}
