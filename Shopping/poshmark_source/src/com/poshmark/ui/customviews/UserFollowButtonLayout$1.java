// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;
import com.poshmark.http.api.PMApi;

// Referenced classes of package com.poshmark.ui.customviews:
//            UserFollowButtonLayout

class this._cls0
    implements android.view.ButtonLayout._cls1
{

    final UserFollowButtonLayout this$0;

    public void onClick(View view)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (isFollowing) goto _L2; else goto _L1
_L1:
        if (fireAndForgetMode) goto _L4; else goto _L3
_L3:
        view = UserFollowButtonLayout.access$000(UserFollowButtonLayout.this);
        UserFollowButtonLayout.access$100(UserFollowButtonLayout.this, false);
_L5:
        PMApi.followUser(userId, view);
        return;
_L4:
        UserFollowButtonLayout.access$200(UserFollowButtonLayout.this);
        view = obj;
        if (listener != null)
        {
            listener.onFollowClick();
            view = obj;
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (fireAndForgetMode) goto _L7; else goto _L6
_L6:
        view = UserFollowButtonLayout.access$300(UserFollowButtonLayout.this);
        UserFollowButtonLayout.access$100(UserFollowButtonLayout.this, false);
_L9:
        PMApi.unFollowUser(userId, view);
        return;
_L7:
        UserFollowButtonLayout.access$400(UserFollowButtonLayout.this);
        view = obj1;
        if (listener != null)
        {
            listener.onFollowingClick();
            view = obj1;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    erFollowButtonListener()
    {
        this$0 = UserFollowButtonLayout.this;
        super();
    }
}
