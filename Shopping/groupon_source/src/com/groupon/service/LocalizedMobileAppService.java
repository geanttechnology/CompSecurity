// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import com.groupon.abtest.LocalizedMobileAppAbTestHelper;
import com.groupon.activity.IntentFactory;
import com.groupon.foundations.service.BaseIntentService;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CountriesService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.util.NotificationBuilderUtil;
import com.groupon.util.ObjectMapperWrapper;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import roboguice.inject.ContextScopedProvider;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class LocalizedMobileAppService extends BaseIntentService
{

    private static final int NOTIFICATION_TYPE;
    private static final long WAIT_TIME = 0xdbba00L;
    private AbTestService abTestService;
    private CountriesService countriesService;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    protected ContextScopedProvider divisionsServiceProvider;
    private GeoUtils geoUtils;
    private Geocoder geocoder;
    private IntentFactory intentFactory;
    private LocalizedMobileAppAbTestHelper localizedMobileAppAbTestHelper;
    private com.groupon.abtest.LocalizedMobileAppAbTestHelper.LocalizedMobileAppVariant localizedMobileVariant;
    private NotificationManager notificationManager;
    private ObjectMapperWrapper om;
    private SharedPreferences prefs;

    public LocalizedMobileAppService()
    {
        this(com/groupon/service/LocalizedMobileAppService.getCanonicalName());
    }

    public LocalizedMobileAppService(String s)
    {
        super(s);
    }

    private Notification createNotification()
    {
        Object obj = (new android.support.v4.app.NotificationCompat.Builder(this)).setContentTitle(getString(0x7f0802a2)).setContentText(getString(0x7f0802a1)).setContentIntent(getPendingIntent());
        NotificationBuilderUtil.setupNotificationIcon(getApplicationContext(), ((android.support.v4.app.NotificationCompat.Builder) (obj)));
        obj = ((android.support.v4.app.NotificationCompat.Builder) (obj)).build();
        obj.flags = ((Notification) (obj)).flags | 0x10;
        return ((Notification) (obj));
    }

    private PendingIntent getPendingIntent()
    {
        return PendingIntent.getActivity(this, 0, intentFactory.newCarouselIntent(), 0);
    }

    protected void onHandleIntent(Intent intent)
    {
        Object obj;
        Object obj1;
        Ln.d("LocalizedMobileApp: %s:onHandleLocationUpdated", new Object[] {
            com/groupon/service/LocalizedMobileAppService.getSimpleName()
        });
        localizedMobileVariant = localizedMobileAppAbTestHelper.getLocalizedMobileVariant();
        obj1 = (LocationInfo)intent.getSerializableExtra("com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo");
        intent = new GeoPoint((int)((double)((LocationInfo) (obj1)).lastLat * 1000000D), (int)((double)((LocationInfo) (obj1)).lastLong * 1000000D));
        obj = null;
        if (geoUtils.milesBetween(intent, currentDivisionManager.getCurrentDivision().geoPoint) >= (double)localizedMobileVariant.getMiles()) goto _L2; else goto _L1
_L1:
        Ln.d("LocalizedMobileApp: User is within %f miles of current division.", new Object[] {
            Float.valueOf(localizedMobileVariant.getMiles())
        });
_L5:
        return;
_L2:
        obj1 = geocoder.getFromLocation(((LocationInfo) (obj1)).lastLat, ((LocationInfo) (obj1)).lastLong, 1);
        obj = obj1;
_L3:
        if (obj == null || ((List) (obj)).size() == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = Strings.toString(((Address)((List) (obj)).get(0)).getCountryCode()).toLowerCase();
        if (!countriesService.getKnownCountries().contains(obj))
        {
            obj = "";
        }
        if (Strings.isEmpty(obj))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = currentCountryManager.getCurrentCountry();
        if (obj1 == null)
        {
            Ln.d("Current country is null. %s ends", new Object[] {
                com/groupon/service/LocalizedMobileAppService.getCanonicalName()
            });
            return;
        }
        break MISSING_BLOCK_LABEL_256;
        obj1;
        geoUtils.logGeocodeException(((Exception) (obj1)), com/groupon/service/LocalizedMobileAppService.getSimpleName());
          goto _L3
        boolean flag;
        long l;
        Object obj2 = ((Country) (obj1)).shortName;
        Ln.d("LocalizedMobileApp: Current country: %s", new Object[] {
            obj1
        });
        l = System.currentTimeMillis();
        if (!Strings.equals(obj2, obj))
        {
            Ln.d("LocalizedMobileApp: Country change not supported", new Object[0]);
            return;
        }
        obj2 = ((DivisionUtil)divisionsServiceProvider.get(this)).getDivisionFrom(intent);
        Ln.d("LocalizedMobileApp: Division: division= %s, country = %s", new Object[] {
            obj2, obj
        });
        if (obj2 == null)
        {
            Ln.d("LocalizedMobileApp: Division is null. Exiting", new Object[0]);
            return;
        }
        Ln.d("LocalizedMobileApp: Division: division= %s, country = %s area=%s", new Object[] {
            ((Division) (obj2)).getIdOrParentId(), obj, ((Division) (obj2)).id
        });
        long l1 = ((Division) (obj2)).latE6;
        long l3 = ((Division) (obj2)).lngE6;
        if (l1 == 0L || l3 == 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new GeoPoint((int)l1, (int)l3);
        if (geoUtils.milesBetween(intent, ((GeoPoint) (obj))) > (double)localizedMobileVariant.getMiles())
        {
            Ln.d("LocalizedMobileApp: User is not within %f miles radius of the nearest division.", new Object[] {
                Float.valueOf(localizedMobileVariant.getMiles())
            });
            return;
        }
        if (abTestService.isVariantEnabled("maskDivisions1508", "on") && ((Country) (obj1)).isLocationsAutocompleteEnabledCountry())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((Division) (obj2)).id.equals(prefs.getString("locationChangedPossibleNewDivision", "")))
        {
            break MISSING_BLOCK_LABEL_627;
        }
        obj1 = prefs.edit();
        try
        {
            obj1 = ((android.content.SharedPreferences.Editor) (obj1)).putLong("locationChangedTimer", l).putString("locationChangedPossibleNewDivision", ((Division) (obj2)).id);
            obj2 = om;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            throw new RuntimeException(intent);
        }
        if (!flag)
        {
            intent = ((Intent) (obj));
        }
        ((android.content.SharedPreferences.Editor) (obj1)).putString("locationChangedInfoJson", ((ObjectMapperWrapper) (obj2)).writeValueAsString(intent)).apply();
        Ln.d("LocalizedMobileApp: Storing current location", new Object[0]);
        return;
        long l2 = prefs.getLong("locationChangedTimer", l);
        Ln.d((new StringBuilder()).append("LocalizedMobileApp: Times here: ").append(l).append(" last recorded at: ").append(l2).toString(), new Object[0]);
        if (l - l2 >= 0xdbba00L)
        {
            Ln.d("LocalizedMobileApp: The 4 hour condition has been met. Checking if notification was shown already.", new Object[0]);
            if (!flag)
            {
                intent = ((Intent) (obj));
            }
            try
            {
                showNotification(intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                throw new RuntimeException(intent);
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void showNotification(GeoPoint geopoint)
        throws IOException
    {
        long l = Calendar.getInstance().get(6);
        if (l != prefs.getLong("localiizedMobileAppNotificationTimer", -1L))
        {
            prefs.edit().putLong("localiizedMobileAppNotificationTimer", l).putBoolean("locationChangedNeedsToShowDialog", true).putString("locationChangedInfoJson", om.writeValueAsString(geopoint)).apply();
            Ln.d("LocalizedMobileApp: Showing notification now", new Object[0]);
            notificationManager.notify(NOTIFICATION_TYPE, createNotification());
        }
    }

    static 
    {
        NOTIFICATION_TYPE = com.groupon.Constants.Notification.NotificationType.LOCALIZED_MOBILE_APP_NOTIFICATION.getId();
    }
}
