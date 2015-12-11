// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.following:
//            FollowedCollectionViewModel

public class FollowedCollectionViewHolder extends ViewHolder
{

    private final RemoteImageView image1;
    private final RemoteImageView image2;
    private final RemoteImageView image3;
    private final View removeFollowButton;
    private final TextView subtitle;
    private final TextView title;
    private final View view;

    public FollowedCollectionViewHolder(View view1)
    {
        super(view1);
        view = view1;
        image1 = (RemoteImageView)view1.findViewById(0x7f1000f3);
        image2 = (RemoteImageView)view1.findViewById(0x7f1000f4);
        image3 = (RemoteImageView)view1.findViewById(0x7f1000f5);
        title = (TextView)view1.findViewById(0x7f10005f);
        subtitle = (TextView)view1.findViewById(0x7f1000fb);
        removeFollowButton = view1.findViewById(0x7f10018b);
        subtitle.setText(subtitle.getResources().getString(0x7f070240));
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof FollowedCollectionViewModel))
        {
            throw new IllegalArgumentException("Model is not instance of FollowedCollectionViewModel");
        }
        viewmodel = (FollowedCollectionViewModel)viewmodel;
        image1.setRemoteImageUrl(((FollowedCollectionViewModel) (viewmodel)).imageUrl1);
        image2.setRemoteImageUrl(((FollowedCollectionViewModel) (viewmodel)).imageUrl2);
        image3.setRemoteImageUrl(((FollowedCollectionViewModel) (viewmodel)).imageUrl3);
        title.setText(((FollowedCollectionViewModel) (viewmodel)).title);
        if (((FollowedCollectionViewModel) (viewmodel)).listener != null)
        {
            view.setOnClickListener(this);
            if (removeFollowButton != null)
            {
                removeFollowButton.setOnClickListener(this);
            }
        }
    }
}
