// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.upgrade.UpgradeController;
import com.amazon.mShop.upgrade.UpgradeSubscriberAdapter;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.mShop.UpgradeInfo;

// Referenced classes of package com.amazon.mShop.util:
//            AttributionUtils, ThirdPartyActivityUtils, ActivityUtils, AppUtils

public class UpgradeUtil
{

    public UpgradeUtil()
    {
    }

    public static void checkForUpgrade()
    {
        UpgradeController upgradecontroller = new UpgradeController();
        upgradecontroller.setSubscriber(new UpgradeSubscriberAdapter());
        upgradecontroller.checkForUpgrade(null);
    }

    public static void checkForUpgradeLater()
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putLong("upgradeLastCheckTime", System.currentTimeMillis());
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            public void run()
            {
                UpgradeUtil.checkForUpgrade();
            }

        }, 30000L);
    }

    public static boolean checkTimeout(long l, long l1)
    {
        return Math.abs(System.currentTimeMillis() - l) > l1;
    }

    public static void clearNewUpgradeInfo()
    {
        AndroidPlatform.getInstance().getDataStore().putBoolean("upgradeShouldShowDialog", false);
    }

    private static String formatDialogMessage(Context context, int i)
    {
        String s = context.getString(i);
        boolean flag = Features.getInstance().isFeatureActivated("Android_UpgradeThruAppstore");
        if (AppstoreUtils.isAppstoreAvailable() && flag)
        {
            return s;
        }
        String s1 = AttributionUtils.readAssociatesTag(context, AndroidPlatform.getInstance().getDataStore(), true);
        if (s1.equals(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_google_play_prefix)) && ThirdPartyActivityUtils.checkGooglePackage())
        {
            context = (new StringBuilder()).append(s).append(" ").append(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_dialog_visit_googleplay)).toString();
        } else
        if (s1.equals(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_amazon_appstore_prefix)) && ThirdPartyActivityUtils.checkAmazonAppstorePackage())
        {
            context = (new StringBuilder()).append(s).append(" ").append(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_dialog_visit_amazonappstore)).toString();
        } else
        {
            context = (new StringBuilder()).append(s).append(" ").append(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_dialog_general_store)).toString();
        }
        return context;
    }

    private static String getASINforPackage()
    {
        String s1 = AndroidPlatform.getInstance().getApplicationContext().getPackageName();
        String s = "B004GJDQT8";
        if (s1.startsWith("de"))
        {
            s = "B00N2DG1UA";
        } else
        if (s1.startsWith("uk"))
        {
            return "B00N2DM6I6";
        }
        return s;
    }

    private static void goToAppstoreApp()
    {
        if (ThirdPartyActivityUtils.checkAmazonAppstorePackage())
        {
            ThirdPartyActivityUtils.startAmazonAppStore();
            return;
        } else
        {
            ThirdPartyActivityUtils.installAmazonAppStore();
            return;
        }
    }

    public static void goToUpgradePage()
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        boolean flag = Features.getInstance().isFeatureActivated("Android_UpgradeThruAppstore");
        if (AppstoreUtils.isAppstoreAvailable())
        {
            if (flag)
            {
                ActivityUtils.startAppstoreActivityWithAsinAndFlag(context, getASINforPackage(), null, null, null, 0x10000000);
                return;
            } else
            {
                goToUpgradePageBaseOnAssoHandler(context);
                return;
            }
        }
        if (isFromGooglePlay(context) && flag)
        {
            goToAppstoreApp();
            return;
        } else
        {
            goToUpgradePageBaseOnAssoHandler(context);
            return;
        }
    }

    private static void goToUpgradePageBaseOnAssoHandler(Context context)
    {
        String s = AttributionUtils.getTrimmedAssociateTag(context, AndroidPlatform.getInstance().getDataStore(), true);
        if (isFromGooglePlay(context))
        {
            ThirdPartyActivityUtils.startGooglePlay();
            return;
        }
        if (s.equals(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_amazon_appstore_prefix)))
        {
            goToAppstoreApp();
            return;
        }
        if (ThirdPartyActivityUtils.isCnPackage())
        {
            ThirdPartyActivityUtils.openAmazonAppHostPage();
            return;
        } else
        {
            ThirdPartyActivityUtils.openGeneralMarketApp();
            return;
        }
    }

    private static void initUpgradeButtonGroup(Context context, ViewGroup viewgroup)
    {
        String s = AppLocale.getInstance().getCurrentLocaleName();
        if (s.equals("ja_JP") || s.equals("zh_CN") || s.equals("de_DE") || s.equals("fr_CA") || s.equals("es_ES"))
        {
            LayoutInflater.from(context).inflate(com.amazon.mShop.android.lib.R.layout.upgrade_notification_dialog_buttons_1, viewgroup);
            return;
        } else
        {
            LayoutInflater.from(context).inflate(com.amazon.mShop.android.lib.R.layout.upgrade_notification_dialog_buttons_2, viewgroup);
            return;
        }
    }

    private static boolean isFromGooglePlay(Context context)
    {
        return AttributionUtils.getTrimmedAssociateTag(context, AndroidPlatform.getInstance().getDataStore(), true).equals(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_google_play_prefix)) && ThirdPartyActivityUtils.checkGooglePackage();
    }

    public static boolean isNewUpgrade(UpgradeInfo upgradeinfo, boolean flag)
    {
        boolean flag2 = false;
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        boolean flag1 = flag2;
        if (upgradeinfo != null)
        {
            flag1 = flag2;
            if (upgradeinfo.getUniqueId() != null)
            {
                if (!flag)
                {
                    flag1 = true;
                } else
                if (upgradeinfo.getUniqueId() != null && upgradeinfo.getUniqueId().equals(datastore.getString("upgradeLastUniqueId")))
                {
                    flag1 = flag2;
                    if (checkTimeout(datastore.getLong("upgradeLastDialogTime"), 0x9a7ec800L))
                    {
                        return true;
                    }
                } else
                {
                    return true;
                }
            }
        }
        return flag1;
    }

    public static void saveNewUpgradeInfo(UpgradeInfo upgradeinfo)
    {
        DataStore datastore = AndroidPlatform.getInstance().getDataStore();
        datastore.putBoolean("upgradeShouldShowDialog", true);
        datastore.putString("upgradeLastUniqueId", upgradeinfo.getUniqueId());
    }

    public static boolean shouldCheckUpgrade()
    {
        return checkTimeout(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getLong("upgradeLastCheckTime"), 0x36ee80L);
    }

    public static void showForceUpdateDialog(Context context)
    {
        Object obj = new com.amazon.mShop.AmazonAlertDialog.Builder(context);
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setCancelable(true);
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            public void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
                AppUtils.exitApp();
            }

        });
        obj = ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).create();
        ((AmazonAlertDialog) (obj)).show();
        ((AmazonAlertDialog) (obj)).getWindow().setContentView(com.amazon.mShop.android.lib.R.layout.upgrade_dialog);
        ((TextView)((AmazonAlertDialog) (obj)).getWindow().findViewById(com.amazon.mShop.android.lib.R.id.upgrade_dialog_message)).setText(formatDialogMessage(context, com.amazon.mShop.android.lib.R.string.upgrade_dialog_message));
        ((Button)((AmazonAlertDialog) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.upgrade_now)).setOnClickListener(new android.view.View.OnClickListener(((AmazonAlertDialog) (obj))) {

            final AmazonAlertDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
                UpgradeUtil.goToUpgradePage();
                AppUtils.exitApp();
            }

            
            {
                dialog = amazonalertdialog;
                super();
            }
        });
    }

    public static void showUpgradeNotificationDialog(Context context)
    {
        DataStore datastore = AndroidPlatform.getInstance().getDataStore();
        Object obj = new com.amazon.mShop.AmazonAlertDialog.Builder(context);
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setCancelable(true);
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            public void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
            }

        });
        View view = LayoutInflater.from(context).inflate(com.amazon.mShop.android.lib.R.layout.upgrade_notification_dialog, null);
        initUpgradeButtonGroup(context, (ViewGroup)view.findViewById(com.amazon.mShop.android.lib.R.id.upgrade_dialog_button_container));
        obj = ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).create();
        ((AmazonAlertDialog) (obj)).show();
        ((AmazonAlertDialog) (obj)).getWindow().setContentView(view);
        ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.upgrade_notification_dialog_message)).setText(formatDialogMessage(context, com.amazon.mShop.android.lib.R.string.upgrade_notification_dialog_message));
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.upgrade_now)).setOnClickListener(new android.view.View.OnClickListener(((AmazonAlertDialog) (obj)), datastore) {

            final AmazonAlertDialog val$dialog;
            final DataStore val$store;

            public void onClick(View view1)
            {
                dialog.dismiss();
                RefMarkerObserver.logRefMarker("up_upgrade");
                store.putBoolean("upgradeShouldShowDialog", true);
                UpgradeUtil.goToUpgradePage();
            }

            
            {
                dialog = amazonalertdialog;
                store = datastore;
                super();
            }
        });
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.no_thanks)).setOnClickListener(new android.view.View.OnClickListener(((AmazonAlertDialog) (obj)), datastore) {

            final AmazonAlertDialog val$dialog;
            final DataStore val$store;

            public void onClick(View view1)
            {
                dialog.dismiss();
                RefMarkerObserver.logRefMarker("up_no_thanks");
                store.putBoolean("upgradeShouldShowDialog", false);
            }

            
            {
                dialog = amazonalertdialog;
                store = datastore;
                super();
            }
        });
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.remind_me_later)).setOnClickListener(new android.view.View.OnClickListener(((AmazonAlertDialog) (obj)), datastore) {

            final AmazonAlertDialog val$dialog;
            final DataStore val$store;

            public void onClick(View view1)
            {
                dialog.dismiss();
                RefMarkerObserver.logRefMarker("up_remind");
                store.putBoolean("upgradeShouldShowDialog", true);
            }

            
            {
                dialog = amazonalertdialog;
                store = datastore;
                super();
            }
        });
        datastore.putLong("upgradeLastDialogTime", System.currentTimeMillis());
    }
}
