// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            PrefHelper, BranchRemoteInterface

class this._cls0
    implements Runnable
{

    final PrefHelper this$0;

    public void run()
    {
        PrefHelper.access$000(PrefHelper.this).disconnectFromDebug();
    }

    nterface()
    {
        this$0 = PrefHelper.this;
        super();
    }
}
