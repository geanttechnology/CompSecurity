// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.country.converter;

import com.groupon.models.country.Alipay;
import com.groupon.models.country.AsiaPay;
import com.groupon.models.country.AuEasyPay;
import com.groupon.models.country.Country;
import com.groupon.models.country.CreditCard;
import com.groupon.models.country.DineroMail;
import com.groupon.models.country.DotPay;
import com.groupon.models.country.Elv;
import com.groupon.models.country.EnabledFeatures;
import com.groupon.models.country.IPay88;
import com.groupon.models.country.Ideal;
import com.groupon.models.country.LegalDocument;
import com.groupon.models.country.MDebitCl;
import com.groupon.models.country.MOneClickCl;
import com.groupon.models.country.MWebPayCl;
import com.groupon.models.country.Maestro;
import com.groupon.models.country.Maestrouk;
import com.groupon.models.country.MastercardPe;
import com.groupon.models.country.MultiplusPoints;
import com.groupon.models.country.PayPal;
import com.groupon.models.country.PaymentMethod;
import com.groupon.models.country.Pse;
import com.groupon.models.country.SepaDirectDebit;
import com.groupon.models.country.VisaPe;
import com.groupon.models.country.json.AbstractPaymentMethod;
import com.groupon.models.country.json.Locales;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;

public class CountryConverter
{

    public CountryConverter()
    {
    }

    public void addfromJson(List list, AbstractPaymentMethod abstractpaymentmethod, Class class1)
    {
        if (abstractpaymentmethod == null)
        {
            return;
        }
        try
        {
            class1 = (PaymentMethod)class1.newInstance();
            class1.recurringType = abstractpaymentmethod.recurringType;
            class1.name = abstractpaymentmethod.name;
            list.add(class1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list) { }
        // Misplaced declaration of an exception variable
        catch (List list) { }
        Ln.e(list);
    }

    public Country fromJson(com.groupon.models.country.json.Country.Wrapper wrapper)
    {
        return fromJson(wrapper.country);
    }

    public Country fromJson(com.groupon.models.country.json.Country country)
    {
        Country country1 = new Country();
        country1.id = country.id;
        country1.shortName = country.shortname.toLowerCase();
        country1.isoName = country1.shortName;
        country1.url = country.url;
        country1.currency = country.currency;
        country1.rewardUnits = country.rewardUnits;
        country1.bonusPaymentName = country.bonusPaymentName;
        country1.incentiveRewardAmount = country.incentiveRewardAmount;
        country1.doubleOptin = country.doubleOptin;
        country1.enabledFeatures = fromJson(country.enabledFeatures);
        country1.defaultLocale = country.defaultLocale;
        if (country.locales != null && country.locales.languages != null)
        {
            country1.localeLanguages = Arrays.asList(country.locales.languages);
        } else
        {
            country1.localeLanguages = new ArrayList();
        }
        country1.paymentMethods = fromJson(country.paymentMethods);
        country1.facebookAppId = country.facebookAppId;
        if (country1.shortName.equals("ca"))
        {
            country1.shortName = "ca_eu";
        }
        return country1;
    }

    public CreditCard fromJson(com.groupon.models.country.json.CreditCard creditcard)
    {
        CreditCard creditcard1 = new CreditCard();
        creditcard1.name = creditcard.name;
        creditcard1.recurringType = creditcard.recurringType;
        creditcard1.requireCVV = creditcard.requireCVV;
        return creditcard1;
    }

    public EnabledFeatures fromJson(com.groupon.models.country.json.EnabledFeatures enabledfeatures)
    {
        EnabledFeatures enabledfeatures1 = new EnabledFeatures();
        if (enabledfeatures == null)
        {
            return enabledfeatures1;
        } else
        {
            enabledfeatures1.requireCpf = enabledfeatures.requireCpf;
            enabledfeatures1.breakdowns = enabledfeatures.breakdowns;
            enabledfeatures1.multipleImages = enabledfeatures.multipleImages;
            enabledfeatures1.legalDocument = fromJson(enabledfeatures.legalDocument);
            enabledfeatures1.requireCVVForBillingRecordsIds = enabledfeatures.requireCVVForBillingRecordsIds;
            enabledfeatures1.multiLanguage = enabledfeatures.multiLanguage;
            enabledfeatures1.billingRecordsAPI = enabledfeatures.billingRecordsAPI;
            enabledfeatures1.addBillingRecords = enabledfeatures.addBillingRecords;
            enabledfeatures1.subscriptions = enabledfeatures.subscriptions;
            enabledfeatures1.channels = enabledfeatures.channels;
            enabledfeatures1.markAsUsed = enabledfeatures.markAsUsed;
            enabledfeatures1.facebookConnect = enabledfeatures.facebookConnect;
            enabledfeatures1.passwordReset = enabledfeatures.passwordReset;
            enabledfeatures1.buyAsGift = enabledfeatures.buyAsGift;
            enabledfeatures1.discussionForums = enabledfeatures.discussionForums;
            enabledfeatures1.nearby = enabledfeatures.nearby;
            enabledfeatures1.search = enabledfeatures.search;
            enabledfeatures1.locationAutocomplete = enabledfeatures.locationAutocomplete;
            enabledfeatures1.dealsAutocomplete = enabledfeatures.dealsAutocomplete;
            enabledfeatures1.relevanceFeatured = enabledfeatures.relevanceFeatured;
            enabledfeatures1.newsletterOptIn = enabledfeatures.newsletterOptIn;
            enabledfeatures1.activePromotion = enabledfeatures.activePromotion;
            enabledfeatures1.megamind = enabledfeatures.megamind;
            return enabledfeatures1;
        }
    }

    public LegalDocument fromJson(com.groupon.models.country.json.LegalDocument legaldocument)
    {
        if (legaldocument == null)
        {
            return null;
        } else
        {
            LegalDocument legaldocument1 = new LegalDocument();
            legaldocument1.version = legaldocument.version;
            return legaldocument1;
        }
    }

    public List fromJson(com.groupon.models.country.json.Country.List list)
    {
        ArrayList arraylist = new ArrayList();
        if (list.country != null)
        {
            arraylist.add(fromJson(list.country));
        }
        if (list.countries != null)
        {
            for (list = list.countries.iterator(); list.hasNext(); arraylist.add(fromJson((com.groupon.models.country.json.Country)list.next()))) { }
        }
        return arraylist;
    }

    public List fromJson(com.groupon.models.country.json.PaymentMethod paymentmethod)
    {
        ArrayList arraylist = new ArrayList();
        if (paymentmethod != null) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        addfromJson(arraylist, paymentmethod.paypal, com/groupon/models/country/PayPal);
        addfromJson(arraylist, paymentmethod.aueasypay, com/groupon/models/country/AuEasyPay);
        addfromJson(arraylist, paymentmethod.elv, com/groupon/models/country/Elv);
        addfromJson(arraylist, paymentmethod.maestrouk, com/groupon/models/country/Maestrouk);
        addfromJson(arraylist, paymentmethod.ideal, com/groupon/models/country/Ideal);
        addfromJson(arraylist, paymentmethod.dotpay, com/groupon/models/country/DotPay);
        addfromJson(arraylist, paymentmethod.maestro, com/groupon/models/country/Maestro);
        addfromJson(arraylist, paymentmethod.multipluspoints, com/groupon/models/country/MultiplusPoints);
        addfromJson(arraylist, paymentmethod.dineromail, com/groupon/models/country/DineroMail);
        addfromJson(arraylist, paymentmethod.asiapay, com/groupon/models/country/AsiaPay);
        addfromJson(arraylist, paymentmethod.alipay, com/groupon/models/country/Alipay);
        addfromJson(arraylist, paymentmethod.m_oneclick_cl, com/groupon/models/country/MOneClickCl);
        addfromJson(arraylist, paymentmethod.m_debit_cl, com/groupon/models/country/MDebitCl);
        addfromJson(arraylist, paymentmethod.m_webpay_cl, com/groupon/models/country/MWebPayCl);
        addfromJson(arraylist, paymentmethod.ipay88, com/groupon/models/country/IPay88);
        addfromJson(arraylist, paymentmethod.sepadirectdebit, com/groupon/models/country/SepaDirectDebit);
        addfromJson(arraylist, paymentmethod.visa_pe, com/groupon/models/country/VisaPe);
        addfromJson(arraylist, paymentmethod.mastercard_pe, com/groupon/models/country/MastercardPe);
        addfromJson(arraylist, paymentmethod.pse, com/groupon/models/country/Pse);
        if (paymentmethod.creditCards != null)
        {
            paymentmethod = paymentmethod.creditCards.iterator();
            while (paymentmethod.hasNext()) 
            {
                arraylist.add(fromJson((com.groupon.models.country.json.CreditCard)paymentmethod.next()));
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
