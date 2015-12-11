// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.widget.ImageView;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.RendererTimer;

// Referenced classes of package tv.freewheel.renderers.image:
//            ImageRenderer

class this._cls0
    implements Runnable
{

    final ImageRenderer this$0;

    public void run()
    {
        ImageRenderer.access$1202(ImageRenderer.this, new IActivityCallbackListener() {

            final ImageRenderer._cls2 this$1;

            public void onActivityCallback(int i)
            {
                ImageRenderer.access$000(this$0).debug((new StringBuilder()).append("onActivityStateChange ").append(i).toString());
                if (i == ImageRenderer.access$500(this$0).ACTIVITY_CALLBACK_PAUSE())
                {
                    ImageRenderer.access$000(this$0).info("context activity paused");
                    if (ImageRenderer.access$1300(this$0) != null)
                    {
                        ImageRenderer.access$1300(this$0).pause();
                    }
                    if (ImageRenderer.access$1400(this$0) && !ImageRenderer.access$1500(this$0) && !ImageRenderer.access$1600(this$0))
                    {
                        ImageRenderer.access$000(this$0).debug("Send EVENT_REQUEST_CONTENT_VIDEO_PAUSE when activity is paused");
                        ImageRenderer.access$700(this$0).dispatchEvent(ImageRenderer.access$500(this$0).EVENT_REQUEST_CONTENT_VIDEO_PAUSE());
                        ImageRenderer.access$1602(this$0, true);
                    }
                } else
                if (i == ImageRenderer.access$500(this$0).ACTIVITY_CALLBACK_RESUME())
                {
                    ImageRenderer.access$000(this$0).info("context activity resumed");
                    if (ImageRenderer.access$1300(this$0) != null)
                    {
                        ImageRenderer.access$1300(this$0).resume();
                    }
                    if (ImageRenderer.access$1400(this$0) && ImageRenderer.access$1600(this$0))
                    {
                        ImageRenderer.access$000(this$0).debug("Send EVENT_REQUEST_CONTENT_VIDEO_RESUME when activity is resumed");
                        ImageRenderer.access$700(this$0).dispatchEvent(ImageRenderer.access$500(this$0).EVENT_REQUEST_CONTENT_VIDEO_RESUME());
                        ImageRenderer.access$1602(this$0, false);
                    }
                    if (ImageRenderer.access$1700(this$0) != null && ImageRenderer.access$800(this$0).getTimePositionClass() == ImageRenderer.access$500(this$0).TIME_POSITION_CLASS_OVERLAY())
                    {
                        ImageRenderer.access$1700(this$0).bringToFront();
                        return;
                    }
                }
            }

            
            {
                this$1 = ImageRenderer._cls2.this;
                super();
            }
        });
        if (ImageRenderer.access$1800(ImageRenderer.this) && !ImageRenderer.access$1500(ImageRenderer.this))
        {
            ImageRenderer.access$000(ImageRenderer.this).debug("Send EVENT_REQUEST_CONTENT_VIDEO_PAUSE when the ad starts");
            ImageRenderer.access$700(ImageRenderer.this).dispatchEvent(ImageRenderer.access$500(ImageRenderer.this).EVENT_REQUEST_CONTENT_VIDEO_PAUSE());
            ImageRenderer.access$1502(ImageRenderer.this, true);
        }
        ImageRenderer.access$700(ImageRenderer.this).addOnActivityCallbackListener(ImageRenderer.access$1200(ImageRenderer.this));
        ImageRenderer.access$1900(ImageRenderer.this);
        ImageRenderer.access$700(ImageRenderer.this).dispatchEvent(ImageRenderer.access$500(ImageRenderer.this).EVENT_AD_STARTED());
        if (ImageRenderer.access$1300(ImageRenderer.this) != null)
        {
            ImageRenderer.access$1300(ImageRenderer.this).start();
        }
    }

    _cls1.this._cls1()
    {
        this$0 = ImageRenderer.this;
        super();
    }
}
