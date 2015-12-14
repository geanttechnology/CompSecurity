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

class this._cls0
    implements android.content.ener
{

    final ssActiveDialog this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1 && settingsIntent != null)
        {
            AboutMenu.launchSettingsPage(activity, settingsIntent);
        }
        activity.dismissActiveDialog();
    }

    <init>()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/kindle/AutoUploadNotification$1

/* anonymous class */
    static final class AutoUploadNotification._cls1 extends ShowDialogSyncTask
    {

        final FragmentActivity val$activity;
        final Class val$settingsIntent;

        protected Dialog createDialog()
        {
            Object obj = new android.support.v7.app.AlertDialog.Builder(activity);
            ComponentProfiler _tmp = AutoUploadNotification.access$002(new ComponentProfiler((Profiler)((BeanAwareActivity)activity).getApplicationBean(Keys.PROFILER), com/amazon/gallery/framework/kindle/AutoUploadNotification));
            ((android.support.v7.app.AlertDialog.Builder) (obj)).setTitle(0x7f0e013e);
            ((android.support.v7.app.AlertDialog.Builder) (obj)).setMessage(0x7f0e013d);
            AutoUploadNotification._cls1._cls1 _lcls1 = new AutoUploadNotification._cls1._cls1();
            ((android.support.v7.app.AlertDialog.Builder) (obj)).setNegativeButton(0x7f0e013f, _lcls1);
            ((android.support.v7.app.AlertDialog.Builder) (obj)).setPositiveButton(0x7f0e0140, _lcls1);
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
    }

}
