// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.rhythm.display;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.rhythm.display:
//            RhythmTakeoverRenderer

class this._cls0
    implements IActivityCallbackListener
{

    final RhythmTakeoverRenderer this$0;

    public void onActivityCallback(int i)
    {
        logger.debug((new StringBuilder()).append("onActivityStateChange ").append(i).toString());
        if (i == constants.ACTIVITY_CALLBACK_RESUME())
        {
            logger.info("context activity resumed, ad has ended");
            context.dispatchEvent(constants.EVENT_AD_STOPPED());
        }
    }

    ()
    {
        this$0 = RhythmTakeoverRenderer.this;
        super();
    }
}
