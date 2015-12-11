// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.app.Application;
import android.content.Context;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.country.Country;
import com.groupon.models.support.SupportInfo;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.Dates;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service.core:
//            CoreService

public class SupportInfoService extends CoreService
{

    private static final String PREF_KEY_SUPPORT_INFO_SERVICE = "SupportInfoService";
    private static final String PREF_KEY_SUPPORT_INFO_SERVICE_TIMESTAMP = "SupportInfoServiceTimestamp";
    private Application application;
    private Lazy currentCountryManager;
    private Lazy deviceInfoUtil;
    protected ObjectMapperWrapper objectMapper;
    private SupportInfo supportInfo;
    private ArraySharedPreferences supportInfoServiceSharedPreferences;

    public SupportInfoService()
    {
    }

    private void cacheToMemory()
    {
        String s;
        s = supportInfoServiceSharedPreferences.getString("SupportInfoService", null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        supportInfo = (SupportInfo)objectMapper.readValue(s, com/groupon/models/support/SupportInfo);
        return;
        IOException ioexception;
        ioexception;
        Ln.d(ioexception, (new StringBuilder()).append("Impossible to read the support info from cache.").append(s).toString(), new Object[0]);
        return;
    }

    private void init()
    {
        currentCountryManager = new Lazy(application) {

            final SupportInfoService this$0;

            
            {
                this$0 = SupportInfoService.this;
                super(context);
            }
        };
        deviceInfoUtil = new Lazy(application) {

            final SupportInfoService this$0;

            
            {
                this$0 = SupportInfoService.this;
                super(context);
            }
        };
        cacheToMemory();
    }

    public SupportInfo getSupportInfo()
    {
        return supportInfo;
    }

    public boolean isDownloadingDataFromNetwork()
    {
        return true;
    }

    protected boolean isUpToDate()
    {
        return Dates.isToday(supportInfoServiceSharedPreferences.getLong("SupportInfoServiceTimestamp", 0L));
    }

    public void refresh()
        throws Exception
    {
        Object obj = new ArrayList();
        if (!((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible())
        {
            ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
                "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
            }));
        }
        obj = new SyncHttp(application, java/lang/String, "/support_info", ((ArrayList) (obj)).toArray());
        if (!((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible())
        {
            ((SyncHttp) (obj)).setAuthorizationRequired(false);
        }
        obj = (String)((SyncHttp) (obj)).call();
        SupportInfo supportinfo = (SupportInfo)objectMapper.readValue(((String) (obj)), com/groupon/models/support/SupportInfo);
        supportInfoServiceSharedPreferences.edit().putString("SupportInfoService", ((String) (obj))).putLong("SupportInfoServiceTimestamp", System.currentTimeMillis()).apply();
        supportInfo = supportinfo;
    }

    public void resetToNotUpToDate()
    {
        supportInfoServiceSharedPreferences.edit().remove("SupportInfoServiceTimestamp").apply();
    }
}
