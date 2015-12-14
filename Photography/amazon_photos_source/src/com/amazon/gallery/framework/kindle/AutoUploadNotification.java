// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.fragment.SettingsFragment;
import com.amazon.gallery.framework.kindle.ui.AboutMenu;
import com.amazon.gallery.framework.network.watchdog.AutoSaveManager;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            Keys

public class AutoUploadNotification
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AutoSaveDialogAccepted;
        public static final MetricsEvent AutoSaveDialogDisplayed;
        public static final MetricsEvent AutoSaveDialogNotAccepted;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/AutoUploadNotification$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            AutoSaveDialogDisplayed = new MetricsEvent("AutoSaveDialogDisplayed", 0);
            AutoSaveDialogAccepted = new MetricsEvent("AutoSaveDialogAccepted", 1);
            AutoSaveDialogNotAccepted = new MetricsEvent("AutoSaveDialogNotAccepted", 2);
            $VALUES = (new MetricsEvent[] {
                AutoSaveDialogDisplayed, AutoSaveDialogAccepted, AutoSaveDialogNotAccepted
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static AtomicBoolean dialogShowing = new AtomicBoolean(false);
    private static ComponentProfiler profiler;

    public AutoUploadNotification()
    {
    }

    public static boolean getShouldNotShowNotification(Context context)
    {
        return context.getSharedPreferences("galleryKindleSharedPrefs", 0).getBoolean("auto_upload_notification_key", false);
    }

    private static boolean isAccountRegistered(Application application)
    {
        return ((AuthenticationManager)((BeanAwareApplication)application).getBeanFactory().getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount();
    }

    public static boolean isDialogShowing()
    {
        return dialogShowing.get();
    }

    public static void launchAutoUploadNotification(FragmentActivity fragmentactivity)
    {
        profiler = new ComponentProfiler((Profiler)((BeanAwareActivity)fragmentactivity).getApplicationBean(Keys.PROFILER), com/amazon/gallery/framework/kindle/AutoUploadNotification);
        AmazonInsightsHelper amazoninsightshelper = (AmazonInsightsHelper)((BeanAwareActivity)fragmentactivity).getApplicationBean(Keys.AMAZON_INSIGHTS_HELPER);
        (new ShowDialogSyncTask(fragmentactivity, fragmentactivity, (AutoSaveManager)((BeanAwareActivity)fragmentactivity).getApplicationBean(Keys.AUTO_SAVE_MANAGER), amazoninsightshelper) {

            final FragmentActivity val$activity;
            final AutoSaveManager val$autoSaveManager;
            final AmazonInsightsHelper val$helper;

            protected Dialog createDialog()
            {
                AlertDialog alertdialog = (new android.support.v7.app.AlertDialog.Builder(activity)).setTitle(activity.getString(0x7f0e0137)).setMessage(activity.getString(0x7f0e0135)).setNegativeButton(activity.getString(0x7f0e0136), new android.content.DialogInterface.OnClickListener() {

                    final _cls2 this$0;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        SettingsFragment.setAutoUploadEnabled(activity, false, com.amazon.gallery.framework.kindle.fragment.SettingsFragment.AutoSaveSource.Dialog);
                    }

            
            {
                this$0 = _cls2.this;
                super();
            }
                }).setPositiveButton(activity.getString(0x7f0e0093), new android.content.DialogInterface.OnClickListener() {

                    final _cls2 this$0;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        AutoUploadNotification.profiler.trackEvent(MetricsEvent.AutoSaveDialogAccepted);
                        SettingsFragment.setAutoUploadEnabled(activity, true, com.amazon.gallery.framework.kindle.fragment.SettingsFragment.AutoSaveSource.Dialog);
                        autoSaveManager.showNewDialogForCurrentTags();
                    }

            
            {
                this$0 = _cls2.this;
                super();
            }
                }).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                    final _cls2 this$0;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        AutoUploadNotification.dialogShowing.set(false);
                    }

            
            {
                this$0 = _cls2.this;
                super();
            }
                }).create();
                alertdialog.setCancelable(false);
                alertdialog.setCanceledOnTouchOutside(false);
                AutoUploadNotification.profiler.trackEvent(MetricsEvent.AutoSaveDialogDisplayed);
                helper.recordEvent(MetricsEvent.AutoSaveDialogDisplayed);
                if (!BuildFlavors.isAosp())
                {
                    View view = LayoutInflater.from(activity).inflate(0x7f030023, null, false);
                    alertdialog.setView(view);
                    helper.loadABText(activity, "Unlimited Cloud Storage", "ShowText", "UnlimitedPhotoText", view. new com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.TextLoadedListener() {

                        final _cls2 this$0;
                        final View val$view;

                        public void onTextLoaded(String s)
                        {
                            activity.runOnUiThread(s. new Runnable() {

                                final _cls4 this$1;
                                final String val$text;

                                public void run()
                                {
                                    TextView textview = (TextView)view.findViewById(0x7f0c009c);
                                    textview.setText(text);
                                    textview.setVisibility(0);
                                }

            
            {
                this$1 = final__pcls4;
                text = String.this;
                super();
            }
                            });
                        }

            
            {
                this$0 = final__pcls2;
                view = View.this;
                super();
            }
                    });
                }
                AutoUploadNotification.dialogShowing.set(true);
                return alertdialog;
            }

            
            {
                activity = fragmentactivity;
                autoSaveManager = autosavemanager;
                helper = amazoninsightshelper;
                super(activity1);
            }
        }).queue();
        shouldNotShowNotification(fragmentactivity, true);
    }

    public static boolean launchAutoUploadNotificationIfNeverSeen(FragmentActivity fragmentactivity)
    {
        if (getShouldNotShowNotification(fragmentactivity) || !isAccountRegistered(fragmentactivity.getApplication()))
        {
            return true;
        } else
        {
            launchAutoUploadNotification(fragmentactivity);
            return false;
        }
    }

    public static boolean launchAutoUploadNotificationIfNeverSeen(FragmentActivity fragmentactivity, Class class1)
    {
        boolean flag1 = true;
        long l = 0L;
        boolean flag;
        if (BuildFlavors.isAosp())
        {
            flag = launchAutoUploadNotificationIfNeverSeen(fragmentactivity);
        } else
        {
            flag = flag1;
            if (!launchAutoUploadNotificationIfUpgrade(fragmentactivity, class1))
            {
                long l1 = fragmentactivity.getSharedPreferences("galleryKindleSharedPrefs", 0).getLong("deregistrationTimestamp", 0L);
                long l2 = fragmentactivity.getSharedPreferences("galleryKindleSharedPrefs", 0).getLong("new_content_timestamp_key", 0L);
                if (l2 != 0L)
                {
                    l = (new Date(l2)).getTime();
                }
                flag = flag1;
                if (l > l1)
                {
                    return launchAutoUploadNotificationIfNeverSeen(fragmentactivity);
                }
            }
        }
        return flag;
    }

    public static boolean launchAutoUploadNotificationIfUpgrade(FragmentActivity fragmentactivity, Class class1)
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(fragmentactivity);
        if (!sharedpreferences.getBoolean("auto_upload_update_key", false))
        {
            return false;
        } else
        {
            shouldNotShowNotification(fragmentactivity, true);
            launchAutoUploadNotificationUpgrade(fragmentactivity, class1);
            sharedpreferences.edit().putBoolean("auto_upload_update_key", false).apply();
            return true;
        }
    }

    public static void launchAutoUploadNotificationUpgrade(FragmentActivity fragmentactivity, Class class1)
    {
        (new ShowDialogSyncTask(fragmentactivity, fragmentactivity, class1) {

            final FragmentActivity val$activity;
            final Class val$settingsIntent;

            protected Dialog createDialog()
            {
                Object obj = new android.support.v7.app.AlertDialog.Builder(activity);
                AutoUploadNotification.profiler = new ComponentProfiler((Profiler)((BeanAwareActivity)activity).getApplicationBean(Keys.PROFILER), com/amazon/gallery/framework/kindle/AutoUploadNotification);
                ((android.support.v7.app.AlertDialog.Builder) (obj)).setTitle(0x7f0e013e);
                ((android.support.v7.app.AlertDialog.Builder) (obj)).setMessage(0x7f0e013d);
                android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$0;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        if (i == -1 && settingsIntent != null)
                        {
                            AboutMenu.launchSettingsPage(activity, settingsIntent);
                        }
                        activity.dismissActiveDialog();
                    }

            
            {
                this$0 = _cls1.this;
                super();
            }
                };
                ((android.support.v7.app.AlertDialog.Builder) (obj)).setNegativeButton(0x7f0e013f, onclicklistener);
                ((android.support.v7.app.AlertDialog.Builder) (obj)).setPositiveButton(0x7f0e0140, onclicklistener);
                obj = ((android.support.v7.app.AlertDialog.Builder) (obj)).create();
                ((AlertDialog) (obj)).setCancelable(false);
                ((AlertDialog) (obj)).setCanceledOnTouchOutside(false);
                return ((Dialog) (obj));
            }


            
            {
                activity = fragmentactivity;
                settingsIntent = class1;
                super(activity1);
            }
        }).queue();
    }

    public static void shouldNotShowNotification(Context context, boolean flag)
    {
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putBoolean("auto_upload_notification_key", flag).apply();
    }




/*
    static ComponentProfiler access$002(ComponentProfiler componentprofiler)
    {
        profiler = componentprofiler;
        return componentprofiler;
    }

*/

}
