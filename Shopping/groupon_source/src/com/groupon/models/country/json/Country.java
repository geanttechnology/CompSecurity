// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.country.json;


// Referenced classes of package com.groupon.models.country.json:
//            EnabledFeatures, Locales, PaymentMethod

public class Country
{
    public static class List
    {

        public java.util.List countries;
        public Country country;

        public List()
        {
        }
    }

    public static class Wrapper
    {

        public Country country;

        public Wrapper()
        {
        }
    }


    public String bonusPaymentName;
    public String currency;
    public String defaultLocale;
    public boolean doubleOptin;
    public EnabledFeatures enabledFeatures;
    public String facebookAppId;
    public int id;
    public int incentiveRewardAmount;
    public Locales locales;
    public PaymentMethod paymentMethods;
    public int rewardUnits;
    public String shortname;
    public String url;

    public Country()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("Country{id=").append(id).append(", shortname='").append(shortname).append('\'').append(", url='").append(url).append('\'').append(", currency='").append(currency).append('\'').append(", rewardUnits=").append(rewardUnits).append(", bonusPaymentName='").append(bonusPaymentName).append('\'').append(", incentiveRewardAmount=").append(incentiveRewardAmount).append(", doubleOptin=").append(doubleOptin).append(", defaultLocale='").append(defaultLocale).append('\'').append(", enabledFeatures=").append(enabledFeatures).append(", locales=").append(locales).append(", paymentMethods=").append(paymentMethods).append(", facebookAppId='").append(facebookAppId).append('\'').append('}').toString();
    }
}
