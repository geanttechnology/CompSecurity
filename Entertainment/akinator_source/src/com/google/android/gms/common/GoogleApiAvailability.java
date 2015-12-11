// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.google.android.gms.common.internal.zzn;

// Referenced classes of package com.google.android.gms.common:
//            GooglePlayServicesUtil, GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException

public class GoogleApiAvailability
{

    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final GoogleApiAvailability zzaab = new GoogleApiAvailability();

    GoogleApiAvailability()
    {
    }

    public static GoogleApiAvailability getInstance()
    {
        return zzaab;
    }

    private String zzk(Context context, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("gcore_");
        stringbuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        stringbuilder.append("-");
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        stringbuilder.append("-");
        if (context != null)
        {
            stringbuilder.append(context.getPackageName());
        }
        stringbuilder.append("-");
        if (context != null)
        {
            try
            {
                stringbuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        return stringbuilder.toString();
    }

    public Dialog getErrorDialog(Activity activity, int i, int j)
    {
        return GooglePlayServicesUtil.getErrorDialog(i, activity, j);
    }

    public Dialog getErrorDialog(Activity activity, int i, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return GooglePlayServicesUtil.getErrorDialog(i, activity, j, oncancellistener);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int j)
    {
        return zza(context, i, j, null);
    }

    public final String getErrorString(int i)
    {
        return GooglePlayServicesUtil.getErrorString(i);
    }

    public String getOpenSourceSoftwareLicenseInfo(Context context)
    {
        return GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context)
    {
        int j = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        int i = j;
        if (GooglePlayServicesUtil.zzd(context, j))
        {
            i = 18;
        }
        return i;
    }

    public final boolean isUserResolvableError(int i)
    {
        return GooglePlayServicesUtil.isUserRecoverableError(i);
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int j)
    {
        return GooglePlayServicesUtil.showErrorDialogFragment(i, activity, j);
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        return GooglePlayServicesUtil.showErrorDialogFragment(i, activity, j, oncancellistener);
    }

    public void showErrorNotification(Context context, int i)
    {
        GooglePlayServicesUtil.showErrorNotification(i, context);
    }

    public Dialog zza(Activity activity, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        Object obj1 = new ProgressBar(activity, null, 0x101007a);
        ((ProgressBar) (obj1)).setIndeterminate(true);
        ((ProgressBar) (obj1)).setVisibility(0);
        Object obj = new android.app.AlertDialog.Builder(activity);
        ((android.app.AlertDialog.Builder) (obj)).setView(((android.view.View) (obj1)));
        obj1 = GooglePlayServicesUtil.zzaf(activity);
        ((android.app.AlertDialog.Builder) (obj)).setMessage(activity.getResources().getString(com.google.android.gms.R.string.common_google_play_services_updating_text, new Object[] {
            obj1
        }));
        ((android.app.AlertDialog.Builder) (obj)).setTitle(com.google.android.gms.R.string.common_google_play_services_updating_title);
        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton("", null);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        GooglePlayServicesUtil.zza(activity, oncancellistener, "GooglePlayServicesUpdatingDialog", ((Dialog) (obj)));
        return ((Dialog) (obj));
    }

    public PendingIntent zza(Context context, int i, int j, String s)
    {
        s = zza(context, i, s);
        if (s == null)
        {
            return null;
        } else
        {
            return PendingIntent.getActivity(context, j, s, 0x10000000);
        }
    }

    public Intent zza(Context context, int i, String s)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
            return zzn.zzw("com.google.android.gms", zzk(context, s));

        case 42: // '*'
            return zzn.zzpo();

        case 3: // '\003'
            return zzn.zzco("com.google.android.gms");
        }
    }

    public void zzab(Context context)
        throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
    {
        GooglePlayServicesUtil.zzaa(context);
    }

    public void zzac(Context context)
    {
        GooglePlayServicesUtil.zzac(context);
    }

    public Intent zzbi(int i)
    {
        return zza(null, i, null);
    }

    public boolean zzd(Context context, int i)
    {
        return GooglePlayServicesUtil.zzd(context, i);
    }

    public boolean zzj(Context context, String s)
    {
        return GooglePlayServicesUtil.zzj(context, s);
    }

    static 
    {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
