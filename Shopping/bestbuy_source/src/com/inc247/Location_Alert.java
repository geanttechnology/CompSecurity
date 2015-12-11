// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import com.inc247.ApplicationStatusModel.ApplicationLocationAlerts;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import com.inc247.constants.ChatSDKConstants;

// Referenced classes of package com.inc247:
//            ChatSDK

public class Location_Alert
{

    public Location_Alert()
    {
    }

    public static void ShowGoogleLocationAlert(String s)
    {
        ChatSDKConstants.alertDialogBuilder = new android.app.AlertDialog.Builder(ChatSDK.getSDKInstance().activity);
        ChatSDKConstants.alertDialogBuilder.setCancelable(false);
        ChatSDKConstants.alertDialogBuilder.setMessage(s).setCancelable(true).setPositiveButton("OK, Allow", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                ChatSDK.getSDKInstance().activity.startActivity(dialoginterface);
                ApplicationLocationAlerts.setLocationAlertShowingOrNot(false);
            }

        });
        (new Handler()).postDelayed(new Runnable() {

            public void run()
            {
                ChatSDKConstants.alert = ChatSDKConstants.alertDialogBuilder.create();
                ChatSDKConstants.alert.show();
                ChatSDKConstants.alert.setCanceledOnTouchOutside(false);
                ChatSDKConstants.alert.setCancelable(false);
                ApplicationLocationAlerts.setLocationAlertShowingOrNot(true);
            }

        }, 200L);
    }

    public static void showGPSDisabledAlertToUser(String s)
    {
        ChatSDKConstants.alertDialogBuilder = new android.app.AlertDialog.Builder(ChatSDK.getSDKInstance().activity);
        ChatSDKConstants.alertDialogBuilder.setCancelable(false);
        ChatSDKConstants.alertDialogBuilder.setMessage(s).setCancelable(true).setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                ChatSDK.getSDKInstance().activity.startActivity(dialoginterface);
                ApplicationLocationAlerts.setLocationAlertShowingOrNot(false);
            }

        });
        ChatSDKConstants.alertDialogBuilder.setNegativeButton("No", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ChatSDKNativeToJSBridge.data = null;
                ChatSDKConstants.isUserPermitGps = false;
                ApplicationLocationAlerts.setLocationAlertShowingOrNot(false);
                dialoginterface.cancel();
            }

        });
        (new Handler()).postDelayed(new Runnable() {

            public void run()
            {
                ChatSDKConstants.alert = ChatSDKConstants.alertDialogBuilder.create();
                if (ChatSDKConstants.isUserPermitGps)
                {
                    if (ChatSDKConstants.alert.isShowing())
                    {
                        ChatSDKConstants.alert.dismiss();
                    }
                    if (!ApplicationLocationAlerts.getLocationAlertStatus())
                    {
                        ChatSDKConstants.alert.show();
                        ChatSDKConstants.alert.setCanceledOnTouchOutside(false);
                        ChatSDKConstants.alert.setCancelable(false);
                        ApplicationLocationAlerts.setLocationAlertShowingOrNot(true);
                    } else
                    if (ChatSDKConstants.alert.isShowing())
                    {
                        ChatSDKConstants.alert.dismiss();
                        return;
                    }
                }
            }

        }, 800L);
    }
}
