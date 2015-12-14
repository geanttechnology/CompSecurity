// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;

// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            NewPromotionNotification

class this._cls0 extends BroadcastReceiver
{

    final NewPromotionNotification this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (NewPromotionNotification.access$000(NewPromotionNotification.this) != null)
        {
            NewPromotionNotification.access$000(NewPromotionNotification.this).trackEvent(tricsEvent.DismissedNotification);
        }
        context.unregisterReceiver(this);
        NewPromotionNotification.access$102(NewPromotionNotification.this, null);
    }

    tricsEvent()
    {
        this$0 = NewPromotionNotification.this;
        super();
    }
}
