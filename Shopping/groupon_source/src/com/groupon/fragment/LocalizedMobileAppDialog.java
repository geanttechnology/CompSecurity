// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.groupon.activity.IntentFactory;
import com.groupon.foundations.dialog.BaseDialogFragment;
import com.groupon.models.country.Country;
import com.groupon.models.division.City;
import com.groupon.models.division.Division;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import java.io.IOException;
import roboguice.util.Strings;

public class LocalizedMobileAppDialog extends BaseDialogFragment
    implements android.content.DialogInterface.OnClickListener
{

    private static final String INFO_KEY_ARGUMENT = "info_key_argument";
    private static final String INFO_KEY_NAME = "info_key_name";
    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private Division division;
    private DivisionUtil divisionUtil;
    private GeoPoint info;
    private IntentFactory intentFactory;
    private Logger logger;
    private String name;
    private SharedPreferences prefs;

    public LocalizedMobileAppDialog()
    {
    }

    public static LocalizedMobileAppDialog newInstance(GeoPoint geopoint, String s)
        throws IOException
    {
        LocalizedMobileAppDialog localizedmobileappdialog = new LocalizedMobileAppDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("info_key_argument", geopoint);
        bundle.putString("info_key_name", s);
        localizedmobileappdialog.setArguments(bundle);
        return localizedmobileappdialog;
    }

    private void trackDialogClick(String s, String s1)
    {
        s = (new StringBuilder()).append(s).append(", ").append(s1).toString();
        logger.logClick("", "localization_switch_accepted", "localization", s);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        switch (i)
        {
        default:
            return;

        case -1: 
            trackDialogClick(currentDivisionManager.getCurrentDivision().id, division.id);
            prefs.edit().putString("locationChangedInAppMessageId", "7834").apply();
            currentDivisionManager.setCurrentDivisionAndClearCaches(division, new Class[0]);
            startActivity(intentFactory.newSplashIntent());
            getActivity().finish();
            return;

        case -2: 
            getDialog().dismiss();
            return;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        info = (GeoPoint)getArguments().getParcelable("info_key_argument");
        name = getArguments().getString("info_key_name");
        String s;
        boolean flag;
        if (abTestService.isVariantEnabled("maskDivisions1508", "on") && currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        division = divisionUtil.getDivisionFrom(info);
        if (flag && Strings.notEmpty(name))
        {
            division = new City(division, name);
        }
        s = division.name;
        bundle = getString(0x7f08029e);
        s = getString(0x7f08029d, new Object[] {
            s
        });
        return (new com.groupon.util.GrouponAlertDialog.Builder(getActivity())).setTitle(bundle).setMessage(s).setCancelable(false).setPositiveButton(0x7f080426, this).setNegativeButton(0x7f0802a6, this).create();
    }
}
