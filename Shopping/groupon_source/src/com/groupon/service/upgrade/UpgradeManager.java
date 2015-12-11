// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.upgrade;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.provider.SearchRecentSuggestions;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.Channel;
import com.groupon.Constants;
import com.groupon.models.country.Country;
import com.groupon.models.country.converter.CountryConverter;
import com.groupon.models.division.City;
import com.groupon.models.division.Division;
import com.groupon.models.division.converter.DivisionConverter;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.receiver.DailySyncer;
import com.groupon.service.LoginService;
import com.groupon.service.PullNotificationService;
import com.groupon.service.WidgetDealIntentService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryDao;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionDao;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.countryanddivision.DivisionsService;
import com.groupon.service.countryanddivision.RecentDivisionsDao;
import com.groupon.service.operations.ClearCountryForMxUsers;
import com.groupon.service.operations.ClearCountryForSwitchedIntlUsers;
import com.groupon.service.upgrade.listener.UpgradeManagerListener;
import com.groupon.sso.SSOHelper;
import com.groupon.sso.UserCredential;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CacheUtils;
import com.groupon.util.GeoPoint;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class UpgradeManager
{
    protected static interface RunIfUpgradingFrom
        extends Annotation
    {

        public abstract int value();
    }


    public static final String GROUPON_CACHE = "groupon-cache";
    public static final String RECENT_CITIES = "recentCities";
    private static final int RELEASE_15_1 = 3883;
    private static final int RELEASE_15_2_PATCH_3 = 4021;
    private static final int RELEASE_15_3_PATCH_2 = 4096;
    private static final int RELEASE_15_5_PATCH_1 = 4248;
    private static final int RELEASE_15_6_PATCH_1 = 4375;
    private static final int RELEASE_15_7 = 4409;
    private static final int RELEASE_15_8 = 4530;
    private static final int RELEASE_3_0 = 3228;
    private static final int RELEASE_4_0 = 3508;
    private static final int RELEASE_5_0 = 3587;
    private static final int RELEASE_6_0 = 3672;
    private static final int RELEASE_7_0 = 3675;
    private static final int RELEASE_7_0_PATCH_1 = 3786;
    private static final int RELEASE_7_0_PATCH_2 = 3797;
    public static final String SHOULD_LOG_UPGRADE = "shouldLogUpgrade";
    private Application application;
    private ArraySharedPreferences divisionServiceSharedPreferences;
    private PackageInfo info;
    private List listenerList;
    private Logger logger;
    private ArraySharedPreferences loginPrefs;
    private ObjectMapper objectMapper;
    private SharedPreferences prefs;

    public UpgradeManager()
    {
        listenerList = new Vector();
    }

    private void cancelPullNotificationServiceAlarm(Context context, int i, int j)
    {
        PullNotificationService.cancelAlarm(context);
    }

    private void clearAppStartUpCounter(Context context, int i, int j)
    {
        prefs.edit().remove("skipCounter").apply();
        prefs.edit().remove("skipTarget").apply();
    }

    private void clearCountryForMXUsers(Context context, int i, int j)
    {
        ((ClearCountryForMxUsers)RoboGuice.getInjector(context).getInstance(com/groupon/service/operations/ClearCountryForMxUsers)).run();
    }

    private void clearCountryForSwitchedIntlUsers(Context context, int i, int j)
    {
        context = (ClearCountryForSwitchedIntlUsers)RoboGuice.getInjector(context).getInstance(com/groupon/service/operations/ClearCountryForSwitchedIntlUsers);
        if (i >= 2933 && i <= 2935)
        {
            context.run();
        }
    }

    private void clearGenderFromSecurePrefs(Context context, int i, int j)
    {
        loginPrefs.edit().remove("gender").apply();
    }

    private void clearLocation(Context context, int i, int j)
    {
        CurrentCountryManager currentcountrymanager = (CurrentCountryManager)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager);
        context = (CurrentDivisionManager)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentDivisionManager);
        String s = currentcountrymanager.getCurrentCountry().isoName;
        if (s != null && s.equalsIgnoreCase("ca_eu") || s.equalsIgnoreCase("GB"))
        {
            currentcountrymanager.clearCountry();
            context.clearCurrentDivision();
        }
    }

    private void clearLocationFromInsecurePrefs(Context context, int i, int j)
    {
        prefs.edit().remove("lastKnownLat").remove("lastKnownLng").apply();
    }

    private void clearMuteUntil(Context context, int i, int j)
    {
        prefs.edit().remove("proximityEndpointMuteUntil").apply();
    }

    private void clearOldGrouponCache(Context context, int i, int j)
    {
        CacheUtils.clearCacheDir(context);
    }

    private void clearPreferredShippingLocationId(Context context, int i, int j)
    {
        if (prefs.contains("preferredShippingLocationId"))
        {
            long l = prefs.getLong("preferredShippingLocationId", -1L);
            prefs.edit().remove("preferredShippingLocationId").apply();
            prefs.edit().putString("preferredShippingLocationId", Strings.toString(Long.valueOf(l))).apply();
        }
    }

    private void clearRecentlySearchedList(Context context, int i, int j)
    {
        (new SearchRecentSuggestions(context, "com.groupon.recent.locations.authority", 3)).clearHistory();
    }

    private void clearSmuggledDeals(Context context, int i, int j)
    {
        prefs.edit().putString("smuggledDeals", "").apply();
    }

    private void clearSubCategoryIdKeys(Context context, int i, int j)
    {
        prefs.edit().remove((new StringBuilder()).append(Channel.GOODS.name()).append("subcategoryId").toString()).apply();
        prefs.edit().remove((new StringBuilder()).append(Channel.NEARBY.name()).append("subcategoryId").toString()).apply();
    }

    private void convertOldCountryAndDivisionFormat(Context context, int i, int j)
        throws IOException
    {
        Object obj = prefs.getString("currentCountryData", null);
        String s = prefs.getString("currentCountryShortname", null);
        if (obj != null)
        {
            Object obj1 = (CurrentCountryManager)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager);
            obj1 = (CurrentCountryDao)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentCountryDao);
            if (Strings.equals(s, "us"))
            {
                ((CurrentCountryDao) (obj1)).saveCountry(Constants.DEFAULT_US_COUNTRY);
            } else
            if (Strings.equals(s, "ca"))
            {
                ((CurrentCountryDao) (obj1)).saveCountry(Constants.DEFAULT_CA_COUNTRY);
            } else
            {
                ObjectMapper objectmapper1 = new ObjectMapper();
                ObjectMapper objectmapper = new ObjectMapper();
                objectmapper.enableDefaultTyping();
                obj = (new CountryConverter()).fromJson((com.groupon.models.country.json.Country)objectmapper1.readValue(((String) (obj)), com/groupon/models/country/json/Country));
                objectmapper.writeValueAsString(obj);
                ((CurrentCountryDao) (obj1)).saveCountry(((Country) (obj)));
            }
        }
        prefs.edit().remove("currentCountryData").apply();
        if (i < 3592)
        {
            migrateUserCredentialToNewAccountManagerSystem(context, i, j);
        }
    }

    private void disableFirstCountrySelectionLoggingWhenUpgrading(Context context, int i, int j)
    {
        prefs.edit().putBoolean("countrySelected", true).apply();
    }

    private void doUpgrade(Context context, int i, int j)
    {
        Object obj = new ArrayList(Arrays.asList(getClass().getDeclaredMethods()));
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((Method)iterator.next()).getAnnotation(com/groupon/service/upgrade/UpgradeManager$RunIfUpgradingFrom) == null)
            {
                iterator.remove();
            }
        } while (true);
        Collections.sort(((List) (obj)), new Comparator() {

            final UpgradeManager this$0;

            public volatile int compare(Object obj1, Object obj2)
            {
                return compare((Method)obj1, (Method)obj2);
            }

            public int compare(Method method1, Method method2)
            {
                return ((RunIfUpgradingFrom)method1.getAnnotation(com/groupon/service/upgrade/UpgradeManager$RunIfUpgradingFrom)).value() - ((RunIfUpgradingFrom)method2.getAnnotation(com/groupon/service/upgrade/UpgradeManager$RunIfUpgradingFrom)).value();
            }

            
            {
                this$0 = UpgradeManager.this;
                super();
            }
        });
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Method method = (Method)((Iterator) (obj)).next();
            if (((RunIfUpgradingFrom)method.getAnnotation(com/groupon/service/upgrade/UpgradeManager$RunIfUpgradingFrom)).value() >= i)
            {
                Ln.i("Performing upgrade: %s", new Object[] {
                    method.getName()
                });
                try
                {
                    method.invoke(this, new Object[] {
                        context, Integer.valueOf(i), Integer.valueOf(j)
                    });
                    Ln.i("Finished %s", new Object[] {
                        method.getName()
                    });
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new RuntimeException(context);
                }
            }
        } while (true);
    }

    private void fireOnUpgradeSuccess()
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((UpgradeManagerListener)iterator.next()).onUpgradeSuccess()) { }
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private void forceRelogin(Context context, int i, int j)
    {
        Ln.i("Logging out to force clean encrypted sharedpreferences", new Object[0]);
        ((LoginService)RoboGuice.getInjector(context).getInstance(com/groupon/service/LoginService)).logout();
    }

    private void isUserLoggedIn(Context context, int i, int j)
    {
        if (((LoginService)RoboGuice.getInjector(context).getInstance(com/groupon/service/LoginService)).isLoggedIn())
        {
            prefs.edit().putBoolean("hasLoggedInAtleastOnce", true).apply();
        }
    }

    private void makeNotificationsSilent(Context context, int i, int j)
    {
        prefs.edit().putBoolean("silentNotifications", true).apply();
    }

    private void migrateUserCredentialToNewAccountManagerSystem(Context context, int i, int j)
    {
        CurrentCountryManager currentcountrymanager = (CurrentCountryManager)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager);
        String s = loginPrefs.getString("username", null);
        String s1 = loginPrefs.getString("password", null);
        String s2 = loginPrefs.getString("firstName", s);
        if (s != null && s1 != null)
        {
            SSOHelper.addOrUpdateAccountForApp(context, new UserCredential(s, s1, currentcountrymanager.getCurrentCountry().isoName, s2));
        }
        loginPrefs.edit().remove("username").apply();
        loginPrefs.edit().remove("password").apply();
    }

    private void removeOldGcmPreferences(Context context, int i, int j)
    {
        prefs.edit().remove("gcmAppVersion").remove("gcmTokenUploaded").remove("g1PushTokenUploaded").remove("push_division").remove("pushSubscriptionID").apply();
    }

    private void uninstallOldDailySyncAlarm(Context context, int i, int j)
    {
        ((AlarmManager)context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 200, new Intent(context, com/groupon/receiver/DailySyncer), 0x10000000));
    }

    private void upgradeFrom_15_1_removeAllOldAbTests(Context context, int i, int j)
        throws IOException
    {
        context.getSharedPreferences("abTest", 0).edit().clear().commit();
    }

    private void upgradeFrom_15_2_convertDivisionJsonCacheToPojo(Context context, int i, int j)
        throws IOException
    {
        Object obj;
        Object obj1;
        CurrentDivisionManager currentdivisionmanager;
        Object obj3;
        obj1 = divisionServiceSharedPreferences.getString("DivisionsService", null);
        if (obj1 == null)
        {
            return;
        }
        obj3 = (DivisionConverter)RoboGuice.getInjector(application).getInstance(com/groupon/models/division/converter/DivisionConverter);
        context = (ArraySharedPreferences)RoboGuice.getInjector(application).getInstance(Key.get(com/groupon/util/ArraySharedPreferences, Names.named("localizedStore")));
        currentdivisionmanager = (CurrentDivisionManager)RoboGuice.getInjector(application).getInstance(com/groupon/service/countryanddivision/CurrentDivisionManager);
        obj = context.getString("currentDivisionId", ((StaticSupportInfoService)RoboGuice.getInjector(application).getInstance(com/groupon/service/core/StaticSupportInfoService)).getSupportInfo(((CurrentCountryManager)RoboGuice.getInjector(application).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager)).getCurrentCountry()).defaultDivisionID);
        context = context.getString("currentAreaId", null);
        if (context != null)
        {
            obj = context;
        }
        context = null;
        obj1 = ((DivisionConverter) (obj3)).fromJson((com.groupon.models.division.json.Division.List)objectMapper.readValue(((String) (obj1)), new TypeReference() {

            final UpgradeManager this$0;

            
            {
                this$0 = UpgradeManager.this;
                super();
            }
        }));
        context = ((Context) (obj1));
        obj3 = ((List) (obj1)).iterator();
_L4:
        context = ((Context) (obj1));
        if (!((Iterator) (obj3)).hasNext()) goto _L2; else goto _L1
_L1:
        context = ((Context) (obj1));
        Division division = (Division)((Iterator) (obj3)).next();
        context = ((Context) (obj1));
        division.geoPoint = new GeoPoint((int)division.latE6, (int)division.lngE6);
        context = ((Context) (obj1));
        if (!Strings.equals(division.id, obj)) goto _L4; else goto _L3
_L3:
        context = ((Context) (obj1));
        currentdivisionmanager.setCurrentDivision(division);
          goto _L4
        IOException ioexception;
        ioexception;
        Ln.e(ioexception, "Error upgrading/deserializing divisions data", new Object[0]);
_L6:
        ioexception = (RecentDivisionsDao)RoboGuice.getInjector(application).getInstance(com/groupon/service/countryanddivision/RecentDivisionsDao);
        obj1 = (ArraySharedPreferences)RoboGuice.getInjector(application).getInstance(Key.get(com/groupon/util/ArraySharedPreferences, Names.named("localizedStore")));
        Object obj2 = ((ArraySharedPreferences) (obj1)).getListString("recentCities", new ArrayList());
        if (context != null)
        {
            obj2 = ((List) (obj2)).iterator();
label0:
            do
            {
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                String as[] = ((String)((Iterator) (obj2)).next()).split(":");
                String s = as[as.length - 1];
                Iterator iterator = context.iterator();
                Division division1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    division1 = (Division)iterator.next();
                } while (!division1.id.equals(s));
                ioexception.addRecentDivision(division1);
            } while (true);
        }
        break; /* Loop/switch isn't completed */
_L2:
        context = ((Context) (obj1));
        ioexception = objectMapper.writeValueAsString(obj1);
        context = ((Context) (obj1));
        divisionServiceSharedPreferences.edit().putString("DivisionServiceV2", ioexception).apply();
        context = ((Context) (obj1));
        if (true) goto _L6; else goto _L5
_L5:
        divisionServiceSharedPreferences.edit().remove("DivisionsService").apply();
        ((ArraySharedPreferences) (obj1)).edit().remove("recentCities").apply();
        application.startService(WidgetDealIntentService.newIntent(application, "android.appwidget.action.APPWIDGET_UPDATE"));
        return;
    }

    public void addListener(UpgradeManagerListener upgrademanagerlistener)
    {
        listenerList.add(upgrademanagerlistener);
    }

    public void execute(Context context)
    {
        int i = 1;
        this;
        JVM INSTR monitorenter ;
        boolean flag = prefs.getBoolean("appLaunched", false);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        prefs.edit().putBoolean("appLaunched", true).apply();
        SharedPreferences sharedpreferences;
        int j;
        j = info.versionCode;
        sharedpreferences = prefs;
        int k;
        if (!flag)
        {
            i = 0x7fffffff;
        }
        i = sharedpreferences.getInt("lastVersion", i);
        k = prefs.getInt("freshInstallVersion", 0x7fffffff);
        if (i != 0x7fffffff && j != k)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        prefs.edit().putBoolean("freshInstall", true).apply();
        prefs.edit().putInt("freshInstallVersion", j).apply();
_L1:
        Ln.i("UpgradeManager: oldVersion: %s, currentVersion: %s, isUpgrade: %s", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(flag)
        });
        if (i == j)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        prefs.edit().putInt("lastVersion", j).apply();
        if (j <= i)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        logger.logGeneralEvent("Application", "upgradeManager", String.valueOf(j), i, Logger.NULL_NST_FIELD);
        doUpgrade(context, i, j);
        prefs.edit().putBoolean("shouldLogUpgrade", true).apply();
        fireOnUpgradeSuccess();
        this;
        JVM INSTR monitorexit ;
        return;
        prefs.edit().putBoolean("freshInstall", false).apply();
          goto _L1
        context;
        throw context;
    }

    public void removeListener(UpgradeManagerListener upgrademanagerlistener)
    {
        listenerList.remove(upgrademanagerlistener);
    }

    protected void upgradeFrom_15_3_removeOldDatabase(Context context, int i, int j)
    {
        context.deleteDatabase("deals.db");
        prefs.edit().remove("base_url_cl").apply();
        prefs.edit().remove("baseUrl").apply();
    }

    protected void upgradeFrom_15_5_removeOldPreferences(Context context, int i, int j)
    {
        context = prefs.edit();
        context.remove("SPLASH_STARTUP_TIME").remove("coldStart");
        Channel achannel[] = Channel.values();
        j = achannel.length;
        for (i = 0; i < j; i++)
        {
            Channel channel = achannel[i];
            context.remove(com.groupon.util.SmuggleDealManager.SharedPrefKey.LAST_SMUGGLE_TIMESTAMP_ON_CHANNEL.format(channel.name())).remove(com.groupon.util.SmuggleDealManager.SharedPrefKey.SMUGGLED_DEALS_ON_CHANNEL.format(channel.name()));
        }

        context.apply();
    }

    protected void upgradeFrom_15_6_refreshParentlessDivision(Context context, int i, int j)
    {
        Division division;
        if (((CurrentCountryManager)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager)).getCurrentCountry().isUSACompatible())
        {
            if ((division = ((CurrentDivisionManager)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/CurrentDivisionManager)).getCurrentDivision()) != CurrentDivisionDao.DEFAULT_DIVISION && !division.hasParent())
            {
                context = (DivisionsService)RoboGuice.getInjector(context).getInstance(com/groupon/service/countryanddivision/DivisionsService);
                try
                {
                    context.refresh();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Ln.e(context);
                }
                return;
            }
        }
    }

    protected void upgradeFrom_15_7_removeOldClientCache(Context context, int i, int j)
    {
        (new File(context.getFilesDir(), "groupon-cache")).delete();
    }

    protected void upgradeFrom_15_8_recoverOriginalDivision(Context context, int i, int j)
    {
        if (i == 4530)
        {
            ContextScopedRoboInjector contextscopedroboinjector = RoboGuice.getInjector(context);
            context = (CurrentDivisionManager)contextscopedroboinjector.getInstance(com/groupon/service/countryanddivision/CurrentDivisionManager);
            Division division1 = context.getCurrentDivision();
            if (division1 != null && division1 != CurrentDivisionDao.DEFAULT_DIVISION && (division1 instanceof City) && division1.hasParent())
            {
                CurrentCountryManager currentcountrymanager = (CurrentCountryManager)contextscopedroboinjector.getInstance(com/groupon/service/countryanddivision/CurrentCountryManager);
                if (((AbTestService)contextscopedroboinjector.getInstance(com/groupon/service/core/AbTestService)).isVariantEnabled("maskDivisions1508", "on") && currentcountrymanager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i == 0)
                {
                    Division division = division1.parent;
                    division.geoPoint = new GeoPoint((int)division.latE6, (int)division.lngE6);
                    context.setCurrentDivision(division);
                }
            }
        }
    }
}
