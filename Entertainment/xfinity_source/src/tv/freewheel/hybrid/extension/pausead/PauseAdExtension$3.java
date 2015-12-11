// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension.pausead;

import java.util.ArrayList;
import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IAdContext;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.ad.interfaces.ISlot;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.extension.pausead:
//            PauseAdExtension

class this._cls0
    implements IEventListener
{

    final PauseAdExtension this$0;

    public void run(IEvent ievent)
    {
        PauseAdExtension.access$100(PauseAdExtension.this).debug("slotStartedListener");
        ievent = PauseAdExtension.access$200(PauseAdExtension.this).getSlotByCustomId((String)(String)ievent.getData().get(PauseAdExtension.access$000(PauseAdExtension.this).INFO_KEY_CUSTOM_ID()));
        if (PauseAdExtension.access$400(PauseAdExtension.this).containsKey(ievent.getCustomId()))
        {
            ievent = (ArrayList)PauseAdExtension.access$400(PauseAdExtension.this).get(ievent.getCustomId());
            PauseAdExtension.access$502(PauseAdExtension.this, (String)ievent.get((int)Math.floor(Math.random() * (double)ievent.size())));
            PauseAdExtension.access$100(PauseAdExtension.this).debug((new StringBuilder()).append("slotStartedListener, toBePlayedPauseSlotCustomId:").append(PauseAdExtension.access$500(PauseAdExtension.this)).toString());
        } else
        if (ievent.getTimePositionClass() == PauseAdExtension.access$000(PauseAdExtension.this).TIME_POSITION_CLASS_PAUSE_MIDROLL())
        {
            PauseAdExtension.access$602(PauseAdExtension.this, ievent.getCustomId());
            PauseAdExtension.access$100(PauseAdExtension.this).debug((new StringBuilder()).append("slotStartedListener, currentPlayingPauseSlotCustomId:").append(PauseAdExtension.access$600(PauseAdExtension.this)).toString());
            return;
        }
    }

    ()
    {
        this$0 = PauseAdExtension.this;
        super();
    }
}
