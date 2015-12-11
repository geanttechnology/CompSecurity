// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.tremor;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers.tremor:
//            TremorVideoRenderer

class val.constants
    implements IActivityCallbackListener
{

    final TremorVideoRenderer this$0;
    final IConstants val$constants;

    public void onActivityCallback(int i)
    {
        if (i == val$constants.ACTIVITY_CALLBACK_RESUME())
        {
            TremorVideoRenderer.access$000(TremorVideoRenderer.this).dispatchEvent(val$constants.EVENT_AD_STOPPED());
        }
    }

    istener()
    {
        this$0 = final_tremorvideorenderer;
        val$constants = IConstants.this;
        super();
    }
}
