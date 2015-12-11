// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.content.Context;
import android.content.SharedPreferences;
import com.ebay.common.ObfuscatedData;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.experimentation.ExperimentationUtil;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.EbayContextFactories;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile:
//            AppContext, MyApp

public final class AppSettings
    implements com.ebay.nautilus.domain.NautilusDomain.Factory, com.ebay.nautilus.domain.content.DomainContext.Factory
{

    static final AppSettings inst = new AppSettings();

    private AppSettings()
    {
    }

    public static AppSettings init(Context context)
    {
        NautilusDomain.init(context, inst);
        return inst;
    }

    public void addContextFactories(Context context, EbayContextFactories ebaycontextfactories)
    {
        AppContext.addAppContextFactories(context, ebaycontextfactories, this);
    }

    public EbayAppCredentials createApplicationCredentials(EbayContext ebaycontext)
    {
        return new EbayAppCredentials("2571", ObfuscatedData.decryptedAppId, "AEAPP", ObfuscatedData.decryptedDevId, ObfuscatedData.decryptedCertId, ObfuscatedData.decryptedPayPalAppId, (new StringBuilder()).append("eBayAndroid/").append(ebaycontext.getAppInfo().getAppVersionName()).toString());
    }

    public SharedPreferences getDomainSharedPreferences()
    {
        return MyApp.getPrefs().getPref();
    }

    public String getMachineGroupId(Context context)
    {
        return MyApp.getPrefs().getGlobalPref("mg_id_ref", null);
    }

    public com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Configuration getShoppingCartDataManagerConfiguration(Context context)
    {
        return MyApp.getDeviceConfiguration();
    }

    public void initializeDataManager(EbayContext ebaycontext, DataManager datamanager)
    {
        if (datamanager instanceof ExperimentationDataManager)
        {
            ExperimentationUtil.initializeDataManager(ebaycontext, (ExperimentationDataManager)datamanager);
        } else
        if (datamanager instanceof FollowedEntityDataManager)
        {
            SearchUtil.initializeDataManager(ebaycontext, datamanager);
            return;
        }
    }

    public void rewriteServiceErrors(EbayContext ebaycontext, ResultStatus resultstatus)
    {
        EbayErrorHandler.rewriteServiceErrors(ebaycontext, resultstatus);
    }

}
