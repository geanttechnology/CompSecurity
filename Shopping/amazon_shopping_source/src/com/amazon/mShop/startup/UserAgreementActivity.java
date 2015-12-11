// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.FeatureUtil;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.startup:
//            BaseActivity

public class UserAgreementActivity extends BaseActivity
{

    public UserAgreementActivity()
    {
    }

    public static boolean shouldShowUserAgreement()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (AppLocale.getInstance().getCurrentLocaleName().equals("zh_CN"))
        {
            flag = flag1;
            if (FeatureUtil.isFeatureEnabled("app_start_agreement_dialog"))
            {
                flag = flag1;
                if (!com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("appStartIndicationDialogNotRemindAgain", false))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void showUserAgreement(Activity activity)
    {
        final CheckBox checkBox = (CheckBox)activity.getLayoutInflater().inflate(com.amazon.mShop.android.lib.R.layout.dialog_checkbox, null);
        Object obj = new com.amazon.mShop.AmazonAlertDialog.Builder(activity);
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setTitle(com.amazon.mShop.android.lib.R.string.app_start_indication_dialog_title).setMessage(com.amazon.mShop.android.lib.R.string.app_start_indication_dialog_msg);
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setNegativeButton(com.amazon.mShop.android.lib.R.string.app_start_indication_dialog_button_agree, new android.content.DialogInterface.OnClickListener() {

            final UserAgreementActivity this$0;
            final CheckBox val$checkBox;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                if (checkBox.isChecked())
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("appStartIndicationDialogNotRemindAgain", true);
                }
                endStartupTask("taskResultSucceed");
            }

            
            {
                this$0 = UserAgreementActivity.this;
                checkBox = checkbox;
                super();
            }
        });
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setPositiveButton(com.amazon.mShop.android.lib.R.string.app_start_indication_dialog_button_disagree, new android.content.DialogInterface.OnClickListener() {

            final UserAgreementActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                AppUtils.exitApp();
                endStartupTask("taskResultFail");
            }

            
            {
                this$0 = UserAgreementActivity.this;
                super();
            }
        });
        obj = ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).create();
        ((AmazonAlertDialog) (obj)).setView(checkBox, activity.getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding_double), 0, 0, 0);
        ((AmazonAlertDialog) (obj)).setCanceledOnTouchOutside(false);
        ((AmazonAlertDialog) (obj)).setCancelable(false);
        ((AmazonAlertDialog) (obj)).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final UserAgreementActivity this$0;

            public void onDismiss(DialogInterface dialoginterface)
            {
                finishIfNotFinishing();
            }

            
            {
                this$0 = UserAgreementActivity.this;
                super();
            }
        });
        ((AmazonAlertDialog) (obj)).show();
    }

    public static void startActivity(Activity activity, String s)
    {
        StartupActivity.startActivityForStartup(activity, new Intent(activity, com/amazon/mShop/startup/UserAgreementActivity), s);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        showUserAgreement(this);
    }
}
