// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.ftue;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.amazon.logging.Logger;
import com.amazon.venezia.logging.Loggers;

public class InferenceResponseReceiver extends BroadcastReceiver
{
    public static interface Listener
    {

        public abstract void onInferenceComplete(Intent intent);

        public abstract void onInferenceRequiresInteraction(Intent intent);
    }


    private static final Logger LOG = Loggers.logger(com/amazon/client/ftue/InferenceResponseReceiver);
    private final Listener listener;

    public InferenceResponseReceiver(Listener listener1)
    {
        listener = listener1;
    }

    public IntentFilter getIntentFilter()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.amazon.mas.client.authentication.InferredCorPfm.RESPONSE");
        intentfilter.addAction("com.amazon.mas.client.authentication.InferredCorPfm.INTERACTIVE");
        return intentfilter;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (listener != null)
        {
            context = intent.getAction();
            if ("com.amazon.mas.client.authentication.InferredCorPfm.RESPONSE".equals(context))
            {
                LOG.d("Received FTUE Inference broadcast");
                listener.onInferenceComplete(intent);
            } else
            if ("com.amazon.mas.client.authentication.InferredCorPfm.INTERACTIVE".equals(context))
            {
                listener.onInferenceRequiresInteraction(intent);
                return;
            }
        }
    }

}
