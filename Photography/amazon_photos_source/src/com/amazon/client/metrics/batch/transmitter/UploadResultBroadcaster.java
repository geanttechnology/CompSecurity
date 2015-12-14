// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.transmitter;

import android.content.Context;
import android.content.Intent;

public class UploadResultBroadcaster
{

    private Context mContext;

    public UploadResultBroadcaster(Context context)
    {
        mContext = context;
    }

    public void broadcastResult(int i, int j, String s)
    {
        mContext.sendBroadcast((new Intent("com.amazon.intent.action.METRICS_UPLOAD_RESULT")).putExtra("NUM_BATCHES_SENT", j).putExtra("RESULT_CODE", i).putExtra("QUEUE_NAME", s));
    }
}
