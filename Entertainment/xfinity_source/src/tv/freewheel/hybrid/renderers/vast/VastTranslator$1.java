// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast;

import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.renderers.interfaces.IRendererContext;
import tv.freewheel.hybrid.utils.URLLoader;

// Referenced classes of package tv.freewheel.hybrid.renderers.vast:
//            VastTranslator

class this._cls0
    implements Runnable
{

    final VastTranslator this$0;

    public void run()
    {
        VastTranslator.access$000(VastTranslator.this).removeAllListeners();
        VastTranslator.access$000(VastTranslator.this).close();
        VastTranslator.access$200(VastTranslator.this).dispatchEvent(VastTranslator.access$100(VastTranslator.this).EVENT_AD_STOPPED());
    }

    ntext()
    {
        this$0 = VastTranslator.this;
        super();
    }
}
