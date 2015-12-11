// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v4.app.ActivityCompat;
import android.view.View;
import com.groupon.activity.transition.DealDetailsRecyclerTransitionController;
import com.groupon.callbacks.OnBottomBarAnimationFinishedListener;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init>
    implements OnBottomBarAnimationFinishedListener
{

    final DealDetails this$0;

    public void onBottomBarAnimationFinished(View view)
    {
        view.setVisibility(4);
        HashMap hashmap = new HashMap(1);
        hashmap.put(Integer.valueOf(0x7f1000a0), view);
        DealDetails.access$3600(DealDetails.this).addAllAnimatedViews(hashmap);
        DealDetails.access$3600(DealDetails.this).handleReturnTransition();
        ActivityCompat.finishAfterTransition(DealDetails.this);
    }

    private Controller()
    {
        this$0 = DealDetails.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
