// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import tv.freewheel.hybrid.ad.interfaces.IAdContext;
import tv.freewheel.hybrid.ad.interfaces.IAdInstance;
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
        Object obj;
        int i;
        int j;
        StreamStitcherHelper.access$000(StreamStitcherHelper.this).debug("EVENT_AD_STARTED");
        obj = (String)ievent.getData().get(StreamStitcherHelper.access$200(StreamStitcherHelper.this).INFO_KEY_CUSTOM_ID());
        i = ((Integer)ievent.getData().get(StreamStitcherHelper.access$200(StreamStitcherHelper.this).INFO_KEY_AD_ID())).intValue();
        j = ((Integer)ievent.getData().get(StreamStitcherHelper.access$200(StreamStitcherHelper.this).INFO_KEY_REPLICA_ID())).intValue();
        ievent = StreamStitcherHelper.access$400(StreamStitcherHelper.this).getSlotByCustomId(((String) (obj)));
        if (ievent != null) goto _L2; else goto _L1
_L1:
        StreamStitcherHelper.access$000(StreamStitcherHelper.this).debug((new StringBuilder()).append("Slot not found in current ad context. slot id: ").append(((String) (obj))).toString());
_L4:
        return;
_L2:
        int k = ievent.getTimePositionClass();
        if (k != StreamStitcherHelper.access$200(StreamStitcherHelper.this).TIME_POSITION_CLASS_PREROLL() && k != StreamStitcherHelper.access$200(StreamStitcherHelper.this).TIME_POSITION_CLASS_MIDROLL() && k != StreamStitcherHelper.access$200(StreamStitcherHelper.this).TIME_POSITION_CLASS_POSTROLL())
        {
            StreamStitcherHelper.access$000(StreamStitcherHelper.this).debug((new StringBuilder()).append("Ignore slots other than PRE/MID/POST. slot id: ").append(((String) (obj))).toString());
            return;
        }
        obj = ievent.getAdInstances().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            ievent = (IAdInstance)((Iterator) (obj)).next();
        } while (ievent.getAdId() != i || ievent.getReplicaId() != j);
        StreamStitcherHelper.access$502(StreamStitcherHelper.this, ievent);
        obj = Pair.create(Integer.valueOf(i), Integer.valueOf(j));
        if (!StreamStitcherHelper.access$600(StreamStitcherHelper.this).contains(obj))
        {
            StreamStitcherHelper.access$600(StreamStitcherHelper.this).add(obj);
            StreamStitcherHelper.access$700(StreamStitcherHelper.this, ievent);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ce()
    {
        this$0 = StreamStitcherHelper.this;
        super();
    }
}
