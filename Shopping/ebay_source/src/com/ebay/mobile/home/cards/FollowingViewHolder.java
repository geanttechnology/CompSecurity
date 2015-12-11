// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.notifications.PollServiceListCache;
import com.ebay.mobile.widget.UserThumbnail;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import java.util.List;
import java.util.TreeMap;

// Referenced classes of package com.ebay.mobile.home.cards:
//            FollowingViewModel

public class FollowingViewHolder extends ViewHolder
{
    public static class FollowedInterestHolder extends ViewHolder
    {

        public final View blueDot;
        public final TextView description;
        public final TextView title;

        public FollowedInterestHolder(View view)
        {
            super(view);
            title = (TextView)view.findViewById(0x7f1000de);
            description = (TextView)view.findViewById(0x7f1000df);
            blueDot = view.findViewById(0x7f1000dd);
        }
    }

    public static class FollowedUserHolder extends ViewHolder
    {

        public final TextView description;
        public final UserThumbnail image;
        public final TextView title;

        public FollowedUserHolder(View view)
        {
            super(view);
            title = (TextView)view.findViewById(0x7f10027e);
            description = (TextView)view.findViewById(0x7f1000d6);
            image = (UserThumbnail)view.findViewById(0x7f10027d);
        }
    }


    public static final int idListInterests[] = {
        0x7f100262, 0x7f100263, 0x7f100264, 0x7f100265, 0x7f100266, 0x7f100267, 0x7f10026b, 0x7f10026e, 0x7f100274, 0x7f100270, 
        0x7f100271, 0x7f100275
    };
    public static final int idListProfiles[] = {
        0x7f100268, 0x7f100269, 0x7f10026c, 0x7f10026f, 0x7f100272, 0x7f100276
    };
    private int NO_OF_COLUMNS_TABLET_LANDSCAPE;
    private int NO_OF_COLUMNS_TABLET_PORTRAIT;
    public final View column0;
    public final View column1;
    public final View column2;
    private boolean isPortrait;
    private boolean isTablet;
    public final LinearLayout listLayout;
    public final Button seeAll;

    public FollowingViewHolder(View view)
    {
        super(view);
        NO_OF_COLUMNS_TABLET_PORTRAIT = 2;
        NO_OF_COLUMNS_TABLET_LANDSCAPE = 3;
        listLayout = (LinearLayout)view.findViewById(0x7f100261);
        seeAll = (Button)view.findViewById(0x7f100229);
        isTablet = view.getContext().getResources().getBoolean(0x7f0b0006);
        isPortrait = DeviceInfoUtil.isPortrait(itemView.getContext());
        column0 = view.findViewById(0x7f10026a);
        column1 = view.findViewById(0x7f10026d);
        column2 = view.findViewById(0x7f100273);
        int ai[] = idListInterests;
        int k = ai.length;
        for (int i = 0; i < k; i++)
        {
            View view1 = view.findViewById(ai[i]);
            if (view1 != null)
            {
                view1.setOnClickListener(this);
            }
        }

        ai = idListProfiles;
        k = ai.length;
        for (int j = 0; j < k; j++)
        {
            View view2 = view.findViewById(ai[j]);
            if (view2 != null)
            {
                view2.setOnClickListener(this);
            }
        }

        if (column0 != null)
        {
            column0.setOnClickListener(this);
        }
        if (column1 != null)
        {
            column1.setOnClickListener(this);
        }
        if (column2 != null)
        {
            column2.setOnClickListener(this);
        }
        if (seeAll != null)
        {
            seeAll.setOnClickListener(this);
        }
    }

    private void bindUser(View view, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser followeduser)
    {
        if (view == null)
        {
            return;
        }
        FollowedUserHolder followeduserholder = new FollowedUserHolder(view);
        if (followeduser == null)
        {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (followeduser.entity != null && followeduser.entity.socialProfile != null && followeduser.entity.socialProfile.avatarImage != null)
        {
            followeduserholder.image.setRemoteImageUrl(followeduser.entity.socialProfile.avatarImage.imageURL);
        }
        if (followeduser.entity != null && followeduser.entity.userIdentifier != null && followeduser.entity.userIdentifier.username != null)
        {
            followeduserholder.title.setText(followeduser.entity.userIdentifier.username);
        } else
        if (followeduser.entity != null && followeduser.entity.userIdentifier != null && followeduser.entity.userIdentifier.userId != null)
        {
            followeduserholder.title.setText(followeduser.entity.userIdentifier.userId);
        }
        view = itemView.getResources();
        if (followeduser.ownedEntities != null && followeduser.ownedEntities.listings != null && followeduser.ownedEntities.listings.activeCount != null)
        {
            followeduserholder.description.setText(String.format(view.getQuantityString(0x7f08000e, followeduser.ownedEntities.listings.activeCount.intValue()), new Object[] {
                followeduser.ownedEntities.listings.activeCount
            }));
            followeduserholder.description.setVisibility(0);
        } else
        {
            followeduserholder.description.setVisibility(8);
        }
        followeduserholder.itemView.setVisibility(0);
    }

    public void bind(ViewModel viewmodel)
    {
        FollowingViewModel followingviewmodel;
        super.bind(viewmodel);
        if (!(viewmodel instanceof FollowingViewModel))
        {
            throw new IllegalArgumentException("Model is not instance of FollowingViewHolder");
        }
        followingviewmodel = (FollowingViewModel)viewmodel;
        if (followingviewmodel.viewType != 3) goto _L2; else goto _L1
_L1:
        return;
_L2:
        List list;
        int i;
        List list1 = followingviewmodel.followedUsers;
        list = followingviewmodel.followedInterests;
        if (list1 != null)
        {
            i = list1.size();
            View view = itemView.findViewById(0x7f100268);
            if (i > 0)
            {
                viewmodel = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser)list1.get(0);
            } else
            {
                viewmodel = null;
            }
            bindUser(view, viewmodel);
            view = itemView.findViewById(0x7f100269);
            if (i > 1)
            {
                viewmodel = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser)list1.get(1);
            } else
            {
                viewmodel = null;
            }
            bindUser(view, viewmodel);
            view = itemView.findViewById(0x7f10026c);
            if (i > 2)
            {
                viewmodel = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser)list1.get(2);
            } else
            {
                viewmodel = null;
            }
            bindUser(view, viewmodel);
            view = itemView.findViewById(0x7f10026f);
            if (i > 3)
            {
                viewmodel = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser)list1.get(3);
            } else
            {
                viewmodel = null;
            }
            bindUser(view, viewmodel);
            view = itemView.findViewById(0x7f100272);
            if (i > 4)
            {
                viewmodel = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser)list1.get(4);
            } else
            {
                viewmodel = null;
            }
            bindUser(view, viewmodel);
            view = itemView.findViewById(0x7f100276);
            if (i > 5)
            {
                viewmodel = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser)list1.get(5);
            } else
            {
                viewmodel = null;
            }
            bindUser(view, viewmodel);
        }
        if (list == null) goto _L1; else goto _L3
_L3:
        i = 0;
_L5:
        if (i >= idListInterests.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        viewmodel = itemView.findViewById(idListInterests[i]);
        if (viewmodel != null)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        if (!isTablet) goto _L1; else goto _L4
_L4:
        int l;
        if (isPortrait)
        {
            if (list.size() >= 1 && column0 != null)
            {
                column0.setVisibility(0);
            }
            if (list.size() >= 2 && column1 != null)
            {
                column1.setVisibility(0);
                return;
            }
        } else
        {
            if (list.size() >= 1 && column0 != null)
            {
                column0.setVisibility(0);
            }
            if (list.size() >= 2 && column1 != null)
            {
                column1.setVisibility(0);
            }
            if (list.size() >= 3 && column2 != null)
            {
                column2.setVisibility(0);
                return;
            }
        }
          goto _L1
        viewmodel = new FollowedInterestHolder(viewmodel);
        l = list.size();
        if (i < l)
        {
            Object obj = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest)list.get(i);
            ((FollowedInterestHolder) (viewmodel)).itemView.setVisibility(0);
            if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity != null)
            {
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).followInfo != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).followInfo.customTitle != null)
                {
                    ((FollowedInterestHolder) (viewmodel)).title.setText(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).followInfo.customTitle);
                } else
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.searchRequest != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.searchRequest.keyword != null)
                {
                    ((FollowedInterestHolder) (viewmodel)).title.setText(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.searchRequest.keyword);
                } else
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.title != null)
                {
                    ((FollowedInterestHolder) (viewmodel)).title.setText(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.title);
                }
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.searchRequest != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.searchRequest.categoryId != null)
                {
                    ((FollowedInterestHolder) (viewmodel)).description.setText(itemView.getResources().getString(0x7f0701df));
                    ((FollowedInterestHolder) (viewmodel)).description.setVisibility(0);
                } else
                {
                    ((FollowedInterestHolder) (viewmodel)).description.setVisibility(8);
                }
                if (followingviewmodel.pollMap != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.interestId != null)
                {
                    obj = (com.ebay.mobile.notifications.PollService.SavedSearchPollData)followingviewmodel.pollMap.get(Long.valueOf(Long.parseLong(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (obj)).entity.interestId)));
                    int j;
                    if (obj != null && PollServiceListCache.hasNew(((com.ebay.mobile.notifications.PollService.SavedSearchPollData) (obj))))
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    viewmodel = ((FollowedInterestHolder) (viewmodel)).blueDot;
                    if (j != 0)
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    viewmodel.setVisibility(j);
                }
            }
        } else
        if (isTablet)
        {
            int k;
            if (isPortrait)
            {
                k = NO_OF_COLUMNS_TABLET_PORTRAIT;
            } else
            {
                k = NO_OF_COLUMNS_TABLET_LANDSCAPE;
            }
            if (i / k == (l - 1) / k)
            {
                ((FollowedInterestHolder) (viewmodel)).itemView.setVisibility(4);
            } else
            {
                ((FollowedInterestHolder) (viewmodel)).itemView.setVisibility(8);
            }
        } else
        {
            ((FollowedInterestHolder) (viewmodel)).itemView.setVisibility(8);
        }
        i++;
          goto _L5
    }

}
