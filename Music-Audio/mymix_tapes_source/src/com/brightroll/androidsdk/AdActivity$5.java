// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.widget.FrameLayout;
import android.widget.VideoView;

// Referenced classes of package com.brightroll.androidsdk:
//            AdActivity

class val.yRatio
    implements Runnable
{

    final AdActivity this$0;
    private final float val$hRatio;
    private final float val$wRatio;
    private final float val$xRatio;
    private final float val$yRatio;

    public void run()
    {
        int i = frameLayout.getWidth();
        int j = frameLayout.getHeight();
        if (videoView != null)
        {
            android.widget.ayoutParams ayoutparams = (android.widget.ayoutParams)videoView.getLayoutParams();
            ayoutparams.gravity = 48;
            ayoutparams.width = (int)((float)i * val$wRatio);
            ayoutparams.height = (int)((float)j * val$hRatio);
            ayoutparams.leftMargin = (int)((float)i * val$xRatio);
            ayoutparams.topMargin = (int)((float)j * val$yRatio);
            videoView.setLayoutParams(ayoutparams);
            videoView.forceLayout();
        }
    }

    ()
    {
        this$0 = final_adactivity;
        val$wRatio = f;
        val$hRatio = f1;
        val$xRatio = f2;
        val$yRatio = F.this;
        super();
    }
}
