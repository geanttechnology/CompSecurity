// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.Preferences;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

private static class observer extends com.ebay.common.content.dm.rver
{

    private final BaseActivity baseActivity;
    private final nTask.execute data;
    private final com.ebay.common.content.dm.anged observer;

    public void onSearchFollowed(Content content)
    {
        if (data.inalFollow.notifications != null && data.inalFollow.notifications.contains(com.ebay.common.model.followinterest.))
        {
            (new ItemCache(baseActivity)).addSavedSearch(data.inalFollow.getInterestId(), data.inalFollow.getInterestTitle(), data.Data.low, data.Data.low, data.Data.low, data.Data.low);
            content = new NotificationPreferenceManager(baseActivity);
            String s = MyApp.getPrefs().getAuthentication().user;
            if (data.inalFollow.notifications != null && data.inalFollow.notifications.contains(com.ebay.common.model.followinterest.))
            {
                content.addNotifyEnabledSavedSearchId(s, data.inalFollow.getInterestId());
            } else
            {
                content.removeNotifyEnabledSavedSearchId(s, data.inalFollow.getInterestId());
            }
            if (observer != null)
            {
                observer.onSearchFollowed(data.inalFollow);
            }
            (new nTask(baseActivity, content, s)).execute(new Void[0]);
        }
    }

    public esChanged(BaseActivity baseactivity, esChanged eschanged, com.ebay.common.content.dm.anged anged)
    {
        baseActivity = baseactivity;
        data = eschanged;
        observer = anged;
    }
}
