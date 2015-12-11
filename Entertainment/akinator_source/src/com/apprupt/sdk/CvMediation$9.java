// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvMediation, CvViewHelper, CvContentOptions, CvMediator

class val.mediator
    implements Runnable
{

    final CvMediation this$0;
    final CvContentOptions val$contentOptions;
    final CvMediator val$mediator;

    public void run()
    {
    /* block-local class not found */
    class _cls1 {}

        CvViewHelper.runOnUIThread(new _cls1(), true);
    }

    ns()
    {
        this$0 = final_cvmediation;
        val$contentOptions = cvcontentoptions;
        val$mediator = CvMediator.this;
        super();
    }
}
