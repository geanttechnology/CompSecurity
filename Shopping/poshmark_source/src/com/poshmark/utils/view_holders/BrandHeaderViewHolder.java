// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.view_holders;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.poshmark.ui.customviews.BrandFollowButtonLayout;
import com.poshmark.ui.customviews.CollectionSortWidget;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMTextView;

public class BrandHeaderViewHolder
{

    public ImageView backgroundImage;
    public TextView brandTitleView;
    public ImageView cancelTriggerButton;
    public LinearLayout filterWidgetLayout;
    public LinearLayout followFollowingButtonContainer;
    public BrandFollowButtonLayout followFollowingButtonLayout;
    public PMButton inviteFriendsButton;
    public Button justInButton;
    public PMTextView shareBrandBannerMessageView;
    public RelativeLayout shareTriggerLayout;
    public CollectionSortWidget sortWidget;
    public Button unknownBrandButton;

    public BrandHeaderViewHolder()
    {
    }
}
