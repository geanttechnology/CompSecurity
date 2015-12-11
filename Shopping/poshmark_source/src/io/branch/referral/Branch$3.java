// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            Branch, ServerRequestSendAppList, ServerRequest

class this._cls0
    implements Runnable
{

    final Branch this$0;

    public void run()
    {
        ServerRequestSendAppList serverrequestsendapplist = new ServerRequestSendAppList(Branch.access$700(Branch.this));
        if (!((ServerRequest) (serverrequestsendapplist)).constructError_ && !serverrequestsendapplist.handleErrors(Branch.access$700(Branch.this)))
        {
            Branch.access$800(Branch.this, serverrequestsendapplist);
        }
    }

    uest()
    {
        this$0 = Branch.this;
        super();
    }
}
