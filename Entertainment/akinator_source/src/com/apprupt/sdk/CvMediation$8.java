// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvMediation, CvMediator, CvContentOptions

class val.mediator
    implements Runnable
{

    final CvMediation this$0;
    final CvMediator val$mediator;

    public void run()
    {
        CvMediation.access$600(CvMediation.this)._mth0(new Object[] {
            "load mediator"
        });
        val$mediator.load(CvMediation.access$1000(CvMediation.this), CvMediation.access$1100(CvMediation.this, val$mediator.getContentOptions().adSpaceId));
    }

    ns()
    {
        this$0 = final_cvmediation;
        val$mediator = CvMediator.this;
        super();
    }
}
