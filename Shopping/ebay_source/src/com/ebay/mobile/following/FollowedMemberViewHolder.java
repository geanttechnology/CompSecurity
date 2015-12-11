// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.widget.UserThumbnail;

// Referenced classes of package com.ebay.mobile.following:
//            FollowedMemberViewModel

public class FollowedMemberViewHolder extends ViewHolder
{

    private final View removeFollowButton;
    private final UserThumbnail thumbnail;
    private final TextView username;
    private final View view;

    public FollowedMemberViewHolder(View view1)
    {
        super(view1);
        view = view1;
        thumbnail = (UserThumbnail)view1.findViewById(0x7f1000d5);
        username = (TextView)view1.findViewById(0x1020014);
        removeFollowButton = view1.findViewById(0x7f10018b);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof FollowedMemberViewModel))
        {
            throw new IllegalArgumentException("Model is not instance of FollowedMemberViewModel");
        }
        viewmodel = (FollowedMemberViewModel)viewmodel;
        thumbnail.setUserId(((FollowedMemberViewModel) (viewmodel)).username);
        username.setText(((FollowedMemberViewModel) (viewmodel)).username);
        if (((FollowedMemberViewModel) (viewmodel)).listener != null)
        {
            view.setOnClickListener(this);
            if (removeFollowButton != null)
            {
                removeFollowButton.setOnClickListener(this);
            }
        }
    }
}
