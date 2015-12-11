// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.temporal;

import android.view.ViewGroup;

// Referenced classes of package tv.freewheel.hybrid.renderers.temporal:
//            VideoRenderer, VideoAdView

class val.slotBase
    implements Runnable
{

    final VideoRenderer this$0;
    final ViewGroup val$slotBase;

    public void run()
    {
        VideoRenderer.access$000(VideoRenderer.this).setVisibility(8);
        val$slotBase.removeView(VideoRenderer.access$000(VideoRenderer.this));
        VideoRenderer.access$002(VideoRenderer.this, null);
    }

    ()
    {
        this$0 = final_videorenderer;
        val$slotBase = ViewGroup.this;
        super();
    }
}
