// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import android.view.View;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;

// Referenced classes of package com.shazam.android.activities.streaming:
//            StreamingProviderUpsellDialogActivity

private final class <init>
    implements android.view.iderUpsellDialogActivity.b
{

    final StreamingProviderUpsellDialogActivity a;

    public final void onClick(View view)
    {
        StreamingProviderUpsellDialogActivity.a(a).logEvent(view, StreamingEventFactory.createStreamingProviderUpsellCancelUserEvent());
        StreamingProviderUpsellDialogActivity.b(a);
        a.finish();
    }

    private (StreamingProviderUpsellDialogActivity streamingproviderupselldialogactivity)
    {
        a = streamingproviderupselldialogactivity;
        super();
    }

    a(StreamingProviderUpsellDialogActivity streamingproviderupselldialogactivity, byte byte0)
    {
        this(streamingproviderupselldialogactivity);
    }
}
