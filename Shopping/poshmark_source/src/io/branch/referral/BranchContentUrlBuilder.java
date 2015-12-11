// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;

// Referenced classes of package io.branch.referral:
//            BranchUrlBuilder

public class BranchContentUrlBuilder extends BranchUrlBuilder
{

    public BranchContentUrlBuilder(Context context, String s)
    {
        super(context);
        channel_ = s;
        type_ = 0;
        feature_ = "share";
    }

    public void generateContentUrl(Branch.BranchLinkCreateListener branchlinkcreatelistener)
    {
        super.generateUrl(branchlinkcreatelistener);
    }

    public String getContentUrl()
    {
        return getUrl();
    }
}
