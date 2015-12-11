// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;


// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSlidingDrawerBrowser, ViewItActivity, ViewItPhotoCaptureView, ViewItSlidingDrawerView

class this._cls0
    implements Runnable
{

    final ViewItSlidingDrawerBrowser this$0;

    public void run()
    {
        ViewItSlidingDrawerBrowser.access$000(ViewItSlidingDrawerBrowser.this).getPhotoCaptureView().getViewItSlidingDrawerView().updateBottomToolBar();
    }

    A()
    {
        this$0 = ViewItSlidingDrawerBrowser.this;
        super();
    }
}
