// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.authentication.AospPreferences;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            Keys, AutoUploadNotification

public class NewFeatureNotification
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent NewFeatureDialogDisplayed;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/NewFeatureNotification$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            NewFeatureDialogDisplayed = new MetricsEvent("NewFeatureDialogDisplayed", 0);
            $VALUES = (new MetricsEvent[] {
                NewFeatureDialogDisplayed
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static AlertDialog dialog;
    private static ComponentProfiler profiler;

    private static boolean checkToSeeIfUserHasUpgradedFromTruth(Context context)
    {
        return (new AospPreferences(context)).getUpgradedFromTruth();
    }

    public static boolean getShouldShowNotification(Context context)
    {
        return checkToSeeIfUserHasUpgradedFromTruth(context);
    }

    public static void hasSeenNewFeatureNotification(Context context)
    {
        (new AospPreferences(context)).removeUpgradeFromTruthKey();
    }

    private static boolean isAccountRegistered(Application application)
    {
        return ((AuthenticationManager)((BeanAwareApplication)application).getBeanFactory().getBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount();
    }

    public static void launchNewFeatureNotification(FragmentActivity fragmentactivity)
    {
        (new ShowDialogSyncTask(fragmentactivity, fragmentactivity) {

            final FragmentActivity val$activity;

            protected Dialog createDialog()
            {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(activity);
                NewFeatureNotification.profiler = new ComponentProfiler((Profiler)((BeanAwareActivity)activity).getApplicationBean(Keys.PROFILER), com/amazon/gallery/framework/kindle/AutoUploadNotification);
                View view = activity.getLayoutInflater().inflate(0x7f0300b1, null);
                builder.setView(view);
                NewFeatureNotification.dialog = builder.create();
                NewFeatureNotification.dialog.setCancelable(false);
                NewFeatureNotification.dialog.setCanceledOnTouchOutside(false);
                view.findViewById(0x7f0c018f).setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$0;

                    public void onClick(View view)
                    {
                        if (NewFeatureNotification.dialog.isShowing())
                        {
                            NewFeatureNotification.dialog.dismiss();
                            ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveDialog();
                        }
                    }

            
            {
                this$0 = _cls1.this;
                super();
            }
                });
                NewFeatureNotification.profiler.trackEvent(MetricsEvent.NewFeatureDialogDisplayed);
                return NewFeatureNotification.dialog;
            }

            
            {
                activity = fragmentactivity;
                super(activity1);
            }
        }).queue();
        hasSeenNewFeatureNotification(fragmentactivity.getApplicationContext());
    }

    public static void launchNewFeatureNotificationIfNeverSeen(FragmentActivity fragmentactivity)
    {
        if (!getShouldShowNotification(fragmentactivity.getApplicationContext()) || !isAccountRegistered(fragmentactivity.getApplication()) || !BuildFlavors.isAosp())
        {
            return;
        } else
        {
            launchNewFeatureNotification(fragmentactivity);
            return;
        }
    }



/*
    static ComponentProfiler access$002(ComponentProfiler componentprofiler)
    {
        profiler = componentprofiler;
        return componentprofiler;
    }

*/



/*
    static AlertDialog access$102(AlertDialog alertdialog)
    {
        dialog = alertdialog;
        return alertdialog;
    }

*/
}
