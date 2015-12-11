// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.Intent;
import com.groupon.Channel;
import com.groupon.activity.BookingMetaData;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.gift.GiftingRecord;
import com.groupon.models.support.SupportInfo;
import com.groupon.service.LoginService;
import com.groupon.service.core.SupportInfoService;

// Referenced classes of package com.groupon.util:
//            DealUtils

public class LoginUtil
{

    private Context context;
    private IntentFactory intentFactory;
    private LoginService loginService;
    private SupportInfoService supportInfoService;

    public LoginUtil()
    {
    }

    public String getSignUpLegalFromJson()
    {
        SupportInfo supportinfo = supportInfoService.getSupportInfo();
        if (supportinfo == null)
        {
            return null;
        } else
        {
            return supportinfo.contents.legalDisclosure.signUp;
        }
    }

    public void startGiftingFlow(Deal deal, Option option, String s, Channel channel, boolean flag, boolean flag1)
    {
        GiftingRecord giftingrecord = new GiftingRecord();
        giftingrecord.isGiftWrappable = DealUtils.isGiftWrappable(option);
        giftingrecord.isGoods = DealUtils.isGoodsShoppingDeal(deal);
        giftingrecord.deliveryMethod = "email";
        giftingrecord.fromName = loginService.getFullName();
        if (loginService.isLoggedIn())
        {
            option = intentFactory.newPurchaseLoginIntent(deal, option.remoteId, s, channel, flag, flag1);
        } else
        {
            option = intentFactory.createPurchaseIntent(deal, option.remoteId, s, flag, flag1, null);
        }
        deal = intentFactory.newGiftingIntent(context, giftingrecord, deal.remoteId, option, DealUtils.isGiftableDeal(deal, false, false));
        context.startActivity(deal);
    }

    public void startMarketRateReservationFlow(String s, String s1, String s2, String s3, String s4, Channel channel, String s5, 
            BookingMetaData bookingmetadata, String s6)
    {
        s1 = intentFactory.newMarketRatePurchaseIntent(s1, s2, s3, s4, channel, s5, s, s6, bookingmetadata);
        s = s1;
        if (!loginService.isLoggedIn())
        {
            s = intentFactory.newLoginIntent(context, s1);
        }
        context.startActivity(s);
    }

    public void startNextActivity(Intent intent)
    {
        if (intent != null)
        {
            context.startActivity(intentFactory.newSplashIntent(intent.putExtra("comingFromLogin", true)));
        }
    }

    public void startPurchaseActivity(Deal deal, String s, String s1, Channel channel, boolean flag, boolean flag1, boolean flag2)
    {
        deal = intentFactory.newPurchaseLoginIntent(deal, s, s1, channel, flag, flag1);
        context.startActivity(deal.putExtra("comingFromCheckout", true).putExtra("isDeepLinked", flag2));
    }
}
