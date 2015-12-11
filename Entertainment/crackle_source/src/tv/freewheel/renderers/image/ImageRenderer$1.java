// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.app.Activity;
import android.os.Handler;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;

// Referenced classes of package tv.freewheel.renderers.image:
//            ImageRenderer

class ntext
    implements Runnable
{

    final ImageRenderer this$0;
    final IRendererContext val$rendererContextFinalRef;

    public void run()
    {
        ImageRenderer.access$702(ImageRenderer.this, val$rendererContextFinalRef);
        ImageRenderer.access$502(ImageRenderer.this, ImageRenderer.access$700(ImageRenderer.this).getConstants());
        ImageRenderer.access$802(ImageRenderer.this, ImageRenderer.access$700(ImageRenderer.this).getAdInstance().getSlot());
        ImageRenderer.access$902(ImageRenderer.this, ImageRenderer.access$700(ImageRenderer.this).getActivity());
        ImageRenderer.access$1002(ImageRenderer.this, new Handler(ImageRenderer.access$900(ImageRenderer.this).getMainLooper()));
        ImageRenderer.access$700(ImageRenderer.this).dispatchEvent(ImageRenderer.access$500(ImageRenderer.this).EVENT_AD_LOADED());
    }

    ntext()
    {
        this$0 = final_imagerenderer;
        val$rendererContextFinalRef = IRendererContext.this;
        super();
    }
}
