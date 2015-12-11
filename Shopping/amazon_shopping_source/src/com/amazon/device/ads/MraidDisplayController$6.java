// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.widget.FrameLayout;

// Referenced classes of package com.amazon.device.ads:
//            MraidDisplayController, Log

class this._cls0
    implements erListener
{

    final MraidDisplayController this$0;

    public void onComplete()
    {
        Log.d("MraidDisplayController", "videoplayback complete");
        MraidDisplayController.access$202(MraidDisplayController.this, false);
        FrameLayout framelayout = (FrameLayout)MraidDisplayController.access$400(MraidDisplayController.this).findViewById(MraidDisplayController.access$300(MraidDisplayController.this));
        framelayout.setVisibility(4);
        MraidDisplayController.access$400(MraidDisplayController.this).removeView(framelayout);
    }

    public void onError()
    {
        onComplete();
    }

    erListener()
    {
        this$0 = MraidDisplayController.this;
        super();
    }
}
