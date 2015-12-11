// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.goldbox.GoldboxLaunchParamters;
import com.amazon.mShop.net.ErrorExceptionMetricsObserver;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.publicurl.PublicURLProcessException;
import com.amazon.mShop.publicurl.PublicURLProcessor;
import com.amazon.mShop.publicurl.PublicURLProcessorFactory;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.MShopSystemNotificationManagerUtil;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.ResourcesUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;

public class NotificationContentActivity extends AmazonActivity
{

    private boolean finishIfBackToForground;

    public NotificationContentActivity()
    {
        finishIfBackToForground = false;
    }

    private void launchTargetNotificationActivity()
    {
        Object obj;
        String s;
        String s3;
        int i;
        s = getIntent().getStringExtra("ref");
        String s1;
        String s4;
        boolean flag;
        if (Util.isEmpty(s))
        {
            obj = ClickStreamTag.ORIGIN_NOTIFICATION;
        } else
        {
            obj = new ClickStreamTag("");
        }
        s3 = getIntent().getStringExtra("NotificationMarketPlace");
        s1 = ResourcesUtils.getStringOfSpecificLocale(this, "country_name", AppLocale.getInstance().getLocaleByMarketPlaceId(s3));
        s4 = AppLocale.getInstance().getCurrentLocaleName();
        flag = AppLocale.getInstance().getMarketPlaceIdByLocale(s4).equals(s3);
        s3 = getIntent().getAction();
        if (flag) goto _L2; else goto _L1
_L1:
        ActivityUtils.startHomeActivity(this, null, -1, true);
        i = com.amazon.mShop.android.lib.R.string.notification_switch_locale_toast_text_for_product;
        if (!s3.equals("GoToUDP")) goto _L4; else goto _L3
_L3:
        i = com.amazon.mShop.android.lib.R.string.notification_switch_locale_toast_text_for_deal;
        RefMarkerObserver.logRefMarker("pn_single_ld_t");
_L8:
        UIUtils.info(getApplicationContext(), getString(i, new Object[] {
            s1
        }));
        finish();
_L6:
        return;
_L4:
        if (s3.equals("GoToDealListPage"))
        {
            i = com.amazon.mShop.android.lib.R.string.notification_switch_locale_toast_text_for_deal_category;
            logRefMarkerForDealList();
        } else
        if (s3.equals("GoToDetailedOrder"))
        {
            i = com.amazon.mShop.android.lib.R.string.notification_switch_locale_toast_text_for_order_details;
            RefMarkerObserver.logRefMarker("pn_shipped_t");
        }
        continue; /* Loop/switch isn't completed */
_L2:
        String s2 = getIntent().getStringExtra("NotificationType");
        getIntent().removeExtra("NotificationType");
        if (!Util.isEmpty(s2))
        {
            MShopSystemNotificationManagerUtil.removeStackedNotifications(s2);
        }
        if (s3.equals("GoToDealListPage"))
        {
            ActivityUtils.startDealsActivity(this, new GoldboxLaunchParamters("LD", getIntent().getStringExtra("refineCategory"), getIntent().getStringExtra("refineCategoryDisplayName")), ((ClickStreamTag) (obj)).getTag(), Maps.of("ref", s), false);
            logRefMarkerForDealList();
            return;
        }
        if (s3.equals("GoToUDP"))
        {
            ActivityUtils.launchDetailsPage(this, new ProductController(getIntent().getStringExtra("asin"), ((ClickStreamTag) (obj))), Maps.of("ref", s), -1);
            RefMarkerObserver.logRefMarker("pn_single_ld_t");
            return;
        }
        if (s3.equals("GoToDetailedOrder"))
        {
            obj = s;
            if (!Util.isEmpty(s))
            {
                obj = s;
                if (!s.toLowerCase().startsWith("m5n_msh_"))
                {
                    obj = (new StringBuilder()).append("m5n_msh_").append(s).toString();
                }
            }
            ActivityUtils.startYourOrdersActivity(this, getIntent().getStringExtra("order_id"), "order_to_view", -1, ((String) (obj)), false, -1);
            RefMarkerObserver.logRefMarker("pn_shipped_t");
            return;
        }
        if (s3.equals("GoToSNS"))
        {
            ActivityUtils.startSnsDispatchActivity(this, getIntent().getStringExtra("data"), getResources().getString(com.amazon.mShop.android.lib.R.string.sns_dp_block_title), s);
            RefMarkerObserver.logRefMarker("pn_sns_t");
            return;
        }
        if (s3.equals("GoToDealsLandingPage"))
        {
            ActivityUtils.startDealsActivity(this, null, ((ClickStreamTag) (obj)).getTag(), Maps.of("ref", s), false);
            RefMarkerObserver.logRefMarker("pn_dotd_t");
            return;
        }
        if (s3.equals("GoToDeepLink"))
        {
            Uri uri = getIntent().getData();
            try
            {
                PublicURLProcessorFactory.getInstance(uri).process(this, ClickStreamTag.ORIGIN_NOTIFICATION.getTag());
                return;
            }
            catch (PublicURLProcessException publicurlprocessexception)
            {
                ErrorExceptionMetricsObserver.logMetric(publicurlprocessexception);
            }
            return;
        }
        if (!s3.equals("GoToSmartLink")) goto _L6; else goto _L5
_L5:
        RefMarkerObserver.logRefMarker("pn_sns_t");
        WebUtils.openWebview(this, getIntent().getData().toString());
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void logRefMarkerForDealList()
    {
        if (!Util.isEmpty(getIntent().getStringExtra("refineCategory")))
        {
            RefMarkerObserver.logRefMarker("pn_group_ld_t");
            return;
        } else
        {
            RefMarkerObserver.logRefMarker("pn_all_ld_t");
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        launchTargetNotificationActivity();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        finishIfBackToForground = false;
        if (DEBUG)
        {
            Log.v("AmazonActivity", (new StringBuilder()).append("onNewIntent: ").append(this).toString());
        }
        launchTargetNotificationActivity();
    }

    public void onStart()
    {
        super.onStart();
        if (finishIfBackToForground)
        {
            finish();
        }
    }

    protected void onStop()
    {
        super.onStop();
        finishIfBackToForground = true;
    }
}
