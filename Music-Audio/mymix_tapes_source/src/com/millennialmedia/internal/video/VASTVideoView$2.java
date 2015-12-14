// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView, MMVideoView

class didPause
    implements com.millennialmedia.internal.utils.ilityListener
{

    private boolean didPause;
    final VASTVideoView this$0;

    public void onViewableChanged(boolean flag)
    {
        if (flag)
        {
            List list = VASTVideoView.access$1000(VASTVideoView.this, ableEvent.creativeView);
            VASTVideoView.access$1100(VASTVideoView.this, list);
            if (VASTVideoView.access$1200(VASTVideoView.this) != null && VASTVideoView.access$1200(VASTVideoView.this).linearAd.trackingEvents != null)
            {
                List list1 = (List)VASTVideoView.access$1200(VASTVideoView.this).linearAd.trackingEvents.get(ableEvent.creativeView);
                VASTVideoView.access$1100(VASTVideoView.this, list1);
            }
        }
        if (!flag)
        {
            didPause = true;
            VASTVideoView.access$300(VASTVideoView.this).pause();
        } else
        if (didPause)
        {
            VASTVideoView.access$300(VASTVideoView.this).start();
            return;
        }
    }

    rAd()
    {
        this$0 = VASTVideoView.this;
        super();
        didPause = false;
    }
}
