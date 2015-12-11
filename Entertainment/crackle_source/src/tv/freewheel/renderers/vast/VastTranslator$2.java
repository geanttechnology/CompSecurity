// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast;

import java.util.HashMap;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers.vast:
//            VastTranslator

class val.map
    implements Runnable
{

    final VastTranslator this$0;
    final HashMap val$map;

    public void run()
    {
        VastTranslator.access$200(VastTranslator.this).dispatchEvent(VastTranslator.access$100(VastTranslator.this).EVENT_ERROR(), val$map);
    }

    ntext()
    {
        this$0 = final_vasttranslator;
        val$map = HashMap.this;
        super();
    }
}
