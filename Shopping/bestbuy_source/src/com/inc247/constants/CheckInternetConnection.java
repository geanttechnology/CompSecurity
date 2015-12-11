// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.constants;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.inc247.constants:
//            ChatSDKConstants

public class CheckInternetConnection
{

    public CheckInternetConnection()
    {
    }

    public static void ShowInternetConnectionLossAlert(Context context)
    {
        ChatSDKConstants.alertDialogBuilder = new android.app.AlertDialog.Builder(context);
        ChatSDKConstants.alertDialogBuilder.setCancelable(false);
        ChatSDKConstants.alertDialogBuilder.setMessage("Check Internet Connection!!").setCancelable(true).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ChatSDKConstants.alert = ChatSDKConstants.alertDialogBuilder.create();
                ChatSDKConstants.alert.dismiss();
            }

        });
        ChatSDKConstants.alert = ChatSDKConstants.alertDialogBuilder.create();
        ChatSDKConstants.alert.show();
    }

    public static boolean isConnected(Activity activity)
    {
        activity = ((ConnectivityManager)activity.getSystemService("connectivity")).getActiveNetworkInfo();
        return activity != null && activity.isConnected();
    }
}
