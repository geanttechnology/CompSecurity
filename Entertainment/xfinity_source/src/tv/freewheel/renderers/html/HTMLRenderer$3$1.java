// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers.html:
//            HTMLRenderer, IMRAIDPresentation

class this._cls1
    implements IActivityCallbackListener
{

    final llbackListener this$1;

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
