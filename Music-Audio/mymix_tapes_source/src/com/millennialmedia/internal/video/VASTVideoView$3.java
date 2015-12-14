// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class this._cls0
    implements com.millennialmedia.internal.utils.ilityListener
{

    final VASTVideoView this$0;

    public void onViewableChanged(boolean flag)
    {
        if (flag && VASTVideoView.access$1300(VASTVideoView.this).trackingEvents != null && !VASTVideoView.access$1300(VASTVideoView.this).trackingEvents.isEmpty())
        {
            List list = (List)VASTVideoView.access$1300(VASTVideoView.this).trackingEvents.get(ableEvent.creativeView);
            VASTVideoView.access$1100(VASTVideoView.this, list);
        }
    }

    ableEvent()
    {
        this$0 = VASTVideoView.this;
        super();
    }
}
