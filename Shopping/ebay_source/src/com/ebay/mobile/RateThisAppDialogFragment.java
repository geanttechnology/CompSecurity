// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.ebay.common.Preferences;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.GregorianCalendar;

// Referenced classes of package com.ebay.mobile:
//            MyApp

public class RateThisAppDialogFragment extends DialogFragment
    implements android.content.DialogInterface.OnClickListener
{

    public static String FRAGMENT_MANAGER_TAG = "rate_this_app";

    public RateThisAppDialogFragment()
    {
    }

    public static void cleanupRateAppPreferences()
    {
        Preferences preferences = MyApp.getPrefs();
        preferences.removeUserPref("rateAppBinAction");
        preferences.removeUserPref("rateAppInstallDate");
        preferences.removeUserPref("rateAppLaunchCount");
        preferences.removeUserPref("rateAppListAction");
        preferences.removeUserPref("rateAppUserSaidNo");
        preferences.removeUserPref("rateAppUserSaidYes");
        preferences.setUserPref(System.currentTimeMillis(), "rateAppInstallDate");
    }

    public static boolean shouldShowDialog()
    {
        Preferences preferences;
        Object obj;
        preferences = MyApp.getPrefs();
        obj = DeviceConfiguration.getAsync();
        break MISSING_BLOCK_LABEL_8;
        if (((DeviceConfiguration) (obj)).get(com.ebay.mobile.dcs.Dcs.Verticals.B.rateThisApp) && !preferences.getUserPref("rateAppUserSaidNo", false) && !preferences.getUserPref("rateAppUserSaidYes", false))
        {
            int i = preferences.getUserPref("rateAppLaunchCount", 0) + 1;
            if (i < 5)
            {
                preferences.setUserPref(i, "rateAppLaunchCount");
                return false;
            }
            long l = preferences.getUserPref("rateAppInstallDate", 0L);
            if (l == 0L)
            {
                preferences.setUserPref(System.currentTimeMillis(), "rateAppInstallDate");
                return false;
            }
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            gregoriancalendar.setTimeInMillis(l);
            gregoriancalendar.add(6, ((DeviceConfiguration) (obj)).get(com.ebay.mobile.dcs.Dcs.Verticals.I.rateThisAppLaterDaysDelay));
            obj = new GregorianCalendar();
            ((GregorianCalendar) (obj)).setTimeInMillis(System.currentTimeMillis());
            if (((GregorianCalendar) (obj)).compareTo(gregoriancalendar) >= 0)
            {
                boolean flag;
                if (preferences.getUserPref("rateAppBinAction", false) || preferences.getUserPref("rateAppListAction", false))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = MyApp.getPrefs();
        switch (i)
        {
        default:
            return;

        case -2: 
            dialoginterface.setUserPref(true, "rateAppUserSaidNo");
            return;

        case -3: 
            dialoginterface.setUserPref(System.currentTimeMillis(), "rateAppInstallDate");
            return;

        case -1: 
            dialoginterface.setUserPref(true, "rateAppUserSaidYes");
            break;
        }
        dialoginterface = getActivity().getPackageName();
        try
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(dialoginterface).toString())));
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("https://play.google.com/store/apps/details?id=").append(dialoginterface).toString())));
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.support.v7.app.AlertDialog.Builder(getActivity());
        bundle.setMessage(0x7f0708cf).setPositiveButton(0x7f0708ce, this).setNegativeButton(0x7f0708d0, this).setNeutralButton(0x7f0708d1, this);
        return bundle.create();
    }

}
