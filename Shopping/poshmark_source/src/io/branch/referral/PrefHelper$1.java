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
        if (PrefHelper.access$000(PrefHelper.this) == null)
        {
            PrefHelper.access$002(PrefHelper.this, new BranchRemoteInterface(PrefHelper.access$100(PrefHelper.this)));
            PrefHelper.access$000(PrefHelper.this).setNetworkCallbackListener(new bugNetworkCallback());
        }
        PrefHelper.access$000(PrefHelper.this).connectToDebug();
    }

    bugNetworkCallback()
    {
        this$0 = PrefHelper.this;
        super();
    }
}
