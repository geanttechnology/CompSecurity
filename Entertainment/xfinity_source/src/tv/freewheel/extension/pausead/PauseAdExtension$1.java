// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension.pausead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.extension.ParamParser;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.extension.pausead:
//            PauseAdExtension

class this._cls0
    implements IEventListener
{

    final PauseAdExtension this$0;

    public void run(IEvent ievent)
    {
        if ("false".equalsIgnoreCase((String)(String)ievent.getData().get(PauseAdExtension.access$000(PauseAdExtension.this).INFO_KEY_SUCCESS())))
        {
            PauseAdExtension.access$100(PauseAdExtension.this).debug("RequestComplete: false, return.");
        } else
        if (PauseAdExtension.access$200(PauseAdExtension.this) != null)
        {
            ievent = new ParamParser(PauseAdExtension.access$200(PauseAdExtension.this), "extension.pausead");
            PauseAdExtension.access$302(PauseAdExtension.this, ievent.parseBoolean("enable", Boolean.valueOf(true)));
            if (!PauseAdExtension.access$300(PauseAdExtension.this).booleanValue())
            {
                PauseAdExtension.access$100(PauseAdExtension.this).debug("PauseAdExtension is not enabled, return.");
                return;
            }
            PauseAdExtension.access$100(PauseAdExtension.this).debug("requestCompleteListener()");
            Object obj = PauseAdExtension.access$200(PauseAdExtension.this).getTemporalSlots();
            ievent = PauseAdExtension.access$200(PauseAdExtension.this).getSlotsByTimePositionClass(PauseAdExtension.access$000(PauseAdExtension.this).TIME_POSITION_CLASS_PAUSE_MIDROLL());
            obj = ((ArrayList) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                ISlot islot1 = (ISlot)((Iterator) (obj)).next();
                if (islot1.getTimePositionClass() == PauseAdExtension.access$000(PauseAdExtension.this).TIME_POSITION_CLASS_PREROLL() || islot1.getTimePositionClass() == PauseAdExtension.access$000(PauseAdExtension.this).TIME_POSITION_CLASS_MIDROLL())
                {
                    ArrayList arraylist = new ArrayList();
                    for (int i = 0; i < ievent.size(); i++)
                    {
                        ISlot islot2 = (ISlot)ievent.get(i);
                        if (islot2.getTimePosition() == islot1.getTimePosition())
                        {
                            arraylist.add(islot2.getCustomId());
                        }
                    }

                    if (arraylist.size() > 0)
                    {
                        PauseAdExtension.access$400(PauseAdExtension.this).put(islot1.getCustomId(), arraylist);
                    }
                }
            } while (true);
            ievent = ievent.iterator();
            do
            {
                if (!ievent.hasNext())
                {
                    break;
                }
                ISlot islot = (ISlot)ievent.next();
                if (islot.getTimePosition() != 0.0D)
                {
                    continue;
                }
                PauseAdExtension.access$502(PauseAdExtension.this, islot.getCustomId());
                break;
            } while (true);
            PauseAdExtension.access$100(PauseAdExtension.this).debug((new StringBuilder()).append("toBePlayedPauseSlotCustomId:").append(PauseAdExtension.access$500(PauseAdExtension.this)).toString());
            PauseAdExtension.access$200(PauseAdExtension.this).addEventListener(PauseAdExtension.access$000(PauseAdExtension.this).EVENT_USER_ACTION_NOTIFIED(), userActionNotified);
            PauseAdExtension.access$200(PauseAdExtension.this).addEventListener(PauseAdExtension.access$000(PauseAdExtension.this).EVENT_SLOT_STARTED(), slotStartedListener);
            PauseAdExtension.access$200(PauseAdExtension.this).addEventListener(PauseAdExtension.access$000(PauseAdExtension.this).EVENT_SLOT_ENDED(), slotEndedListener);
            PauseAdExtension.access$200(PauseAdExtension.this).addEventListener(PauseAdExtension.access$000(PauseAdExtension.this).EVENT_AD_IMPRESSION(), adImpressionListener);
            PauseAdExtension.access$200(PauseAdExtension.this).addEventListener(PauseAdExtension.access$000(PauseAdExtension.this).EVENT_ERROR(), adErrorListener);
            return;
        }
    }

    ()
    {
        this$0 = PauseAdExtension.this;
        super();
    }
}
