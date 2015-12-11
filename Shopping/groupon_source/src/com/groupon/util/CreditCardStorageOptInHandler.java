// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.groupon.models.nst.CreditCardStorageConsentClickExtraInfo;
import com.groupon.models.nst.CreditCardStorageConsentExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            LoggingUtils

public class CreditCardStorageOptInHandler
{

    private static final String CLICK_TYPE = "cc_save_authorization_click";
    public static final String CONSENT_NOT_NEEDED = "not-needed";
    public static final String CONSENT_OPTIN = "opt-in";
    public static final String CONSENT_OPTOUT = "opt-out";
    public static final String CREDIT_CARD_CONSENT_REQUIREMENTS = "creditCardConsentRequirements";
    private static final String IMPRESSION_TYPE = "cc_save_authorization";
    private static final String PLACEMENT = "checkbox_bottom_of_page";
    private static final String USER_CC_STORAGE_CONSENT = "userCCStorageConsent";
    private static final String USER_CC_TYPE_CONSENT = "consentForCreditCardType";
    public static final String USER_CREDIT_CARD_STORAGE_CONSENT = "userCreditCardStorageConsent";
    private final String channelId;
    private String consentedCreditCardType;
    private String currentCreditCardType;
    private final LoggingUtils loggingUtils;
    private final String pageId;
    private String storageConsentRequirement;
    private final Bundle storageConsentRequirements;
    private Boolean userConsent;

    public CreditCardStorageOptInHandler(LoggingUtils loggingutils, String s, String s1, Bundle bundle)
    {
        loggingUtils = loggingutils;
        pageId = s;
        channelId = s1;
        storageConsentRequirements = bundle;
    }

    private boolean hasUserProvidedFeedback()
    {
        return userConsent != null && Strings.equals(consentedCreditCardType, currentCreditCardType);
    }

    public void doRestoreState(Bundle bundle, SharedPreferences sharedpreferences)
    {
        sharedpreferences.edit().remove("userCreditCardStorageConsent").apply();
        if (bundle != null)
        {
            userConsent = Boolean.valueOf(bundle.getBoolean("userCCStorageConsent"));
            consentedCreditCardType = bundle.getString("consentForCreditCardType");
        }
    }

    public void doSaveState(Bundle bundle)
    {
        if (hasUserProvidedFeedback())
        {
            bundle.putBoolean("userCCStorageConsent", userConsent.booleanValue());
            bundle.putString("consentForCreditCardType", consentedCreditCardType);
        }
    }

    public void doSaveUserConsent(SharedPreferences sharedpreferences)
    {
        sharedpreferences = sharedpreferences.edit();
        if (isConsentRequested())
        {
            sharedpreferences = sharedpreferences.putBoolean("userCreditCardStorageConsent", hasStorageConsent());
        } else
        {
            sharedpreferences = sharedpreferences.remove("userCreditCardStorageConsent");
        }
        sharedpreferences.apply();
    }

    public void doUpdateUserConsent(boolean flag)
    {
        userConsent = Boolean.valueOf(flag);
        loggingUtils.logClick("", "cc_save_authorization_click", channelId, Logger.NULL_NST_FIELD, new CreditCardStorageConsentClickExtraInfo(pageId, String.valueOf(flag)));
    }

    public boolean hasStorageConsent()
    {
        boolean flag = Strings.equals("opt-in", storageConsentRequirement);
        boolean flag1 = Strings.equals("opt-out", storageConsentRequirement);
        if (hasUserProvidedFeedback())
        {
            return userConsent.booleanValue();
        }
        return !flag || flag1;
    }

    public boolean isConsentRequested()
    {
        if (!hasUserProvidedFeedback())
        {
            boolean flag = Strings.equals("opt-in", storageConsentRequirement);
            boolean flag1 = Strings.equals("opt-out", storageConsentRequirement);
            if (Strings.equals("not-needed", storageConsentRequirement) || !flag && !flag1)
            {
                return false;
            }
        }
        return true;
    }

    public boolean updateConsentForPaymentMethod(String s)
    {
        if (storageConsentRequirements == null)
        {
            return false;
        }
        currentCreditCardType = s;
        if (!hasUserProvidedFeedback())
        {
            consentedCreditCardType = s;
            userConsent = null;
            storageConsentRequirement = storageConsentRequirements.getString(s, null);
            loggingUtils.logImpression("", "cc_save_authorization", channelId, "checkbox_bottom_of_page", new CreditCardStorageConsentExtraInfo(pageId, storageConsentRequirement));
        }
        return true;
    }
}
