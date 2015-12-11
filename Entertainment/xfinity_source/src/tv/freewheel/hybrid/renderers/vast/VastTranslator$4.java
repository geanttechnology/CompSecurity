// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast;

import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.utils.Logger;
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
        VastTranslator.access$400(VastTranslator.this).verbose((new StringBuilder()).append("request failed: ").append(ievent).toString());
        VastTranslator.access$500(VastTranslator.this, VastTranslator.access$100(VastTranslator.this).ERROR_IO(), (new StringBuilder()).append("Failed to load VAST document ").append(ievent).append(".").toString());
    }

    _cls9()
    {
        this$0 = VastTranslator.this;
        super();
    }
}
