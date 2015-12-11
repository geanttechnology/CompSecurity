// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRendererContext;

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
