// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.DialogInterface;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.util:
//            AppUtils

public class ExitConfirmationDialogHelper
{

    public ExitConfirmationDialogHelper()
    {
    }

    public static AmazonAlertDialog create(Context context, String s, String s1)
    {
        context = (new com.amazon.mShop.AmazonAlertDialog.Builder(context)).setTitle(com.amazon.mShop.android.lib.R.string.exit_confirmation_dialog_title).setMessage(com.amazon.mShop.android.lib.R.string.exit_confirmation_dialog_message).setNegativeButton(com.amazon.mShop.android.lib.R.string.alert_cancel_button, new android.content.DialogInterface.OnClickListener(s1) {

            final String val$refMarkerCancel;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                RefMarkerObserver.logRefMarker(refMarkerCancel);
            }

            
            {
                refMarkerCancel = s;
                super();
            }
        }).setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, new android.content.DialogInterface.OnClickListener(s) {

            final String val$refMarkerOK;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                RefMarkerObserver.logRefMarker(refMarkerOK);
                AppUtils.exitApp();
            }

            
            {
                refMarkerOK = s;
                super();
            }
        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(s1) {

            final String val$refMarkerCancel;

            public void onCancel(DialogInterface dialoginterface)
            {
                RefMarkerObserver.logRefMarker(refMarkerCancel);
            }

            
            {
                refMarkerCancel = s;
                super();
            }
        }).create();
        context.setCanceledOnTouchOutside(true);
        return context;
    }
}
