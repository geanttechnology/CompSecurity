// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.inject.Injector;
import com.groupon.activity.Countries;
import com.groupon.activity.IntentFactory;
import com.groupon.models.country.Country;
import com.groupon.service.UserMigrationController;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ContextUtils;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.UserMigrationManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import roboguice.RoboGuice;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            UserMigrationDialogFragment

public static class redirectIfNotOnCountries
{

    private Bundle configuration;
    private UserMigrationController controller;
    private int defaultMessageId;
    private int japanSpecificMessageId;
    private boolean redirectIfNotOnCountries;
    private List showableOn;
    private String tag;

    private String constructMessage(Activity activity, String s, int i, int j)
    {
        int k = ContextUtils.getIdentifier(activity, (new StringBuilder()).append(Strings.toString(s).toLowerCase()).append("_display_name").toString(), "string");
        if (!hasSpecificMessage(s))
        {
            i = j;
        }
        activity = activity.getResources();
        if (k != 0)
        {
            return activity.getString(i, new Object[] {
                activity.getString(k)
            });
        } else
        {
            return "";
        }
    }

    private boolean hasSpecificMessage(String s)
    {
        return Strings.equalsIgnoreCase(Locale.getDefault().getCountry(), "jp") && Strings.equalsIgnoreCase(s, "jp");
    }

    public hasSpecificMessage attachController(UserMigrationController usermigrationcontroller)
    {
        controller = usermigrationcontroller;
        return this;
    }

    public controller redirectIfNotOnCountries()
    {
        redirectIfNotOnCountries = true;
        return this;
    }

    public redirectIfNotOnCountries setTag(String s)
    {
        tag = s;
        return this;
    }

    public tag setupAsForced()
    {
        configuration.putString("dialog_tag", com.groupon.service.trollerType.FORCED_MIGRATION.name());
        configuration.putInt("dialog_positive_button_text_res_id", 0x7f080439);
        configuration.putInt("dialog_negative_button_text_res_id", 0x7f0800ac);
        japanSpecificMessageId = 0x7f08047f;
        defaultMessageId = 0x7f0801c6;
        return this;
    }

    public defaultMessageId setupAsSuggestion()
    {
        configuration.putString("dialog_tag", com.groupon.service.trollerType.SUGGESTED_MIGRATION.name());
        configuration.putInt("dialog_positive_button_text_res_id", 0x7f080439);
        configuration.putInt("dialog_negative_button_text_res_id", 0x7f080248);
        japanSpecificMessageId = 0x7f080480;
        defaultMessageId = 0x7f0803c5;
        return this;
    }

    public boolean show(Activity activity)
    {
        roboguice.inject.ContextScopedRoboInjector contextscopedroboinjector = RoboGuice.getInjector(activity);
        return show(activity, (IntentFactory)contextscopedroboinjector.getInstance(com/groupon/activity/IntentFactory), (UserMigrationManager)contextscopedroboinjector.getInstance(com/groupon/util/UserMigrationManager), (CurrentCountryManager)contextscopedroboinjector.getInstance(com/groupon/service/countryanddivision/CurrentCountryManager));
    }

    public boolean show(Activity activity, IntentFactory intentfactory, UserMigrationManager usermigrationmanager, CurrentCountryManager currentcountrymanager)
    {
        if (redirectIfNotOnCountries && !(activity instanceof Countries))
        {
            activity.startActivity(intentfactory.redirectToCountries());
        } else
        if (!activity.isFinishing() && showableOn.contains(activity.getClass().getCanonicalName()))
        {
            intentfactory = activity.getFragmentManager();
            UserMigrationDialogFragment usermigrationdialogfragment = (UserMigrationDialogFragment)intentfactory.findFragmentByTag(tag);
            if (usermigrationdialogfragment == null || usermigrationdialogfragment.getActivity() != activity)
            {
                controller.attachManager(usermigrationmanager);
                usermigrationmanager = new UserMigrationDialogFragment();
                currentcountrymanager = currentcountrymanager.getCurrentCountry().shortName;
                configuration.putString("dialog_title", constructMessage(activity, currentcountrymanager, 0x7f080481, 0x7f0803fc));
                configuration.putString("dialog_message", constructMessage(activity, currentcountrymanager, japanSpecificMessageId, defaultMessageId));
                usermigrationmanager.setArguments(configuration);
                usermigrationmanager.setCancelable(false);
                usermigrationmanager.setController(controller);
                GrouponDialogFragment.show(intentfactory, usermigrationmanager, tag);
                return true;
            }
        }
        return false;
    }

    public tag showableOn(Class class1)
    {
        showableOn.add(class1.getCanonicalName());
        return this;
    }

    public ger()
    {
        configuration = new Bundle();
        showableOn = new ArrayList();
        redirectIfNotOnCountries = false;
    }
}
