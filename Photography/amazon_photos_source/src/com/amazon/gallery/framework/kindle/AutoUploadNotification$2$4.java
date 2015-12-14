// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.fragment.SettingsFragment;
import com.amazon.gallery.framework.network.watchdog.AutoSaveManager;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoUploadNotification

class val.view
    implements com.amazon.gallery.foundation.metrics.amazoninsights.adedListener
{

    final _cls1.val.text this$0;
    final View val$view;

    public void onTextLoaded(final String text)
    {
        activity.runOnUiThread(new Runnable() {

            final AutoUploadNotification._cls2._cls4 this$1;
            final String val$text;

            public void run()
            {
                TextView textview = (TextView)view.findViewById(0x7f0c009c);
                textview.setText(text);
                textview.setVisibility(0);
            }

            
            {
                this$1 = AutoUploadNotification._cls2._cls4.this;
                text = s;
                super();
            }
        });
    }

    <init>()
    {
        this$0 = final_<init>1;
        val$view = View.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/kindle/AutoUploadNotification$2

/* anonymous class */
    static final class AutoUploadNotification._cls2 extends ShowDialogSyncTask
    {

        final FragmentActivity val$activity;
        final AutoSaveManager val$autoSaveManager;
        final AmazonInsightsHelper val$helper;

        protected Dialog createDialog()
        {
            AlertDialog alertdialog = (new android.support.v7.app.AlertDialog.Builder(activity)).setTitle(activity.getString(0x7f0e0137)).setMessage(activity.getString(0x7f0e0135)).setNegativeButton(activity.getString(0x7f0e0136), new AutoUploadNotification._cls2._cls3()).setPositiveButton(activity.getString(0x7f0e0093), new AutoUploadNotification._cls2._cls2()).setOnDismissListener(new AutoUploadNotification._cls2._cls1()).create();
            alertdialog.setCancelable(false);
            alertdialog.setCanceledOnTouchOutside(false);
            AutoUploadNotification.access$000().trackEvent(AutoUploadNotification.MetricsEvent.AutoSaveDialogDisplayed);
            helper.recordEvent(AutoUploadNotification.MetricsEvent.AutoSaveDialogDisplayed);
            if (!BuildFlavors.isAosp())
            {
                View view1 = LayoutInflater.from(activity).inflate(0x7f030023, null, false);
                alertdialog.setView(view1);
                helper.loadABText(activity, "Unlimited Cloud Storage", "ShowText", "UnlimitedPhotoText", view1. new AutoUploadNotification._cls2._cls4());
            }
            AutoUploadNotification.access$200().set(true);
            return alertdialog;
        }

            
            {
                activity = fragmentactivity;
                autoSaveManager = autosavemanager;
                helper = amazoninsightshelper;
                super(activity1);
            }

        // Unreferenced inner class com/amazon/gallery/framework/kindle/AutoUploadNotification$2$1

/* anonymous class */
        class AutoUploadNotification._cls2._cls1
            implements android.content.DialogInterface.OnDismissListener
        {

            final AutoUploadNotification._cls2 this$0;

            public void onDismiss(DialogInterface dialoginterface)
            {
                AutoUploadNotification.access$200().set(false);
            }

                    
                    {
                        this$0 = AutoUploadNotification._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/gallery/framework/kindle/AutoUploadNotification$2$2

/* anonymous class */
        class AutoUploadNotification._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final AutoUploadNotification._cls2 this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AutoUploadNotification.access$000().trackEvent(AutoUploadNotification.MetricsEvent.AutoSaveDialogAccepted);
                SettingsFragment.setAutoUploadEnabled(activity, true, com.amazon.gallery.framework.kindle.fragment.SettingsFragment.AutoSaveSource.Dialog);
                autoSaveManager.showNewDialogForCurrentTags();
            }

                    
                    {
                        this$0 = AutoUploadNotification._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/gallery/framework/kindle/AutoUploadNotification$2$3

/* anonymous class */
        class AutoUploadNotification._cls2._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final AutoUploadNotification._cls2 this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                SettingsFragment.setAutoUploadEnabled(activity, false, com.amazon.gallery.framework.kindle.fragment.SettingsFragment.AutoSaveSource.Dialog);
            }

                    
                    {
                        this$0 = AutoUploadNotification._cls2.this;
                        super();
                    }
        }

    }

}
