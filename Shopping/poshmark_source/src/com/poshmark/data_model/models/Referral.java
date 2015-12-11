// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.NumberUtils;
import java.math.BigDecimal;

public class Referral
{
    public class DefaultMessages
    {

        public String email_body;
        public String email_subject;
        public String fb_desc;
        public String fb_img_url;
        public String fb_share;
        public String fb_share_url;
        public String fb_title;
        public String sms;
        final Referral this$0;
        public String tm_share;
        public String tw_share;

        public DefaultMessages()
        {
            this$0 = Referral.this;
            super();
        }
    }


    String campaign_id;
    String created_at;
    DefaultMessages default_messages;
    String id;
    int max_uses;
    int num_used;
    String program;
    BigDecimal referred_incentive;
    String referrer_id;
    BigDecimal referrer_incentive;
    String status;
    String trigger_event;

    public Referral()
    {
    }

    public DefaultMessages getDefaultMessages()
    {
        return default_messages;
    }

    public String getId()
    {
        return id;
    }

    public String getProgram()
    {
        return program;
    }

    public String getReferredIncentiveFormattedString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(NumberUtils.getBigDecimalAsGroupedString(referred_incentive, 0, 0)).toString();
    }

    public String getReferredIncentiveString()
    {
        return NumberUtils.getBigDecimalAsGroupedString(referred_incentive, 0, 0);
    }

    public String getReferrerIncentiveFormattedString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(NumberUtils.getBigDecimalAsGroupedString(referrer_incentive, 0, 0)).toString();
    }

    public String getReferrerIncentiveString()
    {
        return NumberUtils.getBigDecimalAsGroupedString(referrer_incentive, 0, 0);
    }
}
