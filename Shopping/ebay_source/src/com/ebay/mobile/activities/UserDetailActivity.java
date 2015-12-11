// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.net.api.shopping.GetUserProfileNetLoader;
import com.ebay.common.net.api.trading.AddMemberMessageAAQNetLoader;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.givingworks.GivingWorksFavoritesFragment;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.ui_stuff.UserNotifications;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewCommonProgressAndError;
import com.ebay.mobile.viewitem.ItemViewSellersLegalInfoActivity;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.UserProfile;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.shopping.GetUserProfileResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, SignInModalActivity, ComposeNewMessageActivity, ViewFeedbackActivity, 
//            eBay

public class UserDetailActivity extends BaseActivity
    implements android.view.View.OnClickListener
{
    private class FollowedEntityDataManagerObserver extends com.ebay.common.content.dm.FollowedEntityDataManager.SimpleObserver
    {

        final UserDetailActivity this$0;

        public void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
        {
            if (resultstatus.hasError())
            {
                EbayErrorHandler.handleResultStatus(getParent(), 0, resultstatus);
            } else
            if (followtype == FollowType.USER && userId.equalsIgnoreCase(s))
            {
                isUserBeingFollowed = false;
                hideAndShowFavoriteButton();
                return;
            }
        }

        public void onFollowedUsersLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
        {
            followedentitydatamanager = datedcontent.getStatus();
            if (followedentitydatamanager.hasError())
            {
                EbayErrorHandler.handleResultStatus(getParent(), 0, followedentitydatamanager);
            } else
            {
                followedentitydatamanager = (List)datedcontent.getData();
                if (followedentitydatamanager != null)
                {
                    followedentitydatamanager = followedentitydatamanager.iterator();
                    do
                    {
                        if (!followedentitydatamanager.hasNext())
                        {
                            break;
                        }
                        datedcontent = (FollowDescriptor)followedentitydatamanager.next();
                        if (((FollowDescriptor) (datedcontent)).type != FollowType.USER || !userId.equalsIgnoreCase(((FollowDescriptor) (datedcontent)).username))
                        {
                            continue;
                        }
                        isUserBeingFollowed = true;
                        break;
                    } while (true);
                    hideAndShowFavoriteButton();
                    return;
                }
            }
        }

        public void onUserFollowed(Content content)
        {
            ResultStatus resultstatus = content.getStatus();
            if (resultstatus.hasError())
            {
                EbayErrorHandler.handleResultStatus(getParent(), 0, resultstatus);
            } else
            if (userId.equals(content.getData()))
            {
                isUserBeingFollowed = true;
                hideAndShowFavoriteButton();
                return;
            }
        }

        private FollowedEntityDataManagerObserver()
        {
            this$0 = UserDetailActivity.this;
            super();
        }

    }

    private class ViewItemDataManagerObserver extends com.ebay.mobile.viewitem.ViewItemDataManager.SimpleViewItemDataManagerObserver
    {

        final UserDetailActivity this$0;

        public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled actionhandled, boolean flag)
        {
            if (!isFinishing())
            {
                if (viewItemDataManager == null)
                {
                    viewItemDataManager = viewitemdatamanager;
                }
                if (!content.getStatus().hasError())
                {
                    item = (Item)content.getData();
                    initUIState();
                    viewitemdatamanager = MyApp.getPrefs().getAuthentication();
                    if ((requireSignIn || TextUtils.isEmpty(userId)) && viewitemdatamanager == null)
                    {
                        viewitemdatamanager = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), UserDetailActivity.this);
                        startActivityForResult(viewitemdatamanager, 65);
                        return;
                    }
                    fillUIDetails();
                    if (!userProfileLoading)
                    {
                        showUserProfile();
                        return;
                    }
                } else
                {
                    EbayErrorHandler.handleResultStatus(UserDetailActivity.this, 0, content.getStatus());
                    return;
                }
            }
        }

        private ViewItemDataManagerObserver()
        {
            this$0 = UserDetailActivity.this;
            super();
        }

    }


    private static final int DIALOG_NOTIFICATIONS_WILL_NOT_BE_RECEIVED = 1;
    public static final String EXTRA_EMAIL = "email";
    public static final String EXTRA_IS_BUYER = "isBuyer";
    public static final String EXTRA_IS_SELLER = "isSeller";
    private static final String EXTRA_IS_SELLERS_OTHER_ITEMS = "is_sellers_other_item";
    private static final String EXTRA_RATING_STAR = "rating_star";
    public static final String EXTRA_REQUIRE_SIGNIN = "requiresSignIn";
    private static final String EXTRA_SEARCH_OTHER_COUNTRIES = "search_other_countries";
    public static final String EXTRA_USER_ID = "user_id";
    private static final int FOLLOW_REQUEST = 4;
    private static final int LOADER_ID_ADD_MESSAGE = 3;
    private static final int LOADER_ID_GET_USER_PROFILE = 1;
    private static final String SELECT_CHARITY_FRAGMENT = "select_charity_fragment";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("UserDetailActivity", 4, "User Detail activity");
    protected View buttonLayout;
    private TextView feedbackCountTextView;
    private ImageView feedbackStarImageView;
    private FollowedEntityDataManager followedEntityDataManager;
    private FollowedEntityDataManagerObserver followedEntityDmObserver;
    private boolean hasOtherItems;
    private boolean isBuyer;
    private boolean isSeller;
    protected boolean isUserBeingFollowed;
    private boolean isUserViewingTheirOwnDetails;
    protected Item item;
    private String ratingStar;
    protected boolean requireSignIn;
    protected View scrollViewSpacer;
    private boolean searchOtherCountries;
    private UserContextDataManager userContextDataManager;
    protected String userId;
    private TextView userNameTextView;
    private UserProfile userProfile;
    private String userProfileImageUrl;
    private RemoteImageView userProfileImageView;
    protected boolean userProfileLoading;
    private ViewItemViewData viewData;
    protected ViewItemDataManager viewItemDataManager;
    private ViewItemDataManagerObserver viewItemDmObserver;

    public UserDetailActivity()
    {
        userProfile = null;
        userProfileLoading = false;
        userProfileImageUrl = null;
        isUserViewingTheirOwnDetails = false;
        isUserBeingFollowed = false;
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, String s, String s1, String s2, boolean flag)
    {
        StartActivity(activity, viewitemviewdata, s, s1, s2, flag, false, false, true, null, false, null);
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, String s, String s1, String s2, boolean flag, boolean flag1, boolean flag2, 
            boolean flag3, Integer integer, boolean flag4, Intent intent)
    {
        Intent intent1;
label0:
        {
            if (!TextUtils.isEmpty(s))
            {
                intent1 = new Intent(activity, com/ebay/mobile/activities/UserDetailActivity);
                intent1.putExtra("user_id", s);
                intent1.putExtra("email", s1);
                intent1.putExtra("view_item_view_data", viewitemviewdata);
                if (!TextUtils.isEmpty(s2))
                {
                    intent1.putExtra("rating_star", s2);
                }
                intent1.putExtra("is_sellers_other_item", flag);
                intent1.putExtra("isBuyer", flag1);
                intent1.putExtra("isSeller", flag2);
                intent1.putExtra("requiresSignIn", flag3);
                intent1.putExtra("search_other_countries", flag4);
                if (intent != null)
                {
                    intent1.putExtras(intent);
                }
                if (integer == null)
                {
                    break label0;
                }
                activity.startActivityForResult(intent1, integer.intValue());
            }
            return;
        }
        activity.startActivity(intent1);
    }

    public static void StartActivity(Activity activity, String s, String s1, String s2)
    {
        StartActivity(activity, null, s, s1, s2, false, false, false, true, null, false, null);
    }

    public static void StartActivity(Activity activity, String s, String s1, String s2, boolean flag)
    {
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        StartActivity(activity, null, s, s1, s2, false, flag1, flag, true, null, false, null);
    }

    public static void StartActivity(Activity activity, String s, String s1, String s2, boolean flag, Intent intent)
    {
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        StartActivity(activity, null, s, s1, s2, false, flag1, flag, true, null, false, intent);
    }

    public static void StartActivityForBuyer(Activity activity, ViewItemViewData viewitemviewdata, String s, String s1, String s2)
    {
        StartActivity(activity, viewitemviewdata, s, s1, s2, false, true, false, true, null, false, null);
    }

    public static void StartActivityForResult(Activity activity, String s, Integer integer)
    {
        StartActivity(activity, null, s, null, null, false, false, false, true, integer, false, null);
    }

    public static void StartActivityForSeller(Activity activity, ViewItemViewData viewitemviewdata, String s, String s1, String s2, boolean flag, boolean flag1, boolean flag2)
    {
        StartActivity(activity, viewitemviewdata, s, s1, s2, flag, false, true, flag1, null, flag2, null);
    }

    private void getUserProfile()
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        GetUserProfileNetLoader getuserprofilenetloader = new GetUserProfileNetLoader(getEbayContext(), EbayApiUtil.getShoppingApi(this), userId);
        userProfileLoading = true;
        getFwLoaderManager().start(1, getuserprofilenetloader, true);
    }

    private void handleAddMessageError(EbaySimpleNetLoader ebaysimplenetloader, String s)
    {
        handleAddMessageError(ebaysimplenetloader, s, null, null);
    }

    private void handleAddMessageError(EbaySimpleNetLoader ebaysimplenetloader, String s, final String body, final ArrayList pictureUrls)
    {
        ebaysimplenetloader = ebaysimplenetloader.getServiceErrorsAndWarnings();
        Object obj;
        if (ebaysimplenetloader != null)
        {
            ebaysimplenetloader = ((EbayResponseError)ebaysimplenetloader.get(0)).longMessage;
        } else
        {
            ebaysimplenetloader = null;
        }
        obj = ebaysimplenetloader;
        if (ebaysimplenetloader == null)
        {
            s = getString(0x7f070629);
            obj = getString(0x7f070635);
        }
        ebaysimplenetloader = new android.support.v7.app.AlertDialog.Builder(this);
        ebaysimplenetloader.setIcon(0x1080027).setTitle(s).setMessage(((CharSequence) (obj))).setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

            final UserDetailActivity this$0;
            final String val$body;
            final ArrayList val$pictureUrls;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                if (body != null)
                {
                    askQuestion(body, pictureUrls);
                }
            }

            
            {
                this$0 = UserDetailActivity.this;
                body = s;
                pictureUrls = arraylist;
                super();
            }
        }).create();
        ebaysimplenetloader.show();
    }

    private boolean handleEbayResponseErrors(List list)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (EbayErrorUtil.userNotLoggedIn(list))
        {
            flag = flag1;
            if (MyApp.getPrefs().isSignedIn())
            {
                flag = true;
                MyApp.signOutForIafTokenFailure(this);
            }
        }
        return flag;
    }

    private void onAddMessageComplete(AddMemberMessageAAQNetLoader addmembermessageaaqnetloader)
    {
        if (!addmembermessageaaqnetloader.isError())
        {
            UserNotifications.showToast(this, getString(0x7f070617), false, true);
        }
    }

    private void onGetUserProfileComplete(GetUserProfileNetLoader getuserprofilenetloader)
    {
        if (!isFinishing())
        {
            if (!getuserprofilenetloader.isError() && getuserprofilenetloader.getResponse() != null)
            {
                userProfile = ((GetUserProfileResponse)getuserprofilenetloader.getResponse()).result;
                if (userProfile != null)
                {
                    if (!TextUtils.isEmpty(userProfile.myWorldLargeImage) && !userProfile.myWorldLargeImage.equals(userProfileImageUrl))
                    {
                        userProfileImageUrl = userProfile.myWorldLargeImage;
                        userProfileImageView.setRemoteImageUrl(userProfileImageUrl);
                    }
                    ratingStar = userProfile.ratingStar;
                    showUserProfile();
                }
            }
            if (TextUtils.isEmpty(userProfileImageUrl))
            {
                userProfileImageView.setImageResource(0x7f020241);
                return;
            }
        }
    }

    private void otherItems()
    {
        (new TrackingData("SeeSellersOtherItems", TrackingType.PAGE_IMPRESSION)).send(this);
        ActivityStarter.startSellerItemsSearchResultList(this, userId, searchOtherCountries, new SourceIdentification(getTrackingEventName()));
    }

    private void setCell(int i, long l)
    {
        TextView textview = (TextView)findViewById(i);
        textview.setText(String.valueOf(l));
        if (l > 0L)
        {
            textview.setOnClickListener(this);
        }
    }

    private void setRating(com.ebay.nautilus.domain.data.UserProfile.AverageRatingDetails averageratingdetails, int i, String s)
    {
        long l = 0L;
        View view = findViewById(i);
        if (averageratingdetails == null)
        {
            view.setVisibility(8);
            return;
        }
        ((TextView)view.findViewById(0x7f10005f)).setText(s);
        ((RatingBar)view.findViewById(0x7f10053d)).setRating((float)averageratingdetails.rating);
        s = (TextView)view.findViewById(0x7f1003da);
        if (averageratingdetails.ratingCount >= 0L)
        {
            l = averageratingdetails.ratingCount;
        }
        s.setText(getResources().getString(0x7f0708d2, new Object[] {
            Long.valueOf(l)
        }));
    }

    private void setupButton(int i, boolean flag)
    {
        View view = findViewById(i);
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view.setOnClickListener(this);
    }

    private void setupView(int i, boolean flag)
    {
        View view = findViewById(i);
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view.setOnClickListener(this);
    }

    private void updateCharityLayout()
    {
        View view = findViewById(0x7f10085f);
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (isUserViewingTheirOwnDetails && deviceconfiguration.get(DcsBoolean.ebayGivingProfile))
        {
            if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.UK))
            {
                ((TextView)findViewById(0x7f100860)).setText(0x7f0704a6);
            }
            view.findViewById(0x7f100861).setOnClickListener(this);
            view.setVisibility(0);
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    protected void askQuestion()
    {
        askQuestion(null, null);
    }

    protected void askQuestion(String s, ArrayList arraylist)
    {
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 77);
            return;
        }
        obj = new ComposeNewMessageActivity.MemberMessageRequestParams(Long.valueOf(item.id), ((Authentication) (obj)).user, userId, s, isBuyer);
        ((ComposeNewMessageActivity.MemberMessageRequestParams) (obj)).setPictureUrls(arraylist);
        if (!isBuyer)
        {
            s = getEbayContext();
            if (item.currentPriceForType(s, viewData) != null)
            {
                s = new CurrencyAmount(item.currentPriceForType(s, viewData));
            } else
            {
                s = new CurrencyAmount(item.currentPrice);
            }
            s = new ComposeNewMessageActivity.MemberMessageTrackingInfo(Double.toString(s.getValueAsDouble()), item.site, Double.toString(item.primaryCategoryId));
            arraylist = new HashMap();
            arraylist.put(com.ebay.mobile.analytics.Tracking.Tag.MESSAGE_DIRECTION, ComposeNewMessageActivity.MemberMessageTagValues.BUYER_ASK_QUESTION);
            s.setMessageTag(arraylist);
            s.setSid(new SourceIdentification(getTrackingEventName()));
            ((ComposeNewMessageActivity.MemberMessageRequestParams) (obj)).setTrackingData(s);
        }
        (new TrackingData(com.ebay.mobile.analytics.Tracking.EventName.CONTACT_SELLER, TrackingType.EVENT)).send(this);
        ComposeNewMessageActivity.StartActivity(this, ((ComposeNewMessageActivity.MemberMessageRequestParams) (obj)));
    }

    protected void fillUIDetails()
    {
        boolean flag1 = true;
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (TextUtils.isEmpty(userId) && authentication != null)
        {
            userId = authentication.user;
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "fillUIDetails, using logged in user for userid");
            }
        }
        int i;
        boolean flag;
        if (authentication != null && userId.equalsIgnoreCase(authentication.user))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isUserViewingTheirOwnDetails = flag;
        userNameTextView.setText(userId);
        if (!isUserViewingTheirOwnDetails && item != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setupButton(0x7f100843, flag);
        setupView(0x7f100848, true);
        updateCharityLayout();
        if (item != null && item.bsDetailsExists && !isBuyer)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        setupButton(0x7f100863, flag);
        findViewById(0x7f100849).setVisibility(4);
        findViewById(0x7f100850).setVisibility(4);
        if (isUserViewingTheirOwnDetails)
        {
            i = 0x7f070b9b;
        } else
        {
            i = 0x7f070b9c;
        }
        setTitle(i);
        hideAndShowFavoriteButton();
    }

    public String getTrackingEventName()
    {
        return "UserProfile";
    }

    protected void hideAndShowFavoriteButton()
    {
        byte byte0 = 8;
        View view = findViewById(0x7f100846);
        View view1 = findViewById(0x7f100845);
        int i;
        if (!isUserViewingTheirOwnDetails && isUserBeingFollowed)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (!isUserViewingTheirOwnDetails && !isUserBeingFollowed)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view1.setVisibility(i);
        view.setOnClickListener(this);
        view1.setOnClickListener(this);
        view = scrollViewSpacer;
        if (isUserViewingTheirOwnDetails)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        view.setVisibility(i);
    }

    protected boolean initUIState()
    {
        feedbackStarImageView.setVisibility(4);
        setupView(0x7f100848, false);
        setupButton(0x7f100863, false);
        setupView(0x7f100847, true);
        findViewById(0x7f100849).setVisibility(4);
        findViewById(0x7f100850).setVisibility(4);
        setTitle(0x7f070b99);
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if ((requireSignIn || TextUtils.isEmpty(userId)) && authentication == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
            return false;
        } else
        {
            fillUIDetails();
            return true;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   4: 76
    //                   65: 37
    //                   77: 56;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        if (j == -1)
        {
            fillUIDetails();
            getUserProfile();
            return;
        } else
        {
            finish();
            return;
        }
_L4:
        if (j == -1 && !TextUtils.isEmpty(userId))
        {
            askQuestion();
            return;
        }
          goto _L1
_L2:
        followedEntityDataManager.followUser(userId, userContextDataManager.getCurrentCountry().getSiteGlobalId());
        return;
    }

    public void onClick(View view)
    {
        if (networkAvailable()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (view.getId())
        {
        case 2131757124: 
        case 2131757129: 
        case 2131757130: 
        case 2131757131: 
        case 2131757132: 
        case 2131757133: 
        case 2131757134: 
        case 2131757135: 
        case 2131757136: 
        case 2131757137: 
        case 2131757138: 
        case 2131757151: 
        case 2131757152: 
        case 2131757154: 
        default:
            return;

        case 2131757123: 
            if (!TextUtils.isEmpty(userId))
            {
                askQuestion();
                return;
            }
            break;

        case 2131757140: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.POSITIVE, Integer.valueOf(1));
            return;

        case 2131757141: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.POSITIVE, Integer.valueOf(6));
            return;

        case 2131757142: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.POSITIVE, Integer.valueOf(12));
            return;

        case 2131757144: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.NEUTRAL, Integer.valueOf(1));
            return;

        case 2131757145: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.NEUTRAL, Integer.valueOf(6));
            return;

        case 2131757146: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.NEUTRAL, Integer.valueOf(12));
            return;

        case 2131757148: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.NEGATIVE, Integer.valueOf(1));
            return;

        case 2131757149: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.NEGATIVE, Integer.valueOf(6));
            return;

        case 2131757150: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.NEGATIVE, Integer.valueOf(12));
            return;

        case 2131757139: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.POSITIVE, null);
            return;

        case 2131757143: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.NEUTRAL, null);
            return;

        case 2131757147: 
            ViewFeedbackActivity.StartActivity(this, userId, ViewFeedbackActivity.TabChoice.AS_SELLER, ViewFeedbackActivity.TypeChoice.NEGATIVE, null);
            return;

        case 2131757128: 
            ViewFeedbackActivity.StartActivity(this, userId);
            return;

        case 2131757127: 
            otherItems();
            return;

        case 2131757155: 
            ItemViewSellersLegalInfoActivity.StartActivity(this, viewData);
            return;

        case 2131757153: 
            (new GivingWorksFavoritesFragment()).show(getFragmentManager(), "select_charity_fragment");
            return;

        case 2131757125: 
            if (!MyApp.getPrefs().isSignedIn())
            {
                startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 4);
                return;
            } else
            {
                followedEntityDataManager.followUser(userId, userContextDataManager.getCurrentCountry().getSiteGlobalId());
                return;
            }

        case 2131757126: 
            view = MyApp.getPrefs().getAuthentication();
            followedEntityDataManager.deleteFollow(FollowType.USER, userId, ((Authentication) (view)).iafToken);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030277);
        viewItemDmObserver = new ViewItemDataManagerObserver();
        followedEntityDmObserver = new FollowedEntityDataManagerObserver();
        bundle = getIntent();
        userId = bundle.getStringExtra("user_id");
        isBuyer = bundle.getBooleanExtra("isBuyer", false);
        isSeller = bundle.getBooleanExtra("isSeller", false);
        ratingStar = bundle.getStringExtra("rating_star");
        hasOtherItems = bundle.getBooleanExtra("is_sellers_other_item", false);
        viewData = (ViewItemViewData)getIntent().getParcelableExtra("view_item_view_data");
        requireSignIn = bundle.getBooleanExtra("requiresSignIn", false);
        searchOtherCountries = bundle.getBooleanExtra("search_other_countries", false);
        if (bundle.getIntExtra("noti_type_id", -1) != -1)
        {
            ServiceStarter.startUpdateNotificationCacheService(this, com.ebay.common.model.mdns.NotificationPreference.EventType.BUCKSEXP.name(), null);
        }
        userProfileImageView = (RemoteImageView)findViewById(0x7f10083d);
        feedbackCountTextView = (TextView)findViewById(0x7f100840);
        userNameTextView = (TextView)findViewById(0x7f10083f);
        feedbackStarImageView = (ImageView)findViewById(0x7f100841);
        scrollViewSpacer = findViewById(0x7f100844);
        buttonLayout = findViewById(0x7f100524);
        if (initUIState())
        {
            getUserProfile();
        }
        initDataManagers();
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return (new android.support.v7.app.AlertDialog.Builder(this)).setTitle(0x7f070130).setMessage(0x7f0706e9).setNegativeButton(0x7f0701cc, null).setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

                final UserDetailActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    MyApp.signOut(false);
                    eBay.Restart(UserDetailActivity.this);
                    finish();
                }

            
            {
                this$0 = UserDetailActivity.this;
                super();
            }
            }).create();
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        userContextDataManager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        followedEntityDataManager = (FollowedEntityDataManager)datamanagercontainer.initialize(FollowedEntityDataManager.KEY, followedEntityDmObserver);
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (!isUserViewingTheirOwnDetails && authentication != null)
        {
            followedEntityDataManager.getFollows(authentication.iafToken, userContextDataManager.getCurrentCountry().getSite(), false);
        }
        if (viewData != null && viewData.keyParams != null)
        {
            viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, viewItemDmObserver);
            viewItemDataManager.loadData(viewItemDmObserver, viewData);
        }
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        bundle = buttonLayout.getViewTreeObserver();
        if (bundle.isAlive())
        {
            bundle.addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final UserDetailActivity this$0;

                public void onGlobalLayout()
                {
                    buttonLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    android.view.ViewGroup.LayoutParams layoutparams = scrollViewSpacer.getLayoutParams();
                    layoutparams.height = buttonLayout.getHeight();
                    scrollViewSpacer.setLayoutParams(layoutparams);
                }

            
            {
                this$0 = UserDetailActivity.this;
                super();
            }
            });
        }
    }

    protected void onResume()
    {
        super.onResume();
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        NotificationTrackingUtil.addNotificationTracking(this, trackingdata, getIntent(), com.ebay.common.model.mdns.NotificationPreference.EventType.BUCKSEXP.name());
        trackingdata.addSourceIdentification(getIntent());
        trackingdata.send(this);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (!isFinishing())
        {
            if (i == 1)
            {
                userProfileLoading = false;
            }
            if ((fwloader instanceof FwNetLoader) && !((FwNetLoader)fwloader).isError())
            {
                switch (i)
                {
                case 2: // '\002'
                default:
                    return;

                case 1: // '\001'
                    onGetUserProfileComplete((GetUserProfileNetLoader)fwloader);
                    return;

                case 3: // '\003'
                    onAddMessageComplete((AddMemberMessageAAQNetLoader)fwloader);
                    break;
                }
                return;
            }
            if (fwloader instanceof EbaySimpleNetLoader)
            {
                EbaySimpleNetLoader ebaysimplenetloader = (EbaySimpleNetLoader)fwloader;
                if (Util.checkForIAFTokenError(ebaysimplenetloader))
                {
                    handleIafTokenExpiration();
                    return;
                }
                if (!Util.hasNetwork())
                {
                    if (i == 3)
                    {
                        handleAddMessageError(ebaysimplenetloader, getString(0x7f0708c7), ((AddMemberMessageAAQNetLoader)fwloader).getBody(), ((AddMemberMessageAAQNetLoader)fwloader).getPictureUrls());
                        return;
                    } else
                    {
                        Toast.makeText(this, getString(0x7f07024c), 1).show();
                        finish();
                        return;
                    }
                }
                fwloader = ebaysimplenetloader.getServiceErrorsAndWarnings();
                if (!handleEbayResponseErrors(fwloader))
                {
                    if (i == 1)
                    {
                        if (GetUserProfileResponse.isInvalidUserId(fwloader))
                        {
                            MyApp.signOut(false);
                        }
                        Toast.makeText(this, 0x7f070b9a, 1).show();
                        finish();
                        return;
                    }
                    if (i == 3)
                    {
                        handleAddMessageError(ebaysimplenetloader, getString(0x7f0708c7));
                        return;
                    }
                }
            }
        }
    }

    final void showUserProfile()
    {
        byte byte0 = 8;
        if (userProfile != null)
        {
            View view;
            boolean flag;
            int i;
            if (userProfile.ratingItemAsDescribed != null && userProfile.ratingItemAsDescribed.ratingCount != -1L || userProfile.ratingCommunication != null && userProfile.ratingCommunication.ratingCount != -1L || userProfile.ratingShippingAndHandlingCharges != null && userProfile.ratingShippingAndHandlingCharges.ratingCount != -1L || userProfile.ratingShippingTime != null && userProfile.ratingShippingTime.ratingCount != -1L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (userProfile.bIsTopRatedSeller && MyApp.getDeviceConfiguration().isTopRatedSellerEnabled())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            view = findViewById(0x7f10083c);
            if (i != 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
            if (TextUtils.isEmpty(ratingStar))
            {
                feedbackStarImageView.setVisibility(4);
            } else
            {
                Util.SetRatingStar(feedbackStarImageView, ratingStar);
            }
            view = findViewById(0x7f100849);
            i = byte0;
            if (flag)
            {
                i = 0;
            }
            view.setVisibility(i);
            findViewById(0x7f100850).setVisibility(0);
            findViewById(0x7f100853).setOnClickListener(this);
            findViewById(0x7f100857).setOnClickListener(this);
            findViewById(0x7f10085b).setOnClickListener(this);
            feedbackCountTextView.setText(Integer.toString(userProfile.feedbackScore));
            setRating(userProfile.ratingItemAsDescribed, 0x7f10084c, getString(0x7f070489));
            setRating(userProfile.ratingCommunication, 0x7f10084d, getString(0x7f070256));
            setRating(userProfile.ratingShippingTime, 0x7f10084e, getString(0x7f070a79));
            setRating(userProfile.ratingShippingAndHandlingCharges, 0x7f10084f, getString(0x7f070a70));
            setCell(0x7f100854, userProfile.positiveFeedbackCount[0]);
            setCell(0x7f100855, userProfile.positiveFeedbackCount[1]);
            setCell(0x7f100856, userProfile.positiveFeedbackCount[2]);
            setCell(0x7f100858, userProfile.neutralFeedbackCount[0]);
            setCell(0x7f100859, userProfile.neutralFeedbackCount[1]);
            setCell(0x7f10085a, userProfile.neutralFeedbackCount[2]);
            setCell(0x7f10085c, userProfile.negativeFeedbackCount[0]);
            setCell(0x7f10085d, userProfile.negativeFeedbackCount[1]);
            setCell(0x7f10085e, userProfile.negativeFeedbackCount[2]);
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
            return;
        } else
        {
            finish();
            return;
        }
    }

}
