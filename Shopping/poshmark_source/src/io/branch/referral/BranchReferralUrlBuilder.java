// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;

// Referenced classes of package io.branch.referral:
//            BranchUrlBuilder

public class BranchReferralUrlBuilder extends BranchUrlBuilder
{

    public BranchReferralUrlBuilder(Context context, String s)
    {
        super(context);
        channel_ = s;
        type_ = 0;
        feature_ = "referral";
    }

    public void generateReferralUrl(Branch.BranchLinkCreateListener branchlinkcreatelistener)
    {
        super.generateUrl(branchlinkcreatelistener);
    }

    public String getReferralUrl()
    {
        return super.getUrl();
    }
}
