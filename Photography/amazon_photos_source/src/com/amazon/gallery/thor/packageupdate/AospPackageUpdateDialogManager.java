// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.customer.CustomerMetricsInfo;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.thor.packageupdate:
//            ApplicationStore, PackageUpdateCheckReceiver, PackageUpdateService

public class AospPackageUpdateDialogManager
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent MandatoryUpdateLaunched;
        public static final MetricsEvent OptionalUpdateLaunched;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/packageupdate/AospPackageUpdateDialogManager$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            MandatoryUpdateLaunched = new MetricsEvent("MandatoryUpdateLaunched", 0);
            OptionalUpdateLaunched = new MetricsEvent("OptionalUpdateLaunched", 1);
            $VALUES = (new MetricsEvent[] {
                MandatoryUpdateLaunched, OptionalUpdateLaunched
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final long OPTIONAL_UPDATE_NAG_DELAY_MS;
    private static final String TAG = com/amazon/gallery/thor/packageupdate/AospPackageUpdateDialogManager.getName();
    private final ApplicationStore applicationStore;
    private final CustomerMetricsInfo customerMetricsInfo;
    private final ComponentProfiler profiler;

    public AospPackageUpdateDialogManager(String s)
    {
        customerMetricsInfo = (CustomerMetricsInfo)ThorGalleryApplication.getBean(Keys.CUSTOMER_METRICS_INFO);
        applicationStore = new ApplicationStore(s, customerMetricsInfo.getAppVersionName());
        profiler = new ComponentProfiler((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER), com/amazon/gallery/thor/packageupdate/AospPackageUpdateDialogManager);
    }

    private AlertDialog createMandatoryUpdateDialog(final Activity context)
    {
        return (new android.support.v7.app.AlertDialog.Builder(context)).setIcon(0x7f0201f2).setTitle(0x7f0e01c9).setMessage(0x7f0e01c7).setPositiveButton(0x7f0e01c8, new android.content.DialogInterface.OnClickListener() {

            final AospPackageUpdateDialogManager this$0;
            final Activity val$context;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                dialoginterface = applicationStore.getUpdateIntent(context);
                context.startActivity(dialoginterface);
                profiler.trackEvent(MetricsEvent.MandatoryUpdateLaunched);
            }

            
            {
                this$0 = AospPackageUpdateDialogManager.this;
                context = activity;
                super();
            }
        }).setCancelable(false).setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            final AospPackageUpdateDialogManager this$0;

            public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
            {
                return i == 84 && keyevent.getRepeatCount() == 0;
            }

            
            {
                this$0 = AospPackageUpdateDialogManager.this;
                super();
            }
        }).create();
    }

    private AlertDialog createOptionalUpdateDialog(final Activity context)
    {
        return (new android.support.v7.app.AlertDialog.Builder(context)).setIcon(0x7f0201e9).setTitle(0x7f0e01d2).setMessage(0x7f0e01cf).setPositiveButton(0x7f0e01d1, new android.content.DialogInterface.OnClickListener() {

            final AospPackageUpdateDialogManager this$0;
            final Activity val$context;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                dialoginterface = applicationStore.getUpdateIntent(context);
                context.startActivity(dialoginterface);
                profiler.trackEvent(MetricsEvent.MandatoryUpdateLaunched);
            }

            
            {
                this$0 = AospPackageUpdateDialogManager.this;
                context = activity;
                super();
            }
        }).setNegativeButton(0x7f0e01d0, new android.content.DialogInterface.OnClickListener() {

            final AospPackageUpdateDialogManager this$0;
            final Activity val$context;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("optionalUpdateDismissedDate", SystemClock.uptimeMillis()).apply();
            }

            
            {
                this$0 = AospPackageUpdateDialogManager.this;
                context = activity;
                super();
            }
        }).setCancelable(false).create();
    }

    private void scheduleUpdateConfigAlarm(Activity activity)
    {
        activity.sendBroadcast(new Intent(activity, com/amazon/gallery/thor/packageupdate/PackageUpdateCheckReceiver));
    }

    public void showUpdateDialogIfNeeded(final Activity context)
    {
        Object obj;
        Object obj1;
        scheduleUpdateConfigAlarm(context);
        obj = PreferenceManager.getDefaultSharedPreferences(context);
        obj1 = ((SharedPreferences) (obj)).getString("update_config_key", null);
        if (!StringUtils.isEmpty(((CharSequence) (obj1)))) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj2;
        try
        {
            obj2 = new JSONObject(((String) (obj1)));
            obj1 = ((JSONObject) (obj2)).getJSONArray("mandatory_update");
            obj2 = ((JSONObject) (obj2)).getJSONArray("optional_update_available");
            if (PackageUpdateService.versionNameMatch(((org.json.JSONArray) (obj1)), customerMetricsInfo.getAppVersionName()))
            {
                obj = new android.content.DialogInterface.OnDismissListener() {

                    final AospPackageUpdateDialogManager this$0;
                    final Activity val$context;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        context.finish();
                    }

            
            {
                this$0 = AospPackageUpdateDialogManager.this;
                context = activity;
                super();
            }
                };
                (new ShowDialogSyncTask(context) {

                    final AospPackageUpdateDialogManager this$0;

                    protected Dialog createDialog()
                    {
                        return createMandatoryUpdateDialog(mActivity);
                    }

            
            {
                this$0 = AospPackageUpdateDialogManager.this;
                super(activity);
            }
                }).useDismissListener(((android.content.DialogInterface.OnDismissListener) (obj))).queue();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Activity context)
        {
            GLogger.i(TAG, "Unable to read update config: %s", new Object[] {
                context
            });
            return;
        }
        if (!PackageUpdateService.versionNameMatch(((org.json.JSONArray) (obj2)), customerMetricsInfo.getAppVersionName())) goto _L1; else goto _L3
_L3:
        long l = ((SharedPreferences) (obj)).getLong("optionalUpdateDismissedDate", 0L);
        if (l == 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l >= SystemClock.uptimeMillis() + OPTIONAL_UPDATE_NAG_DELAY_MS) goto _L1; else goto _L4
_L4:
        (new ShowDialogSyncTask(context) {

            final AospPackageUpdateDialogManager this$0;

            protected Dialog createDialog()
            {
                return createOptionalUpdateDialog(mActivity);
            }

            
            {
                this$0 = AospPackageUpdateDialogManager.this;
                super(activity);
            }
        }).queue();
        return;
    }

    static 
    {
        OPTIONAL_UPDATE_NAG_DELAY_MS = TimeUnit.DAYS.convert(5L, TimeUnit.MILLISECONDS);
    }




}
