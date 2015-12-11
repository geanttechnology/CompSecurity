// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.EnvConfig;
import com.poshmark.data_model.models.BadgeCount;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.utils.DateUtils;
import com.poshmark.utils.FeatureManager;

// Referenced classes of package com.poshmark.controllers:
//            GlobalPartiesController, ShowroomsController

public class UserStateSummaryController
    implements PMNotificationListener
{

    static UserStateSummaryController globalUserStateSummaryController = null;
    final int REFRESH_USER_STATE_SUMMARY = 1;
    public Handler delayedMessageHandler;
    private UserStateSummary userStateSummary;

    private UserStateSummaryController()
    {
        delayedMessageHandler = new Handler() {

            final UserStateSummaryController this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    fireRecurringRefreshMessage();
                    break;
                }
                refreshModels();
            }

            
            {
                this$0 = UserStateSummaryController.this;
                super();
            }
        };
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.APP_STARTED", this);
    }

    private void fireRecurringRefreshMessage()
    {
        Message message = new Message();
        message.obj = null;
        message.what = 1;
        delayedMessageHandler.sendMessageDelayed(message, EnvConfig.USER_STATE_SUMMARY_INTERVAL);
    }

    public static UserStateSummaryController getGlobalInteractionsController()
    {
        if (globalUserStateSummaryController == null)
        {
            globalUserStateSummaryController = new UserStateSummaryController();
        }
        return globalUserStateSummaryController;
    }

    public void disableAllControllerNotifications()
    {
        delayedMessageHandler.removeMessages(1);
    }

    public UserStateSummary getUserStateSummary()
    {
        return userStateSummary;
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.LOGIN_COMPLETE"))
        {
            refreshModels();
            fireRecurringRefreshMessage();
        } else
        {
            if (intent.getAction().equals("com.poshmark.intents.LOGOUT_COMPLETE"))
            {
                disableAllControllerNotifications();
                return;
            }
            if (intent.getAction().equals("com.poshmark.intents.APP_STARTED") && userStateSummary == null && PMApplicationSession.GetPMSession().isLoggedIn())
            {
                refreshModels();
                fireRecurringRefreshMessage();
                return;
            }
        }
    }

    public void refreshModels()
    {
        PMApi.getUserSummary(new PMApiResponseHandler() {

            final UserStateSummaryController this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (!pmapiresponse.hasError())
                    {
                        userStateSummary = (UserStateSummary)pmapiresponse.data;
                        Analytics.getInstance().setUserSegment(userStateSummary.user_info.getAbSegment());
                        PMApplicationSession.GetPMSession().setUserABSegment(userStateSummary.user_info.getAbSegment());
                        if (userStateSummary.event_invites.updated_at != null)
                        {
                            pmapiresponse = DateUtils.getDateFromString(userStateSummary.event_invites.updated_at);
                            if (GlobalPartiesController.getGlobalPartiesController().lastUpdatedBefore(pmapiresponse))
                            {
                                PMNotificationManager.fireNotification("com.poshmark.intents.NEW_EVENTS_ON_SERVER");
                            }
                        }
                        if (userStateSummary.collections.posts.updated_at != null)
                        {
                            pmapiresponse = DateUtils.getDateFromString(userStateSummary.collections.posts.updated_at);
                            if (ShowroomsController.getGlobalShowroomsController().lastUpdatedBefore(pmapiresponse))
                            {
                                PMNotificationManager.fireNotification("com.poshmark.intents.NEW_SHOWROOMS_ON_SERVER");
                            }
                        }
                        if (userStateSummary.feature_settings != null && userStateSummary.feature_settings.updated_at != null)
                        {
                            pmapiresponse = DateUtils.getDateFromString(userStateSummary.feature_settings.updated_at);
                            if (FeatureManager.getGlobalFeatureManager().lastUpdatedBefore(pmapiresponse))
                            {
                                PMNotificationManager.fireNotification("com.poshmark.intents.NEW_FEATURES_ON_SERVER");
                            }
                        }
                        if (userStateSummary.brands != null)
                        {
                            pmapiresponse = new Bundle();
                            if (userStateSummary.brands.all != null)
                            {
                                pmapiresponse.putString("ALL_BRANDS_UPDATE_DTM", userStateSummary.brands.all.updated_at);
                            }
                            if (userStateSummary.brands.following != null)
                            {
                                pmapiresponse.putString("FOLLOWING_BRANDS_UPDATE_DTM", userStateSummary.brands.following.updated_at);
                            }
                            PMNotificationManager.fireNotification("com.poshmark.intents.NEW_BRANDS_ON_SERVER", pmapiresponse);
                        }
                        if (userStateSummary.catalog != null)
                        {
                            pmapiresponse = new Bundle();
                            pmapiresponse.putString("CATALOG_UPDATE_DTM", userStateSummary.catalog.updated_at);
                            PMNotificationManager.fireNotification("com.poshmark.intents.NEW_CATALOG_ON_SERVER", pmapiresponse);
                        }
                        BadgeCount.setCountValue(userStateSummary.notifications.total);
                        if (userStateSummary.notifications.total <= 0)
                        {
                            break label0;
                        }
                        PMNotificationManager.fireNotification("com.poshmark.intents.NEW_BADGE_COUNT");
                    }
                    return;
                }
                BadgeCount.resetCount();
            }

            
            {
                this$0 = UserStateSummaryController.this;
                super();
            }
        });
    }




/*
    static UserStateSummary access$002(UserStateSummaryController userstatesummarycontroller, UserStateSummary userstatesummary)
    {
        userstatesummarycontroller.userStateSummary = userstatesummary;
        return userstatesummary;
    }

*/

}
