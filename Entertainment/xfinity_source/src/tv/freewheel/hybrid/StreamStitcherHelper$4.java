// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid;

import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IAdContext;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid:
//            StreamStitcherHelper

class this._cls0
    implements IEventListener
{

    final StreamStitcherHelper this$0;

    public void run(IEvent ievent)
    {
        ievent = (String)ievent.getData().get(StreamStitcherHelper.access$200(StreamStitcherHelper.this).INFO_KEY_MESSAGE());
        StreamStitcherHelper.access$000(StreamStitcherHelper.this).debug((new StringBuilder()).append("onCuePoint ").append(ievent).toString());
        ievent = StreamStitcherHelper.access$400(StreamStitcherHelper.this).getSlotByCustomId(ievent);
        if (ievent != null)
        {
            ievent.play();
        }
    }

    t()
    {
        this$0 = StreamStitcherHelper.this;
        super();
    }
}
