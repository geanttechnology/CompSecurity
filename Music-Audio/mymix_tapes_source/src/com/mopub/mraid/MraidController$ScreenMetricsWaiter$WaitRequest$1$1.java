// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.mopub.mraid:
//            MraidController

class val.view
    implements android.view.._cls1
{

    final is._cls0 this$1;
    final View val$view;

    public boolean onPreDraw()
    {
        val$view.getViewTreeObserver().removeOnPreDrawListener(this);
        ss._mth400(_fld0);
        return true;
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$view = View.this;
        super();
    }

    // Unreferenced inner class com/mopub/mraid/MraidController$ScreenMetricsWaiter$WaitRequest$1

/* anonymous class */
    class MraidController.ScreenMetricsWaiter.WaitRequest._cls1
        implements Runnable
    {

        final MraidController.ScreenMetricsWaiter.WaitRequest this$0;

        public void run()
        {
            View aview[] = MraidController.ScreenMetricsWaiter.WaitRequest.access$300(MraidController.ScreenMetricsWaiter.WaitRequest.this);
            int j = aview.length;
            int i = 0;
            while (i < j) 
            {
                View view1 = aview[i];
                if (view1.getHeight() > 0 || view1.getWidth() > 0)
                {
                    MraidController.ScreenMetricsWaiter.WaitRequest.access$400(MraidController.ScreenMetricsWaiter.WaitRequest.this);
                } else
                {
                    view1.getViewTreeObserver().addOnPreDrawListener(view1. new MraidController.ScreenMetricsWaiter.WaitRequest._cls1._cls1());
                }
                i++;
            }
        }

            
            {
                this$0 = MraidController.ScreenMetricsWaiter.WaitRequest.this;
                super();
            }
    }

}
