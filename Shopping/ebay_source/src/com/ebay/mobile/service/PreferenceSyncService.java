// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.content.Intent;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.search.EbayFindingApi;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.BaseIntentService;

public class PreferenceSyncService extends BaseIntentService
{

    public static final String EXTRA_COUNTRY_CODE = "countryCode";
    public static final String EXTRA_POSTAL_CODE = "postalCode";
    public static final String EXTRA_STATE_OR_PROVINCE = "stateOrProvince";
    public static final String NAME = "PreferenceSyncService";
    public static final String UPDATE_PREFS_ALL = "com.ebay.mobile.service.PreferenceSyncService.updatePrefsAll";
    public static final String UPDATE_PREFS_PRIMARY_ADDRESS = "com.ebay.mobile.service.PreferenceSyncService.updatePrefsPrimaryAddress";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTagDebug = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PreferenceSyncService", 3, "Log PreferenceSyncService");
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTagError = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PreferenceSyncService", 6, "Log PreferenceSyncService");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTagInfo = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PreferenceSyncService", 4, "Log PreferenceSyncService");

    public PreferenceSyncService()
    {
        super("PreferenceSyncService");
    }

    private PostalCodeSpecification getSearchFriendlyPostalCode(String s, String s1, String s2)
    {
        if (s1 != null) goto _L2; else goto _L1
_L1:
        s2 = null;
_L4:
        return s2;
_L2:
        PostalCodeSpecification postalcodespecification;
        EbayCountry ebaycountry;
        postalcodespecification = new PostalCodeSpecification(s, s1, s2);
        ebaycountry = EbayCountry.getInstance(postalcodespecification.countryCode);
        if (ebaycountry == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        if (!postalcodespecification.countryCode.equals(ebaycountry.getCountryCode()))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        s2 = postalcodespecification;
        if (TextUtils.isEmpty(postalcodespecification.postalCode)) goto _L4; else goto _L3
_L3:
        if (DeviceConfiguration.getAsync().get(DcsBoolean.SearchUseSearchService) || EbayFindingApi.isValidPostalCodeSynchronous(getEbayContext(), ebaycountry, postalcodespecification.postalCode))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        postalcodespecification.postalCode = null;
        postalcodespecification.countryCode = null;
        s2 = postalcodespecification;
        if (!logTagDebug.isLoggable) goto _L4; else goto _L5
_L5:
        FwLog.println(logTagDebug, "Fail. We can't use the user's postal code.");
        return postalcodespecification;
        s2 = postalcodespecification;
        if (!logTagDebug.isLoggable) goto _L4; else goto _L6
_L6:
        FwLog.println(logTagDebug, (new StringBuilder()).append("Success. The postal code will work for searching this site. CountryCode=").append(s).append("postalCode=").append(s1).toString());
        return postalcodespecification;
        s;
        return null;
    }

    protected void onHandleIntent(Intent intent)
    {
        String s;
        s = intent.getAction();
        if (logTagDebug.isLoggable)
        {
            FwLog.println(logTagDebug, "preferences sync service started");
        }
        break MISSING_BLOCK_LABEL_22;
        if (s != null && ("com.ebay.mobile.service.PreferenceSyncService.updatePrefsPrimaryAddress".equals(s) || "com.ebay.mobile.service.PreferenceSyncService.updatePrefsAll".equals(s)))
        {
            if (logTagDebug.isLoggable)
            {
                FwLog.println(logTagDebug, "updating primary address");
            }
            updatePrimaryAddress(intent, MyApp.getPrefs().getAuthentication());
            if (logTagDebug.isLoggable)
            {
                FwLog.println(logTagDebug, "completed updating primary address");
                return;
            }
        }
        return;
    }

    public final boolean updatePrimaryAddress(Intent intent, Authentication authentication)
    {
        boolean flag = false;
        String s = intent.getStringExtra("postalCode");
        String s1 = intent.getStringExtra("countryCode");
        Object obj = intent.getStringExtra("stateOrProvince");
        intent = MyApp.getPrefs();
        if (s1 != null)
        {
            intent.setShipToPostalCode(new PostalCodeSpecification(s1, s, ((String) (obj))));
            obj = getSearchFriendlyPostalCode(s1, s, ((String) (obj)));
            if (authentication == null)
            {
                intent.setPostalCode(((PostalCodeSpecification) (obj)));
            } else
            {
                intent.setPostalCode(((PostalCodeSpecification) (obj)), authentication.user);
            }
            if (logTagDebug.isLoggable)
            {
                FwLog.println(logTagDebug, String.format("Primary address set to preferences: countryCode=%s, postalCode=%s", new Object[] {
                    s1, s
                }));
            }
            flag = true;
        }
        return flag;
    }

}
