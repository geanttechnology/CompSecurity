// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.util.LinkProperties;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            BranchError

class BranchUniversalReferralInitWrapper
    implements Branch.BranchReferralInitListener
{

    private final Branch.BranchUniversalReferralInitListener universalReferralInitListener_;

    public BranchUniversalReferralInitWrapper(Branch.BranchUniversalReferralInitListener branchuniversalreferralinitlistener)
    {
        universalReferralInitListener_ = branchuniversalreferralinitlistener;
    }

    public void onInitFinished(JSONObject jsonobject, BranchError brancherror)
    {
label0:
        {
            if (universalReferralInitListener_ != null)
            {
                if (brancherror == null)
                {
                    break label0;
                }
                universalReferralInitListener_.onInitFinished(null, null, brancherror);
            }
            return;
        }
        jsonobject = BranchUniversalObject.getReferredBranchUniversalObject();
        LinkProperties linkproperties = LinkProperties.getReferredLinkProperties();
        universalReferralInitListener_.onInitFinished(jsonobject, linkproperties, brancherror);
    }
}
