// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;

import android.view.ViewGroup;

// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoRenderer, VideoAdView

class val.slotBase
    implements Runnable
{

    final VideoRenderer this$0;
    final ViewGroup val$slotBase;

    public void run()
    {
        val$slotBase.addView(VideoRenderer.access$000(VideoRenderer.this));
        VideoRenderer.access$000(VideoRenderer.this).bringToFront();
        VideoRenderer.access$000(VideoRenderer.this).requestFocus();
        VideoRenderer.access$000(VideoRenderer.this).start();
    }

    ()
    {
        this$0 = final_videorenderer;
        val$slotBase = ViewGroup.this;
        super();
    }
}
