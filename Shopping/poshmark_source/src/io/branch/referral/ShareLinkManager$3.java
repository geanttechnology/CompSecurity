// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.pm.ResolveInfo;
import android.util.Log;

// Referenced classes of package io.branch.referral:
//            ShareLinkManager, BranchError

class val.channelName
    implements eateListener
{

    final ShareLinkManager this$0;
    final String val$channelName;
    final ResolveInfo val$selectedResolveInfo;

    public void onLinkCreate(String s, BranchError brancherror)
    {
        if (brancherror == null)
        {
            ShareLinkManager.access$700(ShareLinkManager.this, val$selectedResolveInfo, s, val$channelName);
        } else
        {
            String s1 = ShareLinkManager.access$600(ShareLinkManager.this).getDefaultURL();
            if (s1 != null && s1.trim().length() > 0)
            {
                ShareLinkManager.access$700(ShareLinkManager.this, val$selectedResolveInfo, s1, val$channelName);
            } else
            if (callback_ != null)
            {
                callback_.onLinkShareResponse(s, val$channelName, brancherror);
            } else
            {
                Log.i("BranchSDK", (new StringBuilder()).append("Unable to share link ").append(brancherror.getMessage()).toString());
            }
        }
        ShareLinkManager.access$502(ShareLinkManager.this, false);
    }

    areListener()
    {
        this$0 = final_sharelinkmanager;
        val$selectedResolveInfo = resolveinfo;
        val$channelName = String.this;
        super();
    }
}
