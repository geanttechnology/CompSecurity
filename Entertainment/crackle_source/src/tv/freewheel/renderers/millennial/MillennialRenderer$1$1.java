// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.millennial;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.millennial:
//            MillennialRenderer

class this._cls1
    implements IActivityCallbackListener
{

    final  this$1;

    public void onActivityCallback(int i)
    {
label0:
        {
            MillennialRenderer.access$000(_fld0).debug((new StringBuilder()).append("onActivityCallback(").append(i).append(")").toString());
            if (i == MillennialRenderer.access$800(_fld0).ACTIVITY_CALLBACK_RESUME())
            {
                MillennialRenderer.access$000(_fld0).debug("Content activity resumed");
                if (MillennialRenderer.access$900(_fld0).getTimePositionClass() != MillennialRenderer.access$800(_fld0).TIME_POSITION_CLASS_DISPLAY())
                {
                    break label0;
                }
                MillennialRenderer.access$1000(_fld0).dispatchEvent(MillennialRenderer.access$800(_fld0).EVENT_REQUEST_CONTENT_VIDEO_RESUME());
            }
            return;
        }
        if (MillennialRenderer.access$900(_fld0).getTimePositionClass() == MillennialRenderer.access$800(_fld0).TIME_POSITION_CLASS_OVERLAY())
        {
            MillennialRenderer.access$1000(_fld0).dispatchEvent(MillennialRenderer.access$800(_fld0).EVENT_REQUEST_CONTENT_VIDEO_RESUME());
            MillennialRenderer.access$600(_fld0);
            return;
        } else
        {
            stop();
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class tv/freewheel/renderers/millennial/MillennialRenderer$1

/* anonymous class */
    class MillennialRenderer._cls1
        implements Runnable
    {

        final MillennialRenderer this$0;

        public void run()
        {
            MillennialRenderer.access$000(MillennialRenderer.this).debug("adReturned()");
            if (MillennialRenderer.access$100(MillennialRenderer.this))
            {
                MillennialRenderer.access$102(MillennialRenderer.this, false);
                MillennialRenderer.access$200(MillennialRenderer.this);
                if (MillennialRenderer.access$300(MillennialRenderer.this) != null && MillennialRenderer.access$400(MillennialRenderer.this))
                {
                    MillennialRenderer.access$500(MillennialRenderer.this);
                }
                MillennialRenderer.access$600(MillennialRenderer.this);
                MillennialRenderer.access$702(MillennialRenderer.this, new MillennialRenderer._cls1._cls1());
                MillennialRenderer.access$1000(MillennialRenderer.this).addOnActivityCallbackListener(MillennialRenderer.access$700(MillennialRenderer.this));
                MillennialRenderer.access$1000(MillennialRenderer.this).dispatchEvent(MillennialRenderer.access$800(MillennialRenderer.this).EVENT_AD_STARTED());
                return;
            } else
            {
                MillennialRenderer.access$000(MillennialRenderer.this).warn("MMAdReturned has already been received, returning.");
                return;
            }
        }

            
            {
                this$0 = MillennialRenderer.this;
                super();
            }
    }

}
