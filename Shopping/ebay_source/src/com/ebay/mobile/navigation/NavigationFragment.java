// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.net.api.aps.UserActivitySummary;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.activities.MessagesActivity;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.OcsActivity;
import com.ebay.mobile.activities.PreferencesActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.sellsmartbox.SmartboxActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.user.symban.SymbanActivity;
import com.ebay.mobile.widget.UserThumbnail;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.content.dm.SymbanDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UssChannelsDataManager;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.SymbanNotification;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelsContainer;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NavigationFragment extends BaseFragment
    implements android.view.View.OnClickListener, com.ebay.common.UserCache.IUpdateMsgRemindersCounts, com.ebay.nautilus.domain.content.dm.SymbanDataManager.Observer, com.ebay.nautilus.domain.content.dm.UserContextDataManager.Observer, com.ebay.nautilus.domain.content.dm.UssChannelsDataManager.Observer, com.ebay.nautilus.domain.content.dm.UssContentsDataManager.Observer
{
    public static interface NavigationSelectionListener
    {

        public abstract void onNavigationSelected(int i);
    }


    private boolean bypassUssSelling;
    private DeviceConfiguration dcs;
    private TextView following;
    private boolean followingEnabled;
    private boolean followingNavPending;
    private TextView help;
    private int messageBadgeCount;
    private TextView messagesBadge;
    private NavigationSelectionListener navigationSelectionListener;
    private TextView notificationsBadge;
    private UserThumbnail profile;
    private boolean sellingEnabled;
    private TextView sellingNavigation;
    private SymbanDataManager symbanDataManager;
    private UserCache userCache;
    private UserContextDataManager userContextDataManager;
    private TextView username;
    private UssChannelsDataManager ussChannelsDataManager;
    private UssContentsDataManager ussContentsDataManager;
    private com.ebay.nautilus.domain.content.dm.UssContentsDataManager.KeyParams ussContentsDataManagerKeyParams;

    public NavigationFragment()
    {
        messageBadgeCount = 0;
        ussContentsDataManagerKeyParams = UssContentsDataManager.getChannelKeyParams(ChannelEnum.ACTIVITY.toString());
    }

    private void closeDrawerIfExists(Activity activity)
    {
        activity = (DrawerLayout)activity.findViewById(0x7f10016c);
        if (activity != null)
        {
            activity.closeDrawer(3);
        }
    }

    private void startSignedInActivity(Activity activity, Intent intent, boolean flag)
    {
        if (!MyApp.getPrefs().isSignedIn())
        {
            Intent intent1 = SignInModalActivity.getIntentForSignIn("Menu", activity);
            intent1.putExtra("fromHome", true);
            ArrayList arraylist = new ArrayList();
            if (flag)
            {
                Intent intent2 = new Intent(activity, com/ebay/mobile/activities/eBay);
                intent2.setFlags(0x24000000);
                arraylist.add(intent2);
            }
            arraylist.add(intent);
            intent1.putParcelableArrayListExtra("redirect_intents", arraylist);
            activity.startActivity(intent1);
            return;
        } else
        {
            activity.startActivity(intent);
            return;
        }
    }

    private void updateHelpText()
    {
label0:
        {
            NautilusKernel.verifyMain();
            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing() && dcs != null && help != null)
            {
                if (!dcs.get(DcsBoolean.OCS))
                {
                    break label0;
                }
                help.setText(getString(0x7f07027b));
            }
            return;
        }
        help.setText(getString(0x7f07044e));
    }

    private void updateMessagesBadge()
    {
        if (messagesBadge == null)
        {
            return;
        }
        if (messageBadgeCount > 0)
        {
            messagesBadge.setVisibility(0);
            String s = Util.countAsString(getActivity(), messageBadgeCount);
            messagesBadge.setText(s);
            return;
        } else
        {
            messagesBadge.setVisibility(4);
            return;
        }
    }

    protected boolean networkAvailable()
    {
        if (Util.hasNetwork())
        {
            return true;
        } else
        {
            EbayErrorHandler.handleResultStatus(this, -1, ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getNoNetworkMessage()
            }));
            return false;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (MyApp.getPrefs().isSignedIn())
        {
            bundle = MyApp.getPrefs().getCurrentUser();
            profile.setUserId(bundle);
            username.setText(bundle);
            return;
        } else
        {
            username.setText(0x7f070ab9);
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        BaseActivity baseactivity = getBaseActivity();
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext = baseactivity.getEbayContext();
        userContextDataManager = (UserContextDataManager)DataManager.get(ebaycontext, UserContextDataManager.KEY);
        userContextDataManager.registerObserver(this);
        userCache = new UserCache(baseactivity);
        if (activity instanceof eBay)
        {
            userCache.registerMsgRemindersCountsHandler(this, true);
        } else
        {
            userCache.registerMsgRemindersCountsHandler(this, false);
        }
        symbanDataManager = (SymbanDataManager)DataManager.get(ebaycontext, SymbanDataManager.KEY);
        symbanDataManager.registerObserver(this);
        dcs = MyApp.getDeviceConfiguration().getConfig();
        followingEnabled = dcs.get(com.ebay.mobile.dcs.Dcs.Verticals.B.following);
        followingNavPending = false;
        if (followingEnabled)
        {
            ussContentsDataManager = (UssContentsDataManager)DataManager.get(ebaycontext, ussContentsDataManagerKeyParams);
            ussContentsDataManager.registerObserver(this);
            ussContentsDataManager.loadDataForContentSource(this, new ContentSourceEnum[] {
                ContentSourceEnum.FOLLOW
            });
        }
        sellingEnabled = MyApp.getDeviceConfiguration().isSellingEnabled();
        bypassUssSelling = false;
    }

    public void onChannelsChanged(UssChannelsDataManager usschannelsdatamanager, Content content, EbayCountry ebaycountry)
    {
        boolean flag1 = false;
        if (!content.getStatus().hasError()) goto _L2; else goto _L1
_L1:
        if (sellingEnabled) goto _L4; else goto _L3
_L3:
        if (sellingNavigation != null)
        {
            sellingNavigation.setVisibility(8);
        }
        bypassUssSelling = false;
_L6:
        return;
_L4:
        if (sellingNavigation != null)
        {
            sellingNavigation.setVisibility(0);
            sellingNavigation.setText(0x7f070b61);
        }
        bypassUssSelling = true;
        return;
_L2:
        bypassUssSelling = false;
        sellingNavigation.setText(0x7f0700c3);
        usschannelsdatamanager = (ChannelsContainer)content.getData();
        boolean flag;
        boolean flag2;
        if (usschannelsdatamanager != null && ((ChannelsContainer) (usschannelsdatamanager)).channels != null)
        {
            usschannelsdatamanager = ((ChannelsContainer) (usschannelsdatamanager)).channels;
        } else
        {
            usschannelsdatamanager = Collections.emptyList();
        }
        flag2 = false;
        usschannelsdatamanager = usschannelsdatamanager.iterator();
        do
        {
            flag = flag2;
            if (!usschannelsdatamanager.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            content = (Channel)usschannelsdatamanager.next();
        } while (!ChannelEnum.SELL.name().equals(((Channel) (content)).name));
        flag = true;
        if (sellingNavigation == null) goto _L6; else goto _L5
_L5:
        usschannelsdatamanager = sellingNavigation;
        int i;
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        usschannelsdatamanager.setVisibility(i);
        return;
    }

    public void onClick(View view)
    {
        Activity activity = getActivity();
        closeDrawerIfExists(activity);
        followingNavPending = false;
        int i = view.getId();
        if (navigationSelectionListener != null)
        {
            navigationSelectionListener.onNavigationSelected(i);
        }
        switch (i)
        {
        case 2131756013: 
        case 2131756014: 
        case 2131756016: 
        case 2131756017: 
        case 2131756018: 
        case 2131756019: 
        case 2131756021: 
        case 2131756022: 
        case 2131756023: 
        case 2131756025: 
        case 2131756026: 
        case 2131756027: 
        case 2131756028: 
        default:
            return;

        case 2131756015: 
            view = new SourceIdentification("Menu", "profile");
            if (!MyApp.getPrefs().isSignedIn())
            {
                Intent intent = SignInModalActivity.getIntentForSignIn("Menu", activity);
                intent.putExtra("com.ebay.mobile.analytics.sid", view);
                intent.putExtra("fromHome", true);
                activity.startActivity(intent);
                return;
            } else
            {
                Intent intent1 = new Intent(activity, com/ebay/mobile/activities/UserDetailActivity);
                intent1.putExtra("com.ebay.mobile.analytics.sid", view);
                activity.startActivity(intent1);
                return;
            }

        case 2131756020: 
            view = new Intent(activity, com/ebay/mobile/activities/MessagesActivity);
            view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Menu", "msgs"));
            startSignedInActivity(activity, view, false);
            return;

        case 2131756024: 
            view = new Intent(activity, com/ebay/mobile/user/symban/SymbanActivity);
            view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Menu", "notifications"));
            startSignedInActivity(activity, view, false);
            return;

        case 2131756012: 
            view = new Intent(activity, com/ebay/mobile/activities/eBay);
            view.setFlags(0x24000000);
            activity.startActivity(view);
            view = new Intent(activity, com/ebay/mobile/activities/PreferencesActivity);
            view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Menu", "setting"));
            activity.startActivity(view);
            return;

        case 2131756011: 
            if (dcs.get(DcsBoolean.OCS))
            {
                activity.startActivity(new Intent(activity, com/ebay/mobile/activities/OcsActivity));
                return;
            } else
            {
                view = new TrackingData("AppEvents", TrackingType.EVENT);
                view.addKeyValuePair("mfls", "HLP");
                view.send(getFwActivity().getEbayContext());
                Util.composeSupportEmail(getActivity());
                return;
            }

        case 2131756029: 
            view = new Intent(activity, com/ebay/mobile/activities/eBay);
            view.setFlags(0x24000000);
            view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Menu", "home"));
            activity.startActivity(view);
            return;

        case 2131756030: 
            view = MyEbayLandingActivity.getWatchingActivityIntent(activity);
            view.setFlags(0x24000000);
            view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Menu", "watching"));
            startSignedInActivity(activity, view, true);
            return;

        case 2131756031: 
            view = MyEbayLandingActivity.getBuyingActivityIntent(activity);
            view.setFlags(0x24000000);
            view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Menu", "buying"));
            startSignedInActivity(activity, view, true);
            return;

        case 2131756032: 
            if (bypassUssSelling)
            {
                view = new Intent(activity, com/ebay/mobile/activities/eBay);
                view.setFlags(0x24000000);
                activity.startActivity(view);
                activity.startActivity(new Intent(getActivity(), com/ebay/mobile/sellsmartbox/SmartboxActivity));
                return;
            } else
            {
                view = new Intent(activity, com/ebay/mobile/activities/eBay);
                view.setFlags(0x24000000);
                view.putExtra("HomeStartChannelTab", ChannelEnum.SELL);
                view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Menu", "selling"));
                activity.startActivity(view);
                return;
            }

        case 2131756033: 
            followingNavPending = true;
            ussContentsDataManager.loadData(this);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03017e, viewgroup, false);
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        updateHelpText();
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (!TextUtils.isEmpty(s))
        {
            username.setText(s);
            profile.setUserId(s);
        }
    }

    public void onDestroyView()
    {
        userContextDataManager.unregisterObserver(this);
        userCache.unregisterMsgRemindersCountsHandler(this);
        symbanDataManager.unregisterObserver(this);
        if (followingEnabled)
        {
            ussContentsDataManager.unregisterObserver(this);
        }
        super.onDestroyView();
    }

    public void onEbayError(List list)
    {
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        userContextDataManager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        symbanDataManager = (SymbanDataManager)datamanagercontainer.initialize(SymbanDataManager.KEY, null);
        ussChannelsDataManager = (UssChannelsDataManager)datamanagercontainer.initialize(UssChannelsDataManager.KEY, this);
    }

    public void onMarkAllReadCompleted(SymbanDataManager symbandatamanager, ResultStatus resultstatus)
    {
        if (ResultStatus.SUCCESS.equals(resultstatus))
        {
            notificationsBadge.setVisibility(4);
        }
    }

    public void onRemindersError()
    {
    }

    public void onStreamChanged(UssContentsDataManager usscontentsdatamanager, Content content, boolean flag, boolean flag1)
    {
label0:
        {
            if (!followingNavPending)
            {
                return;
            }
            followingNavPending = false;
            boolean flag3 = false;
            boolean flag2;
            if (content != null)
            {
                usscontentsdatamanager = (Contents)content.getData();
            } else
            {
                usscontentsdatamanager = null;
            }
            flag2 = flag3;
            if (usscontentsdatamanager == null)
            {
                break label0;
            }
            flag2 = flag3;
            if (((Contents) (usscontentsdatamanager)).contentGroups == null)
            {
                break label0;
            }
            usscontentsdatamanager = ((Contents) (usscontentsdatamanager)).contentGroups.iterator();
            do
            {
                flag2 = flag3;
                if (!usscontentsdatamanager.hasNext())
                {
                    break label0;
                }
                content = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)usscontentsdatamanager.next();
            } while (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (content)).contentSource != ContentSourceEnum.FOLLOW);
            usscontentsdatamanager = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (content)).contents.get(0);
            if (usscontentsdatamanager != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (usscontentsdatamanager)).followedEntities != null && !((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (usscontentsdatamanager)).followedEntities.emptyFollow)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
        }
        usscontentsdatamanager = getActivity();
        if (flag2)
        {
            startSignedInActivity(usscontentsdatamanager, ActivityStarter.getBrowseFollowsIntent(usscontentsdatamanager), true);
            return;
        } else
        {
            content = new Intent(usscontentsdatamanager, com/ebay/mobile/activities/eBay);
            content.setFlags(0x24000000);
            content.putExtra("HomeStartChannelTab", ChannelEnum.ACTIVITY);
            content.putExtra("InitialViewType", 3);
            usscontentsdatamanager.startActivity(content);
            return;
        }
    }

    public void onSymbanCountChanged(SymbanDataManager symbandatamanager, int i)
    {
        if (i == 0)
        {
            notificationsBadge.setVisibility(4);
            return;
        } else
        {
            notificationsBadge.setVisibility(0);
            symbandatamanager = Util.countAsString(getActivity(), i);
            notificationsBadge.setText(symbandatamanager);
            return;
        }
    }

    public void onSymbanListChanged(SymbanDataManager symbandatamanager, Content content)
    {
        if (ResultStatus.SUCCESS.equals(content.getStatus()))
        {
            int i = ((List)content.getData()).size();
            if (i == 0)
            {
                notificationsBadge.setVisibility(4);
                return;
            } else
            {
                notificationsBadge.setVisibility(0);
                symbandatamanager = Util.countAsString(getActivity(), i);
                notificationsBadge.setText(symbandatamanager);
                return;
            }
        } else
        {
            notificationsBadge.setVisibility(4);
            return;
        }
    }

    public void onSymbanUpdatedCompleted(SymbanDataManager symbandatamanager, SymbanNotification symbannotification, com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum statusenum)
    {
    }

    public void onUserSignedInStatusChanged(UserContextDataManager usercontextdatamanager, String s, String s1, String s2)
    {
        byte byte0 = 8;
        if (!TextUtils.isEmpty(s))
        {
            username.setText(s);
            profile.setUserId(s);
            usercontextdatamanager = following;
            if (followingEnabled)
            {
                byte0 = 0;
            }
            usercontextdatamanager.setVisibility(byte0);
            return;
        } else
        {
            following.setVisibility(8);
            return;
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        profile = (UserThumbnail)view.findViewById(0x7f1003f0);
        username = (TextView)view.findViewById(0x7f1003f1);
        messagesBadge = (TextView)view.findViewById(0x7f1003f7);
        notificationsBadge = (TextView)view.findViewById(0x7f1003fb);
        help = (TextView)view.findViewById(0x7f1003eb);
        help.setOnClickListener(this);
        following = (TextView)view.findViewById(0x7f100401);
        view.findViewById(0x7f1003ef).setOnClickListener(this);
        view.findViewById(0x7f1003f4).setOnClickListener(this);
        view.findViewById(0x7f1003f8).setOnClickListener(this);
        view.findViewById(0x7f1003ec).setOnClickListener(this);
        view.findViewById(0x7f1003fd).setOnClickListener(this);
        view.findViewById(0x7f1003fe).setOnClickListener(this);
        view.findViewById(0x7f1003ff).setOnClickListener(this);
        sellingNavigation = (TextView)view.findViewById(0x7f100400);
        sellingNavigation.setOnClickListener(this);
        following.setOnClickListener(this);
        if (userContextDataManager != null)
        {
            view = userContextDataManager.getCurrentUser();
            bundle = following;
            int i;
            if (view != null && followingEnabled)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            bundle.setVisibility(i);
        } else
        {
            following.setVisibility(8);
        }
        symbanDataManager.loadCount(this);
        updateMessagesBadge();
        updateHelpText();
    }

    public void setNavigationSelectionListener(NavigationSelectionListener navigationselectionlistener)
    {
        navigationSelectionListener = navigationselectionlistener;
    }

    public void updateMsgRemindersCounts(UserActivitySummary useractivitysummary)
    {
        if (useractivitysummary == null)
        {
            return;
        } else
        {
            messageBadgeCount = useractivitysummary.messagesNewMessageCount;
            updateMessagesBadge();
            return;
        }
    }
}
