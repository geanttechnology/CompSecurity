// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.ui.AboutMenu;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoUploadNotification, Keys

static final class k extends ShowDialogSyncTask
{

    final FragmentActivity val$activity;
    final Class val$settingsIntent;

    protected Dialog createDialog()
    {
        Object obj = new android.support.v7.app.>(val$activity);
        ComponentProfiler _tmp = AutoUploadNotification.access$002(new ComponentProfiler((Profiler)((BeanAwareActivity)val$activity).getApplicationBean(Keys.PROFILER), com/amazon/gallery/framework/kindle/AutoUploadNotification));
        ((android.support.v7.app.R) (obj)).tle(0x7f0e013e);
        ((android.support.v7.app.tle) (obj)).ssage(0x7f0e013d);
        android.content.stener stener = new android.content.DialogInterface.OnClickListener() {

            final AutoUploadNotification._cls1 this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -1 && settingsIntent != null)
                {
                    AboutMenu.launchSettingsPage(activity, settingsIntent);
                }
                activity.dismissActiveDialog();
            }

            
            {
                this$0 = AutoUploadNotification._cls1.this;
                super();
            }
        };
        ((android.support.v7.app.tification._cls1) (obj)).gativeButton(0x7f0e013f, stener);
        ((android.support.v7.app.gativeButton) (obj)).sitiveButton(0x7f0e0140, stener);
        obj = ((android.support.v7.app.sitiveButton) (obj)).e();
        ((AlertDialog) (obj)).setCancelable(false);
        ((AlertDialog) (obj)).setCanceledOnTouchOutside(false);
        return ((Dialog) (obj));
    }


    _cls1.this._cls0(Activity activity1, FragmentActivity fragmentactivity, Class class1)
    {
        val$activity = fragmentactivity;
        val$settingsIntent = class1;
        super(activity1);
    }
}
