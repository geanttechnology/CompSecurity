// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.net.Uri;
import com.poshmark.http.api.PMApiRequest;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.customviews:
//            UserFollowButtonLayout

class this._cls0
    implements PMApiResponseHandler
{

    final UserFollowButtonLayout this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!pmapiresponse.hasError())
        {
            if (pmapiresponse.apiRequest.url.contains(Uri.encode(userId)))
            {
                UserFollowButtonLayout.access$200(UserFollowButtonLayout.this);
                isFollowing = true;
                UserFollowButtonLayout.access$500(UserFollowButtonLayout.this);
                if (listener != null)
                {
                    listener.onFollowClick();
                }
            }
        } else
        {
            UserFollowButtonLayout.access$200(UserFollowButtonLayout.this);
        }
        UserFollowButtonLayout.access$100(UserFollowButtonLayout.this, true);
    }

    erFollowButtonListener()
    {
        this$0 = UserFollowButtonLayout.this;
        super();
    }
}
