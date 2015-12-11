// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.mopub.mraid:
//            MraidController

class this._cls0
    implements Runnable
{

    final this._cls0 this$0;

    public void run()
    {
        View aview[] = cess._mth300(this._cls0.this);
        int j = aview.length;
        int i = 0;
        while (i < j) 
        {
            final View view = aview[i];
            if (view.getHeight() > 0 || view.getWidth() > 0)
            {
                cess._mth400(this._cls0.this);
            } else
            {
                view.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

                    final MraidController.ScreenMetricsWaiter.WaitRequest._cls1 this$1;
                    final View val$view;

                    public boolean onPreDraw()
                    {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        MraidController.ScreenMetricsWaiter.WaitRequest.access$400(this$0);
                        return true;
                    }

            
            {
                this$1 = MraidController.ScreenMetricsWaiter.WaitRequest._cls1.this;
                view = view1;
                super();
            }
                });
            }
            i++;
        }
    }

    _cls1.val.view()
    {
        this$0 = this._cls0.this;
        super();
    }
}
