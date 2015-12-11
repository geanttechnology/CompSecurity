// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid;

import android.util.Pair;
import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid:
//            StreamStitcherHelper

class this._cls0
    implements IEventListener
{

    final StreamStitcherHelper this$0;

    public void run(IEvent ievent)
    {
        StreamStitcherHelper.access$000(StreamStitcherHelper.this).debug("EVENT_REQUEST_COMPLETE");
        StreamStitcherHelper.access$102(StreamStitcherHelper.this, Boolean.valueOf(false));
        if ("false".equalsIgnoreCase((String)ievent.getData().get(StreamStitcherHelper.access$200(StreamStitcherHelper.this).INFO_KEY_SUCCESS())))
        {
            StreamStitcherHelper.access$000(StreamStitcherHelper.this).warn("Ad request failed.");
        } else
        if (StreamStitcherHelper.access$300(StreamStitcherHelper.this) != null)
        {
            handleMetadata("TIT2", (String)StreamStitcherHelper.access$300(StreamStitcherHelper.this).first, ((Long)StreamStitcherHelper.access$300(StreamStitcherHelper.this).second).longValue());
            return;
        }
    }

    s()
    {
        this$0 = StreamStitcherHelper.this;
        super();
    }
}
