// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.PrintStream;

// Referenced classes of package com.igexin.sdk:
//            SdkService

public class PayloadReceiver extends BroadcastReceiver
{

    public PayloadReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj;
        obj = intent.getExtras();
        break MISSING_BLOCK_LABEL_5;
        if (obj != null && ((Bundle) (obj)).getInt("action") == 10001)
        {
            intent = ((Bundle) (obj)).getByteArray("payload");
            if (intent != null)
            {
                intent = new String(intent);
                obj = ((Bundle) (obj)).getString("payloadid");
                System.out.println((new StringBuilder()).append("vPayloadid = ").append(((String) (obj))).toString());
                System.out.println((new StringBuilder()).append("vpayload = ").append(intent).toString());
                Intent intent1 = new Intent(context.getApplicationContext(), com/igexin/sdk/SdkService);
                intent1.setAction("com.igexin.sdk.payloadreceived");
                intent1.putExtra("vPayload", intent);
                intent1.putExtra("vPayloadid", ((String) (obj)));
                context.getApplicationContext().startService(intent1);
                return;
            }
        }
        return;
    }
}
