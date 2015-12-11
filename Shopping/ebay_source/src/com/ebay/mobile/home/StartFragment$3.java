// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.home.cards.FollowingViewHolder;
import com.ebay.mobile.home.cards.FollowingViewModel;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.nautilus.shell.app.FwActivity;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.kListener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        SourceIdentification sourceidentification;
        Activity activity;
        sourceidentification = new SourceIdentification("HomePage", "followedsearch", "activity");
        activity = getActivity();
        if (view.getId() != 0x7f100229) goto _L2; else goto _L1
_L1:
        view = ActivityStarter.getBrowseFollowsIntent(activity);
        view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        activity.startActivity(view);
_L4:
        return;
_L2:
        int i;
        int j;
        if (!(viewmodel instanceof FollowingViewModel))
        {
            continue; /* Loop/switch isn't completed */
        }
        viewmodel = (FollowingViewModel)viewmodel;
        j = view.getId();
        i = 0;
        do
        {
            if (i >= FollowingViewHolder.idListInterests.length)
            {
                break;
            }
            if (j == FollowingViewHolder.idListInterests[i])
            {
                view = (com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedInterest)((FollowingViewModel) (viewmodel)).followedInterests.get(i);
                if (view != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedInterest) (view)).entity != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedInterest) (view)).entity.interestId != null)
                {
                    viewmodel = ActivityStarter.getSavedSearchIntent(activity, getFwActivity().getEbayContext(), ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedInterest) (view)).entity.interestId, null);
                    if (viewmodel != null)
                    {
                        viewmodel.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                        (new ItemCache(activity)).markSavedSearchViewed(((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedInterest) (view)).entity.interestId);
                        activity.startActivity(viewmodel);
                        return;
                    }
                }
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while (true);
        i = 0;
_L5:
        if (i < FollowingViewHolder.idListProfiles.length)
        {
label0:
            {
                if (j != FollowingViewHolder.idListProfiles[i])
                {
                    break label0;
                }
                view = (com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedUser)((FollowingViewModel) (viewmodel)).followedUsers.get(i);
                if (view != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedUser) (view)).entity != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedUser) (view)).entity.userIdentifier != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedUser) (view)).entity.userIdentifier.username != null)
                {
                    viewmodel = eBayDictionaryProvider.getLockedSearchParameters(activity, null);
                    viewmodel.sellerId = ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.FollowedUser) (view)).entity.userIdentifier.username;
                    view = ActivityStarter.getSearchResultListIntent(activity, viewmodel, null);
                    view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                    startActivity(view);
                    return;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        i++;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    ()
    {
        this$0 = StartFragment.this;
        super();
    }
}
