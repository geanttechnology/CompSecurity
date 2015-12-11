// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import com.amazon.geo.mapsv2.internal.IErrorDialogUtil;
import com.amazon.geo.mapsv2.util.ErrorDialogFragment;
import java.util.List;
import java.util.Locale;

public final class MapsErrorDialogUtil
    implements IErrorDialogUtil
{

    public MapsErrorDialogUtil()
    {
    }

    private static boolean canUserInitiateCheckForUpdates(Context context)
    {
        return getSystemUpdatesIntent(context) != null;
    }

    private static android.content.DialogInterface.OnClickListener getConfirmationActionListener(PendingIntent pendingintent)
    {
        if (pendingintent != null)
        {
            return new android.content.DialogInterface.OnClickListener(pendingintent) {

                final PendingIntent val$intent;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    try
                    {
                        intent.send();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (DialogInterface dialoginterface)
                    {
                        return;
                    }
                }

            
            {
                intent = pendingintent;
                super();
            }
            };
        } else
        {
            return new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            };
        }
    }

    private static String getErrorMessage(int i, Context context)
    {
        Resources resources = context.getResources();
        switch (i)
        {
        default:
            return String.format("Code: %d", new Object[] {
                Integer.valueOf(i)
            });

        case 2: // '\002'
            if (canUserInitiateCheckForUpdates(context))
            {
                return resources.getString(com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_update_message);
            } else
            {
                return resources.getString(com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_update_manual_message);
            }

        case 1: // '\001'
            break;
        }
        if (canUserInitiateCheckForUpdates(context))
        {
            return resources.getString(com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_missing_message);
        } else
        {
            return resources.getString(com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_missing_manual_message);
        }
    }

    private static String getErrorTitle(int i, Context context)
    {
        context = context.getResources();
        switch (i)
        {
        default:
            return context.getString(com.amazon.geo.mapsv2.support.R.string.amazon_maps_unhandled_title);

        case 2: // '\002'
            return context.getString(com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_update_title);

        case 1: // '\001'
            return context.getString(com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_missing_title);
        }
    }

    private static Intent getSystemUpdatesIntent(Context context)
    {
        Intent intent;
        if ("kodiak".equalsIgnoreCase(Build.DEVICE) && android.os.Build.VERSION.SDK_INT == 17)
        {
            intent = null;
        } else
        {
            intent = new Intent("com.android.settings.SYSTEM_UPDATES");
            intent.setPackage("com.android.settings");
            List list = context.getPackageManager().queryIntentActivities(intent, 0);
            if (list == null || list.isEmpty())
            {
                intent = new Intent();
                intent.setClassName("com.android.settings", "com.amazon.settings.systemupdates.SystemUpdatesActivity");
                context = context.getPackageManager().queryIntentActivities(intent, 0);
                if (context == null || context.isEmpty())
                {
                    return null;
                }
            }
        }
        return intent;
    }

    public Dialog getErrorDialog(int i, Activity activity, int j)
    {
        return getErrorDialog(i, activity, j, null);
    }

    public Dialog getErrorDialog(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (i == 0)
        {
            return null;
        }
        PendingIntent pendingintent = getErrorPendingIntent(i, activity, j);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        if (oncancellistener != null)
        {
            builder.setOnCancelListener(oncancellistener);
        }
        builder.setTitle(getErrorTitle(i, activity));
        builder.setMessage(getErrorMessage(i, activity));
        if (pendingintent == null)
        {
            i = 0x104000a;
        } else
        {
            i = com.amazon.geo.mapsv2.support.R.string.amazon_maps_update;
        }
        builder.setPositiveButton(i, getConfirmationActionListener(pendingintent));
        return builder.create();
    }

    public PendingIntent getErrorPendingIntent(int i, Context context, int j)
    {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 26
    //                   2 26;
           goto _L1 _L2 _L2
_L1:
        Intent intent;
        return null;
_L2:
        if ((intent = getSystemUpdatesIntent(context)) != null)
        {
            return PendingIntent.getActivity(context, j, intent, 0x8000000);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public String getErrorString(int i)
    {
        switch (i)
        {
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        default:
            return String.format(Locale.getDefault(), "unknown status code %d", new Object[] {
                Integer.valueOf(i)
            });

        case 0: // '\0'
            return "SUCCESS";

        case 1: // '\001'
            return "SERVICE_MISSING";

        case 2: // '\002'
            return "SERVICE_VERSION_UPDATE_REQUIRED";

        case 3: // '\003'
            return "SERVICE_DISABLED";

        case 4: // '\004'
            return "SIGN_IN_REQUIRED";

        case 5: // '\005'
            return "INVALID_ACCOUNT";

        case 6: // '\006'
            return "RESOLUTION_REQUIRED";

        case 7: // '\007'
            return "NETWORK_ERROR";

        case 8: // '\b'
            return "INTERNAL_ERROR";

        case 9: // '\t'
            return "SERVICE_INVALID";

        case 16: // '\020'
            return "API_UNAVAILABLE";

        case 10: // '\n'
            return "DEVELOPER_ERROR";

        case 11: // '\013'
            return "LICENSE_CHECK_FAILED";

        case 12: // '\f'
            return "DATE_INVALID";
        }
    }

    public String getOpenSourceSoftwareLicenseInfo(Context context)
    {
        return "";
    }

    public boolean isUserRecoverableError(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

    public boolean showErrorDialogFragment(int i, Activity activity, int j)
    {
        return showErrorDialogFragment(i, activity, j, null);
    }

    public boolean showErrorDialogFragment(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (i == 0)
        {
            return false;
        } else
        {
            Dialog dialog = getErrorDialog(i, activity, j);
            ErrorDialogFragment.newInstance(dialog, oncancellistener).show(activity.getFragmentManager(), "AmazonMapsErrorDialog");
            return dialog.isShowing();
        }
    }

    public void showErrorNotification(int i, Context context)
    {
        android.app.Notification.Builder builder = new android.app.Notification.Builder(context);
        builder.setContentTitle(getErrorTitle(i, context));
        builder.setContentText(getErrorMessage(i, context));
        builder.setContentIntent(getErrorPendingIntent(i, context, 0));
        ((NotificationManager)context.getSystemService("notification")).notify(getErrorString(i), 0, builder.getNotification());
    }
}
