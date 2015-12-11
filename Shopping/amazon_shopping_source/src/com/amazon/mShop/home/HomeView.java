// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdSize;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.DelayedInitView;
import com.amazon.mShop.actionBar.ActionBarIconController;
import com.amazon.mShop.contentprovider.WidgetContentProvider;
import com.amazon.mShop.contentprovider.WidgetDatabaseHelper;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.control.home.HomeSubscriber;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.error.AmazonErrorInfo;
import com.amazon.mShop.feature.WeblabCsmMetricsImpl;
import com.amazon.mShop.mobileads.AdsHelper;
import com.amazon.mShop.mobileads.MobileAdsLayout;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.ClickedSlotsMetricsObserver;
import com.amazon.mShop.net.ExposedSlotsMetricsObserver;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.BitmapUtil;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.DBException;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import com.amazon.shopapp.voice.mshop.MShopVoiceModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.home:
//            GatewayActivity, PromoSlotView, HomeShovelerView

public class HomeView extends LinearLayout
    implements com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener, DelayedInitView, ActionBarIconController, HomeSubscriber, UserListener
{
    private static final class AdLoadingState extends Enum
    {

        private static final AdLoadingState $VALUES[];
        public static final AdLoadingState FAILURE;
        public static final AdLoadingState INIT;
        public static final AdLoadingState LOADING;
        public static final AdLoadingState SUCCESS;

        public static AdLoadingState valueOf(String s)
        {
            return (AdLoadingState)Enum.valueOf(com/amazon/mShop/home/HomeView$AdLoadingState, s);
        }

        public static AdLoadingState[] values()
        {
            return (AdLoadingState[])$VALUES.clone();
        }

        static 
        {
            INIT = new AdLoadingState("INIT", 0);
            LOADING = new AdLoadingState("LOADING", 1);
            SUCCESS = new AdLoadingState("SUCCESS", 2);
            FAILURE = new AdLoadingState("FAILURE", 3);
            $VALUES = (new AdLoadingState[] {
                INIT, LOADING, SUCCESS, FAILURE
            });
        }

        private AdLoadingState(String s, int i)
        {
            super(s, i);
        }
    }


    public static final Map ACTION_NAME_DICTIONARY;
    public static final Map ACTION_TYPE_DICTIONARY;
    private final GatewayActivity mActivity;
    private AdSize mAdSize;
    private boolean mApplicationStarted;
    private Bitmap mBmpLoading;
    private int mCurrentOrientation;
    private View mHomeBottomBanner;
    private HomeController mHomeController;
    private View mHomeStrenchFrame;
    private boolean mIsHomeViewJustCreated;
    private MobileAdsLayout mLeftAd;
    private FrameLayout mLeftAdLayout;
    private AdLoadingState mLeftAdLoadingState;
    private com.amazon.device.ads.AdProperties.AdType mLeftAdType;
    private TextView mLoginLeftMessage;
    private View mLoginOrYourAccountButton;
    private TextView mLoginRightMessage;
    private boolean mNeedInvokeHomeCallStarted;
    private PageMetricsObserver mPageMetricsCriticalFeatureObserver;
    private PageMetricsObserver mPageMetricsObserver;
    private PageMetricsObserver mPageMetricsRefreshCriticalFeatureObserver;
    private PromoSlotView mPromoSlotImage0;
    private PromoSlotView mPromoSlotImage1;
    private MobileAdsLayout mRightAd;
    private FrameLayout mRightAdLayout;
    private AdLoadingState mRightAdLoadingState;
    private com.amazon.device.ads.AdProperties.AdType mRightAdType;
    private TextView mShopByDepartmentLabel;
    private HomeShovelerView mShoveler0;
    private HomeShovelerView mShoveler1;
    private ImageView mShovelerEmptyPlaceHolder;

    public HomeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mHomeController = HomeController.getInstance();
        mBmpLoading = null;
        mNeedInvokeHomeCallStarted = true;
        mApplicationStarted = true;
        mActivity = (GatewayActivity)context;
        mIsHomeViewJustCreated = true;
        mHomeController.addSubscriberAtFirstPosition(this);
        mPageMetricsObserver = new PageMetricsObserver("Home");
        mPageMetricsObserver.startForObject(mHomeController.getClass().getSimpleName());
        mPageMetricsCriticalFeatureObserver = new PageMetricsObserver("HomeCriticalFeature");
        mPageMetricsCriticalFeatureObserver.startForObject(mHomeController.getClass().getSimpleName());
        mPageMetricsRefreshCriticalFeatureObserver = new PageMetricsObserver("HomeRefreshCriticalFeature");
        mPageMetricsRefreshCriticalFeatureObserver.startForObject(mHomeController.getClass().getSimpleName());
    }

    private void addWeblabCsmMetrics(boolean flag)
    {
        if (flag && !ActivityUtils.isDebugSettingEnabled("debugHTMLGateway"))
        {
            mPageMetricsRefreshCriticalFeatureObserver.setEventListener(new WeblabCsmMetricsImpl(mHomeController.getRequestId(), "GatewayMShop", "pageComponent", "Android_ShopAppHTMLGateway", "cf"));
        }
    }

    public static void forwardProductDetailsView(Context context, HomeItem homeitem, ClickStreamTag clickstreamtag, byte abyte0[])
    {
        while (homeitem == null || context == null || !(context instanceof AmazonActivity)) 
        {
            return;
        }
        homeitem = new ProductController(homeitem);
        if (!Util.isEmpty(abyte0))
        {
            homeitem.setThumbnail(abyte0);
        }
        if (clickstreamtag != null && !Util.isEmpty(clickstreamtag.getTag()))
        {
            homeitem.setClickStreamTag(clickstreamtag);
        }
        ((AmazonActivity)context).forward(homeitem);
    }

    private AdSize getAdSize()
    {
        if (mAdSize == null)
        {
            mAdSize = new AdSize(getResources().getInteger(com.amazon.mShop.android.lib.R.integer.config_HomePromoAdSizeWidth), getResources().getInteger(com.amazon.mShop.android.lib.R.integer.config_HomePromoAdSizeHeight));
        }
        return mAdSize;
    }

    private Bitmap getBmpLoading()
    {
        if (mBmpLoading == null)
        {
            try
            {
                mBmpLoading = BitmapUtil.loadImage(getResources(), com.amazon.mShop.android.lib.R.drawable.promo_loading, true, true, true, true);
            }
            catch (OutOfMemoryError outofmemoryerror)
            {
                System.gc();
            }
        }
        return mBmpLoading;
    }

    private int getCurrentOrientation()
    {
        return mCurrentOrientation;
    }

    public static int getPromoSlotHeight()
    {
        return ((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext()).getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.home_promo_slot_image_view_height);
    }

    public static int getPromoSlotWidth()
    {
        Resources resources = ((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext()).getResources();
        int i = resources.getInteger(com.amazon.mShop.android.lib.R.integer.config_HomePromoAspectRatioWidth);
        int j = resources.getInteger(com.amazon.mShop.android.lib.R.integer.config_HomePromoAspectRatioHeight);
        return (getPromoSlotHeight() * i) / j;
    }

    private void handlerError(Exception exception)
    {
        onCancelled();
        mHomeController.clearException();
        com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final HomeView this$0;

            public void onActionButtonClick(int i)
            {
                mShoveler0.clear();
                mShoveler1.clear();
                mPageMetricsRefreshCriticalFeatureObserver = new PageMetricsObserver("HomeRefreshCriticalFeature");
                mPageMetricsRefreshCriticalFeatureObserver.startForObject(mHomeController.getClass().getSimpleName());
                HomeController.getInstance().phoneHome(true, true);
            }

            
            {
                this$0 = HomeView.this;
                super();
            }
        };
        AmazonErrorUtils.reportMShopServerError(mActivity, amazonerrorboxactionlistener, this, exception);
    }

    private void initAdState()
    {
        mLeftAdLoadingState = AdLoadingState.INIT;
        mRightAdLoadingState = AdLoadingState.INIT;
    }

    private void loadAdForPromoSlot(final PromoSlotView promoSlot, final FrameLayout adsLayout)
    {
        final ImageView promoLoading;
        int i;
        int j;
        adsLayout.setVisibility(0);
        adsLayout.removeAllViews();
        promoSlot.setVisibility(8);
        i = getPromoSlotHeight();
        j = getPromoSlotWidth();
        promoLoading = new ImageView(mActivity);
        promoLoading.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, i, 17F));
        int k = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.promo_loading_padding);
        promoLoading.setPadding(0, k, 0, k);
        promoLoading.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        promoLoading.setImageBitmap(getBmpLoading());
        adsLayout.addView(promoLoading);
        if (adsLayout != mLeftAdLayout) goto _L2; else goto _L1
_L1:
        String s;
        MobileAdsLayout mobileadslayout;
        mLeftAd = new MobileAdsLayout(mActivity, getAdSize());
        mLeftAdLoadingState = AdLoadingState.LOADING;
        mobileadslayout = mLeftAd;
        s = "GW_PROMO_LEFT";
_L6:
        mobileadslayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(j, i, 17));
        adsLayout.addView(mobileadslayout);
        promoSlot = new com.amazon.mShop.mobileads.MobileAdsLayout.MobileAdsDefaultListener() {

            final HomeView this$0;
            final FrameLayout val$adsLayout;
            final ImageView val$promoLoading;
            final PromoSlotView val$promoSlot;

            public void onAdFailedToLoad(Ad ad, AdError aderror)
            {
                adsLayout.setVisibility(8);
                promoSlot.setVisibility(0);
                if (ad != mLeftAd) goto _L2; else goto _L1
_L1:
                ad = mHomeController.getPromoSlot0();
                if (ad != null)
                {
                    mPromoSlotImage0.update(ad, mPageMetricsObserver);
                }
                mLeftAdLoadingState = AdLoadingState.FAILURE;
_L4:
                mPageMetricsObserver.completeForObject(com/amazon/mShop/mobileads/MobileAdsLayout.getSimpleName());
                return;
_L2:
                if (ad == mRightAd)
                {
                    ad = mHomeController.getPromoSlot1();
                    if (ad != null)
                    {
                        mPromoSlotImage1.update(ad, mPageMetricsObserver);
                    }
                    mRightAdLoadingState = AdLoadingState.FAILURE;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void onAdLoaded(Ad ad, AdProperties adproperties)
            {
                adsLayout.removeView(promoLoading);
                if (ad != mLeftAd) goto _L2; else goto _L1
_L1:
                mLeftAdType = adproperties.getAdType();
                mLeftAdLoadingState = AdLoadingState.SUCCESS;
_L4:
                mPageMetricsObserver.completeForObject(com/amazon/mShop/mobileads/MobileAdsLayout.getSimpleName());
                return;
_L2:
                if (ad == mRightAd)
                {
                    mRightAdType = adproperties.getAdType();
                    mRightAdLoadingState = AdLoadingState.SUCCESS;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = HomeView.this;
                adsLayout = framelayout;
                promoSlot = promoslotview;
                promoLoading = imageview;
                super();
            }
        };
        mPageMetricsObserver.startForObject(com/amazon/mShop/mobileads/MobileAdsLayout.getSimpleName());
        mobileadslayout.load(promoSlot, s);
_L4:
        return;
_L2:
        if (adsLayout != mRightAdLayout) goto _L4; else goto _L3
_L3:
        mRightAd = new MobileAdsLayout(mActivity, getAdSize());
        mRightAdLoadingState = AdLoadingState.LOADING;
        mobileadslayout = mRightAd;
        s = "GW_PROMO_RIGHT";
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void loadAds()
    {
        if (AdsHelper.isAdsEnabled())
        {
            if (ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasMobileAdsOnLeftPromoSlot))
            {
                loadAdForPromoSlot(mPromoSlotImage0, mLeftAdLayout);
            } else
            {
                mLeftAdLayout.setVisibility(8);
                mPromoSlotImage0.setVisibility(0);
            }
            loadAdForPromoSlot(mPromoSlotImage1, mRightAdLayout);
            return;
        } else
        {
            mLeftAdLayout.setVisibility(8);
            mRightAdLayout.setVisibility(8);
            mPromoSlotImage0.setVisibility(0);
            mPromoSlotImage1.setVisibility(0);
            return;
        }
    }

    public static void postClickedSlotToken(String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        (new ClickedSlotsMetricsObserver()).postSlotTokens(arraylist);
    }

    private void setCurrentOrientation(int i)
    {
        mCurrentOrientation = i;
    }

    private void setDefaultShoveler()
    {
        HomeShovelerView homeshovelerview = mShoveler0;
        byte byte0;
        if (mHomeController.getHomeShoveler0() == null)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        homeshovelerview.setVisibility(byte0);
        homeshovelerview = mShoveler1;
        if (mHomeController.getHomeShoveler1() == null)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        homeshovelerview.setVisibility(byte0);
        if (mHomeController.getHomeShoveler0() == null && mHomeController.getHomeShoveler1() == null)
        {
            mShovelerEmptyPlaceHolder.setVisibility(0);
            mHomeBottomBanner.setVisibility(8);
            mHomeStrenchFrame.setVisibility(8);
        }
    }

    private void setupVoiceSearch()
    {
        View view;
        int i;
        try
        {
            view = findViewById(com.amazon.mShop.android.lib.R.id.home_shop_by_department_view);
        }
        catch (Exception exception)
        {
            Log.e("HomeView", "Failed to setup voice search", exception);
            return;
        }
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (MShopVoiceModule.getInstance().shopByDepartmentEnabled())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void updateButtonsOnUserStatusChanged(User user)
    {
        if (user == null)
        {
            user = getContext().getApplicationContext();
            if (SSOUtil.isSSOSupported(user) && SSOUtil.hasAmazonAccount())
            {
                updateYourAccountButton(new User("", SSOUtil.peekCustomerAttribute(user, "com.amazon.dcp.sso.property.username"), false, false, null, Boolean.valueOf(false), null));
                return;
            } else
            {
                updateLoginButton();
                return;
            }
        } else
        {
            updateYourAccountButton(user);
            return;
        }
    }

    private void updateLoginButton()
    {
        mLoginLeftMessage.setText(com.amazon.mShop.android.lib.R.string.home_title);
        mLoginRightMessage.setText(com.amazon.mShop.android.lib.R.string.home_sign_in);
        mLoginOrYourAccountButton.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeView this$0;

            public void onClick(View view)
            {
                if (SSOUtil.isSSOSupported(getContext()))
                {
                    SSOUtil.getCurrentIdentityType().handleSSOLogin(mActivity, true, false, false, "gw");
                    return;
                } else
                {
                    ActivityUtils.startLoginActivity(mActivity, "gw", true, "hm_si", new int[0]);
                    return;
                }
            }

            
            {
                this$0 = HomeView.this;
                super();
            }
        });
        mLoginOrYourAccountButton.setVisibility(0);
    }

    private void updatePromoSlot0()
    {
        PromoSlot promoslot = mHomeController.getPromoSlot0();
        if (promoslot == null)
        {
            mPromoSlotImage0.setDefaultPromoSlot();
        } else
        if (AdsHelper.isAdsEnabled())
        {
            if (AdLoadingState.FAILURE.equals(mLeftAdLoadingState) || !ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasMobileAdsOnLeftPromoSlot))
            {
                mPromoSlotImage0.update(promoslot, mPageMetricsObserver);
                return;
            }
        } else
        {
            mPromoSlotImage0.update(promoslot, mPageMetricsObserver);
            return;
        }
    }

    private void updatePromoSlot1()
    {
        PromoSlot promoslot = mHomeController.getPromoSlot1();
        if (promoslot == null)
        {
            mPromoSlotImage1.setDefaultPromoSlot();
        } else
        if (AdsHelper.isAdsEnabled())
        {
            if (AdLoadingState.FAILURE.equals(mRightAdLoadingState))
            {
                mPromoSlotImage1.update(promoslot, mPageMetricsObserver);
                return;
            }
        } else
        {
            mPromoSlotImage1.update(promoslot, mPageMetricsObserver);
            return;
        }
    }

    private void updatePromoSlots()
    {
        updatePromoSlot0();
        updatePromoSlot1();
    }

    private void updateShopByDepartmentLabel()
    {
        String s = getResources().getString(com.amazon.mShop.android.lib.R.string.categroy_browse_department);
        String s1 = (new StringBuilder()).append(getResources().getString(com.amazon.mShop.android.lib.R.string.shop_by_text)).append(s).toString();
        SpannableString spannablestring = new SpannableString(s1);
        if ("ja_JP".equals(AppLocale.getInstance().getCurrentLocaleName()))
        {
            mShopByDepartmentLabel.setGravity(21);
        } else
        {
            int i = s1.indexOf(s);
            int j = s1.length();
            spannablestring.setSpan(new ForegroundColorSpan(getResources().getColor(com.amazon.mShop.android.lib.R.color.action_bar_shop_by_department_bold_text_color)), i, j, 33);
            spannablestring.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.gno_category_browse_department_size), false), i, j, 33);
            spannablestring.setSpan(new StyleSpan(1), i, j, 33);
        }
        mShopByDepartmentLabel.setText(spannablestring);
    }

    private void updateYourAccountButton(User user)
    {
        String s = getResources().getString(com.amazon.mShop.android.lib.R.string.home_sign_in_message_welcome);
        SpannableString spannablestring = new SpannableString(String.format(s, new Object[] {
            user.getFullName()
        }));
        int i = s.indexOf("%1$s");
        if (i != -1)
        {
            int j = user.getFullName().length();
            spannablestring.setSpan(new ForegroundColorSpan(getResources().getColor(com.amazon.mShop.android.lib.R.color.amazon_gold)), i, i + j, 33);
        }
        mLoginLeftMessage.setText(spannablestring);
        mLoginRightMessage.setText(com.amazon.mShop.android.lib.R.string.home_sign_in_message_youraccount);
        mLoginOrYourAccountButton.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeView this$0;

            public void onClick(View view)
            {
                ActivityUtils.startYourAccountActivity(mActivity);
                RefMarkerObserver.logRefMarker("hm_ya");
            }

            
            {
                this$0 = HomeView.this;
                super();
            }
        });
        mLoginOrYourAccountButton.setVisibility(0);
    }

    public void destroy()
    {
        if (mLeftAd != null)
        {
            mLeftAd.onDetachedFromWindow();
            mLeftAd = null;
        }
        if (mRightAd != null)
        {
            mRightAd.onDetachedFromWindow();
            mRightAd = null;
        }
        if (mLeftAd != null && mRightAd != null)
        {
            onDetachedFromWindow();
        }
    }

    public void handleConfigurationChanged(Configuration configuration)
    {
        if (AdsHelper.isAdsEnabled() && getCurrentOrientation() != configuration.orientation)
        {
            setCurrentOrientation(configuration.orientation);
            if (mLeftAdType != null && (mLeftAdType == com.amazon.device.ads.AdProperties.AdType.MRAID_1 || mLeftAdType == com.amazon.device.ads.AdProperties.AdType.MRAID_2) || mLeftAdLoadingState == AdLoadingState.LOADING)
            {
                loadAdForPromoSlot(mPromoSlotImage0, mLeftAdLayout);
            }
            if (mRightAdType != null && (mRightAdType == com.amazon.device.ads.AdProperties.AdType.MRAID_1 || mRightAdType == com.amazon.device.ads.AdProperties.AdType.MRAID_2) || mRightAdLoadingState == AdLoadingState.LOADING)
            {
                loadAdForPromoSlot(mPromoSlotImage1, mRightAdLayout);
            }
        }
    }

    public void insertErrorBox(View view)
    {
        View view1 = findViewById(com.amazon.mShop.android.lib.R.id.home_error_box_separator);
        int i = indexOfChild(view1);
        if (i >= 0)
        {
            addView(view, i);
            view1.setVisibility(0);
            return;
        } else
        {
            Log.e("HomeView", "The home content scroller is not in place");
            return;
        }
    }

    public boolean isActionBarSearchIconFadeable()
    {
        return true;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        User.addUserListener(this);
        mHomeController.addSubscriberAtFirstPosition(this);
        mActivity.registerConfigChangedListener(this);
    }

    public void onAvailableCountReceived(int i)
    {
    }

    public void onCancelled()
    {
        mNeedInvokeHomeCallStarted = true;
        mShoveler0.clear();
        mShoveler1.clear();
        if (!mPageMetricsObserver.isFinished())
        {
            mPageMetricsObserver.onCancelled();
        }
        if (!mPageMetricsCriticalFeatureObserver.isFinished())
        {
            mPageMetricsCriticalFeatureObserver.onCancelled();
        }
        if (!mPageMetricsRefreshCriticalFeatureObserver.isFinished())
        {
            mPageMetricsRefreshCriticalFeatureObserver.onCancelled();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        User.removeUserListener(this);
        mHomeController.removeSubscriber(this);
        mActivity.unregisterConfigChangedListener(this);
        if (!mPageMetricsObserver.isFinished())
        {
            mPageMetricsObserver.onCancelled();
        }
        if (!mPageMetricsCriticalFeatureObserver.isFinished())
        {
            mPageMetricsCriticalFeatureObserver.onCancelled();
        }
        if (!mPageMetricsRefreshCriticalFeatureObserver.isFinished())
        {
            mPageMetricsRefreshCriticalFeatureObserver.onCancelled();
        }
        mLeftAd = null;
        mRightAd = null;
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        handlerError(exception);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mLoginOrYourAccountButton = findViewById(com.amazon.mShop.android.lib.R.id.home_login_or_your_account_button);
        mLoginLeftMessage = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.home_sign_in_left_message);
        mLoginRightMessage = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.home_sign_in_right_message);
        mShopByDepartmentLabel = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.home_shop_by_department_label);
        updateShopByDepartmentLabel();
        setupVoiceSearch();
        mLeftAdLayout = (FrameLayout)findViewById(com.amazon.mShop.android.lib.R.id.home_mobileads_banner_left);
        mRightAdLayout = (FrameLayout)findViewById(com.amazon.mShop.android.lib.R.id.home_mobileads_banner_right);
        mShovelerEmptyPlaceHolder = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.shoveler_view_empty_placeholder);
        mShovelerEmptyPlaceHolder.setImageBitmap(BitmapUtil.loadImage(getResources(), com.amazon.mShop.android.lib.R.drawable.home_shoveler_placeholder, true, true, true, true));
        mShoveler0 = (HomeShovelerView)findViewById(com.amazon.mShop.android.lib.R.id.home_shoveler0);
        mShoveler1 = (HomeShovelerView)findViewById(com.amazon.mShop.android.lib.R.id.home_shoveler1);
        mPromoSlotImage0 = (PromoSlotView)findViewById(com.amazon.mShop.android.lib.R.id.promo_slot0);
        mPromoSlotImage1 = (PromoSlotView)findViewById(com.amazon.mShop.android.lib.R.id.promo_slot1);
        mShoveler0.setMoreLinkRefMarker("hm_c0_mr");
        mShoveler0.setHomeCarouselArg("hm_c0_%1$d");
        mShoveler1.setMoreLinkRefMarker("hm_c1_mr");
        mShoveler1.setHomeCarouselArg("hm_c1_%1$d");
        mPromoSlotImage0.setDefaultPromoSlotInfo(com.amazon.mShop.android.lib.R.drawable.promo_defaultslot0, getResources().getString(com.amazon.mShop.android.lib.R.string.home_promo0_action_android), getResources().getString(com.amazon.mShop.android.lib.R.string.home_promo0_param_android), "hm_p0");
        mPromoSlotImage1.setDefaultPromoSlotInfo(com.amazon.mShop.android.lib.R.drawable.promo_defaultslot1, getResources().getString(com.amazon.mShop.android.lib.R.string.home_promo1_action_android), getResources().getString(com.amazon.mShop.android.lib.R.string.home_promo1_param_android), "hm_p1");
        mHomeBottomBanner = findViewById(com.amazon.mShop.android.lib.R.id.home_bottom_banner);
        mHomeStrenchFrame = findViewById(com.amazon.mShop.android.lib.R.id.home_strentch_frame);
        setCurrentOrientation(getResources().getConfiguration().orientation);
    }

    public void onHomeCallStarted()
    {
        mActivity.runOnUiThread(new Runnable() {

            final HomeView this$0;
            final View val$view;

            public void run()
            {
                if (mActivity.getCurrentView() == view && mActivity.getCurrentErrorInfo() != null && mActivity.getCurrentErrorInfo().getErrorId() == 4)
                {
                    mActivity.dismissErrorBox();
                }
                if (!mNeedInvokeHomeCallStarted)
                {
                    return;
                } else
                {
                    mNeedInvokeHomeCallStarted = false;
                    mPromoSlotImage0.clear();
                    mPromoSlotImage1.clear();
                    mShovelerEmptyPlaceHolder.setVisibility(8);
                    mHomeBottomBanner.setVisibility(0);
                    mHomeStrenchFrame.setVisibility(0);
                    mShoveler0.setVisibility(0);
                    mShoveler1.setVisibility(0);
                    loadAds();
                    mShoveler0.clear();
                    mShoveler1.clear();
                    return;
                }
            }

            
            {
                this$0 = HomeView.this;
                view = view1;
                super();
            }
        });
    }

    public void onHomeShoveler0Received(final HomeShoveler shoveler)
    {
        if (shoveler == null)
        {
            if (!mPageMetricsCriticalFeatureObserver.isFinished())
            {
                mPageMetricsCriticalFeatureObserver.onCancelled();
            }
            if (!mPageMetricsRefreshCriticalFeatureObserver.isFinished())
            {
                mPageMetricsRefreshCriticalFeatureObserver.onCancelled();
            }
        } else
        {
            mShoveler0.update(shoveler, mPageMetricsObserver, mPageMetricsCriticalFeatureObserver, mPageMetricsRefreshCriticalFeatureObserver, mHomeController.getRequestId());
            if (IdentityType.CENTRAL_SSO_TYPE == SSOUtil.getCurrentIdentityType() && (!User.isLoggedIn() || SSOUtil.hasAmazonAccount()))
            {
                WidgetDatabaseHelper.getInstance(getContext()).postDbOperation(new Runnable() {

                    final HomeView this$0;
                    final HomeShoveler val$shoveler;

                    public void run()
                    {
                        try
                        {
                            WidgetDatabaseHelper.getInstance(mActivity).cleanOldHomeShovelerContent();
                            if (SSOUtil.isSSOSupported(getContext().getApplicationContext()))
                            {
                                WidgetDatabaseHelper.getInstance(mActivity).updateHomeShovelerItems(shoveler);
                            }
                            return;
                        }
                        catch (DBException dbexception)
                        {
                            Log.i("HomeView", dbexception.getMessage());
                        }
                    }

            
            {
                this$0 = HomeView.this;
                shoveler = homeshoveler;
                super();
            }
                });
            }
            if (!mPageMetricsCriticalFeatureObserver.isFinished())
            {
                mPageMetricsCriticalFeatureObserver.completeForObject(mHomeController.getClass().getSimpleName());
            }
            if (!mPageMetricsRefreshCriticalFeatureObserver.isFinished())
            {
                mPageMetricsRefreshCriticalFeatureObserver.completeForObject(mHomeController.getClass().getSimpleName());
                return;
            }
        }
    }

    public void onHomeShoveler1Received(final HomeShoveler shoveler)
    {
        if (shoveler == null)
        {
            if (!mPageMetricsObserver.isFinished())
            {
                mPageMetricsObserver.onCancelled();
            }
        } else
        {
            mShoveler1.update(shoveler, mPageMetricsObserver, null, null, mHomeController.getRequestId());
            if (IdentityType.CENTRAL_SSO_TYPE == SSOUtil.getCurrentIdentityType() && (!User.isLoggedIn() || SSOUtil.hasAmazonAccount()))
            {
                WidgetDatabaseHelper.getInstance(getContext()).postDbOperation(new Runnable() {

                    final HomeView this$0;
                    final HomeShoveler val$shoveler;

                    public void run()
                    {
                        try
                        {
                            if (SSOUtil.isSSOSupported(getContext().getApplicationContext()))
                            {
                                WidgetDatabaseHelper.getInstance(mActivity).updateHomeShovelerItems(shoveler);
                            }
                            WidgetContentProvider.sendContentUpdatedIntent(mActivity);
                            return;
                        }
                        catch (DBException dbexception)
                        {
                            Log.i("HomeView", dbexception.getMessage());
                        }
                    }

            
            {
                this$0 = HomeView.this;
                shoveler = homeshoveler;
                super();
            }
                });
            }
            if (!mPageMetricsObserver.isFinished())
            {
                mPageMetricsObserver.completeForObject(mHomeController.getClass().getSimpleName());
                return;
            }
        }
    }

    public void onNotificationReceived(Notification notification)
    {
        UIUtils.alert(getContext(), notification);
    }

    public void onObjectReceived(Object obj, int i)
    {
    }

    public void onObjectsReceived()
    {
    }

    public void onPageComplete()
    {
        mNeedInvokeHomeCallStarted = true;
        updatePromoSlots();
        setDefaultShoveler();
        if (mPageMetricsObserver != null && !mPageMetricsObserver.isFinished())
        {
            mPageMetricsObserver.completeForObject(mHomeController.getClass().getSimpleName());
        }
        if (mPageMetricsCriticalFeatureObserver != null && !mPageMetricsCriticalFeatureObserver.isFinished())
        {
            mPageMetricsCriticalFeatureObserver.completeForObject(mHomeController.getClass().getSimpleName());
        }
        if (mPageMetricsRefreshCriticalFeatureObserver != null && !mPageMetricsRefreshCriticalFeatureObserver.isFinished())
        {
            mPageMetricsRefreshCriticalFeatureObserver.completeForObject(mHomeController.getClass().getSimpleName());
        }
        if (mActivity == AmazonActivity.getTopMostBaseActivity() && (mActivity.getCurrentView() instanceof HomeView))
        {
            postHomePageImpression();
        }
    }

    public void onPromoSlot0Received(PromoSlot promoslot)
    {
    }

    public void onPromoSlot1Received(PromoSlot promoslot)
    {
    }

    public void onPushViewCompleted()
    {
        updateButtonsOnUserStatusChanged(User.getUser());
        mShopByDepartmentLabel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeView this$0;

            public void onClick(View view)
            {
                ActivityUtils.startCategoryBrowseActivity(getContext());
                if (getResources().getConfiguration().orientation == 2)
                {
                    RefMarkerObserver.logRefMarker("hm_br_land");
                    return;
                } else
                {
                    RefMarkerObserver.logRefMarker("hm_br_port");
                    return;
                }
            }

            
            {
                this$0 = HomeView.this;
                super();
            }
        });
        post(new Runnable() {

            final HomeView this$0;

            public void run()
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (!mIsHomeViewJustCreated)
                {
                    flag = flag1;
                    if (mPageMetricsRefreshCriticalFeatureObserver.isFinished())
                    {
                        mPageMetricsRefreshCriticalFeatureObserver = new PageMetricsObserver("HomeRefreshCriticalFeature");
                        mPageMetricsRefreshCriticalFeatureObserver.startForObject(mHomeController.getClass().getSimpleName());
                        flag = true;
                    }
                }
                mNeedInvokeHomeCallStarted = true;
                mHomeController.setReturnCartItems(true);
                mHomeController.setReturnHomeItems(true);
                boolean flag2 = mHomeController.phoneHome(mApplicationStarted, mApplicationStarted);
                if (!flag2 && flag && !mPageMetricsRefreshCriticalFeatureObserver.isFinished())
                {
                    mPageMetricsRefreshCriticalFeatureObserver.onCancelled();
                }
                addWeblabCsmMetrics(flag2);
                if (mActivity.isHomeActivityJustCreated())
                {
                    onHomeCallStarted();
                }
                mApplicationStarted = false;
                mActivity.setHomeActivityJustCreated(false);
                postHomePageImpression();
            }

            
            {
                this$0 = HomeView.this;
                super();
            }
        });
        if (mHomeController.getException() != null)
        {
            handlerError(mHomeController.getException());
        }
        if (mIsHomeViewJustCreated)
        {
            SSOUtil.handleSigninPrompt(mActivity);
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        try
        {
            super.onWindowFocusChanged(flag);
        }
        catch (Exception exception)
        {
            Log.e("HomeView", "onWindowFocusChanged error", exception);
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        setupVoiceSearch();
    }

    public void postHomePageImpression()
    {
        List list = mHomeController.getHomepageTokens();
        if (list.size() > 0)
        {
            (new ExposedSlotsMetricsObserver()).postSlotTokens(list);
        }
    }

    public void preHomeCallStarted()
    {
        initAdState();
        if (!mIsHomeViewJustCreated)
        {
            if (!mPageMetricsObserver.isFinished())
            {
                mPageMetricsObserver.onCancelled();
            }
            if (!mPageMetricsCriticalFeatureObserver.isFinished())
            {
                mPageMetricsCriticalFeatureObserver.onCancelled();
            }
            return;
        } else
        {
            mIsHomeViewJustCreated = false;
            return;
        }
    }

    public void removeErrorBox(View view)
    {
        removeView(view);
        findViewById(com.amazon.mShop.android.lib.R.id.home_error_box_separator).setVisibility(8);
    }

    public void scollToTop()
    {
        ((ScrollView)findViewById(com.amazon.mShop.android.lib.R.id.home_content_scroller)).scrollTo(0, 0);
    }

    public void userSignedIn(User user)
    {
        updateButtonsOnUserStatusChanged(user);
    }

    public void userSignedOut()
    {
        updateButtonsOnUserStatusChanged(null);
        mShovelerEmptyPlaceHolder.setVisibility(8);
        mHomeBottomBanner.setVisibility(0);
        mHomeStrenchFrame.setVisibility(0);
        mShoveler0.setVisibility(0);
        mShoveler1.setVisibility(0);
        mShoveler0.clear();
        mShoveler1.clear();
    }

    public void userUpdated(User user)
    {
        updateButtonsOnUserStatusChanged(user);
    }

    static 
    {
        ACTION_TYPE_DICTIONARY = new HashMap(11);
        ACTION_NAME_DICTIONARY = new HashMap(11);
        ACTION_TYPE_DICTIONARY.put("do_nothing", Integer.valueOf(0));
        ACTION_TYPE_DICTIONARY.put("deals", Integer.valueOf(2));
        ACTION_TYPE_DICTIONARY.put("wishlist", Integer.valueOf(3));
        ACTION_TYPE_DICTIONARY.put("product", Integer.valueOf(4));
        ACTION_TYPE_DICTIONARY.put("open_url", Integer.valueOf(5));
        ACTION_TYPE_DICTIONARY.put("embed_url", Integer.valueOf(6));
        ACTION_TYPE_DICTIONARY.put("cart", Integer.valueOf(7));
        ACTION_TYPE_DICTIONARY.put("saved_for_later", Integer.valueOf(8));
        ACTION_TYPE_DICTIONARY.put("track_package", Integer.valueOf(9));
        ACTION_TYPE_DICTIONARY.put("your_account", Integer.valueOf(10));
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(0), "do_nothing");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(2), "deals");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(3), "wishlist");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(4), "product");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(5), "open_url");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(6), "embed_url");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(7), "cart");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(8), "saved_for_later");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(9), "track_package");
        ACTION_NAME_DICTIONARY.put(Integer.valueOf(10), "your_account");
    }






/*
    static PageMetricsObserver access$1102(HomeView homeview, PageMetricsObserver pagemetricsobserver)
    {
        homeview.mPageMetricsRefreshCriticalFeatureObserver = pagemetricsobserver;
        return pagemetricsobserver;
    }

*/



/*
    static boolean access$1202(HomeView homeview, boolean flag)
    {
        homeview.mNeedInvokeHomeCallStarted = flag;
        return flag;
    }

*/



/*
    static boolean access$1302(HomeView homeview, boolean flag)
    {
        homeview.mApplicationStarted = flag;
        return flag;
    }

*/












/*
    static AdLoadingState access$402(HomeView homeview, AdLoadingState adloadingstate)
    {
        homeview.mLeftAdLoadingState = adloadingstate;
        return adloadingstate;
    }

*/




/*
    static AdLoadingState access$702(HomeView homeview, AdLoadingState adloadingstate)
    {
        homeview.mRightAdLoadingState = adloadingstate;
        return adloadingstate;
    }

*/


/*
    static com.amazon.device.ads.AdProperties.AdType access$802(HomeView homeview, com.amazon.device.ads.AdProperties.AdType adtype)
    {
        homeview.mLeftAdType = adtype;
        return adtype;
    }

*/


/*
    static com.amazon.device.ads.AdProperties.AdType access$902(HomeView homeview, com.amazon.device.ads.AdProperties.AdType adtype)
    {
        homeview.mRightAdType = adtype;
        return adtype;
    }

*/
}
