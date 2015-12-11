// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast;

import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.utils.URLLoader;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast:
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

    _cls9()
    {
        this$0 = VastTranslator.this;
        super();
    }
}
