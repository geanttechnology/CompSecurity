// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.Wearable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

static final class val.stampedData
    implements ResultCallback
{

    final String val$replyPath;
    final byte val$stampedData[];

    public volatile void onResult(Result result)
    {
        onResult((com.google.android.gms.wearable.ult)result);
    }

    public void onResult(com.google.android.gms.wearable.ult ult)
    {
        Node node;
        for (ult = ult.getNodes().iterator(); ult.hasNext(); Wearable.MessageApi.sendMessage(MShopWearListenerService.access$1300(), node.getId(), val$replyPath, val$stampedData).await())
        {
            node = (Node)ult.next();
        }

    }

    sult(String s, byte abyte0[])
    {
        val$replyPath = s;
        val$stampedData = abyte0;
        super();
    }
}
