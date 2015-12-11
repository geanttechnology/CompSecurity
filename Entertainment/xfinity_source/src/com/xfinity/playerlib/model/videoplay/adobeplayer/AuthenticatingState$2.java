// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.disney.datg.videoplatforms.sdk.common.VPAuthToken;
import com.xfinity.playerlib.authorization.VideoAuthManager;
import com.xfinity.playerlib.authorization.VideoAuthToken;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            AuthenticatingState, VideoStateController, ErrorState

class ateController extends VPAuthToken
{

    final AuthenticatingState this$0;

    ()
    {
        this$0 = AuthenticatingState.this;
        super();
        if (stateController.getVideoAuthManager().getVideoAuthToken() != null)
        {
            authenticatingstate = stateController.getVideoAuthManager().getVideoAuthToken().getRawData();
            HashMap hashmap = new HashMap();
            hashmap.put("token_type", "offsite.comcast");
            hashmap.put("token", AuthenticatingState.this);
            setTokenParameters(hashmap);
            return;
        } else
        {
            transitionToState(new ErrorState(stateController, "Disney Media Authorization failed: VideoAuthToken is null"));
            return;
        }
    }
}
