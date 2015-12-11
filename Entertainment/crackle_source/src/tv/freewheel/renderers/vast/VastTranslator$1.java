// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.URLLoader;

// Referenced classes of package tv.freewheel.renderers.vast:
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
