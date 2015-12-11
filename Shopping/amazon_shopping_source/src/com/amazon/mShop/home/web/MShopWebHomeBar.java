// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home.web;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.DelayedInitView;
import com.amazon.mShop.actionBar.ActionBarIconController;
import com.amazon.mShop.contentprovider.WidgetContentProvider;
import com.amazon.mShop.contentprovider.WidgetDatabaseHelper;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.control.home.HomeSubscriber;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.DBException;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import com.amazon.shopapp.voice.mshop.MShopVoiceModule;

// Referenced classes of package com.amazon.mShop.home.web:
//            MShopWebGatewayActivity

public class MShopWebHomeBar extends LinearLayout
    implements com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener, DelayedInitView, ActionBarIconController, HomeSubscriber
{

    private final MShopWebGatewayActivity mActivity;
    private boolean mApplicationStarted;
    private HomeController mHomeController;
    private TextView mShopByDepartmentLabel;

    public MShopWebHomeBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mHomeController = HomeController.getInstance();
        mApplicationStarted = true;
        mActivity = (MShopWebGatewayActivity)context;
        mActivity.calcWebviewStartTime();
        mHomeController.addSubscriberAtFirstPosition(this);
    }

    private void setupVoiceSearch()
    {
        View view;
        int i;
        try
        {
            view = findViewById(com.amazon.mShop.android.lib.R.id.web_home_shop_by_department_view);
        }
        catch (Exception exception)
        {
            Log.e("WebHomeBar", "Failed to setup voice search", exception);
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

    public void handleConfigurationChanged(Configuration configuration)
    {
    }

    public boolean isActionBarSearchIconFadeable()
    {
        return true;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mHomeController.addSubscriberAtFirstPosition(this);
        mActivity.registerConfigChangedListener(this);
    }

    public void onAvailableCountReceived(int i)
    {
    }

    public void onCancelled()
    {
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mHomeController.removeSubscriber(this);
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        mHomeController.clearException();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mShopByDepartmentLabel = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.web_home_shop_by_department_label);
        updateShopByDepartmentLabel();
        mShopByDepartmentLabel.setOnClickListener(new android.view.View.OnClickListener() {

            final MShopWebHomeBar this$0;

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
                this$0 = MShopWebHomeBar.this;
                super();
            }
        });
        if (!MShopVoiceModule.getInstance().shopByDepartmentEnabled())
        {
            setupVoiceSearch();
        }
    }

    public void onHomeCallStarted()
    {
    }

    public void onHomeShoveler0Received(final HomeShoveler shoveler)
    {
        while (shoveler == null || IdentityType.CENTRAL_SSO_TYPE != SSOUtil.getCurrentIdentityType() || User.isLoggedIn() && !SSOUtil.hasAmazonAccount()) 
        {
            return;
        }
        WidgetDatabaseHelper.getInstance(getContext()).postDbOperation(new Runnable() {

            final MShopWebHomeBar this$0;
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
                    Log.i("WebHomeBar", dbexception.getMessage());
                }
            }

            
            {
                this$0 = MShopWebHomeBar.this;
                shoveler = homeshoveler;
                super();
            }
        });
    }

    public void onHomeShoveler1Received(final HomeShoveler shoveler)
    {
        while (shoveler == null || IdentityType.CENTRAL_SSO_TYPE != SSOUtil.getCurrentIdentityType() || User.isLoggedIn() && !SSOUtil.hasAmazonAccount()) 
        {
            return;
        }
        WidgetDatabaseHelper.getInstance(getContext()).postDbOperation(new Runnable() {

            final MShopWebHomeBar this$0;
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
                    Log.i("WebHomeBar", dbexception.getMessage());
                }
            }

            
            {
                this$0 = MShopWebHomeBar.this;
                shoveler = homeshoveler;
                super();
            }
        });
    }

    public void onNotificationReceived(Notification notification)
    {
    }

    public void onObjectReceived(Object obj, int i)
    {
    }

    public void onObjectsReceived()
    {
    }

    public void onPageComplete()
    {
    }

    public void onPromoSlot0Received(PromoSlot promoslot)
    {
    }

    public void onPromoSlot1Received(PromoSlot promoslot)
    {
    }

    public void onPushViewCompleted()
    {
        post(new Runnable() {

            final MShopWebHomeBar this$0;

            public void run()
            {
                long l;
                boolean flag;
                flag = true;
                l = System.currentTimeMillis();
                mHomeController.setReturnCartItems(true);
                HomeController homecontroller = mHomeController;
                if (SSOUtil.getCurrentIdentityType() != IdentityType.CENTRAL_SSO_TYPE)
                {
                    flag = false;
                }
                homecontroller.setReturnHomeItems(flag);
                flag = mHomeController.phoneHome(mApplicationStarted, mApplicationStarted);
                if (!mApplicationStarted) goto _L2; else goto _L1
_L1:
                mActivity.loadHTMLGateway();
_L4:
                mApplicationStarted = false;
                return;
_L2:
                if (flag)
                {
                    mActivity.reloadHtmlGateway(l);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = MShopWebHomeBar.this;
                super();
            }
        });
    }

    public void onWindowFocusChanged(boolean flag)
    {
        try
        {
            super.onWindowFocusChanged(flag);
        }
        catch (Exception exception)
        {
            Log.e("WebHomeBar", "onWindowFocusChanged error", exception);
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        setupVoiceSearch();
    }

    public void preHomeCallStarted()
    {
    }




/*
    static boolean access$102(MShopWebHomeBar mshopwebhomebar, boolean flag)
    {
        mshopwebhomebar.mApplicationStarted = flag;
        return flag;
    }

*/

}
