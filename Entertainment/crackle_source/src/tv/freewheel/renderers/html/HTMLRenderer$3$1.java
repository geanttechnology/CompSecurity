// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.RendererTimer;

// Referenced classes of package tv.freewheel.renderers.html:
//            HTMLRenderer, IMRAIDPresentation

class this._cls1
    implements IActivityCallbackListener
{

    final dClose this$1;

    public void onActivityCallback(int i)
    {
        HTMLRenderer.access$300(_fld0).debug((new StringBuilder()).append("onActivityStateChange ").append(i).toString());
        if (i == HTMLRenderer.access$400(_fld0).ACTIVITY_CALLBACK_PAUSE())
        {
            HTMLRenderer.access$300(_fld0).info("context activity paused");
            if (HTMLRenderer.access$500(_fld0) != null)
            {
                HTMLRenderer.access$500(_fld0).pause();
            }
        } else
        if (i == HTMLRenderer.access$400(_fld0).ACTIVITY_CALLBACK_RESUME())
        {
            HTMLRenderer.access$300(_fld0).info("context activity resumed");
            if ((HTMLRenderer.access$600(_fld0, DState.DEFAULT) || HTMLRenderer.access$600(_fld0, DState.RESIZED)) && HTMLRenderer.access$500(_fld0) != null)
            {
                HTMLRenderer.access$500(_fld0).resume();
            }
            if (HTMLRenderer.access$700(_fld0) && HTMLRenderer.access$800(_fld0))
            {
                HTMLRenderer.access$300(_fld0).debug("Sent EVENT_REQUEST_CONTENT_VIDEO_RESUME");
                HTMLRenderer.access$900(_fld0).dispatchEvent(HTMLRenderer.access$400(_fld0).EVENT_REQUEST_CONTENT_VIDEO_RESUME());
                HTMLRenderer.access$802(_fld0, false);
            }
            if (HTMLRenderer.access$1000(_fld0) != null && HTMLRenderer.access$1100(_fld0).getTimePositionClass() == HTMLRenderer.access$400(_fld0).TIME_POSITION_CLASS_OVERLAY() && HTMLRenderer.access$600(_fld0, DState.DEFAULT))
            {
                HTMLRenderer.access$1000(_fld0).refresh();
            }
            if (HTMLRenderer.access$1200(_fld0))
            {
                switch (HTMLRenderer.access$1300(_fld0))
                {
                default:
                    HTMLRenderer.access$300(_fld0).warn((new StringBuilder()).append("Impossible state of external web browser:").append(HTMLRenderer.access$1300(_fld0)).toString());
                    return;

                case 0: // '\0'
                    HTMLRenderer.access$300(_fld0).debug("No opened external web browser");
                    return;

                case 1: // '\001'
                    HTMLRenderer.access$300(_fld0).debug("External web browser resumed without followed MRAID.close, the renderer will be going on.");
                    HTMLRenderer.access$1302(_fld0, 0);
                    return;

                case 2: // '\002'
                    HTMLRenderer.access$300(_fld0).debug("External web browser resumed after MRAID.close, so it will continue MRAID.close.");
                    break;
                }
                HTMLRenderer.access$1302(_fld0, 0);
                mraidClose();
                return;
            }
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class tv/freewheel/renderers/html/HTMLRenderer$3

/* anonymous class */
    class HTMLRenderer._cls3
        implements Runnable
    {

        final HTMLRenderer this$0;

        public void run()
        {
            HTMLRenderer.access$202(HTMLRenderer.this, new HTMLRenderer._cls3._cls1());
            HTMLRenderer.access$900(HTMLRenderer.this).addOnActivityCallbackListener(HTMLRenderer.access$200(HTMLRenderer.this));
            HTMLRenderer.access$1000(HTMLRenderer.this).show();
            HTMLRenderer.access$1402(HTMLRenderer.this, true);
            HTMLRenderer.access$900(HTMLRenderer.this).dispatchEvent(HTMLRenderer.access$400(HTMLRenderer.this).EVENT_AD_STARTED());
        }

            
            {
                this$0 = HTMLRenderer.this;
                super();
            }
    }

}
