// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.groupon.Constants;
import com.groupon.http.Http;
import com.groupon.models.country.Country;
import com.groupon.models.country.converter.CountryConverter;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.provider.LocalizedSharedPreferencesProvider;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.ObjectMapperWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class CountriesService
{
    private class MapUrlToCountryCodes extends HashMap
    {

        final CountriesService this$0;

        public MapUrlToCountryCodes(Context context1)
        {
            this$0 = CountriesService.this;
            super();
            put((new StringBuilder()).append(prefs.getString("base_url_eu", context1.getString(0x7f0804c1))).append("/countries").toString(), com.groupon.Constants.Location.EU_API_COUNTRIES);
            put((new StringBuilder()).append(prefs.getString("base_url_as", context1.getString(0x7f0804bd)).replace("http", "https")).append("/countries").toString(), com.groupon.Constants.Location.AS_API_COUNTRIES);
            put((new StringBuilder()).append(prefs.getString("base_url_cl", context1.getString(0x7f0804bf)).replace("http", "https")).append("/countries").toString(), com.groupon.Constants.Location.CL_API_COUNTRIES);
            put((new StringBuilder()).append(prefs.getString("base_url_in", context1.getString(0x7f0804c3)).replace("http", "https")).append("/countries").toString(), com.groupon.Constants.Location.IN_API_COUNTRIES);
            put((new StringBuilder()).append(prefs.getString("base_url_jp", context1.getString(0x7f0804c4)).replace("http", "https")).append("/countries").toString(), com.groupon.Constants.Location.JP_API_COUNTRIES);
            put((new StringBuilder()).append(prefs.getString("base_url_ru", context1.getString(0x7f0804c7)).replace("http", "https")).append("/countries").toString(), com.groupon.Constants.Location.RU_API_COUNTRIES);
        }
    }


    private static com.groupon.util.AbstractRetryAsyncTask.OnRetryListener retryListener;
    private Application context;
    private CountryConverter countryConverter;
    private String deviceId;
    private DeviceInfoUtil deviceInfoUtil;
    protected ObjectMapperWrapper objectMapper;
    private SharedPreferences prefs;
    private String referrer;

    public CountriesService()
    {
    }

    private List filterSupportedCountries(List list, List list1)
    {
        list = new HashSet(list);
        Iterator iterator = list1.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!list.contains(((Country)iterator.next()).shortName.toLowerCase()))
            {
                iterator.remove();
            }
        } while (true);
        return list1;
    }

    private List getCountriesSyncTask(final Context final_context1)
        throws Exception
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        CountDownLatch countdownlatch;
        Object obj = new MapUrlToCountryCodes(final_context1);
        arraylist = new ArrayList();
        countdownlatch = new CountDownLatch(((HashMap) (obj)).size());
        String s = deviceInfoUtil.getLanguageFromLocale();
        java.util.Map.Entry entry;
        for (obj = ((HashMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); ((Http)(new Http(new Object[] {
    "device_id", deviceId, "referrer", referrer, "lang", s
}, arraylist, entry, countdownlatch) {

        final CountriesService this$0;
        final CountDownLatch val$latch;
        final List val$supportedCountries;
        final java.util.Map.Entry val$urlEntry;

        protected void onFinally()
        {
            super.onFinally();
            latch.countDown();
        }

        protected volatile void onSuccess(Object obj1)
            throws Exception
        {
            onSuccess((String)obj1);
        }

        protected void onSuccess(String s1)
            throws Exception
        {
            s1 = (com.groupon.models.country.json.Country.List)objectMapper.readValue(s1, com/groupon/models/country/json/Country$List);
            s1 = countryConverter.fromJson(s1);
            supportedCountries.addAll(filterSupportedCountries((List)urlEntry.getValue(), s1));
        }

            transient 
            {
                this$0 = CountriesService.this;
                supportedCountries = list;
                urlEntry = entry;
                latch = countdownlatch;
                super(final_context1, final_class1, final_s, aobj);
            }
    }).setOnRetryListener(retryListener)).execute())
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_161;
        final_context1;
        throw final_context1;
        countdownlatch.await();
        arraylist.add(Constants.DEFAULT_US_COUNTRY);
        arraylist.add(Constants.DEFAULT_CA_COUNTRY);
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public List getCountriesSyncTask()
    {
        List list;
        try
        {
            list = getCountriesSyncTask(((Context) (context)));
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        return list;
    }

    public Set getKnownCountries()
    {
        Set set = getKnownCountriesExcludingUsServerCountries();
        set.addAll(com.groupon.Constants.Location.US_API_COUNTRIES);
        return set;
    }

    public Set getKnownCountriesExcludingUsServerCountries()
    {
        HashSet hashset = new HashSet();
        hashset.addAll(com.groupon.Constants.Location.EU_API_COUNTRIES);
        hashset.addAll(com.groupon.Constants.Location.AS_API_COUNTRIES);
        hashset.addAll(com.groupon.Constants.Location.CL_API_COUNTRIES);
        hashset.addAll(com.groupon.Constants.Location.IN_API_COUNTRIES);
        hashset.addAll(com.groupon.Constants.Location.JP_API_COUNTRIES);
        hashset.addAll(com.groupon.Constants.Location.RU_API_COUNTRIES);
        return hashset;
    }

    public List supportedCountryCodes()
    {
        ArrayList arraylist = new ArrayList();
        StaticSupportInfo astaticsupportinfo[] = StaticSupportInfo.values();
        int j = astaticsupportinfo.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(astaticsupportinfo[i].name().toLowerCase());
        }

        return arraylist;
    }

    public List visitedCountryCodes()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = supportedCountryCodes().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (LocalizedSharedPreferencesProvider.exists(context, s))
            {
                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }



}
