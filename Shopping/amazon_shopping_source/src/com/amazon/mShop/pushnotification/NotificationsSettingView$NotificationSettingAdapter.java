// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.search.GroupItemView;
import com.amazon.mShop.ui.AmazonSwitchWidget;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscription;
import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscriptionGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationsSettingView, PushNotificationManager

private class <init> extends BaseExpandableListAdapter
    implements android.widget.tionSettingAdapter
{

    private List mGroupList;
    final NotificationsSettingView this$0;

    private List getChildrenOfTheGroup(int i)
    {
        return (List)NotificationsSettingView.access$200(NotificationsSettingView.this).get(((PushNotificationSubscriptionGroup)mGroupList.get(i)).getGroupId());
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
            view = (LinearLayout)NotificationsSettingView.access$100(NotificationsSettingView.this).getLayoutInflater().inflate(com.amazon.mShop.android.lib.pter.this._fld0, null);
        }
        viewgroup = view.findViewById(com.amazon.mShop.android.lib.pter.this._fld0);
        TextView textview = (TextView)view.findViewById(com.amazon.mShop.android.lib.pter.this._fld0);
        AmazonSwitchWidget amazonswitchwidget = (AmazonSwitchWidget)view.findViewById(com.amazon.mShop.android.lib.pter.this._fld0);
        TextView textview1 = (TextView)view.findViewById(com.amazon.mShop.android.lib.pter.this._fld0);
        TextView textview2 = (TextView)view.findViewById(com.amazon.mShop.android.lib.pter.this._fld0);
        final String registrationId = PushNotificationManager.getInstance().getCurrentMShopDeviceToken();
        final PushNotificationSubscription subscription = (PushNotificationSubscription)getChild(i, j);
        if (subscription.getRequiresUserRecognized().booleanValue() && !User.isLoggedIn())
        {
            textview1.setVisibility(0);
            textview1.setText(NotificationsSettingView.access$300(NotificationsSettingView.this, subscription));
            viewgroup.setVisibility(8);
            amazonswitchwidget.setVisibility(8);
            textview1.setOnClickListener(new android.view.View.OnClickListener() {

                final NotificationsSettingView.NotificationSettingAdapter this$1;
                final PushNotificationSubscription val$subscription;

                public void onClick(View view1)
                {
                    NotificationsSettingView.access$402(this$0, subscription);
                    NotificationsSettingView.access$502(this$0, true);
                    view1 = new PushNotificationSubscription();
                    view1.setGroupId(subscription.getGroupId());
                    view1.setSubscriptionId(subscription.getSubscriptionId());
                    view1.setSubscribed(true);
                    NotificationsSettingView.access$100(this$0).authenticateUser(view1. new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

                        final _cls1 this$2;
                        final PushNotificationSubscription val$request;

                        public void userCancelledSignIn()
                        {
                            NotificationsSettingView.access$600(this$0, null);
                        }

                        public void userSuccessfullySignedIn()
                        {
                            PushNotificationManager pushnotificationmanager = PushNotificationManager.getInstance();
                            NotificationsSettingView.access$700(this$0).updateNotificationSubscriptions(pushnotificationmanager.getNewNotificationTarget(null), request, (new TaskCallbackFactory(NotificationsSettingView.access$100(this$0))).getTaskCallback(this$0));
                            NotificationsSettingView.access$800(this$0, true, subscription);
                        }

            
            {
                this$2 = final__pcls1;
                request = PushNotificationSubscription.this;
                super();
            }
                    }, null);
                }

            
            {
                this$1 = NotificationsSettingView.NotificationSettingAdapter.this;
                subscription = pushnotificationsubscription;
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
        amazonswitchwidget.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final NotificationsSettingView.NotificationSettingAdapter this$1;
            final String val$registrationId;
            final PushNotificationSubscription val$subscription;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                NotificationsSettingView.access$900(this$0, subscription, registrationId);
            }

            
            {
                this$1 = NotificationsSettingView.NotificationSettingAdapter.this;
                subscription = pushnotificationsubscription;
                registrationId = s;
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
            view = (GroupItemView)NotificationsSettingView.access$100(NotificationsSettingView.this).getLayoutInflater().inflate(com.amazon.mShop.android.lib.pter.this._fld0, null);
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
            NotificationsSettingView.access$900(NotificationsSettingView.this, expandablelistview, view.getCurrentMShopDeviceToken());
            return true;
        }
    }

    private _cls2.val.registrationId()
    {
        this$0 = NotificationsSettingView.this;
        super();
        mGroupList = new ArrayList();
    }

    mGroupList(mGroupList mgrouplist)
    {
        this();
    }
}
