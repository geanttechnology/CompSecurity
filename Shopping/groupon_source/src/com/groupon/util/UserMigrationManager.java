// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.groupon.activity.IntentFactory;
import com.groupon.events.EventAcceptor;
import com.groupon.events.EventVisitor;
import com.groupon.models.country.Country;
import com.groupon.service.UserMigrationController;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

public class UserMigrationManager
{

    public static final String DISMISS_ID = "USER_MIGRATION_DISMISS_ID";
    public static final String LAST_REMINDER_KEY = "USER_MIGRATION_LAST_REMINDER_KEY";
    public static final String USER_MIGRATION_DISABLED_NOTIFICATION = "userMigrationDisabledNotification";
    private AbTestService abTestService;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private boolean dismissed;
    private Lazy eventLogger;
    private Lazy intentFactory;
    private SharedPreferences prefs;

    public UserMigrationManager()
    {
        dismissed = false;
    }

    private Intent createDownloadIntent(String s)
    {
        if ("on".equalsIgnoreCase(s))
        {
            return ((IntentFactory)intentFactory.get()).newAPACDownloadIntent();
        } else
        {
            return ((IntentFactory)intentFactory.get()).newMarketDownloadIntent(s);
        }
    }

    private String fetchForcedExperiment(Country country)
    {
        return abTestService.getVariant((new StringBuilder()).append("tigersForce1504").append(country.shortName.toUpperCase()).toString());
    }

    private String fetchSuggestedExperiment(Country country)
    {
        return abTestService.getVariant((new StringBuilder()).append("tigersPrompt1504").append(country.shortName.toUpperCase()).toString());
    }

    private UserMigrationController findSpecificVariant(Country country)
    {
        String s = fetchForcedExperiment(country);
        if (!Strings.isEmpty(s) && !"Original".equalsIgnoreCase(s))
        {
            return com.groupon.service.UserMigrationController.MigrationControllerType.FORCED_MIGRATION.instance();
        }
        country = fetchSuggestedExperiment(country);
        if (!Strings.isEmpty(country) && !"Original".equalsIgnoreCase(country) && !isPostponed())
        {
            return com.groupon.service.UserMigrationController.MigrationControllerType.SUGGESTED_MIGRATION.instance();
        } else
        {
            return com.groupon.service.UserMigrationController.MigrationControllerType.NOT_APPLICABLE.instance();
        }
    }

    private void init()
    {
        eventLogger = new Lazy(context) {

            final UserMigrationManager this$0;

            
            {
                this$0 = UserMigrationManager.this;
                super(context1);
            }
        };
        intentFactory = new Lazy(context) {

            final UserMigrationManager this$0;

            
            {
                this$0 = UserMigrationManager.this;
                super(context1);
            }
        };
    }

    private boolean isNotApplicable(Country country)
    {
        return country == null || Strings.isEmpty(country.shortName) || !country.isAPACMigrate();
    }

    public UserMigrationController build(Activity activity)
    {
        UserMigrationController usermigrationcontroller = createController();
        if (!dismissed && usermigrationcontroller.isEnabled())
        {
            usermigrationcontroller.setup(new com.groupon.fragment.UserMigrationDialogFragment.Builder()).show(activity);
        }
        return usermigrationcontroller;
    }

    public UserMigrationController createController()
    {
        Object obj = currentCountryManager.getCurrentCountry();
        boolean flag;
        if (isNotApplicable(((Country) (obj))))
        {
            obj = com.groupon.service.UserMigrationController.MigrationControllerType.NOT_APPLICABLE.instance();
        } else
        {
            obj = findSpecificVariant(((Country) (obj)));
        }
        flag = ((UserMigrationController) (obj)).hasNotificationsDisabled();
        if (flag != prefs.getBoolean("userMigrationDisabledNotification", false))
        {
            prefs.edit().putBoolean("userMigrationDisabledNotification", flag).apply();
        }
        return ((UserMigrationController) (obj));
    }

    public UserMigrationController createController(String s)
    {
        s = UserMigrationController.instantiate(s);
        s.attachManager(this);
        return s;
    }

    public Intent createForcedMigrationDownloadIntent()
    {
        return createDownloadIntent(fetchForcedExperiment(currentCountryManager.getCurrentCountry()));
    }

    public Intent createSuggestedMigrationDownloadIntent()
    {
        return createDownloadIntent(fetchSuggestedExperiment(currentCountryManager.getCurrentCountry()));
    }

    public boolean isPostponed()
    {
        return prefs.getLong("USER_MIGRATION_LAST_REMINDER_KEY", System.currentTimeMillis()) > System.currentTimeMillis();
    }

    public void notifyOnEvent(EventAcceptor eventacceptor)
    {
        eventacceptor.accept((EventVisitor)eventLogger.get());
    }

    public void onDialogDismissed()
    {
        dismissed = true;
    }

    public void postpone(long l)
    {
        prefs.edit().putLong("USER_MIGRATION_LAST_REMINDER_KEY", System.currentTimeMillis() + l).apply();
    }

    public void restoreState(Bundle bundle)
    {
        if (bundle != null)
        {
            dismissed = bundle.getBoolean("USER_MIGRATION_DISMISS_ID");
        }
    }

    public void saveState(Bundle bundle)
    {
        bundle.putBoolean("USER_MIGRATION_DISMISS_ID", dismissed);
    }
}
