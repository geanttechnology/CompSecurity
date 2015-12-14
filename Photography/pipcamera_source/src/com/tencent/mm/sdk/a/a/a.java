// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.b.c;

// Referenced classes of package com.tencent.mm.sdk.a.a:
//            b

public final class a
{

    public static boolean a(Context context, a a1)
    {
        if (context == null || a1 == null)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        }
        if (c.a(a1.m))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        }
        String s = null;
        if (!c.a(a1.l))
        {
            s = (new StringBuilder()).append(a1.l).append(".permission.MM_MESSAGE").toString();
        }
        Intent intent = new Intent(a1.m);
        if (a1.k != null)
        {
            intent.putExtras(a1.k);
        }
        String s1 = context.getPackageName();
        intent.putExtra("_mmessage_sdkVersion", 0x22010003);
        intent.putExtra("_mmessage_appPackage", s1);
        intent.putExtra("_mmessage_content", a1.j);
        intent.putExtra("_mmessage_checksum", b.a(a1.j, 0x22010003, s1));
        context.sendBroadcast(intent, s);
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", (new StringBuilder("send mm message, intent=")).append(intent).append(", perm=").append(s).toString());
        return true;
    }

    private class a
    {

        public String j;
        public Bundle k;
        public String l;
        public String m;

        public a()
        {
        }
    }

}
