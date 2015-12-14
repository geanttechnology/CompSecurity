// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;

public final class a
{

    public static boolean a(Context context, a a1)
    {
        if (context == null || a1 == null)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        }
        if (c.a(a1.h))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", (new StringBuilder("send fail, invalid targetPkgName, targetPkgName = ")).append(a1.h).toString());
            return false;
        }
        if (c.a(a1.i))
        {
            a1.i = (new StringBuilder()).append(a1.h).append(".wxapi.WXEntryActivity").toString();
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", (new StringBuilder("send, targetPkgName = ")).append(a1.h).append(", targetClassName = ").append(a1.i).toString());
        Intent intent = new Intent();
        intent.setClassName(a1.h, a1.i);
        if (a1.k != null)
        {
            intent.putExtras(a1.k);
        }
        String s = context.getPackageName();
        intent.putExtra("_mmessage_sdkVersion", 0x22010003);
        intent.putExtra("_mmessage_appPackage", s);
        intent.putExtra("_mmessage_content", a1.j);
        intent.putExtra("_mmessage_checksum", b.a(a1.j, 0x22010003, s));
        if (a1.flags == -1)
        {
            intent.addFlags(0x10000000).addFlags(0x8000000);
        } else
        {
            intent.setFlags(a1.flags);
        }
        try
        {
            context.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", new Object[] {
                context.getMessage()
            });
            return false;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", (new StringBuilder("send mm message, intent=")).append(intent).toString());
        return true;
    }

    private class a
    {

        public int flags;
        public String h;
        public String i;
        public String j;
        public Bundle k;

        public a()
        {
            flags = -1;
        }
    }

}
