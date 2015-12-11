// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;

import android.view.ViewGroup;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoRenderer, VideoAdView

class this._cls0
    implements Runnable
{

    final VideoRenderer this$0;

    public void run()
    {
        VideoRenderer.access$100(VideoRenderer.this).getBase().addView(VideoRenderer.access$000(VideoRenderer.this));
        VideoRenderer.access$000(VideoRenderer.this).bringToFront();
    }

    ()
    {
        this$0 = VideoRenderer.this;
        super();
    }
}
