// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.fb_tmblr_twitter.FBConnectCallback;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

class val.apiResponse
    implements FBConnectCallback
{

    final ShareManager_Old this$0;
    final PMApiResponse val$apiResponse;
    final String val$message;

    public void error(PMApiError pmapierror)
    {
        ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(val$apiResponse.apiError, com.poshmark.ui.model.ctionContext.SHARE_LISTING_FACEBOOK));
    }

    public void success(int i, String s, String s1)
    {
        if ((i & 8) == 0) goto _L2; else goto _L1
_L1:
        .SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_MODE[ShareManager_Old.access$900(ShareManager_Old.this).ordinal()];
        JVM INSTR tableswitch 1 6: default 60
    //                   1 61
    //                   2 80
    //                   3 99
    //                   4 99
    //                   5 118
    //                   6 137;
           goto _L2 _L3 _L4 _L5 _L5 _L6 _L7
_L2:
        return;
_L3:
        shareListing(ShareManager_Old.access$1000(ShareManager_Old.this), val$message);
        return;
_L4:
        shareShowroom(ShareManager_Old.access$1000(ShareManager_Old.this), val$message);
        return;
_L5:
        shareBrand(ShareManager_Old.access$1000(ShareManager_Old.this), val$message);
        return;
_L6:
        shareCloset(ShareManager_Old.access$1000(ShareManager_Old.this), val$message);
        return;
_L7:
        shareParty(ShareManager_Old.access$1000(ShareManager_Old.this), val$message);
        return;
    }

    RE_MODE()
    {
        this$0 = final_sharemanager_old;
        val$message = s;
        val$apiResponse = PMApiResponse.this;
        super();
    }
}
