// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension.medialets;

import java.util.HashMap;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.extension.medialets:
//            MedialetsExtension

class this._cls0
    implements IEventListener
{

    final MedialetsExtension this$0;

    public void run(IEvent ievent)
    {
        ievent = (Integer)ievent.getData().get(MedialetsExtension.access$300(MedialetsExtension.this).INFO_KEY_ACTIVITY_STATE());
        MedialetsExtension.access$600(MedialetsExtension.this).debug((new StringBuilder()).append("EVENT_ACTIVITY_STATE_CHANGED, state=").append(ievent).toString());
        if (ievent.intValue() == MedialetsExtension.access$300(MedialetsExtension.this).ACTIVITY_CALLBACK_PAUSE())
        {
            MedialetsExtension.access$600(MedialetsExtension.this).debug("The activity paused.");
            MedialetsExtension.access$708();
        } else
        if (ievent.intValue() == MedialetsExtension.access$300(MedialetsExtension.this).ACTIVITY_CALLBACK_RESUME())
        {
            MedialetsExtension.access$600(MedialetsExtension.this).debug("The activity resumed.");
            MedialetsExtension.access$710();
            if (MedialetsExtension.access$700() == 0)
            {
                MedialetsExtension.access$800(MedialetsExtension.this, dialetsAdmanagerState.RESUME);
            }
            if (MedialetsExtension.access$700() < 0)
            {
                int _tmp = MedialetsExtension.access$702(0);
                return;
            }
        }
    }

    dialetsAdmanagerState()
    {
        this$0 = MedialetsExtension.this;
        super();
    }
}
