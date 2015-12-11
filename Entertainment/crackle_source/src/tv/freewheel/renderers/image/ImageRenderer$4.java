// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.view.ViewGroup;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.RendererTimer;

// Referenced classes of package tv.freewheel.renderers.image:
//            ImageRenderer, BaseLayout

class this._cls0
    implements Runnable
{

    final ImageRenderer this$0;

    public void run()
    {
        if (ImageRenderer.access$1300(ImageRenderer.this) != null)
        {
            ImageRenderer.access$1300(ImageRenderer.this).stop();
            ImageRenderer.access$1302(ImageRenderer.this, null);
        }
        if (ImageRenderer.access$2100(ImageRenderer.this) != null)
        {
            ImageRenderer.access$2100(ImageRenderer.this).removeAdView(ImageRenderer.access$1700(ImageRenderer.this));
            if (ImageRenderer.access$2100(ImageRenderer.this).getParent() != null)
            {
                ((ViewGroup)ImageRenderer.access$2100(ImageRenderer.this).getParent()).removeView(ImageRenderer.access$2100(ImageRenderer.this));
            }
            ImageRenderer.access$2102(ImageRenderer.this, null);
        } else
        {
            ImageRenderer.access$800(ImageRenderer.this).getBase().removeView(ImageRenderer.access$1700(ImageRenderer.this));
        }
        ImageRenderer.access$1702(ImageRenderer.this, null);
        ImageRenderer.access$102(ImageRenderer.this, null);
        if (ImageRenderer.access$1800(ImageRenderer.this) && ImageRenderer.access$1500(ImageRenderer.this))
        {
            ImageRenderer.access$000(ImageRenderer.this).debug("Send EVENT_REQUEST_CONTENT_VIDEO_RESUME when the ad completes");
            ImageRenderer.access$700(ImageRenderer.this).dispatchEvent(ImageRenderer.access$500(ImageRenderer.this).EVENT_REQUEST_CONTENT_VIDEO_RESUME());
            ImageRenderer.access$1502(ImageRenderer.this, false);
        }
        ImageRenderer.access$700(ImageRenderer.this).dispatchEvent(ImageRenderer.access$500(ImageRenderer.this).EVENT_AD_STOPPED());
    }

    ntext()
    {
        this$0 = ImageRenderer.this;
        super();
    }
}
