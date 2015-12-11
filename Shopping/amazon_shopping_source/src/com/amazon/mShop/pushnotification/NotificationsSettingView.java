// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.content.res.Resources;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.Cancellable;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;
import com.amazon.mShop.control.pushnotification.NotificationSubscriber;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.search.GroupItemView;
import com.amazon.mShop.ui.AmazonSwitchWidget;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsResponse;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscription;
import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscriptionGroup;
import com.amazon.rio.j2me.client.services.mShop.TextAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            PushNotificationManager

public class NotificationsSettingView extends LinearLayout
    implements TitleProvider, Cancellable, NotificationSubscriber
{
    private class NotificationSettingAdapter extends BaseExpandableListAdapter
        implements android.widget.ExpandableListView.OnChildClickListener
    {

        private List mGroupList;
        final NotificationsSettingView this$0;

        private List getChildrenOfTheGroup(int i)
        {
            return (List)mNotificationSetting.get(((PushNotificationSubscriptionGroup)mGroupList.get(i)).getGroupId());
        }

        public Object getChild(int i, int j)
        {
            return getChildrenOfTheGroup(i).get(j);
        }

        public long getChildId(int i, int j)
        {
            return (long)j;
        }

        public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
        {
            viewgroup = (LinearLayout)view;
            view = viewgroup;
            if (viewgroup == null)
            {
                view = (LinearLayout)mAmazonActivity.getLayoutInflater().inflate(com.amazon.mShop.android.lib.R.layout.notification_setting_item, null);
            }
            viewgroup = view.findViewById(com.amazon.mShop.android.lib.R.id.item_text_block);
            TextView textview = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_name);
            AmazonSwitchWidget amazonswitchwidget = (AmazonSwitchWidget)view.findViewById(com.amazon.mShop.android.lib.R.id.item_checkbox);
            TextView textview1 = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.sign_in_to_view);
            TextView textview2 = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_description);
            String s = PushNotificationManager.getInstance().getCurrentMShopDeviceToken();
            final PushNotificationSubscription subscription = (PushNotificationSubscription)getChild(i, j);
            if (subscription.getRequiresUserRecognized().booleanValue() && !User.isLoggedIn())
            {
                textview1.setVisibility(0);
                textview1.setText(getStringIdForSignInLabel(subscription));
                viewgroup.setVisibility(8);
                amazonswitchwidget.setVisibility(8);
                textview1.setOnClickListener(subscription. new android.view.View.OnClickListener() {

                    final NotificationSettingAdapter this$1;
                    final PushNotificationSubscription val$subscription;

                    public void onClick(View view)
                    {
                        mPendingSubscription = subscription;
                        mPendingSubscribed = true;
                        view = new PushNotificationSubscription();
                        view.setGroupId(subscription.getGroupId());
                        view.setSubscriptionId(subscription.getSubscriptionId());
                        view.setSubscribed(true);
                        mAmazonActivity.authenticateUser(view. new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

                            final NotificationSettingAdapter._cls1 this$2;
                            final PushNotificationSubscription val$request;

                            public void userCancelledSignIn()
                            {
                                refreshUI(null);
                            }

                            public void userSuccessfullySignedIn()
                            {
                                PushNotificationManager pushnotificationmanager = PushNotificationManager.getInstance();
                                mNotificationSettingController.updateNotificationSubscriptions(pushnotificationmanager.getNewNotificationTarget(null), request, (new TaskCallbackFactory(mAmazonActivity)).getTaskCallback(_fld0));
                                logRefMarker(true, subscription);
                            }

            
            {
                this$2 = final__pcls1;
                request = PushNotificationSubscription.this;
                super();
            }
                        }, null);
                    }

            
            {
                this$1 = final_notificationsettingadapter;
                subscription = PushNotificationSubscription.this;
                super();
            }
                });
                return view;
            }
            textview1.setVisibility(8);
            viewgroup.setVisibility(0);
            amazonswitchwidget.setVisibility(0);
            textview2.setVisibility(8);
            textview.setText(subscription.getTitle());
            if (subscription.getDetails() != null && !Util.isEmpty(subscription.getDetails().getText()))
            {
                textview2.setText(subscription.getDetails().getText());
                textview2.setVisibility(0);
            }
            amazonswitchwidget.setOnCheckedChangeListener(null);
            amazonswitchwidget.setChecked(subscription.getSubscribed());
            amazonswitchwidget.setOnCheckedChangeListener(s. new android.widget.CompoundButton.OnCheckedChangeListener() {

                final NotificationSettingAdapter this$1;
                final String val$registrationId;
                final PushNotificationSubscription val$subscription;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    subscribe(subscription, registrationId);
                }

            
            {
                this$1 = final_notificationsettingadapter;
                subscription = pushnotificationsubscription;
                registrationId = String.this;
                super();
            }
            });
            return view;
        }

        public int getChildrenCount(int i)
        {
            if (getChildrenOfTheGroup(i) != null)
            {
                return getChildrenOfTheGroup(i).size();
            } else
            {
                return 0;
            }
        }

        public Object getGroup(int i)
        {
            return mGroupList.get(i);
        }

        public int getGroupCount()
        {
            return mGroupList.size();
        }

        public long getGroupId(int i)
        {
            return (long)i;
        }

        public List getGroupList()
        {
            return mGroupList;
        }

        public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
        {
            viewgroup = null;
            GroupItemView groupitemview = (GroupItemView)view;
            view = groupitemview;
            if (groupitemview == null)
            {
                view = (GroupItemView)mAmazonActivity.getLayoutInflater().inflate(com.amazon.mShop.android.lib.R.layout.search_refine_group_view, null);
            }
            if (((PushNotificationSubscriptionGroup)mGroupList.get(i)).getDetails() != null)
            {
                viewgroup = ((PushNotificationSubscriptionGroup)mGroupList.get(i)).getDetails().getText();
            }
            view.update(((PushNotificationSubscriptionGroup)mGroupList.get(i)).getTitle(), viewgroup, flag);
            return view;
        }

        public boolean hasStableIds()
        {
            return true;
        }

        public boolean isChildSelectable(int i, int j)
        {
            return true;
        }

        public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
        {
            expandablelistview = (PushNotificationSubscription)getChild(i, j);
            if (expandablelistview.getRequiresUserRecognized().booleanValue() && !User.isLoggedIn())
            {
                return false;
            } else
            {
                view = PushNotificationManager.getInstance();
                subscribe(expandablelistview, view.getCurrentMShopDeviceToken());
                return true;
            }
        }

        private NotificationSettingAdapter()
        {
            this$0 = NotificationsSettingView.this;
            super();
            mGroupList = new ArrayList();
        }

    }


    private NotificationSettingAdapter mAdapter;
    private AmazonActivity mAmazonActivity;
    private List mCurrentSubscriptions;
    private String mDefaultExpandedGroup;
    private ExpandableListView mExpandableListView;
    private Map mNotificationSetting;
    private NotificationSettingController mNotificationSettingController;
    private boolean mPendingSubscribed;
    private PushNotificationSubscription mPendingSubscription;

    public NotificationsSettingView(AmazonActivity amazonactivity, String s)
    {
        super(amazonactivity);
        mCurrentSubscriptions = new ArrayList();
        mNotificationSetting = new HashMap();
        mAmazonActivity = amazonactivity;
        mDefaultExpandedGroup = s;
        s = View.inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.notification_setting_list_view_header, null);
        View.inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.notification_setting, this);
        mExpandableListView = (ExpandableListView)findViewById(com.amazon.mShop.android.lib.R.id.notification_setting_listview);
        mExpandableListView.addHeaderView(s);
        mExpandableListView.setHeaderDividersEnabled(false);
        mAdapter = new NotificationSettingAdapter();
        mExpandableListView.setBackgroundResource(com.amazon.mShop.android.lib.R.color.white);
        mExpandableListView.setSelector(com.amazon.mShop.android.lib.R.color.common_selector);
        mExpandableListView.setItemsCanFocus(true);
        mExpandableListView.setAdapter(mAdapter);
        mExpandableListView.setOnChildClickListener(mAdapter);
        mExpandableListView.setDivider(getResources().getDrawable(com.amazon.mShop.android.lib.R.drawable.divider_horizontal_dark));
        mExpandableListView.setChildDivider(getResources().getDrawable(com.amazon.mShop.android.lib.R.drawable.divider_horizontal_dark));
        mExpandableListView.setGroupIndicator(null);
        mExpandableListView.setScrollbarFadingEnabled(false);
        mNotificationSettingController = new NotificationSettingController(this);
        s = PushNotificationManager.getInstance().getNewNotificationTarget(null);
        if (s != null)
        {
            mNotificationSettingController.getNotificationSubscriptions(s, (new TaskCallbackFactory(amazonactivity)).getTaskCallback(this, com.amazon.mShop.android.lib.R.string.loading));
        } else
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final NotificationsSettingView this$0;

                public void run()
                {
                    String s1 = PushNotificationManager.getInstance().getCurrentPushNotificationErrorId();
                    showErrorDialog(s1);
                }

            
            {
                this$0 = NotificationsSettingView.this;
                super();
            }
            });
        }
        if ("zh_CN".equals(AppLocale.getInstance().getCurrentLocaleName()))
        {
            if (s != null)
            {
                amazonactivity = "pn_gt_available";
            } else
            {
                amazonactivity = "pn_gt_unavailable";
            }
            RefMarkerObserver.logRefMarker(amazonactivity);
        }
    }

    private String constructRefMarkerPerNotificationType(boolean flag, PushNotificationSubscription pushnotificationsubscription)
    {
        String s = null;
        if (!pushnotificationsubscription.getSubscriptionId().equals("ST:shipment-tracking")) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        s = "pn_on_shipment-tracking";
_L6:
        return s;
_L4:
        return "pn_off_shipment-tracking";
_L2:
        if (pushnotificationsubscription.getSubscriptionId().equals("TD:lightning-deals"))
        {
            if (flag)
            {
                return "pn_on_ld_all";
            } else
            {
                return "pn_off_ld_all";
            }
        }
        if (pushnotificationsubscription.getSubscriptionId().equals("TD:deal-of-the-day"))
        {
            if (flag)
            {
                return "pn_on_dotd";
            } else
            {
                return "pn_off_dotd";
            }
        }
        if (pushnotificationsubscription.getSubscriptionId().equals("SNS:subscribe-and-save"))
        {
            if (flag)
            {
                return "pn_on_sns";
            } else
            {
                return "pn_off_sns";
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private String getErrorMessage(String s)
    {
        return PushNotificationManager.getInstance().getErrorMessage(getContext(), s);
    }

    private int getStringIdForSignInLabel(PushNotificationSubscription pushnotificationsubscription)
    {
        if (pushnotificationsubscription.getSubscriptionId().equals("ST:shipment-tracking"))
        {
            return com.amazon.mShop.android.lib.R.string.notification_sign_in_to_view_shipment_notifications;
        }
        if (pushnotificationsubscription.getSubscriptionId().equals("TD:deal-of-the-day"))
        {
            return com.amazon.mShop.android.lib.R.string.notification_sign_in_to_view_deal_of_the_day_notifications;
        }
        if (pushnotificationsubscription.getSubscriptionId().equals("SNS:subscribe-and-save"))
        {
            return com.amazon.mShop.android.lib.R.string.notification_sign_in_to_view_sns_notifications;
        }
        if (pushnotificationsubscription.getSubscriptionId().equals("PA:price-alert"))
        {
            return com.amazon.mShop.android.lib.R.string.notification_sign_in_to_view_pricealert_notifications;
        } else
        {
            return com.amazon.mShop.android.lib.R.string.notification_sign_in_to_receive_notification;
        }
    }

    private void logRefMarker(boolean flag, PushNotificationSubscription pushnotificationsubscription)
    {
        pushnotificationsubscription = constructRefMarkerPerNotificationType(flag, pushnotificationsubscription);
        if (!Util.isEmpty(pushnotificationsubscription))
        {
            RefMarkerObserver.logRefMarker(pushnotificationsubscription);
        }
    }

    private void refreshUI(GetNotificationSubscriptionsResponse getnotificationsubscriptionsresponse)
    {
        showHeader(getnotificationsubscriptionsresponse);
        mAdapter.notifyDataSetChanged();
        invalidate();
    }

    private void showHeader(GetNotificationSubscriptionsResponse getnotificationsubscriptionsresponse)
    {
        if (mExpandableListView != null && getnotificationsubscriptionsresponse != null)
        {
            final String url = getnotificationsubscriptionsresponse.getMessage();
            if (url != null)
            {
                TextView textview = (TextView)mExpandableListView.findViewById(com.amazon.mShop.android.lib.R.id.notification_setting_explanation);
                url = url.getText();
                if (!Util.isEmpty(url))
                {
                    textview.setText(url);
                }
            }
            url = getnotificationsubscriptionsresponse.getHelpLink();
            if (url != null)
            {
                getnotificationsubscriptionsresponse = (TextView)mExpandableListView.findViewById(com.amazon.mShop.android.lib.R.id.learn_more_about_notifications);
                final String helpText = url.getText();
                if (!Util.isEmpty(helpText))
                {
                    getnotificationsubscriptionsresponse.setText(helpText);
                    url = url.getAttributes().getLinkUrl();
                    if (!Util.isEmpty(url))
                    {
                        getnotificationsubscriptionsresponse.setOnClickListener(new android.view.View.OnClickListener() {

                            final NotificationsSettingView this$0;
                            final String val$helpText;
                            final String val$url;

                            public void onClick(View view)
                            {
                                mAmazonActivity.pushView(new AmazonBrandedWebView(mAmazonActivity, url, helpText));
                            }

            
            {
                this$0 = NotificationsSettingView.this;
                url = s;
                helpText = s1;
                super();
            }
                        });
                    }
                }
            }
        }
    }

    private void subscribe(PushNotificationSubscription pushnotificationsubscription, String s)
    {
        mPendingSubscription = pushnotificationsubscription;
        PushNotificationManager pushnotificationmanager;
        boolean flag;
        if (!pushnotificationsubscription.getSubscribed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPendingSubscribed = flag;
        s = new PushNotificationSubscription();
        s.setGroupId(pushnotificationsubscription.getGroupId());
        s.setSubscriptionId(pushnotificationsubscription.getSubscriptionId());
        s.setSubscribed(mPendingSubscribed);
        pushnotificationmanager = PushNotificationManager.getInstance();
        mNotificationSettingController.updateNotificationSubscriptions(pushnotificationmanager.getNewNotificationTarget(null), s, (new TaskCallbackFactory(mAmazonActivity)).getTaskCallback(this));
        logRefMarker(mPendingSubscribed, pushnotificationsubscription);
    }

    public void cancel()
    {
        mNotificationSettingController.cancel();
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (mAmazonActivity.menuDispatchedKeyEvent(keyevent))
        {
            return true;
        }
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            PushNotificationManager.getInstance().getNewNotificationTarget(null);
            if (mAmazonActivity.isErrorBoxShowing())
            {
                mAmazonActivity.finish();
                return true;
            }
        }
        return super.dispatchKeyEvent(keyevent);
    }

    public CharSequence getTitle()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.notification_setting);
    }

    public void onDeviceTokenUpdated()
    {
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        Log.e(PushNotificationManager.TAG, exception.toString());
        servicecall = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final NotificationsSettingView this$0;

            public void onActionButtonClick(int i)
            {
                Object obj = PushNotificationManager.getInstance();
                if (mPendingSubscription != null)
                {
                    subscribe(mPendingSubscription, ((PushNotificationManager) (obj)).getCurrentMShopDeviceToken());
                    return;
                } else
                {
                    obj = ((PushNotificationManager) (obj)).getNewNotificationTarget(null);
                    mNotificationSettingController.getNotificationSubscriptions(((com.amazon.rio.j2me.client.services.mShop.NotificationTarget) (obj)), (new TaskCallbackFactory(mAmazonActivity)).getTaskCallback(NotificationsSettingView.this, com.amazon.mShop.android.lib.R.string.loading));
                    return;
                }
            }

            
            {
                this$0 = NotificationsSettingView.this;
                super();
            }
        };
        AmazonErrorUtils.reportMShopServerError(mAmazonActivity, servicecall, this, exception);
    }

    public void onMarketplaceToggled(String s, boolean flag)
    {
    }

    public void onRequiresUserLogin(com.amazon.mShop.model.auth.UserSubscriber.Callback callback)
    {
    }

    public void onSubscriptionUpdated()
    {
        mPendingSubscription.setSubscribed(mPendingSubscribed);
        if (mPendingSubscription.getGroupId().equals("ST"))
        {
            String s = User.getUser().getFullName();
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean((new StringBuilder()).append("notShowNotificationSettingAtThankyouPage_").append(s).toString(), mPendingSubscribed);
        }
        boolean flag1 = true;
        Iterator iterator = mCurrentSubscriptions.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            PushNotificationSubscription pushnotificationsubscription = (PushNotificationSubscription)iterator.next();
            if (!pushnotificationsubscription.getGroupId().equals("TD") || !pushnotificationsubscription.getSubscribed())
            {
                continue;
            }
            flag = false;
            break;
        } while (true);
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("showTurnOnNotificationsAtDealresultsPage", flag);
        refreshUI(null);
    }

    public void onSubscriptionsReceived(GetNotificationSubscriptionsResponse getnotificationsubscriptionsresponse)
    {
        List list = getnotificationsubscriptionsresponse.getSubscriptionGroups();
        List list1 = getnotificationsubscriptionsresponse.getSubscriptions();
        if (list.size() == 0)
        {
            findViewById(com.amazon.mShop.android.lib.R.id.empty_notification_text).setVisibility(0);
        } else
        {
            mCurrentSubscriptions.clear();
            mNotificationSetting.clear();
            mCurrentSubscriptions.addAll(list1);
            mAdapter.getGroupList().addAll(list);
            for (Iterator iterator = mCurrentSubscriptions.iterator(); iterator.hasNext();)
            {
                PushNotificationSubscription pushnotificationsubscription = (PushNotificationSubscription)iterator.next();
                if (mNotificationSetting.get(pushnotificationsubscription.getGroupId()) == null)
                {
                    ArrayList arraylist = new ArrayList();
                    mNotificationSetting.put(pushnotificationsubscription.getGroupId(), arraylist);
                    arraylist.add(pushnotificationsubscription);
                } else
                {
                    ((List)mNotificationSetting.get(pushnotificationsubscription.getGroupId())).add(pushnotificationsubscription);
                }
            }

            refreshUI(getnotificationsubscriptionsresponse);
            int i = 0;
            while (i < mAdapter.getGroupCount()) 
            {
                if (Util.isEmpty(mDefaultExpandedGroup))
                {
                    mExpandableListView.expandGroup(i);
                } else
                if (((PushNotificationSubscriptionGroup)mAdapter.getGroupList().get(i)).getGroupId().equals(mDefaultExpandedGroup))
                {
                    mExpandableListView.expandGroup(i);
                    return;
                }
                i++;
            }
        }
    }

    public void showErrorDialog(final String errorId)
    {
        com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener;
        byte byte0;
        if (NetInfo.hasNetworkConnection())
        {
            byte0 = 4;
        } else
        {
            byte0 = 1;
        }
        amazonerrorboxactionlistener = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final NotificationsSettingView this$0;
            final String val$errorId;

            public void onActionButtonClick(int i)
            {
                PushNotificationManager.getInstance().handleClickActionOnErrorButton(mAmazonActivity, errorId);
            }

            
            {
                this$0 = NotificationsSettingView.this;
                errorId = s;
                super();
            }
        };
        AmazonErrorUtils.reportError(mAmazonActivity, byte0, amazonerrorboxactionlistener, this, getErrorMessage(errorId), getResources().getString(com.amazon.mShop.android.lib.R.string.notification_ok));
    }






/*
    static PushNotificationSubscription access$402(NotificationsSettingView notificationssettingview, PushNotificationSubscription pushnotificationsubscription)
    {
        notificationssettingview.mPendingSubscription = pushnotificationsubscription;
        return pushnotificationsubscription;
    }

*/


/*
    static boolean access$502(NotificationsSettingView notificationssettingview, boolean flag)
    {
        notificationssettingview.mPendingSubscribed = flag;
        return flag;
    }

*/




}
