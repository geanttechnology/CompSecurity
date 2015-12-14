// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.uid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.commons.core.utilities.uid:
//            b, c

public class ImIdShareBroadCastReceiver extends BroadcastReceiver
{

    private static final String a = com/inmobi/commons/core/utilities/uid/ImIdShareBroadCastReceiver.getSimpleName();

    public ImIdShareBroadCastReceiver()
    {
    }

    public static String a(String s, String s1)
    {
        if (s != null || s1 != null) goto _L2; else goto _L1
_L1:
        s1 = null;
_L4:
        return s1;
_L2:
        if (s != null && s1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s != null)
        {
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
        String as[] = s.split(",");
        int i = 0;
        s = s1;
        do
        {
            s1 = s;
            if (i >= as.length)
            {
                continue;
            }
            s1 = s;
            if (!s.contains(as[i]))
            {
                s1 = (new StringBuilder()).append(s).append(",").append(as[i]).toString();
            }
            i++;
            s = s1;
        } while (true);
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("com.inmobi.share.id"))
        {
            b b1 = new b(context);
            String s3 = intent.getExtras().getString("appid");
            String s = b1.d();
            String s4 = intent.getExtras().getString("imid");
            String s1 = b1.f();
            String s2 = intent.getExtras().getString("appendedid");
            long l = b1.e();
            long l1 = intent.getExtras().getLong("imidts");
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Received broadcast for IDs. Received ID:").append(s4).append(" AppID:").append(s3).append(" AID:").append(s2).toString());
            if (s1 != null && s3 != null)
            {
                if (!s1.contains(s3))
                {
                    if (l1 < l)
                    {
                        b1.c(s4);
                    }
                    intent = new Intent();
                    intent.setAction("com.inmobi.share.id");
                    intent.putExtra("imid", s);
                    intent.putExtra("appendedid", s1);
                    intent.putExtra("imidts", l);
                    intent.putExtra("appid", c.a().c());
                    context.sendBroadcast(intent);
                }
                b1.d(a(s2, s1));
            }
        }
    }

}
