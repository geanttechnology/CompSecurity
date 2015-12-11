// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.model.cart.Incentive;
import com.ebay.common.model.cart.UserIncentives;
import com.ebay.common.net.api.aps.UserActivitySummary;
import com.ebay.common.net.api.cart.GetUserIncentivesNetLoader;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.ErrorDialogActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.nautilus.shell.content.FwNetLoader;
import com.ebay.shared.ui.TableView;
import com.ebay.shared.ui.TextCountViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemindersActivity extends BaseActivity
    implements com.ebay.common.UserCache.IUpdateMsgRemindersCounts
{
    private class CouponsAdapter extends com.ebay.shared.ui.TableView.TableViewAdapter
    {

        final RemindersActivity this$0;

        public int getCount()
        {
            return 1;
        }

        public Incentive getItem(int i)
        {
            if (coupons == null || coupons.isEmpty())
            {
                return null;
            } else
            {
                return (Incentive)coupons.get(i);
            }
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = inflater.inflate(0x7f03007b, viewgroup, false);
                viewgroup = new TextCountViewHolder(view);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (TextCountViewHolder)view.getTag();
            }
            if (coupons == null || coupons.isEmpty())
            {
                ((TextCountViewHolder) (viewgroup)).count.setVisibility(8);
                view.findViewById(0x7f100147).setVisibility(4);
                view.setBackgroundDrawable(null);
                ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070658));
                return view;
            } else
            {
                ((TextCountViewHolder) (viewgroup)).text.setText(RemindersActivity.couponsAvailableString);
                ((TextCountViewHolder) (viewgroup)).count.setText(Util.countAsString(RemindersActivity.this, coupons.size()));
                return view;
            }
        }

        public void itemClick(int i)
        {
            if (coupons == null || coupons.isEmpty())
            {
                return;
            } else
            {
                ActivityStarter.startCouponItems(RemindersActivity.this, 666, RemindersActivity.couponsAvailableString);
                return;
            }
        }

        private CouponsAdapter()
        {
            this$0 = RemindersActivity.this;
            super();
        }

    }

    private class ReminderType
    {

        int count;
        final RemindersActivity this$0;
        int type;
        String typeText;

        public ReminderType(String s, int i, int j)
        {
            this$0 = RemindersActivity.this;
            super();
            typeText = s;
            type = i;
            count = j;
        }
    }

    private class RemindersAdapter extends com.ebay.shared.ui.TableView.TableViewAdapter
    {

        List reminders;
        final RemindersActivity this$0;
        Type type;

        public int getCount()
        {
            if (reminders == null || reminders.isEmpty())
            {
                return 1;
            } else
            {
                return reminders.size();
            }
        }

        public ReminderType getItem(int i)
        {
            if (reminders == null || reminders.isEmpty())
            {
                return null;
            } else
            {
                return (ReminderType)reminders.get(i);
            }
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = inflater.inflate(0x7f03007b, viewgroup, false);
                viewgroup = new TextCountViewHolder(view);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (TextCountViewHolder)view.getTag();
            }
            if (reminders == null || reminders.isEmpty())
            {
                ((TextCountViewHolder) (viewgroup)).count.setVisibility(8);
                view.findViewById(0x7f100147).setVisibility(4);
                view.setBackgroundDrawable(null);
                static class _cls2
                {

                    static final int $SwitchMap$com$ebay$mobile$myebay$RemindersActivity$Type[];

                    static 
                    {
                        $SwitchMap$com$ebay$mobile$myebay$RemindersActivity$Type = new int[Type.values().length];
                        try
                        {
                            $SwitchMap$com$ebay$mobile$myebay$RemindersActivity$Type[Type.ACTIVITIES.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$myebay$RemindersActivity$Type[Type.BUYING.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$myebay$RemindersActivity$Type[Type.SELLING.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$myebay$RemindersActivity$Type[Type.COUPONS.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls2..SwitchMap.com.ebay.mobile.myebay.RemindersActivity.Type[type.ordinal()])
                {
                default:
                    return view;

                case 1: // '\001'
                    ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070665));
                    return view;

                case 2: // '\002'
                    ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070656));
                    return view;

                case 3: // '\003'
                    ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070683));
                    return view;

                case 4: // '\004'
                    ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070658));
                    break;
                }
                return view;
            } else
            {
                ReminderType remindertype = getItem(i);
                ((TextCountViewHolder) (viewgroup)).text.setText(remindertype.typeText);
                ((TextCountViewHolder) (viewgroup)).count.setText(Util.countAsString(RemindersActivity.this, remindertype.count));
                return view;
            }
        }

        public void itemClick(int i)
        {
            if (reminders == null || reminders.isEmpty())
            {
                return;
            } else
            {
                ReminderType remindertype = getItem(i);
                ActivityStarter.startReminderItems(RemindersActivity.this, remindertype.type, remindertype.typeText);
                return;
            }
        }

        public RemindersAdapter(List list, Type type1)
        {
            this$0 = RemindersActivity.this;
            super();
            reminders = list;
            type = type1;
        }
    }

    private static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type ACTIVITIES;
        public static final Type BUYING;
        public static final Type COUPONS;
        public static final Type SELLING;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/ebay/mobile/myebay/RemindersActivity$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            ACTIVITIES = new Type("ACTIVITIES", 0);
            BUYING = new Type("BUYING", 1);
            SELLING = new Type("SELLING", 2);
            COUPONS = new Type("COUPONS", 3);
            $VALUES = (new Type[] {
                ACTIVITIES, BUYING, SELLING, COUPONS
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int COUPONS = 666;
    public static final int LOADER_ID_GET_USER_COUPONS = 1;
    private static String couponsAvailableString;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logMethod = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("RemindersMethod", 3, "Log Method");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Reminders", 3, "Log Method");
    private TableView activitiesList;
    private TableView buyingReminderList;
    private final List buyingReminders = new ArrayList();
    private RemindersAdapter buyingRemindersAdapter;
    private TableView couponReminderList;
    private final List coupons = new ArrayList();
    private CouponsAdapter couponsAdapter;
    private LayoutInflater inflater;
    private final List recentActivities = new ArrayList();
    private RemindersAdapter recentActivitiesAdapter;
    private View scrollView;
    private TableView sellingReminderList;
    private final List sellingReminders = new ArrayList();
    private RemindersAdapter sellingRemindersAdapter;
    private View spinnerView;
    private final UserCache userCache = new UserCache(this);

    public RemindersActivity()
    {
    }

    private void createUI()
    {
        Util.setAppStatus(this, getString(0x7f070913));
        scrollView = findViewById(0x7f10054b);
        spinnerView = findViewById(0x7f100120);
        scrollView.setVisibility(8);
        recentActivitiesAdapter = new RemindersAdapter(recentActivities, Type.ACTIVITIES);
        buyingRemindersAdapter = new RemindersAdapter(buyingReminders, Type.BUYING);
        sellingRemindersAdapter = new RemindersAdapter(sellingReminders, Type.SELLING);
        couponsAdapter = new CouponsAdapter();
        activitiesList = (TableView)findViewById(0x7f10054f);
        activitiesList.setAdapter(recentActivitiesAdapter);
        buyingReminderList = (TableView)findViewById(0x7f100551);
        buyingReminderList.setAdapter(buyingRemindersAdapter);
        sellingReminderList = (TableView)findViewById(0x7f100553);
        sellingReminderList.setAdapter(sellingRemindersAdapter);
        couponReminderList = (TableView)findViewById(0x7f10054d);
        couponReminderList.setAdapter(couponsAdapter);
        couponsAvailableString = getString(0x7f070275);
    }

    private void handleEbayResponseErrors(List list)
    {
        if (!isFinishing() && EbayErrorUtil.userNotLoggedIn(list) && MyApp.getPrefs().isSignedIn())
        {
            getFwLoaderManager().cancelAll(true);
            MyApp.signOutForIafTokenFailure(this);
        }
    }

    private void onGetUserIncentives(GetUserIncentivesNetLoader getuserincentivesnetloader)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!getuserincentivesnetloader.isError())
        {
            getuserincentivesnetloader = (com.ebay.common.net.api.cart.GetUserIncentives.GetUserIncentivesResponse)getuserincentivesnetloader.getResponse();
            flag = flag1;
            if (getuserincentivesnetloader != null)
            {
                flag = flag1;
                if (getuserincentivesnetloader.getUserIncentives() != null)
                {
                    getuserincentivesnetloader = getuserincentivesnetloader.getUserIncentives().incentives;
                    flag = flag1;
                    if (getuserincentivesnetloader != null)
                    {
                        flag = flag1;
                        if (getuserincentivesnetloader.size() > 0)
                        {
                            coupons.clear();
                            getuserincentivesnetloader = getuserincentivesnetloader.iterator();
                            do
                            {
                                if (!getuserincentivesnetloader.hasNext())
                                {
                                    break;
                                }
                                Incentive incentive = (Incentive)getuserincentivesnetloader.next();
                                if (incentive.incentiveType.equalsIgnoreCase("COUPON"))
                                {
                                    coupons.add(incentive);
                                }
                            } while (true);
                            flag = flag1;
                            if (coupons.size() > 0)
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        if (flag)
        {
            couponReminderList.setVisibility(0);
            findViewById(0x7f10054c).setVisibility(0);
            couponsAdapter.notifyDataSetChanged();
            return;
        } else
        {
            couponReminderList.setVisibility(8);
            findViewById(0x7f10054c).setVisibility(8);
            return;
        }
    }

    protected void getCoupons()
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        if (dcshelper.getConfig().get(DcsBoolean.Coupons) && dcshelper.isMecOrMec2Enabled(null))
        {
            Object obj = EbayApiUtil.getCartApi(this, MyApp.getPrefs().getAuthentication());
            obj = new GetUserIncentivesNetLoader(getEbayContext(), ((com.ebay.common.net.api.cart.EbayCartApi) (obj)), com.ebay.common.net.api.cart.GetUserIncentives.UserIncentiveType.COUPON);
            getFwLoaderManager().start(1, ((FwLoader) (obj)), true);
        }
    }

    public String getTrackingEventName()
    {
        return "Reminders";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 65 65: default 20
    //                   65 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j != -1)
        {
            finish();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        setContentView(0x7f0301c1);
        createUI();
    }

    public void onEbayError(List list)
    {
        handleEbayResponseErrors(list);
    }

    protected void onPause()
    {
        super.onPause();
        userCache.unregisterMsgRemindersCountsHandler(this);
    }

    public void onRemindersError()
    {
        runOnUiThread(new Runnable() {

            final RemindersActivity this$0;

            public void run()
            {
                String s = getString(0x7f07024c);
                Toast.makeText(RemindersActivity.this, s, 1).show();
            }

            
            {
                this$0 = RemindersActivity.this;
                super();
            }
        });
        finish();
    }

    public void onResume()
    {
        super.onResume();
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
            return;
        } else
        {
            getCoupons();
            spinnerView.setVisibility(0);
            (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
            userCache.registerMsgRemindersCountsHandler(this, true);
            return;
        }
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        FwNetLoader fwnetloader;
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[] {
                Integer.valueOf(i)
            });
        }
        fwnetloader = (FwNetLoader)fwloader;
        if (!fwnetloader.isError() || fwnetloader.isCanceled()) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("onTaskComplete: loader reports service error for id=").append(i).toString());
        }
        flag = false;
        i = ((flag) ? 1 : 0);
        if (!(fwnetloader instanceof EbaySimpleNetLoader)) goto _L4; else goto _L3
_L3:
        if (!Util.checkForIAFTokenError((EbaySimpleNetLoader)fwnetloader)) goto _L6; else goto _L5
_L5:
        getFwLoaderManager().cancelAll(true);
        handleIafTokenExpiration();
_L8:
        return;
_L6:
        fwloader = MyApp.getDisplayableServiceError(getEbayContext(), (EbaySimpleNetLoader)fwnetloader);
        i = ((flag) ? 1 : 0);
        if (!TextUtils.isEmpty(fwloader))
        {
            i = 1;
            ErrorDialogActivity.StartActivity(this, MyApp.getMaintenanceTitle(this), fwloader, false);
        }
_L4:
        if (i == 0)
        {
            showNetworkErrorToast();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!isFinishing() && !fwloader.isCanceled())
        {
            switch (i)
            {
            default:
                return;

            case 1: // '\001'
                onGetUserIncentives((GetUserIncentivesNetLoader)fwloader);
                break;
            }
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void updateMsgRemindersCounts(UserActivitySummary useractivitysummary)
    {
        spinnerView.setVisibility(8);
        scrollView.setVisibility(0);
        recentActivities.clear();
        buyingReminders.clear();
        sellingReminders.clear();
        if (useractivitysummary.buyingWatchEndingSoonCount > 0)
        {
            ReminderType remindertype = new ReminderType(getString(0x7f0705cd), 2, useractivitysummary.buyingWatchEndingSoonCount);
            recentActivities.add(remindertype);
        }
        if (useractivitysummary.buyingBidEndingSoonCount > 0)
        {
            ReminderType remindertype1 = new ReminderType(getString(0x7f070526), 3, useractivitysummary.buyingBidEndingSoonCount);
            recentActivities.add(remindertype1);
        }
        if (useractivitysummary.buyingOutbidCount > 0)
        {
            ReminderType remindertype2 = new ReminderType(getString(0x7f070580), 4, useractivitysummary.buyingOutbidCount);
            recentActivities.add(remindertype2);
        }
        if (useractivitysummary.sellingSellEndingSoonCount > 0)
        {
            ReminderType remindertype3 = new ReminderType(getString(0x7f0705b1), 13, useractivitysummary.sellingSellEndingSoonCount);
            recentActivities.add(remindertype3);
        }
        recentActivitiesAdapter.notifyDataSetChanged();
        if (useractivitysummary.buyingPaymentToSend > 0)
        {
            ReminderType remindertype4 = new ReminderType(getString(0x7f0705b3), 1, useractivitysummary.buyingPaymentToSend);
            buyingReminders.add(remindertype4);
        }
        if (useractivitysummary.buyingFeedbackToSend > 0)
        {
            ReminderType remindertype5 = new ReminderType(getString(0x7f070555), 0, useractivitysummary.buyingFeedbackToSend);
            buyingReminders.add(remindertype5);
        }
        if (useractivitysummary.buyingBestOfferCount > 0)
        {
            ReminderType remindertype6 = new ReminderType(getString(0x7f070524), 5, useractivitysummary.buyingBestOfferCount);
            buyingReminders.add(remindertype6);
        }
        if (useractivitysummary.buyingSecondChanceOfferCount > 0)
        {
            ReminderType remindertype7 = new ReminderType(getString(0x7f0705aa), 6, useractivitysummary.buyingSecondChanceOfferCount);
            buyingReminders.add(remindertype7);
        }
        if (MyApp.getDeviceConfiguration().isBopisEnabled() && useractivitysummary.buyingPickupReadyCount > 0)
        {
            ReminderType remindertype8 = new ReminderType(getString(0x7f070589), 7, useractivitysummary.buyingPickupReadyCount);
            buyingReminders.add(remindertype8);
        }
        buyingRemindersAdapter.notifyDataSetChanged();
        if (useractivitysummary.sellingBestOfferCount > 0)
        {
            ReminderType remindertype9 = new ReminderType(getString(0x7f070587), 14, useractivitysummary.sellingBestOfferCount);
            sellingReminders.add(remindertype9);
        }
        if (useractivitysummary.sellingPaymentToReceive > 0)
        {
            ReminderType remindertype10 = new ReminderType(getString(0x7f070522), 11, useractivitysummary.sellingPaymentToReceive);
            sellingReminders.add(remindertype10);
        }
        if (useractivitysummary.sellingFeedbackToSend > 0)
        {
            ReminderType remindertype11 = new ReminderType(getString(0x7f070555), 10, useractivitysummary.sellingFeedbackToSend);
            sellingReminders.add(remindertype11);
        }
        if (useractivitysummary.sellingShippingNeeded > 0)
        {
            useractivitysummary = new ReminderType(getString(0x7f070577), 12, useractivitysummary.sellingShippingNeeded);
            sellingReminders.add(useractivitysummary);
        }
        sellingRemindersAdapter.notifyDataSetChanged();
    }




}
