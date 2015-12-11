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

class this._cls0
    implements Runnable
{

    final HTMLRenderer this$0;

    public void run()
    {
        HTMLRenderer.access$202(HTMLRenderer.this, new IActivityCallbackListener() {

            final HTMLRenderer._cls3 this$1;

            public void onActivityCallback(int i)
            {
                HTMLRenderer.access$300(this$0).debug((new StringBuilder()).append("onActivityStateChange ").append(i).toString());
                if (i == HTMLRenderer.access$400(this$0).ACTIVITY_CALLBACK_PAUSE())
                {
                    HTMLRenderer.access$300(this$0).info("context activity paused");
                    if (HTMLRenderer.access$500(this$0) != null)
                    {
                        HTMLRenderer.access$500(this$0).pause();
                    }
                } else
                if (i == HTMLRenderer.access$400(this$0).ACTIVITY_CALLBACK_RESUME())
                {
                    HTMLRenderer.access$300(this$0).info("context activity resumed");
                    if ((HTMLRenderer.access$600(this$0, HTMLRenderer.MRAIDState.DEFAULT) || HTMLRenderer.access$600(this$0, HTMLRenderer.MRAIDState.RESIZED)) && HTMLRenderer.access$500(this$0) != null)
                    {
                        HTMLRenderer.access$500(this$0).resume();
                    }
                    if (HTMLRenderer.access$700(this$0) && HTMLRenderer.access$800(this$0))
                    {
                        HTMLRenderer.access$300(this$0).debug("Sent EVENT_REQUEST_CONTENT_VIDEO_RESUME");
                        HTMLRenderer.access$900(this$0).dispatchEvent(HTMLRenderer.access$400(this$0).EVENT_REQUEST_CONTENT_VIDEO_RESUME());
                        HTMLRenderer.access$802(this$0, false);
                    }
                    if (HTMLRenderer.access$1000(this$0) != null && HTMLRenderer.access$1100(this$0).getTimePositionClass() == HTMLRenderer.access$400(this$0).TIME_POSITION_CLASS_OVERLAY() && HTMLRenderer.access$600(this$0, HTMLRenderer.MRAIDState.DEFAULT))
                    {
                        HTMLRenderer.access$1000(this$0).refresh();
                    }
                    if (HTMLRenderer.access$1200(this$0))
                    {
                        switch (HTMLRenderer.access$1300(this$0))
                        {
                        default:
                            HTMLRenderer.access$300(this$0).warn((new StringBuilder()).append("Impossible state of external web browser:").append(HTMLRenderer.access$1300(this$0)).toString());
                            return;

                        case 0: // '\0'
                            HTMLRenderer.access$300(this$0).debug("No opened external web browser");
                            return;

                        case 1: // '\001'
                            HTMLRenderer.access$300(this$0).debug("External web browser resumed without followed MRAID.close, the renderer will be going on.");
                            HTMLRenderer.access$1302(this$0, 0);
                            return;

                        case 2: // '\002'
                            HTMLRenderer.access$300(this$0).debug("External web browser resumed after MRAID.close, so it will continue MRAID.close.");
                            break;
                        }
                        HTMLRenderer.access$1302(this$0, 0);
                        mraidClose();
                        return;
                    }
                }
            }

            
            {
                this$1 = HTMLRenderer._cls3.this;
                super();
            }
        });
        HTMLRenderer.access$900(HTMLRenderer.this).addOnActivityCallbackListener(HTMLRenderer.access$200(HTMLRenderer.this));
        HTMLRenderer.access$1000(HTMLRenderer.this).show();
        HTMLRenderer.access$1402(HTMLRenderer.this, true);
        HTMLRenderer.access$900(HTMLRenderer.this).dispatchEvent(HTMLRenderer.access$400(HTMLRenderer.this).EVENT_AD_STARTED());
    }

    _cls1.this._cls1()
    {
        this$0 = HTMLRenderer.this;
        super();
    }
}
