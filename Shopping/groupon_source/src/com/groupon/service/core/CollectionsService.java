// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.app.Application;
import android.content.Context;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.collections.Collections;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.Dates;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service.core:
//            CoreService

public class CollectionsService extends CoreService
{

    private static final String PREF_KEY_COLLECTIONS_SERVICE = "CollectionsService";
    private static final String PREF_KEY_COLLECTIONS_SERVICE_TIMESTAMP = "CollectionsServiceTimestamp";
    private Application application;
    private Collections collections;
    private ArraySharedPreferences collectionsServiceSharedPreferences;
    private Lazy currentCountryManager;
    private Lazy currentDivisionManager;
    private DeviceInfoUtil deviceInfoUtil;
    protected ObjectMapperWrapper objectMapper;

    public CollectionsService()
    {
    }

    private void cacheToMemory()
    {
        String s;
        s = collectionsServiceSharedPreferences.getString("CollectionsService", null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        collections = ((com.groupon.models.collections.Collections.Wrapper)objectMapper.readValue(s, com/groupon/models/collections/Collections$Wrapper)).collections;
        return;
        IOException ioexception;
        ioexception;
        Ln.d(ioexception, "Impossible to read the collections from cache.", new Object[0]);
        return;
    }

    private void init()
    {
        currentCountryManager = new Lazy(application) {

            final CollectionsService this$0;

            
            {
                this$0 = CollectionsService.this;
                super(context);
            }
        };
        currentDivisionManager = new Lazy(application) {

            final CollectionsService this$0;

            
            {
                this$0 = CollectionsService.this;
                super(context);
            }
        };
        cacheToMemory();
    }

    public Collections getCollections()
    {
        return collections;
    }

    public boolean isDownloadingDataFromNetwork()
    {
        return true;
    }

    protected boolean isUpToDate()
    {
        return !((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible() || Dates.isToday(collectionsServiceSharedPreferences.getLong("CollectionsServiceTimestamp", 0L));
    }

    public void refresh()
        throws Exception
    {
        Object obj = deviceInfoUtil.getLanguageFromLocale();
        obj = new ArrayList(Arrays.asList(new Object[] {
            "type", "occasion", "division_id", ((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision().getIdOrParentId(), "lang", obj
        }));
        obj = (String)(new SyncHttp(application, java/lang/String, "/collections", ((List) (obj)).toArray())).call();
        collections = ((com.groupon.models.collections.Collections.Wrapper)objectMapper.readValue(((String) (obj)), com/groupon/models/collections/Collections$Wrapper)).collections;
        collectionsServiceSharedPreferences.edit().putString("CollectionsService", ((String) (obj))).putLong("CollectionsServiceTimestamp", System.currentTimeMillis()).apply();
    }

    public void resetToNotUpToDate()
    {
        collectionsServiceSharedPreferences.edit().remove("CollectionsServiceTimestamp").apply();
    }
}
