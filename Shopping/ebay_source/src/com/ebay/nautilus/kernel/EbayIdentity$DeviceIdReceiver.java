// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.ebay.nautilus.kernel:
//            EbayIdentity

public static class  extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        if (EbayIdentity.access$100().A)
        {
            EbayIdentity.log(context, "DeviceIdReceiver:onReceive()");
        }
        if ("com.ebay.nautilus.domain.ACTION_GET_DEVICE_ID".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        if (EbayIdentity.access$100().A)
        {
            EbayIdentity.log(context, (new StringBuilder()).append("Unknown action: ").append(intent.getAction()).toString());
        }
_L4:
        return;
_L2:
        if (1 == intent.getByteExtra("version", (byte)0))
        {
            break; /* Loop/switch isn't completed */
        }
        if (EbayIdentity.access$100().A)
        {
            EbayIdentity.log(context, (new StringBuilder()).append("Expecting version: 1 but got version: ").append(intent.getByteExtra("version", (byte)0)).toString());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        intent = ptedIdForBroadcast(context);
        if (intent != null)
        {
            if (EbayIdentity.access$100().dForBroadcast)
            {
                EbayIdentity.log(context, (new StringBuilder()).append("device ID set: ").append(intent).append(" aborting").toString());
            }
            setResultData(intent);
            abortBroadcast();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public ()
    {
    }
}
