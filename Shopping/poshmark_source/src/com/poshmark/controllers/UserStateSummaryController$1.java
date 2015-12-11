// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.os.Bundle;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.BadgeCount;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.utils.DateUtils;
import com.poshmark.utils.FeatureManager;

// Referenced classes of package com.poshmark.controllers:
//            UserStateSummaryController, GlobalPartiesController, ShowroomsController

class this._cls0
    implements PMApiResponseHandler
{

    final UserStateSummaryController this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            if (!pmapiresponse.hasError())
            {
                UserStateSummaryController.access$002(UserStateSummaryController.this, (UserStateSummary)pmapiresponse.data);
                Analytics.getInstance().setUserSegment(UserStateSummaryController.access$000(UserStateSummaryController.this).user_info.AbSegment());
                PMApplicationSession.GetPMSession().setUserABSegment(UserStateSummaryController.access$000(UserStateSummaryController.this).user_info.AbSegment());
                if (UserStateSummaryController.access$000(UserStateSummaryController.this).event_invites.updated_at != null)
                {
                    pmapiresponse = DateUtils.getDateFromString(UserStateSummaryController.access$000(UserStateSummaryController.this).event_invites.updated_at);
                    if (GlobalPartiesController.getGlobalPartiesController().lastUpdatedBefore(pmapiresponse))
                    {
                        PMNotificationManager.fireNotification("com.poshmark.intents.NEW_EVENTS_ON_SERVER");
                    }
                }
                if (UserStateSummaryController.access$000(UserStateSummaryController.this).collections.posts.d_at != null)
                {
                    pmapiresponse = DateUtils.getDateFromString(UserStateSummaryController.access$000(UserStateSummaryController.this).collections.posts.d_at);
                    if (ShowroomsController.getGlobalShowroomsController().lastUpdatedBefore(pmapiresponse))
                    {
                        PMNotificationManager.fireNotification("com.poshmark.intents.NEW_SHOWROOMS_ON_SERVER");
                    }
                }
                if (UserStateSummaryController.access$000(UserStateSummaryController.this).feature_settings != null && UserStateSummaryController.access$000(UserStateSummaryController.this).feature_settings.updated_at != null)
                {
                    pmapiresponse = DateUtils.getDateFromString(UserStateSummaryController.access$000(UserStateSummaryController.this).feature_settings.updated_at);
                    if (FeatureManager.getGlobalFeatureManager().lastUpdatedBefore(pmapiresponse))
                    {
                        PMNotificationManager.fireNotification("com.poshmark.intents.NEW_FEATURES_ON_SERVER");
                    }
                }
                if (UserStateSummaryController.access$000(UserStateSummaryController.this).brands != null)
                {
                    pmapiresponse = new Bundle();
                    if (UserStateSummaryController.access$000(UserStateSummaryController.this).brands. != null)
                    {
                        pmapiresponse.putString("ALL_BRANDS_UPDATE_DTM", UserStateSummaryController.access$000(UserStateSummaryController.this).brands..dated_at);
                    }
                    if (UserStateSummaryController.access$000(UserStateSummaryController.this).brands.wing != null)
                    {
                        pmapiresponse.putString("FOLLOWING_BRANDS_UPDATE_DTM", UserStateSummaryController.access$000(UserStateSummaryController.this).brands.wing.dated_at);
                    }
                    PMNotificationManager.fireNotification("com.poshmark.intents.NEW_BRANDS_ON_SERVER", pmapiresponse);
                }
                if (UserStateSummaryController.access$000(UserStateSummaryController.this).catalog != null)
                {
                    pmapiresponse = new Bundle();
                    pmapiresponse.putString("CATALOG_UPDATE_DTM", UserStateSummaryController.access$000(UserStateSummaryController.this).catalog.ted_at);
                    PMNotificationManager.fireNotification("com.poshmark.intents.NEW_CATALOG_ON_SERVER", pmapiresponse);
                }
                BadgeCount.setCountValue(UserStateSummaryController.access$000(UserStateSummaryController.this).notifications.total);
                if (UserStateSummaryController.access$000(UserStateSummaryController.this).notifications.total <= 0)
                {
                    break label0;
                }
                PMNotificationManager.fireNotification("com.poshmark.intents.NEW_BADGE_COUNT");
            }
            return;
        }
        BadgeCount.resetCount();
    }

    cationsObject()
    {
        this$0 = UserStateSummaryController.this;
        super();
    }
}
