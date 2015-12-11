// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast;

import java.util.HashMap;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.utils.URLLoader;

// Referenced classes of package tv.freewheel.renderers.vast:
//            VastTranslator

class this._cls0
    implements IEventListener
{

    final VastTranslator this$0;

    public void run(IEvent ievent)
    {
        VastTranslator.access$000(VastTranslator.this).removeAllListeners();
        ievent = (String)ievent.getData().get(VastTranslator.access$100(VastTranslator.this).INFO_KEY_MESSAGE());
        VastTranslator.access$300(VastTranslator.this, ievent);
    }

    ()
    {
        this$0 = VastTranslator.this;
        super();
    }
}
