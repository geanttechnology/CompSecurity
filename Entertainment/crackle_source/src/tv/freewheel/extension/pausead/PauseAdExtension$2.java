// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension.pausead;

import java.util.HashMap;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.extension.pausead:
//            PauseAdExtension

class this._cls0
    implements IEventListener
{

    final PauseAdExtension this$0;

    public void run(IEvent ievent)
    {
        int i = ((Integer)ievent.getData().get(PauseAdExtension.access$000(PauseAdExtension.this).INFO_KEY_USER_ACTION())).intValue();
        if (i == PauseAdExtension.access$000(PauseAdExtension.this).USER_ACTION_PAUSE_BUTTON_CLICKED())
        {
            PauseAdExtension.access$100(PauseAdExtension.this).debug("pauseButtonClicked");
            if (PauseAdExtension.access$500(PauseAdExtension.this) != null)
            {
                ievent = PauseAdExtension.access$200(PauseAdExtension.this).getSlotByCustomId(PauseAdExtension.access$500(PauseAdExtension.this));
                if (ievent != null)
                {
                    PauseAdExtension.access$100(PauseAdExtension.this).debug((new StringBuilder()).append("play slot:").append(PauseAdExtension.access$500(PauseAdExtension.this)).toString());
                    ievent.play();
                }
            }
        } else
        if (i == PauseAdExtension.access$000(PauseAdExtension.this).USER_ACTION_RESUME_BUTTON_CLICKED())
        {
            PauseAdExtension.access$100(PauseAdExtension.this).debug("resumeButtonClicked");
            if (PauseAdExtension.access$600(PauseAdExtension.this) != null)
            {
                ievent = PauseAdExtension.access$200(PauseAdExtension.this).getSlotByCustomId(PauseAdExtension.access$600(PauseAdExtension.this));
                if (ievent != null)
                {
                    PauseAdExtension.access$100(PauseAdExtension.this).debug((new StringBuilder()).append("stop slot:").append(PauseAdExtension.access$600(PauseAdExtension.this)).toString());
                    PauseAdExtension.access$702(PauseAdExtension.this, Boolean.valueOf(false));
                    PauseAdExtension.access$602(PauseAdExtension.this, null);
                    ievent.stop();
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = PauseAdExtension.this;
        super();
    }
}
