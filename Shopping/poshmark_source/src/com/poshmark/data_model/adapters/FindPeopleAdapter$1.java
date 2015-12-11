// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.view.View;
import android.widget.Button;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.utils.FollowFollowingHelper;

// Referenced classes of package com.poshmark.data_model.adapters:
//            FindPeopleAdapter

class this._cls0
    implements android.view.
{

    final FindPeopleAdapter this$0;

    public void onClick(View view)
    {
        Button button = (Button)view;
        view = (UserReference)view.getTag();
        if (view.isCallerFollowing())
        {
            FollowFollowingHelper.setFollowButton(context, button);
            view.setCallerFollowing(false);
            FollowFollowingHelper.fireUnfollowCall(view.getUserId());
            return;
        } else
        {
            FollowFollowingHelper.setFollowingButton(context, button);
            view.setCallerFollowing(true);
            FollowFollowingHelper.fireFollowCall(view.getUserId());
            return;
        }
    }

    ence()
    {
        this$0 = FindPeopleAdapter.this;
        super();
    }
}
