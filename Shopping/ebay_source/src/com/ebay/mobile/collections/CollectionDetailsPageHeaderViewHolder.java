// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.widget.UserThumbnail;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionDetailsPageHeaderViewModel

public class CollectionDetailsPageHeaderViewHolder extends ViewHolder
{

    public TextView description;
    private final Button follow;
    private final TextView followersText;
    public TextView headline;
    private final RemoteImageView image;
    private final Button share;
    private final TextView subTitle;
    private final TextView title;
    private final UserThumbnail userImage;
    private final View userInfo;
    private final TextView userName;

    public CollectionDetailsPageHeaderViewHolder(View view)
    {
        super(view);
        title = (TextView)view.findViewById(0x1020014);
        subTitle = (TextView)view.findViewById(0x1020015);
        image = (RemoteImageView)view.findViewById(0x7f10005b);
        userImage = (UserThumbnail)itemView.findViewById(0x7f1000fa);
        userName = (TextView)itemView.findViewById(0x7f100864);
        followersText = (TextView)itemView.findViewById(0x7f10012c);
        follow = (Button)itemView.findViewById(0x7f10012d);
        share = (Button)itemView.findViewById(0x7f10012e);
        userInfo = itemView.findViewById(0x7f10012f);
        if (userInfo != null)
        {
            userInfo.setOnClickListener(this);
        }
        if (follow != null)
        {
            follow.setOnClickListener(this);
        }
        if (share != null)
        {
            share.setOnClickListener(this);
        }
        description = (TextView)itemView.findViewById(0x7f100123);
        headline = (TextView)itemView.findViewById(0x7f100122);
        setFullSpan(true);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        viewmodel = (CollectionDetailsPageHeaderViewModel)viewmodel;
        if (viewmodel != null)
        {
            title.setText(((CollectionDetailsPageHeaderViewModel) (viewmodel)).title);
            subTitle.setText(((CollectionDetailsPageHeaderViewModel) (viewmodel)).subTitle);
            Object obj;
            if (!TextUtils.isEmpty(((CollectionDetailsPageHeaderViewModel) (viewmodel)).subTitle))
            {
                ((android.view.ViewGroup.MarginLayoutParams)title.getLayoutParams()).bottomMargin = 0;
                subTitle.setVisibility(0);
            } else
            {
                ((android.view.ViewGroup.MarginLayoutParams)title.getLayoutParams()).bottomMargin = ((android.view.ViewGroup.MarginLayoutParams)subTitle.getLayoutParams()).bottomMargin;
                subTitle.setVisibility(8);
            }
            obj = ((CollectionDetailsPageHeaderViewModel) (viewmodel)).imageUrl;
            image.setRemoteImageUrl(((String) (obj)));
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                image.setVisibility(0);
            } else
            {
                image.setVisibility(8);
            }
            if (userName != null)
            {
                userName.setText(((CollectionDetailsPageHeaderViewModel) (viewmodel)).collection.creator.userIdentifier.username);
            }
            if (userImage != null && !TextUtils.isEmpty(((CollectionDetailsPageHeaderViewModel) (viewmodel)).collection.creator.profileImageURL))
            {
                userImage.setRemoteImageUrl(((CollectionDetailsPageHeaderViewModel) (viewmodel)).collection.creator.profileImageURL);
            }
            obj = itemView.getResources();
            if (followersText != null)
            {
                followersText.setText(String.format(((Resources) (obj)).getQuantityString(0x7f080012, ((CollectionDetailsPageHeaderViewModel) (viewmodel)).followerCount, new Object[] {
                    Integer.valueOf(((CollectionDetailsPageHeaderViewModel) (viewmodel)).followerCount)
                }), new Object[0]));
            }
            if (((CollectionDetailsPageHeaderViewModel) (viewmodel)).isCollectionFollowed)
            {
                follow.setText(((Resources) (obj)).getText(0x7f07041b));
            } else
            {
                follow.setText(((Resources) (obj)).getText(0x7f070127));
            }
            if (headline != null)
            {
                if (!TextUtils.isEmpty(((CollectionDetailsPageHeaderViewModel) (viewmodel)).headline))
                {
                    headline.setVisibility(0);
                    headline.setText(((CollectionDetailsPageHeaderViewModel) (viewmodel)).headline);
                } else
                {
                    headline.setVisibility(8);
                }
            }
            if (description != null)
            {
                if (!TextUtils.isEmpty(((CollectionDetailsPageHeaderViewModel) (viewmodel)).description))
                {
                    description.setVisibility(0);
                    description.setText(((CollectionDetailsPageHeaderViewModel) (viewmodel)).description);
                    return;
                } else
                {
                    description.setVisibility(8);
                    return;
                }
            }
        }
    }

    public void setFullSpan(boolean flag)
    {
        super.setFullSpan(flag);
    }
}
