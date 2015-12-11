// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;


// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItPhotoCaptureView, ViewItSlidingDrawerView

class val.back_resid
    implements Runnable
{

    final ViewItPhotoCaptureView this$0;
    final int val$back_resid;

    public void run()
    {
        if (!ViewItPhotoCaptureView.access$300(ViewItPhotoCaptureView.this).isOpened())
        {
            updateTitle(val$back_resid);
        }
    }

    ()
    {
        this$0 = final_viewitphotocaptureview;
        val$back_resid = I.this;
        super();
    }
}
